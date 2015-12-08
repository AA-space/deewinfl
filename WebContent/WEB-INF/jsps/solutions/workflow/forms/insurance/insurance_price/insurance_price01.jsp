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
function saveCallBack() {
	var submitProcessedForm = document.getElementById("id_submitProcessedForm");
	return true;
}

	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{ 
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return isPassed;}
	
		return true;
	}
	
	

</script>
<!--多行控件  -->
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td ><!-- 投保车辆信息 -->
		   <jsp:include page="insurance_car_info.jsp"></jsp:include>
		 </td>
	</tr>
	<tr>
		<td ><!-- 必投险种 -->
		   <jsp:include page="insurance_must_info.jsp"></jsp:include>
		</td>
	</tr>
	</table>
</div>

<script>
jQuery(function() {

	jQuery(".calculate").attr("readonly",true);
	jQuery(".calculate").attr("disabled",true);
	//########公共JS事件##########
	jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
});
	//隐藏域在提交或保存前的赋值
		function fillHiddenVal() {
			//var contractEquip = getTracywindyObject('table_id_table_word_list_container');//合同清单
			//jQuery('#id_json_word_list_str').val(JsonUtil.encode(contractEquip.getRowsJsonData()));	
	}
</script>