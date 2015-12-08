package com.business.action.leasing.project.credit;

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
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoCompany;
import com.business.entity.cust.CustInfoPerson;
import com.business.entity.proj.ProjInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.SecurityUtil;
/**
 * 
 * @author 蔡雅超
 * @date 2013-7-15
 * @info项目信审的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "projCreditStartAction", description = "流程开始动作", workflowName = "项目信审流程")
@Component(value = "projCreditStartAction")
public class ProjCreditStartAction implements JbpmBaseAction {
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
		
		
		ProjInfo projInfo = (ProjInfo) this.tableService.findEntityByID(ProjInfo.class, proj_id);
		//更新状态为流程进行中
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_ON);
//		projInfo.setProjStatus(AppStaticUtil.PROJ_CREDIT);
		//项目信息
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo,null, "proj_info"));
//		this.tableService.saveOrUpdateEntity(projInfo);
		String sql ="select s from credit_info where dealer= '"+projInfo.getCustDealer().getId()+"'";
		List<Map<String, Object>> maplist = this.tableService.getBussinessDao().getJdbcTemplate().queryForList(sql);
		for ( Map<String, Object> m :maplist )
		{
			for ( String key :m.keySet() )
				variablesMap.put("lastcredit", m.get(key).toString());
				break;
		}
		logger.info("经销商剩余额度："+variablesMap.get("lastcredit"));
		//客户信息
		if(projInfo.getProjOtherInfo()!=null){
	 	  variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo.getProjOtherInfo(),null, "proj_other_info"));
		}else{
			logger.info("projOtherInfo对象为空");
		}
		CustInfo custInfo=projInfo.getCustId();

		//查询项目表中是否有该客户的交易记录
		Map<String, Object> propertiesMap=new HashMap<String, Object>();
		propertiesMap.put("custId", custInfo);
		propertiesMap.put("projStatus", 11);//信审通过的项目
		List<ProjInfo> listporj=this.tableService.findEntityByProperties(ProjInfo.class, propertiesMap);
		if(listporj.size()>0){
			variablesMap.put("proj_info.prohistory","是");
		}else{
			variablesMap.put("proj_info.prohistory","否");
		}
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
	    if (!projInfo.getProjEquips().isEmpty()) {// 租赁物明细
			variablesMap.put("json_proj_equip_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_equip.xml", queryMainObjectMap).toString());
		}
		if (!projInfo.getProjGuaranteeMethods().isEmpty()) {// 担保单位
			variablesMap.put("json_proj_guarantee_method_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_guarantee_method.xml", queryMainObjectMap).toString());
		    
			//ObjectMapper jsonMapper = new ObjectMapper(); 
			JSONArray jsonArray = new JSONArray(variablesMap.get("json_proj_guarantee_method_str"));
			//JSONArray newjsonArray = new JSONArray();
			//List<String> jsonFundList=new ArrayList<String>();
			List list = new ArrayList();
			for(int i=0;i<jsonArray.length();i++){
				  JSONObject jsonObj = jsonArray.getJSONObject(i);
				  list.add(jsonObj.get("assurorname"));
				  //Map[] newSetMaps = jsonMapper.readValue("["+jsonObj.toString()+"]", Map[].class);
			}
			variablesMap.put("assurornameinfo",list.toString().replace("[", "").replace("]", ""));
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
		return null;
	}
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
