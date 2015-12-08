<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
var isSubTable = true;
   function formPageReadOnlyCallBack(){  
    if(!isCompletedTask){
       formJSPInputHideOrShow("id_table_leasing_contract_rent_close_container","",0);
       formJSPInputHideOrShow("plan_rent_terminate_form","fund_rent_adjust.otherin,fund_rent_adjust.otherout,fund_rent_adjust.dunrent,fund_rent_adjust.dunpenalty,fund_rent_adjust.corpusoverage,fund_rent_adjust.contracttotal",0);
     }
   }
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
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
		/* var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		return isPassed; */
		return true;
	}
	isSubTable = true;
</script>
<!--多行控件  -->
<!-- 收款计划 -->
<input type="hidden" id="id_json_receiverchargeplan_str" name="json_receiverchargeplan_str" value='${empty json_receiverchargeplan_str ? "[]" : json_receiverchargeplan_str }'/>
<!-- 历史收款 -->
<input type="hidden"  id="id_json_receiverchargehistory_str" name="json_receiverchargehistory_str" value='${empty json_receiverchargehistory_str ? "[]" : json_receiverchargehistory_str }'/>
<!-- 付款计划 -->
<input type="hidden" id="id_json_payfundchargeplan_str" name="json_paychargeplan_str" value='${empty json_paychargeplan_str ? "[]" : json_paychargeplan_str }'/> 
<!-- 历史付款 -->
<input type="hidden" id="id_json_contract_fund_payment_history_str" name="json_contract_fund_payment_history_str" value='${empty json_contract_fund_payment_history_str ? "[]" : json_contract_fund_payment_history_str }'/>
<!-- 租金计划 -->
<input type="hidden" id="id_json_fund_rent_plans" name="fund_rent_plans" value='${empty fund_rent_plans ? "[]" : fund_rent_plans }'/>
<!-- 历史租金收款 -->
<input type="hidden" id="id_json_fund_income_history" name="fund_income_history" value='${empty fund_income_history ? "[]" : fund_income_history }'/>
<input type="hidden" id="id_json_word_list_str" name="json_word_list_str" value='${empty json_word_list_str ? "[]" : json_word_list_str }'></input>
<input name="law_d" id="law_d" class="td-content-input td-content-readonly" readOnly  type="hidden"  value="${requestScope['law_d'] }">
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	 <tr>
		<td colspan=4><jsp:include page="../contract_approval/contract_base_info.jsp"></jsp:include></td>
	</tr>
    <tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-project-business-condition"></div>
		合同结束</td>
	</tr> 
	<tr>
		<td colspan=4></td>
	</tr>
	 <tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
		<div id='id_project_info_tabs_content' style="">
		<div title="租赁物明细">
			<div id="id_table_leasing_proj_equip_container"	style="overflow: hidden;"></div>
		</div>
		<div title="资金收款计划">
					<div id="id_table_receiverchargeplan_container"	style="overflow: hidden;"></div>
				</div>
		<div title="资金付款计划">
			<div id="id_table_leasing_json_paychargeplan_container" style="overflow: hidden;"></div>
					</div>
		<div title="租金回笼计划">
				<div id="id_fund_income_plans_container"	style="overflow: hidden;">
				</div>
			</div>
		<div title="资金收款历史">
					<div id="id_table_receiverchargehistory_container"	style="overflow: hidden;">
					
					</div>
				</div>
	    <div title="资金付款历史">
			<div id="id_table_leasing_contract_fund_payment_history_container" style="overflow: hidden;"></div>
		</div>
		<div title="租金回笼历史">
			<div id="id_fund_income_history_container" style="overflow: hidden;">
			</div>
		</div>
       <div title="中途终止结算">
       		<div id="id_contract_plan_terminate_form" style="overflow: hidden;">
       			<jsp:include page="../../rent_reckon/rent_terminate/mainHis.jsp"/>
			</div>
       </div>
		<div title="原因及备注">
			<div id="id_table_leasing_contract_rent_close_container" style="overflow: hidden;">
			 <jsp:include page="contract_summary.jsp"></jsp:include>
	       </div>
		</div>
		<%--
		<div title="合同登记资料返还">
			<div id="id_table_leasing_doc_send_info"	style="overflow: hidden;"></div>
		</div>
		 --%>
		<div title="合同终止协议">
			<div id="id_table_leasing_xieyi_info"	style="overflow: hidden;">
			<script type="text/javascript">
				jQuery(function() {isViewHistoryTask = false; });
			</script>
			<jsp:include page="proj_credit_reportxls.jsp"></jsp:include>
			<script type="text/javascript">
				jQuery(function() {isViewHistoryTask = true; });
			</script>
			</div>
		</div>
		</div>
		</td>
	</tr>   
</table>
</div>
<!--避免在tabs中的js重复执行-->
<jsp:include page="contract_terminate_equip_detail.jsp"></jsp:include>
<jsp:include page="../../fund/fund_collection/fund_receiverchargeplan.jsp"></jsp:include><%--资金收款计划 --%>
<jsp:include page="../../fund/fund_payment/fund_paychargeplan.jsp"></jsp:include><%--资金付款计划 --%>
<jsp:include page="../../fund/fund_collection/fund_receiverchargehistory.jsp"></jsp:include><%--资金收款历史 --%>
<jsp:include page="../../fund/fund_payment/fund_payment_history.jsp"></jsp:include><%--资金付款历史 --%>
<jsp:include page="../../assets/fund/fund_income/fund_income_plan.jsp"></jsp:include><!-- 租金回笼计划 -->
<jsp:include page="../../assets/fund/fund_income/fund_income_history.jsp"></jsp:include><!-- 租金回笼历史 -->
<script>
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		//收款计划
		var currentTable1 = getTracywindyObject('table_id_table_receiverchargeplan_container');
		jQuery('#id_json_receiverchargeplan_str').val(
				JsonUtil.encode(currentTable1.getRowsJsonData()));
		//历史收款
		var currentTable1 = getTracywindyObject('table_id_table_receiverchargehistory_container');
		jQuery('#id_json_receiverchargehistory_str').val(
				JsonUtil.encode(currentTable1.getRowsJsonData()));
		//付款计划
		var currentTable1 = getTracywindyObject('table_id_table_leasing_json_paychargeplan_container');
		jQuery('#id_json_payfundchargeplan_str').val(
				JsonUtil.encode(currentTable1.getRowsJsonData()));
		//历史付款
		var currentTable2 = getTracywindyObject('table_id_table_leasing_contract_fund_payment_history_container');
		jQuery('#id_json_contract_fund_payment_history_str').val(
				JsonUtil.encode(currentTable2.getRowsJsonData()));
		//回笼计划
		var currentTable1 = getTracywindyObject('table_id_fund_income_plans_container');
		jQuery('#id_json_fund_rent_plans').val(JsonUtil.encode(currentTable1.getRowsJsonData()));
		
		//回笼历史
		var currentTable1 = getTracywindyObject('table_id_fund_income_history_container');
		jQuery('#id_json_fund_income_history').val(JsonUtil.encode(currentTable1.getRowsJsonData()));
		
		var currentTable1 = getTracywindyObject('table_id_table_leasing_xieyi_info');
		jQuery('#id_json_word_list_str').val(JsonUtil.encode(currentTable1.getRowsJsonData()));
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
		$("#id_project_fund_rent_plan_tabs_content").css("width",(formWidth) + "px");
		$("#id_project_fund_rent_plan_tabs_content").tabs();
	});
		var isViewHistoryTask = true;//全局变量设整个页面只读 
</script>
