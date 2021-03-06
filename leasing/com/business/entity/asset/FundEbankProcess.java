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
import org.hibernate.annotations.Index;

import com.kernal.annotation.FieldName;
/**
 * 
 * @author 孙传良
 * @date 2013-3-7上午11:50:10
 * @info 网银在进行流程信息
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "网银在进行流程信息")
@Table(name="FUND_EBANK_PROCESS")
public class FundEbankProcess {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="网银编号")
	@Index(name="INX_FUND_EBANK_PROCESS_ID")
	@ManyToOne(targetEntity=FundEbankData.class,fetch=FetchType.LAZY)
	@JoinColumn(name="EBDATA_ID")
	private FundEbankData ebdataId ;

	@FieldName(name="合同编号")
	@Column(name="CONTRACT_ID")
	private String contractId ;

	@FieldName(name="经销商编号")
	@Column(name="DEALER_ID")
	private String dealerID ;
	
	@FieldName(name="备用主键1")
	@Column(name="key_One")
	private String keyOne ;
	
	@FieldName(name = "流程实例ID")
	@Column(name="FLOW_UNID")
	private String flowUnid;
	

	@FieldName(name="占用流程")
	@Column(name="PROCESS_NAME")
	private String   processName;

	@FieldName(name="流程开始日期")
	@Column(name="START_DATE_",length=20)
	private String   startDate;

	@FieldName(name="涉及网银金额")
	@Column(name="PROCESS_AMOUNT",precision=22,scale=2)
	private BigDecimal   processAmount;
	
	@FieldName(name="流程状态(在执行/已结束--0/1)")
	@Column(name="work_flag")
	private String   work_flag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FundEbankData getEbdataId() {
		return ebdataId;
	}

	public void setEbdataId(FundEbankData ebdataId) {
		this.ebdataId = ebdataId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getDealerID() {
		return dealerID;
	}

	public void setDealerID(String dealerID) {
		this.dealerID = dealerID;
	}

	public String getKeyOne() {
		return keyOne;
	}

	public void setKeyOne(String keyOne) {
		this.keyOne = keyOne;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public BigDecimal getProcessAmount() {
		return processAmount;
	}

	public void setProcessAmount(BigDecimal processAmount) {
		this.processAmount = processAmount;
	}

	public String getWork_flag() {
		return work_flag;
	}

	public void setWork_flag(String workFlag) {
		work_flag = workFlag;
	}
	public String getFlowUnid() {
		return flowUnid;
	}
	public void setFlowUnid(String flowUnid) {
		this.flowUnid = flowUnid;
	}


}
