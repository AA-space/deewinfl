<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--css sheet-->
<link href="${pageContext.request.contextPath}/css/dtree/dtree.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css"
	rel="stylesheet" type="text/css">
<!--javascript libray-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/validator.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyMultiTable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/ajaxfileupload.js"></script>
<script type="text/javascript">
 
     var isCompletedTask=("true"=="${isCompletedTask}");   //当前结点是否结束
     var flowName="${requestScope['currentWorkFlowName']}";//流程名称
     var stepName="${currentTaskActivityName}";   //当前节点的名称
     var flowUnid="${currentProcessInstanceDBID}";   //当前流程的ID
     var stepUnid="${requestScope['currentTaskId']}";   //当前节点的id
    </script>
<div class="fillTableContainer">
<table class="fillTable" cellspacing="0" cellpadding="0">
	<jsp:include page="finacing_credit03.jsp"></jsp:include>
	<jsp:include page="finacing_change01.jsp"></jsp:include>
</table>
</div>

<script>
var isSubTable = true;
//初始化调用
jQuery(function() {
	//########公共JS事件##########
	jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
	$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
	$("#id_project_info_tabs_content").tabs();
	isSubTable = false;
	var d = $("#id_project_info_tabs_content");
	$("#id_project_fund_rent_plan_tabs_content").css("width",
			(formWidth) + "px");
	$("#id_project_fund_rent_plan_tabs_content").tabs();
	//jQuery(".fillTableContainer").css("width",formWidth+"px");
});
</script>