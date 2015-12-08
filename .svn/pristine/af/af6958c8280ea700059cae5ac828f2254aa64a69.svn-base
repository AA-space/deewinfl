<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租赁业务  - 租金催收函</title>
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
<script type="text/javascript"><!--
	var _tempData = '';
    function importEbankCallBack(message){
        alert(message);
    	window.currentImportExcelLoadMask.hide();
    	var table = getTracywindyObject("id_table");
    	table.reload();
    }
    var constantFlagTable = "User";
    var ebankUploadUrl="";
    var ebankAttachUrl="";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var tableebank = new tracywindyOperationTable({

   		resetFormCallback:function(table,$form,operFlag){
   		 if("add" == operFlag){
   			var rowData = table.getRowDataAt(1);
   	   		 //document.getElementById("custname").value=rowData["custname"];
   			//$("#custname").val(rowData["custname"]);
   	     }
     	 },
   		 loadFormDataCallBack:function(table,$form,rowIndex){
 
        },
   		 tableComment:'[租金催收]',
   		 constantFlagTable:'OverdueRentLetterinfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'租金催收',
         width:window.formWidth||parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/fund_overduerent/overdue_rent_letter.xml',
         loadMode:'ajax',
         isPage:true,
         operButtons:'',
         checkType:'checkbox',
         tools:[{
     	    iconCls:'icon-import',
     	    html:'<font color="red">维护发送日期</font>',
     	    handler:function(table, v){
     	    	var IDValue = table.getCheckedRowDatas();
 				if (0 == IDValue.length) {
 					alert("请选择需要维护发送日期的数据！");
 					return false;
 				}
 				_tempData = IDValue;
 				table.addEntity();
     	   }
     	 },{
     	    iconCls:'icon-import',
     	    html:'<font color="red">生成催款函</font>',
     	    handler:function(table){
     	    	window.open('overdue_rent_letter.bi','_bank');
     	    //table.addEntity();
     	   }},
     	   /*,{
        	   iconCls:'icon-import',
        	   html:'<font color="red">删除发送</font>',
        	   handler:function(table){
        	   table.addEntity();
        	   }
     	 }*/

     	//{
      	    //html:'<input name="senddate" id="senddate"  label="发送时间" require="true"  class="Wdate td-content-input td-content-readonly"  onClick="WdatePicker(this,{readOnly:true})" readOnly   type="text" />'
     	//}
     	 ],
         isFit:true,
         
         columns:[
                    {header:'id',name:'id',hidden:true},
                    {header:'custid',name:'custid',hidden:true},
                    {header:'overrent',name:'overrent',hidden:true},
		            {header:'合同编号',name:'contract_id',queryConfig:{}},
		            {header:'业务合同号',name:'contractnumber',queryConfig:{}},
		            {header:'最近一次发送日期',name:'senddate'},
		            {header:'催款员',name:'dun'},
		            {header:'客户名称',name:'custname'},
		            {header:'电话',name:'phone'},
		            {header:'地址',name:'homeadd'},
		            {header:'担保人',name:'assurors'}
	        ]
   	 });
   });

	   function setValue(){
		   var _param = {};
		   if(_tempData){
			  var _senddate = $('#senddate').val();
			 // console.info(_tempData);
				for ( var int = 0; int < _tempData.length; int++) {
					 _tempData[int].senddate = _senddate;
				}
				_param.dunningnotice = JsonUtil.encode(_tempData);
				
			   $.post('acl/addOverdueRentLetterinfo.acl', _param, function(i,v){
				   if(v == 'success'){
					   var table =getTracywindyObject('id_table');
					   table.reload();
					   alert("维护成功!");
				    }
				   _tempData = null;
				})
			} else{
				alert("错误，请核实数据");
			}
		   jQuery("#id_detailInfoWindowContainer").window("close");  
		}

</script>
</head>
<body>
    <div id="id_tableContainer"></div>
    <div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="租金催收函" style="display:none;height:150px;width:400px;padding-top:20px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:100%" class="fillTable">
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/><input name="custid" type="hidden" value=""/><input name="contractid" type="hidden" value=""/><input name="overrent" type="hidden" value=""/></td></tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">发送时间:  </td>  
			            	<td class="td-content">
			            		<input name="senddate" id="senddate"  label="发送时间" require="true"  class="Wdate td-content-input td-content-readonly"  onClick="WdatePicker(this,{readOnly:true})" readOnly   type="text" /><font class="required-content">*</font>
			            	</td>
			            	<td class="td-content-title"></td>  
			            	<td class="td-content"></td>
			            </tr>
			            <tr class="content-separator">
				            <td colspan='4'>
				                 <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='setValue();'><span>确定</span></a>
						         <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
				            </td>
			            </tr>
			        </table>
		        </form>
	        </center>
	</div>
</body>
</html>