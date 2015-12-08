<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>其它功能 - 设备相关GPS信息 </title>
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
	var dealer_id='${empty dealerid ? "" : dealerid }';
  	var dealer_name='${empty dealername ? "" : dealername }';
    var constantFlagTable = "ContractDocInfo";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
		
		//commonSelectOverall('contractidname2','CONTRACT_INFO','ID','CONTRACT_ID','contractid','','','require="true" label="合同号"',function(combo,data){choseNext(combo,'id_combo_','CONTRACT_INFO');},true);
		//commonSelectOverall('contractidname','CONTRACT_EQUIP','ID','chassis_num','equipID','','','require="true" label="车架号"',null,true); 
		//经销商
 	   var dealer=  new tracywindyComboBox({
    	    id:'id_combo_dealer',
    	    width:162,
    	    renderTo:'id_dealername',
    	    xmlFileName:'\\eleasing\\workflow\\gps\\GPSComboDistributorCustSelect.xml',
    	    loadMode:'ajax',
    	    readOnly:false,
    	    isAjaxLenovo:true,
    	    isContainEmpty:true,
    	    dropListHeight:300,
    	    topAdd:0,
    	    leftAdd:0,
    	    positionDropIconLeftAdd:-1,
    	    name:'dealer_name',
    	    displayField:'dealername',
    	    valueField:'dealerid',
    	 	//value:dealer_id,
    		//rawValue:dealer_name,
    	 	//readOnlyData:(dealer_id.length>0?true:false),
    	 	//otherAttributes:'require="true" label="经销商"',
    	    params:{
    	    	user_id :'${sessionScope.loginUser.id}'
    	    },
    	    onSelect:function(r, v) {
        	    custname.setParam("cust_dealer_id",this.getValue());
        	    custname.reload();
    	    }
    	 });
       //客户名称
 	   var custname=  new tracywindyComboBox({
       	    id:'id_combo_custname',
       	    width:162,
       	    renderTo:'id_custname',
       	    xmlFileName:'\\eleasing\\workflow\\gps\\GPSLimitCustSelect.xml',
       	    loadMode:'ajax',
       	    readOnly:false,
       	    isAjaxLenovo:true,
       	    isContainEmpty:true,
       	    dropListHeight:300,
       	    topAdd:0,
       	    leftAdd:0,
       	    //positionDropIconLeftAdd:-1,
       	    name:'cust_name',
       	    displayField:'custname',
       	    valueField:'custid',
       	 	//readOnlyData:(dealer_id.length>0?true:false),
       	 	//otherAttributes:'require="true" label="客户名称"',
       	 	params:{
        	    	cust_class1:'CUST_INFO_COMPANY',
        	    	cust_class2:'CUST_INFO_COMPANY'
        	    },
       	    onSelect:function(r, v) {
       	    	contract.setParam("cust_number",this.getValue());
       	    	contract.reload();
       	    }
       	 });
 		
 	//合同号
 	   var contract=   new tracywindyComboBox({
    	    id:'id_combo_contract',
    	    width:162,
    	    renderTo:'id_contractnumber',
    	    xmlFileName:'\\eleasing\\workflow\\gps\\GPSFundfundSelectContract.xml',
    	    loadMode:'ajax',
    	    readOnly:false,
    	    //isAjaxLenovo:true,
    	    isContainEmpty:true,
    	    dropListHeight:300,
    	    topAdd:0,
    	    leftAdd:0,
    	    positionDropIconLeftAdd:-1,
    	    name:'contract_number',
    	    displayField:'contractnumber',
    	    //otherAttributes:'require="true" label="合同号"',
    	    valueField:'contractid',
    	    onSelect:function(r,v){
 		  			VIN.setParam("contract_id",this.getValue());
 		 			VIN.reload();
    	    }
    	 });
 	//车架号
 	   var VIN =   new tracywindyComboBox({
    	    id:'id_combo_contractidname',
    	    width:162,
    	    renderTo:'id_contractidname',
    	    xmlFileName:'\\eleasing\\workflow\\gps\\GPS_vehicle_frame_number.xml',
    	    loadMode:'ajax',
    	    readOnly:false,
    	    isAjaxLenovo:true,
    	    isContainEmpty:true,
    	    dropListHeight:300,
    	    topAdd:0,
    	    leftAdd:0,
    	    positionDropIconLeftAdd:-1,
    	    name:'chassisnum',
    	    displayField:'chassisnum',
    	   // otherAttributes:'require="true" label="车架号"',
    	    valueField:'carid'
    	 });
		dictYesOrNoByCode('gpsYesOrNo','isGPS','','',true,'require="true" label="GPS安装"','');
		var table = new tracywindyOperationTable({
   		 loadFormDataCallBack:function(table,$form,rowIndex){
   	   		 var rowData = table.getRowDataAt(rowIndex);
   	   	     var wordindustry = getTracywindyObject("id_combo_gpsYesOrNo");
			 var contractidname = getTracywindyObject("id_combo_contractidname");
			 var dealer = getTracywindyObject("id_combo_dealer");
			 var custname = getTracywindyObject("id_combo_custname");
			 var contract = getTracywindyObject("id_combo_contract");
			 var isgps = rowData["isgps"];
			 if(isgps=="是"){
	   	       	 wordindustry.value = "0";
				 wordindustry.reload();
			}else{
				wordindustry.value = "1";
				 wordindustry.reload();
			}
			  // 设置经销商默认值
			 
			 dealer.value = rowData["custdealerid"];
			 dealer.reload();
			 custname.setParam("cust_dealer_id",rowData["custdealerid"]);
        	 custname.reload();
			 
			 //设置承租人默认值
			 
			 custname.rawValue = rowData["custname"];
			 custname.value = rowData["custid"];
			 custname.reload();
			 
			 contract.setParam("cust_number",rowData["custid"]);
       	     contract.reload();
			
			 //设置合同默认值
			 
			 contract.rawValue = rowData["contractnumber"];
			 contract.value = rowData["contractid"];
			 contract.reload();
			 contractidname.setParam("contract_id",rowData["contractid"]);
 		 	 contractidname.reload();
			 //设置车架号默认值
   	         contractidname.rawValue = rowData["chassisnum"];
   	         contractidname.value = rowData["equipid"];
			 contractidname.reload();
   	     },
			 tableComment:'设备相关GPS信息 ',
	   		 constantFlagTable:'GPSInfo',
	         renderTo:'id_tableContainer',
	         title:'设备相关GPS信息 ',
	         width:pageWidth,
	         height:pageHeight,
	         isExcel:true,
	         id:'id_table',
	         xmlFileName:'/eleasing/jsp/other/interface_import/list3.xml',
	         loadMode:'ajax',
	         isPage:true,
	         isFit:true,
	         border:true,
	         isRank:true,
	         columns:[
                        {header:'id',name:'id',hidden:true},
						{header:'经销商id',name:'custdealerid',hidden:true},
						{header:'经销商',name:'custdealer',queryConfig:{}},
						{header:'承租人id',name:'custid',hidden:true},
						{header:'承租人',name:'custname',queryConfig:{}},
						{header:'合同id',name:'contractid',hidden:true},
						{header:'合同编号',name:'contractnumber',queryConfig:{}},
						{header:'租赁物id',name:'equipid',hidden:true},
						{header:'车架号',name:'chassisnum',queryConfig:{isNewLine:true}},
						{header:'GPS是否安装',name:'isgps',type:'combobox',queryConfig:{
							   loadMode:'local',
						       datas:[{title:'是',name:'0'},{title:'否',name:'1'}],
				 		       isAjaxLenovo:true,    
				 		       readOnly:false,
				 		       width:165,
				 		       name:'title',
				 		       displayField:'title',
				 		       valueField:'name'
					 	}},
					 	//{header:'gps是否安装id',name:'gpsid',hidden:true},
						{header:'GPS软件网址/软件名',name:'gpsname'},
						{header:'GPS用户名',name:'gpsuser'},
						{header:'GPS密码',name:'gpspassword'},
						{header:'租赁物台数',name:'equipnum'},
						{header:'备注',name:'memo'}
		        ]
         
   	 });
   	 
   });
	
</script>
</head>
<body>
<div id="id_tableContainer"></div>
<div id="id_detailInfoWindowContainer" title="添加设备相关GPS信息 信息"
	style="display: none; width: 800px; height: 400px">
<center>
<form id="id_detailInfoForm">
<table style="width: 90%">
    <tr style="display:none">
    	<td><input name="id" type="hidden" value=""/></td>
		</tr>
	    <tr>
		    
			<td class="input_label_desc" align="left">经销商:</td>
			<td class="input_value">
				<div style="float: left" class="leftComboContainer"
				id="id_dealername"></div>
				<span class="content-required">*</span>
			</td>
			<td class="input_label_desc" align="left">客户名称:</td>
			<td class="input_value">
			<div style="float: left" class="leftComboContainer"
				id="id_custname"></div><span class="content-required">*</span>
			</td>
		</tr>
		
		 <tr>
	
			<td class="input_label_desc" align="left">合同号:</td>
			<td class="input_value">
				<div style="float: left" class="leftComboContainer"
				id="id_contractnumber"></div>
				<span class="content-required">*</span>
			</td>
			<td class="input_label_desc" align="left" style="display:none">车架号:</td>
			<td class="input_value" >
			<div style="float: left;display:none" class="leftComboContainer"
				id="id_contractidname"></div>
			</td>
		</tr>
		 <tr>
		   
			<td class="input_label_desc" align="left">GPS安装:</td>
			<td class="input_value">
				<div style="float: left" class="leftComboContainer"
				id="gpsYesOrNo"></div>
				<span class="content-required">*</span>
			</td>
			<td class="input_label_desc" align="left">GPS软件网址/软件名:</td>
			<td class="td-content"><input name="gpsName"   class="td-content-input"
				label="GPS软件网址/软件名" type="text" /></td>
		</tr>
		<tr>
			<td class="input_label_desc" align="left">GPS用户名:</td>
			<td class="td-content"><input name="gpsUser" class="td-content-input"
				label="GPS用户名" type="text" /></td>
				<td class="input_label_desc" align="left">GPS密码:</td>
			<td class="td-content"><input name="gpsPassword" class="td-content-input"
				label="GPS密码" type="text" /></td>
		</tr>
		
		 <tr class="tr-odd">
          <td class="input_label_desc" align="left">备注:</td>
          <td class="td-content" colspan="3">
			  <textarea name="memo" style="width:90%;float:left;"  label="备注"  maxB="255" type="text" ></textarea>
		  </td>
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