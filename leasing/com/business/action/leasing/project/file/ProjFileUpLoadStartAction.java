package com.business.action.leasing.project.file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.action.leasing.project.credit.ProjCreditStartAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.reckon.cash.ContractCashDetailTemp;
import com.business.entity.contract.reckon.cash.ContractFinaCashDetailTemp;
import com.business.entity.contract.reckon.condition.ContractConditionTemp;
import com.business.entity.contract.reckon.fina.ContractFinaRentPlanTemp;
import com.business.entity.contract.reckon.fund.ContractFundRentPlanTemp;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoCompany;
import com.business.entity.cust.CustInfoPerson;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.reckon.ProjCashDetail;
import com.business.entity.proj.reckon.ProjFinaCashDetail;
import com.business.entity.proj.reckon.ProjFinaRentPlan;
import com.business.entity.proj.reckon.ProjFundRentPlan;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.util.WorkflowUtil;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.SecurityUtil;
/**
 * 
 * @author 蔡雅超
 * @date 2013-8-21
 * @info项目资料补齐的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "ProjFileUpLoadStartAction", description = "流程开始动作", workflowName = "项目资料补齐")
@Component(value = "ProjFileUpLoadStartAction")
public class ProjFileUpLoadStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		Logger logger=Logger.getLogger(ProjCreditStartAction.class.getName());
		String proj_id = variablesMap.get("proj_id");
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
		String hql = "SELECT new Map(WF.workNumber as workNumber, WF.workFlowName as workFlowName,WF.workFlowInstance AS workFlowInstance, WF.beginUser AS beginUser) FROM  WorkFlowFlag AS WF , ExclusionInfo AS EI  WHERE WF.workFlowName = EI.workFlowNameB AND EI.workFlowNameA = '"+workFlowName+"' AND WF.workNumber = '"+ proj_id +"'";
		List<Map<String,String>> workFlowFlagList =  this.tableService.findResultsByHSQL(hql);
		if (workFlowFlagList.size() > 0){
			Map<String, String> workFlowInfoMap = workFlowFlagList.get(0);
			User beginUser = this.tableService.findEntityByID(User.class, workFlowInfoMap.get("beginUser"));
			String workFlowNameB = workFlowInfoMap.get("workFlowName");
			throw new BusinessException("该条流程与【"+workFlowNameB+"】流程不能同时发起,请与流程发起人:【"+beginUser.getRealname()+"】联系查看详情");
		}
		
		//将本条流程记录插入到冲突表
		WorkFlowFlag workFlowFlag = new WorkFlowFlag();
		workFlowFlag.setBeginUser(SecurityUtil.getPrincipal().getId());
		workFlowFlag.setStatus(1);
		workFlowFlag.setWorkFlowInstance(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"");
		workFlowFlag.setWorkFlowName(workFlowName);
		workFlowFlag.setWorkNumber(proj_id);
		this.tableService.saveEntity(workFlowFlag);

		variablesMap.put("workFlowFlag", workFlowFlag.getId());
		/** 流程冲突第一步-结束*/
		
		Map<String,String> queryMainObjectMap = new HashMap<String,String>();
		
		//步骤一 (获取前台数据)
		String cust_id = variablesMap.get("cust_id");
		System.out.println(cust_id + "========*****=======" + proj_id);
		//获取合同号
		String contract_id = WorkflowUtil.getContractInfoSerialNumber(variablesMap,this.tableService.getBussinessDao().getHibernateTemplate(), this.tableService.getBussinessDao().getJdbcTemplate());
		String contract_number = WorkflowUtil.getContractInfoSerialNumberForBussiness(variablesMap,this.tableService.getBussinessDao().getHibernateTemplate(), this.tableService.getBussinessDao().getJdbcTemplate());
		//获得一个流水号
		String doc_id=jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"";
		variablesMap.put("contract_info.contractid",contract_id);
		variablesMap.put("contract_info.contractnumber",contract_number);
		queryMainObjectMap.put("proj_id", proj_id);
		queryMainObjectMap.put("contract_id", contract_id);
		queryMainObjectMap.put("doc_id", doc_id);
		queryMainObjectMap.put("cust_id", cust_id);
		
		ProjInfo projInfo = (ProjInfo) this.tableService.findEntityByID(ProjInfo.class, proj_id);
		//项目信息
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo,null, "proj_info"));
//		this.tableService.saveOrUpdateEntity(projInfo);
		//客户信息
		CustInfo custInfo=projInfo.getCustId();
		variablesMap.put("proj_info.custname", custInfo.getCustName());	
		variablesMap.put("proj_info.custnumber", custInfo.getCustNumber());
		variablesMap.put("proj_info.custid", custInfo.getId());
		variablesMap.put("proj_info.cust_type", custInfo.getCustClass().getCode().equals("CUST_INFO_COMPANY")?"法人":"自然人");
		variablesMap.put("cust_info.custclass", custInfo.getCustClass().getName());//动态显示
		/**判断是法人   还是    自然人*/
		if(custInfo.getCustClass().getCode()!=null){
			if(custInfo.getCustClass().getCode().toUpperCase().equals("CUST_INFO_COMPANY")){//法人
				CustInfoCompany company=custInfo.getCustInfoCompany();
				if (company != null) {
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
				} else {
					logger.info("company对象为空");
				}
			}
			if(custInfo.getCustClass().getCode().toUpperCase().equals("CUST_INFO_PERSON")){//自然人
				CustInfoPerson person=custInfo.getCustInfoPerson();
				if(person!=null){
				variablesMap.put("cust_info_person.idcardno", person==null?"":person.getIdCardNo());
				variablesMap.put("cust_info_person.homeadd", person==null?"":person.getHomeAdd());
				variablesMap.put("cust_info_person.mobilenumber", person==null?"":person.getMobileNumber());
				variablesMap.put("cust_info_person.unitname", person==null?"":person.getUnitName());
			    variablesMap.put("cust_info_person.custethnic", (person.getCustEthnic()== null)? "": person.getCustEthnic().getName());
				variablesMap.put("cust_info_person.driverlicensedate", person==null?"":person.getDriverLicenseDate());
				variablesMap.put("cust_info_person.spousename", person==null?"":person.getSpouseName());
				if(projInfo.getCustDealer() != null){
					variablesMap.put("proj_info.custdealer", projInfo.getCustDealer().getId());
				} else {
					variablesMap.put("proj_info.custdealer", (person.getDealerOrCompany() == null ? "" : person.getDealerOrCompany()));
				}
				
				}else{
					logger.info("person对象为空");
				}
			}
		}
		
		queryMainObjectMap.put("proj_id", proj_id);// 注明：项目其它信息(这里projInfo_id在后面的JsonArrayData中很多用到这种格式)
		
		if (!projInfo.getProjEquips().isEmpty()) {// 租赁物明细
			variablesMap.put("json_proj_equip_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_equip.xml", queryMainObjectMap).toString());
		}
		
		//步骤四
		//为了租金测算的通用性此处的名字不用contract_codition 而用framework_condition
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo.getProjCondition(),null, "framework_condition"));
		//设置租金测算参数为合同审批
		variablesMap.put("framework_condition.contractid",contract_id);
		variablesMap.put("framework_condition.process", "cont_process");
		variablesMap.put("framework_condition.custname",custInfo.getCustName());
		variablesMap.put("framework_condition.custid",custInfo.getId());
		variablesMap.put("framework_condition.docid",doc_id);
		variablesMap.put("framework_condition.onhireid","");
		
		//获取当前经销商信息
		if (projInfo.getCustDealer()!=null) {
			variablesMap.put("json_contract_supplier_str", this.tableService.getJsonArrayData("eleasing/workflow/contract_approval/contract_dealer_info.xml", queryMainObjectMap).toString());
		}
		
		//因为这里是按照XML配置查询 所以在合同审批发起的时候数据是从项目表来的 所以这里的xml配置的是项目的XML
		if (!projInfo.getProjFundRentPlans().isEmpty()) {//租金计划
			variablesMap.put("json_fund_rent_plan_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_fund_rent_plan.xml", queryMainObjectMap).toString());
		}
		if (!projInfo.getProjCashDetails().isEmpty()) {//合同现金流
			variablesMap.put("json_fund_cash_flow_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_fund_cash_flow.xml", queryMainObjectMap).toString());
		}
		if (!projInfo.getProjFundFundPlans().isEmpty()) {//项目资金计划
			variablesMap.put("json_fund_fund_charge_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_fund_fund_plan.xml", queryMainObjectMap).toString());
		}
		// 租金发票类型
		
		
		JSONArray jsonArray = this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_invoice_type.xml", queryMainObjectMap);
		if(jsonArray != null && jsonArray.length() > 0){
			JSONObject jsonObject = jsonArray.getJSONObject(0);
			Iterator<?> it = jsonObject.keys();
			while (it.hasNext()) {
				String key = (String) it.next();
				variablesMap.put("proj_invoice_type." + key, jsonObject.get(key).toString());
			}
		}
		//带出项目立项流程上传的附件
		String processDefinitionId = "项目立项流程-1";
		this.tableService.getAttachment(variablesMap, projInfo.getProjId(),processDefinitionId);
	}
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		/** 流程冲突第二步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第二步-结束 */
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		

	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * 把涉及到租金计划的相关的数据从项目表复制到合同的临时的表
	 * @param contract_id
	 * @param doc_id
	 * @param projInfo
	 * @throws Exception
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public void savaConditionDataFromProjToContract(String contract_id, String doc_id,ProjInfo projInfo,BaseService tService) throws Exception {
		Map<String, Object>	propertiesMap=new HashMap<String, Object>();
		propertiesMap.put("contractId", contract_id);
		propertiesMap.put("docId", doc_id);
		removeConditionDataFromTemp(contract_id, doc_id,this.tableService);
		{//1.商务条件
			ContractConditionTemp contractCondition=new ContractConditionTemp();
			//复制数据
			contractCondition=(ContractConditionTemp) tService.copyAndOverrideExistedValueFromObject(projInfo.getProjCondition(), contractCondition);
			contractCondition.setContractId(contract_id);
			contractCondition.setDocId(doc_id);
			//写入
			this.tableService.saveEntity(contractCondition);
		}
		{//2.租金计划
			List<ContractFundRentPlanTemp> contractFundRentPlanTemps=new ArrayList<ContractFundRentPlanTemp>();
			//复制数据
			for(ProjFundRentPlan temp:projInfo.getProjFundRentPlans()){
				ContractFundRentPlanTemp contractFundRentPlanTemp=new ContractFundRentPlanTemp();
				contractFundRentPlanTemp=(ContractFundRentPlanTemp)tService.copyAndOverrideExistedValueFromObject(temp, contractFundRentPlanTemp);
				contractFundRentPlanTemp.setContractId(contract_id);
				contractFundRentPlanTemp.setDocId(doc_id);
				contractFundRentPlanTemps.add(contractFundRentPlanTemp);
			}
			//写入
			tService.saveAllEntities(contractFundRentPlanTemps);
		}
		{//3.会计租金计划
			List<ContractFinaRentPlanTemp> contractFinaRentPlanTemps=new ArrayList<ContractFinaRentPlanTemp>();
			//复制数据
			for(ProjFinaRentPlan temp:projInfo.getProjFinaRentPlans()){
				ContractFinaRentPlanTemp contractFinaRentPlanTemp=new ContractFinaRentPlanTemp();
				contractFinaRentPlanTemp=(ContractFinaRentPlanTemp)tService.copyAndOverrideExistedValueFromObject(temp, contractFinaRentPlanTemp);
				contractFinaRentPlanTemp.setContractId(contract_id);
				contractFinaRentPlanTemp.setDocId(doc_id);
				contractFinaRentPlanTemps.add(contractFinaRentPlanTemp);
			}
			//写入
			tService.saveAllEntities(contractFinaRentPlanTemps);
		}
		{//4.现金流
			List<ContractCashDetailTemp> contractCashDetailTemps=new ArrayList<ContractCashDetailTemp>();
			//复制数据
			for(ProjCashDetail temp:projInfo.getProjCashDetails()){
				ContractCashDetailTemp contractCashDetailTemp=new ContractCashDetailTemp();
				contractCashDetailTemp=(ContractCashDetailTemp)tService.copyAndOverrideExistedValueFromObject(temp, contractCashDetailTemp);
				contractCashDetailTemp.setContractId(contract_id);
				contractCashDetailTemp.setDocId(doc_id);
				contractCashDetailTemps.add(contractCashDetailTemp);
			}
			//写入
			tService.saveAllEntities(contractCashDetailTemps);
		}
		{//5.会计现金流
			List<ContractFinaCashDetailTemp> contractFinaCashDetailTemps=new ArrayList<ContractFinaCashDetailTemp>();
			//复制数据
			for(ProjFinaCashDetail temp:projInfo.getProjFinaCashDetails()){
				ContractFinaCashDetailTemp contractFinaCashDetailTemp=new ContractFinaCashDetailTemp();
				contractFinaCashDetailTemp=(ContractFinaCashDetailTemp)tService.copyAndOverrideExistedValueFromObject(temp, contractFinaCashDetailTemp);
				contractFinaCashDetailTemp.setContractId(contract_id);
				contractFinaCashDetailTemp.setDocId(doc_id);
				contractFinaCashDetailTemps.add(contractFinaCashDetailTemp);
			}
			//写入
			tService.saveAllEntities(contractFinaCashDetailTemps);
		}
	}
	
	
	/**
	 * 删除临时表里的数据
	 * @param contract_id
	 * @param doc_id
	 * @throws Exception
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public void removeConditionDataFromTemp(String contract_id, String doc_id,BaseService tService)throws Exception {
		Map<String, Object>	propertiesMap=new HashMap<String, Object>();
		propertiesMap.put("contractId", contract_id);
		propertiesMap.put("docId", doc_id);
		{//1.商务条件
			//先删除
			List<ContractConditionTemp> contractConditionTemps=new ArrayList<ContractConditionTemp>();
			contractConditionTemps=tService.findEntityByProperties(ContractConditionTemp.class, propertiesMap);
			if(contractConditionTemps!=null&&contractConditionTemps.size()>0){
				tService.removeAllEntites(contractConditionTemps);
			}
		}
		{//2.租金计划
			//先删除
			List<ContractFundRentPlanTemp> contractFundRentPlanTemps=new ArrayList<ContractFundRentPlanTemp>();
			contractFundRentPlanTemps=tService.findEntityByProperties(ContractFundRentPlanTemp.class, propertiesMap);
			if(contractFundRentPlanTemps!=null&&contractFundRentPlanTemps.size()>0){
				tService.removeAllEntites(contractFundRentPlanTemps);
			}
		}
		{//3.会计租金计划
			//先删除
			List<ContractFinaRentPlanTemp> contractFinaRentPlanTemps=new ArrayList<ContractFinaRentPlanTemp>();
			contractFinaRentPlanTemps=tService.findEntityByProperties(ContractFinaRentPlanTemp.class, propertiesMap);
			if(contractFinaRentPlanTemps!=null&&contractFinaRentPlanTemps.size()>0){
				tService.removeAllEntites(contractFinaRentPlanTemps);
			}
		}
		{//4.现金流
			//先删除
			List<ContractCashDetailTemp> contractCashDetailTemps=new ArrayList<ContractCashDetailTemp>();
			contractCashDetailTemps=tService.findEntityByProperties(ContractCashDetailTemp.class, propertiesMap);
			if(contractCashDetailTemps!=null&&contractCashDetailTemps.size()>0){
				tService.removeAllEntites(contractCashDetailTemps);
			}
		}
		{//5.会计现金流
			//先删除
			List<ContractFinaCashDetailTemp> contractFinaCashDetailTemps=new ArrayList<ContractFinaCashDetailTemp>();
			contractFinaCashDetailTemps=tService.findEntityByProperties(ContractFinaCashDetailTemp.class, propertiesMap);
			if(contractFinaCashDetailTemps!=null&&contractFinaCashDetailTemps.size()>0){
				tService.removeAllEntites(contractFinaCashDetailTemps);
			}
		}
	}
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
