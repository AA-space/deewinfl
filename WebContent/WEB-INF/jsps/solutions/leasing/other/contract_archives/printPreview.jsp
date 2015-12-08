<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打印预览</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
	<!--media=print 这个属性可以在打印时有效-->
	<style media=print>
		.NoPrint{display:none;}
		.PageNext{page-break-after: always;}
	</style>
</head>
<body>
</body>
<script type="text/javascript">
   document.body.innerHTML = window.opener.document.getElementById("id_thisDocumentArchives").innerHTML ; 
   var $checkboxs = $("#doclist").find("input[type='checkbox']");
   $checkboxs.attr("disabled",true);
    $(window.opener.document.getElementById("doclist")).find("input[type='checkbox']:checked").each(function(i){
         var value = $(this).val();
        $checkboxs.each(function(i){
        	  var value_ = $(this).val();
              if(value == value_){
            	  $(this).attr("checked",true);  
              }
         });
   });
   $("#id_btn_printPreview").html("<a href='javascript:void(0);' class='NoPrint' onclick='window.print();'>打印文档</a>");
</script>
</html>