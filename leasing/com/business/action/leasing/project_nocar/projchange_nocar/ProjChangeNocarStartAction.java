package com.business.action.leasing.project_nocar.projchange_nocar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjGuaranteeEquip;
import com.business.entity.proj.ProjGuaranteeMethod;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.util.WorkflowUtil;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;

/**
 * 
 * @author rovine
 * @date 2014-8-18
 * @info项目变更的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "projChangeNocarStartAction", description = "流程开始动作", workflowName = "项目变更非车业务")
@Component(value = "projChangeNocarStartAction")
public class ProjChangeNocarStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String proj_id = variablesMap.get("proj_id");
		/**
		 * 流程冲突共三步
		 * 1、起始位置添加第一步，如**startAction
		 * 2、删除流程实例时添加第二部 ,**startAction中delete方法
		 * 3、结束流程里添加第三步, 例**endAction中添加
		 * 注意：例如经销资金收款中，第一步插入冲突表时，需要插入多个，不需要第二步，第三步也需要删除多个
		 * 		workFlowFlag插入时已逗号分隔。
		 * 
		 * 流程冲突第一步-开始*/
		String workFlowName = jbpmWorkflowHistoryInfo.getWorkflowName(); 
		
		//查询冲突 
		String hql = "SELECT new Map(WF.workNumber as workNumber, WF.workFlowName as workFlowName,WF.workFlowInstance AS workFlowInstance, WF.beginUser AS beginUser) FROM  WorkFlowFlag AS WF , ExclusionInfo AS EI  WHERE WF.workFlowName = EI.workFlowNameB AND EI.workFlowNameA = '"+workFlowName+"' AND WF.workNumber = '"+ proj_id +"'";
		List<Map<String,String>> workFlowFlagList =  this.tableService.findResultsByHSQL(hql);
		if (workFlowFlagList.size() > 0){
			Map<String, String> workFlowInfoMap = workFlowFlagList.get(0);
			User beginUser = this.tableService.findEntityByID(User.class, workFlowInfoMap.get("beginUser"));
			String workFlowNameB = workFlowInfoMap.get("workFlowName");
			throw new BusinessException("该条流程与【"+workFlowNameB+"】流程不能同时发起,请与流程发起人:【"+beginUser.getRealname()+"】联系查看详情");
		}
		
		//将本条流程记录插入到冲突表
		WorkFlowFlag workFlowFlag = new WorkFlowFlag();
		workFlowFlag.setBeginUser(SecurityUtil.getPrincipal().getId());
		workFlowFlag.setStatus(1);
		workFlowFlag.setWorkFlowInstance(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"");
		workFlowFlag.setWorkFlowName(workFlowName);
		workFlowFlag.setWorkNumber(proj_id);
		this.tableService.saveEntity(workFlowFlag);

		variablesMap.put("workFlowFlag", workFlowFlag.getId());
		/** 流程冲突第一步-结束*/
		
		ProjInfo projInfo = this.tableService.findEntityByID(ProjInfo.class, proj_id);
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_ON);// 更新状态为流程进行中
		this.baseService.saveOrUpdateEntity(projInfo);
		
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo,null, "proj_info"));
		variablesMap.put("rawValue_proj_info.projdept", projInfo.getProjDept().getName());
		variablesMap.put("rawValue_proj_info.projregistrar", projInfo.getProjRegistrar()==null?"":projInfo.getProjRegistrar().getRealname());
		variablesMap.put("rawValue_proj_info.projmanage", projInfo.getProjManage()==null?"":projInfo.getProjManage().getRealname());
		variablesMap.put("rawValue_proj_info.projassist", projInfo.getProjAssist()==null?"":projInfo.getProjAssist().getRealname());
		
		CustInfo cinfo=projInfo.getCustId();
		if(cinfo!=null){
			variablesMap.put("proj_info.custname",cinfo.getCustName());
			variablesMap.put("proj_info.custid",cinfo.getId());
			variablesMap.put("proj_info.custInfo",cinfo.getId());
			variablesMap.put("proj_info.custnumber",cinfo.getCustNumber());
			variablesMap.put("proj_info.custclass",cinfo.getCustClass().getId());
		}
		//项目查询参数
		Map<String,String> queryMainObjectMap = new HashMap<String,String>();
		queryMainObjectMap.put("proj_id", proj_id);
		
		if(!projInfo.getProjEquips().isEmpty()) {// 租赁物明细
			variablesMap.put("json_proj_equip_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_equip.xml", queryMainObjectMap).toString());
		}
		if (!projInfo.getProjGuaranteeMethods().isEmpty()) {// 担保单位
			variablesMap.put("json_proj_guarantee_detail_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_guarantee_method.xml", queryMainObjectMap).toString());
		}
		if (!projInfo.getProjGuaranteeEquips().isEmpty()) {// 抵押物清单
			variablesMap.put("json_proj_guaranty_detail_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_guarantee_equip.xml", queryMainObjectMap).toString());
		} 
		
		// 为了租金测算的通用性此处的名字不用contract_codition 而用framework_condition
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo.getProjCondition(), null, "framework_condition"));
		// 设置租金测算参数为合同审批
		variablesMap.put("framework_condition.projid", projInfo.getProjId());
		variablesMap.put("framework_condition.contractid", "");
		variablesMap.put("framework_condition.process", "proj_process");
		variablesMap.put("framework_condition.custname", cinfo.getCustName());
		variablesMap.put("framework_condition.custid", cinfo.getId());
		variablesMap.put("framework_condition.docid", jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid() + "");
		variablesMap.put("framework_condition.onhireid", "");
		// 因为这里是按照XML配置查询 所以在合同审批发起的时候数据是从项目表来的 所以这里的xml配置的是项目的XML
		if (!projInfo.getProjFundRentPlans().isEmpty()) {// 租金计划
			variablesMap.put("json_fund_rent_plan_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_fund_rent_plan.xml", queryMainObjectMap).toString());
		}
		if (!projInfo.getProjCashDetails().isEmpty()) {// 合同现金流
			variablesMap.put("json_fund_cash_flow_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_fund_cash_flow.xml", queryMainObjectMap).toString());
		}
		if (!projInfo.getProjFundFundPlans().isEmpty()) {//项目资金计划
			variablesMap.put("json_fund_fund_charge_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_fund_fund_plan.xml", queryMainObjectMap).toString());
		}
	}
	
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String proj_id = variablesMap.get("proj_id");// 先获得proj_id
		//删除流程冲突 
		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.baseService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.baseService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
	}
}
