package com.business.action.leasing.nocar.change;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjChangeInfo;
import com.business.entity.proj.ProjGuaranteeMethod;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.entity.proj.reckon.ProjCashDetail;
import com.business.entity.proj.reckon.ProjFundRentPlan;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
/**
 * 
 * @author 蔡雅超
 * @date 2013-7-22
 * @info设备变更的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "noCarChangeEndAction", description = "流程结束动作", workflowName = "设备变更流程")
@Component(value = "noCarChangeEndAction")
public class NoCarChangeEndAction implements JbpmBaseAction{
	@Resource(name = "baseService")
	private BaseService baseService;
	@Override
	public void end(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String proj_id = variablesMap.get("proj_info.projid");
//		System.out.println(proj_id);
		Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("projId", proj_id);
		//数据字典通过name属性匹配
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		dictDataClassMapping.put("CustInfo", "id");
		variablesMap.put("proj_info.workFlag", AppStaticUtil.PROJ_APPROVAL.toString());
        // 立项基本表
		ProjInfo projInfo = (ProjInfo)this.baseService.updateMainEntity(ProjInfo.class, queryMainObjectMap, variablesMap,null, "proj_info");
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		//客户信息
		CustInfo customerInfo = (CustInfo) this.baseService.findEntityByID(CustInfo.class, variablesMap.get("proj_info.custid"));
		projInfo.setCustId(customerInfo);
		//其它信息
		this.baseService.updateOneToOneEntity(projInfo, "projOtherInfo", "projId", variablesMap,null, "proj_other_info");
		//变更信息
		ProjChangeInfo pchangeInfo=new ProjChangeInfo();
		this.baseService.copyAndOverrideExistedValueFromStringMap(variablesMap, pchangeInfo, null,"proj_other_info");
		pchangeInfo.setProjId(projInfo);
		this.baseService.saveOrUpdateEntity(pchangeInfo);
		// 租金发票类型
		this.baseService.updateOneToOneEntity(projInfo, "projInvoiceType", "projId", variablesMap,null, "proj_invoice_type");
	
		// 担保单位
		String jsonProjGuaranteeMethodString = variablesMap.get("json_proj_guarantee_method_str");
		this.baseService.updateOneToManyCollections(projInfo, "projGuaranteeMethods", ProjGuaranteeMethod.class, "projId", jsonProjGuaranteeMethodString,dictDataClassMapping);
		// 租赁物明细
		String jsonEquipsString = variablesMap.get("json_proj_equip_str");//proj_info.projEquips
		this.baseService.updateOneToManyCollections(projInfo, "projEquips", ProjEquip.class, "projId", jsonEquipsString,dictDataClassMapping);
		// 2.1商务条件  此处的商务条件统一用framework_condition 为了通用性 租金测算页面的域名都用framework_condition开头而不是表名
		this.baseService.updateOneToOneEntity(projInfo, "projCondition", "projId", variablesMap,null, "framework_condition");
	   // 2.2租金计划  
	     String json_fund_rent_plan_str = variablesMap.get("json_fund_rent_plan_str");
		 this.baseService.updateOneToManyCollections(projInfo, "projFundRentPlans", ProjFundRentPlan.class, "projId", json_fund_rent_plan_str,null);
		// 2.3现金流  
		String json_fund_cash_flow_str = variablesMap.get("json_fund_cash_flow_str");
		this.baseService.updateOneToManyCollections(projInfo, "projCashDetails", ProjCashDetail.class, "projId", json_fund_cash_flow_str,null);	
	}
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String delete(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public String save(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
