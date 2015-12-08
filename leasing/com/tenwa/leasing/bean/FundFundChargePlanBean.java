package com.tenwa.leasing.bean;

/**
 * 租金测算时有一个叫做资金收付计划的东东，就是这个了
 * 
 * @author mhy
 *
 */
public class FundFundChargePlanBean {
	
	private String docId;
	private String contractId;
	
	private String paymentId;
	private String planDate;
	private Double planMoney;
	private String feeTypeName;
	private String feeType;
	private String payTypeName;
	private String payType;
	private String payObj;

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPlanDate() {
		return planDate;
	}

	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

	public Double getPlanMoney() {
		return planMoney;
	}

	public void setPlanMoney(Double planMoney) {
		this.planMoney = planMoney;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getFeeTypeName() {
		return feeTypeName;
	}

	public void setFeeTypeName(String feeTypeName) {
		this.feeTypeName = feeTypeName;
	}

	public String getPayTypeName() {
		return payTypeName;
	}

	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}

	public String getPayObj() {
		return payObj;
	}

	public void setPayObj(String payObj) {
		this.payObj = payObj;
	}
}
