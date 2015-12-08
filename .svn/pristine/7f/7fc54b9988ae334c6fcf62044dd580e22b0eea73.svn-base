package com.business.entity.util;

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
 * @date 2013-3-7下午03:42:04
 * @info 本方账户信息
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "本方账户信息")
@Table(name="OWN_ACCOUNT")
public class OwnAccount {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="本方公司信息ID")
	@ManyToOne(targetEntity=OwnInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name="OWN_ID")
	private OwnInfo ownId;
	
	@FieldName(name="本方账号")
	@Column(name="ACC_NUMBER",length=50)
	private String accNumber;

	@FieldName(name="本方银行")
	@Column(name="ACC_BANK",length=50)
	private String accBank;

	@FieldName(name="本方银行账户")
	@Column(name="ACC_NAME",length=50)
	private String accName;
	
	@FieldName(name="银行账户编码")
	@Column(name="ACC_CODE",length=50)
	private String accCode;
	
	@FieldName(name="改银行账户对应科目")
	@Column(name="ACC_SUBJECT",length=50)
	private String accSubject;

	@FieldName(name="状态")
	@Column(name="STATE_",length=2)
	private String state;

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

	public OwnInfo getOwnId() {
		return ownId;
	}

	public void setOwnId(OwnInfo ownId) {
		this.ownId = ownId;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getAccBank() {
		return accBank;
	}

	public void setAccBank(String accBank) {
		this.accBank = accBank;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	public String getAccSubject() {
		return accSubject;
	}

	public void setAccSubject(String accSubject) {
		this.accSubject = accSubject;
	}
	
	
}
