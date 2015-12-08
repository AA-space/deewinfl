<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实际投放</title>
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
		 tableComment:'[项目信息]',
		 constantFlagTable:'ProjInfo',
		 windowTop:20,
	     border:true,
      renderTo:'id_tableContainer',
      title:'项目信息',
      width:parseInt("${param.tableWidth}")||pageWidth,
      height:parseInt("${param.tableHeight}")||pageHeight,
      id:'id_table',
      xmlFileName:'\\eleasing\\workflow\\contract\\payequipment_flowopen_list.xml',
      loadMode:'ajax',
      params:{
      	CONTRACT_STATUS_LessThan : 100, 
      	CONTRACT_STATUS_GreaterThan : 30,
      	userId:'${sessionScope.loginUser.id}'
       },
      isPage:true,
      operButtons:' ',
      isFit:false,
      tools:[{
     	 html : '<font color="red">投放</font>',
			handler : function(table) {
				var projIDValue = table.getCheckedRowDatas();
				if (0 == projIDValue.length) {
					alert("请选择需要启动的流程！");
					return false;
				}
				//attachmentParams = "cust_id="+projIDValue[0].custid+"&contract_id=" + projIDValue[0].id ;
		     	//startProcess("实际投放流程-1",attachmentParams);
		     	
				var url = "${pageContext.request.contextPath}/leasing/checkContractOnhireStart.action";
 				var params = {contract_id:projIDValue[0]["id"]};
 				 ajaxRequest({
 			    	 method:'POST',
 			         url:url,
 			         async:false,
 			         params:params,
 			         failure:function(res){},
 			         success:function(res){
 			 	   		res=res.responseText;
 			 	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
 			     	    if(res != ''){
 			     	    	var rs=JsonUtil.decode(res);
 			     	    	//alert(rs['result']);
 	 			     	    if(rs['result'] == '-5'){
								alert("首付款没收完");
							}else if(rs['result'] == '-4'){
								alert("GPS没有安装");
							}
							/* else if(rs['result'] == 'equipAmt_lt'){
								alert("已投放完毕！");
							} */
							else{
								attachmentParams = "cust_id="+projIDValue[0].custid+"&contract_id=" + projIDValue[0].id ;
 	 					     	startProcess("实际投放流程-1",attachmentParams);
 	 	 	 			    }
 	 			     	 table.reload(); 
 			     	    }else{
 			     	    	
 			     	    }
 			         }
 			    });
		     	
		     	
			},
			iconCls :'icon-update'
          }],
      columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'proj_id',name:'proj_id',hidden:true},
		            {header:'pid',name:'pid',hidden:true},
		            {header:'custid',name:'custid',hidden:true},
		            {header:'typecode',name:'typecode',hidden:true},
		            {header:'合同编号',name:'contractid',queryConfig:{}},
		            {header:'业务合同号',name:'contractnumber',width:150,queryConfig:{}},
		            {header:'项目名称',name:'projname',width:300,queryConfig:{}},
		            {header:'客户名称',name:'custname',queryConfig:{isNewLine:true}},
		            {header:'经销商名称',name:'custdealer',queryConfig:{}},
		            {header:'业务类别',name:'businesstype'},
		            {header:'业务模式',name:'businessmode'},
		            {header:'区域',name:'ownerdistrict'},
		            {header:'应付设备款',name:'planmoney',type:'number'},
		            {header:'设备验收日期',name:'acceptdate'},
		            {header:'已付设备款',name:'factmoney',type:'number'},
		            {header:'未付设备款',name:'lastmoney',type:'number'},
		            {header:'活动类型',name:'projtype'},
		            {header:'项目来源',name:'projsource'},
		            //{header:'项目规模',name:'projscale'},
		            {header:'租赁形式',name:'leasform'},
		            {header:'客户经理',name:'projmanage'}
      ]
	 });
});
 </script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>