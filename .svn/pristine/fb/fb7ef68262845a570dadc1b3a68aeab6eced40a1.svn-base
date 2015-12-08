package com.business.action.leasing.contract_nocar.approval_nocar;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.ContractGuaranteeEquip;
import com.business.entity.contract.ContractGuaranteeMethod;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractPremiseCondition;
import com.business.entity.contract.ContractSignatory;
import com.business.entity.contract.ContractSupplierInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.reckon.cash.ContractCashDetail;
import com.business.entity.contract.reckon.fund.ContractFundRentPlanBefore;
import com.business.entity.proj.ProjInfo;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;


@WorkflowAction(name = "contractApprovalNoCarEndAction", description = "流程结束动作", workflowName = "合同审批流程非车业务")
@Component(value = "contractApprovalNoCarEndAction")
public class ContractApprovalNoCarEndAction implements JbpmBaseAction {

	@Resource(name = "tableService")
	private TableService tableService;
	
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String proj_id = variablesMap.get("proj_id");
		ContractInfo contractInfo = new ContractInfo();
		//1.保存合同信息
		this.tableService.copyAndOverrideExistedValueFromStringMap(variablesMap,contractInfo,null,"contract_info");
		this.tableService.saveEntity(contractInfo);
		
		ProjInfo  pInfo=this.baseService.findEntityByID(ProjInfo.class, proj_id);
		contractInfo.setContractStatus(AppStaticUtil.CONTRACT_APPROVAL);
		contractInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		contractInfo.setProjId(pInfo);
		this.baseService.saveOrUpdateEntity(contractInfo);
		
		//数据字典通过name属性匹配
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		
		// 2.租赁物明细
		String jsonEquipsString = variablesMap.get("json_contract_equip_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractEquips", ContractEquip.class, "contractId", jsonEquipsString,null);
		// 3.担保单位
		String json_contract_guarantee_detail_str = variablesMap.get("json_contract_guarantee_detail_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractGuaranteeMethods", ContractGuaranteeMethod.class, "contractId", json_contract_guarantee_detail_str,null);
		// 4.抵押物信息
		String json_contract_guaranty_detail_str = variablesMap.get("json_contract_guaranty_detail_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractGuaranteeEquips", ContractGuaranteeEquip.class, "contractId", json_contract_guaranty_detail_str,dictDataClassMapping);
		
		// 5.合同各方 
		this.baseService.updateOneToOneEntity(contractInfo, "contractSignatory", "contractId", variablesMap, null, "contract_signatory");
		// 供应商(合同各方)
		String json_contract_signatory_str = variablesMap.get("json_contract_supplier_str");
		if(json_contract_signatory_str!=null){
		   this.baseService.updateOneToManyCollections(contractInfo, "contractSupplierInfos", ContractSupplierInfo.class, "contractId", json_contract_signatory_str,null);
		}
		// 6.前提条件
		String json_contract_premise_str = variablesMap.get("json_contract_premise_str_put");
		if(json_contract_premise_str!=null){
		   this.baseService.updateOneToManyCollections(contractInfo, "contractPremiseConditions", ContractPremiseCondition.class, "contractId", json_contract_premise_str,null);
		}
		// 2.1商务条件 此处的商务条件统一用framework_condition 为了通用性 租金测算页面的域名都用framework_condition开头而不是表名
		this.tableService.updateOneToOneEntity(contractInfo, "contractCondition", "contractId", variablesMap, null, "framework_condition");
		// 2.2合同租金计划

		String json_fund_rent_plan_str = variablesMap.get("json_fund_rent_plan_str");
		this.tableService.updateOneToManyCollections(contractInfo, "contractFundRentPlanBefores", ContractFundRentPlanBefore.class, "contractId", json_fund_rent_plan_str, null);

		// 2.3合同现金流
		String json_fund_cash_flow_str = variablesMap.get("json_fund_cash_flow_str");
		this.tableService.updateOneToManyCollections(contractInfo, "contractCashDetails", ContractCashDetail.class, "contractId", json_fund_cash_flow_str, null);
		// 2.4资金计划
		String json_contract_fund_charge_str = variablesMap.get("json_fund_fund_charge_str");
		this.tableService.updateOneToManyCollections(contractInfo, "fundFundChargePlans", ContractFundFundPlan.class, "contractId", json_contract_fund_charge_str, dictDataClassMapping);
		
		//throw new BusinessException("");
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

}
