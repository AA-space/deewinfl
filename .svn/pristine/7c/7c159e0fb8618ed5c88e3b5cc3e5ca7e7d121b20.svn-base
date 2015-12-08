package com.business.action.leasing.fundlimitapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractLimitInfo;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;


@WorkflowAction(name = "fundLimitAppEndAction", description = "流程结束动作", workflowName = "合同投放额度申请流程")
@Component(value = "fundLimitAppEndAction")
public class FundLimitAppEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
          System.out.println("end in"+variablesMap);
          
			Map<String,String> propertiesMap = new HashMap<String,String>();
			propertiesMap.put("DictionaryData", "code");
			propertiesMap.put("ContractFundFundPlan", "paymentId");
			
			String jsonFundString = variablesMap.get("json_fund_limit_str");//proj_info.projEquips
			System.out.println(jsonFundString.toString());
			ObjectMapper jsonMapper = new ObjectMapper(); 
			JSONArray jsonArray = new JSONArray(jsonFundString);
			JSONArray newjsonArray = new JSONArray();
			List<String> jsonFundList=new ArrayList<String>();
			for(int i=0;i<jsonArray.length();i++){
				  JSONObject jsonObj = jsonArray.getJSONObject(i);
				  jsonObj.remove("id");  
				  Map[] newSetMaps = jsonMapper.readValue("["+jsonObj.toString()+"]", Map[].class);
				  ContractLimitInfo mc=new ContractLimitInfo();
				  this.baseService.copyAndOverrideExistedValueFromStringMap(newSetMaps[0], mc, propertiesMap);
				/*  
				  ContractInfo cinfo;
			 	  Map<String,Object> Map = new HashMap<String,Object>();
				  
				  Map.put("contractId", jsonObj.get("contractid"));
				  cinfo = (ContractInfo) this.baseService.findEntityByProperties(ContractInfo.class, Map).get(0);*/
				  
				  //2013-11-29 13:40  修改前
				 /* ContractInfo cinfo = this.baseService.findEntityByID(ContractInfo.class, variablesMap.get("contractid"));*/
				  //2013-11-29 13:49 修改后。 修改原因：variablesMap.get("contractid")得到的合同id为空 。通过jsonObj.get("contractid")才能得到
				  ContractInfo cinfo = this.baseService.findEntityByID(ContractInfo.class, String.valueOf(jsonObj.get("contractid")));
				  
				  mc.setContractId(cinfo);
				  this.baseService.saveOrUpdateEntity(mc);
			}
			
			
			
			/** 流程冲突第三步-结束*/
			String workFlowFlags = variablesMap.get("workFlowFlag");
			
			if (StringUtils.isNotEmpty(workFlowFlags)) {
				/** 流程冲突第二步-结束*/
				List<WorkFlowFlag> workFlags = this.baseService.findEntityByIDArray(WorkFlowFlag.class, workFlowFlags.split(","));
				this.baseService.removeAllEntites(workFlags);
				/** 流程冲突第二步-结束*/
			}
			/** 流程冲突第三步-结束*/
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
