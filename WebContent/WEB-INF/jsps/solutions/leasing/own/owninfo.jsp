<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统管理 - 本方清单</title>
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
   		
   		 tableComment:'[本方清单]',
   		 constantFlagTable:'OwnInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'本方清单',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/own_manage/owninfo.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'出租人',name:'ownname'},
		            {header:'委托代理人',name:'leaseconsigner'},
		            {header:'注册地址',name:'leaseregisteraddr'},
		            {header:'通讯地址',name:'leaseaddr'},
		            {header:'法定代表人',name:'leaseperson'},
		            {header:'邮编',name:'leasepostcode'},
		            {header:'联系人',name:'leaselinkman'},
		            {header:'电话',name:'leasetel'},
		            {header:'传真',name:'leasefax'},
		            {header:'电子邮件',name:'leaseemail'}
	        ]
         
   	 });
   	 
   });
	
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  title="添加本方信息" style="display:none;width:800px;height:400px">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:90%">
			        <tr><td></td><td></td><td></td><td></td></tr>
			        <tr><td></td><td></td><td></td><td></td></tr>
			        <tr><td></td><td></td><td></td><td></td></tr>
			        <tr><td></td><td></td><td></td><td></td></tr>
			        <tr><td></td><td></td><td></td><td></td></tr>
			        <tr><td></td><td></td><td></td><td></td></tr>
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
			            <tr>
			           <td class="input_label_desc" align="left">出租人:  </td>  
			            	<td class="td-content">
			            		<input type="text" name="ownName"   class="td-content-input" require="true" label="出租人" maxB="100"/><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc" align="left">委托代理人:  </td>
			            	<td class="td-content">
			            		<input   type="text" name="leaseconsigner"   class="td-content-input" require="true" label="委托代理人" maxB="50"/><span class="content-required">*</span> 
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc" align="left">注册地址:  </td>  
			            	<td class="td-content">
			            		<input  type="text"  name="leaseRegisterAddr"   class="td-content-input" require="true" label="注册地址" maxB="200"/><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc" align="left">通讯地址:  </td>  
			            	<td class="td-content">
			            		<input   type="text"  name="leaseAddr"  class="td-content-input" require="true" label="通讯地址" maxB="200"><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	
			            	<td class="input_label_desc" align="left">法定代表人:  </td>  
			            	<td class="td-content">
			            		<input  type="text" name="leasePerson"   class="td-content-input" require="true" label="法定代表人" maxB="50"><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc" align="left">邮编:  </td>  
			            	<td class="td-content">
			            		<input type="text" name="leasePostcode"  class="td-content-input" require="true" label="邮编" datatype="Zip" /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc" align="left">联系人:  </td>  
			            	<td class="td-content">
			            		<input type="text"  name="leaseLinkman"    class="td-content-input" require="true" label="联系人" maxB="50"/><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc" align="left">电话:  </td>  
			            	<td class="td-content">
			            		<input type="text" name="leaseTel" class="td-content-input" require="true" label="电话" datatype="Phone"/><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	
			            	<td class="input_label_desc" align="left">传真:  </td>  
			            	<td class="td-content">
			            		<input  type="text"  name="leaseFax"   class="td-content-input" require="true" label="传真" datatype="Number" maxB="15"/><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc" align="left">电子邮件:  </td>  
			            	<td class="td-content">
			            		<input  type="text" name="leaseEmail" class="td-content-input"  require="true" label="电子邮件" datatype="Email" maxB="100"/><span class="content-required">*</span>
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