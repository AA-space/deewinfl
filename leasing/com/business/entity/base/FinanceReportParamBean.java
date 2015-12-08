package com.business.entity.base;

import com.kernal.annotation.FieldName;
@FieldName(name = "财务报表导入参数类")
public class FinanceReportParamBean {
	@FieldName(name="excel中的sheet名")
    public String sheeName ;
	@FieldName(name="sheet对应的类名")
    public String targetClass;
	@FieldName(name="sheet中标题开始对应的cell")
    public String headerCell;
	@FieldName(name="sheet中数据开始对应的cell")
    public String dataCell;
	public FinanceReportParamBean(String sheeName, String targetClass,
			String headerCell, String dataCell) {
		super();
		this.sheeName = sheeName;
		this.targetClass = targetClass;
		this.headerCell = headerCell;
		this.dataCell = dataCell;
	}
	public String getSheeName() {
		return sheeName;
	}
	public void setSheeName(String sheeName) {
		this.sheeName = sheeName;
	}
	public String getTargetClass() {
		return targetClass;
	}
	public void setTargetClass(String targetClass) {
		this.targetClass = targetClass;
	}
	public String getHeaderCell() {
		return headerCell;
	}
	public void setHeaderCell(String headerCell) {
		this.headerCell = headerCell;
	}
	public String getDataCell() {
		return dataCell;
	}
	public void setDataCell(String dataCell) {
		this.dataCell = dataCell;
	}
	
}
