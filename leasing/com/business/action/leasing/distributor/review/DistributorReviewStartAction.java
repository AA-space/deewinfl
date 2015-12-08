package com.business.action.leasing.distributor.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.BaseDocumentConfig;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.cust.CustInfo;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.asset.AssetServer;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;

/**
 * 
 * @author 邱明
 * @date 2013-6-24上午17:55:13
 * @info 经销商准入评审
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "distributorReviewStartAction", description = "流程开始动作", workflowName = "经销商准入评审")
@Component(value = "distributorReviewStartAction")
public class DistributorReviewStartAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Resource(name = "assetServer")
	private AssetServer assetServer;

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		/** 流程冲突第二步-结束*/
		WorkFlowFlag w = this.assetServer.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
		this.assetServer.removeEntity(w);
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String cust_id = variablesMap.get("cust_id");
		String approvalNum=variablesMap.get("approvalnum");
		//
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
		String hql = "SELECT new Map(WF.workNumber as workNumber, WF.workFlowName as workFlowName,WF.workFlowInstance AS workFlowInstance, WF.beginUser AS beginUser) FROM  WorkFlowFlag AS WF , ExclusionInfo AS EI  WHERE WF.workFlowName = EI.workFlowNameB AND EI.workFlowNameA = '"+workFlowName+"' AND WF.workNumber = '"+ approvalNum +"'";
		List<Map<String,String>> workFlowFlagList =  this.assetServer.findResultsByHSQL(hql);
		if (workFlowFlagList.size() > 0){
			Map<String, String> workFlowInfoMap = workFlowFlagList.get(0);
			User beginUser = this.assetServer.findEntityByID(User.class, workFlowInfoMap.get("beginUser"));
			String workFlowNameB = workFlowInfoMap.get("workFlowName");;
			throw new BusinessException("该条流程与【"+workFlowNameB+"】流程不能同时发起,请与流程发起人:【"+beginUser.getRealname()+"】联系查看详情");
		}
		
		//将本条流程记录插入到冲突表
		WorkFlowFlag workFlowFlag = new WorkFlowFlag();
		workFlowFlag.setBeginUser(SecurityUtil.getPrincipal().getId());
		workFlowFlag.setStatus(1);
		workFlowFlag.setWorkFlowInstance(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"");
		workFlowFlag.setWorkFlowName(workFlowName);
		workFlowFlag.setWorkNumber(approvalNum);
		this.assetServer.saveEntity(workFlowFlag);

		variablesMap.put("workFlowFlag", workFlowFlag.getId());
		/** 流程冲突第一步-结束*/
		
		CustInfo custInfo=(CustInfo)this.baseService.findEntityByID(CustInfo.class, cust_id);
		variablesMap.put("cust_info.custname",custInfo.getCustName());
		variablesMap.put("cust_info.custnumber",custInfo.getCustNumber());
		variablesMap.put("cust_info.id", custInfo.getId());
		Map<String,String>classFieldMapping=new HashMap<String,String>();
		classFieldMapping.put("DictionaryData", "code");
		variablesMap.putAll(this.baseService.getEntityPropertiesToStringMap(custInfo.getCustInfoDealer(), classFieldMapping,"dealer_approval_info"));
		variablesMap.put("current_date", DateUtil.getSystemDate());
		variablesMap.put("dealer_approval_info.creditnum", approvalNum);
	  
	    /*
		//得到档案信息中的“现场考察经销商评审报告” 根节点信息 
		BaseDocumentConfig belongDocument = (BaseDocumentConfig) baseService.findEntityByID(BaseDocumentConfig.class, "level_one_code4");
		
		//得到档案信息中的“非现场考察经销商评审报告” 根节点信息 
		BaseDocumentConfig contractDocument = (BaseDocumentConfig) baseService.findEntityByID(BaseDocumentConfig.class, "level_one_code1");
		
		//所有节点及属性转为Json格式
		StringBuffer str_sb = new StringBuffer();
		belongDocument.toJsonString(belongDocument, str_sb);
		variablesMap.put("json_distributor_locale_report_str",str_sb.toString());
		
		StringBuffer str_sb2 = new StringBuffer();
		contractDocument.toJsonString(contractDocument, str_sb2);
		variablesMap.put("json_distributor_no_locale_report",str_sb2.toString());
		
		//System.out.println(str_sb);
		//request.setAttribute("belongDocument", belongDocument);
		 * 
		 */
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
