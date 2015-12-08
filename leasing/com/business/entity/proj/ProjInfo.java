package com.business.entity.proj;


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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;

import com.business.entity.Department;
import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.contract.ContractInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.entity.proj.invoice.ProjInvoiceType;
import com.business.entity.proj.reckon.ProjCashDetail;
import com.business.entity.proj.reckon.ProjCondition;
import com.business.entity.proj.reckon.ProjFinaCashDetail;
import com.business.entity.proj.reckon.ProjFinaRentPlan;
import com.business.entity.proj.reckon.ProjFundFundPlan;
import com.business.entity.proj.reckon.ProjFundRentPlan;
import com.business.entity.project_nocar.credit_nocar.ProjFileInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-5上午10:17:01
 * @info 项目基本信息实体类
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "项目基本信息")
@Table(name="PROJ_INFO")
public class ProjInfo {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="项目编号")
	@Column(name="PROJ_ID",unique = true, length=50)
	private String projId;

	@FieldName(name="项目日期")
	@Column(name="PROJ_DATE", length=20)
	private String projDate;

	@FieldName(name="项目名称")
	@Index(name="INX_PROJ_INFO_PROJNAME")
	@Column(name="PROJECT_NAME")
	private String projectName;
	
	@FieldName(name="合同号")
	@Column(name="CONTRACT_NUMBER")
	private String contractNumber;

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="项目类型")
	//在JoinColumn中指定的是我这个表需要和DictionaryData中主键级联的数据库的字段名
	@JoinColumn(name="PROJ_TYPE")
	private DictionaryData projType;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="项目规模")
	@JoinColumn(name="PROJ_SCALE")
	private DictionaryData projScale;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="项目来源")
	@JoinColumn(name="PROJ_SOURCE")
	private DictionaryData projSource;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="内部行业")
	@JoinColumn(name="INDUSTRY_TYPE")
	private DictionaryData industryType;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="租赁类型[资产分类(德银)]")
	@JoinColumn(name="LEAS_TYPE")
	private DictionaryData leasType;

	@FieldName(name="是否第三方代付(德银)")
	@Column(name="IS_THIRD_PAY")
	private Integer isThirdPay;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="租赁形式")
	@JoinColumn(name="LEAS_FORM")
	private DictionaryData leasForm;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="承租人")
	@JoinColumn(name="CUST_ID")
	private CustInfo custId;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="项目出单部门")
	@JoinColumn(name="PROJ_DEPT")
	private Department projDept;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="经办人")
	@JoinColumn(name="PROJ_REGISTRAR")
	private User projRegistrar;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="项目经理")
	@JoinColumn(name="PROJ_MANAGE")
	private User projManage;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="项目协办")
	@JoinColumn(name="PROJ_ASSIST")
	private User projAssist;

	@FieldName(name="流程地址")
	@JoinColumn(name="DOCURL")
	private String docurl;

	@FieldName(name="项目状态")
	@Column(name="PROJ_STATUS")
	private Integer projStatus;
	
	@FieldName(name="撤销时间")
	@Column(name="REPEAL_DATE", length=20)
	private String repealDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="撤销原因分类")
	@JoinColumn(name="REPEAL_REASON_TYPE")
	private DictionaryData repealReasonType;
	
	@FieldName(name="撤销原因")
	@Column(name="REPEAL_REASON")
	private String repealReason;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="信审结论类型")
	@JoinColumn(name="APPROVE_TYPE")
	private DictionaryData approveType;

	@FieldName(name="评审结论")
	@Column(name="APPROVE_CONCLUSION")
	private String approveConclusion;

	@FieldName(name="评审日期")
	@Column(name="APPROVE_DATE", length=20)
	private String approveDate;
	
	@FieldName(name="是否资料补齐 0为没有,1为补齐, 默认为0")
	@Column(name="DATA_COMPLETE", length=2, columnDefinition="INT DEFAULT 0")
	private Integer dataComplete;

	@FieldName(name="")
	@Column(name="ISNOTMONEY")
	private String isNotMoney;
	
	@FieldName(name="下属合同序号")
	@Column(name="CONTRACT_ORDER")
	@Deprecated
	private Integer contractOrder;

	@FieldName(name="合同导出状态,默认为0")
	@Column(name="CARD_EXPORT_STATUS", columnDefinition="VARCHAR2(32 CHAR) DEFAULT '0'")
	private String cardExportStatus;
	
	@FieldName(name="合同导出状态,默认为0")
	@Column(name="PROJ_EXPORT_STATUS", columnDefinition="VARCHAR2(32 CHAR) DEFAULT '0'")
	private String projExportStatus;
	public String getCardExportStatus() {
		return cardExportStatus;
	}

	public void setCardExportStatus(String cardExportStatus) {
		this.cardExportStatus = cardExportStatus;
	}

	public String getProjExportStatus() {
		return projExportStatus;
	}

	public void setProjExportStatus(String projExportStatus) {
		this.projExportStatus = projExportStatus;
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
	
	@FieldName(name="流程状态")
	@Column(name="WORK_FLAG", length=2, columnDefinition="INT DEFAULT 0")
	private Integer workFlag;
	
	@FieldName(name="立项结束时间")
	@Column(name="END_DATE", length=20)
	private String endDate;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="业务类型(德银)[D]")
	@JoinColumn(name="BUSINESS_TYPE")
	private DictionaryData businessType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="业务模式(德银)[D]")
	@JoinColumn(name="BUSINESS_MODE")
	private DictionaryData businessMode;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="经销商(德银)[S]")
	@JoinColumn(name="CUST_DEALER")
	private CustInfo custDealer;
	
	@FieldName(name="经销商提交项目的username")
	@Column(name="DEALER_UNAME", length=180)
	private String dealeruname;
	
	//租金测算相关
	@FieldName(name="项目现金流")
	//mappedBy 中指定的值时实体类中的字段名 不是数据库的名字
	@OneToMany(mappedBy="projId", fetch=FetchType.LAZY)
	private Set<ProjCashDetail>  projCashDetails=new HashSet<ProjCashDetail>();
	
	
	@FieldName(name="项目会计现金流")
	@OneToMany(mappedBy="projId", fetch=FetchType.LAZY)
	private Set<ProjFinaCashDetail>  projFinaCashDetails=new HashSet<ProjFinaCashDetail>();
	
	@FieldName(name="合同租金计划")
	@OneToMany(mappedBy="projId", fetch=FetchType.LAZY)
	private Set<ProjFundRentPlan> projFundRentPlans=new HashSet<ProjFundRentPlan>();
	
	@FieldName(name="合同租金计划")
	@OneToMany(mappedBy="projId", fetch=FetchType.LAZY)
	private Set<ProjFinaRentPlan> projFinaRentPlans=new HashSet<ProjFinaRentPlan>();

	@FieldName(name="合同资金计划")
	@OneToMany(mappedBy="projId", fetch=FetchType.LAZY)
	private Set<ProjFundFundPlan> projFundFundPlans=new HashSet<ProjFundFundPlan>();
	
	@FieldName(name="商务条件")
	@OneToOne(mappedBy="projId") 
	private ProjCondition projCondition =new ProjCondition();
	
	// 一对一的表	
	@FieldName(name="项目发票信息")
	@OneToOne(mappedBy="projId") 
	private ProjInvoiceType projInvoiceType ;
	
	// 一对一的表	
	@FieldName(name="项目其它信息")
	@OneToOne(mappedBy="projId") 
	private ProjOtherInfo projOtherInfo ;
	
	public ProjOtherInfo getProjOtherInfo() {
		return projOtherInfo;
	}

	public void setProjOtherInfo(ProjOtherInfo projOhterInfo) {
		this.projOtherInfo = projOhterInfo;
	}

	//一对多的表
	@FieldName(name="租赁物件")
	@OneToMany(mappedBy="projId",fetch=FetchType.LAZY) 
	private Set<ProjEquip> projEquips = new HashSet<ProjEquip>();
	
	@FieldName(name="项目抵质押物件")
	@OneToMany(mappedBy="projId",fetch=FetchType.LAZY) 
	private Set<ProjGuaranteeEquip> projGuaranteeEquips = new HashSet<ProjGuaranteeEquip>();

	@FieldName(name="项目担保方式")
	@OneToMany(mappedBy="projId",fetch=FetchType.LAZY) 
	private Set<ProjGuaranteeMethod> projGuaranteeMethods = new HashSet<ProjGuaranteeMethod>();

	@FieldName(name="项目下属合同")
	@OneToMany(mappedBy="projId",fetch=FetchType.LAZY) 
	private Set<ContractInfo> contractInfos = new HashSet<ContractInfo>();
	
	@FieldName(name="文件清单")
	@OneToMany(mappedBy="projId",fetch=FetchType.LAZY) 
	private Set<ProjFileInfo> projFileInfos = new HashSet<ProjFileInfo>();


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjId() {
		return projId;
	}

	public void setProjId(String projId) {
		this.projId = projId;
	}

	public String getProjDate() {
		return projDate;
	}

	public void setProjDate(String projDate) {
		this.projDate = projDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public DictionaryData getProjType() {
		return projType;
	}

	public void setProjType(DictionaryData projType) {
		this.projType = projType;
	}

	public DictionaryData getProjScale() {
		return projScale;
	}

	public void setProjScale(DictionaryData projScale) {
		this.projScale = projScale;
	}

	public DictionaryData getProjSource() {
		return projSource;
	}

	public void setProjSource(DictionaryData projSource) {
		this.projSource = projSource;
	}

	public DictionaryData getIndustryType() {
		return industryType;
	}

	public void setIndustryType(DictionaryData industryType) {
		this.industryType = industryType;
	}

	public DictionaryData getLeasType() {
		return leasType;
	}

	public void setLeasType(DictionaryData leasType) {
		this.leasType = leasType;
	}

	public Integer getIsThirdPay() {
		return isThirdPay;
	}

	public void setIsThirdPay(Integer isThirdPay) {
		this.isThirdPay = isThirdPay;
	}

	public DictionaryData getLeasForm() {
		return leasForm;
	}

	public void setLeasForm(DictionaryData leasForm) {
		this.leasForm = leasForm;
	}

	public CustInfo getCustId() {
		return custId;
	}

	public void setCustId(CustInfo custId) {
		this.custId = custId;
	}

	public Department getProjDept() {
		return projDept;
	}

	public void setProjDept(Department projDept) {
		this.projDept = projDept;
	}

	public User getProjRegistrar() {
		return projRegistrar;
	}

	public void setProjRegistrar(User projRegistrar) {
		this.projRegistrar = projRegistrar;
	}

	public User getProjManage() {
		return projManage;
	}

	public void setProjManage(User projManage) {
		this.projManage = projManage;
	}

	public User getProjAssist() {
		return projAssist;
	}

	public void setProjAssist(User projAssist) {
		this.projAssist = projAssist;
	}

	public String getDocurl() {
		return docurl;
	}

	public void setDocurl(String docurl) {
		this.docurl = docurl;
	}

	public Integer getProjStatus() {
		return projStatus;
	}

	public void setProjStatus(Integer projStatus) {
		this.projStatus = projStatus;
	}

	public String getRepealDate() {
		return repealDate;
	}

	public void setRepealDate(String repealDate) {
		this.repealDate = repealDate;
	}

	public DictionaryData getRepealReasonType() {
		return repealReasonType;
	}

	public void setRepealReasonType(DictionaryData repealReasonType) {
		this.repealReasonType = repealReasonType;
	}

	public String getRepealReason() {
		return repealReason;
	}

	public void setRepealReason(String repealReason) {
		this.repealReason = repealReason;
	}

	public DictionaryData getApproveType() {
		return approveType;
	}

	public void setApproveType(DictionaryData approveType) {
		this.approveType = approveType;
	}

	public String getApproveConclusion() {
		return approveConclusion;
	}

	public void setApproveConclusion(String approveConclusion) {
		this.approveConclusion = approveConclusion;
	}

	public String getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate;
	}

	public String getIsNotMoney() {
		return isNotMoney;
	}

	public void setIsNotMoney(String isNotMoney) {
		this.isNotMoney = isNotMoney;
	}

	public Integer getContractOrder() {
		return contractOrder;
	}

	public void setContractOrder(Integer contractOrder) {
		this.contractOrder = contractOrder;
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

	public Integer getWorkFlag() {
		return workFlag;
	}

	public void setWorkFlag(Integer workFlag) {
		this.workFlag = workFlag;
	}

	public DictionaryData getBusinessType() {
		return businessType;
	}

	public void setBusinessType(DictionaryData businessType) {
		this.businessType = businessType;
	}

	public DictionaryData getBusinessMode() {
		return businessMode;
	}

	public void setBusinessMode(DictionaryData businessMode) {
		this.businessMode = businessMode;
	}

	public CustInfo getCustDealer() {
		return custDealer;
	}

	public void setCustDealer(CustInfo custDealer) {
		this.custDealer = custDealer;
	}

	public Set<ProjCashDetail> getProjCashDetails() {
		return projCashDetails;
	}

	public void setProjCashDetails(Set<ProjCashDetail> projCashDetails) {
		this.projCashDetails = projCashDetails;
	}

	public Set<ProjFinaCashDetail> getProjFinaCashDetails() {
		return projFinaCashDetails;
	}

	public void setProjFinaCashDetails(
			Set<ProjFinaCashDetail> projFinaCashDetails) {
		this.projFinaCashDetails = projFinaCashDetails;
	}

	public Set<ProjFundRentPlan> getProjFundRentPlans() {
		return projFundRentPlans;
	}

	public void setProjFundRentPlans(Set<ProjFundRentPlan> projFundRentPlans) {
		this.projFundRentPlans = projFundRentPlans;
	}

	public Set<ProjFinaRentPlan> getProjFinaRentPlans() {
		return projFinaRentPlans;
	}

	public void setProjFinaRentPlans(Set<ProjFinaRentPlan> projFinaRentPlans) {
		this.projFinaRentPlans = projFinaRentPlans;
	}

	public ProjCondition getProjCondition() {
		return projCondition;
	}

	public void setProjCondition(ProjCondition projCondition) {
		this.projCondition = projCondition;
	}

	public ProjInvoiceType getProjInvoiceType() {
		return projInvoiceType;
	}

	public void setProjInvoiceType(ProjInvoiceType projInvoiceType) {
		this.projInvoiceType = projInvoiceType;
	}

	public Set<ProjEquip> getProjEquips() {
		return projEquips;
	}

	public void setProjEquips(Set<ProjEquip> projEquips) {
		this.projEquips = projEquips;
	}

	public Set<ProjGuaranteeEquip> getProjGuaranteeEquips() {
		return projGuaranteeEquips;
	}

	public void setProjGuaranteeEquips(Set<ProjGuaranteeEquip> projGuaranteeEquips) {
		this.projGuaranteeEquips = projGuaranteeEquips;
	}

	public Set<ProjGuaranteeMethod> getProjGuaranteeMethods() {
		return projGuaranteeMethods;
	}

	public void setProjGuaranteeMethods(
			Set<ProjGuaranteeMethod> projGuaranteeMethods) {
		this.projGuaranteeMethods = projGuaranteeMethods;
	}
	
	public Set<ProjFileInfo> getProjFileInfos() {
		return projFileInfos;
	}

	public void setProjFileInfos(Set<ProjFileInfo> projFileInfos) {
		this.projFileInfos = projFileInfos;
	}

	public Set<ContractInfo> getContractInfos() {
		return contractInfos;
	}

	public void setContractInfos(Set<ContractInfo> contractInfos) {
		this.contractInfos = contractInfos;
	}

	public Set<ProjFundFundPlan> getProjFundFundPlans() {
		return projFundFundPlans;
	}

	public void setProjFundFundPlans(Set<ProjFundFundPlan> projFundFundPlans) {
		this.projFundFundPlans = projFundFundPlans;
	}

	public Integer getDataComplete() {
		return dataComplete;
	}

	public void setDataComplete(Integer dataComplete) {
		this.dataComplete = dataComplete;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDealeruname() {
		return dealeruname;
	}

	public void setDealeruname(String dealeruname) {
		this.dealeruname = dealeruname;
	}
	
}
