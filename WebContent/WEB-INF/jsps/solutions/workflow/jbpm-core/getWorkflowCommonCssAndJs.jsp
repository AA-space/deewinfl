<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<%@ taglib prefix="fn"  uri="/WEB-INF/tlds/fn.tld" %>
<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/workflow.css" rel="stylesheet" type="text/css">
<%@include file="/base/mini.jsp" %>
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


<script type="text/javascript">

  var currentJbpmWorkflowHistoryInfoId = '${currentJbpmWorkflowHistoryInfoId}';
  var isViewHistoryTask  = ( "true" == "${isViewHistoryTask}" );
  var isCompletedTask    = ( "true" == "${isCompletedTask}" );
  //i18n
  var submitButtonDisplayText ="Submit"; //("提交"),
  var resetRouteButtonDisplayText="ResetRoute";//("任意路由"),
  var saveButtonDisplayText = "Save";//("保存"),
  var backButtonDisplayText ="Back";//("退回"),
  var deleteButtonDisplayText="Delete";//("删除"),
  var deleteButtonNoSavedDisplayText="DeleteNoSaved";//("删除"),
  var abondonButtonDisplayText="Abondon";//("废弃流程"),
  var finishButtonDisplayText="Finish";//("已结束"),
  var draftButtonDisplayText="Draft";//("草稿"),
  var pendingButtonDisplayText="Pending";//("待处理"),
  var signatureButtonDisplayText="Signature";//("会签"),
  var readButtonDisplayText="WorkflowRead";//("传阅"),
  var assignmentButtonDisplayText="Assignment";//("工作指派"),
</script>
<script type="text/javascript">
	var all_width  =  document.documentElement.clientWidth;
	var all_height =  document.documentElement.clientHeight;
	var oldCurrentPageClientWidth = all_width;
	var oldCurrentPageClientHeight = all_height;
	
	var formHeight = 0;
	var formWidth = 0;
	var containerWidthAdd = 12;
	var containerHeightAdd = 115;
	formHeight = all_height-containerHeightAdd-10;
	formWidth = all_width-containerWidthAdd-28;
	var nextChosePersonArr = new Array();
	var backChosePersonArr = new Array();
	var allChosePersonArr = new Array();
	var  isShowSubmitChosePersonWindow = true;
	var  isShowBackChosePersonWindow = true;
	var globalCurrentPressButtonText = "";
	var loadMask  = null;
	var lazyLoadedObj = {};
</script>
