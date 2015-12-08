package com.business.entity.invoice.vat;


import java.math.BigDecimal;

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
import com.business.entity.base.BaseFile;
import com.kernal.annotation.FieldName;

/**
 * @author Toybaby
 *	2013-10-11
 *  资计发票信息
 *  
 */
@Entity
@FieldName(name = "进项发票导入数据存储")
@Table(name="TAX_VAT_UPLOAD_INFO")
public class TaxVatUploadInfo {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="发票号")
	@Column(name="INVOICE_NO", length=50)
	private String invoiceNo;
	
	
	@FieldName(name="合同编号")
	@Column(name="CONTRACT_ID", length=50)
	private String contractId;
	
	
	@FieldName(name="供应商名称")
	@Column(name="VNDR_NAME", length=50)
	private String vndrName;
	
	@FieldName(name="含税金额")
	@Column(name="CORPUS_TAX_MONEY",precision=22,scale=2)
	private BigDecimal corpusTaxMoney;
	
	@FieldName(name="税率")
	@Column(name="TAX_RATE",precision=22,scale=2)
	private BigDecimal taxRate;
	
	@FieldName(name="税额")
	@Column(name="TAX_MONEY",precision=22,scale=2)
	private BigDecimal taxMoney;
	
	@FieldName(name="费用类型")
	@Column(name="TAX_TYPE", length=50)
	private String taxType;
	
	@FieldName(name="客户名称")
	@Column(name="CUST_NAME", length=200)
	private String custName;
	
	@FieldName(name="设备名称")
	@Column(name="EQUIP_NAME", length=200)
	private String equipName;
	
	@FieldName(name="认证结果")
	@Column(name="CERTIFICATION_RESULTS", length=200)
	private String certificationResults;

	@FieldName(name="认证时间")
	@Column(name="CERTIFICATION_DATE", length=20)
	private String certificationDate;
	
	@FieldName(name="开票时间")
	@Column(name="INVOICE_DATE", length=20)
	private String invoiceDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="上传文件名")
	@JoinColumn(name="UPLOAD_ID")
	private BaseFile upLoadId ;
	
	
	public BaseFile getUpLoadId() {
		return upLoadId;
	}

	public void setUpLoadId(BaseFile upLoadId) {
		this.upLoadId = upLoadId;
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

	
	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getVndrName() {
		return vndrName;
	}

	public void setVndrName(String vndrName) {
		this.vndrName = vndrName;
	}

	public BigDecimal getCorpusTaxMoney() {
		return corpusTaxMoney;
	}

	public void setCorpusTaxMoney(BigDecimal corpusTaxMoney) {
		this.corpusTaxMoney = corpusTaxMoney;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public BigDecimal getTaxMoney() {
		return taxMoney;
	}

	public void setTaxMoney(BigDecimal taxMoney) {
		this.taxMoney = taxMoney;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getEquipName() {
		return equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	public String getCertificationResults() {
		return certificationResults;
	}

	public void setCertificationResults(String certificationResults) {
		this.certificationResults = certificationResults;
	}

	public String getCertificationDate() {
		return certificationDate;
	}

	public void setCertificationDate(String certificationDate) {
		this.certificationDate = certificationDate;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
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
