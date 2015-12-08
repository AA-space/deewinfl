<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目立项清单</title>
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
   		 tableComment:'[项目立项清单]',
   		 constantFlagTable:'ProjInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'项目立项清单',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'\\eleasing\\workflow\\proj_change\\proj_approval_info_list.xml',
         loadMode:'ajax',
         params:{
			//WORK_FLAG : 0
			 user_id:'${sessionScope.loginUser.id}',
			 queryText:unescape(decodeURIComponent("${param.queryText}"))
         },
         isPage:true,
         operButtons:' ',
         isFit: true,
         isAutoBreakContent:true,
         tools:[{
        	 html : '<font color="red">项目立项</font>',
        	 iconCls :'icon-update',
 			 handler : function(table){
 				var projIDValue = table.getCheckedRowDatas();
 				if (0 == projIDValue.length) {
 					alert("请选择需要启动的流程！");
 					return false;
 				}
 			  var custid=projIDValue[0]["custid"];
 			  var dealerstauts=projIDValue[0]["dealerstauts"];
 			  var dealer=projIDValue[0]["dealer"];
 			  var twolevelstatus=projIDValue[0]["twolevelstatus"];
 			  var deptid=projIDValue[0]["deptid"];
				if (!custid) {
					alert("请选择承租人!");
					return false;
				}else if(dealerstauts=="0"){
					alert("【"+dealer+"】已暂停立项业务,请与信审专员联系!");
					return false;
				}else {
						 var typecode = 'bussiness_type_car';
						 var modecode = 'bussiness_mode_cust';
					     var attachmentParams="&cust_id="+custid + "&typecode=" +typecode + "&modecode=" + modecode+ "&twolevelstatus=" + twolevelstatus+ "&dealer=" + dealer+ "&deptid=" + deptid;
					      startProcess("项目立项流程-1",attachmentParams);
					     return true;
				    }
				}  
 			},'-',{
        	  isHtml:true,
     	      html:'全局搜索：<input type="text" style="margin-right:4px;border:1px solid #DDD;" id="id_queryWorkflowsTableInput" value="'+unescape(decodeURIComponent("${param.queryText}"))+'" />'
         }],
         columns:[
		            {header:'id',name:'custid',hidden:true},
		            {header:'经销商是否暂停',name:'dealerstauts',hidden:true}, 
		            {header:'twolevelstatus_id',name:'twolevelstatus',hidden: true}, 
		            {header:'twolevelstatus_id2',name:'twolevelstatus2',hidden: true}, 
		            {header:'所属一级经销商_id',name:'onelevelname2',hidden: true},  
		            {header:'是否二级经销商',name:'twolevelstatusname',hidden: true}, 
		            {header:'所属一级经销商',name:'onelevelname',hidden: true}, 
		            {header:'登记人部门id',name:'deptid',hidden: true}, 
		            //-----------------------显示列-------------------------------
		            {header:'客户名',name:'custname'},
		            {header:'经销商',name:'dealer'}, 
		            {header:'客户性质',name:'custclass'},
		            {header:'身份证/组织机构代码',name:'orgcodecardno',width:250}, 
		            {header:'纳税人类别',name:'taxlevel'}, 
		            {header:'客户内部行业',name:'custkind'}, 
		            {header:'登记人',name:'regname'}, 
		            {header:'登记人部门',name:'deptname'}
         ]
   	 });
   	jQuery("#id_queryWorkflowsTableInput").keypress(function(e){ 
        var code = e.keyCode||e.charCode;
        if(13 == code){
            var workflowsTable = getTracywindyTable("id_table");
            workflowsTable.setParams({
                   queryText:this.value.toUpperCase()
            });
            workflowsTable.reload();
        }
    });
   	 
 });
	
</script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
	
</body>
</html>