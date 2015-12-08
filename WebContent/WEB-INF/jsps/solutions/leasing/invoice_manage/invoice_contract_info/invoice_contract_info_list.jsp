<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发票管理-应开票合同信息</title>
<!--css sheet-->
<link href="${pageContext.request.contextPath}/css/dtree/dtree.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/button.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css"
	rel="stylesheet" type="text/css">
<!--javascript libray-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/validator.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
<style type="text/css">
html,body {
	overflow: hidden;
}
</style>
<script type="text/javascript">
    var currentLoginUserId = "${sessionScope['login_userid']}";

	var constantFlagTable = "User";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
		 //选合同
		combo_proj = new tracywindyComboBox({
		    id:'id_combo_proj',
		    width:165,
		    renderTo:'id_contract_id',
		    xmlFileName:'\\eleasing\\workflow\\contract\\contractSelectForPerson.xml',
		    loadMode:'ajax',
		    readOnly:false,
		    isAjaxLenovo:false,
		    dropListHeight:300,
		    topAdd:0,
		    leftAdd:0,
		    positionDropIconLeftAdd:-1,
		    name:'contractid',
		    displayField:'contractnumber',
		    valueField:'id',
		    params:{
		    	cust_class:'CUST_INFO_PERSON'
		    },
		    onSelect:function(combo){
		    	
		    }
		 });
		 
   	     new tracywindyOperationTable({
   	    	
   		 tableComment:'[应开票合同信息]',
   		 constantFlagTable:'InvoiceContractInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'应开票合同信息',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'\\eleasing\\jsp\\invoice_manage\\invoice_contract_info\\invoice_contract_info_list.xml',
         loadMode:'ajax',
         isPage:true,
         //tools:tools,
         isFit:true,
         operButtons:'新增|删除',
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'用户名',name:'custname',queryConfig:{}},
		            {header:'用户类型',name:'custclass'},
		            {header:'合同号',name:'contractnumber',queryConfig:{}}
	        ]
         
   	 });
   	 
   });
</script>
</head>
<body>
<div id="id_tableContainer"></div>
<center>
<div id="id_detailInfoWindowContainer"  title="应开票合同信息" style="display:none;width:500px;height:400px">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:90%">
			            <tr style="display:none">
			            <td><input name="id" id="id" type="hidden" value=""/></td>
			            <td><input name="custclass" id="custclass" type="hidden" value=""/></td>
			            </tr>
			            <tr>
			           <td class="input_label_desc" align="left">合同编号:  </td>  
			            	<td class="td-content">
			            	<div id='id_contract_id' class="leftComboContainer"></div>
	            			</td>
			            </tr>
			           
			            <tr class="content-separator">
				            <td colspan='4'>
				                 <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a>
						         <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
				            </td>
			            </tr>
			        </table>
		        </form>
	        </center>
	</div>
</center>
</div>

</body>
</html>