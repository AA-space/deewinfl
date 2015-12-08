<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经销商账号管理</title>
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
    var constantFlagTable = "User";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		
   		 tableComment:'[经销商账号管理]',
   		 constantFlagTable:'OwnInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'经销商账号管理',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/own_manage/owninfo.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'经销商名称',name:'column1'},
		            {header:'经销商账号状态',name:'column2'},
		            {header:'经销商账号',name:'column3'},
		            {header:'经销商密码',name:'column4'},
		            {header:'经销商密码设置日期',name:'column5'}
	        ]
         
   	 });
   });
    jQuery(function(){
    	dict('id_condition_dealer','proj_info.projtype','root_null_ini','${requestScope["proj_info.projtype"]}','${requestScope["rawValue_proj_info.projtype"]}','');
    	dict('id_condition_state','proj_info.projtype','root_null_ini','${requestScope["proj_info.projtype"]}','${requestScope["rawValue_proj_info.projtype"]}','');
    });
 
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  title="添加经销商账号管理" style="display:none;width:800px;height:400px">
       <center>
        <form id="id_detailInfoForm">
	        <table style="width:90%">
	            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
	            <tr>
	           <td class="input_label_desc" align="left">经销商名称:  </td>  
	            	<td class="td-content">
	            		<div class="leftComboContainer" id="id_condition_dealer"></div>	
	            	</td>
	            	<td class="input_label_desc" align="left">经销商账号状态:  </td>
	            	<td class="td-content">
	            	<div class="leftComboContainer" id="id_condition_state"></div>	  
	            	</td>
	            </tr>
	            <tr>
	            	<td class="input_label_desc" align="left">经销商账号:  </td>  
	            	<td class="td-content">
	            		<input  type="text"  name="column3"   class="td-content-input" require="true" label="经销商账号" minB="16" maxB="22" /><span class="content-required">*</span>
	            	</td>
	            	<td class="input_label_desc" align="left">经销商密码:  </td>  
	            	<td class="td-content">
	            		<input   type="text"  name="column4"  class="td-content-input" require="true" label="经销商密码" minB="6" maxB="6"><span class="content-required">*</span>
	            	</td>
	            </tr>
	            <tr>
	            	<td class="input_label_desc" align="left">经销商密码设置日期:  </td>  
	            	<td class="td-content">
			      <input class="Wdate td-content-input" readonly name="column4" class="td-content-input"  type="text" 
 onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})"  >
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