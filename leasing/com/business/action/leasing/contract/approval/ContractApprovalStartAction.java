package com.business.action.leasing.contract.approval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.cash.ContractCashDetail;
import com.business.entity.contract.reckon.cash.ContractCashDetailTemp;
import com.business.entity.contract.reckon.cash.ContractFinaCashDetail;
import com.business.entity.contract.reckon.cash.ContractFinaCashDetailTemp;
import com.business.entity.contract.reckon.condition.ContractConditionTemp;
import com.business.entity.contract.reckon.fina.ContractFinaRentPlan;
import com.business.entity.contract.reckon.fina.ContractFinaRentPlanTemp;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.contract.reckon.fund.ContractFundRentPlanTemp;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoAccount;
import com.business.entity.cust.CustInfoCompany;
import com.business.entity.dealer.CustInfoDealer;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.reckon.ProjCashDetail;
import com.business.entity.proj.reckon.ProjFinaCashDetail;
import com.business.entity.proj.reckon.ProjFinaRentPlan;
import com.business.entity.proj.reckon.ProjFundRentPlan;
import com.business.entity.util.OwnAccount;
import com.business.entity.util.OwnInfo;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.util.WorkflowUtil;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.SecurityUtil;

/**
 * 
 * @author 孙传良
 * @date 2013-4-18下午04:47:54
 * @info 流程开始的action 在这里处理的是项目层的数据往合同层写入,
 * 在此处写入的 只有 租金测算的临时表 (该步骤后续需要删除)
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "contractApprovalStartAction", description = "流程开始动作", workflowName = "合同审批流程")
@Component(value = "contractApprovalStartAction")
public class ContractApprovalStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		/** 流程冲突第二步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第二步-结束 */
		
		String contract_id = variablesMap.get("framework_condition.contractid");
		String doc_id = variablesMap.get("framework_condition.docid");
		removeConditionDataFromTemp(contract_id, doc_id,this.tableService);
		
		//删除合同之后把删除合同号写入号码废弃池
		//德银业务合同号在项目信审生成，不需要号码废弃池
		/*
		String contractNumber=variablesMap.get("contract_info.contractnumber");
		if(contractNumber!=null){
		  WorkflowUtil.addDiscardContractInfoSerialNumberForBussiness(contractNumber,null,this.tableService.getBussinessDao().getHibernateTemplate(), this.tableService.getBussinessDao().getJdbcTemplate());	
		}*/
		String proj_id = variablesMap.get("proj_id");
		ProjInfo projInfo =(ProjInfo) this.tableService.findEntityByID(ProjInfo.class, proj_id);
		projInfo.setWorkFlag(0);
		this.tableService.updateEntity(projInfo);
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
		/*
		 *  
		 * 合同审批流程发起伪码
		 * 1.接受页面参数,客户编号和项目编号 并初始化一个合同号和一个doc_id
		 * 2.查询出项目基本信息,并把项目基本信息复制到contract_info的bean中(不需要保存到表)
		 * 3.查询出客户基本信息
		 * 4.按照项目号查询出项目的商务报价数据 
		 * 	4.1因为要和老的租金测算配合所以这里要把项目的数据写入到合同的temp表中(该步骤后续摒弃temp的时候需要去掉)
		 *  4.2 添加合同金额到projInContractApproval(add by jason 2013年12月21日)
		 * 5.从项目表中拉取  租金发票类型 ,设备清单,担保,抵押,风险防范措施,其他商务条件   数据.
		 * 6.按照本方信息初始化合同各方中的甲方数据
		 * 7.按照客户信息初始化合同各方中的乙方数据[带完善]
		 * 8.初始化合同各方中的供应商数据(暂时不初始化,因为此处可能修改为在填写设备清单的时候自动填写供应商)
		 * 9.生成资金计划
		 */
		Map<String,String> queryMainObjectMap = new HashMap<String,String>();
		//步骤一 (获取前台数据)
		String cust_id = variablesMap.get("cust_id");
		String proj_id = variablesMap.get("proj_id");
		System.out.println(cust_id + "========*****=======" + proj_id);
		ProjInfo projInfo =(ProjInfo) this.tableService.findEntityByID(ProjInfo.class, proj_id);
//		projInfo.setWorkFlag(1);
		this.tableService.updateEntity(projInfo);
		//获取合同号
		String contract_id = WorkflowUtil.getContractInfoSerialNumber(variablesMap,this.tableService.getBussinessDao().getHibernateTemplate(), this.tableService.getBussinessDao().getJdbcTemplate());
		
		
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
		
		/**合同审批并无流程冲突，此处目的为将该流程添加到流程过程表，用于合同审批list的显示,关键字为projInfo的id*/
		//查询冲突 
		String hql = "SELECT new Map(WF.workNumber as workNumber, WF.workFlowName as workFlowName,WF.workFlowInstance AS workFlowInstance, WF.beginUser AS beginUser) FROM  WorkFlowFlag AS WF , ExclusionInfo AS EI  WHERE WF.workFlowName = EI.workFlowNameB AND EI.workFlowNameA = '"+workFlowName+"' AND WF.workNumber = '"+ projInfo.getId() +"'";
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
		
		//德银新需求，合同审批业务合同编号重proj_info表中获取，在项目信审接受后保存contract_number。
		//1.项目立项后，合同审批，不插contract_number到contractinfo表
		//2.项目信审后，合同审批，取proj_info表中获取contract_number。
		//String contract_number = WorkflowUtil.getContractInfoSerialNumberForBussiness(variablesMap,this.tableService.getBussinessDao().getHibernateTemplate(), this.tableService.getBussinessDao().getJdbcTemplate());
		String contract_number="";
		if(projInfo.getContractNumber()!=null){
			 contract_number=projInfo.getContractNumber();
		}
		
		//获得一个流水号
		String doc_id=jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"";
		variablesMap.put("contract_info.contractid",contract_id);
		variablesMap.put("contract_info.contractnumber",contract_number);
		queryMainObjectMap.put("proj_id", proj_id);
		queryMainObjectMap.put("contract_id", contract_id);
		queryMainObjectMap.put("doc_id", doc_id);
		queryMainObjectMap.put("cust_id", cust_id);
		//步骤二(获取项目基本信息)
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo,null, "contract_info"));
		variablesMap.put("contract_info.id", "");
		variablesMap.put("project_info.projId", projInfo.getProjId());
		variablesMap.put("project_info.id", projInfo.getId());
		variablesMap.put("business_type", projInfo.getBusinessType().getCode());
		//获取项目其他信息
		if(projInfo.getProjOtherInfo()!=null){
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo.getProjOtherInfo(),null, "contract_other_info"));
		}
		//步骤三
		CustInfo customerInfo=projInfo.getCustId();
		//获取纳税人类别
		Map<String,Object> propertiesMap1 = new HashMap<String,Object>();
		propertiesMap1.put("custId", customerInfo);
		List<CustInfoCompany> listcc=new ArrayList<CustInfoCompany>();
		listcc=this.tableService.findEntityByProperties(CustInfoCompany.class, propertiesMap1);
		if(listcc.size()>0)
		{
			variablesMap.put("cust.taxlevel",listcc.get(0).getTaxLevel().getId());
			//System.out.println(variablesMap.get("cust.taxlevel"));
		}
		variablesMap.put("contract_info.custname", customerInfo.getCustName());
		variablesMap.put("contract_info.custnumber", customerInfo.getCustNumber());
		variablesMap.put("contract_info.custid", customerInfo.getId());
		variablesMap.put("contract_info.contractstatus", AppStaticUtil.CONTRACT_APPROVAL.toString());
		//增加法人自然人判断
		variablesMap.put("proj_info.cust_type", customerInfo.getCustClass().getCode() == null ? "" : customerInfo.getCustClass().getCode().equals("CUST_INFO_COMPANY") ? "法人" : "自然人");
		CustInfo custInfo = projInfo.getCustDealer();
		if(custInfo != null){
			variablesMap.put("contract_info.custdealername",custInfo.getCustName());
			//附件上传用到 put 客户类型
			String className = projInfo.getCustId().getCustClass().getName();
			variablesMap.put("cust_info.custclass", className);//动态显示
		}
		Map<String, Object> propertiesMap = new HashMap<String,Object>();
		propertiesMap.put("custId",projInfo.getCustDealer());
		List<CustInfoDealer> list = this.tableService.findEntityByProperties(CustInfoDealer.class, propertiesMap);
		if(list.size()> 0 ){
			variablesMap.put("dealear_xiey", list.get(0).getContractNum());
		}
		/*this.tableService.getEntityPropertiesToStringMapWithOtherEntityFields(projInfo.getProjInvoiceType().getRentInvoiceType().getName(),
				null, otherEntityFieldsMapping, entityIdentifier)*/
		if(projInfo.getProjInvoiceType().getRentInvoiceType()!=null){
			variablesMap.put("rawValue_contract_invoice_type.name", projInfo.getProjInvoiceType().getRentInvoiceType().getName());
		}
		//步骤四
		//为了租金测算的通用性此处的名字不用contract_codition 而用framework_condition
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo.getProjCondition(),null, "framework_condition"));
		//设置租金测算参数为合同审批
		variablesMap.put("framework_condition.contractid",contract_id);
		variablesMap.put("framework_condition.process", "cont_process");
		variablesMap.put("framework_condition.custname",customerInfo.getCustName());
		variablesMap.put("framework_condition.custid",customerInfo.getId());
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
		JSONObject jsonObject;
		Iterator<?> it;
		//步骤五  租金发票类型 ,设备清单,担保,抵押,风险防范措施,其他商务条件
		JSONArray jsonArray=this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_invoice_type.xml", queryMainObjectMap);
		if(jsonArray!=null&&jsonArray.length()>0){
			jsonObject= jsonArray.getJSONObject(0);
			it= jsonObject.keys();
			while(it.hasNext()){//租金发票类型
				String key = (String)it.next();
				variablesMap.put("contract_invoice_type." + key,jsonObject.get(key).toString());
			};
		}
		JSONArray jsonArray2=this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_invoice_info.xml", queryMainObjectMap);
		if(jsonArray2!=null&&jsonArray2.length()>0){
			jsonObject= jsonArray2.getJSONObject(0);
			it= jsonObject.keys();
			while(it.hasNext()){
				String key = (String)it.next();
				variablesMap.put("contract_invoice_info." + key,jsonObject.get(key).toString());
			};
		}
		if (!projInfo.getProjEquips().isEmpty()) {// 租赁物明细
			String json_proj_equip_str = this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_equip.xml", queryMainObjectMap).toString();
			variablesMap.put("json_proj_equip_str", json_proj_equip_str);
			variablesMap.put("json_proj_equip_str_for_credit", json_proj_equip_str);
		}
		if (!projInfo.getProjGuaranteeMethods().isEmpty()) {// 担保单位
			variablesMap.put("json_contract_guarantee_method_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_guarantee_method.xml", queryMainObjectMap).toString());
		}
		//步骤六
		List<OwnInfo> ownInfos= this.tableService.findEntities(OwnInfo.class);
		if(ownInfos.size()>0){
			variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(ownInfos.get(0),null, "contract_signatory"));
			//获取业务区划，赋值给合同各方委托人和联系人
			Map<String,String> queryMap = new HashMap<String,String>();
			queryMap.put("proj_info.custdealer", projInfo.getCustDealer().getId());
			if (projInfo.getCustDealer()!=null) {
				variablesMap.put("proj_credit_users_str", this.tableService.getJsonArrayData("eleasing/workflow/public/projCreditGetMessageUsers.xml", queryMap).toString());
				JSONArray jsonArrayUser = new JSONArray(variablesMap.get("proj_credit_users_str"));
					  JSONObject jsonObj = jsonArrayUser.getJSONObject(0);
					  String name=this.tableService.findEntityByID(User.class,jsonObj.get("userid").toString()).getRealname();
					  variablesMap.put("contract_signatory.leaseconsigner",name);//委托人
					  variablesMap.put("contract_signatory.leaselinkman", name); //联系人
			}
			variablesMap.put("contract_signatory.lessor",ownInfos.get(0).getOwnName());
			if(ownInfos.get(0).getOwnAccounts().size()>0){
				it = ownInfos.get(0).getOwnAccounts().iterator();
				while(it.hasNext()){//合同各方中的乙方方
					OwnAccount ownAccount = (OwnAccount)it.next();
					if("98250154740006353".equals(ownAccount.getAccNumber()))
					{
					   variablesMap.put("contract_signatory.leaseaccnumber",ownAccount.getAccNumber());
					   variablesMap.put("contract_signatory.leaseaccbank",ownAccount.getAccBank());
					   variablesMap.put("contract_signatory.leaseaccname",ownAccount.getAccName());
					}
				};
			}
		}
		//步骤七
		variablesMap.put("contract_signatory.client",customerInfo.getCustName());
		variablesMap.put("contract_signatory.clientconsigner",customerInfo.getCustName());
		variablesMap.put("contract_signatory.clientlinkman",customerInfo.getCustName());
		variablesMap.put("contract_signatory.clientpostcode",customerInfo.getCustInfoCompany()!=null?customerInfo.getCustInfoCompany().getPostCode():customerInfo.getCustInfoPerson().getPostCode());
		variablesMap.put("contract_signatory.clientaddress",customerInfo.getCustInfoCompany()!=null?customerInfo.getCustInfoCompany().getMailAdd():customerInfo.getCustInfoPerson().getMailAdd());
		variablesMap.put("contract_signatory.clientmobilenumber",customerInfo.getCustInfoCompany()!=null?customerInfo.getCustInfoCompany().getMobileNumber():customerInfo.getCustInfoPerson().getMobileNumber());
		variablesMap.put("contract_signatory.clienttel",customerInfo.getCustInfoCompany()!=null?customerInfo.getCustInfoCompany().getPhone():customerInfo.getCustInfoPerson().getPhone());
		variablesMap.put("contract_signatory.clientfax",customerInfo.getCustInfoCompany()!=null?customerInfo.getCustInfoCompany().getFaxNumber():customerInfo.getCustInfoPerson().getFaxNumber());
		variablesMap.put("contract_signatory.clientemail",customerInfo.getCustInfoCompany()!=null?"":customerInfo.getCustInfoPerson().getEmail());
		variablesMap.put("contract_signatory.clientperson",customerInfo.getCustInfoCompany()!=null?customerInfo.getCustInfoCompany().getLegalRepresentative():customerInfo.getCustName());
		//承租方主账号
		CustInfoAccount custInfoAccount = null;
		Set<CustInfoAccount> set = customerInfo.getAccounts();
		if(set.isEmpty()){
			custInfoAccount = null;
		}else{
			for(int i=0;i<set.size();i++){
				if("0".equals(set.iterator().next().getIsMain())){
					custInfoAccount = set.iterator().next();
					System.out.println(custInfoAccount.getAccNumber() + "=-=-=" + custInfoAccount);
					break;
				}
			}
		}
		variablesMap.put("contract_signatory.clientaccnumber",custInfoAccount!=null?custInfoAccount.getAccNumber():"");
		variablesMap.put("contract_signatory.clientaccbank",custInfoAccount!=null?custInfoAccount.getBankName():"");
		variablesMap.put("contract_signatory.clientaccname",custInfoAccount!=null?custInfoAccount.getAccount():"");
		
		if("CUST_INFO_PERSON".equals(customerInfo.getCustClass().getCode())){
			variablesMap.put("contract_signatory.iscard","0");
			variablesMap.put("contract_signatory.clientaccbank","card_hire_bank_agricultural");
		}else{
			variablesMap.put("contract_signatory.iscard","1");
		}
		//9.生成资金计划
		
		if (!projInfo.getProjFundFundPlans().isEmpty()) {//项目资金计划
			//替换资金计划编号
			JSONArray json_fund_fund_charge = this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_fund_fund_plan.xml", queryMainObjectMap);
			for (int i = 0; i < json_fund_fund_charge.length(); i++) {
				JSONObject fund_fund_charge = (JSONObject) json_fund_fund_charge.get(i);
				String paymentidStr = fund_fund_charge.optString("paymentid");
				if(paymentidStr != null && !paymentidStr.equals("")){
					fund_fund_charge.putOpt("paymentid", paymentidStr.replace(projInfo.getProjId().toLowerCase(), contract_id.toLowerCase()));
				}
				
			} 
			
			variablesMap.put("json_fund_fund_charge_str", json_fund_fund_charge.toString());
		}
		//10带出税号
//		Map<String,Object> query = new HashMap<String,Object>();
//		query.put("custId", customerInfo);
//		List<CustInfoCompany> cicList=(List<CustInfoCompany>)this.tableService.findEntityByProperties(CustInfoCompany.class, query);
//		if (cicList.size()>0)
//		{
//			CustInfoCompany ccompany=cicList.get(0);
//			variablesMap.put("contract_invoice_info.taxnumber", ccompany.getTaxRegCode());
//			variablesMap.put("contract_invoice_info.invoicenumber", ccompany.getTaxAcc());
//			variablesMap.put("contract_invoice_info.invoiceaddress", ccompany.getTaxRegAdd());
//			variablesMap.put("contract_invoice_info.invoicetel", ccompany.getTaxPhone());
//			variablesMap.put("contract_invoice_info.invoiceopenbank", ccompany.getTaxBank());
//		}
		//带出项目立项流程上传的附件
		String processDefinitionId = "项目立项流程-1";
		this.tableService.getAttachment(variablesMap, projInfo.getProjId(),processDefinitionId);
		
		
		
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
	/**
	 * 把合同正式表中的数据写入到临时表
	 * @param contractId
	 * @param docId
	 */
	public void saveConditionDataToTemp(ContractInfo contractInfo,String doc_id,BaseService tService)throws Exception{
		String contract_id=contractInfo.getContractId();
		Map<String, Object>	propertiesMap=new HashMap<String, Object>();
		propertiesMap.put("contractId", contract_id);
		propertiesMap.put("docId", doc_id);
		removeConditionDataFromTemp( contract_id, doc_id,this.tableService);
		{//1.商务条件
			ContractConditionTemp contractCondition=new ContractConditionTemp();
			//复制数据
			contractCondition=(ContractConditionTemp) tService.copyAndOverrideExistedValueFromObject(contractInfo.getContractCondition(), contractCondition);
			contractCondition.setContractId(contract_id);
			contractCondition.setDocId(doc_id);
			//写入
			this.tableService.saveEntity(contractCondition);
		}
		{//2.租金计划
			List<ContractFundRentPlanTemp> contractFundRentPlanTemps=new ArrayList<ContractFundRentPlanTemp>();
			//复制数据
			for(ContractFundRentPlan temp:contractInfo.getContractFundRentPlans()){
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
			for(ContractFinaRentPlan temp:contractInfo.getContractFinaRentPlans()){
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
			//先删除
			List<ContractCashDetailTemp> contractCashDetailTemps=new ArrayList<ContractCashDetailTemp>();
			//复制数据
			for(ContractCashDetail temp:contractInfo.getContractCashDetails()){
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
			//先删除
			List<ContractFinaCashDetailTemp> contractFinaCashDetailTemps=new ArrayList<ContractFinaCashDetailTemp>();
			//复制数据
			for(ContractFinaCashDetail temp:contractInfo.getContractFinaCashDetails()){
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
	 * (non-Javadoc)
	 * @see com.business.action.JbpmBaseAction#back(javax.servlet.http.HttpServletRequest, java.util.Map)
	 **/
	
	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
	}
}
