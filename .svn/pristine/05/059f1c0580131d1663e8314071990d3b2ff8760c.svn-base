package com.business.entity.contract.doc;

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
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-8-5下午05:17:34
 * @info 合同档案借阅管理
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "合同档案借阅管理")
@Table(name="Contract_Doc_Borrow_Info")
public class ContractDocBorrowInfo {
	
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="合同文档")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CONTRACT_DOC")
	private ContractDocSendInfo contractDoc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="文档处理类型(借阅/寄送)[D]")
	@JoinColumn(name="TYPE_")
	private DictionaryData type;
	
	@FieldName(name = "借阅人")
	@Column(name="BORROW_USER")
	private String borrowUser;
	
	@FieldName(name = "份数")
	@Column(name="BORROW_PART")
	private Integer borrowPart;
	
	@FieldName(name = "二次寄送份数")
	@Column(name="SEU_PART")
	private Integer seupart;
	
	@FieldName(name = "二次寄送时间")
	@Column(name="BORROW_DATE", length=20)
	private String borrowDate;
	
	@FieldName(name = "借阅时间期限")
	@Column(name="DATE_LIMIT", length=20)
	private String datelimit;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name = "归还人")
	@JoinColumn(name="RETURN_USER")
	private User returnUser;
	
	@FieldName(name = "归还时间")
	@Column(name="RETURN_DATE", length=20)
	private String returnDate;
	
	@FieldName(name = "二次寄送快递单号")
	@Column(name="borrow_Send_No", length=20)
	private String borrowSendNo;
	
	//外部借阅类型，保存记录字段
	@FieldName(name = "外部借阅人")
	@Column(name="OUT_BORROW", length=20)
	private String outborrow;
	
	@FieldName(name = "电话")
	@Column(name="PHONE", length=20)
	private String phone;
	
	@FieldName(name = "地址")
	@Column(name="ADDRESS", length=80)
	private String address;
	
	@FieldName(name = "公司名称")
	@Column(name="COMPANY_NAME", length=40)
	private String companyname;
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

	@FieldName(name = "备注")
	@Column(name="memo", length=3000)
	private String memo;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ContractDocSendInfo getContractDoc() {
		return contractDoc;
	}

	public void setContractDoc(ContractDocSendInfo contractDoc) {
		this.contractDoc = contractDoc;
	}

	public DictionaryData getType() {
		return type;
	}

	public void setType(DictionaryData type) {
		this.type = type;
	}

	public String getBorrowUser() {
		return borrowUser;
	}

	public void setBorrowUser(String borrowUser) {
		this.borrowUser = borrowUser;
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public User getReturnUser() {
		return returnUser;
	}

	public void setReturnUser(User returnUser) {
		this.returnUser = returnUser;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getBorrowSendNo() {
		return borrowSendNo;
	}

	public void setBorrowSendNo(String borrowSendNo) {
		this.borrowSendNo = borrowSendNo;
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

	public Integer getBorrowPart() {
		return borrowPart;
	}

	public void setBorrowPart(Integer borrowPart) {
		this.borrowPart = borrowPart;
	}

	public String getDatelimit() {
		return datelimit;
	}

	public void setDatelimit(String datelimit) {
		this.datelimit = datelimit;
	}
	public String getOutborrow() {
		return outborrow;
	}

	public void setOutborrow(String outborrow) {
		this.outborrow = outborrow;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public Integer getSeupart() {
		return seupart;
	}

	public void setSeupart(Integer seupart) {
		this.seupart = seupart;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
