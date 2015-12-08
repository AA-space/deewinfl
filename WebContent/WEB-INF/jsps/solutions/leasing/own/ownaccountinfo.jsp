<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统管理 - 本方账号信息</title>
<!--css sheet-->
<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
<!--javascript libray-->
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
html,body {
	overflow: hidden;
}
</style>
<script type="text/javascript">
    var constantFlagTable = "User";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({

   		loadFormDataCallBack:function(table,$form,rowIndex){//回调函数给下拉框赋值
	   		 var rowData = table.getRowDataAt(rowIndex);
	   	     var select_ownname = getTracywindyObject("id_combo_ownName");
	   	  select_ownname.setRawValue(rowData["ownname"]);
	 	},
   		 tableComment:'[本方账号信息]',
   		 constantFlagTable:'OwnAccount',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'本方账号信息',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/own_manage/ownaccountinfo.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         columns:[
		            {header:'id',name:'cid',hidden:true},
		            {header:'id',name:'oid',hidden:true},
		            {header:'本方出租人',name:'ownnmae',hidden:true},
		            {header:'本方账号',name:'accnumber'},
		            {header:'本方银行',name:'accbank'},
		            {header:'本方银行账户',name:'accname'},
		            {header:'科目编码',name:'acccode'},
		            {header:'状态',name:'state'}
	        ]
   	 });

 	commonSelectOverall('ownName',"(select i.id oid,i.own_name value from own_info i ) rs",'oid','value','oid','','','require="true" label="本方出租人"','',false);
 	                                                                                     //隐藏列，  显示列，隐藏列域名   
   });
	
</script>
</head>
<body>
	<div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer" title="添加本方账号信息" style="display: none; width: 800px; height: 400px">
		<center>
			<form id="id_detailInfoForm">
				<table style="width: 90%">
					<tr style="display: none">
						<td><input name="cid" type="hidden" value="" /></td>
						<td><input name="oid" type="hidden" value="" /></td>
					</tr>
					<tr>
						<td align="left">本方出租人</td>
						<td><div id="ownName" style="float: left" class="leftComboContainer"></div>
							<span class="content-required">*</span></td>
						<td class="input_label_desc" align="left">科目编码:</td>
						<td><input name="accCode" class="td-content-input" require="true" label="科目编码" maxB="50" /> <span class="content-required">*</span></td>
					</tr>
					<tr>

						<td class="input_label_desc" align="left">本方账号:</td>
						<td class="td-content"><input type="text" name="accNumber" class="td-content-input" require="true" label="本方账号" datatype="Number" maxB="50" /><span class="content-required">*</span></td>
						<td class="input_label_desc" align="left">本方银行:</td>
						<td class="td-content"><input type="text" name="accBank" class="td-content-input" require="true" label="本方银行" maxB="50" /><span class="content-required">*</span></td>
					</tr>
					<tr>
						<td class="input_label_desc" align="left">本方银行账户:</td>
						<td><input name="accName" class="td-content-input" require="true" label="本方银行账户" maxB="50" /> <span class="content-required">*</span></td>
						<td class="input_label_desc" align="left">状态:</td>
						<td class="td-content"><input type="text" name="state" class="td-content-input" require="true" label="状态" maxB="2" /><span class="content-required">*</span></td>
					</tr>
				
					<tr class="content-separator">
						<td colspan='4'><a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a> <a
							style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'
						><span>取消</span></a></td>
					</tr>
				</table>
			</form>
		</center>
	</div>

</body>
</html>