<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>其它功能 - GPS接口信息汇总</title>
<!--css sheet-->
<link href="${pageContext.request.contextPath}/css/dtree/dtree.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/button.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css"
	rel="stylesheet" type="text/css">
<!--javascript libray-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/validator.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
<style type="text/css">
html,body {
	overflow: hidden;
}
</style>
<script type="text/javascript">
    var constantFlagTable = "ContractDocInfo";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
		    var table = new tracywindyOperationTable({
			 tableComment:'GPS接口信息汇总',
	   		 constantFlagTable:'ContractDocInfo',
	         renderTo:'id_tableContainer',
	         title:'GPS接口信息汇总',
	         width:pageWidth,
	         height:pageHeight,
	         id:'id_table',
	         xmlFileName:'/eleasing/jsp/other/interface_import/list2.xml',
	         loadMode:'ajax',
	         operButtons:' ',
	         isPage:true,
	         isFit:true,
	         border:true,
	         isRank:true,
	         columns:[
						//{header:'序号',name:'column1'},
						{header:'承租人名称',name:'gpsuser'},
						{header:'总数量',name:'c0'},
						{header:'在线数',name:'c1'},
						{header:'离线数',name:'c2'}
		        ]
         
   	 });
   	 
   });
	
</script>
</head>
<body>
<div id="id_tableContainer"></div>
<div id="id_detailInfoWindowContainer" title="添加GPS接口信息汇总信息"
	style="display: none; width: 800px; height: 400px">
<center>
<form id="id_detailInfoForm">
<table style="width: 90%">
<tr>
		<td class="input_label_desc" align="left">序号:</td>
			<td class="input_value">
			<div style="float: left" class="leftComboContainer"
				id="contractidname"></div> <span class="content-required">*</span>
			</td>
			
			<td class="input_label_desc" align="left">承租人名称:</td>
			<td class="td-content">
			<div style="float: left" class="leftComboContainer"
				id="contractidname2"></div><span class="content-required">*</span>
			</td>
		</tr>
		<tr>
			<td class="input_label_desc" align="left">总数量:</td>
			<td class="td-content" ><input name="column3" require="true" class="td-content-input"
				label="总数量" type="text" /><span class="content-required">*</span></td>
				
			<td class="input_label_desc" align="left">在线数:</td>
			<td class="td-content" ><input name="column4" require="true" class="td-content-input"
				label="在线数" type="text" /><span class="content-required">*</span></td>
		</tr>
		
		<tr>
			<td class="input_label_desc" align="left">离线数:</td>
			<td class="td-content" ><input name="column5" require="true" class="td-content-input"
				label="离线数" type="text" /><span class="content-required">*</span></td>
		</tr>
		<tr class="content-separator">
			<td colspan='4'><a style="margin-left: 20px;"
				href="javascript:void(0);" class="btn btn-primary"
				onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a>
			<a style="margin-left: 20px;" href="javascript:void(0);"
				class="btn btn-primary"
				onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
			</td>
		</tr>
</table>
</form>
</center>
</div>

</body>
</html>