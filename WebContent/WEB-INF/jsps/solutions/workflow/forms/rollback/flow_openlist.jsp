<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租后管理-调息回滚</title>
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
   		 tableComment:'[央行调息回滚]',
   		 constantFlagTable:'ProjInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'回滚',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'\\eleasing\\workflow\\money_rate\\central_bank_money_rate_rollback_list.xml',
         loadMode:'ajax',
         params:{
   			user_id:'${sessionScope.loginUser.id}',
   			CONTRACT_STATUS_LessThan : '30', CONTRACT_STATUS_GreaterThan : '20'
	     },
         isPage:true,
         operButtons:' ',
         isFit:false,
         pageSize:1,
         isAutoBreakContent:true,
         tools:[{
        	 html : '<font color="red">回滚</font>',
 			handler : function(table) {
 				var projIDValue = table.getCheckedRowDatas();
 				if (0 == projIDValue.length) {
 					alert("请选择需要启动的流程！");
 					return false;
 				}
				var attachmentParams = "id=" + projIDValue[0]["id"];
 				startProcess("调息回滚流程-1",attachmentParams);
 			},
 			iconCls :'icon-update'
             }],
         columns:[
                  {header:'id',name:'id',hidden:true},
		            {header:'利率开始执行日期',name:'statrdate',type:'date',queryConfig:{}},
		            {header:'利息调整幅度_六月',name:'ratehalf'},
		            {header:'利息调整幅度_1年',name:'rateone'},
		            {header:'利息调整幅度_3年',name:'ratethree'},
		            {header:'利息调整幅度_5年',name:'ratefive',queryConfig:{}},
		            {header:'利息调整幅度_5年以上',name:'rateabovefive'},
		            {header:'利息央行基准_六月',name:'baseratehalf'},
		            {header:'利息央行基准_1年',name:'baserateone'},
		            {header:'利息央行基准_3年',name:'baseratethree'},
		            {header:'利息央行基准_5年',name:'baseratefive'},
		            {header:'利息央行基准_5年以上',name:'baserateabovefive'},
		            {header:'是否调息结束',name:'isclose'},
		            {header:'创建人',name:'creator'},
		            {header:'创建时间',name:'createdate',width:150},
		            {header:'修改人',name:'modificator'},
		            {header:'修改时间',name:'modifydate',width:150}
       ]
   	 });
   	
   });
	
 </script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>