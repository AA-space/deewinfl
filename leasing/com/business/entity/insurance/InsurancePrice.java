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
import com.business.entity.proj.ProjInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-7-29下午04:13:15
 * @info 保险询报价(德银)
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "保险询报价(德银)")
@Table(name="INSURANCE_PRICE")
public class InsurancePrice {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="流程实例ID")
	@Column(name="DOC_ID",length=10)
	private String docID;
	
	@FieldName(name="项目编号")
	@ManyToOne(targetEntity=ProjInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name="PROJ_ID")
	private ProjInfo projID;	
	
	@FieldName(name="合同编号")
	@ManyToOne(targetEntity=ContractInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name="CONTRACT_ID")
	private ContractInfo contractId;
	
	@FieldName(name="保险基本信息")
	@OneToOne(targetEntity=InsuranceInfo.class)
	@JoinColumn(name="INSUR_ID")
	private InsuranceInfo insurID;
	
	@FieldName(name="被保险人全称")
	@Column(name="PERSON_NAME",length=50)
	private String personName;
	
	@FieldName(name="车辆型号")
	@Column(name="EQUIP_TYPE",length=50)
	private String equipType;
	
	@FieldName(name="机动车损失保险及不计免赔特约(责任限额/万元)")
	@Column(name="ISINSURANCE_1",length=3)
	private String isinsurance1;
	
	@FieldName(name="机动车损失保险及不计免赔特约(保险费/元)")
	@Column(name="INSURANCE_1_MONEY_2",precision=22,scale=5)
	private BigDecimal insurance1Money2;
	
	@FieldName(name="机动车损失保险及不计免赔特约(责任限额/万元)")
	@Column(name="INSURANCE_1",precision=22,scale=5)
	private BigDecimal insurance1;
	
	@FieldName(name="机动车损失保险及不计免赔特约(保险费/元)")
	@Column(name="INSURANCE_MONEY_1",precision=22,scale=2)
	private BigDecimal insuranceMoney1;
	
	@FieldName(name="是否全车盗抢损失险及不计免赔特约(责任限额/万元)")
	@Column(name="ISINSURANCE_2",length=3)
	private String isinsurance2;
	
	@FieldName(name="是否全车盗抢损失险及不计(保险费/元)")
	@Column(name="INSURANCE_2_MONEY_2",precision=22,scale=2)
	private BigDecimal insurance2Money2;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="第三者责任保险及不计免赔特约(责任限额/万元)")
	@JoinColumn(name="INSURANCE_2")
	private DictionaryData insurance2;
	
	@FieldName(name="第三者责任保险及不计免赔特约(保险费/元)")
	@Column(name="INSURANCE_MONEY_2",precision=22,scale=2)
	private BigDecimal insuranceMoney2;
	
	@FieldName(name="是否全车盗抢损失险及不计免赔特约(责任限额/万元)")
	@Column(name="ISINSURANCE_3",length=3)
	private String isinsurance3;
	
	@FieldName(name="是否全车盗抢损失险及不计免赔特约(保险费/元)")
	@Column(name="INSURANCE_3_MONEY_2",precision=22,scale=2)
	private BigDecimal insurance3Money2;
	
	@FieldName(name="全车盗抢损失险及不计免赔特约(责任限额/万元)")
	@Column(name="INSURANCE_3",precision=22,scale=5)
	private BigDecimal insurance3;
	
	@FieldName(name="全车盗抢损失险及不计免赔特约(保险费/元)")
	@Column(name="INSURANCE_MONEY_3",precision=22,scale=2)
	private BigDecimal insuranceMoney3;
	
	@FieldName(name="车上人员责任险( 驾驶员/人)")
	@Column(name="INSURANCE_4")
	private Integer insurance4;
	
	@FieldName(name="车上人员责任险( 驾驶员 保额[元/人])")
	@Column(name="INSURANCE_MONEY_4_1",precision=22,scale=2)
	private BigDecimal insurance41;
	
	@FieldName(name="车上人员责任险(核定乘客)")
	@Column(name="INSURANCE_4_2")
	private Integer insurance42;
	
	@FieldName(name="车上人员责任险(核定乘客保额[元/人])")
	@Column(name="INSURANCE_MONEY_4_3",precision=22,scale=2)
	private BigDecimal insurance43;
	
	@FieldName(name="车上人员责任险(保险费/元)")
	@Column(name="INSURANCE_MONEY_4",precision=22,scale=2)
	private BigDecimal insuranceMoney4;
	
	@FieldName(name="车上人员责任不计免赔特约(责任限额/万元)")
	@Column(name="ISINSURANCE_5",length=3)
	private String isinsurance5;
	
	@FieldName(name="车上人员责任不计免赔特约(责任限额/万元)")
	@Column(name="INSURANCE_5_MONEY_2",precision=22,scale=2)
	private BigDecimal insurance5Money2;
	
	@FieldName(name="车上人员责任不计免赔特约(责任限额/万元)")
	@Column(name="INSURANCE_5",precision=22,scale=5)
	private BigDecimal insurance5;
	
	@FieldName(name="车上人员责任不计免赔特约(保险费/元)")
	@Column(name="INSURANCE_MONEY_5",precision=22,scale=2)
	private BigDecimal insuranceMoney5;
	
	@FieldName(name="自燃险是否不计免赔特约")
	@Column(name="ISINSURANCE_7",length=3)
	private String isinsurance7;
	
	@FieldName(name="自燃险是否不计免赔特约")
	@Column(name="INSURANCE_7_MONEY_2",precision=22,scale=2)
	private BigDecimal insurance7Money2;
	
	@FieldName(name="自燃险(责任限额/万元)")
	@Column(name="INSURANCE_7",precision=22,scale=5)
	private BigDecimal insurance7;
	
	@FieldName(name="自燃险(保险费/元)")
	@Column(name="INSURANCE_MONEY_7",precision=22,scale=2)
	private BigDecimal insuranceMoney7;
	
	@FieldName(name="交强险(责任限额/万元)")
	@Column(name="INSURANCE_8",precision=22,scale=5)
	private BigDecimal insurance8;
	
	@FieldName(name="交强险(保险费/元)")
	@Column(name="INSURANCE_MONEY_8",precision=22,scale=2)
	private BigDecimal insuranceMoney8;
	
	@FieldName(name="车船税(责任限额/万元)")
	@Column(name="INSURANCE_6",precision=22,scale=5)
	private BigDecimal insurance6;
	
	@FieldName(name="车船税(保险费/元)")
	@Column(name="INSURANCE_MONEY_6",precision=22,scale=2)
	private BigDecimal insuranceMoney6;
	
	@FieldName(name="玻璃单独破碎险(责任限额/万元)")
	@Column(name="INSURANCE_9",precision=22,scale=5)
	private BigDecimal insurance9;
	
	@FieldName(name="玻璃单独破碎险(保险费/元)")
	@Column(name="INSURANCE_MONEY_9",precision=22,scale=2)
	private BigDecimal insuranceMoney9;
	
	@FieldName(name="车上货物责任险(责任限额/万元)")
	@Column(name="INSURANCE_10",precision=22,scale=5)
	private BigDecimal insurance10;
	
	@FieldName(name="车上货物责任险(保险费/元)")
	@Column(name="INSURANCE_MONEY_10",precision=22,scale=2)
	private BigDecimal insuranceMoney10;
	
	@FieldName(name="是否附加险不计免赔特约险(责任限额/万元)")
	@Column(name="ISINSURANCE_11",length=3)
	private String isinsurance11;
	
	@FieldName(name="附加险不计免赔特约险(责任限额/万元)")
	@Column(name="INSURANCE_11",precision=22,scale=5)
	private BigDecimal insurance11;
	
	@FieldName(name="附加险不计免赔特约险(保险费/元)")
	@Column(name="INSURANCE_11_MONEY_2",precision=22,scale=5)
	private BigDecimal insurance11Money2;
	
	@FieldName(name="附加险不计免赔特约险(保险费/元)")
	@Column(name="INSURANCE_MONEY_11",precision=22,scale=2)
	private BigDecimal insuranceMoney11;
	
	@FieldName(name="工程机械设备综合保险")
	@Column(name="INSURANCE_MONEY_20",precision=22,scale=2)
	private BigDecimal insuranceMoney20;
	
	@FieldName(name="附加第三者责任保险")
	@Column(name="INSURANCE_MONEY_21",precision=22,scale=2)
	private BigDecimal insuranceMoney21;
	
	@FieldName(name="附加整机盗抢保险")
	@Column(name="INSURANCE_MONEY_22",precision=22,scale=2)
	private BigDecimal insuranceMoney22;
	
	@FieldName(name="附加自然损失保险")
	@Column(name="INSURANCE_MONEY_23",precision=22,scale=2)
	private BigDecimal insuranceMoney23;
	
	@FieldName(name="保险费总计")
	@Column(name="FEE_TOTAL",precision=22,scale=2)
	private BigDecimal feetotal;
	
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

	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
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

	public InsuranceInfo getInsurID() {
		return insurID;
	}

	public void setInsurID(InsuranceInfo insurID) {
		this.insurID = insurID;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getEquipType() {
		return equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}

	public BigDecimal getInsurance1() {
		return insurance1;
	}

	public void setInsurance1(BigDecimal insurance1) {
		this.insurance1 = insurance1;
	}

	public BigDecimal getInsuranceMoney1() {
		return insuranceMoney1;
	}

	public void setInsuranceMoney1(BigDecimal insuranceMoney1) {
		this.insuranceMoney1 = insuranceMoney1;
	}

	public DictionaryData getInsurance2() {
		return insurance2;
	}

	public void setInsurance2(DictionaryData insurance2) {
		this.insurance2 = insurance2;
	}

	public BigDecimal getInsuranceMoney2() {
		return insuranceMoney2;
	}

	public void setInsuranceMoney2(BigDecimal insuranceMoney2) {
		this.insuranceMoney2 = insuranceMoney2;
	}

	public BigDecimal getInsurance3() {
		return insurance3;
	}

	public void setInsurance3(BigDecimal insurance3) {
		this.insurance3 = insurance3;
	}

	public BigDecimal getInsuranceMoney3() {
		return insuranceMoney3;
	}

	public void setInsuranceMoney3(BigDecimal insuranceMoney3) {
		this.insuranceMoney3 = insuranceMoney3;
	}

	public Integer getInsurance4() {
		return insurance4;
	}

	public void setInsurance4(Integer insurance4) {
		this.insurance4 = insurance4;
	}

	public BigDecimal getInsurance41() {
		return insurance41;
	}

	public void setInsurance41(BigDecimal insurance41) {
		this.insurance41 = insurance41;
	}

	public Integer getInsurance42() {
		return insurance42;
	}

	public void setInsurance42(Integer insurance42) {
		this.insurance42 = insurance42;
	}

	public BigDecimal getInsurance43() {
		return insurance43;
	}

	public void setInsurance43(BigDecimal insurance43) {
		this.insurance43 = insurance43;
	}

	public BigDecimal getInsuranceMoney4() {
		return insuranceMoney4;
	}

	public void setInsuranceMoney4(BigDecimal insuranceMoney4) {
		this.insuranceMoney4 = insuranceMoney4;
	}

	public BigDecimal getInsurance5() {
		return insurance5;
	}

	public void setInsurance5(BigDecimal insurance5) {
		this.insurance5 = insurance5;
	}

	public BigDecimal getInsuranceMoney5() {
		return insuranceMoney5;
	}

	public void setInsuranceMoney5(BigDecimal insuranceMoney5) {
		this.insuranceMoney5 = insuranceMoney5;
	}

	public BigDecimal getInsurance6() {
		return insurance6;
	}

	public void setInsurance6(BigDecimal insurance6) {
		this.insurance6 = insurance6;
	}

	public BigDecimal getInsuranceMoney6() {
		return insuranceMoney6;
	}

	public void setInsuranceMoney6(BigDecimal insuranceMoney6) {
		this.insuranceMoney6 = insuranceMoney6;
	}

	public BigDecimal getInsurance7() {
		return insurance7;
	}

	public void setInsurance7(BigDecimal insurance7) {
		this.insurance7 = insurance7;
	}

	public BigDecimal getInsuranceMoney7() {
		return insuranceMoney7;
	}

	public void setInsuranceMoney7(BigDecimal insuranceMoney7) {
		this.insuranceMoney7 = insuranceMoney7;
	}

	public BigDecimal getInsurance8() {
		return insurance8;
	}

	public void setInsurance8(BigDecimal insurance8) {
		this.insurance8 = insurance8;
	}

	public BigDecimal getInsuranceMoney8() {
		return insuranceMoney8;
	}

	public void setInsuranceMoney8(BigDecimal insuranceMoney8) {
		this.insuranceMoney8 = insuranceMoney8;
	}

	public BigDecimal getInsurance9() {
		return insurance9;
	}

	public void setInsurance9(BigDecimal insurance9) {
		this.insurance9 = insurance9;
	}

	public BigDecimal getInsuranceMoney9() {
		return insuranceMoney9;
	}

	public void setInsuranceMoney9(BigDecimal insuranceMoney9) {
		this.insuranceMoney9 = insuranceMoney9;
	}

	public BigDecimal getInsurance10() {
		return insurance10;
	}

	public void setInsurance10(BigDecimal insurance10) {
		this.insurance10 = insurance10;
	}

	public BigDecimal getInsuranceMoney10() {
		return insuranceMoney10;
	}

	public void setInsuranceMoney10(BigDecimal insuranceMoney10) {
		this.insuranceMoney10 = insuranceMoney10;
	}

	public BigDecimal getInsurance11() {
		return insurance11;
	}

	public void setInsurance11(BigDecimal insurance11) {
		this.insurance11 = insurance11;
	}

	public BigDecimal getInsuranceMoney11() {
		return insuranceMoney11;
	}

	public void setInsuranceMoney11(BigDecimal insuranceMoney11) {
		this.insuranceMoney11 = insuranceMoney11;
	}

	public BigDecimal getFeetotal() {
		return feetotal;
	}

	public void setFeetotal(BigDecimal feetotal) {
		this.feetotal = feetotal;
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

	public String getIsinsurance1() {
		return isinsurance1;
	}

	public void setIsinsurance1(String isinsurance1) {
		this.isinsurance1 = isinsurance1;
	}

	public String getIsinsurance2() {
		return isinsurance2;
	}

	public void setIsinsurance2(String isinsurance2) {
		this.isinsurance2 = isinsurance2;
	}

	public String getIsinsurance3() {
		return isinsurance3;
	}

	public void setIsinsurance3(String isinsurance3) {
		this.isinsurance3 = isinsurance3;
	}

	public String getIsinsurance5() {
		return isinsurance5;
	}

	public void setIsinsurance5(String isinsurance5) {
		this.isinsurance5 = isinsurance5;
	}

	public String getIsinsurance11() {
		return isinsurance11;
	}

	public void setIsinsurance11(String isinsurance11) {
		this.isinsurance11 = isinsurance11;
	}

	public String getIsinsurance7() {
		return isinsurance7;
	}

	public void setIsinsurance7(String isinsurance7) {
		this.isinsurance7 = isinsurance7;
	}

	public BigDecimal getInsurance1Money2() {
		return insurance1Money2;
	}

	public void setInsurance1Money2(BigDecimal insurance1Money2) {
		this.insurance1Money2 = insurance1Money2;
	}


	public BigDecimal getInsurance2Money2() {
		return insurance2Money2;
	}

	public void setInsurance2Money2(BigDecimal insurance2Money2) {
		this.insurance2Money2 = insurance2Money2;
	}

	public BigDecimal getInsurance5Money2() {
		return insurance5Money2;
	}

	public void setInsurance5Money2(BigDecimal insurance5Money2) {
		this.insurance5Money2 = insurance5Money2;
	}

	public BigDecimal getInsurance7Money2() {
		return insurance7Money2;
	}

	public void setInsurance7Money2(BigDecimal insurance7Money2) {
		this.insurance7Money2 = insurance7Money2;
	}

	public BigDecimal getInsurance3Money2() {
		return insurance3Money2;
	}

	public void setInsurance3Money2(BigDecimal insurance3Money2) {
		this.insurance3Money2 = insurance3Money2;
	}


	public BigDecimal getInsurance11Money2() {
		return insurance11Money2;
	}

	public void setInsurance11Money2(BigDecimal insurance11Money2) {
		this.insurance11Money2 = insurance11Money2;
	}

	public BigDecimal getInsuranceMoney20() {
		return insuranceMoney20;
	}

	public void setInsuranceMoney20(BigDecimal insuranceMoney20) {
		this.insuranceMoney20 = insuranceMoney20;
	}

	public BigDecimal getInsuranceMoney21() {
		return insuranceMoney21;
	}

	public void setInsuranceMoney21(BigDecimal insuranceMoney21) {
		this.insuranceMoney21 = insuranceMoney21;
	}

	public BigDecimal getInsuranceMoney22() {
		return insuranceMoney22;
	}

	public void setInsuranceMoney22(BigDecimal insuranceMoney22) {
		this.insuranceMoney22 = insuranceMoney22;
	}

	public BigDecimal getInsuranceMoney23() {
		return insuranceMoney23;
	}

	public void setInsuranceMoney23(BigDecimal insuranceMoney23) {
		this.insuranceMoney23 = insuranceMoney23;
	}

}
