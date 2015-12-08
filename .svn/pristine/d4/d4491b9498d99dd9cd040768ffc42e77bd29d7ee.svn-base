package com.business.action.leasing.fundCollection;

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
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.asset.FundEbankData;
import com.business.entity.asset.FundEbankProcess;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractLimitInfo;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.vouchersFactory.FundCollectionService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;


@WorkflowAction(name = "fundCollectionEndAction", description = "流程结束动作", workflowName = "收款流程")
@Component(value = "fundCollectionEndAction")
public class FundCollectionEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Resource(name="fundCollectionService")
	private FundCollectionService fundCollectionService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.baseService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.baseService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */
		
		String  contractid=variablesMap.get("contract_info.contractid");
		String paytype="pay_type_in";
		
		String HQL=" from ContractInfo as c where c.contractId=?";
		ContractInfo contractinfo;
		contractinfo=(ContractInfo)this.baseService.findResultsByHSQL(HQL, contractid).get(0);
		Map<String,String> propertiesMap = new HashMap<String,String>();
		propertiesMap.put("DictionaryData", "code");
		propertiesMap.put("FundEbankData", "ebdataId");
		propertiesMap.put("FundFundChargePlan", "paymentId");
		
		//网银检查
		BigDecimal sum = BigDecimal.ZERO;
		//保存违约金，为做凭证传参数
		BigDecimal fundpenalty = BigDecimal.ZERO;
	
		BigDecimal money=BigDecimal.ZERO;
		JSONArray jsonArr = new JSONArray(variablesMap.get("json_receivercharge_str"));
		for(int i=0;i<jsonArr.length();i++){
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			if(jsonObj.getDouble("factmoney") > 0){//去除红冲的负数
				sum=sum.add(new BigDecimal(jsonObj.getDouble("factmoney")));
			}
			//统计违约金
			if("feetype13".equals(jsonObj.get("feetype")))
			{
				fundpenalty=fundpenalty.add(new BigDecimal(jsonObj.getDouble("factmoney")));
			}else{
				//其他收款统计到首付款凭证中
				money=money.add(new BigDecimal(jsonObj.getDouble("factmoney")));
			}
			
		}
		
		//BigDecimal originalMoney = new BigDecimal(sum.toString());
		
		if("red".equals(variablesMap.get("feetype"))){
			System.out.println("红冲不需要网银信息");
		}else{
		  FundEbankProcess fundEbankProcess = (FundEbankProcess) this.baseService.findEntityByID(FundEbankProcess.class, variablesMap.get("fund_ebank_process"));
		  FundEbankData fundEbankData = (FundEbankData) this.baseService.findEntityByID(FundEbankData.class, variablesMap.get("ebank_id"));
		  fundEbankData.setInuseflag("0");
		  fundEbankData.initFundEbank();
		  //去除当前网银中间表数据；
		  sum = sum.subtract(fundEbankProcess.getProcessAmount());
		  if(fundEbankData.getMayOpeMoney().subtract(sum).compareTo(BigDecimal.ZERO) == -1){
			throw new BusinessException("当前核销金额有误,请检查");
		   } 
		   fundEbankProcess.setWork_flag("1");
		   this.baseService.updateEntity(fundEbankProcess);
		   //
		   /** 凭证生成-开始*/
			//
			/*如果该网银属于经销商,并且本次收款中首付款大于0,则生成凭证： 核销+客户+首付款
			 传入参数，para1：合同信息，para2：本次收首付款
			 * */
			
			//if ("CUST_INFO_DEALER".equals(fundEbankData.getCustId().getCustClass().getId())) {
			//	fundCollectionService.createVoucher(contractinfo,originalMoney);
			//}
		}
		// 实收
		String jsonFundString = variablesMap.get("json_receivercharge_str");//proj_info.projEquips
		JSONArray jsonArray = new JSONArray(jsonFundString);
		List<ContractFundFundCharge> contractfundfundcharge = new ArrayList<ContractFundFundCharge>();
		
		for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			jsonObj.remove("id");
			jsonObj.put("payType", paytype);
			ContractFundFundCharge fundfundCharge = new ContractFundFundCharge();
			fundfundCharge.setFactDate(jsonObj.optString("factdate"));
			fundfundCharge.setFactMoney(new BigDecimal(jsonObj.optString("factmoney")));
			fundfundCharge.setFeeAdjust(new BigDecimal(jsonObj.optString("feeadjust"))); 
			fundfundCharge.setFactObject(jsonObj.optString("factobject"));
			fundfundCharge.setAccountBank(jsonObj.optString("accountbank"));
			fundfundCharge.setAccount(jsonObj.optString("account"));
			fundfundCharge.setAccNumber(jsonObj.optString("accnumber"));
			fundfundCharge.setClientAccnumber(jsonObj.optString("clientaccnumber"));
			fundfundCharge.setClientAccount(jsonObj.optString("clientaccount"));
			fundfundCharge.setClientBank(jsonObj.optString("clientbank"));
			fundfundCharge.setAccountingDate(jsonObj.optString("accountingdate"));
			fundfundCharge.setCreateDate(DateUtil.getSystemDateTime());
			fundfundCharge.setContractId(contractinfo);
			Map<String, Object> mapc =new HashMap<String, Object>();
			mapc.put("ebdataId",jsonObj.optString("ebanknumber"));
			List<FundEbankData> fundEbankDatalist= this.baseService.findEntityByProperties(FundEbankData.class,mapc);
			if ( fundEbankDatalist.size() > 0 )
			{
				fundfundCharge.setEbankNumber(fundEbankDatalist.get(0));
			}
			ContractFundFundPlan fundFundChargePlan= this.baseService.findEntityByID(ContractFundFundPlan.class,jsonObj.optString("fundfundchargeplan"));
			fundfundCharge.setFundFundChargePlan(fundFundChargePlan);
			fundfundCharge.setFeeType(this.baseService.findEntityByID(DictionaryData.class,jsonObj.optString("feetype")));
			fundfundCharge.setSettleMethod(this.baseService.findEntityByID(DictionaryData.class, jsonObj.optString("settlemethod")));
			fundfundCharge.setCreator(SecurityUtil.getPrincipal());
			fundfundCharge.setPayType(this.baseService.findEntityByID(DictionaryData.class,"pay_type_in"));
			
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
			contractfundfundcharge.add(fundfundCharge);
		}
		this.baseService.saveOrUpdateAllEntities(contractfundfundcharge);
		//插入额度金额
		String json_fund_limit_str = variablesMap.get("json_fund_limit_str");// proj_info.projEquips
		JSONArray limitJsonArray = new JSONArray(json_fund_limit_str);
		ObjectMapper jsonMapper = new ObjectMapper(); 
		for (int i = 0; i < limitJsonArray.length(); i++) {
			JSONObject jsonObj = limitJsonArray.getJSONObject(i);
			jsonObj.remove("id");
			ContractLimitInfo contractLimitInfo = new ContractLimitInfo();
			Map[] newSetMaps = jsonMapper.readValue("["+jsonObj.toString()+"]", Map[].class);
			this.baseService.copyAndOverrideExistedValueFromStringMap(newSetMaps[0], contractLimitInfo, propertiesMap);
			
			ContractInfo cinfo = this.baseService.findEntityByID(ContractInfo.class, String.valueOf(jsonObj.get("contractid")));
			contractLimitInfo.setContractId(cinfo);
			this.baseService.saveOrUpdateEntity(contractLimitInfo);
		}
		
		
/*		//
		如果该网银属于经销商,并且本次收款中首付款大于0,则生成凭证： 核销+客户+首付款
		 传入参数，para1：合同信息，para2：本次收首付款
		 */
		FundEbankData fed=null;
		if(variablesMap.get("ebank_id")!=null){
			 fed = (FundEbankData) this.baseService.findEntityByID(FundEbankData.class, variablesMap.get("ebank_id"));
		}
		if(money.compareTo(BigDecimal.ZERO)!=0)
		{
			fundCollectionService.createVoucher(contractinfo,money,fed);
		}
		//收违约金凭证
		if(fundpenalty.compareTo(BigDecimal.ZERO)!=0)
		{
			fundCollectionService.createVoucherForFundPenalty(contractinfo, fundpenalty,fed);
		}
		/** 凭证生成-结束*/
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
