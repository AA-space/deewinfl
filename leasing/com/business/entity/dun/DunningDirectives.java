package com.business.entity.dun;

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
 * @date 2013-3-6下午03:53:29
 * @info 催款主管领导指示
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "催款主管领导指示")
@Table(name="DUNNING_DIRECTIVES")
public class DunningDirectives {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="客户编号")
	@JoinColumn(name="CUST_ID")
	private CustInfo custId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="指示人")
	@JoinColumn(name="DIRECTIVER")
	private User directiver;
	
	@FieldName(name="指示日期")
	@Column(name="DIRECTIVE_DATE", length=20)	
	private String directiveDate;

	@FieldName(name="指示内容")
	@Column(name="DIRECTIVE_INFO",length=2000)	
	private String directiveInfo;

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

	public CustInfo getCustId() {
		return custId;
	}

	public void setCustId(CustInfo custId) {
		this.custId = custId;
	}

	public User getDirectiver() {
		return directiver;
	}

	public void setDirectiver(User directiver) {
		this.directiver = directiver;
	}

	public String getDirectiveDate() {
		return directiveDate;
	}

	public void setDirectiveDate(String directiveDate) {
		this.directiveDate = directiveDate;
	}

	public String getDirectiveInfo() {
		return directiveInfo;
	}

	public void setDirectiveInfo(String directiveInfo) {
		this.directiveInfo = directiveInfo;
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
