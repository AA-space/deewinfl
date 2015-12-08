package com.business.action.leasing.finacing.rate;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.action.leasing.contract.approval.ContractApprovalStartAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.cash.ContractCashDetail;
import com.business.entity.contract.reckon.cash.ContractCashDetailTemp;
import com.business.entity.contract.reckon.cash.ContractFinaCashDetail;
import com.business.entity.contract.reckon.cash.ContractFinaCashDetailTemp;
import com.business.entity.contract.reckon.condition.ContractConditionTemp;
import com.business.entity.contract.reckon.fina.ContractFinaRentPlan;
import com.business.entity.contract.reckon.fina.ContractFinaRentPlanTemp;
import com.business.entity.contract.reckon.fund.ContractFundRentInComeTemp;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.contract.reckon.fund.ContractFundRentPlanTemp;
import com.business.entity.contract.reckon.fund.FundAdjustInterestContract;
import com.business.entity.contract.reckon.fund.FundAdjustInterestContractTemp;
import com.business.entity.interest.FundStandardInterest;
import com.business.entity.proj.ProjInfo;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.ctc.wstx.util.DataUtil;
import com.google.inject.internal.Lists;
import com.google.inject.internal.Maps;
import com.google.inject.internal.Sets;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;
import com.kernal.utils.MathUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.SecurityUtil;
import com.kernal.utils.StringUtil;
import com.kernal.utils.xml.ConvertUtil;

@WorkflowAction(name = "interestRateEditAction", description = "流程编辑动作", workflowName = "调息流程")
@Component(value = "interestRateEditAction")
public class InterestRateEditAction implements JbpmBaseAction {

	@Resource(name = "tableService")
	private TableService tableService;

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String workFlowFlags = variablesMap.get("workFlowFlag");
		if (StringUtils.isNotEmpty(workFlowFlags)) {
			/** 流程冲突第二步-结束 */
			List<WorkFlowFlag> workFlags = this.tableService.findEntityByIDArray(WorkFlowFlag.class, workFlowFlags.split(","));
			this.tableService.removeAllEntites(workFlags);
			/** 流程冲突第二步-结束 */
		}
	}

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// addObjectToFundAdjustInterestContractTemp(variablesMap, this.tableService);
		Map<String,Object> properMap = Maps.newHashMap();
		properMap.put("docId", variablesMap.get("docid"));
		List<FundAdjustInterestContractTemp> adjustTempList = this.tableService.findEntityByProperties(FundAdjustInterestContractTemp.class, properMap);
		

		List<String> contractIdList = Lists.newArrayList();
		List<String> contractIdListInPoint = Lists.newArrayList();

		Set<String> contractIdSet = Sets.newHashSet();
		Set<String> contractIdSetInPoint = Sets.newHashSet();
		for (int i = 0; i < adjustTempList.size(); i++) {
			FundAdjustInterestContractTemp adjustTemp = adjustTempList.get(i);
			String contract_id = adjustTemp.getContractId().getId();
			contractIdSet.add(contract_id);
			contractIdSetInPoint.add("'" + contract_id + "'");
		}
		contractIdList.addAll(contractIdSet);
		contractIdListInPoint.addAll(contractIdSetInPoint);
		String contractIdStrs = contractIdListInPoint.toString();

		/**
		 * 流程冲突共三步 1、起始位置添加第一步，如**startAction 2、删除流程实例时添加第二部 ,**startAction中delete方法 3、结束流程里添加第三步, 例**endAction中添加
		 * 注意：例如经销资金收款中，第一步插入冲突表时，需要插入多个，不需要第二步，第三步也需要删除多个 workFlowFlag插入时已逗号分隔。
		 * 
		 * 流程冲突第一步-开始
		 */
		String workFlowName = jbpmWorkflowHistoryInfo.getWorkflowName();

		// 查询冲突
		String hql = "SELECT new Map(WF.workNumber as workNumber, WF.workFlowName as workFlowName,WF.workFlowInstance AS workFlowInstance, WF.beginUser AS beginUser, WF.workNumber AS workNumber) FROM  WorkFlowFlag AS WF , ExclusionInfo AS EI  WHERE WF.workFlowName = EI.workFlowNameB AND EI.workFlowNameA = '"
				+ workFlowName + "' AND WF.workNumber in (" + contractIdStrs.substring(1, contractIdStrs.length() - 1) + ")";
		List<Map<String, String>> workFlowFlagList = this.tableService.findResultsByHSQL(hql);
		if (workFlowFlagList.size() > 0) {
			Map<String, String> workFlowInfoMap = workFlowFlagList.get(0);
			User beginUser = this.tableService.findEntityByID(User.class, workFlowInfoMap.get("beginUser"));
			String workFlowNameB = workFlowInfoMap.get("workFlowName");
			String workNumber = workFlowInfoMap.get("workNumber");

			ContractInfo contractInfo = this.tableService.findEntityByID(ContractInfo.class, workNumber);

			throw new BusinessException("【" + contractInfo.getContractNumber() + "】与【" + workFlowNameB + "】流程不能同时发起,请与流程发起人:【" + beginUser.getRealname() + "】联系查看详情");
		}

		List<String> workFlowFlagsList = Lists.newArrayList();
		String workFlowFlags = "";
		for (int i = 0; i < contractIdList.size(); i++) {
			// 将本条流程记录插入到冲突表
			WorkFlowFlag workFlowFlag = new WorkFlowFlag();
			workFlowFlag.setBeginUser(SecurityUtil.getPrincipal().getId());
			workFlowFlag.setStatus(1);
			workFlowFlag.setWorkFlowInstance(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid() + "");
			workFlowFlag.setWorkFlowName(workFlowName);
			workFlowFlag.setWorkNumber(contractIdList.get(i));
			this.tableService.saveEntity(workFlowFlag);

			workFlowFlagsList.add(workFlowFlag.getId());

		}

		workFlowFlags = workFlowFlagsList.toString();
		workFlowFlags = workFlowFlags.substring(1, workFlowFlags.length() - 1);

		variablesMap.put("workFlowFlag", workFlowFlags.replaceAll(" ", ""));

		/** 流程冲突第一步-结束 */
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

		
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

}
