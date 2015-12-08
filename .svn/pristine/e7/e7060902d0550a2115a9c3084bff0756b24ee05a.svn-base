<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link type="text/css" href="${pageContext.request.contextPath}/css/jbpmDesigner/jquery-ui-1.8.4.custom.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
<style type="text/css">
   html{
      overflow:auto;
   }
   body{
      overflow:auto;
   }
</style>
<script type="text/javascript">
    var displayName = "${param.display_name}";
    var type = "${param.type}";
    var code = "${param.code}";
    var position = "${param.position}";
    var workflowName = "${param.workflow_name}";
    var workflowVersion = "${param.workflow_version}";
    var workflowDescription = "${param.workflow_description}";
    var isDeployed = ("true" == "${param.workflow_isDeployed}")? true:false;
    var processInstanceId  = "${param.processInstanceId}";
    var jbpmWorkflowHistoryInfoUserId = "${param.jbpmWorkflowHistoryInfoUserId}";
    var nodeDetailWindowId = "id_NodeDetailWindow";
    var maxDotX  = parseInt("${(empty param.maxDotX) ? maxDotX : param.maxDotX}"||"0");
    var maxDotY  = parseInt("${(empty param.maxDotY) ? maxDotY : param.maxDotY}"||"0");
    var windowClientWidth   = document.documentElement.clientWidth;
    windowClientWidth = (0 == windowClientWidth) ? document.documentElement.scrollWidth : windowClientWidth;
    windowClientWidth-=2;
    var windowClientHeight  = document.documentElement.clientHeight;
    windowClientHeight = (0 == windowClientHeight) ? document.documentElement.scrollHeight : windowClientHeight;
    windowClientHeight-=2;
    var diagramCanvasWidth  = Math.max(windowClientWidth,maxDotX);
    var diagramCanvasHeight = Math.max(windowClientHeight,maxDotY);
    var isViewWorkflowDiagram   = (processInstanceId && ("-1" != processInstanceId) && ("0" != processInstanceId));
    if(/getDesignerSavedDiagramInfo\.action/.test(window.location.href)){
    	diagramCanvasWidth  = windowClientWidth*2;
    	diagramCanvasHeight = windowClientHeight*3.5;
    }
    function initNodeDetailWindow(){
 	   return  '<div  style="background:#FFFFFF;border:1px solid #DDD;padding:5px;display:block;z-index:99999;position:absolute;width:450px;overflow:auto;" id="'+nodeDetailWindowId+'"></div>';
    }
    var queryNodeConfigActorLoadMask = null;
    function globalWorkflowNodeClickCallBack(e,nodeType,nodeName,posX,posY,nodeWidth,nodeHeight)
    {
    	posY+=30;
    	posX-=jQuery("#myflow").scrollLeft();
    	posY-=jQuery("#myflow").scrollTop();
	   if(!$("#"+nodeDetailWindowId)[0]){
		  jQuery("#myflow").append(initNodeDetailWindow());
		  $("#"+nodeDetailWindowId)[0].onclick=function(e){
			  cancelBubble(e);
	      };
	   }
	   $windowDiv = $("#"+nodeDetailWindowId);
	   var nodeRealWidth = Math.min(450,windowClientWidth-(posX+nodeWidth+50));
	   $("#"+nodeDetailWindowId).css("width",nodeRealWidth+"px");
	   $windowDiv.get(0).style.left =((posX+nodeWidth+5)+"px");
	   $windowDiv.get(0).style.top =(posY+"px");
	   //$windowDiv.get(0).style.height =((nodeHeight-10)+"px");
	   if(null == queryNodeConfigActorLoadMask){
		   queryNodeConfigActorLoadMask = new tracywindyLoadMask(document.body,'正在加载数据 请稍等...');
	   }
	   queryNodeConfigActorLoadMask.show();
	   ajaxRequest({
          url:"${pageContext.request.contextPath}/jbpm/getNodeConfigInfo.action",
          success:function(res){
        	  $windowDiv.html(res.responseText);
    	      $windowDiv.show();
    	      queryNodeConfigActorLoadMask.hide();
          },
          params:{
              workflowDefinition:workflowName+"-"+workflowVersion,
              nodeType:nodeType,
              nodeName:nodeName,
              processInstanceId:processInstanceId,
              deployId:"${param.deployId}",
              jbpmWorkflowHistoryInfoUserId:"${param.jbpmWorkflowHistoryInfoUserId}"
          }
	   });
	   e.stopPropagation();
       if(isViewWorkflowDiagram){
           
       }
    }
    function hideGlobalWorkflowNodeDetailWindow(e){
    	 $windowDiv = $("#"+nodeDetailWindowId);
    	 $windowDiv.hide();
    }
    function backFunc(){
        /*if(confirm("确认返回至流程管理页面么？")){
    		window.location.href="${pageContext.request.contextPath}/workflow/jbpm-core/listDesignedDeployments.bi?pageStart=${param.pageStart}&queryText="+escape(encodeURIComponent("${param.queryText}"));
        }*/
        if(confirm("确认流程变更已保存？")){
	         try{
		 		    if(window.opener)
		 		    {
		 			    window.opener.getTracywindyObject("id_workflows_table").reload();
		 			}
		 	}catch(e){}
            closeWindow();
        }
    }
	function closeWindow()
	{
		try{
			window.opener=null;
			window.open("","_self");
			window.close();
		}catch(e){
			window.close();
		}
	}
	window.onbeforeunload = function(e){   
        try{
 		    if(window.opener)
 		    {
 			    window.opener.getTracywindyObject("id_workflows_table").reload();
 			}
 		}catch(e){}
		   /*var ev = getEvent(e);
	       var n = ev.screenX - window.screenLeft;    
	       var b = n >= (document.documentElement.clientWidth-30);    
	       if(b && ev.clientY < 0 || ev.altKey)    
	       { 
		         try{
		 		    if(window.opener)
		 		    {
		 			    window.opener.getTracywindyObject("id_workflows_table").reload();
		 			}
		 		}catch(e){}
		         try{
		        	closeWindow();
		         }catch(e){}
		         cancelBubble(ev);
	       } */
	  };
</script>
	<!--javascript libray-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jbpmDesigner/raphael-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jbpmDesigner/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jbpmDesigner/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jbpmDesigner/myflow.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jbpmDesigner/myflow.editors.js"></script>
<script type="text/javascript" >
	jQuery(function(){
		jQuery("#myflow").css("overflow","auto");
		jQuery("#myflow").css("border","1px solid #DDD");
		jQuery("#myflow").css("borderTopWidth","0px");
		if(!/getDesignerSavedDiagramInfo\.action/.test(window.location.href)){
		    if(windowClientWidth > maxDotX){
		    	jQuery("#myflow").css("overflowX","hidden");
		    }
		    if((windowClientHeight - 35) > maxDotY){
		        jQuery("#myflow").css("overflowY","hidden");
		    }
		    jQuery("#myflow").css("height",(windowClientHeight-30)+"px");
		}else{
			jQuery("#myflow").css("overflow","hidden");
			jQuery(document.body).css("width",(diagramCanvasWidth+2)+"px");
		}
	    jQuery("#myflow").scroll(function(){
	        hideGlobalWorkflowNodeDetailWindow();
	   });
	});
</script>
