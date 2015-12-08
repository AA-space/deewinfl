package com.business.action.leasing.distributor.deduction;

import java.math.BigDecimal;
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
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.reckon.fund.ContractFundRentInCome;
import com.business.entity.dealer.MFundFundCharge;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;


@WorkflowAction(name = "fundDeductionEndAction", description = "流程结束动作", workflowName = "经销商保证金抵扣流程")
@Component(value = "fundDeductionEndAction")
public class FundDeductionEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		 Map<String,String> propertiesMap = new HashMap<String,String>();
			propertiesMap.put("DictionaryData", "code");
			String jsonFundString = variablesMap.get("json_fund_rent_income_str");
			System.out.println(jsonFundString);
			ObjectMapper jsonMapper = new ObjectMapper(); 
			JSONArray jsonArray = new JSONArray(jsonFundString);
			JSONArray newjsonArray = new JSONArray();
			List<String> jsonFundList=new ArrayList<String>();
			for(int i=0;i<jsonArray.length();i++){
				  JSONObject jsonObj = jsonArray.getJSONObject(i);
				  jsonObj.remove("id");    
				  Map[] newSetMaps = jsonMapper.readValue("["+jsonObj.toString()+"]", Map[].class);
				  ContractFundRentInCome cfr=new ContractFundRentInCome();
				  this.baseService.copyAndOverrideExistedValueFromStringMap(newSetMaps[0], cfr, propertiesMap);
				  this.baseService.saveOrUpdateEntity(cfr);
				  MFundFundCharge mc=(MFundFundCharge)this.baseService.findEntityByID(MFundFundCharge.class, cfr.getPID());
				  MFundFundCharge md=new MFundFundCharge();
				  md.setDealerId(mc.getDealerId());
				  md.setFeeType(mc.getFeeType());
				  md.setSettleMethod((DictionaryData)this.baseService.findEntityByID(DictionaryData.class, "PayFund10"));
				  md.setPayType((DictionaryData)this.baseService.findEntityByID(DictionaryData.class, "pay_type_out"));
				  md.setFactDate(cfr.getHireDate());
				  md.setFactMoney(cfr.getPenalty());
				  md.setFeeAdjust(new BigDecimal(0.00));
				  md.setPID(mc);
				  this.baseService.saveOrUpdateEntity(md);
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
