<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租赁物管理  - 设备管理</title>
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
var constantFlagTable = "ContractDocInfo";
var pageWidth  = document.documentElement.clientWidth-2;
var pageHeight = document.documentElement.clientHeight-2;
jQuery(function(){
	tracywindyOperationTable({		
		resetFormCallback:function(table,$form,operFlag){
   		 if("add" == operFlag){
   			var rowData = table.getRowDataAt(0);
   			jQuery("#creator").val('${sessionScope.loginUser.realname}');
   			var select_contract = getTracywindyObject("id_combo_id_is_contractid");
 	        select_contract.setValue("");
 	        
   	     }
     	 },
   		 loadFormDataCallBack:function(table,$form,rowIndex){
     		var rowData = table.getRowDataAt(rowIndex);	  
     		var select_contract = getTracywindyObject("id_combo_id_is_contractid");
   	        select_contract.setValue(rowData["contractid"]); 
     		 
	    
        },	 
		 tableComment:'风险处置 ',
   		 constantFlagTable:'CustRiskProcess',
         renderTo:'id_tableriskContainer',
         title:'风险处置 ',
         width:window.formWidth||pageWidth,
         //height:pageHeight,
         id:'id_tablerisk',
         formContainerId:'id_riskInfoWindowContainer',
         xmlFileName:'/eleasing/jsp/fund_overduerent/custriskprocess.xml',
         loadMode:'ajax',
         isPage:true,
         border:true,
         isRank:true,
         //params:param,
         isFit:true,
         columns:[
					{header:'id',name:'id',hidden:true},
					{header:'合同编号',name:'contract'},
					{header:'业务合同号',name:'contractnumber'},
					{header:'被告人',name:'accused'},
					{header:'诉讼请求',name:'lawplease'},
					{header:'机器编号',name:'carnumber'},
					{header:'机器停放地',name:'caraddr'},
					{header:'办案人员',name:'lawuser'},
					{header:'法院',name:'tribunal'},
					{header:'处理方式',name:'lawtype'},
					{header:'处理时间',name:'lawdate'}
	        ]
	 });
	 
});

jQuery(function(){
	//dict('num','proj_info.projtype','root_null_ini','${requestScope["proj_info.projtype"]}',null,'');
	//dict('contractidnum','proj_info.projtype','root_null_ini','${requestScope["proj_info.projtype"]}',null,'');

	commonSelectOverall('id_is_contractid',"(SELECT id,CONTRACT_NUMBER FROM CONTRACT_INFO) rs",'id',"CONTRACT_NUMBER",'contractid','','','',null,false);
    });


</script>
</head>
<body>
<div id="id_tableriskContainer"></div>
<div id="id_riskInfoWindowContainer" closed="true" modal="true" title="风险处置" style="display:none;width:900px;padding-top:20px;">
<center>
	        <form id="id_detailInfoForm">
		        <table style="width:90%">
 	<tr>
 	<td colspan="4">&nbsp;</td>
 	</tr>
 	<tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
	<tr class="tr-even">
		<td class="input_label_desc" align="left">合同编号:</td>
		<td class="input_value">
		<div style="float: left" class="leftComboContainer" id="id_is_contractid"></div>
		</td>
		<td class="input_label_desc" align="left">被告人:  </td>  
       	<td class="td-content">
		    <input name="accused" id="accused" require="true"  label="被告人" class="td-content-input"  type="text" /></td>
	</tr>
	<tr class="tr-odd">	
       	<td class="input_label_desc" align="left">诉讼请求:  </td>  
       	<td class="td-content">
       	<input name="lawplease" id="lawplease" require="true"  label="诉讼请求" class="td-content-input"  type="text" /></td>
		<td class="input_label_desc" align="left">机器编号:</td>
		<td class="td-content">
		<input name="carnumber" id="carnumber" require="true"  label="机器编号" class="td-content-input"  type="text" /></td>
	</tr>
	
	<tr class="tr-even">
		<td class="input_label_desc" align="left">办案人员:</td>
		<td class="td-content">
		<input name="lawuser" id="lawuser" require="true" label="办案人员" class="td-content-input"  type="text" />
		</td>
		<td class="input_label_desc" align="left">法院:</td>
		<td class="td-content">
		<input name="tribunal" id="tribunal" require="true" label="法院" class="td-content-input"  type="text" />
		</td>
	</tr>
	<tr class="tr-odd">
		<td class="input_label_desc" align="left">处理方式:</td>
		<td class="td-content">
		<input name="lawtype" id="lawtype" require="true" label="处理方式" class="td-content-input"  type="text" />
		</td>
		<td class="input_label_desc" align="left">处理时间:</td>
		<td class="td-content">
		<input name="lawdate" id="lawdate"  label="处理时间"  class="Wdate td-content-input td-content-readonly"  onClick="WdatePicker(this,{readOnly:true})"    type="text" />
		</td>
	</tr>
	<tr class="tr-odd">
		<td class="input_label_desc" align="left">机器停放地:</td>
		<td class="td-content" colspan="4">
		<textarea rows="2" cols="95" class="td-content-input" name="caraddr" require="true" label="机器停放地"
			style="width:84%"></textarea>
			
		</td>
	</tr>
	<tr class="tr-even">
		<td class="input_label_desc" align="left">备注:</td>
		<td class="td-content" colspan="4">
		<textarea rows="2" cols="95" name="lawmemo" class="td-content-input" require="true" label="备注" style="width:84%" ></textarea>
		</td>
	</tr>
	<tr class="tr-odd">
		<td class="input_label_desc" align="left">登记人 :  </td>  
		<td class="td-content">
		    <input name="creatorname" id="creator" label="登记人 " class="td-content-input td-content-readonly"  readonly="readonly" type="text" />
		</td>
		<td class="input_label_desc" align="left">登记时间</td>  
		<td class="td-content">
		    <input name="createdate" id="createdate" isDefaultDate="true" label="登记时间 "   class="td-content-input td-content-readonly"  readonly="readonly" type="text" />
		</td>
	</tr>
	<tr class="tr-even">
		<td class="input_label_desc" align="left">修改人 :  </td>  
		<td class="td-content">
		    <input name="modificatorname" id="modificator" label="修改人 " class="td-content-input td-content-readonly" readonly="readonly" type="text" />
		</td> 
		<td class="input_label_desc" align="left">修改时间</td>  
		<td class="td-content">
		    <input name="modifydate" id="modifydate" label="修改时间" class="td-content-input td-content-readonly"  readonly="readonly" type="text" />
    	</td>
    </tr>
	<tr class="content-separator">
		<td colspan='4'>
		<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='getTracywindyObject("id_tablerisk").operationTable();'><span>确定</span></a>
		<a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_riskInfoWindowContainer").window("close");'><span>取消</span></a>
		</td>                                                                                             
	</tr>
</table>
</form>
</center>
</div>
</body>
</html>
