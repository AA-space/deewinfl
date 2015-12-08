<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GPS信息管理</title>
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
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		 tableComment:'[信息管理]',
   		 constantFlagTable:'GPSInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'信息管理',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/other/insurance_manage/list.xml',
         loadMode:'ajax',
         params:{
		  user_id:'${sessionScope.loginUser.id}',
		  //增加显示 已合同审批的过滤掉（判断项目和合同金额）
		  cApproval:"1" ,
			  total:1
	     },
         isPage:true,
         operButtons:' ',
         isFit:true,
         isAutoBreakContent:true,
         tools:[{
        	 html : '<font color="red">信息管理</font>',
 			 handler : function(table) {
 				var contractIDValue = table.getCheckedRowDatas();
 				if (0 == contractIDValue.length) {
 					alert("请选择需要启动的流程！");
 					return false;
 				}
 			     var attachmentParams = "cont_id=" + contractIDValue[0]["contid"];
				 startProcess("信息管理-1",attachmentParams);
				},
				iconCls : 'icon-update'
			},
            {
				isHtml : true,
				html : '选择显示GPS信息：'
		     }
		     ,{
				isHtml : true,
				html : '<div id="id_flow_name" style="float:left;"></div>'
			 } 
         ],
			columns : [ 
					{header:'合同contid',name:'contid',hidden:true},
					{header:'合同编号',name:'contractid',queryConfig:{}},
					{header:'合同号',name:'contractnumber',queryConfig:{}},
					{header:'客户名称id',name:'custid',hidden:true},
					{header:'客户名称',name:'custname',queryConfig:{}},
					{header:'经销商id',name:'delarid',hidden:true},
					{header:'经销商',name:'dealername',queryConfig:{}},
					//{header:'租赁物id',name:'equipid',hidden:true},
					{header:'租赁物台数',name:'equipnum'}
				
			  ]
		});
   	 var combo_type = new tracywindyComboBox({
			id : 'id_combo_flow_name',
			width : 200,
			renderTo : 'id_flow_name',
			loadMode : 'local',
			readOnly : false,
			isAjaxLenovo : true,
			isContainEmpty : false,
			dropListHeight : 300,
			topAdd : 0,
			leftAdd : 0,
			positionDropIconLeftAdd : -1,
			value:'1',
			name : 'flow_name',
			displayField : 'name',
			valueField : 'value',
			datas : [{
				name : 'GPS信息合同',value : '1'
			    }
		       ,{
				name : '全部合同',value : ''
			}],
			onSelect : function(combo) 
			{
				var table = getTracywindyObject('id_table');
				if(combo.getValue()=='1'){
					table.setParams({total: combo.getValue()});
		            table.reload();
				}else{
					table.setParams({total:''});
		            table.reload();
				}
				
			}
		});
   	 
	});
</script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>