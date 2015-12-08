package com.business.entity.contract.rent;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.business.entity.User;
import com.business.entity.base.BaseFile;
import com.business.entity.contract.ContractInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-7上午11:57:06
 * @info 卡扣上传
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "卡扣上传(德银)")
@Table(name="CONTRACT_CARD_RENT_INCOME")
public class ContractCardRentIncome {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;

	@FieldName(name="合同编号")
	@ManyToOne(targetEntity=ContractInfo.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="CONTRACT_ID")
	private ContractInfo contractId ;	

	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="上传文件名")
	@JoinColumn(name="UPLOAD_ID")
	private BaseFile upLoadId ;
	
	@FieldName(name="扣款状态[成功/失败:0/1]")
	@Column(name="INCOME_STATUS")	
	private Integer incomeStatus;
	
	@FieldName(name="交易结果")
	@Column(name="TRADING_RESULTS")
	private String tradingResults;
	
	@FieldName(name="金额类型(租金/罚息)")
	@Column(name="MONEY_TYPE",length=100)
	private String moneyType;
	
	@FieldName(name="扣款金额")
	@Column(name="INCOME_MONEY",precision=22,scale=2)
	private BigDecimal incomeMoney;
	
	@FieldName(name="剩余金额")
	@Column(name="LAST_MONEY",precision=22,scale=2)
	private BigDecimal lastMoney;
	
	@FieldName(name="交易行")
	@Column(name="TRADE_BANK")	
	private String tradeBank;
	
	@FieldName(name="对方账号")
	@Column(name="CLIENT_ACCOUNT")	
	private String clientAccount;
   
	@FieldName(name="对方户名")
	@Column(name="CLIENT_NAME")	
	private String cilentname;
	
	@FieldName(name="到账时间")
	@Column(name="INCOME_DATE", length=20)	
	private String incomeDate;

	@FieldName(name="到账流水号")
	@Column(name="INCOME_NUM")	
	private String incomeNum;
    
	@FieldName(name="交易用途")
	@Column(name="TRADE_PURPOSE" )	
	private String tradePurpose;
	
	@FieldName(name="期项")
	@Column(name="RENT_LIST")
	private Integer rentList;
	
	@FieldName(name="扣款状态文字表述")
	@Column(name="INCOME_TEXT")	
	private String incomeText;
	
	
	@FieldName(name="扣款状态备注")
	@Column(name="remark")	
	private String remark;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="创建人")
	@JoinColumn(name="CREATOR_")
	private User creator;
	
	@FieldName(name="创建时间")
	@Column(name="CREATE_DATE", length=20)	
	private String createDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="修改人")
	@JoinColumn(name="MODIFICATOR_")
	private User modificator;
	
	@FieldName(name="修改时间")
	@Column(name="MODIFY_DATE", length=20)	
	private String modifyDate;
	
	public String getTradeBank() {
		return tradeBank;
	}

	public void setTradeBank(String tradeBank) {
		this.tradeBank = tradeBank;
	}

	public String getClientAccount() {
		return clientAccount;
	}

	public void setClientAccount(String clientAccount) {
		this.clientAccount = clientAccount;
	}

	public String getCilentname() {
		return cilentname;
	}

	public void setCilentname(String cilentname) {
		this.cilentname = cilentname;
	}
	public String getTradingResults() {
		return tradingResults;
	}

	public void setTradingResults(String tradingResults) {
		this.tradingResults = tradingResults;
	}

	

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

	public BaseFile getUpLoadId() {
		return upLoadId;
	}

	public void setUpLoadId(BaseFile upLoadId) {
		this.upLoadId = upLoadId;
	}

	public Integer getIncomeStatus() {
		return incomeStatus;
	}

	public void setIncomeStatus(Integer incomeStatus) {
		this.incomeStatus = incomeStatus;
	}

	public String getMoneyType() {
		return moneyType;
	}

	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}

	public BigDecimal getIncomeMoney() {
		return incomeMoney;
	}

	public void setIncomeMoney(BigDecimal incomeMoney) {
		this.incomeMoney = incomeMoney;
	}

	public BigDecimal getLastMoney() {
		return lastMoney;
	}

	public void setLastMoney(BigDecimal lastMoney) {
		this.lastMoney = lastMoney;
	}

	public String getIncomeDate() {
		return incomeDate;
	}

	public void setIncomeDate(String incomeDate) {
		this.incomeDate = incomeDate;
	}

	public String getIncomeNum() {
		return incomeNum;
	}

	public void setIncomeNum(String incomeNum) {
		this.incomeNum = incomeNum;
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

	
	public String getTradePurpose() {
		return tradePurpose;
	}

	public void setTradePurpose(String tradePurpose) {
		this.tradePurpose = tradePurpose;
	}
	public Integer getRentList() {
		return rentList;
	}

	public void setRentList(Integer rentList) {
		this.rentList = rentList;
	}

	public String getIncomeText() {
		return incomeText;
	}

	public String getRemark() {
		return remark;
	}

	public void setIncomeText(String incomeText) {
		this.incomeText = incomeText;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
