package com.business.action.leasing.project.reconsider;

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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoCompany;
import com.business.entity.cust.CustInfoPerson;
import com.business.entity.proj.ProjCreditResult;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.ProjMeetingRecord;
import com.business.entity.proj.ProjVote;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.SecurityUtil;
import com.kernal.utils.WebUtil;
/**
 * 
 * @author 蔡雅超
 * @date 2013-7-17
 * @info项目复议的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "projReconsiderStartAction", description = "流程开始动作", workflowName = "项目复议流程")
@Component(value = "projReconsiderStartAction")
public class ProjReconsiderStartAction implements JbpmBaseAction {

	@Resource(name = "tableService")
	private TableService tableService;
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		Logger logger=Logger.getLogger(ProjReconsiderStartAction.class.getName());
		String proj_id = variablesMap.get("proj_id");
		
		ProjInfo projInfo = (ProjInfo) this.tableService.findEntityByID(ProjInfo.class, proj_id);
		/*判断复议流程=====================发起合同审批前两步不能发起复议,说明:合同审批第三步数据确认不更改合同数据*/
		String sql="select * from t_jbpm_workflow_info  where workflow_name_ = '合同审批流程' and history_activity_name_ in ('01发起','02-2法人信用分析师审核','02-1个人信用分析师审核','02业务企划初审') and key_two_= '"+projInfo.getProjectName()+"' ";
		  
		JdbcTemplate jdbcTemplate = (JdbcTemplate)WebUtil.getApplicationContext().getBean("jdbcTemplate");
		List<Map<String, Object>> rownums = jdbcTemplate.queryForList(sql);
		if (rownums.size() > 0){
			throw new BusinessException("项目复议流程不能与合同审批流程同时发起!");//请与【"+projInfo.getCustDealer().getCustName()+"】经销商联系
		}
		//更新状态为流程进行中
		//projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_ON);
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo,null, "proj_info"));
		//项目信息
		if(projInfo.getProjOtherInfo()!=null){
		 	  variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo.getProjOtherInfo(),null, "proj_other_info"));
			}

		//投票信息 
		Map<String,Object>  propertMap = new HashMap<String, Object>(); 
		propertMap.put("projId.id",proj_id);
		List<ProjVote> projVotes = this.tableService.findEntityByProperties(ProjVote.class, propertMap);
		if(projVotes.size() > 0)
		{
			for (ProjVote projVote : projVotes) {
				System.out.println(projVote.getVoteType()+projVote.getVoteGrade());
			}
		}
		//客户信息
		CustInfo custInfo=projInfo.getCustId();
		variablesMap.put("proj_info.custname", custInfo.getCustName());
		variablesMap.put("proj_info.custnumber", custInfo.getCustNumber());
		variablesMap.put("proj_info.custid", custInfo.getId());
		variablesMap.put("proj_info.cust_type", custInfo.getCustClass().getCode().equals("CUST_INFO_COMPANY")?"法人":"自然人");
		variablesMap.put("cust_info.custclass", custInfo.getCustClass().getName());//动态显示
//		variablesMap.put("proj_info.industrytype", custInfo.getCustClass().getCode().equals("CUST_INFO_COMPANY")?custInfo.getCustInfoCompany().getCustKind().getCode():custInfo.getCustInfoPerson().getCustKind().getCode());
		/**判断选的是法人还是自然人*/
		if(custInfo.getCustClass().getCode()!=null){
		if(custInfo.getCustClass().getCode().toUpperCase().equals("CUST_INFO_COMPANY")){//法人
			CustInfoCompany company=custInfo.getCustInfoCompany();
			if (company != null) {
				variablesMap.put("cust_info_company.legalrepresentative", company.getLegalRepresentative() != null ? company.getLegalRepresentative() : "");
				variablesMap.put("cust_info_company.taxregadd", company.getTaxRegAdd()!=null?company.getTaxRegAdd():"");
				variablesMap.put("cust_info_company.ownership", (company.getOwnership() == null) ? "" : company.getOwnership().getName());
				variablesMap.put("cust_info_company.custscale", (company.getCustScale() == null) ? "" : company.getCustScale().getName());
				//插入经销商
				variablesMap.put("proj_info.custdealer", (company.getDealerOrCompany() == null ? "" : company.getDealerOrCompany()));
			} else {
				// logger.debug("法人对象不存在");
				logger.info("company对象为空");
			}
	    }
		if(custInfo.getCustClass().getCode().toUpperCase().equals("CUST_INFO_PERSON")){//自然人
			CustInfoPerson person=custInfo.getCustInfoPerson();
			if(person!=null){
			variablesMap.put("cust_info_person.idcardno", person.getIdCardNo());
			variablesMap.put("cust_info_person.homeadd", person.getHomeAdd());
			variablesMap.put("cust_info_person.mobilenumber", person.getMobileNumber());
			variablesMap.put("cust_info_person.unitname", person.getUnitName());
		    variablesMap.put("cust_info_person.custethnic",person.getCustEthnic()!=null? person.getCustEthnic().getName() : "");
			variablesMap.put("cust_info_person.driverlicensedate", person.getDriverLicenseDate());
			variablesMap.put("cust_info_person.spousename", person.getSpouseName());
		}else{
			logger.info("person对象为空");
		}
	}
}
		
	
		//项目信审初审记录
		ProjMeetingRecord pr;
		HashMap<String,Object>parames=new HashMap<String,Object>();
		parames.put("projId", projInfo);
		parames.put("flowName", "项目信审流程");
		parames.put("meetRecordType", "初审");
		List<ProjMeetingRecord> projMeetingRecord=new ArrayList<ProjMeetingRecord>();
		projMeetingRecord=(List<ProjMeetingRecord>)this.tableService.findEntityByProperties(ProjMeetingRecord.class, parames);
		if(projMeetingRecord.size()>0){
			variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projMeetingRecord.get(0), null, "proj_meet_record"));
	      }
		//项目信审审核记录
		parames.remove(parames.get("meetRecordType"));
		parames.put("meetRecordType", "审核");
		projMeetingRecord=this.tableService.findEntityByProperties(ProjMeetingRecord.class, parames);
     
		if(projMeetingRecord.size()>0){
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projMeetingRecord.get(0), null, "proj_meet_record1"));
        }
		//信审结果
		parames=new HashMap<String,Object>();
		parames.put("projId", projInfo);
		parames.put("flowName", "项目信审流程");
		List<ProjCreditResult> projCreditResult=new ArrayList<ProjCreditResult>();
		projCreditResult=this.tableService.findEntityByProperties(ProjCreditResult.class, parames);
		if(projCreditResult.size()>0){
			variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projCreditResult.get(0), null, "proj_credit_result"));
	    }
		//this.tableService.updateEntity(projInfo);
		
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
		
		//项目其它信息
		Map<String,String> queryMainObjectMap = new HashMap<String,String>();
		queryMainObjectMap.put("proj_id", proj_id);
		// 租金发票类型
//		JSONObject jsonObject = this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_invoice_type.xml", queryMainObjectMap).get(0);
//	    Iterator<?> it = jsonObject.keys();
//		while(it.hasNext()){
//			String key = (String)it.next();
//			variablesMap.put("proj_invoice_type." + key,jsonObject.get(key).toString());
//		};
//		
		// 租金发票类型
		JSONObject jsonObject;
		JSONArray jsonArray =this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_invoice_type.xml", queryMainObjectMap);
		if (jsonArray != null && jsonArray.length() > 0) {
			jsonObject = jsonArray.getJSONObject(0);
			Iterator<?> it = jsonObject.keys();
			while (it.hasNext()) {
				String key = (String) it.next();
				variablesMap.put("proj_invoice_type." + key, jsonObject
						.get(key).toString());
			};
		}
	    if(!projInfo.getProjEquips().isEmpty()) {// 租赁物明细
			variablesMap.put("json_proj_equip_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_equip.xml", queryMainObjectMap).toString());
		}
		if (!projInfo.getProjGuaranteeMethods().isEmpty()) {// 担保单位
			variablesMap.put("json_proj_guarantee_method_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_guarantee_method.xml", queryMainObjectMap).toString());
		}
		//因为这里是按照XML配置查询 所以在合同审批发起的时候数据是从项目表来的 所以这里的xml配置的是项目的XML
		if (!projInfo.getProjFundRentPlans().isEmpty()) {//租金计划
			variablesMap.put("json_fund_rent_plan_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_fund_rent_plan.xml", queryMainObjectMap).toString());
		}
		if (!projInfo.getProjCashDetails().isEmpty()) {//现金流
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
