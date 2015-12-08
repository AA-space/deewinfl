<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="r" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报表</title>
	<%@include file="/base/mini.jsp" %>
    <!--css sheet-->
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<!--javascript libray-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/fusionchart/FusionCharts.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/fusionchart/FusionCharts.jqueryplugin.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/report/report.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/json2/json2.js"></script>
	

</head>
<script type="text/javascript">
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	/*
	function reportReSize(layoutId,layoutWidth,layoutHeight){
		if(layoutWidth == 0 || layoutWidth > pageWidth){
			jQuery('#' + layoutId).width(pageWidth-18);
		}else{
			jQuery('#' + layoutId).width(layoutWidth);
		}
		if(layoutHeight == 0 || layoutHeight > pageHeight){
			jQuery('#' + layoutId).height(pageHeight-5);
		}else{
			jQuery('#' + layoutId).height(layoutHeight);
		}
	}
	*/
</script>
<style type="text/css">
	.content_div{
		margin:0px;
		padding:0px;
		text-indent: 0px;
		float:left;
	}
	.queryButton{
			float:right;			
			padding-top:8px;
			margin-left:10px;
	}
</style>
<body>
	
	<r:forEach items="${layouts}" var="layout" varStatus="status">		
		<r:choose>
			<r:when test="${layout.contentType=='TABLE'}">				
				<div class="content_div" id="layout_${layout.realId}">					
				<jsp:include page="showTable.action?needjs=0&id=${layout.realId}&divWidth=${layout.divWidth}&divHeight=${layout.divHeight}&divCount=${status.count}" flush="true"></jsp:include>
				</div>
			</r:when> 
			<r:when test="${layout.contentType=='CHART' }" >
				<div class="content_div" id="layout_${layout.realId}">					
				<jsp:include page="showChart.action?needjs=0&id=${layout.realId}&divWidth=${layout.divWidth}&divHeight=${layout.divHeight}&divCount=${status.count}" flush="true"></jsp:include>
				</div>
			</r:when>
			<r:when test="${layout.contentType=='PAGE' }">
				<div class="content_div" id="layout_${layout.realId}">					
				<jsp:include page="showPage.action?needjs=0&id=${layout.realId}&divWidth=${layout.divWidth}&divHeight=${layout.divHeight}&divCount=${status.count}" flush="true" ></jsp:include>
				</div>
			</r:when>
		</r:choose>
			
	</r:forEach>
	
	<jsp:include page="export.jsp" flush="true" />
	<div id="div_link" style="display:none">
	
	</div>
</body>
</html>
