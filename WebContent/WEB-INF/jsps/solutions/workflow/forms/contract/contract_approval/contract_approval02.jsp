<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<c:set var="business_type" value="${requestScope['business_type']}"/>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<!-- 特殊附件显示公用方法 -->
<jsp:include page="../../util/proj_view_file.jsp"></jsp:include>
<!-- 项目立项附件带到租前业务相关流程 -->
<jsp:include page="initFileListParams.jsp"></jsp:include>
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
	//点击回退之前回调函数
	function backBeforeOperCallBack(){
		var law="02-2法人信用分析师审核";
		var ewlp="02-1个人信用分析师审核";
		if("${requestScope['proj_info.cust_type']}"=="法人"){
			document.getElementById("id_back_workflow_name_str").value=law;
		}else{
			document.getElementById("id_back_workflow_name_str").value=ewlp;
		}
	}
	function formPageReadOnlyCallBack(){
		   if(!isCompletedTask){
			   jQuery("input[name='contract_signatory.clientaccnumber']").attr({
                   readOnly:false
			     }).removeClass("element-readonly");
		   }
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
<input type="hidden" id="id_back_workflow_name_str" name="back_workflow_name"></input>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td ><!-- 插入项目基本信息 --> <jsp:include	page="contract_base_info_for3.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td colspan=4><!-- 插入项目其它基本信息 --> <jsp:include page="contract_base_other_info.jsp"></jsp:include></td>
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
				<c:if test="${'bussiness_type_car' eq business_type}">
				<jsp:include page="contract_equip_detail02.jsp"></jsp:include>
				<div id="id_table_leasing_proj_equip_container"	style="overflow: hidden;"></div>
				</c:if>
				<c:if test="${'bussiness_type_equip' eq business_type}">
				<jsp:include page="../../nocar/nocar_public/thing_detail.jsp"></jsp:include>
				<div id="id_table_leasing_proj_equip_container"	style="overflow: hidden;"></div>
				</c:if>
			</div>
			<div title="商务报价">
				<span class="print-tabs-title-content">商务报价</span>
				<c:if test="${'bussiness_type_car' eq business_type}">
				<div id="id_table_leasing_contract_condition_container"	style="overflow: hidden;">
					<jsp:include page="../../rent_reckon/rent_reckon/main.jsp" flush="true"/>
				</div>
				</c:if>
				<c:if test="${'bussiness_type_equip' eq business_type}">
				<div id="id_table_leasing_contract_condition_container"	style="overflow: hidden;">
					<jsp:include page="../../rent_reckon/rent_reckon/main_4_5.jsp" flush="true"/>
				</div>
				</c:if>
			</div>
			<div title="担保单位信息">
				<span class="print-tabs-title-content">担保单位信息</span>
				<div id="id_table_leasing_contract_guarantee_method_container"	style="overflow: hidden;"></div>
			</div>
			
			<div title="前提条件">
				<span class="print-tabs-title-content">前提条件</span>
				<div id="id_table_leasing_contract_premise_container"	style="overflow: hidden;"></div>
			</div>
			<div title="合同制作">
				<span class="print-tabs-title-content">合同制作</span>
				<div id="id_table_leasing_contract_make_container"	style="overflow: hidden;">
					<jsp:include page="contract_new_word.jsp"></jsp:include>
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
						<tr  class="tr-contractect-other-info tr-odd">
						    <td class="td-content-title">签约人：</td><td class="td-content" colspan="3"><div class="leftComboContainer" style="width: 99%;"><textarea rows="3"  style="width: 95%;float:left;" name="contract_other_info.signperson" require="true" label="签约人">${requestScope['contract_other_info.signperson']}</textarea></div><font class="required-content">*</font></td>
						</tr>
					</table>
				</div>
			</div>
			<div title="租金发票类型">
				<span class="print-tabs-title-content">租金发票类型</span>
				<div id="id_table_leasing_contract_rent_type_container"	style="overflow: hidden;">
					<jsp:include page="contract_invoice_type.jsp"></jsp:include>
				</div>
			</div>
			<div title="税号">
				<span class="print-tabs-title-content">税号</span>
				<div id="id_table_leasing_contract_invoice_info_container"	style="overflow: hidden;">
					<jsp:include page="contract_invoice_info.jsp"></jsp:include>
				</div>
			</div>
			<div title="合同各方">
				<span class="print-tabs-title-content">合同各方</span>
				<div id="id_table_leasing_contract_signatory_container"	style="overflow: hidden;">
				<script language="javascript">
              	 jQuery(function() {isViewHistoryTask = isCompletedTask;});
             </script>
					<jsp:include page="contract_signatory.jsp"></jsp:include>
					<script language="javascript">
			    jQuery(function() {isViewHistoryTask = true;});
            </script>
				</div>
			</div>
		</div>
		</td>
	</tr>
</table>
</div>
<%--避免在tabs中的js重复执行--%>
<jsp:include page="contract_guarantee_method.jsp"></jsp:include><%--担保 --%>
<jsp:include page="contract_premise_info.jsp"></jsp:include><%--前提条件 --%>
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
		 getTracywindyObject("id_combo_id_cust_kind").readOnlyData = true;
	     getTracywindyObject("id_combo_id_cust_kind").reload();
	});
</script>