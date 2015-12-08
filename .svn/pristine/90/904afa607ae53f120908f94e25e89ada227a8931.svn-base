<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
   var isSubTable = true;
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
		if(!checkTracywindyTableData("table_id_table_leasing_contract_fund_payment_now_container","本次投放信息")){return false;} 
		var submitProcessedForm = document
				.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return false;};
		return true;
	}
	
</script>				
<!--多行控件  -->
<input type="hidden" id="id_json_fundfundcharge_str" name="json_fundfundcharge_str" value='${empty json_fundfundcharge_str ? "[]" : json_fundfundcharge_str }'/> <!-- 未付设备款明细 -->
<input type="hidden" id="id_json_contract_fund_payment_now_str" name="json_contract_fund_payment_now_str" value='${empty json_contract_fund_payment_now_str ? "[]" : json_contract_fund_payment_now_str }'/> <!-- 本次付款明细 -->
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
   <tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" >
		    <jsp:include page="fund_money_collectioninfo.jsp"/>
		</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" >
			<div class="toggle-icon-expanded" title="折叠"	toggleClass="tr-project-equip-fund-charge"></div>本次设备款付款计划
		</td>
	</tr>
	<tr class="tr-project-equip-fund-charge">
		<td  >
			<div id="id_table_leasing_funds_collection_details">
				<jsp:include page="funds_collection_details.jsp"/>
			</div>
		</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" >
			<div class="toggle-icon-expanded" title="折叠"	toggleClass="tr-project-equip-fund-charge-this"></div>本次付款明细
		</td>
	</tr>
	<tr class="tr-project-equip-fund-charge-this">
		<td >
			<div id="id_table_leasing_contract_fund_payment_now_container">
				<jsp:include page="proj_put_this.jsp"/>
			</div>
		</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" >
			<div class="toggle-icon-expanded" title="折叠"	toggleClass="tr-project-equip-fund-charge-memo"></div>投放说明
		</td>
	</tr>
	<tr class="tr-project-equip-fund-charge-memo">
		<td>
		   <jsp:include page="delivery_plan.jsp"/>
		</td>
	</tr>
</table>
</div>
<jsp:include page="fund_fund_plan_details.jsp"/>
<script type="text/javascript">
//隐藏域在提交或保存前的赋值
    function fillHiddenVal() {
    	//本次付款明细
		var currentTable1 = getTracywindyObject('table_id_table_leasing_contract_fund_payment_now_container');
		jQuery('#id_json_contract_fund_payment_now_str').val(
				JsonUtil.encode(currentTable1.getRowsJsonData()));
		var currentTable1 = getTracywindyObject('table_id_table_leasing_funds_collection_details');
		jQuery('#id_json_fundfundcharge_str').val(
				JsonUtil.encode(currentTable1.getRowsJsonData()));
        }
	var isSubTable = true;
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		isSubTable = false;
		});
	
</script>
