package com.business.action.leasing.contract.change;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.ContractGuaranteeEquip;
import com.business.entity.contract.ContractGuaranteeMethod;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractPremiseCondition;
import com.business.entity.contract.ContractSupplierInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.reckon.cash.ContractCashDetail;
import com.business.entity.contract.reckon.cash.ContractFinaCashDetail;
import com.business.entity.contract.reckon.fina.ContractFinaRentPlan;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.cust.CustInfo;
import com.business.service.BaseService;
import com.business.service.reckon.ConditionDataToHisService;
import com.business.service.reckon.ContractFundPlanDataTohisService;
import com.business.service.vouchersFactory.ContractChargeService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;

/**
 * @author Jason
 * @date 2013-4-24
 * @info 
 */
@WorkflowAction(name = "contractChangeEndAction", description = "流程结束动作", workflowName = "合同变更流程")
@Component(value = "contractChangeEndAction")
public class ContractChangeEndAction implements JbpmBaseAction {
	@Resource(name="contractChargeService")
	private ContractChargeService contractChargeService;
	@Resource(name = "baseService")
	private BaseService baseService;
//	@Resource(name="conditionDataToHisService")
//	private ConditionDataToHisService  conditionDataToHisService;
//	@Resource(name="ContractFundPlanDataTohisService")
//	private ContractFundPlanDataTohisService contractFundPlanDataTohisService;
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
		// 1.合同基本信息
		ContractInfo contractInfo =(ContractInfo)this.baseService.findEntityByID(ContractInfo.class, variablesMap.get("contract_info.id"));
		
		/*Map<String,String> queryMainMap = new HashMap<String,String>();
		queryMainMap.put("ProjInfo", "projId");
		this.baseService.copyAndOverrideExistedValueFromStringMap(variablesMap, contractInfo, queryMainMap, "contract_info");
		this.baseService.saveEntity(contractInfo);
		//客户信息
		CustInfo customerInfo = (CustInfo) this.baseService.findEntityByID(CustInfo.class, variablesMap.get("contract_info.custid"));
		contractInfo.setCustId(customerInfo);
		//数据字典通过name属性匹配
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		//3.入历史表
		String docId=jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"";
		conditionDataToHisService.saveContractConditionDataToHis(contractInfo.getId(), docId, "his_contract_onhire", variablesMap, "framework_condition",
				"json_fund_rent_plan_str", "", "json_fund_cash_flow_str", "");
		// 资金计划
		contractFundPlanDataTohisService.saveContractConditionDataToHis(contractInfo.getId(), docId, "his_contract_change", variablesMap, "", "json_fund_fund_charge_str");
		// 4.租赁物明细
		String jsonEquipsString = variablesMap.get("json_contract_equip_str");
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
		*/
		
		String plan_old=variablesMap.get("json_fund_rent_plan_str_forvoucher");
		//System.out.println(plan_old);
		//throw new Exception("message");
		String plan_now=variablesMap.get("json_fund_rent_plan_str");
		BigDecimal interestOld=BigDecimal.ZERO;
		BigDecimal interestNow=BigDecimal.ZERO;
		JSONArray jsonarray=new JSONArray(plan_old);
		for (int i=0;i<jsonarray.length();i++){
			JSONObject jsonobject=jsonarray.getJSONObject(i);
			interestOld=interestOld.add(new BigDecimal(jsonobject.getDouble("interest")));
		}
		JSONArray jsonarray1=new JSONArray(plan_now);
		for (int j=0;j<jsonarray1.length();j++){
			JSONObject jsonobject=jsonarray1.getJSONObject(j);
			interestNow=interestNow.add(new BigDecimal(jsonobject.getDouble("interest")));
		}
		BigDecimal sum=BigDecimal.ZERO;
		sum=interestNow.subtract(interestOld).setScale(2, BigDecimal.ROUND_HALF_UP);
		/*
		 * 生成凭证：调整+客户+租金
		 * */
		if(sum.compareTo(BigDecimal.ZERO)==1){
			contractChargeService.createVoucherInterest(contractInfo, sum);
		}
		
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
