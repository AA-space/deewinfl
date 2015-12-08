package com.business.action.leasing.nocar.file;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.action.leasing.nocar.change.NoCarChangeStartAction;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoCompany;
import com.business.entity.cust.CustInfoRelatedPerson;
import com.business.entity.proj.ProjInfo;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.business.entity.JBPMWorkflowHistoryInfo;
/**
 * 
 * @author 蔡雅超
 * @date 2013-8-21
 * @info项目资料补齐(设备)的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "nocarFileUpLoadStartAction", description = "流程开始动作", workflowName = "项目资料补齐(设备)")
@Component(value = "nocarFileUpLoadStartAction")
public class NocarFileUpLoadStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		Logger logger=Logger.getLogger(NoCarChangeStartAction.class.getName());	
		String proj_id = variablesMap.get("proj_id");//先获得proj_id
		ProjInfo projInfo = (ProjInfo) this.tableService.findEntityByID(ProjInfo.class, proj_id);
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_ON);//更新状态为流程进行中
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo,null, "proj_info"));//把项目的所有元素映射进来
	 	//客户信息
		CustInfo custInfo=projInfo.getCustId();
		variablesMap.put("proj_info.custname", custInfo.getCustName());
		variablesMap.put("proj_info.custnumber", custInfo.getCustNumber());
		variablesMap.put("proj_info.custid", custInfo.getId());
		variablesMap.put("proj_info.cust_type", custInfo.getCustClass().getCode().equals("CUST_INFO_COMPANY")?"法人":"自然人");
		variablesMap.put("cust_info.custclass", custInfo.getCustClass().getName());//动态显示
		//法人信息
		CustInfoCompany company=custInfo.getCustInfoCompany();
		if(company!=null){
			if(custInfo.getCustClass().getCode()!=null){
				if(custInfo.getCustClass().getCode().toUpperCase().equals("CUST_INFO_COMPANY")){//法人信息
						variablesMap.put("cust_info_company.legalrepresentative", company.getLegalRepresentative() != null ? company.getLegalRepresentative() : "");
						variablesMap.put("cust_info_company.taxregadd", company.getTaxRegAdd()!=null?company.getTaxRegAdd():"");
						variablesMap.put("cust_info_company.ownership", (company.getOwnership() == null) ? "" : company.getOwnership().getName());
						variablesMap.put("cust_info_company.custscale", (company.getCustScale() == null) ? "" : company.getCustScale().getName());
						//插入经销商
						if(projInfo.getCustDealer() != null){
							variablesMap.put("proj_info.custdealer", projInfo.getCustDealer().getId());
						} else {
							variablesMap.put("proj_info.custdealer", (company.getDealerOrCompany() == null ? "" : company.getDealerOrCompany()));
						}
					
				}
				Set<CustInfoRelatedPerson> custInfoRelatedPersons=custInfo.getRelatedPersons();
				for (Iterator<CustInfoRelatedPerson> iterator = custInfoRelatedPersons.iterator(); iterator.hasNext();)
				{
					CustInfoRelatedPerson custInfoRelatedPerson = iterator.next();
					if(custInfoRelatedPerson.getRelationship().getCode().toUpperCase().equals("RELATIONSHIP_CEO")){
						variablesMap.put("cust_related_person.name",custInfoRelatedPerson.getRelationship().getName());//总经理名字
						break;
					}
				}
		        variablesMap.put("cust_info_company.netassets",company.getNetAssets()!=null?company.getNetAssets().toString():"");//资产总额（净资产）
		 	    variablesMap.put("cust_info_company.bizscopeprimary", company.getBizScopePrimary()!=null?company.getBizScopePrimary():"");//主营
		 		variablesMap.put("cust_info_company.bizscopesecondary", company.getBizScopeSecondary()!=null?company.getBizScopeSecondary():"");//兼营
				}	
		}else{
			logger.info("company对象为空");
		}	
	}
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		

	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
