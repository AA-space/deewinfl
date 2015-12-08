package com.business.entity.dealer;

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
import com.business.entity.cust.CustInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-7-28下午03:22:57
 * @info 经销商信息(德银)
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "经销商信息(德银)")
@Table(name="CUST_INFO_DEALER")
public class CustInfoDealer {
	@Id
	@OrderBy
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;

	@FieldName(name="经销商ID")
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name="CUST_ID")
	private CustInfo custId;
	
	@FieldName(name="所属一级经销商ID")
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name="ONE_LEVEL")
	private CustInfo onelevel;
		
	@FieldName(name="经销商合作编号")
	@Column(name="CONTRACT_NUM", length=50)
	private String contractNum;
	
	@FieldName(name="组织结构代码")
	@Column(name="ORG_CODE", length=20)
	private String orgCode;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="合作状态[S]")
	@JoinColumn(name="COOPERATE_STATUS")
	private DictionaryData cooperateStatus;
	
	@FieldName(name="是否暂停经销商立项,默认为1  暂停为0")
	@Column(name="DEALER_ZANT_STATUS", columnDefinition="VARCHAR2(32 CHAR) DEFAULT '1'")
	private String dealerzantstatus="1";
	
	@FieldName(name="是否二级经销商,默认否为1  是为0")
	@Column(name="TWO_LEVEL_STATUS", columnDefinition="VARCHAR2(32 CHAR) DEFAULT '1'")
	private String twolevelstatus="1";
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="纳税人类别[D]")
	@JoinColumn(name="TAX_LEVEL")
	private DictionaryData taxLevel;
	
	@FieldName(name="纳税人识别号/国税登记号")
	@Column(name="TAX_REG_CODE", length=20)
	private String taxRegCode;
	
	@FieldName(name="电话")
	@Column(name="TAX_PHONE", length=100)
	private String taxPhone;

	@FieldName(name="开户行")
	@Column(name="TAX_BANK", length=100)
	private String taxBank;
	
	@FieldName(name="开户账号")
	@Column(name="TAX_ACC", length=50)
	private String taxAcc;
	
	@FieldName(name="货款卡号")
	@Column(name="CREDIT_CARD", length=50)
	private String creditCard;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="客户规模[D]")
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
	@Column(name="REG_NUMBER", length=30)
	private String regNumber;
	
	@FieldName(name="注册时间")
	@Column(name="REG_DATE", length=20)
	private String regDate;
	
	@FieldName(name="注册资本")
	@Column(name="REG_CAPITAL", precision=22,scale=2)
	private BigDecimal regCapital;
	
	@FieldName(name="注册地址")
	@Column(name="REG_ADDR", length=200)
	private String regAddr;
	
	@FieldName(name="经营范围（主营）")
	@Column(name="BIZ_SCOPE_PRIMARY", length=2000)
	private String bizScopePrimary;
	
	@FieldName(name="经营范围（兼营）")
	@Column(name="BIZ_SCOPE_SECONDARY", length=2000)
	private String bizScopeSecondary;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="所属区域[D]")
	@JoinColumn(name="OWNER_DISTRICT")
	private DictionaryData ownerDistrict;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="办事处[D]")
	@JoinColumn(name="OWNER_OFFICE")
	private DictionaryData ownerOffice;
	
	@FieldName(name="近三年销量")
	@Column(name="THREE_YEAR_SALES", length=2000)
	private String threeYearSales;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="店面类型[D]")
	@JoinColumn(name="SHOP_TYPE")
	private DictionaryData shopType;
	
	@FieldName(name="是否4S")
	@Column(name="is_4s", length=2)
	private String is4s;
	
	@FieldName(name="与陕汽合作时间")
	@Column(name="COOPERATION_DATE", length=20)
	private String cooperationDate;
	
	@FieldName(name="目标销量")
	@Column(name="PURPOSE_SALES", length=2000)
	private String purposeSales;
		
	@FieldName(name="常住地址")
	@Column(name="OFTEN_ADDR", length=200)
	private String oftenAddr;

	@FieldName(name="净资产")
	@Column(name="NET_ASSETS", length=2000)
	private String netAssets;
	
	@FieldName(name="实收资本")
	@Column(name="INCOME_ASSETS", length=2000)
	private String incomeAssets;
	
	@FieldName(name="股权结构")
	@Column(name="OWNERSHIP_STRUCTURE", length=2000)
	private String ownershipStructure;
	
	
	@FieldName(name="自有车辆")
	@Column(name="OWNER_VEHICLE", length=2000)
	private String ownerVehicle;
	
	@FieldName(name="房产")
	@Column(name="OWNER_ESTATE", length=2000)
	private String ownerEstate;
	
	@FieldName(name="土地")
	@Column(name="OWNER_LAND", length=2000)
	private String ownerLand;
	
	@FieldName(name="其他")
	@Column(name="OWNER_OTHER", length=2000)
	private String ownerOther;
	
	@FieldName(name="资产估价（总）")
	@Column(name="OWNERSHIP_TOTAL", length=2000)
	private String ownershipTotal;
	
	@FieldName(name="备注")
	@Column(name="owner_Memo", length=2000)
	private String ownerMemo;
	
	@FieldName(name="暂停经销商立项备注")
	@Column(name="MEMO", length=2000)
	private String memo;
	
	@FieldName(name="经销商协议状态,提交到不合作为1  默认为(null)")
	@Column(name="DEALER_FILE_STATUS")
	private String dealerFileStatus;
	
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

	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public DictionaryData getCooperateStatus() {
		return cooperateStatus;
	}

	public void setCooperateStatus(DictionaryData cooperateStatus) {
		this.cooperateStatus = cooperateStatus;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public BigDecimal getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(BigDecimal regCapital) {
		this.regCapital = regCapital;
	}

	public String getRegAddr() {
		return regAddr;
	}

	public void setRegAddr(String regAddr) {
		this.regAddr = regAddr;
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

	public DictionaryData getOwnerDistrict() {
		return ownerDistrict;
	}

	public void setOwnerDistrict(DictionaryData ownerDistrict) {
		this.ownerDistrict = ownerDistrict;
	}

	public DictionaryData getOwnerOffice() {
		return ownerOffice;
	}

	public void setOwnerOffice(DictionaryData ownerOffice) {
		this.ownerOffice = ownerOffice;
	}

	public String getThreeYearSales() {
		return threeYearSales;
	}

	public void setThreeYearSales(String threeYearSales) {
		this.threeYearSales = threeYearSales;
	}

	public DictionaryData getShopType() {
		return shopType;
	}

	public void setShopType(DictionaryData shopType) {
		this.shopType = shopType;
	}

	public String getIs4s() {
		return is4s;
	}

	public void setIs4s(String is4s) {
		this.is4s = is4s;
	}

	public String getCooperationDate() {
		return cooperationDate;
	}

	public void setCooperationDate(String cooperationDate) {
		this.cooperationDate = cooperationDate;
	}

	public String getPurposeSales() {
		return purposeSales;
	}

	public void setPurposeSales(String purposeSales) {
		this.purposeSales = purposeSales;
	}

	public String getOftenAddr() {
		return oftenAddr;
	}

	public void setOftenAddr(String oftenAddr) {
		this.oftenAddr = oftenAddr;
	}

	public String getNetAssets() {
		return netAssets;
	}

	public void setNetAssets(String netAssets) {
		this.netAssets = netAssets;
	}

	public String getIncomeAssets() {
		return incomeAssets;
	}

	public void setIncomeAssets(String incomeAssets) {
		this.incomeAssets = incomeAssets;
	}

	public String getOwnershipStructure() {
		return ownershipStructure;
	}

	public void setOwnershipStructure(String ownershipStructure) {
		this.ownershipStructure = ownershipStructure;
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

	public String getOwnerMemo() {
		return ownerMemo;
	}

	public void setOwnerMemo(String ownerMemo) {
		this.ownerMemo = ownerMemo;
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDealerzantstatus() {
		return dealerzantstatus;
	}

	public void setDealerzantstatus(String dealerzantstatus) {
		this.dealerzantstatus = dealerzantstatus;
	}

	public CustInfo getOneLevel() {
		return onelevel;
	}

	public void setOneLevel(CustInfo onelevel) {
		this.onelevel = onelevel;
	}

	public String getTwolevelstatus() {
		return twolevelstatus;
	}

	public void setTwolevelstatus(String twolevelstatus) {
		this.twolevelstatus = twolevelstatus;
	}

	public String getDealerFileStatus() {
		return dealerFileStatus;
	}

	public void setDealerFileStatus(String dealerFileStatus) {
		this.dealerFileStatus = dealerFileStatus;
	}

}
