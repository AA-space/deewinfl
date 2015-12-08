package com.business.entity.base;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import com.kernal.annotation.FieldName;

/***********************************************************************
 * Module:  District.java
 * Author:  Administrator
 * Purpose: Defines the Class District
 ***********************************************************************/

/**
 * / 行政区信息
 */
@Entity
@Table(name = "T_DISTRICT")
@FieldName(name = "行政区信息")
public class District {
	@Id
	//@GeneratedValue(generator = "paymentableGenerator")
	//@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(length = 32)
	private String id;
	@Column(length = 255, nullable=false)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pid")
	@FieldName(name = "行政区")
	private District parentDistrict;
	
	@OneToMany(mappedBy="parentDistrict", fetch=FetchType.LAZY)
	@JsonIgnore
	@FieldName(name = "上级行政区信息")
	private Set<District> childrenDistrict = new HashSet<District>();

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public District getParentDistrict() {
		return parentDistrict;
	}

	public Set<District> getChildrenDistrict() {
		return childrenDistrict;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParentDistrict(District parentDistrict) {
		this.parentDistrict = parentDistrict;
	}

	public void setChildrenDistrict(Set<District> childrenDistrict) {
		this.childrenDistrict = childrenDistrict;
	}


}