package com.business.entity.dealer;

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
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-7-29下午08:01:31
 * @info 经销商抵押合同申请文件清单(德银)
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "经销商抵押合同申请文件清单(德银)")
@Table(name="DEALER_DOCUMENT_LIST")
public class DealerDocumentList {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="申请记录")
	@JoinColumn(name="PID_")
	private DealerDocumentInfo documentInfo;
	
	@FieldName(name = "办理地点")
	@Column(name="APP_ADDR")
	private String appAddr;
	
	@FieldName(name = "组织机构代码证")
	@Column(name="REG_CODE")
	private Integer regCode;
	
	@FieldName(name = "抵押登记申请表")
	@Column(name="GUARANTEE_NUM")
	private Integer guaranteeNum;

	@FieldName(name = "抵押合同")
	@Column(name="GUARANTEE_DOC_NUM")
	private Integer guaranteeDocNum;
	
	@FieldName(name = "授权委托书标准版")
	@Column(name="ENTRUST_NORMAL_NUM")
	private Integer entrustNormalNum;
	
	@FieldName(name = "授权委托书通用版")
	@Column(name="ENTRUST_NUM")
	private Integer entrustNum;
	
	@FieldName(name = "其他材料")
	@Column(name="OTHER_DOC",length=3000)
	private String otherDoc;
	
	@FieldName(name = "抵押或解除抵押状态")
	@Column(name="STATUS", length=20)
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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

	public DealerDocumentInfo getDocumentInfo() {
		return documentInfo;
	}

	public void setDocumentInfo(DealerDocumentInfo documentInfo) {
		this.documentInfo = documentInfo;
	}

	public String getAppAddr() {
		return appAddr;
	}

	public void setAppAddr(String appAddr) {
		this.appAddr = appAddr;
	}


	public Integer getGuaranteeNum() {
		return guaranteeNum;
	}

	public void setGuaranteeNum(Integer guaranteeNum) {
		this.guaranteeNum = guaranteeNum;
	}

	public Integer getGuaranteeDocNum() {
		return guaranteeDocNum;
	}

	public void setGuaranteeDocNum(Integer guaranteeDocNum) {
		this.guaranteeDocNum = guaranteeDocNum;
	}

	public Integer getEntrustNormalNum() {
		return entrustNormalNum;
	}

	public void setEntrustNormalNum(Integer entrustNormalNum) {
		this.entrustNormalNum = entrustNormalNum;
	}

	public Integer getEntrustNum() {
		return entrustNum;
	}

	public void setEntrustNum(Integer entrustNum) {
		this.entrustNum = entrustNum;
	}

	public String getOtherDoc() {
		return otherDoc;
	}

	public void setOtherDoc(String otherDoc) {
		this.otherDoc = otherDoc;
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

	public Integer getRegCode() {
		return regCode;
	}

	public void setRegCode(Integer regCode) {
		this.regCode = regCode;
	}
	
}
