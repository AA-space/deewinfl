package com.business.action.leasing.other;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.equip.ContractEquipEvaluate;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
/**
 * 
 * @author 蔡雅超
 * @date 2013-8-31
 * @info收车评估的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "vehicleEvaluationEndAction", description = "流程结束动作", workflowName = "收车评估流程")
@Component(value = "vehicleEvaluationEndAction")
public class VehicleEvaluationEndAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	
	@SuppressWarnings("unchecked")
	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */

		String contractid=variablesMap.get("contract_id");
		ContractInfo contractInfo=(ContractInfo)this.tableService.findEntityByID(ContractInfo.class,contractid);
		Map<String,Object> properMap = new HashMap<String,Object>();
		properMap.put("contractId",contractInfo);
		ContractEquipEvaluate contractEquipEvaluate=null;
		List<ContractEquipEvaluate> contractEquipEvaluates=this.tableService.findEntityByProperties(ContractEquipEvaluate.class, properMap);
		if(contractEquipEvaluates.isEmpty()){
			contractEquipEvaluate=new ContractEquipEvaluate();
			contractEquipEvaluate.setContractId(contractInfo);
		}else{
			contractEquipEvaluates.get(0);
		}
        this.tableService.copyAndOverrideExistedValueFromStringMap(variablesMap, contractEquipEvaluate, null, "contract_equip_revoke");
        this.tableService.saveOrUpdateEntity(contractEquipEvaluate);
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
	}

}
