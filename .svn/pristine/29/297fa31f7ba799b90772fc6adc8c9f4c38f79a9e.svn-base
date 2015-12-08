package com.business.entity.contract.fund;

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
import org.hibernate.annotations.Index;

import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.cust.CustInfo;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-7下午12:05:49
 * @info 放款抵扣租金表
 * @Copyright Tenwa
 */
@Entity
@FieldName(name = "放款抵扣租金表")
@Table(name = "CONTRACT_FUND_PAY_FOR_RENT")
public class ContractFundFundPayForRent {

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(length = 32)
	private String id;

	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="经销商")
	@Index(name="INX_FUND_PAY_FOR_RENT_ID")
	@JoinColumn(name="CUST_ID")
	private CustInfo custId;

	@FieldName(name="客户银行")
	@Column(name="CLIENT_BANK")
	private String   clientBank;

	@FieldName(name="客户帐户")
	@Column(name="CLIENT_ACCOUNT")
	private String   clientAccount;

	@FieldName(name="客户帐号")
	@Column(name="CLIENT_ACCNUMBER")
	private String   clientAccnumber;
	
	@FieldName(name = "计划收付日期")
	@Column(name = "PLAN_DATE", length = 20)
	private String planDate;

	@FieldName(name = "现汇金额")
	@Column(name = "PLAN_MONEY", precision = 22, scale = 2)
	private BigDecimal planMoney;
	
	@FieldName(name = "抵扣金额")
	@Column(name = "DEDU_MONEY", precision = 22, scale = 2)
	private BigDecimal deduMoney;

	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="企划")
	@JoinColumn(name="PLANNED")
	private User planned;
	
	@FieldName(name = "当前授信额度")
	@Column(name="CREDIT_MONEY",precision=22,scale=2)
	private BigDecimal creditMoney = BigDecimal.ZERO;
	
	@FieldName(name = "台数")
	@Column(name="EQUIP_COUNT", length = 5)
	private Integer equipcount = 0;
	
	@FieldName(name="承租人名称汇总")
	@Column(name="ALL_CUSTNAME", length = 4000)
	private String   allcustname;
	
	@FieldName(name="合同号汇总")
	@Column(name="ALL_CONTRACTNUM", length = 4000)
	private String   allcontractnum;
	
	@FieldName(name="备注")
	@Column(name="FPNOTE")
	private String   fpnote;
	//设置作废字段,默认为未提交-,已提交，已导出,已放款
	@FieldName(name="状态")
	@Column(name="INVALID",length=10)
	private String invalid="未提交";
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name="创建人")
	@JoinColumn(name="CREATOR_")
	private User creator;

	@FieldName(name = "创建时间")
	@Column(name = "CREATE_DATE", length = 20)
	private String createDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name = "修改人")
	@JoinColumn(name = "MODIFICATOR_")
	private User modificator;

	@FieldName(name = "修改时间")
	@Column(name = "MODIFY_DATE", length = 20)
	private String modifyDate;

	@FieldName(name = "导出状态, 0未导出，1导出")
	@Column(name = "EXPORT_FLAG", length = 2, columnDefinition = "INT DEFAULT 0")
	private Integer exportFlag = 0;

	public String getId() {
		return id;
	}
	
	public String getPlanDate() {
		return planDate;
	}

	public BigDecimal getPlanMoney() {
		return planMoney;
	}

	public BigDecimal getCreditMoney() {
		return creditMoney;
	}

	public String getFpnote() {
		return fpnote;
	}

	public String getInvalid() {
		return invalid;
	}

	public User getCreator() {
		return creator;
	}

	public String getCreateDate() {
		return createDate;
	}

	public User getModificator() {
		return modificator;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public Integer getExportFlag() {
		return exportFlag;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

	public void setPlanMoney(BigDecimal planMoney) {
		this.planMoney = planMoney;
	}

	public void setCreditMoney(BigDecimal creditMoney) {
		this.creditMoney = creditMoney;
	}

	public void setFpnote(String fpnote) {
		this.fpnote = fpnote;
	}

	public void setInvalid(String invalid) {
		this.invalid = invalid;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public void setModificator(User modificator) {
		this.modificator = modificator;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setExportFlag(Integer exportFlag) {
		this.exportFlag = exportFlag;
	}

	public Integer getEquipcount() {
		return equipcount;
	}

	public void setEquipcount(Integer equipcount) {
		this.equipcount = equipcount;
	}
	
	public String getClientBank() {
		return clientBank;
	}

	public String getClientAccount() {
		return clientAccount;
	}

	public String getClientAccnumber() {
		return clientAccnumber;
	}

	public void setClientBank(String clientBank) {
		this.clientBank = clientBank;
	}

	public void setClientAccount(String clientAccount) {
		this.clientAccount = clientAccount;
	}

	public void setClientAccnumber(String clientAccnumber) {
		this.clientAccnumber = clientAccnumber;
	}

	public User getPlanned() {
		return planned;
	}

	public void setPlanned(User planned) {
		this.planned = planned;
	}

	public CustInfo getCustId() {
		return custId;
	}

	public void setCustId(CustInfo custId) {
		this.custId = custId;
	}

	public BigDecimal getDeduMoney() {
		return deduMoney;
	}

	public void setDeduMoney(BigDecimal deduMoney) {
		this.deduMoney = deduMoney;
	}

	public String getAllcustname() {
		return allcustname;
	}

	public void setAllcustname(String allcustname) {
		this.allcustname = allcustname;
	}

	public String getAllcontractnum() {
		return allcontractnum;
	}

	public void setAllcontractnum(String allcontractnum) {
		this.allcontractnum = allcontractnum;
	}
	
}
 
