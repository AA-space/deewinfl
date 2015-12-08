<%@ page contentType="text/html; charset=gbk" language="java" errorPage="../../error.jsp" %>
<jsp:directive.page import="com.tenwa.leasing.irr.web.ActuIrrDo"/>
<jsp:directive.page import="java.io.PrintWriter"/>
<jsp:directive.page import="java.io.IOException"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<link href="../../css/global.css" rel="stylesheet" type="text/css">
</head>

<BODY>
<%
String contract_id =  request.getParameter("contract_id") ;
//调用irr计算的方法

String irr = new ActuIrrDo().calActuIrrByContractId(contract_id);
 
 
 
 		response.setContentType("text/xml; charset=GBK");
	    response.setHeader("Cache-Control", "no-cache");
	    //String result = plan_bj;
	    try {
	      PrintWriter pw = response.getWriter();
	      pw.println(irr);
	      pw.flush();
	      pw.close();
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
 
 
 
%>