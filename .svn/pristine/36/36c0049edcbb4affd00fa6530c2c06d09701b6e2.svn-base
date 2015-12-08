package com.business.entity.asset;

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
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.business.entity.User;
import com.business.entity.base.BaseFile;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.reckon.fund.ContractFundRentInCome;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.MFundFundCharge;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-7上午11:28:11
 * @info 网银数据
 * @Copyright Tenwa
 */
@Entity
@FieldName(name = "网银数据")
@Table(name = "FUND_EBANK_DATA")
public class FundEbankData {

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(length = 32)
	private String id;

	@FieldName(name = "网银编号")
	@Column(name = "EBDATA_ID", length = 50, nullable = true)
	private String ebdataId;

	@FieldName(name = "上传文件名")
	@ManyToOne(targetEntity = BaseFile.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "UP_ID")
	private BaseFile upLoadId;

	@FieldName(name = "本方银行")
	@Column(name = "OWN_BANK")
	private String ownBank;

	@FieldName(name = "本方账户")
	@Column(name = "OWN_ACCOUNT")
	private String ownAccount;

	@FieldName(name = "本方账号")
	@Column(name = "OWN_ACC_NUMBER")
	private String ownAccNumber;

	@FieldName(name = "对方银行")
	@Column(name = "CLIENT_BANK")
	private String clientBank;

	@FieldName(name = "对方账户")
	@Column(name = "CLIENT_ACCOUNT")
	private String clientAccount;

	@FieldName(name = "对方账号")
	@Column(name = "CLIENT_ACC_NUMBER")
	private String clientAccNumber;

	@FieldName(name = "付款人")
	@Column(name = "CLIENT_NAME")
	private String clientName;

	@FieldName(name = "经销商或客户名称[D](德银)")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUST_ID")
	private CustInfo custId;
	
	@FieldName(name = "客户(德银)")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KEHU")
	private CustInfo kehu;

	@FieldName(name = "到账金额类型")
	@Column(name = "MONEY_TYPE")
	private String moneyType;

	@FieldName(name = "到账金额")
	@Column(name = "FACT_MONEY", precision = 22, scale = 2)
	private BigDecimal factMoney;
	
	@FieldName(name = "与系统无关金额")
	@Column(name = "NO_WITH_MONEY", precision = 22, scale = 2)
	private BigDecimal noWithMoney;

	@Transient
	@FieldName(name = "已核销金额")
	@Column(name = "HAD_MONEY", precision = 22, scale = 2)
	private BigDecimal hadMoney;

	@Transient
	@FieldName(name = "可核销金额")
	@Column(name = "MAY_OPEMONEY", precision = 22, scale = 2)
	private BigDecimal mayOpeMoney;

	@Transient
	@FieldName(name = "核销合同资金金额")
	@Column(name = "FUND_MONEY", precision = 22, scale = 2)
	private BigDecimal fundMoney;

	@Transient
	@FieldName(name = "核销合同租金金额")
	@Column(name = "RENT_MONEY", precision = 22, scale = 2)
	private BigDecimal rentMoney;

	@Transient
	@FieldName(name = "核销经销商保证金额")
	@Column(name = "FUND_G_MONEY", precision = 22, scale = 2)
	private BigDecimal fundGMoney;

	@Transient
	@FieldName(name = "核销过程中的金额")
	@Column(name = "FUND_P_MONEY", precision = 22, scale = 2)
	private BigDecimal fundPMoney;

	@FieldName(name = "到账时间")
	@Column(name = "FACT_DATE", length = 20)
	private String factDate;

	@FieldName(name = "流水号")
	@Column(name = "SN", length = 50)
	private String sn;

	/**
	 * 由于功能增加，添加状态，11为刚导入，21为保险理赔款，101为其他费用类型
	 * 原有0为启用，1为未启用沿用之前。
	 */
	@FieldName(name = "是否有效, 0为有效，1为无效，默认为0有效")
	@Column(name = "ENABLED_", columnDefinition="INT DEFAULT 0")
	private Integer enabled;
	
	@FieldName(name = "资金收款信息")
	@OneToMany(mappedBy = "ebankNumber", fetch = FetchType.LAZY)
	private Set<ContractFundFundCharge> fundFundCharges = new HashSet<ContractFundFundCharge>();

	@FieldName(name = "租金实收表")
	@OneToMany(mappedBy = "ebankNumber", fetch = FetchType.LAZY)
	private Set<ContractFundRentInCome> contractFundRentInComes = new HashSet<ContractFundRentInCome>();

	@FieldName(name = "经销商保证金收款")
	@OneToMany(mappedBy = "ebankNumber")
	private Set<MFundFundCharge> mFundFundCharges = new HashSet<MFundFundCharge>();

	@FieldName(name = "网银在进行流程")
	@OneToMany(mappedBy = "ebdataId")
	private Set<FundEbankProcess> fundEbankProcesses = new HashSet<FundEbankProcess>();
	
	@FieldName(name = "用途")
	@Column(name = "USE_FOR", length = 2000)
	private String useFor;
	

	@FieldName(name = "备注1")
	@Column(name = "SUMMARY", length = 2000)
	private String summary;
	
	@FieldName(name = "备注2")
	@Column(name = "SUMMARY_BAK", length = 2000)
	private String summaryBak;

	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name = "创建人")
	@JoinColumn(name = "CREATOR_")
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
	
	@FieldName(name = "网银是否正在使用,inusering 表示正在用，为0为未用" )
	@Column(name = "INUSEFLAG", length = 20, columnDefinition="varchar2(20)  DEFAULT 0")
	private String inuseflag;
	
	
	public void initFundEbank() {
		BigDecimal fundMoney = BigDecimal.ZERO;
		BigDecimal rentMoney = BigDecimal.ZERO;
		BigDecimal fundGMoney=BigDecimal.ZERO;
		BigDecimal fundPMoney=BigDecimal.ZERO;
		for (ContractFundFundCharge fc : fundFundCharges) {
			fundMoney = fundMoney.add(fc.getFactMoney());
		}
		for (ContractFundRentInCome fc : contractFundRentInComes) {
			rentMoney = rentMoney .add(fc.getRent()).add(fc.getPenalty());
		}
		for (MFundFundCharge fc : mFundFundCharges) {
			fundGMoney = fundGMoney.add( fc.getFactMoney());
		}
		for (FundEbankProcess fc : fundEbankProcesses) {
			if(fc.getWork_flag().endsWith("0")){
			fundPMoney = fundPMoney.add( fc.getProcessAmount());
		}}
		this.setFundMoney(fundMoney);  //非租金实收（不包含经销商保证金）
		this.setFundGMoney(fundGMoney); //保存证金实收
		this.setFundPMoney(fundPMoney); //核销过程中表
		this.setRentMoney(rentMoney);//租金实收
		BigDecimal hadMoney=new BigDecimal(0.00);
		this.setHadMoney(hadMoney.add(fundMoney).add(rentMoney).add(fundGMoney).add(fundPMoney).setScale(2, BigDecimal.ROUND_HALF_UP));
		BigDecimal opeMoney=this.factMoney;
		opeMoney.subtract(this.noWithMoney).subtract(fundMoney).subtract(rentMoney).subtract(fundGMoney).subtract(fundPMoney);
		this.setMayOpeMoney(opeMoney.subtract(this.noWithMoney).subtract(fundMoney).subtract(rentMoney).subtract(fundGMoney).subtract(fundPMoney).setScale(2, BigDecimal.ROUND_HALF_UP));
	}
	public String getId() {
		return id;
	}

	public String getEbdataId() {
		return ebdataId;
	}

	
	public String getOwnBank() {
		return ownBank;
	}

	public String getOwnAccount() {
		return ownAccount;
	}

	public String getOwnAccNumber() {
		return ownAccNumber;
	}

	public String getClientBank() {
		return clientBank;
	}

	public String getClientAccount() {
		return clientAccount;
	}

	public String getClientAccNumber() {
		return clientAccNumber;
	}

	public String getClientName() {
		return clientName;
	}

	public String getMoneyType() {
		return moneyType;
	}

	public BigDecimal getFactMoney() {
		return factMoney;
	}

	public BigDecimal getNoWithMoney() {
		return noWithMoney;
	}

	public String getFactDate() {
		return factDate;
	}

	public String getSn() {
		return sn;
	}

	public String getSummary() {
		return summary;
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

	public void setId(String id) {
		this.id = id;
	}

	public void setEbdataId(String ebdataId) {
		this.ebdataId = ebdataId;
	}
	public BaseFile getUpLoadId() {
		return upLoadId;
	}
	public void setUpLoadId(BaseFile upLoadId) {
		this.upLoadId = upLoadId;
	}
	public void setOwnBank(String ownBank) {
		this.ownBank = ownBank;
	}

	public void setOwnAccount(String ownAccount) {
		this.ownAccount = ownAccount;
	}

	public void setOwnAccNumber(String ownAccNumber) {
		this.ownAccNumber = ownAccNumber;
	}

	public void setClientBank(String clientBank) {
		this.clientBank = clientBank;
	}

	public void setClientAccount(String clientAccount) {
		this.clientAccount = clientAccount;
	}

	public void setClientAccNumber(String clientAccNumber) {
		this.clientAccNumber = clientAccNumber;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}

	public void setFactMoney(BigDecimal factMoney) {
		this.factMoney = factMoney;
	}

	public void setNoWithMoney(BigDecimal noWithMoney) {
		this.noWithMoney = noWithMoney;
	}

	public void setFactDate(String factDate) {
		this.factDate = factDate;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	public void setSummary(String summary) {
		this.summary = summary;
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

	public Set<FundEbankProcess> getFundEbankProcesses() {
		return fundEbankProcesses;
	}

	public void setFundEbankProcesses(Set<FundEbankProcess> fundEbankProcesses) {
		this.fundEbankProcesses = fundEbankProcesses;
	}

	public BigDecimal getMayOpeMoney() {
		return mayOpeMoney;
	}

	public void setMayOpeMoney(BigDecimal mayOpeMoney) {
		this.mayOpeMoney = mayOpeMoney;
	}

	public Set<ContractFundFundCharge> getFundFundCharges() {
		return fundFundCharges;
	}

	public Set<ContractFundRentInCome> getContractFundRentInComes() {
		return contractFundRentInComes;
	}

	public void setFundFundCharges(Set<ContractFundFundCharge> fundFundCharges) {
		this.fundFundCharges = fundFundCharges;
	}

	public void setContractFundRentInComes(
			Set<ContractFundRentInCome> contractFundRentInComes) {
		this.contractFundRentInComes = contractFundRentInComes;
	}

	public BigDecimal getHadMoney() {
		return hadMoney;
	}

	public void setHadMoney(BigDecimal hadMoney) {
		this.hadMoney = hadMoney;
	}

	public CustInfo getCustId() {
		return custId;
	}

	public void setCustId(CustInfo custId) {
		this.custId = custId;
	}

	public BigDecimal getFundMoney() {
		return fundMoney;
	}

	public void setFundMoney(BigDecimal fundMoney) {
		this.fundMoney = fundMoney;
	}

	public BigDecimal getRentMoney() {
		return rentMoney;
	}

	public void setRentMoney(BigDecimal rentMoney) {
		this.rentMoney = rentMoney;
	}

	public BigDecimal getFundGMoney() {
		return fundGMoney;
	}

	public void setFundGMoney(BigDecimal fundGMoney) {
		this.fundGMoney = fundGMoney;
	}
	public BigDecimal getFundPMoney() {
		return fundPMoney;
	}
	public void setFundPMoney(BigDecimal fundPMoney) {
		this.fundPMoney = fundPMoney;
	}
	public Set<MFundFundCharge> getmFundFundCharges() {
		return mFundFundCharges;
	}
	public void setmFundFundCharges(Set<MFundFundCharge> mFundFundCharges) {
		this.mFundFundCharges = mFundFundCharges;
	}
	public String getUseFor() {
		return useFor;
	}
	public void setUseFor(String useFor) {
		this.useFor = useFor;
	}
	public String getSummaryBak() {
		return summaryBak;
	}
	public void setSummaryBak(String summaryBak) {
		this.summaryBak = summaryBak;
	}
	public String getInuseflag() {
		return inuseflag;
	}
	public void setInuseflag(String inuseflag) {
		this.inuseflag = inuseflag;
	}
	public CustInfo getKehu() {
		return kehu;
	}
	public void setKehu(CustInfo kehu) {
		this.kehu = kehu;
	}
	
}
