package com.business.action.leasing.distributor.drawback;

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
import com.business.entity.asset.FundEbankData;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.MFundFundCharge;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;


@WorkflowAction(name = "disDrawbackfirstAction", description = "第一步结束动作", workflowName = "经销商保证金退款流程")
@Component(value = "disDrawbackfirstAction")
public class DisDrawbackfirstAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		 String custid=variablesMap.get("cust_info.id");
		    CustInfo ci=(CustInfo)this.baseService.findEntityByID(CustInfo.class, custid);
		    String ebankid=variablesMap.get("fund_ebank_data.ebdataid");
		    Map<String,Object>properties=new HashMap<String,Object>();
		    properties.put("ebdataId", ebankid);
		    FundEbankData fd=(FundEbankData)this.baseService.findEntityByProperties(FundEbankData.class, properties).get(0);
		 // 实收
		    Map<String,String>classFieldMapping=new HashMap<String,String>();
		    classFieldMapping.put("DictionaryData", "code");
		    classFieldMapping.put("FundEbankData", "ebdataId");
			String jsonFundString = variablesMap.get("json_receivercharge_str");//proj_info.projEquips
			ObjectMapper jsonMapper = new ObjectMapper(); 
			JSONArray jsonArray = new JSONArray(jsonFundString);
			JSONArray newjsonArray = new JSONArray();
			List<String> jsonFundList=new ArrayList<String>();
			for(int i=0;i<jsonArray.length();i++){
				  JSONObject jsonObj = jsonArray.getJSONObject(i);
				  jsonObj.remove("id");    
				  Map[] newSetMaps = jsonMapper.readValue("["+jsonObj.toString()+"]", Map[].class);
				  MFundFundCharge mc=new MFundFundCharge();
				  this.baseService.copyAndOverrideExistedValueFromStringMap(newSetMaps[0], mc, classFieldMapping);
				  mc.setDealerId(ci);
				  if(mc.getSettleMethod().getCode().equalsIgnoreCase("PayFund9")){
					  mc.setRollBack("1");
					  mc.getPID().setRollBack("1");
					  this.baseService.saveOrUpdateEntity(mc.getPID());
				  }
				  this.baseService.saveOrUpdateEntity(mc);
				 
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
