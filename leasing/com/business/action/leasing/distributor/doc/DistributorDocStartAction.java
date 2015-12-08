package com.business.action.leasing.distributor.doc;

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


@WorkflowAction(name = "distributorDocStartAction", description = "流程开始动作", workflowName = "经销商资料补充")
@Component(value = "distributorDocStartAction")
public class DistributorDocStartAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;


	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String cust_id = variablesMap.get("cust_id");
		String approvalNum=variablesMap.get("approvalnum");
		CustInfo custInfo=(CustInfo)this.baseService.findEntityByID(CustInfo.class, cust_id);
		variablesMap.put("cust_info.custname",custInfo.getCustName());
		variablesMap.put("cust_info.custnumber",custInfo.getCustNumber());
		variablesMap.put("cust_info.id", custInfo.getId());
		Map<String,String>classFieldMapping=new HashMap<String,String>();
		classFieldMapping.put("DictionaryData", "code");
		variablesMap.putAll(this.baseService.getEntityPropertiesToStringMap(custInfo.getCustInfoDealer(), classFieldMapping,"dealer_approval_info"));
		variablesMap.put("current_date", DateUtil.getSystemDate());
		variablesMap.put("dealer_approval_info.creditnum", approvalNum);
	     
	}
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
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
	}
}
