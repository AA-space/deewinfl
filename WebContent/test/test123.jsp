<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String[] ss = new String[]{"足球1", "足球1", "足球1"};
	String aa = "足球2,足球3";
	//	request.setAttribute("ss", ss);
	//request.getSession().setAttribute("ss", ss);
	request.setAttribute("aa", aa);
	
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="This is my page">

<style type="text/css">
custom-label {
	
}

.custom-option {
	color: red;
	border: 1px;
	border-color: black;
}
</style>

<script type="text/javascript" src="resource/jquery/jquery-1.8.2.js"></script>
<!-- 验证框架 -->

<script type="text/javascript" src="resource/validator/Validform_v5.3.2/js/Validform_v5.3.2.js"></script>
<!-- <script type="text/javascript" src="resource/poshyTip/jquery.poshytip.js"></script> -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>



<script type="text/javascript">
var tt = '12312\\n12312312\\n<input type="text"/>';
	console.info(tt);
	function get(){
		tt = $("textarea[name='textarea']").val();
		console.info(tt);
	}
	function set(){
		ss = tt.replace(/\\n/gi, '\n');
		console.info(ss);
		$("textarea[name='textarea']").val(ss + "好");
	}
	
	
</script>

</head>
<body>
	<textarea id="textarea"  name="textarea"></textarea>
	<input type="button" onclick="get();" value="得值"/>
	<input type="button" onclick="set();" value="赋值"/>
</body>
</html>