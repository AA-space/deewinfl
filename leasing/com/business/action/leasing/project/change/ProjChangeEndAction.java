package com.business.action.leasing.project.change;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjChangeInfo;
import com.business.entity.proj.ProjGuaranteeMethod;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.entity.proj.reckon.ProjCashDetail;
import com.business.entity.proj.reckon.ProjFundFundPlan;
import com.business.entity.proj.reckon.ProjFundRentPlan;
import com.business.service.BaseService;
import com.business.service.reckon.ConditionDataToHisService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
/**
 * 
 * @author 蔡雅超
 * @date 2013-7-12
 * @info项目变更的Action
 * @Copyright Tenwa
 */
@WorkflowAction(name = "ProjChangeEndAction", description = "流程结束动作", workflowName = "立项变更流程")
@Component(value = "ProjChangeEndAction")
public class ProjChangeEndAction implements JbpmBaseAction {
	@Resource(name="baseService")
	private BaseService baseService;
	@Resource(name="conditionDataToHisService")
	private ConditionDataToHisService  conditionDataToHisService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.baseService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.baseService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */
		
		String proj_id = variablesMap.get("proj_info.projid");
		Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("projId", proj_id);
		
		//数据字典通过name属性匹配
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
//		dictDataClassMapping.put("DictionaryData", "code");
		dictDataClassMapping.put("DictionaryData", "code");
		dictDataClassMapping.put("CustInfo", "id");
		//variablesMap.put("proj_info.workFlag", AppStaticUtil.PROJ_APPROVAL.toString());
        // 立项基本表
		ProjInfo projInfo = (ProjInfo)this.baseService.updateMainEntity(ProjInfo.class, queryMainObjectMap, variablesMap,null, "proj_info");
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		projInfo.setProjStatus(AppStaticUtil.PROJ_APPROVAL);//变更结束后，状态为1
		this.baseService.updateEntity(projInfo);
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
		// 2.4资金收付计划 
		//修改资金计划，由于项目资金计划的收付编号（payment_id）为unique的类型，插入前需清空之前的资金记录
		Map<String, Object> propertiesMapProj = new HashMap<String, Object>();
		propertiesMapProj.put("projId", projInfo);
		List<ProjFundFundPlan> projfund=this.baseService.findEntityByProperties(ProjFundFundPlan.class, propertiesMapProj);
		this.baseService.removeAllEntites(projfund);
		this.baseService.updateFlush();
		//插入新的计划
 		String json_fund_fund_charge_str = variablesMap.get("json_fund_fund_charge_str");
 		this.baseService.updateOneToManyCollections(projInfo, "projFundFundPlans", ProjFundFundPlan.class, "projId", json_fund_fund_charge_str,null);
		
//		conditionDataToHisService.saveProjConditionDataToHis(projInfo.getId(), jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"",
//				"his_proj_change", variablesMap,  "framework_condition",
//				"json_fund_rent_plan_str", "json_finance_rent_plan_str", "json_fund_cash_flow_str", "json_finance_cash_flow_str");
	}
	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

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
