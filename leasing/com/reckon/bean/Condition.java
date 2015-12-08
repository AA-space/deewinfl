package com.reckon.bean;

import java.math.BigDecimal;

import com.business.entity.DictionaryData;
import com.reckon.base.ReckonKey;

/**
 * 
 * @author 孙传良
 * @date 2013-4-22下午05:44:09
 * @info  租金测算商务条件的父类 
 * @Copyright 
 * Tenwa
 */
public class Condition extends ReckonKey {
	
	private BigDecimal equipAmt;
	private BigDecimal leaseAmt;
	private String   leaseAmtDate;
	private BigDecimal firstPaymentRatio;
	private BigDecimal firstPayment;
	private BigDecimal cleanLeaseMoney;
	private BigDecimal yearRate;
	private DictionaryData periodType;
	private DictionaryData incomeNumberYear;
	private Integer incomeNumber;
	private Integer leaseTerm;
	private DictionaryData settleMethod;
	private String   startDate;
	private BigDecimal nominalPrice;
	private BigDecimal penaRate;
	private DictionaryData rateFloatType;
	private BigDecimal rateFloatAmt;
	private DictionaryData adjustStyle;
	private BigDecimal cautionMoneyRatio;
	private BigDecimal cautionMoney;
	private BigDecimal cautionDeductionRatio;
	private BigDecimal cautionDeductionMoney;
	private BigDecimal handlingChargeRatio;
	private BigDecimal handlingChargeMoney;
	private String insurer;
	private BigDecimal insureMoney;
	private BigDecimal managementMoneyRatio;
	private BigDecimal managementMoney;
	private BigDecimal irr;
	private BigDecimal planIrr;
	private BigDecimal returnAmt;
	private BigDecimal firstPaymentTotal;
	private BigDecimal consultingMoney;
	private BigDecimal beforeInterest;
	private Integer delay;
	private Integer grace;
	private BigDecimal otherIncome;
	private BigDecimal otherExpenditure;
	private Integer freeDefaInterDay;
	private BigDecimal equipEndValue;
	private Integer isBeforeInterest;
	private String endDate;
	private String actualStartDate;
	private String actualEndDate;
	private String accountingStartDate;
	private Integer isMerger;
	private BigDecimal lastCorpus;
	private BigDecimal custCautionMoneyRatio;
	private BigDecimal custCautionMoney;
	private BigDecimal supplierCautionMoneyRatio;
	private BigDecimal supplierCautionMoney;
	private String firstPlanDate;
	private BigDecimal expectRentRatio;
	private BigDecimal expectRent;
	private BigDecimal expectRentDeductionRatio;
	private BigDecimal expectRentDeduction;
	private String		isRegistration;
	private String		isGuaranty;
	private BigDecimal		gpsMoney;
	private DictionaryData		insurerType;
	
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
	public BigDecimal getHandlingChargeRatio() {
		return handlingChargeRatio;
	}
	public void setHandlingChargeRatio(BigDecimal handlingChargeRatio) {
		this.handlingChargeRatio = handlingChargeRatio;
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
	public Integer getIsBeforeInterest() {
		return isBeforeInterest;
	}
	public void setIsBeforeInterest(Integer isBeforeInterest) {
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
	public Integer getIsMerger() {
		return isMerger;
	}
	public void setIsMerger(Integer isMerger) {
		this.isMerger = isMerger;
	}
	public BigDecimal getLastCorpus() {
		return lastCorpus;
	}
	public void setLastCorpus(BigDecimal lastCorpus) {
		this.lastCorpus = lastCorpus;
	}
	public BigDecimal getCustCautionMoneyRatio() {
		return custCautionMoneyRatio;
	}
	public void setCustCautionMoneyRatio(BigDecimal custCautionMoneyRatio) {
		this.custCautionMoneyRatio = custCautionMoneyRatio;
	}
	public BigDecimal getCustCautionMoney() {
		return custCautionMoney;
	}
	public void setCustCautionMoney(BigDecimal custCautionMoney) {
		this.custCautionMoney = custCautionMoney;
	}
	public BigDecimal getSupplierCautionMoneyRatio() {
		return supplierCautionMoneyRatio;
	}
	public void setSupplierCautionMoneyRatio(BigDecimal supplierCautionMoneyRatio) {
		this.supplierCautionMoneyRatio = supplierCautionMoneyRatio;
	}
	public BigDecimal getSupplierCautionMoney() {
		return supplierCautionMoney;
	}
	public void setSupplierCautionMoney(BigDecimal supplierCautionMoney) {
		this.supplierCautionMoney = supplierCautionMoney;
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
