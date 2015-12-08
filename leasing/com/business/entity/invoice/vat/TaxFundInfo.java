package com.business.entity.invoice.vat;


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

import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.base.BaseFile;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.kernal.annotation.FieldName;

/**
 * @author Toybaby
 *	2013-10-11
 *  资计发票信息
 *  
 */
@Entity
@FieldName(name = "资金发票开票信息")
@Table(name="TAX_FUND_INFO")
public class TaxFundInfo {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="Contract_Fund_Fund_Plan表的主键ID")
	@ManyToOne(targetEntity=ContractFundFundPlan.class,fetch=FetchType.LAZY)
	@JoinColumn(name="CFFP_ID")
	private ContractFundFundPlan cffpId;
	
	@FieldName(name="Contract_Fund_Fund_Charge表的主键ID")
	@ManyToOne(targetEntity=ContractFundFundCharge.class,fetch=FetchType.LAZY)
	@JoinColumn(name="CFFC_ID")
	private ContractFundFundCharge cffcId;
	
	@FieldName(name="发票状态 (null||0)：不生成||1：确认中||2：已导出||3：已退回")
	@Column(name="INVOICE_STATUS")
	private Integer invoiceStatus;
	
	@FieldName(name="计划时间")
	@Column(name="PLAN_DATE", length=20)	
	private String planDate;
	
	@FieldName(name="计划金额")
	@Column(name="PLAN_MONEY",precision=22,scale=2)	
	private BigDecimal planMoney;
	
	@FieldName(name="实际时间")
	@Column(name="FACT_DATE", length=20)	
	private String factDate;
	
	@FieldName(name="实际金额")
	@Column(name="FACT_MONEY",precision=22,scale=2)	
	private BigDecimal factMoney;
	
	@FieldName(name="付款人")
	@Column(name="PAY_OBJ", length=200)	
	private String payObj;
	
	@FieldName(name="BaseFile表的主键ID")
	@ManyToOne(targetEntity=BaseFile.class,fetch=FetchType.LAZY)
	@JoinColumn(name="EXP_Id")
	private BaseFile expId;
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="导出人")
	@JoinColumn(name="EXP_USER")	
	private User expUser;
	
	@FieldName(name="导出时间")
	@Column(name="EXP_DATE", length=20)	
	private String expDate;
	
	@FieldName(name="付款类型")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PAY_TYPE")	
	private DictionaryData payType;
	
	@FieldName(name="流水号")
	@Column(name="OUT_NO", length=20)	
	private String outNo;
	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public ContractFundFundPlan getCffpId() {
		return cffpId;
	}

	public void setCffpId(ContractFundFundPlan cffpId) {
		this.cffpId = cffpId;
	}

	
	
	public ContractFundFundCharge getCffcId() {
		return cffcId;
	}

	public void setCffcId(ContractFundFundCharge cffcId) {
		this.cffcId = cffcId;
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

	public Integer getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(Integer invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
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

	public String getFactDate() {
		return factDate;
	}

	public void setFactDate(String factDate) {
		this.factDate = factDate;
	}

	public BigDecimal getFactMoney() {
		return factMoney;
	}

	
	public BaseFile getExpId() {
		return expId;
	}

	public void setExpId(BaseFile expId) {
		this.expId = expId;
	}


	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public void setFactMoney(BigDecimal factMoney) {
		this.factMoney = factMoney;
	}

	public String getPayObj() {
		return payObj;
	}

	public void setPayObj(String payObj) {
		this.payObj = payObj;
	}

	public DictionaryData getPayType() {
		return payType;
	}

	public void setPayType(DictionaryData payType) {
		this.payType = payType;
	}

	public String getOutNo() {
		return outNo;
	}

	public void setOutNo(String outNo) {
		this.outNo = outNo;
	}

	public User getExpUser() {
		return expUser;
	}

	public void setExpUser(User expUser) {
		this.expUser = expUser;
	}
	
	
}
