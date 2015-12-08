package com.business.entity.cust;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-7-28下午03:23:23
 * @info 客户集团
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name="客户集团")
@Table(name="CUST_GROUP")
public class CustGroup {
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(length = 32)
	private String id;
	
	@FieldName(name = "集团名称")
	@Column(name = "GROUP_NAME", length = 255)
	private String groupName;
	
	@FieldName(name = "集团编号")
	@Column(name = "ORG_CODE", length = 30)
	private String orgCode;
	
	@ManyToMany(fetch = FetchType.LAZY) 
    @JoinTable(
            name="CUST_GROUP_COMPANY",
            joinColumns = { @JoinColumn(name="GROUP_ID")},
            inverseJoinColumns = @JoinColumn(name="CUST_ID")
    )
	private Set<CustInfo> custInfos = new HashSet<CustInfo>();
	
	public String getId() {
		return id;
	}
	public String getGroupName() {
		return groupName;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public Set<CustInfo> getCustInfos() {
		return custInfos;
	}
	public void setCustInfos(Set<CustInfo> custInfos) {
		this.custInfos = custInfos;
	}
	
}
