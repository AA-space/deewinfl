<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<%@ taglib prefix="fn"  uri="/WEB-INF/tlds/fn.tld" %> 
<%@ taglib prefix="spring" uri="/WEB-INF/tlds/spring.tld"%>
<%@ taglib prefix="fmt"  uri="/WEB-INF/tlds/fmt.tld" %>
<c:forEach items="${processedHistoryLogInfoList}" var="jbpmWorkflowHistoryInfo" varStatus="status">
	    <c:set var="historyTask" value="${jbpmWorkflowHistoryInfo.historyTaskInstanceImpl}"></c:set>
	    <c:set var="activityDetail" value="${jbpmWorkflowHistoryInfo.activityDetail}"></c:set>
	    <c:set var="fromButtonTextToCome" value="${jbpmWorkflowHistoryInfo.fromButtonTextToCome}"></c:set>
	    <c:set var="taskName" value="${activityDetail.activityName}"></c:set>
	    <c:set var="taskStartTime" value="${historyTask.startTime}"></c:set>
	    <c:set var="taskEndTime" value="${historyTask.endTime}"></c:set>
	    <c:set var="durationMinutes" value="${historyTask.duration/1000/60}"></c:set>
		<div class="taskname">
           <table><tr>
		    <td><strong>【<font color="red"><spring:message code="${fromButtonTextToCome}"  text="${fromButtonTextToCome}"/></font>】&nbsp;&nbsp;<a href="javascript:void(0);" onclick="toProcessForm('${historyTask.historyTask.id}')">${taskName}</a></strong></td>
                        <td>【开始时间】<fmt:formatDate value="${taskStartTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                        <td>【结束时间】<fmt:formatDate value="${taskEndTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                        <td>【耗时】<fmt:formatNumber value="${durationMinutes}" pattern="#.##" type="number"></fmt:formatNumber>&nbsp;分钟</td>
           </tr></table>
		</div>
		<div class="taskactor">
		<c:set var="planActorsStr" value=""></c:set>
		<c:set var="assignActorsStr" value=""></c:set>
		<c:set var="assignedActorsStr" value=""></c:set>
		<c:set var="assignProcessAdvisesStr" value=""></c:set>
		<c:set var="assignedProcessAdvisesStr" value=""></c:set>
		<c:set var="assignedEndTimesStr" value=""></c:set>
		<c:set var="finalProcessAdvisesStr" value=""></c:set>
		<fieldset class="historyFieldSet">
		<legend>处理信息：<a href="javascript:void(0);" onclick="javascript:fieldsetHidden(event);"><img src="${pageContext.request.contextPath}/images/arrowDown.gif"  border="0" align="absmiddle"/></a></legend>
		<table class="workflowTable" style="width:100%"><tr><td>【处理状态】</td><td>【计划处理人】</td><td>【实际处理人】</td><td>【处理时间】</td><td>【处理意见】</td></tr>
		<c:forEach items="${jbpmWorkflowHistoryInfo.jbpmWorkflowHistoryInfoUsers}" var="jbpmWorkflowHistoryInfoUser" varStatus="userStatus">
		 <c:set var="taskPlanActor" value="${jbpmWorkflowHistoryInfoUser.planActor}"></c:set>
	     <c:set var="taskActualActor" value="${jbpmWorkflowHistoryInfoUser.actualActor}"></c:set>
	     <c:set var="taskAssignActor" value="${jbpmWorkflowHistoryInfoUser.assignActor}"></c:set>
	     <c:set var="taskAssignedActor" value="${jbpmWorkflowHistoryInfoUser.assignedActor}"></c:set>
	     <c:set var="taskPlanActorRealName" value="${taskPlanActor.realname}"></c:set>
	     <c:set var="taskActualActorRealName" value="${taskActualActor.realname}"></c:set>
	     <c:set var="processedAdvise" value="${jbpmWorkflowHistoryInfoUser.processedAdvise}"></c:set>
	     
	     <c:if test="${!empty taskAssignActor}">
	        <c:set var="planActorsStr" value="${planActorsStr},${taskPlanActor.realname}"></c:set>
	        <c:set var="assignActorsStr" value="${assignActorsStr},${taskAssignActor.realname}"></c:set>
	        <c:set var="assignedActorsStr" value="${assignedActorsStr},${taskAssignedActor.realname}"></c:set>
	        <c:set var="assignProcessAdvisesStr" value="${assignProcessAdvisesStr},${jbpmWorkflowHistoryInfoUser.assignAdvise}"></c:set>
	        <c:set var="assignedProcessAdvisesStr" value="${assignedProcessAdvisesStr},${jbpmWorkflowHistoryInfoUser.assignedAdvise}"></c:set>
	        <c:set var="assignedEndTimesStr" value="${assignedEndTimesStr},${jbpmWorkflowHistoryInfoUser.endTime }"></c:set>
	        <c:set var="finalProcessAdvisesStr" value="${finalProcessAdvisesStr},${processedAdvise}"></c:set>
	     </c:if>
	          <tr>
	             <c:set var="currentColor" value="${empty jbpmWorkflowHistoryInfoUser.endTime ? 'red' : '' }"></c:set>
		      <th><font color="${currentColor}">${empty jbpmWorkflowHistoryInfoUser.endTime ? '未处理' : '已处理' }</font></th>
		      <th><font color="${currentColor}">${taskPlanActorRealName}</font></th>
		      <th><font color="${currentColor}">${taskActualActorRealName}</font></th>
		      <th><font color="${currentColor}">${jbpmWorkflowHistoryInfoUser.endTime}</font></th>
		      <th><font color="${currentColor}">${processedAdvise}</font></th>
		      </tr>
		</c:forEach>
		</table>
		</fieldset>
		
		<c:set var="tempVar" value=""></c:set>
		<c:set var="planActorsArray" value="${fn:split(planActorsStr,',')}"></c:set>
		<c:set var="assignActorsArray" value="${fn:split(assignActorsStr,',')}"></c:set>
		<c:set var="assignedActorsArray" value="${fn:split(assignedActorsStr,',')}"></c:set>
		<c:set var="assignProcessAdvisesArray" value="${fn:split(assignProcessAdvisesStr,',')}"></c:set>
		<c:set var="assignedProcessAdvisesArray" value="${fn:split(assignedProcessAdvisesStr,',')}"></c:set>
		<c:set var="assignedEndTimesArray" value="${fn:split(assignedEndTimesStr,',')}"></c:set>
		<c:set var="finalProcessAdvisesArray" value="${fn:split(finalProcessAdvisesStr,',')}"></c:set>
		<c:if test="${fn:length(assignActorsStr)>1}">
        <c:forEach items="${assignActorsArray}" var="assignActorStr" varStatus="userStatus">
		   <c:if test="${0 == userStatus.index}">
		        <fieldset class="historyFieldSet"><legend>工作指派：<a href="javascript:void(0);" onclick="javascript:fieldsetHidden(event);"><img src="${pageContext.request.contextPath}/images/arrowDown.gif"  border="0" align="absmiddle"/></a></legend>
		        <c:set var="tempVar" value="true"></c:set>	
				<table class="workflowTable" style="width:100%"><tr><th>【处理状态】</th><th>【指派人】</th><th>【被指派人】</th><th>【指派人意见】</th><th>【被指派人意见】</th><th>【处理时间】</th><th>【处理意见】</th></tr>
		   </c:if>
		   <c:if test="${0 <= userStatus.index}">
		   	<tr>
				          <c:set var="currentColor"  value="${empty assignedActorsArray[userStatus.index] ? 'red' : '' }"></c:set>
		      <td><font color="${currentColor}">${empty assignedActorsArray[userStatus.index] ? '未处理' : '已处理' }</font></td>
		      <td><font color="${currentColor}">${assignActorStr}</font></td>
		      <td><font color="${currentColor}">${empty assignedActorsArray[userStatus.index] ? planActorsArray[userStatus.index] : assignedActorsArray[userStatus.index]}</font></td>
		      <td><font color="${currentColor}">${assignProcessAdvisesArray[userStatus.index]}</font></td>
		      <td><font color="${currentColor}">${assignedProcessAdvisesArray[userStatus.index]}</font></td>
		      <td><font color="${currentColor}">${assignedEndTimesArray[userStatus.index]}</font></td>
		      <td><font color="${currentColor}">${finalProcessAdvisesArray[userStatus.index]}</font></td>
		     </tr>
		     </c:if>
         </c:forEach>
        <c:if test="${!empty tempVar}"></table></fieldset></c:if>		
		</c:if>
		<c:set var="tempVar" value=""></c:set>
		<c:forEach items="${jbpmWorkflowHistoryInfo.attachmentFileUploadInfoDetails}" var="attachmentFileUploadInfoDetail" varStatus="userStatus">
		   <c:if test="${0==userStatus.index}"><fieldset class="historyFieldSet"><legend>附件信息：<a href="javascript:void(0);" onclick="javascript:fieldsetHidden(event);"><img src="${pageContext.request.contextPath}/images/arrowDown.gif"  border="0" align="absmiddle"/></a></legend><c:set var="tempVar" value="true"></c:set>
		   <table class="workflowTable" style="width:100%"><tr><th>【附件名称】</th><th>【上传人】</th><th>【上传时间】</th></tr>
		   </c:if>
		   <tr>
		   <td><font color='red'>${attachmentFileUploadInfoDetail.chineseFileName}</font></td>
		   <td><font color='red'>${attachmentFileUploadInfoDetail.uploadUser.realname}</font></td>
		   <td><font color='red'>${attachmentFileUploadInfoDetail.uploadTime}</font></td>
		   </tr>
		</c:forEach>
		<c:if test="${!empty tempVar}"></table></fieldset></c:if>
		<c:set var="tempVar" value=""></c:set>
		<c:forEach items="${jbpmWorkflowHistoryInfo.jbpmWorkflowReadUsers}" var="jbpmWorkflowReadUser" varStatus="userStatus">
		   <c:if test="${0==userStatus.index}">
		   <fieldset class="historyFieldSet"><legend>传阅信息：<a href="javascript:void(0);" onclick="javascript:fieldsetHidden(event);"><img src="${pageContext.request.contextPath}/images/arrowDown.gif"  border="0" align="absmiddle"/></a></legend><c:set var="tempVar" value="true"></c:set>
		   <table class="workflowTable" style="width:100%"><tr><td>【传阅状态】</td><td>【传阅人】</td><td>【传阅意见】</td></tr>
		   </c:if>
		      <tr>
		      <c:set var="currentColor" value="${empty jbpmWorkflowReadUser.endTime ? 'red' : '' }"></c:set>
		      <th><font color="${currentColor}">${empty jbpmWorkflowReadUser.endTime ? '未查看' : '已查看' }</font></th>
		      <th><font color="${currentColor}">${jbpmWorkflowReadUser.readedActor.realname}</font></th>
		      <th><font color="${currentColor}">${jbpmWorkflowReadUser.readedAdvise}</font></th>
		      </tr>
		</c:forEach>
		<c:if test="${!empty tempVar}"></table></fieldset></c:if>
		<c:set var="tempVar" value=""></c:set>
		<c:forEach items="${jbpmWorkflowHistoryInfo.jbpmWorkflowSignatureUsers}" var="jbpmWorkflowSignatureUser" varStatus="userStatus">
		   <c:if test="${0==userStatus.index}"><fieldset class="historyFieldSet"><legend>会签信息：<a href="javascript:void(0);" onclick="javascript:fieldsetHidden(event);"><img src="${pageContext.request.contextPath}/images/arrowDown.gif"  border="0" align="absmiddle"/></a></legend><c:set var="tempVar" value="true"></c:set>
		   <table class="workflowTable" style="width:100%"><tr><td>【会签状态】</td><th>【会签人】</td><td>【会签意见】</td></tr>
		   </c:if>
		      <tr>
		      <c:set var="currentColor" value="${empty jbpmWorkflowSignatureUser.endTime ? 'red' : '' }"></c:set>
		      <th><font color="${currentColor}">${empty jbpmWorkflowSignatureUser.endTime ? '未完成' : '已完成' }</font></th>   
		      <th><font color="${currentColor}">${jbpmWorkflowSignatureUser.signaturedActor.realname}</font></th>
		      <th><font color="${currentColor}">${jbpmWorkflowSignatureUser.signaturedAdvise}</font></th>
              </tr>
		</c:forEach>
		<c:if test="${!empty tempVar}"></table></fieldset></c:if>
		</div>
	</c:forEach>