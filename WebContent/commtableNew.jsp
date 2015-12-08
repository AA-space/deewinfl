<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJsp.jsp' starting page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="This is my page">

<style type="text/css">
custom-label {
	
}
</style>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/my97DatePicker/skin/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="resource/jquery.easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="resource/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resource/jquery.easyui/themes/icon.css">

<link href="/framework/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css"/>
<link href="/framework/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
<link href="/framework/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
<link href="/framework/css/tracywindy/workflow.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="resource/jquery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="resource/jquery/jquery.json-2.4.min.js"></script>
<script type="text/javascript" src="resource/jquery.easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="resource/jquery.easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="resource/jquery.easyui/jquery.easyui.extend.js"></script>
<script type="text/javascript" src="resource/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resource/somejs/commutil.js"></script>
<script type="text/javascript" src="resource/somejs/commtable.js"></script>
<!-- 验证框架 -->
<script type="text/javascript" src="resource/validator/validator.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>


<!-- <script type="text/javascript" src="resource/validator/common-validator-2.1.min.js"></script>
<script type="text/javascript" src="resource/validator/common-validator-config.js"></script>
<script type="text/javascript" src="resource/validator/common-validator-messages.js"></script> -->
<!--[if IE 6]>
    <link rel="stylesheet" type="text/css" href="resource/bootstrap/css/ie6.min.css">
<![endif]-->

</head>
<body>

	<script type="text/javascript">
		$(".collapse").collapse();
	</script>
	<script type="text/javascript">
	////console.info('${param.xml}');
		jQuery(document).ready(function() {
			var xml = '${param.xml}';
			var t1 = new Jason.commTable({
				XMLName : xml,//'Customer.xml',
				XMLType : [ 'findPageList', 'add','modify', 'fuzzy'],
				renderId : 'table',
				groupDivStyle : 'span6'
			}); 
			 
		/* 	var g1 = new tableGrid({
				renderID : 'grid',
				url : 'commController/commController.action?findFields&xml=Customer.xml&modelType=findPageList&objectType=com.business.entity.CustEwlpInfo'
			});
			g1.getHead(); */
			
		});
		
		
	</script>

	<div id="table"></div>
	<div id="grid"></div>
	
</body>
</html>