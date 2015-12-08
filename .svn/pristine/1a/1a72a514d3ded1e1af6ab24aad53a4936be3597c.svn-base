package com.business.action.leasing.assets;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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
import com.business.entity.contract.reckon.fund.ContractFundRentInCome;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.vouchersFactory.ContractOnHireService;
import com.business.service.vouchersFactory.FundIncomeService;
import com.google.common.collect.Maps;
import com.kernal.annotation.WorkflowAction;


@WorkflowAction(name = "dealerFundIncomeEndAction", description = "流程结束动作", workflowName = "经销商租金回笼")
@Component(value = "dealerFundIncomeEndAction")
public class DealerFundIncomeEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Resource(name="fundIncomeService")
	private FundIncomeService fundIncomeService;
	
	@Resource(name="contractOnHireService")
	private ContractOnHireService contractOnHireService;
	
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String ebank_id = variablesMap.get("ebank_id");
		String paytype="pay_type_in";
		System.out.println(variablesMap);
	    DictionaryData dicdpayType;
		Map<String,String> propertiesMap = new HashMap<String,String>();
		propertiesMap.put("DictionaryData", "code");
		propertiesMap.put("FundEbankData", "ebdataId");
		propertiesMap.put("FundFundChargePlan", "paymentId");
		
		
		//网银检查
		BigDecimal sum = BigDecimal.ZERO;
		JSONArray jsonArr = new JSONArray(variablesMap.get("json_id_fund_rent_income"));
		for(int i=0;i<jsonArr.length();i++){
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			sum=sum.add(new BigDecimal(jsonObj.getDouble("receivermoney")));
		}
		
		FundEbankProcess fundEbankProcess = (FundEbankProcess) this.baseService.findEntityByID(FundEbankProcess.class, variablesMap.get("fund_ebank_process"));
		FundEbankData fundEbankData = (FundEbankData) this.baseService.findEntityByID(FundEbankData.class, variablesMap.get("ebank_id"));
		
		fundEbankData.initFundEbank();
		fundEbankData.setInuseflag("0");
		//去除当前网银中间表数据；
		sum = sum.subtract(fundEbankProcess.getProcessAmount()).setScale(2,BigDecimal.ROUND_HALF_UP);
		if(fundEbankData.getMayOpeMoney().subtract(sum).compareTo(BigDecimal.ZERO) == -1){
			throw new BusinessException("当前核销金额有误,请检查");
		} 
		fundEbankProcess.setWork_flag("1");
		this.baseService.updateEntity(fundEbankProcess);
		
		// 实收
		String jsonFundString = variablesMap.get("json_id_fund_rent_income");//proj_info.projEquips
		JSONArray jsonArray = new JSONArray(jsonFundString);
		JSONArray newjsonArray = new JSONArray();
	
		Map<String,List<String>> contractMap = Maps.newHashMap();
		
		for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			if(jsonObj.has("contract_id")){
				String contracid =jsonObj.getString("contract_id");
				String sql="update contract_fund_rent_plan set card_export_status='0'  where contract_id= '"+contracid+"'";
				this.baseService.updateBySql(sql);
			}
			jsonObj.remove("id");
			jsonObj.put("payType", paytype);
			jsonObj.put("planlist", Integer.parseInt((String) jsonObj.opt("planlist")));
			//jsonObj.put("hirelist", Integer.parseInt((String) jsonObj.opt("hirelist")));
			
			
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
		Iterator<String> it = contractMap.keySet().iterator();
		while (it.hasNext()) {
			String contract_id = (String) it.next();
			ContractInfo contractInfo = (ContractInfo) this.baseService.findEntityByID(ContractInfo.class, contract_id);
			List<String> jsonFundList = contractMap.get(contract_id);
			
			this.baseService.updateOneToManyCollectionsNoRemoved(contractInfo, "contractFundRentIncomes", ContractFundRentInCome.class, "contractId", jsonFundList.toString(),propertiesMap);
		}
		/**凭证-开始*/
		for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			BigDecimal rent=new BigDecimal(jsonObj.getDouble("rent"));
			String contract_id = jsonObj.optString("contract_id");
			String planid = jsonObj.optString("planid");
			ContractInfo contractInfo = (ContractInfo) this.baseService.findEntityByID(ContractInfo.class, contract_id);
			if(rent.compareTo(BigDecimal.ZERO)!=0){
				fundIncomeService.createVoucher(contractInfo,jsonObj,fundEbankData);
			}
			
			BigDecimal penalty =new BigDecimal(jsonObj.optString("penalty")).setScale(2, BigDecimal.ROUND_HALF_EVEN);
			if(penalty.compareTo(BigDecimal.ZERO)!=0){
				String workFlowName = "租金回笼";
			    //  确认+客户+延期利息
			    fundIncomeService.createVoucherForPenalty(contractInfo,jsonObj,workFlowName);
			    //  核销+客户+延期利息
			    fundIncomeService.createVoucherForPenaltyhx(contractInfo,jsonObj,fundEbankData);
				
			    /*start 处理补 租金利息凭证*/
				String sql3="select  c.id from  CONTRACT_FUND_RENT_PLAN c"
						+ " left join INTEREAS_VOUCHERHEAD h on c.contract_id=h.contract_id"
						+ " where  h.modleName='租金利息'  and c.contract_id='"+contract_id+"'"
						+ " and c.id='"+planid+"' ";
				List<Map<String,Object>> listBySql = baseService.queryListBySql(sql3);
				if( listBySql.size() > 0 ){
					System.out.println("contract_id--"+contract_id+"-->"+"planid--"+planid);
				}
				else{
					ContractFundRentPlan rentPlan = this.baseService.findEntityByID(ContractFundRentPlan.class, planid);
					BigDecimal rt = rentPlan.getRent();
					BigDecimal interest = rentPlan.getInterest();
					contractOnHireService.createVoucherRTInterest(rentPlan, rt, interest);
				}
				/*end 处理补 租金利息凭证*/
				
			}
		}
		
		String workFlowFlags = variablesMap.get("workFlowFlag");
		
		if (StringUtils.isNotEmpty(workFlowFlags)) {
			/** 流程冲突第三步-结束*/
			List<WorkFlowFlag> workFlags = this.baseService.findEntityByIDArray(WorkFlowFlag.class, workFlowFlags.split(","));
			this.baseService.removeAllEntites(workFlags);
			/** 流程冲突第三步-结束*/
		}
		//throw new Exception("123");
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
