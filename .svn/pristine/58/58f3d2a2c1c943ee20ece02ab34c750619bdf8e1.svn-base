<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty needjs || (needjs eq '1')}">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>

</head>
<body>
</c:if>	
	<div id='page_${id}' style="border:1px solid #ddd;width:100%;height:100%;" class="x-panel-table-div x-panel-table-div-border">
		<div id="page_title_${id}" style="width:100%" class="x-panel-table-div-title">
			<span class="x-panel-table-div-title-titleSpan">&nbsp;&nbsp;${title}</span>
		</div>
		<div id="page_content_${id}" style="width:100%;height:90%;overflow:hidden;">
			<iframe style="overflow:auto;border-width:0px;display:block;width:100%;height:100%" name="page_iframe_${id}" id="id_page_iframe_${id}" frameborder="0" src="${pageUrl}"></iframe>
		</div>
	</div>
	
<c:if test="${empty needjs || (needjs eq '1')}">
</body>
</html>
</c:if>