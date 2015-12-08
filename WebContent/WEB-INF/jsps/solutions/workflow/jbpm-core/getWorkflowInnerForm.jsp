<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<%@ taglib prefix="fn"  uri="/WEB-INF/tlds/fn.tld" %> 
<%@ taglib prefix="fmt" uri="/WEB-INF/tlds/fmt.tld" %>
<%@ taglib prefix="spring" uri="/WEB-INF/tlds/spring.tld"%>
<div  style="display:block;" id="id_toggle_tabs_form">
	   <!--表单页签1开始-->
	   <!--表单处理-->
	   <div style="" id="id_workflowFormContainer">
		 <div  id="id_workflowFormContainer_inner" style="width:100%;overflow-y:scroll;">
		   <iframe name="real_submit_frame" style="display:none;" id="id_real_submit_frame"></iframe>
		   <form  id="id_submitProcessedForm" enctype="multipart/form-data" target="real_submit_frame" action="{pageContext.request.contextPath}/submitProcessedForm/jbpm/submitProcessedForm.action" method="post">
			   <!-- 流程提交隐藏域 -->
			   <jsp:include page="getWorkflowFormHiddenField.jsp"></jsp:include>
			   <!-- 当前任务节点表单路径相对于jbpm-core/forms下的jsp页面 -->
			   <jsp:include page="/${empty requestFormPath ? 'errorPages/error404.bi' : requestFormPath }" flush="true"></jsp:include>
			   <script type="text/javascript">
			  		jQuery("#id_loadMaskContainer").hide();
			   </script>
		   </form>
		 </div>
		 <script>
		      jQuery("#id_workflowFormContainer_inner").css("width",(all_width-containerWidthAdd-10)+"px");
			  jQuery("#id_workflowFormContainer_inner").css("height",(all_height-containerHeightAdd-1)+"px");
			  jQuery(".x-panel-table-toolbar-div").css("width",(all_width-containerWidthAdd)+"px");
			  jQuery(".x-panel-table-div-title").css("width",(all_width-containerWidthAdd)+"px");
			  jQuery("#id_toggle_tabs_advise .x-panel-table-div-title").css("width",(all_width-containerWidthAdd-20)+"px");
			  jQuery("#id_toggle_tabs_attachment .x-panel-table-div-title").css("width",(all_width-containerWidthAdd-20)+"px");
			  jQuery("#id_content_tabs .tabs-header").css("width",(all_width-containerWidthAdd+1)+"px");
	    </script>
	  </div>
</div>