package com.business.entity.contract.risk;

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

@Entity
@FieldName(name = "合同风险级别调整(德银)")
@Table(name = "CONTRACT_RISK_ADJUST")
public class ContractRiskAdjust {
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(length = 32)
	private String id;
	
	@ManyToOne(targetEntity = ContractInfo.class, fetch = FetchType.LAZY)
	@FieldName(name="合同号")
	@JoinColumn(name = "CONTRACT_ID")
	private ContractInfo contractId;
	
	@FieldName(name="合同人")
	@Column(name="CUST_ID", length=20)
	private String custId;
	
	@FieldName(name="调整原因")
	@Column(name="ADJUST_WHY", length=2000)
	private String adjustWhy;
	
	
	
	@FieldName(name="调整级别")
	@Column(name="ADJUST_RANK", length=32)
	private String adjustRank;
	@FieldName(name="调整时间")
	@Column(name="ADJUST_DATE", length=32)
	private String adjustDate;

	@FieldName(name="撤销原因")
	@Column(name="REVOKE_WHY", length=2000)
	private String revokeWhy;
	
	@FieldName(name="撤销时间")
	@Column(name="REVOKE_DATE", length=2000)
	private String revokeDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="登记人")
	@JoinColumn(name="CREATOR_")
	private User creator;
	
	@FieldName(name="登记时间")
	@Column(name="CREATE_DATE", length=20)
	private String createDate;
	
	@FieldName(name="登记时间")
	@Column(name="IS_USE", length=20)
	private String isUse;

	public String getIsUse() {
		return isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	public String getAdjustDate() {
		return adjustDate;
	}

	public void setAdjustDate(String adjustDate) {
		this.adjustDate = adjustDate;
	}

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

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getAdjustWhy() {
		return adjustWhy;
	}

	public void setAdjustWhy(String adjustWhy) {
		this.adjustWhy = adjustWhy;
	}

	public String getAdjustRank() {
		return adjustRank;
	}

	public void setAdjustRank(String adjustRank) {
		this.adjustRank = adjustRank;
	}

	public String getRevokeWhy() {
		return revokeWhy;
	}

	public void setRevokeWhy(String revokeWhy) {
		this.revokeWhy = revokeWhy;
	}

	public String getRevokeDate() {
		return revokeDate;
	}

	public void setRevokeDate(String revokeDate) {
		this.revokeDate = revokeDate;
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

	
}
