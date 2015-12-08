package com.business.action.leasing.contract.change;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractGuaranteeMethod;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractPremiseCondition;
import com.business.entity.contract.ContractSupplierInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.contract.reckon.cash.ContractCashDetail;
import com.business.entity.contract.reckon.fund.ContractFundRentPlanBefore;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjInfo;
import com.business.service.BaseService;
import com.business.service.reckon.ConditionDataToHisService;
import com.business.service.reckon.ContractFundPlanDataTohisService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;

/**
 * @author Jason
 * @date 2013-4-24
 * @info 
 */
@WorkflowAction(name = "contractChangeEditStatusToEndAction", description = "流程结束动作", workflowName = "合同变更流程")
@Component(value = "contractChangeEditStatusToEndAction")
public class ContractChangeEditStatusToEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Resource(name="conditionDataToHisService")
	private ConditionDataToHisService  conditionDataToHisService;
	@Resource(name="ContractFundPlanDataTohisService")
	private ContractFundPlanDataTohisService contractFundPlanDataTohisService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		/**
		 * 合同审批流程结束需要保存的信息伪码
		 * 1.合同表 contract_info
		 * 2.合同租金测算结果
		 * 	2.1商务条件
		 * 	2.2合同租金计划
		 * 	2.3合同现金流
		 * 	2.4资金计划
		 * 3.计算合同表商务条件表中endDate并保存 
		 * 4.租赁物明细
		 * 5.担保
		 * 6.前提条件
		 * 7.合同清单
		 * 8.合同各方
		 * 	8.1供应商(合同各方)
		 * 9.租金发票类型
		 * 10.合同租金发票
		 * 11.合同其他信息
		 */
		// 1.合同基本信息，更新合同信息
		ContractInfo contractInfo =(ContractInfo)this.baseService.findEntityByID(ContractInfo.class, variablesMap.get("contract_info.id"));
		ProjInfo pinfo=contractInfo.getProjId();
		contractInfo=(ContractInfo)this.baseService.copyAndOverrideExistedValueFromStringMap(variablesMap, contractInfo,null,"contract_info");
		if(pinfo!=null){
			contractInfo.setProjId(pinfo);
		}
		contractInfo.setContractStatus(AppStaticUtil.CONTRACT_APPROVAL);
		//客户信息
		CustInfo customerInfo = (CustInfo) this.baseService.findEntityByID(CustInfo.class, variablesMap.get("contract_info.custid"));
		contractInfo.setCustId(customerInfo);
		this.baseService.updateEntity(contractInfo);
		
		//数据字典通过name属性匹配
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		// 2.1商务条件 此处的商务条件统一用framework_condition 为了通用性
		// 租金测算页面的域名都用framework_condition开头而不是表名
		this.baseService.updateOneToOneEntity(contractInfo,"contractCondition", "contractId", variablesMap, null,"framework_condition");
		// 2.2合同租金计划
		String json_fund_rent_plan_str = variablesMap.get("json_fund_rent_plan_str");
		this.baseService.updateOneToManyCollections(contractInfo,"contractFundRentPlanBefores",ContractFundRentPlanBefore.class, "contractId",json_fund_rent_plan_str, null);
		// 2.3合同现金流
		String json_fund_cash_flow_str = variablesMap.get("json_fund_cash_flow_str");
		this.baseService.updateOneToManyCollections(contractInfo,"contractCashDetails", ContractCashDetail.class, "contractId",json_fund_cash_flow_str, null);
	    // 4.租赁物明细
		String jsonEquipsString = variablesMap.get("json_proj_equip_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractEquips", ContractEquip.class, "contractId", jsonEquipsString,dictDataClassMapping);
		// 5.担保单位
		String jsonProjGuaranteeMethodString = variablesMap.get("json_contract_guarantee_method_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractGuaranteeMethods", ContractGuaranteeMethod.class, "contractId", jsonProjGuaranteeMethodString,null);
		// 6.前提条件
		String json_contract_premise_str = variablesMap.get("json_contract_premise_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractPremiseConditions", ContractPremiseCondition.class, "contractId", json_contract_premise_str,null);
		// 7.合同清单   暂无
		// 8.合同各方 
		this.baseService.updateOneToOneEntity(contractInfo, "contractSignatory", "contractId", variablesMap, null, "contract_signatory");
		//  8.1供应商(合同各方)
		String json_contract_supplier_str = variablesMap.get("json_contract_supplier_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractSupplierInfos", ContractSupplierInfo.class, "contractId", json_contract_supplier_str,null);
		//9.租金发票类型
		this.baseService.updateOneToOneEntity(contractInfo, "contractInvoiceType", "contractId", variablesMap, dictDataClassMapping, "contract_invoice_type");
		//10.合同租金发票
		this.baseService.updateOneToOneEntity(contractInfo, "contractInvoiceInfo", "contractId", variablesMap, null, "contract_invoice_info");
		//11.合同其他信息
		this.baseService.updateOneToOneEntity(contractInfo, "contractOtherInfo", "contractId", variablesMap,null, "contract_other_info");
	
		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {WorkFlowFlag w = this.baseService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.baseService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */

	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
        this.end(request, variablesMap, jbpmWorkflowHistoryInfo);
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
	}

}
