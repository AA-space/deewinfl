package com.business.entity.dealer;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.asset.FundEbankData;
import com.business.entity.cust.CustInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-7上午11:57:06
 * @info 合同资金实收表
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "经销商保证金收款记录表(德银)")
@Table(name="MFUND_FUND_CHARGE")
public class MFundFundCharge {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;

	@FieldName(name="经销商编号")
	@ManyToOne(targetEntity=CustInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name="DEALER_ID")
	private CustInfo dealerId ;
	
	@FieldName(name="网银编号[S]")
	@ManyToOne(targetEntity=FundEbankData.class,fetch=FetchType.LAZY)
	@JoinColumn(name="EBANK_NUMBER")
	private FundEbankData ebankNumber;
	
	@FieldName(name="收付款期项")
	@Column(name="CHARGE_LIST")
	private Integer   chargeList;

	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="费用类型[D]")
	@JoinColumn(name="FEE_TYPE")
	private DictionaryData feeType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="结算方式[D]")
	@JoinColumn(name="SETTLE_METHOD")
	private DictionaryData settleMethod;
	
	@FieldName(name="收支日期")
	@Column(name="FACT_DATE",length=20)
	private String   factDate;

	@FieldName(name="收支金额")
	@Column(name="FACT_MONEY",precision=22,scale=2)
	private BigDecimal factMoney;

	@FieldName(name="费用调整")
	@Column(name="FEE_ADJUST",precision=22,scale=2)
	private BigDecimal feeAdjust;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="货币类型[D]")
	@JoinColumn(name="CURRENCY")
	private DictionaryData currency;

	@FieldName(name="收支对象")
	@Column(name="FACT_OBJECT")
	private String   factObject;

	@FieldName(name="银行名称")
	@Column(name="ACCOUNT_BANK",length=20)
	private String   accountBank;

	@FieldName(name="帐户名称")
	@Column(name="ACCOUNT")
	private String   account;

	@FieldName(name="银行帐号")
	@Column(name="ACC_NUMBER")
	private String   accNumber;

	@FieldName(name="客户银行")
	@Column(name="CLIENT_BANK")
	private String   clientBank;

	@FieldName(name="客户帐户")
	@Column(name="CLIENT_ACCOUNT")
	private String   clientAccount;

	@FieldName(name="客户帐号")
	@Column(name="CLIENT_ACCNUMBER")
	private String   clientAccnumber;

	@FieldName(name="单据号")
	@Column(name="INVOICE_NO")
	private String   invoiceNo;

	@FieldName(name="会计处理日")
	@Column(name="ACCOUNTING_DATE",length=20)
	private String   accountingDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="收付类型")
	@JoinColumn(name="PAY_TYPE")
	private DictionaryData payType;

	@FieldName(name="对应期项")
	@Column(name="MATCH_LIST")
	private Integer   matchList;

	@FieldName(name="申请放款日期")
	@Column(name="APPLY_PAY_DATE",length=20)
	private String   applyPayDate;
	
	@FieldName(name="上传日期")
	@Column(name="UPLOAD_DATE",length=20)
	private String   uploadDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="上传人")
	@JoinColumn(name="UPLOAD_CREATOR")
	private User uploadCreator;

	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="开票人")
	@JoinColumn(name="INVOICE_PERSON")
	private User invoicePerson;

	@FieldName(name="开票时间")
	@Column(name="INVOICE_DATE", length=20)	
	private String invoiceDate;

	@FieldName(name="备注")
	@Column(name="FFCMEMO", length=2000)
	private String   ffcmemo;
	
	@FieldName(name="是否红冲或被红冲记录")
	@Column(name="ROLL_BACK",length=2)
	private String   rollBack;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="PID_")
	@FieldName(name="资金款项来源")
	private MFundFundCharge PID;
	
	@JsonManagedReference
	@OneToMany(mappedBy="PID",fetch = FetchType.LAZY)
	@OrderBy(value = "createDate ASC")
	@FieldName(name="资金款项去向")
	private Set<MFundFundCharge> mfundFundChargeS = new HashSet<MFundFundCharge>();
	
	@Transient
	@FieldName(name = "保证金抵扣金额")
	@Column(name = "DEDUCTION_MONEY", precision = 22, scale = 2)
	private BigDecimal deductionMoney;
	
	@Transient
	@FieldName(name = "保证金红冲")
	@Column(name = "CRW_MONEY", precision = 22, scale = 2)
	private BigDecimal  crwMoney;
	
	@Transient
	@FieldName(name = "保证金退款金额")
	@Column(name = "DRAWBACK_MONEY", precision = 22, scale = 2)
	private BigDecimal drawbackMoney;
	
	@Transient
	@FieldName(name = "保证金余额")
	@Column(name = "overMoney", precision = 22, scale = 2)
	private BigDecimal overMoney;
	
	
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

	
	public void initMFundFundCharge(){
		System.out.println(mfundFundChargeS.size());
		BigDecimal tempdeduction=BigDecimal.ZERO;//保证金抵扣
		BigDecimal tempcrw=BigDecimal.ZERO; //保证金红冲
		BigDecimal tempdrawback=BigDecimal.ZERO;//保证金退款
		BigDecimal overMoney=BigDecimal.ZERO;
        for(MFundFundCharge mf:mfundFundChargeS){
        	//付款并且是保证金抵扣      
        	if(mf.getPayType().getCode().equalsIgnoreCase("pay_type_out")&&mf.getSettleMethod().getCode().equalsIgnoreCase("PayFund10")){
        		tempdeduction=tempdeduction.add(mf.getFactMoney());
        	}
        	//付款并且是退款
        	if(mf.getPayType().getCode().equalsIgnoreCase("pay_type_out")&&mf.getSettleMethod().getCode().equalsIgnoreCase("PayFund8")){
        		tempdrawback=tempdrawback.add(mf.getFactMoney());
        	}
        	//红冲
        	if(mf.getSettleMethod().getCode().equalsIgnoreCase("PayFund9")){
        		if(mf.getPayType().getCode().equalsIgnoreCase("pay_type_out")){
        			tempcrw=BigDecimal.ZERO.subtract(tempcrw.add(mf.getFactMoney()));
        		}else{
        			tempcrw=tempcrw.add(mf.getFactMoney());
        		}
            }
        }
        overMoney=this.factMoney.subtract(tempdeduction).subtract(tempdrawback).add(tempcrw);
        this.setDeductionMoney(tempdeduction);
        this.setCrwMoney(BigDecimal.ZERO.subtract(tempcrw));
        this.setDrawbackMoney(tempdrawback);
        this.setOverMoney(overMoney);
	}
	public BigDecimal getOverMoney() {
		return overMoney;
	}
	public void setOverMoney(BigDecimal overMoney) {
		this.overMoney = overMoney;
	}
	public BigDecimal getDeductionMoney() {
		return deductionMoney;
	}
	public void setDeductionMoney(BigDecimal deductionMoney) {
		this.deductionMoney = deductionMoney;
	}
	public BigDecimal getCrwMoney() {
		return crwMoney;
	}
	public void setCrwMoney(BigDecimal crwMoney) {
		this.crwMoney = crwMoney;
	}
	public BigDecimal getDrawbackMoney() {
		return drawbackMoney;
	}
	public void setDrawbackMoney(BigDecimal drawbackMoney) {
		this.drawbackMoney = drawbackMoney;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CustInfo getDealerId() {
		return dealerId;
	}

	public void setDealerId(CustInfo dealerId) {
		this.dealerId = dealerId;
	}

	public FundEbankData getEbankNumber() {
		return ebankNumber;
	}

	public void setEbankNumber(FundEbankData ebankNumber) {
		this.ebankNumber = ebankNumber;
	}

	public Integer getChargeList() {
		return chargeList;
	}

	public void setChargeList(Integer chargeList) {
		this.chargeList = chargeList;
	}

	public DictionaryData getFeeType() {
		return feeType;
	}

	public void setFeeType(DictionaryData feeType) {
		this.feeType = feeType;
	}

	public DictionaryData getSettleMethod() {
		return settleMethod;
	}

	public void setSettleMethod(DictionaryData settleMethod) {
		this.settleMethod = settleMethod;
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

	public void setFactMoney(BigDecimal factMoney) {
		this.factMoney = factMoney;
	}

	public BigDecimal getFeeAdjust() {
		return feeAdjust;
	}

	public void setFeeAdjust(BigDecimal feeAdjust) {
		this.feeAdjust = feeAdjust;
	}

	public DictionaryData getCurrency() {
		return currency;
	}

	public void setCurrency(DictionaryData currency) {
		this.currency = currency;
	}

	public String getFactObject() {
		return factObject;
	}

	public void setFactObject(String factObject) {
		this.factObject = factObject;
	}

	public String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getClientBank() {
		return clientBank;
	}

	public void setClientBank(String clientBank) {
		this.clientBank = clientBank;
	}

	public String getClientAccount() {
		return clientAccount;
	}

	public void setClientAccount(String clientAccount) {
		this.clientAccount = clientAccount;
	}

	public String getClientAccnumber() {
		return clientAccnumber;
	}

	public void setClientAccnumber(String clientAccnumber) {
		this.clientAccnumber = clientAccnumber;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getAccountingDate() {
		return accountingDate;
	}

	public void setAccountingDate(String accountingDate) {
		this.accountingDate = accountingDate;
	}
	public Integer getMatchList() {
		return matchList;
	}

	public void setMatchList(Integer matchList) {
		this.matchList = matchList;
	}

	public String getApplyPayDate() {
		return applyPayDate;
	}

	public void setApplyPayDate(String applyPayDate) {
		this.applyPayDate = applyPayDate;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public User getUploadCreator() {
		return uploadCreator;
	}

	public void setUploadCreator(User uploadCreator) {
		this.uploadCreator = uploadCreator;
	}

	public User getInvoicePerson() {
		return invoicePerson;
	}

	public void setInvoicePerson(User invoicePerson) {
		this.invoicePerson = invoicePerson;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getFfcmemo() {
		return ffcmemo;
	}

	public void setFfcmemo(String ffcmemo) {
		this.ffcmemo = ffcmemo;
	}

	public String getRollBack() {
		return rollBack;
	}

	public void setRollBack(String rollBack) {
		this.rollBack = rollBack;
	}

	public MFundFundCharge getPID() {
		return PID;
	}

	public void setPID(MFundFundCharge pID) {
		PID = pID;
	}

	public Set<MFundFundCharge> getMfundFundChargeS() {
		return mfundFundChargeS;
	}

	public void setMfundFundChargeS(Set<MFundFundCharge> mfundFundChargeS) {
		this.mfundFundChargeS = mfundFundChargeS;
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

	public DictionaryData getPayType() {
		return payType;
	}

	public void setPayType(DictionaryData payType) {
		this.payType = payType;
	}	
}
