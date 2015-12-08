<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="div_excelExport" style="display:none;height:200px">	
	<input type="hidden" name="export_reportName" id="export_reportName" vlaue="${(empty reportName)?'':reportName}" />
	<center>
	<table id="table_excelExport" style="width:90%;margin-top:5px">
		
	</table>
	<div id="table_export_btn" style="float:right;position:absolute; bottom:1px;right:10px;height:20px;margin-bottom:10px;margin-right:10px;">
		<a href="javascript:void(0);" class="btn btn-primary" onclick="javascript:exportExcel('${pageContext.request.contextPath}/report/exportExcel.action');"><span>导出</span></a>
		<a href="javascript:void(0);" class="btn btn-primary" onclick="javascript:$('#div_excelExport').window('close');"><span>关闭</span></a>
	</div>
	
	<div style="display:none">
		<iframe id="iframe_export" src="about:blank" style="display:none">
		
		</iframe>
	</div>
	
	</center>
</div>