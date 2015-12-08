package com.business.action.leasing.finacing.rate.rollback;

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
import com.business.entity.contract.reckon.cash.ContractCashDetail;
import com.business.entity.contract.reckon.cash.ContractFinaCashDetail;
import com.business.entity.contract.reckon.fina.ContractFinaRentPlan;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.contract.reckon.fund.FundAdjustInterestContract;
import com.business.entity.contract.reckon.fund.FundAdjustInterestContractHis;
import com.business.entity.contract.reckon.fund.FundAdjustInterestContractTemp;
import com.business.entity.cust.CustInfo;
import com.business.entity.interest.FundStandardInterest;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.service.reckon.ConditionDataToHisService;
import com.business.service.tx.AjustInterestService;
import com.kernal.annotation.WorkflowAction;

@WorkflowAction(name = "interestRateRollBackEndAction", description = "流程结束动作", workflowName = "调息回滚流程")
@Component(value = "interestRateRollBackEndAction")
public class InterestRateRollBackEndAction implements JbpmBaseAction {

	@Resource(name = "tableService")
	private TableService tableService;

	@Resource(name = "conditionDataToHisService")
	private ConditionDataToHisService conditionDataToHisService;

	@Resource(name = "ajustInterestService")
	private AjustInterestService ajustInterestService;

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * #.回滚流程结束操作
	 */
	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		String workFlowFlags = variablesMap.get("workFlowFlag");
		if (StringUtils.isNotEmpty(workFlowFlags)) {
			/** 流程冲突第三步-结束 */
			List<WorkFlowFlag> workFlags = this.tableService.findEntityByIDArray(WorkFlowFlag.class, workFlowFlags.split(","));
			this.tableService.removeAllEntites(workFlags);
			/** 流程冲突第三步-结束 */
		}
		
		// 1.把调息记录临时表FUND_ADJUST_INTEREST_C_TEMP 的数据写入 FUND_ADJUST_INTEREST_CONTRACT
		this.ajustInterestService.updateFundAdjustInterestContract(variablesMap);
		variablesMap.put("table_for_his_type", "his_rate_change_back");
		// 2.把商务条件表数据写入历史表 CONTRACT_CONDITION -->CONTRACT_CONDITION_HIS
		// 历史表中字段MOD_STATUS值为 his_status_before 字段 MOD_REASON的值为his_rate_change
		// 3.租金计划表 CONTRACT_FUND_RENT_PLAN 和 现金流表 CONTRACT_CASH_DETAIL 同步骤2商务条件表的操作
		// 4.把商务条件临时表 CONTRACT_CONDITION_TEMP 的数据 更新到正式表CONTRACT_CONDITION
		// 5.把现金流临时表 CONTRACT_CASH_DETAIL_TEMP 的数据 更新到正式表CONTRACT_CASH_DETAIL
		/*
		 * 6.把租金计划临时表 CONTRACT_FUND_RENT_PLAN_TEMP 的数据 差异性写入 正式表CONTRACT_FUND_RENT_PLAN [差异性为
		 * 如果正式表中已有的期项做修改操作,正式表中没有的期项做新增操作,临时表没有正式表有的期项 做删除操作 如果删除操作因为外键关系删除失败则友好提示,并回滚数据]
		 */
		/*
		 * 7.把把商务条件临时表 CONTRACT_CONDITION_TEMP 的数据 更新到正式表>CONTRACT_CONDITION_HIS 历史表中字段MOD_STATUS值为 his_status_after 字段
		 * MOD_REASON的值为his_rate_change
		 */
		// 8.租金计划表临时表 CONTRACT_FUND_RENT_PLAN_TEMP 和 现金流表 CONTRACT_CASH_DETAIL_TEMP 同步骤7商务条件表的操作
		this.ajustInterestService.updateCopyTxAllTempToHis(variablesMap, this.conditionDataToHisService);
		// this.addFundFundAdjustInterestContractToAdjustInterestContractHis(variablesMap,this.tableService);
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

	/**
	 * 将临时表数据插入到正式表
	 * 
	 * @param variablesMap
	 * @param tService
	 * @throws Exception
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public void addFundAdjustInterestContractTempToFundAdjustInterestContract(Map<String, String> variablesMap, BaseService tService) throws Exception {
		String faictid = "";
		String doc_id = "";
		String checkedData = variablesMap.get("json_pranayama_to_roll_back_the_record_str");
		JSONArray jsonArray = new JSONArray(checkedData);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			faictid = jsonObj.getString("faictid");
			doc_id = variablesMap.get("flowunid");
			FundAdjustInterestContractTemp fundadjustinterestcontracttemp = tService.findEntityByID(FundAdjustInterestContractTemp.class, faictid);
			FundAdjustInterestContract faic = new FundAdjustInterestContract();
			BeanUtils.copyProperties(fundadjustinterestcontracttemp, faic);
			faic.setDocId(doc_id);
			tService.saveEntity(faic);

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
