<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经销商合同管理</title>
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
    <style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	   .picItem{
	      float:left;
	      padding:5px 5px 5px 5px;
	      border:1px solid silver;
	   }
	</style>

<script type="text/javascript">
jQuery(function(){
	var all_width = (document.documentElement || document.body).clientWidth - 2;
	var all_height = (document.documentElement || document.body).clientHeight - 1;
	var table = new tracywindyOperationTable ({
				renderTo : 'id_table_flowopen_select',
				width : all_width,
				height : all_height,
				isFit : true,
				operButtons:"",
				tools : [ {
					html : '<font color="red">额度调整</font>',
					handler : function(table) {
						var projIDValue = table.getCheckedRowDatas();
						if (0 == projIDValue.length) {
							alert("请选择经销商！");
							return false;
						}
				       var attachmentParams="&cust_id="+projIDValue[0].id+"&dealerid="+projIDValue[0].dealerid;
					   startProcess("经销商额度管理-1", attachmentParams);
					},
					iconCls : 'icon-update'
				} ],
				isPage : true,
				pageSize : 20,
				isCheck : true,
				border:   true,
				emptyChar : '-',
				checkType : 'radio', 
				title:'经销商额度管理',
				xmlFileName : 'eleasing/workflow/distributor/DistributorLimitManagerFlowSelectList.xml',
				columns : [
						{
							header : '经销商名称',
							name : 'custname',queryConfig:{}
						},
						{
							header : '合作经销商编号',
							name : 'contractnum'
						},
						{
							header : '所属区域',
							name : 'ownerdistrict'
						},
						{
							header : '办事处',
							name : 'owneroffice'
						},
						{
							header : '额度',
							name : 'creditmoney'
						},
						{
							header : '当前授信额度开始时间',
							name : 'creditstardate'
						},
						{
							header : '当前授信额度结束时间',
							name : 'creditenddate'
						},
						{
							header : '登记人',
							name : 'creator'
						},
						{
							header : '登记时间',
							name : 'createdate'
						}
						],
			params:{
		           draft:'1',dealerstatuseq:'dealer_symbiosis1',dealerapprovalstatuseq:'agreeApply'
			       //不是草稿,合作状态不为禁用,申请状态不为不通过
				}
				});
	});

function openWindow(){
	var cust_id = getTracywindyObject('id_combo_cust').getValue();
	if (!cust_id) {
		alert("请选择经销商!");
		return false;
	}else {
		   var attachmentParams="&cust_id="+cust_id;
	       startProcess("经销商准入评审-1",attachmentParams);
        }
	}
</script>
</head>
<body>
	<div id="id_table_flowopen_select"></div>
</body>
</html>