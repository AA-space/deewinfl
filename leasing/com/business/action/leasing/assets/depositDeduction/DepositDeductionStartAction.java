package com.business.action.leasing.assets.depositDeduction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.reckon.fund.ContractFundRentInCome;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.reckon.ProjCondition;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;
import com.kernal.utils.MathUtil;
import com.kernal.utils.SecurityUtil;
import com.kernal.utils.StringUtil;

/**
 * 
 * @author 陈兴<br>
 *         时间：2013-08-15<br>
 *         方法名：保证金抵扣流程 开始Action
 * 
 */

@WorkflowAction(name = "depositDeductionStartAction", description = "流程开始动作", workflowName = "期末保证金抵扣")
@Component(value = "depositDeductionStartAction")
public class DepositDeductionStartAction implements JbpmBaseAction {

	@Resource(name = "tableService")
	private TableService tableService;

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

		/** 流程冲突第二步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第二步-结束 */

		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String contract_id = variablesMap.get("contract_id");// 获得合同类的id
		/**
		 * 流程冲突共三步 1、起始位置添加第一步，如**startAction 2、删除流程实例时添加第二部 ,**startAction中delete方法 3、结束流程里添加第三步, 例**endAction中添加
		 * 注意：例如经销资金收款中，第一步插入冲突表时，需要插入多个，不需要第二步，第三步也需要删除多个 workFlowFlag插入时已逗号分隔。
		 * 
		 * 流程冲突第一步-开始
		 */
		String workFlowName = jbpmWorkflowHistoryInfo.getWorkflowName();

		// 查询冲突
		String hql = "SELECT new Map(WF.workNumber as workNumber, WF.workFlowName as workFlowName,WF.workFlowInstance AS workFlowInstance, WF.beginUser AS beginUser) FROM  WorkFlowFlag AS WF , ExclusionInfo AS EI  WHERE WF.workFlowName = EI.workFlowNameB AND EI.workFlowNameA = '"
				+ workFlowName + "' AND WF.workNumber = '" + contract_id + "'";
		List<Map<String, String>> workFlowFlagList = this.tableService.findResultsByHSQL(hql);
		if (workFlowFlagList.size() > 0) {
			Map<String, String> workFlowInfoMap = workFlowFlagList.get(0);
			User beginUser = this.tableService.findEntityByID(User.class, workFlowInfoMap.get("beginUser"));
			String workFlowNameB = workFlowInfoMap.get("workFlowName");
			throw new BusinessException("该条流程与【" + workFlowNameB + "】流程不能同时发起,请与流程发起人:【" + beginUser.getRealname() + "】联系查看详情");
		}

		// 将本条流程记录插入到冲突表
		WorkFlowFlag workFlowFlag = new WorkFlowFlag();
		workFlowFlag.setBeginUser(SecurityUtil.getPrincipal().getId());
		workFlowFlag.setStatus(1);
		workFlowFlag.setWorkFlowInstance(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid() + "");
		workFlowFlag.setWorkFlowName(workFlowName);
		workFlowFlag.setWorkNumber(contract_id);
		this.tableService.saveEntity(workFlowFlag);

		variablesMap.put("workFlowFlag", workFlowFlag.getId());
		/** 流程冲突第一步-结束 */

		System.out.println("contract_id===" + contract_id);
		// 加载合同信息
		ContractInfo contractInfo = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, contract_id);
		// 合同基本信息

		String HQL = "";
		String feeType = "feetype2";

		if (contractInfo != null) {

			String projid = contractInfo.getProjId().getProjId();
			String contractid = contractInfo.getContractId();
			CustInfo custinfo = contractInfo.getCustId();
			ProjCondition projCondition = contractInfo.getProjId().getProjCondition();

			// 加入客户信息
			variablesMap.put("contract_info.custname", custinfo.getCustName());
			variablesMap.put("contract_info.custnumber", custinfo.getCustNumber());
			// 加入合同基本信息
			variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractInfo, null, "contract_info"));
			variablesMap.put("contract_info.projid", projid);
			variablesMap.put("contract_info.contractnumber", contractid);
			
			//查询网银编号
			 Map<String, Object> propertiesMap1 =new HashMap<String, Object>();
			 propertiesMap1.put("contractId", contractInfo);
			 propertiesMap1.put("feeType", this.tableService.findEntityByID(DictionaryData.class, "feetype2"));
			 propertiesMap1.put("payType", this.tableService.findEntityByID(DictionaryData.class, "pay_type_in"));
			 List<ContractFundFundCharge> cfundcharge=this.tableService.findEntityByProperties(ContractFundFundCharge.class, propertiesMap1);
			 if(cfundcharge.size()>0){
				 if(cfundcharge.get(0).getEbankNumber()!=null){
					 variablesMap.put("ebankid",cfundcharge.get(0).getEbankNumber().getEbdataId());
				 }
				/* else{
					 throw new BusinessException("网银编号为空!");
				 }*/
			 }

			// 保证金信息 (用到的表：CONTRACT_FUND_FUND_CHARGE(合同资金实收表),CONTRACT_FUND_RENT_INCOME(租金回笼实际))
			// 总保证金 = Sum((收支金额+费用调整)*1.00) 条件= 合同号&费用类型&收付方式（收）
			HQL = "select sum((nvl(cffc.factMoney,0.00)+nvl(cffc.feeAdjust,0.00))*1) from ContractFundFundCharge cffc where cffc.contractId.id=? and cffc.feeType.code=? and cffc.payType.code=?";
			List zbzj = tableService.findResultsByHSQL(HQL, contract_id, "feetype2", "pay_type_in");
			
			String cautionmoney = zbzj.get(0) == null ? "0.00" : zbzj.get(0).toString();
			System.out.println("cautionmoney=" + cautionmoney);
			variablesMap.put("projcondition_info.cautionmoney", cautionmoney);

			// 已还保证金 = Sum((收支金额+费用调整)*1.00) 条件= 合同号&费用类型&收付方式（付）
			HQL = "select sum((nvl(cffc.factMoney,0.00)+nvl(cffc.feeAdjust,0.00))*-1) from ContractFundFundCharge cffc where cffc.contractId.id=? and cffc.feeType.code=? and cffc.payType.code=?";
			List yhbzj = tableService.findResultsByHSQL(HQL, contract_id, "feetype2", "pay_type_out");
			String _incomecaution = yhbzj.get(0) == null ? "0.00" : yhbzj.get(0).toString();
			System.out.println("_incomecaution=" + _incomecaution);
			variablesMap.put("projcondition_info.incomecaution", _incomecaution);

			// 已抵扣保证金= 租金回笼实收表里面的 回笼租金+回笼罚息的和 条件 合同编号，结算方式=保证金抵扣租金
			HQL = "select sum(nvl(cfri.rent,0.00))+sum(nvl(cfri.penalty,0.00)) from ContractFundRentInCome cfri where cfri.contractId.id=? and cfri.balanceMode.code=?";
			List ydkbzj = tableService.findResultsByHSQL(HQL, contract_id, "PayFund7");
			String _deduction = ydkbzj.get(0) == null ? "0.00" : ydkbzj.get(0).toString();
			System.out.println("_deduction=" + _deduction);
			variablesMap.put("projcondition_info.deduction", _deduction);

			// 剩余保证金 = 总保证金-已还保证金-已抵扣保证金
			System.out.println("cautionmoney===" + MathUtil.parseDecimal(cautionmoney, 3));
			Double surplusmoney = MathUtil.parseDecimal(cautionmoney, 3) - MathUtil.parseDecimal(_incomecaution, 3) - MathUtil.parseDecimal(_deduction, 3);
			System.out.println("surplusmoney=" + surplusmoney);
			variablesMap.put("projcondition_info.surpluscaution", MathUtil.decimal(surplusmoney,3));
			variablesMap.put("projcondition_info.deductible", MathUtil.decimal(surplusmoney,3));

			// --------------------------------------------------------------------------

			HQL = " from DictionaryData AS DD where DD.belongDictionary.code=? ";
			List<DictionaryData> listpayType = new ArrayList<DictionaryData>();

			// 查出资金状态
			listpayType = this.tableService.findResultsByHSQL(HQL, "PLANMANYSTATUS");
			HashMap<String, DictionaryData> mapPayType = new HashMap<String, DictionaryData>();
			for (DictionaryData dd : listpayType) {
				mapPayType.put(dd.getCode(), dd);
			}

			// 保证金计划收付清单
			
			HQL = " from ContractFundFundPlan as fc where fc.contractId.contractId=? and fc.feeType.code=? and fc.invalid=?";
			List<ContractFundFundPlan> fundPlan = new ArrayList<ContractFundFundPlan>();
			fundPlan = this.tableService.findResultsByHSQL(HQL, contractInfo.getContractId(), feeType,"0");

			List<ContractFundFundPlan> fundPlanR = new ArrayList<ContractFundFundPlan>();
			for (ContractFundFundPlan fplan : fundPlan) {
				fplan.receiverAllMoney(mapPayType);
				fundPlanR.add(fplan);
			}

			HashMap<String, String> fieldClassMapping = new HashMap<String, String>();
			fieldClassMapping.put("ContractInfo", "contractId");
			fieldClassMapping.put("DictionaryData", "name");

			if (fundPlanR.size() > 0) {
				variablesMap.put("json_deposit_in_str", this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(fundPlanR, fieldClassMapping, ""));
			}

			// 保证金实际收付明细

			List<ContractFundFundCharge> chargeList = new ArrayList<ContractFundFundCharge>();
			// HQL=" from DictionaryData AS DD where DD.code=? ";
			// dicdpayType=(DictionaryData)this.tableService.findResultsByHSQL(HQL,paytype).get(0);
			HQL = " from ContractFundFundCharge as fc where fc.contractId.contractId=? and fc.feeType.code=?";
			chargeList = this.tableService.findResultsByHSQL(HQL, contractInfo.getContractId(), feeType);
			fieldClassMapping.clear();

			fieldClassMapping.put("ContractInfo", "contractId");
			fieldClassMapping.put("DictionaryData", "name");
			fieldClassMapping.put("ContractFundFundPlan", "paymentId");
			// fieldClassMapping.put("FundFundChargePlan", "paymentId");
			if (chargeList.size() > 0) {
				variablesMap.put("json_deposit_out_str", this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(chargeList, fieldClassMapping, ""));
			}

			// 租金回笼计划
			Map<String,String>  queryMainObjectMap =new HashMap<String,String>();
			queryMainObjectMap.put("contract_id",contract_id);
			String json_rent_up_plan_str = this.tableService.getJsonArrayData("eleasing/workflow/fund/fund_income/fundIncomePlan.xml", queryMainObjectMap).toString();
			System.out.println("json_rent_up_plan_str:"+json_rent_up_plan_str);
			if ( json_rent_up_plan_str.length() > 0 && null != json_rent_up_plan_str)
			{
				variablesMap.put("json_rent_up_plan_str",json_rent_up_plan_str);
			}
			/*BigDecimal rate = new BigDecimal("0.00");// 罚息利率
			String cur_date = DateUtil.getSystemDate();
			int freeDefaInterDay = 0;
			rate = new BigDecimal(StringUtil.nullToString(contractInfo.getContractCondition().getPenaRate(), "0.00"));
			freeDefaInterDay = Integer.parseInt(StringUtil.empty2Other(contractInfo.getContractCondition().getFreeDefaInterDay(), "0"));

			List<ContractFundRentPlan> planList = new ArrayList<ContractFundRentPlan>();
			HQL = " from ContractFundRentPlan as fc where fc.contractId.contractId=? order by fc.rentList";
			planList = this.tableService.findResultsByHSQL(HQL, contractInfo.getContractId());

			List<ContractFundRentPlan> rentPlanR = new ArrayList<ContractFundRentPlan>();

			for (ContractFundRentPlan fplan : planList) {
				fplan.initContractFundRentPlan(mapPayType, cur_date, rate, freeDefaInterDay);
				rentPlanR.add(fplan);
			}
			fieldClassMapping.clear();
			fieldClassMapping.put("ContractInfo", "contractId");
			fieldClassMapping.put("DictionaryData", "name");
			// fieldClassMapping.put("FundFundChargePlan", "paymentId");
			if (rentPlanR.size() > 0) {
				variablesMap.put("json_rent_up_plan_str", this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(rentPlanR, fieldClassMapping, ""));
			}*/
			// 租金回笼实际

			List<ContractFundRentInCome> rentList = new ArrayList<ContractFundRentInCome>();
			HQL = " from ContractFundRentInCome as fc where fc.contractId.contractId=? order by fc.planList";
			rentList = this.tableService.findResultsByHSQL(HQL, contractInfo.getContractId());
			fieldClassMapping.clear();

			fieldClassMapping.put("ContractInfo", "contractId");
			fieldClassMapping.put("DictionaryData", "name");
			fieldClassMapping.put("FundEbankData", "ebdataId");
			// fieldClassMapping.put("FundFundChargePlan", "paymentId");
			if (rentList.size() > 0) {
				variablesMap.put("json_rent_up_actually_str", this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(rentList, fieldClassMapping, ""));
			}
			
			//scl  增加条件  剩余保证金要大于应收租金才可以发起
			//租金计划租金总和
			HQL = "select sum(nvl(cfrp.rent,0.00)) from ContractFundRentPlan cfrp where cfrp.contractId.id=?";
			List planRent = tableService.findResultsByHSQL(HQL, contract_id);
			String _rent = planRent.get(0) == null ? "0.00" : planRent.get(0).toString();
			//租金实收租金总和
			HQL = "select sum(nvl(cfrp.rent,0.00))+nvl(sum(nvl(cfrp.rentAdjust,0.00)),0)  from ContractFundRentInCome cfrp where cfrp.contractId.id=?";
			List incomeRent = tableService.findResultsByHSQL(HQL, contract_id);
			String _incRent = incomeRent.get(0) == null ? "0.00" : incomeRent.get(0).toString();
			if(new BigDecimal(surplusmoney).compareTo(BigDecimal.ZERO)==0){
				throw new BusinessException("该合同已无剩余保证金，不可进行抵扣！");
			}else if(new BigDecimal(surplusmoney).compareTo(new BigDecimal(_rent).subtract(new BigDecimal(_incRent)))<0){
				//throw new BusinessException("剩余保证金小于总剩余租金合计，不可进行抵扣！");
			}
			if(new BigDecimal(_incRent).compareTo(new BigDecimal(_rent))>=0)
			{
				throw new BusinessException("该用户已经还清租金，不能进行抵扣！");
			}
		}

	}
}
