<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租赁业务  - 客户信息生成</title>
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
    function importEbankCallBack(message){
        alert(message);
    	window.currentImportExcelLoadMask.hide();
    	var table = getTracywindyObject("id_table");
    	table.reload();
    }
    var constantFlagTable = "bankdownlist";
    var ebankUploadUrl="";
    var ebankAttachUrl="";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var tableebank = new tracywindyOperationTable({

   		 tableComment:'[客户功能下载]',
   		// constantFlagTable:'fundebank',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'客户功能下载',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/fund_customerdown/customerdown2.xml',
         loadMode:'ajax',
         isPage:true,
         isExcel:true,
         isFit:true,
         //checkType:'checkbox',
         operButtons:'',
         /* completeCallBack : function(){
        	 console.info(this);
        	 var table = this;
        	 var data =table.tableData;
        	 var dateTmp = [];
        	 var levelRent = 50000;
        	 
        	 if(data){
	        	 for(var i = 0 ; i < data.length; i++){
	        		 if(parseFloat(data[i]['ovrent']) > levelRent){
	        			 var dataObject = jQuery.extend(true, {}, data[i]);
	        			
	        			 dataObject['ovrent'] =levelRent;
	        			 
	        			 var time =Math.floor(parseFloat(data[i]['ovrent']) / levelRent);
	        			 
	        			 for ( var int = 0; int < time; int++) {
	        				 dateTmp.push(dataObject);
						 }
	        			 var dataObject1 = jQuery.extend(true, {}, data[i]);
	        			 dataObject1['ovrent'] = parseFloat(data[i]['ovrent']) - (time * levelRent);
	        			 
	        			 dateTmp.push(dataObject1);
	        		 } else{
	        			 dateTmp.push(data[i]);
	        		 }
	        	 }
        	 }
        	 
        	this.tableData = dateTmp;
        	console.info(dateTmp);
        	 
        	 
         }, */
         tools:[{
        	    iconCls:'icon-import',
        	    html:'<font color="red">客户导出</font>',
        	    handler:function(table){
        	    	//var params = getQueryAreaParams(table,false);
        	    	var url="/leasing/template/createFileByTemplateClass.action";
        	    	var curdate=getCurDateTime();
        	    	var fileparames={url:url,dateInitMethod:'customerHire',title:"客户导出",twoClassify:'wordtempletypetwo.47',returnType:'file',modelname:'wordtempletypetwo.47',contract_status:21,cust_export_status:'0'};
        	       /*  for(var p in params){
        	        	alert(params[p]);
            	        if(params[p]!=""){
        	        	   fileparames[p]=params[p];
            	        }
            	    } */
        	        attachmentDown(fileparames); 
        	    }
        	 }
        	 ],
         columns:[//custNumber[客户编号],custname[客户名],brithdate[出生日期],homeadd[家庭地址],sexName[性别名],
                    {header:'id',name:'id',hidden:true},
		            {header:'客户编号',name:'custnumber',queryConfig:{}},
		            //{header:'合同状态',name:'contractstatusname'},
		            {header:'客户名',name:'custname'},
		            {header:'出生日期',name:'brithdate'},//type:"date",isRange:true,queryConfig:{width:250}}, 
		            {header:'性别',name:'sexname'},//contractnumber[合同号],dealer[经销商名称]
		            {header:'家庭地址',name:'homeadd'},
		            {header:'经销商名称',name:'dealer'},
		            {header:'合同号',name:'contractnumber'},
		            {header:'导出状态',name:'custexportstatus'},
		            {header:'客户名',name:'custnameall',queryConfig:{}}
	        ],
	        params:{
	        	cust_export_status:'0',
	        	contract_status:21
		   } 
   	 });
   });

</script>
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>