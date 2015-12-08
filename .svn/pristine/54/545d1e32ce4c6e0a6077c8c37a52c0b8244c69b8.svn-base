package com.tenwa.leasing.bean;

import com.business.entity.User;
import com.tenwa.leasing.util.DateTools;
import com.tenwa.leasing.util.NumTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-2-17
 * @desc TODO (todo-list 交易结构临时表，正式表数据传值载体)
 */
public class ConditionBean {

	private String	id						= "";
	private String	docId					= "";	// docId
	private String	proj_id					= "";	// 项目编号
	private String	equip_amt				= "0";	// 设备款
	private String	lease_amt				= "0";	// 融资款

	private String	lease_amt_date			= "";	// 融资款支付日期
	private String	first_payment_ratio		= "0";	// 首付款比率
	private String	first_payment			= "0";	// 首付款
	private String	clean_lease_money		= "0";	// 净融资额
	private String	lease_money				= "0";	// 租赁本金

	private String	year_rate				= "0";	// 租赁年利率 用于计算的年利率 因为在等额租金的情况下 利率要 先做 *365/360 的处理
	private String	period_type				= "0";	// 期初（期末）支付 period_type_0  期初;period_type_1 期末
	private String	income_number_year		= "0";	// 年还租次数
	private String	income_number			= "0";	// 还租次数
	private String	lease_term				= "0";	// 租赁期限（月）

	private String	settle_method			= "0";	// 测算方式
	private String	start_date				= "";	// 预计起租日
	private String	nominal_price			= "0";	// 名义货价
	private String	pena_rate				= "0";	// 罚息利率
	private String	rate_float_type			= "";	// 利率浮动类型

	private String	rate_float_amt			= "0";	// 利率调整值
	private String	adjust_style			= "next_list";	// 调息方式
	private String	caution_money_ratio		= "0";	// 保证金比率
	private String	caution_money			= "0";	// 租赁保证金
	private String	caution_deduction_ratio	= "0";	// 保证金抵扣比率
	private String	caution_deduction_money	= "0";	// 保证金抵扣金额

	private String	handling_charge_ratio	= "0";	// 手续费比率
	private String	handling_charge_money	= "0";	// 手续费
	private String	insurer					= "";	// 保险公司
	private String	insurance				= "0";	// 保险费
	private String	management_money_ratio	= "0";	// 管理费比率
	private String	management_money		= "0";	// 管理费

	private String	irr						= "0";	// 年内部收益率IRR
	private String	plan_irr				= "0";	// 计划IRR
	private String	return_amt				= "0";	// 厂商返利
	private String	first_payment_total		= "0";	// 期初付总计
	private String	income_day				= "0";	// 每月偿付日

	private String	before_interest			= "0";	// 租前息
	private String	rate_adjustment_modulus	= "0";	// 利率调整系数
	private String	delay					= "0";	// 延迟期数
	private String	grace					= "0";	// 宽限期数
	private String	other_income			= "0";	// 其它收入
	private String	other_expenditure		= "0";	// 其它支出

	private String	creator					= "";	// 登记人
	private String	create_date				= "";	// 登记时间
	private String	modify_date				= "";	// 更新日期
	private String	modificator				= "";	// 更新人

	private String	pmtEndValue				= "0";	// 租金测算pmt公式后期测算代入的值,相当于期末残值,默认为0
	private String	calTotalByCont			= "0";	// 租金测总本金合同
	private String	calTotalByFinac			= "0";	// 租金测总本金会计

	private String	free_defa_inter_day		= "0";	// 免罚息
	private String	equip_end_value			= "0";	// 期末残值
	private String	is_before_interest		= "0";	// 是否算租前息

	private String	measure_id				= "";	// 测算编号
	private String	rentScale				= "";	// 租金格式化小数

	private String	Column_2				= "";	//
	private String	Column_3				= "";	//
	private String	Column_4				= "";	//
	private String	Column_5				= "";	//
	private String	Column_6				= "";	//

	private String	Column_7				= "";	//
	private String	Column_8				= "";	//
	private String	Column_9				= "";	//
	private String	Column_10				= "";	//
	private String	Column_1				= "";	//
	
	private String	id_1					= "";	//
	private String	id_2					= "";	//

	private String	quot_id					= "";	// 报价编号

	private String	end_date				= DateTools.getSystemDate(0);	// 预计结束日期
	private String	actual_start_date		= DateTools.getSystemDate(0);	// 实际起租日
	private String	accounting_start_date	= DateTools.getSystemDate(0);	// 财务起租日
	
	private String	onHire_id 				="";//起租编号
	private boolean isChangeDate			=true;//租金支付表是否按照第一期租金支付日做平移 默认 需要平移 但是租金计划修改 和租金计划变更的时候不平移
	private String	reckonType				="";//租金测算方式  如  租金测算  变更 调息 
	private Integer isMerger;//是否合并起租
	
	private String	noGraceIRR				="";//[KEY:scl]2012-12-24增加一个用于计算会计租金计划的IRR 不包含 宽限期
	private String	graceMultiply			="1";//[KEY:scl]2012-12-24在宽限期分摊手续费的时候如果手续费小于0了则重新按照1/N的比例重新计算
	
	private String		isRegistration;
	private String		isGuaranty;
	private Double		gpsMoney;
	private String		insurerType;
	
	public String getGraceMultiply() {
		return graceMultiply;
	}


	public void setGraceMultiply(String graceMultiply) {
		this.graceMultiply = graceMultiply;
	}


	public String getNoGraceIRR() {
		return noGraceIRR;
	}


	public void setNoGraceIRR(String noGraceIRR) {
		this.noGraceIRR = noGraceIRR;
	}
	public String getReckonType() {
		return reckonType;
	}


	public void setReckonType(String reckonType) {
		this.reckonType = reckonType;
	}
	public boolean isChangeDate() {
		return isChangeDate;
	}


	public void setChangeDate(boolean isChangeDate) {
		this.isChangeDate = isChangeDate;
	}


	public String getOnhireId() {
		if (onHire_id!=null&&!onHire_id.equals("")&&!onHire_id.equals("null")) {
			return onHire_id;
		}else {
			return "";
		}
		
	}

	public void setOnhireId(String onHire_id) {
		this.onHire_id = onHire_id;
	}

	public String getAdjustStyle() {
		return "".equals(adjust_style)?"next_list":adjust_style;
	}

	public void setAdjustStyle(String adjust_style) {
		this.adjust_style = adjust_style;
	}

	public String getBeforeInterest() {
		return before_interest;
	}

	public void setBeforeInterest(String before_interest) {
		this.before_interest = before_interest;
	}

	public String getCautionDeductionMoney() {
		return "".equals(caution_deduction_money)?"0":caution_deduction_money;
	}

	public void setCautionDeductionMoney(String caution_deduction_money) {
		this.caution_deduction_money = caution_deduction_money;
	}

	public String getCautionDeductionRatio() {
		return "".equals(caution_deduction_ratio)?"0":caution_deduction_ratio;
	}

	public void setCautionDeductionRatio(String caution_deduction_ratio) {
		this.caution_deduction_ratio = caution_deduction_ratio;
	}

	public String getCautionMoney() {
		return "".equals(caution_money)?"0":caution_money;
	}

	public void setCautionMoney(String caution_money) {
		this.caution_money = caution_money;
	}

	public String getCautionMoneyRatio() {
		return "".equals(caution_money_ratio)?"0":caution_money_ratio;
	}

	public void setCautionMoneyRatio(String caution_money_ratio) {
		this.caution_money_ratio = caution_money_ratio;
	}

	public String getCleanLeaseMoney() {
		return "".equals(clean_lease_money)?"0":clean_lease_money;
	}

	public void setCleanLeaseMoney(String clean_lease_money) {
		this.clean_lease_money = clean_lease_money;
	}


	public String getExpectRentDeduction() {
		return "".equals(Column_10)?"0":Column_10;
	}

	public void setExpectRentDeduction(String column_10) {
		Column_10 = column_10;
	}


	public String getCustCautionMoneyRatio() {
		return "".equals(Column_2)?"0":Column_2;
	}

	public void setCustCautionMoneyRatio(String column_2) {
		Column_2 = column_2;
	}

	public String getCustCautionMoney() {
		return "".equals(Column_3)?"0":Column_3;
	}

	public void setCustCautionMoney(String column_3) {
		Column_3 = column_3;
	}

	public String getSupplierCautionMoneyRatio() {
		return "".equals(Column_4)?"0":Column_4;
	}

	public void setSupplierCautionMoneyRatio(String column_4) {
		Column_4 = column_4;
	}

	public String getSupplierCautionMoney() {
		return "".equals(Column_5)?"0":Column_5;
	}

	public void setSupplierCautionMoney(String column_5) {
		Column_5 = column_5;
	}

	public String getFirstPlanDate() {
		return "".equals(Column_6)?"0":Column_6;
	}

	public void setFirstPlanDate(String column_6) {
		Column_6 = column_6;
	}

	public String getExpectRentRatio() {
		return "".equals(Column_7)?"0":Column_7;
	}

	public void setExpectRentRatio(String column_7) {
		Column_7 = column_7;
	}

	public String getExpectRent() {
		return "".equals(Column_8)?"0":Column_8;
	}

	public void setExpectRent(String column_8) {
		Column_8 = column_8;
	}

	public String getExpectRentDeductionRatio() {
		return "".equals(Column_9)?"0":Column_9;
	}

	public void setExpectRentDeductionRatio(String column_9) {
		Column_9 = column_9;
	}

	public String getCreateDate() {
		return create_date;
	}

	public void setCreateDate(String create_date) {
		this.create_date = create_date;
	}

	public String getCreator() {
		return creator;
	}
	
	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDelay() {
		return delay;
	}


	public void setDelay(String delay) {
		this.delay = delay;
	}


	public String getDocId() {
		return docId;
	}


	public void setDocId(String docId) {
		this.docId = docId;
	}


	public String getEquipAmt() {
		return equip_amt;
	}

	public void setEquipAmt(String equip_amt) {
		this.equip_amt = equip_amt;
	}

	public String getFirstPayment() {
		return first_payment;
	}

	public void setFirstPayment(String first_payment) {
		this.first_payment = first_payment;
	}

	public String getFirstPaymentRatio() {
		return first_payment_ratio;
	}

	public void setFirstPaymentRatio(String first_payment_ratio) {
		this.first_payment_ratio = first_payment_ratio;
	}

	public String getFirstPaymentTotal() {
		return first_payment_total;
	}

	public void setFirstPaymentTotal(String first_payment_total) {
		this.first_payment_total = first_payment_total;
	}

	public String getGrace() {
		return "".equals(grace)?"0":grace;
	}

	public void setGrace(String grace) {
		this.grace = grace;
	}

	public String getHandlingChargeMoney() {
		return handling_charge_money;
	}

	public void setHandlingChargeMoney(String handling_charge_money) {
		this.handling_charge_money = handling_charge_money;
	}

	public String getHandlingChargeRatio() {
		return "".equals(handling_charge_ratio)?"0":handling_charge_ratio;
	}

	public void setHandlingChargeRatio(String handling_charge_ratio) {
		this.handling_charge_ratio = handling_charge_ratio;
	}

	public String getIncomeDay() {
		return "".equals(income_day)?"0":income_day;
	}

	public void setIncomeDay(String income_day) {
		this.income_day = income_day;
	}

	public String getIncomeNumber() {
		return "".equals(income_number)?"0":income_number;
	}

	public void setIncomeNumber(String income_number) {
		this.income_number = income_number;
	}

	public String getIncomeNumberYear() {
		return "".equals(income_number_year)?"0":income_number_year;
	}

	public void setIncomeNumberYear(String income_number_year) {
		this.income_number_year = income_number_year;
	}

	public String getInsurance() {
		return "".equals(insurance)?"0":insurance;
	}


	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}


	public String getInsurer() {
		return "".equals(insurer)?"0":insurer;
	}


	public void setInsurer(String insurer) {
		this.insurer = insurer;
	}


	public String getIrr() {
		return "".equals(irr)?"0":irr;
	}


	public void setIrr(String irr) {
		this.irr = irr;
	}


	public String getLeaseAmt() {
		return "".equals(lease_amt)?"0":lease_amt;
	}

	public void setLeaseAmt(String lease_amt) {
		this.lease_amt = lease_amt;
	}

	public String getLeaseAmtDate() {
		return "".equals(lease_amt_date)?"0":lease_amt_date;
	}

	public void setLeaseAmtDate(String lease_amt_date) {
		this.lease_amt_date = lease_amt_date;
	}

	public String getLeaseMoney() {
		return "".equals(lease_money)?"0":lease_money;
	}

	public void setLeaseMoney(String lease_money) {
		this.lease_money = lease_money;
	}

	public String getLeaseTerm() {
		return "".equals(lease_term)?"0":lease_term;
	}

	public void setLeaseTerm(String lease_term) {
		this.lease_term = lease_term;
	}

	public String getManagementMoney() {
		return "".equals(management_money)?"0":management_money;
	}

	public void setManagementMoney(String management_money) {
		this.management_money = management_money;
	}

	public String getManagementMoneyRatio() {
		return "".equals(management_money_ratio)?"0":management_money_ratio;
	}

	public void setManagementMoneyRatio(String management_money_ratio) {
		this.management_money_ratio = management_money_ratio;
	}

	public String getModificator() {
		return modificator;
	}

	public void setModificator(String modificator) {
		this.modificator = modificator;
	}

	public String getModifyDate() {
		return modify_date;
	}

	public void setModifyDate(String modify_date) {
		this.modify_date = modify_date;
	}

	public String getNominalPrice() {
		return "".equals(nominal_price)?"0":nominal_price;
	}

	public void setNominalPrice(String nominal_price) {
		this.nominal_price = nominal_price;
	}


	public String getOtherExpenditure() {
		return "".equals(other_expenditure)?"0":other_expenditure;
	}


	public void setOtherExpenditure(String other_expenditure) {
		this.other_expenditure = other_expenditure;
	}


	public String getOtherIncome() {
		return "".equals(other_income)?"0":other_income;
	}


	public void setOtherIncome(String other_income) {
		this.other_income = other_income;
	}

	public String getPenaRate() {
		return "".equals(pena_rate)?"0":pena_rate;
	}

	public void setPenaRate(String pena_rate) {
		this.pena_rate = pena_rate;
	}

	public String getPeriodType() {
		return "".equals(period_type)?"0":period_type;
	}

	public void setPeriodType(String period_type) {
		this.period_type = period_type;
	}

	public String getPlanIrr() {
		return "".equals(plan_irr)?"0":plan_irr;
	}

	public void setPlanIrr(String plan_irr) {
		this.plan_irr = plan_irr;
	}

	public String getProjId() {
		return proj_id;
	}

	public void setProjId(String proj_id) {
		this.proj_id = proj_id;
	}


	public String getRateAdjustmentModulus() {
		return rate_adjustment_modulus;
	}

	public void setRateAdjustmentModulus(String rate_adjustment_modulus) {
		this.rate_adjustment_modulus = rate_adjustment_modulus;
	}

	public String getRateFloatAmt() {
		return "".equals(rate_float_amt)?"0":rate_float_amt;
	}

	public void setRateFloatAmt(String rate_float_amt) {
		this.rate_float_amt = rate_float_amt;
	}

	public String getRateFloatType() {
		return "".equals(rate_float_type)?"fixed":rate_float_type;
	}

	public void setRateFloatType(String rate_float_type) {
		this.rate_float_type = rate_float_type;
	}

	public String getReturnAmt() {
		return "".equals(return_amt)?"0":return_amt;
	}

	public void setReturnAmt(String return_amt) {
		this.return_amt = return_amt;
	}

	public String getSettleMethod() {
		return settle_method;
	}

	public void setSettleMethod(String settle_method) {
		this.settle_method = settle_method;
	}

	public String getStartDate() {
		return start_date;
	}

	public void setStartDate(String start_date) {
		this.start_date = start_date;
	}

	public String getCalTotalByCont() {
		return NumTools.formatNumberDoubleScale(calTotalByCont, 2);
	}

	public void setCalTotalByCont(String calTotalByCont) {
		this.calTotalByCont = calTotalByCont;
	}

	public String getCalTotalByFinac() {
		return NumTools.formatNumberDoubleScale(calTotalByFinac, 2) ;
	}

	public void setCalTotalByFinac(String calTotalByFinac) {
		this.calTotalByFinac = calTotalByFinac;
	}

	public String getEquipEndValue() {
		return "".equals(equip_end_value)?"0":equip_end_value;
	}

	public void setEquipEndValue(String equip_end_value) {
		this.equip_end_value = equip_end_value;
	}

	public String getFreeDefaInterDay() {
		return free_defa_inter_day;
	}

	public void setFreeDefaInterDay(String free_defa_inter_day) {
		this.free_defa_inter_day = free_defa_inter_day;
	}

	public String getIsBeforeInterest() {
		return "".equals(is_before_interest)?"0":is_before_interest;
	}

	public void setIsBeforeInterest(String is_before_interest) {
		this.is_before_interest = is_before_interest;
	}

	public String getPmtEndValue() {
		return "".equals(pmtEndValue)?"0":pmtEndValue;
	}

	public void setPmtEndValue(String pmtEndValue) {
		this.pmtEndValue = pmtEndValue;
	}

	public void setYearRate(String year_rate) {
		this.year_rate = year_rate;
	}

	public String getLastCorpus() {
		return "".equals(Column_1)?"0":Column_1;
	}

	public void setLastCorpus(String column_1) {
		Column_1 = column_1;
	}

	public String getQuotId() {
		return quot_id;
	}

	public void setQuotId(String quot_id) {
		this.quot_id = quot_id;
	}

	public String getMeasureId() {
		return measure_id;
	}

	public void setMeasureId(String measure_id) {
		this.measure_id = measure_id;
	}

	public String getRentScale() {
		return rentScale;
	}

	public void setRentScale(String rentScale) {
		this.rentScale = rentScale;
	}

	public String getId_1() {
		if (id_1!=null&&!"".equals(id_1)&&!id_1.equals("null")) {
			return id_1;
		}else {
			return "";
		}
	}

	public void setId_1(String id_1) {
		this.id_1 = id_1;
	}

	public String getId_2() {
		if (id_2!=null&&!"".equals(id_2)&&!id_2.equals("null")) {
			return id_2;
		}else {
			return "";
		}
	}

	public void setId_2(String id_2) {
		this.id_2 = id_2;
	}

	public String getAccountingStartDate() {
		return accounting_start_date;
	}

	public void setAccountingStartDate(String accounting_start_date) {
		this.accounting_start_date = accounting_start_date;
	}


	public String getActualStartDate() {
		return actual_start_date;
	}

	public void setActualStartDate(String actual_start_date) {
		this.actual_start_date = actual_start_date;
	}

	public String getEndDate() {
		return end_date;
	}

	public void setEndDate(String end_date) {
		this.end_date = end_date;
	}

	public String getYearRate() {
		return year_rate;		
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------
	//为类配合新就代码在旧的代码的bean中重写新的bean的get和set(差异化重写,只写不一样)
	//----------------------------------------------------------------------------------------------------------------------------------
	public String getContractId() {
		return proj_id;
	}
	
	public void setContractId(String contractId) {
		this.proj_id = contractId;
	}
	
	public Double getInsureMoney() {
		return Double.parseDouble(insurance);
	}

	public void setInsureMoney(Double insureMoney) {
		this.insurance = insureMoney.toString();
	}

	public Integer getIsMerger() {
		return isMerger;
	}

	public void setIsMerger(Integer isMerger) {
		this.isMerger = isMerger;
	}

	public void setCreator(User user){
		creator=user.getId();
	}

	public void setModificator(User user){
		modificator=user.getId();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setIsRegistration(String isRegistration) {
		this.isRegistration = isRegistration;
	}


	public String getIsRegistration() {
		return isRegistration;
	}


	public void setIsGuaranty(String isGuaranty) {
		this.isGuaranty = isGuaranty;
	}


	public String getIsGuaranty() {
		return isGuaranty;
	}


	public void setGpsMoney(Double gpsMoney) {
		this.gpsMoney = gpsMoney;
	}


	public Double getGpsMoney() {
		return gpsMoney;
	}


	public String getInsurerType() {
		return insurerType;
	}


	public void setInsurerType(String insurerType) {
		this.insurerType = insurerType;
	}
	
}
