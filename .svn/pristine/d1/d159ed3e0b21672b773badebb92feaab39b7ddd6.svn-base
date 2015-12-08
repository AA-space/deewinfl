package com.business.action.leasing.distributor.review;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.CustInfoDealer;
import com.business.entity.dealer.DealerApprovalInfo;
import com.business.entity.dealer.DealerCreditInfo;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
/**
 * 
 * @author 邱明
 * @date 2013-6-24上午17:55:13
 * @info 经销商准入评审
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "distributorReviewEndAction", description = "流程结束动作", workflowName = "经销商准入评审")
@Component(value = "distributorReviewEndAction")
public class DistributorReviewEndAction implements JbpmBaseAction {
	@Resource(name="tableService")
	private TableService baseService;
	@Resource(name = "tableService")
	private TableService tableService;

	/*
	 * public ProjApprovalEndAction(){ this.baseService =
	 * (ProjApprrovalDao)WebUtil.getApplicationContext().getBean("baseService"); }
	 */
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */
		//1.更新申请表
		//根据申请是否过来插额度表
		 String flowunid=String.valueOf(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid());
		    
		String cust_id=variablesMap.get("cust_info.id");
		CustInfo custinfo=(CustInfo)this.baseService.findEntityByID(CustInfo.class, cust_id);
		String approvalNum=variablesMap.get("dealer_approval_info.creditnum");
		Map<String,Object> propertiesMap=new HashMap<String,Object>();
		Map<String,String>classFieldMapping=new HashMap<String,String>();
		classFieldMapping.put("DictionaryData", "code");
		classFieldMapping.put("CustInfo", "id");
		classFieldMapping.put("Department", "id");
		variablesMap.put("dealer_apptocridet_info.custId", custinfo.getId());
		variablesMap.put("dealer_credit_info.custId", custinfo.getId());
		propertiesMap.put("approvalNum", approvalNum);
		System.out.println(variablesMap.toString());
		String dealerStatus=variablesMap.get("dealer_approval_info.dealerStatus");
		System.out.println(dealerStatus);
		if(dealerStatus.equalsIgnoreCase("conform")){variablesMap.put("dealer_approval_info.dealerStatus", "dealerApprovalstatus4");}
		if(dealerStatus.equalsIgnoreCase("noconform")){variablesMap.put("dealer_approval_info.dealerStatus", "dealerApprovalstatus5");}                                                                                             
		
		//1.更新经销商准入表
		DealerApprovalInfo di=(DealerApprovalInfo)this.baseService.updateMainEntity(DealerApprovalInfo.class, propertiesMap, variablesMap, classFieldMapping, "dealer_approval_info");
		//更新合作编号
		CustInfoDealer dealer=custinfo.getCustInfoDealer();
		if(variablesMap.get("dealer_approval_info.contractnum") != null) {
			dealer.setContractNum(variablesMap.get("dealer_approval_info.contractnum").trim());
			this.baseService.updateEntity(dealer);
		}
		
		if(dealerStatus.equals("conform")){
			  //2.插入授信额度，把数据库中已有的授信设为历史
		    String HQL="update DealerCreditInfo di set di.isNow=1 where di.custId.id='"+cust_id+"'";
		    this.baseService.getBussinessDao().getHibernateTemplate().bulkUpdate(HQL);
		    propertiesMap.clear();
		    propertiesMap.put("custId", null);
		    variablesMap.put("dealer_credit_info.isnow", "0");
		    variablesMap.put("dealer_credit_info.docid",flowunid);
		    DealerCreditInfo dci=(DealerCreditInfo)this.baseService.updateMainEntity(DealerCreditInfo.class, propertiesMap, variablesMap, classFieldMapping, "dealer_credit_info");
		}
		//保存考察报告
		Map<String, String> map=new HashMap<String, String>();
		String  docReportStr="";
		JSONObject savedDataJsonObj;
		Iterator<String> iter;
		if(variablesMap.get("reporttype").equalsIgnoreCase("1")){
		   //现场考察报告
		    docReportStr = variablesMap.get("json_dealer_local_report_str");
		    savedDataJsonObj = new JSONObject(docReportStr);  
		    iter =  savedDataJsonObj.keys();
		    while(iter.hasNext()){
			   String key = iter.next();
			   map.put(key,  savedDataJsonObj.getString(key).toString());
		    }  
		    this.baseService.savedTree2TableData(map.get("savedDataKey").toString(),map.get("valuesMapping").toString(),map);
		}else{
			//非现场考察报告
	        map=new HashMap<String, String>();
		    docReportStr = variablesMap.get("json_dealer_notlocal_report_str");
	        savedDataJsonObj = new JSONObject(docReportStr);  
		    iter =  savedDataJsonObj.keys();
		    while(iter.hasNext()){
			   String key = iter.next();
			   map.put(key,  savedDataJsonObj.getString(key).toString());
		    }
		   this.baseService.savedTree2TableData(map.get("savedDataKey").toString(),map.get("valuesMapping").toString(),map);
		}
		variablesMap.put("dealer_approval_info.dealerStatus", dealerStatus);
		
		//throw new BusinessException("111");
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
