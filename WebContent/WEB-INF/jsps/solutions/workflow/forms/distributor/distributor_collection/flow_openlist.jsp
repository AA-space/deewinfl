<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经销商管理  - 收款管理</title>
    <!--css sheet-->
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
	
	<!--javascript libray-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAttachmentFileUpload.js"></script>
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
   		 tableComment:'[网银信息]',
   		 constantFlagTable:'fundebank',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'网银信息',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/fund_ebank/fund_ebank_info.xml',
         loadMode:'ajax',
         isPage:true,
         operButtons:'',
         
		params : {
				hasMoney : 0,
		        enabled:0
			},
			tools : [ {
				isHtml : true,
				html : '流程名称：'
			}, {
				isHtml : true,
				html : '<div id="id_flow_name" style="float:left;"></div>'
			}, {
				iconCls : 'icon-import',
				html : '<font color="red">收款</font>',
				handler : function(table) {
					var selectDatas = table.getCheckedRowDatas();
					if (0 == selectDatas.length) {
						alert("请选择网银！");
						return "";
					}
					var flowname = getTracywindyObject('id_combo_flow_name').getValue();
					var cust_id = selectDatas[0].custid;
					var ebankid = selectDatas[0].ebdataid;
					var dealerid = selectDatas[0].dealerid;
					if (!flowname) {
						alert("请选择流程!");
						return false;
					} else {
						var attachmentParams = "ebank_id=" + ebankid + "&cust_id=" + cust_id+ "&dealerid=" + dealerid;
						// alert(attachmentParams+":"+flowname);
						startProcess(flowname, attachmentParams);
					}
				}
			} ],
			isFit : true,
			columns : [ {
				header : 'id',
				name : 'id',
				hidden : true
			}, {
				header : '网银编号',
				name : 'ebdataid',
				queryConfig:{}
			}, {
				header : '经销商',
				name : 'custname',
				type : 'text',
				queryConfig : {}
			}, {
				header : '付款人',
				name : 'clientname',
				queryConfig : {isNewLine:true}
			}, {
				header : '本方银行',
				name : 'ownbank',
				hidden : true
			}, {
				header : '本方账户',
				name : 'ownaccount',
				hidden : true
			}, {
				header : '本方账号',
				name : 'ownaccnumber',
				hidden : true
			}, {
				header : '对方银行',
				name : 'clientbank',
				hidden : true
			}, {
				header : '对方账户',
				name : 'clientaccount',
				hidden : true
			}, {
				header : '对方账号',
				name : 'clientaccnumber',
				hidden : true
			}, {
				header : '到账金额类型',
				name : 'moneytype',
				hidden : true
			}, {
				header : '到账金额',
				name : 'factmoney',
				type : "double",
				queryConfig:{}
			}, {
				header : '与系统无关金额',
				name : 'nowithmoney',
				type : "double"
			}, {
				header : '已核销金额',
				name : 'hiremoney',
				type : "double"
			}, {
				header : '网银余额',
				name : 'owmoney',
				type : "double"
			}, {
				header : '到账时间',
				name : 'factdate',
				type : "date",
				isRange : true,
				queryConfig : {
					isNewLine : true
				}
			}, {
				header : '流水号',
				name : 'sn',
				queryConfig : {}
			}, {
				header : '备注',
				name : 'summary',
				hidden : true
			}, {
				header : '登记人',
				name : 'creator_name'
			}, {
				header : '登记时间',
				name : 'create_date'
			} ]
		});
		var combo_cust = new tracywindyComboBox({
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
			name : 'flow_name',
			displayField : 'name',
			valueField : 'value',
			datas : [ {
				name : '经销商保证金收款流程',
				value : '经销商保证金收款流程-1'
			} ],
			onSelect : function(combo) {

			}
		});
	});
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>