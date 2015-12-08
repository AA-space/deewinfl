<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		if(!checkTracywindyTableData("table_id_current_fund_income_detial_container","本次回笼明细")){return false;}
		
		//if(!checkRentCharge()){return false;};
		
	    //if(!doCheckRentListContinue('table_id_fund_income_plans_container','table_id_current_fund_income_detial_container')){return false;};
	    
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		return true;
	}
</script>
<!--多行控件  -->  
<input type="hidden" id="id_json_fund_rent_plans" name="fund_rent_plans" value='${empty fund_rent_plans ? "[]" : fund_rent_plans }'></input>
<input type="hidden" id="id_json_fund_income_history" name="fund_income_history" value='${empty fund_income_history ? "[]" : fund_income_history }'></input>
<input type="hidden" id="id_json_current_fund_income_detial" name="current_fund_income_detial" value='${empty current_fund_income_detial ? "[]" : current_fund_income_detial }'></input>
<div class="fillTableContainer">
	<table class="fillTable" cellspacing="0" cellpadding="0">
	   <tr>
		<td ><!-- 插入合同基本信息 --> <jsp:include page="contract_base_info.jsp"></jsp:include></td>
	   </tr>
		<tr class="tr-contract-business-condition">
			<td class="td-tabs-container" style="text-indent: 0px;">
				<div id='id_contract_condition_tabs_content' style="">
					<div title="租金回笼计划">
						<table cellspacing="0" cellpadding="0">
							<tr class="tr-contractect-info tr-even">
								<td><div id="id_fund_income_plans_container" style="overflow: hidden"></div></td>
							</tr>
						</table>
					</div>
					<div title="租金回笼历史">
						<table cellspacing="0" cellpadding="0">
							<tr class="tr-contractect-info tr-even">
								<td><div id="id_fund_income_history_container" style="overflow: hidden;"></div></td>
							</tr>
						</table>
					</div>
					<div title="罚息减免明细">
						<div id="id_current_fund_income_detial_container" style="overflow: hidden;"></div>
					</div>
				</div>
			</td>
		</tr>
	</table>
</div>
<%--避免在tabs中的js重复执行--%>
<script language="javascript">
  jQuery(function() {isViewHistoryTask = true;});
</script>
<jsp:include page="fund_income_history.jsp"></jsp:include>
<script language="javascript">
  jQuery(function() {isViewHistoryTask = isCompletedTask;});
</script>
<jsp:include page="fund_income_plan.jsp"></jsp:include>
<jsp:include page="fund_current_income_detial.jsp"></jsp:include>
<script language="javascript">
	jQuery(function() {isViewHistoryTask = true;});
</script>
<script>
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		
		var currentTable1 = getTracywindyObject('table_id_fund_income_plans_container');//回笼计划
		jQuery('#id_json_fund_rent_plans').val(JsonUtil.encode(currentTable1.getRowsJsonData()));
		
		var currentTable1 = getTracywindyObject('table_id_fund_income_history_container');//回笼历史
		jQuery('#id_json_fund_income_history').val(JsonUtil.encode(currentTable1.getRowsJsonData()));
	
		//本次回笼明细
		var currentTable1 = getTracywindyObject('table_id_current_fund_income_detial_container');
		jQuery('#id_json_current_fund_income_detial').val(JsonUtil.encode(currentTable1.getRowsJsonData()));
	}
	//初始化调用
	jQuery(function() {       
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		$("#id_contract_condition_tabs_content").css("width", (formWidth) + "px");
		$("#id_contract_condition_tabs_content").tabs();
		$("#id_contract_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_contract_info_tabs_content").tabs();
		isSubTable = false;//标志主页面加载完成
		var d = $("#id_contract_info_tabs_content");
	});
</script>