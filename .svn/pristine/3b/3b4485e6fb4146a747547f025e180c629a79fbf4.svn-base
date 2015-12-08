<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资金发票统计</title>
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
   		 tableComment:'[资金发票统计]',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'资金发票统计',
         id:'id_table',
         xmlFileName:'/eleasing/jsp/invoice_report/fund_invoice_statistics.xml',
         loadMode:'ajax',
         isFit:true,
         isPage:true,
         columns:[
		            {header:'合同编号',name:'contract_id',queryConfig:{}},
		            {header:'业务合同号',name:'contract_number',queryConfig:{}},
		            {header:'费用类型',name:'name_'},
		            {header:'金额',name:'fact_money'},
		            {header:'日期',name:'fact_date'},
		            {header:'承租人',name:'cust_name'},
		            {header:'发票类型',name:'tax_type'},
		            {header:'状态',name:'invoice_status'},
		            {header:'发票号',name:'invoice_no'},
		            {header:'发票金额',name:'invoice_money'},
		            {header:'组织机构代码',name:'tax_reg_code'}
	        ]
   	 });
   });
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>