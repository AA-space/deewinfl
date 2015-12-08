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

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/ligerui1.2.0/skins/Dark/css/ligerui-all.css" />
<!-- link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/ligerui1.2.0/skins/Gray/css/all.css" /> -->
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
<script src="resource/ligerui1.2.0/js/plugins/ligerTab.js" type="text/javascript"></script>
<!-- <script type="text/javascript" src="resource/ligerui1.2.0/js/ligerui.all.js"></script> -->
<script type="text/javascript" src="resource/ligerui1.2.0/js/lab.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/ligerGrid.showFilter.js"></script>
<script type="text/javascript" src="resource/ligerui1.2.0/js/table.js"></script>
<script type="text/javascript" src="resource/somejs/tableGrid.js"></script>
<script type="text/javascript" src="resource/somejs/commtable.js"></script>
<script type="text/javascript" src="resource/somejs/PageSystem.js"></script>
<script type="text/javascript" src="resource/somejs/ComboBox.js"></script>
<!-- 验证框架 -->

<script type="text/javascript" src="resource/validator/Validform_v5.3.2/js/Validform_v5.3.2.js"></script>
<!-- <script type="text/javascript" src="resource/poshyTip/jquery.poshytip.js"></script> -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>

<script type="text/javascript">
/* 	$(function() {
		//$('#table').ligerTab(); 
		ss = $('#grid').jasonTable({jsonType : 'ProcessStatus',  toolBar :['添加', '删除', '修改'],
			gridEdit : function(grid, table){
	 			var selected = grid.getSelected();
	 			if (!selected) {
					lab.tip('请选择行');
					return;
				}
	 			openShowModalDialog("test/custinfo-c.jsp",selected);	
	 		}});
	});
	 */
	$(function() {
	    var data = window.dialogArguments;
	   	//var data = $.evalJSON('{"taxLevel.name":null,"phone":null,"isAssociated":"0","landTaxNumber":null,"taxRegAdd":null,"custKind.id":null,"taxLevel.id":null,"bizScopePrimary":null,"idcardNo":null,"taxPhone":null,"id":"402881e43ebadd08013ebbe36caf0003","regNumber":null,"faxNumber":null,"reditorRight.id":null,"webSite":null,"regCapital":null,"orgCode":"75708818-X","assurorRight.name":null,"taxBank":null,"assurorRight.id":null,"legalRepresentative":null,"mailAdd":null,"postAddr":null,"reditorRight.name":null,"industry.id":null,"postCode":null,"regAddr":null,"creditCard":null,"ownership.id":null,"industry.name":null,"taxAcc":null,"cimemo":null,"custKind.name":null,"custScale.name":null,"nationalTaxNumber":null,"ownership.name":null,"custScale.id":null,"country.name":null,"country.id":null,"taxRegCode":null,"bizScopeSecondary":null,"mobileNumber":null,"bizMethod":null,"__id":"r1001","__previd":-1,"__recordid":"r1001_1","__index":0,"__status":"nochanged","__nextid":"r1002"}');
	   	//初始化为form，默认为grid
	    custCompany = $('#grid').jasonTable({jsonType : 'ProcessStatus', init : 'form', formMethod : 'plane', formData : data});

    });

    function save() {
	    //取得form
	    var custCompanyForm = custCompany.getForm();
	    var validate = $(custCompanyForm.element).Validform({tiptype : 3});
	    if (validate.check(false)) {
		    return;
	    } else {
	    	var values = custCompanyForm.getValues();
	    	console.info(values);
		    /* var objectType = fields.attribute.objectType;
		    var url = 'commController.action?saveOrUpdata&objectType='+ objectType;
		    var simpleObjectType = objectType.substr(objectType.lastIndexOf('.') +1);
		    var formData = simpleObjectType + '=' + $.toJSON($(openForm.element).serializeObject());
		     $.post(url ,formData , function(msg){
		    	console.info(msg);
		    }); */
	    };
    }
</script>

</head>
<body>
	<div id="process_status_list"></div>
	<div id="grid"></div>
	<button id="save" onclick="save();" >保存</button>
</body>
</html>