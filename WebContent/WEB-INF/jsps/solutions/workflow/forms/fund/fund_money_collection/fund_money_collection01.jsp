
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
   var isSubTable = true;
   //isViewHistoryTask = true;
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack() {
		//var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		//alert(Validator);
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		if(!checkTracywindyTableData("table_id_table_leasing_delivery_plan","本次回笼租金明细")){return false;}  
		if(!checkFundCharge()){return false;};
		var submitProcessedForm = document
				.getElementById("id_submitProcessedForm");
		//var isPassed = Validator.Validate(submitProcessedForm,1,false);
		//return isPassed;
		if(!checkLimit()){return false;};
		return true;
	}
	
</script>
<!-- 本次实收 -->
<input  type="hidden" id="id_json_receivercharge_str" name="json_receivercharge_str" value='${empty json_receivercharge_str ? "[]" : json_receivercharge_str }'/>
<input  type="hidden" id="id_json_fund_limit_str" name="json_fund_limit_str" value='${empty json_fund_limit_str ? "[]" : json_fund_limit_str }'/>

<div class="fillTableContainer">

	<table class="fillTable" cellspacing="0" cellpadding="0">
		<tr>
			<td colspan=4 class="td-even-line-separator">&nbsp;</td>
		</tr>
		<tr>
			<td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr_ebank_info"></div>网银信息</td>
		</tr>
		<tr class="tr_ebank_info">
			<td colspan=4>
				<!-- 网银信息--> 
				<jsp:include page="../fund_collection/fund_ebankdata.jsp"></jsp:include>
		</tr>
		<tr id="fund_money_collectioninfo" style="display: none">
			<td colspan=4>
				<!-- 未付设备款明细 --> 
				<jsp:include page="fund_money_collectioninfo.jsp"></jsp:include></td>
		</tr>
	<!--	<tr>
			<td colspan=4 class="td-even-line-separator">&nbsp;</td>
		</tr>
		 <tr>
			<td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr_project_info"></div>未回收资金明细</td>
		</tr> -->
	<!-- 	<tr class="tr_project_info">
			<td colspan=4>
				未回收资金明细

			</td>
		</tr> -->
		<tr>
			<td colspan=4 class="td-even-line-separator">&nbsp;</td>
		</tr>
		<tr>
			<td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr_project"></div>本次实收资金明细</td>
		</tr>
		<tr class="tr_project">
			<td colspan=4>
				<!-- 本次实收资金明细 -->
				<div id="id_table_leasing_delivery_plan"><jsp:include page="fund_money_info.jsp"></jsp:include></div>
			</td>
		</tr>
		
		<tr>
			<td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr_limit"></div>额度管理</td>
		</tr>
		<tr class="tr_limit">
			<td colspan=4>
				<!-- 额度管理 -->
				<div id="id_table_limit_container"><jsp:include page="fund_limit.jsp"></jsp:include></div>
			</td>
		</tr>
	</table>
</div>
<div id="id_table_leasing_contract_fund_payment_now_container" style="display: none;">
	<jsp:include page="fund_money_detail.jsp"></jsp:include>
</div>
<script>
	var isSubTable = true;
	if(!isViewHistoryTask){
		$("#fund_money_collectioninfo").show();
	}
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_project_info_tabs_content").tabs();
		isSubTable = false;
		var d = $("#id_project_info_tabs_content");
		//$("#id_project_fund_rent_plan_tabs_content").css("width",
		//		(formWidth) + "px");
		//$("#id_project_fund_rent_plan_tabs_content").tabs();
		//jQuery(".fillTableContainer").css("width",formWidth+"px");
	});
	

	function fillHiddenVal() {
		//本次实收
		var currentTable1 = getTracywindyObject('table_id_table_leasing_delivery_plan');
		jQuery('#id_json_receivercharge_str').val(JsonUtil.encode(currentTable1.getRowsJsonData()));
		//保存额度
		var currentTable2 = getTracywindyObject('table_id_table_limit_container');
		jQuery('#id_json_fund_limit_str').val(JsonUtil.encode(currentTable2.getRowsJsonData()));
		
	}
</script>
