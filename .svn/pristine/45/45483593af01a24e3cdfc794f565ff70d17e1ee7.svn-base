<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">

	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		return Validator.Validate(submitProcessedForm,1,false);;
	}
	
	//保存成功提交后，后台返回
	function saveCallBack() {
		return true;
	}
	
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		return Validator.Validate(submitProcessedForm,1,false);;
	}
	var isSubTable = true;//标志主页面是否加载完成 只有在主页面加载完成再加载其他多行空间和下拉框之类的数据
	var isViewHistoryTask = true;
	
</script>

<!--多行控件  -->
<input type="hidden" id="id_json_generated_reports_str" name="json_generated_reports_str" value='${empty json_generated_reports_str ? "[]" : json_generated_reports_str }'/> <!-- 存量资产检查报告 -->
<input type="hidden" id="id_json_contract_guarantee_method_str" name="json_contract_guarantee_method_str" value='${empty json_contract_guarantee_method_str ? "[]" : json_contract_guarantee_method_str }'/> <!-- 担保人信息 -->

<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td ><!-- 插入合同基本信息 --> <jsp:include	page="../contract_approval/contract_base_info.jsp"></jsp:include></td>
	</tr>
	<tr class="tr-contract-business-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
			<div id='id_contract_condition_tabs_content' style="">
			
			<div title="客户巡视计划表单">
					<span class="print-tabs-title-content">客户巡视计划表单</span>
					<div id="id_table_leasing_contract_sign_container"	style="overflow: hidden;">
						<table cellspacing="0" cellpadding="0" style="width: 98%; margin-top: 20px;" >
							 <tr  class="tr-contractect-other-info tr-even">
							    <td class="td-content-title">市场估价：</td><td class="td-content"><div class="leftComboContainer"><input type="text" name="cust_view.marketValue" value="${requestScope['cust_view.marketValue']}" require="true" label="市场估价" ></input></div><font class="required-content">*</font></td>
							    <td class="td-content-title">巡视时间：</td><td class="td-content"><input class="Wdate td-content-input" readonly name="cust_view.viewTime" class="td-content-input"  type="text" value="${requestScope['cust_view.viewTime']}" onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="巡视时间"><font class="required-content">*</font></td>
							    </tr>
							<tr  class="tr-contractect-other-info tr-even">
							    <td class="td-content-title">巡视重点：</td><td class="td-content" colspan="3"><div class="leftComboContainer" style="width: 90%;"><textarea rows="6"  style="width: 95%;" name="cust_view.viewFocus" require="true" label="巡视重点">${requestScope['cust_view.viewFocus']}</textarea></div><font class="required-content">*</font></td>
							</tr>
						</table>
					</div>
				</div>
			
			<div title="制作存量资产检查报告">
					<span class="print-tabs-title-content">制作存量资产检查报告</span>
						<jsp:include page="../five_category_contract/make_reports.jsp" flush="true"/>
			</div>
			
				
				
				<div title="存量资产检查报告">
					<span class="print-tabs-title-content">存量资产检查报告</span>
					<div id="id_table_leasing_generated_reports_container"	style="overflow: hidden;"></div>
				</div>
				
				<div title="担保人信息">
					<span class="print-tabs-title-content">担保人信息</span>
					<div id="id_table_leasing_contract_guarantee_method_container"	style="overflow: hidden;">
					</div>
				</div>
			</div>
			
		</td>
		</tr>
	</table>
</div>

<%--避免在tabs中的js重复执行--%>
<jsp:include page="../five_category_contract/generated_reports.jsp"></jsp:include><%--存量资产检查报告 --%>
<jsp:include page="../contract_approval/contract_guarantee_method.jsp"></jsp:include><%-- 担保人信息 --%>

<script>
//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		var currentTable1 = getTracywindyObject('table_id_table_leasing_generated_reports_container');//存量资产检查报告
		jQuery('#id_json_generated_reports_str').val(JsonUtil.encode(currentTable1.getRowsJsonData()));
		var currentTable2 = getTracywindyObject('table_id_table_leasing_contract_guarantee_method_container');//担保人信息
		jQuery('#id_json_contract_guarantee_method_str').val(JsonUtil.encode(currentTable2.getRowsJsonData()));
	}
	
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		//第一个页签集合
		$("#id_contract_condition_tabs_content").css("width", (formWidth) + "px");
		$("#id_contract_condition_tabs_content").tabs();
		//第二个页签集合
		//$("#id_contract_info_tabs_content").css("width", (formWidth) + "px");
		//$("#id_contract_info_tabs_content").tabs();
		isSubTable = false;//标志主页面加载完成
		//var d = $("#id_contract_info_tabs_content");
	});
</script>