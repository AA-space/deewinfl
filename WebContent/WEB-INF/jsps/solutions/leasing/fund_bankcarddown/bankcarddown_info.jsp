<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租赁业务  - 卡扣回笼生成</title>
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

   		 tableComment:'[卡扣回笼下载]',
   		 constantFlagTable:'fundebank',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'卡扣回笼下载',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/fund_bankcarddown/bankcarddown.xml',
         loadMode:'ajax',
         isPage:true,
        // isExcel:true,
         isFit:true,
         //checkType:'checkbox',
         operButtons:'',
         completeCallBack : function(){
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
	        			 var cha =parseFloat(data[i]['ovrent']) - (parseFloat(time) * parseFloat(levelRent));
	        			 dataObject1['ovrent'] = parseFloat(cha).toFixed(2);
	        			 if(parseFloat(dataObject1['ovrent'])>0){
	        				 dateTmp.push(dataObject1);
	        			 }
	        		 } else{
	        			 dateTmp.push(data[i]);
	        		 }
	        	 }
        	 }
        	 
        	this.tableData = dateTmp;
         },
         tools:[{
        	    iconCls:'icon-import',
        	    html:'<font color="red">农行卡扣</font>',
        	    handler:function(table){
        	    	var params = getQueryAreaParams(table,false);
        	    	var url="/leasing/template/createFileByTemplateClass.action";
        	    	var curdate=getCurDateTime();
        	    	var fileparames={url:url,/*custoperatorMethod:'cardHire',*/dateInitMethod:'cardHire',sqlDataCallback:'cardDataCallback',title:"农行卡扣",twoClassify:'wordtempletypetwo19',returnType:'list',modelname:'wordtempletypetwo19',CONTRACT_STATUS_GreaterThan:30,CONTRACT_STATUS_LessThan:100,blankname:'card_hire_bank_agricultural',plandate_end:curdate};
        	        for(var p in params){
            	        if(params[p]!=""){
        	        	   fileparames[p]=params[p];
            	        }
            	    } 
        	        attachmentDown(fileparames); 
        	    }
        	 },{
        	    iconCls:'icon-import',
        	    html:'<font color="red">建行卡扣</font>',
        	    handler:function(table){
        	    	var params = getQueryAreaParams(table,false);
        	    	var curdate=getCurDateTime();
        	    	var url="/leasing/template/createFileByTemplateClass.action";
        	    	var fileparames={url:url,dateInitMethod:'cardHire',sqlDataCallback:'cardDataCallback',title:"建行卡扣",twoClassify:'wordtempletypetwo20',splitField:'ovrent',rangeValue:'50000', returnType:'list',modelname:'wordtempletypetwo20',CONTRACT_STATUS_GreaterThan:30,
        	   				CONTRACT_STATUS_LessThan:100,
        	   				blankname:'card_hire_bank_construction',
        	        		plandate_end:curdate
        	        		};
        	        for(var p in params){
        	        	 if(params[p]!=""){
        	        	    fileparames[p]=params[p];
        	        	 }
            	    }
        	        console.info(fileparames);
        	        attachmentDown(fileparames); 
        	    }
        	 }
        	 /* 
        	  * 通用下载暂时未启用
        	 ,{
        	    iconCls:'icon-import',
        	    html:'<font color="red">通用卡扣</font>',
        	    handler:function(table){
        	    	var params = getQueryAreaParams(table,false);
        	    	var url="/leasing/template/createFileByTemplateClass.action";
        	    	var curdate=getCurDateTime();
        	    	var fileparames={url:url,dateInitMethod:'cardHire',title:"通用卡扣",twoClassify:'wordtempletypetwo21',returnType:'list',modelname:'wordtempletypetwo21',CONTRACT_STATUS_GreaterThan:30,CONTRACT_STATUS_LessThan:100,plandate_end:curdate};
        	        for(var p in params){
        	        	 if(params[p]!=""){ 
        	        	     fileparames[p]=params[p];
        	        	 }
            	    }
        	        attachmentDown(fileparames); 
        	    }
        	 } */
        	 ],
         columns:[
                    {header:'id',name:'id',hidden:true},
		            {header:'合同号',name:'contractnumber'},
		            //{header:'合同状态',name:'contractstatusname'},
		            {header:'导出银行',name:'blankname',type:'combobox',queryConfig:{
		            	xmlFileName:'\\combos\\comboDict.xml',
			 		       loadMode:'ajax',
			 		       isAjaxLenovo:true,    
			 		       width:200,
			 		       name:'blank',
			 		       displayField:'name',
					       valueField:'code',
			 		       readOnly:false,
			 		       params:{
					          pid:'card_hire_bank'
					       }
		            }},
		            {header:'经销商',name:'dealername',queryConfig:{}},
			            /*
		            {header:'客户名称',name:'custname',type:'combobox',queryConfig:{
		            	isNewLine:true,
		            	  xmlFileName:'\\eleasing\\workflow\\public\\comboSimpleCustSelect.xml',
			 		       loadMode:'ajax',
			 		       isAjaxLenovo:true,    
			 		       width:200,
			 		       name:'custname',
			 		       displayField:'nameandcode',
			 		       valueField:'value',
			 		       readOnly:false,
			 		      params:{
				 		    	 custType:'cust_type.cust'
						       }
			            }},
			            */
		            {header:'客户名称',name:'custname',queryConfig:{}},
		            {header:'卡号',name:'cardnum'},
		            {header:'计划日期',name:'plandate',type:"date",isRange:true,queryConfig:{isNewLine:true}},
		            {header:'期次',name:'rentlist',queryConfig:{}},
		            {header:'费用类型',name:'feetype',type:'combobox',queryConfig:{
		            	//isNewLine:true,
			 		       loadMode:'local',
			 		       datas:[{title:'租金',name:'租金'},{title:'罚息',name:'罚息'}],
			 		       isAjaxLenovo:true,    
			 		       width:200,
			 		       name:'feetype',
			 		       displayField:'title',
			 		       valueField:'name',
			 		       readOnly:false
			            }},
		            {header:'金额',name:'ovrent'}
	        ],
	        params:{
   				CONTRACT_STATUS_GreaterThan:30,
   				CONTRACT_STATUS_LessThan:100,
        		plandate_end:getCurDateTime()
		   }
   	 });
   });

</script>
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>