<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测算表生成</title>
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
   		 tableComment:'[测算信息]',
   		 constantFlagTable:'ProjInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'测算信息',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'\\eleasing\\jsp\\fund_bankcarddown\\rent_calc_list.xml',
         loadMode:'ajax',
         params:{
   			user_id:'${sessionScope.loginUser.id}',
   			loginuser:"${sessionScope['login_userid']}",
   			CONTRACT_STATUS_LessThan : '100', 
   			CONTRACT_STATUS_GreaterThan : '21'
   			//work_flag : '0'
	     },
         isPage:true,
         operButtons:' ',
         isFit:false,
         isExcel:true,
         isAutoBreakContent:true,
         tools:[{
        	 html : '<font color="red">生成测算表</font>',
 			handler : function(table) {
 				var projIDValue = table.getCheckedRowDatas();
 				if (0 == projIDValue.length) {
 					alert("请选择需要生成测算的项目！");
 					return false;
 				}
 				
 				var attachmentParams = "contract_id=" + projIDValue[0]["id"]+"&cust_id="+projIDValue[0]["custid"];
 				var url="/leasing/template/createFileByTemplateClass.action";
 			    //var filename='table_projcreditreport';
 			    var custname=projIDValue[0]["contractnumber"]+"-"+projIDValue[0]["custdealer"]+"-"+projIDValue[0]["custname"]+'租金测算表.xls';
 				var parames=[];
 			    parames.push({filename:custname});
 			    attachmentDown({uploadid:"",url:url,title:"",twoClassify:'wordtempletypetwo.55',returnType:'file',modelname:'rentcalculate',contractid:projIDValue[0]["id"],parames:parames});
 			 
 				
 	
 			},
 			iconCls :'icon-update'
             }],
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'custid',name:'custid',hidden:true},
		            {header:'项目编号',name:'projid'},
		            {header:'合同编号',name:'contractid'},
		            {header:'合同号',name:'contractnumber',width:200,queryConfig:{}},
		            {header:'合同状态',name:'contractstatus'},
		            {header:'客户名称',name:'custname',width:150,queryConfig:{}},
		            {header:'经销商名称',name:'custdealer',queryConfig:{isNewLine:true}},
		            {header:'业务类别',name:'businesstype'},
		            {header:'业务模式',name:'businessmode'},
		            {header:'区域',name:'district'},
		            {header:'合同金额',name:'contractmoney'},
		            {header:'合同起租日',name:'acceptdate',type:'date',isRange:true,queryConfig:{}}
         ]
   	 });
   });
	
 </script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>