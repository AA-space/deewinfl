package com.business.entity.dealer;

import java.math.BigDecimal;

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
import com.business.entity.cust.CustInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-7-28下午03:28:25
 * @info 经销商额度记录(德银)
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "经销商额度记录(德银)")
@Table(name="DEALER_CREDIT_INFO")
public class DealerCreditInfo {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="经销商ID")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUST_ID")
	private CustInfo custId;
 
	@FieldName(name="流程实例ID")
	@Column(name="doc_id",length=10)
	private String docID;
	
	@FieldName(name = "当前授信额度")
	@Column(name="credit_Money",precision=22,scale=2)
	private BigDecimal creditMoney;
	
	@FieldName(name = "当前授信额度开始时间")
	@Column(name="CREDIT_STAR_DATE", length=20)
	private String creditStarDate;
	
	@FieldName(name = "当前授信额度结束时间")
	@Column(name="CREDIT_END_DATE", length=20)
	private String creditEndDate;
	
	@FieldName(name = "调整前授信额度")
	@Column(name="ADJUST_credit_Money",precision=22,scale=2)
	private BigDecimal adjustCreditMoney;
	
	@FieldName(name = "应收保证金")
	@Column(name="CAUTION_MONEY",precision=22,scale=2)
	private BigDecimal cautionMoney;
	
	@FieldName(name = "调整前授信额度开始时间")
	@Column(name="ADJUST_CREDIT_STAR_DATE", length=20)
	private String adjustCreditStarDate;
	
	@FieldName(name = "调整前授信额度结束时间")
	@Column(name="ADJUST_CREDIT_END_DATE", length=20)
	private String adjustCreditEndDate;
	
	@FieldName(name = "调整方式")
	@Column(name="ADJUST_MODE", length=255)
	private String adjustMode;
	
	@FieldName(name = "考察报告得分")
	@Column(name="REPORT_SCORE",precision=22,scale=2)
	private BigDecimal reportScore;
	
	@FieldName(name = "调整时间")
	@Column(name="ADJUST_DATE", length=20)
	private String adjustDate;
	
	@FieldName(name = "调整原因")
	@Column(name="ADJUST_REASON", length=255)
	private String adjustReason;
	
	@FieldName(name = "经销商评审编号")
	@Column(name="creditNum", length=20)
	private String creditNum;
	
	@FieldName(name = "是否为当前额度记录(是/否--0/1)")
	@Column(name="IS_NOW", length=2)
	private String isNow;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name = "登记人")
	@JoinColumn(name="CREATOR_")
	private User creator;
	
	@FieldName(name = "登记时间")
	@Column(name="CREATE_DATE", length=20)
	private String createDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name = "更新人")
	@JoinColumn(name="MODIFICATOR_")
	private User modificator;
	
	@FieldName(name = "更新日期")
	@Column(name="MODIFY_DATE")
	private String modifyDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CustInfo getCustId() {
		return custId;
	}

	public void setCustId(CustInfo custId) {
		this.custId = custId;
	}

	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
	}

	public BigDecimal getCreditMoney() {
		return creditMoney;
	}

	public void setCreditMoney(BigDecimal creditMoney) {
		this.creditMoney = creditMoney;
	}

	public String getCreditStarDate() {
		return creditStarDate;
	}

	public void setCreditStarDate(String creditStarDate) {
		this.creditStarDate = creditStarDate;
	}

	public String getCreditEndDate() {
		return creditEndDate;
	}

	public void setCreditEndDate(String creditEndDate) {
		this.creditEndDate = creditEndDate;
	}

	public BigDecimal getAdjustCreditMoney() {
		return adjustCreditMoney;
	}

	public void setAdjustCreditMoney(BigDecimal adjustCreditMoney) {
		this.adjustCreditMoney = adjustCreditMoney;
	}

	public String getAdjustCreditStarDate() {
		return adjustCreditStarDate;
	}

	public void setAdjustCreditStarDate(String adjustCreditStarDate) {
		this.adjustCreditStarDate = adjustCreditStarDate;
	}

	public String getAdjustCreditEndDate() {
		return adjustCreditEndDate;
	}

	public void setAdjustCreditEndDate(String adjustCreditEndDate) {
		this.adjustCreditEndDate = adjustCreditEndDate;
	}

	public String getAdjustMode() {
		return adjustMode;
	}

	public void setAdjustMode(String adjustMode) {
		this.adjustMode = adjustMode;
	}

	public BigDecimal getReportScore() {
		return reportScore;
	}

	public void setReportScore(BigDecimal reportScore) {
		this.reportScore = reportScore;
	}

	public String getAdjustDate() {
		return adjustDate;
	}

	public void setAdjustDate(String adjustDate) {
		this.adjustDate = adjustDate;
	}

	public String getAdjustReason() {
		return adjustReason;
	}

	public void setAdjustReason(String adjustReason) {
		this.adjustReason = adjustReason;
	}

	public String getCreditNum() {
		return creditNum;
	}

	public void setCreditNum(String creditNum) {
		this.creditNum = creditNum;
	}

	public String getIsNow() {
		return isNow;
	}

	public void setIsNow(String isNow) {
		this.isNow = isNow;
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

	public BigDecimal getCautionMoney() {
		return cautionMoney;
	}

	public void setCautionMoney(BigDecimal cautionMoney) {
		this.cautionMoney = cautionMoney;
	}

}
