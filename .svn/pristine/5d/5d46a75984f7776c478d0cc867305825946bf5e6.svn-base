package com.business.entity.insurance;

import java.math.BigDecimal;

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
import com.business.entity.contract.ContractInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-4下午09:33:10
 * @info 保险公司信息
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "保险公司信息(德银)")
@Table(name="INSURANCE_INFO")
public class InsuranceInfo {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="保险单编号")
	@Column(name="INSURANCE_ID",unique = true, length=50)
	private String insuranceId;
	
	@ManyToOne(targetEntity=ProjInfo.class,fetch=FetchType.LAZY)
	@FieldName(name="项目编号")
	@JoinColumn(name="PROJ_ID")
	private ProjInfo projID;
	
	@FieldName(name="合同编号")
	@ManyToOne(targetEntity=ContractInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name="CONTRACT_ID")
	private ContractInfo contractId;
	
	@FieldName(name="保险询价")
	@OneToOne(mappedBy="insurID")
	private InsurancePrice insurancePrice;
	
	@FieldName(name="投保人全称")
	@Column(name="INSURED_A",length=50)
	private String insuredA;

	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name = "投保人证件类型[D]")
	@JoinColumn(name="INSURED_A_CARD_TYPE")
	private DictionaryData insuredACardType;
	
	@FieldName(name="投保人证件号")
	@Column(name="insured_A_Card_No",length=50)
	private String insuredACardNo;
	
	@FieldName(name="被保险人全称")
	@Column(name="INSURED_B",length=50)
	private String insuredB; 

	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name = "被保险人证件类型[D]")
	@JoinColumn(name="INSURED_B_CARD_TYPE")
	private DictionaryData insuredBCardType;
	
	@FieldName(name="被保险人证件号")
	@Column(name="insured_B_Card_No",length=50)
	private String insuredBCardNo;
	
	@FieldName(name="行驶证车主")
	@Column(name="diver_Host",length=50)
	private String diverHost;
	
	@FieldName(name="品牌型号")
	@Column(name="BRANDS_",length=50)
	private String brands;
	
	@FieldName(name="性质")
	@Column(name="PROPERTY_",length=50)
	private String property;
	
	@FieldName(name="车牌号（旧车）")
	@Column(name="old_Car_No",length=50)
	private String oldCarNo;
	
	@FieldName(name="初次登记日期")
	@Column(name="FIRST_REG_DATE",length=20)
	private String firstRegDate;
	
	@FieldName(name="核定载客/整备质量")
	@Column(name="CAPACITY_QUALITY",length=200)
	private String capacityAndQuality;
	
	@FieldName(name="车辆类型")
	@Column(name="CAR_TYPE",length=50)
	private String carType;
	
	@FieldName(name="车辆/挂车购置价格")
	@Column(name="CAR_PRICE",precision=22,scale=2)
	private BigDecimal carPrice;
	
	@FieldName(name="整车合计价格")
	@Column(name="CAR_PRICE_TOTAL",precision=22,scale=2)
	private BigDecimal carPriceTotal;
	
	@FieldName(name="发动机号")
	@Column(name="ENGINE_NO",length=20)
	private String   EngineNo;
	
	@FieldName(name="车架号")
	@Column(name="CHASSIS_NO",length=100)
	private String   chassisNo;
	
	@FieldName(name="投保开始日期")
	@Column(name="BEGIN_DATE",length=20)
	private String beginDate;

	@FieldName(name="投保结束日期")
	@Column(name="END_DATE",length=20)
	private String endDate;
	
	@FieldName(name="第一受益人")
	@Column(name="FIRST_BENEFICIARY",length=200)
	private String firstBeneficiary;
	
	@FieldName(name="第二受益人")
	@Column(name="SECOND_BENEFICIARY",length=200)
	private String secondBeneficiary;
	

	@FieldName(name="是否德银合作保险公司")
	@Column(name="IS_DEEWINFL",length=2)
	private String isDeewinfl;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name = "保险模式")
	@JoinColumn(name="INSUR_TYPE_INFO")
	private DictionaryData insurTypeInfo;
	
	@FieldName(name="是否经销商自选保险公司")
	@Column(name="IS_DEALER",length=2)
	private String isDealer;
	
	@FieldName(name="保险公司名称")
	@Column(name="insurance_Name",length=50)
	private String insuranceName;
	
	@FieldName(name="保险公司联系方式")
	@Column(name="INSUR_COMM",length=50)
	private String insuranceCommunication;
	
	@FieldName(name="保险公司折扣")
	@Column(name="INSUR_REBATE",length=20)
	private String insuranceRebate;

	@FieldName(name="经销商")
	@ManyToOne(targetEntity=CustInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name="DEALER_ID")
	private CustInfo dealer;
	
	@FieldName(name="联系方式")
	@Column(name="COMM_TYPE",length=20)
	private String communicationType;
	
	@FieldName(name="联系人")
	@Column(name="COMM_PERSON",length=50)
	private String communicationPerson;
	
	@FieldName(name="备注")
	@Column(name="IIMEMO")
	private String iimemo;
	
	@FieldName(name="初始保单登记类型")
	@Column(name="init_insur_type")
	private String initInsurType;
	
	@FieldName(name="是否作废(伪删除)[是/否--0/1][S]")
	@Column(name="INVALID_",length=2)
	private String invalid;
	
	@FieldName(name="合计不计免赔项")
	@Column(name="come_no_abatement")
	private String comeNoAbatement;
	
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

	
	
	public String getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}

	public ProjInfo getProjID() {
		return projID;
	}

	public void setProjID(ProjInfo projID) {
		this.projID = projID;
	}

	public ContractInfo getContractId() {
		return contractId;
	}

	public void setContractId(ContractInfo contractId) {
		this.contractId = contractId;
	}

	public InsurancePrice getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(InsurancePrice insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public String getInsuredA() {
		return insuredA;
	}

	public void setInsuredA(String insuredA) {
		this.insuredA = insuredA;
	}

	public DictionaryData getInsuredACardType() {
		return insuredACardType;
	}

	public void setInsuredACardType(DictionaryData insuredACardType) {
		this.insuredACardType = insuredACardType;
	}

	public String getInsuredACardNo() {
		return insuredACardNo;
	}

	public void setInsuredACardNo(String insuredACardNo) {
		this.insuredACardNo = insuredACardNo;
	}

	public String getInsuredB() {
		return insuredB;
	}

	public void setInsuredB(String insuredB) {
		this.insuredB = insuredB;
	}

	public DictionaryData getInsuredBCardType() {
		return insuredBCardType;
	}

	public void setInsuredBCardType(DictionaryData insuredBCardType) {
		this.insuredBCardType = insuredBCardType;
	}

	public String getInsuredBCardNo() {
		return insuredBCardNo;
	}

	public void setInsuredBCardNo(String insuredBCardNo) {
		this.insuredBCardNo = insuredBCardNo;
	}

	public String getDiverHost() {
		return diverHost;
	}

	public void setDiverHost(String diverHost) {
		this.diverHost = diverHost;
	}

	public String getBrands() {
		return brands;
	}

	public void setBrands(String brands) {
		this.brands = brands;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getOldCarNo() {
		return oldCarNo;
	}

	public void setOldCarNo(String oldCarNo) {
		this.oldCarNo = oldCarNo;
	}

	public String getFirstRegDate() {
		return firstRegDate;
	}

	public void setFirstRegDate(String firstRegDate) {
		this.firstRegDate = firstRegDate;
	}

	public String getCapacityAndQuality() {
		return capacityAndQuality;
	}

	public void setCapacityAndQuality(String capacityAndQuality) {
		this.capacityAndQuality = capacityAndQuality;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public BigDecimal getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(BigDecimal carPrice) {
		this.carPrice = carPrice;
	}

	public BigDecimal getCarPriceTotal() {
		return carPriceTotal;
	}

	public void setCarPriceTotal(BigDecimal carPriceTotal) {
		this.carPriceTotal = carPriceTotal;
	}

	public String getEngineNo() {
		return EngineNo;
	}

	public void setEngineNo(String engineNo) {
		EngineNo = engineNo;
	}

	public String getChassisNo() {
		return chassisNo;
	}

	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getFirstBeneficiary() {
		return firstBeneficiary;
	}

	public void setFirstBeneficiary(String firstBeneficiary) {
		this.firstBeneficiary = firstBeneficiary;
	}

	public String getSecondBeneficiary() {
		return secondBeneficiary;
	}

	public void setSecondBeneficiary(String secondBeneficiary) {
		this.secondBeneficiary = secondBeneficiary;
	}

	public String getIsDeewinfl() {
		return isDeewinfl;
	}

	public void setIsDeewinfl(String isDeewinfl) {
		this.isDeewinfl = isDeewinfl;
	}

	public String getIsDealer() {
		return isDealer;
	}

	public void setIsDealer(String isDealer) {
		this.isDealer = isDealer;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public String getInsuranceCommunication() {
		return insuranceCommunication;
	}

	public void setInsuranceCommunication(String insuranceCommunication) {
		this.insuranceCommunication = insuranceCommunication;
	}

	public String getInsuranceRebate() {
		return insuranceRebate;
	}

	public void setInsuranceRebate(String insuranceRebate) {
		this.insuranceRebate = insuranceRebate;
	}

	public CustInfo getDealer() {
		return dealer;
	}

	public void setDealer(CustInfo dealer) {
		this.dealer = dealer;
	}

	public String getCommunicationType() {
		return communicationType;
	}

	public void setCommunicationType(String communicationType) {
		this.communicationType = communicationType;
	}

	public String getCommunicationPerson() {
		return communicationPerson;
	}

	public void setCommunicationPerson(String communicationPerson) {
		this.communicationPerson = communicationPerson;
	}

	public String getIimemo() {
		return iimemo;
	}

	public void setIimemo(String iimemo) {
		this.iimemo = iimemo;
	}

	public String getInitInsurType() {
		return initInsurType;
	}

	public void setInitInsurType(String initInsurType) {
		this.initInsurType = initInsurType;
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

	public String getInvalid() {
		return invalid;
	}

	public void setInvalid(String invalid) {
		this.invalid = invalid;
	}

	public DictionaryData getInsurTypeInfo() {
		return insurTypeInfo;
	}

	public void setInsurTypeInfo(DictionaryData insurTypeInfo) {
		this.insurTypeInfo = insurTypeInfo;
	}

	public String getComeNoAbatement() {
		return comeNoAbatement;
	}

	public void setComeNoAbatement(String comeNoAbatement) {
		this.comeNoAbatement = comeNoAbatement;
	}
	
	
	
	
}
