package com.business.action.leasing.project_nocar.approval_nocar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.proj.ProjGuaranteeEquip;
import com.business.entity.proj.ProjGuaranteeMethod;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.entity.proj.reckon.ProjCashDetail;
import com.business.entity.proj.reckon.ProjFundFundPlan;
import com.business.entity.proj.reckon.ProjFundRentPlan;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.DateUtil;

/**
 * 
 * @author rovine
 * @date 2014-8-18
 * @info项目立项的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "projApprovalNocarEndAction", description = "流程结束动作", workflowName = "项目立项非车业务")
@Component(value = "projApprovalNocarEndAction")
public class ProjApprovalNocarEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		 
	}
	
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//String proj_id = variablesMap.get("proj_id");// 先获得proj_id
		//删除流程冲突 
		 
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String proj_id = variablesMap.get("proj_info.projid");
		Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("projId", proj_id);
		
		//数据字典通过name属性匹配
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		dictDataClassMapping.put("CustInfo", "id");
		
        // 立项基本表
		ProjInfo projInfo = (ProjInfo)this.baseService.updateMainEntity(ProjInfo.class, queryMainObjectMap, variablesMap,dictDataClassMapping, "proj_info");
		//立项结束时间
		projInfo.setEndDate(DateUtil.getSystemDateTime());
		//设置流程状态为流程完毕
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		//设置项目为立项完成状态
		projInfo.setProjStatus(AppStaticUtil.PROJ_APPROVAL);
		this.baseService.saveOrUpdateEntity(projInfo);
		
		// 租赁物明细
		String jsonEquipsString = variablesMap.get("json_proj_equip_str");//proj_info.projEquips
		this.baseService.updateOneToManyCollections(projInfo, "projEquips", ProjEquip.class, "projId", jsonEquipsString,dictDataClassMapping);
		// 担保单位
		String jsonProjGuaranteeMethodString = variablesMap.get("json_proj_guarantee_detail_str");
		this.baseService.updateOneToManyCollections(projInfo, "projGuaranteeMethods", ProjGuaranteeMethod.class, "projId", jsonProjGuaranteeMethodString,dictDataClassMapping);
		// 抵押人信息
		String jsonGuarString = variablesMap.get("json_proj_guaranty_detail_str");//proj_info.projEquips
		this.baseService.updateOneToManyCollections(projInfo, "projGuaranteeEquips", ProjGuaranteeEquip.class, "projId", jsonGuarString,dictDataClassMapping);
		
		// 2.1商务条件  此处的商务条件统一用framework_condition 为了通用性 租金测算页面的域名都用framework_condition开头而不是表名
		this.baseService.updateOneToOneEntity(projInfo, "projCondition", "projId", variablesMap,null, "framework_condition");
		// 2.2租金计划  
		String json_fund_rent_plan_str = variablesMap.get("json_fund_rent_plan_str");
		this.baseService.updateOneToManyCollections(projInfo, "projFundRentPlans", ProjFundRentPlan.class, "projId", json_fund_rent_plan_str,null);
		// 2.3现金流  
		String json_fund_cash_flow_str = variablesMap.get("json_fund_cash_flow_str");
		this.baseService.updateOneToManyCollections(projInfo, "projCashDetails", ProjCashDetail.class, "projId", json_fund_cash_flow_str,null);
		// 2.4资金收付计划 
		String json_fund_fund_charge_str = variablesMap.get("json_fund_fund_charge_str");
		dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		this.baseService.updateOneToManyCollections(projInfo, "projFundFundPlans", ProjFundFundPlan.class, "projId", json_fund_fund_charge_str,dictDataClassMapping);

	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
	}
}
