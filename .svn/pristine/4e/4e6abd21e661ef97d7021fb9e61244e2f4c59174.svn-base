<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息管理  - 附件信息</title>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAttachmentFileUpload.js"></script>
	<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	</style>
<script type="text/javascript">
var constantFlagTable = "User";
var pageWidth  = document.documentElement.clientWidth-2;
var pageHeight = document.documentElement.clientHeight-2;
var cust_id="<%= request.getParameter("cust_id")%>";
var param={};
if(cust_id!="null" || cust_id==""){param.CUST_ID=cust_id;}
if("false"=='${param.readOnly}')
{
	readonly=true;
}else{
	readonly=false;
}
	jQuery(function(){
   	 /*var table = new tracywindyOperationTable({   		 
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         xmlFileName:'/eleasing/jsp/cust_historyinfo/cust_historyinfo.xml',
         params:param,
         loadMode:'ajax',
         operButtons:' ',
         isPage:true,
         //isFit:true,
         displayToggleContainer:'id_tableContainer',
         columns:[
		            {header:'项目编号',name:'projid'},
		            {header:'合同编号',name:'contractid'},
		            {header:'业务合同号',name:'contractnumber'},
		            {header:'项目状态',name:'contractstatusname'},
		            {header:'明细连接',name:'acct'},
		            {header:'融资额',name:'corpus'},
		            {header:'承租人',name:'custname'},
		            {header:'出单部门',name:'projdeptname'},
		            {header:'项目经理',name:'projmanagename'},
		            {header:'逾期期数',name:'num'},
		            {header:'逾期租金',name:'overrent'},
		            {header:'剩余租金',name:'residueoverrent'},
		            {header:'罚息',name:'accnum'},
		            {header:'担保人',name:'assurors'}
	        ]
   	 });*/
		tracywindyAttachmentFileUpload({
			isReadOnly:readonly,
            renderTo:'id_tableContainer',
            module:'CustAttchmentFiles',
            attachmentType:'cust_company_list',
            identifierOne:cust_id,
            width:(parseInt("${param.tableWidth}")||pageWidth)-1,
            height:parseInt("${param.tableHeight}")||pageHeight,
            //isReadOnly:window.isCompletedTask||window.assignAttachmentIsReadOnly||false,
            border:true
		});
   });

</script>

</head>
<body>
	<div id="id_tableContainer"></div>
</body>
</html>