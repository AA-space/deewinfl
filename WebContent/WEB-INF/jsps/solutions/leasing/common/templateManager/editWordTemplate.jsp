<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<%@ taglib prefix="fn"  uri="/WEB-INF/tlds/fn.tld" %> 
<%@ taglib prefix="fmt" uri="/WEB-INF/tlds/fmt.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="IE=7" http-equiv="X-UA-Compatible" /> 
		<!--设置缓存-->
		<meta http-equiv="cache-control" content="no-cache,must-revalidate">
		<meta http-equiv="pragram" content="no-cache">
		<meta http-equiv="expires" content="0">
<title>文档在线编辑</title>
    <link href="${pageContext.request.contextPath}/css/tracywindy/workflow.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAttachmentFileUpload.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyCommonUserSelection.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyMultiTable.js"></script>
	<SCRIPT LANGUAGE="JavaScript" src="${pageContext.request.contextPath}/ntko/OfficeContorlFunctions.js"></SCRIPT>
	<script type="text/javascript">
	    function closeWindow()
		{
			window.opener=null;
			window.open("","_self");
			window.close();
		}
	   
</script>
</head>
  <script type="text/javascript">
  var id="<%= request.getParameter("id")%>";
  var status="<%= request.getParameter("status")%>";
  if(status==""||status=="null"){
   status="1";
  }
  jQuery(function() {
	   if(status=="0"){
		   $("#id_tosave").css("display","none");
		   $("#id_toedit").css("display","none");
		   $("#id_toReview").css("display","none");
		   $("#id_tomadeReview").css("display","none");
	   }else{
		 
	   }
  });	  
 // var newAction = "leasing/template/downLoadAttachByName.action?browserType="+SysBrowser.getBrowser().toLowerCase();
  var newAction="leasing/template/downLoadAttachByIdtoEdit.action?browserType="+SysBrowser.getBrowser().toLowerCase();
  newAction+="&id="+id;
  </script>
   <body style="overflow:hidden" onload='intializePage(newAction)' onbeforeunload ="onPageClose()">
			<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/print/LodopFuncs.js"></script>
       		  <div id="id_loadMaskContainer" style="display:none;">
			     <div id="loading">
					 <div class="loading-indicator">正在加载   请稍等...</div>
				 </div>
			  </div>
			  <script type="text/javascript">
			     jQuery("#id_loadMaskContainer").css("height",800);			        
			  </script>

       <div class="x-panel-table-toolbar-div">
		        <!--提交按钮-->
		        <div>
			        <a href="javascript:void(0);"  class="easyui-linkbutton" onClick="if(window.confirm('确认关闭？'))closeWindow();" plain="true" iconCls="icon-cancel">关闭</a>
			        <a href="javascript:void(0);" id="id_tosave" class="easyui-linkbutton" onClick="if(window.confirm('确认保存WORD？'))saveFileToUrl();" plain="true" iconCls="icon-update">保存</a>
			        <a href="javascript:void(0);" id="id_toedit" class="easyui-linkbutton" onClick="setEditWord();" plain="true" iconCls="icon-update">编辑</a>
			        <a href="javascript:void(0);" id="id_toprint" class="easyui-linkbutton" onClick="OFFICE_CONTROL_OBJ.printout(true);" plain="true" iconCls="icon-update">打印</a>
			        <a href="javascript:void(0);" id="id_toReview" class="easyui-linkbutton" onClick="SetReviewMode(true);" plain="true" iconCls="icon-update">修改留痕</a>
			        <a href="javascript:void(0);" id="id_tomadeReview" class="easyui-linkbutton" onClick="OFFICE_CONTROL_OBJ.ActiveDocument.AcceptAllRevisions();" plain="true" iconCls="icon-update">接受修改</a>
			   </div>
		 </div>  
		<!-- 弹出意见框结束-->
		        <div  style="display:block;" id="id_toggle_tabs_form"><!--页签1开始-->
				        <!--表单处理-->
				        <div style="" id="id_workflowFormContainer">
						     <div  id="id_workflowFormContainer_inner">
                               <div id="id_wf_hidden_field">
							      <jsp:include page="editword.jsp"></jsp:include>	 
							 </div>
						</div>
				    </div><!--页签1结束-->
		</div><!--页签结束-->
</body>
<script type="text/javascript">
function setEditWord(){
  OFFICE_CONTROL_OBJ.SetReadOnly(false,"123");//禁止编辑
  OFFICE_CONTROL_OBJ.Menubar=true;
  OFFICE_CONTROL_OBJ.ToolBars=true;//菜单不显示
  OFFICE_CONTROL_OBJ.activeDocument.saved=true;
}
</script>
</html>