<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>区域管理</title>
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
   			var select_contract = getTracywindyObject("id_combo_id_district");
   	        select_contract.setRawValue(""); 
   	        select_contract = getTracywindyObject("id_combo_id_managerrole");
	        select_contract.setRawValue(""); 
	    	select_contract = getTracywindyObject("id_combo_manager");
   	        select_contract.setRawValue("");   
   	     }
     	 },
   		 loadFormDataCallBack:function(table,$form,rowIndex){
     		var rowData = table.getRowDataAt(rowIndex);	  
     		var select_contract = getTracywindyObject("id_combo_id_district");
   	        select_contract.setRawValue(rowData["district"]); 
   	        select_contract = getTracywindyObject("id_combo_id_managerrole");
	        select_contract.setRawValue(rowData["rolename"]); 
	    	select_contract = getTracywindyObject("id_combo_manager");
   	        select_contract.setRawValue(rowData["manager"]); 
        },	 
		 tableComment:'区域管理 ',
   		 constantFlagTable:'managerDistrict',
         renderTo:'id_tableriskContainer',
         title:'区域管理 ',
         width:window.formWidth||pageWidth,
         height:pageHeight,
         id:'id_tablerisk',
         formContainerId:'id_riskInfoWindowContainer',
         xmlFileName:'/eleasing/jsp/other/area/managerdistrict.xml',
         loadMode:'ajax',
         isPage:true,
         border:true,
         isRank:true,
         //params:param,
         isFit:true,
         columns:[
 		      {header:'角色',name:'rolename'},
 		      {header:'人员',name:'manager',queryConfig:{}},
 		      {header:'所属区域',name:'district',queryConfig:{}}
	        ]
	 });
	 
});

jQuery(function(){
	dictOnSelect('id_district','district','dealer_district',null,null,'require="true" label="所属区域"');
	commonSelectOverall('id_managerrole',"(SELECT ID_, name_ FROM t_roles) rs",'id_',"name_",'managerrole','','','require="true" label="角色"', function(combo,data){
		var cust=getTracywindyObject("id_combo_manager");
		  cust.setParam("roleid",combo.getValue());
		  cust.reload();
			},false);
	var combo_cust = new tracywindyComboBox({
	    id:'id_combo_manager',
	    width:300,
	    renderTo:'id_manager',
	    xmlFileName:'\\eleasing\\workflow\\public\\SimpleUserSelectByRole.xml',
	    loadMode:'ajax',
	    readOnly:false,
	    isAjaxLenovo:true,
	    isContainEmpty:false,
	    dropListHeight:300,
	    topAdd:0,
	    leftAdd:0,
	    positionDropIconLeftAdd:-1,
	    name:'manager',
	    displayField:'name',
	    valueField:'id',
	    params:{
	    },
	    onSelect:function(combo){
	    }
 	});
    });


</script>

<div id="id_tableriskContainer"></div>
<div id="id_riskInfoWindowContainer" closed="true" modal="true" title="区域管理" style="display:none;width:900px;padding-top:20px;">
<center>
	        <form id="id_detailInfoForm">
		        <table style="width:90%">
 	<tr>
 	<td colspan="4">&nbsp;</td>
 	</tr>
 	<tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
	<tr class="tr-even">
		<td class="input_label_desc" align="left">角色:</td>
		<td class="input_value">
			<div style="float: left" class="leftComboContainer" id="id_managerrole"></div>
		</td>
		<td class="input_label_desc" align="left">人员:  </td>  
       	<td class="td-content">
       	    <div style="float: left" class="leftComboContainer" id="id_manager"></div>
		  </td>
	</tr>
	<tr class="tr-odd">	
       	<td class="input_label_desc" align="left">所属区域:  </td>  
       	<td class="td-content">
      	 	<div style="float: left" class="leftComboContainer" id="id_district"></div>
	</tr>
	
<!-- 	<tr class="tr-even">
		<td class="input_label_desc" align="left">备注:</td>
		<td class="td-content" colspan="4">
		<textarea rows="2" cols="95" name="lawmemo" require="true" label="备注" style="width:84%" ></textarea>
		</td>
	</tr> -->
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
</head>
</html>
