<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投放额度申请</title>
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
	var param={};
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	
	var attachmentParams;
	jQuery(function(){
		var table = new tracywindyOperationTable({
			 tableComment:'信息 ',
	   		 constantFlagTable:'Info111',
	         renderTo:'id_tableContainer',
	         title:'合同额度申请信息 ',
	         width:pageWidth,
	         height:pageHeight,
	         id:'id_table',
	         xmlFileName:'\\eleasing\\workflow\\contract\\fund_limit_app_flowopen_list.xml',
	         loadMode:'ajax',
	         isPage:true,
	         isFit:true,
	         operButtons:' ',
	         border:true,
	         params:{
	           	userId:'${sessionScope.loginUser.id}'
	            },
	         tools:[{
	         	 html : '<font color="red">额度申请</font>',
	    			handler : function(table) {
	    				var projIDValue = table.getCheckedRowDatas();
	    			
	    				attachmentParams = "";
	    		     	startProcess("合同投放额度申请流程-1",attachmentParams);
	    			},
	    			iconCls :'icon-update'
	              }],
	         isRank:true,
	         columns:[
			            {header:'id',name:'id',hidden:true},
			            {header:'客户名称',name:'custname',queryConfig:{}},
			            {header:'经销商名称',name:'dealername'},
			            {header:'合同业务编号',name:'contractnumber',queryConfig:{}},
			            {header:'合同编号',name:'contractid',queryConfig:{}},
			            {header:'额度金额',name:'limitmoney'},
			            {header:'设备款',name:'pmoney'}
	      ]
         
   	 });
	   	 

  
      
});
 </script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>