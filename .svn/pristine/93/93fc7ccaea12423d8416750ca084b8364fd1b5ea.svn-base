<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金计划开票确认（收据）</title>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
<style type="text/css">
	html,body{
		overflow:hidden;
	}
</style>
<script type="text/javascript">
var currentLoginUserId = "${sessionScope['login_userid']}";
var isAdmin = false;
var buttons = {
	exportData : {
		html : '<font color="red">导出收据</font>',
		handler : function(table) {
			var operType = "导出";
			var operTitle = "租金计划收据";
 	 		var checkedRowDatas = table.getCheckedRowDatas();
 	 		var selectRowsCount = checkedRowDatas.length;
	 		if(0 == selectRowsCount){
				alert("请选择要"+operType+"的记录！！");
				return;
			}
	 		if(1 < selectRowsCount){
				alert("每次只能导出一条数据！！");
				return;
			}

 	 		var tempIdArr = [];
	 		for(var i = 0;i < selectRowsCount; i++){
				var checkedRowdata = checkedRowDatas[i];
				var id = checkedRowdata.id;
				var checkedRawData=checkedRowDatas[i];
				if("已确认" != checkedRawData.status){
					alert("只能导出已确认的数据");
					return;
				}
				tempIdArr.push(id);
			}
	 		
			if(window.confirm("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？")) {
				var loadMaskMsg="正在"+operType+operTitle+"	请稍后... ";
				var currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
				currentLoadMask.show();
				var ids = "'" + tempIdArr.join("','") + "'";
				var attachmentParams = {
					ids:ids,
					userid:'${sessionScope["login_userid"]}',
					url:'/leasing/template/createFileByTemplateClass.action',
					title:"租金计划开票确认收据",
					modelname:'wordtempletypefirst.5',
					twoClassify:'rentplanconfirmreceipt',
					returnType:'file',
					functionField:"moneychinese",
					'function':"convertMoneyToChinese",
					custoperatorMethod:''// TODO 需要回写数据库确认
				};
				//把导出数据和导出参数合并成一个新的参数,checkedRowDatas[0]传入xml,attachmentParams传入后台
				var params = jQuery.extend({}, checkedRowDatas[0], attachmentParams);
				attachmentDown(params);
			}
		},
		iconCls : 'icon-print'
	},
	cancel : {
		html : '<font color="red">退回</font>',
		iconCls : 'icon-cancel',
		handler : function(table) {
			var operType = "退回";
			var operTitle = "租金计划应开票清单(收据)";
			var operAction = "backRentPlanReceipt";// TODO 无Action
	 		var checkedRowDatas = table.getCheckedRowDatas();
			var currentLoadMask = null;
			var params = {};
			var tempIdArr = [];
			for(var i = 0;i<checkedRowDatas.length;i++){
				var checkedRowdata = checkedRowDatas[i];
				var id = checkedRowdata.id;
				tempIdArr.push(id);
			}
			params["ids"] = tempIdArr.join(",");
	 		if(0 == checkedRowDatas.length){
				alert("请选择要"+operType+"的记录！！");
				return;
			}
	 		for(var i =0;i<checkedRowDatas.length;i++){
				var checkedRawData=checkedRowDatas[i];
				if("已确认"==checkedRawData.invoicestatus){
					alert("该条"+operTitle+"已确认，不允许退回！！！");
					return;
				} 
			}
			if(window.confirm("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？")){
				var loadMaskMsg="正在"+operType+operTitle+"	请稍后... ";
				var url=getRootPath()+"/acl/"+operAction+".acl";
				currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
				currentLoadMask.show();
				ajaxRequest({
					url:url,
					params:params,
					timeout:30*1000,
					failure:function(){
						alert("操作失败！！");
					},
					success:function(res){//孙传良 修改 显示出action返回值
						res=res.responseText;
						res=res.replace(/(^\s+)|(\s+$)/g, ""); 
						if(res!=''){
							alert(res);
						}else{
							alert(operType+operTitle+"成功！！");
						}
						currentLoadMask.hide();
						table.reload();
					}
				});
			}
		}
 	},
	confirm : {
		html : '<font color="red">确认</font>',
		iconCls : 'icon-ok',
		handler : function(table) {
			var operType = "确认";
			var operTitle = "租金计划应开票清单(收据)";
			var operAction = "confirmRentPlanReceipt";// TODO 无Action
			var checkedRowDatas = table.getCheckedRowDatas();
			var currentLoadMask = null;
			var params = {};
			var tempIdArr = [];
			for(var i = 0;i<checkedRowDatas.length;i++){
				var checkedRowdata = checkedRowDatas[i];
				var id = checkedRowdata.id;
				tempIdArr.push(id);
			}
			params["ids"] = tempIdArr.join(",");
			if(0 == checkedRowDatas.length){
				alert("请选择要"+operType+"的记录！！");
				return;
			}
			for(var i =0;i<checkedRowDatas.length;i++){
				var checkedRawData=checkedRowDatas[i];
				if("已确认"==checkedRawData.invoicestatus){
					alert("该条"+operTitle+"已确认，不允许退回！！！");
					return;
				} 
			}
			if(window.confirm("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？")) {
				var loadMaskMsg="正在"+operType+operTitle+"	请稍后... ";
				var url=getRootPath()+"/acl/"+operAction+".acl";
				currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
				currentLoadMask.show();
				ajaxRequest({
					url:url,
					params:params,
					timeout:30*1000,
					failure:function(){
						alert("操作失败！！");
					},
					success:function(res){//孙传良 修改 显示出action返回值
						res = res.responseText;
						res = res.replace(/(^\s+)|(\s+$)/g, ""); 
						if(res != '') {
							alert(res);
						} else {
							alert(operType+operTitle+"成功！！");
						}
						currentLoadMask.hide();
						table.reload();
					}
				});
			}
		}
	}
};

var userButtons = [];
var hasConfirmButton = false;//是否有确认按钮
var hasExportButton = false;//是否有导出按钮
var hasCancelButton = false;//是否有退回按钮
</script >

<permission:action code="admin_action">
	<script type="text/javascript">
		isAdmin = true;
	</script>
</permission:action>

<permission:action code="interest_master">
	<script type="text/javascript">
		if(false == hasConfirmButton){
			userButtons.push(buttons.confirm);
			hasConfirmButton = true;
		}
		if(false == hasExportButton){
			userButtons.push(buttons.exportData);
			hasExportButton = true;
		}
		if(false == hasCancelButton){
			userButtons.push(buttons.cancel);
			hasCancelButton = true;
		}
	</script >
</permission:action>

<permission:action code="rent_account">
	<script type="text/javascript">
		if(false == hasConfirmButton){
			userButtons.push(buttons.confirm);
			hasConfirmButton = true;
		}
		if(false == hasExportButton){
			userButtons.push(buttons.exportData);
			hasExportButton = true;
		}
		if(false == hasCancelButton){
			userButtons.push(buttons.cancel);
			hasCancelButton = true;
		}
	</script >
</permission:action>

<permission:action code="fund_account">
	<script type="text/javascript">
		if(false == hasConfirmButton){
			userButtons.push(buttons.confirm);
			hasConfirmButton = true;
		}
		if(false == hasExportButton){
			userButtons.push(buttons.exportData);
			hasExportButton = true;
		}
		if(false == hasCancelButton){
			userButtons.push(buttons.cancel);
			hasCancelButton = true;
		}
	</script >
</permission:action>

<script type="text/javascript">
var all_width = (document.documentElement||document.body).clientWidth-2;
var all_height = (document.documentElement||document.body).clientHeight-2;

jQuery(function(){
	new tracywindyOperationTable({
		renderTo:'id_tableContainer',
		width:all_width,
		height:all_height,
		windowTop:20,
		border:true,
		title:'租金计划开票确认（收据）',
		tools : userButtons,
		id:'id_table',
		xmlFileName:'/eleasing/jsp/invoice_manage/rent_invoice/rent_invoice_plan_receip_confirm.xml',
		loadMode:'ajax',
		isPage:true,
		pageSize : 20,
		isCheck:true,
		isRank:false,
		columns:[
			{name:'id',  header:'id',hidden:true},
			{header:'合同号',name:'contractid',  queryConfig:{}},
			{header:'业务合同编号',name:'contractnumber', width:150, queryConfig:{}},
			{header:'经销商',name:'dealername'},
			{header:'期项',name:'rentlist' ,width:50  },
			{header:'计划收款日',name:'plandate',type:"date",isRange:true,queryConfig:{isNewLine:true}},
			{header:'开票金额',name:'invoicemoney',  type:'double' },
			{header:'金额类型',name:'moneytype' },
			{header:'开票类型',name:'taxtype'  },
			{header:'纳税人识别号',name:'taxregcode'},
			{header:'开户行',name:'taxbank'},
			{header:'账号',name:'taxacc'},
			{header:'电话',name:'taxphone'},
			{header:'地址',name:'taxregadd'},
			{header:'状态',name:'status',type:'combobox',
				queryConfig:{
					isNewLine:false,
					colSpan:3,
					loadMode:'local',
					datas:[
						{title:'已导出',name:'已导出'},
						{title:'已确认',name:'已确认'},
						{title:'已退回',name:'已退回'},
						{title:'确认中',name:'确认中'},
						{title:'未提交',name:'未提交'},
						{title:'全部',name:''}
					],
					displayField:'title',
					valueField:'name',
					defaultValue:1
				}
			}
		]
	});
});
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>