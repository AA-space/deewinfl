package com.business.entity.contract;

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
import com.business.entity.cust.CustInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-5下午04:41:56
 * @info 合同抵质押物件
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "合同抵质押物件")
@Table(name="CONTRACT_GUARANTEE_EQUIP")
public class ContractGuaranteeEquip {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="合同编号")
	@ManyToOne(targetEntity=ContractInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name="CONTRACT_ID")
	private ContractInfo contractId;
	
	@FieldName(name="设备类型")
	@JoinColumn(name="EQUIP_GUARANTEE_TYPE")
	@ManyToOne(fetch = FetchType.LAZY)
	private DictionaryData equipGuaranteeType;
	
	@FieldName(name="抵质押物名称")
	@Column(name="EQIP_NAME")
	private String eqipName;
	
	@FieldName(name="抵押/质押人")
	@JoinColumn(name="GUARANTOR")
	@ManyToOne(fetch = FetchType.LAZY)
	private CustInfo guarantor;
	
	@FieldName(name="发票号")
	@Column(name="EQUIP_INVOICE")
	private String equipInvoice;
	
	@FieldName(name="发票金额")
	@Column(name="TOTAL_PRICE",precision=22,scale=2)
	private BigDecimal totalPrice;

	@FieldName(name="现值")
	@Column(name="PRESENT_VALUE",precision=22,scale=2)
	private BigDecimal presentValue;
	
	@FieldName(name="是否抵押公证:是/否--APPSTATICUTIL类里声明")
	@Column(name="NOTARY_FLAG")
	private int notaryFlag;
	
	@FieldName(name="购买年限")
	@Column(name="PURCHASE_LIFE")
	private Integer purchaseLife;
	
	@FieldName(name="登记机关")
	@Column(name="RECORD_MECH")
	private String recordMech;
	
	@FieldName(name="备注")
	@Column(name="CGENOTE")
	private String cgenote;
	
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

	public ContractInfo getContractId() {
		return contractId;
	}

	public void setContractId(ContractInfo contractId) {
		this.contractId = contractId;
	}

	public DictionaryData getEquipGuaranteeType() {
		return equipGuaranteeType;
	}

	public void setEquipGuaranteeType(DictionaryData equipGuaranteeType) {
		this.equipGuaranteeType = equipGuaranteeType;
	}

	public String getEqipName() {
		return eqipName;
	}

	public void setEqipName(String eqipName) {
		this.eqipName = eqipName;
	}

	public CustInfo getGuarantor() {
		return guarantor;
	}

	public void setGuarantor(CustInfo guarantor) {
		this.guarantor = guarantor;
	}

	public String getEquipInvoice() {
		return equipInvoice;
	}

	public void setEquipInvoice(String equipInvoice) {
		this.equipInvoice = equipInvoice;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getPresentValue() {
		return presentValue;
	}

	public void setPresentValue(BigDecimal presentValue) {
		this.presentValue = presentValue;
	}

	public int getNotaryFlag() {
		return notaryFlag;
	}

	public void setNotaryFlag(int notaryFlag) {
		this.notaryFlag = notaryFlag;
	}

	public Integer getPurchaseLife() {
		return purchaseLife;
	}

	public void setPurchaseLife(Integer purchaseLife) {
		this.purchaseLife = purchaseLife;
	}

	public String getRecordMech() {
		return recordMech;
	}

	public void setRecordMech(String recordMech) {
		this.recordMech = recordMech;
	}

	public String getCgenote() {
		return cgenote;
	}

	public void setCgenote(String cgenote) {
		this.cgenote = cgenote;
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
}
