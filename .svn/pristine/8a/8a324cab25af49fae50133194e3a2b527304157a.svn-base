<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<!-- 特殊附件显示公用方法 -->
<jsp:include page="../../util/proj_view_file.jsp"></jsp:include>
<!-- 项目立项附件带到租前业务相关流程 -->
<jsp:include page="initFileListParams.jsp"></jsp:include>

<script type="text/javascript">
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack() {
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		return isPassed;
	}
	var isSubTable = true;
	var isViewHistoryTask = true;
</script>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	 <tr>
		<td colspan=4><jsp:include page="../contract_approval/contract_base_info.jsp"></jsp:include></td>
	</tr>
		<tr class="x-panel-table-div-title">
			<td class="x-panel-table-div-title" colspan=4>
				<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-business-condition"></div> 合同起租后变更
			</td>
		</tr>
		<tr>
		<td colspan=4></td>
	</tr>
	 <tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
		<div id='id_project_info_tabs_content' style="">
		<div title="承租人变更">
			<div id="id_table_leasing_contract_rent_type_container" style="overflow: hidden;">
			   <jsp:include page="contract_person_change.jsp"></jsp:include>
			</div>
		</div>
		<div title="租赁物件变更">
				<div id="id_table_leasing_contract_other_container"	style="overflow: hidden;">
					<jsp:include page="contract_equip_container_main02.jsp" flush="true"/>
				</div>
			</div>
		<div title="担保单位变更">
					<div id="id_table_leasing_contract_fund_charge_container"	style="overflow: hidden;">
					<jsp:include page="contract_guarantee_method_main02.jsp" flush="true"/>    
					</div>
				</div>
		</div>
		</td>
	</tr>   
</table>
</div>

<script>
	function fillHiddenVal() {
		var contractEquip = getTracywindyObject('table_id_table_leasing_contract_equip_container_new');//租赁物件
		jQuery('#id_json_contract_equip_new_str').val(JsonUtil.encode(contractEquip.getRowsJsonData()));
		var contractGuaranteeMethod = getTracywindyObject('table_id_table_leasing_contract_guarantee_method_container_new');//担保
		jQuery('#id_json_contract_guarantee_method_new_str').val(JsonUtil.encode(contractGuaranteeMethod.getRowsJsonData()));
	}
	var isSubTable = true;
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_project_info_tabs_content").tabs();
		isSubTable = false;
		var d = $("#id_project_info_tabs_content");
		$("#id_project_fund_rent_plan_tabs_content").css("width",(formWidth) + "px");
		$("#id_project_fund_rent_plan_tabs_content").tabs();
	});
</script>
