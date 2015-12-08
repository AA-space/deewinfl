package com.business.action.leasing.contract.equipAcceptance;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.contract.equip.ContractEquipAcceptance;
import com.business.entity.cust.CustInfo;
import com.business.service.TableService;
import com.google.gson.JsonObject;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;


@WorkflowAction(name = "equipAcceptanceEditAction", description = "设备验收流程编辑", workflowName = "设备验收流程")
@Component(value = "equipAcceptanceEditAction")
public class EquipAcceptanceEditAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		ContractInfo contractInfo= (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, variablesMap.get("contract_id"));
		//将设备清单的流程状态设置为流程中
		if (!contractInfo.getContractEquips().isEmpty()) {// 租赁物明细
			Iterator<ContractEquip> it = contractInfo.getContractEquips().iterator();
			while (it.hasNext()) {
				ContractEquip contractEquip = (ContractEquip) it.next();
				contractEquip.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
			}
		}
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {}

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
