<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经销商--保证金抵扣流程</title>
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
var dealer_id="${sessionScope['currentDealerCustInfoId']}";
var dealer_name="${sessionScope['currentDealerCustInfoName']}";
jQuery(function(){
	var all_width = (document.documentElement || document.body).clientWidth - 2;
	var all_height = (document.documentElement || document.body).clientHeight - 1;
	var table = new tracywindyOperationTable ({
				renderTo : 'id_table_flowopen_select',
				width : all_width,
				height : all_height,
				isFit : true,
				title:"经销商保证金退款流程",
				operButtons:"",
				tools : [ {
					html : '<font color="red">抵扣</font>',
					handler : function(table) {
						var projIDValue = table.getCheckedRowDatas();
						if (0 == projIDValue.length) {
							alert("请选择保证金！");
							return false;
						}
				    var attachmentParams="&dealerid="+projIDValue[0].dealerid+"&fundid="+projIDValue[0].id+"&dealerkeyid="+projIDValue[0].dealerkeyid;
					startProcess("经销商保证金抵扣流程-1", attachmentParams);
					},
					iconCls : 'icon-update'
				} ],
				isPage : true,
				pageSize : 20,
				isCheck : true,
				border:   true,
				emptyChar : '-',
				checkType : 'radio',
				xmlFileName : 'eleasing/workflow/public/fundfundMPlanSelect.xml',
				columns : [
				           {name:'id',  header:'id',hidden:true},
				           {name:'dealerid',  header:'经销商ID',hidden:true},
				          /*  {name:'dealer_name',header:'经销商',type : 'combobox',
				        	   queryConfig : {
									xmlFileName : '/eleasing/jsp/fund_ebank/fund_ebank_info.xml',
									loadMode : 'ajax',
									width : 200,
									isAjaxLenovo:true,
									readOnly:false,
									name : 'custname',
									displayField : 'custname',
									valueField : 'custname',
							}}, */
						   {name:'dealer_name',header:'经销商',type : 'text',queryConfig : {}},
					       {name:'factmoney',  header:'实收金额',nullable:false,type:'double',queryConfig : {}},
					       {name:'deductionmoney',  header:'抵扣金额',nullable:false,type:'double'},
					       {name:'drawbackmoney',  header:'退款金额',nullable:false,type:'double'},
					       {name:'crwmoney',  header:'红冲金额',nullable:false,type:'double'},
					       {name:'overmoney',  header:'保证金余额',nullable:false,type:'doule'},
					       {name:'factdate',  header:'到账时间',nullable:false}
						],
			params:{
		         hasmoney:'0',dealer_number:dealer_id
				}
		});
	});
</script>
</head>
<body>
	<div id="id_table_flowopen_select"></div>
</body>
</html>