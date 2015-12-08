<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目资料补充</title>
<!--css sheet-->
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
    <style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	   .picItem{
	      float:left;
	      padding:5px 5px 5px 5px;
	      border:1px solid silver;
	   }
	</style>

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
var combo_cust = new tracywindyComboBox({
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
    //rawValue:empty2Other('${empty ProductType ? PROD_ID : ProductType }','推土机'),
    params:{
    },
    onSelect:function(combo){
    	//var cust_id=combo.getValue();
        //combo_proj.setParam("id",cust_id);
      //  combo_proj.reload();
        }
 });
combo_proj = new tracywindyComboBox({
    id:'id_combo_proj',
    width:300,
    renderTo:'id_proj_name',
    xmlFileName:'\\eleasing\\workflow\\public\\comboProjSelect.xml',
    loadMode:'ajax',
    readOnly:false,
    isAjaxLenovo:true,
    dropListHeight:300,
    topAdd:0,
    leftAdd:0,
    positionDropIconLeftAdd:-1,
    name:'proj_info',
    displayField:'name',
    valueField:'value',
    params:{
      //	PROJ_STATUS_LessThanEqual : 20,
    },
    onSelect:function(combo){
        
    }
 });


})

function openWindow(){
	var cust_id = getTracywindyObject('id_combo_cust').getValue();
    var proj_id = getTracywindyObject('id_combo_proj').getValue();

    if (!cust_id) {
	    alert("请选择承租人!");
	    return false;
    } else if (!proj_id) {
	    alert("请选择项目名称!");
	    return false;
    } else {
    	//验证发起流程条件
    	 var attachmentParams = "projInfo_id=" + proj_id;
			    startProcess("项目资料补齐-1", attachmentParams);

    }
	//注释掉的部分？？？
	/* var cust_id = getTracywindyObject('id_combo_cust').getValue();
	var cust_info = getTracywindyObject('id_combo_cust').getRawValue();
	var proj_id=getTracywindyObject('id_combo_proj').getValue();
	//if (!cust_id|| !proj_id) {
	//	alert("请选择承租人和项目!");
	//	return false;
	//}else {
		   //var attachmentParams="projInfo_id="+proj_id;
		   var attachmentParams = "";
		  // alert(attachmentParams);
	       startProcess("项目资料补齐-1",attachmentParams);
      //  } */
	}
</script>
</head>
<body>
	<div id="id_menuDetailInfoForm" class="easyui-window" closed="true" modal="true" title="项目资料补充流程" style="display:none;width:600px;height:250px;text-align:center;">
	        <center>
		        <div style="width:90%;padding-top:30px;">
			        <table align="center">
			            <tr><td class="input_label_desc">承租人:</td><td  class="input_value"><div id="id_cust_name" style="float:left;"></div></td><td><span class="content-required">*</span></td></tr>
						<tr><td class="input_label_desc">项目名称:</td><td  class="input_value"><div id="id_proj_name" style="float:left;"></div></td><td><span class="content-required">*</span></td></tr> 
						 <tr class="content-separator">
				            <td colspan=3>
						        <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='openWindow();'><span>确定</span></a>
								<a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_menuDetailInfoForm").window("close");'><span>取消</span></a>
				            </td>
			            </tr>
			        </table>
		        </div>
	        </center>
	</div>
	</body>
</html>