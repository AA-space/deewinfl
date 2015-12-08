package com.business.entity.contract.change;

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
import com.business.entity.contract.ContractInfo;
import com.business.entity.cust.CustInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-5下午03:54:08
 * @info 合同租赁物件信息
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "合同租赁物件信息变更历史表")
@Table(name="CONTRACT_EQUIP_HIS")
public class ContractEquipHis {
	
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="合同编号")
	@ManyToOne(targetEntity=ContractInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name="CONTRACT_ID")
	private ContractInfo contractId;

	@FieldName(name="流程实例ID")
	@Column(name="DOC_ID")
	private String docID;
	
	@FieldName(name="品牌")
	@Column(name="BRAND_")
	private String brand;

	@FieldName(name="设备名称")
	@Column(name="EQIP_NAME")
	private String eqipName;

	@FieldName(name="型号/规格")
	@Column(name="MODEL")
	private String model;

	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="设备类型")
	@JoinColumn(name="DEVICE_TYPE")
	private DictionaryData deviceType;
	
	@FieldName(name="设备编号")
	@Column(name="EQIP_ID")
	private String eqipId;
	
	@FieldName(name="数量")
	@Column(name="EQUIP_NUM")
	private Integer equipNum;
	
	@FieldName(name="单价")
	@Column(name="PRICE",precision=22,scale=2)
	private BigDecimal price;
	
	@FieldName(name="原总价")
	@Column(name="TOTAL",precision=22,scale=2)
	private BigDecimal total;
	
	@FieldName(name="现总价")
	@Column(name="NOWTOTAL",precision=22,scale=2)
	private BigDecimal nowtotal;
	
	@FieldName(name="设备设置地")
	@Column(name="EQUIP_PLACE")
	private String equipPlace;
	
	@FieldName(name="供应商")
	@JoinColumn(name="VNDR")
	@ManyToOne(fetch = FetchType.LAZY)
	private CustInfo vndr;

	@FieldName(name="代理商")
	@JoinColumn(name="AGENT")
	@ManyToOne(fetch = FetchType.LAZY)
	private CustInfo agent;
	
	@FieldName(name="生产厂商")
	@JoinColumn(name="MANUFACTURER")
	@ManyToOne(fetch = FetchType.LAZY)
	private CustInfo manufacturer;
	
	@FieldName(name="物件交付地")
	@Column(name="EQUIP_DELIVERY_PLACE")
	private String equipDeliveryPlace;
	
	@FieldName(name="交付时间")
	@Column(name="EQUIP_DELIVERY_DATE",length=20)
	private String   equipDeliveryDate;
	
	@FieldName(name="备注")
	@Column(name="CENOTE")
	private String cenote;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="设备分类(德银)")
	@JoinColumn(name="EQUIP_CLASS")
	private DictionaryData equipClass;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="设备类别(德银)")
	@JoinColumn(name="EQUIP_TYPE")
	private DictionaryData equipType;
	
	@FieldName(name="车辆合同小号(德银)")
	@Column(name="EQUIP_CONTRACT_NUM",length=100)
	private String   equipContractNum;
	
	@FieldName(name="车架号(德银)")
	@Column(name="CHASSIS_NUM",length=100)
	private String   chassisNum;
	
	@FieldName(name="完整车架号(德银)")
	@Column(name="CHASSIS_NUMBER",length=100)
	private String   chassisNumber;
	
	@FieldName(name="入库时间(德银)")
	@Column(name="GARAGE_DATE",length=20)
	private String   garageDate;
	
	@FieldName(name="已售时间(德银)")
	@Column(name="SALE_DATE",length=20)
	private String   saleDate;
	
	@FieldName(name="采购价(德银)")
	@Column(name="PURCHASE_PRICE",precision=22,scale=2)
	private BigDecimal purchasePrice;
	
	@FieldName(name="采购价(德银)")
	@Column(name="SALE_PRICE",precision=22,scale=2)
	private BigDecimal salePrice;
	
	@FieldName(name="购置税(德银)")
	@Column(name="PURCHASE_TAX",precision=22,scale=2)
	private BigDecimal purchaseTax;
	
	@FieldName(name="保费(德银)")
	@Column(name="INSURE_MONEY",precision=22,scale=2)
	private BigDecimal insureMoney;
	
	@FieldName(name="其他融资额(德银)")
	@Column(name="LEASING_MONEY",precision=22,scale=2)
	private BigDecimal leasingMoney;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="修改状态")
	@JoinColumn(name="MOD_STATUS")	
	private DictionaryData modStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="修改原因")
	@JoinColumn(name="MOD_REASON")
	private DictionaryData modReason;
	
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

	public ContractInfo getContractId() {
		return contractId;
	}

	public void setContractId(ContractInfo contractId) {
		this.contractId = contractId;
	}

	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getEqipName() {
		return eqipName;
	}

	public void setEqipName(String eqipName) {
		this.eqipName = eqipName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public DictionaryData getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DictionaryData deviceType) {
		this.deviceType = deviceType;
	}

	public String getEqipId() {
		return eqipId;
	}

	public void setEqipId(String eqipId) {
		this.eqipId = eqipId;
	}

	public Integer getEquipNum() {
		return equipNum;
	}

	public void setEquipNum(Integer equipNum) {
		this.equipNum = equipNum;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getNowtotal() {
		return nowtotal;
	}

	public void setNowtotal(BigDecimal nowtotal) {
		this.nowtotal = nowtotal;
	}

	public String getEquipPlace() {
		return equipPlace;
	}

	public void setEquipPlace(String equipPlace) {
		this.equipPlace = equipPlace;
	}

	public CustInfo getVndr() {
		return vndr;
	}

	public void setVndr(CustInfo vndr) {
		this.vndr = vndr;
	}

	public CustInfo getAgent() {
		return agent;
	}

	public void setAgent(CustInfo agent) {
		this.agent = agent;
	}

	public CustInfo getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(CustInfo manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getEquipDeliveryPlace() {
		return equipDeliveryPlace;
	}

	public void setEquipDeliveryPlace(String equipDeliveryPlace) {
		this.equipDeliveryPlace = equipDeliveryPlace;
	}

	public String getEquipDeliveryDate() {
		return equipDeliveryDate;
	}

	public void setEquipDeliveryDate(String equipDeliveryDate) {
		this.equipDeliveryDate = equipDeliveryDate;
	}

	public String getCenote() {
		return cenote;
	}

	public void setCenote(String cenote) {
		this.cenote = cenote;
	}

	public DictionaryData getEquipClass() {
		return equipClass;
	}

	public void setEquipClass(DictionaryData equipClass) {
		this.equipClass = equipClass;
	}

	public DictionaryData getEquipType() {
		return equipType;
	}

	public void setEquipType(DictionaryData equipType) {
		this.equipType = equipType;
	}

	public String getEquipContractNum() {
		return equipContractNum;
	}

	public void setEquipContractNum(String equipContractNum) {
		this.equipContractNum = equipContractNum;
	}

	public String getChassisNum() {
		return chassisNum;
	}

	public void setChassisNum(String chassisNum) {
		this.chassisNum = chassisNum;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getGarageDate() {
		return garageDate;
	}

	public void setGarageDate(String garageDate) {
		this.garageDate = garageDate;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public BigDecimal getPurchaseTax() {
		return purchaseTax;
	}

	public void setPurchaseTax(BigDecimal purchaseTax) {
		this.purchaseTax = purchaseTax;
	}

	public BigDecimal getInsureMoney() {
		return insureMoney;
	}

	public void setInsureMoney(BigDecimal insureMoney) {
		this.insureMoney = insureMoney;
	}

	public BigDecimal getLeasingMoney() {
		return leasingMoney;
	}

	public void setLeasingMoney(BigDecimal leasingMoney) {
		this.leasingMoney = leasingMoney;
	}

	public DictionaryData getModStatus() {
		return modStatus;
	}

	public void setModStatus(DictionaryData modStatus) {
		this.modStatus = modStatus;
	}

	public DictionaryData getModReason() {
		return modReason;
	}

	public void setModReason(DictionaryData modReason) {
		this.modReason = modReason;
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
