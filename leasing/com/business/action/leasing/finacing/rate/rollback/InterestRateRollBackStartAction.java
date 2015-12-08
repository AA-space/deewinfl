package com.business.action.leasing.finacing.rate.rollback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.cash.ContractCashDetail;
import com.business.entity.contract.reckon.cash.ContractCashDetailTemp;
import com.business.entity.contract.reckon.cash.ContractFinaCashDetail;
import com.business.entity.contract.reckon.cash.ContractFinaCashDetailTemp;
import com.business.entity.contract.reckon.condition.ContractConditionTemp;
import com.business.entity.contract.reckon.fina.ContractFinaRentPlan;
import com.business.entity.contract.reckon.fina.ContractFinaRentPlanTemp;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.contract.reckon.fund.ContractFundRentPlanTemp;
import com.business.entity.contract.reckon.fund.FundAdjustInterestContract;
import com.business.entity.contract.reckon.fund.FundAdjustInterestContractTemp;
import com.business.entity.interest.FundStandardInterest;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.util.WorkflowUtil;
import com.google.common.collect.Maps;
import com.kernal.annotation.WorkflowAction;

@WorkflowAction(name = "interestRateRollBackStartAction", description = "流程开始动作", workflowName = "调息回滚流程")
@Component(value = "interestRateRollBackStartAction")
public class InterestRateRollBackStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// 如果有相同记录删除调息记录表，再插入一条新的
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String flowunid = String.valueOf(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid());
		// 1.央行信息表
		FundStandardInterest fajc = (FundStandardInterest) this.tableService.findEntityByID(FundStandardInterest.class, variablesMap.get("id"));
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(fajc, null, "fund_standard_interest"));
		variablesMap.put("adjustid", variablesMap.get("id"));
		variablesMap.put("keyword_workflowid", flowunid);
		variablesMap.put("docid", flowunid);

	}
}
