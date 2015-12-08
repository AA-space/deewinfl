
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基础信息维护 - 贷款类型</title>
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
			
		//dictOnSelect('id_unit_property','unitProperty','crediter_type',null,null,'label="授信机构属性" require="true"',true);//授信机构属性

		
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
   	    // var select_contract = getTracywindyObject("id_combo_id_unit_property");
  	     //select_contract.setValue(rowData["unitproperty"]);
   	    
        },
   		 tableComment:'[贷款类型]',
   		 constantFlagTable:'FinacingLoanType',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'贷款类型',
         width:pageWidth,
         height:pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/financing_config/finacing_config_loan_type.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         columns:[
		            
		            {header:'id',name:'id',hidden:true},
		            {header:'贷款类型编号',name:'code'},
		            {header:'贷款类型名称',name:'loanname'},
		            {header:'还款方式',name:'view',align:'center',renderer:function(value,tableObj,columnName,columnIndex,rowData){
			            return "<a href='javascript:void(0);' onclick='view("+rowData.rowIndex+");'>查看</a>";
			        }},
		            {header:'最后更新日期',name:'modifydate'},
		           
		            {header:'操作员',name:'creator'}
	        ]
   	 });
   	 var table2 = new tracywindyTable({
   	     border:true,
         renderTo:'id_tableContainer2',
         width:497,
         isAutoHeight:true,
         id:'id_table2',
         xmlFileName:'/eleasing/jsp/financing_config/finacing_config_refund_type.xml',
         loadMode:'ajax',
         isPage:false,
         isFit:true,
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'还款方式编号',name:'code'},
		            {header:'还款方式名称',name:'refundname'},
		            {header:'贷款方式',name:'loanname'},
		            {header:'最后更新日期',name:'modifydate'},
		            {header:'操作员',name:'creator'}
	        ]
   	 });
   });
	function view(rowIndex){
		  var table = getTracywindyObject('id_table');
		  var rowData = table.getRowDataAt(rowIndex);
		  //alert(JsonUtil.encode(rowData));
		  $("#id_detailInfoWindowContainer2").show();
		  $("#id_detailInfoWindowContainer2").window({top:20});
		  $("#id_detailInfoWindowContainer2").window('open');
    }
</script>

</head>
<body>
    <div id="id_tableContainer"></div>
    <div id="id_detailInfoWindowContainer2"  closed="true" modal="true" title="查看贷款类型" style="display:none;width:700px;height:300px;padding-top:20px;">
       <div id="id_tableContainer2"></div> 
      
    </div>
    
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="贷款类型" style="display:none;width:900px;padding-top:20px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:90%">
			            <tr>
			            	<input type="hidden" name="id"/>
			            	<td class="input_label_desc"  align="left" width="30%">贷款类型编号:  </td>  
			            	<td class="td-content" colspan="3" >
			            		<input name="code" require="true" label="贷款类型编号"  type="text" /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc"  align="left" width="30%">贷款类型名称: </td>  
			            	<td class="td-content" colspan="3">
			            		<input name="loanName" require="true" label="贷款类型名称"  type="text" /><span class="content-required">*</span>
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