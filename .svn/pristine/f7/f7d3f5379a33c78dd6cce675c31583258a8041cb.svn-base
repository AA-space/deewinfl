package com.business.action.leasing.rentPlan.mod;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.fund.FundRentAdjust;
import com.business.service.TableService;
import com.business.service.reckon.ConditionDataToHisService;
import com.kernal.annotation.WorkflowAction;

/**
 * 
 * @author 孙传良
 * @date 2013-5-26下午06:20:19
 * @info
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "planModEndAction", description = "流程结束动作", workflowName = "租金计划修改")
@Component(value = "planModEndAction")
public class PlanModEndAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	@Resource(name="conditionDataToHisService")
	private ConditionDataToHisService  conditionDataToHisService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */
		
		ContractInfo contractInfo=(ContractInfo)this.tableService.findEntityByID(ContractInfo.class, variablesMap.get("contract_info.id"));
		String docId=jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"";
		String hisType=variablesMap.get("fund_rent_adjust.adjusttype");
		//保存数据
		//1.入历史表前
		//2.入正式表
		//3.入历史表后
		conditionDataToHisService.saveContractConditionDataToHis(contractInfo.getId(), docId, hisType, variablesMap, "framework_condition",
				"json_fund_rent_plan_str", "", "json_fund_cash_flow_str", "");
		//4.写入调整记录
		FundRentAdjust adjustInfo=new FundRentAdjust();
		this.tableService.copyAndOverrideExistedValueFromStringMap(variablesMap, adjustInfo, null,"fund_rent_adjust");
		adjustInfo.setContractId(contractInfo);
		this.tableService.saveEntity(adjustInfo);
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
	}

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub

	}
}
