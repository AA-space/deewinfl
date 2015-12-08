<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='/WEB-INF/tlds/c.tld'%>
<c:set var="business_type" value="${requestScope['business_type']}" />
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		return true;
	}
	function formPageReadOnlyCallBack() {
		if (!isCompletedTask) {
			formJSPInputHideOrShow("equip_accpance_other_info", "", 1);
		}
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		return Validator.Validate(submitProcessedForm, 1, false);
	}
	var isSubTable = true;//标志主页面是否加载完成 只有在主页面加载完成再加载其他多行空间和下拉框之类的数据
</script>

<!--多行控件  -->
<input type="hidden" id="id_json_contract_equip_str" name="json_contract_equip_str" value='${empty json_contract_equip_str ? "[]" : json_contract_equip_str }' />
<!-- 租赁物件 -->
<input type="hidden" id="id_json_equip_acceptance_history_str" name="json_equip_acceptance_history_str" value='${empty json_equip_acceptance_history_str ? "[]" : json_equip_acceptance_history_str }' />
<!-- 设备验收历史 -->

<div class="fillTableContainer">
	<table class="fillTable" cellspacing="0" cellpadding="0">

		<tr>
			<td>
				<!-- 插入合同基本信息 --> <jsp:include page="../contract_approval/contract_base_info.jsp"></jsp:include></td>
		</tr>
		<tr>
			<td>
				<!-- 插入设配验收--> <jsp:include page="equip_acceptance_other_info.jsp"></jsp:include>
			</td>
		</tr>
		<tr class="tr-contract-business-condition">
			<td class="td-tabs-container" style="text-indent: 0px;">
				<div id='id_contract_condition_tabs_content' style="">
					<div title="租赁物件">
						<%-- 					<div id="id_table_leasing_contract_equip_container"	style="overflow: hidden;">
					<jsp:include page="../contract_approval/contract_equip_detail.jsp"></jsp:include>租赁物件
					</div> --%>
						<div id="id_table_leasing_proj_equip_container" style="overflow: hidden;"></div>
						<jsp:include page="../../project/proj_approval/proj_equip_detail.jsp"></jsp:include>



					</div>
					<div title="商务报价">
						<c:if test="${'bussiness_type_car' eq business_type}">
							<div id="id_table_leasing_contract_condition_container" style="overflow: hidden;">
								<jsp:include page="../../rent_reckon/rent_reckon/main.jsp" flush="true" />
							</div>
						</c:if>
						<c:if test="${'bussiness_type_equip' eq business_type}">
							<div id="id_table_leasing_contract_condition_container" style="overflow: hidden;">
								<jsp:include page="../../rent_reckon/rent_reckon/main_4_5.jsp" flush="true" />
							</div>
						</c:if>
					</div>
				</div>
			</td>
		</tr>
	</table>
</div>

<script>
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		//商务条件数据
		saveReckonJsonValue();
	}
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		//第一个页签集合
		$("#id_contract_condition_tabs_content").css("width", (formWidth) + "px");
		$("#id_contract_condition_tabs_content").tabs();
		isSubTable = false;//标志主页面加载完成
	});
	var isViewHistoryTask = true;
	jQuery('#onhiredatatext').html('起租日期：');//将商务报价里面的计划起租日期改为起租日期
</script>