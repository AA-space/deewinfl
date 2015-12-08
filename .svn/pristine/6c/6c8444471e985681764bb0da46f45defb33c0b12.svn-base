<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设备管理-收车登记</title>
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
jQuery(function() {
var combo_contract = new tracywindyComboBox({
	lazyLoad:true,
	id : 'id_combo_contract',
	width : 165,
	renderTo : 'id_contract_name',
	xmlFileName : '\\eleasing\\workflow\\public\\comboContractSelect.xml',
	loadMode : 'ajax',
	readOnly : false,
	isAjaxLenovo : true,
	dropListHeight : 300,
	topAdd : 0,
	leftAdd : 0,
	positionDropIconLeftAdd : -1,
	name : 'contract_info',
	displayField : 'name',
	valueField : 'value',
	params : {
	
	},
	onSelect : function(r,v) {
		
	}
});
var combo_cust_leasing = new tracywindyComboBox({
	lazyLoad:true,
	id : 'combo_cust_leasing',
	width : 165,
	renderTo : 'id_cust_leasing',
	xmlFileName : '\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
	loadMode : 'ajax',
	readOnly : false,
	isAjaxLenovo : true,
	dropListHeight : 300,
	topAdd : 0,
	leftAdd : 0,
	positionDropIconLeftAdd : -1,
	name : 'cust_info',
	displayField : 'name',
	valueField : 'value',
	params : {
	
	},
	onSelect : function(r,v) {
		
	}
});
var combo_dealer = new tracywindyComboBox({
	lazyLoad:true,
	id : 'id_combo_dealer',
	width : 165,
	renderTo : 'id_dealer',
	xmlFileName : '\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
	loadMode : 'ajax',
	readOnly : false,
	isAjaxLenovo : true,
	dropListHeight : 300,
	topAdd : 0,
	leftAdd : 0,
	positionDropIconLeftAdd : -1,
	name : 'cust_info',
	displayField : 'name',
	valueField : 'value',
	params : {
	
	},
	onSelect : function(r,v) {
		
	}
});

});
    var constantFlagTable = "User";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	var cust_id="<%= request.getParameter("cust_id")%>";
    var param={};
    if(cust_id!="null" || cust_id==""){param.CUST_ID=cust_id;}
	jQuery(function(){
   	 var table = new tracywindyOperationTable({

   		resetFormCallback:function(table,$form,operFlag){
   		 if("add" == operFlag){
   			var rowData = table.getRowDataAt(0);
   	   		 //document.getElementById("custname").value=rowData["custname"];
   			//$("#custname").val(rowData["custname"]);
   	       }
     	 },
   		 loadFormDataCallBack:function(table,$form,rowIndex){
   		 var rowData = table.getRowDataAt(rowIndex);
   	     //var select_contract = getTracywindyObject("id_combo_id_is_mainPersonFlag");
   	     //select_contract.setValue(rowData["ismain"]);
   	     //var select_contract = getTracywindyObject("id_combo_cust");
  	     //select_contract.setValue(rowData["cust_id"]);
  	   	 //jQuery("#creatorname").val('${sessionScope.loginUser.realname}');
   	    
        },
   		 tableComment:'[收车登记]',
   		 constantFlagTable:'equipmentmanager',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'收车登记',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/cust_account/cust_account_info.xml',
         params:param,
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         columns:[
					{header:'id',name:'id',hidden:true},
		            {header:'合同编号',name:'column1'},
		            {header:'承租客户',name:'column2'},
		            {header:'经销商',name:'column3'},
		            {header:'收回车辆日期',name:'column4'},
		            {header:'车架号',name:'column5'},
		            {header:'登记日期',name:'column6'},
		            {header:'处理计划',name:'column7'},
		            {header:'备注',name:'column8'}
	        ]
   	 });
   });

</script>

 <script type="text/javascript">
     
 </script>
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="收车登记" style="display:none;width:800px;padding-top:20px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:90%">
			            <tr>
			              <td class="input_label_desc">合同编号:  </td>
			               <td class="td-content" >
			              <div id="id_contract_name" style="float: left;" class="leftComboContainer"></div><span class="content-required">*</span>
			            	<input name="id" type="hidden" value=""/>
			            	</td>
			            	<td class="input_label_desc">承租客户:  </td>  
			              <td class="td-content">
			                <div id="id_cust_leasing" style="float: left;" class="leftComboContainer"></div><span class="content-required">*</span></td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">经销商:  </td>  
			            	<td class="td-content">
			            	   <div id="id_dealer" style="float: left;" class="leftComboContainer"></div><span class="content-required">*</span>
			                 </td>
			               <td class="input_label_desc">收回车辆日期:  </td>  
			               <td class="td-content" >
			            		<input name="column4" class="Wdate td-content-input td-content-readonly"  
                                      type="text" value="${requestScope['column4'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="收回车辆日期" /><span class="content-required">*</span></td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">车架号:  </td>  
			            	<td class="td-content">
			            	   <input name="column5" class="td-content-input" require="true" label="车架号"  maxB="150" type="text" />
			                  <span class="content-required">*</span></td>
			               <td class="input_label_desc">登记日期:  </td>  
			               <td class="td-content" >
			            	<input name="column6" class="Wdate td-content-input td-content-readonly"  
                                 type="text" value="${requestScope['column6'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="登记日期" /><span class="content-required">*</span></td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">处理计划:  </td>  
			            	<td class="td-content"  colspan="3">
			            	 <textarea name="column7"  require="true"  class="td-content-input" style="width:70%" label="处理计划" maxB="50"   type="text" ></textarea><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">备注:  </td>  
			            	<td class="td-content"  colspan="3">
			            	 <textarea name="column8"  require="true"  class="td-content-input" style="width:70%" label="备注" maxB="50"   type="text" ></textarea><span class="content-required">*</span>
			            	
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
</body>
</html>