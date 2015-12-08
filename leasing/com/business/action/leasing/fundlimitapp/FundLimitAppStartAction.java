package com.business.action.leasing.fundlimitapp;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.daoImpl.AbstractBaseDaoImpl;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.google.common.collect.Sets;
import com.google.inject.internal.Lists;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.SecurityUtil;

/**
 * @author Toybaby
 * 
 *         2012-12-26下午01:17:43 email toybaby@mail2.tenwa.com.cn function:
 * 
 */
@WorkflowAction(name = "fundLimitAppStartAction", description = "流程开始动作", workflowName = "合同投放额度申请流程")
@Component(value = "fundLimitAppStartAction")
public class FundLimitAppStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;

	private static Log log = LogFactory.getLog(AbstractBaseDaoImpl.class);

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		String json_fund_limit_str = variablesMap.get("json_fund_limit_str");
		JSONArray json_fund_limit_Array = new JSONArray(json_fund_limit_str);

		List<String> contractIdList = Lists.newArrayList();
		
		List<String> contractIdListInPoint = Lists.newArrayList();
		
		Set<String> contractIdSet = Sets.newHashSet();
		Set<String> contractIdSetInPoint = Sets.newHashSet();
 
		for (int i = 0; i < json_fund_limit_Array.length(); i++) {
			JSONObject  json_fund_limit_object = json_fund_limit_Array.optJSONObject(i);
			String contract_id = json_fund_limit_object.optString("contractid");
			contractIdSet.add(contract_id);
			contractIdSetInPoint.add("'" + contract_id + "'");
		}
		contractIdListInPoint.addAll(contractIdSetInPoint);
		contractIdList.addAll(contractIdSet);
		String contractIdStrs = contractIdListInPoint.toString();
		
		/**
		 * 流程冲突共三步
		 * 1、起始位置添加第一步，如**startAction
		 * 2、删除流程实例时添加第二部 ,**startAction中delete方法
		 * 3、结束流程里添加第三步, 例**endAction中添加
		 * 注意：例如经销资金收款中，第一步插入冲突表时，需要插入多个，不需要第二步，第三步也需要删除多个
		 * 		workFlowFlag插入时已逗号分隔。
		 * 
		 * 流程冲突第一步-开始*/
		String workFlowName = jbpmWorkflowHistoryInfo.getWorkflowName(); 
		
		//查询冲突 
		String hql = "SELECT new Map(WF.workNumber as workNumber, WF.workFlowName as workFlowName,WF.workFlowInstance AS workFlowInstance, WF.beginUser AS beginUser, WF.workNumber AS workNumber) FROM  WorkFlowFlag AS WF , ExclusionInfo AS EI  WHERE WF.workFlowName = EI.workFlowNameB AND EI.workFlowNameA = '"+workFlowName+"' AND WF.workNumber in ("+ contractIdStrs.substring(1, contractIdStrs.length()-1) +")";
		List<Map<String,String>> workFlowFlagList =  this.tableService.findResultsByHSQL(hql);
		if (workFlowFlagList.size() > 0){
			Map<String, String> workFlowInfoMap = workFlowFlagList.get(0);
			User beginUser = this.tableService.findEntityByID(User.class, workFlowInfoMap.get("beginUser"));
			String workFlowNameB = workFlowInfoMap.get("workFlowName");
			String workNumber = workFlowInfoMap.get("workNumber");
			
			ContractInfo contractInfo = this.tableService.findEntityByID(ContractInfo.class, workNumber);
			
			
			throw new BusinessException("【"+contractInfo.getContractNumber()+"】与【"+workFlowNameB+"】流程不能同时发起,请与流程发起人:【"+beginUser.getRealname()+"】联系查看详情");
		}
		
		List<String> workFlowFlagsList = Lists.newArrayList();
		String workFlowFlags = "";
		for (int i = 0; i < contractIdList.size(); i++) {
			//将本条流程记录插入到冲突表
			WorkFlowFlag workFlowFlag = new WorkFlowFlag();
			workFlowFlag.setBeginUser(SecurityUtil.getPrincipal().getId());
			workFlowFlag.setStatus(1);
			workFlowFlag.setWorkFlowInstance(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"");
			workFlowFlag.setWorkFlowName(workFlowName);
			workFlowFlag.setWorkNumber(contractIdList.get(i));
			this.tableService.saveEntity(workFlowFlag);
			
			workFlowFlagsList.add(workFlowFlag.getId());

		}
		
		workFlowFlags = workFlowFlagsList.toString();
		workFlowFlags  = workFlowFlags.substring(1,workFlowFlags.length()-1);
		
		variablesMap.put("workFlowFlag", workFlowFlags.replaceAll(" ", ""));

		/** 流程冲突第一步-结束*/
		
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.business.action.JbpmBaseAction#back(javax.servlet.http.HttpServletRequest, java.util.Map)
	 **/

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String workFlowFlags = variablesMap.get("workFlowFlag");
		
		if (StringUtils.isNotEmpty(workFlowFlags)) {
			/** 流程冲突第二步-结束*/
			List<WorkFlowFlag> workFlags = this.tableService.findEntityByIDArray(WorkFlowFlag.class, workFlowFlags.split(","));
			this.tableService.removeAllEntites(workFlags);
			/** 流程冲突第二步-结束*/
		}	
	}
}
