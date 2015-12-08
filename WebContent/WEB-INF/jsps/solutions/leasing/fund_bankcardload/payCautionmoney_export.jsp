<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保证金支付明细导出</title>
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

   		 tableComment:'[放款导出]',
   		 constantFlagTable:'fundebank',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'放款导出',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/fund_bankcarddown/payCautionmoneydown.xml',
         loadMode:'ajax',
         isPage:true,
         isExcel:true,
         isFit:true,
         checkType:'checkbox',
         operButtons:'',
         tools:[{
        	    iconCls:'icon-import',
        	    html:'<font color="red">导出</font>',
        	    handler:function(table){
        	    	var params = getQueryAreaParams(table,false);
        	    	var url="/leasing/template/createFileByTemplateClass.action";
        	    	var fileparames={url:url,dateInitMethod:'totalCredit', sqlDataCallback:'CautionMoneyDataCallback',title:"导出",twoClassify:'wordtempletypetwo.201',returnType:'file',modelname:'wordtempletypetwo.201'};
        	        for(var p in params){
            	        if(params[p]!=""){
        	        	   fileparames[p]=params[p];
            	        }
            	    } 
        	        fileparames.export_flag = 0;
        	        attachmentDown(fileparames); 
        	    }
        	 }
        	 ],
         columns:[
                    {header:'id',name:'id',hidden:true},
		            {header:'序号',name:'rn'},
		            {header:'合同号',name:'contract_number',queryConfig:{}},
		            {header:'客户',name:'cust_name',queryConfig:{}},
		            {header:'经销商',name:'dealer',queryConfig:{}},
		            {header:'保证金金额',name:'balancemoney'},
		            {header:'抵扣租金',name:'credit_money'},
		            {header:'剩余支付金额',name:'total_money'},
		            {header:'付款时间',name:'plan_date'},
		            {header:'账户名称',name:'client_account'},
		            {header:'开户行名称',name:'client_bank'},
		            {header:'账号',name:'client_accnumber',queryConfig:{isNewLine:true}},
		            {header:'对应租后人员',name:'realname'},
		            {header:'导出状态',name:'export_flag',renderer: function(value, tableObj, columnName, columnIndex, rowData){
		            	if(value == '0'){
		            		return '<span>未导出</span>';
		            	} else{
		            		return '<span>已导出</span>';
		            	}
		            	
		            },type:'combobox',
						queryConfig:{
						colSpan:2,
						loadMode:'local',
						datas:[{title:'未导出',name:'0'},{title:'已导出',name:'1'}],
			            displayField:'title',
			            valueField:'name',
			            defaultValue:0
						}}
		            
	        ],
	        params:{
	        	export_flag : 0
		   }
   	 });
   });

</script>
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>