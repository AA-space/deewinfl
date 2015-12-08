package com.business.entity.voucher;

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
import com.business.entity.cust.CustInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-9-13下午05:37:39
 * @info 业务财务客户对应表
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "业务财务客户对应表")
@Table(name="INTEREAS_CUSTID_JOIN")
public class IntereasCustIdJoin {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="业务客户编号")
	@JoinColumn(name="CUST_ID_B")	
	private CustInfo custIdB;
	
	@FieldName(name="财务客户编号")
	@Column(name="CUST_ID_F", length=20)	
	private String custIdF;
	
	@FieldName(name="财务客户名称")
	@Column(name="CUST_NAME_F", length=20)	
	private String custNameF;
	
	@FieldName(name="所属组织")
	@Column(name="OWNER_NAME", length=20)	
	private String ownerName;
	
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

	public CustInfo getCustIdB() {
		return custIdB;
	}

	public void setCustIdB(CustInfo custIdB) {
		this.custIdB = custIdB;
	}

	public String getCustIdF() {
		return custIdF;
	}

	public void setCustIdF(String custIdF) {
		this.custIdF = custIdF;
	}

	public String getCustNameF() {
		return custNameF;
	}

	public void setCustNameF(String custNameF) {
		this.custNameF = custNameF;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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
