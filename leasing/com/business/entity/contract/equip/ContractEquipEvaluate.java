package com.business.entity.contract.equip;

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

import com.business.entity.User;
import com.business.entity.contract.ContractInfo;
import com.business.entity.cust.CustInfo;
import com.kernal.annotation.FieldName;
/**
 * 
 * @author 孙传良
 * @date 2013-8-2下午04:06:24
 * @info 合同租赁物评估
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "合同租赁物评估(德银)")
@Table(name="CONTRACT_EQUIP_EVALUATE")
public class ContractEquipEvaluate {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="合同编号")
	@ManyToOne(targetEntity=ContractInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name="CONTRACT_ID")
	private ContractInfo contractId;
	
	@FieldName(name="登记时间")
	@Column(name="REG_DATE",length=20)
	private String   regDate;
	
	@FieldName(name="车架号")
	@Column(name="CHASSIS_NUM",length=100)
	private String   chassisNum;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@FieldName(name="生产厂商")
	@JoinColumn(name="MANUFACTURER")
	private CustInfo manufacturer;
	
	@FieldName(name="额定载量")
	@Column(name="LIMITED_AMOUNT",length=20)
	private String   limitedAmount;

	@FieldName(name="购买时间")
	@Column(name="BUY_DATE",length=20)
	private String   buyDate;
	
	@FieldName(name="购买价格")
	@Column(name="buyPrice",precision=22,scale=2)
	private BigDecimal   buyPrice;
	
	@FieldName(name="已行驶公里数")
	@Column(name="runMileage",precision=22,scale=4)
	private BigDecimal   runMileage;
	
	@FieldName(name="发动机厂家")
	@Column(name="ENGINE_FACTORY",length=50)
	private String   engineFactory;
	
	@FieldName(name="发动机型号")
	@Column(name="ENGINE_MODEL",length=20)
	private String   engineModel;
	
	@FieldName(name="变速箱厂家/型号")
	@Column(name="GEARBOX_",length=20)
	private String   gearbox;
	
	@FieldName(name="车辆外观（几成新）")
	@Column(name="CAR_STYLE",length=20)
	private String   carStyle;
	
	@FieldName(name="有无空调[S]")
	@Column(name="AIR_CONDITIONING",length=2)
	private String   airConditioning;
	
	@FieldName(name="车辆改装情况")
	@Column(name="CAR_MEMO",length=2000)
	private String   carMemo;
	
	@FieldName(name="是否在保险有限期[S]")
	@Column(name="IS_INSUR_TERM",length=2)
	private String   isInsurTerm;
	
	@FieldName(name="现保单生效日")
	@Column(name="INSUR_DATE",length=20)
	private String   insurDate;
	
	@FieldName(name="现保单已交保费")
	@Column(name="INSUR_MONEY",precision=22,scale=2)
	private BigDecimal   insurMoney;
	
	@FieldName(name="是否购买车损险")
	@Column(name="IS_INSUR_TYPE_1",length=2)
	private String   isInsurType1;
	
	@FieldName(name="车损险金额")
	@Column(name="INSUR_TYPE_MONEY_1",precision=22,scale=2)
	private BigDecimal   insurTypeMoney1;
	
	@FieldName(name="是否购买三者险")
	@Column(name="IS_INSUR_TYPE_2",length=2)
	private String   isInsurType2;
	
	@FieldName(name="三者险金额")
	@Column(name="INSUR_TYPE_MONEY_2",precision=22,scale=2)
	private BigDecimal   insurTypeMoney2;
	
	@FieldName(name="是否购买盗抢险")
	@Column(name="IS_INSUR_TYPE_3",length=2)
	private String   isInsurType3;
	
	@FieldName(name="盗抢险金额")
	@Column(name="INSUR_TYPE_MONEY_3",precision=22,scale=2)
	private BigDecimal   insurTypeMoney3;
	
	@FieldName(name="是否购买自然险")
	@Column(name="IS_INSUR_TYPE_4",length=2)
	private String   isInsurType4;
	
	@FieldName(name="自然险金额")
	@Column(name="INSUR_TYPE_MONEY_4",precision=22,scale=2)
	private BigDecimal   insurTypeMoney4;
	
	@FieldName(name="是否购买不计险")
	@Column(name="IS_INSUR_TYPE_5",length=2)
	private String   isInsurType5;
	
	@FieldName(name="不计险金额")
	@Column(name="INSUR_TYPE_MONEY_5",precision=22,scale=2)
	private BigDecimal   insurTypeMoney5;
	
	@FieldName(name="是否购买司乘险")
	@Column(name="IS_INSUR_TYPE_6",length=2)
	private String   isInsurType6;
	
	@FieldName(name="司乘险金额")
	@Column(name="INSUR_TYPE_MONEY_6",precision=22,scale=2)
	private BigDecimal   insurTypeMoney6;
	
	@FieldName(name="是否购买货险")
	@Column(name="IS_INSUR_TYPE_7",length=2)
	private String   isInsurType7;
	
	@FieldName(name="货险金额")
	@Column(name="INSUR_TYPE_MONEY_7",precision=22,scale=2)
	private BigDecimal   insurTypeMoney7;
	
	@FieldName(name="有无理赔记录")
	@Column(name="IS_REPARATION",length=2)
	private String   isReparation;
	
	@FieldName(name="若有理赔记录，本车车损金额")
	@Column(name="REPARATION_MONEY",precision=22,scale=2)
	private BigDecimal   reparationMoney;
	
	@FieldName(name="车辆出险日期")
	@Column(name="REPARATION_DATE",length=20)
	private String   reparationDate;
	
	@FieldName(name="车辆出险情况")
	@Column(name="REPARATION_INFO",length=2000)
	private String   reparationInfo;
	
	@FieldName(name="有保养手册")
	@Column(name="IS_MAINTAIN",length=2)
	private String   isMaintain;

	@FieldName(name="车辆所在地")
	@Column(name="CAR_ADDR",length=20)
	private String   carAddr;
	
	@FieldName(name="其它保养说明")
	@Column(name="MAINTAIN_INFO",length=2000)
	private String   maintainInfo;
	
	@FieldName(name="评估价格")
	@Column(name="EVALUATE_MONEY",precision=22,scale=2)
	private BigDecimal   evaluateMoney;
	
	@FieldName(name="评估日期")
	@Column(name="EVALUATE_DATE",length=20)
	private String   evaluateDate;
	
	@FieldName(name="评估备注")
	@Column(name="EVALUATE_INFO",length=2000)
	private String   evaluateInfo;
	
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

	public String getChassisNum() {
		return chassisNum;
	}

	public void setChassisNum(String chassisNum) {
		this.chassisNum = chassisNum;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public CustInfo getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(CustInfo manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getLimitedAmount() {
		return limitedAmount;
	}

	public void setLimitedAmount(String limitedAmount) {
		this.limitedAmount = limitedAmount;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	public BigDecimal getRunMileage() {
		return runMileage;
	}

	public void setRunMileage(BigDecimal runMileage) {
		this.runMileage = runMileage;
	}

	public String getEngineFactory() {
		return engineFactory;
	}

	public void setEngineFactory(String engineFactory) {
		this.engineFactory = engineFactory;
	}

	public String getEngineModel() {
		return engineModel;
	}

	public void setEngineModel(String engineModel) {
		this.engineModel = engineModel;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public String getCarStyle() {
		return carStyle;
	}

	public void setCarStyle(String carStyle) {
		this.carStyle = carStyle;
	}

	public String getAirConditioning() {
		return airConditioning;
	}

	public void setAirConditioning(String airConditioning) {
		this.airConditioning = airConditioning;
	}

	public String getCarMemo() {
		return carMemo;
	}

	public void setCarMemo(String carMemo) {
		this.carMemo = carMemo;
	}

	public String getIsInsurTerm() {
		return isInsurTerm;
	}

	public void setIsInsurTerm(String isInsurTerm) {
		this.isInsurTerm = isInsurTerm;
	}

	public String getInsurDate() {
		return insurDate;
	}

	public void setInsurDate(String insurDate) {
		this.insurDate = insurDate;
	}

	public BigDecimal getInsurMoney() {
		return insurMoney;
	}

	public void setInsurMoney(BigDecimal insurMoney) {
		this.insurMoney = insurMoney;
	}

	public String getIsInsurType1() {
		return isInsurType1;
	}

	public void setIsInsurType1(String isInsurType1) {
		this.isInsurType1 = isInsurType1;
	}

	public BigDecimal getInsurTypeMoney1() {
		return insurTypeMoney1;
	}

	public void setInsurTypeMoney1(BigDecimal insurTypeMoney1) {
		this.insurTypeMoney1 = insurTypeMoney1;
	}

	public String getIsInsurType2() {
		return isInsurType2;
	}

	public void setIsInsurType2(String isInsurType2) {
		this.isInsurType2 = isInsurType2;
	}

	public BigDecimal getInsurTypeMoney2() {
		return insurTypeMoney2;
	}

	public void setInsurTypeMoney2(BigDecimal insurTypeMoney2) {
		this.insurTypeMoney2 = insurTypeMoney2;
	}

	public String getIsInsurType3() {
		return isInsurType3;
	}

	public void setIsInsurType3(String isInsurType3) {
		this.isInsurType3 = isInsurType3;
	}

	public BigDecimal getInsurTypeMoney3() {
		return insurTypeMoney3;
	}

	public void setInsurTypeMoney3(BigDecimal insurTypeMoney3) {
		this.insurTypeMoney3 = insurTypeMoney3;
	}

	public String getIsInsurType4() {
		return isInsurType4;
	}

	public void setIsInsurType4(String isInsurType4) {
		this.isInsurType4 = isInsurType4;
	}

	public BigDecimal getInsurTypeMoney4() {
		return insurTypeMoney4;
	}

	public void setInsurTypeMoney4(BigDecimal insurTypeMoney4) {
		this.insurTypeMoney4 = insurTypeMoney4;
	}

	public String getIsInsurType5() {
		return isInsurType5;
	}

	public void setIsInsurType5(String isInsurType5) {
		this.isInsurType5 = isInsurType5;
	}

	public BigDecimal getInsurTypeMoney5() {
		return insurTypeMoney5;
	}

	public void setInsurTypeMoney5(BigDecimal insurTypeMoney5) {
		this.insurTypeMoney5 = insurTypeMoney5;
	}

	public String getIsInsurType6() {
		return isInsurType6;
	}

	public void setIsInsurType6(String isInsurType6) {
		this.isInsurType6 = isInsurType6;
	}

	public BigDecimal getInsurTypeMoney6() {
		return insurTypeMoney6;
	}

	public void setInsurTypeMoney6(BigDecimal insurTypeMoney6) {
		this.insurTypeMoney6 = insurTypeMoney6;
	}

	public String getIsInsurType7() {
		return isInsurType7;
	}

	public void setIsInsurType7(String isInsurType7) {
		this.isInsurType7 = isInsurType7;
	}

	public BigDecimal getInsurTypeMoney7() {
		return insurTypeMoney7;
	}

	public void setInsurTypeMoney7(BigDecimal insurTypeMoney7) {
		this.insurTypeMoney7 = insurTypeMoney7;
	}

	public String getIsReparation() {
		return isReparation;
	}

	public void setIsReparation(String isReparation) {
		this.isReparation = isReparation;
	}

	public BigDecimal getReparationMoney() {
		return reparationMoney;
	}

	public void setReparationMoney(BigDecimal reparationMoney) {
		this.reparationMoney = reparationMoney;
	}

	public String getReparationDate() {
		return reparationDate;
	}

	public void setReparationDate(String reparationDate) {
		this.reparationDate = reparationDate;
	}

	public String getReparationInfo() {
		return reparationInfo;
	}

	public void setReparationInfo(String reparationInfo) {
		this.reparationInfo = reparationInfo;
	}

	public String getIsMaintain() {
		return isMaintain;
	}

	public void setIsMaintain(String isMaintain) {
		this.isMaintain = isMaintain;
	}

	public String getCarAddr() {
		return carAddr;
	}

	public void setCarAddr(String carAddr) {
		this.carAddr = carAddr;
	}

	public String getMaintainInfo() {
		return maintainInfo;
	}

	public void setMaintainInfo(String maintainInfo) {
		this.maintainInfo = maintainInfo;
	}

	public BigDecimal getEvaluateMoney() {
		return evaluateMoney;
	}

	public void setEvaluateMoney(BigDecimal evaluateMoney) {
		this.evaluateMoney = evaluateMoney;
	}

	public String getEvaluateDate() {
		return evaluateDate;
	}

	public void setEvaluateDate(String evaluateDate) {
		this.evaluateDate = evaluateDate;
	}

	public String getEvaluateInfo() {
		return evaluateInfo;
	}

	public void setEvaluateInfo(String evaluateInfo) {
		this.evaluateInfo = evaluateInfo;
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
