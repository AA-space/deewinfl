<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进项发票统计表</title>
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
   		 tableComment:'[进项发票统计表]',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'进项发票统计表',
         id:'id_table',
         xmlFileName:'/eleasing/jsp/invoice_report/input_invoice_statistics.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         columns:[
		            {header:'业务合同号',name:'contractnumber',queryConfig:{}},
		            {header:'承租人',name:'custname',queryConfig:{}},
		            {header:'项目名称',name:'projectname',queryConfig:{}},
		            {header:'费用类型',name:'feename'},
		            {header:'发票金额',name:'invoicemoney',queryConfig:{isNewLine:true}},
		            {header:'发票张数',name:'invoiceamount'},
		            {header:'认证金额',name:'certificationmoney'},
		            {header:'未认证金额',name:'uncertificationmoney'},
		            {header:'发票号',name:'invoiceno',queryConfig:{}},
		            {header:'合同号',name:'contractid'}
	        ]
   	 });
   });
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>