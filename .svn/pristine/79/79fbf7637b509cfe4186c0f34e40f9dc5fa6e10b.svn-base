

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
  var currentJbpmWorkflowHistoryInfoId = '40288584408a22f801408acceacc0068';
  var isViewHistoryTask  = ( "true" == "true" );
  var isCompletedTask    = ( "true" == "true" );
  //i18n
  var submitButtonDisplayText ="Submit"; //("提交"),
  var resetRouteButtonDisplayText="ResetRoute";//("任意路由"),
  var saveButtonDisplayText = "Save";//("保存"),
  var backButtonDisplayText ="Back";//("退回"),
  var deleteButtonDisplayText="Delete";//("删除"),
  var abondonButtonDisplayText="Abondon";//("废弃流程"),
  var finishButtonDisplayText="Finish";//("已结束"),
  var draftButtonDisplayText="Draft";//("草稿"),
  var pendingButtonDisplayText="Pending";//("待处理"),
  var signatureButtonDisplayText="Signature";//("会签"),
  var readButtonDisplayText="WorkflowRead";//("传阅"),
  var assignmentButtonDisplayText="Assignment";//("工作指派"),
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>06-运营部专员办理</title>
<link href="/deewinfl/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css"/>
<link href="/deewinfl/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
<link href="/deewinfl/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
<link href="/deewinfl/css/tracywindy/workflow.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="/deewinfl/js/tracywindy/tracywindyUtils.js"></script>
<script type="text/javascript" src="/deewinfl/js/tracywindy/tracywindyJsonUtil.js"></script>
<script type="text/javascript" src="/deewinfl/js/tracywindy/tracywindyLoadMask.js"></script>
<script type="text/javascript" src="/deewinfl/js/tracywindy/tracywindyComboBox.js"></script>
<script type="text/javascript" src="/deewinfl/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript" src="/deewinfl/js/tracywindy/tracywindyTable.js"></script>
<script type="text/javascript" src="/deewinfl/js/tracywindy/tracywindyAttachmentFileUpload.js"></script>
<script type="text/javascript" src="/deewinfl/js/tracywindy/tracywindyCommonUserSelection.js"></script>
<script type="text/javascript" src="/deewinfl/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/deewinfl/js/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/deewinfl/js/jquery/easyui-lang-zh_CN.js"></script>
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
	</script>
	
    
	   <script type="text/javascript">
	     isShowBackChosePersonWindow = false;
	   </script>
    
</head>
   <body style="overflow:hidden;padding:5px;padding-bottom:2px;">
			<script type="text/javascript" language="javascript" src="/deewinfl/print/LodopFuncs.js"></script>
       		  <div id="id_loadMaskContainer" style="display:block;">
					  <div id="loading">
					    <div class="loading-indicator">
	                                                                       正在加载   请稍等...
					    </div>
					</div>
			  </div>
			  <script type="text/javascript">
			     jQuery("#id_loadMaskContainer").css("height",all_height);			        
			  </script>
    <div>
       <div class="x-panel-table-div-title" id="id_focusComponent">流程：项目信审流程(设备)[06-运营部专员办理]</div>
       <div class="x-panel-table-toolbar-div">
		        <!--提交按钮-->
		        <div>
			       <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="if(window.confirm('确认关闭此流程页面么？'))closeWindow();" plain="true" iconCls="icon-cancel">关闭</a>
			       
			       <span id='id_btn_tools_container'></span>
			       <a style="margin-left:50px;" href="javascript:void(0);" class="easyui-linkbutton-btn" onclick='btn_callBack(resetRouteButtonDisplayText);' plain="true" iconCls="icon-department">任意路由</a>
			       <a style="margin-left:50px;" href="javascript:void(0);" class="easyui-linkbutton-btn" onclick='toProcessActivePicture();' plain="true" iconCls="icon-department">流程图</a>
			       <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick='viewWorkflowHistoryDetail();' plain="true" iconCls="icon-globe">历史信息</a>
			       <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick='viewProjSummary();' plain="true" iconCls="icon-track">项目总表</a>
			       <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick='previewPrint();' plain="true" iconCls="icon-print">打印预览</a>
		        </div>
		        <script>jQuery(".easyui-linkbutton-btn").linkbutton({plain:true}).linkbutton('disable');</script>
		     </div>
		 		   <div id="id_content_tabs"><!--页签开始-->
		             <div class="tabs-header">
					    <div style="display: none;" class="tabs-scroller-left"></div><div style="display: none;" class="tabs-scroller-right"></div>
					
					    <div  class="tabs-wrap">
					       <ul class="tabs">
					          <li class="tabs-selected"><a href="javascript:void(0)"  id="id_toggle_form_link" onclick="toggleFormDisplay();" class="tabs-inner"><span class="tabs-title">流程表单</span><span class="tabs-icon"></span></a></li>
						      <li><a href="javascript:void(0)" id="id_toggle_advise_link" href="javascript:void(0);" class="tabs-inner" onClick="toggleAdviseDisplay();"><span class="tabs-title">审批意见</span><span class="tabs-icon"></span></a></li>
						      <li><a href="javascript:void(0)" id="id_toggle_attachment_link" href="javascript:void(0);" class="tabs-inner" onClick="toggleAttachmentDisplay();"><span class="tabs-title">附件一览</span><span class="tabs-icon"></span></a></li>
					       </ul> 
					    </div>
					 </div>
		              <div  style="display:block;" id="id_toggle_tabs_form"><!--页签1开始-->
				        <!--表单处理-->
				        <div  class="workflow-title"><span style="height:100%;padding-top:5px;font-size:11px;color:#FFFFFF;font-weight:BOLD;">流程表单</span></div>
					     <div style="" id="id_workflowFormContainer">
						     <div  id="id_workflowFormContainer_inner">
							   <iframe name="real_submit_frame" style="display:none;" id="id_real_submit_frame"></iframe>
							   <form  id="id_submitProcessedForm" enctype="multipart/form-data" target="real_submit_frame" action="{pageContext.request.contextPath}/submitProcessedForm/jbpm/submitProcessedForm.action" method="post">
                               <div id="id_wf_hidden_field" style="display: none;">
							       <!--工作指派-->
							        <input type="hidden" id="id_assignmentUserId_hidden" name="assignmentUserId" readOnly value=""/>
							 指派人：<input type="text" id="id_assignmentUserRealName_display" name="assignmentUserRealName" readOnly  value=""/>
					                 被指派人： <input type="hidden" id="id_assignmentedUserId_hidden" name="assignmentedUserId" readOnly value=""/>
							        <input type="text" id="id_assignmentedUserRealName_display" name="assignmentedUserRealName" readOnly  value=""/>
							        <!--传阅-->
							        <input type="hidden" id="id_readUserIds_hidden" name="readUserIds" readOnly  value=""/>    
						      传阅人：      <input type="text" id="id_readUserRealNames_display" readOnly  value=""/>    
							        <!--会签-->
							        <input type="hidden" id="id_signatureUserIds_hidden" name="signatureUserIds" readOnly value=""/>
						     会签人：       <input type="text" id="id_signatureUserRealNames_display" readOnly  value=""/>
							        <input type="text" value="pending" name="currentRequestTaskType"/>
                                   </div>
							       <!-- 必要隐藏参数 -->
							       <input type="hidden" id="id_currentTaskId" name="currentTaskId" value="150071" />
							       <input type="hidden" name="jbpmWorkflowHistoryInfoUserId" value="40288584408a22f801408accead90069" />
							       <!--任意路由参数--> 
							       <input type="hidden" id="id_choseRequestNextRouteNodeName" name="choseRequestNextRouteNodeName" value="150071" />
							       <!-- 流程实例动态变量 -->
							       <input type="hidden" id="id_requestInitiatorRoute" name="requestInitiatorRoute" value=""/>
							       <input type="hidden" id="id_changeRequestInitiator" name="changeRequestInitiator" value=""/>
							       <input type="hidden" id="id_hidden_text_choseAdvise" name="processedAdvise"  value=""/>
							       <input type="hidden" id="id_currentTaskSubmitButtonText" name="currentTaskSubmitButtonText"  value=""/>
							       <input type="hidden" id="id_workflow_ishis" name="is_workflow_ishis" value="" />
								   <!-- 当前任务节点表单路径相对于jbpm-core/forms下的jsp页面 -->
								   ssss
								   <script type="text/javascript">
								       jQuery("#id_loadMaskContainer").hide();
								   </script>
							   </form>
							 </div>
						</div>
				    </div><!--页签1结束-->
				    <!--审批意见-->
		            <div id="id_toggle_tabs_advise"><!--页签2开始-->
						       <div class="x-panel-table-div-title" >
							                    意见一览
						       </div>
							       <div id="id_workflowAdviseContainer">
									       
									           
									           
									           
									           
									           
									           
										       <div class="taskname">
                                                   <table><tr>
										           <td><strong>【<font color="red">提交</font>】06-运营部专员办理</strong></td>
                                                   <td>【开始时间】2013-08-17 13:43:39</td>
                                                   <td>【结束时间】2013-08-17 13:43:52</td>
                                                   <td>【耗时】0.21&nbsp;分钟</td>
                                                   </tr></table>
										       </div>
										       
										        
									            
									            
									            
									            
										        <div class="taskactor">
											           【处理人】&nbsp;&nbsp;&nbsp; 1、超级管理员&nbsp;&lt;&nbsp;超级管理员&nbsp;&gt;&nbsp;<br>
												【处理意见】 &nbsp;&nbsp;
											    </div>
										       
									       
									           
									           
									           
									           
									           
									           
										       <div class="taskname">
                                                   <table><tr>
										           <td><strong>【<font color="red">提交</font>】05-业务评审委员会(3) 评审</strong></td>
                                                   <td>【开始时间】2013-08-17 13:43:23</td>
                                                   <td>【结束时间】2013-08-17 13:43:39</td>
                                                   <td>【耗时】0.28&nbsp;分钟</td>
                                                   </tr></table>
										       </div>
										       
										        
									            
									            
									            
									            
										        <div class="taskactor">
											           【处理人】&nbsp;&nbsp;&nbsp; 1、超级管理员&nbsp;&lt;&nbsp;超级管理员&nbsp;&gt;&nbsp;<br>
												【处理意见】 &nbsp;&nbsp;
											    </div>
										       
									       
									           
									           
									           
									           
									           
									           
										       <div class="taskname">
                                                   <table><tr>
										           <td><strong>【<font color="red">提交</font>】04-信审部经理审核</strong></td>
                                                   <td>【开始时间】2013-08-17 13:43:09</td>
                                                   <td>【结束时间】2013-08-17 13:43:22</td>
                                                   <td>【耗时】0.23&nbsp;分钟</td>
                                                   </tr></table>
										       </div>
										       
										        
									            
									            
									            
									            
										        <div class="taskactor">
											           【处理人】&nbsp;&nbsp;&nbsp; 1、超级管理员&nbsp;&lt;&nbsp;超级管理员&nbsp;&gt;&nbsp;<br>
												【处理意见】 &nbsp;&nbsp;
											    </div>
										       
									       
									           
									           
									           
									           
									           
									           
										       <div class="taskname">
                                                   <table><tr>
										           <td><strong>【<font color="red">提交</font>】03-信审专员</strong></td>
                                                   <td>【开始时间】2013-08-17 13:42:29</td>
                                                   <td>【结束时间】2013-08-17 13:43:08</td>
                                                   <td>【耗时】0.65&nbsp;分钟</td>
                                                   </tr></table>
										       </div>
										       
										        
									            
									            
									            
									            
										        <div class="taskactor">
											           【处理人】&nbsp;&nbsp;&nbsp; 1、超级管理员&nbsp;&lt;&nbsp;超级管理员&nbsp;&gt;&nbsp;<br>
												【处理意见】 &nbsp;&nbsp;
											    </div>
										       
									       
									           
									           
									           
									           
									           
									           
										       <div class="taskname">
                                                   <table><tr>
										           <td><strong>【<font color="red">提交</font>】02-信审部经理分派考察人员</strong></td>
                                                   <td>【开始时间】2013-08-17 13:42:14</td>
                                                   <td>【结束时间】2013-08-17 13:42:29</td>
                                                   <td>【耗时】0.26&nbsp;分钟</td>
                                                   </tr></table>
										       </div>
										       
										        
									            
									            
									            
									            
										        <div class="taskactor">
											           【处理人】&nbsp;&nbsp;&nbsp; 1、超级管理员&nbsp;&lt;&nbsp;超级管理员&nbsp;&gt;&nbsp;<br>
												【处理意见】 &nbsp;&nbsp;
											    </div>
										       
									       
									           
									           
									           
									           
									           
									           
										       <div class="taskname">
                                                   <table><tr>
										           <td><strong>【<font color="red">流程发起</font>】01-信审专员发起</strong></td>
                                                   <td>【开始时间】2013-08-17 13:40:48</td>
                                                   <td>【结束时间】2013-08-17 13:42:14</td>
                                                   <td>【耗时】1.43&nbsp;分钟</td>
                                                   </tr></table>
										       </div>
										       
										        
									            
									            
									            
									            
										        <div class="taskactor">
											           【处理人】&nbsp;&nbsp;&nbsp; 1、超级管理员&nbsp;&lt;&nbsp;超级管理员&nbsp;&gt;&nbsp;<br>
												【处理意见】 &nbsp;&nbsp;
											    </div>
										       
									       
						        </div>
		              </div><!--页签2结束-->
		             <div id="id_toggle_tabs_attachment"><!--页签2开始-->
						       <div class="x-panel-table-div-title" > 
						                         附件上传
						       </div>
						       <div id="id_workflowAttachmentContainer">
						       </div>
				    </div>
				</div><!--页签结束-->  
				<!-- js 函数开始 -->
				<script type="text/javascript">
				window.onresize = function(){
			    	var currentPageClientWidth  =  document.documentElement.clientWidth;
			    	var currentPageClientHeight =  document.documentElement.clientHeight;
			    	currentPageClientWidth  = currentPageClientWidth  > 0 ? currentPageClientWidth  : document.body.clientWidth;
			    	currentPageClientHeight = currentPageClientHeight > 0 ? currentPageClientHeight : document.body.clientHeight;
		            if(
		                     (Math.abs(currentPageClientWidth-oldCurrentPageClientWidth)>4)
		                   ||(Math.abs(currentPageClientHeight-oldCurrentPageClientHeight)>4)
		              ){
			              if(confirm("您改变了页面的大小，确定录入内容已保存,重新布局页面么？")){
			            	  window.location.href = window.location.href;
				          }
		              }
			    	oldCurrentPageClientWidth  =  currentPageClientWidth;
			    	oldCurrentPageClientHeight =  currentPageClientHeight;
				};
				//jQuery(function()
			    {
					   jQuery("#id_workflowFormContainer_inner").css("width",(all_width-containerWidthAdd-10)+"px");
				       jQuery("#id_workflowFormContainer_inner").css("height",(all_height-containerHeightAdd-1)+"px");
				       jQuery("#id_workflowAdviseContainer").css("width",(all_width-containerWidthAdd)+"px");
				       jQuery("#id_workflowAdviseContainer").css("height",(all_height-containerWidthAdd-124)+"px");
				       jQuery(".x-panel-table-toolbar-div").css("width",(all_width-containerWidthAdd)+"px");
				       jQuery(".x-panel-table-div-title").css("width",(all_width-containerWidthAdd)+"px");
				       jQuery("#id_toggle_tabs_advise .x-panel-table-div-title").css("width",(all_width-containerWidthAdd-20)+"px");
				       jQuery("#id_toggle_tabs_attachment .x-panel-table-div-title").css("width",(all_width-containerWidthAdd-20)+"px");
				       jQuery("#id_content_tabs .tabs-header").css("width",(all_width-containerWidthAdd+1)+"px");
					   //加载通用意见
					   jQuery(function(){
						   new tracywindyComboBox({
			                      renderTo:'id_selectAdvise',
			                      id:'id_selectAdvise_combo',
			                      width:200,
				           	      xmlFileName:'\\combos\\comboDict.xml',
				        	      loadMode:'ajax',
				        	      readOnly:true,
				        	      displayField:'name',
				        	      valueField:'code',
				        	      isForceModify:true,
				        	      params:{
			                        pid:'JbpmCommonAdvise'
				        	      },
				        	      onSelect:function(combo){
					        	      var selectedAdviseValue = combo.getRawValue();
				        	    	  document.getElementById('text_selectedAdvise').value = selectedAdviseValue;
				        	    	  document.getElementById('id_hidden_text_choseAdvise').value = selectedAdviseValue;
					        	  }
							  });
					   });
						  //加载附件
					 /*
					    renderToContainer,//渲染到哪个div的id
					    attachmentType,//附件分类
					    serialNo,//流水号唯一标识
					    isReadOnly,//是否只能下载，不能上传和删除附件
					    width,//上传列表宽度
					    height,//上传列表高度
					    title//列表标题
					    border//边框
					    */
				     /*new tracywindyAttachmentFileUpload(
		                  'id_workflowAttachmentContainer',
		                  '',
		                  'DY2013000026',
		                  '',
		                  '',
		                  '',
		                  '',
		                  '',
		                  '',
		                  '',
		                  '',
		                  '',
		                  false,
		                  all_width-12,
		                  all_height-containerWidthAdd-124,
		                  '',
		                  false,
		                  "id_toggle_tabs_attachment"
					 );*/
				}
				//);//jquery finish
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
				}
			    function toggleAttachmentDisplay()
				{
					 jQuery("#id_toggle_tabs_form").hide();
					 jQuery("#id_toggle_tabs_advise").hide();
					 jQuery("#id_toggle_tabs_attachment").show();
					 
					 jQuery("#id_toggle_advise_link").parent().removeClass("tabs-selected");
					 jQuery("#id_toggle_form_link").parent().removeClass("tabs-selected");
					 jQuery("#id_toggle_attachment_link").parent().addClass("tabs-selected");
				}
				//显示流程图
				function toProcessActivePicture(){
					var processInstanceId =encodeURI('项目信审流程(设备).150060');
					window.open("/deewinfl/workflow/jbpm/getActivedRects.action?deployId=169&processInstanceId="+processInstanceId+"&randomNumber="+Math.random(),"_blank");
			    }
			    //流程历史信息
			    function viewWorkflowHistoryDetail(){
			    	jQuery("#id_workflowHistoryDetailInfoWindow").show();
					jQuery("#id_workflowHistoryDetailInfoWindow").window({top:20});
			    	jQuery("#id_workflowHistoryDetailInfoWindow").window("open");
			    }
			    //流程历史信息
			    function viewProjSummary(){
			    	
				    var URL = "/deewinfl/jbpm/getProjSummaryHistoryInfos.action?keyOne=DY2013000026";
				    openFullScreenWindow(URL);
			    }
			    //打开历史表单
			    function toProcessForm(currentTaskId){
			    	window.open("/deewinfl/jbpm/viewHistoryProcessForm.action?currentTaskId="+currentTaskId,"_blank");
			    }
			    //打印预览
			    function previewPrint(){
				    var currentTaskId = "150071"||"150071";
				    var URL = "/deewinfl/jbpm/preivewProcessTaskForm.action?currentTaskId="+currentTaskId+"&jbpmWorkflowHistoryInfoUserId=";
				    /*if(SysBrowser.getBrowser().indexOf("IE")>-1)
					{
						var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));
			    		LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_按网址打印");
			    		LODOP.ADD_PRINT_URL(30,20,746,"100%",URL);
			    		LODOP.SET_PRINT_STYLEA(1,"HOrient",3);
			    		LODOP.SET_PRINT_STYLEA(1,"VOrient",3);
			    		LODOP.PREVIEW();
					}
					else*/
					{
						window.open (URL, '_blank','width='+(1014)+',height='+(window.screen.availHeight-30)+ ',top=0,left=0,location=no,directories=no,toolbar=no,resizable=no,status=no,menubar=no,scrollbars=yes'); 
						/*directories：是否显示链接工具栏； 
						location：是否显示地址栏； 
						menubar：是否显示菜单栏； 
						resizable：是否允许调整窗口大小； 
						scrollbars：是否显示滚动条； 
						status：是否显示状态栏； 
						toolbar */
				    }
				}
			    //提交下一步
			    function  submitNextTask(){
			    	jQuery("#id_currentTaskSubmitButtonText").val(submitButtonDisplayText);
			    	jQuery("#id_submitProcessedForm")[0].submit();
				}
				 function doChoseRouteOper(operFlag)
			        {
						//短信
			         	if(true){
			         		if(jQuery('#isSendMsgFlag').attr('checked')){
			         			//短信内容
			         			var value = jQuery('#sendMsgContent');
			         		}
			         		
			         	}
						
						
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
			     			currentChosePersonArr.push(this.getAttribute("name"));
			            });
			         	var allActivityRequestInitiators = {};
			         	var chosedRoutePath = null;
			         	if(currentChosePersonArr)
			         	{
			             	for(var i=0;i<currentChosePersonArr.length;i++)
			             	{
			             		/*var requestNextRoute = document.getElementById("id_requestInitiatorRoute");
			             		requestNextRouteValue = requestNextRoute.value;
				            	   var currentChoses = null;
				            	   if(('next'==operFlag) && window.workflowNextRouteCallBack)
				            	   {
					            	   var nameFlag = "";
				            		   if('next'==operFlag)
				            		   {
				            			   nameFlag ="next_chose_";
					            	   }
				                       else if('back'==operFlag)
				                       {
				                    	   nameFlag ="back_chose_";
					                   }
				            		   currentChoses = jQuery("input[name^='"+nameFlag+requestNextRouteValue+"'][name='"+currentChosePersonArr[i]+"']");  
					            	   if(!currentChoses[0])
					            	   {
						            	   continue;
						               }
					            	   else
					            	   {
					            		   currentChoses = currentChoses.parent().find(":checked");
						               }
					               }
				            	   else
				            	   {
				            		   currentChoses = jQuery("input[name='"+currentChosePersonArr[i]+"']:checked");  
					               }*/
				            	currentChoses = jQuery("input[name='"+currentChosePersonArr[i]+"']:checked");  
			               	    if(!currentChoses[0])
			              	    {
			              		   alert("请选择【"+currentChosePersonArr[i].substring(currentChosePersonArr[i].lastIndexOf("_")+1)+"】任务执行人");
			              		   return;
			              	    }
			               	    else
			               	    {
			               	 	    var requestInitiators = new Array();
			               	    	currentChoses.each(function(i){
			                   	    	if(0==i)
			                   	    	{
			                   	    		chosedRoutePath = this.getAttribute("routePath");
			                       	    }
			               	    		requestInitiators.push({username:this.getAttribute("login_name")});
			                   	    });
			               	    	allActivityRequestInitiators[currentChoses[0].getAttribute("node_name")] =requestInitiators; 
									//设置任意路由的节点名称
			               	    	document.getElementById("id_choseRequestNextRouteNodeName").value =currentChoses[0].getAttribute("parent_node_name");
			                   	}
			                }
			            }
			         	
			         	
			         	
			         	
			         	if('next'==operFlag)
			         	{
			         	    jQuery("#id_nextRouteChoseWindow").window("close");
			         	}
			         	else if('back'==operFlag)
			         	{
			         		jQuery("#id_backRouteChoseWindow").window("close");
			         	}
			         	else if('all'==operFlag)
			         	{
			         		jQuery("#id_allRouteChoseWindow").window("close");
			         	}
			         	var requestNextRoute = document.getElementById("id_requestInitiatorRoute");
			         	var changeRequestInitiator = document.getElementById("id_changeRequestInitiator");
			         	requestNextRoute.value = chosedRoutePath;
			         	changeRequestInitiator.value = JsonUtil.encode(allActivityRequestInitiators);
			         	submitFormWithoutWorkflowNextCallBack();
			       }
					   function dealNextRouteChoseWindow()
					   {
						   var currentChosePersonArr = null;
						   var requestNextRoute = document.getElementById("id_requestInitiatorRoute");
						   var requestNextRouteValue = requestNextRoute.value;
						   jQuery("tr[identity]").show();
						   //jQuery("input[name^='back_chose_']:first").attr("checked",true);
						   if((backButtonDisplayText==globalCurrentPressButtonText))
						   {
							   /*currentChosePersonArr = backChosePersonArr;
							   if(window.workflowNextRouteCallBack)
							   {
								   jQuery("tr[identity][identity!='back_chose_tr_"+requestNextRouteValue+"']").hide();
								  // jQuery("tr[identity][identity^='back_chose_tr_'][routePath!='"+requestNextRouteValue+"']").hide();
							   }*/
							   //jQuery("input[name^='back_chose_']:first").attr("checked",true);
							   return;
						   }
						   if((submitButtonDisplayText==globalCurrentPressButtonText))
						   {	
							   currentChosePersonArr = nextChosePersonArr;
							   if(window.workflowNextRouteCallBack)
							   {
							      jQuery("tr[identity][identity!='next_chose_tr_"+requestNextRouteValue+"']").hide();
							   }
						   }
						   //默认勾选取消
						   /*
				           if(currentChosePersonArr)
				           {
				               for(var i=0;i<currentChosePersonArr.length;i++)
				               {
				            	   var currentChoses = null;
				            	   if(window.workflowNextRouteCallBack)
				            	   {
					            	   var nameFlag = "";
					            	   if((submitButtonDisplayText==globalCurrentPressButtonText))
				            		   {
				            			   nameFlag ="next_chose_";
					            	   }
				                       else if((backButtonDisplayText==globalCurrentPressButtonText))
				                       {
				                    	   nameFlag ="back_chose_";
					                   }
				            		   currentChoses = jQuery("input[name^='"+nameFlag+requestNextRouteValue+"'][name='"+currentChosePersonArr[i]+"']:first");  
					               }
				            	   else
				            	   {
				            		   currentChoses = jQuery("input[name='"+currentChosePersonArr[i]+"']:first");  
					               }
				            	   currentChoses.attr("checked",true);
				               }
				           }*/
					   }
				   </script>
				<!-- js 函数结束 -->
		 <!--任意路由开始-->
		        <div id="id_allRouteChoseWindow"  closed="true" modal="true" title="任意下一步详情" style="display:none;width:600px;padding-top:10px;padding:0px;">
		        <center>
		            <script type="text/javascript">
					    allChosePersonArr = [];
					</script>
			        <div style="width:96%;text-align:left;">
				        <table  width="100%">
				            
				            <tr style='height:20px;'><td></td></tr>
				            
				                
				                
				                
				                
				                
					             
					                
					             
					             <script type="text/javascript">
					               allChosePersonArr.push('all_chose__01-信审专员发起');
					             </script>
					             <tr identity="all_chose_tr_">
					                 <td colspan=2>
					                  <div> 
					                    01-信审专员发起
					                    
					                                                    【
					                        单人处理
					                  	】
						                    
					                    
					                  </div>
					                 </td>
					             </tr>
					             
					             
					                  
					                    <tr identity="all_chose_tr_">
					                  
					                      <td style="padding-left:10px;">
						                      <input 
						                        style="position:relative;top:3px;" 
						                        type="radio" name="all_chose__01-信审专员发起"  
						                        node_name="01-信审专员发起" real_name="超级管理员" 
						                        delegate_real_name="" login_name="administrator" routePath=""
						                        onclick="allRejectChecked('all_chose__01-信审专员发起');"
						                        parent_node_name="01-信审专员发起"
						                        parent_name     = "all_chose__01-信审专员发起" 
						                      />
						                      超级管理员
					                     </td>
					                  
										
										
											
											     </tr>
											
										
									  
					             
				            
				                
				                
				                
				                
				                
					             
					                
					             
					             <script type="text/javascript">
					               allChosePersonArr.push('all_chose__02-信审部经理分派考察人员');
					             </script>
					             <tr identity="all_chose_tr_">
					                 <td colspan=2>
					                  <div> 
					                    02-信审部经理分派考察人员
					                    
					                                                    【
					                        单人处理
					                  	】
						                    
					                    
					                  </div>
					                 </td>
					             </tr>
					             
					             
					                  
					                    <tr identity="all_chose_tr_">
					                  
					                      <td style="padding-left:10px;">
						                      <input 
						                        style="position:relative;top:3px;" 
						                        type="radio" name="all_chose__02-信审部经理分派考察人员"  
						                        node_name="02-信审部经理分派考察人员" real_name="超级管理员" 
						                        delegate_real_name="" login_name="administrator" routePath=""
						                        onclick="allRejectChecked('all_chose__02-信审部经理分派考察人员');"
						                        parent_node_name="02-信审部经理分派考察人员"
						                        parent_name     = "all_chose__02-信审部经理分派考察人员" 
						                      />
						                      超级管理员
					                     </td>
					                  
										
										
											
											     </tr>
					             <script type="text/javascript">
					               allChosePersonArr.push('all_chose__03-信审专员');
					             </script>
					             <tr identity="all_chose_tr_">
					                 <td colspan=2>
					                  <div> 
					                    03-信审专员
					                    
					                                                    【
					                        单人处理
					                  	】
					                  </div>
					                 </td>
					             </tr>
					                    <tr identity="all_chose_tr_">
					                  
					                      <td style="padding-left:10px;">
						                      <input 
						                        style="position:relative;top:3px;" 
						                        type="radio" name="all_chose__03-信审专员"  
						                        node_name="03-信审专员" real_name="超级管理员" 
						                        delegate_real_name="" login_name="administrator" routePath=""
						                        onclick="allRejectChecked('all_chose__03-信审专员');"
						                        parent_node_name="03-信审专员"
						                        parent_name     = "all_chose__03-信审专员" 
						                      />
						                      超级管理员
					                     </td>
											     </tr>
					             <script type="text/javascript">
					               allChosePersonArr.push('all_chose__04-信审部经理审核');
					             </script>
					             <tr identity="all_chose_tr_">
					                 <td colspan=2>
					                  <div> 
					                    04-信审部经理审核
					                    
					                                                    【
					                        单人处理
					                  	】
					                  </div>
					                 </td>
					             </tr>
					                    <tr identity="all_chose_tr_">
					                      <td style="padding-left:10px;">
						                      <input 
						                        style="position:relative;top:3px;" 
						                        type="radio" name="all_chose__04-信审部经理审核"  
						                        node_name="04-信审部经理审核" real_name="超级管理员" 
						                        delegate_real_name="" login_name="administrator" routePath=""
						                        onclick="allRejectChecked('all_chose__04-信审部经理审核');"
						                        parent_node_name="04-信审部经理审核"
						                        parent_name     = "all_chose__04-信审部经理审核" 
						                      />
						                      超级管理员
					                     </td>
											     </tr>
					             <script type="text/javascript">
					               allChosePersonArr.push('all_chose__05-业务评审委员会(1) 评审');
					             </script>
					             <tr identity="all_chose_tr_">
					                 <td colspan=2>
					                  <div> 
					                    05-业务评审委员会(1) 评审
					                    
					                                                    【
					                        单人处理
					                  	】
					                  </div>
					                 </td>
					             </tr>
					                    <tr identity="all_chose_tr_">
					                  
					                      <td style="padding-left:10px;">
						                      <input 
						                        style="position:relative;top:3px;" 
						                        type="radio" name="all_chose__05-业务评审委员会(1) 评审"  
						                        node_name="05-业务评审委员会(1) 评审" real_name="超级管理员" 
						                        delegate_real_name="" login_name="administrator" routePath=""
						                        onclick="allRejectChecked('all_chose__05-业务评审委员会(1) 评审');"
						                        parent_node_name="05-业务评审委员会(1) 评审"
						                        parent_name     = "all_chose__05-业务评审委员会(1) 评审" 
						                      />
						                      超级管理员
					                     </td>
											     </tr>
					             <script type="text/javascript">
					               allChosePersonArr.push('all_chose__05-业务评审委员会(2) 评审');
					             </script>
					             <tr identity="all_chose_tr_">
					                 <td colspan=2>
					                  <div> 
					                    05-业务评审委员会(2) 评审
					                    
					                                                    【
					                        单人处理
					                  	】
					                  </div>
					                 </td>
					             </tr>
					                    <tr identity="all_chose_tr_">
					                      <td style="padding-left:10px;">
						                      <input 
						                        style="position:relative;top:3px;" 
						                        type="radio" name="all_chose__05-业务评审委员会(2) 评审"  
						                        node_name="05-业务评审委员会(2) 评审" real_name="超级管理员" 
						                        delegate_real_name="" login_name="administrator" routePath=""
						                        onclick="allRejectChecked('all_chose__05-业务评审委员会(2) 评审');"
						                        parent_node_name="05-业务评审委员会(2) 评审"
						                        parent_name     = "all_chose__05-业务评审委员会(2) 评审" 
						                      />
						                      超级管理员
					                     </td>
											     </tr>
					             <script type="text/javascript">
					               allChosePersonArr.push('all_chose__05-业务评审委员会(3) 评审');
					             </script>
					             <tr identity="all_chose_tr_">
					                 <td colspan=2>
					                  <div> 
					                    05-业务评审委员会(3) 评审
					                                                    【
					                        单人处理
					                  	】
						                    
					                  </div>
					                 </td>
					             </tr>
					                    <tr identity="all_chose_tr_">
					                  
					                      <td style="padding-left:10px;">
						                      <input 
						                        style="position:relative;top:3px;" 
						                        type="radio" name="all_chose__05-业务评审委员会(3) 评审"  
						                        node_name="05-业务评审委员会(3) 评审" real_name="超级管理员" 
						                        delegate_real_name="" login_name="administrator" routePath=""
						                        onclick="allRejectChecked('all_chose__05-业务评审委员会(3) 评审');"
						                        parent_node_name="05-业务评审委员会(3) 评审"
						                        parent_name     = "all_chose__05-业务评审委员会(3) 评审" 
						                      />
						                      超级管理员
					                     </td>
											     </tr>
					             <script type="text/javascript">
					               allChosePersonArr.push('all_chose__结束');
					             </script>
					             <tr identity="all_chose_tr_">
					                 <td colspan=2>
					                  <div> 
					                    结束
					                    
					                  </div>
					                 </td>
					             </tr>
					             
					               <tr identity="all_chose_tr_">
					                      <td style="padding-left:10px;">
						                      <input 
						                        style="position:relative;top:3px;" 
						                        type="radio" name="all_chose__结束"  
						                        node_name="radio" 
						                        routePath=""
						                        onclick="allRejectChecked('all_chose__结束');"
						                        parent_node_name="结束"
						                        parent_name     = "all_chose__结束" 
						                      />
						                      结束
					                     </td>
					               </tr>  
				            <tr style='text-align:center;padding-top:30px;height:40px;'>
							      <td colspan='2'>
								       <input class="btn btn-primary" type="button" value="确定" onclick='doChoseRouteOper("all");' style="cursor:pointer;width:60px;"/>
								       <input class="btn btn-primary" type="button" value="取消" onclick='jQuery("#id_allRouteChoseWindow").window("close");' style="cursor:pointer;margin-left:20px;width:60px;"/>
							      </td>
							</tr>
				        </table>
			        </div>
		        </center>
		     </div>
		 <!--任意路由结束-->
		        <!--弹出选人框开始-->
		        <div id="id_nextRouteChoseWindow"  closed="true" modal="true" title="提交下一步详情" style="display:none;width:600px;padding-top:10px;padding:0px;">
		        <center>
		            <script type="text/javascript">
					    nextChosePersonArr = [];
					</script>
			        <div style="width:96%;text-align:left;">
				        <table  width="100%">
				            <tr style='height:20px;'><td></td></tr>
					             <script type="text/javascript">
					               nextChosePersonArr.push('next_chose_TO 结束_结束');
					             </script>
					             <tr identity="next_chose_tr_TO 结束">
					                 <td colspan=2>
					                  <div> 
					                    结束
					                    
					                  </div>
					                 </td>
					             </tr>
					               <tr identity="next_chose_tr_TO 结束">
					                   <td colspan=2>
					                      <input type="radio" style="position:relative;top:3px;" 
					                      name="next_chose_TO 结束_结束"  
					                      login_name="NULL" routePath="TO 结束" 
					                      node_name="结束"
					                      onclick="nextRejectChecked('next_chose_TO 结束_结束');"
						                  parent_node_name="结束"
						                  parent_name     = "next_chose_TO 结束_结束" 
					                      />
					                      结束
					                   </td>
					               </tr>  
				            <tr>
				            	<td  bgcolor=#d9d9d9 colspan="2">
				            	<div id="workflow_message" >
				            	<fieldset>
 								   <legend>【信息】</legend>
				            			<div title="发送短信" >
					            			<table  width="98%">
					            				<tr>
					            					<td  colspan="4">是否发送短信：<input id="isSendMsgFlag" type="checkbox" > 是否发送站内信：<input id="isSendStationMsgFlag" type="checkbox" ></td>
					            				</tr>
					            				<tr>
					            					<td style="width: 100px;">短息内容：</td>
					            					<td colspan="3">
					            						<textarea id="sendMsgContent" rows="2" cols="50"></textarea>
					            					</td>
					            				</tr>
					            			</table>
				            			</div>
	<!-- 			            			<div title="发送站内信" >
					            			<table  width="100%">
					            				<tr>
					            					<td  style="width: 100px;">是否发送站内信：</td>
					            					<td><input id="isSendStationMsgFlag" type="checkbox" ></td>
					            				</tr>
					            				<tr>
					            					<td style="width: 100px;">站内信内容：</td>
					            					<td ><textarea id="sendStationMsgContent" rows="2" cols="50"></textarea></td>
					            				</tr>
					            			</table>
				            			</div> -->
				            			</fieldset>
				            		</div>
				            	</td>
				            </tr>
				            <tr style='text-align:center;padding-top:30px;height:40px;'>
							      <td colspan='2'>
								       <input class="btn btn-primary" type="button" value="确定" onclick='doChoseRouteOper("next");' style="cursor:pointer;width:60px;"/>
								       <input class="btn btn-primary" type="button" value="取消" onclick='jQuery("#id_nextRouteChoseWindow").window("close");' style="cursor:pointer;margin-left:20px;width:60px;"/>
							      </td>
							</tr>
				        </table>
			        </div>
		        </center>
		     </div>
		     <div id="id_backRouteChoseWindow"  closed="true" modal="true" title="提交下一步详情" style="display:none;width:600px;padding-top:10px;padding:0px;">
		        <center>
		            <script type="text/javascript">
		                backChosePersonArr = [];
					</script>
			        <div style="width:96%;text-align:left;">
				        <table  width="100%">
				            
				            <tr style='height:20px;'><td></td></tr>
				            
				            <tr style='text-align:center;padding-top:30px;height:40px;'>
							      <td colspan='2'>
								       <input  class="btn btn-primary" type="button" value="确定" onclick='doChoseRouteOper("back");' style="cursor:pointer;width:60px;"/>
								       <input  class="btn btn-primary" type="button" value="取消" onclick='jQuery("#id_backRouteChoseWindow").window("close");' style="cursor:pointer;margin-left:20px;width:60px;"/>
							      </td>
							</tr>
				        </table>
			        </div>
		        </center>
		     </div>
		        <!--弹出选人框结束-->
		        <!-- 弹出意见框开始 -->
		        <div id="id_adviseContainerWindow" buttons="#id_adviseButtons" closed="true" modal="true" title="意见表单" style="display:none;width:350px;text-align:center">
							   <table style="width:96%" style="margin:auto;padding:auto;">
							      <tr class="tr-odd">
							         <td style="width:100px;">当前时间：</td>
							         <td><div id="id_currentSystemTime"></div></td>
							      </tr>
							      <tr class="tr-even" style="width:100px;">
							         <td style="padding-top:10px;">常用意见：</td>
							         <td style="padding-top:10px;"><div id="id_selectAdvise"></div></td>
							      </tr>
							      <tr class="tr-odd">
							         <td  style="width:100px;">&nbsp;</td>
							         <td style="text-align:left;"><textarea id="text_selectedAdvise" style="width:196px;height:300px;overflow:auto;border:1px solid #DDD;"></textarea></td>
							      </tr>
							   </table>
			   	</div>	   
			   	<div style="padding-top:15px;text-align:center;display:none;" id="id_adviseButtons"> 
					           <input class="btn btn-primary" type="button" value="确定" onclick='fillCurrentCommonAdvise();jQuery("#id_adviseContainerWindow").dialog("close");' style="cursor:pointer;width:60px;"/>
							   <input class="btn btn-primary" type="button" value="取消" onclick='jQuery("#id_adviseContainerWindow").dialog("close");' style="cursor:pointer;margin-left:20px;width:60px;"/>
			   	 </div>     	 
		        <!-- 弹出意见框结束-->
			</div>
			<!--历史信息window-->
			<div id="id_workflowHistoryDetailInfoWindow"  closed="true" modal="true" title="流程历史处理信息" style="display:none;width:1004px;height:550px;padding:10px;">
					<div class="taskname">
                        <table><tr>
					    <td><strong>【<font color="red">提交</font>】&nbsp;&nbsp;<a href="javascript:void(0);" onclick="toProcessForm('150071')">06-运营部专员办理</a></strong></td>
                        <td>【开始时间】2013-08-17 13:43:39</td>
                        <td>【结束时间】2013-08-17 13:43:52</td>
                        <td>【耗时】0.21&nbsp;分钟</td>
                        </tr></table>
					</div>
					<div class="taskactor">
					<fieldset class="historyFieldSet">
					<legend>处理信息：<a href="javascript:void(0);" onclick="javascript:fieldsetHidden(event);"><img src="/deewinfl/images/arrowDown.gif"  border="0" align="absmiddle"/></a></legend>
					<table class="workflowTable"><tr><th style="width:20px;">&nbsp;</th><th>【处理状态】</th><th>【计划处理人】</th><th>【实际处理人】</th><th>【处理时间】</th><th>【处理意见】</th></tr>
				          <tr>
				             <td>1</td>
					      <td><font color="">已处理</font></td>
					      <td><font color="">超级管理员</font></td>
					      <td><font color="">超级管理员</font></td>
					      <td><font color="">2013-08-17 13:43:52</font></td>
					      <td><font color=""></font></td>
					      </tr>
					</table>
					</fieldset>
					</div>
					<div class="taskname">
                        <table><tr>
					    <td><strong>【<font color="red">提交</font>】&nbsp;&nbsp;<a href="javascript:void(0);" onclick="toProcessForm('150069')">05-业务评审委员会(3) 评审</a></strong></td>
                        <td>【开始时间】2013-08-17 13:43:23</td>
                        <td>【结束时间】2013-08-17 13:43:39</td>
                        <td>【耗时】0.28&nbsp;分钟</td>
                        </tr></table>
					</div>
					<div class="taskactor">
					<fieldset class="historyFieldSet">
					<legend>处理信息：<a href="javascript:void(0);" onclick="javascript:fieldsetHidden(event);"><img src="/deewinfl/images/arrowDown.gif"  border="0" align="absmiddle"/></a></legend>
					<table class="workflowTable"><tr><th style="width:20px;">&nbsp;</th><th>【处理状态】</th><th>【计划处理人】</th><th>【实际处理人】</th><th>【处理时间】</th><th>【处理意见】</th></tr>
				          <tr>
				             <td>1</td>
					      <td><font color="">已处理</font></td>
					      <td><font color="">超级管理员</font></td>
					      <td><font color="">超级管理员</font></td>
					      <td><font color="">2013-08-17 13:43:39</font></td>
					      <td><font color=""></font></td>
					      </tr>
					</table>
					</fieldset>
					</div>
					<div class="taskname">
                        <table><tr>
					    <td><strong>【<font color="red">提交</font>】&nbsp;&nbsp;<a href="javascript:void(0);" onclick="toProcessForm('150067')">04-信审部经理审核</a></strong></td>
                        <td>【开始时间】2013-08-17 13:43:09</td>
                        <td>【结束时间】2013-08-17 13:43:22</td>
                        <td>【耗时】0.23&nbsp;分钟</td>
                        </tr></table>
					</div>
					<div class="taskactor">
					<fieldset class="historyFieldSet">
					<legend>处理信息：<a href="javascript:void(0);" onclick="javascript:fieldsetHidden(event);"><img src="/deewinfl/images/arrowDown.gif"  border="0" align="absmiddle"/></a></legend>
					<table class="workflowTable"><tr><th style="width:20px;">&nbsp;</th><th>【处理状态】</th><th>【计划处理人】</th><th>【实际处理人】</th><th>【处理时间】</th><th>【处理意见】</th></tr>
				          <tr>
				             <td>1</td>
					      <td><font color="">已处理</font></td>
					      <td><font color="">超级管理员</font></td>
					      <td><font color="">超级管理员</font></td>
					      <td><font color="">2013-08-17 13:43:23</font></td>
					      <td><font color=""></font></td>
					      </tr>
					</table>
					</fieldset>
					</div>
					<div class="taskname">
                        <table><tr>
					    <td><strong>【<font color="red">提交</font>】&nbsp;&nbsp;<a href="javascript:void(0);" onclick="toProcessForm('150065')">03-信审专员</a></strong></td>
                        <td>【开始时间】2013-08-17 13:42:29</td>
                        <td>【结束时间】2013-08-17 13:43:08</td>
                        <td>【耗时】0.65&nbsp;分钟</td>
                        </tr></table>
					</div>
					<div class="taskactor">
					<fieldset class="historyFieldSet">
					<legend>处理信息：<a href="javascript:void(0);" onclick="javascript:fieldsetHidden(event);"><img src="/deewinfl/images/arrowDown.gif"  border="0" align="absmiddle"/></a></legend>
					<table class="workflowTable"><tr><th style="width:20px;">&nbsp;</th><th>【处理状态】</th><th>【计划处理人】</th><th>【实际处理人】</th><th>【处理时间】</th><th>【处理意见】</th></tr>
				          <tr>
				             <td>1</td>
					      <td><font color="">已处理</font></td>
					      <td><font color="">超级管理员</font></td>
					      <td><font color="">超级管理员</font></td>
					      <td><font color="">2013-08-17 13:43:09</font></td>
					      <td><font color=""></font></td>
					      </tr>
					</table>
					</fieldset>
					</div>
					<div class="taskname">
                        <table><tr>
					    <td><strong>【<font color="red">提交</font>】&nbsp;&nbsp;<a href="javascript:void(0);" onclick="toProcessForm('150063')">02-信审部经理分派考察人员</a></strong></td>
                        <td>【开始时间】2013-08-17 13:42:14</td>
                        <td>【结束时间】2013-08-17 13:42:29</td>
                        <td>【耗时】0.26&nbsp;分钟</td>
                        </tr></table>
					</div>
					<div class="taskactor">
					<fieldset class="historyFieldSet">
					<legend>处理信息：<a href="javascript:void(0);" onclick="javascript:fieldsetHidden(event);"><img src="/deewinfl/images/arrowDown.gif"  border="0" align="absmiddle"/></a></legend>
					<table class="workflowTable"><tr><th style="width:20px;">&nbsp;</th><th>【处理状态】</th><th>【计划处理人】</th><th>【实际处理人】</th><th>【处理时间】</th><th>【处理意见】</th></tr>
				          <tr>
				             <td>1</td>
					      <td><font color="">已处理</font></td>
					      <td><font color="">超级管理员</font></td>
					      <td><font color="">超级管理员</font></td>
					      <td><font color="">2013-08-17 13:42:29</font></td>
					      <td><font color=""></font></td>
					      </tr>
					</table>
					</fieldset>
					</div>
					<div class="taskname">
                        <table><tr>
					    <td><strong>【<font color="red">流程发起</font>】&nbsp;&nbsp;<a href="javascript:void(0);" onclick="toProcessForm('150061')">01-信审专员发起</a></strong></td>
                        <td>【开始时间】2013-08-17 13:40:48</td>
                        <td>【结束时间】2013-08-17 13:42:14</td>
                        <td>【耗时】1.43&nbsp;分钟</td>
                        </tr></table>
					</div>
					<div class="taskactor">
					<fieldset class="historyFieldSet">
					<legend>处理信息：<a href="javascript:void(0);" onclick="javascript:fieldsetHidden(event);"><img src="/deewinfl/images/arrowDown.gif"  border="0" align="absmiddle"/></a></legend>
					<table class="workflowTable"><tr><th style="width:20px;">&nbsp;</th><th>【处理状态】</th><th>【计划处理人】</th><th>【实际处理人】</th><th>【处理时间】</th><th>【处理意见】</th></tr>
				          <tr>
				             <td>1</td>
					      <td><font color="">已处理</font></td>
					      <td><font color="">超级管理员</font></td>
					      <td><font color="">超级管理员</font></td>
					      <td><font color="">2013-08-17 13:42:14</font></td>
					      <td><font color=""></font></td>
					      </tr>
					</table>
					</fieldset>
					</div>
			</div>
			<!-- 
			<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
			       <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
			</object>
			 -->
</body>
 <script type="text/javascript">
 function backRejectChecked(checkName){
     jQuery("#id_backRouteChoseWindow input[name^='back_chose_'][parent_name!='"+checkName+"']:checked").attr("checked",false);
     jQuery("#id_backRouteChoseWindow input[id^='back_chose_'][id!='"+checkName+"_checkedAll']:checked").attr("checked",false);
}
 function nextRejectChecked(checkName){
     jQuery("#id_nextRouteChoseWindow input[parent_name^='next_chose_'][parent_name!='"+checkName+"']:checked").attr("checked",false);
     jQuery("#id_nextRouteChoseWindow input[id^='next_chose_'][id!='"+checkName+"_checkedAll']:checked").attr("checked",false);
}
 function allRejectChecked(checkName){
     jQuery("#id_allRouteChoseWindow input[parent_name^='all_chose_'][parent_name!='"+checkName+"']:checked").attr("checked",false);
     jQuery("#id_allRouteChoseWindow input[id^='all_chose_'][id!='"+checkName+"_checkedAll']:checked").attr("checked",false);
}
 
 function doCheckedAll(checked,checkName,parentCheckName)
 {
	var checkboxs =  document.getElementsByName(checkName);
	for(var i=0;i<checkboxs.length;i++)
	{
		checkboxs[i].checked = checked;
	}
	if(checkName.indexOf("back_chose_")>-1){
		backRejectChecked(parentCheckName);
	}
	if(checkName.indexOf("next_chose_")>-1){
		nextRejectChecked(parentCheckName);
	}
	if(checkName.indexOf("all_chose_")>-1){
		allRejectChecked(parentCheckName);
	}
	//document.getElementsByName(checkName+"_checkedAll")[0].checked = checked;
 }
   (function setInitFocus(){
	   setTimeout("document.getElementById('id_focusComponent').focus()",10);
   })();
   var globalCurrentPressButtonText = "";
   var loadMask  = null;
   //选择会签人或者传阅人
   function choseUsers(hiddenDomId,displayDomId,isSingle)
	{
		var strURL = "/deewinfl/acl/commonUserSelection.bi?isUseRowId=true";
		var parentOrgId   = '0';
		var parentOrgName = '组织结构';
		var selectModel   = 'M';
		if(isSingle)
		{
			selectModel   = 'S';
		}
		var isQueryModel  = null;
		var argumentArr = [];
		argumentArr.push(document.getElementById(hiddenDomId));//realValue
		argumentArr.push(document.getElementById(displayDomId));//displayValue
		return showModalUserSelectionWindow_(strURL,argumentArr,parentOrgId,parentOrgName,selectModel,isQueryModel);
   }
   function readOrSignatureOper(flag)
   {
	    var msg = "确认提交么？";
	    if(!window.confirm(msg))
	    {
		    return;
		}
	    var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');
	    var url = "/deewinfl/jbpm/removeReadPersonToTask.action";
	    if('read'!=flag)
	    {
	    	if(!hidden_text_choseAdvise.value){alert("请填写处理意见");return;};
	    	url = "/deewinfl/jbpm/removeSignaturePersonToTask.action";
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
   //提交按钮时候执行回调函数
    function btn_callBack(buttonText)
    {
	  
	    var isNeedChoseOper = false;
    	globalCurrentPressButtonText = buttonText;
    	document.getElementById('id_currentTaskSubmitButtonText').value = globalCurrentPressButtonText;
    	if(resetRouteButtonDisplayText==globalCurrentPressButtonText){
	 	 	jQuery("#id_allRouteChoseWindow").show();
			jQuery("#id_allRouteChoseWindow").window({top:10});
			jQuery("#id_allRouteChoseWindow").window("open"); 
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
		    
	        //是否提交    
	        if(window.workflowSubmitCallBack)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	        {
	            if(!workflowSubmitCallBack(buttonText))
	            {
	            	//setInitFocus();
	                return;
	            }
	        }
	        //通过哪条路由路线进行提交
	        var requestNextRoute = document.getElementById("id_requestInitiatorRoute");
	        if(window.workflowNextRouteCallBack)//该回调函数可用于设置提交提交的路由线路通过(requestNextRoute.value=路由线路值)进行设置;
	    	{//该回调函数先于endAction中的appointRequestRoute方法的执行
	    		isNeedChoseOper = workflowNextRouteCallBack(buttonText,requestNextRoute);
	        }
	    	else
	    	{
	    		requestNextRoute.value="";
	        }
	    	dealNextRouteChoseWindow();
	    	if((submitButtonDisplayText==globalCurrentPressButtonText))
	    	{
		    	if(!isShowSubmitChosePersonWindow)
		    	{
		    		submitFormWithoutWorkflowNextCallBack();
			    }
		    	else
		    	{
			 	 	jQuery("#id_nextRouteChoseWindow").show();
					jQuery("#id_nextRouteChoseWindow").window({top:10});
					jQuery("#id_nextRouteChoseWindow").window("open"); 
			    }
		    }
	    	else if((backButtonDisplayText==globalCurrentPressButtonText))
	    	{
		    	if(!isShowBackChosePersonWindow)
		    	{
				    alert("退回选择列表为空，不允许退回");
				    return;
			    }
		    	else
		    	{
			 	 	jQuery("#id_backRouteChoseWindow").show();
					jQuery("#id_backRouteChoseWindow").window({top:10});
					jQuery("#id_backRouteChoseWindow").window("open"); 
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
    function ajaxCallBack(returnResult)
    {
        jQuery("#id_workflowAdviseContainer").css("overflow","auto");
        jQuery("#id_workflowFormContainer").css("overflow","auto");

        if(saveButtonDisplayText == globalCurrentPressButtonText)
        {
        	if(window.saveCallBack)//保存成功时候的回调函数
        	{
        		saveCallBack(returnResult);
    	    }
	    	var promitInfo = '保存成功';
	    	alert(promitInfo);
        	//alert(globalCurrentPressButtonText+"成功");
	    	if(loadMask)loadMask.hide();
	    	return;
        }
        else if(submitButtonDisplayText == globalCurrentPressButtonText)
        {
        	/*var currentRadio = jQuery(":radio[name='next_chose_']:checked");
        	var loginName = currentRadio.attr("login_name");
        	if("NULL" == loginName)
        	{
            	alert("该流程已结束");
    	    	window.opener = null;
    	        window.open("","_self");
    	     	window.close();
            	return;
            }
        	var nodeName = currentRadio.attr("node_name");
        	var realName = currentRadio.attr("real_name");
        	var delegate_real_name = currentRadio.attr("delegate_real_name");
        	alert("流程已成功提交至：<"+nodeName+"，处理人："+realName+delegate_real_name+" >");*/
        }
        else if(backButtonDisplayText==globalCurrentPressButtonText)
    	{
        	/*var currentRadio = jQuery(":radio[name='back_radio_']:checked");
        	var nodeName = currentRadio.attr("node_name");
        	var realName = currentRadio.attr("real_name");
        	var delegate_real_name = currentRadio.attr("delegate_real_name");
        	alert("流程已成功退回至：<"+nodeName+"，处理人："+realName+delegate_real_name+">");*/
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
	    	//alert(globalCurrentPressButtonText+"成功");
	    	var promitInfo = '传阅成功';
	    	alert(promitInfo);
	    	return;
	    }
        else if(signatureButtonDisplayText==globalCurrentPressButtonText)
    	{
	    	if(loadMask)loadMask.hide();
	    	//alert(globalCurrentPressButtonText+"成功");
	    	var promitInfo = '会签成功';
	    	alert(promitInfo);
	    	return;
	    }
        else if(assignmentButtonDisplayText==globalCurrentPressButtonText)
    	{
	    	/*if(loadMask)loadMask.hide();
	    	alert(globalCurrentPressButtonText+"成功");
	    	return;*/
	    }
	    if(window.opener)
	    {
		    window.opener.location.reload();
		}
	    //alert(globalCurrentPressButtonText+"成功");
	    alert(returnResult);
    	window.opener = null;
        window.open("","_self");
     	window.close();
    }
    //添加意见
    //currentJBPMWorkflowHistoryInfoUser
    function addCommonAdivse(hidden_text_choseAdviseValue)
    {
    	var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');
    	hidden_text_choseAdvise.value = hidden_text_choseAdviseValue;
    	var workflowAdviseContainer = document.getElementById('id_workflowAdviseContainer');
        var insertHtml ='<div id="id_currentTaskFilledAdvise_1" style="border:0px solid silver;padding-left:5px;height:25px;line-height:25px;background-color:#EFEFEF;">';
    	insertHtml+='	<span style="width:200px;height:100%;padding-top:5px;font-size:12px;">【步骤】<font color="red" style="font-weight:BOLD;">当前处理</font></span>';
    	insertHtml+='	<span style="width:300px;margin-left:5%;height:100%;padding-top:5px;font-size:12px;">【填写时间】'+ getCurDateTime()+'</span>';
    	insertHtml+='	<span style="width:150px;margin-left:20%;height:100%;padding-top:4px;font-size:12px;">';
    	insertHtml+='		<a href="javascript:void(0);" style="text-decoration:none;" onclick="showModalCommonAdivseWindow();"><img align="absmiddle" src="/deewinfl/menuIcons/pencil.png" border="0"/>&nbsp;编辑</a>';
    	insertHtml+='		<a href="javascript:void(0);" style="text-decoration:none;margin-left:20px;" onclick="delCommonAdivse();"><img align="absmiddle" src="/deewinfl/menuIcons/no.png" border="0"/>&nbsp;删除</a></span>';
    	insertHtml+='</div>';
    	insertHtml+='<div id="id_currentTaskFilledAdvise_2" style="border:0px solid silver;border-top:0px solid #FFFFFF;border-bottom:0px;padding-left:20px;height:25px;line-height:25px;background-color:#FFFFFF;">';
    	insertHtml+='	<span style="height:100%;padding-top:5px;font-size:12px;">'+hidden_text_choseAdvise.value+'</span>';
    	insertHtml+='</div>';
        workflowAdviseContainer.innerHTML = (insertHtml+workflowAdviseContainer.innerHTML);
    }
    //判断已经保存过了意见
    var currentSavedAdvise = (""||"");
    if(currentSavedAdvise && !isViewHistoryTask)
    {
    	addCommonAdivse(currentSavedAdvise);
    }
    //通用意见弹出窗口
    function showModalCommonAdivseWindow()
    {
        var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');
        
	    document.getElementById("id_currentSystemTime").innerHTML= getCurDateTime();
	    document.getElementById('text_selectedAdvise').value = hidden_text_choseAdvise.value;
	    getTracywindyObject("id_selectAdvise_combo").setRawValue(hidden_text_choseAdvise.value);
	    jQuery("#id_adviseContainerWindow").show();
	    jQuery("#id_adviseContainerWindow").dialog({top:100});
	    jQuery("#id_adviseContainerWindow").dialog("open");
    }
    function fillCurrentCommonAdvise(){
        
    	var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');
     	hidden_text_choseAdvise.value = document.getElementById('text_selectedAdvise').value;
	    var workflowAdviseContainer = document.getElementById('id_workflowAdviseContainer');
	    var currentTaskFilledAdvise_1 = document.getElementById('id_currentTaskFilledAdvise_1');
	    if(currentTaskFilledAdvise_1)
	    {
	    	workflowAdviseContainer.removeChild(currentTaskFilledAdvise_1);
	    	var currentTaskFilledAdvise_2 = document.getElementById('id_currentTaskFilledAdvise_2');
	    	workflowAdviseContainer.removeChild(currentTaskFilledAdvise_2);
		}
        var insertHtml ='<div id="id_currentTaskFilledAdvise_1" style="border:0px solid silver;padding-left:5px;height:25px;line-height:25px;background-color:#EFEFEF;">';
        	insertHtml+='	<span style="width:200px;height:100%;padding-top:5px;font-size:12px;">【步骤】<font color="red" style="font-weight:BOLD;">当前处理</font></span>';
        	insertHtml+='	<span style="width:300px;margin-left:5%;height:100%;padding-top:5px;font-size:12px;">【填写时间】'+ getCurDateTime()+'</span>';
        	insertHtml+='	<span style="width:150px;margin-left:20%;height:100%;padding-top:4px;font-size:12px;">';
        	insertHtml+='		<a href="javascript:void(0);" style="text-decoration:none;" onclick="showModalCommonAdivseWindow();"><img align="absmiddle" src="/deewinfl/menuIcons/pencil.png" border="0"/>&nbsp;编辑</a>';
        	insertHtml+='		<a href="javascript:void(0);" style="text-decoration:none;margin-left:20px;" onclick="delCommonAdivse();"><img align="absmiddle" src="/deewinfl/menuIcons/no.png" border="0"/>&nbsp;删除</a></span>';
        	insertHtml+='</div>';
        	insertHtml+='<div id="id_currentTaskFilledAdvise_2" style="border:0px solid silver;border-top:0px solid #FFFFFF;border-bottom:0px;padding-left:20px;height:25px;line-height:25px;background-color:#FFFFFF;">';
        	insertHtml+='	<span style="height:100%;padding-top:5px;font-size:12px;">'+hidden_text_choseAdvise.value+'</span>';
        	insertHtml+='</div>';
        workflowAdviseContainer.innerHTML = (insertHtml+workflowAdviseContainer.innerHTML);
    }
    function delCommonAdivse()
    {
    	var workflowAdviseContainer = document.getElementById('id_workflowAdviseContainer');
    	var currentTaskFilledAdvise_1 = document.getElementById('id_currentTaskFilledAdvise_1');
	    if(currentTaskFilledAdvise_1)
	    {
	    	workflowAdviseContainer.removeChild(currentTaskFilledAdvise_1);
	    	var currentTaskFilledAdvise_2 = document.getElementById('id_currentTaskFilledAdvise_2');
	    	workflowAdviseContainer.removeChild(currentTaskFilledAdvise_2);
		}
	    var hidden_text_choseAdvise = document.getElementById('id_hidden_text_choseAdvise');
	    hidden_text_choseAdvise.value="";
	}
	function closeWindow()
	{
		window.opener=null;
		window.open("","_self");
		window.close();
	}
    function toggleDisplay()
    {
        var currentOperationImgElement = window.event.srcElement;
        var isDisplay = currentOperationImgElement.src.indexOf("_b")==-1;
        currentOperationImgElement.src = isDisplay?currentOperationImgElement.src.replace("_a","_b"):currentOperationImgElement.src.replace("_b","_a");
        var toggleDisplayElement = currentOperationImgElement.parentNode.parentNode.nextSibling;
        toggleDisplayElement.style.display = (isDisplay?"block":"none");
    }
   jQuery(function(){
	           if(isViewHistoryTask){
		           var submitForm = document.getElementById("id_submitProcessedForm");
		           var formElements = submitForm.elements;
		           for(var i=0;i<formElements.length;i++)
		           {
			           var formElement = formElements[i];
			           formElement.readOnly = true;
			           jQuery("#id_submitProcessedForm input[type='text'],#id_submitProcessedForm textarea").addClass("element-readonly");
			           if(formElement.className.indexOf("Wdate")>-1){
			        	   formElement.onclick = null;
				       }
			           removeClass(formElement,"Wdate");
			       }
			       if(window.formPageReadOnlyCallBack){
			    	   window.formPageReadOnlyCallBack(submitForm);
				   }
		       }
	           document.documentElement.style.overflow = "hidden";
	           document.body.style.overflow = "hidden";
			   var iframes = window.top.frames;
			   var iframesLen = iframes.length;
			   var index = 0;
			   {
				  setTimeout('jQuery(".easyui-linkbutton-btn").linkbutton("enable");',iframesLen*250);
			   }
			   
		//短信
		//jQuery('#workflow_message').tabs();
	});
   </script>
</html>