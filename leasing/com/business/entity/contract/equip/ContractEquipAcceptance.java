package com.business.entity.contract.equip;

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
import org.hibernate.annotations.Index;

import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.contract.ContractInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-6下午04:27:10
 * @info 合同租赁物件验收信息
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "合同租赁物件验收信息")
@Table(name="CONTRACT_EQUIP_ACCEPTANCE")
public class ContractEquipAcceptance {
	
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@OneToOne
	@Index(name="INX_EQUIP_ACCEPTANCE_ID")
	@FieldName(name="合同编号")
	@JoinColumn(name="CONTRACT_ID")
	private ContractInfo contractId;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="验收类型[D]")
	@JoinColumn(name="ACCEPT_TYPE")
	private DictionaryData acceptType;

	@FieldName(name="验收日期")
	@Column(name="ACCEPT_DATE",length=20)
	private String   acceptDate;
	
	@FieldName(name="验收地点")
	@Column(name="ACCEPT_ADDER",length=200)
	private String   acceptAdder;
	
	@FieldName(name="验收人")
	@Column(name="ACCEPT_USER",length=20)
	private String   acceptUser;
	
	@FieldName(name="备注")
	@Column(name="ECMEMO",length=2000)
	private String   ecmemo;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="创建人")
	@JoinColumn(name="CREATOR_")
	private User creator;
	
	@FieldName(name="创建时间")
	@Column(name="CREATE_DATE", length=20)	
	private String createDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
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

	public DictionaryData getAcceptType() {
		return acceptType;
	}

	public void setAcceptType(DictionaryData acceptType) {
		this.acceptType = acceptType;
	}

	public String getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(String acceptDate) {
		this.acceptDate = acceptDate;
	}

	public String getAcceptAdder() {
		return acceptAdder;
	}

	public void setAcceptAdder(String acceptAdder) {
		this.acceptAdder = acceptAdder;
	}

	public String getEcmemo() {
		return ecmemo;
	}

	public void setEcmemo(String ecmemo) {
		this.ecmemo = ecmemo;
	}

	public String getAcceptUser() {
		return acceptUser;
	}

	public void setAcceptUser(String acceptUser) {
		this.acceptUser = acceptUser;
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
