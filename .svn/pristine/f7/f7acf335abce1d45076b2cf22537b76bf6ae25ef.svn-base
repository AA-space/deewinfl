<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同信息查询</title>
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
//流程历史信息
function viewProjSummary(keyOne){
    var URL = "${pageContext.request.contextPath}/jbpm/getProjSummaryHistoryInfos.action?keyOne="+keyOne;
    openFullScreenWindow(URL);
}
function viewShowCondition(contractId){
	var URL = "${pageContext.request.contextPath}/leasing/selectContractCondition.action?contractid="+contractId;
    openFullScreenWindow(URL);
}
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({   		 
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'合同信息查询',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         xmlFileName:'/eleasing/jsp/query/contract_info_query.xml',
         loadMode:'ajax',
         operButtons:' ',
         lazyLoad:true,
         isPage:true,
         isAutoBreakContent:true,
         isExcel:true,
         //isFit:true,
         columns:[
                    {header:'合同主键',name:'cid',hidden:true},
		            {header:'项目编号',name:'projid',queryConfig:{},
		            	renderer:function(value,tableObj,columnName,columnIndex,rowData){
		                return "<a href='javascript:void(0);' onclick='viewProjSummary(\""+rowData["projid"]+"\")'>"+value+"</a>";
		    	       }
			         },
		            {header:'项目名称',name:'projectname',queryConfig:{},width:300},
		            {header:'合同编号',name:'contractid',queryConfig:{},
		            	renderer:function(value,tableObj,columnName,columnIndex,rowData){
		                return "<a href='javascript:void(0);' onclick='viewProjSummary(\""+rowData["contractid"]+"\")'>"+value+"</a>";
		    	       }
		    	     },
		    	     {header:'业务合同号',name:'contractnumber',queryConfig:{}},
		            {header:'承租单位',name:'custname',queryConfig:{isNewLine:true}},
		            {header:'经销商',name:'custdealer'},
		            {header:'合同状态',name:'contractstatusname',queryConfig:{}},
		            {header:'项目规模',name:'projscalename'},
		            {header:'是否第三方支付',name:'isthirdpay'},
		            {header:'租赁形式',name:'leastypename'},
		            {header:'业务类型',name:'businesstypename'},
		            {header:'业务模式',name:'businessmodename'},
		            {header:'客户经理',name:'projmanagename'},
		            //{header:'客户助理',name:'projassistname'},
		            {header:'起租日期',name:'acceptdate',queryConfig:{}},//,type:'date'
		            {header:'合同结束日期(财务 )',name:'processend'},//,type:'date'
		            {header:'项目出单部门',name:'projdeptname',width:200},
		            {header:'操作',name:'assurors',
		            	renderer:function(value,tableObj,columnName,columnIndex,rowData){
		                return "<a href='javascript:void(0);' onclick='viewShowCondition(\""+rowData["cid"]+"\")'>当前商务条件查看</a>";
		    	       }
			        }
	        ]
   	 });
   });

</script>

</head>
<body>
	<div id="id_tableContainer"></div>
</body>
</html>