package com.business.action.leasing.project_nocar.projreconsider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.BusException;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjCreditResult;
import com.business.entity.proj.ProjGuaranteeEquip;
import com.business.entity.proj.ProjGuaranteeMethod;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.entity.proj.reckon.ProjCashDetail;
import com.business.entity.proj.reckon.ProjFundFundPlan;
import com.business.entity.proj.reckon.ProjFundRentPlan;
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
 * @info项目撤销的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "projReconsideNocarEndAction", description = "流程结束动作", workflowName = "项目复议非车业务")
@Component(value = "projReconsideNocarEndAction")
public class ProjReconsideNocarEndAction implements JbpmBaseAction {
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
		String proj_id = variablesMap.get("proj_id");
		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.baseService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.baseService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */
		ProjInfo projInfo = this.tableService.findEntityByID(ProjInfo.class, proj_id);
		//设置项目为立项完成状态
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		//保存信审结论
		ProjCreditResult pcr=new ProjCreditResult();
	    pcr.setProjId(projInfo);
	    DictionaryData creditResultType=this.baseService.findEntityByID(DictionaryData.class, variablesMap.get("proj_info_credittype"));
	    pcr.setCreditResultType(creditResultType);
	    pcr.setProjCreditPassTime(variablesMap.get("proj_credit_re_result.projcreditpasstime"));
	    pcr.setCreditConclusion(variablesMap.get("proj_credit_re_result.creditconclusion"));
		pcr.setFlowName(jbpmWorkflowHistoryInfo.getWorkflowName());
		this.baseService.saveOrUpdateEntity(pcr);
		
		//德银新需求，业务合同号在信审结束后生成,信审通过才分配合同号
		String contract_number="";
		if("credit_type_@12".equals(variablesMap.get("proj_info_credittype"))){
			projInfo.setProjStatus(12);
		}//复议
		if("credit_type_@103".equals(variablesMap.get("proj_info_credittype"))){
			projInfo.setProjStatus(103);
		}//否决
		if("credit_type_@11".equals(variablesMap.get("proj_info_credittype"))){
		   if ( "lease_form2".equals(projInfo.getLeasForm().getCode()) )
		   {//加回租判断
			   contract_number = WorkflowUtil.getContractInfoSerialNumberForBussiness2(variablesMap,this.tableService.getBussinessDao().getHibernateTemplate(), this.tableService.getBussinessDao().getJdbcTemplate());
		   }else
		   {
			   contract_number = WorkflowUtil.getContractInfoSerialNumberForBussiness(variablesMap,this.tableService.getBussinessDao().getHibernateTemplate(), this.tableService.getBussinessDao().getJdbcTemplate());
		   }
		   projInfo.setContractNumber(contract_number);
		   projInfo.setProjStatus(11);//信审通过
		}
		this.baseService.saveOrUpdateEntity(projInfo);
		
		//throw new BusinessException("");
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
