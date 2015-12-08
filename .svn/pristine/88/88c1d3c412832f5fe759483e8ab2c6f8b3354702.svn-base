<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->

<%@page import="com.kernal.utils.DateUtil"%><jsp:include page="../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
<!-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script> -->
<script type="text/javascript">
//var isViewHistoryTask = true;
//全局变量说是这一个只读业页
isViewHistoryTask = true;
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
		fillHiddenVal();
		return true;
	}
</script>
<input type="hidden" id="id_pranayama_to_roll_back_the_record_str" name="json_pranayama_to_roll_back_the_record_str" value="${requestScope['json_pranayama_to_roll_back_the_record_str'] }">
<input type="hidden" id="id_adjustid" name="adjustid" value="${requestScope['adjustid'] }">
<input type="hidden" id="id_docid" name="docid" value="${requestScope['docid'] }">

<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan=4>
			<!-- 央行利率信息 --> 
			<jsp:include page="../transfer_interest/the_bank_information.jsp"></jsp:include> 
		</td>
	</tr>
	
	<tr>
	<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>

		<tr class="tr-contract-business-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
			<div id='id_contract_condition_tabs_content' style="">
			
		<div title="已调息可回滚记录列表">
		<span class="print-tabs-title-content">已调息可回滚记录列表</span>
		<div id="id_table_already_regulating_of_breathing_container" style="overflow: hidden;">
		<jsp:include page="already_regulating_of_breathing_list.jsp"></jsp:include>
		</div>
		
		</div>
		<div title="本次回滚列表">
		<span class="print-tabs-title-content">本次回滚列表</span>
		
		<div id="id_table_pranayama_to_roll_back_the_record_container" style="overflow: hidden;">
		<jsp:include page="pranayama_to_roll_back_the_record_list.jsp"></jsp:include>
		</div>
		</div>
		</div>
		</td>
	</tr>
</table>
</div>

<!--避免在tabs中的js重复执行-->


  
<script>
var isSubTable = true;
//隐藏域在提交或保存前的赋值
function fillHiddenVal() {
	/*获取待调息数据
	 var currentTable1 = getTracywindyObject('id_table_leasing_todo_regulating_of_breathing_container_table');
	jQuery('#id_json_current_regulating_of_breathing_str').val(
		JsonUtil.encode(currentTable1.getRowsJsonData()));
	
	//获取已调息数据
	 var currentTable2 = getTracywindyObject('id_table_leasing_already_regulating_of_breathing_container');
	jQuery('#id_json_current_regulating_of_breathing_str').val(
		JsonUtil.encode(currentTable2.getRowsJsonData()));*/
	
	  //获取本次调息数据
	  var currentTable3 = getTracywindyObject('id_table2');
	jQuery('#id_pranayama_to_roll_back_the_record_str').val(
		JsonUtil.encode(currentTable3.getRowsJsonData()));
	var datas = currentTable3.getRowsJsonData();
	var tempData = "";
	var selectedDatas = [];
	for(var i=0;i<datas.length;i++){
		var currentData = datas[i];
		selectedDatas.push({
			adjust_contractid:currentData["id"],
			docid:currentData["docid"],
			faictid:currentData["faictid"]
			
		});
	}
	jQuery('#id_pranayama_to_roll_back_the_record_str').val(
			JsonUtil.encode(selectedDatas));

	//alert("本次调息数据："+jQuery("#id_json_current_regulating_of_breathing_str").val());

	
}


jQuery(function() {


	//########公共JS事件##########
	jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
	$("#id_contract_condition_tabs_content").css("width", (formWidth) + "px");
	$("#id_contract_condition_tabs_content").tabs();
	isSubTable = false;
	var d = $("#id_contract_condition_tabs_content");
	
});


</script>
