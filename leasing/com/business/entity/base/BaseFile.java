package com.business.entity.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.kernal.annotation.FieldName;

/**
 * 
 * @author 徐云龙
 * @date 2013-8-6下午14:18:45
 * @info
 * @Copyright 
 * Tenwa
 */
@Entity
@FieldName(name = "模板生成文件表")
@Table(name="B_FILE")
public class BaseFile {
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Id
    @GeneratedValue(generator = "paymentableGenerator")     
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	@FieldName(name="模板")
	@ManyToOne(targetEntity=FileTemplate.class,fetch=FetchType.LAZY)
	@JoinColumn(name="FILE_TEMPLATE")
    private FileTemplate fileTemplate;
    
	@FieldName(name="流程id")
	@Column(name="FLOW_UNID")
	private String flowUnid;
	
	@FieldName(name="文档的关键字，合同号、合同编号")
	@Column(name="FILE_FIRST_KEY")
	private String fileFirstKey;
	
	@FieldName(name="文档的关键字、经销商，承租人")
	@Column(name="File_SECOND_KEY")
	private String fileSecondKey;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@FieldName(name="流程名或应该用名")
	@JoinColumn(name="MODEL_NAME")
    private DictionaryData modelName;
	
	@FieldName(name="模板显示名称")
    @Transient
	private String templateShowName;

	@FieldName(name="模板名称")
	@Transient
	private String templateName;
	
	@FieldName(name="文件路径")
	@Column(name="FILE_REAL_ADDRESS")
	private String fileRealAddress;
	
	
	@FieldName(name="导出次数")
	@Column(name="EXPORT_NUMBER", columnDefinition="INT DEFAULT 0",length=5)
	private int exportNumber;
	
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
	   
	@FieldName(name="文件名称")  
	@Column(name="FILE_NAME")
	private String fileName;
	
	@FieldName(name="修改时间")
	@Column(name="MEMO")	
	private String memo;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getTemplateShowName() {
		return templateShowName;
	}

	public void setTemplateShowName(String templateShowName) {
		this.templateShowName = templateShowName;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FileTemplate getFileTemplate() {
		return fileTemplate;
	}

	public void setFileTemplate(FileTemplate fileTemplate) {
		this.fileTemplate = fileTemplate;
	}

	public String getFlowUnid() {
		return flowUnid;
	}

	public void setFlowUnid(String flowUnid) {
		this.flowUnid = flowUnid;
	}

	public String getFileFirstKey() {
		return fileFirstKey;
	}

	public void setFileFirstKey(String fileFirstKey) {
		this.fileFirstKey = fileFirstKey;
	}

	public String getFileSecondKey() {
		return fileSecondKey;
	}

	public void setFileSecondKey(String fileSecondKey) {
		this.fileSecondKey = fileSecondKey;
	}

	
	public DictionaryData getModelName() {
		return modelName;
	}

	public void setModelName(DictionaryData modelName) {
		this.modelName = modelName;
	}

	public String getFileRealAddress() {
		return fileRealAddress;
	}

	public void setFileRealAddress(String fileRealAddress) {
		this.fileRealAddress = fileRealAddress;
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

	public int getExportNumber() {
		return exportNumber;
	}

	public void setExportNumber(int exportNumber) {
		this.exportNumber = exportNumber;
	}

	
}
