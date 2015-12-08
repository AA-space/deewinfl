<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经销商开票申请</title>
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
	   html,body{
	     overflow:hidden;
	   }
	</style>
	
<script type="text/javascript">
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		 tableComment:'[经销商开票申请]',
   		 constantFlagTable:'DealerInvoice',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'经销商开票申请',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'\\eleasing\\workflow\\invoice_apply\\invoice_apply1.xml',
         loadMode:'ajax',
         /* params:{
   			user_id:'${sessionScope.loginUser.id}',
   			CONTRACT_STATUS_LessThan : '30', CONTRACT_STATUS_GreaterThan : '20'
	     }, */
         isPage:true,
         operButtons:' ',
         isFit:false,
         isAutoBreakContent:true,
         tools:[{
        	 html : '<font color="red">开票申请</font>',
 			handler : function(table) {
 				var contractIdValue = table.getCheckedRowDatas();
 				if (0 == contractIdValue.length) {
 					alert("请选择需要启动的流程！");
 					return false;
 				}
				var attachmentParams = "contract_id=" + contractIdValue[0]["contractid"]+"&cust_id="+contractIdValue[0]["custid"];
                startProcess("开票申请流程-1",attachmentParams);
 			},
 			iconCls :'icon-update'
             }],
         columns:[
{header:'contractid',name:'contractid',hidden:true},
{header:'合同号',name:'contractnumber'},
{header:'custid',name:'custid',hidden:true},
{header:'合同状态',name:'contractStatus',hidden:true},
{header:'项目名称',name:'projectname'},
{header:'活动类型',name:'projtype'},
{header:'经销商',name:'dealer'},
{header:'承租人',name:'custname'}
         ]
   	 });
   });
</script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
	
</body>
</html>