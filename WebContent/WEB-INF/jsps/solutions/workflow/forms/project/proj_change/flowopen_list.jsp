<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目变更清单</title>
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
	<%---
	{header:'项目类型',name:'projtype',type:'combobox',
			            queryConfig:{
						colSpan:3,
						loadMode:'local',
						datas:[{title:'关联',name:'关联'},{title:'非关联',name:'非关联'}],
			            displayField:'title',
			            valueField:'name',
			            defaultValue:1
			        }},
	 --%>
<script type="text/javascript">
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		 tableComment:'[项目变更清单]',
   		 constantFlagTable:'ProjInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'项目变更清单',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'\\eleasing\\workflow\\proj_change\\proj_change_info_list.xml',
         loadMode:'ajax',
         params:{
        	PROJ_STATUS_LessThan : 10,
			PROJ_STATUS_GreaterThan : 0,
			WORK_FLAG : 0,
			cust_dealer_id:"${sessionScope['currentDealerCustInfoId']}",
			 user_id:'${sessionScope.loginUser.id}'
         },
         isPage:true,
         operButtons:' ',
         isFit:false,
         isAutoBreakContent:true,
         tools:[{
        	 html : '<font color="red">项目变更</font>',
 			handler : function(table) {
 				var projIDValue = table.getCheckedRowDatas();
 				if (0 == projIDValue.length) {
 					alert("请选择需要启动的流程！");
 					return false;
 				}
 				//alert(projIDValue[0]["typecode"]+"xxxxxxxxxxxx");
 				//alert(projIDValue[0]["businessmode"]+"cccccccccccc");
				if(projIDValue[0]["typecode"]=="bussiness_type_equip"){
					var attachmentParams = "proj_id=" + projIDValue[0]["id"] + 'projNumber=' + projid;
					 startProcess("设备变更流程-1", attachmentParams);   
				}else if(projIDValue[0]["typecode"]=="bussiness_type_car"){
					var attachmentParams = "proj_id=" + projIDValue[0]["id"];
 				    startProcess("立项变更流程-1",attachmentParams);
				}else{
					var attachmentParams = "proj_id=" + projIDValue[0]["id"];
 				    startProcess("立项变更流程-1",attachmentParams);
				}  
			    
 			},
 			iconCls :'icon-update'
             }],
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'code1',name:'typecode',hidden:true},
		            {header:'code2',name:'modecode',hidden:true},
		            {header:'custid',name:'custid',hidden:true},
		            {header:'业务模式',name:'businessmode',hidden:true},
		            {header:'业务类别',name:'businesstype',hidden:true},
		            {header:'活动类型',name:'projtype',hidden:true},
		            {header:'承租单位',name:'custname',width:250,hidden:true},
		            {header:'项目来源',name:'projsource',hidden:true},
		            {header:'项目规模',name:'projscale',hidden:true},
		            {header:'资产分类',name:'leastype',hidden:true},
		            {header:'是否第三方支付',name:'thirdpay',hidden:true},
		            //-----------------------显示列-------------------------------
		            {header:'项目号',name:'proj_id',queryConfig:{}},
		            {header:'项目名称',name:'projname',width:300,queryConfig:{}},
		            {header:'项目状态',name:'statusname'},
		            {header:'客户名',name:'custname',queryConfig:{}},
		            {header:'经销商',name:'custdealer',queryConfig:{}},
		            {header:'租赁形式',name:'leasform'},
		            {header:'客户性质',name:'custclass'},
		            {header:'身份证/组织机构代码',name:'orgcodecardno',width:250}, 
		            {header:'纳税人类别',name:'taxlevel'},
		            {header:'项目经理',name:'projmanage'}, 
		            {header:'项目助理',name:'projassist'},
		            {header:'项目出单部门',name:'projdept',width:250},
		            {header:'设备款',name:'equipamt'}
         ]
   	 });
   });
	
</script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
	
</body>
</html>