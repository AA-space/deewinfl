<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<%@ taglib prefix="fn"  uri="/WEB-INF/tlds/fn.tld" %> 
<%@ taglib prefix="fmt" uri="/WEB-INF/tlds/fmt.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金催收</title>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyMultiTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
	<script type="text/javascript">
	    var cust_id="${param.cust_id}";
	    window.onresize = function(){
	    	var currentPageClientWidth  =  document.documentElement.clientWidth;
	    	var currentPageClientHeight =  document.documentElement.clientHeight;
	    	currentPageClientWidth  = currentPageClientWidth  > 0 ? currentPageClientWidth  : document.body.clientWidth;
	    	currentPageClientHeight = currentPageClientHeight > 0 ? currentPageClientHeight : document.body.clientHeight;
            if(
                     (Math.abs(currentPageClientWidth-oldCurrentPageClientWidth)>4)
                   &&(Math.abs(currentPageClientHeight-oldCurrentPageClientHeight)>4)
              ){
            	   window.location.href = window.location.href;
              }
	    	oldCurrentPageClientWidth  =  currentPageClientWidth;
	    	oldCurrentPageClientHeight =  currentPageClientHeight;
		};
		function closeWindow()
		{
			window.opener=null;
			window.open("","_self");
			window.close();
		}
		var all_width  =  document.documentElement.clientWidth;
		var all_height =  document.documentElement.clientHeight;
		var oldCurrentPageClientWidth = all_width;
		var oldCurrentPageClientHeight = all_height;
		
		var formHeight = 0;
		var formWidth = all_width-30;
</script>
</head>
   <body style="overflow:hidden;padding:5px;">
			<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/print/LodopFuncs.js"></script>
       		  <div id="id_loadMaskContainer" style="display:none;">
					  <div id="loading">
					    <div class="loading-indicator">正在加载   请稍等...</div>
					</div>
			  </div>
			  <script type="text/javascript">
			     jQuery("#id_loadMaskContainer").css("height",all_height);			        
			  </script>
       <div class="x-panel-table-div-title"  id="id_focusComponent">租金催收：催收明细<div style="float:right"><a href="javascript:void(0);" class="easyui-linkbutton" onClick="if(window.confirm('确认关闭此流程页面么？'))closeWindow();" plain="true" iconCls="icon-cancel">关闭</a></div></div>
		<!-- 弹出意见框结束-->
		       <div id="id_content_tabs"><!--页签开始-->
		             <div class="tabs-header">
					    <div style="display: none;" class="tabs-scroller-left"></div><div style="display: none;" class="tabs-scroller-right"></div>
					    <div  class="tabs-wrap">
					       <ul class="tabs">
					          <li class="tabs-selected"><a href="javascript:void(0)"  id="id_toggle_form_link" onclick="toggleFormDisplay();" class="tabs-inner"><span class="tabs-title">催收内容</span><span class="tabs-icon"></span></a></li>
						     </ul> 
					    </div>
					 </div>
		              <div  style="display:block;height:auto;float:left;" ><!--页签1开始-->
				        <!--表单处理-->
					     <div style="border:0px;overflow-y:scroll;overflow-x:hidden;" id="id_workflowFormContainer"><jsp:include page="overdue_rent_detail_info.jsp" ></jsp:include></div>
				    </div><!--页签1结束-->
				    
				</div><!--页签结束l-->
</body>
 
</html>