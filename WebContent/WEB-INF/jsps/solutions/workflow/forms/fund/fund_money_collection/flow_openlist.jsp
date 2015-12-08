<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收款</title>
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
	var attachmentParams;
	
	jQuery(function(){
	 var table = new tracywindyOperationTable({
		 tableComment:'[项目信息]',
		 constantFlagTable:'ProjInfo',
		 windowTop:20,
	     border:true,
	     renderTo:'id_ebank',
      title:'项目信息',
      width:parseInt("${param.tableWidth}")||pageWidth,
      height:parseInt("${param.tableHeight}")||pageHeight,
      id:'id_table',
      xmlFileName:'/eleasing/jsp/fund_ebank/fund_ebank_info.xml',
      loadMode:'ajax',
      params:{
				user_id:'${sessionScope.loginUser.id}',
		      	enabled:0,
		      	kehu:'1'
			//cust_id : cust_id
			//parentid:'ProductType'
			},
      isPage:true,
      operButtons:' ',
      isFit:true,
      tools:[{
     	 html : '<font color="red">收款</font>',
		 handler : function(table) {
				var projIDValue = table.getCheckedRowDatas();
				if (0 == projIDValue.length) {
					alert("请选择需要启动的流程！");
					return false;
				}
			
				var cur_depid="${sessionScope['loginUserDeptObj'].id}"; 
				attachmentParams = attachmentParams + "&ebank_id=" +projIDValue[0].id +"&cur_depid="+cur_depid+"&custdealername="+projIDValue[0].custname;
				startProcess("经销商资金收款-1", attachmentParams);
			},
			iconCls :'icon-update'
          }],
          columns:[
                   {header:'id',name:'id',hidden:true},
                   {header:'custdealerid',name:'custdealerid',hidden:true},
		            {header:'网银编号',name:'ebdataid',queryConfig:{}},
		            {header:'经销商',name:'custname',queryConfig:{}},
		            {header:'付款人',name:'clientname',queryConfig:{}},
		            {header:'本方银行',name:'ownbank',hidden:true},
		            {header:'本方账户',name:'ownaccount',hidden:true},
		            {header:'本方账号',name:'ownaccnumber',hidden:true},
		            {header:'对方银行',name:'clientbank',hidden:true},
		            {header:'对方账户',name:'clientaccount',hidden:true},
		            {header:'对方账号',name:'clientaccnumber',hidden:true},
		            {header:'到账金额类型',name:'moneytype',hidden:true},
		            {header:'到账金额',name:'factmoney',queryConfig:{isNewLine : true}},
		            //{header:'与系统无关金额',name:'nowithmoney'},
		            {header:'已核销金额',name:'hiremoney'},
		            {header:'可核销金额',name:'owmoney'},
		            {header:'到账时间',name:'factdate'},
		            {header:'流水号',name:'sn'},
		            {header:'备注',name:'summary'}
		            //{header:'登记人',name:'creator_name'},
		            //{header:'登记时间',name:'create_date'}
	        ]
	 });
});
	/*
	jQuery(function(){
	   	 new tracywindyOperationTable({
	         displayToggleContainer:'ebank',
	   		 tableComment:'[网银信息]',
	   		 constantFlagTable:'fundebank',
	   		 windowTop:20,
	   	     border:true,
	         renderTo:'id_ebank',
	         //title:'网银信息',
	         width:parseInt("${param.tableWidth}")||pageWidth,
     		 height:parseInt("${param.tableHeight}")||pageHeight,
	         id:'table_ebank',
	        
	         loadMode:'ajax',
	         isPage:true,
	         operButtons:' ',
	         isFit:true,
	         operButtons:' ',
	         //params : param_,
	         tools:[{
	         	 html : '<font color="red">收款</font>',
	 			handler : function(table) {
	 				var projIDValue = table.getCheckedRowDatas();
	 				if (0 == projIDValue.length) {
	 					alert("请选择需要的网银");
	 					return false;
	 				}
	 				
	 				attachmentParams = attachmentParams + "&ebank_id=" +projIDValue[0].id ;
		 			startProcess("收款流程-1",attachmentParams);
	 
	 			},
	 			iconCls :'icon-update'
	           }],
	         isFit:false,
	         columns:[
	                    {header:'id',name:'id',hidden:true},
	                    {header:'custdealerid',name:'custdealerid',hidden:true},
			            {header:'网银编号',name:'ebdataid'},
			            {header:'经销商',name:'custname'},
			            {header:'付款人',name:'clientname'},
			            {header:'本方银行',name:'ownbank',hidden:true},
			            {header:'本方账户',name:'ownaccount',hidden:true},
			            {header:'本方账号',name:'ownaccnumber',hidden:true},
			            {header:'对方银行',name:'clientbank',hidden:true},
			            {header:'对方账户',name:'clientaccount',hidden:true},
			            {header:'对方账号',name:'clientaccnumber',hidden:true},
			            {header:'到账金额类型',name:'moneytype',hidden:true},
			            {header:'到账金额',name:'factmoney'},
			            //{header:'与系统无关金额',name:'nowithmoney'},
			            {header:'已核销金额',name:'hiremoney'},
			            {header:'可核销金额',name:'owmoney'},
			            {header:'到账时间',name:'factdate'},
			            {header:'流水号',name:'sn'},
			            {header:'备注',name:'summary',hidden:true}
			            //{header:'登记人',name:'creator_name'},
			            //{header:'登记时间',name:'create_date'}
		        ]
	   	 });
	   });
	*/
 </script>
 

</head>
<body>
<div id="id_ebank"></div>
    <div id="id_tableContainer"></div>
	    <div id="ebank" style="display: none;overflow:hidden;" title="选择网银">
	    	
    </div>
	<script type='text/javascript'>
	    var ebankDom =document.getElementById("ebank");
	    //ebankDom.style.height= ((parseInt("${param.tableHeight}")||pageHeight) - 100)+"px";
	</script>
</body>
</html>