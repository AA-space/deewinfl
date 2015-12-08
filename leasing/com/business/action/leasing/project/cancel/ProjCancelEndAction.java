package com.business.action.leasing.project.cancel;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.proj.ProjInfo;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;
/**
 * 
 * @author 蔡雅超
 * @date 2013-7-15
 * @info项目撤销的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "ProjCancelEndAction", description = "流程结束动作", workflowName = "项目立项撤销流程")
@Component(value = "ProjCancelEndAction")
public class ProjCancelEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
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
		
		String proj_id = variablesMap.get("proj_info.projid");
		Map<String,Object> propertiesMap = new  HashMap<String,Object>();
		propertiesMap.put("projId",proj_id);
		ProjInfo projInfo = (ProjInfo) this.baseService.getNewOrUpdateObject(ProjInfo.class, propertiesMap);
		
		User user = (User) SecurityUtil.getPrincipal();
		String systemDate = DateUtil.getSystemDateTime();
		String repeal_date=variablesMap.get("proj_info.repealdate");
		String repeal_reason=variablesMap.get("proj_info.repealreason");
		String repealreasontype=variablesMap.get("proj_info.repealreasontype");
		DictionaryData reasontype  = (DictionaryData) this.baseService.findEntityByID(DictionaryData.class, repealreasontype);
		if (null != projInfo.getId()) {
			projInfo.setModificator(user);
			projInfo.setModifyDate(systemDate);
			projInfo.setProjStatus(AppStaticUtil.PROJ_CANCEL);
			projInfo.setRepealDate(repeal_date);
			projInfo.setRepealReason(repeal_reason);
			projInfo.setRepealReasonType(reasontype);
			projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		}
		this.baseService.saveOrUpdateEntity(projInfo);
		//end
	}
	 
	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		

	}
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
