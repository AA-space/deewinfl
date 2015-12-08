package com.business.action.leasing.distributor.contract;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.BaseFile;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.CustInfoDealer;
import com.business.entity.dealer.DealerContractInfo;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;
/**
 * 
 * @author 邱明
 * @date 2013-6-24上午17:55:13
 * @info 经销商合同管理
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "distributorContractEndAction", description = "流程结束动作", workflowName = "经销商合同管理")
@Component(value = "distributorContractEndAction")
public class DistributorContractEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;

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
		CustInfoDealer dealer=custinfo.getCustInfoDealer();
		Map<String,Object> propertiesMap=new HashMap<String,Object>();
		Map<String,String>classFieldMapping=new HashMap<String,String>();
		classFieldMapping.put("DictionaryData", "id");
		classFieldMapping.put("CustInfo", "id");
		classFieldMapping.put("Department", "id");
		variablesMap.put("dealer_contract_info.custId", custinfo.getId());
		variablesMap.put("dealer_contract_info.dealerstatus","dealerApprovalstatus6");
		variablesMap.put("dealer_contract_info.flowunid",String.valueOf(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()));
		propertiesMap.put("custId", null);
		//合同审批信息
		this.baseService.updateMainEntity(DealerContractInfo.class, propertiesMap,variablesMap , classFieldMapping, "dealer_contract_info");
		//插入合同列表
		String fileliststr=variablesMap.get("json_word_list_str");
        if(!fileliststr.equalsIgnoreCase("[]")){
        	  classFieldMapping.clear();
        	  classFieldMapping.put("FileTemplate", "id");
        	  ObjectMapper jsonMapper = new ObjectMapper(); 
     		  JSONArray jsonArray = new JSONArray(fileliststr);
     		  for(int i=0;i<jsonArray.length();i++){
  			     JSONObject jsonObj = jsonArray.getJSONObject(i);
  			     Map[] newSetMaps = jsonMapper.readValue("["+jsonObj.toString()+"]", Map[].class);
  			     BaseFile bf=new BaseFile();
  			     this.baseService.copyAndOverrideExistedValueFromStringMap(newSetMaps[0], bf, classFieldMapping, true);
  			     bf.setId(null);
  			     this.baseService.saveOrUpdateEntity(bf);
     		} 
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
