<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金开票数据回导</title>
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
<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	</style>
<script type="text/javascript">
var currentLoginUserId = "${sessionScope['login_userid']}";
var isAdmin=false;
var tools=[ {
		html : '<font color="red">导入租金已开票数据</font>',
			handler : function(table) {
	    	attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",modelname:'rentinvoiceconfirm',title:'导入已开票数据',headerIndex:'1',dataIndex:'2',targetClass:'com.business.entity.invoice.vat.TaxRentUploadInfo',custoperatorMethod:'checkRentInvoiceConfirmExp',parames:rentInvoiceColumn});
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
	    	var url="/acl/expTaxRentInvoiceEms.acl";
	    	var fileparames={ids:tempIdArr.join(","),url:url,title:"快递寄送数据导出",twoClassify:'rentinvoiceems',returnType:'file',modelname:'rentinvoiceconfirm'};
	        attachmentDown(fileparames); },
			iconCls : 'icon-update'}
		,{html : '<font color="red">快递寄送数据导入</font>',
			handler : function(table) {
	    	attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",modelname:'rentinvoiceconfirm',title:'快递寄送数据导入',headerIndex:'1',dataIndex:'2',targetClass:'com.business.entity.invoice.vat.TaxRentUploadInfo',custoperatorMethod:'checkRentInvoiceEmsConfirmExp',parames:rentInvoiceColumn});
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
isAdmin=true;
tools='';
</script >
</permission:action>

<permission:action  code="tax_account">
<script type="text/javascript">
isAdmin=false;
tools=[ {
		html : '<font color="red">导入租金已开票数据</font>',
			handler : function(table) {
	    	attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",modelname:'rentinvoiceconfirm',title:'导入已开票数据',headerIndex:'1',dataIndex:'2',targetClass:'com.business.entity.invoice.vat.TaxRentUploadInfo',custoperatorMethod:'checkRentInvoiceConfirmExp',parames:rentInvoiceColumn});
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
	    	var url="/acl/expTaxRentInvoiceEms.acl";
	    	var fileparames={ids:tempIdArr.join(","),url:url,title:"快递寄送数据导出",twoClassify:'rentinvoiceems',returnType:'file',modelname:'rentinvoiceconfirm'};
	        attachmentDown(fileparames); },
			iconCls : 'icon-update'}
		,{html : '<font color="red">快递寄送数据导入</font>',
			handler : function(table) {
	    	attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",modelname:'rentinvoiceconfirm',title:'快递寄送数据导入',headerIndex:'1',dataIndex:'2',targetClass:'com.business.entity.invoice.vat.TaxRentUploadInfo',custoperatorMethod:'checkRentInvoiceEmsConfirmExp',parames:rentInvoiceColumn});
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
var rentInvoiceColumn= [    
                        {header:'编号',mapping:'outno'},          
                        {header:'合同号',mapping:'contractid'},          
                        {header:'客户名称',mapping:'custname'},
                        {header:'期项',mapping:'rentlist'},
                        {header:'收款日期',mapping:'incomedate'},
                        {header:'收款金额',mapping:'incomemoney'},
                        {header:'开票类型',mapping:'invoicetype'},
                        {header:'金额类型',mapping:'renttype'},
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
   		 renderTo:'id_tableContainer',
   		 width:all_width,
		 height:all_height,
		 //toolsLeftMargin:200,
		 windowTop:20,
   	     border:true,
         title:'租金开票数据回导',
         tools : tools,
         id:'id_table',
         xmlFileName:'eleasing/jsp/invoice_manage/rent_invoice/rent_invoice_import.xml',
         loadMode:'ajax',
         isPage:true,
         pageSize : 20,
         //isFit:true,
         isCheck:true,
 		 isRank:false,
 		 lockedNames:['contractid'],
         columns:[
                  {header:'id',name:'id',hidden:true},
		            {header:'合同号',name:'contractid',queryConfig:{}},
		            {header:'客户名称',name:'custname',queryConfig:{}},
		            {header:'收款日期',name:'incomedate'},
		            {header:'期次',name:'rentlist'},
		            {header:'金额类型',name:'renttype'},
		            {header:'发票类型',name:'invoicetype'},
		            {header:'开票时间',name:'invoicedate'},
		            {header:'开票金额',name:'invoicemoney',type:'double',queryConfig:{}},
		            {header:'销项税金',name:'taxmoney',type:'double'},
		            {header:'发票号',name:'invoiceno'},
		            {header:'纳税人识别号',name:'taxregcode'},
		            {header:'开户行',name:'taxbank'},
		            {header:'账号',name:'taxacc'},
		            {header:'电话',name:'taxphone'},
		            {header:'地址',name:'taxregadd'},
		            {header:'状态',name:'status'}
			       
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

