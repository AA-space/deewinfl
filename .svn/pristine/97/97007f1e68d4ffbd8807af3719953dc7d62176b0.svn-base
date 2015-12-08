<%---业务申请 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
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
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		createProjectName();
		//必填
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm, 1, false);
		if (!isPassed) {
			return isPassed;
		}

		//检查租赁物件
		if (!checkTracywindyTableData("table_id_table_leasing_proj_equip_container", "租赁物件")) {
			return false;
		}
		//担保信息
		if (!checkTracywindyTableData("table_id_table_leasing_proj_guarantee_method_container", "担保信息")) {
			return false;
		}
		//租金计划
		if(!checkTracywindyTableData("table_id_table_leasing_rent_plan_container","租金计划")){return false;}
		if(!validataTotalMoney()){return false;}
		return true;
	}
</script>
<!--多行控件  -->
<input type="hidden" id="id_json_proj_equip_str" name="json_proj_equip_str" value='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }'></input>
<input type="hidden" id="id_json_stockholder_info_str" name="json_stockholder_info_str" value='${empty json_stockholder_info_str ? "[]" : json_stockholder_info_str }'></input>
<input type="hidden" id="id_json_proj_guarantee_method_str" name="json_proj_guarantee_method_str" value='${empty json_proj_guarantee_method_str ? "[]" : json_proj_guarantee_method_str }'></input>
<!--结束多行控件  -->
<div class="fillTableContainer">
	<table class="fillTable" cellspacing="0" cellpadding="0">
		<%---插入信息--%>
		<tr>
			<td colspan=4>
				<!-- 插入项目基本信息 --> <jsp:include page="nocar_base_info.jsp"></jsp:include></td>
		</tr>
		<tr>
			<td colspan="4">
				<!-- 插入法人客户信息 --> <jsp:include page="nocar_apply_custom_info.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td>
			<table cellspacing="0" cellpadding="0">
				<tr class="x-panel-table-div-title">
					<td class="x-panel-table-div-title" colspan="4">
					<div class="toggle-icon-expanded" title="折叠"
						toggleClass="tr-project-stockholder"></div>
					股东构成信息</td>
				</tr>
				<tr class="tr-project-stockholder tr-even">
				<td>
				<div id="id_table_leasing_stockholder_info_container">
					<!-- 插入股东构成信息 -->
					<jsp:include page="nocar_stockholder_info.jsp"></jsp:include>
				</div>
				</td>
				</tr>
				</table>
			</td>
		</tr>
		<!--<tr>
			<td colspan=4 class="td-even-line-separator">&nbsp;</td>
		</tr>
		--><tr>
			<td colspan=4>
				<!-- 插入项目其它基本信息 --> <jsp:include page="nocar_apply_other_info.jsp"></jsp:include></td>
		</tr>
		<!--<tr>
		<td colspan=4> 插入是否提前准备钱  <jsp:include
			page="../nocar_public/proj_per_money.jsp"></jsp:include></td>
	</tr>
	-->
		<%---结束插入信息--%>
		<tr>
			<td colspan=4 class="td-even-line-separator">&nbsp;</td>
		</tr>
		<%---选项卡 --%>
		<tr class="x-panel-table-div-title">
			<td class="x-panel-table-div-title" colspan=4>
				<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-business-condition"></div> 项目商务条件
			</td>
		</tr>
		<tr>
			<td colspan=4></td>
		</tr>
		<tr class="tr-project-business-condition">
			<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
				<!-- 标签栏 -->
				<div id='id_project_info_tabs_content' style="">
					<div title="租赁物件">
						<span class="print-tabs-title-content">租赁物件</span>
						<div id="id_table_leasing_proj_equip_container" style="overflow: hidden;"></div>
					</div>
					<div title="商务报价"> 
						<span class="print-tabs-title-content">商务报价</span>
						<div id="id_table_leasing_proj_condition_container" style="overflow: hidden;">
							<jsp:include page="../../rent_reckon/rent_reckon/main_4_5.jsp"></jsp:include></div>
					</div>
					<div title="担保信息">
						<span class="print-tabs-title-content">担保信息</span>
						<div id="id_table_leasing_proj_guarantee_method_container" style="overflow: hidden;"></div>
					</div>
				</div>
			</td>
		</tr>
		<%---结束选项卡 --%>
	</table>
</div>
<%--避免在tabs中的js重复执行--%>
<jsp:include page="../nocar_public/thing_detail.jsp"></jsp:include><%--租赁物件 --%>
<jsp:include page="../../project/proj_approval/proj_guarantee_method.jsp"></jsp:include><%--担保 --%>
<%--结束--%>
<script>
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		//租赁物件
		var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');
		jQuery('#id_json_proj_equip_str').val(JsonUtil.encode(currentTable1.getRowsJsonData()));
		//担保单位信息
		var currentTable4 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');
		jQuery('#id_json_proj_guarantee_method_str').val(JsonUtil.encode(currentTable4.getRowsJsonData()));
		//商务条件数据
		//saveReckonJsonValue();
	}
	//生成项目名称
	function createProjectName() {
		var project_name = jQuery('#project_name').val();
		var dept_name = getTracywindyObject('id_combo_proj_info.projdept').getRawValue();
		var proj_id = $("#project_id").val();
		var cust_name = $("#cust_name").val();
		if (project_name == '') {
			project_name = proj_id + "-" + dept_name + "-" + cust_name + '项目';
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
		$("#id_project_fund_rent_plan_tabs_content").css("width", (formWidth) + "px");
		$("#id_project_fund_rent_plan_tabs_content").tabs();
		//jQuery(".fillTableContainer").css("width",formWidth+"px");
	});
</script>
