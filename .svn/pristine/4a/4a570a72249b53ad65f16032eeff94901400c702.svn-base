<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">

//全局变量说是这一个只读业页
isViewHistoryTask = true;
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
			return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{ 
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return isPassed;}
	
		return workflowSaveCallBack();
	}
	
	

</script>
<!--多行控件  -->
<input type="hidden" name="json_word_list_str" id="id_json_word_list_str"  value='${empty json_word_list_str ? "[]" : json_word_list_str }'>
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
	//jQuery(".nocalculate").attr("readonly",true);
	jQuery(":radio").attr("disabled",true);
	//jQuery(".calculate").removeClass("element-readonly",false);
	//jQuery(".calculate").raplace(/\s{1,}/gm," ");
	//########公共JS事件##########
	jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
	$(":checkbox").attr("disabled","disabled");
	//var checkbox = $("#ce").find("input:checkbox");
	   //checkbox.attr("disabled","disabled");
	    $(":checkbox").each(function(){
	     if($(this).val()=="${requestScope['insurance_price.insurance9']}"){
	        $(this).attr("checked",true);
	     }    
	   });
});
  function formPageReadOnlyCallBack(){
	  jQuery(".calculate").attr("readOnly",false);
	  jQuery(".calculate").removeClass("element-readonly",false);
  }
	//隐藏域在提交或保存前的赋值
		function fillHiddenVal() {
			//var contractEquip = getTracywindyObject('table_id_table_word_list_container');//合同清单
			//jQuery('#id_json_word_list_str').val(JsonUtil.encode(contractEquip.getRowsJsonData()));	
	}
</script>