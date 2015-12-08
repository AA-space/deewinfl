package com.business.action.leasing.distributor.manager;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.DealerApprovalInfo;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;

/**
 * 
 * @author 邱明
 * @date 2013-6-24上午17:55:13
 * @info 经销商准入申请
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "distributorManagerStartAction", description = "流程开始动作", workflowName = "经销商申请")
@Component(value = "distributorManagerStartAction")
public class DistributorManagerStartAction implements JbpmBaseAction {
	
	@Resource(name="tableService")
	private TableService baseService;

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
		CustInfo custInfo=(CustInfo)this.baseService.findEntityByID(CustInfo.class, cust_id);
		variablesMap.put("cust_info.custname",custInfo.getCustName());
		variablesMap.put("cust_info.custnumber",custInfo.getCustNumber());
		variablesMap.put("cust_info.id", custInfo.getId());
		Map<String,String>classFieldMapping=new HashMap<String,String>();
		classFieldMapping.put("DictionaryData", "name");
		variablesMap.putAll(this.baseService.getEntityPropertiesToStringMap(custInfo.getCustInfoDealer(), classFieldMapping,"dealer_approval_info"));
		variablesMap.put("current_date", DateUtil.getSystemDate());
	    String DealerCode="";
	    DealerCode=	custInfo.getCustNumber(); 
	    String ApprovalNum=	"";//custInfo.getCustInfoDealer().getApprovalNum();
	    Map<String,Object>propertiesMap=new HashMap<String,Object>();
	    propertiesMap.put("custId", custInfo);
	    int ANum= this.baseService.findEntityByProperties(DealerApprovalInfo.class, propertiesMap).size();
	    if(ANum==0){
	    	variablesMap.put("dealer_approval_info.approvalnum",DealerCode+"-001");
	    }else{
	    	if(ANum<10){
	    		variablesMap.put("dealer_approval_info.approvalnum",DealerCode+"-00"+(ANum+1));
	    	}
	    	if(ANum>=10 && ANum<100){
	    		variablesMap.put("dealer_approval_info.approvalnum",DealerCode+"-0"+(ANum+1));
	    	}
	    	if(ANum>=100){
	    		variablesMap.put("dealer_approval_info.approvalnum",DealerCode+"-"+(ANum+1));
	    	}
	    }	    
		//获取档案资料的json
	    Map<String,String> model=new HashMap<String, String>();
	    model.put("savedDataKey", "");
	    model.put("dictTableName", "base_document_config");
	    model.put("dictDataTableName", "base_document_column_config");
	    model.put("rootDictId", "doc_code_300");
	    String returnJsonInfo = baseService.createTree2TableJsonString("","base_document_config", "base_document_column_config", "doc_code_300", true,model);
	    variablesMap.put("json_dealer_doc_report_str",returnJsonInfo);
	    System.out.println(variablesMap.toString());
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
