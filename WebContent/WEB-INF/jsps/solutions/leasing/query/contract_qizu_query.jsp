<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同起租统计报表(项目经理专用)</title>
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
	   html,body{
	     overflow:hidden;
	   }
	</style>
<script type="text/javascript">
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({   		 
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'合同起租统计报表(项目经理专用)',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         xmlFileName:'/eleasing/jsp/query/contract_qizu_query.xml',
         loadMode:'ajax',
         operButtons:' ',
         isPage:true,
         isAutoBreakContent:true,
         isExcel:true,
         //isFit:true,
         params:{
			 user_id:'${sessionScope.loginUser.id}',
         },
         columns:[
                    {header:'合同号',name:'contractid',width:180,queryConfig:{}},
		            {header:'所属区域',name:'ssqy'},
		            {header:'办事处',name:'bansc'},
		            {header:'项目经理',name:'projmanage'},
		            {header:'合同状态',name:'statusname',queryConfig:{}},
		            {header:'经销商',name:'jxs',queryConfig:{}},
		            {header:'承租人',name:'custname',queryConfig:{isNewLine:true}},
		            {header:'是否上牌',name:'shangpai'},
		            {header:'是否抵押',name:'diya'},
		            {header:'设备款',name:'equipamt'},
		            {header:'融资金额',name:'leaseamt'},
		            {header:'起租比例(%)',name:'firstpaymentratio'},
		            {header:'起租租金',name:'firstpayment'},
		            {header:'保证金比例(%)',name:'cautionmoneyratio'},
		            {header:'保证金',name:'cautionmoney'},
		            {header:'手续费比例(%)',name:'handration'},
		            {header:'手续费',name:'handmoney'},
		            {header:'留购价',name:'nominalprice'},
		            {header:'gps费用',name:'gpsmoney'},
		            {header:'信审通过时间',name:'is_pass',isRange:true,type:'date',queryConfig:{}},
		            {header:'首付款',name:'firsttotal'},
		            {header:'最后一笔首付款收款时间',name:'indate'},
		            {header:'最后一次放款时间',name:'outdate'},
		            {header:'放款总金额',name:'outallmoney'},
		            {header:'现汇总额',name:'nowmoney'},
		            {header:'放车额度总额',name:'limitmoney'},
		            {header:'设备台数',name:'equipcount'},
		            {header:'总期数',name:'rentlist'},
		            {header:'月租金',name:'y_rents'},
		            {header:'总租金',name:'rent'},
		            {header:'起租日期',name:'startdate',type:'date',queryConfig:{isNewLine:true}},
		            {header:'保险购买方式',name:'insname'},
		            {header:'剩余保证金',name:'sycaution'}
	        ]
   	 });
   });

</script>

</head>
<body>
	<div id="id_tableContainer"></div>
</body>
</html>