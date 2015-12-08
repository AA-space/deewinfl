<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试miniui</title>
 <%@include file="/base/mini.jsp"%>
</head>
<body>
     <div style="width:100%;text-align:center;font-size:14px;">
	    <script>
	        seajs.use("js/test/test.js",function(test){
	        	alert(new test().getTest());
	        });
	        //alert(test);//undefined，这时候资源还没有被加载完成，所以为空
	    </script>
     </div>
     测试文字颜色
</body>
</html>
