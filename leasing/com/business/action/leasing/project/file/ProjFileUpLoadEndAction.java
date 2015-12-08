package com.business.action.leasing.project.file;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.entity.proj.reckon.ProjCashDetail;
import com.business.entity.proj.reckon.ProjFundFundPlan;
import com.business.entity.proj.reckon.ProjFundRentPlan;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;
/**
 * 
 * @author 蔡雅超
 * @date 2013-8-21
 * @info项目资料补齐的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "projFileUpLoadEndAction", description = "流程结束动作", workflowName = "项目资料补齐")
@Component(value = "projFileUpLoadEndAction")
public class ProjFileUpLoadEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.baseService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.baseService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */
		
		String proj_id = variablesMap.get("proj_info.projid");
		Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("projId", proj_id);
		ProjInfo projInfo = (ProjInfo)this.baseService.updateMainEntity(ProjInfo.class, queryMainObjectMap, variablesMap,null, "proj_info");
		//数据字典通过name属性匹配
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		dictDataClassMapping.put("CustInfo", "id");
		// 租赁物明细
		String jsonEquipsString = variablesMap.get("json_proj_equip_str");//proj_info.projEquips
		this.baseService.updateOneToManyCollections(projInfo, "projEquips", ProjEquip.class, "projId", jsonEquipsString,dictDataClassMapping);
		// 租金发票类型
		this.baseService.updateOneToOneEntity(projInfo, "projInvoiceType", "projId", variablesMap,null, "proj_invoice_type");
		
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		 
	}
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
