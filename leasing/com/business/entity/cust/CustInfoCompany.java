package com.business.entity.cust;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
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
 * @date 2013-7-28下午03:24:06
 * @info 法人客户信息
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "法人客户信息")
@Table(name="CUST_INFO_COMPANY")
public class CustInfoCompany {
	@Id
	@OrderBy
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;

	@FieldName(name="客户ID")
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name="CUST_ID")
	private CustInfo custId;
	
	@Column(name="SENIOR_NAME", length=200)
	@FieldName(name="高管名称")
	private String seniorName;
	
	@Column(name="POSITION", length=200)
	@FieldName(name="职位")
	private String position;
	
	@Column(name="DEGREE", length=200)
	@FieldName(name="学历")
	private String degree;
	
	@Column(name="WORK_LIFE", length=200)
	@FieldName(name="从业年限")
	private String worklife;
	
	@Column(name="C_AGE", length=200)
	@FieldName(name="年龄")
	private String cage;
	
	@Column(name="ORG_CODE", length=20)
	@FieldName(name="组织结构代码")
	private String orgCode;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="客户规模[D]")
	@JoinColumn(name="CUST_SCALE")
	private DictionaryData custScale;
	
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
	
	@FieldName(name="是否与本企业关联[S]")
	@Column(name="IS_ASSOCIATED", length=2)
	private String isAssociated;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="债权性质[D]")
	@JoinColumn(name="REDITOR_RIGHT")
	private DictionaryData reditorRight;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="担保性质[D]")
	@JoinColumn(name="ASSUROR_RIGHT")
	private DictionaryData assurorRight;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="客户内部行业[D]")
	@JoinColumn(name="CUST_KIND")
	private DictionaryData custKind;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="客户所属行业门类[B]")
	@JoinColumn(name="INDUSTRY_")
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
	@FieldName(name="企业性质[D]")
	@JoinColumn(name="OWNER_SHIP")
	private DictionaryData ownership;
	
	@FieldName(name="法人代表")
	@Column(name="LEGAL_REPRESENTATIVE", length=50)
	private String legalRepresentative;
	
	@FieldName(name="法人代表身份证号")
	@Column(name="ID_CARD_NO", length=20)
	private String idcardNo;
	
	@FieldName(name="手机")
	@Column(name="MOBILE_NUMBER", length=20)
	private String mobileNumber;

	@FieldName(name="电话")
	@Column(name="PHONE_",length=100)
	private String phone;
	
	@FieldName(name="邮寄地址")
	@Column(name="MAIL_ADD", length=200)
	private String mailAdd;
	
	@FieldName(name="邮编")
	@Column(name="POST_CODE", length=10)
	private String postCode;
	
	@FieldName(name="公司网址")
	@Column(name="WEB_SITE", length=50)
	private String webSite;
	
	@FieldName(name="公司地址")
	@Column(name="POST_ADDR", length=200)
	private String postAddr;
	
	@FieldName(name="传真")
	@Column(name="FAX_NUMBER", length=20)
	private String faxNumber;

	@FieldName(name="登记注册号（营业执照号）")
	@Column(name="REG_NUMBER", length=20)
	private String regNumber;
	
	@FieldName(name="国税登记号")
	@Column(name="NATIONAL_TAX_NUMBER", length=20)
	private String nationalTaxNumber;
	
	@FieldName(name="地税登记号")
	@Column(name="LAND_TAX_NUMBER", length=20)
	private String landTaxNumber;
	
	@FieldName(name="注册资本")
	@Column(name="REG_CAPITAL", length=100)
	private String regCapital;
	
	@FieldName(name="注册地址")
	@Column(name="REG_ADDR", length=200)
	private String regAddr;
	
	@FieldName(name="经营方式")
	@Column(name="BIZ_METHOD", length=2000)
	private String bizMethod;
	
	@FieldName(name="经营范围（主营）")
	@Column(name="BIZ_SCOPE_PRIMARY", length=2000)
	private String bizScopePrimary;
	
	@FieldName(name="经营范围（兼营）")
	@Column(name="BIZ_SCOPE_SECONDARY", length=2000)
	private String bizScopeSecondary;
	
	@FieldName(name="客户概况")
	@Column(name="CIMEMO",length=2000)
	private String cimemo;
	
	@FieldName(name="是否已办企业管理(德银)[S]")
	@Column(name="IS_COMPANY_MANAGE",length=2)
	private String  isCompanyManage;
	
	@FieldName(name = "实收资本(德银)")
	@Column(name="CALLED_CAPITAL",precision=22,scale=2)
	private BigDecimal calledCapital;
	
	@FieldName(name = "出资方式及金额(货币、实物等)(德银)")
	@Column(name="INVESTMENT_AMOUN", length = 50)
	private String investmentAmoun;
	
	@FieldName(name = "注册登记机关(德银)")
	@Column(name="REGISTRATION_AUTHORITY", length = 50)
	private String registrationauthority;
	
	@FieldName(name = "认缴额(德银)")
	@Column(name="SUBSCRIPTIONS",precision=22,scale=2)
	private BigDecimal subscriptions;
	
	@FieldName(name = "实缴额(德银)")
	@Column(name="PAID_INAMOUNT",precision=22,scale=2)
	private BigDecimal paidInamount;
	
	@FieldName(name = "成立时间(德银)")
	@Column(name="FUND_TIME", length = 20)
	private String fundTime;
	
	@FieldName(name = "抵押方式(德银)")
	@Column(name="COLLATERAL_TYPE",length=2 )
	private String collateralType;
	
	@FieldName(name = "抵押物品名称(德银)")
	@Column(name="COLLATERAL_NAME", length = 50)
	private String collateralName;
	
	@FieldName(name = "有无估价文件(德银)[S]")
	@Column(name="VALUATION_FILE", length = 2)
	private String valuationFile;
	
	@FieldName(name = "抵押物价值(德银)")
	@Column(name="GAGE_VALUE",precision=22,scale=2)
	private BigDecimal gageValue;
	
	@FieldName(name = "质物方式(德银)")
	@Column(name="PLEDGE_TYPE", length = 2)
	private String pledgeType;
	
	@FieldName(name = "质物名称(德银)")
	@Column(name="PLEDGE_NAME", length = 50)
	private String pledgeName;
	
	@FieldName(name = "质物价值(德银)")
	@Column(name="PLEDGE_VALUE",precision=22,scale=2)
	private BigDecimal pledgeValue;
	
	@FieldName(name = "保证方式(德银)")
	@Column(name="WARRANTER_TYPE",length=2)
	private String warranterType;
	
	@FieldName(name = "保证人名称(德银)")
	@Column(name="WARRANTER_NAME", length = 50)
	private String warranterName;
	
	@FieldName(name = "年营业收入(德银)")
	@Column(name="ANNUAL_REVENUE",precision=22,scale=2)
	private BigDecimal annualRevenue;
	
	@FieldName(name = "企业总人数(德银)")
	@Column(name="ENTERPRISE_TOTAL",precision=22)
	private Integer enterpriseTotal;
	
	@FieldName(name = "企业在职人数(德银)")
	@Column(name="ENTERPRISE_NUMBER",precision=22)
	private Integer enterpriseNumber;
	
	@FieldName(name="净资产(德银)")
	@Column(name="NET_ASSETS",precision=22,scale=2)
	private BigDecimal netAssets;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="银行信用等级[D]")
	@JoinColumn(name="BANK_LEVEL")
	private DictionaryData bankLevel;
	
	@FieldName(name = "经销商或公司(德银)")
	@Column(name="DEALER_COMPANY",length=50)
	private String dealerOrCompany;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "登记人")
	@JoinColumn(name="CREATOR_")
	private User creator;

	@FieldName(name = "登记时间")
	@Column(name="CREATE_DATE", length = 20)
	private String createDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "登记部门")
	@JoinColumn(name="CREATOR_DEPT")
	private Department creatorDept;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "更新人")
	@JoinColumn(name="MODIFICATOR_")
	private User modificator;

	@FieldName(name = "更新时间")
	@Column(name="MODIFY_DATE", length = 20)
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

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public DictionaryData getCustScale() {
		return custScale;
	}

	public void setCustScale(DictionaryData custScale) {
		this.custScale = custScale;
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

	public String getIsAssociated() {
		return isAssociated;
	}

	public void setIsAssociated(String isAssociated) {
		this.isAssociated = isAssociated;
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

	public DictionaryData getCustKind() {
		return custKind;
	}

	public void setCustKind(DictionaryData custKind) {
		this.custKind = custKind;
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

	public DictionaryData getOwnership() {
		return ownership;
	}

	public void setOwnership(DictionaryData ownership) {
		this.ownership = ownership;
	}

	public String getLegalRepresentative() {
		return legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	public String getIdcardNo() {
		return idcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
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

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getPostAddr() {
		return postAddr;
	}

	public void setPostAddr(String postAddr) {
		this.postAddr = postAddr;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getNationalTaxNumber() {
		return nationalTaxNumber;
	}

	public void setNationalTaxNumber(String nationalTaxNumber) {
		this.nationalTaxNumber = nationalTaxNumber;
	}

	public String getLandTaxNumber() {
		return landTaxNumber;
	}

	public void setLandTaxNumber(String landTaxNumber) {
		this.landTaxNumber = landTaxNumber;
	}

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}

	public String getRegAddr() {
		return regAddr;
	}

	public void setRegAddr(String regAddr) {
		this.regAddr = regAddr;
	}

	public String getBizMethod() {
		return bizMethod;
	}

	public void setBizMethod(String bizMethod) {
		this.bizMethod = bizMethod;
	}

	public String getBizScopePrimary() {
		return bizScopePrimary;
	}

	public void setBizScopePrimary(String bizScopePrimary) {
		this.bizScopePrimary = bizScopePrimary;
	}

	public String getBizScopeSecondary() {
		return bizScopeSecondary;
	}

	public void setBizScopeSecondary(String bizScopeSecondary) {
		this.bizScopeSecondary = bizScopeSecondary;
	}

	public String getCimemo() {
		return cimemo;
	}

	public void setCimemo(String cimemo) {
		this.cimemo = cimemo;
	}

	public String getIsCompanyManage() {
		return isCompanyManage;
	}

	public void setIsCompanyManage(String isCompanyManage) {
		this.isCompanyManage = isCompanyManage;
	}

	public BigDecimal getCalledCapital() {
		return calledCapital;
	}

	public void setCalledCapital(BigDecimal calledCapital) {
		this.calledCapital = calledCapital;
	}

	public String getInvestmentAmoun() {
		return investmentAmoun;
	}

	public void setInvestmentAmoun(String investmentAmoun) {
		this.investmentAmoun = investmentAmoun;
	}

	public String getRegistrationauthority() {
		return registrationauthority;
	}

	public void setRegistrationauthority(String registrationauthority) {
		this.registrationauthority = registrationauthority;
	}

	public BigDecimal getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(BigDecimal subscriptions) {
		this.subscriptions = subscriptions;
	}

	public BigDecimal getPaidInamount() {
		return paidInamount;
	}

	public void setPaidInamount(BigDecimal paidInamount) {
		this.paidInamount = paidInamount;
	}

	public String getFundTime() {
		return fundTime;
	}

	public void setFundTime(String fundTime) {
		this.fundTime = fundTime;
	}

	public String getCollateralType() {
		return collateralType;
	}

	public void setCollateralType(String collateralType) {
		this.collateralType = collateralType;
	}

	public String getCollateralName() {
		return collateralName;
	}

	public void setCollateralName(String collateralName) {
		this.collateralName = collateralName;
	}

	public String getValuationFile() {
		return valuationFile;
	}

	public void setValuationFile(String valuationFile) {
		this.valuationFile = valuationFile;
	}

	public BigDecimal getGageValue() {
		return gageValue;
	}

	public void setGageValue(BigDecimal gageValue) {
		this.gageValue = gageValue;
	}

	public String getPledgeType() {
		return pledgeType;
	}

	public void setPledgeType(String pledgeType) {
		this.pledgeType = pledgeType;
	}

	public String getPledgeName() {
		return pledgeName;
	}

	public void setPledgeName(String pledgeName) {
		this.pledgeName = pledgeName;
	}

	public BigDecimal getPledgeValue() {
		return pledgeValue;
	}

	public void setPledgeValue(BigDecimal pledgeValue) {
		this.pledgeValue = pledgeValue;
	}

	public String getWarranterType() {
		return warranterType;
	}

	public void setWarranterType(String warranterType) {
		this.warranterType = warranterType;
	}

	public String getWarranterName() {
		return warranterName;
	}

	public void setWarranterName(String warranterName) {
		this.warranterName = warranterName;
	}

	public BigDecimal getAnnualRevenue() {
		return annualRevenue;
	}

	public void setAnnualRevenue(BigDecimal annualRevenue) {
		this.annualRevenue = annualRevenue;
	}

	public Integer getEnterpriseTotal() {
		return enterpriseTotal;
	}

	public void setEnterpriseTotal(Integer enterpriseTotal) {
		this.enterpriseTotal = enterpriseTotal;
	}

	public Integer getEnterpriseNumber() {
		return enterpriseNumber;
	}

	public void setEnterpriseNumber(Integer enterpriseNumber) {
		this.enterpriseNumber = enterpriseNumber;
	}

	public BigDecimal getNetAssets() {
		return netAssets;
	}

	public void setNetAssets(BigDecimal netAssets) {
		this.netAssets = netAssets;
	}

	public DictionaryData getBankLevel() {
		return bankLevel;
	}

	public void setBankLevel(DictionaryData bankLevel) {
		this.bankLevel = bankLevel;
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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Department getCreatorDept() {
		return creatorDept;
	}

	public void setCreatorDept(Department creatorDept) {
		this.creatorDept = creatorDept;
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

	public String getSeniorName() {
		return seniorName;
	}

	public void setSeniorName(String seniorName) {
		this.seniorName = seniorName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getWorklife() {
		return worklife;
	}

	public void setWorklife(String worklife) {
		this.worklife = worklife;
	}

	public String getCage() {
		return cage;
	}

	public void setCage(String cage) {
		this.cage = cage;
	}
	
}
