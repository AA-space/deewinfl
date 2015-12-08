<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>放款单导出</title>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
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

   		 tableComment:'[放款单导出]',
   		 constantFlagTable:'FundforRent',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'放款单导出',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/fund_exprot_for_rent/dedulistmodify.xml',
         loadMode:'ajax',
         isPage:true,
         isExcel:true,
         isFit:true,
         //checkType:'checkbox',
         operButtons:'',
         tools:[
			 {
				isHtml : true,
				html : '本方银行：'
			 }, {
				isHtml : true,
				html : '<div id="id_flow_name" style="float:left;"></div>'
			 }, 
        	 {
         	    iconCls:'icon-update',
         	    html:'<font color="red">导出放款单</font>',
         		handler : function(table) {
         			debugger;
         			var flowname = getTracywindyObject('id_combo_flow_name').getValue();
					if(flowname==""){
						alert("请选择本方银行！！！");
						return false;
					}
        	    	var url="/leasing/template/createFileByTemplateClass.action";
        	    	var fileparames={url:url,dateInitMethod:'totalCredit', sqlDataCallback:'deduDetailExportDataCallback',title:"导出",twoClassify:'wordtempletypetwo.200',returnType:'file',modelname:'wordtempletypetwo.200'};
        	        fileparames.accountid = flowname;
        	        
        	        attachmentDown(fileparames); 
         		}
         	 }
        	 ],
         columns:[
                    {header:'id',name:'id',hidden:true},
		            {header:'经销商',name:'cust_name',queryConfig:{}},
		            {header:'账号',name:'client_accnumber'},
		            {header:'账户名称',name:'client_account'},
		            {header:'开户行',name:'client_bank'},
		            {header:'台数',name:'equip_count'},
		            {header:'付款时间',name:'plan_date'},
		            {header:'现汇金额',name:'plan_money'},
		            {header:'抵扣金额',name:'dedu_money'},
		            {header:'状态',name:'invalid',type:'combobox'
// 						queryConfig:{
// 						colSpan:2,
// 						loadMode:'local',
// 						datas:[{title:'未提交',name:"'未提交'"},{title:'已提交',name:"'已提交'"}],
// 			            displayField:'title',
// 			            valueField:'name'
// 						}
		            }
	        ],
	        params:{
	        	invalid : "'已导出'"
		   }
   	 });
   	 
   	var combo_cust = new tracywindyComboBox({
		id : 'id_combo_flow_name',
		width : 200,
		renderTo : 'id_flow_name',
		xmlFileName : '\\eleasing\\workflow\\public\\ownAccNumberSelect.xml',
        loadMode:'ajax',
		readOnly : false,
		isAjaxLenovo : true,
		isContainEmpty : false,
		dropListHeight : 300,
		topAdd : 0,
		leftAdd : 0,
		positionDropIconLeftAdd : -1,
		name : 'flow_name',
		displayField:'accname',
        valueField:'id',
        value:"",
		rawValue:"",
		
		onSelect : function(combo) {

		}
	});
   	
   	
   	
   	
   });

</script>
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer" title="维护抵扣租金信息" style="display: none; width: 800px; height: 300px">
		<center>
			<form id="id_detailInfoForm">
				<table style="width: 90%">
					<tr style="display: none">
						<td><input name="id" type="hidden" value="" /></td>
					</tr>
					<tr>
						<td class="input_label_desc" align="left">经销商:</td>
						<td><input name="cust_name" class="td-content-input" readOnly label="经销商" maxB="50" /> <span class="content-required">*</span></td>
						<td class="input_label_desc" align="left">抵扣金额:</td>
						<td class="td-content"><input type="text" name="dedu_money" class="td-content-input" require="true" label="抵扣金额" dataType="Money" /><span class="content-required">*</span></td>
					</tr>
				
					<tr class="content-separator">
						<td colspan='4'><a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a> <a
							style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'
						><span>取消</span></a></td>
					</tr>
				</table>
			</form>
		</center>
	</div>
</body>
</html>