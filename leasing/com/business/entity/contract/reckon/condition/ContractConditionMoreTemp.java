package com.business.entity.contract.reckon.condition;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.contract.ContractInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-7下午03:33:16
 * @info 合同多次起租商务条件
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "合同多次起租商务条件(临时)")
@Table(name="CONTRACT_CONDITION_MORE_TEMP")
@Deprecated
public class ContractConditionMoreTemp {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="合同编号")
	@OneToOne(targetEntity=ContractInfo.class)
	@JoinColumn(name="CONTRACT_ID")
	private ContractInfo contractId;
	
	@FieldName(name="报价编号")
	@Column(name="DOC_ID")
	private String docId;

	@FieldName(name="客户初始报价测算编号")
	@Column(name="QUOT_ID")
	@Deprecated
	private String quotId;
	
	@FieldName(name="多次起租编号")
	@Column(name="ONHIRE_ID")
	@Deprecated
	private String onhireId;
	
	@FieldName(name="设备款")
	@Column(name="EQUIP_AMT",precision=22,scale=2)
	private BigDecimal equipAmt;

	@FieldName(name="融资款")
	@Column(name="LEASE_AMT",precision=22,scale=2)
	private BigDecimal leaseAmt;
	
	@FieldName(name="设备款支付日期")
	@Column(name="LEASE_AMT_DATE",length=20)
	private String   leaseAmtDate;

	@FieldName(name="首付款比率")
	@Column(name="FIRST_PAYMENT_RATIO",precision=22,scale=6)
	private BigDecimal firstPaymentRatio;

	@FieldName(name="首付款")
	@Column(name="FIRST_PAYMENT",precision=22,scale=2)
	private BigDecimal firstPayment;
	
	@FieldName(name="净融资额")
	@Column(name="CLEAN_LEASE_MONEY",precision=22,scale=2)
	private BigDecimal cleanLeaseMoney;

	@FieldName(name="租赁本金")
	@Column(name="LEASE_MONEY",precision=22,scale=2)
	@Deprecated
	private BigDecimal leaseMoney;
	
	@FieldName(name="租赁年利率")
	@Column(name="YEAR_RATE",precision=22,scale=6)
	private BigDecimal yearRate;

	@FieldName(name="期初（期末）支付")
	@ManyToOne
	@JoinColumn(name="PERIOD_TYPE")
	private DictionaryData periodType;

	@FieldName(name="年还租次数")
	@JoinColumn(name="INCOME_NUMBER_YEAR")
	@ManyToOne
	private DictionaryData incomeNumberYear;
	
	@FieldName(name="还租次数")
	@Column(name="INCOME_NUMBER")
	private Integer incomeNumber;

	@FieldName(name="租赁期限（月）")
	@Column(name="LEASE_TERM")
	private Integer leaseTerm;
	
	@FieldName(name="测算方式")
	@JoinColumn(name="SETTLE_METHOD")
	@ManyToOne
	private DictionaryData settleMethod;

	@FieldName(name="预计起租日")
	@Column(name="START_DATE_",length=20)
	private String   startDate;

	@FieldName(name="名义货价")
	@Column(name="NOMINAL_PRICE",precision=22,scale=2)
	private BigDecimal nominalPrice;

	@FieldName(name="罚息利率")
	@Column(name="PENA_RATE",precision=22,scale=6)
	private BigDecimal penaRate;

	@FieldName(name="利率浮动类型")
	@JoinColumn(name="RATE_FLOAT_TYPE")
	@ManyToOne
	private DictionaryData rateFloatType;

	@FieldName(name="利率调整值")
	@Column(name="RATE_FLOAT_AMT",precision=22,scale=6)
	private BigDecimal rateFloatAmt;

	@FieldName(name="调息方式")
	@JoinColumn(name="ADJUST_STYLE")
	@ManyToOne
	private DictionaryData adjustStyle;

	@FieldName(name="保证金比率")
	@Column(name="CAUTION_MONEY_RATIO",precision=22,scale=6)
	private BigDecimal cautionMoneyRatio;
	
	@FieldName(name="租赁保证金")
	@Column(name="CAUTION_MONEY",precision=22,scale=2)
	private BigDecimal cautionMoney;

	@FieldName(name="保证金抵扣比率")
	@Column(name="CAUTION_DEDUCTION_RATIO",precision=22,scale=6)
	private BigDecimal cautionDeductionRatio;
	
	@FieldName(name="保证金抵扣金额")
	@Column(name="CAUTION_DEDUCTION_MONEY",precision=22,scale=2)
	private BigDecimal cautionDeductionMoney;

	@FieldName(name="手续费比率")
	@Column(name="HANDLING_CHARGE_MONEY_RATIO",precision=22,scale=6)
	private BigDecimal handlingChargeMoneyRatio;

	@FieldName(name="手续费")
	@Column(name="HANDLING_CHARGE_MONEY",precision=22,scale=2)
	private BigDecimal handlingChargeMoney;

	@FieldName(name="保险公司")
	@Column(name="INSURER")
	private String insurer;
	
	@ManyToOne
	@FieldName(name="保险方式(德银)")
	@JoinColumn(name="insurer_Type")
	private DictionaryData insurerType;
	
	@FieldName(name="保险费")
	@Column(name="INSURE_MONEY",precision=22,scale=2)
	private BigDecimal insureMoney;
	
	@FieldName(name="管理费比率")
	@Column(name="MANAGEMENT_MONEY_RATIO",precision=22,scale=6)
	private BigDecimal managementMoneyRatio;
	
	@FieldName(name="管理费")
	@Column(name="MANAGEMENT_MONEY",precision=22,scale=2)
	private BigDecimal managementMoney;
	
	@FieldName(name="内部收益率")
	@Column(name="IRR",precision=22,scale=6)
	private BigDecimal irr;
	
	@FieldName(name="财务收益率")
	@Column(name="PLAN_IRR",precision=22,scale=6)
	private BigDecimal planIrr;
	
	@FieldName(name="厂商返利")
	@Column(name="RETURN_AMT",precision=22,scale=2)
	private BigDecimal returnAmt;

	@FieldName(name="期初付总计")
	@Column(name="FIRST_PAYMENT_TOTAL",precision=22,scale=2)
	private BigDecimal firstPaymentTotal;

	@FieldName(name="每月偿付日")
	@Column(name="INCOME_DAY")
	@Deprecated
	private int   incomeDay;

	@FieldName(name="咨询费")
	@Column(name="CONSULTING_MONEY",precision=22,scale=2)
	private BigDecimal consultingMoney;

	@FieldName(name="租前息")
	@Column(name="BEFORE_INTEREST",precision=22,scale=2)
	private BigDecimal beforeInterest;

	@FieldName(name="利率调整系数")
	@Column(name="RATE_ADJUSTMENT_MODULUS",precision=22,scale=6)
	private BigDecimal rateAdjustmentModulus;

	@FieldName(name="延迟期数")
	@Column(name="DELAY_")
	private Integer delay;
	
	@FieldName(name="宽限期数")
	@Column(name="GRACE")
	private Integer grace;
	
	@FieldName(name="其它收入")
	@Column(name="OTHER_INCOME",precision=22,scale=2)
	private BigDecimal otherIncome;
	
	@FieldName(name="其它支出")
	@Column(name="OTHER_EXPENDITURE",precision=22,scale=2)
	private BigDecimal otherExpenditure;
	
	@FieldName(name="免罚息天数")
	@Column(name="FREE_DEFA_INTER_DAY")
	private Integer freeDefaInterDay;
	
	@FieldName(name="设备残值")
	@Column(name="EQUIP_END_VALUE",precision=22,scale=2)
	private BigDecimal equipEndValue;
	
	@FieldName(name="是否收租前息:是/否--APPSTATICUTIL类里声明")
	@Column(name="IS_BEFORE_INTEREST")
	private int isBeforeInterest;

	@FieldName(name="预计结束日期")
	@Column(name="END_DATE", length=20)
	private String endDate;

	@FieldName(name="实际起租日")
	@Column(name="ACTUAL_START_DATE", length=20)
	private String actualStartDate;
	
	@FieldName(name="实际结束日期")
	@Column(name="ACTUAL_END_DATE", length=20)
	private String actualEndDate;
	
	@FieldName(name="财务起租日")
	@Column(name="ACCOUNTING_START_DATE", length=20)
	private String accountingStartDate;
	
	@FieldName(name="是否合并起租")
	@Column(name="IS_MERGER")
	private int isMerger;
	
	@FieldName(name="剩余本金")//Column_1
	@Column(name="LAST_CORPUS",precision=22,scale=2)
	private BigDecimal lastCorpus;
	
	@FieldName(name="承租人保证金比例")//Column_2
	@Column(name="CAUTION_MONEY_RATIO_C",precision=22,scale=6)
	private BigDecimal cautionMoneyRatioC;
	
	@FieldName(name="承租人保证金")//Column_3
	@Column(name="CAUTION_MONEY_C",precision=22,scale=2)
	private BigDecimal custCautionMoneyC;
	
	@FieldName(name="供应商保证金比例")//Column_4
	@Column(name="CAUTION_MONEY_RATIO_S",precision=22,scale=6)
	private BigDecimal cautionMoneyRatioS;
	
	@FieldName(name="供应商保证金")//Column_5
	@Column(name="CAUTION_MONEY_S",precision=22,scale=2)
	private BigDecimal cautionMoneyS;
	
	@FieldName(name="第一期租金支付日")//Column_5
	@Column(name="FIRST_PLAN_DATE", length=20)
	private String firstPlanDate;
	
	@FieldName(name="预收租金比例")//Column_7
	@Column(name="EXPECT_RENT_RATIO",precision=22,scale=6)
	private BigDecimal expectRentRatio;
	
	@FieldName(name="预收租金金额")//Column_8
	@Column(name="EXPECT_RENT",precision=22,scale=2)
	private BigDecimal expectRent;
	
	@FieldName(name="预收租金抵扣比例")//Column_9
	@Column(name="EXPECT_RENT_DEDUCTION_RATIO",precision=22,scale=6)
	private BigDecimal expectRentDeductionRatio;
	
	@FieldName(name="预收租金抵扣金额")//Column_10
	@Column(name="EXPECT_RENT_DEDUCTION",precision=22,scale=2)
	private BigDecimal expectRentDeduction;
	
	@FieldName(name="是否上牌[S](德银)")
	@Column(name="IS_REGISTRATION",length=2)
	private String		isRegistration;
	
	@FieldName(name="是否抵押[S](德银)")
	@Column(name="IS_GUARANTY",length=2)
	private String		isGuaranty;
	
	@FieldName(name="GPS费用(德银)")
	@Column(name="GPS_MONEY",precision=22,scale=2)
	private BigDecimal		gpsMoney;
	
	@ManyToOne
	@FieldName(name="创建人")
	@JoinColumn(name="CREATOR_")
	private User creator;
	
	@FieldName(name="创建时间")
	@Column(name="CREATE_DATE", length=20)	
	private String createDate;
	
	@ManyToOne
	@FieldName(name="修改人")
	@JoinColumn(name="MODIFICATOR_")
	private User modificator;
	
	@FieldName(name="修改时间")
	@Column(name="MODIFY_DATE", length=20)	
	private String modifyDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ContractInfo getContractId() {
		return contractId;
	}

	public void setContractId(ContractInfo contractId) {
		this.contractId = contractId;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getQuotId() {
		return quotId;
	}

	public void setQuotId(String quotId) {
		this.quotId = quotId;
	}

	public String getOnhireId() {
		return onhireId;
	}

	public void setOnhireId(String onhireId) {
		this.onhireId = onhireId;
	}

	public BigDecimal getEquipAmt() {
		return equipAmt;
	}

	public void setEquipAmt(BigDecimal equipAmt) {
		this.equipAmt = equipAmt;
	}

	public BigDecimal getLeaseAmt() {
		return leaseAmt;
	}

	public void setLeaseAmt(BigDecimal leaseAmt) {
		this.leaseAmt = leaseAmt;
	}

	public String getLeaseAmtDate() {
		return leaseAmtDate;
	}

	public void setLeaseAmtDate(String leaseAmtDate) {
		this.leaseAmtDate = leaseAmtDate;
	}

	public BigDecimal getFirstPaymentRatio() {
		return firstPaymentRatio;
	}

	public void setFirstPaymentRatio(BigDecimal firstPaymentRatio) {
		this.firstPaymentRatio = firstPaymentRatio;
	}

	public BigDecimal getFirstPayment() {
		return firstPayment;
	}

	public void setFirstPayment(BigDecimal firstPayment) {
		this.firstPayment = firstPayment;
	}

	public BigDecimal getCleanLeaseMoney() {
		return cleanLeaseMoney;
	}

	public void setCleanLeaseMoney(BigDecimal cleanLeaseMoney) {
		this.cleanLeaseMoney = cleanLeaseMoney;
	}

	public BigDecimal getLeaseMoney() {
		return leaseMoney;
	}

	public void setLeaseMoney(BigDecimal leaseMoney) {
		this.leaseMoney = leaseMoney;
	}

	public BigDecimal getYearRate() {
		return yearRate;
	}

	public void setYearRate(BigDecimal yearRate) {
		this.yearRate = yearRate;
	}

	public DictionaryData getPeriodType() {
		return periodType;
	}

	public void setPeriodType(DictionaryData periodType) {
		this.periodType = periodType;
	}

	public DictionaryData getIncomeNumberYear() {
		return incomeNumberYear;
	}

	public void setIncomeNumberYear(DictionaryData incomeNumberYear) {
		this.incomeNumberYear = incomeNumberYear;
	}

	public Integer getIncomeNumber() {
		return incomeNumber;
	}

	public void setIncomeNumber(Integer incomeNumber) {
		this.incomeNumber = incomeNumber;
	}

	public Integer getLeaseTerm() {
		return leaseTerm;
	}

	public void setLeaseTerm(Integer leaseTerm) {
		this.leaseTerm = leaseTerm;
	}

	public DictionaryData getSettleMethod() {
		return settleMethod;
	}

	public void setSettleMethod(DictionaryData settleMethod) {
		this.settleMethod = settleMethod;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public BigDecimal getNominalPrice() {
		return nominalPrice;
	}

	public void setNominalPrice(BigDecimal nominalPrice) {
		this.nominalPrice = nominalPrice;
	}

	public BigDecimal getPenaRate() {
		return penaRate;
	}

	public void setPenaRate(BigDecimal penaRate) {
		this.penaRate = penaRate;
	}

	public DictionaryData getRateFloatType() {
		return rateFloatType;
	}

	public void setRateFloatType(DictionaryData rateFloatType) {
		this.rateFloatType = rateFloatType;
	}

	public BigDecimal getRateFloatAmt() {
		return rateFloatAmt;
	}

	public void setRateFloatAmt(BigDecimal rateFloatAmt) {
		this.rateFloatAmt = rateFloatAmt;
	}

	public DictionaryData getAdjustStyle() {
		return adjustStyle;
	}

	public void setAdjustStyle(DictionaryData adjustStyle) {
		this.adjustStyle = adjustStyle;
	}

	public BigDecimal getCautionMoneyRatio() {
		return cautionMoneyRatio;
	}

	public void setCautionMoneyRatio(BigDecimal cautionMoneyRatio) {
		this.cautionMoneyRatio = cautionMoneyRatio;
	}

	public BigDecimal getCautionMoney() {
		return cautionMoney;
	}

	public void setCautionMoney(BigDecimal cautionMoney) {
		this.cautionMoney = cautionMoney;
	}

	public BigDecimal getCautionDeductionRatio() {
		return cautionDeductionRatio;
	}

	public void setCautionDeductionRatio(BigDecimal cautionDeductionRatio) {
		this.cautionDeductionRatio = cautionDeductionRatio;
	}

	public BigDecimal getCautionDeductionMoney() {
		return cautionDeductionMoney;
	}

	public void setCautionDeductionMoney(BigDecimal cautionDeductionMoney) {
		this.cautionDeductionMoney = cautionDeductionMoney;
	}

	public BigDecimal getHandlingChargeMoneyRatio() {
		return handlingChargeMoneyRatio;
	}

	public void setHandlingChargeMoneyRatio(BigDecimal handlingChargeMoneyRatio) {
		this.handlingChargeMoneyRatio = handlingChargeMoneyRatio;
	}

	public BigDecimal getHandlingChargeMoney() {
		return handlingChargeMoney;
	}

	public void setHandlingChargeMoney(BigDecimal handlingChargeMoney) {
		this.handlingChargeMoney = handlingChargeMoney;
	}

	public String getInsurer() {
		return insurer;
	}

	public void setInsurer(String insurer) {
		this.insurer = insurer;
	}

	public BigDecimal getInsureMoney() {
		return insureMoney;
	}

	public void setInsureMoney(BigDecimal insureMoney) {
		this.insureMoney = insureMoney;
	}

	public BigDecimal getManagementMoneyRatio() {
		return managementMoneyRatio;
	}

	public void setManagementMoneyRatio(BigDecimal managementMoneyRatio) {
		this.managementMoneyRatio = managementMoneyRatio;
	}

	public BigDecimal getManagementMoney() {
		return managementMoney;
	}

	public void setManagementMoney(BigDecimal managementMoney) {
		this.managementMoney = managementMoney;
	}

	public BigDecimal getIrr() {
		return irr;
	}

	public void setIrr(BigDecimal irr) {
		this.irr = irr;
	}

	public BigDecimal getPlanIrr() {
		return planIrr;
	}

	public void setPlanIrr(BigDecimal planIrr) {
		this.planIrr = planIrr;
	}

	public BigDecimal getReturnAmt() {
		return returnAmt;
	}

	public void setReturnAmt(BigDecimal returnAmt) {
		this.returnAmt = returnAmt;
	}

	public BigDecimal getFirstPaymentTotal() {
		return firstPaymentTotal;
	}

	public void setFirstPaymentTotal(BigDecimal firstPaymentTotal) {
		this.firstPaymentTotal = firstPaymentTotal;
	}

	public int getIncomeDay() {
		return incomeDay;
	}

	public void setIncomeDay(int incomeDay) {
		this.incomeDay = incomeDay;
	}

	public BigDecimal getConsultingMoney() {
		return consultingMoney;
	}

	public void setConsultingMoney(BigDecimal consultingMoney) {
		this.consultingMoney = consultingMoney;
	}

	public BigDecimal getBeforeInterest() {
		return beforeInterest;
	}

	public void setBeforeInterest(BigDecimal beforeInterest) {
		this.beforeInterest = beforeInterest;
	}

	public BigDecimal getRateAdjustmentModulus() {
		return rateAdjustmentModulus;
	}

	public void setRateAdjustmentModulus(BigDecimal rateAdjustmentModulus) {
		this.rateAdjustmentModulus = rateAdjustmentModulus;
	}

	public Integer getDelay() {
		return delay;
	}

	public void setDelay(Integer delay) {
		this.delay = delay;
	}

	public Integer getGrace() {
		return grace;
	}

	public void setGrace(Integer grace) {
		this.grace = grace;
	}

	public BigDecimal getOtherIncome() {
		return otherIncome;
	}

	public void setOtherIncome(BigDecimal otherIncome) {
		this.otherIncome = otherIncome;
	}

	public BigDecimal getOtherExpenditure() {
		return otherExpenditure;
	}

	public void setOtherExpenditure(BigDecimal otherExpenditure) {
		this.otherExpenditure = otherExpenditure;
	}

	public Integer getFreeDefaInterDay() {
		return freeDefaInterDay;
	}

	public void setFreeDefaInterDay(Integer freeDefaInterDay) {
		this.freeDefaInterDay = freeDefaInterDay;
	}

	public BigDecimal getEquipEndValue() {
		return equipEndValue;
	}

	public void setEquipEndValue(BigDecimal equipEndValue) {
		this.equipEndValue = equipEndValue;
	}

	public int getIsBeforeInterest() {
		return isBeforeInterest;
	}

	public void setIsBeforeInterest(int isBeforeInterest) {
		this.isBeforeInterest = isBeforeInterest;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(String actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public String getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(String actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public String getAccountingStartDate() {
		return accountingStartDate;
	}

	public void setAccountingStartDate(String accountingStartDate) {
		this.accountingStartDate = accountingStartDate;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public User getModificator() {
		return modificator;
	}

	public void setModificator(User modificator) {
		this.modificator = modificator;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getIsMerger() {
		return isMerger;
	}

	public void setIsMerger(int isMerger) {
		this.isMerger = isMerger;
	}

	public BigDecimal getLastCorpus() {
		return lastCorpus;
	}

	public void setLastCorpus(BigDecimal lastCorpus) {
		this.lastCorpus = lastCorpus;
	}

	public BigDecimal getCautionMoneyRatioC() {
		return cautionMoneyRatioC;
	}

	public void setCautionMoneyRatioC(BigDecimal cautionMoneyRatioC) {
		this.cautionMoneyRatioC = cautionMoneyRatioC;
	}

	public BigDecimal getCustCautionMoneyC() {
		return custCautionMoneyC;
	}

	public void setCustCautionMoneyC(BigDecimal custCautionMoneyC) {
		this.custCautionMoneyC = custCautionMoneyC;
	}

	public BigDecimal getCautionMoneyRatioS() {
		return cautionMoneyRatioS;
	}

	public void setCautionMoneyRatioS(BigDecimal cautionMoneyRatioS) {
		this.cautionMoneyRatioS = cautionMoneyRatioS;
	}

	public BigDecimal getCautionMoneyS() {
		return cautionMoneyS;
	}

	public void setCautionMoneyS(BigDecimal cautionMoneyS) {
		this.cautionMoneyS = cautionMoneyS;
	}

	public String getFirstPlanDate() {
		return firstPlanDate;
	}

	public void setFirstPlanDate(String firstPlanDate) {
		this.firstPlanDate = firstPlanDate;
	}

	public BigDecimal getExpectRentRatio() {
		return expectRentRatio;
	}

	public void setExpectRentRatio(BigDecimal expectRentRatio) {
		this.expectRentRatio = expectRentRatio;
	}

	public BigDecimal getExpectRent() {
		return expectRent;
	}

	public void setExpectRent(BigDecimal expectRent) {
		this.expectRent = expectRent;
	}

	public BigDecimal getExpectRentDeductionRatio() {
		return expectRentDeductionRatio;
	}

	public void setExpectRentDeductionRatio(BigDecimal expectRentDeductionRatio) {
		this.expectRentDeductionRatio = expectRentDeductionRatio;
	}

	public BigDecimal getExpectRentDeduction() {
		return expectRentDeduction;
	}

	public void setExpectRentDeduction(BigDecimal expectRentDeduction) {
		this.expectRentDeduction = expectRentDeduction;
	}

	public String getIsRegistration() {
		return isRegistration;
	}

	public void setIsRegistration(String isRegistration) {
		this.isRegistration = isRegistration;
	}

	public String getIsGuaranty() {
		return isGuaranty;
	}

	public void setIsGuaranty(String isGuaranty) {
		this.isGuaranty = isGuaranty;
	}

	public BigDecimal getGpsMoney() {
		return gpsMoney;
	}

	public void setGpsMoney(BigDecimal gpsMoney) {
		this.gpsMoney = gpsMoney;
	}

	public DictionaryData getInsurerType() {
		return insurerType;
	}

	public void setInsurerType(DictionaryData insurerType) {
		this.insurerType = insurerType;
	}
	
}
