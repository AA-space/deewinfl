package com.business.entity.voucher;   

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kernal.annotation.FieldName;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2013-11-20 下午3:31:35
 * 类说明
 */
@Entity
@FieldName(name="科目辅助账类型配置表")
@Table(name="VOUCHERASS_STACTS_CONFIG")
public class VoucherassStactsConfig {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="科目名称")
	@Column(name="SUBJECTS_NAME", length=1000)	
	private String subjectsName; 
	
	@FieldName(name="科目编号")
	@Column(name="SUBJECTS_CODE")	
	private String subjectsCode; 
	
	@FieldName(name = "客户01")
	@Column(name="ASSTACTTYPE_CUST", length = 5,columnDefinition="INT default 0")
	private int asstActTypeCust;//1是启用； 0为禁用
	
	@FieldName(name = "供应商02")
	@Column(name="ASSTACTTYPE_VENDOR", length = 5,columnDefinition="INT default 0")
	private int asstActTypeVendor;//1是启用； 0为禁用
	
	@FieldName(name = "银行账户03")
	@Column(name="ASSTACTTYPE_BANK", length = 5,columnDefinition="INT default 0")
	private int asstActTypeBank;//1是启用； 0为禁用
	
	@FieldName(name = "预留04")
	@Column(name="ASSTACTTYPE_FOUR", length = 5,columnDefinition="INT default 0")
	private int asstActTypeFour;//1是启用； 0为禁用
	
	@FieldName(name = "职员05")
	@Column(name="ASSTACTTYPE_EMPLOYEE", length = 5,columnDefinition="INT default 0")
	private int asstActTypeEmployee;//1是启用； 0为禁用
	
	@FieldName(name = "预留06")
	@Column(name="ASSTACTTYPE_SIX", length = 5,columnDefinition="INT default 0")
	private int asstActTypeSix;//1是启用； 0为禁用
	
	@FieldName(name = "行政组织07")
	@Column(name="ASSTACTTYPE_ORGANIZATION", length = 5,columnDefinition="INT default 0")
	private int asstActTypeOrganization;//1是启用； 0为禁用

	public String getId() {
		return id;
	}

	public String getSubjectsName() {
		return subjectsName;
	}

	public String getSubjectsCode() {
		return subjectsCode;
	}

	public int getAsstActTypeCust() {
		return asstActTypeCust;
	}

	public int getAsstActTypeVendor() {
		return asstActTypeVendor;
	}

	public int getAsstActTypeBank() {
		return asstActTypeBank;
	}

	public int getAsstActTypeFour() {
		return asstActTypeFour;
	}

	public int getAsstActTypeEmployee() {
		return asstActTypeEmployee;
	}

	public int getAsstActTypeSix() {
		return asstActTypeSix;
	}

	public int getAsstActTypeOrganization() {
		return asstActTypeOrganization;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSubjectsName(String subjectsName) {
		this.subjectsName = subjectsName;
	}

	public void setSubjectsCode(String subjectsCode) {
		this.subjectsCode = subjectsCode;
	}

	public void setAsstActTypeCust(int asstActTypeCust) {
		this.asstActTypeCust = asstActTypeCust;
	}

	public void setAsstActTypeVendor(int asstActTypeVendor) {
		this.asstActTypeVendor = asstActTypeVendor;
	}

	public void setAsstActTypeBank(int asstActTypeBank) {
		this.asstActTypeBank = asstActTypeBank;
	}

	public void setAsstActTypeFour(int asstActTypeFour) {
		this.asstActTypeFour = asstActTypeFour;
	}

	public void setAsstActTypeEmployee(int asstActTypeEmployee) {
		this.asstActTypeEmployee = asstActTypeEmployee;
	}

	public void setAsstActTypeSix(int asstActTypeSix) {
		this.asstActTypeSix = asstActTypeSix;
	}

	public void setAsstActTypeOrganization(int asstActTypeOrganization) {
		this.asstActTypeOrganization = asstActTypeOrganization;
	}
}
  
