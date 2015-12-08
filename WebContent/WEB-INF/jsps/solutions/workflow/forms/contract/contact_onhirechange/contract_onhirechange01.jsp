<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<!-- 特殊附件显示公用方法 -->
<jsp:include page="../../util/proj_view_file.jsp"></jsp:include>
<!-- 项目立项附件带到租前业务相关流程 -->
<jsp:include page="initFileListParams.jsp"></jsp:include>
<c:set var="business_type" value="${requestScope['business_type']}"/>
<style type="text/css">
	table.fillTable td.td-content-title, table.fillTable td.td-content {
		border: 0px dotted #CAD9EA;
		border-bottom: 1px dotted silver;
		padding: 0;
		margin: 0;
		width: 120px;
	}
</style>
<script type="text/javascript">
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack() {
		fillHiddenVal();
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(isPassed==false) return false;
		//比较租赁物价格
		//计算租赁物的总交易价格
		var currentTable1 = getTracywindyObject('table_id_table_leasing_contract_equip_container');
		var data = currentTable1.tableData;
		var totalPrice = 0;
		for ( var i = 0; i < data.length; i++) {
			if(data[i].nowtotalold == ""){
				continue;
			}else{
				totalPrice += parseFloat(data[i]['nowtotalold']);
			}
		}
		
		var currentTable2 = getTracywindyObject('table_id_table_leasing_contract_equip_container_new');
		var data2 = currentTable2.tableData;
		var totalPrice2 = 0;
		for ( var i = 0; i < data2.length; i++) {
			totalPrice2 += parseFloat(data2[i]['nowtotal']);
		}
		//计算商务条件的设备款
		if(totalPrice!=0){
			if (totalPrice != totalPrice2) {//如果不相等，则跳出执行
				alert("【原租赁物明细】标签的合计总价[" + totalPrice + "]和【现租赁物明细】标签的合计总价[" + totalPrice2 + "]不相等,请检查.");
				return false;
			}
		}
		return true;
	
	}
	//流程提交是设置条件路由
	function workflowNextRouteCallBack(buttonText,requestNextRoute){
        if(buttonText=="Submit"){
        	var law="TO 02信审部审核法人";
    		var ewlp="TO 02信审部审核个人";
    		var cust=getTracywindyObject("id_combo_cust_new").getRawValue();
    		if(cust.indexOf("法人")>-1){
       			requestNextRoute.value=law;
    		}else{
    			requestNextRoute.value=ewlp;
    		}
        }
   }
	
	var isSubTable = true;
</script>
<!--多行控件  -->
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	 <tr>
		<td colspan=4><%--插入合同信息--%>
			<script language="javascript">
			jQuery(function() {isViewHistoryTask = true;});
			</script>
		<jsp:include page="../contract_approval/contract_base_info.jsp"></jsp:include>
		<script language="javascript">
			jQuery(function() {isViewHistoryTask = false;});
		</script>
		</td>
	</tr>
	
	<tr>
		<td colspan=4>
			<!-- 插入项目其它信息 -->
			<jsp:include page="contract_onhirechange_other_info.jsp"></jsp:include>	
		</td>
	</tr>
	<tr>
		<td colspan=4>
			<jsp:include page="car_operation_info.jsp"></jsp:include>	
		</td>
	</tr>
	<tr>
	<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
		<tr class="x-panel-table-div-title">
			<td class="x-panel-table-div-title" colspan=4>
				<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-business-condition"></div> 合同起租后变更
			</td>
		</tr>
		<tr>
		<td colspan=4></td>
	</tr>
	 <tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
		<div id='id_project_info_tabs_content' style="">
			<div title="承租人变更">
				<div id="id_table_leasing_contract_rent_type_container" style="overflow: hidden;">
				   <jsp:include page="contract_person_change.jsp"></jsp:include>
				</div>
			</div>
			<div title="租赁物件变更">
				<div id="id_table_leasing_contract_equip_container_main"	style="overflow: hidden;">
					<jsp:include page="contract_equip_container_main.jsp" flush="true"/>
				</div>
			</div>
			<div title="担保单位变更">
				<div id="id_table_leasing_contract_fund_charge_container_main"	style="overflow: hidden;">
					<jsp:include page="contract_guarantee_method_main.jsp" flush="true"/>    
				</div>
			</div>
		</div>
		</td>
	</tr>   
</table>
</div>

<script>
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		var contractEquip = getTracywindyObject('table_id_table_leasing_contract_equip_container_new');//租赁物件
		jQuery('#id_json_contract_equip_new_str').val(JsonUtil.encode(contractEquip.getRowsJsonData()));
		var contractGuaranteeMethod = getTracywindyObject('table_id_table_leasing_contract_guarantee_method_container_new');//担保
		jQuery('#id_json_contract_guarantee_method_new_str').val(JsonUtil.encode(contractGuaranteeMethod.getRowsJsonData()));
	}
	var isSubTable = true;
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_project_info_tabs_content").tabs();
		isSubTable = false;
	});
	//var isViewHistoryTask = true;//全局变量设整个页面只读 
</script>

