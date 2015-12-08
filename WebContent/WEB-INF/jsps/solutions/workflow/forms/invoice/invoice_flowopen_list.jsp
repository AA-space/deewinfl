<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>维护发票信息</title>
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
	   html,body{ overflow:hidden;}
	</style>
<script type="text/javascript"> 
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		 tableComment:'[维护发票信息]',
   		 constantFlagTable:'ProjInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'维护发票信息',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/workflow/invoice/invoice_flowopen_list.xml',
         loadMode:'ajax',
         params:{
   			  
 			 cust_dealer_id:"${sessionScope['currentDealerCustInfoId']}"
          },
         isPage:true,
         isAutoBreakContent:true,
         operButtons:' ',
         isFit:false,
         tools:[{
 			 iconCls :'icon-update',
        	 html : '<font color="red">维护发票信息</font>',
 			 handler : function(table) {
 				var projIDValue = table.getCheckedRowDatas();
 				if (0 == projIDValue.length) {
 					alert("请选择需要启动的流程！");
 					return false;
 				}
				var attachmentParams = "contract_id=" + projIDValue[0]["id"];
				startProcess("维护发票信息流程-1",attachmentParams);
			    table.reload();
 			},
           }],
         columns:[
		            {header:'id',name:'id',hidden: true},
		            {header:'custid',name:'custid',hidden:true},
		            {header:'合同号',name:'contract_number',queryConfig:{}},
		            {header:'客户名',name:'custname',queryConfig:{}},
		            {header:'项目名称',name:'projectname',width:300,queryConfig:{}},
		            {header:'纳税人类别',name:'taxlevel'},
		            {header:'项目状态',name:'statusname'},
		            {header:'经销商',name:'custdealer',queryConfig:{isNewLine:true}},
		            {header:'立项结束时间',name:'enddate'},
		            {header:'项目经理',name:'projmanage'}, 
		            {header:'项目出单部门',name:'projdept',width:250}
         ]
   	 });
   });
</script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>