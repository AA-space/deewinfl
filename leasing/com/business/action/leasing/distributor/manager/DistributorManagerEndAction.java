package com.business.action.leasing.distributor.manager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.BaseDocumentConfig;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.CustInfoDealer;
import com.business.entity.dealer.DealerApprovalInfo;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.QueryUtil;
/**
 * 
 * @author 徐云龙
 * @date 2013-6-24上午17:55:13
 * @info 经销商准入申请
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "distributorManagerEndAction", description = "流程结束动作", workflowName = "经销商申请")
@Component(value = "distributorManagerEndAction")
public class DistributorManagerEndAction implements JbpmBaseAction {
	@Resource(name="tableService")
	private TableService baseService;

	/*
	 * public ProjApprovalEndAction(){ this.baseService =
	 * (ProjApprrovalDao)WebUtil.getApplicationContext().getBean("baseService"); }
	 */
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String cust_id=variablesMap.get("cust_info.id");
		CustInfo custinfo=(CustInfo)this.baseService.findEntityByID(CustInfo.class, cust_id);
		Map<String,Object> propertiesMap=new HashMap<String,Object>();
		propertiesMap.put("custId", null);
		Map<String,String>classFieldMapping=new HashMap<String,String>();
		classFieldMapping.put("DictionaryData", "code");
		classFieldMapping.put("CustInfo", "id");
		classFieldMapping.put("Department", "id");
		variablesMap.put("dealer_approval_info.custId", custinfo.getId());
		String dealerStatus=variablesMap.get("dealer_approval_info.dealerStatus");
		if(dealerStatus.equalsIgnoreCase("agreeApply")){variablesMap.put("dealer_approval_info.dealerStatus", "dealerApprovalstatus2");}
		if(dealerStatus.equalsIgnoreCase("noagreeApply")){variablesMap.put("dealer_approval_info.dealerStatus", "dealerApprovalstatus3");}                                                                                             
		DealerApprovalInfo dai=(DealerApprovalInfo)this.baseService.updateMainEntity(DealerApprovalInfo.class, propertiesMap, variablesMap, classFieldMapping, "dealer_approval_info");
		//CustInfoDealer dealer=custinfo.getCustInfoDealer();
		//dealer.setContractNum(variablesMap.get("dealer_approval_info.contractnum").trim());
		//this.baseService.updateEntity(dealer);
		variablesMap.put("dealer_approval_info.dealerStatus", dealerStatus);
	  //保存资料清单
	    Map<String, String> map=new HashMap<String, String>();
		String  docReportStr = variablesMap.get("json_dealer_doc_report_str");
		JSONObject savedDataJsonObj = new JSONObject(docReportStr);  
		Iterator<String> iter =  savedDataJsonObj.keys();
		while(iter.hasNext()){
			String key = iter.next();
			map.put(key,  savedDataJsonObj.getString(key).toString());
		}
		this.baseService.savedTree2TableData(map.get("savedDataKey").toString(),map.get("valuesMapping").toString(),map);
		
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
