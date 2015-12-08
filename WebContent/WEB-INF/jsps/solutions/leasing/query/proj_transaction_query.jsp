<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目交易结构(项目经理专用)</title>
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
         title:'项目交易结构(项目经理专用)',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         xmlFileName:'/eleasing/jsp/query/proj_transaction_query.xml',
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
		            {header:'项目名称',name:'projname',width:240,queryConfig:{}},
		            {header:'项目编号',name:'pid'},
		            {header:'承租人',name:'ctname'},
		            {header:'项目经理',name:'pmanage'},
		            {header:'客户类别',name:'custclass'},
		            {header:'经销商名称',name:'dname',queryConfig:{}},
		            {header:'融资台数',name:'eqnum'},
		            {header:'设备款',name:'eqamt'},
		            {header:'融资额',name:'lamt'},
		            {header:'起租比例',name:'firstratio'},
		            {header:'年利率',name:'yrate'},
		            {header:'还租次数',name:'inumber'},
		            {header:'租赁期限',name:'lzterm'},
		            {header:'付租类型',name:'ptype'},
		            {header:'付租方式',name:'prdtype'},
		            {header:'保险费',name:'iumoney'},
		            {header:'保险方式',name:'btype'},
		            {header:'gps费用',name:'gpsfeet'},
		            {header:'是否上牌',name:'registration'},
		            {header:'是否抵押',name:'guaranty'},
		            {header:'租金总额',name:'rt'},
		            {header:'第一期租金额',name:'ft'},
		            {header:'保证金比例',name:'cmr'},
		            {header:'手续费比例',name:'hcmr'},
		            {header:'是否发起起合同审批',name:'contractstatus'},
		            {header:'项目状态',name:'pstatus',queryConfig:{}},
		            {header:'担保人',name:'danb'},
		            {header:'合同号',name:'contractnumber'},
		            {header:'信审时间',name:'enddate',isRange:true,type:'date',queryConfig:{isNewLine:true}},
		            {header:'留购价',name:'nominalprice'},
		            {header:'省份',name:'sf',queryConfig:{}},
		            {header:'是否第三方支付',name:'thirdpay'},
		            {header:'运输种类',name:'classtra'},
		            {header:'起租日期',name:'acceptdate'},
		            {header:'车辆类别',name:'equipclass'},
		            {header:'流程操作人',name:'rname'},
		            {header:'操作次数',name:'rcount'},
		            {header:'操作人意见',name:'ad'}
	        ]
   	 });
   });

</script>

</head>
<body>
	<div id="id_tableContainer"></div>
</body>
</html>