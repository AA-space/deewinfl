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
		 new tracywindyMultiTable({
   		 windowTop:20,
   	     border:true,
   	     isNeedTools:false,
         renderTo:'id_tableContainer',
         width:window.formWidth||parseInt("${param.tableWidth}")||pageWidth,
        // height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/fund_overduerent/overdue_rent_info.xml',
         loadMode:'ajax',
         isPage:true,
         params:{contract_id:contract_id},
         isFit:false,
         columns:[
                  {header:'id',name:'id',hidden:true},
		            {header:'客户名称',name:'custname'},
		            {header:'合同号',name:'contractid'},
		            {header:'合同状态',name:'contractstatusname'},
		            {header:'催款员',name:'dun'},
		            {header:'事业部',name:'projdeptname'},
		            {header:'省份',name:'provincename'},
	                {header:'身份证/组织机构代码',name:'idcardorcode',width:140},
	                {header:'经销商',name:'dealername'},
		            //{header:'项目出单部门',name:'projdeptname'},
		            {header:'项目经理',name:'projmanagename'},
		            {header:'逾期期数',name:'overinterest'},
		            {header:'逾期租金',name:'overrent'},
		            {header:'逾期利息',name:'overinterest'},
		            {header:'逾期罚息',name:'column9'},
		            //{header:'逾期期数',name:'column10'},
		            {header:'留购价款',name:'nominalprice'},
		            {header:'总期数',name:'incomenumber'},
		            {header:'联系方式',name:'liaisonwayname'},
		            {header:'起租日',name:'startdate'},
		            {header:'本金余额/剩余还款期数',name:'corpusorresiduenum',width:170},
		            {header:'下一次联系日',name:'nextliaisondate'},
		            {header:'最近一次付款金额/时间',name:'rentordate',width:170},
		            {header:'催收日',name:'liaisondate'},
	                {header:'承诺还款日',name:'paydate'},
	                {header:'承诺还款金额',name:'paymoney'},
	                {header:'担保人',name:'assurors'},
	                {header:'担保人联系方式',name:'assurorsnum'},
	                {header:'承租人邮寄地址',name:'mailadd',width:140}
	                //{header:'产品型号',name:'model'},
	                // {header:'整机编号',name:'eqipid'},
	                // {header:'台数',name:'equipnum'}      


		            
	        ]
   	 });
   // 	commonSelectOverall('id_select_contract_id',"(select ci.contract_id,ci.id||'/'||cust.cust_name value from contract_info ci left join cust_info cust on (ci.cust_id=cust.id)) rs",'value',"contract_id",'contractid','','','',selectContract,false);
  //   	dictYesOrNoByCode('id_select_is_insured','isinsured',1,'','','require="true" label="是否投保"');
   });

</script>
</head>
<body>
    <div class="x-panel-table-div-title" style="border:0px;line-height:30px;text-indent:20px;">逾期明细</div>
    <div id="id_tableContainer"></div>
    
    <jsp:include page="overdue_visitrecord_info.jsp"></jsp:include>
    <jsp:include page="overdue_rentrecord_info.jsp"></jsp:include>
    <jsp:include page="../other/lawsuit/list2.jsp"></jsp:include>
</body>
</html>