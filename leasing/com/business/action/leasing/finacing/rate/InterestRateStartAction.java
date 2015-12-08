package com.business.action.leasing.finacing.rate;

import java.net.URLDecoder;
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
import com.business.action.leasing.contract.approval.ContractApprovalStartAction;
import com.business.controller.adjustInterest.AdjustInterestController;
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
import com.business.entity.proj.ProjInfo;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.util.WorkflowUtil;
import com.google.common.collect.Maps;
import com.kernal.annotation.WorkflowAction;

@WorkflowAction(name = "interestRateStartAction", description = "流程开始动作", workflowName = "调息流程")
@Component(value = "interestRateStartAction")
public class InterestRateStartAction implements JbpmBaseAction{
	@Resource(name = "tableService")
	private TableService tableService;
	
//	@Resource(name = "adjustInterestController")
//	private AdjustInterestController adjustInterestController;
//	
	

	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
	}

	@Override
	public String delete(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

		return null;
	}

	@Override
	public void end(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//adjustInterestController.removeAdjustInterest(request);
	}

	@Override
	public String save(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String flowunid=String.valueOf(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid());
		variablesMap.put("Central_Bank_id", variablesMap.get("id"));
		variablesMap.put("flowunid", flowunid);
		//单选后得到合同进行央行调息记录
		FundStandardInterest fajc = (FundStandardInterest)this.tableService.findEntityByID(FundStandardInterest.class, variablesMap.get("id"));
		//央行信息表
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(fajc, null, "fund_standard_interest"));
		variablesMap.put("adjustid", variablesMap.get("id"));
		variablesMap.put("docid", flowunid);
		variablesMap.put("keyword_workflowid", flowunid);
		
	}

	

	
	
	
}
