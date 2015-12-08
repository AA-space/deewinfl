package com.business.action.leasing.contract.equipAcceptance;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.equip.ContractEquipAcceptance;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.service.TableService;
import com.business.service.reckon.ConditionDataToHisService;
import com.business.service.reckon.ContractFundPlanDataTohisService;
import com.kernal.annotation.WorkflowAction;


@WorkflowAction(name = "equipAcceptanceEndAction", description = "设备验收流程结束", workflowName = "设备验收流程")
@Component(value = "equipAcceptanceEndAction")
public class EquipAcceptanceEndAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	@Resource(name="conditionDataToHisService")
	private ConditionDataToHisService  conditionDataToHisService;
	@Resource(name="ContractFundPlanDataTohisService")
	private ContractFundPlanDataTohisService contractFundPlanDataTohisService;

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		ContractInfo contractInfo = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, variablesMap.get("contract_id"));
		//contract_fund_rent_plan_before拷贝到contract_fund_rent_plan表中
		String json_fund_rent_plan_str = variablesMap.get("json_fund_rent_plan_str");
		this.tableService.updateOneToManyCollections(contractInfo, "contractFundRentPlans", ContractFundRentPlan.class, "contractId", json_fund_rent_plan_str,null);
		
		//更新商务条件、租金计划、现金流
		String docId=jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"";
		conditionDataToHisService.saveContractConditionDataToHis(contractInfo.getId(), docId, "his_contract_onhire", variablesMap, "framework_condition",
				"json_fund_rent_plan_str", "", "json_fund_cash_flow_str", "");
		//更新资金计划
		contractFundPlanDataTohisService.saveContractConditionDataToHis(contractInfo.getId(), docId, "his_contract_onhire", variablesMap, "json_fund_fund_charge_str", "");
		//保存验收信息
		ContractEquipAcceptance equipAcceptance = new ContractEquipAcceptance();
		this.tableService.copyAndOverrideExistedValueFromStringMap(variablesMap, equipAcceptance, null, "equip_acceptance");
		equipAcceptance.setContractId(contractInfo);
		this.tableService.saveEntity(equipAcceptance);
		
		
		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */

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
