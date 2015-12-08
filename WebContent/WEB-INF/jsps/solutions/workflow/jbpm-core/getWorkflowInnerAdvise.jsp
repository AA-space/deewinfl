<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<div id="id_toggle_tabs_advise">
		<div class="x-panel-table-div-title" >意见一览
		<c:if test="${'true' != isViewHistoryTask}"><a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"  onClick="javascript:showModalCommonAdivseWindow();">填写意见</a></c:if>
		</div>
		<div id="id_workflowAdviseContainer">
		</div>
</div>
<script type="text/javascript">
	jQuery("#id_workflowAdviseContainer").css("width",(all_width-containerWidthAdd)+"px");
	jQuery("#id_workflowAdviseContainer").css("height",(all_height-containerWidthAdd-124)+"px");
</script>