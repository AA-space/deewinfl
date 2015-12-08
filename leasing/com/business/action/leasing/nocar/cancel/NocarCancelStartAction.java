package com.business.action.leasing.nocar.cancel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoCompany;
import com.business.entity.cust.CustInfoPerson;
import com.business.entity.cust.CustInfoRelatedPerson;
import com.business.entity.proj.ProjCreditResult;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.ProjMeetingRecord;
import com.business.entity.proj.ProjOtherInfo;
import com.business.entity.proj.reckon.ProjFundRentPlan;
import com.business.entity.util.OwnInfo;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.serviceImpl.reckon.RentCalculateServiceImpl;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.business.entity.JBPMWorkflowHistoryInfo;
/**
 * 
 * @author 蔡雅超
 * @date 2013-7-15
 * @info项目撤销的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "nocarCancelStartAction", description = "流程开始动作", workflowName = "设备撤销流程")
@Component(value = "nocarCancelStartAction")
public class NocarCancelStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		Logger logger=Logger.getLogger(NocarCancelStartAction.class.getName());
		String proj_id = variablesMap.get("proj_id");
		ProjInfo projInfo = (ProjInfo) this.tableService.findEntityByID(ProjInfo.class, proj_id);
		//更新状态为流程进行中
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_ON);
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo,null, "proj_info"));
		if(projInfo.getProjOtherInfo()!=null){
		 	  variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo.getProjOtherInfo(),null, "proj_other_info"));
		}
		//客户信息
		CustInfo custInfo=projInfo.getCustId();
		if(custInfo!=null){
		variablesMap.put("proj_info.custname", custInfo.getCustName());
		variablesMap.put("proj_info.custnumber", custInfo.getCustNumber());
		variablesMap.put("proj_info.custid", custInfo.getId());
		variablesMap.put("proj_info.cust_type", custInfo.getCustClass().getCode().equals("CUST_INFO_COMPANY")?"法人":"自然人");
		variablesMap.put("cust_info.custclass", custInfo.getCustClass().getName());//动态显示
		}else{
			logger.info("custInfo对象为空");
		}
		CustInfoCompany company=custInfo.getCustInfoCompany();
		if(company!=null){
		if(custInfo.getCustClass().getCode()!=null){
		if(custInfo.getCustClass().getCode().toUpperCase().equals("CUST_INFO_COMPANY")){//法人信息
			variablesMap.put("cust_info_company.legalrepresentative", company.getLegalRepresentative() != null ? company.getLegalRepresentative() : "");
			variablesMap.put("cust_info_company.taxregadd", company.getTaxRegAdd()!=null?company.getTaxRegAdd():"");
			variablesMap.put("cust_info_company.ownership", (company.getOwnership() == null) ? "" : company.getOwnership().getName());
			variablesMap.put("cust_info_company.custscale", (company.getCustScale() == null) ? "" : company.getCustScale().getName());
			//插入经销商
			variablesMap.put("proj_info.custdealer", (company.getDealerOrCompany() == null ? "" : company.getDealerOrCompany()));
		}
		Set<CustInfoRelatedPerson> custInfoRelatedPersons=custInfo.getRelatedPersons();
		for (Iterator<CustInfoRelatedPerson> iterator = custInfoRelatedPersons.iterator(); iterator.hasNext();)
		{
			CustInfoRelatedPerson custInfoRelatedPerson = iterator.next();
			if(custInfoRelatedPerson.getRelationship().getCode().toUpperCase().equals("RELATIONSHIP_CEO")){
				variablesMap.put("cust_related_person.name",custInfoRelatedPerson.getRelationship()!=null?custInfoRelatedPerson.getRelationship().getName():"");//总经理名字
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
		this.tableService.updateEntity(projInfo);
		//为了租金测算的通用性此处的名字不用contract_codition 而用framework_condition
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo.getProjCondition(),null, "framework_condition"));
		//设置租金测算参数为合同审批
		variablesMap.put("framework_condition.projid",projInfo.getProjId());
		variablesMap.put("framework_condition.contractid","");
		variablesMap.put("framework_condition.process", "proj_process");
		variablesMap.put("framework_condition.custname",custInfo.getCustName());
		variablesMap.put("framework_condition.custid",custInfo.getId());
		variablesMap.put("framework_condition.docid",jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"");
		variablesMap.put("framework_condition.onhireid","");
		//存入租金测算数据
		variablesMap.put("framework_condition.custname",custInfo.getCustName());
		variablesMap.put("proj_info.custid", custInfo.getId());
		variablesMap.put("framework_condition.projid",proj_id);
		variablesMap.put("framework_condition.docid",jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"");
		variablesMap.put("framework_condition.process","proj_process");
		//项目其它信息
		Map<String,String> queryMainObjectMap = new HashMap<String,String>();
		queryMainObjectMap.put("proj_id", proj_id);
		// 租金发票类型
		JSONObject jsonObject = this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_invoice_type.xml", queryMainObjectMap).getJSONObject(0);
	    Iterator<?> it = jsonObject.keys();
		while(it.hasNext()){
			String key = (String)it.next();
			variablesMap.put("proj_invoice_type." + key,jsonObject.get(key).toString());
		};
	    if(!projInfo.getProjEquips().isEmpty()) {// 租赁物明细
			variablesMap.put("json_proj_equip_str", this.tableService.getJsonArrayData("eleasing/workflow/nocar/nocar_equip.xml", queryMainObjectMap).toString());
		}
		if (!projInfo.getProjGuaranteeMethods().isEmpty()) {// 担保单位
			variablesMap.put("json_proj_guarantee_method_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_guarantee_method.xml", queryMainObjectMap).toString());
		}
		//因为这里是按照XML配置查询 所以在合同审批发起的时候数据是从项目表来的 所以这里的xml配置的是项目的XML
		if (!projInfo.getProjFundRentPlans().isEmpty()) {//租金计划
			variablesMap.put("json_fund_rent_plan_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_fund_rent_plan.xml", queryMainObjectMap).toString());
		}
		if (!projInfo.getProjCashDetails().isEmpty()) {//合同现金流
			variablesMap.put("json_fund_cash_flow_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_fund_cash_flow.xml", queryMainObjectMap).toString());
		}
		//股东构成
		Map<String,String> queryObjectMap = new HashMap<String,String>();
		queryObjectMap.put("cust_id", custInfo.getId());
		variablesMap.put("json_stockholder_info_str", this.tableService.getJsonArrayData("eleasing/workflow/stockholder/stockholder_info.xml", queryObjectMap).toString());
		//生成资金计划
		if (!projInfo.getProjFundFundPlans().isEmpty()) {//项目资金计划
			variablesMap.put("json_fund_fund_charge_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_fund_fund_plan.xml", queryMainObjectMap).toString());
		}
	}
	 

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

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
