package com.business.action.leasing.finacing.rate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.fund.FundAdjustInterestContractHis;
import com.business.entity.contract.reckon.fund.FundAdjustInterestContractTemp;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.service.reckon.ConditionDataToHisService;
import com.business.service.tx.AjustInterestService;
import com.business.service.vouchersFactory.ContractChargeService;
import com.kernal.annotation.WorkflowAction;

@WorkflowAction(name = "interestRateEndAction", description = "流程结束动作", workflowName = "调息流程")
@Component(value = "interestRateEndAction")
public class InterestRateEndAction implements JbpmBaseAction {

	@Resource(name = "tableService")
	private TableService tableService;

	@Resource(name = "conditionDataToHisService")
	private ConditionDataToHisService conditionDataToHisService;

	@Resource(name = "ajustInterestService")
	private AjustInterestService ajustInterestService;
	
	@Resource(name = "contractChargeService")
	private ContractChargeService contractChargeService;

	/**
	 * 将临时表数据插入到正式表
	 * 
	 * @param variablesMap
	 * @param tService
	 * @throws Exception
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public void addFundAdjustInterestContractTempToFundAdjustInterestContract(Map<String, String> variablesMap, BaseService tService) throws Exception {
		// 1将央行调息记录临时表copy到央行调息记录表
		this.ajustInterestService.updateCopyFundAdjustInterestContractTempToRecord(variablesMap);
		// 2将临时表的数据插入历史表
		this.addFundFundAdjustInterestContractToAdjustInterestContractHis(variablesMap, this.tableService);
		/*
		 * 3.将租金计划临时表copy到租金计划历史表 4.将现金流临时表copy到现金流历史表 5.将交易结构临时表copy到交易就够历史表
		 */
		// 设置状态为 ‘调息’
		variablesMap.put("table_for_his_type", "his_rate_change");
		this.ajustInterestService.updateCopyTxAllTempToHis(variablesMap, conditionDataToHisService);
		variablesMap = null;
	}

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		System.out.println(variablesMap);
		System.out.println("********************************************");
		String workFlowFlags = variablesMap.get("workFlowFlag");
		if (StringUtils.isNotEmpty(workFlowFlags)) {
			/** 流程冲突第二步-结束 */
			List<WorkFlowFlag> workFlags = this.tableService.findEntityByIDArray(WorkFlowFlag.class, workFlowFlags.split(","));
			this.tableService.removeAllEntites(workFlags);
			/** 流程冲突第二步-结束 */
		}
		
		String json_current_regulating_of_breathing_str =  variablesMap.get("json_current_regulating_of_breathing_str");
		System.out.println("调息结束步骤json字符串=" + variablesMap.get("json_current_regulating_of_breathing_str"));
		// 调息开始
		this.addFundAdjustInterestContractTempToFundAdjustInterestContract(variablesMap, this.tableService);
		
		JSONArray jsonArray = new JSONArray(json_current_regulating_of_breathing_str);
		
		for (int i = 0; i <jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String contract_id = jsonObject.getString("adjust_contractid");
			String doc_id =  jsonObject.getString("docid");
			ContractInfo contractInfo = this.tableService.findEntityByID(ContractInfo.class, contract_id);
			
			String hqlHis = "SELECT SUM(his.interest) FROM ContractFundRentPlanHis his WHERE his.contractId.id = ? AND his.docId = ?";
			String hqlNow = "SELECT SUM(his.interest) FROM ContractFundRentPlanHis his WHERE his.contractId.id = ?";
			List<BigDecimal> contractConditionHisList = this.tableService.findResultsByHSQL(hqlHis, new String[]{contract_id, doc_id});
			
			
			List<BigDecimal> contractConditionList = this.tableService.findResultsByHSQL(hqlNow, contract_id);
			
			if (contractConditionHisList.size() > 0 && contractConditionList.size() > 0 ) {
				BigDecimal his = contractConditionHisList.get(0);
				BigDecimal now = contractConditionList.get(0);
				
				BigDecimal sum = now.subtract(his);
				/** 调息-凭证-开始*/
				
				contractChargeService.createVoucherInterest(contractInfo, sum);
				
				/** 调息-凭证-结束*/
			}
			
		}
		
		
		// 将央行基准利率表是否调息结束 改称是
		// String adjustid = variablesMap.get("adjustid");
		// FundStandardInterest fundStandardInterest = this.tableService.findEntityByID(FundStandardInterest.class,
		// adjustid);
		// fundStandardInterest.setIsClose("0");
		// this.tableService.updateEntity(fundStandardInterest);
		
	}

	/**
	 * 将正式表数据插入到历史表 将状态改为 ‘后’ 类型改为‘调息’
	 * 
	 * @param variablesMap
	 * @param tableService2
	 * @throws Exception
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	private void addFundFundAdjustInterestContractToAdjustInterestContractHis(Map<String, String> variablesMap, TableService tableService2) throws Exception {
		String faictid = "";
		String doc_id = "";
		String checkedData = variablesMap.get("json_current_regulating_of_breathing_str");
		JSONArray jsonArray = new JSONArray(checkedData);
		JSONObject jsonObj = null;
		FundAdjustInterestContractTemp faict = null;
		FundAdjustInterestContractHis faich = null;
		for (int i = 0; i < jsonArray.length(); i++) {
			jsonObj = jsonArray.getJSONObject(i);
			faictid = jsonObj.getString("faictid");
			doc_id = variablesMap.get("flowunid");
			faict = tableService2.findEntityByID(FundAdjustInterestContractTemp.class, faictid);
			faich = new FundAdjustInterestContractHis();
			BeanUtils.copyProperties(faict, faich);
			faich.setDocId(doc_id);
			faich.setStatus("his_status_after");
			faich.setModReason("his_rate_change");
			tableService2.saveEntity(faich);
		}
		emptyTheVariable(faictid, doc_id, checkedData, jsonArray, jsonObj, faict, variablesMap, tableService2);
	}

	/**
	 * 清空对象
	 * 
	 * @param obj
	 */
	private void emptyTheVariable(Object... obj) {
		if (obj != null) {
			for (Object o : obj) {
				if (o != null) {
					o = null;
				}
			}
		}
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

}
