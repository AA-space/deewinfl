package com.reckon.bean;

import java.math.BigDecimal;

import com.business.entity.DictionaryData;
import com.reckon.base.ReckonKey;

/**
 * 
 * @author 孙传良
 * @date 2013-4-22下午06:00:04
 * @info 用于测算是的资金计划类
 * @Copyright 
 * Tenwa
 */
public class FundPlan extends ReckonKey {

	private DictionaryData feeType;
	private DictionaryData payType;
	private String   planDate;
	private BigDecimal planMoney;
	private String payObj ;
	public DictionaryData getFeeType() {
		return feeType;
	}
	public void setFeeType(DictionaryData feeType) {
		this.feeType = feeType;
	}
	public DictionaryData getPayType() {
		return payType;
	}
	public void setPayType(DictionaryData payType) {
		this.payType = payType;
	}
	public String getPlanDate() {
		return planDate;
	}
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}
	public BigDecimal getPlanMoney() {
		return planMoney;
	}
	public void setPlanMoney(BigDecimal planMoney) {
		this.planMoney = planMoney;
	}
	public String getPayObj() {
		return payObj;
	}
	public void setPayObj(String payObj) {
		this.payObj = payObj;
	}
	
}
