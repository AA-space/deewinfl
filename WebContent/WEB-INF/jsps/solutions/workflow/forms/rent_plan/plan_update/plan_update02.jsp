<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<c:set var="business_type" value="${requestScope['business_type']}"/>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
var isSubTable = false;
isViewHistoryTask=true;//直接设置整个表单只读
//是否保存   
function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
{
	return true;
}
//保存成功提交后，后台返回
function saveCallBack() {
	return true;
}
//是否提交    
function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
{
	var submitProcessedForm = document.getElementById("id_submitProcessedForm");
	var isPassed = Validator.Validate(submitProcessedForm,1,false);
	if(!isPassed){return isPassed;}
	return true;
}
</script>
<!--多行控件  -->
<input type="hidden" id="fundrentadjustcontract" name="fund_rent_adjust.contract"  value='${requestScope["fund_rent_adjust.contract"]}'/>
<input type="hidden" id="fundrentadjustcontractid" name="fund_rent_adjust.contractid"  value='${requestScope["fund_rent_adjust.contractid"]}'/>
<input type="hidden" id="fundrentadjustdocid" name="fund_rent_adjust.docid"  value='${requestScope["fund_rent_adjust.docid"]}'/>
<input type="hidden" id="fundrentadjustadjusttype" name="fund_rent_adjust.adjusttype"  value='${requestScope["fund_rent_adjust.adjusttype"]}'/>
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
					<div title="租金计划修改">
					    <span class="print-tabs-title-content">租金计划修改</span>
					    <div id="id_table_leasing_rent_plan_mod_content"	style="overflow: hidden;">
							<jsp:include page="../../rent_reckon/rent_update/main_now.jsp"></jsp:include>	
						</div>
					</div>
					<div title="租金计划[原]">
					    <span class="print-tabs-title-content">租金计划[原]</span>
					    <div id="id_table_leasing_rent_plan_mod_content"	style="overflow: hidden;">
							<jsp:include page="../../rent_reckon/rentOld/main.jsp"></jsp:include>	
						</div>
					</div>
					<div title="租金计划变更原因及内容">
						<span class="print-tabs-title-content">租金计划变更原因及内容</span>
						<div id="id_table_leasing_rent_plan_reason_content"
							style="overflow: hidden;">
							<jsp:include page="../plan_change/plan_reason_content.jsp"></jsp:include>
							</div>
					</div>	
					
			</div>
		</td>
	</tr>
</table>
</div>

<script>
var isSubTable = true;
//初始化调用
jQuery(function() {
	//########公共JS事件##########
	jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
	$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
	$("#id_project_info_tabs_content").tabs();
	isSubTable = false;
	var d = $("#id_project_info_tabs_content");
});
function submitByPlanUpdate(){
}
function formPageReadOnlyCallBack(obj){
	if(!isCompletedTask){
		jQuery('#btn_rent_cal').hide();//禁用现表单中的租金测算按钮
		getTracywindyObject('table_id_table_leasing_rent_plan_container').disabledToolsByText("租金测算");
	}
}
</script>
