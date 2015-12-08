package com.business.entity.invoice.vat;


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
import com.kernal.annotation.FieldName;

/**
 * @author Toybaby
 *	2013-10-11
 *  资金发票信息
 *  
 */
@Entity
@FieldName(name = "资金发票红冲发票信息")
@Table(name="TAX_FUND_HC_INFO")
public class TaxFundHcInfo {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="上传编号")
	@ManyToOne(targetEntity=TaxFundUploadInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name="TAX_FUND_UPLOAD_ID")
	private TaxFundUploadInfo taxFundUpId;
	
	@FieldName(name="发票红冲通知单号")
	@Column(name="INVOICE_HC_NO",length=50)
	private String invoiceHcNo;
	
	
	@FieldName(name="红冲日期")
	@Column(name="INVOICE_HC_DATE", length=20)
	private String invoiceHcDate;
	
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

	public TaxFundUploadInfo getTaxFundUpId() {
		return taxFundUpId;
	}

	public void setTaxFundUpId(TaxFundUploadInfo taxFundUpId) {
		this.taxFundUpId = taxFundUpId;
	}

	public String getInvoiceHcNo() {
		return invoiceHcNo;
	}

	public void setInvoiceHcNo(String invoiceHcNo) {
		this.invoiceHcNo = invoiceHcNo;
	}

	public String getInvoiceHcDate() {
		return invoiceHcDate;
	}

	public void setInvoiceHcDate(String invoiceHcDate) {
		this.invoiceHcDate = invoiceHcDate;
	}
}
