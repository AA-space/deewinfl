<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div class="fillTableContainer">
<table class="fillTable" cellspacing="0" cellpadding="0">
	<tr class="tr-contractect-word-info tr-odd">
             <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contractect-word-list"></div>合同清单</td>
    </tr>
	<tr class="tr-contractect-word-list">
		<td class="td-content" colspan=6>
			<div id="id_table_leasing_contract_list_container"	style="overflow: hidden;">
				<jsp:include page="contract_list_info.jsp"></jsp:include><%--合同清单 --%>
			</div>
		</td>
	</tr>
</table>
</div>