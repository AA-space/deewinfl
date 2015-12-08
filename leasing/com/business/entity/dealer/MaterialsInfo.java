package com.business.entity.dealer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.base.District;
import com.business.entity.cust.CustInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author
 * @date 2013-7-29下午08:16:33
 * @info 抵押备案材料明细
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "抵押备案材料明细信息")
@Table(name="MATERIALS_INFO")
public class MaterialsInfo {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="申请表")
	@JoinColumn(name="APPLICATION_FORM")
	private DictionaryData applicationForm;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="商务部批文")
	@JoinColumn(name="BUSINESS_BOOK")
	private DictionaryData businessBook;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="名称核准通知书")
	@JoinColumn(name="HZ_NOTICE")
	private DictionaryData hz_notice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="德银公司公章")
	@JoinColumn(name="COMPANY_SEAL")
	private DictionaryData companySeal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="法定代表人身份证")
	@JoinColumn(name="LEGAL_CARD_ID")
	private DictionaryData legalCardId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="营业执")
	@JoinColumn(name="BUSINESS_LICENSE")
	private DictionaryData businessLicense;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="组织机构代码证")
	@JoinColumn(name="ORGANIZATION_CODE")
	private DictionaryData organizationCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="税务登记证")
	@JoinColumn(name="TAX_REGISTRATION")
	private DictionaryData taxRegistration;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="抵押合同")
	@JoinColumn(name="MORTGAGE_CONTRACT")
	private DictionaryData mortgageContract;

	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="主合同")
	@JoinColumn(name="MAIN_CONTRACT")
	private DictionaryData mainContract;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="其他")
	@JoinColumn(name="OTHERS")
	private DictionaryData others;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DictionaryData getApplicationForm() {
		return applicationForm;
	}

	public void setApplicationForm(DictionaryData applicationForm) {
		this.applicationForm = applicationForm;
	}

	public DictionaryData getBusinessBook() {
		return businessBook;
	}

	public void setBusinessBook(DictionaryData businessBook) {
		this.businessBook = businessBook;
	}

	public DictionaryData getHz_notice() {
		return hz_notice;
	}

	public void setHz_notice(DictionaryData hzNotice) {
		hz_notice = hzNotice;
	}

	public DictionaryData getCompanySeal() {
		return companySeal;
	}

	public void setCompanySeal(DictionaryData companySeal) {
		this.companySeal = companySeal;
	}

	public DictionaryData getLegalCardId() {
		return legalCardId;
	}

	public void setLegalCardId(DictionaryData legalCardId) {
		this.legalCardId = legalCardId;
	}

	public DictionaryData getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(DictionaryData businessLicense) {
		this.businessLicense = businessLicense;
	}

	public DictionaryData getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(DictionaryData organizationCode) {
		this.organizationCode = organizationCode;
	}

	public DictionaryData getTaxRegistration() {
		return taxRegistration;
	}

	public void setTaxRegistration(DictionaryData taxRegistration) {
		this.taxRegistration = taxRegistration;
	}

	public DictionaryData getMortgageContract() {
		return mortgageContract;
	}

	public void setMortgageContract(DictionaryData mortgageContract) {
		this.mortgageContract = mortgageContract;
	}

	public DictionaryData getMainContract() {
		return mainContract;
	}

	public void setMainContract(DictionaryData mainContract) {
		this.mainContract = mainContract;
	}

	public DictionaryData getOthers() {
		return others;
	}

	public void setOthers(DictionaryData others) {
		this.others = others;
	}
	
	
}
