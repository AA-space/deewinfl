package com.reckon.bean;

import java.math.BigDecimal;

import com.reckon.base.ReckonKey;

/**
 * 
 * @author 孙传良
 * @date 2013-4-22下午05:59:08
 * @info 用于租金测算时的现金流类
 * @Copyright 
 * Tenwa
 */
public class CashDetail extends ReckonKey implements Comparable<CashDetail> {

	private String planDate;
	private BigDecimal fundIn;
	private String fundInDetails;
	private BigDecimal fundOut;
	private String fundOutDetails;
	private BigDecimal netFlow;
	public String getPlanDate() {
		return planDate;
	}
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}
	public BigDecimal getFundIn() {
		return fundIn;
	}
	public void setFundIn(BigDecimal fundIn) {
		this.fundIn = fundIn;
	}
	public String getFundInDetails() {
		return fundInDetails;
	}
	public void setFundInDetails(String fundInDetails) {
		this.fundInDetails = fundInDetails;
	}
	public BigDecimal getFundOut() {
		return fundOut;
	}
	public void setFundOut(BigDecimal fundOut) {
		this.fundOut = fundOut;
	}
	public String getFundOutDetails() {
		return fundOutDetails;
	}
	public void setFundOutDetails(String fundOutDetails) {
		this.fundOutDetails = fundOutDetails;
	}
	public BigDecimal getNetFlow() {
		return netFlow;
	}
	public void setNetFlow(BigDecimal netFlow) {
		this.netFlow = netFlow;
	}
	@Override
	public int compareTo(CashDetail o) {
		return this.getPlanDate().compareTo(o.getPlanDate());
	}

}
