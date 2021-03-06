package com.business.entity.cust;

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
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-7-28下午03:24:39
 * @info 重要个人
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "重要个人")
@Table(name = "CUST_RELATED_PERSON")
public class CustInfoRelatedPerson {
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(length = 32)
	private String id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="客户ID")
	@JoinColumn(name="CUST_ID")
	private CustInfo custId;

	@FieldName(name = "重要个人名称")
	@Column(name = "PERSON_NAME_", length = 50)
	private String personName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="证件类别[D]")
	@JoinColumn(name="PASSPORT_TYPE")
	private DictionaryData passportType;
	
	@FieldName(name="证件号码")
	@Column(name="ID_CARD_NO", length=20)
	private String idCardNo;
	
	@FieldName(name="性别[S]")
	@Column(name="SEX_", length=2)
	private String sex;
	
	@FieldName(name="出生年月")
	@Column(name="BIRTH_DATE", length=20)
	private String birthDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="关系[D]")
	@JoinColumn(name="RELATIONSHIP")
	private DictionaryData relationship;
	
	@FieldName(name="工作单位")
	@Column(name="UNIT_NAME", length=50)
	private String unitName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="职位[D]")
	@JoinColumn(name="JOBPOSITION")
	private DictionaryData jobposition;
	
	@FieldName(name="任职年限")
	@Column(name="SERVICE_LIFE",precision=22,scale=2)
	private BigDecimal serviceLife;
	
	@FieldName(name="是否主联系人[S]")
	@Column(name="MAIN_PERSON_FLAG", length=2)
	private String mainPersonFlag;
	
	@FieldName(name="籍贯(户口所在地)")
	@Column(name="DOMICILE_PLACE", length=200)
	private String domicilePlace;
	
	@FieldName(name="常住地址")
	@Column(name="HOME_ADD", length=200)
	private String homeAdd;
	
	@FieldName(name="邮寄地址")
	@Column(name="MAIL_ADD", length=200)
	private String mailAdd;
	
	@FieldName(name="EMAIL")
	@Column(name="EMAIL_", length=100)
	private String email;
	
	@FieldName(name="邮政编码")
	@Column(name="POST_CODE", length=10)
	private String postCode;

	@FieldName(name="手机号码")
	@Column(name="MOBILE_NUMBER", length=20)
	private String mobileNumber;
	
	@FieldName(name="电话")
	@Column(name="PHONE_", length=100)
	private String phone;
	
	@FieldName(name="备注")
	@Column(name="CPMEMO", length=255)
	private String cpmemo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="登记人")
	@JoinColumn(name="CREATOR_")
	private User creator;
	
	@FieldName(name="登记时间")
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

	public CustInfo getCustId() {
		return custId;
	}

	public void setCustId(CustInfo custId) {
		this.custId = custId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public DictionaryData getPassportType() {
		return passportType;
	}

	public void setPassportType(DictionaryData passportType) {
		this.passportType = passportType;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public DictionaryData getRelationship() {
		return relationship;
	}

	public void setRelationship(DictionaryData relationship) {
		this.relationship = relationship;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public DictionaryData getJobposition() {
		return jobposition;
	}

	public void setJobposition(DictionaryData jobposition) {
		this.jobposition = jobposition;
	}

	public BigDecimal getServiceLife() {
		return serviceLife;
	}

	public void setServiceLife(BigDecimal serviceLife) {
		this.serviceLife = serviceLife;
	}

	public String getMainPersonFlag() {
		return mainPersonFlag;
	}

	public void setMainPersonFlag(String mainPersonFlag) {
		this.mainPersonFlag = mainPersonFlag;
	}

	public String getDomicilePlace() {
		return domicilePlace;
	}

	public void setDomicilePlace(String domicilePlace) {
		this.domicilePlace = domicilePlace;
	}

	public String getHomeAdd() {
		return homeAdd;
	}

	public void setHomeAdd(String homeAdd) {
		this.homeAdd = homeAdd;
	}

	public String getMailAdd() {
		return mailAdd;
	}

	public void setMailAdd(String mailAdd) {
		this.mailAdd = mailAdd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCpmemo() {
		return cpmemo;
	}

	public void setCpmemo(String cpmemo) {
		this.cpmemo = cpmemo;
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
