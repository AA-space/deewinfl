<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<tr>
		<td ><%--商务条件 --%>
			<c:if test="${'bussiness_type_car' eq business_type}">
				<jsp:include page="../rent_reckon/condition_frame.jsp" flush="true"/>
			</c:if>
			<c:if test="${'bussiness_type_equip' eq business_type}">
				<jsp:include page="../rent_reckon/condition_frame_4_5.jsp" flush="true"/>
			</c:if>
	</td>
	</tr>
 	<tr>
           <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contract-plan-condition"></div>租金计划</td>
    </tr>
	<tr class="tr-contract-plan-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
			<div id='id_contract_condition_plan_tabs_content' style="">
				<div title="租金计划">
					<span class="print-tabs-title-content">租金计划</span>
					<div id="id_table_leasing_rent_plan_container"	style="overflow: hidden;">
					<script language="javascript">
					jQuery(function() {isViewHistoryTask = isCompletedTask;});
					</script>
						<jsp:include page="fund_rent_plan_frame.jsp" flush="true"/>
					<script language="javascript">
						jQuery(function() {isViewHistoryTask = true;});
					</script>
					</div>
				</div>
				<div title="现金流">
					<span class="print-tabs-title-content">现金流</span>
					<div id="id_table_leasing_fund_cash_flow_container"	style="overflow: hidden;">
						<jsp:include page="../rent_reckon/fund_cash_plan_frame.jsp" flush="true"/>
					</div>
				</div>
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