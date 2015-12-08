<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统后台管理</title>
    <!--css sheet-->
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<!--javascript libray-->
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyCommonUserSelection.js"></script>
    <script>
       var loadMask = null;
       function xmlDataSynchronized(){
           if(!window.confirm("确认XML数据同步么？"))
           {
               return false;
           }
           if(null == loadMask){
        	   loadMask = new  tracywindyLoadMask(document.body,"数据加载中 请稍等...");
           }
           loadMask.show();
           ajaxRequest({
                url:'${pageContext.request.contextPath}/acl/updateXmlData.acl',
                timeout:30*60*1000,
                success:function(response){
                     alert("XML数据同步成功！");
                     loadMask.hide();
                }
           });
       }
       function permissionSynchronized(){
           if(!window.confirm("确认权限同步么？"))
           {
               return false;
           }
           if(null == loadMask){
        	   loadMask = new  tracywindyLoadMask(document.body,"数据加载中 请稍等...");
           }
           loadMask.show();
           ajaxRequest({
                url:'${pageContext.request.contextPath}/acl/updatePermission.acl',
                timeout:30*60*1000,
                success:function(response){
                     alert("权限同步成功！");
                     loadMask.hide();
                     window.location.href = window.location.href ;
                }
           });
       }
       function changeSystemModel(){
           if(!window.confirm("确认切换系统模式？"))
           {
               return false;
           }
           if(null == loadMask){
        	   loadMask = new  tracywindyLoadMask(document.body,"数据加载中 请稍等...");
           }
           loadMask.show();
           ajaxRequest({
                url:'${pageContext.request.contextPath}/acl/updateSystemMode.acl',
                timeout:30*60*1000,
                success:function(response){
                     alert("系统模式切换成功！");
                     loadMask.hide();
                     window.location.href = window.location.href ;
                }
           });
       }
       function workflowSynchronized(flag){
    	   var flagComment = flag ? "选中" : "全部";
           if(!window.confirm("确认同步"+flagComment+"流程么？"))
           {
               return false;
           }
    	   if(!Validator.Validate(jQuery("#id_workflowSynchronizedContainer")[0],1,false)){
        	   return;
           }
           if(null == loadMask){
        	   loadMask = new  tracywindyLoadMask(document.body,"数据加载中 请稍等...");
           }
           loadMask.show();
           var params = jQuery("#id_workflowSynchronizedContainer").tracywindySerializeFormToJsonObject(true);
           if(!flag){
        	   delete params["updateWorkflowIds"];
           }else{
        	   if(!jQuery("#id_updateWorkflowIds").val()){
        		   alert("请选择需要同步的流程！");
        		   jQuery("#id_updateWorkflowIds").focus();
        		   loadMask.hide();
        	   }
           }
           ajaxRequest({
                url:'${pageContext.request.contextPath}/jbpm/updateWorkflowConfigSynchronized.action',
                timeout:30*60*1000,
                method:"post",
                success:function(response){
                     alert("流程同步成功！");
                     loadMask.hide();
                     window.location.href = window.location.href ;
                },
                params:params
           });
       }
    </script>
    <style type="text/css">
    	body fieldset{
    		text-align:center;
    		float:left;
    		margin-top:20px;
    		margin-left:20px;
    		border:1px solid silver;
    		padding-top:10px;
    		padding-left:20px;
    		width:200px;
    		height: 70px;
    	}
    	
    	body fieldset font{
    		color: red;
    		font-weight:BOLD;
    	}
    
   		body fieldset a.btn{
    		width:auto;
    		margin-top:10px;
    		min-width: 100px;
    		font-size: 12px;
    	}
    	
    	.fl{
    		float: left;
    	}
    	
    	.data-source-config input,.data-source-config textarea{
    		width:200px;
    		border:1px solid #DDD;
    		overflow:auto;
    	}
    	
    	.data-source-config font{
    		width:100px;
    		text-align:center;
    		margin-left:10px;
    		color:red;
    	}
    	
    	.data-source-config td{
    		text-align: right;
    	}
    	
    	#id_contentContainer{
    		border:1px solid #DDD;
    		border-top:0px;
    		overflow: auto;
    	}
    	body{
    	  overflow-x:hidden;
    	}
    	#id_updateWorkflowIds_display{
    	  height:100px;
    	}
    </style>
</head>
<body>
   <div id="id_contentContainer">
   		<div>
		   	<div class="fl">
			   <fieldset>
			      <legend>模式变更</legend>
			      <%if(!com.kernal.utils.ResourceUtil.isDebug()){%>  
			         <font>上线模式</font><br/><a class="btn btn-primary" href="javascript:void(0);" onclick="changeSystemModel();" >转为 &nbsp;&lt;&nbsp;<font>开发</font> &nbsp;&gt;&nbsp;模式</a>
			      <%}else{%>  
			         <font>开发模式</font><br/><a class="btn btn-primary" href="javascript:void(0);" onclick="changeSystemModel();" >转为 &nbsp;&lt;&nbsp;<font>上线 </font>&nbsp;&gt;&nbsp;模式</a>
			      <%}%>
			   </fieldset>
			</div>
			<div class="fl">
			   <fieldset>
			      <legend>XML数据同步</legend>
			      <font>XML数据同步&nbsp;</font><br/>
			      <a class="btn btn-primary" href="javascript:void(0);" onclick="xmlDataSynchronized();">同&nbsp;步&nbsp;变&nbsp;动 </a>
			   </fieldset>
			</div>
			<div class="fl">
			   <fieldset>
			      <legend>模板移位</legend>
			      <font>模板移位&nbsp;</font><br/>
			      <a class="btn btn-primary" href="javascript:void(0);" onclick="removerTemplate();">模&nbsp;板&nbsp;移&nbsp;位 </a>
			   </fieldset>
			</div>
			<div class="fl">
			   <fieldset>
			      <legend>权限同步</legend>
			      <%if(com.kernal.utils.ResourceUtil.isNeedUpdatePermissionCache()){%>  
			         <font>存在权限变动&nbsp;</font><br/><a class="btn btn-primary" href="javascript:void(0);" onclick="permissionSynchronized();">同&nbsp;步&nbsp;变&nbsp;动 </a>
			      <%}else{%>  
			         <font>不存在权限变动</font>
			      <%}%>
			   </fieldset>
			</div>
			<div style="clear: both;"></div>
		</div>
		<div class="data-source-config">
		   <fieldset style="width:auto;height: auto;">
		      <legend>流程数据库同步</legend>
		      <table id="id_workflowSynchronizedContainer">
		         <tr><td>源数据库类型：</td><td><select label="源数据库类型" Require="true" name="type" style="width:204px;;border:1px solid #DDD;"><option value="oracle" selected>oracle</option><option value="sqlserver">sqlserver</option></select><font>*</font></td></tr>
		         <tr><td>源数据库地址：</td><td><input label="源数据库地址" Require="true"  value="" name="host"></input><font>*</font></td></tr>
		         <tr><td>源数据库端口：</td><td><input label="源数据库端口" Require="true"  value="1521" name="port"></input><font>*</font></td></tr>
		         <tr><td>源数据库库名/服务名：</td><td><input label="源数据库库名/服务名" Require="true"  value="orcl" name="dbname"></input><font>*</font></td></tr>
		         <tr><td>源数据库用户名：</td><td><input label="源数据库用户名" Require="true"  value="" name="user"></input><font>*</font></td></tr>
		         <tr><td>源数据库密码：</td><td><input type="password" label="源数据库密码" Require="true"  value="" name="password"></input><font>*</font></td></tr>
		         <tr><td>需要同步的流程：</td><td><textarea readonly onclick="getUpdateWorkflow();" id="id_updateWorkflowIds_display" name="updateWorkflowIds_display" label="需要同步的流程" Require="false"  value=""></textarea><font>*</font></td></tr>
		         <tr style="display:none" ><td>需要同步的流程：</td><td><textarea readonly id="id_updateWorkflowIds" name="updateWorkflowIds" label="需要同步的流程" Require="false"  value="" ></textarea><font>*</font></td></tr>
		         <tr><td style="height:20px;">&nbsp;</td></tr>
		         <tr><td colspan=2 style="text-align:center;"><a class="btn btn-primary" href="javascript:void(0);" onclick="workflowSynchronized(true);">同步选中流程</a>&nbsp;&nbsp;<a class="btn btn-primary" href="javascript:void(0);" onclick="workflowSynchronized(false);">同步全部流程</a></td></tr>
		      </table>
		   </fieldset>
		</div>
   </div>
   <script type='text/javascript'>
         $("#id_contentContainer").css("height",$(window).height()-2);
         function removerTemplate(){
      	   
      	   var url="/leasing/template/removeTempalate.action";
      	   alert(1);
      	    ajaxRequest({
      		     url:getRootPath()+url,
      		     method:'POST',
      		     success:function(rs){
      		        alert(rs.responseText);
      	   	     },
      		     async:false,
      		     failure:function(res){
      	   		
                 }
      	   });
       
        }  
         var selectionUpdateWorkflowIds =  null;
         function getUpdateWorkflow()
         {
        	var params = jQuery("#id_workflowSynchronizedContainer").tracywindySerializeFormToJsonObject(true);
        	if(null == selectionUpdateWorkflowIds){
	           	 selectionUpdateWorkflowIds =  new tracywindyCommonUserSelection({
					    hiddenInput:"id_updateWorkflowIds",
					    displayInput:"id_updateWorkflowIds_display",
					    isMultiSelect:true,
					    draggable:false,
					    windowTop:1,
					    id:"id_selectionUpdateWorkflowIds",
					    type:'synchronizedWorkflowDesigners',
					    params:params
				   });
        	}else{
        		selectionUpdateWorkflowIds.setParams(params);
        		selectionUpdateWorkflowIds.reload();
        	}
        	selectionUpdateWorkflowIds.show();
         }
   </script>
</body>
</html>