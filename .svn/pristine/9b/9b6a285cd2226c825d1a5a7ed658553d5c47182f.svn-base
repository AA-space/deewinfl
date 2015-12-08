package com.business.action.leasing.distributor.contract;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.cust.CustInfo;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;

/**
 * 
 * @author 邱明
 * @date 2013-6-24上午17:55:13
 * @info 经销商合同管理
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "distributorContractStartAction", description = "流程开始动作", workflowName = "经销商合同管理")
@Component(value = "distributorContractStartAction")
public class DistributorContractStartAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
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
		String cust_id = variablesMap.get("cust_id");
		String approvalnum=variablesMap.get("approvalnum");
		String approvaldate=variablesMap.get("approvaldata");
		CustInfo custInfo=(CustInfo)this.baseService.findEntityByID(CustInfo.class, cust_id);
		variablesMap.put("cust_info.custname",custInfo.getCustName());
		variablesMap.put("cust_info.custnumber",custInfo.getCustNumber());
		variablesMap.put("cust_info.id", custInfo.getId());
		Map<String,String>classFieldMapping=new HashMap<String,String>();
		classFieldMapping.put("DictionaryData", "code");
		variablesMap.putAll(this.baseService.getEntityPropertiesToStringMap(custInfo.getCustInfoDealer(), classFieldMapping,"dealer_contract_info"));
		variablesMap.put("current_date", DateUtil.getSystemDate());
	    variablesMap.put("dealer_contract_info.creditnum", approvalnum);
	    variablesMap.put("dealer_contract_info.credittime", approvaldate);
	   
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
