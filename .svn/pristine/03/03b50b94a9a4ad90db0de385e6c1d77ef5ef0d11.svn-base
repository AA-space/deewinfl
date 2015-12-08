package com.business.action.leasing.fundCollection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.asset.FundEbankData;
import com.business.entity.asset.FundEbankProcess;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractLimitInfo;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.vouchersFactory.DealerFundCollectionService;
import com.business.service.vouchersFactory.FundCollectionService;
import com.google.common.collect.Maps;
import com.kernal.annotation.WorkflowAction;


@WorkflowAction(name = "dealerFundCollectionEndAction", description = "流程结束动作", workflowName = "经销商资金收款")
@Component(value = "dealerFundCollectionEndAction")
public class DealerFundCollectionEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Resource(name="dealerFundCollectionService")
	private DealerFundCollectionService dealerFundCollectionService;
	
	@Resource(name="fundCollectionService")
	private FundCollectionService fundCollectionService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		System.out.println(variablesMap);
		String workFlowFlags = variablesMap.get("workFlowFlag");

		if (StringUtils.isNotEmpty(workFlowFlags)) {
			/** 流程冲突第二步-结束 */
			List<WorkFlowFlag> workFlags = this.baseService.findEntityByIDArray(WorkFlowFlag.class, workFlowFlags.split(","));
			this.baseService.removeAllEntites(workFlags);
			/** 流程冲突第二步-结束 */
		}
		
		String ebank_id = variablesMap.get("ebank_id");
		String paytype="pay_type_in";
		
	    DictionaryData dicdpayType;
		String HQL=" from ContractInfo as c where c.contractId=?";
		Map<String,String> propertiesMap = new HashMap<String,String>();
		propertiesMap.put("DictionaryData", "code");
		propertiesMap.put("FundEbankData", "ebdataId");
		propertiesMap.put("FundFundChargePlan", "paymentId");
		
		//网银检查
		BigDecimal sum = BigDecimal.ZERO;
		JSONArray jsonArr = new JSONArray(variablesMap.get("json_receivercharge_str"));
		for(int i=0;i<jsonArr.length();i++){
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			sum=sum.add(new BigDecimal(jsonObj.getDouble("factmoney")));
		}
		
		FundEbankProcess fundEbankProcess = (FundEbankProcess) this.baseService.findEntityByID(FundEbankProcess.class, variablesMap.get("fund_ebank_process"));
		FundEbankData fundEbankData = (FundEbankData) this.baseService.findEntityByID(FundEbankData.class, variablesMap.get("ebank_id"));
		
		fundEbankData.initFundEbank();
		//去除当前网银中间表数据；
		sum = sum.subtract(fundEbankProcess.getProcessAmount());
		if(fundEbankData.getMayOpeMoney().subtract(sum).compareTo(BigDecimal.ZERO) == -1){
			throw new BusinessException("当前核销金额有误,请检查");
		} 
		fundEbankProcess.setWork_flag("1");
		this.baseService.updateEntity(fundEbankProcess);
		
		// 实收
		String jsonFundString = variablesMap.get("json_receivercharge_str");//proj_info.projEquips
		JSONArray jsonArray = new JSONArray(jsonFundString);
		JSONArray newjsonArray = new JSONArray();
	
		Map<String,List<String>> contractMap = Maps.newHashMap();
		
		for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			jsonObj.remove("id");
			jsonObj.put("payType", paytype);
			
			String contract_id = jsonObj.optString("contract_id");
			List<String> jsonFundList = null;
			if(contractMap.get(contract_id) == null){
				jsonFundList =new ArrayList<String>();
			} else{
				jsonFundList = contractMap.get(contract_id);
			}
			
			jsonFundList.add(jsonObj.toString());
			
			contractMap.put(contract_id, jsonFundList);
			
			//经销商资金收款占时不红冲
			/*
			String pid = jsonObj.optString("pid");
			String rollback = jsonObj.optString("rollback");
			if(pid != null && rollback != null && rollback.equals("1")){//如果是红冲，则将对应收款设置成rollback
				ContractFundFundCharge c = (ContractFundFundCharge) this.baseService.findEntityByID(ContractFundFundCharge.class, pid);
				//设置状态为红冲,rollbac设置为1
				DictionaryData payFund9Dict = (DictionaryData) this.baseService.findEntityByID(DictionaryData.class, "PayFund9");
				c.setRollBack("1");
				c.setSettleMethod(payFund9Dict);
				this.baseService.updateEntity(c);
			}
			*/
		}
		
		
		
		//保存留购价，为做凭证传参数
		BigDecimal nominalprice=BigDecimal.ZERO;
		Iterator<String> it = contractMap.keySet().iterator();
		while (it.hasNext()) {
			String contract_id = (String) it.next();
			ContractInfo contractInfo = (ContractInfo) this.baseService.findEntityByID(ContractInfo.class, contract_id);
			List<String> jsonFundList = contractMap.get(contract_id);
			
			this.baseService.updateOneToManyCollectionsNoRemoved(contractInfo, "fundFundCharges", ContractFundFundCharge.class, "contractId", jsonFundList.toString(),propertiesMap);
			
			//生成凭证
			JSONArray fundArr = new JSONArray(jsonFundList.toString());
			//保存首付款，为做凭证传参数
			BigDecimal originalMoney = BigDecimal.ZERO;
			//违约金
			BigDecimal fundpenalty = BigDecimal.ZERO;
			for(int i=0;i<fundArr.length();i++){
				JSONObject jsonObj = fundArr.getJSONObject(i);
				//统计违约金
				if("feetype13".equals(jsonObj.get("feetype")))
				{
					fundpenalty=fundpenalty.add(new BigDecimal(jsonObj.getDouble("factmoney")));
				}else{
				    originalMoney=originalMoney.add(new BigDecimal(jsonObj.getDouble("factmoney")));
				}
				//System.out.println("合同号：" + jsonObj.get("contract_number") + " | 款项：" + jsonObj.getString("rawvaluefee_type") + " | 金额 ： " + jsonObj.getDouble("factmoney"));
			}
			//System.out.println("合计 ：" + originalMoney.toString());
			//System.out.println("------------------------------------------------------------------------------");
			//其他金额计入 首付款凭证
			if (originalMoney.compareTo(BigDecimal.ZERO) != 0)
			{
				if (fundEbankData.getCustId() != null) {
					fundCollectionService.createVoucher(contractInfo,originalMoney,fundEbankData);
				} else {
					throw new BusinessException("网银还未指定到客户或者经销商，请先指定网银到客户或这经销商");
				}
			}
			
			//收违约金凭证
			if(fundpenalty.compareTo(BigDecimal.ZERO)!=0)
			{
				fundCollectionService.createVoucherForFundPenalty(contractInfo, fundpenalty,fundEbankData);
			}
			
		}
		
		//插入额度金额
		String json_fund_limit_str = variablesMap.get("json_fund_limit_str");// proj_info.projEquips
		JSONArray limitJsonArray = new JSONArray(json_fund_limit_str);
		ObjectMapper jsonMapper = new ObjectMapper(); 
		for (int i = 0; i < limitJsonArray.length(); i++) {
			JSONObject jsonObj = limitJsonArray.getJSONObject(i);
			jsonObj.remove("id");
			ContractLimitInfo climit = new ContractLimitInfo();
			
			Map[] newSetMaps = jsonMapper.readValue("["+jsonObj.toString()+"]", Map[].class);
			this.baseService.copyAndOverrideExistedValueFromStringMap(newSetMaps[0], climit, propertiesMap);

			ContractInfo cinfo = this.baseService.findEntityByID(ContractInfo.class, String.valueOf(jsonObj.get("contractid")));
			climit.setContractId(cinfo);
			//climit.setLimitMoney(new BigDecimal(String.valueOf(jsonObj.get("limitmoney"))));
			this.baseService.saveOrUpdateEntity(climit);
		}
		///throw new BusinessException("111");
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
