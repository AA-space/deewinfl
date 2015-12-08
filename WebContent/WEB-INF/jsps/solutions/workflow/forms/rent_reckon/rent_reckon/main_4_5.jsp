<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<c:set var="isShow" value="true"/>
<permission:action  code="cash_no_purview">
<c:set var="isShow" value="false"/>
</permission:action>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<tr>
		<td ><%--商务条件 --%>
			<jsp:include page="condition_frame_4_5.jsp" flush="true"/>
	</td>
	</tr>
 	<tr>
           <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contract-plan-condition"></div>租金计划</td>
    </tr>
	<tr class="tr-contract-plan-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
			<div id='id_contract_condition_plan_tabs_content' style="">
				<div title="租金计划">
					<div id="id_table_leasing_rent_plan_container"	style="overflow: hidden;">
						<jsp:include page="fund_rent_plan_frame.jsp" flush="true"/>
					</div>
				</div>
				<c:if test="${'true' eq isShow}"><%--经销商不显示该页签 --%>
				<div title="现金流">
					<div id="id_table_leasing_fund_cash_flow_container"	style="overflow: hidden;">
						<jsp:include page="fund_cash_plan_frame.jsp" flush="true"/>
					</div>
				</div>
				</c:if>
				<div title="资金收付计划">
					<div id="id_table_leasing_fund_fund_charge_container"	style="overflow: hidden;">
						<jsp:include page="fund_fund_plan.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</td>
	</tr>
	</table>
</div>
<c:if test="${'false' eq isShow}"><%--经销商不显示该页签,但是该多行控件还是必须要有 --%>
<div id="id_table_leasing_fund_cash_flow_container"	style="overflow: hidden;display: none;">
	<jsp:include page="fund_cash_plan_frame.jsp" flush="true"/>
</div>
</c:if>
<script>
	//初始化调用
	jQuery(function() {
		$("#id_contract_condition_plan_tabs_content").css("width", (formWidth) + "px");
		$("#id_contract_condition_plan_tabs_content").tabs();
	});
</script>