package com.business.action.leasing.project_nocar.projcancel_nocar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjGuaranteeEquip;
import com.business.entity.proj.ProjGuaranteeMethod;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.util.WorkflowUtil;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.DateUtil;

/**
 * 
 * @author rovine
 * @date 2014-8-18
 * @info项目撤销的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "projCancelNocarEndAction", description = "流程结束动作", workflowName = "项目撤销非车业务")
@Component(value = "projCancelNocarEndAction")
public class ProjCancelNocarEndAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
	}
	
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//String proj_id = variablesMap.get("proj_id");// 先获得proj_id
		//删除流程冲突 
		 
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
		String proj_id = variablesMap.get("proj_id");
		ProjInfo projInfo = this.tableService.findEntityByID(ProjInfo.class, proj_id);
		projInfo.setRepealDate(variablesMap.get("proj_info.repealdate"));
		projInfo.setRepealReason(variablesMap.get("proj_info.repealreason"));
		//数据字典
		String dict=variablesMap.get("proj_info.dictionarydatabyrepealreasontype");
		DictionaryData dict1=this.tableService.findEntityByID(DictionaryData.class,dict );
		projInfo.setRepealReasonType(dict1);
		//项目撤销
		projInfo.setProjStatus(AppStaticUtil.PROJ_CANCEL);
		this.tableService.saveOrUpdateEntity(projInfo);
		
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
	}
}
