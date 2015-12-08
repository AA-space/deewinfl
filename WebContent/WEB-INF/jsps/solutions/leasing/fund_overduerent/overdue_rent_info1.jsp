<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租赁业务  - 租金催收</title>
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
    var constantFlagTable = "User";
    var ebankUploadUrl="";
    var ebankAttachUrl="";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
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
   		 tableComment:'[租金催收]',
   		 constantFlagTable:'fundebank',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'租金催收',
         width:window.formWidth||parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/fund_overduerent/overdue_rent_info.xml',
        // xmlFileName:'/eleasing/jsp/law_manage/law_info.xml',
         loadMode:'ajax',
         operButtons:' ',
         isPage:true,
         isFit:false,
         //isNeedEnabled:true,
         isAutoBreakContent:true,
         lockedNames:['custname'],
         columns:[
                  {header:'id',name:'id',hidden:true},
		            {header:'客户名称',name:'custname',renderer:showOverdueName,width:180,queryConfig:{}},
		            {header:'合同号',name:'contractid'},
		            {header:'合同状态',name:'contractstatusname'},
		            {header:'催款员',name:'dun'},
		            {header:'事业部',name:'projdeptname'},
		            {header:'省份',name:'provincename'},
		            {header:'身份证/组织机构代码',name:'idcardorcode',width:140},
		            {header:'经销商',name:'dealername',width:200},
		            //{header:'项目经理',name:'projmanagename',width:200},
		            {header:'逾期期数',name:'overnum-'},
		            {header:'逾期租金',name:'overrent'},
		            {header:'逾期利息',name:'overinterest'},
		            {header:'逾期罚息',name:'penalty-'},
		            {header:'逾期天数',name:'column14-'},
		            //{header:'累计逾期数',name:'column16'},
		            {header:'留购价款',name:'nominalprice'},
		            {header:'总期数',name:'incomenumber'},
		            {header:'联系方式',name:'liaisonwayname'},
		            {header:'起租日',name:'startdate'},
		            {header:'本金余额/剩余还款期数',name:'corpusorresiduenum'},
		            {header:'下一次联系日',name:'nextliaisondate'},
		            {header:'最近一次付款金额/时间',name:'rentordate',width:170},
		            {header:'催收日',name:'liaisondate'},
		            {header:'承诺还款日',name:'paydate'},
		            {header:'承诺还款金额',name:'paymoney'},
		            {header:'担保人',name:'assurors'},
		            {header:'担保人联系方式',name:'assurorsnum'},
		            {header:'承租人邮寄地址',name:'mailadd',width:140}
		            //{header:'产品型号',name:'model'},
		            //{header:'整机编号',name:'eqipid'},
		            //{header:'台数',name:'equipnum'}
		            
	        ]
   	 }); 	 
   	function showOverdueName(value,tableObj,columnName,columnIndex,rowData){
        var base = "<a href='#' onclick=showoverdueInfo('"+rowData.custid+"','"+rowData.contractid+"')>{1}</a>{2}";
        var separator = "&nbsp;&nbsp;";
        var updateFlag=value;
        var updateClickFunc="other";
        var field=base.replace("{1}",updateFlag).replace("{2}",separator);
        return field;
      }

	    
   // 	commonSelectOverall('id_select_contract_id',"(select ci.contract_id,ci.id||'/'||cust.cust_name value from contract_info ci left join cust_info cust on (ci.cust_id=cust.id)) rs",'value',"contract_id",'contractid','','','',selectContract,false);
  //   	dictYesOrNoByCode('id_select_is_insured','isinsured',1,'','','require="true" label="是否投保"');
   });
	 function showoverdueInfo(custid,contractid){
	    	var URL = "${pageContext.request.contextPath}/leasing/fund_overduerent/show_template.bi";
	    	var params = {cust_id:custid,contract_id:contractid,jsp:"overdue_rent_detail_info"};
		    openFullScreenWindow(URL,params);
	        //window.open(getRootPath()+"/leasing/law_cust/show_template.bi?cust_id="+cust_id+"&jsp=law_cust_all_info",'','height=500px,width=1000px,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	    }

</script>
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>