<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资金计划变更</title>
<!-- 插入样式和JS -->
<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
<!--javascript libray-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
</head>
<script type="text/javascript">
jQuery(function(){

    var all_width = document.body.clientWidth;
	var all_height = document.body.clientHeight;
jQuery("#id_menuDetailInfoForm").show();
jQuery("#id_menuDetailInfoForm").window({
	   closable:false,
	   top:20
});
jQuery("#id_menuDetailInfoForm").window("open");
combo_cust = new tracywindyComboBox({
	lazyLoad:true,
    id:'id_combo_cust',
    width:300,
    renderTo:'id_cust_name',
    xmlFileName:'\\eleasing\\workflow\\public\\comboCustSelect.xml',
    loadMode:'ajax',
    readOnly:false,
    isAjaxLenovo:true,
    dropListHeight:300,
    topAdd:0,
    leftAdd:0,
    positionDropIconLeftAdd:-1,
    name:'cust_info',
    displayField:'name',
    valueField:'value',
    
    params:{
    },
    onSelect:function(combo){
    //	var cust_id=combo_cust.getValue();
    //    combo_proj.setParam("custID",cust_id);
    //    combo_proj.reload();
        }
 });
combo_proj = new tracywindyComboBox({
	lazyLoad:true,
    id:'id_combo_contract',
    width:300,
    renderTo:'id_contract_name',
    xmlFileName:'\\eleasing\\workflow\\public\\comboContractSelect.xml',
    loadMode:'ajax',
    readOnly:false,
    isAjaxLenovo:true,
    dropListHeight:300,
    topAdd:0,
    leftAdd:0,
    positionDropIconLeftAdd:-1,
    name:'contract_info',
    displayField:'name',
    valueField:'value',
    
    params:{
    },
    onSelect:function(combo){
        
    }
 });
});
function openWindow(){
	var cust_id = getTracywindyObject('id_combo_cust').getValue();
	var contract_id = getTracywindyObject('id_combo_contract').getValue();
	alert(contract_id);
	if (!cust_id) {
		alert("请选择承租人!");
		return false;
	}else if (!contract_id) {
			alert("请选择合同编号!");
			return false;
	}else {
		   var attachmentParams="cust_id="+cust_id+"&contract_id="+contract_id;
	       startProcess("资金计划变更流程-1",attachmentParams);
	}
}
function clearWindow(){
	combo_cust.reload();
	combo_proj.reload();
}
</script>
<body>
	<div id="id_menuDetailInfoForm" class="easyui-window" closed="true" modal="true" title="资金计划变更" style="display:none;width:600px;height:250px;text-align:center;">
	        <center>
		        <div style="width:90%;padding-top:30px;">
			        <table align="center">
			            <tr><td class="input_label_desc">选择客户名称:</td><td  class="input_value"><div id="id_cust_name" style="float:left;"></div></td><td><span class="content-required">*</span></td></tr>
						<tr><td class="input_label_desc">选择合同编号:</td><td  class="input_value"><div id="id_contract_name" style="float:left;"></div></td><td><span class="content-required">*</span></td></tr>
						 <tr class="content-separator">
				            <td colspan=3>
						        <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='openWindow();'><span>确定</span></a>
								<a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='clearWindow();'><span>重置</span></a>
				            </td>
			            </tr>
			            
			        </table>
		        </div>
	        </center>
	</div>
</body>
</html>