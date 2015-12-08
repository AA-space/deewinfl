
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
		if(!checkPenalty()){return false;}
		var submitProcessedForm = document
				.getElementById("id_submitProcessedForm");
		return true;
	}
	
</script>				
<!--多行控件  -->
<!-- 保证金 -->
<input type="hidden"  id="id_json_fund_receiver_detail_str" name="json_fund_receiver_detail_str" value='${empty json_fund_receiver_detail_str ? "[]" : json_fund_receiver_detail_str }'/>
<!--租金抵扣计划-->
<input  type="hidden" id="id_json_fund_rent_plan_str" name="json_fund_rent_plan_str" value='${empty json_fund_rent_plan_str ? "[]" : json_fund_rent_plan_str }'/>
<!-- 租金抵扣实际-->
<input  type="hidden" id="id_json_fund_rent_income_str" name="json_fund_rent_income_str" value='${empty json_fund_rent_income_str ? "[]" : json_fund_rent_income_str }'/>

<div class="fillTableContainer">

<table class="fillTable" cellspacing="0" cellpadding="0">
     <tr>
		 <td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr>
        <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr_project_info1"></div>客户逾期明细</td>
    </tr>
	<tr class="tr_project_info1">
		<td colspan=4 ><!-- 客户逾期明细 --> 
		<div id="id_table_other_fund_plan_container">
		</div>
		<jsp:include page="other_fund_rent_plan_details.jsp"></jsp:include>
		</td>
	</tr>
	<tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr>
		<td colspan=4><!-- 未付设备款明细 --> 
		<jsp:include page="fund_money_collectioninfo.jsp"></jsp:include></td>
		
	</tr>
	<tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr>
        <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr_project_info2"></div>保证金收款</td>
    </tr>
	<tr class="tr_project_info2">
		<td colspan=4 ><!-- 保证金收款 --> 
		<div id="id_table_fund_fund_plan_history_container">
		</div>
		<jsp:include page="fund_receiver_detail.jsp"></jsp:include>
		</td>
	</tr>
	  <tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr>
        <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr_project_info3"></div>租金计划</td>
    </tr>
	<tr class="tr_project_info3">
		<td colspan=4 ><!-- 本次付款的租金计划 --> 
		<div id="id_table_fund_rent_plan_container">
		<jsp:include  page="fund_money_detail.jsp"></jsp:include></div></td>
	</tr>
	  <tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr>
       <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr_project"></div>本次抵扣的明细</td>
     </tr>
	<tr class="tr_project">
		<td colspan=4><!-- 本次付款的租金明细 --> 
		<div id="id_table_fund_rent_income_container">
		  <jsp:include page="fund_money_info.jsp"></jsp:include>
		</div></td>
	</tr>

</table>
</div>
<script>
	var isSubTable = true;
	function fillHiddenVal() {
	       //保证金收款
			var currentTable1 = getTracywindyObject('table_id_table_fund_fund_plan_history_container');
			jQuery('#id_json_fund_receiver_detail_str').val(
					JsonUtil.encode(currentTable1.getRowsJsonData()));
			//租金计划
			var currentTable1 = getTracywindyObject('table_id_table_fund_rent_plan_container');
			jQuery('#id_json_fund_rent_plan_str').val(
					JsonUtil.encode(currentTable1.getRowsJsonData()));
			//本次回收计划
			var currentTable1 = getTracywindyObject('table_id_table_fund_rent_income_container');
			jQuery('#id_json_fund_rent_income_str').val(
					JsonUtil.encode(currentTable1.getRowsJsonData()));
		}
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_project_info_tabs_content").tabs();
		isSubTable = false;
		var d = $("#id_project_info_tabs_content");
	});
</script>
