<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金催款函</title>
    <!--css sheet-->
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAttachmentFileUpload.js"></script>
	
	
	
	<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	</style>
<script type="text/javascript">

    function createNote(table){
    	var plandata = table.getCheckedRowDatas();
    	ids="";
    	contracts="";
    	filename="";
    	var parames=[];
    	for(var i=0;i<plandata.length;i++){
        	var id=plandata[i].id;
        	var contractnumber=plandata[i].contractnumber;
        	var custname=plandata[i].custname;
        	var contractid=plandata[i].contractid;
        	parames.push({id:id,memo:contractnumber,modelname:'overduenotice',filename:custname+"("+contractnumber+')租金催款函.doc','contractid':contractid});
        }
        var url="/leasing/template/createFileByTemplateClass.action";
    	attachmentDown({url:url,title:"下载通知函",twoClassify:'wordtempletypetwo11',returnType:'list',parames:parames});
    }
    function importEbankCallBack(message){
        alert(message);
    	window.currentImportExcelLoadMask.hide();
    	var table = getTracywindyObject("id_table");
    	table.reload();
    }
    var constantFlagTable = "User";
    var ebankUploadUrl="";
    var ebankAttachUrl="";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var tableebank = new tracywindyOperationTable({
   		resetFormCallback:function(table,$form,operFlag){
   		 if("add" == operFlag){
   			var rowData = table.getRowDataAt(1);
   	     }
     	 },
   		 loadFormDataCallBack:function(table,$form,rowIndex){
        },
   		 tableComment:'[租金催款函]',
   		 constantFlagTable:'FundOverduerent',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'租金催款函',
         width:window.formWidth||parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/fund_overduerent/overdue_letter_info.xml',
         loadMode:'ajax',
         isPage:true,
         operButtons:'',
         checkType:'checkbox',
         tools:[{
     	    iconCls:'icon-import',
     	    html:'<font color="red">生成催款函</font>',
     	    handler:function(table){
     	    	createNote(table);
     	   }}
     	 ],
         isFit:true,
         columns:[
                    {header:'id',name:'id',hidden:true},
		            {header:'合同编号',name:'contractid',queryConfig:{}},
		            {header:'租赁合同号',name:'contractnumber',queryConfig:{}},
		            {header:'最近一次发送日期',name:'senddate'},
		            {header:'催款员',name:'dun'},
		            {header:'客户名称',name:'custname'},
		            {header:'电话',name:'phone'},
		            {header:'地址',name:'homeadd'},
		            {header:'担保人',name:'assurors'}
	        ]
   	 });
   });
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>