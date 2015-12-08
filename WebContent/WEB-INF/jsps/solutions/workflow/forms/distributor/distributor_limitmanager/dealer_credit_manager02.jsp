<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		    fillHiddenVal();
			var submitProcessedForm = document.getElementById("id_submitProcessedForm");
			var isPassed = Validator.Validate(submitProcessedForm,1,false);
			if(!isPassed){return isPassed;}
			return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack(rs) {
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{ 
		
		return workflowSaveCallBack();
	}
	
	

</script>
<!--多行控件  -->
<input type="hidden" name="json_word_list_str" id="id_json_word_list_str"  value='${empty json_word_list_str ? "[]" : json_word_list_str }'>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td ><!-- 插入项目基本信息 -->
		   <jsp:include page="credit_other_info.jsp"></jsp:include>
		 </td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-survey"></div> 通知函清单</td>
	</tr>
	<tr>
		<td ><!-- 通知函模板列表 -->
		<div id="id_table_word_list_container"	style="overflow: hidden;">
		</div> 
	</tr>
	 <tr>
		<td ><!-- 额度调事通知函-->
		<jsp:include page="dealer_limit_evaluate.jsp"></jsp:include></td>
	</tr>
	</table>
</div>
<jsp:include page="word_list_info.jsp"></jsp:include></td>
<script>
	//隐藏域在提交或保存前的赋值
	isViewHistoryTask = true;
		function fillHiddenVal() {
			var contractEquip = getTracywindyObject('table_id_table_word_list_container');//合同清单
			jQuery('#id_json_word_list_str').val(JsonUtil.encode(contractEquip.getRowsJsonData()));
		}

</script>