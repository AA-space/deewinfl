<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
    <head>
<script type="text/javascript">
var cust_id="${param.cust_id}";
var contract_id = '${param.contract_id}';
//var param={};
//if(cust_id!="null" || cust_id==""){param.CUST_ID=cust_id;}
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
		seajs.use("js/apcomponent/aptable/aptable.js",function(ApTable){
			new ApTable({
				
				 //windowTop:20,
		         renderTo:'id_tableContainer',
		         width:window.formWidth||parseInt("${param.tableWidth}")||pageWidth,
		         /* height:parseInt("${param.tableHeight}")||pageHeight, */
		        height:250,
		         id:'id_table',
		         xmlFileName:'/eleasing/jsp/fund_overduerent/overdue_rent_info.xml',
				 showPager:false, 
				 showFooter:true,
				 showToolbar:true,
				 params:{CUST_ID:cust_id},
				 hiddenQueryArea : true,
				     columns:[
                       {type:'indexcolumn'},
                       {type:'checkcolumn'},
                    {field:'id', header:'id',visible:false},
   		            {header:'客户名称',field:'custname'},
   		            {header:'合同号',field:'contractnumber'},
   		            {header:'合同状态',field:'contractstatusname'},
   		            {header:'催款员',field:'dun'},
   		            {header:'事业部',field:'projdeptname'},
   		            {header:'省份',field:'provincename'},
   	                {header:'身份证/组织机构代码',field:'idcardorcode',width:140},
   	                {header:'经销商',field:'dealername'},
   		             {header:'项目经理',field:'projmanagename'},
   		            {header:'逾期期数',field:'overinterest'},
   		            {header:'逾期租金',field:'overrent'},
   		            {header:'逾期利息',field:'overinterest'},
   		            {header:'逾期罚息',field:'column9'},
   		            {header:'留购价款',field:'nominalprice'},
   		            {header:'总期数',field:'incomenumber'},
   		            {header:'联系方式',field:'liaisonwayname'},
   		            {header:'起租日',field:'startdate'},
   		            {header:'本金余额/剩余还款期数',field:'corpusorresiduenum',width:170},
   		            {header:'下一次联系日',field:'nextliaisondate'},
   		            {header:'最近一次付款金额/时间',field:'rentordate',width:170},
   		            {header:'催收日',field:'liaisondate'},
   	                {header:'承诺还款日',field:'paydate'},
   	                {header:'承诺还款金额',field:'paymoney'},
   	                {header:'担保人',field:'assurors'},
   	                {header:'担保人联系方式',field:'assurorsnum'},
   	                {header:'承租人邮寄地址',field:'mailadd',width:140}  
		  		   			]
			});
			
		});
});
	
	
</script>
</head>
<body>
    <div class="x-panel-table-div-title" style="border:0px;line-height:30px;text-indent:20px;">逾期明细</div>
    <div id="id_tableContainer"></div>
    <jsp:include page="overdue_visitrecord_info.jsp"></jsp:include>
    <jsp:include page="overdue_rentrecord_info.jsp"></jsp:include>
     <jsp:include page="list2.jsp"></jsp:include>  
      <jsp:include page="overdue_riskadjust_info.jsp"></jsp:include>   
     <jsp:include page="overdue_contractstatus_info.jsp"></jsp:include>  
     
</body>
</html>