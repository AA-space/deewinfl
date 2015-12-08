
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
var isSubTable = true;
isViewHistoryTask = true;
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
		if(!checkFundCharge()){return false;};
		/* var submitProcessedForm = document
				.getElementById("id_submitProcessedForm"); */
		//var isPassed = Validator.Validate(submitProcessedForm,1,false);
		//return isPassed;
		return true;
	}
	
</script>
<!--多行控件  -->
<input type="hidden" id="id_json_payfundchargeplan_str" name="json_paychargeplan_str" value='${empty json_paychargeplan_str ? "[]" : json_paychargeplan_str }'/> <!-- 资金付款计划 -->
<input type="hidden" id="id_json_contract_fund_payment_history_str" name="json_contract_fund_payment_history_str" value='${empty json_contract_fund_payment_history_str ? "[]" : json_contract_fund_payment_history_str }'/> <!-- 历史付款明细 -->
<input type="hidden" id="id_json_contract_fund_payment_now_str" name="json_contract_fund_payment_now_str" value='${empty json_contract_fund_payment_now_str ? "[]" : json_contract_fund_payment_now_str }'/> <!-- 本次付款明细 -->


<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan=4><!-- 插入合同基本信息 --> <jsp:include
			page="../../contract/contract_approval/contract_base_info.jsp"></jsp:include></td>
	</tr>
	
	<tr>
	<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr>
		<td colspan=4></td>
	</tr>
	<tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
		<!-- 标签栏 -->
		<div id='id_project_info_tabs_content' style="">
		<div title="资金付款计划">
		<div id="id_table_leasing_json_paychargeplan_container"
			style="overflow: hidden;"></div></div>
		<div title="历史付款明细">
		<div id="id_table_leasing_contract_fund_payment_history_container"
			style="overflow: hidden;"></div>
		</div>
		<div title="本次付款明细">
		<div id="id_table_leasing_contract_fund_payment_now_container"
			style="overflow: hidden;"></div>
		</div>
		<div title="租金发票类型">
		<div id="id_table_leasing_contract_rent_type_container"	style="overflow: hidden;">
						<jsp:include page="../../contract/contract_approval/contract_invoice_type.jsp"></jsp:include>
		</div>
		</div>
		</div>
		</td>
	</tr>
</table>
</div>
<!--避免在tabs中的js重复执行-->
<jsp:include page="fund_paychargeplan.jsp"></jsp:include><%--资金付款计划 --%>
<jsp:include page="fund_payment_history.jsp"></jsp:include> <!-- 历史付款明细 -->
<jsp:include page="fund_payment_now.jsp"></jsp:include> <!-- 本次付款明细 -->
<script>
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		
		var currentTable1 = getTracywindyObject('table_id_table_leasing_json_paychargeplan_container');
		jQuery('#id_json_payfundchargeplan_str').val(
				JsonUtil.encode(currentTable1.getRowsJsonData()));
		var currentTable2 = getTracywindyObject('table_id_table_leasing_contract_fund_payment_history_container');
		jQuery('#id_json_contract_fund_payment_history_str').val(
				JsonUtil.encode(currentTable2.getRowsJsonData()));
		var currentTable3 = getTracywindyObject('table_id_table_leasing_contract_fund_payment_now_container');
		jQuery('#id_json_contract_fund_payment_now_str').val(
				JsonUtil.encode(currentTable3.getRowsJsonData()));

	}
	//生成项目名称
	//function createProjectName() {
	//	var project_name =jQuery('#project_name').val();
	//	var dept_name = getTracywindyObject('id_combo_proj_info.projDept')
	//			.getRawValue();
	//	var proj_id=$("#project_id").val();
	//	var cust_name=$("#cust_name").val();
	//	if (project_name == '') {
	//		project_name = proj_id+"-"+dept_name+"-"+cust_name + '项目';
	//	}
	//	jQuery('#project_name').val(project_name);
	//}
	var isSubTable = true;
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_project_info_tabs_content").tabs();
		isSubTable = false; //标志主页面加载完成
		var d = $("#id_project_info_tabs_content");
		//第二个页签集合
		//$("#id_project_fund_rent_plan_tabs_content").css("width",
		//		(formWidth) + "px");
		//$("#id_project_fund_rent_plan_tabs_content").tabs();
		//jQuery(".fillTableContainer").css("width",formWidth+"px");
	});
</script>
