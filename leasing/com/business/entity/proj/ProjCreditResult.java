package com.business.entity.proj;

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
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 徐云龙
 * @date 2013-3-5上午10:17:01
 * @info 项目信审结论
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "项目信审结论")
@Table(name="PROJ_CREDIT_RESULT")
public class ProjCreditResult {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="项目编号")
	@Index(name="INX_PROJ_CREDIT_RESULT_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROJ_ID")
	private ProjInfo projId;
	
	@FieldName(name="信审通过时间")
	@Column(name="PROJ_CREDIT_PASS_TIME")
	 private String projCreditPassTime;
	
	@FieldName(name="信审结论类型")
	@JoinColumn(name="CREDIT_RESULT_TYPE")
	@ManyToOne(fetch = FetchType.LAZY)
	private DictionaryData creditResultType;
	
	@FieldName(name="信审员")
	@JoinColumn(name="CREDIT_PERSON_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	 private User  creditPersonId;
	
	@FieldName(name="信审结论")
	@Column(name="CREDIT_CONCLUSION")
	private String creditConclusion;
	
	@FieldName(name="流程名称")
	@Column(name="FLOW_NAME")
    private String flowName;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProjInfo getProjId() {
		return projId;
	}

	public void setProjId(ProjInfo projId) {
		this.projId = projId;
	}
	

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getProjCreditPassTime() {
		return projCreditPassTime;
	}

	public DictionaryData getCreditResultType() {
		return creditResultType;
	}

	 
	public String getCreditConclusion() {
		return creditConclusion;
	}

	public void setProjCreditPassTime(String projCreditPassTime) {
		this.projCreditPassTime = projCreditPassTime;
	}

	public void setCreditResultType(DictionaryData creditResultType) {
		this.creditResultType = creditResultType;
	}

	 
	public void setCreditConclusion(String creditConclusion) {
		this.creditConclusion = creditConclusion;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public User getCreditPersonId() {
		return creditPersonId;
	}

	public void setCreditPersonId(User creditPersonId) {
		this.creditPersonId = creditPersonId;
	}
}
