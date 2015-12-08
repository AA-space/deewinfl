
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack() {
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		//alert(Validator);
		return true;
	}
	
	
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		//必填
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return isPassed;}
		return true;
	}

	function getTableColumnData(tabledatas,column){
        var cdata=[];
        if(tabledatas.length>0){
            for(var i=0;i<tabledatas.length;i++){
                var ctable=tabledatas[i];
                cdata[i]=ctable[column];
            }
        }
        return cdata;
    }
  

</script>


<!--多行控件  -->
<input type="hidden" id="id_json_todo_regulating_of_breathing_str" name="json_todo_regulating_of_breathing_str" value='${empty json_todo_regulating_of_breathing_str ? "[]" : json_todo_regulating_of_breathing_str }'/> <!--待调息清单-->
<input type="hidden" id="id_json_already_regulating_of_breathing_str" name="json_already_regulating_of_breathing_str"  value='${empty json_already_regulating_of_breathing_str ? "[]" : json_already_regulating_of_breathing_str }'/> <!-- 已调息清单 -->
<input type="hidden" id="id_json_current_regulating_of_breathing_str" name="json_current_regulating_of_breathing_str"  value='${empty json_current_regulating_of_breathing_str ? "[]" : json_current_regulating_of_breathing_str }'/> <!-- 本次调息 -->

<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr  id="contract_base_info">
		<td>
		<!-- 央行利率信息 --> 
			<jsp:include page="the_bank_information.jsp"></jsp:include>
		</td>
	</tr>
	
	<tr>
		<td  class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr class="tr-contract-business-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
			<div id='id_contract_condition_tabs_content' style="">
				<div title="待调息">
					<span class="print-tabs-title-content">待调息</span>
					<div id="id_table_todo_regulating_of_breathing_container" style="overflow: hidden;"></div>
	
				</div>
				<div title="已调息">
					<span class="print-tabs-title-content">已调息</span>
					<div id="id_table_already_regulating_of_breathing_container" style="overflow: hidden;"></div>
				</div>
				<div title="本次调息">
					<span class="print-tabs-title-content">本次调息</span>
					<div id="id_table_current_regulating_of_breathing_container"	style="overflow: hidden;"></div>
				</div>
	
			</div>
		</td>
	</tr>
</table>
</div>

<!--避免在tabs中的js重复执行-->
<jsp:include page="todo_regulating_of_breathing.jsp"></jsp:include> <!-- 待调息 -->
<jsp:include page="already_regulating_of_breathing.jsp"></jsp:include> <!-- 已调息 -->
<jsp:include page="current_regulating_of_breathing.jsp"></jsp:include> <!-- 本次调息 -->

<script>

//隐藏域在提交或保存前的赋值
function fillHiddenVal() {
	var currentTable1 = getTracywindyObject('table_id_table_leasing_todo_regulating_of_breathing_container');
	jQuery('#id_json_todo_regulating_of_breathing_str').val(
			JsonUtil.encode(currentTable1.getRowsJsonData()));

	var currentTable2 = getTracywindyObject('table_id_table_leasing_already_regulating_of_breathing_container');
	jQuery('#id_json_already_regulating_of_breathing_str').val(
			JsonUtil.encode(currentTable2.getRowsJsonData()));

	var currentTable3 = getTracywindyObject('table_id_table_leasing_current_regulating_of_breathing_container');
	jQuery('#id_json_current_regulating_of_breathing_str').val(
			JsonUtil.encode(currentTable3.getRowsJsonData()));
}

var isSubTable = true;

jQuery(function() {
	//########公共JS事件##########
	jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
	$("#id_contract_condition_tabs_content").css("width", (formWidth) + "px");
	$("#id_contract_condition_tabs_content").tabs();
	isSubTable = false;
	var d = $("#id_contract_condition_tabs_content");
	
});


</script>
