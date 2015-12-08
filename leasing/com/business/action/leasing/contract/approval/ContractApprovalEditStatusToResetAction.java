package com.business.action.leasing.contract.approval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.BaseMessage;
import com.business.entity.base.BaseMessageToUser;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractGuaranteeMethod;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractPremiseCondition;
import com.business.entity.contract.ContractSupplierInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.proj.ProjInfo;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;

/**
 * 
 * 04合同审核岗位寄送退回第三步，将状态改为，16
 * 
 * @Copyright Tenwa
 */
@WorkflowAction(name = "contractApprovalEditStatusToResetAction", description = "流程修改合同状态", workflowName = "合同审批流程")
@Component(value = "contractApprovalEditStatusToResetAction")
public class ContractApprovalEditStatusToResetAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Resource(name = "tableService")
	private TableService tableService;

	
	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		System.out.println("#############进入重置状态");
		//退回  把状态 置回  16
		String contractId = variablesMap.get("contract_info.contractid");
		variablesMap.put("contract_info.id", variablesMap.get("contract_info.id"));
		ContractInfo contractInfo = new ContractInfo();
		Map<String,Object> Mapa = new HashMap<String,Object>();
		if (!"".equals(contractId)) 
		{
			Mapa.put("contractId", contractId);
			List<ContractInfo> cInfos = this.baseService.findEntityByProperties(ContractInfo.class, Mapa);
			if (cInfos != null && cInfos.size() > 0) 
			{
				contractInfo = cInfos.get(0);
				contractInfo.setContractStatus(AppStaticUtil.CONTRACT_APPROVAL_01);
				System.out.println("#############结束重置状态");
	        }
		}
	}
	
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		 
		
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		 
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	
	
}
