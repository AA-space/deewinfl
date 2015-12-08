<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<%@ taglib prefix="fn"  uri="/WEB-INF/tlds/fn.tld" %> 
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
	  html,body{
	    overflow:hidden;
	  }
	  .twoNumInput{
	     width:20px;
	     border:1px solid silver;
	     height:13px;
	     font-size:11px;
	  }
	  .fourNumInput{
	     width:60px;
	     border:1px solid silver;
	     height:14px;
	     font-size:11px;
	  }
	  .content-container{
	     padding:5px;
	     border:1px solid silver;
	     margin-top:5px;
	  }
	  input.commonCheck{
	     position:relative;
	     top:2px;
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
		//触发器
	    var triggersTable = new tracywindyTable({
			   renderTo:"id_triggerContainer",
			   id:'id_triggersTable',
			   width:all_width-2,
			   height:all_height-1,
			   isShortPage:true,
			   title:'调度触发器',
			   xmlFileName:'/quartz/queryAllTriggers.xml',
			   loadMode:'ajax',
			   columns:[{
				   header:'调度名称',name:'trigger_name',hidden:true
			   },{
				   header:'调度描述',name:'description'
			   },{
				   header:'任务名称',name:'job_name',hidden:true
			   },{
				   header:'任务名称',name:'job_description'
			   },{
				   header:'调度开始时间',name:'start_time',renderer:function(value,tableObj,columnName,columnIndex,rowData){
                   return getCurDateTime(new Date(parseInt(value)));
			      }
			   },{
				   header:'调度结束时间',name:'end_time',renderer:function(value,tableObj,columnName,columnIndex,rowData){
                   return getCurDateTime(new Date(parseInt(value)));
			      }
			   },{
				   header:'时间表达式',name:'cron_expression',renderer:function(value,tableObj,columnName,columnIndex,rowData){
                   return  "<a href='javascript:void(0);' onclick='showFlag = true;showCronWindow(\""+rowData['cron_expression']+"\",\"resume\")'>"+value+"</a>&nbsp;&nbsp;";;
			      }
			   },{
				   header:'调度状态',name:'trigger_state',renderer:function(value,tableObj,columnName,columnIndex,rowData){
                   var display = "";
                   switch(value)
                   {
                      case "ACQUIRED":{display = "运行";break;}
                      case "PAUSED":{display = "暂停";break;}
                      case "WAITING":{display = "等待";break;}
                   }
                   return display;
			      }
			   },{
				   header:'调度上次执行时间',name:'prev_fire_time',renderer:function(value,tableObj,columnName,columnIndex,rowData){
                   return getCurDateTime(new Date(parseInt(value)));
			      }
			   },{
				   header:'调度下次执行时间',name:'next_fire_time',renderer:function(value,tableObj,columnName,columnIndex,rowData){
                   return getCurDateTime(new Date(parseInt(value)));
			      }
			   },{
				   header:'',renderer:function(value,tableObj,columnName,columnIndex,rowData){
				       var resumeOper = "<a href='javascript:void(0);' onclick='triggerOper(\""+rowData['trigger_name']+"\",\"resume\")'>恢复</a>&nbsp;&nbsp;";
				       var pauseOper =  "<a href='javascript:void(0);' onclick='triggerOper(\""+rowData['trigger_name']+"\",\"pause\")'>暂停</a>&nbsp;&nbsp;";
				       var runOper =    "<a href='javascript:void(0);' onclick='triggerOper(\""+rowData['trigger_name']+"\",\"run\")'>立即执行</a>&nbsp;&nbsp;<br/>";
				       var modifyOper = "<a href='javascript:void(0);' onclick='modifyTrigger("+rowData['rowIndex']+")'>修改</a>&nbsp;&nbsp;";
				       var removeOper = "<a href='javascript:void(0);' onclick='triggerOper(\""+rowData['trigger_name']+"\",\"remove\")'>删除</a>";
		               switch(rowData['trigger_state'])
		               {
		                      case "ACQUIRED":resumeOper="";{runOper="";modifyOper="";removeOper="";break;}
		                      case "PAUSED":{pauseOper="";break;}
		                      case "WAITING":{resumeOper="";modifyOper="";break;}
		               }
	                   return resumeOper+pauseOper+runOper+modifyOper+removeOper;
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
	              html:'<font color="red">新增调度</font>',
	              iconCls:'icon-plus',
	              handler:function(table){
	            	  addTrigger();
	              }
			   }],
			   callBack:function(){
	    	   }
			});
		   var comboJobName = new tracywindyComboBox({
			   lazyLoad:true,
		       dropListHeight:200,
		       id:'id_comboJobName',
		       width:190,
		       renderTo:'id_comboJobContainer',
		       loadMode:'ajax',
		       readOnly:true,
		       xmlFileName:'/quartz/queryAllJobs.xml',
		       isCheck:false,
		       valueField:'job_name',
		       displayField:'description',
		       onSelect:function(combo){
		       }
		    });
	     }); 
     var loadMask = null;  
     function resetTrigger()
     {
    	 jQuery("#id_triggerName").val("");
    	 getTracywindyObject("id_comboJobName").setValue("");
    	 jQuery("#id_description").val("");
    	 jQuery("#id_cronExpression").val("");
    	 jQuery("#id_startDate").val("");
    	 jQuery("#id_durableDays").val("");
     }
     function addTrigger()
     {
    	 resetTrigger();
 	    jQuery("#id_quartzTriggerDetailInfoForm").show();
			jQuery("#id_quartzTriggerDetailInfoForm").window({
        	zIndex:9000,
        	draggable:true,
        	top:20,
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
     function modifyTrigger(rowIndex)
     {
    	 resetTrigger();
         var rowData = getTracywindyObject('id_triggersTable').getRowDataAt(rowIndex);
    	 jQuery("#id_triggerName").val(rowData["trigger_name"]);
    	 getTracywindyObject("id_comboJobName").setValue(rowData["job_name"]);
    	 jQuery("#id_description").val(rowData["description"]);
    	 jQuery("#id_cronExpression").val(rowData["cron_expression"]);
    	 
    	 
    	 var start_time = rowData["start_time"];
    	 var d1 = new Date(parseInt(start_time));
    	 jQuery("#id_startDate").val(getCurDateTime(d1));
    	 var end_time = rowData["end_time"];
    	 /*var s1 = start_time.substring(0,10).replace(/-/g, "/");
    	 var s2 = end_time.substring(0,10).replace(/-/g, "/");*/
    	 
    	 var days = parseInt((parseInt(end_time)-parseInt(start_time)) / (1000 * 60 * 60 * 24));
    	 jQuery("#id_durableDays").val(days);
 	     jQuery("#id_quartzTriggerDetailInfoForm").show();
			jQuery("#id_quartzTriggerDetailInfoForm").window({
        	zIndex:9000,
        	draggable:true,
        	top:20,
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
     function doQuartzTriggerOperation()
     {
    	 var triggerName  = jQuery("#id_triggerName").val();
    	 var jobName  = getTracywindyObject("id_comboJobName").getValue();
    	 var description  = jQuery("#id_description").val();
    	 var cronExpression  = jQuery("#id_cronExpression").val();
    	 var startDate  = jQuery("#id_startDate").val();
    	 var durableDays  = jQuery("#id_durableDays").val();
    	 
    	// if(!triggerName){alert("调度名称不能为空");return;}
    	 if(!description){alert("调度描述不能为空");return;}
    	 if(!cronExpression){alert("cron表达式不能为空");return;}
    	 if(!startDate){alert("调度开始时间不能为空");return;}
    	 if(!durableDays){alert("调度持续时间");return;}
    	 if(!jobName){alert("任务名称不能为空");return;}
    	 
    	 var dataMap = "";

    	 var params = {};
    	 params['triggerName'] = triggerName;
    	 params['jobName'] = jobName;
    	 params['description'] = description;
    	 params['cronExpression'] = cronExpression;
    	 params['startDate'] = startDate;
    	 params['durableDays'] = durableDays;
    	 
    	 if(!loadMask)
    	 {
        	 loadMask = new tracywindyLoadMask(document.body,"操作进行中  请稍后...");
         }
    	 jQuery("#id_quartzTriggerDetailInfoForm").window("close");
    	 loadMask.show();
		 ajaxRequest({
	   		     url:'${pageContext.request.contextPath}/quartz/saveOrUpdateTrigger.action',
	   		     method:'POST',
	   		     success:function(res){
	   		    	alert("操作成功");
	   		    	loadMask.hide();
	   		    	getTracywindyObject("id_triggersTable").reload();
	   		     },
	   		     failure:function(res){
		   		    alert("操作失败");
	   		    	loadMask.hide();
		   		 },
	   		     params:params
  		 });
     }
     function triggerOper(triggerName,flag)
     {
    	 if(!loadMask)
    	 {
        	 loadMask = new tracywindyLoadMask(document.body,"操作进行中  请稍后...");
         }
    	 loadMask.show();
		 ajaxRequest({
	   		     url:'${pageContext.request.contextPath}/quartz/'+flag+'Trigger.action',
	   		     method:'POST',
	   		     success:function(res){
	   		    	alert("操作成功");
	   		    	loadMask.hide();
	   		    	getTracywindyObject("id_triggersTable").reload();
	   		     },
	   		     failure:function(res){
		   		    alert("操作失败");
	   		    	loadMask.hide();
		   		 },
	   		     params:{
		   			triggerName:triggerName
		   		}
  		 });
     }
     showFlag = true;
   </script>
</head>
<body>
    <div id="id_triggerContainer"></div>
    <div id="id_quartzTriggerDetailInfoForm" closed="true" modal="true" title="调度任务" style="display:none;width:500px;height:250px;padding-top:10px;text-align:center;">
		        <center>
			        <div style="width:95%;">
				        <table align="center" style="width:90%">
				            <tr style='height:10px;'></tr>
				            <tr style="display:none;"><td class="input_label_desc" >调度名称:</td><td class="input_value"><input type="text" id="id_triggerName" /></td><td><span class="content-required">*</span></td></tr>
				            <tr><td class="input_label_desc">调度描述:</td><td class="input_value"><textarea  id="id_description" ></textarea></td><td><span class="content-required">*</span></td></tr>
				            <tr><td class="input_label_desc">cron表达式:</td><td class="input_value"><input  id="id_cronExpression" readonly onclick="showFlag = false;showCronWindow();"/></td><td><span class="content-required">*</span></td></tr>
				            <tr><td class="input_label_desc">调度开始时间:</td><td class="input_value"><input type="text" readonly id="id_startDate" class="Wdate"  onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td><td><span class="content-required">*</span></td></tr>
				            <tr><td class="input_label_desc">调度持续时间（天）:</td><td class="input_value"><input type="text" id="id_durableDays"/></td><td><span class="content-required">*</span></td></tr>
				            <tr><td class="input_label_desc">任务名称:</td><td class="input_value" id="id_comboJobContainer"></td><td><span class="content-required">*</span></td></tr>
				            <tr class="content-separator">
				                <td colspan=3>
							        <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='doQuartzTriggerOperation();'><span>确定</span></a>
									<a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_quartzTriggerDetailInfoForm").window("close");'><span>取消</span></a>
					            </td>
				            </tr>
				        </table>
			        </div>
		        </center>
	  </div>
	  
	      <div id="id_quartzCronDetailInfoForm" closed="true" modal="true" title="cron转换器" style="display:none;width:670px;padding-top:10px;">
		        <center>
			        <div style="width:95%;text-align:left;">
				        <table  style="width:90%" align="left">
				            <tr><td>
				                   <c:set var="sixty" value="0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59" ></c:set>
								    <c:set var="twentyFour" value="0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23" ></c:set>
								    <c:set var="thirtyOne" value="1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31" ></c:set>
								    <c:set var="twelve" value="1|2|3|4|5|6|7|8|9|10|11|12" ></c:set>
								    <c:set var="week" value="星期日|星期一|星期二|星期三|星期四|星期五|星期六" ></c:set>
								   	<div id="tt" class="easyui-tabs"  style="width:620px;height:250px;">
										<div title="秒"  style="padding:10px;">
										    <input name="cronSecond" value="per" type="radio" checked/>每秒都执行
											<br/>
										    <input name="cronSecond" value="cycle" type="radio"/>循环：
										        <div class="content-container">从第&nbsp;<input id="id_cronSecondStart" type="text" class="twoNumInput" value="0"/>&nbsp;秒开始，每隔&nbsp;<input id="id_cronSecondPer" type="text" class="twoNumInput"  value="1"/>&nbsp;秒执行。</div>
										    <input name="cronSecond" value="assigned" type="radio" />指定：
											    <div class="content-container">
												    <c:forTokens var="str" items="${sixty}" delims="|" varStatus="status">  
												         <input  name="checkbox_cronSecond" type="checkbox" value="${str}"/>${str}
												         <c:if test="${1 == fn:length(str)}">
												             &nbsp;
												         </c:if>
												    </c:forTokens>
											    </div>
										</div>
										<div title="分钟"  style="padding:10px;">
										    <input name="cronMinute" value="per" type="radio" checked/>每分钟都执行
											<br/>
										    <input name="cronMinute" value="cycle" type="radio" />循环：
										    	<div class="content-container">从第&nbsp;<input value="0" type="text" id="id_cronMinuteStart"  class="twoNumInput"/>&nbsp;分钟开始，每隔&nbsp;<input type="text" id="id_cronMinutePer"  class="twoNumInput" value="1" />&nbsp;分钟执行。</div>
										    <input name="cronMinute" value="assigned" type="radio" />指定：
											    <div class="content-container">
												    <c:forTokens var="str" items="${sixty}" delims="|" varStatus="status">  
												         <input  name="checkbox_cronMinute" type="checkbox" value="${str}"/>${str}
												         <c:if test="${1 == fn:length(str)}">
												             &nbsp;
												         </c:if>
												    </c:forTokens>
											    </div>
										</div>
										<div title="小时" style="padding:10px;">
										    <input name="cronHour" value="per" type="radio" checked/>每小时都执行
										    <br/>
										    <input name="cronHour" value="cycle" type="radio" />循环：
										    	<div class="content-container">从&nbsp;<input value="0" type="text" id="id_cronHourStart"  class="twoNumInput"/>&nbsp;时开始，每隔&nbsp;<input type="text" id="id_cronHourPer"  class="twoNumInput" value="1" />&nbsp;小时执行。</div>
										  	<input name="cronHour" value="assigned" type="radio" />指定：
											    <div class="content-container">
												    上午：<c:forTokens var="str" items="${twentyFour}" delims="|" varStatus="status"> 
												         <c:if test="${status.index == 12}">
												             <br/>下午：
												         </c:if> 
												         <input  name="checkbox_cronHour"  type="checkbox" value="${str}"/>${str}
												         <c:if test="${1 == fn:length(str)}">
												             &nbsp;
												         </c:if>
												    </c:forTokens>
											    </div>
										</div>
										<div title="天" style="padding:10px;">
										   <input name="cronPriority" value="day" type="radio" checked/>天优先（优先级高于&nbsp;<font color="red">星期</font>&nbsp;）
										   <div>
										        <input name="cronDay" value="per" type="radio" checked/>每天都执行
											   	<br/>
										        <input name="cronDay" value="cycle" type="radio" />循环：
										    	<div class="content-container">从第&nbsp;<input value="1" type="text" id="id_cronDayStart"  class="twoNumInput"/>&nbsp;天开始，每隔&nbsp;<input type="text" id="id_cronDayPer"  class="twoNumInput" value="1" />&nbsp;天执行。</div>  
											   	<input name="cronDay" value="assigned" type="radio" />指定：
												    <div class="content-container">
													    <c:forTokens var="str" items="${thirtyOne}" delims="|" varStatus="status">  
													         <input  name="checkbox_cronDay"   type="checkbox" value="${str}"/>${str}
													         <c:if test="${1 == fn:length(str)}">
													             &nbsp;
													         </c:if>
													    </c:forTokens>
												    </div>
										   </div>
										</div>
										<div title="月" style="padding:10px;">
										   	<input name="cronMonth" value="per" type="radio" checked/>每月都执行
											<br/>
										    <input name="cronMonth" value="cycle" type="radio" />循环：
										    	<div class="content-container">从&nbsp;<input value="1" type="text" id="id_cronMonthStart"  class="twoNumInput"/>&nbsp;月开始，每隔&nbsp;<input type="text" id="id_cronMonthPer"  class="twoNumInput" value="1" />&nbsp;月执行。</div>  
										   	<input name="cronMonth" value="assigned" type="radio" />指定：
											    <div class="content-container">
												    <c:forTokens var="str" items="${twelve}" delims="|" varStatus="status">  
												         <input  name="checkbox_cronMonth"  type="checkbox" value="${str}"/>${str}
												         <c:if test="${1 == fn:length(str)}">
												             &nbsp;
												         </c:if>
												    </c:forTokens>
											    </div>
										</div>
										<div title="星期" style="padding:10px;">
										    <input name="cronPriority" value="week" type="radio" />星期优先（优先级高于&nbsp;<font color="red">天</font>&nbsp;）
										    <div>
											    <input name="cronWeek" value="per" type="radio" checked/>每星期都执行
											   	<br/>
										        <input name="cronWeek" value="cycle" type="radio" />循环：
										    	<div class="content-container">从&nbsp;<select id="id_cronWeekStart">
										    	    <c:forTokens var="str" items="${week}" delims="|" varStatus="status">  
													         <option value="${status.index+1}" <c:if test="${0 == status.index}"></c:if>/>${str}</option>
													</c:forTokens>
										    	</select>&nbsp;开始，每隔&nbsp;<input type="text" id="id_cronWeekPer"  class="twoNumInput" value="1" />&nbsp;天执行。</div>  
											   	<input name="cronWeek" value="assigned" type="radio" />指定：
												    <div class="content-container">
													    <c:forTokens var="str" items="${week}" delims="|" varStatus="status">  
													         <input name="checkbox_cronWeek"  type="checkbox" value="${status.index+1}"/>${str}
													    </c:forTokens>
												    </div>
											 </div>
										</div>
										<div title="年" style="padding:10px;">
										   <input name="cronYear" value="per" type="radio" checked/>每年都执行
										   <br/>
										   <input name="cronYear" value="cycle" type="radio" />循环：
										       <div class="content-container">从&nbsp;<input value="*" type="text" id="id_cronYearStart"  class="fourNumInput"/>&nbsp;年开始，每隔&nbsp;<input type="text" id="id_cronYearPer"  class="twoNumInput" value="1" />&nbsp;年执行。</div>  
										   <input name="cronYear" value="assigned" type="radio" />指定年份（多个年份以<font color="red">英文逗号</font>隔开,形如：2012<font color="red">,</font>2013）：
											   <div class="content-container">
											      <textarea id="id_cronYear_assigned" style="overflow:hidden;border:transparent;width:100%;height:16px;"></textarea>
											   </div>
										   <input name="cronYear" value="period" type="radio" />时间段：
											   <div class="content-container">
											              选择：&nbsp;<input type="text" id="id_cronYearPeriodStart" class="fourNumInput"/>&nbsp;----&nbsp;<input type="text" id="id_cronYearPeriodEnd" class="fourNumInput"/>&nbsp;年 
											   </div>
										</div>
									</div>
				            </td></tr>
				            <tr class="content-separator">
				                <td colspan=3>
							        <a id='id_cronTriggerSubmit' style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='generateCron();'><span>确定</span></a>
									<a id='id_cronTriggerCancel' style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_quartzCronDetailInfoForm").window("close");'><span>取消</span></a>
					            </td>
				            </tr>
				        </table>
			        </div>
		        </center>
	  </div>
</body>
    <script type="text/javascript">
    function showCronWindow(tempCron)
    {
        var cronExpression = jQuery("#id_cronExpression").val();
        if(tempCron)
        {
        	cronExpression = tempCron;
        }
        if(!cronExpression)
        {
        	cronExpression = "* * * * * ? *";
        }
    	resolveCronExpressionToUI(jQuery,cronExpression);
        jQuery("#id_quartzCronDetailInfoForm").show();
    	jQuery("#id_quartzCronDetailInfoForm").window({
        	zIndex:9000,
        	draggable:true,
        	top:20,
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
        jQuery("#id_cronSecondStart").focus();
    }
    function generateCron()
    {
    	var cronExpression = resolveUIToCronExpression(jQuery);
    	if(cronExpression)
    	{
    	   jQuery("#id_cronExpression").val(cronExpression);
    	   jQuery("#id_quartzCronDetailInfoForm").window('close');
        }
    }
    function resolveUIToCronExpression($)
    {
        var cronExpression = "";
	   	var secondField = resolveUIToCronExpression_items($,"Second");
		var minuteField = resolveUIToCronExpression_items($,"Minute");
		var hourField   = resolveUIToCronExpression_items($,"Hour");
		var dayField    = resolveUIToCronExpression_items($,"Day");
		var monthField  = resolveUIToCronExpression_items($,"Month");
		var weekField   = resolveUIToCronExpression_items($,"Week");	
		var yearField   = resolveUIToCronExpression_items($,"Year");	
        if(!secondField || !minuteField || !hourField || !dayField|| !monthField || !weekField || !yearField)
        {
          return null;
        }    	
        cronExpression = secondField
        +" "+minuteField
        +" "+hourField
        +" "+dayField
        +" "+monthField
        +" "+weekField
        +" "+yearField;
       return cronExpression;
    }
    //解析秒开始
    function resolveCronExpressionToUI($,cronExpression)
    {
    	jQuery("#tt input[type='checkbox']").attr("checked",false);
    	if(showFlag){
    		jQuery("#id_cronTriggerSubmit").hide();
        	jQuery("#id_cronTriggerCancel").hide();
    	}else{
    		jQuery("#id_cronTriggerSubmit").show();
        	jQuery("#id_cronTriggerCancel").show();
    	}
    	
    	cronExpression = cronExpression.replace(/\s+/," ");
    	var splitFields = cronExpression.split(" ");
    	var secondField = splitFields[0];
    	var minuteField = splitFields[1];
    	var hourField = splitFields[2];
    	var dayField = splitFields[3];
    	var monthField = splitFields[4];
    	var weekField = splitFields[5];
    	resolveCronExpressionToUI_items($,"Second",secondField);
    	resolveCronExpressionToUI_items($,"Minute",minuteField);
    	resolveCronExpressionToUI_items($,"Hour",hourField);
    	resolveCronExpressionToUI_items($,"Day",dayField);
    	resolveCronExpressionToUI_items($,"Month",monthField);
    	resolveCronExpressionToUI_items($,"Week",weekField);
    	if(splitFields.length > 6)
    	{
    	  var yearField = splitFields[6];
    	  resolveCronExpressionToUI_items($,"Year",yearField);
        }
    }
    function resolveUIToCronExpression_items($,flag)
    {
        if(("Day"==flag)||("Week"==flag))
        {
            var cronPriorityVal = $("#tt input[name='cronPriority'][type='radio']:checked").val();
            if(flag.toLowerCase()!=cronPriorityVal)
            {
                return "?";
            }
        }
    	var selectedValues = "";
        var selectedItemVal = $("#tt input[name='cron"+flag+"'][type='radio']:checked").val();
        if("cycle"==selectedItemVal) {
            var cronItemStartVal = $("#id_cron"+flag+"Start").val();
            var cronItemPerVal = $("#id_cron"+flag+"Per").val();
            if(""==cronItemStartVal)
            {
                if(""==cronItemPerVal)
                {
                	selectedValues = "*";
                }
                else
                {
                	selectedValues = "*/"+cronItemPerVal;
                }
            }
            else
            {
                if(""==cronItemPerVal)
                {
                	selectedValues = cronItemStartVal;
                }
                else
                {
                	selectedValues = cronItemStartVal+"/"+cronItemPerVal;
                }
            }
        }
        else if("per"==selectedItemVal){
        	selectedValues = "*";
        }
        else if("assigned"==selectedItemVal){
            if("Year" == flag)
            {
            	var cronYearAssignedVal = $("#id_cronYear_assigned").val();
            	if(cronYearAssignedVal)
            	{
            		selectedValues = cronYearAssignedVal;
                }
            }
        	var isFirst = true;
            var selectedItemsCheckBox = $("#tt input[name='checkbox_cron"+flag+"'][type='checkbox']:checked");
            selectedItemsCheckBox.each(function(i){
                  if(!isFirst)
                  {
                	  selectedValues+=","; 
                  }
                  selectedValues+=this.value;
                  isFirst = false;
            });
        }
        else if("period"==selectedItemVal){
            var cronItemStartVal = $("#id_cron"+flag+"PeriodStart").val();
            var cronItemEndVal = $("#id_cron"+flag+"PeriodEnd").val();
            if(cronItemStartVal&&cronItemEndVal)
            {
            	selectedValues = cronItemStartVal+"-"+cronItemEndVal;
            }
            else if(!cronItemStartVal)
            {
            	alert("开始年份不能为空");
            	return null;
            }
            else if(!cronItemEndVal)
            {
            	alert("结束年份不能为空");
            	return null;
            }
        }
        var flagDisplay = "";
        switch(flag)
        {
           case "Second":{flagDisplay="秒";break;}
           case "Minute":{flagDisplay="分钟";break;}
           case "Hour":{flagDisplay="小时";break;}
           case "Day":{flagDisplay="天";break;}
           case "Month":{flagDisplay="月";break;}
           case "Week":{flagDisplay="星期";break;}
           case "Year":{flagDisplay="年";break;}
        }
        if("" == selectedValues)
        {
            alert("没有指定"+flagDisplay+"!");
            return null;
        }
        return selectedValues;
    }
    function resolveCronExpressionToUI_items($,flag,fieldValue)
    {
        if("*"==fieldValue)   
        {
        	$("#tt input[name='cron"+flag+"'][type='radio'][value='per']").attr("checked",true);
        }
        else if("?"==fieldValue)   
        {
        	$("#tt input[name='cronPriority'][type='radio'][value!='"+flag.toLowerCase()+"']").attr("checked",true);
        }
        else if(fieldValue.indexOf("/")>-1)
        {
        	$("#tt input[name='cron"+flag+"'][type='radio'][value='cycle']").attr("checked",true);
            var cronItemStartVal = fieldValue.split("/")[0];
            var cronItemPerVal   = fieldValue.split("/")[1];
            $("#id_cron"+flag+"Start").val(cronItemStartVal);
            $("#id_cron"+flag+"Per").val(cronItemPerVal);
        }
        else if(fieldValue.indexOf("-")>-1)
        {
        	$("#tt input[name='cron"+flag+"'][type='radio'][value='period']").attr("checked",true);
            var cronItemStartVal = fieldValue.split("-")[0];
            var cronItemEndVal   = fieldValue.split("-")[1];
            $("#id_cron"+flag+"PeriodStart").val(cronItemStartVal);
            $("#id_cron"+flag+"PeriodEnd").val(cronItemEndVal);
        }
        else
        {
        	$("#tt input[name='cron"+flag+"'][type='radio'][value='assigned']").attr("checked",true);
            if("Year" == flag)
            {
            	$("#id_cronYear_assigned").val(fieldValue);
                return;
            }
        	var selectedValues = fieldValue.split(",");
            var selectedItemsCheckBox = $("#tt input[name='checkbox_cron"+flag+"'][type='checkbox']");
            selectedItemsCheckBox.each(function(i){
                var isChecked = false;
                for(var i=0;i<selectedValues.length;i++)
                {
                   if( this.value == selectedValues[i])  
                   {
                	   isChecked = true;
                       break;
                   } 
                }
                this.checked = isChecked;
            });
        }
    }
	//上传函数结束
     jQuery(function(){
          jQuery("#tt input[type='radio']").addClass("commonCheck");
          jQuery("#tt input[type='checkbox']").addClass("commonCheck");
          jQuery("#id_cronYearStart").val(new Date().getFullYear());
     });
   </script>
</html>