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
import com.business.entity.base.District;
import com.business.entity.cust.CustInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-7-29下午08:16:33
 * @info 经销商抵押合同申请记录(德银)
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "经销商抵押合同申请记录(德银)")
@Table(name="DEALER_GUARANTEE_INFO")
public class DealerGuaranteeInfo {
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
	
	@FieldName(name = "(经销商)联系人")
	@Column(name="COMM_PERSON", length=50)
	private String commPerson;
	
	@FieldName(name = "(经销商)地址")
	@Column(name="ADDR_", length=200)
	private String Addr;
	
	@FieldName(name = "(经销商)电话")
	@Column(name="phone_", length=100)
	private String phone;
	
	@FieldName(name = "(抵押人)联系人")
	@Column(name="GUA_PERSON", length=50)
	private String guaPerson;
	
	@FieldName(name = "(抵押人)地址")
	@Column(name="GUA_ADDR", length=200)
	private String guaAddr;
	
	@FieldName(name = "(抵押人)电话")
	@Column(name="GUA_PHONE", length=100)
	private String guaphone;
	
	@FieldName(name = "合同(年)")
	@Column(name="CONTRACT_YEAR", length=2)
	private String contractYear;
	
	@FieldName(name = "合同(流水号)")
	@Column(name="CONTRACT_NO", length=5)
	private String contractNo;
	
	@FieldName(name = "车辆类型")
	@Column(name="CAR_TYPE", length=20)
	private String carType;
	
	@FieldName(name = "车辆数量")
	@Column(name="CAR_NUM")
	private Integer carNum;
	
	@FieldName(name = "合同其他")
	@Column(name="CONTRACT_OTHER", length=100)
	private String contractOther;
	
	@FieldName(name = "抵押备案")
	@Column(name="IS_GUARANTY", length=100)
	private String isGuaranty;
	
	@FieldName(name = "抵押登记")
	@Column(name="IS_MORTGAGE", length=100)
	private String isMortgage;
	
	@FieldName(name = "解除抵押登记")
	@Column(name="NOT_GUARANTY", length=100)
	private String notGuaranty;
	
	@FieldName(name = "公证")
	@Column(name="IS_FAIR", length=100)
	private String isFair;
	
	@FieldName(name = "其他")
	@Column(name="IS_OTHER", length=100)
	private String isother;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="省份[B]")
	@JoinColumn(name="PROVINCE_")
	private District province;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="城市[B]")
	@JoinColumn(name="CITY_")
	private District city;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="地区[B]")
	@JoinColumn(name="COUNTY_")
	private District county;
	
	@FieldName(name = "期限")
	@Column(name="term_", length=100)
	private String term;
	
	@FieldName(name = "电话(事项)")
	@Column(name="OTHER_PHONE", length=100)
	private String otherPhone;
	
	@FieldName(name = "经办人")
	@Column(name="HANDLE_USER", length=20)
	private String handleUser;
	
	@FieldName(name = "经办时间")
	@Column(name="HANDLE_DATE", length=20)
	private String handleDate;
	
	@FieldName(name = "经办单位")
	@Column(name="HANDLE_UNIT", length=50)
	private String handleUnit;
	
	@FieldName(name = "经办单位时间")
	@Column(name="HANDLE_UNIT_DATE", length=20)
	private String handleUnitDate;
	
	@FieldName(name = "风险控制部意见")
	@Column(name="RISK_PROPOSAL", length=100)
	private String riskProposal;
	
	@FieldName(name = "风险控制部意见时间")
	@Column(name="RISK_PRO_DATE", length=20)
	private String riskProposalDate;
	
	@FieldName(name = "人员安排")
	@Column(name="USER_PLAN", length=50)
	private String userPlan;
	
	@FieldName(name = "期限安排")
	@Column(name="TERM_PLAN", length=50)
	private String termPlan;
	
	@FieldName(name = "办理结果")
	@Column(name="HANDLE_RS", length=2000)
	private String handleRS;
	
	@FieldName(name = "材料名称")
	@Column(name="MATERIAL_NAME", length=2000)
	private String materialName;
	
	@FieldName(name = "原件")
	@Column(name="ORIGINAL", length=2000)
	private String original;
	
	@FieldName(name = "复印件/份")
	@Column(name="COPY", length=2000)
	private String copy;
	
	@FieldName(name = "备注")
	@Column(name="MEMO", length=2000)
	private String memo;
	
	@FieldName(name = "快递单号")
	@Column(name="SINGLE_NUMBER", length=2000)
	private String singleNumber;
	
	@FieldName(name = "快递时间")
	@Column(name="SINGLE_TIME", length=2000)
	private String singleTime;
	
	
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

	public String getAddr() {
		return Addr;
	}

	public void setAddr(String addr) {
		Addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGuaPerson() {
		return guaPerson;
	}

	public void setGuaPerson(String guaPerson) {
		this.guaPerson = guaPerson;
	}

	public String getGuaAddr() {
		return guaAddr;
	}

	public void setGuaAddr(String guaAddr) {
		this.guaAddr = guaAddr;
	}

	public String getGuaphone() {
		return guaphone;
	}

	public void setGuaphone(String guaphone) {
		this.guaphone = guaphone;
	}

	public String getContractYear() {
		return contractYear;
	}

	public void setContractYear(String contractYear) {
		this.contractYear = contractYear;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Integer getCarNum() {
		return carNum;
	}

	public void setCarNum(Integer carNum) {
		this.carNum = carNum;
	}

	public String getContractOther() {
		return contractOther;
	}

	public void setContractOther(String contractOther) {
		this.contractOther = contractOther;
	}

	public String getIsGuaranty() {
		return isGuaranty;
	}

	public void setIsGuaranty(String isGuaranty) {
		this.isGuaranty = isGuaranty;
	}

	public String getIsMortgage() {
		return isMortgage;
	}

	public void setIsMortgage(String isMortgage) {
		this.isMortgage = isMortgage;
	}

	public String getNotGuaranty() {
		return notGuaranty;
	}

	public void setNotGuaranty(String notGuaranty) {
		this.notGuaranty = notGuaranty;
	}

	public String getIsFair() {
		return isFair;
	}

	public void setIsFair(String isFair) {
		this.isFair = isFair;
	}

	public String getIsother() {
		return isother;
	}

	public void setIsother(String isother) {
		this.isother = isother;
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

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getOtherPhone() {
		return otherPhone;
	}

	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}

	public String getHandleUser() {
		return handleUser;
	}

	public void setHandleUser(String handleUser) {
		this.handleUser = handleUser;
	}

	public String getHandleDate() {
		return handleDate;
	}

	public void setHandleDate(String handleDate) {
		this.handleDate = handleDate;
	}

	public String getHandleUnit() {
		return handleUnit;
	}

	public void setHandleUnit(String handleUnit) {
		this.handleUnit = handleUnit;
	}

	public String getHandleUnitDate() {
		return handleUnitDate;
	}

	public void setHandleUnitDate(String handleUnitDate) {
		this.handleUnitDate = handleUnitDate;
	}

	public String getRiskProposal() {
		return riskProposal;
	}

	public void setRiskProposal(String riskProposal) {
		this.riskProposal = riskProposal;
	}

	public String getRiskProposalDate() {
		return riskProposalDate;
	}

	public void setRiskProposalDate(String riskProposalDate) {
		this.riskProposalDate = riskProposalDate;
	}

	public String getUserPlan() {
		return userPlan;
	}

	public void setUserPlan(String userPlan) {
		this.userPlan = userPlan;
	}

	public String getTermPlan() {
		return termPlan;
	}

	public void setTermPlan(String termPlan) {
		this.termPlan = termPlan;
	}

	public String getHandleRS() {
		return handleRS;
	}

	public void setHandleRS(String handleRS) {
		this.handleRS = handleRS;
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

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getCopy() {
		return copy;
	}

	public void setCopy(String copy) {
		this.copy = copy;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getSingleNumber() {
		return singleNumber;
	}

	public void setSingleNumber(String singleNumber) {
		this.singleNumber = singleNumber;
	}

	public String getSingleTime() {
		return singleTime;
	}

	public void setSingleTime(String singleTime) {
		this.singleTime = singleTime;
	}
	
}
