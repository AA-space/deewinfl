<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<%@ taglib prefix="spring" uri="/WEB-INF/tlds/spring.tld"%>

<script type="text/javascript">
   //提交按钮时候执行回调函数
    function btn_callBack(buttonText,assignmentIsSilentModel)
    {
        if(true == assignmentIsSilentModel){
        	document.getElementById("id_assignmentIsSilentModel").value ="true"; 
        }
        else{
        	document.getElementById("id_assignmentIsSilentModel").value ="false"; 
        }
	    var isNeedChoseOper = false;
    	globalCurrentPressButtonText = buttonText;
    	document.getElementById('id_currentTaskSubmitButtonText').value = globalCurrentPressButtonText;
    	if(resetRouteButtonDisplayText==globalCurrentPressButtonText){
            var infoFlag = "all";
    		if(getLazyLoadedObj(infoFlag,jQuery(document.body),function(){
    	 	 	jQuery("#id_allRouteChoseWindow").show();
    			jQuery("#id_allRouteChoseWindow").dialog({top:10});
    			jQuery("#id_allRouteChoseWindow").dialog("open"); 
    		})){
    	 	 	jQuery("#id_allRouteChoseWindow").show();
    			jQuery("#id_allRouteChoseWindow").dialog({top:10});
    			jQuery("#id_allRouteChoseWindow").dialog("open"); 
    		}
        	return;
        }
    	if(saveButtonDisplayText == globalCurrentPressButtonText)
    	{
	        //是否保存    
	        if(window.workflowSaveCallBack)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	        {
	            if(!workflowSaveCallBack())
	            {
	                return;
	            }
	        }
	        submitFormWithoutWorkflowNextCallBack();
	    }
    	else if((submitButtonDisplayText==globalCurrentPressButtonText)||(backButtonDisplayText==globalCurrentPressButtonText))
    	{
        	if(!checkAttachmentInfoFunc())return;
		    <c:if test="${'1' eq currentTaskIsNeedAdvise}">
			    var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');
			    if(!hidden_text_choseAdvise.value){alert("请填写处理意见");return;};
		    </c:if>
	        //是否提交    
	        if(window.workflowSubmitCallBack)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	        {
	            if(!workflowSubmitCallBack(buttonText))
	            {
	            	//setInitFocus();
	                return;
	            }
	        }
	        /*
	        //通过哪条路由路线进行提交
	        var requestNextRoute = document.getElementById("id_requestInitiatorRoute");
	        alert(requestNextRoute.value);
	        //modify by tracywindy 20140211
	        if(!requestNextRoute.value){
		        if(window.workflowNextRouteCallBack)//该回调函数可用于设置提交提交的路由线路通过(requestNextRoute.value=路由线路值)进行设置;
		    	{//该回调函数先于endAction中的appointRequestRoute方法的执行
		    		isNeedChoseOper = workflowNextRouteCallBack(buttonText,requestNextRoute);
		        }
		    	else
		    	{
		    		requestNextRoute.value="";
		        }
	        }*/
	    	if((submitButtonDisplayText==globalCurrentPressButtonText))
	    	{
	    		var infoFlag="next";
	    		if(getLazyLoadedObj(infoFlag,jQuery(document.body),function(){
	    			dealNextRouteChoseWindow();
			    	if(!isShowSubmitChosePersonWindow)
			    	{
			    		submitFormWithoutWorkflowNextCallBack();
				    }
			    	else
			    	{
		    			jQuery("#id_nextRouteChoseWindow").show();
						jQuery("#id_nextRouteChoseWindow").dialog({top:10});
						jQuery("#id_nextRouteChoseWindow").dialog("open"); 
				    }
	    		})){
	    			dealNextRouteChoseWindow();
			    	if(!isShowSubmitChosePersonWindow)
			    	{
			    		submitFormWithoutWorkflowNextCallBack();
				    }
			    	else
			    	{
		    			jQuery("#id_nextRouteChoseWindow").show();
						jQuery("#id_nextRouteChoseWindow").dialog({top:10});
						jQuery("#id_nextRouteChoseWindow").dialog("open"); 
				    }
	    		}
		    }
	    	else if((backButtonDisplayText==globalCurrentPressButtonText))
	    	{
	    		var infoFlag="back";
	    		if(getLazyLoadedObj(infoFlag,jQuery(document.body),function(){
	    			//modify by tracywindy for default chose first person
	    			dealNextRouteChoseWindow();
			    	if(!isShowBackChosePersonWindow)
			    	{
					    alert("退回选择列表为空，不允许退回");
					    return;
				    }
			    	else
			    	{
				 	 	jQuery("#id_backRouteChoseWindow").show();
						jQuery("#id_backRouteChoseWindow").dialog({top:10});
						jQuery("#id_backRouteChoseWindow").dialog("open");
				    }
	    		})){ 
		    		//modify by tracywindy for default chose first person
	    			dealNextRouteChoseWindow();
			    	if(!isShowBackChosePersonWindow)
			    	{
					    alert("退回选择列表为空，不允许退回");
					    return;
				    }
			    	else
			    	{
				 	 	jQuery("#id_backRouteChoseWindow").show();
						jQuery("#id_backRouteChoseWindow").dialog({top:10});
						jQuery("#id_backRouteChoseWindow").dialog("open");
				    }
	    		}
		    }
    	}
    	else if(deleteButtonDisplayText == buttonText)
	    {
		    if(confirm("确认删除该流程实例么？"))
		    {
			    if(!loadMask)
			    {
			    	loadMask = new tracywindyLoadMask(document.body,"数据处理中，请稍等...");
				}
			    submitFormWithoutWorkflowNextCallBack();
			}
		}
    	else if(abondonButtonDisplayText == buttonText)
	    {
		    if(confirm("确认废弃该流程实例么？"))
		    {
			    if(!loadMask)
			    {
			    	loadMask = new tracywindyLoadMask(document.body,"数据处理中，请稍等...");
				}
			    submitFormWithoutWorkflowNextCallBack();
			}
		}
    	else if(readButtonDisplayText == buttonText)
    	{
    		new tracywindyCommonUserSelection({
    			hiddenInput:'id_readUserIds_hidden',
    			displayInput:'id_readUserRealNames_display',
    			displayPromit:'参与传阅的人员',
    			isMultiSelect:true,
    			choseCallBack:function(){
    			    submitFormWithoutWorkflowNextCallBack();
                    return true;
    			}
        	}).show();
        }
    	else if(signatureButtonDisplayText == buttonText)
    	{
    		new tracywindyCommonUserSelection({
    			hiddenInput:'id_signatureUserIds_hidden',
    			displayInput:'id_signatureUserRealNames_display',
    			displayPromit:'参与会签的人员',
    			isMultiSelect:true,
    			choseCallBack:function(){
    				submitFormWithoutWorkflowNextCallBack();
                    return true;
    			}
        	}).show();
    		
        }
    	else if(assignmentButtonDisplayText == buttonText)
    	{
    		new tracywindyCommonUserSelection({
    			hiddenInput:'id_assignmentedUserId_hidden',
    			displayInput:'id_assignmentUserRealName_display',
    			isMultiSelect:false,
    			displayPromit:'被指派人员',
    			choseCallBack:function(){
    				submitFormWithoutWorkflowNextCallBack();
                    return true;
    			}
        	}).show();
        }
    }
    function submitFormWithoutWorkflowNextCallBack()
    {
        //条件通过提交表单
        jQuery("#id_workflowAdviseContainer").css("overflow","hidden");
        jQuery("#id_workflowFormContainer").css("overflow","hidden");
        if(!loadMask)
        {
        	loadMask = new tracywindyLoadMask(document.body,"数据处理中，请稍等...");
        }
        loadMask.show();
        window.top.document.body.style.overflow="hidden";
        var submitProcessedForm = document.getElementById("id_submitProcessedForm");
    	submitProcessedForm.submit();
    	return false;
	}
    /*function saveCallBack(returnResult){}*///保存回调函数
    function ajaxCallBack(returnResult,assignmentIsSilentModel)
    {
        jQuery("#id_workflowAdviseContainer").css("overflow","auto");
        jQuery("#id_workflowFormContainer").css("overflow","auto");

        if(saveButtonDisplayText == globalCurrentPressButtonText)
        {
        	if(window.saveCallBack)//保存成功时候的回调函数
        	{
        		saveCallBack(returnResult);
    	    }
    	    if(!assignmentIsSilentModel){
		    	var promitInfo = '<spring:message code="Save"  text="保存"/><spring:message code="Success"  text="成功"/>';
		    	alert(promitInfo);
	    	}
	    	if(loadMask)loadMask.hide();
	    	return;
        }
        else if(submitButtonDisplayText == globalCurrentPressButtonText)
        {
        }
        else if(backButtonDisplayText==globalCurrentPressButtonText)
    	{
	    }
        else if(deleteButtonDisplayText==globalCurrentPressButtonText)
    	{
        	returnResult = "该流程已被成功删除";
	    }
        else if(abondonButtonDisplayText==globalCurrentPressButtonText)
    	{
        	returnResult = "该流程已被成功废弃";
	    }
        else if(readButtonDisplayText==globalCurrentPressButtonText)
    	{
	    	if(loadMask)loadMask.hide();
	    	var promitInfo = '<spring:message code="WorkflowRead"  text="传阅"/><spring:message code="Success"  text="成功"/>';
	    	alert(promitInfo);
	    	return;
	    }
        else if(signatureButtonDisplayText==globalCurrentPressButtonText)
    	{
	    	if(loadMask)loadMask.hide();
	    	var promitInfo = '<spring:message code="Signature"  text="会签"/><spring:message code="Success"  text="成功"/>';
	    	alert(promitInfo);
	    	return;
	    }
        else if(assignmentButtonDisplayText==globalCurrentPressButtonText)
    	{
	    }
		try{
		    if(window.opener)
		    {
			window.opener.location.reload();
		    }
		}catch(e){}
	    if(deleteButtonNoSavedDisplayText != globalCurrentPressButtonText){
	    	alert(returnResult);
	    }
	    try{closeWindow();}catch(e){}
    	/*window.opener = null;
        window.open("","_self");
     	window.close();*/
    }
    //提交下一步
    function  submitNextTask(){
    	jQuery("#id_currentTaskSubmitButtonText").val(submitButtonDisplayText);
    	jQuery("#id_submitProcessedForm")[0].submit();
	}
	function doChoseRouteOper(operFlag)
    {
		    //短信
         	/*if(true){
         		if(jQuery('#isSendMsgFlag').attr('checked')){
         			//短信内容
         			var value = jQuery('#sendMsgContent');
         		}
         	}*/
	        var currentChosePersonArr = [];
	        var displayPromit = "";
         	if('next'==operFlag)
         	{
         		displayPromit = "请选择要提交到的节点";
         	}
         	else if('back'==operFlag)
         	{
         		displayPromit = "请选择要退回到的节点";
         	}
         	else if('all'==operFlag)
         	{
         		displayPromit = "请选择要重置路由的节点";
         	}
     		var firstAlllement = jQuery("input[name^='"+operFlag+"_chose_']:checked:first")[0];
     		if(!firstAlllement){alert(displayPromit);return false;}
     		var parent_name = firstAlllement.getAttribute("parent_name");
     		jQuery("input[parent_name='"+parent_name+"']").each(function(){
         		var currentName = this.getAttribute("name");
         		if(!currentChosePersonArr.contains(currentName)){
         			currentChosePersonArr.push(currentName);
             	}
            });
         	var allActivityRequestInitiators = {};
         	var signatureAllActivityRequestInitiators = {};
         	var readAllActivityRequestInitiators = {};
         	var chosedRoutePath = null;
         	if(currentChosePersonArr)
         	{
             	for(var i=0;i<currentChosePersonArr.length;i++)
             	{
	            	var currentChosePerson = currentChosePersonArr[i];
	            	currentChoses = jQuery("input[name='"+currentChosePerson+"']:checked");
					//modify by tracywindy 2013-08-26 
					actorCurrentChoses      = jQuery("input[name='"+currentChosePerson+"'][flag='actor']");
					actorCurrentChosesChecked   = jQuery("input[name='"+currentChosePerson+"'][flag='actor']:checked");
	            	readCurrentChoses       = jQuery("input[name='"+currentChosePerson+"'][flag='read']");
	            	readCurrentChosesChecked    = jQuery("input[name='"+currentChosePerson+"'][flag='read']:checked");
	            	signatureCurrentChoses  = jQuery("input[name='"+currentChosePerson+"'][flag='signature']");
	            	signatureCurrentChosesChecked  = jQuery("input[name='"+currentChosePerson+"'][flag='signature']:checked");

                    var isNeedSignature = (signatureCurrentChoses.length>0)&&(0 == signatureCurrentChosesChecked.length);
                    var isNeedRead = (readCurrentChoses.length>0)&&(0 == readCurrentChosesChecked.length);
	            	var msg = "";
	            	if((actorCurrentChoses.length>0)&&(0 == actorCurrentChosesChecked.length)){
	            		msg = "任务处理人";
		            }
	            	else if(isNeedSignature){
	            		msg = "会签对象";
		            }
	            	else if(isNeedRead){
	            		msg = "传阅对象";
		            }
               	    if(msg/*!currentChoses[0]*/)
              	    {
              		   alert("请选择【"+currentChosePerson.substring(currentChosePerson.lastIndexOf("_")+1)+"】"+msg);
              		   return;
              	    }
               	    else
               	    {
               	        var dealMethod  = null;
				        var passedCount = null;
               	 	    var requestInitiators = new Array();
               	 	    var readRequestInitiators = new Array();
               	 	    var signatureRequestInitiators = new Array();
               	    	currentChoses.each(function(i){
                   	    	if(0==i)
                   	    	{
                   	    		chosedRoutePath = this.getAttribute("routePath");
                       	    }
                       	    var flag = this.getAttribute("flag");
                       	    switch(flag){
                       	      case "actor":{
                           	      if(0==i){
                           	        dealMethod    = this.getAttribute("dealMethod");
                           	        passedCount   = this.getAttribute("passedCount");
                           	  }
                           	  requestInitiators.push({username:this.getAttribute("login_name")});break;}
                       	      case "read":{readRequestInitiators.push({username:this.getAttribute("login_name")});break;}
                       	      case "signature":{signatureRequestInitiators.push({username:this.getAttribute("login_name")});break;}
                       	      default:{requestInitiators.push({username:this.getAttribute("login_name")});break;}
                       	    }
                   	    });
	               	 	/*		
	               	 	 *     changeRequestInitiator={
	               	 	 * 			"02-分支任务1":[{"username":"Admin"}],
	               	 	 * 			"03-分支任务2":[{"username":"Admin"}],
	               	 	 * 			"04-分支任务3":[{"username":"Admin"}]
	               	 	 * 		}
	               	 	 */
                   	    var node_name = currentChoses[0].getAttribute("node_name");
                   	    if("NPassed" == dealMethod){
                       	    if(parseInt(passedCount) > requestInitiators.length){
                           	    alert("节点【"+node_name+"】所勾选的处理人员数量必须大于等于需要通过的"+passedCount+"人!");
                           	    return;
                           	}
                       	}
               	    	allActivityRequestInitiators[node_name] =requestInitiators; 
               	    	readAllActivityRequestInitiators[node_name] =readRequestInitiators; 
               	    	signatureAllActivityRequestInitiators[node_name] =signatureRequestInitiators; 
						//设置任意路由的节点名称
               	    	document.getElementById("id_choseRequestNextRouteNodeName").value =currentChoses[0].getAttribute("parent_node_name");
                   	}
                }
            }
         	if('next'==operFlag)
         	{
         	    jQuery("#id_nextRouteChoseWindow").dialog("close");
         	}
         	else if('back'==operFlag)
         	{
         		jQuery("#id_backRouteChoseWindow").dialog("close");
         	}
         	else if('all'==operFlag)
         	{
         		jQuery("#id_allRouteChoseWindow").dialog("close");
         	}
         	var requestNextRoute = document.getElementById("id_requestInitiatorRoute");
         	var changeRequestInitiator = document.getElementById("id_changeRequestInitiator");
         	var signatureChangeRequestInitiator = document.getElementById("id_signatureChangeRequestInitiator");
         	var readChangeRequestInitiator = document.getElementById("id_readChangeRequestInitiator");
         	requestNextRoute.value = chosedRoutePath;
         	changeRequestInitiator.value = JsonUtil.encode(allActivityRequestInitiators);
         	signatureChangeRequestInitiator.value = JsonUtil.encode(signatureAllActivityRequestInitiators);
         	readChangeRequestInitiator.value = JsonUtil.encode(readAllActivityRequestInitiators);
         	submitFormWithoutWorkflowNextCallBack();
       }
	   function dealNextRouteChoseWindow()
	   {
		        //通过哪条路由路线进行提交
		        var requestNextRoute = document.getElementById("id_requestInitiatorRoute");
		        //modify by tracywindy 20140211
		        if(!requestNextRoute.value){
			        if(window.workflowNextRouteCallBack)//该回调函数可用于设置提交提交的路由线路通过(requestNextRoute.value=路由线路值)进行设置;
			    	{//该回调函数先于endAction中的appointRequestRoute方法的执行
			    		workflowNextRouteCallBack(globalCurrentPressButtonText,requestNextRoute);
			        }
			    	else
			    	{
			    		requestNextRoute.value="";
			        }
		        }
			   var currentChosePersonArr = null;
			   //var requestNextRoute = document.getElementById("id_requestInitiatorRoute");
			   var requestNextRouteValue = (!requestNextRoute.value?"":requestNextRoute.value);
			   jQuery("tr[identity]").show();
			   //jQuery("input[name^='back_chose_']:first").attr("checked",true);
			   if((backButtonDisplayText==globalCurrentPressButtonText))
			   {//modify by tracywindy for default chose first person
				   currentChosePersonArr = backChosePersonArr;
				   /*if(window.workflowNextRouteCallBack)
				   {
					   jQuery("tr[identity][identity!='back_chose_tr_"+requestNextRouteValue+"']").hide();
					  // jQuery("tr[identity][identity^='back_chose_tr_'][routePath!='"+requestNextRouteValue+"']").hide();
				   }*/
				   //jQuery("input[name^='back_chose_']:first").attr("checked",true);
				   //return;
			   }
			   else if((submitButtonDisplayText==globalCurrentPressButtonText))
			   {	
				   currentChosePersonArr = nextChosePersonArr;
				   if(requestNextRouteValue || window.workflowNextRouteCallBack)
				   {
					   ///lish
				      jQuery("tr[identity][identity!='next_chose_tr_"+requestNextRouteValue+"']").hide();
				   }
			   }
			 //modify by tracywindy for default chose first person
			   var $firstCheckedInput = null;
			   //默认勾选取消
			   if(currentChosePersonArr)
	           {
				   for(var i=0;i<currentChosePersonArr.length;i++)
	               {
	            	   var currentChoses = null;
	            	   jQuery("input[name='"+currentChosePersonArr[i]+"']").attr("checked",false); 
	            	   if(window.workflowNextRouteCallBack)
	            	   {
		            	   /*
		            	   //var nameFlag = "";
		            	   if((submitButtonDisplayText==globalCurrentPressButtonText))
	            		   {
	            			   //nameFlag ="next_chose_";
	            			   currentChoses = jQuery("input[routePath='"+requestNextRouteValue+"'][name='"+currentChosePersonArr[i]+"']:first");  
		            	   }
	                       else if((backButtonDisplayText==globalCurrentPressButtonText))
	                       {
	                    	   //nameFlag ="back_chose_";
	                    	   currentChoses = jQuery("input[name='"+currentChosePersonArr[i]+"']:first"); 
		                   }*/
	            		   currentChoses = jQuery("input[routePath='"+requestNextRouteValue+"'][name='"+currentChosePersonArr[i]+"']");  
		               }
	            	   else
	            	   {
	            		   currentChoses = jQuery("input[name='"+currentChosePersonArr[i]+"']:first");  
	            		   if(null == $firstCheckedInput){
	            			   $firstCheckedInput = currentChoses;
		            	   }
		               }
	            	   currentChoses.attr("checked",true);
	               }
	           }
	           //added by tracywindy
	           if(null != $firstCheckedInput){
	        	   var first_parent_name = $firstCheckedInput.attr("parent_name");
	        	   if(first_parent_name){
	        		   jQuery("input[parent_name][parent_name!='"+first_parent_name+"']").attr("checked",false);  
		           }
		       }
		}
	   //选择会签人或者传阅人
	   function readOrSignatureOper(flag)
	   {
		    var msg = "确认提交么？";
		    if(!window.confirm(msg))
		    {
			    return;
			}
		    var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');
		    var url = "${pageContext.request.contextPath}/jbpm/removeReadPersonToTask.action";
		    if('read'!=flag)
		    {
		    	if(!hidden_text_choseAdvise.value){alert("请填写处理意见");return;};
		    	url = "${pageContext.request.contextPath}/jbpm/removeSignaturePersonToTask.action";
			}
		    if(!loadMask)
		    {
		    	loadMask = new tracywindyLoadMask(document.body,"数据处理中，请稍等...");
			}
		    loadMask.show();
		    ajaxRequest({
	              url:url,
	              success:function(res){alert("操作成功");if(window.opener){window.opener.location.reload();}closeWindow();},
	              failure:function(res){alert("操作失败");if(window.opener){window.opener.location.reload();}closeWindow();},
	              params:{
	            	    jbpmWorkflowHistoryInfoId:currentJbpmWorkflowHistoryInfoId,
	            	    processedAdvise:hidden_text_choseAdvise.value
	              }
			});
		    
	   }
 </script>