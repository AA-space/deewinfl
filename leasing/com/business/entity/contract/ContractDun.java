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
import org.hibernate.annotations.Index;

import com.business.entity.User;
import com.business.entity.base.BaseFile;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-5下午02:01:33
 * @info 合同对应催款员信息
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "合同对应催款员信息")
@Table(name="CONTRACT_DUN")
public class ContractDun {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="合同号")
	@Index(name="INX_CONTRACT_DUN_CONTRACT_ID")
	@ManyToOne(targetEntity=ContractInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name="CONTRACT_ID")
	private ContractInfo contractId;
	
	@FieldName(name="催款员")
	@JoinColumn(name="DUN")
	@ManyToOne(fetch=FetchType.LAZY)
	private User dun;
	
	@FieldName(name="上传文件名")
	@ManyToOne(targetEntity=BaseFile.class,fetch=FetchType.LAZY)
	@JoinColumn(name="FILENAME_")
	private BaseFile fileName ;
	
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

	public User getDun() {
		return dun;
	}

	public void setDun(User dun) {
		this.dun = dun;
	}

	public BaseFile getFileName() {
		return fileName;
	}

	public void setFileName(BaseFile fileName) {
		this.fileName = fileName;
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
