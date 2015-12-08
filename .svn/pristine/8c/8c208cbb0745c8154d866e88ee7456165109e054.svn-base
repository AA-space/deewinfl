<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资金开票数据回导</title>
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
var tools=[ {
	html : '<font color="red">导入已开票数据</font>',
	handler : function(table) {
    	attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",modelname:'fundinvoiceconfirm',title:'导入已开票数据',headerIndex:'1',dataIndex:'2',targetClass:'com.business.entity.invoice.vat.TaxFundUploadInfo',custoperatorMethod:'checkFundInvoiceConfirmExp',parames:fundInvoiceColumn});
	},
	iconCls : 'icon-update'}
	 ,{html : '<font color="red">快递寄送数据导出</font>',
	handler : function(table) {
		var checkedRowDatas = table.getCheckedRowDatas();
		if(0 == checkedRowDatas.length){
		alert("请选择要导出的记录！！");
		return;
		}
		var tempIdArr = [];
    for(var i = 0;i<checkedRowDatas.length;i++){
		var checkedRowdata = checkedRowDatas[i];
		var id = checkedRowdata.id;
		tempIdArr.push("'"+id+"'");
	}
	var url="/leasing/template/createFileByTemplateClass.action";
	var fileparames={ids:tempIdArr.join(","),currentLoginRealName:'${sessionScope["login_realname"]}',url:url,title:"快递寄送数据导出",twoClassify:'fundinvoiceconfirm',returnType:'list',modelname:'fundinvoiceconfirm'};
    attachmentDown(fileparames); },
	iconCls : 'icon-update'}
,{html : '<font color="red">快递寄送数据导入</font>',
	handler : function(table) {
 	attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",modelname:'fundinvoiceconfirm',title:'快递寄送数据导入',headerIndex:'1',dataIndex:'2',targetClass:'com.business.entity.invoice.vat.TaxFundUploadInfo',custoperatorMethod:'checkFundInvoiceEmsConfirmExp',parames:fundInvoiceColumn});
	},
	iconCls : 'icon-update'
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
isAdmin=false;
tools=[ {
	html : '<font color="red">导入已开票数据</font>',
	handler : function(table) {
    	attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",modelname:'fundinvoiceconfirm',title:'导入已开票数据',headerIndex:'1',dataIndex:'2',targetClass:'com.business.entity.invoice.vat.TaxFundUploadInfo',custoperatorMethod:'checkFundInvoiceConfirmExp',parames:fundInvoiceColumn});
	},
	iconCls : 'icon-update'}
	 ,{html : '<font color="red">快递寄送数据导出</font>',
	handler : function(table) {
		var checkedRowDatas = table.getCheckedRowDatas();
		if(0 == checkedRowDatas.length){
		alert("请选择要导出的记录！！");
		return;
		}
		var tempIdArr = [];
    for(var i = 0;i<checkedRowDatas.length;i++){
		var checkedRowdata = checkedRowDatas[i];
		var id = checkedRowdata.id;
		tempIdArr.push("'"+id+"'");
	}
	var url="/leasing/template/createFileByTemplateClass.action";
	var fileparames={ids:tempIdArr.join(","),currentLoginRealName:'${sessionScope["login_realname"]}',url:url,title:"快递寄送数据导出",twoClassify:'fundinvoiceconfirm',returnType:'list',modelname:'fundinvoiceconfirm'};
    attachmentDown(fileparames); },
	iconCls : 'icon-update'}
,{html : '<font color="red">快递寄送数据导入</font>',
	handler : function(table) {
 	attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",modelname:'fundinvoiceconfirm',title:'快递寄送数据导入',headerIndex:'1',dataIndex:'2',targetClass:'com.business.entity.invoice.vat.TaxFundUploadInfo',custoperatorMethod:'checkFundInvoiceEmsConfirmExp',parames:fundInvoiceColumn});
	},
	iconCls : 'icon-update'
 }];
</script >
</permission:action>

<permission:action  code="tax_account">
<script type="text/javascript">
isAdmin=false;
tools=[ {
	html : '<font color="red">导入已开票数据</font>',
	handler : function(table) {
    	attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",modelname:'fundinvoiceconfirm',title:'导入已开票数据',headerIndex:'1',dataIndex:'2',targetClass:'com.business.entity.invoice.vat.TaxFundUploadInfo',custoperatorMethod:'checkFundInvoiceConfirmExp',parames:fundInvoiceColumn});
	},
	iconCls : 'icon-update'}
	 ,{html : '<font color="red">快递寄送数据导出</font>',
	handler : function(table) {
		var checkedRowDatas = table.getCheckedRowDatas();
		if(0 == checkedRowDatas.length){
		alert("请选择要导出的记录！！");
		return;
		}
		var tempIdArr = [];
    for(var i = 0;i<checkedRowDatas.length;i++){
		var checkedRowdata = checkedRowDatas[i];
		var id = checkedRowdata.id;
		tempIdArr.push("'"+id+"'");
	}
	var url="/leasing/template/createFileByTemplateClass.action";
	var fileparames={ids:tempIdArr.join(","),currentLoginRealName:'${sessionScope["login_realname"]}',url:url,title:"快递寄送数据导出",twoClassify:'fundinvoiceconfirm',returnType:'list',modelname:'fundinvoiceconfirm'};
    attachmentDown(fileparames); },
	iconCls : 'icon-update'}
,{html : '<font color="red">快递寄送数据导入</font>',
	handler : function(table) {
 	attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",modelname:'fundinvoiceconfirm',title:'快递寄送数据导入',headerIndex:'1',dataIndex:'2',targetClass:'com.business.entity.invoice.vat.TaxFundUploadInfo',custoperatorMethod:'checkFundInvoiceEmsConfirmExp',parames:fundInvoiceColumn});
	},
	iconCls : 'icon-update'
 }];
</script >
</permission:action>
	<script type="text/javascript">
	      var all_width = (document.documentElement||document.body).clientWidth-2;
	      var all_height = (document.documentElement||document.body).clientHeight-2;
	    </script>
<script type="text/javascript">
	var fundInvoiceColumn= [    
           {header:'编号',mapping:'outno'},          
           {header:'合同号',mapping:'contractid'},          
           {header:'客户名称',mapping:'custname'},
           {header:'费用类型',mapping:'taxtype'},
           {header:'收款日期',mapping:'incomedate'},
           {header:'收款金额',mapping:'incomemoney'},
           {header:'发票类型',mapping:'invoicetype'},
           {header:'发票号',mapping:'invoiceno'},
           {header:'开票金额',mapping:'invoicemoney'},
           {header:'开票时间',mapping:'invoicedate'},
           {header:'销项税金',mapping:'taxmoney'},
           {header:'税率',mapping:'taxrate'},
           {header:'开户行',mapping:'taxbank'},
           {header:'帐号',mapping:'taxacc'},
           {header:'电话号码',mapping:'taxtel'},
           {header:'纳税人识别号',mapping:'taxregcode'},
           {header:'地址',mapping:'taxaddr'},
           {header:'快递单号',mapping:'emsno'},
           {header:'寄送时间',mapping:'senddate'},
           {header:'导出时间',mapping:'exportdate'},
           {header:'导出 人',mapping:'exportuser'}
	];
	jQuery(function(){
   	 var table = new tracywindyTable({
   		width:all_width,
		height:all_height,
   		 tableComment:'[资金开票数据回导]',
   		 constantFlagTable:'OwnInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'资金开票数据回导',
         id:'id_table',
         xmlFileName:'/eleasing/jsp/invoice_manage/fund_invoice/fund_upload_info.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:false,
         isCheck:true,
 		 isRank:true,
 		 tools : tools,
        columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'编号',name:'outno'},
		            {header:'合同号',name:'contractid',queryConfig:{}},
		            {header:'客户名称',name:'custname',queryConfig:{}},
		            {header:'收款日期',name:'plandate',type:"date",isRange:true,queryConfig:{isNewLine:false}},
		            {header:'收款金额',name:'planmoney',type:'double',queryConfig:{isNewLine:true}},
		            {header:'费用类型',name:'taxtype'},
		            {header:'发票类型',name:'invoicetype'},
		            {header:'开票时间',name:'invoicedate'},
		            {header:'开票金额',name:'invoicemoney',type:'double',queryConfig:{}},
		            {header:'税率',name:'taxrate'},
		            {header:'销项税金',name:'taxmoney'},
		            {header:'发票号',name:'invoiceno'},
		            {header:'纳税人识别号',name:'taxregcode'},
		            {header:'开户行',name:'taxbank'},
		            {header:'账号',name:'taxacc'},
		            {header:'电话',name:'taxphone'},
		            {header:'地址',name:'taxregadd'},
		            {header:'状态',name:'hcstatus',type:'combobox',
		            	queryConfig:{
		            	isNewLine:false,
		            	colSpan:3, 
		            	loadMode:'local',
		            	datas:[
		            	{title:'已红冲',name:'已红冲'},
		            	{title:'红冲发票',name:'红冲发票'},
		            	{title:'全部',name:''}
		            	],
		            	displayField:'title',
		            	valueField:'name',
		            	defaultValue:1
		            	}}
	        ]
   	 });
   });
	function importEbankCallBack(message){
        alert(message);
    	window.currentImportExcelLoadMask.hide();
    	var table = getTracywindyObject("id_table");
    	table.reload();
    }
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
	
</body>
</html>