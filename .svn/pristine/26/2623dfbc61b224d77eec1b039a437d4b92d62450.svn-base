package com.business.entity.dealer;

import java.math.BigDecimal;
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

import org.hibernate.annotations.GenericGenerator;

import com.business.entity.Department;
import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.cust.CustInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-7-28下午03:27:59
 * @info 经销商准入申请记录(德银)
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "经销商准入申请(德银)")
@Table(name="DEALER_APPROVAL_INFO")
public class DealerApprovalInfo {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="经销商ID")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUST_ID")
	private CustInfo custId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="经销商状态[D]")
	@JoinColumn(name="dealer_Status")
	private DictionaryData dealerStatus;
	
	@FieldName(name = "准入申请编号")
	@Column(name="APPROVAL_NUM")
	private String approvalNum;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name = "准入申请人")
	@JoinColumn(name="APPROVAL_")
	private User approval;
	
	@FieldName(name = "准入申请时间")
	@Column(name="APPROVAL_TIME", length=20)
	private String approvalTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="准入申请部门")
	@JoinColumn(name="APPROVAL_DEPT")
	private Department approvalDept;

	@FieldName(name = "准入评审编号")
	@Column(name="CREDIT_NUM",length=20)
	private String creditNum;
	
	@FieldName(name = "准入评审时间")
	@Column(name="CREDIT_Time",length=20)
	private String creditTime;
	
	@FieldName(name = "经销商准入时间")
	@Column(name="APPROVAL_DATA",length=20)
	private String approvalData;
	
	@FieldName(name = "考察报告得分")
	@Column(name="REPORT_SCORE",precision=22,scale=2)
	private BigDecimal reportScore;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name = "评审人")
	@JoinColumn(name="credit_")
	private User credit;

	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="评审部门")
	@JoinColumn(name="CREDIT_DEPT")
	private Department creditDept;
	
	@FieldName(name="注册时间")
	@Column(name="REG_DATE", length=20)
	private String regDate;
	
	@FieldName(name="注册资本")
	@Column(name="REG_CAPITAL", precision=22,scale=2)
	private BigDecimal regCapital;
	
	@FieldName(name="实收资本")
	@Column(name="INCOME_ASSETS", length=2000)
	private String incomeAssets;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="所属区域[D]")
	@JoinColumn(name="OWNER_DISTRICT")
	private DictionaryData ownerDistrict;
	
	@FieldName(name="净资产")
	@Column(name="NET_ASSETS", length=2000)
	private String netAssets;
	
	@FieldName(name="近三年销量")
	@Column(name="THREE_YEAR_SALES", length=2000)
	private String threeYearSales;
	
	@FieldName(name="是否4S")
	@Column(name="is_4s", length=2)
	private String is4s;
	
	@FieldName(name="与陕汽合作时间")
	@Column(name="COOPERATION_DATE", length=20)
	private String cooperationDate;
	
	@FieldName(name="经销商合同记录")
	@OneToMany(mappedBy="creditNum", fetch=FetchType.LAZY)
	private Set<DealerContractInfo> dealerContractInfos=new HashSet<DealerContractInfo>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name = "登记人")
	@JoinColumn(name="CREATOR_")
	private User creator;
	
	@FieldName(name = "登记时间")
	@Column(name="CREATE_DATE", length=20)
	private String createDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name = "更新人")
	@JoinColumn(name="MODIFICATOR_")
	private User modificator;
	
	@FieldName(name = "更新日期")
	@Column(name="MODIFY_DATE")
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

	public DictionaryData getDealerStatus() {
		return dealerStatus;
	}

	public void setDealerStatus(DictionaryData dealerStatus) {
		this.dealerStatus = dealerStatus;
	}

	public String getApprovalNum() {
		return approvalNum;
	}

	public void setApprovalNum(String approvalNum) {
		this.approvalNum = approvalNum;
	}

	public User getApproval() {
		return approval;
	}

	public void setApproval(User approval) {
		this.approval = approval;
	}

	public String getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(String approvalTime) {
		this.approvalTime = approvalTime;
	}

	public Department getApprovalDept() {
		return approvalDept;
	}

	public void setApprovalDept(Department approvalDept) {
		this.approvalDept = approvalDept;
	}

	public String getCreditNum() {
		return creditNum;
	}

	public void setCreditNum(String creditNum) {
		this.creditNum = creditNum;
	}

	public String getCreditTime() {
		return creditTime;
	}

	public void setCreditTime(String creditTime) {
		this.creditTime = creditTime;
	}

	public String getApprovalData() {
		return approvalData;
	}

	public void setApprovalData(String approvalData) {
		this.approvalData = approvalData;
	}

	public BigDecimal getReportScore() {
		return reportScore;
	}

	public void setReportScore(BigDecimal reportScore) {
		this.reportScore = reportScore;
	}

	public User getCredit() {
		return credit;
	}

	public void setCredit(User credit) {
		this.credit = credit;
	}

	public Department getCreditDept() {
		return creditDept;
	}

	public void setCreditDept(Department creditDept) {
		this.creditDept = creditDept;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public BigDecimal getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(BigDecimal regCapital) {
		this.regCapital = regCapital;
	}

	public String getIncomeAssets() {
		return incomeAssets;
	}

	public void setIncomeAssets(String incomeAssets) {
		this.incomeAssets = incomeAssets;
	}

	public DictionaryData getOwnerDistrict() {
		return ownerDistrict;
	}

	public void setOwnerDistrict(DictionaryData ownerDistrict) {
		this.ownerDistrict = ownerDistrict;
	}

	public String getNetAssets() {
		return netAssets;
	}

	public void setNetAssets(String netAssets) {
		this.netAssets = netAssets;
	}

	public String getThreeYearSales() {
		return threeYearSales;
	}

	public void setThreeYearSales(String threeYearSales) {
		this.threeYearSales = threeYearSales;
	}

	public String getIs4s() {
		return is4s;
	}

	public void setIs4s(String is4s) {
		this.is4s = is4s;
	}

	public String getCooperationDate() {
		return cooperationDate;
	}

	public void setCooperationDate(String cooperationDate) {
		this.cooperationDate = cooperationDate;
	}

	public Set<DealerContractInfo> getDealerContractInfos() {
		return dealerContractInfos;
	}

	public void setDealerContractInfos(Set<DealerContractInfo> dealerContractInfos) {
		this.dealerContractInfos = dealerContractInfos;
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
