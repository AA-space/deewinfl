<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表组件测试</title>
    <!--css sheet-->
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/my97DatePicker/skin/WdatePicker.css"/>
	<style type="text/css">
	  html,bode{
	    overflow:hidden;
	  }
	</style>
	<!--javascript libray-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
	//上传函数结束
     jQuery(function(){
         var all_width  =  Math.max(document.documentElement.clientWidth,document.body.clientWidth);
         var all_height = Math.max(document.documentElement.clientHeight,document.body.clientHeight);
       //任务
   	    var jobsTable = new tracywindyTable({
		   renderTo:"id_jobContainer",
		   id:'id_jobsTable',
		   width:all_width-2,
		   height:all_height-1,
		   isShortPage:true,
		   title:'调度任务',
		   xmlFileName:'/quartz/queryAllJobs.xml',
		   loadMode:'ajax',
		   columns:[{
			   header:'任务名称',name:'job_name',hidden:true
		   },{
			   header:'任务描述',name:'description'
		   },{
			   header:'任务CLASS',name:'job_class_name'
		   },{
			   header:'',renderer:function(value,tableObj,columnName,columnIndex,rowData){
                   var modify = "<a href='javascript:void(0);' onclick='modifyJob("+rowData.rowIndex+")'>修改</a>";
                   var del = "<a href='javascript:void(0);' onclick='removeJob(\""+rowData['job_name']+"\")'>删除</a>";
                    return modify+"&nbsp;&nbsp;&nbsp;&nbsp;"+del;
    			 }
		   }],
		   isFit:true,
		   border:true,
		   pageSize:20,
		   isShortPage:true,
		   border:true,
		   isRank:true,
		   isPage:false,
		   tools:[{
              html:'<font color="red">新增任务</font>',
              iconCls:'icon-plus',
              handler:function(table){
                   addJob();
              }
		   }],
		   callBack:function(){
    	   }
		});
     });
     function resetJob()
     {
    	 jQuery("#id_jobName").val("");
    	 jQuery("#id_description").val("");
    	 var comboQuartzJob = getTracywindyObject("combo_quartzJob");
    	 //jQuery("#id_jobClassName").val("");
         //	 loadComplete
    	 comboQuartzJob.setValue("");
      	 comboQuartzJob.reload();
     }
     function addJob()
     {
	    	resetJob();
	  	    jQuery("#id_quartzJobDetailInfoForm").show();
			jQuery("#id_quartzJobDetailInfoForm").window({
	    	zIndex:9000,
	    	draggable:true,
	    	top:50,
	    	resizable:true,
	    	shadow:true,
	    	modal:true,
	    	inline:false,
	    	collapsible:false,
	    	minimizable:false,
	    	maximizable:false,
	    	closable:true,
	    	closed:false
	    });
     }
     function modifyJob(rowIndex)
     {
    	 resetJob();
         var rowData = getTracywindyObject('id_jobsTable').getRowDataAt(rowIndex);
    	 jQuery("#id_jobName").val(rowData['job_name']);
    	 jQuery("#id_description").val(rowData['description']);
    	 var comboQuartzJob = getTracywindyObject("combo_quartzJob");
    	 comboQuartzJob.setValue(rowData['job_class_name']);
    	 //jQuery("#id_jobClassName").val(rowData['job_class_name']); 
 	     jQuery("#id_quartzJobDetailInfoForm").show();
			jQuery("#id_quartzJobDetailInfoForm").window({
        	zIndex:9000,
        	draggable:true,
        	top:50,
        	resizable:true,
        	shadow:true,
        	modal:true,
        	inline:false,
        	collapsible:false,
        	minimizable:false,
        	maximizable:false,
        	closable:true,
        	closed:false
        });
     }
     var loadMask = null;  
     function doQuartzJobOperation()
     {
    	 var jobName = jQuery("#id_jobName").val();
    	 var description = jQuery("#id_description").val();
    	 //var jobClassName = jQuery("#id_jobClassName").val();
         var comboQuartzJob = getTracywindyObject("combo_quartzJob");
         jobClassName =  comboQuartzJob.getValue();
    	 //if(!jobName){alert("任务名称不能为空");return;}
    	 if(!description){alert("任务描述不能为空");return;}
    	 if(!jobClassName){alert("任务执行CLASS不能为空");return;}

    	 var params = {};
    	 params['jobName'] = jobName;
    	 params['description'] = description;
    	 params['jobClassName'] = jobClassName;

    	 if(!loadMask)
    	 {
        	 loadMask = new tracywindyLoadMask(document.body,"操作进行中  请稍后...");
         }
    	 jQuery("#id_quartzJobDetailInfoForm").window("close");
    	 loadMask.show();
		 ajaxRequest({
	   		     url:'${pageContext.request.contextPath}/quartz/saveOrUpdateJob.action',
	   		     method:'POST',
	   		     success:function(res){
	   		    	alert("操作成功");
	   		    	loadMask.hide();
	   		    	getTracywindyObject("id_jobsTable").reload();
	   		     },
	   		     failure:function(res){
		   		    alert("操作失败");
	   		    	loadMask.hide();
		   		 },
	   		     params:params
  		 });
     }
     function removeJob(jobName)
     {
    	 if(!loadMask)
    	 {
        	 loadMask = new tracywindyLoadMask(document.body,"操作进行中  请稍后...");
         }
    	 loadMask.show();
		 ajaxRequest({
	   		     url:'${pageContext.request.contextPath}/quartz/removeJob.action',
	   		     method:'POST',
	   		     success:function(res){
	   		    	alert("操作成功");
	   		    	loadMask.hide();
	   		    	getTracywindyObject("id_jobsTable").reload();
	   		     },
	   		     failure:function(res){
		   		    alert("操作失败");
	   		    	loadMask.hide();
		   		 },
	   		     params:{
		   			jobName:jobName
		   		}
  		 });
     }
     jQuery(function(){
         //选择action
		   var combo_quartzJob = new tracywindyComboBox({
			   lazyLoad:true,
		       dropListHeight:200,
		       id:'combo_quartzJob',
		       width:352,
		       renderTo:'id_quartzJobContainer',
		       url:'${pageContext.request.contextPath}/quartz/getQuartzJobs.action',
		       loadMode:'ajax',
		       readOnly:true,
		       value:'',
		       displayField:'name',
		       valueField:'value',
		       params:{
		       }
		    }); 
    });
   </script>
</head>
<body>
    <div id="id_jobContainer"></div>
   <div id="id_quartzJobDetailInfoForm" closed="true" modal="true" title="调度任务" style="display:none;width:500px;height:200px;padding-top:10px;text-align:center;">
		        <center>
			        <div style="width:95%;">
				        <table align="center" style="width:100%">
				            <tr style='height:10px;'></tr>
				            <tr style="display:none;"><td class="input_label_desc">任务名称:</td><td class="input_value"><input type="text" id="id_jobName" /></td><td><span class="content-required">*</span></td></tr>
				            <tr><td class="input_label_desc">任务描述:</td><td class="input_value"><textarea  id="id_description" ></textarea></td><td><span class="content-required">*</span></td></tr>
				            <tr><td class="input_label_desc">任务CLASS:</td>
				            <td class="input_value" ><div id="id_quartzJobContainer"></div></td>
				            <td><span class="content-required">*</span></td></tr>
				            <tr class="content-separator">
				                <td colspan=3>
							        <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='doQuartzJobOperation();'><span>确定</span></a>
									<a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_quartzJobDetailInfoForm").window("close");'><span>取消</span></a>
					            </td>
				            </tr>
				        </table>
			        </div>
		        </center>
	  </div>
</body>
</html>