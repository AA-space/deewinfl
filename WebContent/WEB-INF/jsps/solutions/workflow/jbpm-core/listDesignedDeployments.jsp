<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程部署</title>
<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
<style type="text/css">
   html,body{overflow:hidden;}
   td.td-label{
     font-weight:BOLD;
     width:200px;
     padding-left:20px;
   }
   td.td-input input{
      border:1px solid silver;
      width:200px;
   }
   td.td-input select{
      border:1px solid silver;
      width:124px;
   }
   input[name='isNeedAdvise']{
      position:relative;
      top:2px;
   }
   .td-content-readonly {
    background: #F6F6F6;
    border: 1px solid silver;
    height:16px;
   }
   #workflow_activity_setting_tabs .tabs li{
      padding-left:10px;
      padding-right:10px;
   }
   #workflow_activity_setting_tabs .tabs li a.tabs-inner{
      padding-left:10px;
      padding-right:10px;
   }
  
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyCommonUserSelection.js"></script>
<script type="text/javascript">
	var all_width  = document.documentElement.clientWidth;
	var all_height = document.documentElement.clientHeight-2;
	 (function($){$(function(){
		 //加载流程类别
		   new tracywindyComboBox({
               renderTo:'id_workflowTypeComboContainer',
               id:'id_workflowType_combo',
               width:191,
               isContainEmpty:false,
        	   xmlFileName:'\\combos\\comboDict.xml',
     	       loadMode:'ajax',
     	       readOnly:true,
     	       displayField:'name',
     	       valueField:'code',
     	       isForceModify:true,
     	       params:{
                 pid:'root.workflowType'
     	       },
     	       onSelect:function(combo,rowData){}
			  });  
			//加载排序
			var comboMenuPosition = new tracywindyComboBox({
			       dropListHeight:200,
			       isContainEmpty:false,
			       id:'id_comboMenuPosition',
			       width:190,
			       name:'currentPosition',
			       renderTo:'id_menuPositionContainer',
			       loadMode:'ajax',
			       readOnly:false,
			       xmlFileName:'\\combos\\comboWorkflowTypePosition.xml',
			       displayField:'name',
			       valueField:'name',
			       isCheck:false,
			       leftAdd:1,
			       params:{},
			       rawValue:'最后',
			       onSelect:function(combo){
			          var currentRawValue = combo.getRawValue();
			          if(("第一位" == currentRawValue)||("最后" == currentRawValue))
			          {
				          jQuery("#id_constantLabel").hide();
				      }
			          else
			          {
			        	  jQuery("#id_constantLabel").show();
				      }
			       }
			    });
     });})(jQuery);
</script>
</head>
<body>
    	<div id="id_createNewWorkflowWindow"  closed="true" modal="true" title="创建新流程" style="display:none;width:500px;padding-top:10px;text-align:center;">
	        <center>
		        <div style="width:95%;">
			        <table align="center" style="width:90%">
			            <tr style='height:10px;'></tr>
			            <tr><td class="input_label_desc">流程分类:</td><td class="input_value"><div  style="float:left;" id="id_workflowTypeComboContainer"></div><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">显示名称:</td><td class="input_value"><input type="text" id="id_displayName"/><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">流程编号:</td><td class="input_value"><input type="text" id="id_worflowCode"/><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">流程关键字:</td><td class="input_value"><input type="text" id="id_name"/><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">版本号:</td><td class="input_value"><input type="text" id="id_version"/><span class="content-required">*</span></td></tr>
			            <tr style="display:none;"><td class="input_label_desc">设计器版本:</td><td class="input_value">
				            <select id="id_jpdlVersion" style="width:194px;">
				               <option value="4.4" selected>jbpm4.4</option>
				               <option value="4.3">jbpm4.3</option>
				            </select>
			            <span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">流程描述:</td><td class="input_value"><input type="text" id="id_description"/><span class="content-required">&nbsp;&nbsp;</span></td></tr>
			            <tr><td colspan=3><div style="width:100%;height:5px;">&nbsp;</div></td></tr>
			            <tr><td colspan=3><div style="width:100%;border-top:1px solid #DDD;"></div></td></tr>
			            <tr><td colspan=3><div style="width:100%;height:5px;">&nbsp;</div></td></tr>
			            <tr><td  class="input_label_desc" colspan=3><span style="float:left;margin-left:100px;">排在&nbsp;&nbsp;</span><span style="float:left;" id="id_menuPositionContainer"></span><span style="float:left;" id="id_constantLabel">&nbsp;&nbsp;之后</span></td></tr>
			            <tr class='content-separator'>
			            <td colspan='2'>
					        <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick="toCreateNewWorkflowPage();"><span>确定</span></a>
					        <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_createNewWorkflowWindow").window("close");'><span>取消</span></a>
			            </td>
			            </tr>
			        </table>
		        </div>
	        </center>
	</div>
	<form action="" method="post" id="id_workflow_form">
	    <input type="hidden" id='id_form_workflow_id'          name="id"/>
	    <input type="hidden" id='id_form_workflow_code'        name="code"/>
	    <input type="hidden" id='id_form_workflow_type'        name="type"/>
	    <input type="hidden" id='id_form_workflow_position'    name="position"/>
	    <input type="hidden" id='id_form_queryText_id'         name="queryText"/>
	    <input type="hidden" id='id_form_display_name'         name="display_name"/>
	    <input type="hidden" id='id_form_workflow_name'        name="workflow_name"/>
	    <input type="hidden" id='id_form_workflow_version'     name="workflow_version"/>
	    <input type="hidden" id='id_form_workflow_jpdlVersion' name="workflow_jpdlVersion"/>
	    <input type="hidden" id='id_form_workflow_description' name="workflow_description"/>
	    <input type="hidden" id='id_form_workflow_isDeployed'  name="workflow_isDeployed"/>
	    <input type="hidden" id='id_form_workflow_designerWorkflowJsonString'        name="workflow_designerWorkflowJsonString"/>
	</form>
    <div id="id_processDefinitionsContainer"></div>
	<div id="id_ajax_debug" style="display: none;"></div>
    <script type="text/javascript" language="javascript">
         var globalRowIndex = -1;
         var loadMask = null;//new tracywindyLoadMask(document.body,"操作进行中，请稍等...");
         function createNewWorkflow()
         {
        	resetCreateNewWorkflowPage(); 
     		jQuery("#id_createNewWorkflowWindow").show();
    		jQuery("#id_createNewWorkflowWindow").window({top:20,draggable:false});
        	jQuery("#id_createNewWorkflowWindow").window("open");
         }
         function resetCreateNewWorkflowPage()
         {
     	     $("#id_form_workflow_id").val("");
     	     $("#id_form_display_name").val("");
     	     $("#id_form_workflow_name").val("");
     	     $("#id_form_workflow_type").val("");
     	     $("#id_form_workflow_code").val("");
     	     $("#id_form_workflow_position").val("");
    	     $("#id_form_workflow_version").val("");
    	     $("#id_form_workflow_jpdlVersion").val("");
    	     $("#id_form_workflow_description").val("");
    	     $("#id_form_workflow_designerWorkflowJsonString").val("{}");
    	     $("#id_form_workflow_isDeployed").val("");
    	    
        	 $("#id_displayName").val("");
        	 $("#id_worflowCode").val("");
        	 $("#id_name").val("");
        	 $("#id_version").val("");
        	 $("#id_jpdlVersion").val("4.4");
        	 $("#id_description").val("");

        	 getTracywindyObject('id_workflowType_combo').setValue("");
        	 getTracywindyObject('id_comboMenuPosition').setRawValue("最后");
         }
         function toCreateNewWorkflowPage()
         {
        	 var displayName = $("#id_displayName").val();
             var name = $("#id_name").val();
             var version = $("#id_version").val();
             var type = getTracywindyObject('id_workflowType_combo').getValue();
             var code = $("#id_worflowCode").val();
             var jpdlVersion = $("#id_jpdlVersion").val();
             var description = $("#id_description").val();
             if(!type){alert("流程分类不能为空");return;}
             if(!displayName){alert("流程显示名称不能为空");return;}
             if(!code){alert("流程编号不能为空");return;}
             if(!name){alert("流程关键字不能为空");return;}
             if(!version){alert("流程版本号不能为空");return;}
             if(!jpdlVersion){alert("设计器版本不能为空");return;}
             if(!/^\d+$/.test(version))
             {
            	 alert("流程版本号必须为数字");return;
             }
             loadMask.show();
            $("#id_form_queryText_id").val($("#id_queryWorkflowsTableInput").val());
    	    $("#id_form_display_name").val(displayName);
    	    $("#id_form_workflow_name").val(name);
    	    $("#id_form_workflow_type").val(type);
    	    $("#id_form_workflow_code").val(code);
    	    $("#id_form_workflow_position").val(getTracywindyObject('id_comboMenuPosition').getValue());
    	    $("#id_form_workflow_version").val(parseInt(version)+"");
    	    $("#id_form_workflow_jpdlVersion").val(jpdlVersion);
    	    $("#id_form_workflow_description").val(description);
    	    submitForm(jpdlVersion);
         }
         function submitForm(jpdlVersion)
         {
             /*var formAction = "";
             if("4.4" == jpdlVersion)
             {
            	 formAction = "${pageContext.request.contextPath}/workflow/jbpm-designer/jbpm4-4-designer.bi";
             }
             else if("4.3" == jpdlVersion)
             {
            	 formAction = "${pageContext.request.contextPath}/workflow/jbpm-designer/jbpm4-3-designer.bi";
             }
            formAction = "${pageContext.request.contextPath}/jbpm/getDesignerSavedDiagramInfo.action";
            formAction+="?pageStart="+getTracywindyObject("id_workflows_table").start;
            var form =$("#id_workflow_form")[0];
            with(form)
            {
                target="_self";
            	action = formAction;
            } 
            form.submit();
            return false;*/
            var formAction = "${pageContext.request.contextPath}/jbpm/getDesignerSavedDiagramInfo.action";
            formAction+="?pageStart="+getTracywindyObject("id_workflows_table").start;
            //打开窗体，并post提交页面   
            var toDay =  new Date();     
            windowname="win"+toDay.getTime(); 
            var sheight = window.screen.availHeight-30;
            var swidth = window.screen.availWidth-10;
            window.open(formAction,windowname,"left=0px,top=0px,height="+sheight+"px,width="+swidth+"px,scrollbars=yes,fullscreen=yes,status=yes,toolbar=no,menubar=no,location=no");   
            var form =$("#id_workflow_form")[0];
            with(form)
            {
               target=windowname;
           	   action = formAction;
            } 
            form.submit();
            loadMask.hide();
            try{
            	jQuery("#id_createNewWorkflowWindow").window("close");
            }catch(e){}
           return false;
         }
         function modifyWorkflow(rowIndex,isDeployed)
         {
        	 loadMask.show();
        	 resetCreateNewWorkflowPage();
        	 var rowData = getTracywindyObject('id_workflows_table').getRowDataAt(rowIndex);
        	 setFormFieldValue(rowData);
    	    var jpdlVersion = rowData['processdefinitionjpdlversion'];
            if('true'==isDeployed)
            {
           	   $("#id_form_workflow_isDeployed").val("true");
            }
            submitForm(jpdlVersion);
         } 
         function setFormFieldValue(rowData)
         {
        	 var id = rowData['id'];
        	 var designerWorkflowJsonString = rowData['designerworkflowjsonstring'];
        	 $("#id_form_workflow_id").val(id);
        	 $("#id_form_queryText_id").val($("#id_queryWorkflowsTableInput").val());
        	 //$("#id_form_workflow_designerWorkflowJsonString").val(designerWorkflowJsonString);
        	 var jpdlVersion = rowData['processdefinitionjpdlversion'];
     	     $("#id_form_display_name").val(rowData['processdefinitiondisplayname']);
     	     $("#id_form_workflow_name").val(rowData['processdefinitionkey']);
     	     $("#id_form_workflow_type").val(rowData['type']);
     	     $("#id_form_workflow_code").val(rowData['code']);
     	     //$("#id_form_workflow_position").val(rowData['position']);
     	     $("#id_form_workflow_position").val(rowData['processdefinitionkey']+"-"+rowData['processdefinitionversion']);
    	     $("#id_form_workflow_version").val(rowData['processdefinitionversion']);
    	     $("#id_form_workflow_jpdlVersion").val(jpdlVersion);
    	     $("#id_form_workflow_description").val(rowData['processdefinitiondescription']);
         }
         function viewDiagram(rowIndex)
         {
        	 var currentRowIndex = globalRowIndex;
             if(rowIndex ||( 0 == rowIndex))
             {
            	 currentRowIndex = rowIndex;
             }
        	 var rowData = getTracywindyObject('id_workflows_table').getRowDataAt(currentRowIndex);
        	 setFormFieldValue(rowData);
        	 var jpdlVersion = rowData['processdefinitionjpdlversion'];
             var formAction = "";
             if("4.4" == jpdlVersion)
             {
            	 formAction = "${pageContext.request.contextPath}/workflow/jbpm-designer/jbpm4-4-diagram.bi";
             }
             else if("4.3" == jpdlVersion)
             {
            	 formAction = "${pageContext.request.contextPath}/workflow/jbpm-designer/jbpm4-3-diagram.bi";
             }
            var form =$("#id_workflow_form")[0];
            with(form)
            {
            	target = "";
            	action = formAction;
            } 
            form.submit();
            return false;
         }
     	//显示流程图
     	function toProcessActivePicture(deployId,processInstanceId,maxDotX,maxDotY)
     	{
     		maxDotX = (maxDotX+"")||"0";
     		maxDotY = (maxDotY+"")||"0";
     	   //var sheight = 600;
     	   //var swidth = 850;
     	   var winoption =null;//"height="+sheight+"px;width="+swidth+"px;status=no;scroll=yes;resizable=yes";
     	   window.open("${pageContext.request.contextPath}/workflow/jbpm/getActivedRects.action?deployId="+deployId+"&maxDotX="+maxDotX+"&maxDotY="+maxDotY+"&processInstanceId="+processInstanceId+"&randomNumber="+Math.random(),"_blank");
     	}
         function publishDeploy(rowIndex)
         {
        	 loadMask.show();
        	 var rowData = getTracywindyObject('id_workflows_table').getRowDataAt(rowIndex);
        	 var designedId = rowData['id'];
             ajaxRequest({
                method:'post',
                url:'${pageContext.request.contextPath}/jbpm/deployWorkflow.action',
                success:function(res){alert("发布成功");loadMask.hide();getTracywindyTable("id_workflows_table").reload();},
                failure:function(res){alert("发布失败");loadMask.hide();getTracywindyTable("id_workflows_table").reload();},
                params:{
                	designedId:designedId
                }
             });
         }
         function removeDeploy(rowIndex)
         {
           if(window.confirm("确定删除该流程相关的所有信息么？"))
           {
          	 var rowData = getTracywindyObject('id_workflows_table').getRowDataAt(rowIndex);
        	 var designedId = rowData['id'];
        	 var deployId  = rowData['deployid'];
        	 loadMask.show();
        	 ajaxRequest({
                 method:'post',
                 url:'${pageContext.request.contextPath}/jbpm/removeDeployedWorkflow.action',
                 success:function(res){
                     alert("删除成功");
                     loadMask.hide();
                     var workflowsTable = getTracywindyTable("id_workflows_table");
	                 workflowsTable.setParams({
	                        queryText:'${param.queryText}'
	                 });
	                 doLocalTablePageReload( workflowsTable.params, workflowsTable.start, workflowsTable.pageSize);
                 },
                 failure:function(res){
                     alert("删除失败");
                     loadMask.hide();
	                 var workflowsTable = getTracywindyTable("id_workflows_table");
	                 workflowsTable.setParams({
	                        queryText:'${param.queryText}'
	                 });
	                 doLocalTablePageReload( workflowsTable.params, workflowsTable.start, workflowsTable.pageSize);
                 },
                 params:{
                	 designedId:designedId,
                	 deployId:deployId
                 }
              });
           }
         }
         function removeDesignedWorkflow(rowIndex)
         {
           if(window.confirm("确定删除该流程设计么？"))
           {
          	 var rowData = getTracywindyObject('id_workflows_table').getRowDataAt(rowIndex);
        	 var designedId = rowData['id'];
        	 loadMask.show();
        	 ajaxRequest({
                 method:'post',
                 url:'${pageContext.request.contextPath}/jbpm/removeDesignedWorkflow.action',
                 success:function(res){
                	 var workflowsTable = getTracywindyTable("id_workflows_table");
	                 workflowsTable.setParams({
	                        queryText:'${param.queryText}'
	                 });
	                 doLocalTablePageReload( workflowsTable.params, workflowsTable.start, workflowsTable.pageSize);
                 },
                 failure:function(res){
                	 var workflowsTable = getTracywindyTable("id_workflows_table");
	                 workflowsTable.setParams({
	                        queryText:'${param.queryText}'
	                 });
	                 doLocalTablePageReload( workflowsTable.params, workflowsTable.start, workflowsTable.pageSize);
                 },
                 params:{
                	 designedId:designedId
                 }
              });
           }
         }
       </script>
       <!-- 流程设置 -->
       <div id="id_processDefinitionsContainer"></div>
       <div id="id_workflow_setting"  closed="true" modal="true" title="流程节点设置" style="display:none;padding:2px;text-align:center;overflow:hidden;">
		   <div id="id_workflow_activity_detail">
		   </div>
	   </div>
       <div id="id_workflow_key_setting"  closed="true" modal="true" title="流程关键字设置" style="display:none;width:450px;padding:2px;padding-top:10px;text-align:center;overflow:auto;">
	       	       <table width="100%;" style="table-layout:fixed;">
	                  <tr>
		                  <td class="td-label">关键字一：</td>
		                  <td class="td-input" ><input  id="id_keyOne"/></td>
		             </tr>
		              <tr>
		                  <td class="td-label">关键字二：</td>
		                  <td class="td-input" ><input  id="id_keyTwo"/></td>
		              </tr>
		              <tr>
		                  <td class="td-label">关键字三：</td>
		                  <td class="td-input" ><input  id="id_keyThree"/></td>
		              </tr>
		              <tr>
		                  <td class="td-label">关键字四：</td>
		                  <td class="td-input" ><input  id="id_keyFour"/></td>
	                  </tr>
		              <tr>
		                  <td class="td-label">关键字五：</td>
		                  <td class="td-input" ><input  id="id_keyFive"/></td>
	                  </tr>
		              <tr>
		                  <td class="td-label">关键字六：</td>
		                  <td class="td-input" ><input  id="id_keySix"/></td>
	                  </tr>
		              <tr>
		                  <td class="td-label">关键字七<font color="red">(付款单号)</font>：</td>
		                  <td class="td-input" ><input  id="id_keySeven"/></td>
	                  </tr>
		              <tr>
		                  <td class="td-label">关键字八<font color="red">(合同流水号)</font>：</td>
		                  <td class="td-input" ><input  id="id_keyEight"/></td>
	                  </tr>
		              <tr>
		                  <td class="td-label">关键字九<font color="red">(项目立项流水号)</font>：</td>
		                  <td class="td-input" ><input  id="id_keyNine"/></td>
	                  </tr>
		              <tr>
		                  <td class="td-label">关键字十<font color="red">(互斥标识)</font>：</td>
		                  <td class="td-input" ><input  id="id_keyTen"/></td>
	                  </tr>
	                 <tr style="text-align:center;">
		                  <td  colspan=2 style="padding-top:10px;border-top:1px solid silver;">&nbsp;&nbsp;<input class="btn btn-primary" type="button" value="保存" style="width:60px;cursor:pointer;" onclick="javascript:saveKeyToWorkflow();"/>
		                  &nbsp;&nbsp;<input class="btn btn-primary" type="button" value="取消" style="width:60px;cursor:pointer;" onclick="jQuery('#id_workflow_key_setting').window('close');">
		                  </td>
	                  </tr>
	             </table>
	   </div>
	   <div id="id_workflow_activity_setting" buttons='#id-activity-diag-buttons' closed="true" modal="true" title="流程节点明细设置" style="display:none;padding:2px;width:700px;height:430px;text-align:center;overflow:auto;">
	      <form id="id_workflow_activity_setting_form">
	        <table width="100%;" style="table-layout:fixed;">
		        <tr>
			        <td style="text-align:left;padding-left:20px;height:30px;line-height:30px;border-bottom:1px solid silver;"  colspan=4>
			                                   节点类型：&nbsp;&lt;&nbsp;<label  style="color:red;font-weight:BOLD;" id="id_activityType"></label>&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                                   节点名称：&nbsp;&lt;&nbsp;<label  style="color:red;font-weight:BOLD;" id="id_activityName"></label>&nbsp;&gt;&nbsp;
			        </td>
			    </tr>
		   </table>
	        <!-- 标签栏 -->
			<div id="workflow_activity_setting_tabs" style="height:300px;" >
				<div title="基本信息" style="overflow:hidden;">
					   <table width="100%;" style="table-layout:fixed;padding-top:2px;line-height:20px;">
		                  <tr style="display:none;"><td style="width:100px;">记录编号：</td><td><input type="hidden" id="id_recordId" value=""/></td></tr>
		                  <tr style="display:none;"><td style="width:100px;">部署编号：</td><td><input type="hidden" id="id_deployId" value=""/></td></tr>
		                  <tr>
		                  	  <td class="td-label">表单标题：</td>
			                  <td class="td-input" colspan=3><input style="width:400px;border:1px solid silver;" id="id_formTitle"/></td>
			              </tr>
		                  <tr>
			                  <td class="td-label">表单路径：</td>
			                  <td colspan=3><input style="width:400px;border:1px solid silver;"  type="text" value=""  id="id_formPath"/></td>
		                  </tr>
		                  <tr><td class="td-label">触发动作：</td>
		                  <td colspan=3  id="id_activityActionContainer">
		                  </td>
		                  </tr>
		                  <tr><td class="td-label">附件分类：</td>
		                  	<td colspan=3 id="id_attachmentTypeContainer">
		                  	</td>
		                  </tr>
		                  
		                  <tr><td class="td-label">提交按钮：</td>
		                  <td colspan=3>
			                  <input  style="position:relative;top:3px;" value="save" type="checkbox" name="submitButtons" />&nbsp;保存
			                  <input  style="position:relative;top:3px;" value="read" type="checkbox" name="submitButtons" />&nbsp;传阅
			                  <input  style="position:relative;top:3px;" value="assignment" type="checkbox" name="submitButtons" />&nbsp;工作指派
			                  <input  style="position:relative;top:3px;" value="signature" type="checkbox" name="submitButtons" />&nbsp;会签
			                  <input  style="position:relative;top:3px;" value="back" type="checkbox" name="submitButtons" />&nbsp;退回
		                  </td></tr>
		                  <tr><td class="td-label">退回路由：</td><td colspan=3 id="id_backRoutesContainer"></td></tr>
		                  <tr><td class="td-label">填写意见：</td><td colspan=3 style="text-align:left;padding-left:10px;">是<input type="radio" name="isNeedAdvise" value="1"/>&nbsp;&nbsp;&nbsp;&nbsp;否<input type="radio" name="isNeedAdvise" value="0"/></td></tr>
		                  <tr><td class="td-label">检查附件：</td><td colspan=3 style="text-align:left;padding-left:10px;">是<input type="radio" name="isAttachmentChecked" value="true"/>&nbsp;&nbsp;&nbsp;&nbsp;否<input type="radio" name="isAttachmentChecked" value="false"/></td></tr>
		                  <tr style="display:none"><td class="td-label">自动处理：</td><td colspan=3 style="text-align:left;padding-left:10px;">是<input type="radio" name="isAutoActivity" value="1"/>&nbsp;&nbsp;&nbsp;&nbsp;否<input type="radio" name="isAutoActivity" value="0"/></td></tr>
		           </table>
				</div>
				<div title="待办" style="overflow:hidden;">
				    <table width="100%;" style="table-layout:fixed;padding-top:20px;line-height:30px;">
		                  <!-- 节点执行人 -->
		                  <tr>
			                  <td class="td-label">参与人类型：</td>
			                  <td class="td-input" id="id_initiatorTypeContainer">
			                  </td>
							  <td class="td-input">&nbsp;&nbsp;</td>
		                  </tr>
		                  <tr class="need-set-value-cls-">
		                      <td class="td-label">参与人：</td>
			                  <td class="td-input" colspan=3>
				                  <textarea  id="id_initiator_display" style="width:300px;margin-left:0px;height:50px;overflow:auto;border:1px solid silver;">
				                  </textarea>
				                  <textarea  id="id_initiator" style="display:none;width:300px;margin-left:0px;height:50px;overflow:auto;border:1px solid silver;">
				                  </textarea>
			                  </td>
			                  <td class="td-input"><a style="display:none;width:80px;margin-left:-35px;" class="btn btn-primary" href="javascript:void(0);" id="id_initiator_button">选择{0}</a></td>
		                  </tr>
		                  <tr  >
			                  <td class="td-label">处理方式：</td>
			                  <td class="td-input" id="id_dealMethodContainer" >
			                  </td>
			                  <td class="td-label n-passed-cls" style="display:none" >处理人数：</td><td style="display:none" class="td-input n-passed-cls" ><input  type="text" value=""  id="id_passedCount"/>
			                  </td>
		                  </tr>
		                  <!-- 待办提醒-->
		                  <tr>
			                   <td class="td-label">提醒方式：</td>
			                   <td colspan=3>
			                       <!-- -->  
				                  <input  style="position:relative;top:3px;" value="waitToDo" type="checkbox" disabled="disabled" checked/>&nbsp;待办
				                  <input  style="position:relative;top:3px;" value="sms" type="checkbox" name="messageTypes" />&nbsp;短信
				                  <input  style="position:relative;top:3px;" value="mail" type="checkbox" name="messageTypes" />&nbsp;邮件
				                  <!--  
				                  <input  style="position:relative;top:3px;" value="stationMessage" type="checkbox" name="messageTypes" />&nbsp;站内信
		                 		  -->
		                 		</td>
		                  </tr>
		                  <tr>
		                      <td class="td-label">提醒内容：</td>
			                  <td class="td-input" colspan=3>
				                  <textarea  id="id_messageContent" name="messageContent" style="width:300px;margin-left:0px;height:50px;overflow:auto;border:1px solid silver;">
				                  </textarea>
			                  </td>
		                  </tr>
		            </table>
		        </div>
		        <div title="条件路由">
		           <table width="100%;" style="table-layout:fixed;padding-top:20px;line-height:30px;">
		            <!-- 条件路由"配置 -->
		                  <tr>
			                  <td class="td-label">条件路由类型：</td>
			                  <td  class="td-input" id="id_conditionRouteTypeContainer"></td>
		                  	  <td class="td-input">&nbsp;&nbsp;</td>
		                  </tr>
		                  <tr class="need-set-value-cls-conditionRoute">
		                      <td class="td-label" >条件路由数值：</td>
			                  <td class="td-input" colspan=2>
				                  <textarea  value="workflowNextRouteCallBack" id="id_conditionRouteValue" style="width:300px;margin-left:0px;height:50px;overflow:auto;border:1px solid silver;">
				                  </textarea>
			                  </td>
		                  </tr>
		                  <tr class="need-set-value-cls-conditionRoute-label" style="display:none;">
		                      <td colspan=3 >
				                  <div style="text-indent:20px;font-size:12px;"> 
				                                      条件路由数值将被忽略,将会调用页面中的回调函数&nbsp;<font style="color:red">workflowNextRouteCallBack(buttonText,requestNextRoute)</font>&nbsp;<br/>
				                                      通过&nbsp;<font style="color:red">requestNextRoute.value="指定的路由路径"</font>&nbsp;来指定路由路径
				                  </div>
			                  </td>
		                  </tr>
		            </table>
		        </div>
		        <div title="传阅 " style="overflow:hidden;">
		            <table width="100%;" style="table-layout:fixed;padding-top:20px;line-height:30px;">
		                  <tr>
			                  <td class="td-label">传阅参与人类型：</td>
			                  <td  class="td-input" id="id_autoReadInitiatorTypeContainer"></td>
		                  	  <td class="td-input">&nbsp;&nbsp;</td>
		                  </tr>
		                  <tr class="need-set-value-cls-read">
		                      <td class="td-label" >传阅参与人：</td>
			                  <td class="td-input" colspan=3>
				                  <textarea  id="id_autoReadInitiator_display" style="width:300px;margin-left:0px;height:50px;overflow:auto;border:1px solid silver;">
				                  </textarea>
				                  <textarea  id="id_autoReadInitiator" style="display:none;width:300px;margin-left:0px;height:50px;overflow:auto;border:1px solid silver;">
				                  </textarea>
			                  </td>
			                  <td class="td-input"><a style="display:none;width:80px;margin-left:-35px;" class="btn btn-primary" href="javascript:void(0);" id="id_autoReadInitiator_button">选择{0}</a></td>
		                  </tr>
		                 <!-- 传阅提醒 -->
		                  <tr>
			                   <td class="td-label">提醒方式：</td>
			                   <td colspan=3>
				                  <input  style="position:relative;top:3px;" value="waitToDo" type="checkbox" disabled="disabled" checked/>&nbsp;待办
				                  <input  style="position:relative;top:3px;" value="sms" type="checkbox" name="readMessageTypes" />&nbsp;短信
				                  <input  style="position:relative;top:3px;" value="mail" type="checkbox" name="readMessageTypes" />&nbsp;邮件
				                  <!-- 
				                  <input  style="position:relative;top:3px;" value="stationMessage" type="checkbox" name="readMessageTypes" />&nbsp;站内信
		                 		  -->
		                 		</td>
		                  </tr>
		                  <tr>
		                      <td class="td-label">提醒内容：</td>
			                  <td class="td-input" colspan=3>
				                  <textarea  id="id_readMessageContent" name="readMessageContent" style="width:300px;margin-left:0px;height:50px;overflow:auto;border:1px solid silver;">
				                  </textarea>
			                  </td>
		                  </tr> 
		                 
		            </table>
		        </div>
		        <!---->  
		        <div title="会签" style="overflow:hidden;">
		        	<table width="100%;" style="table-layout:fixed;padding-top:20px;line-height:30px;">
		                  <tr>
			                    <td class="td-label">会签参与人类型：</td>
			                    <td  class="td-input" id="id_autoSignatureInitiatorTypeContainer" >
			                    </td>
			                    <td class="td-input">&nbsp;&nbsp;</td>
		                  </tr>
		                  <tr class="need-set-value-cls-signature">
		                      <td class="td-label">会签参与人：</td>
			                  <td class="td-input" colspan=3>
				                  <textarea  id="id_autoSignatureInitiator_display" style="width:300px;margin-left:0px;height:50px;overflow:auto;border:1px solid silver;">
				                  </textarea>
				                  <textarea  id="id_autoSignatureInitiator" style="display:none;width:300px;margin-left:0px;height:50px;overflow:auto;border:1px solid silver;">
				                  </textarea>
			                  </td>
			                  <td class="td-input"><a style="display:none;width:80px;margin-left:-35px;" class="btn btn-primary" href="javascript:void(0);" id="id_autoSignatureInitiator_button">选择{0}</a></td>
		                  </tr>
		                  <!-- 会签提醒-->
		                  <tr>
			                   <td class="td-label">提醒方式：</td>
			                   <td colspan=3>
				                  <input  style="position:relative;top:3px;" value="waitToDo" type="checkbox" disabled="disabled" checked/>&nbsp;待办
				                  <input  style="position:relative;top:3px;" value="sms" type="checkbox" name="signatureMessageTypes" />&nbsp;短信
				                  <input  style="position:relative;top:3px;" value="mail" type="checkbox" name="signatureMessageTypes" />&nbsp;邮件
				                  <!--  
				                  <input  style="position:relative;top:3px;" value="stationMessage" type="checkbox" name="signatureMessageTypes" />&nbsp;站内信
		                 		  -->
		                 		</td>
		                  </tr>
		                  <tr>
		                      <td class="td-label">提醒内容：</td>
			                  <td class="td-input" colspan=3>
				                  <textarea  id="id_signatureMessageContent" name="signatureMessageContent" style="width:300px;margin-left:0px;height:50px;overflow:auto;border:1px solid silver;">
				                  </textarea>
			                  </td>
		                  </tr> 
		                  
		            </table>
		        </div>
		        
		        <!--
		        <div title="待办提醒" style="overflow:hidden;">
		        	<table width="100%;" style="table-layout:fixed;padding-top:20px;line-height:30px;">
		                  <tr>
			                    <td class="td-label">信息类型：</td>
			                   <td colspan=3>
				                  <input  style="position:relative;top:3px;" value="waitToDo" type="checkbox" disabled="disabled" checked/>&nbsp;待办
				                  <input  style="position:relative;top:3px;" value="sms" type="checkbox" name="messageTypes" />&nbsp;短信
				                  <input  style="position:relative;top:3px;" value="mail" type="checkbox" name="messageTypes" />&nbsp;邮件
				                  <input  style="position:relative;top:3px;" value="stationMessage" type="checkbox" name="messageTypes" />&nbsp;站内信
		                 		</td>
		                  </tr>
		                  <tr>
		                      <td class="td-label">信息内容：</td>
			                  <td class="td-input" colspan=3>
				                  <textarea  id="id_messageContent" name="messageContent" style="width:300px;margin-left:0px;height:50px;overflow:auto;border:1px solid silver;">
				                  </textarea>
			                  </td>
		                  </tr>
		            </table>
		        </div>
		        -->
			</div>
			</form>
	   </div>
	   <div id="id-activity-diag-buttons" style="display:none;">
	      	<table width="100%;">
				<tr style="text-align:center;">
			      <td  colspan=4 style="padding-top:6px;">&nbsp;&nbsp;<input class="btn btn-primary" type="button" value="保存" style="width:60px;cursor:pointer;" onclick="javascript:saveChangeToActivity();"/>
			      &nbsp;&nbsp;<input class="btn btn-primary" type="button" value="取消" style="width:60px;cursor:pointer;" onclick="jQuery('#id_workflow_activity_setting').window('close');">
			      </td>
		        </tr>
		    </table>
	   </div>
       <script type="text/javascript">
          $(function(){
        	  $('#workflow_activity_setting_tabs').tabs();
          });
          
          function workflowActivitiesSetting(rowIndex,deployId,deployDesc,maxDotX,maxDotY)
          {
        	  globalRowIndex = rowIndex;
        	  jQuery("#id_workflow_setting").show();
          	  var cwin = jQuery("#id_workflow_setting").window({
              	left:50,
              	top:20,
              	zIndex:9000,
              	title:"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;&nbsp;<a href='javascript:void(0);' onclick=\"toProcessActivePicture('"+deployId+"','-1','"+maxDotX+"','"+maxDotY+"');\">"+deployDesc+"</a>&nbsp;&gt;&nbsp;流程节点设置",
              	draggable:false,
              	resizable:false,
              	shadow:true,
              	modal:true,
              	inline:false,
              	collapsible:false,
              	minimizable:false,
              	maximizable:false,
              	closable:true,
              	closed:false
              });
              var table_activities = getTracywindyObject('id_workflow_activity_detail_table');
              table_activities.setParams({deployId:deployId});
              table_activities.reload();
          	  cwin.window("open");
          }
          function workflowInfoSetting(rowIndex,deployId,deployDesc)
          {
        	  globalRowIndex = rowIndex;
        	  jQuery("#id_workflow_info_setting").show();
          	  var cwin = jQuery("#id_workflow_info_setting").window({
              	left:50,
              	top:20,
              	zIndex:9000,
              	title:"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（ "+deployDesc+" ）流程信息修改",
              	draggable:false,
              	resizable:false,
              	shadow:true,
              	modal:false,
              	inline:false,
              	collapsible:false,
              	minimizable:false,
              	maximizable:false,
              	closable:true,
              	closed:false
              });
          	  cwin.window("open");
          }
          function workflowKeySetting(rowIndex,deployId,deployDesc)
          {
         	  var rowData = getTracywindyObject('id_workflows_table').getRowDataAt(rowIndex);
         	  var keyOne  = rowData['keyone'];
         	  var keyTwo  = rowData['keytwo'];
         	  var keyThree = rowData['keythree'];
         	  var keyFour  = rowData['keyfour'];
         	  var keyFive  = rowData['keyfive'];
         	  var keySix  =  rowData['keysix'];
         	  var keySeven  = rowData['keyseven'];
         	  var keyEight  = rowData['keyeight'];
         	  var keyNine  = rowData['keynine'];
         	  var keyTen    = rowData['keyten'];
         	  $("#id_keyOne").val(keyOne);
         	  $("#id_keyTwo").val(keyTwo);
         	  $("#id_keyThree").val(keyThree);
         	  $("#id_keyFour").val(keyFour);
         	  $("#id_keyFive").val(keyFive);
         	  $("#id_keySix").val(keySix);
         	  $("#id_keySeven").val(keySeven);
         	  $("#id_keyEight").val(keyEight);
         	  $("#id_keyNine").val(keyNine);
         	  $("#id_keyTen").val(keyTen);
         	  
        	  globalRowIndex = rowIndex;
        	  jQuery("#id_workflow_key_setting").show();
          	  var cwin = jQuery("#id_workflow_key_setting").window({
              	top:50,
              	zIndex:9000,
              	title:"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（<a href='javascript:void(0);' onclick=\"viewDiagram();\">"+deployDesc+"</a>）流程关键字设置",
              	draggable:false,
              	resizable:false,
              	shadow:true,
              	modal:false,
              	inline:false,
              	collapsible:false,
              	minimizable:false,
              	maximizable:false,
              	closable:true,
              	closed:false
              });
          	  cwin.window("open");
          }
          function saveKeyToWorkflow()
          {
        	  var currentRowIndex = globalRowIndex;
         	  var rowData = getTracywindyObject('id_workflows_table').getRowDataAt(currentRowIndex);
         	  var designerId  = rowData['id'];
         	  var keyOne  = $("#id_keyOne").val();
         	  var keyTwo  = $("#id_keyTwo").val();
         	  var keyThree = $("#id_keyThree").val();
         	  var keyFour  = $("#id_keyFour").val();
        	  var keyFive  = $("#id_keyFive").val();
         	  var keySix   = $("#id_keySix").val();
         	  var keySeven = $("#id_keySeven").val();
         	  var keyEight = $("#id_keyEight").val();
         	  var keyNine = $("#id_keyNine").val();
         	  var keyTen   = $("#id_keyTen").val();
              loadMask.show();
        	  var url = "${pageContext.request.contextPath}/jbpm/saveKeyToWorkflow.action";
              $.ajax({
                 url:url,
                 type:'POST',
                 dataType:'text',
                 data:{
            	    designerId:designerId,
            	    keyOne:keyOne,
            	    keyTwo:keyTwo,
            	    keyThree:keyThree,
            	    keyFour:keyFour,
            	    keyFive:keyFive,
            	    keySix:keySix,
            	    keySeven:keySeven,
            	    keyEight:keyEight,
            	    keyNine:keyNine,
            	    keyTen:keyTen
                 },
                 success:function(data){
                	  alert("关键字设置成功");
                	  var workflowsTable = getTracywindyTable("id_workflows_table");
                      workflowsTable.setParams({
                             queryText:'${param.queryText}'
                      });
                      doLocalTablePageReload( workflowsTable.params, workflowsTable.start, workflowsTable.pageSize);
                 }
              });
         	  
          }
          function startProcess(processDefinitionId)
          {
              if(window.confirm("确认发起新流程?"))
              {
            	  window.open("${pageContext.request.contextPath}/jbpm/startDeployedProcess.action?processDefinitionId="+escape(encodeURIComponent(processDefinitionId)),"_blank");
              }
          }
          function workflowSynchronized(deployId)
          {
              loadMask.show();
        	  var url = "${pageContext.request.contextPath}/jbpm/workflowSynchronized.action";
              $.ajax({
                 url:url,
                 type:'POST',
                 dataType:'text',
                 data:{
                	 deployId:deployId
                 },
                 success:function(res){
                	  alert(res);
                	  getTracywindyTable("id_workflows_table").reload();
                	  loadMask.hide();
                 }
              });
          }
       </script>
	  <script type="text/javascript">
	     function getChineseActorType(actorType)
	     {
		    var chineseActorType = "";
		    switch(actorType){
		    	case  'requestInitiator': { chineseActorType = '流程发起人';break;}
		    	case  'user': { chineseActorType = '指定人员';break;}
		    	case  'requestInitiatorRelation': { chineseActorType = '发起人关系';break;}
		    	case  'submitRelation': { chineseActorType = '提交人关系';break;}
                case  'requestInitiatorDefinedRelation':{chineseActorType='预定义的发起人关系';break;}
                case  'submitDefinedRelation': { chineseActorType = '预定义的提交人关系';break;}
		    	case  'dept': { chineseActorType = '部门';break;}
		    	case  'deptRole': { chineseActorType = '角色';break;}
		    	case  'group': { chineseActorType = '群组';break;}
		    	case  'step': { chineseActorType = '历史步骤';break;}
		    	case  'formField': { chineseActorType = '表单域';break;}
		    	case  'sql': { chineseActorType = '自定义';break;}
		    	default:{chineseActorType = "";}
		    }
     		return chineseActorType;
		 }
	     function getChineseConditionRouteType(conditionRouteType){
				var value = "";
				switch(conditionRouteType){
			    	case  'pageCallBack' : { value = "页面回调函数";break;}
			    	case  'field': { value = "表单域";break;}
			    	case  'expression': { value = "表达式";break;}
			    	case  'sql': { value = "自定义";break;}
			    	default:{
				    	value = "";
				    }
			    }
			    return value;
	     }
		 function renderActorValue(actorType,displayValue,hiddenValue){
			var value = "";
			switch(actorType){
		    	case  'formField': 
		    	case  'sql': { value = hiddenValue;break;}
		    	default:{
			    	value = displayValue;
			    }
		    }
		    return value;
	     }
	     jQuery(function(){
	    	  loadMask = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');
		      jQuery("#id_workflow_setting").css("width",(all_width-100)+"px");
		      jQuery("#id_workflow_setting").css("height",(all_height-50)+"px");
	    	 var tableActivityDetail= new tracywindyTable({
		            renderTo:'id_workflow_activity_detail',
		            displayToggleContainer:'id_workflow_setting',
		            width:all_width-114,
		            height:all_height-112,
		            isCheck:false,
		            isRank:false,
		            rankSize:30,
		            toolsLeftMargin:50,
		            id:'id_workflow_activity_detail_table',
		            checkOnly:true,
		            checkType:'checkbox',
		            showHeader:true,
		            xmlFileName:'\\jbpm\\queryWorkflowActivities.xml',
		            loadMode:'ajax',
		            isPage:false,
		            params:{deployId:'-1'},
		            lockedNames:['oper'],
		            resizableAddSize:-50,
		            columns:[
		 		            {header:'操作',name:'oper',width:60},
		 		            //{header:'记录编号',name:'id',hidden:true},
		 		            //{header:'部署编号',name:'deploymentimpl',hidden:true},
		 		            {header:'流程名称',name:'displayworkflowname'},
		 		            {header:'流程关键字',name:'workflowname'},
		 		            {header:'节点类型',name:'activitytype'},
		 		            {header:'节点名称',name:'activityname'},
		 		            //{header:'是否检查附件',name:'isattachmentchecked',hidden:true},
		 		            {header:'是否检查附件',name:'isattachmentcheckeddesc'},
		 		            {header:'参与人类型',name:'actortype',width:160},
		 		            {header:'参与人',name:'actorvalue',hidden:true},
		 		            {header:'参与人',name:'displayactorvalue'},
		 		            {header:'条件路由类型',name:'conditionroutetype'},
		 		            {header:'条件路由数值',name:'conditionroutevalue'},
		 		            {header:'参与人信息类型',name:'messagetypes'},
		 		            {header:'参与人发送内容',name:'messagecontent'},
		 		            {header:'条件路由数值',name:'conditionroutevalue'},
		 		            {header:'传阅参与人类型',name:'autoreadactortype',width:160},
		 		            {header:'传阅参与人',name:'autoreadactorvalue',hidden:true},
		 		            {header:'传阅参与人',name:'autoreaddisplayactorvalue',width:160},
		 		            {header:'传阅人信息类型',name:'readmessagetypes'},
		 		            {header:'传阅人发送内容',name:'readmessagecontent'},
		 		            {header:'会签参与人类型',name:'autosignatureactortype',width:160},
		 		            {header:'会签参与人',name:'autosignatureactorvalue',hidden:true},
		 		            {header:'会签参与人',name:'autosignaturedisplayactorvalue',width:160},
		 		            {header:'会签人信息类型',name:'signaturemessagetypes'},
		 		            {header:'会签人发送内容',name:'signaturemessagecontent'},
		 		            {header:'处理方式',name:'dealmethod'},
		 		            {header:'通过人数',name:'passedcount'},
		 		            {header:'应用表单',name:'formpath'},
		 		            {header:'表单标题',name:'formtitle'},
		 		            {header:'是否填写意见',name:'isneedadvise'},
		 		            {header:'是否自动节点',name:'isautoactivity',hidden:true},
		 		            {header:'操作按钮',name:'operationbuttons'},
		 		            {header:'节点动作',name:'activityaction'},
		 		            {header:'附件类型',name:'attachmenttype'},
		 		            {header:'附件类型编号',name:'attachmenttypeids',hidden:true},
		 		            {header:'退回路由节点',name:'backactivities'}
			        ],
		            callBack:function(){
		            	this.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
			            	var actorType = rowData['actortype'];
			            	var chineseActorType = getChineseActorType(actorType);
		            		return chineseActorType;
			            },'actortype');
		            	//条件路由类型
		            	this.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
		            		if(("start" == rowData.activitytype) || ("end" == rowData.activitytype)){
		            			return "";
		            		}
			            	var conditionRouteType = rowData['conditionroutetype'];
			            	var chineseActorType = getChineseConditionRouteType(conditionRouteType);
		            		return chineseActorType;
			            },'conditionroutetype');
		            	//条件路由数值
		            	this.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
		            		if(("start" == rowData.activitytype) || ("end" == rowData.activitytype)){
		            			return "";
		            		}
			            	var conditionRouteValue = rowData['conditionroutevalue'];
			            	var conditionRouteType = rowData['conditionroutetype'];
			            	if("pageCallBack" == conditionRouteType){
			            		return "workflowNextRouteCallBack(buttonText,requestNextRoute)";
			            	}
		            		return conditionRouteValue;
			            },'conditionroutevalue');
		            	//信息
		            	this.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
		            		var chineseValues = [];
		            		if(value){
		            			var values = value.split(",");
		            		  for(var i= 0;i < values.length;i++){
		            			  var englishValue = values[i];
		            			  var chineseValue = "";
				            	  switch(englishValue){
				            		  case "sms":{
				            			  chineseValue = "短信";
				            			  break;
				            		  }
				            		  case "mail":{
				            			  chineseValue = "邮件";
				            			  break;
				            		  }
				            		  case "stationMessage":{
				            			  chineseValue = "站内信";
				            			  break;
				            		  }
				            	}
				            	chineseValues.push(chineseValue);
		            		  }
		            		}
		            		return chineseValues.join(",");
			            },'messagetypes');
		            	//信息
		            	this.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
		            		var chineseValues = [];
		            		if(value){
		            			var values = value.split(",");
		            		  for(var i= 0;i < values.length;i++){
		            			  var englishValue = values[i];
		            			  var chineseValue = "";
				            	  switch(englishValue){
				            		  case "sms":{
				            			  chineseValue = "短信";
				            			  break;
				            		  }
				            		  case "mail":{
				            			  chineseValue = "邮件";
				            			  break;
				            		  }
				            		  case "stationMessage":{
				            			  chineseValue = "站内信";
				            			  break;
				            		  }
				            	}
				            	chineseValues.push(chineseValue);
		            		  }
		            		}
		            		return chineseValues.join(",");
			            },'readmessagetypes');
		            	//信息
		            	this.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
		            		var chineseValues = [];
		            		if(value){
		            			var values = value.split(",");
		            		  for(var i= 0;i < values.length;i++){
		            			  var englishValue = values[i];
		            			  var chineseValue = "";
				            	  switch(englishValue){
				            		  case "sms":{
				            			  chineseValue = "短信";
				            			  break;
				            		  }
				            		  case "mail":{
				            			  chineseValue = "邮件";
				            			  break;
				            		  }
				            		  case "stationMessage":{
				            			  chineseValue = "站内信";
				            			  break;
				            		  }
				            	}
				            	chineseValues.push(chineseValue);
		            		  }
		            		}
		            		return chineseValues.join(",");
			            },'signaturemessagetypes');
		            	
		            	this.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
			            	var actorType = rowData['autoreadactortype'];
			            	var chineseActorType = getChineseActorType(actorType);
		            		return chineseActorType;
			            },'autoreadactortype');
		            	this.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
			            	var actorType = rowData['autosignatureactortype'];
			            	var chineseActorType = getChineseActorType(actorType);
		            		return chineseActorType;
			            },'autosignatureactortype');
		            	
		            	this.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
			            	var actorType = rowData['actortype'];
			            	var displayValue = rowData['displayactorvalue'];
			            	var hiddenValue = rowData['actorvalue'];
		            		return renderActorValue(actorType,displayValue,hiddenValue);
			            },'displayactorvalue');
		            	this.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
			            	var actorType = rowData['autoreadactortype'];
			            	var displayValue = rowData['autoreaddisplayactorvalue'];
			            	var hiddenValue = rowData['autoreadactorvalue'];
		            		return renderActorValue(actorType,displayValue,hiddenValue);
			            },'autoreaddisplayactorvalue');
		            	this.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
			            	var actorType = rowData['autosignatureactortype'];
			            	var displayValue = rowData['autosignaturedisplayactorvalue'];
			            	var hiddenValue = rowData['autosignatureactorvalue'];
		            		return renderActorValue(actorType,displayValue,hiddenValue);
			            },'autosignaturedisplayactorvalue');
		            	
		            	this.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
			            	var dealMethod = rowData["dealmethod"];
			            	var dealMethodChineseName = "";
		            		if("Single"==(dealMethod)){dealMethodChineseName="单人处理";};
		            		if("AllPassed"==(dealMethod)){dealMethodChineseName="多人全部";};
		            		if("OnePassed"==(dealMethod)){dealMethodChineseName="多人任一";};
		            		if("NPassed"==(dealMethod)){dealMethodChineseName="N人处理";};
			            	return dealMethodChineseName;
			            },'dealmethod');
		            	this.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
                            var realValue = "";
                            if("1" == value){realValue="是";}
                            else if("0" == value){realValue="否";}
			            	return realValue;
			            },'isneedadvise');
		            	this.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
                            var realValue = "";
                            if("1" == value){realValue="是";}
                            else if("0" == value){realValue="否";}
			            	return realValue;
			            },'isautoactivity');
		            	this.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
			            	var blank = "&nbsp;";
			            	var modifyActivities = "<a href='javascript:void(0);' onclick='javacript:modifyActivity("+rowData.rowIndex+");'>修改</a>";
			            	return blank+modifyActivities;
			            },'oper');
			       }
		         });
	           //选择action
			   var combo_activityAction = new tracywindyComboBox({
			       dropListHeight:200,
			       id:'combo_activityAction',
			       width:352,
			       renderTo:'id_activityActionContainer',
			       url:'${pageContext.request.contextPath}/jbpm/getWorkflowActions.action',
			       loadMode:'ajax',
			       readOnly:true,
			       value:'',
			       displayField:'name',
			       valueField:'value',
			       params:{
			    	   paramWorkflowName:'-1'
			       }
			    }); 
	           //选择附件分类
			   var combo_attachmentType = new tracywindyComboBox({
			       dropListHeight:200,
			       id:'combo_attachmentType',
			       width:352,
			       renderTo:'id_attachmentTypeContainer',
			       xmlFileName:'\\jbpm\\queryAttachmentTypes.xml',
			       loadMode:'ajax',
			       readOnly:true,
			       isCheck:true,
			       value:'',
			       displayField:'name',
			       valueField:'value'
			    }); 
	          //选择退后路由 
			   var combo_backRoutes = new tracywindyComboBox({
			       dropListHeight:200,
			       id:'combo_backRoutes',
			       width:352,
			       renderTo:'id_backRoutesContainer',
			       xmlFileName:'\\jbpm\\queryWorkflowActivities.xml',
			       loadMode:'ajax',
			       readOnly:true,
			       isCheck:true,
			       value:'',
			       displayField:'activityname',
			       valueField:'activityname',
			       params:{
				    deployId:'-1'
			       }
			    }); 
			 //选择处理方式
			 var combo_dealMethod = new tracywindyComboBox({
			       dropListHeight:200,
			       id:'combo_dealMethod',
			       width:160,
			       renderTo:'id_dealMethodContainer',
			       loadMode:'local',
			       readOnly:true,
			       isContainEmpty:false,
			       datas:[
					        { name:'单人处理',value:'Single'},
					        { name:'多人全部',value:'AllPassed'},
					        { name:'多人任一',value:'OnePassed'},
					        { name:'N人处理',value:'NPassed'}
			             ],
			       value:'',
			       displayField:'name',
			       valueField:'value',
			       onSelect:function(combo,rowData){
			           var value = combo.getValue();
			           if("NPassed" == value){
				            $("td.n-passed-cls").show();
				       }else{
				    	    $("#id_passedCount").val("");
				    	    $("td.n-passed-cls").hide();
					   }
			       }
			    }); 
			 //条件路由
			var combo_conditionRouteType = new tracywindyComboBox({
			       dropListHeight:200,
			       id:'combo_conditionRouteType',
			       width:160,
			       renderTo:'id_conditionRouteTypeContainer',
			       loadMode:'local',
			       readOnly:true,
			       //isContainEmpty:false,
			       datas:[
					        { name:'页面回调函数',value:'pageCallBack'},
					        { name:'表单域',value:'field'},
					        { name:'表达式',value:'expression'},
					        { name:'自定义',value:'sql'}
			             ],
			       value:'pageCallBack',
			       displayField:'name',
			       valueField:'value',
			       onSelect:function(combo,rowData){
			    	   var conditionRouteType = combo.getValue();
				         if("pageCallBack" == conditionRouteType){
				        	 jQuery(".need-set-value-cls-conditionRoute").hide();
				        	 jQuery(".need-set-value-cls-conditionRoute-label").show();
				         }else{
				        	 jQuery(".need-set-value-cls-conditionRoute").show();
				        	 jQuery(".need-set-value-cls-conditionRoute-label").hide();
				         }
			       }
			    }); 
			 //选择参与人
			 initNodeContainer("id_initiatorTypeContainer","id_initiator_display","id_initiator","id_initiator_button","");
		     //选择结束时传阅参与人类型
		     initNodeContainer("id_autoReadInitiatorTypeContainer","id_autoReadInitiator_display","id_autoReadInitiator","id_autoReadInitiator_button","read");
		     //选择结束时会签参与人类型  
		     initNodeContainer("id_autoSignatureInitiatorTypeContainer","id_autoSignatureInitiator_display","id_autoSignatureInitiator","id_autoSignatureInitiator_button","signature");
		 });
		 function initNodeContainer(initiatorTypeContainer,initiatorDisplayId,initiatorHiddenId,choseButtonId,attachmentId)
		 {
			  new tracywindyCommonUserSelection({
				    hiddenInput:initiatorHiddenId||'id_initiator_display',
				    displayInput:initiatorDisplayId||'id_initiator',
				    isMultiSelect:true,
				    draggable:false,
				    windowTop:1,
				    id:'id_user'+attachmentId,
				    type:'user'
			   });
			  new tracywindyCommonUserSelection({
				    hiddenInput:initiatorHiddenId||'id_initiator_display',
				    displayInput:initiatorDisplayId||'id_initiator',
				    isMultiSelect:true,
				    draggable:false,
				    windowTop:1,
				    id:'id_requestInitiatorRelation'+attachmentId,
				    type:'relation'
			   });
			  new tracywindyCommonUserSelection({
				    hiddenInput:initiatorHiddenId||'id_initiator_display',
				    displayInput:initiatorDisplayId||'id_initiator',
				    isMultiSelect:true,
				    draggable:false,
				    windowTop:1,
				    id:'id_submitRelation'+attachmentId,
				    type:'relation'
			   });
              //关系2，从已定义的关系的中选择
               new tracywindyCommonUserSelection({
                    hiddenInput:initiatorHiddenId||'id_initiator_display',
                    displayInput:initiatorDisplayId||'id_initiator',
                    isMultiSelect:true,
                    draggable:false,
                    windowTop:1,
                    id:'id_requestInitiatorDefinedRelation'+attachmentId,
                    type:'definedRelation'
               });
              new tracywindyCommonUserSelection({
                    hiddenInput:initiatorHiddenId||'id_initiator_display',
                    displayInput:initiatorDisplayId||'id_initiator',
                    isMultiSelect:true,
                    draggable:false,
                    windowTop:1,
                    id:'id_submitDefinedRelation'+attachmentId,
                    type:'definedRelation'
              });
			  new tracywindyCommonUserSelection({
				    hiddenInput:initiatorHiddenId||'id_initiator_display',
				    displayInput:initiatorDisplayId||'id_initiator',
				    isMultiSelect:true,
				    draggable:false,
				    windowTop:1,
				    id:'id_dept'+attachmentId,
				    type:'dept'
			   });
			  new tracywindyCommonUserSelection({
				    hiddenInput:initiatorHiddenId||'id_initiator_display',
				    displayInput:initiatorDisplayId||'id_initiator',
				    isMultiSelect:true,
				    draggable:false,
				    windowTop:1,
				    id:'id_deptRole'+attachmentId,
				    type:'deptRole'
			   });
			  new tracywindyCommonUserSelection({
				    hiddenInput:initiatorHiddenId||'id_initiator_display',
				    displayInput:initiatorDisplayId||'id_initiator',
				    isMultiSelect:true,
				    draggable:false,
				    windowTop:1,
				    id:'id_group'+attachmentId,
				    type:'group'
			   });
			  new tracywindyCommonUserSelection({
				    hiddenInput:initiatorHiddenId||'id_initiator_display',
				    displayInput:initiatorDisplayId||'id_initiator',
				    isMultiSelect:true,
				    draggable:false,
				    windowTop:1,
				    id:'id_step'+attachmentId,
				    type:'step',
				    params:{
						deployId:'-1',
		   			    currentActivityDetailId:'-1'
				    }
			   });
			 //选择节点参与人类型
			 var combo_initiatorType = new tracywindyComboBox({
			       dropListHeight:280,
			       id:'combo_initiatorType'+attachmentId,
			       width:160,
			       renderTo:initiatorTypeContainer||'id_initiatorTypeContainer',
			       loadMode:'local',
			       readOnly:true,
			       isContainEmpty:!!attachmentId,
			       datas:[
					        { name:'流程发起人',value:'requestInitiator'},
					        { name:'指定人员',value:'user'},
					        { name:'发起人关系',value:'requestInitiatorRelation'},
					        { name:'提交人关系',value:'submitRelation'},
                            { name:'预定义的发起人关系', value:'requestInitiatorDefinedRelation'},
                            { name:'预定义的提交人关系', value:'submitDefinedRelation'},
					        { name:'部门',value:'dept'},
					        { name:'角色',value:'deptRole'},
					        { name:'群组',value:'group'},
					        { name:'历史步骤',value:'step'},
					        { name:'表单域',value:'formField'},
					        { name:'自定义',value:'sql'}
			             ],
			       value:'',
			       displayField:'name',
			       valueField:'value',
			       onSelect:function(combo,rowData){
			          var value = combo.getValue();
			          var rawValue = combo.getRawValue();
			          $("#"+initiatorHiddenId).val("");
			          $("#"+initiatorDisplayId).val("");
			          initNodeInitiator(value,rawValue,initiatorTypeContainer,initiatorDisplayId,initiatorHiddenId,choseButtonId,attachmentId);
			       }
			    }); 
	    }
		function initNodeInitiator(value,rawValue,initiatorTypeContainer,initiatorDisplayId,initiatorHiddenId,choseButtonId,attachmentId){
			   var $choseButton = $("#"+(choseButtonId||"id_initiator_button"));
			   switch(value){
		          case "requestInitiator":
		          case "user":
		          case "requestInitiatorRelation":
		          case "submitRelation":
                  case "requestInitiatorDefinedRelation":
                  case "submitDefinedRelation":
		          case "dept":
		          case "deptRole":
		          case "group":
		          case "step":{
			          $("#"+initiatorHiddenId).hide();
			          $("#"+initiatorDisplayId).attr("readOnly",true);
			          $("#"+initiatorDisplayId).show();
			          $("tr.need-set-value-cls-"+attachmentId).show();
			          if("requestInitiator"==value){
			        	  $("tr.need-set-value-cls-"+attachmentId).hide();
				      }
		        	  $choseButton.show();
			          $choseButton.html("选择 "+rawValue);
			          $choseButton[0].onclick=(function(value){
				          return function(e){
				        	 getTracywindyObject('id_'+value+attachmentId).show();
					      };
				      })(value);
			          break;
			      }
			      default:{
			    	  $("tr.need-set-value-cls-"+attachmentId).show();
			          $("#"+initiatorHiddenId).show();
			          $("#"+initiatorDisplayId).attr("readOnly",false);
			          $("#"+initiatorDisplayId).hide();
			    	  $choseButton.hide();
				  }
	          }
		}
		function modifyActivity(rowIndex)
		{
			 var rowData = getTracywindyObject('id_workflow_activity_detail_table').getRowDataAt(rowIndex);
			 var id = rowData['id'];
			 var deployid = rowData['deploymentimpl'];
			 var workflowName = rowData['workflowname'];
			 var activityType = rowData['activitytype'];
			 var activityName = rowData['activityname'];
			 //var initiatorType = rowData['actortype'];
			 //执行人
			 var initiator = (rowData['actorvalue']||"").replace(/\\n/g,"\r\n");
			 var displayInitiator = rowData['displayactorvalue'];
			 var initiatorType = rowData['actortype'];
			 //自动传阅
			 var autoSignatureInitiator     = (rowData['autosignatureactorvalue']||"").replace(/\\n/g,"\r\n");
			 var autoSignatureDisplayInitiator     = rowData['autosignaturedisplayactorvalue'];
			 var autoSignatureInitiatorType = rowData['autosignatureactortype'];
			 //条件路由
			 var conditionRouteType    = rowData['conditionroutetype'];
			 var conditionRouteValue   = rowData['conditionroutevalue'];
			 //信息
			 var messageTypes    = rowData['messagetypes'];
			 var messageContent  = rowData['messagecontent'];
			 var readMessageTypes    = rowData['readmessagetypes'];
			 var readMessageContent  = rowData['readmessagecontent'];
			 var signatureMessageTypes    = rowData['signaturemessagetypes'];
			 var signatureMessageContent  = rowData['signaturemessagecontent'];
			 
			//自动会签
			 var autoReadInitiator     = (rowData['autoreadactorvalue']||"").replace(/\\n/g,"\r\n");
			 var autoReadDisplayInitiator     = rowData['autoreaddisplayactorvalue'];
			 var autoReadInitiatorType = rowData['autoreadactortype'];
			 //表单
			 var formPath        = rowData['formpath'];
			 var formTitle       = rowData['formtitle'];
			 //Action
			 var activityAction  = rowData['activityaction'];
			 //附件
			 var attachmentType  = rowData['attachmenttype'];
			 //提交按钮
			 var submitButtons   = rowData['operationbuttons'];
			 //是否需要填写意见
			 var isNeedAdvise    = rowData['isneedadvise'];
			 //手否检查附件
			 var isAttachmentChecked = rowData['isattachmentchecked'];
			 //是否是自动节点
			 var isAutoActivity  = rowData['isautoactivity'];
			 //退后按钮
			 var backRoutesNodes = rowData['backactivities'];
			 //处理方式
			 var dealMethod      = rowData['dealmethod'];
			 var passedCount     = rowData['passedcount'];
			 
			 var currentCheckedRadio = jQuery("input[type='radio'][name='isNeedAdvise'][value='"+isNeedAdvise+"']")[0];
			 if(currentCheckedRadio)
			 {
				 currentCheckedRadio.checked = true;
		     }
			 else
			 {
				 jQuery("input[type='radio'][name='isNeedAdvise']")[1].checked=true;
			 }
			 
			 var currentCheckedAttachmentRadio = jQuery("input[type='radio'][name='isAttachmentChecked'][value='"+isAttachmentChecked+"']")[0];
			 if(currentCheckedAttachmentRadio)
			 {
				 currentCheckedAttachmentRadio.checked = true;
		     }
			 else
			 {
				 jQuery("input[type='radio'][name='isAttachmentChecked']")[1].checked=true;
			 }
			 
			 var currentCheckedAutoActivityRadio = jQuery("input[type='radio'][name='isAutoActivity'][value='"+isAutoActivity+"']")[0];
			 if(currentCheckedAutoActivityRadio)
			 {
				 currentCheckedAutoActivityRadio.checked = true;
		     }
			 else
			 {
				 jQuery("input[type='radio'][name='isAutoActivity']")[1].checked=true;
			 }
			 
			 jQuery("#id_recordId").val(id);
			 jQuery("#id_deployId").val(deployid);
			 jQuery("#id_activityType").html(activityType);
			 jQuery("#id_activityName").html(activityName);
			 //参与人
			 jQuery("#id_initiator").val(initiator);
			 jQuery("#id_initiator_display").val(displayInitiator);
			 //条件路由
			 jQuery("#id_conditionRouteValue").val(conditionRouteValue);
			 //信息
			 jQuery("#id_messageContent").val(messageContent);
			 setMessageTypes(messageTypes);
			 jQuery("#id_readMessageContent").val(readMessageContent);
			 setReadMessageTypes(readMessageTypes);
			 jQuery("#id_signatureMessageContent").val(signatureMessageContent);
			 setSignatureMessageTypes(signatureMessageTypes);
			 //自动会签
			 jQuery("#id_autoSignatureInitiator").val(autoSignatureInitiator);
			 jQuery("#id_autoSignatureInitiator_display").val(autoSignatureDisplayInitiator);
			 //自动传阅
			 jQuery("#id_autoReadInitiator").val(autoReadInitiator);
			 jQuery("#id_autoReadInitiator_display").val(autoReadDisplayInitiator);

			 //表单
			 jQuery("#id_formPath").val(formPath);
			 jQuery("#id_formTitle").val(formTitle);
			 setOperationButtons(submitButtons);
			 //设置处理方式
			 jQuery("#id_passedCount").val(passedCount);
			 
			 var combo_activityAction = getTracywindyObject('combo_activityAction');
			 var combo_attachmentType = getTracywindyObject('combo_attachmentType');
			 var combo_backRoutes     = getTracywindyObject('combo_backRoutes');
			 
			 var combo_initiatorType     = getTracywindyObject('combo_initiatorType');
			 var combo_autoReadInitiatorType     = getTracywindyObject('combo_initiatorTyperead');
			 var combo_autoSignatureInitiatorType     = getTracywindyObject('combo_initiatorTypesignature');
			 var combo_dealMethod     = getTracywindyObject('combo_dealMethod');
			 
			 //条件路由
             var combo_conditionRouteType = getTracywindyObject('combo_conditionRouteType');
			 //信息
             if(("start"==activityType)||(("end"==activityType)))
             {
            	 jQuery("#id_initiator_display")[0].disabled = true;
            	 jQuery("#id_autoSignatureInitiator")[0].disabled = true;
            	 jQuery("#id_autoSignatureInitiator_display")[0].disabled = true;
            	 if("end"==activityType){
                	 jQuery("#id_autoReadInitiator")[0].disabled = false;
                	 jQuery("#id_autoReadInitiator_display")[0].disabled = false;
            	 }else{
                	 jQuery("#id_autoReadInitiator")[0].disabled = true;
                	 jQuery("#id_autoReadInitiator_display")[0].disabled = true;
            	 }
            	 jQuery("#id_formPath")[0].disabled = true;
            	 jQuery("#id_formTitle")[0].disabled = true;
            	 jQuery("#id_passedCount")[0].disabled = true;
            	 jQuery("input[name='submitButtons']").attr("disabled","disabled");
            	 jQuery("input[type='radio'][name='isNeedAdvise']").attr("disabled","disabled");
            	 jQuery("input[type='radio'][name='isAttachmentChecked']").attr("disabled","disabled");
            	 jQuery("input[type='radio'][name='isAutoActivity']").attr("disabled","disabled");
            	 //信息
            	 jQuery("#id_messageContent")[0].disabled = true;
            	 jQuery("input[name='messageTypes']").attr("disabled","disabled");
            	 jQuery("#id_readMessageContent")[0].disabled = true;
            	 jQuery("input[name='readMessageTypes']").attr("disabled","disabled");
            	 jQuery("#id_signatureMessageContent")[0].disabled = true;
            	 jQuery("input[name='signatureMessageTypes']").attr("disabled","disabled");
            	 
            	 combo_attachmentType.readOnlyData = true;
            	 combo_backRoutes.readOnlyData = true;
            	 combo_initiatorType.readOnlyData = true;
            	 if("end"==activityType){
    			    combo_autoReadInitiatorType.readOnlyData = false;
            	 }else{
            		 combo_autoReadInitiatorType.readOnlyData = true;
            	 }
    			 combo_autoSignatureInitiatorType.readOnlyData = true;
    			 combo_dealMethod.readOnlyData = true;
    			 combo_conditionRouteType.readOnlyData = true;
             }
             else
             {
            	 jQuery("#id_initiator")[0].disabled = false;
            	 jQuery("#id_initiator_display")[0].disabled = false;
            	 jQuery("#id_autoSignatureInitiator")[0].disabled = false;
            	 jQuery("#id_autoSignatureInitiator_display")[0].disabled = false;
            	 jQuery("#id_autoReadInitiator")[0].disabled = false;
            	 jQuery("#id_autoReadInitiator_display")[0].disabled = false;
            	 jQuery("#id_formPath")[0].disabled = false;
            	 jQuery("#id_formTitle")[0].disabled = false;
            	 jQuery("#id_passedCount")[0].disabled = false;
            	 jQuery("input[name='submitButtons']").removeAttr("disabled");
            	 //信息
            	 jQuery("#id_messageContent")[0].disabled = false;
            	 jQuery("input[name='messageTypes']").removeAttr("disabled");
            	 jQuery("#id_readMessageContent")[0].disabled = false;
            	 jQuery("input[name='readMessageTypes']").removeAttr("disabled");
            	 jQuery("#id_signatureMessageContent")[0].disabled = false;
            	 jQuery("input[name='signatureMessageTypes']").removeAttr("disabled");
            	 
            	 jQuery("input[type='radio'][name='isNeedAdvise']").removeAttr("disabled");
            	 jQuery("input[type='radio'][name='isAttachmentChecked']").removeAttr("disabled");
            	 jQuery("input[type='radio'][name='isAutoActivity']").removeAttr("disabled");
            	 combo_attachmentType.readOnlyData = false;
            	 combo_backRoutes.readOnlyData = false;
            	 combo_initiatorType.readOnlyData = false;
    			 combo_autoReadInitiatorType.readOnlyData = false;
    			 combo_autoSignatureInitiatorType.readOnlyData = false;
    			 combo_dealMethod.readOnlyData = false;
    			 combo_conditionRouteType.readOnlyData = false;
             }
	         //设置参与人
             combo_initiatorType.setValue(initiatorType);
			 combo_autoReadInitiatorType.setValue(autoReadInitiatorType);
			 combo_autoSignatureInitiatorType.setValue(autoSignatureInitiatorType);
			 combo_dealMethod.setValue(dealMethod);
        	 combo_initiatorType.reload();
			 combo_autoReadInitiatorType.reload();
			 combo_autoSignatureInitiatorType.reload();
			 combo_dealMethod.reload();
	         //设置条件路由
	         combo_conditionRouteType.setValue(conditionRouteType);
	         combo_conditionRouteType.reload();
	         if("pageCallBack" == conditionRouteType){
	        	 jQuery(".need-set-value-cls-conditionRoute").hide();
	        	 jQuery(".need-set-value-cls-conditionRoute-label").show();
	         }else{
	        	 jQuery(".need-set-value-cls-conditionRoute").show();
	        	 jQuery(".need-set-value-cls-conditionRoute-label").hide();
	         }
             //设置节点Action
			 combo_activityAction.setParams({
				 paramWorkflowName:workflowName
		     });
			 combo_activityAction.setRawValue('');
			 combo_activityAction.loadComplete=function(){
				 this.setValue(activityAction);
		    };
			 combo_activityAction.reload();
		    //设置附件类型
			combo_attachmentType.setRawValue('');
			combo_attachmentType.loadComplete=function(){
				this.setRawValue(attachmentType);
		    };
			combo_attachmentType.reload();
		    //设置退回路由
			combo_backRoutes.setParams({
				  deployId:deployid
		     });
			 combo_backRoutes.loadComplete=function(){
				 this.setRawValue(backRoutesNodes);
		    };
			 combo_backRoutes.reload();
			 //初始化设置
			 if("NPassed" == dealMethod){
				 $("td.n-passed-cls").show();
			 }else{
				 $("td.n-passed-cls").hide();
			 }
			 //选择参与人
			 initNodeInitiator(combo_initiatorType.getValue(),combo_initiatorType.getRawValue(),"id_initiatorTypeContainer","id_initiator_display","id_initiator","id_initiator_button","");
		     //选择结束时传阅参与人类型
		     initNodeInitiator(combo_autoReadInitiatorType.getValue(),combo_autoReadInitiatorType.getRawValue(),"id_autoReadInitiatorTypeContainer","id_autoReadInitiator_display","id_autoReadInitiator","id_autoReadInitiator_button","read");
		     //选择结束时会签参与人类型  
		     initNodeInitiator(combo_autoSignatureInitiatorType.getValue(),combo_autoSignatureInitiatorType.getRawValue(),"id_autoSignatureInitiatorTypeContainer","id_autoSignatureInitiator_display","id_autoSignatureInitiator","id_autoSignatureInitiator_button","signature");
		    //设置选择历史步骤
		    var params = {
			    	deployId:deployid,
				    currentActivityDetailId:id
			};
		    var stepSelection = getTracywindyObject('id_step');
		    stepSelection.setParams(params);
		    stepSelection.reload();
		    var stepSelectionRead = getTracywindyObject('id_step'+"read");
		    stepSelectionRead.setParams(params);
		    stepSelectionRead.reload();
		    var stepSelectionSignature = getTracywindyObject('id_step'+"signature");
		    stepSelectionSignature.setParams(params);
		    stepSelectionSignature.reload();
            
            jQuery("#id_workflow_activity_setting").show();
			var cwin = jQuery("#id_workflow_activity_setting").dialog({
		              	top:5,
		              	zIndex:9999999,
		              	title:"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; < "+activityName+" > 节点设置",
		              	draggable:true,
		              	resizable:false,
		              	shadow:true,
		              	modal:false,
		              	inline:false,
		              	collapsible:false,
		              	minimizable:false,
		              	maximizable:false,
		              	closable:true,
		              	closed:false
	              });
	          cwin.dialog("open");
	     }
	     function saveChangeToActivity()
	     {
	    	  var activityName = jQuery("#id_activityName").html();
			  if(window.confirm("确认修改节点（ "+activityName+"）的信息么？"))
			  {
						 loadMask.show();
						 var id = jQuery("#id_recordId").val();
						 var deployid = jQuery("#id_deployId").val();

						 var combo_initiatorType     = getTracywindyObject('combo_initiatorType');
						 var combo_autoReadInitiatorType     = getTracywindyObject('combo_initiatorTyperead');
						 var combo_autoSignatureInitiatorType     = getTracywindyObject('combo_initiatorTypesignature');
						 var combo_dealMethod     = getTracywindyObject('combo_dealMethod');
						 var combo_conditionRouteType =  getTracywindyObject('combo_conditionRouteType');
						 
						 var initiatorType = combo_initiatorType.getValue();
						 var initiator = jQuery("#id_initiator").val();
						 var conditionRouteType = combo_conditionRouteType.getValue();
						 var conditionRouteValue = jQuery("#id_conditionRouteValue").val();
						 var displayInitiator = jQuery("#id_initiator_display").val();
						 var autoSignatureInitiatorType = combo_autoSignatureInitiatorType.getValue();
						 var autoSignatureInitiator = jQuery("#id_autoSignatureInitiator").val();
						 var autoSignatureDisplayInitiator = jQuery("#id_autoSignatureInitiator_display").val();
						 var autoReadInitiatorType = combo_autoReadInitiatorType.getValue();
						 var autoReadInitiator = jQuery("#id_autoReadInitiator").val();
						 var autoReadDisplayInitiator = jQuery("#id_autoReadInitiator_display").val();
						 
						 var dealMethod = combo_dealMethod.getValue();
						 var passedCount = jQuery("#id_passedCount").val();
						 var activityAction = getTracywindyObject('combo_activityAction').getValue();
						 var attachmentType = getTracywindyObject('combo_attachmentType').getRawValue();
						 var attachmentTypeIds = getTracywindyObject('combo_attachmentType').getValue();
						 var formPath = jQuery("#id_formPath").val();
						 var formTitle = jQuery("#id_formTitle").val();
						 var submitButtons  = getOperationButtons();
						 var isNeedAdvise   = jQuery("input[type='radio'][name='isNeedAdvise']:checked").val();
						 var isAttachmentChecked   = jQuery("input[type='radio'][name='isAttachmentChecked']:checked").val();
						 var isAutoActivity = jQuery("input[type='radio'][name='isAutoActivity']:checked").val();
						 var backRoutesNodes = getTracywindyObject('combo_backRoutes').getRawValue();
						 //信息
						 var messageTypes   = getMessageTypes();
						 var messageContent = jQuery("#id_messageContent").val();
						 var readMessageTypes   = getReadMessageTypes();
						 var readMessageContent = jQuery("#id_readMessageContent").val();
						 var signatureMessageTypes   = getSignatureMessageTypes();
						 var signatureMessageContent = jQuery("#id_signatureMessageContent").val();
						 
		            	 jQuery("input[name='messageTypes']").removeAttr("disabled");
						 var params={
							id:id,
							actorType:initiatorType,
							actorValue:initiator,
							conditionRouteType:conditionRouteType,
							conditionRouteValue:conditionRouteValue,
							messageTypes:messageTypes,
							messageContent:messageContent,
							readMessageTypes:readMessageTypes,
							readMessageContent:readMessageContent,
							signatureMessageTypes:signatureMessageTypes,
							signatureMessageContent:signatureMessageContent,
							displayActorValue:displayInitiator,
							autoSignatureActorType:autoSignatureInitiatorType,
							autoSignatureActorValue:autoSignatureInitiator,
							autoSignatureDisplayActorValue:autoSignatureDisplayInitiator,
							autoReadActorType:autoReadInitiatorType,
							autoReadActorValue:autoReadInitiator,
							autoReadDisplayActorValue:autoReadDisplayInitiator,
							activityAction:activityAction,
							attachmentType:attachmentType,
							attachmentTypeIds:attachmentTypeIds,
							formPath:formPath,
							formTitle:formTitle,
							operationButtons:submitButtons	 ,
							isNeedAdvise:isNeedAdvise,
							isAttachmentChecked:isAttachmentChecked,
							isAutoActivity:isAutoActivity,
							backActivities:backRoutesNodes,
							dealMethod:dealMethod,
							passedCount:passedCount
					    };
						ajaxRequest({
				  		     url:'${pageContext.request.contextPath}/jbpm/saveChangeToActivity.action',
				  		     method:'POST',
				  		     success:function(res){
					  		    getTracywindyObject('id_workflow_activity_detail_table').reload();
				  		    	loadMask.hide();
				  		    	jQuery("#id_workflow_activity_setting").window("close");
				  		     },
				  		     failure:function(res){loadMask.hide();},
				  		     params:params
						 }); 
					}
		 }
	     function setDataChecks(buttonsValue,checkName){
	    	 $("input[name='"+checkName+"']").attr("checked",false);
		     if(buttonsValue)
		     {
			     var splitButtonsArr = buttonsValue.split(",");
			     for(var i=0;i<splitButtonsArr.length;i++)
			     {
			    	 $("input[name='"+checkName+"'][value='"+splitButtonsArr[i]+"']").attr("checked",true);
				 }
			 }
	     }
	     function getDataChecks(checkName){
		     var operationButtonsCheckBox = $("input[name='"+checkName+"']:checked");
		     var operationButionsArr = [];
		     operationButtonsCheckBox.each(function(){
		    	 operationButionsArr.push(this.value);
			 });
			 return operationButionsArr.join(",");
	     }
	     function setMessageTypes(buttonsValue){
	    	 setDataChecks(buttonsValue,"messageTypes");
	     }
	     function getMessageTypes(){
	    	 return getDataChecks("messageTypes");
	     }
	     function setReadMessageTypes(buttonsValue){
	    	 setDataChecks(buttonsValue,"readMessageTypes");
	     }
	     function getReadMessageTypes(){
	    	 return getDataChecks("readMessageTypes");
	     }
	     function setSignatureMessageTypes(buttonsValue){
	    	 setDataChecks(buttonsValue,"signatureMessageTypes");
	     }
	     function getSignatureMessageTypes(){
	    	 return getDataChecks("signatureMessageTypes");
	     }
	     function setOperationButtons(buttonsValue)
	     {
	    	 setDataChecks(buttonsValue,"submitButtons");
	    	 /*$("input[name='submitButtons']").attr("checked",false);
		     if(buttonsValue)
		     {
			     var splitButtonsArr = buttonsValue.split(",");
			     for(var i=0;i<splitButtonsArr.length;i++)
			     {
			    	 $("input[name='submitButtons'][value='"+splitButtonsArr[i]+"']").attr("checked",true);
				 }
			 }*/
		 }
	     function getOperationButtons()
	     {
	    	 return getDataChecks("submitButtons");
		     /*var operationButtonsCheckBox = $("input[name='submitButtons']:checked");
		     var operationButionsArr = [];
		     operationButtonsCheckBox.each(function(){
		    	 operationButionsArr.push(this.value);
			 });
			 return operationButionsArr.join(",");*/
		 }
	  </script>
<script type="text/javascript">
		//processDefinitionsDatas.sort(function(a,b){return a.processdefinitionkey>b.processdefinitionkey?1:-1;});
		
		var processDefinitionsColumns = [ 
			{header:'流程图',  name:'diagram',width:60,align:'center',
	            renderer:function(value,tableObj,columnName,columnIndex,rowData){
	       	 return '<a href="javascript:void(0);" onclick="toProcessActivePicture(\''+rowData.id+'\',\''+(-1)+'\',\''+rowData.maxdotx+'\',\''+rowData.maxdoty+'\')">查看</a>';
	         }
	        },
	        {header:'流程设计',name:'operdesign',width:60,align:'center',renderer:function(value,tableObj,columnName,columnIndex,rowData){
	            var isDeployed = 'false';
	            if(rowData.deployid)
	            {
	           	 isDeployed = 'true';
	            }
	       	 return '<a href="javascript:void(0);" onclick="modifyWorkflow('+rowData.rowIndex+',\''+isDeployed+'\')">设计</a>';
	        }},
	        {header:'流程发布',name:'operdeploy',align:"left",width:150,renderer:function(value,tableObj,columnName,columnIndex,rowData){
	       	 var deploy = "";
	            if(rowData.deployid)
	            {
	           	 deploy+= '<a href="javascript:void(0);" onclick="removeDeploy('+rowData.rowIndex+')">撤销发布</a>';
	           	 deploy+='&nbsp;&nbsp;'+'<a href="javascript:void(0);" onclick="workflowActivitiesSetting('+rowData.rowIndex+',\''+rowData.deployid+'\',\''+rowData.processdefinitionid+'\',\''+rowData.maxdotx+'\',\''+rowData.maxdoty+'\')">设置</a>';
	           	 //deploy+='<br/><a href="javascript:void(0);" onclick="workflowInfoSetting('+rowData.rowIndex+',\''+rowData.deployid+'\',\''+rowData.processdefinitionid+'\')">修改</a>';
	           	 deploy+='&nbsp;&nbsp;'+'<a href="javascript:void(0);" onclick="workflowKeySetting('+rowData.rowIndex+',\''+rowData.deployid+'\',\''+rowData.processdefinitionid+'\')">关键字</a>';
	           	 if(rowData.processdefinitiondeployedtime < rowData.processdefinitionupdatetime)
	           	 {
	           		 deploy+='<br/>&nbsp;&nbsp;'+'<a href="javascript:void(0);" onclick="workflowSynchronized(\''+rowData.deployid+'\')">流程同步</a>';
	                }
	           	 //deploy+='&nbsp;&nbsp;&nbsp;&nbsp;'+'<a href="javascript:void(0);" onclick="startProcess(\''+rowData.processdefinitionid+'\')">发起流程</a>';
	            }
	            else
	            {
	           	 deploy += '<a href="javascript:void(0);" onclick="publishDeploy('+rowData.rowIndex+')">发布</a>';
	           	 deploy += '&nbsp;&nbsp;'+'<a href="javascript:void(0);" onclick="removeDesignedWorkflow('+rowData.rowIndex+')">删除</a>';
	           	 deploy+='&nbsp;&nbsp;'+'<a href="javascript:void(0);" onclick="workflowKeySetting('+rowData.rowIndex+',\''+rowData.deployid+'\',\''+rowData.processdefinitionid+'\')">关键字</a>';
	            }
	       		return deploy;
	      }},
	     {header:'设计编号',name:'id',hidden:true},
	     {header:'部署编号',name:'deployid',hidden:true},
	     {header:'流程分类编号',name:'type',hidden:true},
	     {header:'排序',name:'position',hidden:true},
	     {header:'流程分类',name:'displaytype'},
	     {header:'显示名称',name:'processdefinitiondisplayname',width:200},
	     {header:'流程编号',name:'code'},
	     {header:'流程名称',name:'processdefinitionkey',width:200},
	     {header:'流程版本号',name:'processdefinitionversion',width:80},
	     {header:'设计器版本',name:'processdefinitionjpdlversion',width:80},
	     {header:'流程描述',name:'processdefinitiondescription',width:100},
	     {header:'关键字段一',name:'keyone',width:150},
	     {header:'关键字段二',name:'keytwo',width:150},
	     {header:'关键字段三',name:'keythree',width:150},
	     {header:'关键字段四',name:'keyfour',width:150},
	     {header:'关键字段五',name:'keyfive',width:150},
	     {header:'关键字段六',name:'keysix',width:150},
	     {header:'关键字段七<font color="red">(付款单号)</font>',name:'keyseven',width:150},
	     {header:'关键字段八<font color="red">(合同流水号)</font>',name:'keyeight',width:150},
	     {header:'关键字段九<font color="red">(项目立项流水号)</font>',name:'keynine',width:150},
	     {header:'关键字段十<font color="red">(互斥标识)</font>',name:'keyten',width:150}
     ];   
	new tracywindyTable({
				  lockedNames:['diagram','operdesign','operdeploy'],
		          renderTo:'id_processDefinitionsContainer',
		          width:all_width-2,
		          height:all_height,
		          isCheck:false,
		          isRank:true,
		          pageSize:20,
		          isExcel:false,
		          title:'流程设计',
		          tools:[{
	            	  isHtml:true,
	            	  html:'全局搜索：<input type="text" style="margin-right:4px;border:1px solid #DDD;" id="id_queryWorkflowsTableInput" value="'+unescape(decodeURIComponent("${param.queryText}"))+'" />'
		            },'-',{
			          html:'创建新流程',
		        	  iconCls:'icon-plus',
		        	  handler:function(){
		        	    createNewWorkflow();
		        	  }
			      }],
			      border:true,
			      toolsLeftMargin:50,
		          id:'id_workflows_table',
		          showHeader:true,
		          isPage:true,
		          start:parseInt("${empty param.pageStart ? 0 : param.pageStart }"),
		          params:{
					queryText:unescape(decodeURIComponent("${param.queryText}"))
                  },
                  xmlFileName:'/jbpm/queryAllDesignedWorkflows.xml',
		          loadMode:'ajax',
		          columns:processDefinitionsColumns,
				  callBack:function(){
					this.setColumnHidden(true,'processdefinitionversion');
					this.setColumnHidden(true,'processdefinitionjpdlversion');
				  }
		       });
	         jQuery("#id_queryWorkflowsTableInput").keypress(function(e){
                 var code = e.keyCode||e.charCode;
                 if(13 == code){
                     var workflowsTable = getTracywindyTable("id_workflows_table");
                     workflowsTable.setParams({
                            queryText:this.value.toUpperCase()
                     });
                     workflowsTable.reload();
                 }
	         });
</script>
</body>
</html>