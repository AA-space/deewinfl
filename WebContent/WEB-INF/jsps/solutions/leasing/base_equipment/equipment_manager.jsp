<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设备管理-设备管理</title>
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
   		 tableComment:'[设备管理]',
   		 constantFlagTable:'equipmentmanager',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'设备管理',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/cust_account/cust_account_info.xml',
         params:param,
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         columns:[
		            
		            {header:'设备分类',name:'column1'},
		            {header:'设备种类',name:'column2',hidden:true},
		            {header:'设备类型',name:'column3'},
		            {header:'型号',name:'column4'},
		            {header:'计量单位',name:'column5'},
		            {header:'厂商',name:'column6'},
		            {header:'启用/停用',name:'column7'}
	        ]
   	 });
   });

</script>

 <script type="text/javascript">
     
 </script>
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="设备管理" style="display:none;width:800px;padding-top:20px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:90%">
			            <tr>
			              <td class="input_label_desc">设备分类:  </td>  
			              <td class="td-content" >
			            	<input name="id" type="hidden" value=""/>
			            	<input type="radio" name="column1"  checked="true"  value="车辆"/>车辆
			        	    <input type="radio" name="column1" id="displaynocar"  value="设备"/>设备<font color="red">*</font></td>
			              <td class="input_label_desc">设备种类:  </td>  
			              <td class="td-content">
			            		<input type="radio" name="column2"  checked="true"  value="自卸车"/>自卸车
			        	        <input type="radio" name="column2" id="displaynocar"  value="挂车"/>挂车<span class="content-required">*</span>
			               </td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">型号:  </td>  
			            	<td class="td-content">
			            	   <input name="column3" class="td-content-input" require="true" label="型号"  maxB="150" type="text" />
			                  <font color="red">*</font></td>
			               <td class="input_label_desc">计理单位(辆/台):  </td>  
			               <td class="td-content" >
			            		<input name=column4 class="td-content-input" require="true" label="计量单位(辆/台)"  maxB="255"   type="text" /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">厂商:  </td>  
			            	<td class="td-content" colspan="3" >
			            	<input name="column5" style="width:80%" class="td-content-input" require="true" label="厂商"  maxB="150" type="text" />
			            		<span class="content-required">*</span>
			            	</td>
			            	
			            </tr>
			            <tr>
			            	<td class="input_label_desc">状态:  </td>  
			            	<td class="td-content" >
			            	<input type="radio" name="column6"  checked="true" id="displaycar" value="1"/>启用
			        	    <input type="radio" name="column6" id="displaynocar"  value="0"/>停用
			               </td>
			               <td></td><td></td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="input_label_desc">登记人 :  </td>  
			            	<td class="td-content">
			            		<input name="column7" id="creatorname" label="登记人 " class="td-content-input td-content-readonly" readonly="readonly" type="text" />
			            	</td>
			            	<td class="input_label_desc">登记时间:</td>  
			            	<td class="td-content">
			            		<input name="column8" id="createdate" label="登记时间 " class=" td-content-input td-content-readonly"  readonly="readonly" type="text" />
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