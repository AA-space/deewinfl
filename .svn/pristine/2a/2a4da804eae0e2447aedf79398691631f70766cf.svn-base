package com.business.action.leasing.contract_nocar.contractcharge_nocar;



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
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.business.service.contractnocar.ContractComm;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.SecurityUtil;
/**
 * 
 * @date 2014-8-18
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "contractChargeNocarStartAction", description = "流程开始动作", workflowName = "合同变更流程非车业务")
@Component(value = "contractChargeNocarStartAction")
public class ContractChargeNocarStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	
	@Resource(name = "contractComm")
	private ContractComm ContractComm;
	
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String contract_id = variablesMap.get("contract_id");//获取传过来的  ContractInfo  对象主键id
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
		String hql = "SELECT new Map(WF.workNumber as workNumber, WF.workFlowName as workFlowName,WF.workFlowInstance AS workFlowInstance, WF.beginUser AS beginUser) FROM  WorkFlowFlag AS WF , ExclusionInfo AS EI  WHERE WF.workFlowName = EI.workFlowNameB AND EI.workFlowNameA = '"+workFlowName+"' AND WF.workNumber = '"+ contract_id +"'";
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
		workFlowFlag.setWorkNumber(contract_id);
		this.tableService.saveEntity(workFlowFlag);

		variablesMap.put("workFlowFlag", workFlowFlag.getId());
		/** 流程冲突第一步-结束*/
		
		ContractInfo contractInfo = this.tableService.findEntityByID(ContractInfo.class, contract_id);
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractInfo, null, "contract_info"));
		//合同基本信息
		//步骤二(获取项目基本信息)
		variablesMap.put("rawValue_contract_info.projdept", contractInfo.getProjDept().getName());
		variablesMap.put("rawValue_contract_info.projregistrar", contractInfo.getProjRegistrar()==null?"":contractInfo.getProjRegistrar().getRealname());
		variablesMap.put("rawValue_contract_info.projmanage", contractInfo.getProjManage()==null?"":contractInfo.getProjManage().getRealname());
		variablesMap.put("rawValue_contract_info.projassist", contractInfo.getProjAssist()==null?"":contractInfo.getProjAssist().getRealname());
	
		
		variablesMap.put("contract_info.id", "");
		variablesMap.put("project_info.projId", contractInfo.getProjId().getProjId());
		variablesMap.put("project_info.id", contractInfo.getId());
		variablesMap.put("contract_info.contractstatus", contractInfo.getContractStatus().toString());
		variablesMap.put("contract_info.projId", contractInfo.getProjId().getId());
		variablesMap.put("contract_info.proj_id", contractInfo.getProjId().getProjId());
		variablesMap.put("contract_info.contractid",contractInfo.getContractId());
		
		CustInfo cinfo=contractInfo.getCustId();
		if(cinfo!=null){
			variablesMap.put("contract_info.custname",cinfo.getCustName());
			variablesMap.put("contract_info.custid",cinfo.getId());
			variablesMap.put("contract_info.custInfo",cinfo.getId());
			variablesMap.put("contract_info.custnumber",cinfo.getCustNumber());
			variablesMap.put("contract_info.custclass",cinfo.getCustClass().getId());
		}
		
		//合同状态
		contractInfo.setContractStatus(21);
		//流程状态为流程中
		//contractInfo.setWorkFlag(AppStaticUtil.WORKFLOW_ON);
		this.tableService.updateEntity(contractInfo);//修改在合同撤销流程中状态
		
		Map<String,String> queryMainObjectMap = new HashMap<String,String>();
		queryMainObjectMap.put("contract_id",contract_id);
		
		//保存资金计划到页面
		if (!contractInfo.getFundFundChargePlans().isEmpty()) {// 资金计划
			variablesMap.put("json_fund_fund_charge_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/fund_fund_charge_plan.xml", queryMainObjectMap).toString());
			//保存原来的资金计划
			variablesMap.put("json_fund_fund_charge_str_old",variablesMap.get("json_fund_fund_charge_str"));
		}
		// 获取实收资金信息
		Map<String, Object> propertiesMapc = new HashMap<String, Object>();
		propertiesMapc.put("contractId", contractInfo);
		List<ContractFundFundCharge> ccharge = this.tableService.findEntityByProperties(ContractFundFundCharge.class, propertiesMapc);
		
		// 流程互斥表:判断是否在客户资金收款或资金收款流程中,在则不能删除
		Map<String, Object> MapWork = new HashMap<String, Object>();
		MapWork.put("workNumber", contractInfo.getId());
		List<WorkFlowFlag> wflags = this.tableService.findEntityByProperties(WorkFlowFlag.class, MapWork);
		for (WorkFlowFlag wflag : wflags) {
			if ("收款流程".equals(wflag.getWorkFlowName()) || "经销商资金收款".equals(wflag.getWorkFlowName())) {
				throw new BusinessException("与" + wflag.getWorkFlowName() + "冲突,不能发起合同变更!");
			}
		}
		
		//合同变更，前需判断是否有资金收款
		for (int i = 0; i < ccharge.size(); i++) {
			ContractFundFundCharge cc = ccharge.get(i);
			// 如果是红冲金额,则处理资金计划信息,有其他收款则走红冲 PayFund9--资金类型为红冲
			if ("PayFund9".equalsIgnoreCase(cc.getSettleMethod().getCode())) {
				// 3.将资金计划作废
//						ContractFundFundPlan cplan = cc.getFundFundChargePlan();
//						cplan.setInvalid("1");
//						cplan.setPaymentId(null);
//						this.tableService.updateEntity(cplan);
			} else {
				throw new BusinessException("已经资金收款,不能做合同变更,如需合同变更,请走资金收款做红冲!");
			}
		}
				
		// 获得一个流水号
		String doc_id = jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid() + "";
		queryMainObjectMap.put("doc_id", doc_id);

		// 步骤四
		// 为了租金测算的通用性此处的名字不用contract_codition 而用framework_condition
		if(contractInfo.getContractCondition() != null){
			variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractInfo.getContractCondition(), null, "framework_condition"));
		}
		
		if (!contractInfo.getContractFundRentPlanBefores().isEmpty()) {// 租金计划
			variablesMap.put("json_fund_rent_plan_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_fund_rent_plan_before.xml", queryMainObjectMap).toString());
			//保存合同变更前租金计划，为生成凭证传参数
			variablesMap.put("json_fund_rent_plan_str_forvoucher", variablesMap.get("json_fund_rent_plan_str"));
		}
		if (!contractInfo.getContractCashDetails().isEmpty()) {// 合同现金流
			variablesMap.put("json_fund_cash_flow_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_fund_cash_flow.xml", queryMainObjectMap).toString());
		}
		// 设置租金测算参数为合同审批
		variablesMap.put("framework_condition.contractid", contractInfo.getContractId());
		variablesMap.put("framework_condition.process", "cont_process");
		variablesMap.put("framework_condition.custname", cinfo.getCustName());
		variablesMap.put("framework_condition.custid", cinfo.getCustNumber());
		variablesMap.put("framework_condition.docid", doc_id);
		variablesMap.put("framework_condition.onhireid", "");
		variablesMap.put("framework_condition.projid", "");
		queryMainObjectMap.remove("doc_id");
		// 因为这里是按照XML配置查询 所以在合同审批发起的时候数据是从项目表来的 所以这里的xml配置的是项目的XML
		
		if (!contractInfo.getContractEquips().isEmpty()) {// 租赁物明细
			variablesMap.put("json_contract_equip_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_equip.xml", queryMainObjectMap).toString());
		}
		if (!contractInfo.getContractGuaranteeMethods().isEmpty()) {// 担保单位
			variablesMap.put("json_contract_guarantee_detail_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_guarantee_method.xml", queryMainObjectMap).toString());
		}
		
		if (!contractInfo.getContractGuaranteeEquips().isEmpty()) {// 抵押物清单
			variablesMap.put("json_contract_guaranty_detail_str", this.tableService.getJsonArrayData("eleasing/workflow/contract_nocar/contract_approval/contract_guarantee_equip.xml", queryMainObjectMap).toString());
		}
		
		if (!contractInfo.getContractSupplierInfos().isEmpty()) {// 供应商
			variablesMap.put("json_contract_supplier_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_supplier_info.xml", queryMainObjectMap).toString());
		}
		
		if (!contractInfo.getContractPremiseConditions().isEmpty()) {//前提条件
			variablesMap.put("json_contract_premise_str_put", this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_premise_condition.xml", queryMainObjectMap).toString());
		}
		// 步骤六
		//合同各方信息
		if(contractInfo.getContractSignatory()!=null){
	 	  variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractInfo.getContractSignatory(),null, "contract_signatory"));
		}
		 
		
	}
	
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String contract_id = variablesMap.get("contract_id");//获取传过来的  ContractInfo  对象主键id
		ContractInfo contractInfo = this.tableService.findEntityByID(ContractInfo.class, contract_id);
		contractInfo.setWorkFlag(0);//取消在流程中状态
		this.tableService.updateEntity(contractInfo);
		
		/** 流程冲突第二步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第二步-结束 */
		
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
