<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同管理-合同变更</title>
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
 //var proj_id="<%= request.getParameter("id")%>";
   var param={};
   //if(proj_id!="null" || proj_id==""){param.proj_id=proj_id;}
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		 tableComment:'[项目信息]',
   		 constantFlagTable:'ProjInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'项目信息',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'\\eleasing\\workflow\\contract\\contractCommon_flowopen_list.xml',
         loadMode:'ajax',
         params:{
   		    custdealerid:'${sessionScope["currentDealerCustInfoId"]}'
	     },
         isPage:true,
         operButtons:' ',
         isFit:true,
         isAutoBreakContent:true,
         tools:[{
        	 html : '<font color="red">抵押备案</font>',
 			handler : function(table) {
 				var projIDValue = table.getCheckedRowDatas();
 				if (0 == projIDValue.length) {
 					alert("请选择需要启动的流程！");
 					return false;
 				}
				var attachmentParams = "id=" + projIDValue[0]["id"];
 				startProcess("抵押备案信息-1",attachmentParams);
 			},
 			iconCls :'icon-update'
             }],
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'客户名称',name:'custname',width:150,queryConfig:{}},
		            {header:'经销商名称',name:'custdealer',queryConfig:{}},
		            {header:'合同编号',name:'contractnumber',queryConfig:{}},
		            {header:'项目名称',name:'projname',width:400,queryConfig:{isNewLine:true}}
         ]
   	 });
   });
	
 </script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>