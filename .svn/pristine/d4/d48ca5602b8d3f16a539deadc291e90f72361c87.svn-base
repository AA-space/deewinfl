<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack(rs) {
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		return true;
	}
	var isSubTable = true;//标志主页面是否加载完成 只有在主页面加载完成再加载其他多行空间和下拉框之类的数据
	isViewHistoryTask = true;//全局变量说是这一个只读页面
</script>
<!--多行控件  -->
<input type="hidden" id="id_json_contract_equip_str" name="json_contract_equip_str"  value='${empty json_contract_equip_str ? "[]" : json_contract_equip_str }'></input>
<input type="hidden" id="id_json_contract_guarantee_method_str" name="json_contract_guarantee_method_str" value='${empty json_contract_guarantee_method_str ? "[]" : json_contract_guarantee_method_str }'></input>
<input type="hidden" id="id_json_contract_guarantee_equip_str" name="json_contract_guarantee_equip_str" value='${empty json_contract_guarantee_equip_str ? "[]" : json_contract_guarantee_equip_str }'></input>
<input type="hidden" id="id_json_contract_supplier_str" name="json_contract_supplier_str" value='${empty json_contract_supplier_str ? "[]" : json_contract_supplier_str }'></input>
<input type="hidden" id="id_json_contract_premise_str" name="json_contract_premise_str" value='${empty json_contract_premise_str ? "[]" : json_contract_premise_str }'></input>
<input type="hidden" id="id_json_contract_list_str" name="json_contract_list_str" value='${empty json_contract_list_str ? "[]" : json_contract_list_str }'></input>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td ><!-- 插入项目基本信息 --> <jsp:include	page="../contract_approval/contract_base_info.jsp"></jsp:include></td>
	</tr>
	</table>
</div>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<tr class="tr-contract-business-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
		<div id='id_contract_info_tabs_content' style="">
			<div title="租赁物明细">
				<span class="print-tabs-title-content">租赁物明细</span>
				<div id="id_table_leasing_contract_equip_container"	style="overflow: hidden;"></div>
			</div>
			<div title="商务报价">
				<span class="print-tabs-title-content">商务报价</span>
				<div id="id_table_leasing_contract_condition_container"	style="overflow: hidden;">
					<jsp:include page="../../rent_reckon/rent_reckon/main.jsp" flush="true"/>
				</div>
			</div>
			<div title="担保单位信息">
				<span class="print-tabs-title-content">担保单位信息</span>
				<div id="id_table_leasing_contract_guarantee_method_container"	style="overflow: hidden;"></div>
			</div>
			<div title="抵/质押列表">
				<span class="print-tabs-title-content">抵/质押列表</span>
				<div id="id_table_leasing_contract_guarantee_equip_container"	style="overflow: hidden;"></div>
			</div>
			<div title="合同各方">
				<span class="print-tabs-title-content">合同各方</span>
				<div id="id_table_leasing_contract_signatory_container"	style="overflow: hidden;">
					<jsp:include page="../contract_approval/contract_signatory.jsp"></jsp:include>
				</div>
			</div>
			<div title="风险防范措施">
				<span class="print-tabs-title-content">风险防范措施</span>
				<div id="id_table_leasing_contract_protect_container"	style="overflow: hidden;">
					<textarea rows="15"  style="width: 98%; margin-top: 20px;" name="contract_other_info.riskpreventionmeasures" >${requestScope['contract_other_info.riskpreventionmeasures']}</textarea>
				</div>
			</div>
			<div title="其他商务条件">
				<span class="print-tabs-title-content">其他商务条件</span>
				<div id="id_table_leasing_contract_other_container"	style="overflow: hidden;">
					<textarea rows="15"  style="width: 98%; margin-top: 20px;" name="contract_other_info.othercondtion" >${requestScope['contract_other_info.othercondtion']}</textarea>
				</div>
			</div>
			<div title="前提条件">
				<span class="print-tabs-title-content">前提条件</span>
				<div id="id_table_leasing_contract_premise_container"	style="overflow: hidden;"></div>
			</div>
			<div title="合同制作">
				<span class="print-tabs-title-content">合同制作</span>
				<div id="id_table_leasing_contract_make_container"	style="overflow: hidden;">
					<jsp:include page="../contract_approval/contract_word_read.jsp"></jsp:include>
				</div>
			</div>
			<div title="签约信息">
				<span class="print-tabs-title-content">签约信息</span>
				<div id="id_table_leasing_contract_sign_container"	style="overflow: hidden;">
					<table cellspacing="0" cellpadding="0" style="width: 98%; margin-top: 20px;" >
						 <tr  class="tr-contractect-other-info tr-even">
						    <td class="td-content-title">签约时间：</td><td class="td-content"><input class="Wdate td-content-input" readonly name="contract_other_info.signdate" class="td-content-input"  type="text" value="${requestScope['contract_other_info.signdate']}" onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="签约时间"><font class="required-content">*</font></td>
						    <td class="td-content-title">签约地点：</td><td class="td-content"><input name="contract_other_info.signplace" class="td-content-input" type="text" value="${requestScope['contract_other_info.signplace']}" require="true" label="签约地点"><font class="required-content">*</font></td>
						</tr>
						<tr  class="tr-contractect-other-info tr-even">
						    <td class="td-content-title">签约人：</td><td class="td-content" colspan="3"><div class="leftComboContainer" style="width: 90%;"><textarea rows="3"  style="width: 95%;" name="contract_other_info.signperson" require="true" label="签约人">${requestScope['contract_other_info.signperson']}</textarea></div><font class="required-content">*</font></td>
						</tr>
					</table>
				</div>
			</div>
			<div title="起止建造日期及周期">
				<span class="print-tabs-title-content">起止建造日期及周期</span>
				<div id="id_table_leasing_contract_create_container"	style="overflow: hidden;">
					<table cellspacing="0" cellpadding="0" style="width: 98%; margin-top: 20px;" >
						 <tr  class="tr-contractect-other-info tr-even">
						    <td class="td-content-title">建造开始日期：</td><td class="td-content"><input require="true" label="建造开始日期" class="Wdate td-content-input" readonly name="contract_other_info.terminalbegindate" class="td-content-input"  type="text" value="${requestScope['contract_other_info.terminalbegindate']}" onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})"><font class="required-content">*</font></td>
						    <td class="td-content-title">建造结束日期：</td><td class="td-content"><input require="true" label="建造结束日期" class="Wdate td-content-input" readonly name="contract_other_info.terminalenddate" class="td-content-input" type="text" value="${requestScope['contract_other_info.terminalenddate']}" onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})"><font class="required-content">*</font></td>
						</tr>
						<tr  class="tr-contractect-other-info tr-even">
						    <td class="td-content-title">使用开始日期：</td><td class="td-content"><input require="true" label="使用开始日期" class="Wdate td-content-input" readonly name="contract_other_info.terminalusebegintime" class="td-content-input"  type="text" value="${requestScope['contract_other_info.terminalusebegintime']}" onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})"><font class="required-content">*</font></td>
						    <td class="td-content-title">使用结束日期：</td><td class="td-content"><input require="true" label="使用结束日期" class="Wdate td-content-input" readonly name="contract_other_info.terminaluseendtime" class="td-content-input" type="text" value="${requestScope['contract_other_info.terminaluseendtime']}" onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})"><font class="required-content">*</font></td>
						</tr>
					</table>
				</div>
			</div>
			<div title="租金发票类型">
				<span class="print-tabs-title-content">租金发票类型</span>
				<div id="id_table_leasing_contract_rent_type_container"	style="overflow: hidden;">
					<jsp:include page="../contract_approval/contract_invoice_type.jsp"></jsp:include>
				</div>
			</div>
			<div title="税号">
				<span class="print-tabs-title-content">税号</span>
				<div id="id_table_leasing_contract_invoice_info_container"	style="overflow: hidden;">
					<jsp:include page="../contract_approval/contract_invoice_info.jsp"></jsp:include>
				</div>
			</div>
		</div>
		</td>
	</tr>
</table>
</div>
<%--避免在tabs中的js重复执行--%>
<jsp:include page="../contract_approval/contract_equip_detail.jsp"></jsp:include><%--租赁物件 --%>
<jsp:include page="../contract_approval/contract_guarantee_method.jsp"></jsp:include><%--担保 --%>
<jsp:include page="../contract_approval/contract_guarantee_equip.jsp"></jsp:include><%--抵押 --%>
<jsp:include page="../contract_approval/contract_premise_info.jsp"></jsp:include><%--前提条件 --%>
<script>
	
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		//第一个页签集合
		$("#id_contract_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_contract_info_tabs_content").tabs();
		isSubTable = false;//标志主页面加载完成
		//var d = $("#id_contract_info_tabs_content");
	});
</script>