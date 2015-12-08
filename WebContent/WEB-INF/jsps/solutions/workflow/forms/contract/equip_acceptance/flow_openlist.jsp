<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同管理-设备验收</title>
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
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		 tableComment:'[设备验收]',
   		 constantFlagTable:'ProjInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'设备验收',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'\\eleasing\\workflow\\contract\\contractEquipAcceptance_flow_list.xml',
         loadMode:'ajax',
         params:{
   			district:'${sessionScope.loginUser.id}',
   			loginuser:"${sessionScope['login_userid']}",
   			CONTRACT_STATUS_LessThan:'22',//显示状态为22 已经设备验收的，但不能发起流程
   			CONTRACT_STATUS_GreaterThan:'20'
	     },
         isPage:true,
         operButtons:' ',
         isFit:false,
         isAutoBreakContent:true,
         tools:[{
        	 html : '<font color="red">设备验收</font>',
 			 handler : function(table) {
 				var projIDValue = table.getCheckedRowDatas();
 				if (0 == projIDValue.length) {
 					alert("请选择需要启动的流程！");
 					return false;
 				}
 				if (projIDValue[0]["contractstatus"]=='设备验收') {
 					alert("已经设备验收,不能再发起！");
 					return false;
 				}
 				//判断资金首付款 是否 已收完
                //if(!checkFirstMoney(projIDValue[0]["id"]))
                // {return false;}
               
				var attachmentParams = "contract_id=" + projIDValue[0]["id"]+"&cust_id="+projIDValue[0]["custid"];
 				startProcess("设备验收流程-1",attachmentParams);
 			 },
 			 iconCls :'icon-update'
             }],
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'custid',name:'custid',hidden:true},
		            {header:'项目编号',name:'projid',queryConfig:{}},
		            {header:'合同编号',name:'contractid',queryConfig:{}},
		            {header:'业务合同号',name:'contractnumber',width:150,queryConfig:{}},
		            {header:'合同状态',name:'contractstatus'},
		            {header:'客户名称',name:'custname',width:150,queryConfig:{isNewLine : true}},
		            {header:'经销商名称',name:'custdealer',width:180,queryConfig:{}},
		            {header:'业务类别',name:'businesstype'},
		            {header:'业务模式',name:'businessmode'},
		            {header:'区域',name:'district'},
		            {header:'合同金额',name:'contractmoney'}
         ]
   	 });
   });

	function checkFirstMoney(contract_id){
		//loadMask_oper.show();
		var isSubmit = false;
		 var param={};
		 param.contract_id=contract_id;
		 ajaxRequest({
  		     url:'${pageContext.request.contextPath}/leasing/checkMoney/checkMoney.action',
  		     method:'POST',
  		     success:function(res){
  	   		    var svote=res.responseText;
  	   		    svote=svote.replace(/(^\s+)|(\s+$)/g, ""); 
  	   		    //loadMask_oper.hide();
  	   		    if(svote==""){
	  	   		    //jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>后台没有返回！</div>",'error');
	  	   		    isSubmit = true;
  	   		    }else{
  	   		        jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>首付款没有付清！</div>",'error');
  	   		        isSubmit = false;
  	   	   		}
  		     },
  		     async:false,
  		     failure:function(res){},
  		     params:param
		 });
		 return isSubmit;
		}
	
 </script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>