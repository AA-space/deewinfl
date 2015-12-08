<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%
    //request.setCharacterEncoding("GBK");
    String fullPath = request.getSession().getServletContext().getRealPath("/test.doc");
	FileInputStream   fis=new   FileInputStream(fullPath); 
	int   byteRead; 
	OutputStream os = response.getOutputStream();
	while(-1 != (byteRead=fis.read())) 
	{ 
	   os.write(byteRead); 
	} 
	if   (fis   !=   null) 
	{
	   fis.close();
	}
	os.flush();
	os.close();
%>