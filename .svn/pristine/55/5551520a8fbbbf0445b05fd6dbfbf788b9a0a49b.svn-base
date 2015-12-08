<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同租金计划报表(项目经理专用)</title>
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
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({   		 
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'合同租金计划报表(项目经理专用)',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         xmlFileName:'/eleasing/jsp/query/contract_rentjh_query.xml',
         loadMode:'ajax',
         operButtons:' ',
         isPage:true,
         isAutoBreakContent:true,
         isExcel:true,
         //isFit:true,
         params:{
			 user_id:'${sessionScope.loginUser.id}',
         },
         columns:[
                    {header:'区域',name:'qy'},
		            {header:'办事处',name:'bsc'},
		            {header:'原始合同号',name:'contract_number',queryConfig:{}},
		            {header:'经销商',name:'proj_dept',queryConfig:{}},
		            {header:'项目经理',name:'proj_manage'},//,queryConfig:{isNewLine:true}
		            {header:'客户名称',name:'cust_name',queryConfig:{}},
		            {header:'计划期项',name:'rent_list'},
		            {header:'计划日期',name:'plan_date',type:'date',queryConfig:{isNewLine:true}},
		            {header:'租金',name:'rent'},
		            {header:'本金',name:'corpus'},
		            {header:'利息',name:'interest'},
		            {header:'实收租金',name:'income_rent'},
		            {header:'实收本金',name:'income_corpus'},
		            {header:'实收利息',name:'income_interest'},
		            {header:'剩余租金',name:'s_rent',queryConfig:{}},
		            {header:'剩余本金',name:'s_corpus',queryConfig:{}},
		            {header:'剩余利息',name:'s_interest'},
		            {header:'应收罚息',name:'penalty'},
		            {header:'实收罚息',name:'income_penalty'},
		            {header:'免罚息值',name:'penaltyadjust'},
		            {header:'剩余罚息',name:'s_penalty',queryConfig:{isNewLine:true}},
		            {header:'是否卡扣',name:'iscard',queryConfig:{}},
		            {header:'是否诉讼',name:'susong',queryConfig:{}}
		            
	        ]
   	 });
   });

</script>

</head>
<body>
	<div id="id_tableContainer"></div>
</body>
</html>