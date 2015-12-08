<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="This is my page">

<style type="text/css">
custom-label {
	
}

.custom-option {
	color: red;
	border: 1px;
	border-color: black;
}
</style>


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/ligerui1.2.0/skins/Aqua/css/ligerui-all.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/ligerui1.2.0/skins/lab.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/poshyTip/tip-yellow/tip-yellow.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/poshyTip/tip-violet/tip-violet.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/poshyTip/tip-darkgray/tip-darkgray.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/poshyTip/tip-skyblue/tip-skyblue.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/poshyTip/tip-yellowsimple/tip-yellowsimple.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/poshyTip/tip-twitter/tip-twitter.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/poshyTip/tip-green/tip-green.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/my97DatePicker/skin/WdatePicker.css" />
<!-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/validator/Validform_v5.3.2/css/style.css" /> -->
<!-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/validator/Validform_v5.3.2/css/demo.css" />-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/validator/Validform_v5.3.2/css/custom.css" />

<script type="text/javascript" src="resource/jquery/jquery-1.8.2.js"></script>
<script type="text/javascript" src="resource/jquery/jqueryExtend.js"></script>
<script type="text/javascript" src="resource/jquery/jquery.json-2.4.min.js"></script>
<script src="resource/ligerui1.2.0/js/core/base.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerGrid.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerToolBar.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerComboBox.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerFilter.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerForm.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerDialog.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerTextBox.js" type="text/javascript"></script>
<script src="resource/ligerui1.2.0/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
<!-- <script type="text/javascript" src="resource/ligerui1.2.0/js/ligerui.all.js"></script> -->
<script type="text/javascript" src="resource/ligerui1.2.0/js/lab.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/ligerGrid.showFilter.js"></script>
<script type="text/javascript" src="resource/somejs/tableGrid.js"></script>
<script type="text/javascript" src="resource/somejs/commtable.js"></script>
<script type="text/javascript" src="resource/somejs/PageSystem.js"></script>
<script type="text/javascript" src="resource/somejs/ComboBox.js"></script>
<!-- 验证框架 -->

<script type="text/javascript" src="resource/jquery.validation/messages_cn.js"></script>
<!-- <script type="text/javascript" src="resource/validator/validator.js"></script> -->
<script type="text/javascript" src="resource/validator/Validform_v5.3.2/js/Validform_v5.3.2.js"></script>
<!-- <script type="text/javascript" src="resource/poshyTip/jquery.poshytip.js"></script> -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
<script type="text/javascript" src="testGridData.js"></script>

<script type="text/javascript">
	var openWidth =$(window).width() || 900;
	var openHeight = $(window).height() || 500;
	var jsonString = '${param.jsontype}';
	if (jsonString == '') {
		alert("请输入参数 jsontype!");
	} else {
		var openForms = [];
		var param = {
			jsonStringName : jsonString
		};
		$.post("commController.action?getJsonString", param, function(data) {
			console.info(data);
			var column = data.grid;
			var ajaxParam = {};
			ajaxParam.column = [];
			ajaxParam.objectType = data.attribute.objectType;

			for ( var key in column) {
				ajaxParam.column.push(column[key]['name']);
			}
			//JSON.stringify(ajaxParam);
			var url = 'commController.action?findFuzzy';
			data.attribute.url = url;
			data.attribute.params = ajaxParam;
			preview(data);
		}, "json");

	}


	
	function clearCascadeSelect(){
		
	}
	
	function clear(o) {
		if (openForms.length > 0) {
			for ( var i = 0; i < openForms.length; i++) {
				openForms[i].destroy();
			}
			openForms = [];
		}
		;
		var managerid = [];
		var managers = $.ligerui.find($.ligerui.controls.Input);
		for ( var i = 0, l = managers.length; i < l; i++) {
			managerid.push(managers[i].id);
			if (exits(o, managers[i].id)) {
				managers[i].destroy();
			}

		}
	}

	function preview(o) {
		//var o = bulidData();

		//clear(o.form);

		var out = [];
		out.push('<div>');
		out.push('  <div style=" width:98%">');
		out.push('      <div class="searchtitle">');
		out.push('          <span>搜索</span><img src="../icons/searchtool.gif" />');
		out.push('          <div class="togglebtn"></div> ');
		out.push('      </div>');
		out.push('      <div class="navline" style="margin-bottom:4px; margin-top:4px;"></div>');
		out.push('      <div class="searchbox">');
		out.push('          <form></form>');
		out.push('      <div class="l-clear"></div>');
		out.push('      </div>');
		out.push('  </div>');
		out.push('  <div class="listgrid"></div> ');
		out.push('</div>');
		var listPanle = $(out.join(''));

		var searchform = $("form:first", listPanle);
		searchform.ligerForm({
			fields : o.search
		});

		var AllProductData = {};

		var listgrid = $(".listgrid:first", listPanle).ligerGrid({
			columns : o.grid,
			toolbar : listToolbar(),
			//data : $.extend(true, {}, AllProductData),
			url : o.attribute.url,
			params : o.attribute.params,
			width : 'auto',
			height : '100%',
			checkbox : false
		});

		//搜索 按钮
		lab.appendSearchButtons(searchform, listgrid, false, function() {
			listgrid.options.data = $.extend(true, {}, AllProductData);
		});

		//附加到body上
		$('body').html(listPanle);
		/* 
		//弹框
		$.ligerDialog.open({
			title : '预览 列表 界面',
			target : listPanle,
			width : 950,
			height : 530,
			isResize : true,
			isHidden : false,
			modal : false,
			buttons : [ {
				text : '关闭',
				onclick : function(item, dialog) {
					dialog.hide();
				}
			} ]
		}); */

		function listToolbar() {
			var items = [];
			items.push({
				text : '增加',
				click : grid_add,
				img : "../icons/page_add.png"
			});
			items.push({
				text : '修改',
				click : grid_edit,
				img : "../icons/edit.gif"
			});
			items.push({
				text : '删除',
				click : grid_delete,
				img : "../icons/delete.png"
			});
			items.push({
				text : '高级自定义查询',
				click : grid_search,
				icon : 'search2'
			});
			return {
				items : items
			};

			function grid_add() {
				//clear(o.form);
				showDetail(o);
			}

			function grid_edit() {
				//clear(o.form);
				var selected = listgrid.getSelected();
				if (!selected) {
					lab.tip('请选择行');
					return;
				}
				showDetail(o, selected);
			}

			function grid_delete() {
				listgrid.deleteSelectedRow();
			}

			function grid_search() {
				listgrid.options.data = $.extend(true, {}, AllProductData);
				listgrid.showFilter();
			}
		}
	}

	function showDetail(fields, data) {
		var formFields = fields.form;
		
		var form = $('<form></form> ');
		var openForm = form.ligerForm({
			fields : formFields
		});
		//openForms.push(openForm);
		var dialog = $.ligerDialog.open({
			title : '预览 明细 界面',
			target : form,
			width : openWidth - 100,
			height : openHeight - 20,
			isResize : false,
			beforeClose : function(dialog){
				dialog.openForm.destroy();
			},
			buttons : [ {
				text : '关闭',
				onclick : function(item, dialog) {
					dialog.close();
				}
			},{
				text : '保存',
				onclick : function(item, dialog) {
					//dialog.hide();
					/* lab.submitForm(openForm, function(){
						alert("ok");
					}); */
					;
					//console.info(Validator.Validate(openForm.element,1, false));
					 //console.info(Validator.Validate(openForm.element,4,false));
					var validate = $(openForm.element).Validform({
							tiptype:3
						});
					console.info(validate.check(false));
					 
					var objectType = fields.attribute.objectType;
					var url = 'commController.action?saveOrUpdata&objectType='+ objectType;
					var simpleObjectType = objectType.substr(objectType.lastIndexOf('.') +1);
					var formData = simpleObjectType + '=' + $.toJSON($(openForm.element).serializeObject());
					
					/* $.post(url ,formData , function(msg){
						console.info(msg);
					}); */
				}
			} ]
		});
		dialog.openForm = openForm;
		lab.loadForm(form, data, openForm.id+ '_');
	}

	function exits(o, id) {
		for ( var int = 0; int < o.length; int++) {
			if (id == o[int]['name'])
				return true;
		}
		return false;
	}
</script>

</head>
<body>

</body>
</html>