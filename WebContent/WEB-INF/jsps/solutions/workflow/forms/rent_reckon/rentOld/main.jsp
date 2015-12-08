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
			<c:if test="${'bussiness_type_car' eq business_type}">
				<jsp:include page="condition_frame.jsp" flush="true"/>
			</c:if>
			<c:if test="${'bussiness_type_equip' eq business_type}">
				<jsp:include page="condition_frame_4_5.jsp" flush="true"/>
			</c:if>
	</td>
	</tr>
 	<tr>
           <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contract-plan-old-condition"></div>租金计划[原]</td>
    </tr>
	<tr class="tr-contract-plan-old-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
			<div id='id_contract_condition_plan_tabs_content_old' style="">
				<div title="租金计划">
					<div id="id_table_leasing_rent_plan_container_old"	style="overflow: hidden;">
						<jsp:include page="fund_rent_plan_frame.jsp" flush="true"/>
					</div>
				</div>
				<c:if test="${'true' eq isShow}"><%--经销商不显示该页签 --%>
				<div title="现金流">
					<div id="id_table_leasing_fund_cash_flow_container_old"	style="overflow: hidden;">
						<jsp:include page="fund_cash_plan_frame.jsp" flush="true"/>
					</div>
				</div>
				</c:if>
			</div>
		</td>
	</tr>
	</table>
</div>
<c:if test="${'false' eq isShow}"><%--经销商不显示该页签,但是该多行控件还是必须要有 --%>
<div id="id_table_leasing_fund_cash_flow_container_old"	style="display: none;">
	<jsp:include page="fund_cash_plan_frame.jsp" flush="true"/>
</div>
</c:if>
<script>
	//初始化调用
	jQuery(function() {
		$("#id_contract_condition_plan_tabs_content_old").css("width", (formWidth) + "px");
		$("#id_contract_condition_plan_tabs_content_old").tabs();
	});
</script>