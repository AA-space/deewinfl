package com.business.entity.contract;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kernal.annotation.FieldName;

/**
 * 
 * @author 孙传良
 * @date 2013-3-6下午09:44:31
 * @info 合同五级分类表
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "合同五级分类表")
@Table(name="FINANCE_FIVE_SORT")
public class FinanceFiveSort {

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="五级分类编号")
	@Column(name="FINANCEFIVESORTID")
	private String financefiveSortId;
	
	@FieldName(name="五级分类日期")
	@Column(name="FINANCEFIVESORTDATE",length=20)
	private String   financefiveSortDate;

	@FieldName(name="资产分类名称")
	@Column(name="ITEMNAME")
	private String itemName;

	@FieldName(name="正常类")
	@Column(name="AVERAGECLASS",precision=22,scale=2)
	private BigDecimal averageClass;

	@FieldName(name="关注类")
	@Column(name="ATTENTIONCLASS",precision=22,scale=2)
	private BigDecimal attentionClass;

	@FieldName(name="次级类")
	@Column(name="SECONDARYCLASS",precision=22,scale=2)
	private BigDecimal secondaryClass;

	@FieldName(name="可疑类")
	@Column(name="DOUBTABLECLASS",precision=22,scale=2)
	private BigDecimal doubtableClass;

	@FieldName(name="损失类")
	@Column(name="LOSINGCLASS",precision=22,scale=2)
	private BigDecimal losingClass;

	@FieldName(name="五级分类编号")
	@Column(name="REMARK")
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFinancefiveSortId() {
		return financefiveSortId;
	}

	public void setFinancefiveSortId(String financefiveSortId) {
		this.financefiveSortId = financefiveSortId;
	}

	public String getFinancefiveSortDate() {
		return financefiveSortDate;
	}

	public void setFinancefiveSortDate(String financefiveSortDate) {
		this.financefiveSortDate = financefiveSortDate;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getAverageClass() {
		return averageClass;
	}

	public void setAverageClass(BigDecimal averageClass) {
		this.averageClass = averageClass;
	}

	public BigDecimal getAttentionClass() {
		return attentionClass;
	}

	public void setAttentionClass(BigDecimal attentionClass) {
		this.attentionClass = attentionClass;
	}

	public BigDecimal getSecondaryClass() {
		return secondaryClass;
	}

	public void setSecondaryClass(BigDecimal secondaryClass) {
		this.secondaryClass = secondaryClass;
	}

	public BigDecimal getDoubtableClass() {
		return doubtableClass;
	}

	public void setDoubtableClass(BigDecimal doubtableClass) {
		this.doubtableClass = doubtableClass;
	}

	public BigDecimal getLosingClass() {
		return losingClass;
	}

	public void setLosingClass(BigDecimal losingClass) {
		this.losingClass = losingClass;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
