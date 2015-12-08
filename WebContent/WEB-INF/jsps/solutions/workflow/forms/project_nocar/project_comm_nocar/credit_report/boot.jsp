<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<link rel=stylesheet href="${pageContext.request.contextPath}/css/miniui/default/miniui.css"/>
<link rel=stylesheet href="${pageContext.request.contextPath}/css/miniui/default/icons.css"/>
<link rel=stylesheet href="${pageContext.request.contextPath}/css/miniui/default/skin.css"/>

<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
	
<!-- 插入样式和JS -->
<script src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/miniui/miniui.js" type="text/javascript"></script>
<!-- miniui扩展样式 -->
<link rel=stylesheet href="${pageContext.request.contextPath}/css/comm_nocar/miniui_ext.css"/>
<!-- miniui扩展JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm_nocar/miniui_ext.js"></script>
<script type="text/javascript" >
function onbeforeshowpopup(e) {
    miniui_ext.onbeforeshowpopup(e);
}

function comboboxChanged(e){
	 var cbb=e.sender;
	 mini.get("rawValue_"+cbb.name).setValue(cbb.text);
}
</script>