<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<%@ taglib prefix="fn"  uri="/WEB-INF/tlds/fn.tld" %> 
<%@ taglib prefix="spring" uri="/WEB-INF/tlds/spring.tld"%>
<%@ taglib prefix="fmt"  uri="/WEB-INF/tlds/fmt.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css?version=3" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车架号详细信息</title>
<style type="text/css">
       table.x-panel-table td {
         border:1px solid #DDD;
         border-top:0px solid #DDD;
      }
</style>
</head>
<body>
			<table  style="width:100%;border:0px" class="x-panel-table">
			    <tr ><td colspan="9" class="x-panel-table-div-title" style="padding-left:20px;">车架号信息</td></tr>
				<tr>
				    <td style="width:50px;border:0px;">&nbsp;</td>
					<td>设备</td>
					<td>车架号</td>
					
			    </tr>
			    
			    <c:forEach items="${requestScope['assurornameinfo']}" var="item" varStatus="j">
			    <tr>
				    <td style="width:50px;border:0px;">&nbsp;</td>
					<td>设备${j.count}</td>
					<td>${item}</td>
			    </tr>
			   </c:forEach>
			
	</table>
	
</body>
</html>