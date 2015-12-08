package com.business.entity.contract.risk;

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
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-8-5下午08:20:52
 * @info 合同租后检查
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "合同租后检查(德银)")
@Table(name = "CONTRACT_CENSOR")
public class ContractCensor {

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(length = 32)
	private String id;

	@ManyToOne(targetEntity = ContractInfo.class, fetch = FetchType.LAZY)
	@FieldName(name="合同号")
	@JoinColumn(name = "CONTRACT_ID")
	private ContractInfo contractId;

	@FieldName(name="逾期期数")
	@Column(name="DUN_NUM",precision=10,scale=4)
	private BigDecimal dunNum;
	
	@FieldName(name="逾期罚息")
	@Column(name="PENALTY_",precision=22,scale=2)
	private BigDecimal penalty;
	
	@FieldName(name="客户目前经营状况及变化，融资款的使用情况，租金的支付情况")
	@Column(name="CENSOR_INFO_1", length=2000)
	private String censorInfo1;
	
	@FieldName(name="影响租金偿还或客户履约的主要不利和有利因素，估计客户违约可能性")
	@Column(name="CENSOR_INFO_2", length=2000)
	private String censorInfo2;
	
	@FieldName(name="担保状况及不利变化")
	@Column(name="CENSOR_INFO_3", length=2000)
	private String censorInfo3;
	
	@FieldName(name="对经销商或德银公司租后检查的态度")
	@Column(name="CENSOR_INFO_4", length=2000)
	private String censorInfo4;
	
	@FieldName(name="拟采取的主要处理措施")
	@Column(name="CENSOR_INFO_5", length=2000)
	private String censorInfo5;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="检查人员")
	@JoinColumn(name="CENSOR_USER")
	private User censorUser;
	
	@FieldName(name="检查时间")
	@Column(name="CENSOR_DATE", length=20)
	private String censorDate;
	
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

	public ContractInfo getContractId() {
		return contractId;
	}

	public void setContractId(ContractInfo contractId) {
		this.contractId = contractId;
	}

	public BigDecimal getDunNum() {
		return dunNum;
	}

	public void setDunNum(BigDecimal dunNum) {
		this.dunNum = dunNum;
	}

	public BigDecimal getPenalty() {
		return penalty;
	}

	public void setPenalty(BigDecimal penalty) {
		this.penalty = penalty;
	}

	public String getCensorInfo1() {
		return censorInfo1;
	}

	public void setCensorInfo1(String censorInfo1) {
		this.censorInfo1 = censorInfo1;
	}

	public String getCensorInfo2() {
		return censorInfo2;
	}

	public void setCensorInfo2(String censorInfo2) {
		this.censorInfo2 = censorInfo2;
	}

	public String getCensorInfo3() {
		return censorInfo3;
	}

	public void setCensorInfo3(String censorInfo3) {
		this.censorInfo3 = censorInfo3;
	}

	public String getCensorInfo4() {
		return censorInfo4;
	}

	public void setCensorInfo4(String censorInfo4) {
		this.censorInfo4 = censorInfo4;
	}

	public String getCensorInfo5() {
		return censorInfo5;
	}

	public void setCensorInfo5(String censorInfo5) {
		this.censorInfo5 = censorInfo5;
	}

	public User getCensorUser() {
		return censorUser;
	}

	public void setCensorUser(User censorUser) {
		this.censorUser = censorUser;
	}

	public String getCensorDate() {
		return censorDate;
	}

	public void setCensorDate(String censorDate) {
		this.censorDate = censorDate;
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
