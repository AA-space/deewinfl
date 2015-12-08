package com.business.action.leasing.distributor.relemortgagecontract;

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
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.DealerDeptInfo;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;

/**
 * 
 * @author Rovine
 * @date 2013-8-10上午17:55:13
 * @info 经销商解押合同事宜办理流程
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "distributorReleMortgageContractStartAction", description = "经销商解除抵押合同管理", workflowName = "经销商解除抵押合同管理")
@Component(value = "distributorReleMortgageContractStartAction")
public class DistributorReleMortgageContractStartAction implements JbpmBaseAction {
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
		
		Map<String,Object> propertiesMap=new HashMap<String,Object>(); 
		
		Department dt=this.baseService.findEntityByID(Department.class, deptid);
//		Map<String,String> propertiesMapString=new HashMap<String,String>();
		propertiesMap.put("dealerDept", dt);
		dilist=this.baseService.findEntityByProperties(DealerDeptInfo.class, propertiesMap);
		if(dilist.size()>0){
			DealerDeptInfo di=(DealerDeptInfo)dilist.get(0);
			CustInfo ci=di.getCustId();
			variablesMap.put("cust_info.id", ci.getId());
			variablesMap.put("cust_info.custname", ci.getCustName());
			System.out.println(ci.getCustName());
//		    propertiesMapString.put("cust_id",ci.getId());
//		    System.out.println(ci.getId());
//			variablesMap.put("json_mortgage_info_str", this.tableService.getJsonArrayData("eleasing/workflow/distributor/distributor_released_mortgage_contract.xml", propertiesMapString).toString());
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
