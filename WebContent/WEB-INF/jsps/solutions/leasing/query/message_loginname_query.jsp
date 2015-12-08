<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当前登录人可见-站内信消息查询</title>
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
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
	<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	</style>
<script type="text/javascript">
//流程历史信息

	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
		var mynotice = new tracywindyOperationTable({
	   		 tableComment:'[站内信消息查询]',
	   	     border:true,
	   	     title:'站内信消息查询',
	         operButtons:'',
	         renderTo:'id_mynotice_list',
	         width:pageWidth,
	         height:pageHeight,
	         id:'id_table_mynotice_list',
	         xmlFileName:'/eleasing/jsp/base/messagenoticeInfo.xml',
	         loadMode:'ajax',
	         isPage:true,
	         isFit:true,
	         isExcel:true,
	         isAutoBreakContent:true,
	         tools:[
	                /*
	                {
	        	    iconCls:'icon-cancel',
	        	    html:'<font color="blue">定期删除</font>',
	        	    handler:function(table)
	        	    { 
	        	    	jQuery("#id_message_list").show();
	        	    	jQuery("#id_message_list").window({
	        	    		top:10
	        	    	});
	        	    	jQuery("#id_message_list").window("open");
	        	    	table.reload();
	        	    }
	         },
	         */
	         {
	        	    iconCls:'icon-ok',
	        	    html:'<font color="blue">批量标记为已读</font>',
	        	    handler:function(table)
	        	    { 
	        	    	var param ={};
	                    param.fieldname = document.getElementById("id_queryWorkflowsTableInput").value;
	                    $.ajax({
	            			type : "post",
	            			url : getRootPath()+"/leasing/checkBathInfo.action",
	            			cache : false,
	            			async : false,
	            			data : param,
	            			success : function(rs) 
	            			{
	            			   var svote=rs;
	            			   svote=svote.replace(/(^\s+)|(\s+$)/g, ""); 
	            				if (svote!="") 
	            				{
	            					if ( rs == "yes" )
	           						{
	            					   alert("标记已读成功!");
	            					   table.reload();
	           						}
	            					else{
	            						alert(rs);
	            					}
	            				}
	            			}
	            		});
	        	    	
	        	    }
	         },{
	        	  isHtml:true,
	     	      html:'请输入登陆编码：<input type="text" readOnly style="margin-right:3px;border:1px solid #DDD;" id="id_queryWorkflowsTableInput" value="'+'${sessionScope.loginUser.username}'+'" />'
	         }], 
	         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'bid',name:'bid',hidden:true},
		            {header:'正文',name:'msgtext',hidden:true},
		            {header:'主题',name:'msgtitle',queryConfig:{}},
		            {header:'上报时间',name:'senddate',type:'date',isRange:true,queryConfig:{}},
		            {header:'接收人',name:'js',queryConfig:{}},
		            {header:'登陆编码',name:'bm'},
		            {header:'状态',name:'readstatus'},
		            {header:'上报人',name:'realname'}
	        ],
	        params:{
			     USER_ID:'${sessionScope.loginUser.id}'
			}
	   	 });
   });

</script>

</head>
<body>
	<div id="id_mynotice_list"></div>
	<div id="id_message_list" style="width: 420px; display: none; overflow: hidden;" title="选择删除日期">
		<table>
			<tr>
			<td class="td-content-title">从：</td>
			<td class="td-content">
			<input id="startdate" name="startdate" class="Wdate td-content-input td-content-readonly" type="text"  onClick="WdatePicker(this,{readOnly:true})" readOnly/>
			</td>
			<td class="td-content-title">到：</td>
			<td class="td-content">
			<input id="enddate" name="enddate" class="Wdate td-content-input td-content-readonly"type="text"  onClick="WdatePicker(this,{readOnly:true})" readOnly/>
			</td>
			</tr>
			<tr><td colspan="4"></tr><tr><td colspan="4"></tr><tr><td colspan="4"></tr>
			<tr>
				<td colspan="4" style="text-align:center">
					<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='confirmData();'><span>确定</span></a>
					<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_message_list").window("close");'><span>取消</span></a>
				</td>
			</tr>
	 </table>
	</div>
	<script type="text/javascript">
	
	function confirmData()
	{
		var param ={};
        param.startdate = document.getElementById("startdate").value;
        param.enddate = document.getElementById("enddate").value;
        if ( param.startdate > param.enddate )
       	{
           alert("开始时间不能大于结束时间!");
       	   return false;
       	}
        $.ajax({
			type : "post",
			url : getRootPath()+"/leasing/checkMessageInfo.action",
			cache : false,
			async : false,
			data : param,
			success : function(rs) 
			{
			   var svote=rs;
			   svote=svote.replace(/(^\s+)|(\s+$)/g, ""); 
				if (svote!="") 
				{
					if ( rs == "yes" )
					{
					   alert("删除成功!");
					   jQuery("#id_message_list").window("close");
		               getTracywindyObject("id_table_mynotice_list").reload();
					}
					else{
						alert("输入的时间有误!");
					}
				}
			}
		});
		
	}
	
	</script>
</body>
</html>