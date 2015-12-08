<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金回笼</title>
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
//var proj_id="<%= request.getParameter("id")%>";
var param={};
//if(proj_id!="null" || proj_id==""){param.proj_id=proj_id;}
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	
	var attachmentParams;
	jQuery(function(){
	 var table = new tracywindyOperationTable({
		 tableComment:'[租金回笼信息]',
		 constantFlagTable:'ProjInfo',
		 windowTop:20,
	     border:true,
      renderTo:'id_tableContainer',
      title:'租金回笼信息',
      width:parseInt("${param.tableWidth}")||pageWidth,
      height:parseInt("${param.tableHeight}")||pageHeight,
      id:'id_table',
      xmlFileName:'\\eleasing\\workflow\\contract\\contract_fund_charge_incom_list.xml',
      loadMode:'ajax',
      params:{
				CONTRACT_STATUS_LessThan : 100, 
				CONTRACT_STATUS_GreaterThan : 30,
				hasMoney : "1",
				palndate_end : getCurDate(),
				dealer_id:"${sessionScope['currentDealerCustInfoId']}",
				total:'1'
			},
      isPage:true,
      operButtons:' ',
      isFit:false,
      isExcel:true,
      tools:[{
     	 html : '<font color="red">回笼</font>',
		 handler : function(table) {
			 
			
				var projIDValue = table.getCheckedRowDatas();
				if (0 == projIDValue.length) {
					alert("请选择需要启动的流程！");
					return false;
				}
				attachmentParams = "cust_id="+projIDValue[0].custid+"&contract_id=" + projIDValue[0].id ;
				var custid = projIDValue[0].custid;
				var dealerid = projIDValue[0].custdealerid;
				var param_ = {};
				param_.hasMoney = '0';
				param_.enabled='0';//只显示有效的
				param_.custordealer="1";//设置为或者查询
				//因为或者查询必须有值 所以如果没有值就把值设置为-
				if(!custid||custid==""){
					custid = "-";
				}
				if(!dealerid||dealerid==""){
					dealerid = "-";
				}
				param_.cid=custid;
				param_.did=dealerid;
				
				var table_ebank = getTracywindyObject('table_ebank');
				table_ebank.setParams(param_);
				table_ebank.reload();
				
				jQuery("#ebank").show();
				jQuery("#ebank").window({
					   top:10
				  });
				 jQuery("#ebank").window("open");
				
				
				//startProcess("收款流程-4",attachmentParams);
			},
			iconCls :'icon-update'
          },
          {
          	 html : '<font color="red">租金红冲</font>',
     		 handler : function(table) {
     			 
     			
     				var projIDValue = table.getCheckedRowDatas();
     				if (0 == projIDValue.length) {
     					alert("请选择需要启动的流程！");
     					return false;
     				}
     				attachmentParams = "cust_id="+projIDValue[0].custid+"&contract_id=" + projIDValue[0].id+"&feetype=red" ;
     				startProcess("租金回笼流程-1", attachmentParams);
     		 }
          },
          {
				isHtml : true,
				html : '选择显示合同信息：'
		  }, {
				isHtml : true,
				html : '<div id="id_flow_name" style="float:left;"></div>'
			}
     	],
      columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'proj_id',name:'proj_id',hidden:true},
		            {header:'pid',name:'pid',hidden:true},
		            {header:'custid',name:'custid',hidden:true},
		            {header:'typecode',name:'typecode',hidden:true},
		            {header:'项目名称',name:'projname',width:300,queryConfig:{}},
		            {header:'合同编号',name:'contractid',queryConfig:{}},
		            {header:'业务合同号',name:'contractnumber',width:150,queryConfig:{}},
		            {header:'客户名称',name:'custname',queryConfig:{isNewLine:true}},
		            {header:'经销商名称',name:'custdealer',width:200,queryConfig:{}},
		            {header:'业务类别',name:'businesstype'},
		            {header:'业务模式',name:'businessmode'},
		            {header:'区域',name:'ownerdistrict'},
		            //{header:'项目类型',name:'projtype'},
		            //{header:'项目来源',name:'projsource'},
		            //{header:'项目规模',name:'projscale'},
		            //{header:'资产分类',name:'industrytype'},
		            //{header:'租赁形式',name:'leasform'},
		            //{header:'客户经理',name:'projmanage'},
		            {header:'月租金',name:'yrent'},
					{header:'应收罚息',name:'penalty'},
		            {header:'结束时间',name:'palndate',  type:"date",isRange:true,queryConfig:{}}
      ]
	 });
	 
	 var combo_type = new tracywindyComboBox({
			id : 'id_combo_flow_name',
			width : 200,
			renderTo : 'id_flow_name',
			loadMode : 'local',
			readOnly : false,
			isAjaxLenovo : true,
			isContainEmpty : false,
			dropListHeight : 300,
			topAdd : 0,
			leftAdd : 0,
			positionDropIconLeftAdd : -1,
			value:'1',
			name : 'flow_name',
			displayField : 'name',
			valueField : 'value',
			datas : [ 
			    {
				name : '回笼合同',
				value : '1'
			    },{
					name : '全部合同',
					value : ''
				}],
			onSelect : function(combo) {
				var table = getTracywindyObject('id_table');
				//alert(table);
				 table.setParams({
	                    total: combo.getValue()
	                });
	                table.reload();

			}
		});
});
	jQuery(function(){
	   	 new tracywindyOperationTable({
	         displayToggleContainer:'ebank',
	   		 tableComment:'[网银信息]',
	   		 constantFlagTable:'fundebank',
	   		 windowTop:20,
	   	     border:true,
	         renderTo:'id_ebank',
	         title:'网银信息',
	         width:(parseInt("${param.tableWidth}")||pageWidth) - 300,
	         height:(parseInt("${param.tableHeight}")||pageHeight)-140,
	         id:'table_ebank',
	         xmlFileName:'eleasing/jsp/fund_ebank/fund_ebank_info.xml',
	         displayToggleContainer:"table_ebank",
	         loadMode:'ajax',
	         isPage:true,
	         operButtons:' ',
	         isFit:true,
	         operButtons:' ',
	         params:{
	        	 enabled:0
			 },
	         //params : param_,
	         tools:[{
	         	 html : '<font color="red">收款</font>',
	 			handler : function(table) {
	 				var projIDValue = table.getCheckedRowDatas();
	 				if (0 == projIDValue.length) {
	 					alert("请选择需要的网银");
	 					return false;
	 				}
	 				
	 				attachmentParams = attachmentParams + "&ebank_id=" +projIDValue[0].id ;
	 				startProcess("租金回笼流程-1", attachmentParams);
	 			},
	 			iconCls :'icon-update'
	           }],
	         isFit:false,
	         columns:[
	                    {header:'id',name:'id',hidden:true},
	                    {header:'custdealerid',name:'custdealerid',hidden:true},
			            {header:'网银编号',name:'ebdataid',queryConfig:{}},
			            {header:'经销商',name:'custname'},
			            {header:'付款人',name:'clientname',queryConfig:{}},
			            {header:'本方银行',name:'ownbank',hidden:true},
			            {header:'本方账户',name:'ownaccount',hidden:true},
			            {header:'本方账号',name:'ownaccnumber',hidden:true},
			            {header:'对方银行',name:'clientbank',hidden:true},
			            {header:'对方账户',name:'clientaccount',hidden:true},
			            {header:'对方账号',name:'clientaccnumber',hidden:true},
			            {header:'到账金额类型',name:'moneytype',hidden:true},
			            {header:'到账金额',name:'factmoney',queryConfig:{}},
			            //{header:'与系统无关金额',name:'nowithmoney'},
			            {header:'已核销金额',name:'hiremoney'},
			            {header:'可核销金额',name:'owmoney'},
			            {header:'到账时间',name:'factdate'},
			            {header:'流水号',name:'sn'},
			            {header:'备注',name:'summary'},
			            {header:'用途',name:'usefor'}
			            //{header:'登记人',name:'creator_name'},
			            //{header:'登记时间',name:'create_date'}
		        ]
	   	 });
	   });
 </script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
	    <div id="ebank" style="display: none;overflow:hidden;" title="选择网银">
	    	<div id="id_ebank"></div>
    </div>
	<script type='text/javascript'>
	    var ebankDom =document.getElementById("ebank");
	    ebankDom.style.height= ((parseInt("${param.tableHeight}")||pageHeight) - 100)+"px";
	</script>
</body>
</html>