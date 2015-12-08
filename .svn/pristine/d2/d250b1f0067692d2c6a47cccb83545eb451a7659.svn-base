package com.business.entity.cust;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.business.entity.Department;
import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.base.District;
import com.business.entity.base.Industry;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-7-28下午03:24:31
 * @info 客户信息
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "客户信息")
@Table(name="CUST_INFO_PERSON")
public class CustInfoPerson {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="客户ID")
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name="CUST_ID")
	private CustInfo custId;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "证件类型[D]")
	@JoinColumn(name="PASSPORT_TYPE")
	private DictionaryData passportType;
	
	@FieldName(name = "证件号码")
	@Column(name="ID_CARD_NO", length=20)
	private String idCardNo;

	@FieldName(name = "性别[S]")
	@Column(name="SEX_", length=2)
	private String sex;
	
	@FieldName(name = "出生日期")
	@Column(name="BRITH_DATE", length=20)
	private String brithDate;
	
	@FieldName(name = "户口所在地")
	@Column(name="DOMICILE_PLACE", length=100)
	private String domicilePlace;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "客户内部行业")
	@JoinColumn(name="CUST_KIND")
	private DictionaryData custKind;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "客户规模[D]")
	@JoinColumn(name="CUST_SCALE")
	private DictionaryData custScale;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="国家[B]")
	@JoinColumn(name="COUNTRY_")
	private District country;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="省份[B]")
	@JoinColumn(name="PROVINCE_")
	private District province;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="城市[B]")
	@JoinColumn(name="CITY_")
	private District city;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="地区[B]")
	@JoinColumn(name="COUNTY_")
	private District county;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "所属行业[B]")
	@JoinColumn(name = "INDUSTRY_")
	private Industry industry;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="客户所属行业大类[B]")
	@JoinColumn(name="INDUSTRY_LEVEL_BIG")
	private Industry industryLevelBig;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="客户所属行业中类[B]")
	@JoinColumn(name="INDUSTRY_LEVEL_MIDDLE")
	private Industry industryLevelMiddle;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="客户所属行业小类[B]")
	@JoinColumn(name="INDUSTRY_LEVEL_SMALL")
	private Industry industryLevelSmall;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "债权性质[D]")
	@JoinColumn(name="REDITOR_RIGHT")
	private DictionaryData reditorRight;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "担保性质[D]")
	@JoinColumn(name="ASSUROR_RIGHT")
	private DictionaryData assurorRight;
	
	@Column(name="HOME_ADD", length=200)
	@FieldName(name = "家庭地址")
	private String homeAdd;
	
	@Column(name="MAIL_ADD", length=200)
	@FieldName(name = "邮寄地址")
	private String mailAdd;
	
	@FieldName(name = "邮编")
	@Column(name="POST_CODE", length=10)
	private String postCode;
	
	@FieldName(name = "EMAIL")
	@Column(name="EMAIL_", length=50)
	private String email;
	
	@FieldName(name = "工作单位")
	@Column(name="UNIT_NAME", length=200)
	private String unitName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "职务[D]")
	@JoinColumn(name="UNIT_POSITION")
	private DictionaryData unitPosition;
	
	@FieldName(name = "工作电话")
	@Column(name="WORK_PHONE", length=100)
	private String workPhone;
	
	@FieldName(name = "传真")
	@Column(name="FAX_NUMBER", length=20)
	private String faxNumber;
	
	@FieldName(name = "手机号码")
	@Column(name="MOBILE_NUMBER", length=20)
	private String mobileNumber;
	
	@FieldName(name = "电话号码")
	@Column(name="PHONE_", length=100)
	private String phone;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "婚姻状态[D]")
	@JoinColumn(name="MARITAL_STATUS")
	private DictionaryData maritalStatus;
	
	@FieldName(name="配偶名称(德银)")
	@Column(name="SPOUSE_NAME", length=50)
	private String spouseName;
	
	@FieldName(name="配偶身份证号码(德银)")
	@Column(name="SPOUSE_IDCARDNO", length=20)
	private String spouseIdCardNo;
	
	@FieldName(name="配偶联系方式(德银)")
	@Column(name="SPOUSE_CONTACT", length=20)
	private String spouseContact;
	
	@FieldName(name="配偶年龄(德银)")
	@Column(name="SPOUSE_AGE", length=20)
	private String spouseAge;
	
	@FieldName(name="配偶工作单位(德银)")
	@Column(name="SPOUSE_WORK", length=50)
	private String spouseWork;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "学历[D]")
	@JoinColumn(name="SCHOOL_")
	private DictionaryData school;

	@Column(name="IS_ASSOCIATED", length=2)
	@FieldName(name = "是否与本企业关联[是/否--0/1][S]")
	private String isAssociated;

	@FieldName(name = "客户概况")
	@Column(name="CEIMEMO",length=2000)
	private String ceimemo;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "纳税人类别[D]")
	@JoinColumn(name="TAX_LEVEL")
	private DictionaryData taxLevel;
	
	@FieldName(name = "纳税人识别号/国税登记号")
	@Column(name="TAX_REG_CODE", length=20)
	private String taxRegCode;

	@Column(name="TAX_REG_ADD", length=200)
	@FieldName(name = "注册地址")
	private String taxRegAdd;
	
	@FieldName(name = "电话")
	@Column(name="TAX_PHONE", length=100)
	private String taxPhone;
	
	@FieldName(name = "开户银行")
	@Column(name="TAX_BANK", length=100)
	private String taxBank;
	
	@FieldName(name = "开户账号")
	@Column(name="TAX_ACC", length=30)
	private String taxAcc;
	
	@FieldName(name="货款卡号")
	@Column(name="CREDIT_CARD", length=50)
	private String creditCard;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "民族(德银)")
	@JoinColumn(name="CUST_ETHNIC")
	private DictionaryData custEthnic;
	
	@FieldName(name = "获取驾照日期(德银)")
	@Column(name="DRIVER_LICENSE_DATE", length=20)
	private String driverLicenseDate;
	
	@FieldName(name="常住地址(德银)")
	@Column(name="OFTEN_ADDR", length=200)
	private String oftenAddr;	
	
	@FieldName(name="有无子女(德银)[S]")
	@Column(name="SPOUSE_CHILD", length=2)
	private String spouseChild;

	@FieldName(name="自有车辆(德银)")
	@Column(name="OWNER_VEHICLE", length=2000)
	private String ownerVehicle;
	
	@FieldName(name="房产(德银)")
	@Column(name="OWNER_ESTATE", length=2000)
	private String ownerEstate;
	
	@FieldName(name="土地(德银)")
	@Column(name="OWNER_LAND", length=2000)
	private String ownerLand;
	
	@FieldName(name="其他(德银)")
	@Column(name="OWNER_OTHER", length=2000)
	private String ownerOther;
	
	@FieldName(name="资产估价（总）(德银)")
	@Column(name="OWNERSHIP_TOTAL", length=2000)
	private String ownershipTotal;

	@FieldName(name = "经销商或公司(德银)")
	@Column(name="DEALER_COMPANY",length=50)
	private String dealerOrCompany;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "登记人")
	@JoinColumn(name="CREATOR_")
	private User creator;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "登记部门")
	@JoinColumn(name="CREATOR_DEPT")
	private Department creatorDept;
	
	@FieldName(name = "登记时间")
	@Column(name="CREATE_DATE", length=20)
	private String createDate;
	@ManyToOne(fetch=FetchType.LAZY)
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

	public String getBrithDate() {
		return brithDate;
	}

	public void setBrithDate(String brithDate) {
		this.brithDate = brithDate;
	}

	public String getDomicilePlace() {
		return domicilePlace;
	}

	public void setDomicilePlace(String domicilePlace) {
		this.domicilePlace = domicilePlace;
	}

	public DictionaryData getCustKind() {
		return custKind;
	}

	public void setCustKind(DictionaryData custKind) {
		this.custKind = custKind;
	}

	public DictionaryData getCustScale() {
		return custScale;
	}

	public void setCustScale(DictionaryData custScale) {
		this.custScale = custScale;
	}

	public District getCountry() {
		return country;
	}

	public void setCountry(District country) {
		this.country = country;
	}

	public District getProvince() {
		return province;
	}

	public void setProvince(District province) {
		this.province = province;
	}

	public District getCity() {
		return city;
	}

	public void setCity(District city) {
		this.city = city;
	}

	public District getCounty() {
		return county;
	}

	public void setCounty(District county) {
		this.county = county;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public Industry getIndustryLevelBig() {
		return industryLevelBig;
	}

	public void setIndustryLevelBig(Industry industryLevelBig) {
		this.industryLevelBig = industryLevelBig;
	}

	public Industry getIndustryLevelMiddle() {
		return industryLevelMiddle;
	}

	public void setIndustryLevelMiddle(Industry industryLevelMiddle) {
		this.industryLevelMiddle = industryLevelMiddle;
	}

	public Industry getIndustryLevelSmall() {
		return industryLevelSmall;
	}

	public void setIndustryLevelSmall(Industry industryLevelSmall) {
		this.industryLevelSmall = industryLevelSmall;
	}

	public DictionaryData getReditorRight() {
		return reditorRight;
	}

	public void setReditorRight(DictionaryData reditorRight) {
		this.reditorRight = reditorRight;
	}

	public DictionaryData getAssurorRight() {
		return assurorRight;
	}

	public void setAssurorRight(DictionaryData assurorRight) {
		this.assurorRight = assurorRight;
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

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public DictionaryData getUnitPosition() {
		return unitPosition;
	}

	public void setUnitPosition(DictionaryData unitPosition) {
		this.unitPosition = unitPosition;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
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

	public DictionaryData getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(DictionaryData maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getSpouseIdCardNo() {
		return spouseIdCardNo;
	}

	public void setSpouseIdCardNo(String spouseIdCardNo) {
		this.spouseIdCardNo = spouseIdCardNo;
	}

	public String getSpouseContact() {
		return spouseContact;
	}

	public void setSpouseContact(String spouseContact) {
		this.spouseContact = spouseContact;
	}

	public String getSpouseAge() {
		return spouseAge;
	}

	public void setSpouseAge(String spouseAge) {
		this.spouseAge = spouseAge;
	}

	public DictionaryData getSchool() {
		return school;
	}

	public void setSchool(DictionaryData school) {
		this.school = school;
	}

	public String getIsAssociated() {
		return isAssociated;
	}

	public void setIsAssociated(String isAssociated) {
		this.isAssociated = isAssociated;
	}

	public String getCeimemo() {
		return ceimemo;
	}

	public void setCeimemo(String ceimemo) {
		this.ceimemo = ceimemo;
	}

	public DictionaryData getTaxLevel() {
		return taxLevel;
	}

	public void setTaxLevel(DictionaryData taxLevel) {
		this.taxLevel = taxLevel;
	}

	public String getTaxRegCode() {
		return taxRegCode;
	}

	public String getSpouseWork() {
		return spouseWork;
	}

	public void setSpouseWork(String spouseWork) {
		this.spouseWork = spouseWork;
	}

	public void setTaxRegCode(String taxRegCode) {
		this.taxRegCode = taxRegCode;
	}

	public String getTaxRegAdd() {
		return taxRegAdd;
	}

	public void setTaxRegAdd(String taxRegAdd) {
		this.taxRegAdd = taxRegAdd;
	}

	public String getTaxPhone() {
		return taxPhone;
	}

	public void setTaxPhone(String taxPhone) {
		this.taxPhone = taxPhone;
	}

	public String getTaxBank() {
		return taxBank;
	}

	public void setTaxBank(String taxBank) {
		this.taxBank = taxBank;
	}

	public String getTaxAcc() {
		return taxAcc;
	}

	public void setTaxAcc(String taxAcc) {
		this.taxAcc = taxAcc;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public DictionaryData getCustEthnic() {
		return custEthnic;
	}

	public void setCustEthnic(DictionaryData custEthnic) {
		this.custEthnic = custEthnic;
	}

	public String getDriverLicenseDate() {
		return driverLicenseDate;
	}

	public void setDriverLicenseDate(String driverLicenseDate) {
		this.driverLicenseDate = driverLicenseDate;
	}

	public String getOftenAddr() {
		return oftenAddr;
	}

	public void setOftenAddr(String oftenAddr) {
		this.oftenAddr = oftenAddr;
	}

	public String getSpouseChild() {
		return spouseChild;
	}

	public void setSpouseChild(String spouseChild) {
		this.spouseChild = spouseChild;
	}

	public String getOwnerVehicle() {
		return ownerVehicle;
	}

	public void setOwnerVehicle(String ownerVehicle) {
		this.ownerVehicle = ownerVehicle;
	}

	public String getOwnerEstate() {
		return ownerEstate;
	}

	public void setOwnerEstate(String ownerEstate) {
		this.ownerEstate = ownerEstate;
	}

	public String getOwnerLand() {
		return ownerLand;
	}

	public void setOwnerLand(String ownerLand) {
		this.ownerLand = ownerLand;
	}

	public String getOwnerOther() {
		return ownerOther;
	}

	public void setOwnerOther(String ownerOther) {
		this.ownerOther = ownerOther;
	}

	public String getOwnershipTotal() {
		return ownershipTotal;
	}

	public void setOwnershipTotal(String ownershipTotal) {
		this.ownershipTotal = ownershipTotal;
	}

	public String getDealerOrCompany() {
		return dealerOrCompany;
	}

	public void setDealerOrCompany(String dealerOrCompany) {
		this.dealerOrCompany = dealerOrCompany;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Department getCreatorDept() {
		return creatorDept;
	}

	public void setCreatorDept(Department creatorDept) {
		this.creatorDept = creatorDept;
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
