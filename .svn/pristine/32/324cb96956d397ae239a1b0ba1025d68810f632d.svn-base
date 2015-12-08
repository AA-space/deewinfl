package com.business.action.leasing.assets.onhirechange;

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
import com.business.entity.contract.ContractGuaranteeMethod;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.cust.CustInfo;
import com.business.service.BaseService;
import com.business.service.reckon.CustInfoDataTohisService;
import com.kernal.annotation.WorkflowAction;

/**
 * @author Jason
 * @date 2013-4-24
 * @info 
 */
@WorkflowAction(name = "contractOnhireChangeEndAction", description = "流程结束动作", workflowName = "起租后合同变更")
@Component(value = "contractOnhireChangeEndAction")
public class ContractOnhireChangeEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Resource(name = "custInfoDataTohisService")
	private CustInfoDataTohisService custInfoDataTohisService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.baseService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.baseService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */
		
		
		//获取参数
		String contract_id = variablesMap.get("contract_info.id");
		String new_cust_info = variablesMap.get("new_cust_info");
		String doc_id = jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"";
		// 1.合同基本信息
		ContractInfo contractInfo = (ContractInfo)this.baseService.findEntityByID(ContractInfo.class, contract_id);
		if(new_cust_info != null && !"".equals(new_cust_info)){
			CustInfo custInfo = (CustInfo) this.baseService.findEntityByID(CustInfo.class, new_cust_info);
			custInfoDataTohisService.saveCustInfoDataToHis(contractInfo, doc_id, "his_onhire_contract_change", custInfo);
		}
		// 2.保存变更租赁物件
		String json_contract_equip_container_new_str = variablesMap.get("json_contract_equip_container_new_str");
		System.out.println("json_contract_equip_container_new_str"+json_contract_equip_container_new_str);
		if(json_contract_equip_container_new_str != null && !json_contract_equip_container_new_str.equals("") && !json_contract_equip_container_new_str.equals("null") && !json_contract_equip_container_new_str.equals("[]".replace(" ", ""))){
			this.baseService.updateOneToManyCollections(contractInfo, "contractEquips", ContractEquip.class, "contractId", json_contract_equip_container_new_str,null);
		}
		// 3.保存变更担保单位
		String json_contract_guarantee_method_container_new_str = variablesMap.get("json_contract_guarantee_method_new_str");
		if(json_contract_guarantee_method_container_new_str != null && !json_contract_guarantee_method_container_new_str.equals("") && !json_contract_guarantee_method_container_new_str.equals("null") && !json_contract_guarantee_method_container_new_str.equals("[]".replace(" ", ""))){
			this.baseService.updateOneToManyCollections(contractInfo, "contractGuaranteeMethods", ContractGuaranteeMethod.class, "contractId", json_contract_guarantee_method_container_new_str,null);
		}
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
