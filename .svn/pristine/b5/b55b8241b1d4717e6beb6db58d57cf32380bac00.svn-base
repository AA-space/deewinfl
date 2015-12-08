<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		createProjectName();
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
		createProjectName();
		var submitProcessedForm = document
				.getElementById("id_submitProcessedForm");
		//var isPassed = Validator.Validate(submitProcessedForm,1,false);
		//return isPassed;
		return true;
	}
	
</script>
<!--多行控件  -->
<input type="hidden" id="id_json_proj_equip_str" name="json_proj_equip_str" ></input>
<input type="hidden" id="id_json_fund_rent_plan_str" name="json_fund_rent_plan_str"></input>
<input type="hidden" id="id_json_fund_rent_cash_str" name="json_fund_rent_cash_str"></input>
<input type="hidden" id="id_json_proj_guarantee_method_str" 	name="json_proj_guarantee_method_str"></input>
<input type="hidden" id="id_json_proj_guarantee_equip_str" name="json_proj_guarantee_equip_str"></input>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	 <tr>
		<td colspan=4>
		<jsp:include page="../contract/contract_approval/contract_base_info.jsp"></jsp:include></td>
	</tr>
	<!--<tr>
		<td colspan=4> 插入项目其它基本信息  <jsp:include
			page="../proj_approval/proj_base_other_info.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td colspan=4> 插入是否提前准备钱  <jsp:include
			page="../proj_approval/proj_per_money.jsp"></jsp:include></td>
	</tr>
	<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr> -->
	    <tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-project-business-condition"></div>
		资金计划修改</td>
	</tr> 
	<tr>
		<td colspan=4></td>
	</tr>
	 <tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
		<div id='id_project_info_tabs_content' style="">
	    <div title="资金计划修改">
			<div id="id_table_leasing_proj_equip_container" style="overflow: hidden;"></div>
		</div>
		</div>
		</td>
	</tr>   
</table>
</div>
<!--避免在tabs中的js重复执行-->
<jsp:include page="../capital_plan_change/capital_detail.jsp"></jsp:include>
<script>
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		//租赁物件
		//var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');
		//jQuery('#id_json_proj_equip_str').val(
		//		JsonUtil.encode(currentTable1.getRowsJsonData()));
		//租金计划
		//var currentTable2 = getTracywindyObject('table_leasing_table_fund_rent_plan');
		//jQuery('#id_json_fund_rent_plan_str').val(
		//		JsonUtil.encode(currentTable2.getRowsJsonData()));
		//现金流
		//var currentTable3 = getTracywindyObject('table_leasing_table_fund_rent_cash');
		//jQuery('#id_json_fund_rent_cash_str').val(
		//		JsonUtil.encode(currentTable3.getRowsJsonData()));
		//担保单位信息
		//var currentTable4 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');
		//jQuery('#id_json_proj_guarantee_method_str').val(
		//		JsonUtil.encode(currentTable4.getRowsJsonData()));
		//抵押物列表
		//var currentTable5 = getTracywindyObject('table_id_table_leasing_proj_guarantee_equip_container');
		//jQuery('#id_json_proj_guarantee_equip_str').val(
		//		JsonUtil.encode(currentTable5.getRowsJsonData()));

	}
	//生成项目名称
	function createProjectName() {
		var project_name =jQuery('#project_name').val();
		var dept_name = getTracywindyObject('id_combo_proj_info.projDept')
				.getRawValue();
		var proj_id=$("#project_id").val();
		var cust_name=$("#cust_name").val();
		if (project_name == '') {
			project_name = proj_id+"-"+dept_name+"-"+cust_name + '项目';
		}
		jQuery('#project_name').val(project_name);
	}
	var isSubTable = true;
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_project_info_tabs_content").tabs();
		isSubTable = false;
		var d = $("#id_project_info_tabs_content");
		$("#id_project_fund_rent_plan_tabs_content").css("width",
				(formWidth) + "px");
		$("#id_project_fund_rent_plan_tabs_content").tabs();
		//jQuery(".fillTableContainer").css("width",formWidth+"px");
	});
</script>
