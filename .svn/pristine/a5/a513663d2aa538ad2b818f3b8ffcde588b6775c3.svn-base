<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租赁业务  - 卡扣上传</title>
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
   function downloadFile(Id)
   {
     attachmentDown({url:"/leasing/template/downLoadAttachById.action",id:Id,returnType:'file'});
    } 
    function showOperator(value,tableObj,columnName,columnIndex,rowData){
       var base = "<a href='#' onclick='downloadFile(\""+rowData.id+"\")'>"+rowData.filename+"</a>";
       return base;
    }
    function importEbankCallBack(message){
        alert("'"+message+"'");
    	window.currentImportExcelLoadMask.hide();
    	var table = getTracywindyObject("id_table");
    	table.reload();
    }
    var constantFlagTable = "User";
    var ebankUploadUrl="";
    var ebankAttachUrl="";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	//普通的卡扣上传列
	var importcolumn= [
		            {header:'合同号',mapping:'contractid'},
		            {header:'租金金额',mapping:'incomemoney'}
	  	        ];
    //农行卡扣上传
    var agricultureColumn= [    
                    {header:'serialno',mapping:'incomenum'},          
                    {header:'enddate',mapping:'incomedate'},          
		            {header:'actualdebitamt',mapping:'incomemoney'},
		            {header:'resultdesc',mapping:'incometext'},
		            {header:'payeeaccountno',mapping:'clientaccount'},
		            {header:'payeename',mapping:'cilentname'},
		            {header:'routecenter',mapping:'tradepurpose'}
		            /* ,
		            {header:'失败原因',mapping:'返回信息'} */
	  	        ];
    //建行卡扣上传
    var ConstructionColumn= [    
                    //{header:'账户明细编号-交易流水号',mapping:'incomenum'},          
                    //{header:'交易时间',mapping:'incomedate'},          

		            {header:'付款人姓名',mapping:'cilentname'},
		            {header:'付款账号',mapping:'clientaccount'},
		            {header:'金 额',mapping:'incomemoney'},
		            {header:'交易结果',mapping:'incometext'},
		            {header:'摘要',mapping:'tradepurpose'},
		            {header:'失败原因',mapping:'remark'}
	  	        ];  
    //通用卡扣上传
    var CommonColumn= [    
                    {header:'编号',mapping:'incomenum'},          
                    {header:'交易时间',mapping:'incomedate'},          
		            {header:'交易金额',mapping:'incomemoney'},
		            {header:'交易状态',mapping:'tradingresults'},
		            {header:'对方账号',mapping:'clientaccount'},
		            {header:'对方户名',mapping:'cilentname'},
		            {header:'备注',mapping:'tradepurpose'}
	  	        ];  
	jQuery(function(){
   	 var tableebank = new tracywindyOperationTable({

   		resetFormCallback:function(table,$form,operFlag){
   		 if("add" == operFlag){
   			var rowData = table.getRowDataAt(0);
   	   		 //document.getElementById("custname").value=rowData["custname"];
   			//$("#custname").val(rowData["custname"]);
   	     }
     	 },
   		 loadFormDataCallBack:function(table,$form,rowIndex){
 
        },
   		 tableComment:'[卡扣回笼上传]',
   		 constantFlagTable:'fundebank',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'卡扣回笼上传',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/fund_bankcarddown/bankcardupload.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         isRemoteSortable : false,
         operButtons:' ',
       /*   params : {
        	isexport : ' ' 
         }, */
         tools:[{
        	    iconCls:'icon-cancel',
        	    html:'<font color="red">删除</font>',
        	    handler:function(table)
        	    { 
        	    	var row = table.getCheckedRowDatas();
        		    if( row[0]['exp'] == '0' )
        		    {
            	    	param = {};
            	    	param.b_id = row[0]['id'];
            			$.ajax({
            				type : "post",
            				url : getRootPath()+"/acl/deleteUploadCardHire.acl",
            				cache : false,
            				async : false,
            				data : param,
            				success : function( rs ) 
            				{
            				   var svote = rs;
            				   svote = svote.replace(/(^\s+)|(\s+$)/g, ""); 
            					if (svote!="") 
            					{
            						if ( svote == "yes"){
           							   alert( "删除成功!" );
            						   table.reload();
            						}
            						else
           							{
           						   	   alert("删除失败!");
            						   table.reload();
           							}
            					}
            				}
            			});
            	    	
        	    	}
        		    else alert( "[不允许操作]该数据已经核销,或者正在核销... " ); 
                }
        	 },
                {
        	    iconCls:'icon-import',
        	    html:'<font color="red">农行卡扣上传</font>',
        	    handler:function(table){ 
        	    	var canStrat = true;
        	    	var data = table.getRowsData();
        	    	for(var i = 0; i < data.length; i++ ){
        	    		if(data[i]['exp'] != '2'){
        	    			canStrat = false;
        	    			break;
        	    		}
        	    	}
        	     	if(canStrat){
	        	    	attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",modelname:'cardupload', filefirstkey : 'card_hire_bank_agricultural', title:'农行卡扣上传','成功':'0','失败':'1',headerIndex:'1',dataIndex:'2',targetClass:'com.business.entity.contract.rent.ContractCardRentIncome',title:'农行卡扣上传',custoperatorMethod:'initCardHire',parames:agricultureColumn});
        	    	} else {
        	    		alert("还有未核销完成的卡扣数据,请核销完成后再上传");
        	    	}
        	    	
               }
        	 },
        	 {
         	    iconCls:'icon-import',
         	    html:'<font color="red">建行卡扣上传</font>',
         	    handler:function(table){ 
	         	   	var canStrat = true;
	    	    	var data = table.getRowsData();
	    	    	for(var i = 0; i < data.length; i++ ){
	    	    		if(data[i]['exp'] != '2'){
	    	    			canStrat = false;
	    	    			break;
	    	    		}
	    	    	}
	    	     	if(canStrat){
         	    		attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",modelname:'cardupload',filefirstkey : 'card_hire_bank_construction', title:'建行卡扣上传','成功':'0','失败':'1',headerIndex:'3',dataIndex:'4',targetClass:'com.business.entity.contract.rent.ContractCardRentIncome',custoperatorMethod:'initCardHire',parames:ConstructionColumn});
	    	    	} else {
	    	    		alert("还有未核销完成的卡扣数据,请核销完成后再上传");
	    	    	}
                }
         	 },
        	 {
          	    iconCls:'icon-import',
          	    html:'<font color="red">通用卡扣上传</font>',
          	    handler:function(table){ 
	         	   	var canStrat = true;
	    	    	var data = table.getRowsData();
	    	    	for(var i = 0; i < data.length; i++ ){
	    	    		if(data[i]['exp'] != '2'){
	    	    			canStrat = false;
	    	    			break;
	    	    		}
	    	    	}
	    	     	if(canStrat){
	          	    	attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",modelname:'cardupload',title:'通用卡扣上传','成功':'0','失败':'1',headerIndex:'1',dataIndex:'2',targetClass:'com.business.entity.contract.rent.ContractCardRentIncome',custoperatorMethod:'',parames:CommonColumn});
	    	    	} else {
	    	    		alert("还有未核销完成的卡扣数据,请核销完成后再上传");
	                 }
          	  	}
          	 },
        	 {
         	    iconCls:'icon-import',
         	    html:'<font color="red">卡扣核销</font>',
         	    handler:function(table){ 
        		    var row = table.getCheckedRowDatas();
         	    	//console.info(row);
        		    if(row.length==0 || row.length > 1){
            	    	alert("请选择需要核销的上传数据!");
        	    	}else  if(row[0]['exp'] == '2'){
        		    	alert("该数据已经核销过，不能再次核销");
        		    } else {
        	    		startProcess("租金批量核销(卡扣)-1","&fileid="+row[0].id);
        	    	}
         	   }
         	 }
    	 ],
         columns:[
                    {header:'id',name:'id',hidden:true},
		            {header:'文件名',name:'filename',renderer:showOperator},
		            {header:'上传人',name:'username'},
		            {header:'上传时间',name:'createdate'},
		            {header:'核销状态',name:'exp',renderer:function(value,tableObj,columnName,columnIndex,rowData){
		 	    	
					var text = "";
					if (rowData.exp) {
						var key = rowData.exp;
						switch (key) {
						case '0':
							text = "<span>未核销</span>";
							break;
						case '1':
							text = "<span>正在核销</span>";
							break;
						case '2':
							text = "<span>已核销</span>";
							break;

						default:
							break;
						}

					}
					return text;
				}
			}]
		});
	});
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>