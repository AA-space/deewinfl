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
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr_credit_change"></div>
		变更备注信息</td>
	</tr>
	
	<tr class="tr_credit_change tr-odd">
		<td class="td-content-title">变更日期：</td>
		<td class="td-content"><input
			name=""
			class="td-content-input td-content-readonly"
			onclick="WdatePicker(this,{readOnly:true})" readOnly require="true"
			type="text"
			value="${requestScope[''] }"><font
			class="required-content">*</font></td>
		<td></td><td></td>
	</tr>
	<tr class="tr_credit_change tr-even">
		<td class="td-content-title">变更备注：</td>
		<td class="td-content"><input
			name=""
			class="td-content-input td-content-readonly"
			onclick="WdatePicker(this,{readOnly:true})" readOnly require="true"
			type="text"
			value="${requestScope[''] }"></td>
		<td></td><td></td>
	<tr/>

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