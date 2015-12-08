package com.business.entity.contract;

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
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-6下午09:49:36
 * @info 合同五级划分归属表
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "客户寻访")
@Table(name="CONTRACT_PATROL_CUST")
public class ContractPatrolCust {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;

	@FieldName(name="合同编号")
	@JoinColumn(name="CONTRACT_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private ContractInfo contractId;
	
	@FieldName(name="流程编号")
	@Column(name="DOC_ID")
	private String docId;

	@FieldName(name="寻访时间")
	@Column(name="PATROL_DATE",length=20)
	private String   patrolDate;

	@FieldName(name="资产估价")
	@Column(name="PATROL_PRICE")
	private String patrolPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="登记人")
	@JoinColumn(name="CREATOR_")
	private User creator;
	
	@FieldName(name="登记时间")
	@Column(name="CREATE_DATE", length=20)
	private String createDate;

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

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getPatrolDate() {
		return patrolDate;
	}

	public void setPatrolDate(String patrolDate) {
		this.patrolDate = patrolDate;
	}

	public String getPatrolPrice() {
		return patrolPrice;
	}

	public void setPatrolPrice(String patrolPrice) {
		this.patrolPrice = patrolPrice;
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
