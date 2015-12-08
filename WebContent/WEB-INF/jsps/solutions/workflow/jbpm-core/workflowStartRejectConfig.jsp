<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程发起互斥管理</title>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
    <style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	</style>
<script type="text/javascript">
	var pageWidth  = document.documentElement.clientWidth;
	var pageHeight = document.documentElement.clientHeight-10;
	var loadMask = null;
	jQuery(function(){
		if(null == loadMask){
			loadMask = new tracywindyLoadMask(document.body,"数据加载中 请稍后...");
	    }
	    //加载树形
		$('#id_menu_tabs_menu').tree({
			url:'${pageContext.request.contextPath}/jbpm/getDeployedWorkflowsTreeData.action',
			onBeforeLoad:function(node,params){
				loadMask.show();
				if(!node){
					params['init'] = true; 
				}
				else{
					params['typeId'] = node.id;
			    }
			},
			onLoadSuccess:function(a,b){
				loadMask.hide();
		    },
		    onClick:function(node){
			    var isType = false;
		    	if(!node.attributes)isType=true;
		    	if(node.attributes){
			    	if(!node.attributes["typeId"])isType=true;
			    }
		    	if(isType&&firstReloaded){
		    		$("#id_userSelectContainer").html(node.text);
		    		var table = getTracywindyObject("id_table");
		    		$("#id_userSelectContainer").html("");
		    		table.setColumnHidden(true,'isgrant');
		    		table.setColumnHidden(true,'query_conditions_');
		    		table.reload();
			    }
		    	else if(!isType)
			    {
			        currentMenuSelectNode = node;
					$("#id_userSelectContainer").html(node.text);
					reloadSelectUsersTable(null);
			    }
			}
		});
   });

	   
	//加载人员选择
	var currentMenuSelectNode = null;
	var currentMenuRemoveUserNode = null;
	var currentSelectedUserIds = [];
	var rejectJsonArray = null;
	function reloadSelectUsersTable(){
		    var table = getTracywindyObject("id_table");
		    table.setColumnHidden(false,'isgrant');
		    table.setColumnHidden(false,'rejectinfo');
		    table.setColumnHidden(false,'query_conditions_');
		    table.xmlFileName = "/jbpm/queryRejectWorkflowDesigners.xml";
			table.setParams({sourceDesignerId:currentMenuSelectNode.id});
		    if(!firstReloaded){
		    	table.columns.push({
			    	 header:'互拆流程分配',
			    	 name:'isgrant',
			    	 align:'left',
			    	 renderer:function(value,tableObj,columnName,columnIndex,rowData){
			    	 	var checked = "";
			    	 	var queryCondition="";
		            	if('1' == value )
		            	{
		            		queryCondition = "<a href='javascript:void(0);' onclick='showRejectConditionsWindow("+rowData.rowIndex+");'>"+"互斥条件"+"</a>&nbsp;";
		            		checked ="checked";
			            }
			            var html ="<input style='cursor:pointer;' type='checkbox' "+checked +"  onclick=\"distribute('"+rowData.rowIndex+"',this.checked);\"/>";
			            return queryCondition+html;
			    	 }
			    });
		    	table.setColumnRenderer(function(value,tableObj,columnName,columnIndex,rowData){
                     if(!rejectJsonArray){ 
		    		   ajaxRequest({
		    			   url:'${pageContext.request.contextPath}/jbpm/getWorkflowRejectBeanNames.action',
		    			   timeout:30*10*1000,
		    			   async:false,
		    			   success:function(res){
		    				   rejectJsonArray = JsonUtil.decode(res.responseText);
		    		       },
		    		       failure:function(){
		    		       }
		    		   });
                     }
                     var  rowData_sourceWorkflowName = currentMenuSelectNode.attributes["key"];
                     var  rowData_rejectWorkflowName = rowData["key_"];
                     for(var i = 0;i<rejectJsonArray.length;i++){
                         var rejectJson = rejectJsonArray[i];
                         var sourceWorkflowName = rejectJson.sourceWorkflowName;
                         var rejectWorkflowName = rejectJson.rejectWorkflowName;
                         if((rowData_sourceWorkflowName == sourceWorkflowName) && (rowData_rejectWorkflowName == rejectWorkflowName)){
                               return rejectJson.name;
                         }
                     }
                     return "";
			    },"rejectinfo");
		    	table.setLockedNames(["isgrant","query_conditions_","rejectinfo"]);
			}
		    else{
		    	table.reload();
			}
		    firstReloaded = true;
	}
	var firstReloaded = false;
	function distribute(rowIndex,checked){
		 loadMask.show();
         var rowData = getTracywindyObject("id_table").getRowDataAt(rowIndex);
         var entityClassName = "WorkflowDesignerReject";
         var leftFieldName = "sourceJbpmWorkflowDesigner";
         var leftId  = rowData["sourcedesignerid"];
         var rightFieldName = "rejectJbpmWorkflowDesigner";
         var rightId = rowData["rejectdesignerid"];
         var url = "${pageContext.request.contextPath}/acl/addOrRemoveDistribute.acl";
         var params = {
                 entityClassName:entityClassName,
        		 leftFieldName  :leftFieldName,
        		 leftId         :leftId,
        		 rightFieldName :rightFieldName,
        		 rightId        :rightId
         };
         ajaxRequest({
              url:url,
              params:params,
              timeout:30*1000,
              success:function(res){
        	      getTracywindyObject("id_table").reload();
                  loadMask.hide();
              }
         });
         
    }
    jQuery(function(){
	   	 var table = new tracywindyTable({
	   	     border:true,
	         renderTo:'id_menu_main_content_div',
	         width:(pageWidth + widthAdd-2),
	         height:(pageHeight+heightAdd-32),
	         tools:[{
	        	  isHtml:true,
	           	  html:'全局搜索：<input type="text" style="margin-right:4px;border:1px solid #DDD;width:80px;" id="id_queryWorkflowsTableInput" />'
	           }],
	         id:'id_table',
	         xmlFileName:'/jbpm/queryAllDesignedWorkflows.xml',
	         loadMode:'ajax',
	         isPage:false,
	         isFit:true,
	         border:true,
	         isRank:true,
	         isAutoBreakContent:true,
	         columns:[
			            {header:'记录编号',name:'id',hidden:true},
			            {header:'',name:'sourcedesignerid',hidden:true},
			            {header:'',name:'rejectdesignerid',hidden:true},
			            {header:'关键字一对应参数名',name:'query_conditions_',hidden:true},
			            {header:'自定义互斥CLASS',name:'rejectinfo',hidden:true},
			            {header:'流程分类',name:'typename_'},
			            {header:'显示名称',name:'display_name_'},
			            {header:'流程编号',name:'code_'},
			            {header:'流程名称',name:'key_'}/*,
			            {header:'流程版本',name:'version_'},
			            {header:'流程描述',name:'description_'}*/
		     ],
		     params:{
	   		    enabled : 1
		     }
	   	 });
	     jQuery("#id_queryWorkflowsTableInput").keypress(function(e){
	         var code = e.keyCode||e.charCode;
	         var table = getTracywindyObject("id_table");
	         if(13 == code){
	             table.setParams({
	                    queryText:this.value.toUpperCase()
	             });
	             table.reload();
	         }
	     });
	   });
	   var globalSetRowIndex = -1;
	   function showRejectConditionsWindow(rowIndex)
	   {
		    globalSetRowIndex = rowIndex;
		    var rowData = getTracywindyObject("id_table").getRowDataAt(rowIndex);
		    var id      = rowData["id_"];
		    $("#id_rejectQueryConditions").val(rowData["query_conditions_"]);
    		jQuery("#id_detailInfoWindowContainer").show();
    		jQuery("#id_detailInfoWindowContainer").window({top:80,title:' < '+rowData["display_name_"]+' > 互斥条件',draggable:false});
        	jQuery("#id_detailInfoWindowContainer").window("open");
	   }
	   function setRejectConditions()
	   {
		     var queryConditions = $("#id_rejectQueryConditions").val();
		     if(!queryConditions.replace(/\s/g,"")){
			   alert("流程互斥条件不能为空!");
			   return ;
		     }
		     jQuery("#id_detailInfoWindowContainer").window("close");
		     loadMask.show();
	         var rowData = getTracywindyObject("id_table").getRowDataAt(globalSetRowIndex);
	         var url = "${pageContext.request.contextPath}/acl/updateRejectQueryCondition.acl";
	         var params = {
	    	          id             :rowData["id_"],
	    	          queryConditions:queryConditions
	         };
	         ajaxRequest({
	              url:url,
	              params:params,
	              timeout:30*1000,
	              success:function(res){
	        	      getTracywindyObject("id_table").reload();
	        	      alert("设置成功");
	                  loadMask.hide();
	              }
	         });
	   }
</script>
</head>
<body>
	<div id='menu_main_content' style="float:left;width:325px;overflow:hidden;border:1px solid #DDD;border-top:0px;border-right:0px;padding:5px;">
	   <div class="panel-title" >流程列表</div>
       <div id="id_menu_tabs_menu" style="border:1px solid #DDD;border-top:0px;overflow:auto;padding:5px;"  ></div>
	</div>
	<div id='menu_main_oper' style="overflow:hidden;float:left;border:1px solid #DDD;border-left:0px;border-top:0px;padding:5px;">
	   <div class="panel-title" ><font color="red" id="id_userSelectContainer"></font>&nbsp;&nbsp;互斥流程列表</div>
	   <div id='id_menu_main_content_div' style="border:1px solid #DDD;border-top:0px;overflow:hidden;padding:5px;"></div>
	</div>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="互斥条件" style="display:none;width:500px;height:220px;padding-top:20px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:98%">
			            <tr><td class="input_label_desc">互斥条件：</td>  
			            <td class="input_value">
				            <textarea id="id_rejectQueryConditions" style="height:60px;width:280px;overflow:auto;"></textarea>
				            <span  class="content-required" >*</span>
			            </td></tr>
			            <tr class="content-separator">
				            <td colspan='2'>
				                 <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='setRejectConditions();'><span>确定</span></a>
						         <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
				            </td>
			            </tr>
			        </table>
		        </form>
	        </center>
	</div>
	<script type='text/javascript'>
	    var heightAdd = -2;
	    var widthAdd  = -348;
		jQuery("#menu_main_content").css("height",(pageHeight+heightAdd)+"px");
		jQuery("#id_menu_tabs_menu").css("height",(pageHeight+heightAdd-40)+"px");
		jQuery("#id_menu_main_content_div").css("height",(pageHeight+heightAdd-31)+"px");
		
		jQuery("#menu_main_oper").css("height",(pageHeight+heightAdd)+"px");
		jQuery("#menu_main_oper").css("width",(pageWidth + widthAdd)+"px");
	</script>
</body>
</html>
