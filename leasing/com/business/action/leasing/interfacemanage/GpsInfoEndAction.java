package com.business.action.leasing.interfacemanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractLimitInfo;
import com.business.entity.contract.equip.gps.GPSInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;

import com.kernal.annotation.WorkflowAction;

/**
 * 
 * @author 周丽梅
 * @date 2014-1-3
 * @info信息管理Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "gpsInfoEndAction", description = "流程结束动作", workflowName = "信息管理")
@Component(value = "gpsInfoEndAction")
public class GpsInfoEndAction implements JbpmBaseAction{
	@Resource(name = "tableService")
	private TableService tableService;
	
	

	@Override
	public void back(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String delete(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//ContractInfo contractInfo = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, variablesMap.get("contract_id"));
		//contract_fund_rent_plan_before拷贝到contract_fund_rent_plan表中
		Map<String,String> propertiesMap = new HashMap<String,String>();
		propertiesMap.put("DictionaryData", "code");
		
		String json_proj_gps_str = variablesMap.get("json_proj_gps_str");
		//this.tableService.updateOneToManyCollections(contractInfo, null, GPSInfo.class, "contractId", json_proj_gps_str,null);
		
		ObjectMapper jsonMapper = new ObjectMapper(); 
		JSONArray jsonArray = new JSONArray(json_proj_gps_str);
		System.err.println(json_proj_gps_str);
		//JSONArray newjsonArray = new JSONArray();
		//List<String> jsonFundList=new ArrayList<String>(); 
		
		for(int i=0;i<jsonArray.length();i++){
			  JSONObject jsonObj = jsonArray.getJSONObject(i);
			  jsonObj.remove("id");  
			  Map[] newSetMaps = jsonMapper.readValue("["+jsonObj.toString()+"]", Map[].class);
			  GPSInfo gpsInfo=new GPSInfo();
			  this.tableService.copyAndOverrideExistedValueFromStringMap(newSetMaps[0], gpsInfo, propertiesMap);
			  this.tableService.saveOrUpdateEntity(gpsInfo);
		} 
		//throw new BusinessException("33");
	}

	@Override
	public String save(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
