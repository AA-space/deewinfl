
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="base.jsp"></jsp:include>
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
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		//必填
		
		return true;
	}
	//流程提交是设置条件路由
	
</script>
<!--多行控件  -->
<input type="hidden" id="id_json_fund_limit_str" name="json_fund_limit_str" value='${empty json_fund_limit_str ? "[]" : json_fund_limit_str }'></input>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	
	<tr>
		<td colspan=4><!-- 插入项目其它基本信息 -->
		<div id="id_table_fund_limit_add_id"></div>
	</tr>
	
</table>
</div>
<!--避免在tabs中的js重复执行-->
<jsp:include page="fund_limit_add.jsp"></jsp:include>

<script>
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		//租赁物件
		var currentTable1 = getTracywindyObject('table_id_table_fund_limit_add_id');
		jQuery('#id_json_fund_limit_str').val(
				JsonUtil.encode(currentTable1.getRowsJsonData()));
	}
	
	var isSubTable = true;
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_project_info_tabs_content").tabs();
		
	});
</script>
