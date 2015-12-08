package com.business.entity.asset;

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
import com.business.entity.cust.CustInfo;
import com.kernal.annotation.FieldName;
/**
 * 网银数据操作记录表
 * @author Chennes
 * 2013-11-7下午06:26:39
 */
@Entity
@FieldName(name = "网银数据操作记录表")
@Table(name = "FUND_EBANK_DATA_OPERATE_LOG")
public class FundEbankDataOperateLog {
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(length = 32)
	private String id;
	
	@FieldName(name = "网银表id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EBANK_ID")
	private FundEbankData ebankId;
	
	@FieldName(name = "流水号")
	@Column(name = "SN", length = 50)
	private String sn;
	
	@FieldName(name = "修改前是否有效")
	@Column(name = "BEFOR_ENABLED_")
	private Integer beforEnabled;
	
	@FieldName(name = "修改前经销商或客户名称[D](德银)")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BEFOR_CUST_ID")
	private CustInfo beforCustId;
	
	@FieldName(name = "修改前与系统无关金额")
	@Column(name = "BEFOR_NO_WITH_MONEY", precision = 22, scale = 2)
	private BigDecimal beforNoWithMoney;
	
	@FieldName(name = "修改后是否有效")
	@Column(name = "AFTER_ENABLED_")
	private Integer afterEnabled;
	
	@FieldName(name = "修改后经销商或客户名称[D](德银)")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFTER_CUST_ID")
	private CustInfo afterCustId;
	
	@FieldName(name = "修改后与系统无关金额")
	@Column(name = "AFTER_NO_WITH_MONEY", precision = 22, scale = 2)
	private BigDecimal afterNoWithMoney;
	
	@FieldName(name = "备注")
	@Column(name = "SUMMARY", length = 2000)
	private String summary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name = "修改人")
	@JoinColumn(name = "MODIFICATOR_")
	private User modificator;

	@FieldName(name = "修改时间")
	@Column(name = "MODIFY_DATE", length = 20)
	private String modifyDate;
	
	@FieldName(name = "修改状态")
	@Column(name = "STATUS", length = 20)
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FundEbankData getEbankId() {
		return ebankId;
	}

	public void setEbankId(FundEbankData ebankId) {
		this.ebankId = ebankId;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Integer getBeforEnabled() {
		return beforEnabled;
	}

	public void setBeforEnabled(Integer beforEnabled) {
		this.beforEnabled = beforEnabled;
	}

	public CustInfo getBeforCustId() {
		return beforCustId;
	}

	public void setBeforCustId(CustInfo beforCustId) {
		this.beforCustId = beforCustId;
	}

	public BigDecimal getBeforNoWithMoney() {
		return beforNoWithMoney;
	}

	public void setBeforNoWithMoney(BigDecimal beforNoWithMoney) {
		this.beforNoWithMoney = beforNoWithMoney;
	}

	public Integer getAfterEnabled() {
		return afterEnabled;
	}

	public void setAfterEnabled(Integer afterEnabled) {
		this.afterEnabled = afterEnabled;
	}

	public CustInfo getAfterCustId() {
		return afterCustId;
	}

	public void setAfterCustId(CustInfo afterCustId) {
		this.afterCustId = afterCustId;
	}

	public BigDecimal getAfterNoWithMoney() {
		return afterNoWithMoney;
	}

	public void setAfterNoWithMoney(BigDecimal afterNoWithMoney) {
		this.afterNoWithMoney = afterNoWithMoney;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
