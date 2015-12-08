package com.business.action.leasing.contract.approval;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractGuaranteeMethod;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractOtherInfo;
import com.business.entity.contract.ContractSignatory;
import com.business.entity.contract.ContractSupplierInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.contract.equip.gps.GPSInfo;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.invoice.ContractInvoiceInfo;
import com.business.entity.contract.invoice.ContractInvoiceType;
import com.business.entity.contract.reckon.cash.ContractCashDetail;
import com.business.entity.contract.reckon.condition.ContractCondition;
import com.business.entity.contract.reckon.fund.ContractFundRentPlanBefore;
import com.business.entity.insurance.ContractInsuranceSureInfo;
import com.business.entity.insurance.InsuranceInfo;
import com.business.entity.insurance.InsurancePrice;
import com.business.entity.proj.ProjInfo;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;

/**
 * 
 * @author 孙传良
 * @date 2013-4-18下午04:53:39
 * @info 配置在流程步骤第一步的action 如果合同号设置为只读 则不需要配置该action 在这个步骤中如果点击保存则触发校验合同号唯一, 如果点击下一步则把该合同的合同信息写入合同表中并标记该合同正在合同审批流程中.
 *       如果该步骤发生删除操作,则删除租金测算表中的临时数据,并删除合同表中的记录
 * @Copyright Tenwa
 */
@WorkflowAction(name = "contractApprovalEditAction", description = "流程修改动作", workflowName = "合同审批流程")
@Component(value = "contractApprovalEditAction")
public class ContractApprovalEditAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Resource(name = "contractApprovalStartAction")
	private ContractApprovalStartAction contractApprovalStartAction;

	@SuppressWarnings("unchecked")
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		try {
			String contract_id = variablesMap.get("framework_condition.contractid");
			String doc_id = variablesMap.get("framework_condition.docid");
			this.contractApprovalStartAction.removeConditionDataFromTemp(contract_id, doc_id, this.baseService);
		} catch (Exception e) {
			System.out.println("删除租金测算临时表失败!");
		}
		// 删除合同表
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		String contractId = variablesMap.get("contract_info.contractid");
		if (!"".equals(contractId)) {
			propertiesMap.put("contractId", contractId);
			List<ContractInfo> cInfos = (List<ContractInfo>) this.baseService.findEntityByProperties(ContractInfo.class, propertiesMap);
			if (cInfos != null && cInfos.size() > 0) {
				this.baseService.removeAllEntites(cInfos);
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		//String contractNumber = variablesMap.get("contract_info.contractnumber").trim();
		//variablesMap.put("contract_info.contractnumber", contractNumber);
		// String id = variablesMap.get("contract_info.id");
		String contractid = variablesMap.get("contract_info.contractid");
		ContractInfo contractInfo = new ContractInfo();
		if (!"".equals(contractid) && contractid != null) {

			propertiesMap.put("contractId", contractid);
			List<ContractInfo> cInfos = this.baseService.findEntityByProperties(ContractInfo.class, propertiesMap);
			// Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
			// queryMainObjectMap.put("id", id);
			// 移除本条记录
			if (cInfos.size() > 0) {
				// for (ContractInfo temp : cInfos) {
				// if (temp.getId().equalsIgnoreCase(id)) {
				// contractInfo = temp;// 数据库已经有这个合同的记录
				// cInfos.remove(temp);// 从集合中移除自己用于判断重复
				// this.baseService.removeEntity(temp);
				contractInfo = (ContractInfo) this.baseService.updateMainEntity(ContractInfo.class, propertiesMap, variablesMap, null, "contract_info");
				// }

			} else {
				//variablesMap.remove("framework_condition.contractid");
				// 更新数据
				contractInfo = (ContractInfo) this.baseService.copyAndOverrideExistedValueFromStringMap(variablesMap, contractInfo, null, "contract_info");
				this.baseService.saveEntity(contractInfo);
			}
			variablesMap.put("framework_condition.contractid", contractInfo.getId());

			// if (!cInfos.isEmpty()) {// 移除了自己之后集合还有数据就有重复数据
			// ContractInfo temp = cInfos.get(0);
			// throw new BusinessException("承租人[" + temp.getCustId().getCustName() + "]的项目[" + temp.getProjectName() +
			// "]已使用合同号[" + contractNumber + "],请重新输入合同号!");
			// } else {
			// 保存合同信息

			propertiesMap = new HashMap<String, Object>();
			propertiesMap.put("projId", variablesMap.get("contract_info.projid"));
			List<ProjInfo> pInfos = this.baseService.findEntityByProperties(ProjInfo.class, propertiesMap);
			if (pInfos != null && pInfos.size() > 0) {
				//德银保存项目信审批生成的合同号
				if (pInfos.get(0).getContractNumber() != null) {
					contractInfo.setContractNumber(pInfos.get(0).getContractNumber());
					variablesMap.put("contract_info.contractnumber", pInfos.get(0).getContractNumber());
				} else {
					throw new BusinessException("业务合同号不能为空!");
				}
				contractInfo.setContractStatus(AppStaticUtil.CONTRACT_APPROVAL_01);
				contractInfo.setWorkFlag(AppStaticUtil.WORKFLOW_ON);
				contractInfo.setProjId(pInfos.get(0));
				this.baseService.saveOrUpdateEntity(contractInfo);
				
				ProjInfo projInfo = pInfos.get(0);
				projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_ON);
				this.baseService.saveOrUpdateEntity(projInfo);
				
			} else {
				throw new BusinessException("警告:没有项目信息无法保存合同信息");
			}
			// propertiesMap = new HashMap<String, Object>();
			// propertiesMap.put("contractNumber", contractNumber);
			// cInfos = this.baseService.findEntityByProperties(ContractInfo.class, propertiesMap);
			// if (!cInfos.isEmpty()) {
			// variablesMap.put("contract_info.id", cInfos.get(0).getId());
			// }

			// 插入商务条件相关表
			// 数据字典通过name属性匹配
			Map<String, String> dictDataClassMapping = new HashMap<String, String>();
			dictDataClassMapping.put("DictionaryData", "code");
			// 2.1商务条件 此处的商务条件统一用framework_condition 为了通用性 租金测算页面的域名都用framework_condition开头而不是表名
			this.baseService.updateOneToOneEntity(contractInfo, "contractCondition", "contractId", variablesMap, null, "framework_condition");
			// 2.2合同租金计划

			String json_fund_rent_plan_str = variablesMap.get("json_fund_rent_plan_str");
			this.baseService.updateOneToManyCollections(contractInfo, "contractFundRentPlanBefores", ContractFundRentPlanBefore.class, "contractId", json_fund_rent_plan_str, null);

			// 2.3合同现金流
			String json_fund_cash_flow_str = variablesMap.get("json_fund_cash_flow_str");
			this.baseService.updateOneToManyCollections(contractInfo, "contractCashDetails", ContractCashDetail.class, "contractId", json_fund_cash_flow_str, null);
			// 2.4资金计划
			String json_contract_fund_charge_str = variablesMap.get("json_fund_fund_charge_str");
			this.baseService.updateOneToManyCollectionsNoRemoved(contractInfo, "fundFundChargePlans", ContractFundFundPlan.class, "contractId", json_contract_fund_charge_str, dictDataClassMapping);
			// this.baseService.updateOneToManyCollectionsNoRemoved(contractinfo, "fundFundCharges",
			// ContractFundFundCharge.class, "contractId", jsonFundList.toString(),propertiesMap);
			
			//租赁物
			 String jsonEquipsString = variablesMap.get("json_contract_equip_str");
			this.baseService.updateOneToManyCollections(contractInfo, "contractEquips", ContractEquip.class, "contractId", jsonEquipsString, null);

			getContractQueryOption(variablesMap);
		} else {
			throw new BusinessException("请输入合同号!");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// 校验合同号唯一
		String msg = "";
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		String contractNumber = variablesMap.get("contract_info.contractnumber");
		variablesMap.put("contract_info.contractnumber", contractNumber);
		String id = variablesMap.get("contract_info.id");
		if (contractNumber!=null&&!"".equals(contractNumber)) {
			propertiesMap.put("contractNumber", contractNumber);
			List<ContractInfo> cInfos = this.baseService.findEntityByProperties(ContractInfo.class, propertiesMap);
			// 移除本条记录
			for (ContractInfo contractInfo : cInfos) {
				if (contractInfo.getId().equalsIgnoreCase(id)) {
					cInfos.remove(contractInfo);
				}
			}
			if (cInfos != null && cInfos.size() > 0) {
				msg = "您填写的合同号[" + contractNumber + "]已经存在!";
			}
		}
		getContractQueryOption(variablesMap);

		return msg;
	}

	private void getContractQueryOption(Map<String, String> variablesMap) {
		// 合同清单选择的查询条件缓存
		String contract_word_partner_type = variablesMap.get("contract_word.partner_type");
		String contract_word_car_affiliated = variablesMap.get("contract_word.car_affiliated");
		String contract_word_mortgage_type = variablesMap.get("contract_word.mortgage_type");
		String contract_word_assurance = variablesMap.get("contract_word.assurance");
		String equip_money_totle = variablesMap.get("equip.equip_money_totle");

		variablesMap.put("contract_word_partner_type", contract_word_partner_type);
		variablesMap.put("contract_word_car_affiliated", contract_word_car_affiliated);
		variablesMap.put("contract_word_mortgage_type", contract_word_mortgage_type);
		variablesMap.put("contract_word_assurance", contract_word_assurance);
		variablesMap.put("equip_money_totle", equip_money_totle);
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//企划确认  --->退回给  个人分析师  和 法人分析师
		System.out.println("################开始EditAction的退回动作");
		// 1获取合同信息
		System.out.println("######variablesMap:"+variablesMap);
		String contractid = variablesMap.get("contract_info.contractid");
		
		Map<String, Object> cMap = new HashMap<String, Object>();
		cMap.put("contractId", contractid);
		 List<ContractInfo> listcon=this.baseService.findEntityByProperties(ContractInfo.class, cMap);
		 if (listcon.size() > 0)
		 {
			 
			 ContractInfo contractInfo = listcon.get(0);
		
			 // 获取实收资金信息
		Map<String, Object> propertiesMapc = new HashMap<String, Object>();
		propertiesMapc.put("contractId", contractInfo);
		List<ContractFundFundCharge> ccharge = this.baseService.findEntityByProperties(ContractFundFundCharge.class, propertiesMapc);
		 
		// 流程互斥表:判断是否在客户资金收款或资金收款流程中,在则不能删除
		Map<String, Object> MapWork = new HashMap<String, Object>();
		MapWork.put("workNumber", contractInfo.getId());
		List<WorkFlowFlag> wflags = this.baseService.findEntityByProperties(WorkFlowFlag.class, MapWork);
		for (WorkFlowFlag wflag : wflags) {
			if ("收款流程".equals(wflag.getWorkFlowName()) || "经销商资金收款".equals(wflag.getWorkFlowName())) {
				throw new BusinessException("与" + wflag.getWorkFlowName() + "冲突,不能回退!");
			}
		}

		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("contractId", contractInfo);
		if (ccharge.size() == 0) {
			// 1.删除租金计划表before
			// 2.删除现金流表
			// 3.删除资金计划表
			List<ContractFundRentPlanBefore> cplanbefore = this.baseService.findEntityByProperties(ContractFundRentPlanBefore.class, propertiesMap);
			this.baseService.removeAllEntites(cplanbefore);
			List<ContractCashDetail> cashdetail = this.baseService.findEntityByProperties(ContractCashDetail.class, propertiesMap);
			this.baseService.removeAllEntites(cashdetail);
			List<ContractFundFundPlan> fundplan = this.baseService.findEntityByProperties(ContractFundFundPlan.class, propertiesMap);
			this.baseService.removeAllEntites(fundplan);

		} else {
			// 1.删除租金计划表before
			// 2.删除现金流表
			// 3.将资金计划表设置成作废
			// 3.1没有实收的资金计划删除
			// 4.将资金计划设置成红冲
			// 5.增加资金红冲信息
			List<ContractFundRentPlanBefore> cplanbefore = this.baseService.findEntityByProperties(ContractFundRentPlanBefore.class, propertiesMap);
			this.baseService.removeAllEntites(cplanbefore);

			// 2.删除现金流表
			List<ContractCashDetail> cashdetail = this.baseService.findEntityByProperties(ContractCashDetail.class, propertiesMap);
			this.baseService.removeAllEntites(cashdetail);

			for (int i = 0; i < ccharge.size(); i++) {
				ContractFundFundCharge cc = ccharge.get(i);
				// 如果是红冲金额,则处理资金计划信息,有其他收款则走红冲 PayFund9--资金类型为红冲
				if ("PayFund9".equalsIgnoreCase(cc.getSettleMethod().getCode())) {

					// 3.将资金计划作废
					ContractFundFundPlan cplan = cc.getFundFundChargePlan();
					cplan.setInvalid("1");
					cplan.setPaymentId(null);
					this.baseService.updateEntity(cplan);

				} else {
					throw new BusinessException("已经资金收款,不能回退,如需回退,请走资金收款做红冲!");
				}
			}
			// 3.1没有实收的资金计划删除
			List<ContractFundFundPlan> fundplan = this.baseService.findEntityByProperties(ContractFundFundPlan.class, propertiesMap);
			for (int j = fundplan.size() - 1; j >= 0; j--) {
				ContractFundFundPlan fplan = fundplan.get(j);
				for (int i = 0; i < ccharge.size(); i++) {
					if (fplan.getId().equalsIgnoreCase(ccharge.get(i).getFundFundChargePlan().getId())) {
						fundplan.remove(fplan);
					}
				}
			}
			this.baseService.removeAllEntites(fundplan);
		}

		// 删除contractContractCondition
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("contractId", contractInfo);
		List<ContractCondition> contractConditions = this.baseService.findEntityByProperties(ContractCondition.class, queryMap);
		if(contractConditions.size() > 0){
			this.baseService.removeAllEntites(contractConditions);
		}
		
		//删除现金流
		List<ContractCashDetail> contractCashDetails = this.baseService.findEntityByProperties(ContractCashDetail.class, queryMap);
		if(contractCashDetails.size() > 0){
			this.baseService.removeAllEntites(contractCashDetails);
		}
		
		//删除gps_info信息
		List<GPSInfo> gpsInfo = this.baseService.findEntityByProperties(GPSInfo.class, queryMap);
		if(gpsInfo.size() > 0){
			this.baseService.removeAllEntites(gpsInfo);
		}
		
		//删除租赁物 
		List<ContractEquip> equips = this.baseService.findEntityByProperties(ContractEquip.class, queryMap);
		if(equips.size() > 0){
			this.baseService.removeAllEntites(equips);
		}
		
		//合同供应商信息
		List<ContractSupplierInfo> contractSupplierInfos = this.baseService.findEntityByProperties(ContractSupplierInfo.class, queryMap);
		if (contractSupplierInfos.size() > 0)
		{
			this.baseService.removeAllEntites(contractSupplierInfos);
		}
		
		//合同各方    
		List<ContractSignatory> contractSignatories = this.baseService.findEntityByProperties(ContractSignatory.class, queryMap);
		if (contractSignatories.size() > 0)
		{
			this.baseService.removeAllEntites(contractSignatories);
		}
		//合同其他基本信息
		List<ContractOtherInfo> contractOtherInfos = this.baseService.findEntityByProperties(ContractOtherInfo.class, queryMap);
		if (contractOtherInfos.size() > 0)
		{
			this.baseService.removeAllEntites(contractOtherInfos);
		}
		//合同开票类型信息
		List<ContractInvoiceType> contractInvoiceTypes = this.baseService.findEntityByProperties(ContractInvoiceType.class, queryMap);
		if (contractInvoiceTypes.size() > 0)
		{
			this.baseService.removeAllEntites(contractInvoiceTypes);
		}
		//合同开票信息
		List<ContractInvoiceInfo> contractInvoiceInfos = this.baseService.findEntityByProperties(ContractInvoiceInfo.class, queryMap);
		if (contractInvoiceInfos.size() > 0)
		{
			this.baseService.removeAllEntites(contractInvoiceInfos);
		}
		//合同担保方式
		List<ContractGuaranteeMethod> contractGuaranteeMethods = this.baseService.findEntityByProperties(ContractGuaranteeMethod.class, queryMap);
		if (contractGuaranteeMethods.size() > 0)
		{
			this.baseService.removeAllEntites(contractGuaranteeMethods);
		}
		//合同保险方式确认信息
		List<ContractInsuranceSureInfo> contractInsuranceSureInfos = this.baseService.findEntityByProperties(ContractInsuranceSureInfo.class, queryMap);
		if (contractInsuranceSureInfos.size() > 0)
		{
			this.baseService.removeAllEntites(contractInsuranceSureInfos);
		}
		// 删除contractInfo
		this.baseService.removeEntity(contractInfo);
		}
		System.out.println("################结束EditAction的退回动作");
	}

}
