<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金测算</title>
<!--javascript libray-->
<script language="javascript">
var loadMask;
jQuery(function() {
	isSubTable=true;
	var all_width  =document.documentElement.clientWidth;
	var all_height =  document.documentElement.clientHeight;
	var oldCurrentPageClientWidth = all_width;
	var oldCurrentPageClientHeight = all_height;
	formHeight = 0;
	formWidth = 0;//formWidth
	var containerWidthAdd = 12;
	var containerHeightAdd = 115;
	formHeight = all_height-containerHeightAdd-10;
	formWidth = all_width-containerWidthAdd-20;
});
</script>
</head>
<body >
<jsp:include page="main_4_5.jsp"/>
<script language="javascript">
//jQuery(function() {//初始化测算主要字段
	/*jQuery('#conditionCustName').val("XX客户");
	jQuery('#conditionCustId').val("rentcal_4_5");
	jQuery('#conditionContractId').val("rentcal_4_5");
	jQuery('#conditionProjId').val("rentcal_4_5");
	jQuery('#conditionDocId').val(Math.random());
	jQuery('#reckonProcess').val("quoted_price");
	jQuery('#rentCalUtil').hide();*/
	
//});
</script>
</body>
</html>