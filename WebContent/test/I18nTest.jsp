<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="/WEB-INF/tlds/spring.tld"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 01 Transitional//EN">  
<html>  
  <head>  
    <title>Spring国际化</title>  
  </head>  
  <body>  
  
    标签：<input type='button' value='<spring:message code="title" arguments="<%=new String[]{"test01","test02"} %>" text="测试"/>' /><br>  
 java代码调用：<input type='button' value='<%=com.kernal.utils.WebUtil.getMessage("title",new String[]{"test01","test02"},"测试",null) %>' /><br>  
  
  </body>   
  
</html>  
