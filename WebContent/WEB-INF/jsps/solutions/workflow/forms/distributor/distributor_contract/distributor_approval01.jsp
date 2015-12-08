
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		
		
		return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack() {
		//var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		//alert(Validator);
		return true;
	}
	function workflowSubmitCallBack(buttonText){
		//return workflowSaveCallBack();
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return isPassed;}
		return true;
    }

	function formPageReadOnlyCallBack(){
		jQuery("input[name='dealer_contract_info.cautionmoney']").attr({
            readOnly:false
	     }).removeClass("element-readonly");
	    //formJSPInputHideOrShow("proj_base_info","dealer_contract_info.cautionmoney",1);
	}
</script>

<div class="fillTableContainer">
<input type="hidden" name="json_word_list_str" id="id_json_word_list_str"  value='${empty json_word_list_str ? "[]" : json_word_list_str }'>
<table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan=4><!-- 插入项目基本信息 --> <script language="javascript">
			</script> <jsp:include page="proj_base_info.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td colspan=4><!-- 插入项目其它基本信息 --> <jsp:include page="proj_base_other_info.jsp"></jsp:include></td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-survey"></div> 协议清单</td>
	</tr>
	<tr>
		<td colspan=4><!-- 插入项目其它基本信息 -->
		<div id="id_table_word_list_container"	style="overflow: hidden;">
		</div> 
	</tr>
	<tr>
		<td colspan=4><!-- 插入是否提前准备钱 --> <jsp:include page="proj_per_money.jsp"></jsp:include></td>
	</tr>
	<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
</table>
</div>
<script language="javascript">jQuery(function(){	isViewHistoryTask = false;});</script>
<jsp:include page="word_list_info.jsp"></jsp:include></td>
<script language="javascript">jQuery(function(){	isViewHistoryTask = true;});</script>
<script language="javascript">
	isViewHistoryTask = true;
	function fillHiddenVal() {
		var contractEquip = getTracywindyObject('table_id_table_word_list_container');//合同清单
		jQuery('#id_json_word_list_str').val(JsonUtil.encode(contractEquip.getRowsJsonData()));
	}
</script>
