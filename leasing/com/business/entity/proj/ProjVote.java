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
@FieldName(name = "项目投票")
@Table(name="PROJ_VOTE")
public class ProjVote {
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="项目编号")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROJ_ID")
	private ProjInfo projId;
	
	@FieldName(name="投票类型")
	@JoinColumn(name="VOTE_TYPE")
	@ManyToOne(fetch = FetchType.LAZY)
	private DictionaryData voteType;
	
	@FieldName(name="评审分数")
	@Column(name="VOTE_GRADE")
	private String voteGrade;
	
	@FieldName(name="评审意见")
	@Column(name="VOTE_COMMONENT")
	private String voteCommonent;
	

	@FieldName(name="步骤id")
	@Column(name="WORK_FLOW_UNID")
	private String workFLowUnid;
	
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

	public DictionaryData getVoteType() {
		return voteType;
	}

	public String getVoteGrade() {
		return voteGrade;
	}

	public String getVoteCommonent() {
		return voteCommonent;
	}

	public void setVoteType(DictionaryData voteType) {
		this.voteType = voteType;
	}

	public void setVoteGrade(String voteGrade) {
		this.voteGrade = voteGrade;
	}

	public void setVoteCommonent(String voteCommonent) {
		this.voteCommonent = voteCommonent;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public String getWorkFLowUnid() {
		return workFLowUnid;
	}

	public void setWorkFLowUnid(String workFLowUnid) {
		this.workFLowUnid = workFLowUnid;
	}

	
}
