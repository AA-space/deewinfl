<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<%@ taglib prefix="fn"  uri="/WEB-INF/tlds/fn.tld" %> 
<%@ taglib prefix="fmt" uri="/WEB-INF/tlds/fmt.tld" %>
<%@ taglib prefix="spring" uri="/WEB-INF/tlds/spring.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 通用js变量和函数 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${currentTaskFormTitle}</title>
<!--样式和js引用以及通用函数-->
<jsp:include page="getWorkflowCommonCssAndJs.jsp"></jsp:include>
</head>
   <body style="overflow:hidden;padding:5px;padding-bottom:2px;">
     <div id="id_loadMaskContainer" style="display:block;">
		<div id="loading">
			  <div class="loading-indicator">正在加载   请稍等...</div>
		</div>
	</div>
	<script type="text/javascript">
	   jQuery("#id_loadMaskContainer").css("height",all_height);	      
	</script>
	<!-- 流程信息容器-->
    <div>
       <div class="x-panel-table-div-title" id="id_focusComponent"><spring:message code="Workflow"  text="流程"/>：${currentWorkFlowDisplayName}[${currentTaskName}]</div>
       <div class="x-panel-table-toolbar-div">
		  <!--提交按钮-->
		  <jsp:include page="getWorkflowButtons.jsp"></jsp:include>
	   </div>
	   <!-- 流程信息明细 -->
       <jsp:include page="getWorkflowMainContainer.jsp"></jsp:include>
	   <!-- 弹出意见框开始 -->
	   <jsp:include page="getWorkflowChoseAdvise.jsp"></jsp:include>  	 
   </div>
</body>
   <script type="text/javascript">
	 (function setInitFocus(){
		   setTimeout("document.getElementById('id_focusComponent').focus()",10);
	 })();
   </script>
   <!-- 流程页面加载完成处理 -->
   <jsp:include page="getWorkflowLoadFinishProcess.jsp"></jsp:include>
   <!-- 流程提交相关函数 -->
   <jsp:include page="getWorkflowSubmitAndCallBack.jsp"></jsp:include>
   <!-- 流程页面通用函数 -->
   <jsp:include page="getWorkflowCommonFunc.jsp"></jsp:include>
   <!-- 流程页面按钮操作函数 -->
   <jsp:include page="getWorkflowButtonsFunc.jsp"></jsp:include>
</html>