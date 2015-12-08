package com.business.entity.proj;

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
import com.business.entity.cust.CustInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-6下午02:50:21
 * @info 项目担保方式
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "项目担保方式")
@Table(name="PROJ_GUARANTEE_METHOD")
public class ProjGuaranteeMethod {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="项目编号")
	@OneToOne(targetEntity=ProjInfo.class)
	@JoinColumn(name="PROJ_ID")
	private ProjInfo projId;
	
	@FieldName(name="担保单位")
	@JoinColumn(name="ASSUROR")
	@ManyToOne(fetch = FetchType.LAZY)
	private CustInfo assuror;

	@FieldName(name="担保人信息(德银)")
	@Column(name="ASSUROR_INFO")
	private String assurorInfo;
	
	@FieldName(name="担保类型")
	@JoinColumn(name="ASSURE_METHOD")
	@ManyToOne(fetch = FetchType.LAZY)
	private DictionaryData assureMethod;

	@FieldName(name="担保关系")
	@JoinColumn(name="ASSURE_RELATION")
	@ManyToOne(fetch = FetchType.LAZY)
	private DictionaryData assureRelation;

	@FieldName(name="备注")
	@Column(name="CGMNOTE")
	private String cgmnote;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="创建人")
	@JoinColumn(name="CREATOR_")
	private User creator;
	
	@FieldName(name="创建时间")
	@Column(name="CREATE_DATE", length=20)	
	private String createDate;
	
	@FieldName(name="修改人")
	@JoinColumn(name="MODIFICATOR")
	@ManyToOne(fetch = FetchType.LAZY)
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

	public ProjInfo getProjId() {
		return projId;
	}

	public void setProjId(ProjInfo projId) {
		this.projId = projId;
	}

	public CustInfo getAssuror() {
		return assuror;
	}

	public void setAssuror(CustInfo assuror) {
		this.assuror = assuror;
	}

	public String getAssurorInfo() {
		return assurorInfo;
	}

	public void setAssurorInfo(String assurorInfo) {
		this.assurorInfo = assurorInfo;
	}

	public DictionaryData getAssureMethod() {
		return assureMethod;
	}

	public void setAssureMethod(DictionaryData assureMethod) {
		this.assureMethod = assureMethod;
	}

	public DictionaryData getAssureRelation() {
		return assureRelation;
	}

	public void setAssureRelation(DictionaryData assureRelation) {
		this.assureRelation = assureRelation;
	}

	public String getCgmnote() {
		return cgmnote;
	}

	public void setCgmnote(String cgmnote) {
		this.cgmnote = cgmnote;
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
