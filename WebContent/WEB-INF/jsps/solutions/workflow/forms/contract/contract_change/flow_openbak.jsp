<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同审批</title>
<!--css sheet-->
<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
<!--javascript libray-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
<style type="text/css">
html,body {
	overflow: hidden;
}

.picItem {
	float: left;
	padding: 5px 5px 5px 5px;
	border: 1px solid silver;
}
</style>


</head>
<body>
	<div id="proj_change"></div>

	<script type="text/javascript">
		var all_width = (document.documentElement || document.body).clientWidth - 2;
		var all_height = (document.documentElement || document.body).clientHeight - 1;
		var table = new tracywindyTable({
			renderTo : 'proj_change',
			width : all_width,
			height : all_height,
			isFit : true,
			tools : [ {
				html : '<font color="red">审批</font>',
				handler : function(table) {
					var contractIDValue = table.getCheckedRowDatas();
					if (0 == contractIDValue.length) {
						alert("请选择需要变更的项目！");
						return false;
					}
					var attachmentParams = "contractInfo_id=" + contractIDValue[0].id;
					startProcess("合同变更流程-1", attachmentParams);
				},
				iconCls : 'icon-add'
			} ],
			isPage : true,
			pageSize : 20,
			//isRank : true,
			//rankSize : 50,
			isCheck : true,
			emptyChar : '-',
			checkType : 'radio',
			xmlFileName : 'eleasing/workflow/contract/commContractSelect.xml',
			columns : [
					{
						header : '合同编号',
						name : 'contract_id'
					},
					{
						header : '项目名称',
						name : 'project_name'
					},
					{
						header : '承租人',
						name : 'cust_name'
					},
					{
						header : '立项日期',
						name : 'proj_date'
					},
					{
						header : '创建日期',
						name : 'create_date'
					},
					{
						header : '创建人',
						name : 'realname'
					},
					{
						header : '操作',
						name : 'oper',
						renderer : function(value, tableObj, columnName, columnIndex, rowData) {

							return '<a href="javascript:void(0);" onclick="toProcessActivePicture(\'' + rowData.deployid + '\',\'' + rowData.processinstanceid + '\')">显示流程图</a>'
									+ '&nbsp;&nbsp;&nbsp;&nbsp;' + '<a href="javascript:void(0);" onclick="toProcessForm(' + rowData.taskid + ',\'' + rowData.actorid + '\',\'' + rowData.tasktype
									+ '\')">查看</a>';
						}
					} ]
		});

		function toProcessActivePicture(deployId, processInstanceId) {
			var sheight = 600;
			var swidth = 850;
			var winoption = null;//"height="+sheight+"px;width="+swidth+"px;status=no;scroll=yes;resizable=yes";
			window.open("${pageContext.request.contextPath}/workflow/jbpm/getActivedRects.action?deployId=" + deployId + "&processInstanceId=" + processInstanceId + "&randomNumber=" + Math.random(),
					"_blank");
		}
		function toProcessForm(currentTaskId, planActorId) {
			window.open("${pageContext.request.contextPath}/jbpm/requestProcessTaskForm.action?currentTaskId=" + currentTaskId + "&jbpmWorkflowHistoryInfoUserId=" + planActorId, "_blank");
		}
	</script>
</body>
</html>