package com.business.action.leasing.fundPayment;

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
import com.business.entity.asset.FundEbankData;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.util.OwnAccount;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.vouchersFactory.FundPaymentService;
import com.kernal.annotation.WorkflowAction;


@WorkflowAction(name = "fundPaymentEndAction", description = "流程结束动作", workflowName = "付款流程")
@Component(value = "fundPaymentEndAction")
public class FundPaymentEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Resource(name="fundPaymentService")
	private FundPaymentService fundPaymentService;
	private static ObjectMapper jsonMapper = new ObjectMapper(); 
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		System.out.println(variablesMap);
		String  contractid=variablesMap.get("contract_info.contractid");
		String HQL=" from ContractInfo as c where c.contractId=?";
		ContractInfo contractinfo;
		contractinfo=(ContractInfo)this.baseService.findResultsByHSQL(HQL, contractid).get(0);
		Map<String,String> propertiesMap = new HashMap<String,String>();
		propertiesMap.put("DictionaryData", "code");
		propertiesMap.put("ContractFundFundPlan", "id");
		propertiesMap.put("ContractFundFundCharge", "id");
		String jsonFundString = variablesMap.get("json_contract_fund_payment_now_str");//proj_info.projEquips
		ObjectMapper jsonMapper = new ObjectMapper(); 
		JSONArray jsonArray = new JSONArray(jsonFundString);
		JSONArray newjsonArray = new JSONArray();
		List<String> jsonFundList=new ArrayList<String>();
		//获取本次付款保证金，为生成凭证 ：支付+客户+保证金
		BigDecimal cautionmoney = BigDecimal.ZERO;
		String ownAccNumber = null;
		//获取本次付款保证金，为生成凭证 ：支付+客户+车款
		BigDecimal equipmoney = BigDecimal.ZERO;
		for(int i=0;i<jsonArray.length();i++){
			  JSONObject jsonObj = jsonArray.getJSONObject(i);
			  //保存保证金
			  if("feetype2".equals(jsonObj.get("feetype")))
			  {
				  cautionmoney=cautionmoney.add(new BigDecimal(jsonObj.getDouble("factmoney")));
				  ownAccNumber = jsonObj.optString("accnumber");
			  }
			  if("feetype10".equals(jsonObj.get("feetype")))
			  {
				  equipmoney=equipmoney.add(new BigDecimal(jsonObj.getDouble("factmoney")));
			  }
			  jsonObj.remove("id");    
			  Map[] newSetMaps = jsonMapper.readValue("["+jsonObj.toString()+"]", Map[].class);
			  ContractFundFundCharge mc=new ContractFundFundCharge();
			  this.baseService.copyAndOverrideExistedValueFromStringMap(newSetMaps[0], mc, propertiesMap);
			  if(mc.getSettleMethod().getCode().equalsIgnoreCase("PayFund9")){
				  mc.setRollBack("1");
				  mc.getPID().setRollBack("1");
				  this.baseService.saveOrUpdateEntity(mc.getPID());
			  }
			  mc.setContractId(contractinfo);
			  this.baseService.saveOrUpdateEntity(mc);
			  
				//获取网银信息
				Map<String, Object> proMap=new HashMap<String, Object>();
				//本方账号信息(指定)
				proMap.put("accNumber",ownAccNumber);//按账号查询
				OwnAccount ownacc=this.baseService.findEntityByProperties(OwnAccount.class,proMap).get(0);
				/** 凭证生成-开始*/
				/*本次付款中保证金大于0,则生成凭证： 支付+客户+保证金
				 传入参数，para1：合同信息，para2：本次付款保证金
				 * */
				
				String feeType = jsonObj.getString("feetype");
				
				if(cautionmoney.compareTo(BigDecimal.ZERO)==1 && ownacc != null){
					fundPaymentService.createVoucherCautionMoney(contractinfo, cautionmoney.setScale(2,BigDecimal.ROUND_HALF_UP),ownacc, feeType);
				}
			 
		}
	
		

		
		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.baseService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.baseService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */
		
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
