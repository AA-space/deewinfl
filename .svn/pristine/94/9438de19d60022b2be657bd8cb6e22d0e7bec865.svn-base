<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建流程</title>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
    <style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	   .picItem{
	      float:left;
	      padding:5px 5px 5px 5px;
	      border:1px solid silver;
	   }
	</style>

<script type="text/javascript">
jQuery(function(){

    var all_width = document.body.clientWidth;
	var all_height = document.body.clientHeight;
jQuery("#id_menuDetailInfoForm").show();
jQuery("#id_menuDetailInfoForm").window({
	   top:20
 });
jQuery("#id_menuDetailInfoForm").window("open");
var combo_cust = new tracywindyTable({
    id:'id_combo_cust',
    renderTo:'report_credit',
    xmlFileName:'\\eleasing\\jsp\\financing_report\\report_credit.xml',
    loadMode:'ajax',
    isPage:true,
    isFit:true,
    columns:[
	            
	            {header:'id',name:'id',hidden:true},
	            {header:'守信单位',name:'crediter'},
	            {header:'授信品种',name:'credit_money'},
	            {header:'提款金额',name:'currency'},
	            {header:'提款金额(RMB)',name:'currency'},
	            {header:'提款日期',name:'show_title'},
	            {header:'已还本金',name:'credit_used_money'},
	            {header:'已还本金(RMB)',name:'credit_left_money'},
	            {header:'剩余本金',name:'assurer'},
	            {header:'剩余本金(RMB)',name:'bloc_credit'},
	            {header:'币种',name:'crediter_type'},
	            {header:'汇率',name:'show_title'},
	            {header:'利率',name:'credit_used_money'},
	            {header:'利率浮动类型',name:'credit_left_money'},
	            {header:'贷款到期日',name:'assurer'},
	            {header:'贷款期限',name:'bloc_credit'},
	            {header:'剩余期限',name:'crediter_type'},
	            {header:'贷款类型',name:'bloc_credit'},
	            {header:'还款形式',name:'crediter_type'},
	            {header:'还款方式',name:'crediter_type'}
     ],
    params:{
    }
 });
});
</script>
</head>
<body>
	<div id="report_credit"></div>
</body>
</html>