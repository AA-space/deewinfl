<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<c:set var="business_type" value="${requestScope['business_type']}"/>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<!-- 附件显示 -->
<jsp:include page="../../util/proj_view_file.jsp"></jsp:include>
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
</script>

<!--多行控件  -->
<input type="hidden" id="id_json_contract_equip_str" name="json_contract_equip_str"  value='${empty json_contract_equip_str ? "[]" : json_contract_equip_str }'/> <!-- 租赁物件 -->
<input type="hidden" id="id_json_contract_fund_receive_history_str" name="json_contract_fund_receive_history_str" value='${empty json_contract_fund_receive_history_str ? "[]" : json_contract_fund_receive_history_str }'/> <!-- 资金收款历史 -->
<input type="hidden" id="id_json_contract_fund_payment_history_str" name="json_contract_fund_payment_history_str" value='${empty json_contract_fund_payment_history_str ? "[]" : json_contract_fund_payment_history_str }'/> <!-- 资金付款历史 -->

<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td ><!-- 插入合同基本信息 --> <jsp:include	page="../contract_approval/contract_base_info.jsp"></jsp:include></td>
	</tr>
	<tr class="tr-contract-business-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
			<div id='id_contract_condition_tabs_content' style="">
			
			<div title="租赁物件">
					<span class="print-tabs-title-content">租赁物件</span>
					<c:if test="${'bussiness_type_car' eq business_type}">
					<div id="id_table_leasing_contract_equip_container"	style="overflow: hidden;">
					<jsp:include page="../contract_approval/contract_equip_detail.jsp"></jsp:include><%--租赁物件 --%>
					</div>
					</c:if>
					<c:if test="${'bussiness_type_equip' eq business_type}">
				<jsp:include page="../contract_approval/thing_detail.jsp"></jsp:include>
				<div id="id_table_leasing_contract_equip_container"	style="overflow: hidden;"></div>
				</c:if>
				</div>
			
				<div title="撤销原因">
					<span class="print-tabs-title-content">撤销原因</span>
					<div id="id_table_leasing_contract_sign_container"	style="overflow: hidden;">
						<table cellspacing="0" cellpadding="0" style="width: 98%; margin-top: 20px;" >
							 <tr  class="tr-contractect-other-info tr-even">
							    <td class="td-content-title">撤销时间：</td><td class="td-content"><input class="Wdate td-content-input" readonly name="contract_other_info.repealdate" class="td-content-input"  type="text" value="${requestScope['contract_info.repealdate']}" onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="撤销时间"><font class="required-content">*</font></td>
							    <td class="td-content-title">撤销类型：</td><td class="td-content" ><div class="leftComboContainer" id="id_repeal_reasontype" value="${requestScope['contract_info.repealreasontype']}"></div><font class="required-content">*</font></td>
							    </tr>
							<tr  class="tr-contractect-other-info tr-even">
							    <td class="td-content-title">撤销原因：</td><td class="td-content" colspan="3"><div class="leftComboContainer" style="width: 90%;"><textarea rows="6"  style="width: 95%;" name="contract_other_info.repealreason" require="true" label="撤销原因">${requestScope['contract_info.repealreason']}</textarea></div><font class="required-content">*</font></td>
							</tr>
						</table>
					</div>
				</div>
				
				<div title="资金收款历史">
					<span class="print-tabs-title-content">资金收款历史</span>
					<div id="id_table_leasing_contract_fund_receive_history_container"	style="overflow: hidden;"></div>
				</div>
				<div title="资金付款历史">
					<span class="print-tabs-title-content">资金付款历史</span>
					<!-- <div id="id_table_leasing_contract_invoice_info_container"	style="overflow: hidden;"> -->
					<div id="id_table_leasing_contract_fund_payment_history_container"	style="overflow: hidden;">
					</div>
				</div>
			</div>
			
		</td>
		</tr>
	</table>
</div>

<%--避免在tabs中的js重复执行--%>
<jsp:include page="contract_fund_receive_history.jsp"></jsp:include><%--资金收款历史 --%>
<jsp:include page="../../fund/fund_payment/fund_payment_history.jsp"></jsp:include><%--资金付款历史 --%>

<script>
//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		var currentTable1 = getTracywindyObject('table_id_table_leasing_contract_fund_receive_history_container');//资金收款历史
		jQuery('#id_json_contract_fund_receive_history_str').val(JsonUtil.encode(currentTable1.getRowsJsonData()));
		var currentTable2 = getTracywindyObject('table_id_table_leasing_contract_equip_container');//租赁物件
		jQuery('#id_json_contract_equip_str').val(JsonUtil.encode(currentTable2.getRowsJsonData()));
		var currentTable3 = getTracywindyObject('table_id_table_leasing_contract_fund_payment_history_container');//资金付款历史
		jQuery('#id_json_contract_fund_payment_history_str').val(JsonUtil.encode(currentTable3.getRowsJsonData()));
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
	var isViewHistoryTask = true;
		dict('id_repeal_reasontype','contract_info.repealreasontype','repeal_type','${requestScope["contract_info.repealreasontype"]}','${requestScope["rawValue_contract_info.repealreasontype"]}','isForceModify="false" label="撤销类型"');
</script>