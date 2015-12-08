package com.business.action.leasing.fundPayDisEquipment;

import java.math.BigDecimal;
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
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.util.OwnAccount;
import com.business.service.BaseService;
import com.business.service.vouchersFactory.FundPaymentService;
import com.kernal.annotation.WorkflowAction;


@WorkflowAction(name = "fundPayDisEquipmentEndAction", description = "流程结束动作", workflowName = "项目投放流程")
@Component(value = "fundPayDisEquipmentEndAction")
public class FundPayDisEquipmentEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Resource(name="fundPaymentService")
	private FundPaymentService fundPaymentService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		 Map<String,String> propertiesMap = new HashMap<String,String>();
			propertiesMap.put("DictionaryData", "code");
			propertiesMap.put("ContractFundFundPlan", "paymentId");
			String jsonFundString = variablesMap.get("json_contract_fund_payment_now_str");//proj_info.projEquips
			System.out.println(jsonFundString.toString());
			ObjectMapper jsonMapper = new ObjectMapper(); 
			JSONArray jsonArray = new JSONArray(jsonFundString);
			JSONArray newjsonArray = new JSONArray();
			List<String> jsonFundList=new ArrayList<String>();
			for(int i=0;i<jsonArray.length();i++){
				  JSONObject jsonObj = jsonArray.getJSONObject(i);
				  jsonObj.remove("id");    
				  Map[] newSetMaps = jsonMapper.readValue("["+jsonObj.toString()+"]", Map[].class);
				  ContractFundFundCharge mc=new ContractFundFundCharge();
				  this.baseService.copyAndOverrideExistedValueFromStringMap(newSetMaps[0], mc, propertiesMap);
				  this.baseService.saveOrUpdateEntity(mc);
				  
					/** 设备投放-凭证生成-开始*/
				  
				  String ownAccNumber  = mc.getAccNumber();
				  ContractInfo contractinfo = mc.getContractId();
				  BigDecimal factmoney = mc.getFactMoney();
					
					propertiesMap.clear();
					Map<String, Object> ownAccountMap = new HashMap<String, Object>();
					
					ownAccountMap.put("accNumber", ownAccNumber);
					OwnAccount ownacc = this.baseService.findEntityByProperties(OwnAccount.class, ownAccountMap).get(0);
					
					if(factmoney.compareTo(BigDecimal.ZERO)==1){
						fundPaymentService.createVoucherEquipMoney(contractinfo, factmoney.setScale(2,BigDecimal.ROUND_HALF_UP),ownacc);
					}
					/** 凭证生成-结束*/
				  
			}
			
			String workFlowFlags = variablesMap.get("workFlowFlag");
			
			if (StringUtils.isNotEmpty(workFlowFlags)) {
				/** 流程冲突第三步-结束*/
				List<WorkFlowFlag> workFlags = this.baseService.findEntityByIDArray(WorkFlowFlag.class, workFlowFlags.split(","));
				this.baseService.removeAllEntites(workFlags);
				/** 流程冲突第三步-结束*/
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
