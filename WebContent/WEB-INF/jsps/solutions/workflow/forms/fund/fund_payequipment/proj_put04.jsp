<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
   var isSubTable = false;
   isViewHistoryTask = true;
   isNeedBank = false;
   isNeedBankEdit = false;
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		//if(!checkTracywindyTableData("table_id_table_leasing_contract_fund_payment_now_container","本次投放信息")){return false;}  
		//var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		//var isPassed = Validator.Validate(submitProcessedForm,1,false);
		//return isPassed;
		return true;
	}
	
</script>				
<!--多行控件  -->
<input type="hidden" id="id_json_contract_premise_str" name="json_contract_premise_str" value='${empty json_contract_premise_str ? "[]" : json_contract_premise_str }'/> <!-- 前提条件 -->
<input type="hidden" id="id_json_leasing_delivery_plan_str" name="json_leasing_delivery_plan_str" value='${empty json_leasing_delivery_plan_str ? "[]" : json_leasing_delivery_plan_str }'/> <!-- 投放计划 -->
<input type="hidden" id="id_json_fundfundcharge_str" name="json_fundfundcharge_str" value='${empty json_fundfundcharge_str ? "[]" : json_fundfundcharge_str }'/> <!-- 资金收款明细 -->
<input type="hidden" id="id_json_contract_fund_payment_history_str" name="json_contract_fund_payment_history_str" value='${empty json_contract_fund_payment_history_str ? "[]" : json_contract_fund_payment_history_str }'/> <!-- 历史付款明细 -->
<input type="hidden" id="id_json_contract_fund_payment_now_str" name="json_contract_fund_payment_now_str" value='${empty json_contract_fund_payment_now_str ? "[]" : json_contract_fund_payment_now_str }'/> <!-- 本次投放明细 -->

<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan=4><!-- 插入合同基本信息 --> <jsp:include
			page="../../contract/contract_approval/contract_base_info.jsp"></jsp:include></td>
	</tr>
	
	<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-project-business-condition"></div>
		项目商务条件</td>
	</tr>
	<tr>
		<td colspan=4></td>
	</tr>
	<tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
			<!-- 标签栏 -->
			<div id='id_project_info_tabs_content' style="">
					<div title="前提条件">
					    <span class="print-tabs-title-content">前提条件</span>
						<div id="id_table_leasing_contract_premise_container" style="overflow: hidden;"></div>
					</div>
					
						
					<div title="投放计划">
						<span class="print-tabs-title-content">投放计划</span>
						<div id="id_table_leasing_delivery_plan" style="overflow: hidden;"></div>
					</div>	
				    
				    
	               <div title="资金收款明细">
						<span class="print-tabs-title-content">资金收款明细</span>
						<div id="id_table_leasing_funds_collection_details" 	style="overflow: hidden;"></div>
					</div>
					
					<div title="本次投放明细">
						<span class="print-tabs-title-content">本次投放明细</span>
						<div id="id_table_leasing_contract_fund_payment_now_container"
							style="height: 350px;">
						</div>
					</div>
					
						<div title="已投放明细">
						<span class="print-tabs-title-content">已投放明细</span>
						<div id="id_table_leasing_contract_fund_payment_history_container"
							style="overflow: hidden;"></div>
					</div>
					<div title="租金发票类型">
						<span class="print-tabs-title-content">租金发票类型</span>
							<jsp:include page="../../contract/contract_approval/contract_invoice_type.jsp"></jsp:include>
					</div>
			</div>
		</td>
	</tr>
</table>
</div>
<!--避免在tabs中的js重复执行-->


<jsp:include page="../../contract/contract_approval/contract_premise_info.jsp"></jsp:include> <!-- 前提条件 -->
<jsp:include page="funds_collection_details.jsp"></jsp:include> <!-- 资金收款明细 -->

<jsp:include page="delivery_plan.jsp"></jsp:include> <!-- 投放计划 -->
<jsp:include page="fund_payment_history.jsp"></jsp:include> <!-- 已投放明细 -->
<jsp:include page="proj_put_this_deewinfl.jsp"></jsp:include> <!-- 本次投放明细 -->

<script>
//隐藏域在提交或保存前的赋值
function fillHiddenVal() {
	var currentTable1 = getTracywindyObject('table_id_table_leasing_contract_premise_container');
	jQuery('#id_json_contract_premise_str').val(
			JsonUtil.encode(currentTable1.getRowsJsonData())); //前提条件 
	
	var currentTable2 = getTracywindyObject('table_id_table_leasing_delivery_plan');
	jQuery('#id_json_leasing_delivery_plan_str').val(
			JsonUtil.encode(currentTable2.getRowsJsonData())); //投放计划
			
	var currentTable3 = getTracywindyObject('table_leasing_funds_collection_details'); //资金收款明细
	jQuery('#id_json_fundfundcharge_str').val(
			JsonUtil.encode(currentTable3.getRowsJsonData()));
	
	var currentTable4 = getTracywindyObject('table_id_table_leasing_contract_fund_payment_now_container'); //本次投放明细
	jQuery('#id_json_contract_fund_payment_now_str').val(
			JsonUtil.encode(currentTable4.getRowsJsonData()));
	
	var currentTable5 = getTracywindyObject('table_id_table_leasing_contract_fund_payment_history_container'); //已投放明细
	jQuery('#id_json_contract_fund_payment_history_str').val(
			JsonUtil.encode(currentTable5.getRowsJsonData()));
	
}


	var isSubTable = true;
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_project_info_tabs_content").tabs();
		isSubTable = false;
	});
</script>
