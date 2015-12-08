<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程实例</title>
		<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css?version=3" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
        <script type="text/javascript">
	      var all_width = (document.documentElement||document.body).clientWidth-2;
	      var all_height = (document.documentElement||document.body).clientHeight-1;
	    </script>
	    <style type="text/css">
	       html,body{
	         overflow:hidden;
	       }
	    </style>
</head>
<body style="overflow:hidden;"> 
   <div id="id_tasksContainer"></div>
   <script type="text/javascript" defer>
	var processDefinitionsColumns = [
	                                 {header:'流程名称',name:'workflow_name_'},
	                                 {header:'流程版本',name:'version_'},
	                                 {header:'操作',name:'oper',renderer:function(value,tableObj,columnName,columnIndex,rowData){
		                                return '<a href="javascript:void(0);" onclick="removeProcessInstance(\''+rowData['workflow_name_']+'\',\''+rowData['version_']+'\');">清除所有流程数据</a>';
	                                 }}
	                              ];
		 var tableActivityDetail= new tracywindyTable({
	          renderTo:'id_tasksContainer',
	          width:all_width,
	          height:all_height,
	          isCheck:false,
	          isRank:false,
	  		  toolsLeftMargin:20,
			  tools:[{
		    	  isHtml:true,
		    	  html:'全局搜索：<input type="text" style="margin-right:4px;border:1px solid #DDD;" id="id_queryWorkflowsTableInput" value="${param.queryText}" />'
		        }],
	          id:'id_tasks_table',
	          showHeader:true,
	          isPage:true,
	          border:true,
	          isFit:true,
	          title:'流程实例删除',
	          loadMode:'ajax',
	          xmlFileName:'jbpm/queryAllDeployedWorkflows.xml',
	          columns:processDefinitionsColumns
	       });
		 document.getElementById("id_queryWorkflowsTableInput").onkeypress = function(evt){
			 var e  = getEvent(evt);
		     var code = e.keyCode||e.charCode;
		     if(13 == code){
		         var workflowsTable = getTracywindyTable("id_tasks_table");
		         workflowsTable.setParams({
		                queryText:this.value.toUpperCase()
		         });
		         workflowsTable.reload();
		     }
		 };
	  //显示流程图
	   function toProcessActivePicture(deployId,processInstanceId)
	   {
			var sheight = 600;
	        var swidth = 850;
	        var winoption =null;//"height="+sheight+"px;width="+swidth+"px;status=no;scroll=yes;resizable=yes";
			window.open("${pageContext.request.contextPath}/workflow/jbpm/getActivedRects.action?deployId="+deployId+"&processInstanceId="+processInstanceId+"&randomNumber="+Math.random(),"_blank");
	   }
	   function doQueryByText_pending()
	   {
		  var contentText = document.all['id_contextText_pending'].value;
		  var tableContact = getTracywindyTable("pendingRequestTable");
		  tableContact.params['proj_id'] = contentText.toUpperCase();
		  tableContact.reload();
	   }
	   var loadMask = null;
	   function removeProcessInstance(workflowName,workflowVersion)
	   {
		   if(confirm("确认清除  <  "+workflowName+" > 下的所有流程数据么?"))
		   {
			   if(!loadMask)
			   {
				   loadMask = new tracywindyLoadMask(document.body,"正在执行操作  请稍等...");
			   }
			   loadMask.show();
	           ajaxRequest({
	               method:'post',
	               url:'${pageContext.request.contextPath}/jbpm/removeWorkflowAllProcessInstance.action',
	               success:function(res){alert("删除成功");loadMask.hide();},
	               failure:function(res){alert("删除失败");loadMask.hide();},
	               params:{
	            	   paramWorkflowName       : workflowName,
	            	   paramWorkflowVersion    : workflowVersion
	               }
	            });
		   }
	   }
   </script>
      <script type="text/javascript">
        function toProcessForm(currentTaskId,planActorId)
        {
        	window.open("${pageContext.request.contextPath}/jbpm/requestProcessTaskForm.action?currentTaskId="+currentTaskId+"&jbpmWorkflowHistoryInfoUserId="+planActorId,"_blank");
        }
      </script>
</body>
</html>