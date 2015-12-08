<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目信审通过合同起租未发起清单</title>
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
   		 tableComment:'[合同撤销清单]',
   		 //constantFlagTable:'ProjInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'合同撤销清单',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/project_manage/proj_credit_cancel_contract_list.xml',
         loadMode:'ajax',
         params:{
         	PROJ_STATUS_LessThan : 15,
 			PROJ_STATUS_GreaterThan : 0,
 			WORK_FLAG : 0,
 			PROJ_CANCEL_FLAG:0,
 			cust_dealer_id:"${sessionScope['currentDealerCustInfoId']}",
 			user_id:'${sessionScope.loginUser.id}'
          },
         isPage:true,
         operButtons:' ',
         isRank:true,
         isCheck:true,
         checkType:'checkbox',
         isFit:true,
         isExcel:true,
         isAutoBreakContent:true,
         tools:[{
        	 html : '<font color="red">合同撤销</font>',
 			handler : function(table) {
 				if(confirm("合同撤销后不能发起合同审批！")){
 				}else{
 					return false;
 				}
 				var projIDValue = table.getCheckedRowDatas();
 				if (0 == projIDValue.length) {
 					alert("请选择需要启动的流程！");
 					return false;
 				}
 				debugger;
 				var params =[];
 				var data={};
 				for (var i=0;i<projIDValue.length;i++){
 					data.proj_id=projIDValue[i].id;
 					data.proj_status=projIDValue[i].proj_status;
 					data.dbid=projIDValue[i].dbid;
 					params.push(data)
 				}
				debugger;
// 				data :{datas:mini.encode(params)},
// 				dataType : 'json',
				objdata = {};
				objdata.datas = JsonUtil.encode(params);
				var url = getRootPath()+"/leasing/updateContractCancel.action";
 			    ajaxRequest({
						type : "post", //post|get
						url : url, //  getRootPath()+"/leasing/getAsyncCheckData.acl";
						params :objdata,
						success : function( res ) {
							//res = res.responseText;
				 	   		//res = res.replace(/(^\s+)|(\s+$)/g, "");
				 	   		alert("项目撤销成功");
				 	   	    table.reload();
						}
				    });
				
 			},
 			iconCls :'icon-update'
             }],
         columns:[
					{header:'id',name:'id',hidden:true},
		            {header:'项目名称',name:'project_name'},
		            {header:'合同编号',name:'contract_number'},
		            {header:'项目状态',name:'proj_status'},
		            {header:'客户名',name:'custname',queryConfig:{}},
		            {header:'经销商',name:'dealername',queryConfig:{}},
		            {header:'信审通过时间',name:'proj_credit_pass_time',type:'date',isRange : true,queryConfig:{isNewLine:true}},
         ]
   	 });
   });
	
 </script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
	
</body>
</html>