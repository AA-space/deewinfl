<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<input type="hidden" id="id_json_contract_guarantee_method_str" name="json_contract_guarantee_method_str"	value='${empty json_contract_guarantee_method_str ? "[]" : json_contract_guarantee_method_str }'/>
<input type="hidden" id="id_json_contract_guarantee_method_new_str" name="json_contract_guarantee_method_new_str"	value='${empty json_contract_guarantee_method_new_str ? "[]" : json_contract_guarantee_method_new_str }'/>


<div class="fillTableContainer">
	<table class="fillTable" cellspacing="0" cellpadding="0">

		<tr>
			<td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contract-plan-condition4"></div>原担保信息</td>
		</tr>
		<tr class="tr-contract-plan-condition4">
			<td class="td-tabs-container" style="text-indent: 0px;">
				<div id="id_table_leasing_contract_guarantee_method_container" style="overflow: hidden;">
					<jsp:include page="contract_guarantee_method.jsp" />
				</div>

			</td>
		</tr>

		<tr>
			<td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contract-plan-condition5"></div>现担保信息</td>
		</tr>
		<tr class="tr-contract-plan-condition5">
			<td class="td-tabs-container" style="text-indent: 0px;">

				<div id="id_table_leasing_contract_guarantee_method_container_new" style="overflow: hidden;">
					<jsp:include page="contract_guarantee_method_new.jsp" />
				</div>

			</td>
		</tr>
	</table>
</div>
<script>
	//初始化调用
	jQuery(function() {
		$("#id_contract_condition_plan_tabs_content").css("width", (formWidth) + "px");
		$("#id_contract_condition_plan_tabs_content").tabs();
	});
</script>