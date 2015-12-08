<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>

<input type="hidden" id="id_json_contract_equip_str" name="json_contract_equip_str" value='${empty json_contract_equip_str ? "[]" : json_contract_equip_str }'></input>
<input type="hidden" id="id_json_contract_equip_new_str" name="json_contract_equip_container_new_str" value='${empty json_contract_equip_container_new_str ? "[]" : json_contract_equip_container_new_str }'></input>


<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	
 	<tr>
           <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contract-plan-condition"></div>原租赁物件</td>
    </tr>
	<tr class="tr-contract-plan-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
			<div id="id_table_leasing_contract_equip_container"	style="overflow: hidden;">
				<c:if test="${'bussiness_type_car' eq business_type}">
					<jsp:include page="contract_equip_detail.jsp" />
				</c:if>
				<c:if test="${'bussiness_type_equip' eq business_type}">
				<jsp:include page="../../nocar/nocar_public/thing_detail.jsp"></jsp:include>
				</c:if>
			</div>
		</td>
	</tr>
	
	<tr>
           <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contract-plan-condition1"></div>现租赁物件</td>
    </tr>
	<tr class="tr-contract-plan-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
			<div id="id_table_leasing_contract_equip_container_new"	style="overflow: hidden;">
			    <c:if test="${'bussiness_type_car' eq business_type}">
					<jsp:include page="contract_equip_detail_now.jsp"/>
				</c:if>
				<c:if test="${'bussiness_type_equip' eq business_type}">
				<jsp:include page="../../nocar/nocar_public/thing_detail.jsp"></jsp:include>
				</c:if>
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