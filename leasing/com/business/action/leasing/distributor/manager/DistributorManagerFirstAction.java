package com.business.action.leasing.distributor.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.CustInfoDealer;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
/**
 * 
 * @author 徐云龙
 * @date 2013-6-24上午17:55:13
 * @info 经销商准入申请
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "distributorManagerFirstAction", description = "流程第一步动作", workflowName = "经销商申请")
@Component(value = "distributorManagerFirstAction")
public class DistributorManagerFirstAction implements JbpmBaseAction {
	@Resource(name="tableService")
	private TableService baseService;

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
		
	}
	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String cust_id=variablesMap.get("cust_info.id");
		CustInfo custinfo=(CustInfo)this.baseService.findEntityByID(CustInfo.class, cust_id);
		String contractnum=variablesMap.get("dealer_approval_info.contractnum");
		String HQL="from CustInfoDealer ci where ci.custId.id<>? and ci.contractNum=?";
		System.out.println(cust_id+":"+contractnum);
		List<CustInfoDealer> cilist=new ArrayList<CustInfoDealer>();
		cilist=this.baseService.findResultsByHSQL(HQL, cust_id,contractnum);
		if(cilist.size()>0){
			CustInfoDealer ci=cilist.get(0);
			return "合作经销商编号:"+contractnum+"和经销商("+ci.getCustId().getCustName()+")重复";
		}else{
		  return "";
		}
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
