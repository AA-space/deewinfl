<%---经销商抵押合同事宜办理 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
isViewHistoryTask = true;
//只读回调
function formPageReadOnlyCallBack(){
   if(!isCompletedTask){
      
	     formJSPInputHideOrShow("id_sent_info","",1);
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
		//var submitProcessedForm = document.getElementById("id_submitProcessedForm");
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
		//检查经销商抵押合同事宜办理
		if(!checkTracywindyTableData("table_id_table_leasing_mortgage_info_container","经销商抵押合同事宜办理")){return false;}
		return true;
	}
	
</script>
<!--多行控件  -->
<input type="hidden" id="id_json_mortgage_info_str" name="json_mortgage_info_str" value='${empty json_mortgage_info_str ? "[]" : json_mortgage_info_str }'></input>
<!--结束多行控件  -->
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<%---选项卡 --%>
	<tr class="tr-projectdistribut_info">
		<td colspan=4 >
			<jsp:include page="distribut_info.jsp"></jsp:include>
		</td>
	</tr>
	<tr>
	<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<%---选项卡 --%>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-project-business-condition"></div>
		申请材料</td>
	</tr>
	<tr class="tr-project-business-condition">
		<td colspan=4 >
			<div id="id_table_leasing_mortgage_info_container">
		</div>
		</td>
	</tr>
	<tr>
		<td colspan=4 >
			<jsp:include page="mortgage_apply_info.jsp"></jsp:include>
		</td>
	</tr>
	<tr>
		<td colspan=4 >
			<jsp:include page="mortgage_sent_info.jsp"></jsp:include>
		</td>
	</tr>
	<%---结束选项卡 --%>
</table>
</div>
<jsp:include page="mortgage_other_info.jsp"></jsp:include>
<div>
<jsp:include page="mortgage_explain.jsp"></jsp:include>
</div>




<script>
     function fillHiddenVal() {
	   var contract= getTracywindyObject('table_id_table_leasing_mortgage_info_container');//材料清单
	   jQuery('#id_json_mortgage_info_str').val(JsonUtil.encode(contract.getRowsJsonData()));
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
		$("#id_project_fund_rent_plan_tabs_content").css("width",
				(formWidth) + "px");
		$("#id_project_fund_rent_plan_tabs_content").tabs();
		//jQuery(".fillTableContainer").css("width",formWidth+"px");
	});
</script>
