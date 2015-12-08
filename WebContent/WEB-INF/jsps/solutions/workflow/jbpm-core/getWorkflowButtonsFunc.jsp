<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<script>
 var isDraft = ("Draft" == "${processInstanceState}");
</script>
<script type="text/javascript">
	//显示流程图
	function toProcessActivePicture(){
		/*var processInstanceId =encodeURIComponent('${currentProcessInstanceId}');
		?deployId=&processInstanceId="+processInstanceId+"&randomNumber="+Math.random()*/
		var attachmentParams = {
				deployId:'${currentDeployId}',
				processInstanceId:escape(encodeURIComponent('${currentProcessInstanceId}')),
				randomNumber:Math.random(),
				jbpmWorkflowHistoryInfoUserId:"${jbpmWorkflowHistoryInfoUserId}"
	    };
		openFullScreenWindow("${pageContext.request.contextPath}/workflow/jbpm/getActivedRects.action",attachmentParams);
	}
	//流程历史信息
	function viewWorkflowHistoryDetail(){
		var infoFlag="history";
		if(getLazyLoadedObj(infoFlag,jQuery(document.body),function(){
			jQuery("#id_workflowHistoryDetailInfoWindow").show();
			jQuery("#id_workflowHistoryDetailInfoWindow").window({top:20});
			jQuery("#id_workflowHistoryDetailInfoWindow").window("open");
		})){
			jQuery("#id_workflowHistoryDetailInfoWindow").show();
			jQuery("#id_workflowHistoryDetailInfoWindow").window({top:20});
			jQuery("#id_workflowHistoryDetailInfoWindow").window("open");
		}
	}
	//流程历史信息
	function viewProjSummary(){
		<c:if test="${empty currentHistoryTaskInfo.keyOne}">
		   alert("流程关键字为空,请先设定流程《${currentHistoryTaskInfo.workflowName}》的第一个流程关键字");
		   return;
		</c:if>
	    var URL = "${pageContext.request.contextPath}/jbpm/getProjSummaryHistoryInfos.action?keyOne=${currentHistoryTaskInfo.keyOne}&proj_id=${requestScope['project_info.projId']}";
	    openFullScreenWindow(URL);
	}
	//打开历史表单
	function toProcessForm(currentTaskId){
		window.open("${pageContext.request.contextPath}/jbpm/viewHistoryProcessForm.action?currentTaskId="+currentTaskId,"_blank");
	}
	//打印预览
	function previewPrint(){
	    var currentTaskId = "${param.currentTaskId}"||"${requestScope['currentTaskId']}";
	    var URL = "${pageContext.request.contextPath}/jbpm/preivewProcessTaskForm.action?currentTaskId="+currentTaskId+"&jbpmWorkflowHistoryInfoUserId=${param.jbpmWorkflowHistoryInfoUserId}";
		window.open (URL, '_blank','width='+(1014)+',height='+(window.screen.availHeight-30)+ ',top=0,left=0,location=no,directories=no,toolbar=no,resizable=no,status=no,menubar=no,scrollbars=yes'); 
	}
	//删除流程实例
	function removeProcessInstance(){
		if(isDraft && !window.isCompletedTask){
		   if(!window.loadMask)
		   {
		    	window.loadMask = new tracywindyLoadMask(document.body,"数据处理中，请稍等...");
		   }
		   window.loadMask.show();
		   globalCurrentPressButtonText = deleteButtonNoSavedDisplayText;
		   document.getElementById('id_currentTaskSubmitButtonText').value = globalCurrentPressButtonText;
		   submitFormWithoutWorkflowNextCallBack();
		}else{
			try{
			   closeWindow();
			}catch(e){}
		}
		/*try{
		    if(window.top.opener)
		    {
			    window.top.opener.location.reload();
			}
		}catch(e){}
		closeWindow();*/
	}
</script>
<script type="text/javascript"> 
	/*window.onbeforeunload = onbeforeunload_handler; 
	window.onunload = onunload_handler; 
	function onbeforeunload_handler(){ 
	    var warning="确认退出?";    
	    return window.confirm(warning); 
	} 
	    
	function onunload_handler(){ 
	    var warning="谢谢光临"; 
	    alert(warning); 
	} */
	if(isDraft && !window.isCompletedTask){
		window.onbeforeunload = function(e){    
		   var ev = getEvent(e);
	       var n = ev.screenX - window.screenLeft;    
	       var b = n >= (document.documentElement.clientWidth-30);    
	       if(b && ev.clientY < 0 || ev.altKey)    
	       { 
	         removeProcessInstance();
	         try{
	 		    if(window.opener)
	 		    {
	 			    window.opener.location.reload();
	 			}
	 		}catch(e){}
	         try{
	        	closeWindow();
	         }catch(e){}
	         cancelBubble(ev);
	       } 
	    }; 
	}

</script> 
