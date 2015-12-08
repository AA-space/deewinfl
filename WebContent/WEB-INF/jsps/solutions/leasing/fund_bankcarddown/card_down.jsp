<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租赁业务  - 卡扣回笼下载</title>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyMultiTable.js"></script>
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
    function showOperator(value,tableObj,columnName,columnIndex,rowData){
        // var base = "<a href='#' onclick='showRecorder(\""+rowData.id+"\")'>记录</a>";
         var base2 = "<a href='#' onclick='downloadFile(\""+rowData.id+"\")'>下载</a>";
        // var base3 = "<a href='#' onclick='openoverdue(\""+rowData.id+"\")'>编辑</a>";
         return base2; 
      }

     function downloadFile(Id)
     {
       attachmentDown({url:"/leasing/template/downLoadAttachById.action",id:Id,returnType:'file'});
      }
     
    var constantFlagTable = "bankdownlist";
    var ebankUploadUrl="";
    var ebankAttachUrl="";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	var filename='table_id_tableContainer';
	jQuery(function(){
   	 var tableebank = new tracywindyMultiTable({

   		 tableComment:'[卡扣回笼下载]',
   		 constantFlagTable:'fundebank',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         //id:'id_table',
         xmlFileName:'/eleasing/jsp/fund_bankcarddown/bankcarddownlist.xml',
         loadMode:'ajax',
         params:{modelname:"wordtempletypetwo19','wordtempletypetwo20','wordtempletypetwo21"},
         isPage:true,
         isCheck:false,
        // isExcel:true,
         isFit:true,
         isCheck :false,
         //checkType:'checkbox',
         tools:'',
		 datas:JsonUtil.decode('${empty json_word_list_str ? "[]" : json_word_list_str }'),
		    //datas:[{id:11,filename:111}],
	    columns:[
	       {name:'id',  header:'id',type:'text',hidden:true},
	       {header:'文件名称',name:'filename'},
	       {header:'文件生成时间',name:'username'},
	       {header:'文件生成时间',name:'createdate'},
	     /*   {header:'状态',name:'exp',renderer:function(value,tableObj,columnName,columnIndex,rowData){
	    	   var text = "";
	    	   if(rowData.exp ){
					text = "<span>已下载 " + rowData.exp + " 次</span>"
	    	   }
	    	   return text;
	       }}, */
	       {header:'操作',name:'create',renderer:showOperator}
	      // {name:'templateshowname',  header:'协议文本',type:'text', renderer:showContractFile}
	     ]
   	 });
   });

</script>
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>