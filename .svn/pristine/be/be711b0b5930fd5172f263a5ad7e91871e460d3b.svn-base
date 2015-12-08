package com.business.action.leasing.fundPlanChange;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.service.BaseService;
import com.business.service.reckon.ContractFundPlanDataService;
import com.kernal.annotation.WorkflowAction;


@WorkflowAction(name = "fundPlanChangeEndAction", description = "流程结束动作", workflowName = "资金计划变更流程")
@Component(value = "fundPlanChangeEndAction")
public class FundPlanChangeEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Resource(name="ContractFundPlanDataService")
	private ContractFundPlanDataService contractFundPlanDataService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}
  
	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//获取合同Id
		String contractId = variablesMap.get("contract_info.id");
		//获取流水号
		String docId=jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"";
		ContractInfo contractInfo = (ContractInfo)this.baseService.findEntityByID(ContractInfo.class, contractId);
		contractFundPlanDataService.saveContractConditionData(contractInfo.getId(), docId, "his_fund_plan_change", variablesMap, "json_fundchargeplanreceiver_str", "json_fundchargeplanpay_str");
		/** 流程冲突第三步-结束*/
		if(StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))){WorkFlowFlag w = this.baseService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
		this.baseService.removeEntity(w);}
		/** 流程冲突第三步-结束*/
		
	
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	
	 /**
	 * (non-Javadoc)
	 * @see com.business.action.JbpmBaseAction#back(javax.servlet.http.HttpServletRequest, java.util.Map)
	 **/
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
