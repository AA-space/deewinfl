<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>其它功能 - GPS接口导入</title>
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
    var constantFlagTable = "GPSInterfacesInfo";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	function importEbankCallBack(message){
        alert(message);
    	window.currentImportExcelLoadMask.hide();
    	var table = getTracywindyObject("id_table");
    	table.reload();
    }
	var importcolumn= [
			{header:'用户名称',mapping:'gpsuser'},
			{header:'车牌号',mapping:'carno'},
			{header:'VIN码',mapping:'chassisnum'},
			{header:'终端号',mapping:'simno'},
			{header:'车辆状态',mapping:'carstatus'},
			{header:'地理位置',mapping:'caraddr'},
			{header:'车速',mapping:'carspeed'},
			{header:'转速',mapping:'carpinwheel'},
			{header:'里程',mapping:'carmileage'},
			{header:'定位时间',mapping:'cardate'},
			{header:'方向',mapping:'cardirection'},
			{header:'开关量',mapping:'offoron'}
	  	    ];
	jQuery(function(){
		var table = new tracywindyOperationTable({
			/*resetFormCallback:function(table,$form,operFlag){
				if("add" == operFlag){
				alert("addddddd");
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
			}
   	   },
   	   loadFormDataCallBack:function(table,$form,rowIndex){
  		   alert("loadFormDataCallBack:function");

       },*/
    	////////////////////////////////////////////////////////////
			 tableComment:'GPS接口导入',
	   		 constantFlagTable:'GpsInterfacesInfo',
	         renderTo:'id_tableContainer',
	         title:'GPS接口导入',
	         width:pageWidth,
	         height:pageHeight,
	         id:'id_table',
	         xmlFileName:'/eleasing/jsp/other/interface_import/list1.xml',
	         loadMode:'ajax',
	         isPage:true,
	        // isFit:true,
	         border:true,
	         isRank:true,
	         tools:[{
	        	 html : '<font color="red">导入</font>',
					handler : function(table) {
                    
	        		 attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",modelname:'gpsimport',title:'GPS信息上传',targetClass:'com.business.entity.contract.equip.gps.GPSInterfacesInfo',custoperatorMethod:'checkGPSImportConfirmExp',parames:importcolumn});
	                 	
	        		// importExcelData(table.id,"/acl/addGpsInterfacesInfoUpload.action",importcolumn);
							//alert("请选择需要导入的项目！");
							//return false;
					},
					iconCls : 'icon-update'
		         }],
	         columns:[
                        {header:'id',name:'id',hidden:true},
						{header:'用户名称',name:'gpsuser'},
						{header:'车牌号',name:'carno'},
						{header:'VIN码（车架号）',name:'chassisnum'},
						{header:'终端号（SM卡号）',name:'simno'},
						{header:'车辆状态',name:'carstatus'},
						{header:'地理位置',name:'caraddr'},
						{header:'车速（KM/h）',name:'carspeed'},
						{header:'转速（转）',name:'carpinwheel'},
						{header:'里程（km）',name:'carmileage'},
						{header:'定位时间',name:'cardate'},
						{header:'方向',name:'cardirection'},
						{header:'开关量',name:'offoron'}
		        ]
         
   	 });
   	 
   });
	
</script>
</head>
<body>
<div id="id_tableContainer"></div>
<div id="id_detailInfoWindowContainer" title="添加GPS接口导入信息"
	style="display: none; width: 800px; height: 400px">
<center>
<form id="id_detailInfoForm">
<table style="width: 90%">
	<tr style="display: none">
		<td><input name="id" type="hidden" value="" /></td>
	</tr>
	<tr>
		<!-- <td class="input_label_desc" align="left">用户名称:</td>
		<td class="td-content">
		<div style="float: left" class="leftComboContainer"
			id="contractidname2"><input name="gpsUser" require="true"
			class="td-content-input" label="用户名" type="text" /></div>
		<span class="content-required">*</span></td> -->

		<td class="input_label_desc" align="left">开关量:</td>
		<td class="td-content"><input name="offOrOn" require="true"
			class="td-content-input" label="定位时间" type="text" /><span
			class="content-required">*</span></td>

	</tr>
	<tr>
		<td class="input_label_desc" align="left">车牌号:</td>
		<td class="td-content"><input name="carNo" require="true"
			class="td-content-input" label="车牌号" type="text" /><span
			class="content-required">*</span></td>

		<td class="input_label_desc" align="left">VIN码（车架号）:</td>
		<td class="td-content"><input name="chassisNum" require="true"
			class="td-content-input" label="VIN码（车架号）" type="text" /><span
			class="content-required">*</span></td>
	</tr>

	<tr>
		<td class="input_label_desc" align="left">终端号（SM卡号）:</td>
		<td class="td-content"><input name="simNo" require="true"
			class="td-content-input" label="终端号（SM卡号）" type="text" /><span
			class="content-required">*</span></td>
		<td class="input_label_desc" align="left">车辆状态:</td>
		<td class="td-content"><input name="carStatus" require="true"
			class="td-content-input" label="车辆状态" type="text" /><span
			class="content-required">*</span></td>
	</tr>
	<tr>
		<td class="input_label_desc" align="left">地理位置:</td>
		<td class="td-content"><input name="carAddr" require="true"
			class="td-content-input" label="地理位置" type="text" /><span
			class="content-required">*</span></td>
		<td class="input_label_desc" align="left">车速（KM/h）:</td>
		<td class="td-content"><input name="carSpeed" require="true"
			class="td-content-input" label="车速（KM/h）" type="text" /><span
			class="content-required">*</span></td>
	</tr>
	<tr>
		<td class="input_label_desc" align="left">转速（转）:</td>
		<td class="td-content"><input name="carPinwheel" require="true"
			class="td-content-input" label="转速（转）" type="text" /><span
			class="content-required">*</span></td>
		<td class="input_label_desc" align="left">里程（km）:</td>
		<td class="td-content"><input name="carMileage" require="true"
			class="td-content-input" label="里程（km）" type="text" /><span
			class="content-required">*</span></td>
	</tr>
	<tr>
		<td class="input_label_desc" align="left">定位时间:</td>
		<td class="td-content"><input class="Wdate td-content-input"
			readonly name="carDate" class="td-content-input" type="text"
			onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})">
		</td>
		<td class="input_label_desc" align="left">方向:</td>
		<td class="td-content"><input name="carDirection" require="true"
			class="td-content-input" label="里程（km）" type="text" /><span
			class="content-required">*</span></td>
	</tr>

	<tr class="content-separator">
		<td colspan='4'><a style="margin-left: 20px;"
			href="javascript:void(0);" class="btn btn-primary"
			onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a>
		<a style="margin-left: 20px;" href="javascript:void(0);"
			class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
	</tr>
</table>
</form>
</center>
</div>

</body>
</html>