package com.business.action.leasing.project_nocar.approval_nocar;



import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjGuaranteeEquip;
import com.business.entity.proj.ProjGuaranteeMethod;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.exception.BusinessException;
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
 * @info项目立项的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "projApprovalNocarStartAction", description = "流程开始动作", workflowName = "项目立项非车业务")
@Component(value = "projApprovalNocarStartAction")
public class ProjApprovalNocarStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String cust_id = variablesMap.get("cust_id");
		CustInfo custInfo = (CustInfo) this.tableService.findEntityByID(
				CustInfo.class, cust_id);
		variablesMap.put("proj_info.custname", custInfo.getCustName());
		
		String proj_id = WorkflowUtil.getProjInfoSerialNumber(variablesMap,
				this.tableService.getBussinessDao().getHibernateTemplate(), this.tableService
				.getBussinessDao().getJdbcTemplate());
			
		variablesMap.put("proj_info.projid", proj_id);
		variablesMap.put("proj_info.custid", cust_id);
	    variablesMap.put("proj_info.projdate",DateUtil.getSystemDate());			
		variablesMap.put("proj_info.custnumber", custInfo == null ? "": custInfo.getCustNumber());
		variablesMap.put("proj_info.custclass",custInfo.getCustClass().getId());
		
		// 存入租金测算数据
		variablesMap.put("framework_condition.custname", custInfo
				.getCustName());
		variablesMap.put("framework_condition.custid", cust_id);
		variablesMap.put("framework_condition.projid", proj_id);
		variablesMap.put("framework_condition.docid",
				jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl()
						.getDbid()
						+ "");
		variablesMap.put("framework_condition.process", "proj_process");
		String mian = "mianfx01";
		DictionaryData fx = this.tableService.findEntityByID(DictionaryData.class,mian);
		if ( fx == null ) throw new BusinessException("请在数据字典中维护免罚息天数");
		variablesMap.put("framework_condition.freedefainterday",fx.getDescription());
		 
	}
	
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String proj_id = variablesMap.get("proj_id");// 先获得proj_id
		//删除流程冲突 
		 
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
