package com.business.serviceImpl.convert;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.entity.contract.reckon.condition.ContractCondition;
import com.business.entity.contract.reckon.condition.ContractConditionMore;
import com.business.entity.contract.reckon.condition.ContractConditionTemp;
import com.business.entity.contract.reckon.fina.ContractFinaRentPlan;
import com.business.entity.contract.reckon.fund.ContractFundRentInCome;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.exception.BusinessException;
import com.business.model.ConditionBean;
import com.business.service.convert.ConvertMapToBeanService;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.business.util.Tools;

@Service(value = "convertMapToBeanService")
public class ConvertMapToBeanServiceImpl extends AbstractBaseServiceImpl implements ConvertMapToBeanService {

	@Resource(name = "baseDao")
	private BaseDao baseDao;

	/**
	 * 将ContractConditionTemp参数转换为com.tenwa.leasing.bean.ConditionBean
	 * 
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public com.tenwa.leasing.bean.ConditionBean convertContionBean(ContractConditionTemp condition) throws Exception {
		com.tenwa.leasing.bean.ConditionBean conditionBean = new com.tenwa.leasing.bean.ConditionBean();
		conditionBean.setId(condition.getId());
		conditionBean.setDocId(condition.getDocId());
		conditionBean.setEquipAmt(condition.getEquipAmt() == null ? "0" : condition.getEquipAmt().toString());
		conditionBean.setLeaseAmt(condition.getLeaseAmt() == null ? "0" : condition.getLeaseAmt().toString());
		conditionBean.setLeaseAmtDate(condition.getLeaseAmtDate());
		conditionBean.setFirstPaymentRatio(condition.getFirstPaymentRatio() == null ? "0" : condition.getFirstPaymentRatio().toString());
		conditionBean.setFirstPayment(condition.getFirstPayment() == null ? "0" : condition.getFirstPayment().toString());
		conditionBean.setCleanLeaseMoney(condition.getCleanLeaseMoney() == null ? "0" : condition.getCleanLeaseMoney().toString());
		conditionBean.setLeaseMoney(condition.getLeaseMoney() == null ? "0" : condition.getLeaseMoney().toString());
		conditionBean.setYearRate(condition.getYearRate() == null ? "0" : condition.getYearRate().toString());
		conditionBean.setPeriodType(condition.getPeriodType() == null ? "0" : condition.getPeriodType().getCode());
		conditionBean.setIncomeNumberYear(condition.getIncomeNumberYear() == null ? "0" : condition.getIncomeNumberYear().getCode());
		conditionBean.setIncomeNumber(condition.getIncomeNumber() == null ? "0" : condition.getIncomeNumber().toString());
		conditionBean.setLeaseTerm(condition.getLeaseTerm() == null ? "0" : condition.getLeaseTerm().toString());
		conditionBean.setSettleMethod(condition.getSettleMethod() == null ? "0" : condition.getSettleMethod().getCode());
		conditionBean.setStartDate(condition.getStartDate());
		conditionBean.setNominalPrice(condition.getNominalPrice() == null ? "0" : condition.getNominalPrice().toString());
		conditionBean.setPenaRate(condition.getPenaRate() == null ? "0" : condition.getPenaRate().toString());
		conditionBean.setRateFloatType(condition.getRateFloatType() == null ? "0" : condition.getRateFloatType().getCode());
		conditionBean.setRateFloatAmt(condition.getRateFloatAmt() == null ? "0" : condition.getRateFloatAmt().toString());
		conditionBean.setAdjustStyle(condition.getAdjustStyle() == null ? "0" : condition.getAdjustStyle().getCode());
		conditionBean.setCautionMoneyRatio(condition.getCautionDeductionRatio() == null ? "0" : condition.getCautionDeductionRatio().toString());
		conditionBean.setCautionMoney(condition.getCautionMoney() == null ? "0" : condition.getCautionMoney().toString());
		conditionBean.setCautionDeductionRatio(condition.getCautionDeductionRatio() == null ? "0" : condition.getCautionDeductionRatio().toString());
		conditionBean.setCautionDeductionMoney(condition.getCautionDeductionMoney() == null ? "0" : condition.getCautionDeductionMoney().toString());
		conditionBean.setHandlingChargeRatio(condition.getHandlingChargeRatio() == null ? "0" : condition.getHandlingChargeRatio().toString());
		conditionBean.setHandlingChargeMoney(condition.getHandlingChargeMoney() == null ? "0" : condition.getHandlingChargeMoney().toString());
		conditionBean.setInsurer(condition.getInsurer());
		conditionBean.setManagementMoneyRatio(condition.getManagementMoneyRatio() == null ? "0" : condition.getManagementMoneyRatio().toString());
		conditionBean.setManagementMoney(condition.getManagementMoney() == null ? "0" : condition.getManagementMoney().toString());
		conditionBean.setIrr(condition.getIrr() == null ? "0" : condition.getIrr().toString());
		conditionBean.setPlanIrr(condition.getPlanIrr() == null ? "0" : condition.getPlanIrr().toString());
		conditionBean.setReturnAmt(condition.getReturnAmt() == null ? "0" : condition.getReturnAmt().toString());
		conditionBean.setFirstPaymentTotal(condition.getFirstPaymentTotal() == null ? "0" : condition.getFirstPaymentTotal().toString());
		conditionBean.setIncomeDay(condition.getIncomeDay() == null ? "0" : condition.getIncomeDay().toString());
		conditionBean.setBeforeInterest(condition.getBeforeInterest() == null ? "0" : condition.getBeforeInterest().toString());
		conditionBean.setRateAdjustmentModulus(condition.getRateAdjustmentModulus() == null ? "0" : condition.getRateAdjustmentModulus().toString());
		conditionBean.setDelay(condition.getDelay() == null ? "0" : condition.getDelay().toString());
		conditionBean.setGrace(condition.getGrace() == null ? "0" : condition.getGrace().toString());
		conditionBean.setOtherIncome(condition.getOtherIncome() == null ? "0" : condition.getOtherIncome().toString());
		conditionBean.setOtherExpenditure(condition.getOtherExpenditure() == null ? "0" : condition.getOtherExpenditure().toString());

		conditionBean.setCreator(condition.getCreator());
		conditionBean.setCreateDate(condition.getCreateDate());
		conditionBean.setModifyDate(condition.getModifyDate());
		conditionBean.setModificator(condition.getModificator());

		conditionBean.setFreeDefaInterDay(condition.getFreeDefaInterDay() == null ? "0" : condition.getFreeDefaInterDay().toString());
		conditionBean.setEquipEndValue(condition.getEquipEndValue() == null ? "0" : condition.getEquipEndValue().toString());
		conditionBean.setIsBeforeInterest(condition.getBeforeInterest() == null ? "0" : condition.getBeforeInterest().toString());

		conditionBean.setQuotId(condition.getQuotId());
		conditionBean.setEndDate(condition.getEndDate());
		conditionBean.setActualStartDate(condition.getActualStartDate());
		conditionBean.setAccountingStartDate(condition.getAccountingStartDate());
		conditionBean.setOnhireId(condition.getOnhireId() == null ? "0" : condition.getOnhireId().toString());
		conditionBean.setGpsMoney(condition.getGpsMoney() == null ? 0 : condition.getGpsMoney().doubleValue());
		conditionBean.setIsMerger(condition.getIsMerger() == null ? 1 : condition.getIsMerger().intValue());
		conditionBean.setIsGuaranty(condition.getIsGuaranty());

		// conditionBean.setProjId();// 项目编号
		// conditionBean.setInsurance();// 保险费
		// conditionBean.setPmtEndValue();// 租金测算pmt公式后期测算代入的值,相当于期末残值,默认为0
		// conditionBean.setCalTotalByCont();// 租金测总本金合同
		// conditionBean.setCalTotalByFinac();// 租金测总本金会计
		// conditionBean.setMeasureId();// 测算编号
		// conditionBean.setRentScale();// 租金格式化小数
		// conditionBean.setChangeDate();// 租金支付表是否按照第一期租金支付日做平移 默认 需要平移
		// 但是租金计划修改 和租金计划变更的时候不平移
		// conditionBean.setReckonType();// 租金测算方式 如 租金测算 变更 调息
		// conditionBean.setNoGraceIRR();//
		// [KEY:scl]2012-12-24增加一个用于计算会计租金计划的IRR 不包含 宽限期
		// conditionBean.setGraceMultiply();//
		// [KEY:scl]2012-12-24在宽限期分摊手续费的时候如果手续费小于0了则重新按照1/N的比例重新计算
		// conditionBean.setIsRegistration();

		// conditionBean.setId1();
		// conditionBean.setId2();
		// conditionBean.setColumn_2(column_2);
		// conditionBean.setColumn_3(column_3);
		// conditionBean.setColumn_4(column_4);
		// conditionBean.setColumn_5(column_5);
		// conditionBean.setColumn_6(column_6);
		// conditionBean.setColumn_7(column_7);
		// conditionBean.setColumn_8(column_8);
		// conditionBean.setColumn_9(column_9);
		// conditionBean.setColumn_10(column_10);
		// conditionBean.setColumn_1(column_1);

		return conditionBean;
	}

	@Override
	public ConditionBean convertContionBean(ConditionBean conditionBean, Map<String, String> modelData) throws Exception {

		// conditionBean.setSettle_method(modelData.get("settle_method"));
		// conditionBean.setEquip_amt(modelData.get("equip_amt"));
		// conditionBean.setLease_amt_date(modelData.get("lease_amt_date"));
		// conditionBean.setRatio_param(modelData.get("ratio_param"));
		// conditionBean.setFirst_payment(modelData.get("first_payment"));
		// conditionBean.setFirst_payment_ratio(modelData.get("first_payment_ratio"));
		// conditionBean.setLease_money(modelData.get("lease_money"));
		//
		// conditionBean.setIncome_number(modelData.get("income_number"));
		// conditionBean.setLease_term(modelData.get("lease_term"));
		// conditionBean.setYear_rate(modelData.get("year_rate"));
		// conditionBean.setPena_rate(modelData.get("pena_rate"));
		// conditionBean.setNominal_price(modelData.get("nominal_price"));
		// conditionBean.setCaution_money_ratio(modelData.get("caution_money_ratio"));
		// conditionBean.setCaution_money(modelData.get("caution_money"));
		//
		// conditionBean.setAssets_value(modelData.get("assets_value"));
		// conditionBean.setCust_caution_money_ratio(modelData.get("cust_caution_money_ratio"));
		// conditionBean.setCust_caution_money(modelData.get("cust_caution_money"));
		// conditionBean.setInsure_type(modelData.get("insure_type"));
		// conditionBean.setSupplier_caution_money_ratio(modelData.get("supplier_caution_money_ratio"));
		// conditionBean.setSupplier_caution_money(modelData.get("supplier_caution_money"));
		// conditionBean.setInsure(modelData.get("insure"));
		// conditionBean.setCaution_deduction_ratio(modelData.get("caution_deduction_ratio"));
		// conditionBean.setCaution_deduction_money(modelData.get("caution_deduction_money"));
		//
		// conditionBean.setInsure_money(modelData.get("insure_money"));
		// conditionBean.setHandling_charge_ratio(modelData.get("handling_charge_ratio"));
		// conditionBean.setHandling_charge(modelData.get("handling_charge"));
		// conditionBean.setReturn_amt(modelData.get("return_amt"));
		// conditionBean.setManagement_fee(modelData.get("management_fee"));
		// conditionBean.setManagement_fee_ratio(modelData.get("management_fee_ratio"));
		// conditionBean.setAdjust_style(modelData.get("adjust_style"));
		// conditionBean.setOther_income(modelData.get("other_income"));
		// conditionBean.setOther_expenditure(modelData.get("other_expenditure"));
		//
		// conditionBean.setStart_date(modelData.get("start_date"));
		// conditionBean.setRate_float_type(modelData.get("rate_float_type"));
		// conditionBean.setRate_float_amt(modelData.get("rate_float_amt"));
		// conditionBean.setIs_before_interest(modelData.get("is_before_interest"));
		// conditionBean.setBefore_interest(modelData.get("before_interest"));
		// conditionBean.setGrace(modelData.get("grace"));
		// conditionBean.setActual_fund(modelData.get("actual_fund"));
		// conditionBean.setFirst_payment_total(modelData.get("first_payment_total"));
		// conditionBean.setIrr(modelData.get("irr"));
		// conditionBean.setPlan_irr(modelData.get("plan_irr"));
		// conditionBean.setFree_defa_inter_day(modelData.get("free_defa_inter_day"));

		this.baseDao.copyAndOverrideExistedValueFromStringMap(modelData, conditionBean, null, "proj_condition");
		String income_number_year = modelData.get("proj_condition.income_number_year");
		conditionBean.setIncome_number_year(income_number_year.substring(7, income_number_year.length()));// income_1,income_2,income_3,income_6,income_12(直接截取)
		conditionBean.setPeriod_type(modelData.get("proj_condition.period_type").equals("period_type_1") ? "1" : "0");
		// 新系统中暂时没有字段，暂时不改动算法的情况下先强行赋值
		conditionBean.setRate_subsidy("0");
		conditionBean.setDiscount_rate("0");
		conditionBean.setConsulting_fee_in("0");
		conditionBean.setConsulting_fee_out("0");
		// conditionBean.setInsure_type(modelData.get("insure_type"));
		conditionBean.setCaution_sfjx("否");
		conditionBean.setIf_leas("否");
		conditionBean.setCaution_oper_way("抵扣");
		return conditionBean;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.business.serviceImpl.AbstractBaseServiceImpl#getBussinessDao(com.business.dao.BaseDao)
	 **/

	@Override
	public BaseDao getBussinessDao() throws Exception {
		return this.baseDao;
	}

	@Override
	public com.tenwa.leasing.bean.ConditionBean convertContionBean(com.tenwa.leasing.bean.ConditionBean cb, Map<String, String> modelData) throws Exception {
		// 通用方式转化bean
		this.baseDao.copyAndOverrideExistedValueFromStringMap(modelData, cb, null, "framework_condition");
		// 处理其他的数据
		String is_merger = cb.getIsMerger().toString();
		BigDecimal handling_charge_money_onHire = new BigDecimal("0");
		BigDecimal lastCorpus = new BigDecimal("0");
		// 根据是否合并起租设置剩余本金
		String processType = modelData.get("framework_condition.process");
		if ("onHire_more_process".equals(processType) && "0".equals(is_merger)) {
			Map<String, Object> propertiesMap = new HashMap<String, Object>();
			propertiesMap.put("contract_id", cb.getContractId());
			List<ContractConditionMore> ccml = this.baseDao.findEntityByProperties(ContractConditionMore.class, propertiesMap);
			boolean cal = true;
			// 如果是合并计算的话 只能是同一种租金测算方式
			if (ccml != null && ccml.size() > 0) {
				if (!(ccml.get(0).getSettleMethod().equals(cb.getSettleMethod()) && ccml.get(0).getYearRate().equals(cb.getYearRate()) && ccml.get(0).getIncomeNumberYear().equals(cb.getIncomeNumberYear()))) {
					throw new BusinessException("如果要合并起租必须是相同的 租金测算方式,租赁年利率,付租类型!");
				}
			} else {
				throw new BusinessException("此为第一次起租,不能选择合并起租!");
			}

			// 判断期初期末
			String add = "0";
			String income_number_year = cb.getIncomeNumberYear();
			if (income_number_year.equals("income_1")) {
				add = "1";
			}
			if (income_number_year.equals("income_2")) {
				add = "2";
			}
			if (income_number_year.equals("income_3")) {
				add = "3";
			}
			if (income_number_year.equals("income_6")) {
				add = "6";
			}
			if (income_number_year.equals("income_12")) {
				add = "12";
			}
			add = cb.getPeriodType().equals("period_type_0") ? "0" : add;
			String dateNow = Tools.getSystemDate(0);
			BigDecimal planCorpus = new BigDecimal("0");
			BigDecimal incomeCorpus = new BigDecimal("0");
			BigDecimal fundInterest = new BigDecimal("0");
			BigDecimal finaInterest = new BigDecimal("0");
			BigDecimal fundInterestOld = new BigDecimal("0");
			BigDecimal finaInterestOld = new BigDecimal("0");
			List<ContractFundRentPlan> contractFundRentPlans = this.baseDao.findEntityByProperties(ContractFundRentPlan.class, propertiesMap);
			List<ContractFinaRentPlan> contractFinaRentPlans = this.baseDao.findEntityByProperties(ContractFinaRentPlan.class, propertiesMap);
			int i = 0;
			for (ContractFundRentPlan contractFundRentPlan : contractFundRentPlans) {
				ContractFinaRentPlan contractFinaRentPlan = contractFinaRentPlans.get(i);
				// 计算剩余本金
				if (Tools.dateDiff("day", dateNow, contractFundRentPlan.getPlanDate()) >= 0) {
					planCorpus.add(contractFundRentPlan.getCorpusBusiness());
					for (ContractFundRentInCome cfric : contractFundRentPlan.getContractFundRentInComes()) {
						incomeCorpus.add(cfric.getCorpus());
						if (BigDecimal.ZERO.compareTo(cfric.getCorpusAdjust()) != 0) {
							incomeCorpus.add(cfric.getCorpusAdjust());
						}
					}
				} else {
					fundInterestOld.add(contractFundRentPlan.getInterest());
					finaInterestOld.add(contractFinaRentPlan.getInterest());
				}
				// 计算剩余手续费
				fundInterest.add(contractFundRentPlan.getInterest());
				finaInterest.add(contractFinaRentPlan.getInterest());
				i++;
			}
			lastCorpus = planCorpus.subtract(incomeCorpus);// 剩余本金
			handling_charge_money_onHire = finaInterest.subtract(fundInterest).subtract(finaInterestOld.subtract(fundInterestOld));// 剩余手续费
		}
		// 必须设置项
		cb.setReckonType("reckon");
		// 多次起租时 要判断是否合并起租
		cb.setCalTotalByCont(String.valueOf(Double.parseDouble(cb.getEquipAmt()) - Double.parseDouble(cb.getFirstPayment()) + Double.parseDouble(lastCorpus.toString())));// 租金测总本金合同==设备款－首付款
		// 2012-4-18 多次起租是如果是合并计算财务总本金要减去上次起租剩余手续费
		cb.setCalTotalByFinac(String.valueOf(Double.parseDouble(cb.getCleanLeaseMoney()) + Double.parseDouble(cb.getCautionMoney()) + Double.parseDouble(lastCorpus.toString()) - Double.parseDouble(handling_charge_money_onHire.toString())));// 租金测总本金会计==净融资额
																																																												// +保证金-多次起租剩余手续费
		return cb;
	}

	@Override
	public ContractCondition convertContionBean(ContractCondition cb, Map<String, String> modelData) throws Exception {
		// 通用方式转化bean
		this.baseDao.copyAndOverrideExistedValueFromStringMap(modelData, cb, null, "framework_condition");
		return cb;
	}
}
