package com.business.entity.cust;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;

import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.dealer.CustInfoDealer;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-7-28下午03:23:41
 * @info 客户信息
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "客户信息")
@Table(name="CUST_INFO")
public class CustInfo {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="客户编号")
	@Column(name="CUST_NUMBER", length=50)
	private String custNumber;
	
	@FieldName(name="客户名称")
	@Index(name="INX_CUST_INFO_NAME")
	@Column(name="CUST_NAME", length=100)
	private String custName;
 
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "客户类别[法律性质的个人/法人/经销商(德银)][D]")
	@JoinColumn(name="cust_class")
	private DictionaryData custClass;
 
	@FieldName(name="是否作废(伪删除)[是/否--0/1][S]")
	@Column(name="INVALID_",length=2)
	private String invalid;
	
	@FieldName(name="是否草稿[是/否--0/1][S]")
	@Column(name="DRAFT_",length=2)
	private String draft;
	
	

	@FieldName(name="客户导出状态,默认为0")
	@Column(name="CUST_EXPORT_STATUS", columnDefinition="VARCHAR2(32 CHAR) DEFAULT '0'")
	private String custExportStatus;
	public String getCustExportStatus() {
		return custExportStatus;
	}

	public void setCustExportStatus(String custExportStatus) {
		this.custExportStatus = custExportStatus;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "登记人")
	@JoinColumn(name="CREATOR_")
	private User creator;
	
	@FieldName(name = "登记时间")
	@Column(name="CREATE_DATE", length=20)
	private String createDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name = "更新人")
	@JoinColumn(name="MODIFICATOR_")
	private User modificator;
	
	@FieldName(name = "更新日期")
	@Column(name="MODIFY_DATE", length=20)
	private String modifyDate;
	
	@JsonIgnore
	@FieldName(name = "客户类别[业务性质的承租/担保等][D]")
	@OneToMany(mappedBy="custId",  fetch=FetchType.LAZY)
	private Set<CustTypeInfo> custType = new HashSet<CustTypeInfo>();
	
	@JsonIgnore
	@OneToOne(mappedBy="custId")
	private CustInfoCompany custInfoCompany;
	
	@JsonIgnore
	@OneToOne(mappedBy="custId")
	private CustInfoPerson custInfoPerson;
	
	@JsonIgnore
	@OneToOne(mappedBy="custId")
	private CustInfoDealer custInfoDealer;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="custInfos")
	private Set<CustGroup> custGroups = new HashSet<CustGroup>();
	
	@OneToMany(mappedBy="custId",fetch=FetchType.LAZY)
	private Set<CustInfoRelatedPerson> relatedPersons = new HashSet<CustInfoRelatedPerson>();
	
	@OneToMany(mappedBy="custId",fetch=FetchType.LAZY)
	private Set<CustInfoAccount> accounts = new HashSet<CustInfoAccount>();
	
	@OneToMany(mappedBy="custId",fetch=FetchType.LAZY)
	private Set<CustInfoCreditRank> creditRanks = new HashSet<CustInfoCreditRank>();
	
	@OneToMany(mappedBy="custId",fetch=FetchType.LAZY)
	private Set<CustInfoContact> contacts = new HashSet<CustInfoContact>();
	
	@OneToMany(mappedBy="custId",fetch=FetchType.LAZY)
	private Set<CustShareCompany> custShareCompanys = new HashSet<CustShareCompany>();
	
	@OneToMany(mappedBy="custId",fetch=FetchType.LAZY)
	private Set<CustTransfer> custTransfers = new HashSet<CustTransfer>();
     
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustNumber() {
		return custNumber;
	}

	public void setCustNumber(String custNumber) {
		this.custNumber = custNumber;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public DictionaryData getCustClass() {
		return custClass;
	}

	public void setCustClass(DictionaryData custClass) {
		this.custClass = custClass;
	}

	public Set<CustTypeInfo> getCustType() {
		return custType;
	}

	public void setCustType(Set<CustTypeInfo> custType) {
		this.custType = custType;
	}

	public CustInfoCompany getCustInfoCompany() {
		return custInfoCompany;
	}

	public void setCustInfoCompany(CustInfoCompany custInfoCompany) {
		this.custInfoCompany = custInfoCompany;
	}

	public CustInfoPerson getCustInfoPerson() {
		return custInfoPerson;
	}

	public void setCustInfoPerson(CustInfoPerson custInfoPerson) {
		this.custInfoPerson = custInfoPerson;
	}

	public CustInfoDealer getCustInfoDealer() {
		return custInfoDealer;
	}

	public void setCustInfoDealer(CustInfoDealer custInfoDealer) {
		this.custInfoDealer = custInfoDealer;
	}

	public Set<CustGroup> getCustGroups() {
		return custGroups;
	}

	public void setCustGroups(Set<CustGroup> custGroups) {
		this.custGroups = custGroups;
	}

	public Set<CustInfoRelatedPerson> getRelatedPersons() {
		return relatedPersons;
	}

	public void setRelatedPersons(Set<CustInfoRelatedPerson> relatedPersons) {
		this.relatedPersons = relatedPersons;
	}

	public Set<CustInfoAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<CustInfoAccount> accounts) {
		this.accounts = accounts;
	}

	public Set<CustInfoCreditRank> getCreditRanks() {
		return creditRanks;
	}

	public void setCreditRanks(Set<CustInfoCreditRank> creditRanks) {
		this.creditRanks = creditRanks;
	}

	public Set<CustInfoContact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<CustInfoContact> contacts) {
		this.contacts = contacts;
	}

	public Set<CustShareCompany> getCustShareCompanys() {
		return custShareCompanys;
	}

	public void setCustShareCompanys(Set<CustShareCompany> custShareCompanys) {
		this.custShareCompanys = custShareCompanys;
	}

	public Set<CustTransfer> getCustTransfers() {
		return custTransfers;
	}

	public void setCustTransfers(Set<CustTransfer> custTransfers) {
		this.custTransfers = custTransfers;
	}

	public String getInvalid() {
		//默认否
		if(invalid==null||invalid.equals("")){
			invalid="1";
		}
		return invalid;
	}

	public void setInvalid(String invalid) {
		this.invalid = invalid;
	}

	public String getDraft() {
		//默认否
		if(draft==null||draft.equals("")){
			draft="1";
		}
		return draft;
	}

	public void setDraft(String draft) {
		this.draft = draft;
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
