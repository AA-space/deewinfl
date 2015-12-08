
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<style type="text/css">
<!--
#red {
	color: #F00;
}
-->
</style>
<%@page import="com.kernal.utils.DateUtil"%><jsp:include page="../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
<!-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script> -->
<script type="text/javascript">
//var isViewHistoryTask = true;
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
<input type="hidden"  id="id_json_current_regulating_of_breathing_str" name="json_current_regulating_of_breathing_str" value='${empty json_current_regulating_of_breathing_str ? "[]" : json_current_regulating_of_breathing_str }'/>
<div class="fillTableContainer">

   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr  id="fund_standard_interest">
		<td >
		<!-- 央行利率信息 --> 

			<jsp:include page="the_bank_information.jsp"></jsp:include>

			</td>
	</tr>
	
	<tr>
	<td  class="td-even-line-separator">&nbsp;</td>
	</tr>

		<tr class="tr-contract-business-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
			<div id='id_contract_condition_tabs_content' style="">
			
		<div title="待调息">
		<span class="print-tabs-title-content">待调息</span>
		<div id="id_table_leasing_todo_regulating_of_breathing_container" style="overflow: hidden;">
			<jsp:include page="todo_regulating_of_breathing.jsp"></jsp:include> <!-- 待调息 -->
		</div>
		
		</div>
		<div title="已调息">
		<span class="print-tabs-title-content">已调息</span>
		<div id="id_table_leasing_already_regulating_of_breathing_container" style="overflow: hidden;">
			<jsp:include page="already_regulating_of_breathing.jsp"></jsp:include> <!-- 已调息 -->
		</div>
		</div>
			
		<div title="本次调息">
		<span class="print-tabs-title-content">本次调息</span>
		<div id="id_table_leasing_current_regulating_of_breathing_container" style="overflow: hidden;">
			<jsp:include page="current_regulating_of_breathing.jsp"></jsp:include> <!-- 本次调息 -->
		</div>
		</div>
		
		</div>
		</td>
	</tr>
	<tr class="tr-tx-info tr-even">
	   <td class="td-content-title" >
	   	调息操作记录
	   </td>
	</tr>
	<tr class="tr-tx-info tr-even">
	   <td class="td-content-title" >
	   		<input type="hidden" id="id_adjust_contractids" name="adjust_contractids" value="${requestScope['adjust_contractids'] }">
	   		<input type="hidden" id="id_adjustid" name="adjustid" value="${requestScope['adjustid'] }">
	   		<input type="hidden" id="id_docid" name="docid" value="${requestScope['docid'] }">
	   		<textarea style="width:98.9%;height:250px;float:left;" id="tx_text_memo" class="td-content-input td-content-readonly" readOnly name="tx_text_memo" >${requestScope['tx_text_memo'] }</textarea>
	   </td>
	</tr>
</table>
</div>
<div id="id_station_message" buttons="#id-dlg-buttons"  closed="true" modal="true" title="操作反馈" style="display:none;width:800px;height:400px;">
   <center>
	       <div id="msg_memo">
	       
	       </div>
   </center>
</div>
<div style="text-align:center;width:800px;display:none;" id="id-dlg-buttons">
   <a  style="margin-left:20px;margin-top:5px;" href="javascript:void(0);" class="btn btn-primary" onclick='msgButton()'><span id="msgButtonText">取消</span></a>
</div>
<script>

var isSubTable = true;
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
	  var currentTable3 = getTracywindyObject('id_table_leasing_current_regulating_of_breathing_container');
	jQuery('#id_json_current_regulating_of_breathing_str').val(
		JsonUtil.encode(currentTable3.getRowsJsonData()));
	var datas = currentTable3.getRowsJsonData();
	var selectedDatas = [];
 
	for(var i=0;i<datas.length;i++){
		var currentData = datas[i];
		selectedDatas.push({
			adjust_contractid:currentData["id"],
			docid:currentData["docid"],
			faictid:currentData["faictid"]
			
		});
	}
	//tempData = tempData+'{"adjust_contractid":\""+datas[i]["id"]+"\",\"docid\":\""+datas[i]["docid"]+"\"},';

	jQuery('#id_json_current_regulating_of_breathing_str').val(
			JsonUtil.encode(selectedDatas));


	
}
jQuery(function() {
	//隐藏域在提交或保存前的赋值
	
	//########公共JS事件##########
	jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
	$("#id_contract_condition_tabs_content").css("width", (formWidth) + "px");
	$("#id_contract_condition_tabs_content").tabs();
	isSubTable = false;
	var d = $("#id_contract_condition_tabs_content");
});
</script>
