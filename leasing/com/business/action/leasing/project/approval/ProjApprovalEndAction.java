package com.business.action.leasing.project.approval;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.Department;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoCompany;
import com.business.entity.proj.ProjGuaranteeEquip;
import com.business.entity.proj.ProjGuaranteeMethod;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.ProjOtherInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.entity.proj.invoice.ProjInvoiceInfo;
import com.business.entity.proj.reckon.ProjCashDetail;
import com.business.entity.proj.reckon.ProjFinaCashDetail;
import com.business.entity.proj.reckon.ProjFinaRentPlan;
import com.business.entity.proj.reckon.ProjFundFundPlan;
import com.business.entity.proj.reckon.ProjFundRentPlan;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.DateUtil;
/**
 * 
 * @author 蔡雅超
 * @date 2013-7-15
 * @info项目立项的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "projApprovalEndAction", description = "流程结束动作", workflowName = "项目立项流程")
@Component(value = "projApprovalEndAction")
public class ProjApprovalEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Resource(name = "tableService")
	private TableService tableService;
	
	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String proj_id = variablesMap.get("proj_info.projid");
		Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("projId", proj_id);
		
		//数据字典通过name属性匹配
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		dictDataClassMapping.put("CustInfo", "id");
		
        // 立项基本表
		ProjInfo projInfo = (ProjInfo)this.baseService.updateMainEntity(ProjInfo.class, queryMainObjectMap, variablesMap,dictDataClassMapping, "proj_info");
		projInfo.setEndDate(DateUtil.getSystemDateTime());
		this.baseService.saveOrUpdateEntity(projInfo);
		//设置流程状态为流程完毕
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		//设置项目为立项完成状态
		projInfo.setProjStatus(AppStaticUtil.PROJ_APPROVAL);
		if(variablesMap.get("cust_info.dealername")!=null){
			HashMap<String, Object> propertiesMap = new HashMap<String, Object>();
			propertiesMap.put("realname", variablesMap.get("cust_info.dealername"));
			List<User> listUser = this.tableService.findEntityByProperties(User.class, propertiesMap);
			if(listUser.size() > 0){ 
				User user = listUser.get(0);
				projInfo.setProjRegistrar(user);
			}
		}
		if(variablesMap.get("proj_info.deptid")!=null){
			Department department = this.baseService.findEntityByID(Department.class,variablesMap.get("proj_info.deptid")); 
			projInfo.setProjDept(department);
		}
		//加一个项目立项发起人的获取
		Map<String, String> queryMap = new HashMap<String,String>();
		queryMap.put("proj_id",projInfo.getProjId());
		JSONArray jsonArray = new JSONArray(this.tableService
				.getJsonArrayData("eleasing/workflow/dealer/dealer_project_manager_new.xml", queryMap).toString());
		if(jsonArray.length()==1){
			JSONObject jsonObject = jsonArray.getJSONObject(0);
			projInfo.setDealeruname(jsonObject.getString("jxsu"));
		}
		this.baseService.updateEntity(projInfo);
		//客户信息
		CustInfo customerInfo = (CustInfo) this.baseService.findEntityByID(CustInfo.class, variablesMap.get("proj_info.custid"));
		projInfo.setCustId(customerInfo);
		/*start 加高管信息*/
		CustInfoCompany custInfoCompany = customerInfo.getCustInfoCompany();
		custInfoCompany.setSeniorName(variablesMap.get("cust_info_company.seniorname"));
		custInfoCompany.setPosition(variablesMap.get("cust_info_company.position"));
		custInfoCompany.setDegree(variablesMap.get("cust_info_company.degree"));
		custInfoCompany.setWorklife(variablesMap.get("cust_info_company.worklife"));
		custInfoCompany.setCage(variablesMap.get("cust_info_company.cage"));
		this.baseService.updateEntity(custInfoCompany);
		/*end 加高管信息*/
		//其它信息
		this.baseService.updateOneToOneEntity(projInfo, "projOtherInfo", "projId", variablesMap,null, "proj_other_info");//插入projOtherInfo数据
		// 租金发票类型
		this.baseService.updateOneToOneEntity(projInfo, "projInvoiceType", "projId", variablesMap,null, "proj_invoice_type");
		ProjInvoiceInfo projInvoiceInfo = new ProjInvoiceInfo();
		this.tableService.copyAndOverrideExistedValueFromStringMap(variablesMap, projInvoiceInfo, null, "proj_invoice_info");
		projInvoiceInfo.setProjId(projInfo);
		this.tableService.saveEntity(projInvoiceInfo);
		// 租赁物明细
		String jsonEquipsString = variablesMap.get("json_proj_equip_str");//proj_info.projEquips
		this.baseService.updateOneToManyCollections(projInfo, "projEquips", ProjEquip.class, "projId", jsonEquipsString,dictDataClassMapping);
		// 担保单位
		String jsonProjGuaranteeMethodString = variablesMap.get("json_proj_guarantee_method_str");
		this.baseService.updateOneToManyCollections(projInfo, "projGuaranteeMethods", ProjGuaranteeMethod.class, "projId", jsonProjGuaranteeMethodString,dictDataClassMapping);
		// 2.1商务条件  此处的商务条件统一用framework_condition 为了通用性 租金测算页面的域名都用framework_condition开头而不是表名
		//分别按直租、回租维护罚息利率
		//直租
		DictionaryData fxleasform=null;
		
		if("lease_form1".equals(projInfo.getLeasForm().getId())){
			fxleasform=this.tableService.findEntityByID(DictionaryData.class,"fxrate.01");
		}else if("lease_form2".equals(projInfo.getLeasForm().getId())){
			fxleasform=this.tableService.findEntityByID(DictionaryData.class,"fxrate.02");
		}
		String penarate="0";
		if(fxleasform!=null){
		    penarate=fxleasform.getDescription();
		}
		variablesMap.put("framework_condition.penarate",penarate);
		this.baseService.updateOneToOneEntity(projInfo, "projCondition", "projId", variablesMap,null, "framework_condition");
	   // 2.2租金计划  
	     String json_fund_rent_plan_str = variablesMap.get("json_fund_rent_plan_str");
		 this.baseService.updateOneToManyCollections(projInfo, "projFundRentPlans", ProjFundRentPlan.class, "projId", json_fund_rent_plan_str,null);
		// 2.3现金流  
		String json_fund_cash_flow_str = variablesMap.get("json_fund_cash_flow_str");
		this.baseService.updateOneToManyCollections(projInfo, "projCashDetails", ProjCashDetail.class, "projId", json_fund_cash_flow_str,null);
		// 2.4资金收付计划 
 		String json_fund_fund_charge_str = variablesMap.get("json_fund_fund_charge_str");
 		dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
 		this.baseService.updateOneToManyCollections(projInfo, "projFundFundPlans", ProjFundFundPlan.class, "projId", json_fund_fund_charge_str,dictDataClassMapping);
		//end;
 	
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}
	/*
	 * public ProjApprovalEndAction(){ this.baseService =
	 * (ProjApprrovalDao)WebUtil.getApplicationContext().getBean("baseService"); }
	 */
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
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
