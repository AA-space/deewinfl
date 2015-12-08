<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<%@ taglib prefix="fn"  uri="/WEB-INF/tlds/fn.tld" %> 
<%@ taglib prefix="spring" uri="/WEB-INF/tlds/spring.tld"%>
<%@ taglib prefix="permission" uri="/WEB-INF/tlds/permission.tld"%>
 <!--提交按钮-->
 <div>
	<a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="if(window.confirm('确认关闭此流程页面么？')){closeWindow();}" plain="true" iconCls="icon-cancel"><spring:message code="Close"  text="关闭"/></a>
	<c:if test="${('true' ne isViewHistoryTask)}">
	    <c:set var="operationButtons" value="${currentTaskOperationButtons}"></c:set>
	    <c:if test="${('read' eq currentRequestTaskType)}">
	         <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="readOrSignatureOper('read');" plain="true" iconCls="icon-save"><spring:message code="ConfirmWorkflowRead"  text="已阅"/></a>
	         <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(readButtonDisplayText);" plain="true" iconCls="icon-save"><spring:message code="ContinueWorkflowRead"  text="继续传阅"/></a>
	    </c:if>
	    <c:if test="${('signature' eq currentRequestTaskType)}">
	    <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="readOrSignatureOper('signature');" plain="true" iconCls="icon-save"><spring:message code="ConfirmSignature"  text="会签确认"/></a>
	         <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(signatureButtonDisplayText);" plain="true" iconCls="icon-save"><spring:message code="ContinueSignature"  text="继续会签"/></a>
	    </c:if>
	    <c:if test="${('assignmentPending' eq currentRequestTaskType)}">
	        <c:if test="${fn:indexOf(operationButtons, 'save')>-1}">
				  <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(saveButtonDisplayText);" plain="true" iconCls="icon-save"><spring:message code="Save"  text="保存"/></a>
			</c:if>
	        <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(submitButtonDisplayText);" plain="true" iconCls="icon-ok"><spring:message code="Submit"  text="提交"/></a>
	    </c:if>
	    <c:if test="${('assignmentCompleted' eq currentRequestTaskType)}">
	        <c:if test="${fn:indexOf(operationButtons, 'save')>-1}">
				  <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(saveButtonDisplayText);" plain="true" iconCls="icon-save"><spring:message code="Save"  text="保存"/></a>
			</c:if>
	        <c:if test="${fn:indexOf(operationButtons, 'read')>-1}">
				  <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(readButtonDisplayText);" plain="true" iconCls="icon-save"><spring:message code="WorkflowRead"  text="传阅"/></a>
			</c:if>
			<c:if test="${fn:indexOf(operationButtons, 'signature')>-1}">
				  <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(signatureButtonDisplayText);" plain="true" iconCls="icon-sum"><spring:message code="Signature"  text="会签"/></a>
			</c:if>
			<!--提交-->
			<a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(submitButtonDisplayText);" plain="true" iconCls="icon-ok"><spring:message code="Submit"  text="提交"/></a>
			<c:if test="${fn:indexOf(operationButtons, 'back')>-1}">
				<a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(backButtonDisplayText);" plain="true" iconCls="icon-back"><spring:message code="Back"  text="退回"/></a>
			</c:if>
			<c:if test="${('true' eq isFirstTask )}">
				<a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(deleteButtonDisplayText);" plain="true" iconCls="icon-cancel"><spring:message code="Delete"  text="删除"/></a>
			</c:if>
			 <!-- 
			<c:if test="${('true' eq isFirstTask ) && !('Draft' eq  processInstanceState) }">
				<a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(abondonButtonDisplayText);" plain="true" iconCls="icon-cancel"><spring:message code="Abondon"  text="废弃"/></a>
			</c:if>
			-->
	    </c:if>
	    <c:if test="${('pending' eq currentRequestTaskType)||('delegate' eq currentRequestTaskType)}">
	       <c:if test="${fn:indexOf(operationButtons, 'save')>-1}">
				  <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(saveButtonDisplayText);" plain="true" iconCls="icon-save"><spring:message code="Save"  text="保存"/></a>
		   </c:if>
		   <c:if test="${('pending' eq currentRequestTaskType)}">
				<c:if test="${fn:indexOf(operationButtons, 'assignment')>-1}">
				  <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(assignmentButtonDisplayText);" plain="true" iconCls="icon-save"><spring:message code="Assignment"  text="工作指派"/></a>
				</c:if>
			</c:if>
			<c:if test="${fn:indexOf(operationButtons, 'read')>-1}">
				  <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(readButtonDisplayText);" plain="true" iconCls="icon-save"><spring:message code="WorkflowRead"  text="传阅"/></a>
			</c:if>
			<c:if test="${fn:indexOf(operationButtons, 'signature')>-1}">
				  <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(signatureButtonDisplayText);" plain="true" iconCls="icon-sum"><spring:message code="Signature"  text="会签"/></a>
			</c:if>
			<!--提交-->
				<a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(submitButtonDisplayText);" plain="true" iconCls="icon-ok"><spring:message code="Submit"  text="Submit"/></a>
			<c:if test="${fn:indexOf(operationButtons, 'back')>-1}">
				  <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(backButtonDisplayText);" plain="true" iconCls="icon-back"><spring:message code="Back"  text="Back"/></a>
			</c:if>
			<c:if test="${('true' eq isFirstTask )}">
				  <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(deleteButtonDisplayText);" plain="true" iconCls="icon-cancel"><spring:message code="Delete"  text="删除"/></a>
			</c:if>
			 <!-- 
			<c:if test="${('true' eq isFirstTask ) && !('Draft' eq  processInstanceState) }">
	              <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(abondonButtonDisplayText);" plain="true" iconCls="icon-cancel"><spring:message code="Abondon"  text="废弃"/></a>
			</c:if>
			-->
	    </c:if>
	    <c:if test="${(empty currentRequestTaskType)}">
	         <c:if test="${fn:indexOf(operationButtons, 'save')>-1}">
				  <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(saveButtonDisplayText);" plain="true" iconCls="icon-save"><spring:message code="Save"  text="保存"/></a>
			 </c:if>
		    <!--提交-->
			 <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(submitButtonDisplayText);" plain="true" iconCls="icon-ok"><spring:message code="Submit"  text="提交"/></a>
	         <c:if test="${('true' eq isFirstTask )}">
			    <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(deleteButtonDisplayText);" plain="true" iconCls="icon-cancel"><spring:message code="Delete"  text="删除"/></a>
			 </c:if>
			 <!-- 
			 <c:if test="${('true' eq isFirstTask ) && !('Draft' eq  processInstanceState) }">
				<a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="btn_callBack(abondonButtonDisplayText);" plain="true" iconCls="icon-cancel"><spring:message code="Abondon"  text="废弃"/></a>
			  </c:if>
			-->
	    </c:if>
	    <c:if test="${('pending' eq currentRequestTaskType)}">
			<permission:action code="admin_action">
		       <a style="margin-left:50px;" href="javascript:void(0);" class="easyui-linkbutton-btn" onclick='btn_callBack(resetRouteButtonDisplayText);' plain="true" iconCls="icon-department"><spring:message code="ResetRoute"  text="任意路由"/></a>
			</permission:action>
		</c:if>
	</c:if>
	<span id='id_btn_tools_container'></span>
	<a style="margin-left:50px;" href="javascript:void(0);" class="easyui-linkbutton-btn" onclick='toProcessActivePicture();' plain="true" iconCls="icon-department"><spring:message code="WorkflowDiagram"  text="流程图"/></a>
	<a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick='viewWorkflowHistoryDetail();' plain="true" iconCls="icon-globe"><spring:message code="HistoryInfo"  text="历史信息"/></a>
	<a id="id_viewProjSummary" href="javascript:void(0);" class="easyui-linkbutton-btn" onClick='viewProjSummary();' plain="true" iconCls="icon-track"><spring:message code="ProjectSummary"  text="项目总表"/></a>
	<!--
	<a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick='previewPrint();' plain="true" iconCls="icon-print"><spring:message code="PrintPreview"  text="打印预览"/></a>
	-->
	<div style="float:right;margin-right:50px;">
	   <a href="javascript:void(0);" class="easyui-linkbutton-btn" onClick="if(window.confirm('确认返回至系统首页么？')){jQuery('.loading-indicator').text('正在返回首页 请耐心等待');jQuery('#id_loadMaskContainer').show();window.top.location.href='${pageContext.request.contextPath}/acl/index.acl';}" plain="true" iconCls="icon-home">返回至系统首页</a>
	</div>
 </div>
 <permission:action  code="dealer_action"><script type="text/javascript">jQuery("#id_viewProjSummary").hide();</script></permission:action>
 <script type="text/javascript">jQuery(".easyui-linkbutton-btn").linkbutton({plain:true}).linkbutton('disable');</script>