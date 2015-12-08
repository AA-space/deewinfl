package com.business.entity.project_nocar.credit_nocar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.business.entity.DictionaryData;
import com.business.entity.proj.ProjInfo;
import com.kernal.annotation.FieldName;

@Entity
@FieldName(name = "信审结论")
@Table(name="PROJ_LETTER_CONCLUSION")
public class ProjLetterConclusion {
	
	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="项目编号")
	@OneToOne(targetEntity=ProjInfo.class)
	@JoinColumn(name="PROJ_ID")
	private ProjInfo projId;
	
	@FieldName(name = "通过时间")
	@Column(name="PASS_DATE", length = 20)
	private String passDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@FieldName(name = "信审结论类型")
	@JoinColumn(name="CONCLUSION_TYPE")
	private DictionaryData conclusionType;
	
	@FieldName(name="信审结论")
	@Column(name="CREDIT_CONCLUSION",length=2000)
	private String creditConclusion;

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

	public String getPassDate() {
		return passDate;
	}

	public void setPassDate(String passDate) {
		this.passDate = passDate;
	}

	public DictionaryData getConclusionType() {
		return conclusionType;
	}

	public void setConclusionType(DictionaryData conclusionType) {
		this.conclusionType = conclusionType;
	}

	public String getCreditConclusion() {
		return creditConclusion;
	}

	public void setCreditConclusion(String creditConclusion) {
		this.creditConclusion = creditConclusion;
	}
	
}
