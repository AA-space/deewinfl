<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>   
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>风险处置 </title>
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
<link
	href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css"
	rel="stylesheet" type="text/css">
<!--javascript libray-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
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
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/validator.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
<style type="text/css">
html,body {
	overflow: hidden;
}
</style>
<script type="text/javascript">
    var constantFlagTable = "ContractDocInfo";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
		
		 
		var table = new tracywindyOperationTable({
			 
			 tableComment:'风险处置 ',
	   		 constantFlagTable:'ContractDocInfo',
	         renderTo:'id_tableContainer',
	         title:'风险处置 ',
	         width:pageWidth,
	         height:pageHeight,
	         id:'id_table',
	         xmlFileName:'/eleasing/jsp/other/lawsuit/list.xml',
	         loadMode:'ajax',
	         isPage:true,
	         border:true,
	         isRank:true,
	         isFit:true,
	         columns:[
						
						{header:'序号',name:'column1'},
						{header:'合同编号',name:'column2'},
						{header:'客户名称',name:'column3'},
						{header:'经销商名称',name:'column4'},
						{header:'采取措施',name:'column5'}
		        ]
   	 });
   	 
   });

	jQuery(function(){
    	dict('num','proj_info.projtype','root_null_ini','${requestScope["proj_info.projtype"]}','${requestScope["rawValue_proj_info.projtype"]}','');
    	dict('contractidnum','proj_info.projtype','root_null_ini','${requestScope["proj_info.projtype"]}','${requestScope["rawValue_proj_info.projtype"]}','');
    });

	
</script>
</head>
<body>
<div id="id_tableContainer"></div>
<div id="id_detailInfoWindowContainer" title="添加" style="display: none; width: 800px; height: 400px">
<center>
<form id="id_detailInfoForm">
<table style="width: 90%">
	 	<tr>
	 	<td colspan="4">&nbsp;</td>
	 	</tr>
		<tr>
			<td class="input_label_desc" align="left">序号:</td>
			<td class="input_value">
			<div style="float: left" class="leftComboContainer" id="num"></div>
			</td>
			<td class="input_label_desc" align="left">合同编号:</td>
			<td class="input_value">
			<div style="float: left" class="leftComboContainer" id="contractidnum"></div>
			</td>
		</tr>
		<tr>
		<td class="input_label_desc" align="left">客户名称:  </td>  
           	<td class="td-content">
           		<input  type="text"  name="column3"   class="td-content-input" require="true" label="客户名称"  maxB="8" /><span class="content-required">*</span>
           	</td>
           	<td class="input_label_desc" align="left">经销商名称:  </td>  
           	<td class="td-content">
           		<input   type="text"  name="column4"  class="td-content-input" require="true" label="经销商名称" ><span class="content-required">*</span>
           	</td>
	      	</tr>
		<tr>
			<td class="input_label_desc" align="left">风险详情:</td>
			<td class="input_value" colspan="4"><textarea rows="3" cols="95" ' require="true" label="风险详情"
				style="width:98.9%" name="q.c9"></textarea>
			</td>
		</tr>
		<tr>		
			<td class="input_label_desc" align="left">采取措施:</td>
			<td class="input_value" colspan="4"><textarea rows="3" cols="95" ' require="true" label="采取措施"
				style="width:98.9%" name="q.c9"></textarea>
			</td>
		</tr>
		<tr>
			<td class="input_label_desc" align="left">处理进度:</td>
			<td class="input_value" colspan="4"><textarea rows="3" cols="95" ' require="true" label="处理进度"
				style="width:98.9%" name="q.c9"></textarea>
			</td>
		</tr>
		<tr>
			<td class="input_label_desc" align="left">备注:</td>
			<td class="input_value" colspan="4">
			<textarea rows="3" cols="95" ' require="true" label="备注"
				style="width:98.9%" name="q.c9"></textarea>
			</td>
		</tr>

		<tr class="content-separator">
			<td colspan='4'><a style="margin-left: 20px;"
				href="javascript:void(0);" class="btn btn-primary"
				onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a>
			<a style="margin-left: 20px;" href="javascript:void(0);"
				class="btn btn-primary"
				onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
			</td>
		</tr>
</table>
</form>
</center>
</div>

</body>
</html>