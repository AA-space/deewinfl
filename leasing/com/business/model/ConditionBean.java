package com.business.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.business.entity.User;
import com.business.util.MathExtend;
import com.kernal.annotation.FieldName;

/**
 * @author Toybaby
 *
 * 2012-12-28下午05:25:18
 * email toybaby@mail2.tenwa.com.cn
 * function:
 *
 */
public class ConditionBean {
	private String id;// 主键
	private String contract_id;// 合同id
	private String proj_id;// 项目id
	private String equip_amt;// 设备金额
	private String currency;// 货币类型
	private String lease_money;// 租赁本金
	private String lease_amt_date;//设备款支付日期
	private String first_payment_ratio;// 首付款比例
	private String first_payment;// 首付款
	
	private String caution_money_ratio;// 保证金比例
	private String caution_money;// 保证金
	private String caution_deduction_ratio;// 保证金抵扣比例
	private String caution_deduction_money;// 保证金抵扣金额
	private String actual_fund;// 净融资额
	private String actual_fund_ratio;// 净融资额比例

	private String handling_charge_ratio;// 手续费比例
	private String handling_charge;// 手续费
	private String management_fee;// 管理费
	private String management_fee_ratio;//管理费比例
	private String nominal_price;// 留购价款
	private String return_ratio;// 厂商返利比率
	private String amt_return;// 厂商返利

	// 新增
	private String assets_value;// 资产余值
	private String assess_adjust;// 考核调整
	private String ratio_param;// 本金公比、租金公比、本金公差、租金公差
	private String rent_start_date;//第一期租金尝付日

	private String rate_subsidy;// 利息补贴
	private String before_interest;// 租前息
	private String is_before_interest;//是否收取租前息
	private String before_interest_type;// 租前息 - 类型 是否算本
	private String discount_rate;// 贴现息
	private String consulting_fee_out;// 咨询费付出
	private String consulting_fee_in;// 咨询费收入
	private String other_income;// 其它收入
	private String other_expenditure;// 其它支出

	private String income_number;// 还租次数
	private String income_number_year;// 付租方式 月付、季付等
	private String lease_term;// 租赁期限（月）
	private String settle_method;// 租金计算方法
	private String period_type;// 付租类型先付/后付
	private String rate_float_type;// 利率浮动类型
	private String rate_float_amt;// 利率调整值

	private String adjust_style;// 调息方式
	private String year_rate;// 租赁年利率
	private String pena_rate;// 罚息利率
	private String start_date;// 预计起租日
	private String income_day;// 每月偿付日
	private String end_date;// 预计结束日

	private String irr;// 实际Irr,财务填写
	private String plan_irr;// 年内部收益率IRR,预计IRR
	private String free_defa_inter_day;// 逾期宽限日
	private String total_amt;// 租赁合同总金额 -- 租金总额
	private String apply_contract_number;// 适用合同份数
	private String insure_type;// 投保方式
	private String into_batch;// 是否批量调息
	private String insure;//保险公司
	private String insure_money;// 保费金额
	private User creator;// 创建人
	private String createDate;// 创建时间
	private String modifyDate;// 修改人
	private User modificator;// 修改时间

	// 2012-12-27 Jaffe 新增 开票方式|是否达标|达标Irr
	private String invoice_type;// 开票方式
	private String StandardF;// 是否达标
	private String StandardIrr;// 达标Irr

	// 2012-1-4 sys新增 保险收取方式
	private String insure_pay_type;
	// 2012-8-9 Jaffe 新增根据华胜需求
	private String caution_sfjx;// 保证金是否计息
	private String caution_inter_floattype;// 与银行维持一样，浮动
	private String caution_inter_floatamt;// 浮动值
	private String caution_oper_way;// 保证金处理方式 退款、抵扣

	// 2012-10-30 Jaffe 新增三个字段( 贷款利息率\ 厂商保证金比例\ 厂商保证金)
	private String loan_ratio;// 贷款利息率
	private String supplier_caution_money_ratio;// 厂商保证金比例
	private String supplier_caution_money;// 厂商保证金
	private String cust_caution_money_ratio;//承租人保证金
	private String cust_caution_money;//承租人保证金
	private String if_leas;// 租赁公司收取 - 选择是|否
	private String grace;//宽限期
	private String first_payment_total;//期初付款总计
	
	/**
	 * 无参构造函数
	 */
	public ConditionBean() {
		super();
	}

	/**
	 * @param doc_id
	 * @param proj_id
	 * @param equip_amt
	 * @param currency
	 * @param lease_money
	 * @param first_payment
	 * @param caution_money
	 * @param actual_fund
	 * @param actual_fund_ratio
	 * @param handling_charge
	 * @param management_fee
	 * @param nominalprice
	 * @param return_amt
	 * @param rate_subsidy
	 * @param before_interest
	 * @param discount_rate
	 * @param consulting_fee_out
	 * @param consulting_fee_in
	 * @param other_income
	 * @param other_expenditure
	 * @param income_number
	 * @param income_number_year
	 * @param lease_term
	 * @param settle_method
	 * @param period_type
	 * @param rate_float_type
	 * @param rate_float_amt
	 * @param adjust_style
	 * @param year_rate
	 * @param pena_rate
	 * @param start_date
	 * @param income_day
	 * @param end_date
	 * @param plan_irr
	 * @param free_defa_inter_day
	 * @param insure_type
	 * @param into_batch
	 * @param insure_money
	 * @param creator
	 * @param create_date
	 * @param modify_date
	 * @param modificator
	 */
	public ConditionBean(String doc_id, String proj_id, String equip_amt,
			String currency, String lease_money, String first_payment,
			String caution_money, String actual_fund, String actual_fund_ratio,
			String handling_charge, String management_fee, String nominal_price,
			String return_amt, String rate_subsidy, String before_interest,
			String discount_rate, String consulting_fee_out,
			String consulting_fee_in, String other_income,
			String other_expenditure, String income_number,
			String income_number_year, String lease_term, String settle_method,
			String period_type, String rate_float_type, String rate_float_amt,
			String adjust_style, String year_rate, String pena_rate,
			String start_date, String income_day, String end_date,
			String rent_start_date, String plan_irr,
			String free_defa_inter_day, String insure_type, String into_batch,
			String insure_money, String assets_value, String assess_adjust,
			String ratio_param, String creator, String create_date,
			String modify_date, String modificator) {
		super();
		this.proj_id = proj_id;
		this.equip_amt = equip_amt;
		this.currency = currency;
		this.lease_money = lease_money;
		this.first_payment = first_payment;
		// 首付款比例 = 首付款/设备金额
		this.first_payment_ratio = MathExtend.divide(this.first_payment,
				this.equip_amt, 6);
		this.caution_money = caution_money;
		// 保证金比例 = 保证金/设备金额
		this.caution_money_ratio = MathExtend.divide(this.caution_money,
				this.equip_amt, 6);
		this.actual_fund = actual_fund;
		this.actual_fund_ratio = actual_fund_ratio;
		this.handling_charge = handling_charge;
		// 手续费比例 = 手续费/设备金额
		this.handling_charge_ratio = MathExtend.divide(this.handling_charge,
				this.equip_amt, 6);
		this.management_fee = management_fee;
		this.nominal_price = nominal_price;

		this.rate_subsidy = rate_subsidy;
		this.before_interest = before_interest;
		this.discount_rate = discount_rate;
		this.consulting_fee_out = consulting_fee_out;
		this.consulting_fee_in = consulting_fee_in;
		this.other_income = other_income;
		this.other_expenditure = other_expenditure;
		this.income_number = income_number;
		this.income_number_year = income_number_year;
		this.lease_term = lease_term;
		this.settle_method = settle_method;
		this.period_type = period_type;
		this.rate_float_type = rate_float_type;
		this.rate_float_amt = rate_float_amt;
		this.adjust_style = adjust_style;
		this.year_rate = year_rate;
		this.pena_rate = pena_rate;
		this.start_date = start_date;
		this.income_day = income_day;
		this.end_date = end_date;
		this.rent_start_date = rent_start_date;
		this.plan_irr = plan_irr;
		this.free_defa_inter_day = free_defa_inter_day;
		this.insure_type = insure_type;
		this.into_batch = into_batch;
		this.insure_money = insure_money;
		this.assets_value = assets_value;
		this.assess_adjust = assess_adjust;
		this.ratio_param = ratio_param;
	}

	/**
	 * @return the if_leas
	 */
	public String getIf_leas() {
		return if_leas;
	}

	/**
	 * @param if_leas
	 *            the if_leas to set
	 */
	public void setIf_leas(String if_leas) {
		this.if_leas = if_leas;
	}

	/**
	 * @return the loan_ratio
	 */
	public String getLoan_ratio() {
		return loan_ratio;
	}

	/**
	 * @param loan_ratio
	 *            the loan_ratio to set
	 */
	public void setLoan_ratio(String loan_ratio) {
		this.loan_ratio = loan_ratio;
	}

	public String getLease_amt_date() {
		return lease_amt_date;
	}

	public void setLease_amt_date(String leaseAmtDate) {
		lease_amt_date = leaseAmtDate;
	}


	/**
	 * @return the invoice_type
	 */
	public String getInvoice_type() {
		return invoice_type;
	}

	/**
	 * @param invoice_type
	 *            the invoice_type to set
	 */
	public void setInvoice_type(String invoice_type) {
		this.invoice_type = invoice_type;
	}

	public String getSupplier_caution_money_ratio() {
		return supplier_caution_money_ratio;
	}

	public void setSupplier_caution_money_ratio(String supplierCautionMoneyRatio) {
		supplier_caution_money_ratio = supplierCautionMoneyRatio;
	}

	public String getSupplier_caution_money() {
		return supplier_caution_money;
	}

	public void setSupplier_caution_money(String supplierCautionMoney) {
		supplier_caution_money = supplierCautionMoney;
	}

	/**
	 * @return the standardF
	 */
	public String getStandardF() {
		return StandardF;
	}

	/**
	 * @param standardF
	 *            the standardF to set
	 */
	public void setStandardF(String standardF) {
		StandardF = standardF;
	}

	/**
	 * @return the standardIrr
	 */
	public String getStandardIrr() {
		return StandardIrr;
	}

	/**
	 * @param standardIrr
	 *            the standardIrr to set
	 */
	public void setStandardIrr(String standardIrr) {
		StandardIrr = standardIrr;
	}

	/**
	 * @return the irr
	 */
	public String getIrr() {
		return irr;
	}

	/**
	 * @param irr
	 *            the irr to set
	 */
	public void setIrr(String irr) {
		this.irr = irr;
	}

	/**
	 * @return the contract_id
	 */
	public String getContract_id() {
		return contract_id;
	}

	/**
	 * @param contract_id
	 *            the contract_id to set
	 */
	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}

	/**
	 * @return the assets_value
	 */
	public String getAssets_value() {
		return assets_value;
	}

	/**
	 * @param assets_value
	 *            the assets_value to set
	 */
	public void setAssets_value(String assets_value) {
		this.assets_value = assets_value;
	}

	/**
	 * @return the assess_adjust
	 */
	public String getAssess_adjust() {
		return assess_adjust;
	}

	/**
	 * @param assess_adjust
	 *            the assess_adjust to set
	 */
	public void setAssess_adjust(String assess_adjust) {
		this.assess_adjust = assess_adjust;
	}


	/**
	 * @return the ratio_param
	 */
	public String getRatio_param() {
		return ratio_param;
	}

	/**
	 * @param ratio_param
	 *            the ratio_param to set
	 */
	public void setRatio_param(String ratio_param) {
		this.ratio_param = ratio_param;
	}





	/**
	 * @return the proj_id
	 */
	public String getProj_id() {
		return proj_id;
	}

	/**
	 * @param proj_id
	 *            the proj_id to set
	 */
	public void setProj_id(String proj_id) {
		this.proj_id = proj_id;
	}

	/**
	 * @return the equip_amt
	 */
	public String getEquip_amt() {
		return equip_amt;
	}

	/**
	 * @param equip_amt
	 *            the equip_amt to set
	 */
	public void setEquip_amt(String equip_amt) {
		this.equip_amt = equip_amt;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the lease_money
	 */
	public String getLease_money() {
		return lease_money;
	}

	/**
	 * @param lease_money
	 *            the lease_money to set
	 */
	public void setLease_money(String lease_money) {
		this.lease_money = lease_money;
	}

	/**
	 * @return the first_payment_ratio
	 */
	public String getFirst_payment_ratio() {
		return first_payment_ratio;
	}

	/**
	 * @param first_payment_ratio
	 *            the first_payment_ratio to set
	 */
	public void setFirst_payment_ratio(String first_payment_ratio) {
		this.first_payment_ratio = first_payment_ratio;
	}

	/**
	 * @return the first_payment
	 */
	public String getFirst_payment() {
		return first_payment;
	}

	/**
	 * @param first_payment
	 *            the first_payment to set
	 */
	public void setFirst_payment(String first_payment) {
		this.first_payment = first_payment;
	}

	/**
	 * @return the caution_money_ratio
	 */
	public String getCaution_money_ratio() {
		return caution_money_ratio;
	}

	/**
	 * @param caution_money_ratio
	 *            the caution_money_ratio to set
	 */
	public void setCaution_money_ratio(String caution_money_ratio) {
		this.caution_money_ratio = caution_money_ratio;
	}

	/**
	 * @return the caution_money
	 */
	public String getCaution_money() {
		return caution_money;
	}

	/**
	 * @param caution_money
	 *            the caution_money to set
	 */
	public void setCaution_money(String caution_money) {
		this.caution_money = caution_money;
	}

	/**
	 * @return the caution_deduction_ratio
	 */
	public String getCaution_deduction_ratio() {
		return caution_deduction_ratio;
	}

	/**
	 * @param caution_deduction_ratio
	 *            the caution_deduction_ratio to set
	 */
	public void setCaution_deduction_ratio(String caution_deduction_ratio) {
		this.caution_deduction_ratio = caution_deduction_ratio;
	}

	/**
	 * @return the caution_deduction_money
	 */
	public String getCaution_deduction_money() {
		return caution_deduction_money;
	}

	/**
	 * @param caution_deduction_money
	 *            the caution_deduction_money to set
	 */
	public void setCaution_deduction_money(String caution_deduction_money) {
		this.caution_deduction_money = caution_deduction_money;
	}

	/**
	 * @return the actual_fund
	 */
	public String getActual_fund() {
		return actual_fund;
	}

	/**
	 * @param actual_fund
	 *            the actual_fund to set
	 */
	public void setActual_fund(String actual_fund) {
		this.actual_fund = actual_fund;
	}

	/**
	 * @return the actual_fund_ratio
	 */
	public String getActual_fund_ratio() {
		return actual_fund_ratio;
	}

	/**
	 * @param actual_fund_ratio
	 *            the actual_fund_ratio to set
	 */
	public void setActual_fund_ratio(String actual_fund_ratio) {
		this.actual_fund_ratio = actual_fund_ratio;
	}

	/**
	 * @return the handling_charge_ratio
	 */
	public String getHandling_charge_ratio() {
		return handling_charge_ratio;
	}

	/**
	 * @param handling_charge_ratio
	 *            the handling_charge_ratio to set
	 */
	public void setHandling_charge_ratio(String handling_charge_ratio) {
		this.handling_charge_ratio = handling_charge_ratio;
	}

	/**
	 * @return the handling_charge
	 */
	public String getHandling_charge() {
		return handling_charge;
	}

	/**
	 * @param handling_charge
	 *            the handling_charge to set
	 */
	public void setHandling_charge(String handling_charge) {
		this.handling_charge = handling_charge;
	}

	/**
	 * @return the management_fee
	 */
	public String getManagement_fee() {
		return management_fee;
	}

	/**
	 * @param management_fee
	 *            the management_fee to set
	 */
	public void setManagement_fee(String management_fee) {
		this.management_fee = management_fee;
	}
	

	public String getNominal_price() {
		return nominal_price;
	}

	public void setNominal_price(String nominalPrice) {
		nominal_price = nominalPrice;
	}

	/**
	 * @return the return_ratio
	 */
	public String getReturn_ratio() {
		return return_ratio;
	}

	/**
	 * @param return_ratio
	 *            the return_ratio to set
	 */
	public void setReturn_ratio(String return_ratio) {
		this.return_ratio = return_ratio;
	}


	/**
	 * @param return_amt
	 *            the return_amt to set
	 */

	/**
	 * @return the rate_subsidy
	 */
	public String getRate_subsidy() {
		return rate_subsidy;
	}

	/**
	 * @param rate_subsidy
	 *            the rate_subsidy to set
	 */
	public void setRate_subsidy(String rate_subsidy) {
		this.rate_subsidy = rate_subsidy;
	}

	/**
	 * @return the before_interest
	 */
	public String getBefore_interest() {
		return before_interest;
	}

	/**
	 * @param before_interest
	 *            the before_interest to set
	 */
	public void setBefore_interest(String before_interest) {
		this.before_interest = before_interest;
	}

	/**
	 * @return the discount_rate
	 */
	public String getDiscount_rate() {
		return discount_rate;
	}

	/**
	 * @param discount_rate
	 *            the discount_rate to set
	 */
	public void setDiscount_rate(String discount_rate) {
		this.discount_rate = discount_rate;
	}

	/**
	 * @return the consulting_fee_out
	 */
	public String getConsulting_fee_out() {
		return consulting_fee_out;
	}

	/**
	 * @param consulting_fee_out
	 *            the consulting_fee_out to set
	 */
	public void setConsulting_fee_out(String consulting_fee_out) {
		this.consulting_fee_out = consulting_fee_out;
	}

	/**
	 * @return the consulting_fee_in
	 */
	public String getConsulting_fee_in() {
		return consulting_fee_in;
	}

	/**
	 * @param consulting_fee_in
	 *            the consulting_fee_in to set
	 */
	public void setConsulting_fee_in(String consulting_fee_in) {
		this.consulting_fee_in = consulting_fee_in;
	}

	/**
	 * @return the other_income
	 */
	public String getOther_income() {
		return other_income;
	}

	/**
	 * @param other_income
	 *            the other_income to set
	 */
	public void setOther_income(String other_income) {
		this.other_income = other_income;
	}

	/**
	 * @return the other_expenditure
	 */
	public String getOther_expenditure() {
		return other_expenditure;
	}

	/**
	 * @param other_expenditure
	 *            the other_expenditure to set
	 */
	public void setOther_expenditure(String other_expenditure) {
		this.other_expenditure = other_expenditure;
	}

	/**
	 * @return the income_number
	 */
	public String getIncome_number() {
		return income_number;
	}

	/**
	 * @param income_number
	 *            the income_number to set
	 */
	public void setIncome_number(String income_number) {
		this.income_number = income_number;
	}

	/**
	 * @return the income_number_year
	 */
	public String getIncome_number_year() {
		return income_number_year;
	}

	/**
	 * @param income_number_year
	 *            the income_number_year to set
	 */
	public void setIncome_number_year(String income_number_year) {
		this.income_number_year = income_number_year;
	}

	/**
	 * @return the lease_term
	 */
	public String getLease_term() {
		return lease_term;
	}

	/**
	 * @param lease_term
	 *            the lease_term to set
	 */
	public void setLease_term(String lease_term) {
		this.lease_term = lease_term;
	}

	/**
	 * @return the settle_method
	 */
	public String getSettle_method() {
		return settle_method;
	}

	/**
	 * @param settle_method
	 *            the settle_method to set
	 */
	public void setSettle_method(String settle_method) {
		this.settle_method = settle_method;
	}

	/**
	 * @return the period_type
	 */
	public String getPeriod_type() {
		return period_type;
	}

	/**
	 * @param period_type
	 *            the period_type to set
	 */
	public void setPeriod_type(String period_type) {
		this.period_type = period_type;
	}

	/**
	 * @return the rate_float_type
	 */
	public String getRate_float_type() {
		return rate_float_type;
	}

	/**
	 * @param rate_float_type
	 *            the rate_float_type to set
	 */
	public void setRate_float_type(String rate_float_type) {
		this.rate_float_type = rate_float_type;
	}

	/**
	 * @return the rate_float_amt
	 */
	public String getRate_float_amt() {
		return rate_float_amt;
	}

	/**
	 * @param rate_float_amt
	 *            the rate_float_amt to set
	 */
	public void setRate_float_amt(String rate_float_amt) {
		this.rate_float_amt = rate_float_amt;
	}

	/**
	 * @return the adjust_style
	 */
	public String getAdjust_style() {
		return adjust_style;
	}

	/**
	 * @param adjust_style
	 *            the adjust_style to set
	 */
	public void setAdjust_style(String adjust_style) {
		this.adjust_style = adjust_style;
	}

	/**
	 * @return the year_rate
	 */
	public String getYear_rate() {
		return year_rate;
	}

	/**
	 * @param year_rate
	 *            the year_rate to set
	 */
	public void setYear_rate(String year_rate) {
		this.year_rate = year_rate;
	}

	/**
	 * @return the pena_rate
	 */
	public String getPena_rate() {
		return pena_rate;
	}

	/**
	 * @param pena_rate
	 *            the pena_rate to set
	 */
	public void setPena_rate(String pena_rate) {
		this.pena_rate = pena_rate;
	}

	/**
	 * @return the start_date
	 */
	public String getStart_date() {
		return start_date;
	}

	/**
	 * @param start_date
	 *            the start_date to set
	 */
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	/**
	 * @return the income_day
	 */
	public String getIncome_day() {
		return income_day;
	}

	/**
	 * @param income_day
	 *            the income_day to set
	 */
	public void setIncome_day(String income_day) {
		this.income_day = income_day;
	}

	/**
	 * @return the end_date
	 */
	public String getEnd_date() {
		return end_date;
	}

	/**
	 * @param end_date
	 *            the end_date to set
	 */
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	/**
	 * @return the plan_irr
	 */
	public String getPlan_irr() {
		return plan_irr;
	}

	/**
	 * @param plan_irr
	 *            the plan_irr to set
	 */
	public void setPlan_irr(String plan_irr) {
		this.plan_irr = plan_irr;
	}

	/**
	 * @return the free_defa_inter_day
	 */
	public String getFree_defa_inter_day() {
		return free_defa_inter_day;
	}

	/**
	 * @param free_defa_inter_day
	 *            the free_defa_inter_day to set
	 */
	public void setFree_defa_inter_day(String free_defa_inter_day) {
		this.free_defa_inter_day = free_defa_inter_day;
	}

	/**
	 * @return the total_amt
	 */
	public String getTotal_amt() {
		return total_amt;
	}

	/**
	 * @param total_amt
	 *            the total_amt to set
	 */
	public void setTotal_amt(String total_amt) {
		this.total_amt = total_amt;
	}

	/**
	 * @return the rent_start_date
	 */
	public String getRent_start_date() {
		return rent_start_date;
	}

	/**
	 * @param rent_start_date
	 *            the rent_start_date to set
	 */
	public void setRent_start_date(String rent_start_date) {
		this.rent_start_date = rent_start_date;
	}

	/**
	 * @return the amt_return
	 */
	public String getAmt_return() {
		return amt_return;
	}

	/**
	 * @param amt_return
	 *            the amt_return to set
	 */
	public void setAmt_return(String amt_return) {
		this.amt_return = amt_return;
	}

	/**
	 * @return the apply_contract_number
	 */
	public String getApply_contract_number() {
		return apply_contract_number;
	}

	/**
	 * @param apply_contract_number
	 *            the apply_contract_number to set
	 */
	public void setApply_contract_number(String apply_contract_number) {
		this.apply_contract_number = apply_contract_number;
	}

	/**
	 * @return the insure_type
	 */
	public String getInsure_type() {
		return insure_type;
	}

	/**
	 * @param insure_type
	 *            the insure_type to set
	 */
	public void setInsure_type(String insure_type) {
		this.insure_type = insure_type;
	}

	/**
	 * @return the into_batch
	 */
	public String getInto_batch() {
		return into_batch;
	}

	/**
	 * @param into_batch
	 *            the into_batch to set
	 */
	public void setInto_batch(String into_batch) {
		this.into_batch = into_batch;
	}

	/**
	 * @return the insure_money
	 */
	public String getInsure_money() {
		return insure_money;
	}

	/**
	 * @param insure_money
	 *            the insure_money to set
	 */
	public void setInsure_money(String insure_money) {
		this.insure_money = insure_money;
	}

	/**
	 * @return the creator
	 */
	public User getCreator() {
		return creator;
	}

	/**
	 * @param creator
	 *            the creator to set
	 */
	public void setCreator(User creator) {
		this.creator = creator;
	}

	/**
	 * @return the before_interest_type
	 */
	public String getBefore_interest_type() {
		return before_interest_type;
	}

	/**
	 * @param before_interest_type
	 *            the before_interest_type to set
	 */
	public void setBefore_interest_type(String before_interest_type) {
		this.before_interest_type = before_interest_type;
	}

	/**
	 * 
	 * @return insure_pay_type
	 */
	public String getInsure_pay_type() {
		return insure_pay_type;
	}

	public void setInsure_pay_type(String insurePayType) {
		insure_pay_type = insurePayType;
	}
	public String getCust_caution_money_ratio() {
		return cust_caution_money_ratio;
	}

	public void setCust_caution_money_ratio(String custCautionMoneyRatio) {
		cust_caution_money_ratio = custCautionMoneyRatio;
	}

	public String getCust_caution_money() {
		return cust_caution_money;
	}

	public void setCust_caution_money(String custCautionMoney) {
		cust_caution_money = custCautionMoney;
	}
	/**
	 * @return the caution_sfjx
	 */
	public String getCaution_sfjx() {
		return caution_sfjx;
	}

	/**
	 * @param caution_sfjx
	 *            the caution_sfjx to set
	 */
	public void setCaution_sfjx(String caution_sfjx) {
		this.caution_sfjx = caution_sfjx;
	}

	/**
	 * @return the caution_inter_floattype
	 */
	public String getCaution_inter_floattype() {
		return caution_inter_floattype;
	}

	/**
	 * @param caution_inter_floattype
	 *            the caution_inter_floattype to set
	 */
	public void setCaution_inter_floattype(String caution_inter_floattype) {
		this.caution_inter_floattype = caution_inter_floattype;
	}

	/**
	 * @return the caution_inter_floatamt
	 */
	public String getCaution_inter_floatamt() {
		return caution_inter_floatamt;
	}

	/**
	 * @param caution_inter_floatamt
	 *            the caution_inter_floatamt to set
	 */
	public void setCaution_inter_floatamt(String caution_inter_floatamt) {
		this.caution_inter_floatamt = caution_inter_floatamt;
	}

	/**
	 * @return the caution_oper_way
	 */
	public String getCaution_oper_way() {
		return caution_oper_way;
	}

	/**
	 * @param caution_oper_way
	 *            the caution_oper_way to set
	 */
	public void setCaution_oper_way(String caution_oper_way) {
		this.caution_oper_way = caution_oper_way;
	}

	public String getInsure() {
		return insure;
	}

	public void setInsure(String insure) {
		this.insure = insure;
	}

	public String getManagement_fee_ratio() {
		return management_fee_ratio;
	}

	public void setManagement_fee_ratio(String managementFeeRatio) {
		management_fee_ratio = managementFeeRatio;
	}

	public String getIs_before_interest() {
		return is_before_interest;
	}

	public void setIs_before_interest(String isBeforeInterest) {
		is_before_interest = isBeforeInterest;
	}

	public String getGrace() {
		return grace;
	}

	public void setGrace(String grace) {
		this.grace = grace;
	}

	public String getFirst_payment_total() {
		return first_payment_total;
	}

	public void setFirst_payment_total(String firstPaymentTotal) {
		first_payment_total = firstPaymentTotal;
	}

	
	 /**
	 * @param id the id to set
	 **/
	
	public void setId(String id) {
		this.id = id;
	}

	
	 /**
	 * id
	 * @return the id
	 * @since 1.0.0
	 **/
	
	public String getId() {
		return id;
	}
	public String getCreateDate() {
		return createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public User getModificator() {
		return modificator;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setModificator(User modificator) {
		this.modificator = modificator;
	}
}