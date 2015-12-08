<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发票认证结果导入</title>
<!--css sheet-->
<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
<!--javascript libray-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyMultiTable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	</style>
	<script type="text/javascript">
var currentLoginUserId = "${sessionScope['login_userid']}";
var isAdmin=false;
var tools=[
	 		 {
	      	    iconCls:'icon-import',
	     	    html:'<font color="red">模板下载</font>',
	     	    handler:function(table){
	     	       attachmentDown({
	         	       url:'/leasing/template/createFileByTemplateClass.action',
	         	       returnType:'file',
	         	       twoClassify:'taxvatuploadinfo',
	         	      modelname:'taxvatuploadinfo'
	             	       });
	 	          },
	 	        iconCls : 'icon-update'
	 		  }
	 		  ,
	 		  {iconCls:'icon-import',
	 			  html:'<font color="red">导入认证结果</font>',
	 			  handler:function(table){   
	 	    	    	attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",uploadDataCallBack: 'taxUpload',modelname:'taxvatuploadinfo',title:'导入认证结果',headerIndex:'1',dataIndex:'2',targetClass:'com.business.entity.invoice.vat.TaxVatUploadInfo',custoperatorMethod:'initTaxVatUploadInfo',parames:constructionColumn});
	 			  }
	  		 }];
</script >
<permission:action  code="interest_master">
<script type="text/javascript">
isAdmin=true;
tools='';
</script >
</permission:action>

<permission:action  code="rent_account">
<script type="text/javascript">
isAdmin=true;
tools='';
</script >
</permission:action>

<permission:action  code="tax_account">
<script type="text/javascript">
isAdmin=false;
tools=[
		 {
	      	    iconCls:'icon-import',
	     	    html:'<font color="red">模板下载</font>',
	     	    handler:function(table){
	     	       attachmentDown({
	         	       url:'/leasing/template/createFileByTemplateClass.action',
	         	       returnType:'file',
	         	       twoClassify:'taxvatuploadinfo',
	         	      modelname:'taxvatuploadinfo'
	             	       });
	 	          },
	 	        iconCls : 'icon-update'
	 		  }
	 		  ,
	 		  {iconCls:'icon-import',
	 			  html:'<font color="red">导入认证结果</font>',
	 			  handler:function(table){   
	 	    	    	attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",uploadDataCallBack: 'taxUpload',modelname:'taxvatuploadinfo',title:'导入认证结果',headerIndex:'1',dataIndex:'2',targetClass:'com.business.entity.invoice.vat.TaxVatUploadInfo',custoperatorMethod:'initTaxVatUploadInfo',parames:constructionColumn});
	 			  }
	  		 }];
</script >
</permission:action>
	<script type="text/javascript">
	      var all_width = (document.documentElement||document.body).clientWidth-2;
	      var all_height = (document.documentElement||document.body).clientHeight-2;
	    </script>
<script type="text/javascript">
function importEbankCallBack(message){
    alert(message);
	window.currentImportExcelLoadMask.hide();
	var table = getTracywindyObject("id_table");
	table.reload();
}
	var constructionColumn= [    
        {header:'发票号码',mapping:'invoiceNo'},          
	    //{header:'供应商名称',mapping:'vndrName'},
	    //{header:'合同号',mapping:'contractId'},
	  	{header:'金额',mapping:'corpusTaxMoney'},
	  	{header:'税率',mapping:'taxRate'},
	  	{header:'税额',mapping:'taxMoney'},
	  	//{header:'费用类型',mapping:'taxType'},
	  	//{header:'客户名称',mapping:'custName'},
	  	//{header:'设备名称',mapping:'equipName'},
	  	{header:'认证结果',mapping:'certificationResults'},
	  	//{header:'认证时间',mapping:'certificationDate'},
	  	{header:'开票日期',mapping:'invoiceDate'}
	  ];
	jQuery(function(){
   	 var table = new tracywindyOperationTable({

   		width:all_width,
		height:all_height,
		//toolsLeftMargin:100,
   		 tableComment:'[发票认证结果导入]',
   		 constantFlagTable:'OwnInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'发票认证结果导入',
         id:'id_table',
         xmlFileName:'/eleasing/jsp/invoice_manage/vat_invoice/vat_authentication_imp.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         isCheck:false,
         operButtons:'',
 		 isRank:true,
 		 tools : tools,
        columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'合同号',name:'contractid',queryConfig:{}},
		            {header:'发票号',name:'invoiceno',queryConfig:{}},
		            {header:'开票时间',name:'invoicedate',type:"date",isRange:true,queryConfig:{isNewLine:false}},
		            {header:'供应商',name:'vndrname',queryConfig:{isNewLine:true}},
		            {header:'设备名称',name:'equipname'},
		            {header:'金额（含税价）',name:'corpustaxmoney'},
		            {header:'税率',name:'taxrate'},
		            {header:'税额',name:'taxmoney'},
		            {header:'费用类型',name:'taxtype'},
		            {header:'认证结果',name:'certificationresults'},
		            {header:'客户名',name:'custname'},
		            {header:'回导人',name:'modificator'},
		            {header:'回导时间',name:'modifydate'}
	        ]
	       
   	 });
   });
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
	
</body>
</html>