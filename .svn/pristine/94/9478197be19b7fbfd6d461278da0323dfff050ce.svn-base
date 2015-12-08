<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>关账日信息</title>
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
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
		html,body{overflow:hidden;}
		.required-content{color:red}
	</style>
<script type="text/javascript">
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({   		 
   		 windowTop:20,
   		 constantFlagTable:'CloseDayInfo',
   	     border:true,
         renderTo:'id_tableContainer',
         title:'关账日信息',
         tableComment:'[关账日信息]',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         xmlFileName:'/eleasing/jsp/close_day/close_day_info.xml',
         loadMode:'ajax',
         operButtons:'新增|修改|删除',
         lazyLoad: false,
         isPage:true,
         id:'id_table',
         isAutoBreakContent: false,
         isExcel:true,
         isFit: true,
         beforeShowWindowCallBack:function(operType,thisForm,operType){
	    	 if(operType=="update"){
	    		 var status = $('input[name="status"]').val();
	    		 if(status == "0"){
	    			 getTracywindyObject("id_combo_id_status").setRawValue("有效");
	    		 }else{
	    			 getTracywindyObject("id_combo_id_status").setRawValue("无效");
	    		 }
				 getTracywindyObject("id_combo_id_status").setValue(status);
	    	 }
	    	 return true;
	     },
         columns:
         [
	            {header:'id',name:'cid',hidden:true},
	    	    {header:'年份',name:'closeyear',queryConfig:{}},
	            {header:'月份',name:'closemonth',queryConfig:{}},
	            {header:'关账日',name:'closeday'},
	            {name:'status', header:'状态id',hidden:true},
	            {header:'状态',name:'statusname',hiddenName:'status',queryConfig:{},config:{
	  				width:165,
					isNewLine:true,
					type:'combobox',
					colSpan:3, 
					loadMode:'local',
					datas:[{title:'有效',name:'0'},{title:'无效',name:'1'}],
		            displayField:'title',
		            valueField:'name',
		            defaultValue:1,
		            value:'1'
	            }}
	     ]
   	 });
   });
</script>

</head>
<body>
<!-- 加载table 内容div -->
<div id="id_tableContainer"></div>

<!-- 画弹出框内容 -->	
<center>
<div id="id_detailInfoWindowContainer"  title="关账日信息" style="display:none;width:550px;height:300px">
        <center>
	        <form id="id_detailInfoForm">
		        <table style="width:90%">
		            <tr style="display:none">
		            <td><input name="id" id="id" type="hidden" value=""/></td>
		            <td><input name="closeStaff" id="closeStaff" type="hidden" value=""/></td>
		            </tr>
		           <tr >
					   <td class="td-content-title">年份：</td>
					   <td class="td-content"><input name="closeyear" class="td-content-input"  
			             type="text" require="true" label="年份" /><font class="required-content">*</font></td>
			           <td class="td-content-title">月份：</td>
			             <td class="td-content"><input name="closemonth" class="td-content-input" require="true" label="月份"   type="text"  value="${requestScope['closemonth'] }"><font class="required-content">*</font></td>
					</tr>
					<tr >
					   <td class="td-content-title">关账日：</td>
					   <td class="td-content"><input name="closeday" id="closeday" onClick="WdatePicker(this,{readOnly:true})" dataType="date" readOnly class="td-content-input"  
			             type="text" value="${requestScope['closeday'] }"   require="true" label="关账日" /><font class="required-content">*</font></td>
			           <td class="td-content-title">状态：</td>
			             <td class="td-content">
			             <div class="leftComboContainer" id="id_status"></div></td>
					</tr>
					<br/>
		            <tr class="content-separator">
			            <td colspan='4'>
			                 <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='submitInfo()'><span>确定</span></a>
					         <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
			            </td>
		            </tr>
		        </table>
	        </form> 
        </center>
	</div>
</center>
<script>
function submitInfo(){
	if($("#closeday").val() == ""){
		alert("关账日不为空!");
		return false;
	}
	return getTracywindyObject("id_table").operationTable();
}
jQuery(function(){
	new tracywindyComboBox({
		lazyLoad:true,
		id : 'id_combo_id_status',
		width : 167,
		renderTo : 'id_status',
		datas:[{value:'0',name:'有效'},{value:'1',name:'无效'}],
		loadMode : 'local',
		readOnly : false,
		isAjaxLenovo : true,
		readOnly:true,
		otherAttributes:'require="true"  label="状态"',
		topAdd : 0,
		leftAdd : 0,
		positionDropIconLeftAdd : -1,
		name : 'status',
		displayField : 'name',
		valueField : 'value',
		value:'${requestScope["status"]}',
		rawValue:'${requestScope["rawValue_status"]}'
		
	});
	
});

</script>
</body>
</html>