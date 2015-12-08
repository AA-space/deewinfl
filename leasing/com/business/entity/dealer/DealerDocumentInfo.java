package com.business.entity.dealer;

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
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import com.business.entity.User;
import com.business.entity.cust.CustInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-7-28下午03:27:51
 * @info 经销商抵押合同申请记录(德银)
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "经销商抵押合同申请记录(德银)")
@Table(name="Dealer_Document_Info")
public class DealerDocumentInfo {
	
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="经销商ID")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUST_ID")
	private CustInfo custId;
 
	@FieldName(name = "流程实例ID")
	@Column(name="DOC_ID", length=20)
	private String docID;
	
	@FieldName(name = "联系人")
	@Column(name="COMM_PERSON", length=50)
	private String commPerson;
	
	@FieldName(name = "邮寄地址")
	@Column(name="MAIL_ADDR", length=200)
	private String mailAddr;
	
	@FieldName(name = "电话")
	@Column(name="phone_", length=100)
	private String phone;
	
	@FieldName(name = "申请日期")
	@Column(name="APP_DATE", length=20)
	private String appDate;
	
	@FieldName(name = "快递单号")
	@Column(name="SEND_NUM", length=20)
	private String sendNum;
	
	@FieldName(name = "快递时间")
	@Column(name="SEND_DATE", length=20)
	private String sendDate;

	@FieldName(name = "备注")
	@Column(name="SEND_MEMO", length=2000)
	private String sendMemo;
	
	@FieldName(name = "申请材料说明")
	@Column(name="APP_MEMO", length=2000)
	private String appMemo;
	
	@JsonIgnore
	@OneToMany(mappedBy="documentInfo",  fetch=FetchType.LAZY)
	private Set<DealerDocumentList> dealerDocumentList=new HashSet<DealerDocumentList>();
	
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

	public String getCommPerson() {
		return commPerson;
	}

	public void setCommPerson(String commPerson) {
		this.commPerson = commPerson;
	}

	public String getMailAddr() {
		return mailAddr;
	}

	public void setMailAddr(String mailAddr) {
		this.mailAddr = mailAddr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public String getSendNum() {
		return sendNum;
	}

	public void setSendNum(String sendNum) {
		this.sendNum = sendNum;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getSendMemo() {
		return sendMemo;
	}

	public void setSendMemo(String sendMemo) {
		this.sendMemo = sendMemo;
	}

	public String getAppMemo() {
		return appMemo;
	}

	public void setAppMemo(String appMemo) {
		this.appMemo = appMemo;
	}

	public Set<DealerDocumentList> getDealerDocumentList() {
		return dealerDocumentList;
	}

	public void setDealerDocumentList(Set<DealerDocumentList> dealerDocumentList) {
		this.dealerDocumentList = dealerDocumentList;
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
