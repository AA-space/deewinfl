<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>其它功能 - 保险管理</title>
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
    var constantFlagTable = "ContractDocInfo";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
		
		commonSelectOverall('contractidname2','CONTRACT_INFO','ID','CONTRACT_ID','contractid','','','require="true" label="合同号"',function(combo,data){choseNext(combo,'id_combo_contractidname','CONTRACT_INFO');},true);
		commonSelectOverall('contractidname','CONTRACT_INFO','ID','CONTRACT_ID','contractid','','','require="true" label="合同号"',function(combo,data){choseNext(combo,'id_combo_contractidname','CONTRACT_INFO');},true); 
		//commonSelectOverall('borrowername','T_USERS','ID_','REALNAME_','borrower','','','require="true" label="借阅人"',function(combo,data){choseNext(combo,'id_combo_borrowername','T_USERS');},true);
		//commonSelectOverall('createpersonname','T_USERS','ID_','REALNAME_','createperson','','','require="true" label="创建人"',function(combo,data){choseNext(combo,'id_combo_borrowername','T_USERS');},true);

		//commonSelectOverall('documentstatusname','T_DICTS_DATAS','ID_','NAME_','documentstatus','','','require="true" label="文档状态"',function(combo,data){choseNext(combo,'id_combo_documentstatusname','T_DICTS_DATAS');},true);

		
		var table = new tracywindyOperationTable({
			resetFormCallback:function(table,$form,operFlag){
			/*
			if("add" == operFlag){
				getTracywindyObject("id_combo_custtypename").setValue("cust_type.cust");
				getTracywindyObject("id_combo_draftname").readOnlyData = false;
   	   	  		getTracywindyObject("id_combo_draftname").reload();
				getTracywindyObject("id_combo_draftname").setRawValue("否");
				getTracywindyObject("id_combo_draftname").setValue("1");
				jQuery("#invalidname").val("否");
				jQuery("#invalid").val("1");
				jQuery("#creatorname").val('${sessionScope.loginUser.realname}');
				MustFillIn.setRequire(custType.lawCust);//默认承租人
				MustFillIn.GoCheck(document.getElementById("id_detailInfoForm"));
			}*/
   	     },
   		 loadFormDataCallBack:function(table,$form,rowIndex){
			var rowData = table.getRowDataAt(rowIndex);
			/*var objList=["custtypename","custkindname","industryname","industrylevelbigname","industrylevelmiddlename","industrylevelsmallname"
			 			,"provincename","cityname","countyname","ownershipname","custscalename","taxlevelname","isassociatedname"
			 			,"draftname","reditorrightname","assurorrightname","creatordept"];*/
 			var objMappingArr = [
 			       			    {comboId:'contractidname',rowDataMapping:'contractid'},
 			       				//{comboId:'createpersonname',rowDataMapping:'createperson'},
 			       				//{comboId:'documentstatusname',rowDataMapping:'documentstatus'},
 			       				//{comboId:'borrowername',rowDataMapping:'borrower'}
 			                  ];
		     for(var j=0;j<objMappingArr.length;j++){
			     var objMapping = objMappingArr[j];
			     var parentRowDataMapping = objMapping['parentRowDataMapping'];
			     var rowDataValue         = rowData[objMapping['rowDataMapping']];
			     var comboId   =  ("id_combo_"+objMapping['comboId']);
			     var currentCombo = getTracywindyObject(comboId);
			     if(parentRowDataMapping){
				     var parentRowDataMappingValue = rowData[parentRowDataMapping];
				    // alert(parentRowDataMapping+":"+parentRowDataMappingValue);
				     var tableName = objMapping['tableName'];
				     currentCombo.setParams({tableName:"(select id,name from "+tableName+" where pid='"+parentRowDataMappingValue+"') rs "}) ;
					 var loadCompleteFunc = (function(combo,rowDataValue){
						       return function(combo){
						    	   combo.setValue(rowDataValue);
							  };
					 })(currentCombo,rowDataValue);
					 currentCombo.loadComplete = loadCompleteFunc;
				}
			    else{
			    	currentCombo.setValue(rowDataValue);
			   }
			    currentCombo.reload();
			 }
			/*var objListId=["custtype","custkind","industry","industrylevelbig","industrylevelmiddle","industrylevelsmall",
			   			"province","city","county","ownership","custscale","taxlevel","isassociated"
			 			,"draft","reditorright","assurorright","creatordept"];
			for(var j=0;j<objList.length;j++){
				try{
					getTracywindyObject("id_combo_"+objList[j]).setValue(rowData[objListId[j]]);
				}catch(e){
					alert(objList[j]+"|"+rowData[objListId[j]]);
				}
			}
			//changeCustType();//修改时加载必填
			if(getTracywindyObject("id_combo_draftname").getValue()=='1'){//不是草稿的时候不能修改
   	   	  		getTracywindyObject("id_combo_draftname").readOnlyData = true;
   	   	  		getTracywindyObject("id_combo_draftname").reload();
			}else{
				getTracywindyObject("id_combo_draftname").readOnlyData = false;
   	   	  		getTracywindyObject("id_combo_draftname").reload();
			}*/
    	 },
			 tableComment:'保险管理',
	   		 constantFlagTable:'ContractDocInfo',
	         renderTo:'id_tableContainer',
	         title:'保险管理',
	         width:pageWidth,
	         height:pageHeight,
	         id:'id_table',
	         xmlFileName:'/eleasing/jsp/other/insurance_manage/list.xml',
	         loadMode:'ajax',
	         isPage:true,
	        // isFit:true,
	         border:true,
	         isRank:true,
	         columns:[
						
						{header:'客户名称',name:'id'},
						{header:'合同号',name:'id'},
						{header:'车架号',name:'id'},
						{header:'保单号',name:'id'},
						{header:'保险公司',name:'id'},
						{header:'险种',name:'id'},
						{header:'保费',name:'id'},

						{header:'开始日期',name:'id'},
						{header:'开始日期',name:'id'},
						{header:'受益人',name:'id'}
		        ]
         
   	 });
   	 
   });
	
</script>
</head>
<body>
<div id="id_tableContainer"></div>
<div id="id_detailInfoWindowContainer" title="添加保险管理信息"
	style="display: none; width: 800px; height: 400px">
<center>
<form id="id_detailInfoForm">
<table style="width: 90%">
	<tr>
			<td class="input_label_desc" align="left">客户名称:</td>
			<td class="input_value">
			<div style="float: left" class="leftComboContainer"
				id="contractidname"></div><span class="content-required">*</span>
			</td>
			
			<td class="input_label_desc" align="left">合同号:</td>
			<td class="input_value">
			<div style="float: left" class="leftComboContainer"
				id="contractidname2"></div><span class="content-required">*</span>
			</td>
		</tr>
	
		<tr>
			<td class="input_label_desc" align="left">车架号:</td>
			<td class="td-content"><input name="cupboardno" require="true"  class="td-content-input"
				label="车架号" type="text" /><span class="content-required">*</span></td>
				
			<td class="input_label_desc" align="left">保单号:</td>
			<td class="td-content"><input name="cupboardno" require="true"  class="td-content-input"
				label="保单号" type="text" /><span class="content-required">*</span></td>
		</tr>

		<tr>
			<td class="input_label_desc" align="left">险种:</td>
			<td class="td-content"><input name="cupboardno" require="true"  class="td-content-input"
				label="险种" type="text" /><span class="content-required">*</span></td>
				
			<td class="input_label_desc" align="left">保险公司:</td>
			<td class="td-content"><input name="cupboardno" require="true"  class="td-content-input"
				label="保险公司" type="text" /><span class="content-required">*</span></td>
		</tr>
		
		
		<tr>
			<td class="input_label_desc" align="left">保费:</td>
			<td class="td-content"><input name="cupboardno" require="true"  class="td-content-input"
				label="保费" type="text" /><span class="content-required">*</span></td>
				
			<td class="input_label_desc" align="left">受益人:</td>
			<td class="td-content"><input name="cupboardno" require="true"  class="td-content-input"
				label="受益人" type="text" /><span class="content-required">*</span></td>
		</tr>
		
		<tr>
			<td class="input_label_desc" align="left">开始日期:</td>
			<td class="td-content">
			<input name="borrowdate" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['borrowdate'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="开始日期" /><span class="content-required">*</span></td>
			
		<td class="input_label_desc" align="left">结束日期:</td>
			<td class="td-content">
			<input name="borrowdate" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['borrowdate'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="结束日期" /><span class="content-required">*</span></td>
		</tr>

		<tr class="content-separator">
			<td colspan='4'><a style="margin-left: 20px;"
				href="javascript:void(0);" class="btn btn-primary"
				onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a>
			<a style="margin-left: 20px;" href="javascript:void(0);"
				class="btn btn-primary"
				onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
			</td>
		</tr>
</table>
</form>
</center>
</div>

</body>
</html>