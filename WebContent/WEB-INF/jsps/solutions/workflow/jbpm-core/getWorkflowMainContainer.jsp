<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
    <!--表单页签1开始-->
    <jsp:include page="getWorkflowInnerForm.jsp"></jsp:include>
	<!--审批意见页签2开始-->
	<jsp:include page="getWorkflowInnerAdvise.jsp"></jsp:include>
    <!--附件上传页签3开始-->
    <jsp:include page="getWorkflowInnerAttachment.jsp"></jsp:include>
</div><!--页签结束-->  