<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>其它功能 - 文件登记</title>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyMultiTable.js"></script>
<style type="text/css">
html,body {
	overflow: hidden;
}
</style>

<script type="text/javascript">
  function openoverdue(id){
		var URL=getRootPath()+"/leasing/common/templateManager/editWordTemplate.bi";
		var params={id:id};
	   openFullScreenWindow(URL,params);
		//window.open (getRootPath()+'/leasing/common/templateManager/editWordTemplate.bi?id='+id,'newwindow',"top=0,left=0") ;
 }
    function showOperator(value,tableObj,columnName,columnIndex,rowData){
       var base = "<a href='#' onclick='showRecorder(\""+rowData.id+"\")'>记录</a>";
       var base2 = "<a href='#' onclick='downloadFile(\""+rowData.id+"\")'>下载</a>";
       var base3 = "<a href='#' onclick='openoverdue(\""+rowData.id+"\")'>编辑</a>";
       return base2+"&nbsp;&nbsp;"+base+"&nbsp;&nbsp"+base3; 
    }
    function showRecorder(id){
    	 var currentTabled =getTracywindyObject('table_id_file_recorder_container');
         var parames={};
         parames["basefile"]=id;
         currentTabled.setParams(parames);
         currentTabled.reload();
    	 jQuery("#file_recorder").show();
  	     jQuery("#file_recorder").window({
  			   top:10
  	   	  });
  	    jQuery("#file_recorder").window("open");
    }
    var constantFlagTable = "ContractDocInfo";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
		 
		var table = new tracywindyOperationTable({
			 
			 tableComment:'系统上传下载文件',
	   		 constantFlagTable:'ContractDocInfo',
	         renderTo:'id_tableContainer',
	         title:'系统上传下载文件',
	         width:pageWidth,
	         height:pageHeight,
	         id:'id_table',
	         operButtons:' ',
	         xmlFileName:'/eleasing/jsp/template_word/filelist_info.xml',
	         loadMode:'ajax',
	         isPage:true,
	         isFit:true,
	         border:true,
	         columns:[
	                    {ader:'id',name:'id',hidden:'true'}, 
						{header:'模块名称',name:'modelname'},
						{header:'文件名',name:'filename'},
						{header:'创建人',name:'creator'},
						{header:'创建时间',name:'createdate'},	
						{header:'操作',name:'createdate',renderer:showOperator}				
		        ],
		     params:{id:'${param.id}'}
   	 });
   });
	jQuery(function(){
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_file_recorder_container',
	    width:500,
	    height:500,
	    tools:'',
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    lazyLoad:true,
	    xmlFileName : '/eleasing/jsp/template_word/fileRecorderList_info.xml',
		loadMode : 'ajax',
		//params : {fee_type:'feetype10'},
	    columns:[
				{name:'creator',  header:'操作人',nullable:false},
				{name:'createdate',  header:'操作时间',nullable:false},
				{name:'operatortype',  header:'操作',nullable:false}
	     ]})
	 });
</script>
</head>
<body>
<div id="id_tableContainer"></div>
<div id="file_recorder" closed="true" modal="true" title="文件操作记录"
		style="display:none;width:500px;padding-top:10px;padding:0px;">
	<center>
	<div style="width:100%;text-align:left;" id="id_file_recorder_container">
	
	</div>
    </center>
 </div>
</body>
</html>