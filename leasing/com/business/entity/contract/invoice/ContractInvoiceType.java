package com.business.entity.contract.invoice;

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
import org.hibernate.annotations.Index;

import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.contract.ContractInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-5下午05:31:43
 * @info 合同开票类型信息
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "合同开票类型信息")
@Table(name="CONTRACT_INVOICE_TYPE")
public class ContractInvoiceType {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="合同编号")
	@Index(name="INX_CONTRACT_INVOICE_TYPE_ID")
	@OneToOne(targetEntity=ContractInfo.class)
	@JoinColumn(name="CONTRACT_ID")
	private ContractInfo contractId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="开票类型")
	@JoinColumn(name="RENTINVOICETYPE")
	private DictionaryData rentInvoiceType;

	@FieldName(name="租金是否拆分:是/否[S]")
	@Column(name="ISINVOICERENTSPLIT",length=2)
	private String isInvoiceRentSplit;
	
	@FieldName(name="是否一次性开票:是/否[S]")
	@Column(name="BOOLINVOICE",length=2)
	private String boolInvoice;

	@FieldName(name="发票为放款先决条件:是/否[S](德银)")
	@Column(name="IS_FUND",length=2)
	private String isFund;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="创建人")
	@JoinColumn(name="CREATOR_")
	private User creator;
	
	@FieldName(name="创建时间")
	@Column(name="CREATE_DATE", length=20)	
	private String createDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
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

	public DictionaryData getRentInvoiceType() {
		return rentInvoiceType;
	}

	public void setRentInvoiceType(DictionaryData rentInvoiceType) {
		this.rentInvoiceType = rentInvoiceType;
	}

	public String getIsInvoiceRentSplit() {
		return isInvoiceRentSplit;
	}

	public void setIsInvoiceRentSplit(String isInvoiceRentSplit) {
		this.isInvoiceRentSplit = isInvoiceRentSplit;
	}

	public String getBoolInvoice() {
		return boolInvoice;
	}

	public void setBoolInvoice(String boolInvoice) {
		this.boolInvoice = boolInvoice;
	}

	public String getIsFund() {
		return isFund;
	}

	public void setIsFund(String isFund) {
		this.isFund = isFund;
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
