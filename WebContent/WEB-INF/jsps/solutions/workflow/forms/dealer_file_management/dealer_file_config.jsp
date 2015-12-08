<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经销商协议管理</title>
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
	<style type="text/css"> 
		html,body{overflow:hidden;}
		.required-content{color:red}
	</style>
<script type="text/javascript">
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({   		 
   		 windowTop:20,
   		 constantFlagTable:'DealerFileConfig',
   	     border:true,
         renderTo:'id_tableContainer',
         title:'经销商协议管理',
         tableComment:'[经销商协议管理]',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         xmlFileName:'/eleasing/workflow/dealer_file_management/dealer_file_config.xml',
         loadMode:'ajax',
         operButtons:'新增|修改|删除',
         lazyLoad: false,
         isPage:true,
         id:'id_table',
         isAutoBreakContent: false,
         isExcel:true,
         isFit: true,
         columns:
         [
	            {header:'id',name:'id',hidden:true},
	    	    {header:'模板序号',name:'fileindex',queryConfig:{}},
	            {header:'合同/文件名称',name:'filename',queryConfig:{}},
	            {header:'年份',name:'year',queryConfig:{}},
	            {header:'排序字段', name:'ordernum'}
	     ]
   	 });
   });
</script>

</head>
<body>
<!-- 加载table 内容div -->
<div id="id_tableContainer"></div>

<!-- 画弹出框内容 -->	
<center>
<div id="id_detailInfoWindowContainer"  title="关账日信息" style="display:none;width:650px;height:200px">
        <center>
	        <form id="id_detailInfoForm">
		        <table style="width:90%">
		            <tr style="display:none">
		            <td><input name="id" id="id" type="hidden" value=""/></td>
		            <td><input name="closeStaff" id="closeStaff" type="hidden" value=""/></td>
		            </tr>
		           <tr >
					   <td class="td-content-title">模板序号：</td>
					   <td class="td-content"><input name="fileindex" class="td-content-input"  
			             type="text" require="true" label="模板序号" /><font class="required-content">*</font></td>
			           <td class="td-content-title">合同/文件名称：</td>
			             <td class="td-content"><input name="filename" class="td-content-input" require="true" label="合同/文件名称"   type="text"  value="${requestScope['filename'] }"><font class="required-content">*</font></td>
					</tr>
					<tr >
					   <td class="td-content-title">年份：</td>
					<td class="td-content"><input name="year" id="year" onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy'})" dataType="date" readOnly class="td-content-input"  
			             type="text" value="${requestScope['year'] }"   require="true" label="关账日" /><font class="required-content">*</font></td>
			           <td class="td-content-title">排序字段：</td>
			             <td class="td-content">
						 <input name="ordernum" class="td-content-input" require="true" label="合同/文件名称"   type="text"  value="${requestScope['ordernum'] }"><font class="required-content">*</font>
						 </td>
					</tr>
					<br/>
		            <tr class="content-separator">
			            <td colspan='4'>
			                 <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='submitInfo()'><span>确定</span></a>
					         <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
			            </td>
		            </tr>
		        </table>
	        </form> 
        </center>
	</div>
</center>
<script type="text/javascript">
function submitInfo(){
	return getTracywindyObject("id_table").operationTable();
}
</script>
</body>
</html>