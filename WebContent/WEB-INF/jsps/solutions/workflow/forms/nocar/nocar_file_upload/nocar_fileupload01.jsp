<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<!-- 项目信审申请 -->
<script type="text/javascript">
	//是否保存   
	//只读回调
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		createProjectName();
		return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack() {
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		//alert(Validator);
		return true;
	}
	 
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		createProjectName();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return isPassed;}
		return true;
	}
	
</script>
 
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan=4><!-- 插入项目基本信息 --> <jsp:include
			page="../../nocar/apply/nocar_base_info.jsp"></jsp:include></td>
	</tr>
	<tr>
			<td colspan="4">
				<!-- 插入法人客户信息 --> <jsp:include page="../../nocar/apply/nocar_apply_custom_info.jsp"></jsp:include>
			</td>
		</tr>
	 
	 
	 
</table>
</div>
 
<script>
	//生成项目名称
	function createProjectName() {
		var project_name =jQuery('#project_name').val();
		var dept_name = getTracywindyObject('id_combo_proj_info.projdept')
				.getRawValue();
		var proj_id=$("#project_id").val();
		var cust_name=$("#cust_name").val();
		if (project_name == '') {
			project_name = proj_id+"-"+dept_name+"-"+cust_name + '项目';
		}
		jQuery('#project_name').val(project_name);
	}
	//页面初始化
	var isSubTable=true;
	//全局变量说是这一个只读业页
	isViewHistoryTask = true;
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
