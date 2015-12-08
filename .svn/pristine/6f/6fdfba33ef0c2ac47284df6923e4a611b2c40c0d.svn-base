<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建流程</title>
<!--css sheet-->
<link href="${pageContext.request.contextPath}/css/dtree/dtree.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/button.css"
	rel="stylesheet" type="text/css">
<!--javascript libray-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
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

<script type="text/javascript">
jQuery(function(){
    var all_width = document.body.clientWidth;
	var all_height = document.body.clientHeight;
	//commonSelect('id_crediter','FINANCING_CONFIG_UNIT','UNIT_NAME','ID','crediter',null,null,'lable="授信机构"',190);
	var crediter = new tracywindyComboBox({
	       id:'id_combo_crediter',
	       renderTo:'id_crediter',
	       xmlFileName:'\\eleasing\\jsp\\financing_config\\finacing_config_credit.xml',
	       loadMode:'ajax',
	       readOnly:true,
		   isContainEmpty:false,
		   otherAttributes:'requerid=true label="授信单位"',
	       name:'crediter',
	       width:190,
	       displayField:'name',
	       valueField:'code',
	       leftAdd:0,
	       isCheck:false,
	       params:{
	          pid:'cust_type'
	       },
		   onSelect:function(combo){
	       var valSplitArr = combo.getValue().split(";");
	       jQuery("input[name='crediter_type']").val(valSplitArr[2]);
			}
	    });
	var creditType = new tracywindyComboBox({
	       id:'id_combo_creditType',
	       renderTo:'id_credit_type',
	       xmlFileName:'\\eleasing\\jsp\\financing_config\\finacing_config_creditType.xml',
	       loadMode:'ajax',
	       readOnly:true,
		   isContainEmpty:false,
		   otherAttributes:'requerid=true label="授信类型"',
	       name:'creditType',
	       width:190,
	       displayField:'name',
	       valueField:'code',
	       leftAdd:0,
	       isCheck:false,
	       params:{
	          pid:'cust_type'
	       }
		   //onSelect:
	    });
		jQuery("#id_menuDetailInfoForm").show();
		jQuery("#id_menuDetailInfoForm").window({
			   closable:false,
			   top:20
		});
		jQuery("#id_menuDetailInfoForm").window("open");
	});
	function openWindow(){
		var crediter = getTracywindyObject('id_combo_crediter').getRawValue();
		var crediter_type = getTracywindyObject('id_combo_crediter').getValue().split(";");
		var credit_type = getTracywindyObject('id_combo_creditType').getValue().split(";");
		if(!crediter) {
			alert("请选择授信单位!");
			return false;
		}else if(!credit_type[1]){
			alert("请选择授信种类");
			return false;
		}else {
			   var attachmentParams="financing_credit.crediter="+crediter+"&financing_credit.crediter_type="+crediter_type[1]+"&financing_credit.credit_type="+credit_type[1];
		       startProcess("授信流程-1",attachmentParams);
	       }
	}
</script>
</head>
<body>
<div id="id_menuDetailInfoForm" class="easyui-window" closed="true"
	modal="true" title="新建流程"
	style="display: none; width: 600px; height: 250px; text-align: center;">
<center>
<div style="width: 90%; padding-top: 30px;">
<table align="center">
	<tr>
		<td>可选用的流程</td>
		<td>融资授信流程</td>
	</tr>
	<tr>
		<td class="input_label_desc">授信单位:</td>
		<td class="input_value"><div id="id_crediter"></div></td>
		<td></td>
	</tr>
	<tr>
		<td class="input_label_desc">授信机构属性:</td>
		<td class="input_value"><input name="crediter_type" class="readonly" readonly></td>
		<td></td>
	</tr>
	<tr>
		<td class="input_label_desc">授信种类:</td>
		<td class="input_value"><div id="id_credit_type"></div></td>
		<td></td>
	</tr>
	<tr>
		<td class="input_label_desc">发起人:</td>
		<td class="input_value"><input name="Creator" value="${sessionScope.loginUser.realname}"
			disabled="disabled"></td>
		<td></td>
	</tr>
	<tr class="content-separator">
		<td colspan=3><a style="margin-left: 20px;"
			href="javascript:void(0);" class="btn btn-primary"
			onclick='openWindow();'><span>确定</span></a> <a
			style="margin-left: 20px;" href="javascript:void(0);"
			class="btn btn-primary"
			onclick='jQuery("#id_menuDetailInfoForm").window("close");'><span>取消</span></a>
		</td>
	</tr>

</table>
</div>
</center>
</div>
</body>
</html>