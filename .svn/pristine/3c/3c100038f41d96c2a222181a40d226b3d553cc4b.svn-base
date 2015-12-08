<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租赁物管理  - 收车登记</title>
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
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		resetFormCallback:function(table,$form,operFlag){
   		   if("add" == operFlag){
   				var currentCombo = getTracywindyObject("id_combo_contractid");
   				currentCombo.reload();
   	       }
   		   if("update" == operFlag){

	       }
     	 },
   		 loadFormDataCallBack:function(table,$form,rowIndex){
     		 var rowData = table.getRowDataAt(rowIndex);
	   		 var currentCombo = getTracywindyObject(comboId);
	   		 var objMappingArr = [{comboId:'contractid',rowDataMapping:'conid'},
	   		                   {comboId:'custname',rowDataMapping:'custid'}];
			 			    
		     for(var j=0;j<objMappingArr.length;j++){
			     var objMapping = objMappingArr[j];
			     var rowDataValue = rowData[objMapping['rowDataMapping']];
			     var comboId = ("id_combo_"+objMapping['comboId']);
			     var currentCombo = getTracywindyObject(comboId);
			 	 if("contractid" == objMapping['comboId']){
					var cust_id = rowData['custid'];
			 		currentCombo.setParams({"CUST_ID":cust_id});
			 		currentCombo.value = rowDataValue;
				    currentCombo.reload();
				 }else{
				     currentCombo.setValue(rowDataValue);
				     currentCombo.reload();
				 }
			 }
        },
   		 tableComment:'[收车登记]',
   		 constantFlagTable:'EquipRevoke',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'收车登记',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/lease_management/equip_revoke.xml',
         //params:param
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         columns:[
					{header:'id',name:'id',hidden:true},
					{header:'custid',name:'custid',hidden:true},
					{header:'conid',name:'conid',hidden:true},
					{header:'contractid',name:'contractid',hidden:true},
					{header:'合同编号',name:'contract_id'},
					{header:'业务合同号',name:'contractnumber'},
		            {header:'承租客户',name:'custname'},
		            {header:'经销商',name:'custdealer'},
		            {header:'收回车辆日期',name:'revokedate'},
		            {header:'车架号',name:'equipno'},
		            {header:'登记日期',name:'createdate'},
		            {header:'处理计划',name:'revokeplan'},
		            {header:'备注',name:'revokememo'}
	        ]
   	 });
   });

</script>

 <script type="text/javascript">
     jQuery(function(){
    	revoke_cust_name = new tracywindyComboBox({
    	    id:'id_combo_custname',
    	    renderTo:'id_custname',
    	    xmlFileName:'\\eleasing\\jsp\\base\\contractcustname.xml',
    	    loadMode:'ajax',
    	    readOnly:true,
    	    isContainEmpty:false,
    	    width:165,
    	    name:'custname',
    		displayField:'value',
    		valueField:'name',
    	    otherAttributes:'require="true" label="客户名称"',
    	    params:{
    			BUSINESS_TYPE:'bussiness_type_car'
    	    },
    	    onSelect:function(combo){
    	    	var cust_id=combo.getValue();
    			var combo_revoke_contract_id = getTracywindyObject("id_combo_contractid");
    			combo_revoke_contract_id.setParams({"CUST_ID":cust_id});
    			combo_revoke_contract_id.reload();
    	    }
    	 });
    	revoke_contract_id = new tracywindyComboBox({
    	    id:'id_combo_contractid',
    	    renderTo:'id_contractid',
    	    xmlFileName:'\\eleasing\\jsp\\base\\revokecarcontractid.xml',
    	    loadMode:'ajax',
    	    readOnly:true,
    	    isContainEmpty:false,
    	    width:165,
    	    name:'conid',
    		displayField:'value',
    		valueField:'name',
    	    otherAttributes:'require="true" label="合同编号"',
    	    params:{
    			CUST_ID:'NULL',BUSINESS_TYPE:'bussiness_type_car'
    	    },
    	    onSelect:function(combo){
    	    	var valSplitArr = combo.getValue().split(";");
    		    jQuery("input[name='contractid']").val(valSplitArr[0]);
    		    jQuery("input[name='custdealer']").val(valSplitArr[1]);
    	    }
    	 });
     });
</script>
</head>
<body>
 <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="收车登记" style="display:none;height:300px;width:800px;padding-top:20px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:95%" class="fillTable">
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/>
			            <input name="contractid" type="hidden" value=""/>
			            </td></tr>
			            <tr class="tr-even">
			               <td class="td-content-title">承租客户:  </td>  
			            	<td class="td-content">
			            		<div id="id_custname" class="leftComboContainer" style="float:left"></div><font class="required-content">*</font>
			            	</td>
			            	<td class="td-content-title">合同编号: </td>  
			            	<td class="td-content" >
			            	 <div id="id_contractid" class="leftComboContainer" style="float:left"></div><font class="required-content">*</font>
			            	 </td>
			               </tr>
			                <tr class="tr-odd">
			            	<td class="td-content-title">经销商:  </td>  
			            	<td class="td-content">
			            	 <input name="custdealer"  id="custdealer" class="td-content-input td-content-readonly"   type="text"  maxlength="100" label="经销商"  maxB="100" /><font class="required-content">*</font></td>
			                <td class="td-content-title">收回车辆日期:  </td>  
			            	<td class="td-content" >
			            		<input name="revokedate" id="revokedate"  label="收回车辆日期"  class="Wdate td-content-input td-content-readonly"  onClick="WdatePicker(this,{readOnly:true})" readOnly   type="text" />
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">车架号:  </td>  
			            	<td class="td-content" >
			            		<input name="equipno"  class="td-content-input" require="true"  maxlength="200"  label="车架号"   maxB="200"  type="text" /><font class="required-content">*</font>
			            	</td>
			            	<td class="td-content-title">登记日期:  </td>  
			            	<td class="td-content">
			            		<input name="createdate" id="createdate" isDefaultDate="true" label="登记日期 "   class="td-content-input td-content-readonly"  readonly="readonly" type="text" />
			            </tr>
			               <tr  class="tr-odd">
			            	<td class="td-content-title">处理计划:  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="revokeplan" label="处理计划" style="width:84%" ></textarea>
			            	</td>
			            </tr>
			              <tr class="tr-even">
							<td class="td-content-title">备注:</td>
							<td class="td-content" colspan="3">
							<textarea name="revokememo" label="备注" style="width:84%" ></textarea>
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
