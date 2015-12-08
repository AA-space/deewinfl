<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJsp.jsp' starting page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="This is my page">

<style type="text/css">
custom-label{
	
}
</style>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/my97DatePicker/skin/WdatePicker.css"/>
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="resource/jquery.easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="resource/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resource/jquery.easyui/themes/icon.css">


<script type="text/javascript" src="resource/jquery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="resource/jquery/jquery.json-2.4.min.js"></script>
<script type="text/javascript" src="resource/jquery.easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="resource/jquery.easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="resource/jquery.easyui/jquery.easyui.extend.js"></script>
<script type="text/javascript" src="resource/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resource/somejs/commutil.js"></script>
<script type="text/javascript" src="resource/somejs/commtable.js"></script>
<script type="text/javascript" src="resource/somejs/tcommtable.js"></script>
<!-- 验证框架 -->
<script type="text/javascript" src="resource/validator/validator.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>

<!-- <script type="text/javascript" src="resource/validator/common-validator-2.1.min.js"></script>
<script type="text/javascript" src="resource/validator/common-validator-config.js"></script>
<script type="text/javascript" src="resource/validator/common-validator-messages.js"></script> -->
<!--[if IE 6]>
    <link rel="stylesheet" type="text/css" href="resource/bootstrap/css/ie6.min.css">
<![endif]-->

</head>
<body>
	<script type="text/javascript">
		$(".collapse").collapse();
	</script>

	<script>
		jQuery(document).ready(function() {

			
			var commData = jQuery.parseJSON('${requestScope.data}');
			///console.info(commData);
			var xml = '${param.xml}';

			if (commData.findPageList) {
				 
				var data = new GetCommDataByType(commData, 'findPageList');
				var xmlType = '&xml=' + xml + '&modelType=' + data.getModelType();
				var objectType = '&objectType=' + data.getTableId();
				
				commTableHead(objectType, xmlType, function(r) {//获得通用列表
					commTablePageList(objectType, xmlType, convertTableListHead(r), 'commTablePageList');
				});
				showToolBar();
				if (commData.fuzzy) {
					
					var fuzzyData = new GetCommDataByType(commData, 'fuzzy');
					var fuzzyXmlType = '&xml=' + xml + '&modelType=' + fuzzyData.getModelType();
					var fuzzyTableId = 'commtable' + fuzzyData.getSimpleId() + 'fuzzy';
					
					var fuzzyObjectType = '&objectType=' + fuzzyData.getTableId();
					
					var accordId = fuzzyTableId + 'accordion';
					var accordInnerId = fuzzyTableId + 'Inner';
					$('#toolBarQuery').show();
					
					addToolBarAccordionMethod('toolBarQuery', accordId);
					
					commTableHead(fuzzyObjectType, fuzzyXmlType, function(r) {
						addAccordionContent(r, fuzzyTableId, accordId, accordInnerId);
						addFuzzyToolBar(accordInnerId, fuzzyTableId, 'commTablePageList');
					});
					
				}
			}
			if (commData.add) {
				var addFalg = '${param.addFlag}';
				var addData = new GetCommDataByType(commData, 'add');
				var addXmlType = '&xml=' + xml + '&modelType=' + addData.getModelType();
				var addTableId = 'commtable' + addData.getSimpleId() + 'add';
				var addObjectType = '&objectType=' + addData.getTableId();
				var addObjectId = addTableId + 'id';
				var addObjectTitle = addData.getTableName();
				var addGroupStyle = addData.getGroupStyle();
				var addTypeModel = addData.getTypeModel();
				///console.info("addGroupStyle = " + addGroupStyle);
				///console.info("addTypeModel = " + addTypeModel);
				
				$('#toolBarAdd').show();
				
				if (addFalg) {
					commTableHead(addObjectType, addXmlType, function(r) {
						commTable(r, addTableId, 'commAdd', addGroupStyle);
						addSaveAndCloseButton(addTableId, addObjectType, addObjectId);
					});
				} else{
					//var openTypeStr = 'openNewWindow';
					openType(addTypeModel, addObjectType, addXmlType, addTableId, addObjectId, addObjectTitle, addGroupStyle);
				}
			}

			if (commData.findById) {
				var data = new GetCommDataByType(commData, 'findById');
				var xmlType = '&xml=' + xml + '&modelType=' + data.getModelType();
				var renderId = 'commtable' + data.getSimpleId() + 'findById';
				var objectType = '&objectType=' + data.getTableId();
				commTableHead(objectType, xmlType, function(r) {
					commTable(r, renderId, 'findById');
					////console.info(r);

				});

				addSaveAndCloseButton(renderId, objectType);
				var id = 16;
				commTableValue(objectType, id, function(r) {
					addValues(r, renderId);
				});
			}

			if (commData.updata) {
				
				var data = new GetCommDataByType(commData, 'updata');
				var xmlType = '&xml=' + xml + '&modelType=' + data.getModelType();
				var renderId = 'commtable' + data.getSimpleId() + 'updata';
				$('#toolBarModifile').show();
				commTableHead(objectType, xmlType, function(r) {
					//do something
				});
			}

		});
	</script>

	<!-- toolbar选项 -->
	<div class="accordion" id="accordion" style="display: none;">
		<div id="accordion-group" class="accordion-group">
			<div id="accordion-heading" class="accordion-heading">
				<button id="toolBarAdd" class="btn btn-info" style="display: none;">添加</button>
				<button id="toolBarDel" class="btn btn-danger" data-toggle="collapse" data-parent="#accordion" data-target="#collapseOne" style="display: none;">删除</button>
				<button id="toolBarModifile" class="btn btn-danger" data-toggle="collapse" data-parent="#accordion" data-target="#collapseOne" style="display: none;">修改</button>
				<button id="toolBarQuery" class="btn btn-info" data-toggle="collapse" data-parent="#accordion" style="display: none;">查询选项</button>
			</div>
			<div id="collapseOne" class="accordion-body collapse">
				<div class="accordion-inner"></div>
			</div>
		</div>
	</div>

	<!-- 列表 -->
	<table id="commTablePageList"></table>

	<!-- 通用 -->
	<div id="comm"></div>
	<!-- 弹框 -->
	<div id="commModel" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="removecommModel();">×</button>
			<h3 id="myModalLabel"></h3>
		</div>
		<div id="modal-body" class="modal-body"></div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true" onclick="removecommModel();">关闭</button>
			<button id="btn-primary-save" class="btn btn-primary" onclick="setInputValue();">保存</button>
		</div>
	</div>

	<!-- 通用增加 -->
	<div id="commAdd"></div>
	<div id="findById"></div>

	<!-- tab效果 -->
	<div id="commTablebable" class="tabbable" style="display:none;">
		<ul id="commNav-tabs" class="nav nav-tabs"></ul>
		<div id="commTab-content" class="tab-content"  style=""></div>
		
		<hr>
	</div>
	<script>
		//ie6支持
		$(function() {
			if ($.browser.msie && parseInt($.browser.version, 10) === 6) {
				$('.row div[class^="span"]:last-child').addClass("last-child");
				$('[class*="span"]').addClass("margin-left-20");
				$(':button[class="btn"], :reset[class="btn"], :submit[class="btn"], input[type="button"]').addClass("button-reset");
				$(":checkbox").addClass("input-checkbox");
				$('[class^="icon-"], [class*=" icon-"]').addClass("icon-sprite");
				$(".pagination li:first-child a").addClass("pagination-first-child");
			}
		});
	</script>
	
	<form action="">
	<select></select>
	</form>
</body>
</html>