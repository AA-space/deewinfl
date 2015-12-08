package com.business.entity.contract.equip;

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
 * @date 2013-8-2下午03:27:00
 * @info 合同租赁物收回  区分 业务类型 车辆和设备
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "合同租赁物收回(德银)")
@Table(name="CONTRACT_EQUIP_REVOKE")
public class ContractEquipRevoke {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="合同编号")
	@ManyToOne(targetEntity=ContractInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name="CONTRACT_ID")
	private ContractInfo contractId;
	
	@FieldName(name="收回 车辆/设备 日期")
	@Column(name="REVOKE_DATE", length=20)	
	private String revokeDate;
	
	@FieldName(name="车架号/设备编号 ")
	@Column(name="EQUIP_NO",length=100)
	private String   equipNo;
	
	@FieldName(name="收回后处理计划")
	@Column(name="REVOKE_PLAN",length=2000)
	private String   revokePlan;
	
	@FieldName(name="备注")
	@Column(name="REVOKE_MEMO",length=2000)
	private String   revokeMemo;
	
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

	public String getRevokeDate() {
		return revokeDate;
	}

	public void setRevokeDate(String revokeDate) {
		this.revokeDate = revokeDate;
	}

	public String getEquipNo() {
		return equipNo;
	}

	public void setEquipNo(String equipNo) {
		this.equipNo = equipNo;
	}

	public String getRevokePlan() {
		return revokePlan;
	}

	public void setRevokePlan(String revokePlan) {
		this.revokePlan = revokePlan;
	}

	public String getRevokeMemo() {
		return revokeMemo;
	}

	public void setRevokeMemo(String revokeMemo) {
		this.revokeMemo = revokeMemo;
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
