package com.business.action.leasing.distributor.mortgagerecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.Department;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.ContractInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.DealerDeptInfo;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;

/**
 * 
 * @author 徐云龙
 * @date 2013-8-10上午17:55:13
 * @info 经销商抵押合同事宜办理流程
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "distributorMortgageRecordStartAction", description = "流程开始动作", workflowName = "抵押备案信息")
@Component(value = "distributorMortgageRecordStartAction")
public class DistributorMortgageRecordStartAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
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
		String deptid=variablesMap.get("cur_depid");
		List dilist=new ArrayList();
		Map<String,Object>propertiesMap=new HashMap<String,Object>(); 
		Department dt=this.baseService.findEntityByID(Department.class, deptid);
		propertiesMap.put("dealerDept", dt);
		dilist=this.baseService.findEntityByProperties(DealerDeptInfo.class, propertiesMap);
		if(dilist.size()>0){
			DealerDeptInfo di=(DealerDeptInfo)dilist.get(0);
			CustInfo ci=di.getCustId();
			variablesMap.put("dealerguaranteeinfo.dealername1", ci.getId());
			variablesMap.put("cust_info.custname", ci.getCustName());
		}
	
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
