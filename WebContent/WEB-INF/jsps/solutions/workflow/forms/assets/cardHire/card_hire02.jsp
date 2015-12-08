<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
<script type="text/javascript">
isViewHistoryTask = true;//全局变量说是这一个只读页面
function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
{
	fillHiddenVal();
	return true;
}

</script>
<input id="card_fail" name="card_fail" type="hidden"></input>
<table  cellspacing="0" cellpadding="0">
	<tr>
	    <td class="x-panel-table-div-title" ><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-cardetail-info"></div>本次卡扣基本信息</td>
	</tr>
	<tr class="tr-cardetail-info tr-odd">
	   <td class="td-content-title">
	   		<table width="100%"  cellspacing="0" cellpadding="0">
	   			<tr>
	   				<td>
	   				文件上传人
	   				</td>
	   				<td>
	   				<input name="cardhire.docid" id="cardhire.docid" type="hidden" value="${requestScope['cardhire.docid'] }"/>
	   				<input name="cardhire.docname" id="cardhire.docname" type="hidden" value="${requestScope['cardhire.docname'] }" class="td-content-input td-content-readonly" readOnly/>
	   				<input name="cardhire.uploadid" id="cardhire.uploaduser" type="hidden" value="${requestScope['cardhire.uploadid'] }" class="td-content-input td-content-readonly" readOnly/>
	   				<input name="cardhire.uploaduser" id="cardhire.uploaduser" type="text" value="${requestScope['cardhire.uploaduser'] }" class="td-content-input td-content-readonly" readOnly/>
	   				</td>
	   				<td>
	   				文件上传时间
	   				</td>
	   				<td>
	   				<input name="cardhire.uploaddate" id="cardhire.uploaddate" type="text" value="${requestScope['cardhire.uploaddate'] }" class="td-content-input td-content-readonly" readOnly/>
	   				</td>
	   				<td>
	   				总到账金额
	   				</td>
	   				<td>
	   				<input name="cardhire.incomemoneysum" id="cardhire.incomemoneysum" type="text" value="${requestScope['cardhire.incomemoneysum'] }" class="td-content-input td-content-readonly" readOnly/>
	   				</td>
	   				<td>
	   				总可用金额
	   				</td>
	   				<td>
	   				<input name="cardhire.lastmoneysum" id="cardhire.lastmoneysum" type="text" value="${requestScope['cardhire.lastmoneysum'] }" class="td-content-input td-content-readonly" readOnly/>
	   				</td>
	   			</tr>
	   		</table>
	   </td>
	</tr>
	<tr class="tr-cardetail-info tr-even">
	   <td class="td-content-title">
	   		<div id="id_tableContainer_rentincome"></div>
	   </td>
	</tr>
		<tr class="tr-cardetail-info tr-even">
		<td class="td-content-title">
			<div id="id_tableContainer_card_fail"></div>
		</td>
	</tr>
</table>
<jsp:include page="contract_card_income_temp_list.jsp"></jsp:include>
<jsp:include page="contract_card_fail_list.jsp"></jsp:include>
<script>
function fillHiddenVal() {
	var failCard = getTracywindyObject('id_tableContainer_card_fail_table');//租赁物件
	jQuery('#card_fail').val(JsonUtil.encode(failCard.getRowsJsonData()));
}
</script>