package com.business.entity.proj.invoice;

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

import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.proj.ProjInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-6下午02:50:53
 * @info
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "项目开票类型信息")
@Table(name="PROJ_INVOICE_TYPE")
public class ProjInvoiceType {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="项目编号")
	@OneToOne(targetEntity=ProjInfo.class)
	@JoinColumn(name="PROJ_ID")
	private ProjInfo projId;
	
	@FieldName(name="开票类型")
	@JoinColumn(name="RENTINVOICETYPE")
	@ManyToOne(fetch = FetchType.LAZY)
	private DictionaryData rentInvoiceType;

	@FieldName(name="租金是否拆分:是/否--APPSTATICUTIL类里声明")
	@Column(name="ISINVOICERENTSPLIT")
	private String isInvoiceRentSplit;
	
	@FieldName(name="是否一次性开票:是/否--APPSTATICUTIL类里声明")
	@Column(name="BOOLINVOICE")
	private String boolInvoice;

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

	public DictionaryData getRentInvoiceType() {
		return rentInvoiceType;
	}

	public void setRentInvoiceType(DictionaryData rentInvoiceType) {
		this.rentInvoiceType = rentInvoiceType;
	}
	public void setProjId(ProjInfo projId) {
		this.projId = projId;
	}

	public ProjInfo getProjId() {
		return projId;
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

	public String getIsInvoiceRentSplit() {
		return isInvoiceRentSplit;
	}

	public String getBoolInvoice() {
		return boolInvoice;
	}

	public void setIsInvoiceRentSplit(String isInvoiceRentSplit) {
		this.isInvoiceRentSplit = isInvoiceRentSplit;
	}

	public void setBoolInvoice(String boolInvoice) {
		this.boolInvoice = boolInvoice;
	}
}  
