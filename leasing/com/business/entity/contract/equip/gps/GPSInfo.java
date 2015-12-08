package com.business.entity.contract.equip.gps;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.business.entity.User;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.cust.CustInfo;

import org.hibernate.annotations.GenericGenerator;

import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-8-6下午02:06:40
 * @info GPS安装信息
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "GPS安装信息(德银)")
@Table(name="GPS_INFO")
public class GPSInfo {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@ManyToOne(targetEntity=CustInfo.class,fetch=FetchType.LAZY)
	@FieldName(name="经销商(德银)[S]")
	@JoinColumn(name="CUST_DEALER")
	private CustInfo custDealer;
	
	@FieldName(name="承租人")
	@ManyToOne(targetEntity=CustInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name="CUST_ID")
	private CustInfo custId;

	@FieldName(name="合同号")
	@ManyToOne(targetEntity=ContractInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name="CONTRACT_ID")
	private ContractInfo contractId;
	
	@FieldName(name="车架号")
	@ManyToOne(targetEntity=ContractEquip.class,fetch=FetchType.LAZY)
	@JoinColumn(name="EQUIP_ID")
	private ContractEquip equipID;
	
	@FieldName(name="是否安装GPS[S]")
	@Column(name="is_GPS",length=2)
	private String isGPS;
	
	@FieldName(name="是GPS软件网址/软件名")
	@Column(name="GPS_NAME",length=100)
	private String gpsName;
	
	@FieldName(name="GPS用户名")
	@Column(name="GPS_USER",length=100)
	private String gpsUser;
	
	@FieldName(name="GPS密码")
	@Column(name="GPS_PASSWORD",length=100)
	private String gpsPassword;
	
	@FieldName(name="备注")
	@Column(name="MEMO",length=2000)
	private String memo;
	
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

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

	public ContractEquip getEquipID() {
		return equipID;
	}

	public void setEquipID(ContractEquip equipID) {
		this.equipID = equipID;
	}

	public String getIsGPS() {
		return isGPS;
	}

	public void setIsGPS(String isGPS) {
		this.isGPS = isGPS;
	}

	public String getGpsName() {
		return gpsName;
	}

	public void setGpsName(String gpsName) {
		this.gpsName = gpsName;
	}

	public String getGpsUser() {
		return gpsUser;
	}

	public void setGpsUser(String gpsUser) {
		this.gpsUser = gpsUser;
	}

	public String getGpsPassword() {
		return gpsPassword;
	}

	public void setGpsPassword(String gpsPassword) {
		this.gpsPassword = gpsPassword;
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
	public CustInfo getCustDealer() {
		return custDealer;
	}

	public void setCustDealer(CustInfo custDealer) {
		this.custDealer = custDealer;
	}

	public CustInfo getCustId() {
		return custId;
	}

	public void setCustId(CustInfo custId) {
		this.custId = custId;
	}

	public ContractInfo getContractId() {
		return contractId;
	}

	public void setContractId(ContractInfo contractId) {
		this.contractId = contractId;
	}
}
