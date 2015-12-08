<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金应开票提醒（租金）</title>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script><style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
</style>
<script type="text/javascript">
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
</script>
<script type="text/javascript">
	jQuery(function(){
   	 	var table = new tracywindyTable({
   	 	width:parseInt("${param.tableWidth}")||pageWidth,
        height:parseInt("${param.tableHeight}")||pageHeight,
		 toolsLeftMargin:100,
   		 tableComment:'[租金应开票提醒（租金）]',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'租金应开票提醒（租金）',
         id:'id_table',
         isPage:true,
         xmlFileName:'/eleasing/jsp/invoice_report/rent_invoice_remind.xml',
         loadMode:'ajax',
         isFit:true,
         columns:[
		            {header:'合同编号',name:'contractid',queryConfig:{}},
		            {header:'业务合同号',name:'contractnumber',queryConfig:{}},
		            {header:'承租人',name:'custname',queryConfig:{}},
		            {header:'期次',name:'rentlist'},
		            {header:'租金',name:'rent'},
		            {header:'本金',name:'corpus'},
		            {header:'利息',name:'interest'},
		            {header:'金额类型',name:'moneytype'},
		            {header:'计划日期',name:'plandate'},
		            {header:'发票类型',name:'taxtype'},
		            {header:'开票方式',name:'rentinvoicetype'},
		            {header:'发票金额',name:'invoicemoney'},
		            {header:'发票号',name:'invoiceno'}
	        ]
   	 });
   });
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>