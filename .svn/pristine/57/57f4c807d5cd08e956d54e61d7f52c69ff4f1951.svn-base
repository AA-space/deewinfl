package com.business.action.leasing.other;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.SecurityUtil;

/**
 * 
 * @author 蔡雅超
 * @date 2013-8-31
 * @info收车评估的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "vehicleEvaluationStartAction", description = "流程开始动作", workflowName = "收车评估流程")
@Component(value = "vehicleEvaluationStartAction")
public class VehicleEvaluationStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
			Logger logger = Logger.getLogger(VehicleEvaluationStartAction.class.getName()); 
			String id= variablesMap.get("id");  
			
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
			String hql = "SELECT new Map(WF.workNumber as workNumber, WF.workFlowName as workFlowName,WF.workFlowInstance AS workFlowInstance, WF.beginUser AS beginUser) FROM  WorkFlowFlag AS WF , ExclusionInfo AS EI  WHERE WF.workFlowName = EI.workFlowNameB AND EI.workFlowNameA = '"+workFlowName+"' AND WF.workNumber = '"+ id +"'";
			List<Map<String,String>> workFlowFlagList =  this.tableService.findResultsByHSQL(hql);
			if (workFlowFlagList.size() > 0){
				Map<String, String> workFlowInfoMap = workFlowFlagList.get(0);
				User beginUser = this.tableService.findEntityByID(User.class, workFlowInfoMap.get("beginUser"));
				String workFlowNameB = workFlowInfoMap.get("workFlowName");
				throw new BusinessException("该条流程与【"+workFlowNameB+"】流程不能同时发起,请与流程发起人:【"+beginUser.getRealname()+"】联系查看详情");
			}
			
			//将本条流程记录插入到冲突表
			WorkFlowFlag workFlowFlag = new WorkFlowFlag();
			workFlowFlag.setBeginUser(SecurityUtil.getPrincipal().getId());
			workFlowFlag.setStatus(1);
			workFlowFlag.setWorkFlowInstance(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"");
			workFlowFlag.setWorkFlowName(workFlowName);
			workFlowFlag.setWorkNumber(id);
			this.tableService.saveEntity(workFlowFlag);

			variablesMap.put("workFlowFlag", workFlowFlag.getId());
			/** 流程冲突第一步-结束*/
			
			if(id!=null){
				try {
					ContractInfo contractInfo=(ContractInfo)this.tableService.findEntityByID(ContractInfo.class,id);
//					System.out.println(contractInfo.getContractId());
					variablesMap.put("contract_equip_revoke.contractid", contractInfo.getContractId());
//					System.out.println(variablesMap.get("contract_equip_revoke.contractid"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				logger.info("contract_id未能获得");
			}
		
	}
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		/** 流程冲突第二步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第二步-结束 */
		
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
	}
}
