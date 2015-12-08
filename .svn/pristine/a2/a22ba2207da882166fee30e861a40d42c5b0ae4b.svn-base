package com.business.action.leasing.nocar.cancel;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.proj.ProjInfo;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.business.entity.JBPMWorkflowHistoryInfo;

@WorkflowAction(name = "nocarCancelEditAction", description = "流程修改动作", workflowName = "设备撤销流程")
@Component(value = "nocarCancelEditAction")
public class NocarCancelEditAction implements JbpmBaseAction {
	@Resource(name="baseService")
	private BaseService baseService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String proj_id = variablesMap.get("proj_info.proj_id");
		Map<String,Object> propertiesMap = new  HashMap<String,Object>();
		propertiesMap.put("proj_id",proj_id);
		ProjInfo projInfo =(ProjInfo)this.baseService.getNewOrUpdateObject(ProjInfo.class, propertiesMap);
		//将work_flag赋值为0（1：流程中 0：非流程中）
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_ON);
		this.baseService.updateEntity(projInfo);
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		this.save(request, variablesMap,jbpmWorkflowHistoryInfo);
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	
	 /**
	 * (non-Javadoc)
	 * @see com.business.action.JbpmBaseAction#back(javax.servlet.http.HttpServletRequest, java.util.Map)
	 **/
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
