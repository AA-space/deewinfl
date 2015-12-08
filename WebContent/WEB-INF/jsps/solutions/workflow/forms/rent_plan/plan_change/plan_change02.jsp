<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<c:set var="business_type" value="${requestScope['business_type']}"/>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
var isSubTable = false;
isViewHistoryTask=true;//直接设置整个表单只读
</script>

<!--多行控件  -->
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan=4><!-- 插入合同基本信息 --> <jsp:include
			page="../../contract/contract_approval/contract_base_info.jsp"></jsp:include></td>
	</tr>
	

	<tr>
		<td colspan=4></td>
	</tr>
	<tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
			<!-- 标签栏 -->
			<div id='id_project_info_tabs_content' style="">
					<div title="租金计划变更">
					    <span class="print-tabs-title-content">租金计划变更</span>
					    <div id="id_table_leasing_rent_plan_chang_content"	style="overflow: hidden;">
							<jsp:include page="../../rent_reckon/rent_adjust/main.jsp"></jsp:include>	
						</div>
					</div>
					<div title="租金计划变更原因及内容">
						<span class="print-tabs-title-content">租金计划变更原因及内容</span>
						<div id="id_table_leasing_rent_plan_reason_content"	style="overflow: hidden;">
							<jsp:include page="plan_reason_content.jsp"></jsp:include>	
						</div>
					</div>	
					
			</div>
		</td>
	</tr>
</table>
</div>
<!--避免在tabs中的js重复执行-->

<script>
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_project_info_tabs_content").tabs();
		isSubTable = true;
	});
</script>
