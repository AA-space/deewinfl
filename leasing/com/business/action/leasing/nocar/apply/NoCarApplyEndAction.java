package com.business.action.leasing.nocar.apply;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoCompany;
import com.business.entity.cust.CustInfoRelatedPerson;
import com.business.entity.dealer.CustInfoDealer;
import com.business.entity.proj.ProjGuaranteeMethod;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.ProjOtherInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.entity.proj.reckon.ProjCashDetail;
import com.business.entity.proj.reckon.ProjFundFundPlan;
import com.business.entity.proj.reckon.ProjFundRentPlan;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.util.WorkflowUtil;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
/**
 * 
 * @author 蔡雅超
 * @date 2013-7-10
 * @info项目立项流程(设备)的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "noCarApplyEndAction", description = "流程结束动作", workflowName = "项目立项流程(设备)")
@Component(value = "noCarApplyEndAction")
public class NoCarApplyEndAction implements JbpmBaseAction{
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Override
	public void end(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		String proj_id = variablesMap.get("proj_info.projid");
		Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("projId", proj_id);
		//variablesMap.put("proj_info.workFlag", AppStaticUtil.PROJ_APPROVAL.toString());
		
        // 立项基本表
		ProjInfo projInfo = (ProjInfo)this.baseService.updateMainEntity(ProjInfo.class, queryMainObjectMap, variablesMap,null, "proj_info");
		this.baseService.saveOrUpdateEntity(projInfo);
		//设置流程状态为流程完毕
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		
		//设置项目为立项完成状态
		projInfo.setProjStatus(AppStaticUtil.PROJ_APPROVAL);
		this.baseService.updateEntity(projInfo);
		
		//客户信息
		CustInfo customerInfo = (CustInfo) this.baseService.findEntityByID(CustInfo.class, variablesMap.get("proj_info.custid"));
		projInfo.setCustId(customerInfo);
		//其它信息
		this.baseService.updateOneToOneEntity(projInfo, "projOtherInfo", "projId", variablesMap,null, "proj_other_info");//插入projOtherInfo数据
		
		// 租金发票类型
		this.baseService.updateOneToOneEntity(projInfo, "projInvoiceType", "projId", variablesMap,null, "proj_invoice_type");
		//数据字典通过name属性匹配
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		dictDataClassMapping.put("CustInfo", "id");
	
		// 租赁物明细
		String jsonEquipsString = variablesMap.get("json_proj_equip_str");//proj_info.projEquips
		this.baseService.updateOneToManyCollections(projInfo, "projEquips", ProjEquip.class, "projId", jsonEquipsString,dictDataClassMapping);
		
		// 担保单位
		String jsonProjGuaranteeMethodString = variablesMap.get("json_proj_guarantee_method_str");
		this.baseService.updateOneToManyCollections(projInfo, "projGuaranteeMethods", ProjGuaranteeMethod.class, "projId", jsonProjGuaranteeMethodString,dictDataClassMapping);
   
		// 2.1商务条件  此处的商务条件统一用framework_condition 为了通用性 租金测算页面的域名都用framework_condition开头而不是表名
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
		
	}
	
	
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		 
	}
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
	}

	@Override
	public String delete(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	

	@Override
	public String save(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	

	
	
	
}
