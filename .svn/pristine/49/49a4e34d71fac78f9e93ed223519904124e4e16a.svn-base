package com.business.action.leasing.assets.depositDeduction;

import java.math.BigDecimal;
import java.util.HashMap;
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
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.fund.ContractFundRentInCome;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.service.BaseService;
import com.business.service.vouchersFactory.DepositDeductionService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;

/**
 * 
 * @author 陈兴<br>
 *         时间：2013-08-15<br>
 *         方法名：保证金抵扣流程 结束Action
 * 
 */
@WorkflowAction(name = "depositDeductionEndAction", description = "流程结束动作", workflowName = "期末保证金抵扣")
@Component(value = "depositDeductionEndAction")
public class DepositDeductionEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Resource(name="depositDeductionService")
	private DepositDeductionService depositDeductionService;

	@Override
	/**
	 * 流程退回动作
	 */
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	@Override
	/**
	 * 流程删除动作
	 */
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	/**
	 * 流程结束动作
	 */
	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		/** 流程冲突第三步-结束*/
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.baseService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.baseService.removeEntity(w);
		}
		/** 流程冲突第三步-结束*/
		
		String contract_id = variablesMap.get("contract_info.id");
		ContractInfo contractInfo = (ContractInfo) baseService.findEntityByID(ContractInfo.class, contract_id);
		String contractFundRendString = variablesMap.get("json_rent_up_detail_str");
//		Map<String,String> propertiesMap = new HashMap<String,String>();
//		propertiesMap.put("DictionaryData", "code");
//		propertiesMap.put("FundEbankData", "ebdataId");
//		propertiesMap.put("ContractFundRentPlan", "id");
//		propertiesMap.put("planId.id", "planId");
//		this.baseService.updateOneToManyCollectionsNoRemoved(contractInfo, "contractFundRentIncomes", ContractFundRentInCome.class, "contractId", contractFundRendString, propertiesMap);
		
	    //生成凭证需要的参数，租金和保证金
		BigDecimal sum=BigDecimal.ZERO;
		BigDecimal interest= BigDecimal.ZERO;
	    BigDecimal CautionMoney=BigDecimal.ZERO;
	    System.out.println("contractFundRendString"+contractFundRendString);
	    JSONArray jsonArray=new JSONArray(contractFundRendString);
	    for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			sum=sum.add(new BigDecimal(jsonObj.getDouble("rent")));//租金总数
			interest = interest.add(new BigDecimal(jsonObj.getDouble("interest")));
			/*持久化 ContractFundRentInCome start*/
			ContractFundRentInCome contractFundRentInCome = new ContractFundRentInCome();
			contractFundRentInCome.setPlanList(jsonObj.getInt("planlist"));
			contractFundRentInCome.setHireList(jsonObj.getInt("hirelist"));
			HashMap<String, Object> propertiesMap = new HashMap<String,Object>();
			propertiesMap.put("contractId", contractInfo);
			propertiesMap.put("rentList", jsonObj.getInt("planlist"));
			ContractFundRentPlan CRentPlan = this.baseService.findEntityByID(ContractFundRentPlan.class,jsonObj.has("contractid")?jsonObj.getString("planid"):"");
			if(CRentPlan==null){
				List<ContractFundRentPlan> list = this.baseService.findEntityByProperties(ContractFundRentPlan.class, propertiesMap);
				if(list.size()>0){
					ContractFundRentPlan fundRentPlan = list.get(0);
					contractFundRentInCome.setPlanId(fundRentPlan);
				}
			}else{
				contractFundRentInCome.setPlanId(CRentPlan);
			}
			
			contractFundRentInCome.setContractId(contractInfo);
			contractFundRentInCome.setCreateDate(DateUtil.getSystemDateTime());
			contractFundRentInCome.setCreator(SecurityUtil.getPrincipal());
			contractFundRentInCome.setBalanceMode(this.baseService.findEntityByID(DictionaryData.class,"PayFund7"));
			contractFundRentInCome.setRent(new BigDecimal(jsonObj.getString("rent")) );
			contractFundRentInCome.setCorpus(new BigDecimal(jsonObj.getString("corpus")) );
			contractFundRentInCome.setInterest(new BigDecimal(jsonObj.getString("interest")) );
			contractFundRentInCome.setPenalty(new BigDecimal(jsonObj.getString("penalty")));
			contractFundRentInCome.setHireDate(jsonObj.getString("hiredate"));
			contractFundRentInCome.setAccountingDate(DateUtil.getSystemDate());
			this.baseService.saveEntity(contractFundRentInCome);
			/*持久化 ContractFundRentInCome end */
	    }
	    CautionMoney=new BigDecimal(variablesMap.get("projcondition_info.deductible"));//抵扣保证金
		/*
		 * 凭证生成：保证金抵冲租金
		 * para1:合同信息，para2:租金，para3：保证金
		 * */
		depositDeductionService.createVoucherCautionMoney(contractInfo, jsonArray,interest, sum);
		/*
		 * 凭证结束
		 * */
	}

	/**
	 * 流程保存动作
	 */
	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	/**
	 * 流程开始动作
	 */
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

}
