<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!-- function -->
   <script type="text/javascript">
	   window.onresize = function(){
		   	var currentPageClientWidth  =  document.documentElement.clientWidth;
		   	var currentPageClientHeight =  document.documentElement.clientHeight;
		   	currentPageClientWidth  = currentPageClientWidth  > 0 ? currentPageClientWidth  : document.body.clientWidth;
		   	currentPageClientHeight = currentPageClientHeight > 0 ? currentPageClientHeight : document.body.clientHeight;
		       if(
		                (Math.abs(currentPageClientWidth-oldCurrentPageClientWidth)>10)
		              &&(Math.abs(currentPageClientHeight-oldCurrentPageClientHeight)>10)
		         ){
		             if(confirm("您改变了页面的大小，确定录入内容已保存,重新布局页面么？")){
		           	  window.location.href = window.location.href;
			          }
		         }
		   	oldCurrentPageClientWidth  =  currentPageClientWidth;
		   	oldCurrentPageClientHeight =  currentPageClientHeight;
		};
		//点击加载容器内容
		function getLazyLoadedObj(infoFlag,$parent,callback){
			/*if(lazyLoadedObj[infoFlag]){
				return true;
			}*/
			if((("advise" == infoFlag)||("history" == infoFlag)) && lazyLoadedObj[infoFlag]){
				return true;
			}else if(lazyLoadedObj[infoFlag]){
				try{jQuery("#id_nextRouteChoseWindow")[0].outerHTML="";}catch(e){};
				try{$parent.remove(jQuery("#id_backRouteChoseWindow"));}catch(e){};
				try{$parent.remove(jQuery("#id_allRouteChoseWindow"));}catch(e){};
			}
			var loadMaskContainer = jQuery("#id_loadMaskContainer");
			loadMaskContainer.show();
			//回退之前的回调函数
	        if(window.backBeforeOperCallBack)
	        {
	            backBeforeOperCallBack();
	        }
			var back_workflow_name='';
			if(document.getElementById("id_back_workflow_name_str")!=null){
				back_workflow_name = document.getElementById("id_back_workflow_name_str").value;
			}
			 
			var params = {
					jhiCompletedTaskImplId:'${currentJbpmWorkflowHistoryInfoId}',
					historyProcessInstanceImplDbid:'${currentProcessInstanceDBID}',
					jbpmWorkflowHistoryInfoUserId:'${jbpmWorkflowHistoryInfoUserId}',
					infoFlag:infoFlag,
					backworkflowname:back_workflow_name
				};
	        var submitForm = document.getElementById("id_submitProcessedForm");
	        var formElements = submitForm.elements;
	        for (var i = 0; i < formElements.length; i++) {
	        	var formElement = formElements[i];
	        	var inputName   = formElement.name;
	        	var inputValue  = formElement.value;
		        if(inputName){
		        	params[inputName] = inputValue;
			    }
		    }
			ajaxRequest({
				url:"${pageContext.request.contextPath}/jbpm/getWorkflowInfo.action",
				async:false, 
				success:function(res){
					var html = (res.responseText||"").replace(/(\r|\n)/gi,"");
					if(0 == (html||"").indexOf("javascript:")){
				        var oHead = document.getElementsByTagName("HEAD").item(0); 
				        var oScript = document.createElement( "script" ); 
				        oScript.language = "javascript"; 
				        oScript.type = "text/javascript"; 
				        oScript.defer = true; 
				        oScript.text = html.substring("javascript:".length,html.length); 
				        oHead.appendChild( oScript ); 
						return;
					}
					$parent.append(jQuery(html));
					if(callback){
						try{
							callback();
						}catch(e){
							lazyLoadedObj[infoFlag] = false;
							return;
						}
					}
					loadMaskContainer.hide();
					lazyLoadedObj[infoFlag] = true;
				},
				failure:function(res){
				},
				timeout:30*60*1000,
				params:params
				
		    });
			return false;
		}
		function backRejectChecked(checkName){
		     jQuery("#id_backRouteChoseWindow input[parent_name^='back_chose_'][parent_name!='"+checkName+"']:checked").attr("checked",false);
		     
		     jQuery("#id_backRouteChoseWindow input[id^='back_chose_'][id!='"+checkName+"_checkedAll_actor']:checked").each(function(){
			       if(((checkName+"_checkedAll_read") != this.id) && ((checkName+"_checkedAll_signature") != this.id)){
				       this.checked = false;
				   }
			 });
		     jQuery("#id_backRouteChoseWindow input[id^='back_chose_'][id!='"+checkName+"_checkedAll_read']:checked").each(function(){
			       if(((checkName+"_checkedAll_actor") != this.id) && ((checkName+"_checkedAll_signature") != this.id)){
				       this.checked = false;
				   }
			 });
		     jQuery("#id_backRouteChoseWindow input[id^='back_chose_'][id!='"+checkName+"_checkedAll_signature']:checked").each(function(){
			       if(((checkName+"_checkedAll_actor") != this.id) && ((checkName+"_checkedAll_read") != this.id)){
				       this.checked = false;
				   }
			 });
		     //jQuery("#id_backRouteChoseWindow input[name^='back_chose_'][parent_name!='"+checkName+"']:checked").attr("checked",false);
		     //jQuery("#id_backRouteChoseWindow input[id^='back_chose_'][id!='"+checkName+"_checkedAll']:checked").attr("checked",false);
		}
		function nextRejectChecked(checkName,flag){
		     jQuery("#id_nextRouteChoseWindow input[parent_name^='next_chose_'][parent_name!='"+checkName+"']:checked").attr("checked",false);
		     
		     jQuery("#id_nextRouteChoseWindow input[id^='next_chose_'][id!='"+checkName+"_checkedAll_actor']:checked").each(function(){
			       if(((checkName+"_checkedAll_read") != this.id) && ((checkName+"_checkedAll_signature") != this.id)){
				       this.checked = false;
				   }
			 });
		     jQuery("#id_nextRouteChoseWindow input[id^='next_chose_'][id!='"+checkName+"_checkedAll_read']:checked").each(function(){
			       if(((checkName+"_checkedAll_actor") != this.id) && ((checkName+"_checkedAll_signature") != this.id)){
				       this.checked = false;
				   }
			 });
		     jQuery("#id_nextRouteChoseWindow input[id^='next_chose_'][id!='"+checkName+"_checkedAll_signature']:checked").each(function(){
			       if(((checkName+"_checkedAll_actor") != this.id) && ((checkName+"_checkedAll_read") != this.id)){
				       this.checked = false;
				   }
			 });
		}
		function allRejectChecked(checkName){
		    /* jQuery("#id_allRouteChoseWindow input[parent_name^='all_chose_'][parent_name!='"+checkName+"']:checked").attr("checked",false);
		     jQuery("#id_allRouteChoseWindow input[id^='all_chose_'][id!='"+checkName+"_checkedAll']:checked").attr("checked",false);*/
		     jQuery("#id_allRouteChoseWindow input[parent_name^='all_chose_'][parent_name!='"+checkName+"']:checked").attr("checked",false);
		     
		     jQuery("#id_allRouteChoseWindow input[id^='all_chose_'][id!='"+checkName+"_checkedAll_actor']:checked").each(function(){
			       if(((checkName+"_checkedAll_read") != this.id) && ((checkName+"_checkedAll_signature") != this.id)){
				       this.checked = false;
				   }
			 });
		     jQuery("#id_allRouteChoseWindow input[id^='all_chose_'][id!='"+checkName+"_checkedAll_read']:checked").each(function(){
			       if(((checkName+"_checkedAll_actor") != this.id) && ((checkName+"_checkedAll_signature") != this.id)){
				       this.checked = false;
				   }
			 });
		     jQuery("#id_allRouteChoseWindow input[id^='all_chose_'][id!='"+checkName+"_checkedAll_signature']:checked").each(function(){
			       if(((checkName+"_checkedAll_actor") != this.id) && ((checkName+"_checkedAll_read") != this.id)){
				       this.checked = false;
				   }
			 });
		}
		function doCheckedAll(checked,checkName,parentCheckName,flag)
		{
			var checkboxsArr =  document.getElementsByName(checkName);
            var checkboxs = [];
            for(var i=0;i<checkboxsArr.length;i++){
                var checkbox = checkboxsArr[i];
                if(flag == checkbox.getAttribute("flag")){
                	checkboxs.push(checkbox);
                } 
            }
			for(var i=0;i<checkboxs.length;i++)
			{
				checkboxs[i].checked = checked;
			}
			if(checkName.indexOf("back_chose_")>-1){
				backRejectChecked(parentCheckName);
			}
			if(checkName.indexOf("next_chose_")>-1){
				nextRejectChecked(parentCheckName,flag);
			}
			if(checkName.indexOf("all_chose_")>-1){
				allRejectChecked(parentCheckName);
			}
		 }
		 function toggleFormDisplay()
		 {
			jQuery("#id_toggle_tabs_form").show();
			jQuery("#id_toggle_tabs_advise").hide();
			jQuery("#id_toggle_tabs_attachment").hide();
			
			jQuery("#id_toggle_form_link").parent().addClass("tabs-selected");
			jQuery("#id_toggle_advise_link").parent().removeClass("tabs-selected");
			jQuery("#id_toggle_attachment_link").parent().removeClass("tabs-selected");
		}

		function toggleAdviseDisplay()
		{
			jQuery("#id_toggle_tabs_form").hide();
			jQuery("#id_toggle_tabs_advise").show();
			jQuery("#id_toggle_tabs_attachment").hide();
			
			jQuery("#id_toggle_advise_link").parent().addClass("tabs-selected");
			jQuery("#id_toggle_form_link").parent().removeClass("tabs-selected");
			jQuery("#id_toggle_attachment_link").parent().removeClass("tabs-selected");
			getLazyLoadedObj("advise",jQuery("#id_workflowAdviseContainer"),function(){
				  if(currentSavedAdvise /*&& !isCompletedTask*/)
				  {
				  	 addCommonAdivse(currentSavedAdvise);
				  }
			});
		}
	    function toggleAttachmentDisplay()
	    {
			jQuery("#id_toggle_tabs_form").hide();
			jQuery("#id_toggle_tabs_advise").hide();
			jQuery("#id_toggle_tabs_attachment").show();
			
			jQuery("#id_toggle_advise_link").parent().removeClass("tabs-selected");
			jQuery("#id_toggle_form_link").parent().removeClass("tabs-selected");
			jQuery("#id_toggle_attachment_link").parent().addClass("tabs-selected");
			loadWorkflowAttachment();
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
		function toggleDisplay()
		{
		   var currentOperationImgElement = window.event.srcElement;
		   var isDisplay = currentOperationImgElement.src.indexOf("_b")==-1;
		   currentOperationImgElement.src = isDisplay?currentOperationImgElement.src.replace("_a","_b"):currentOperationImgElement.src.replace("_b","_a");
		   var toggleDisplayElement = currentOperationImgElement.parentNode.parentNode.nextSibling;
		   toggleDisplayElement.style.display = (isDisplay?"block":"none");
		}
   </script>