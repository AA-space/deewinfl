package com.business.action.leasing.nocar.reconsider;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.proj.ProjInfo;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
/**
 * 
 * @author 蔡雅超
 * @date 2013-7-22
 * @info设备复议的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "noCarConsiderEditAction", description = "流程修改动作", workflowName = "设备复议流程")
@Component(value = "noCarConsiderEditAction")
public class NoCarConsiderEditAction implements JbpmBaseAction{
	@Resource(name="baseService")
	private BaseService baseService;
	
	@Override
	public String delete(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//删除流程进行中状态
		ProjInfo projInfo = (ProjInfo) this.baseService.findEntityByID(ProjInfo.class, variablesMap.get("projInfo_id"));
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		return null;
	}
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void end(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String save(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
