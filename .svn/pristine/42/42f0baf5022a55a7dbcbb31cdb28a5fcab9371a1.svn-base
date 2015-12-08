
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!-- 插入样式和JS -->
<jsp:include page="../project/proj_approval/base.jsp"></jsp:include>
<!-- 特殊附件显示公用方法 -->
<!-- 项目立项附件带到租前业务相关流程 -->
<!-- 项目信审申请 -->
<script type="text/javascript">
	//是否保存   
	//只读回调
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		return true;
	}
	//只读反转
	function formPageReadOnlyCallBack(){
	       
	}
	//保存成功提交后，后台返回
	function saveCallBack() {
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		return true;
	}

	//是否提交    
	function workflowSubmitCallBack(buttonText)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		return true;
	}
	

</script>
<!--多行控件  -->
<input type="hidden" id="id_json_proj_gps_str" name="json_proj_gps_str" value='${empty json_proj_gps_str ? "[]" : json_proj_gps_str }'></input>

<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
		<tr id="fund_money_collectioninfo">
			<td colspan=4>
				<!-- 未付设备款明细 --> 
				<jsp:include page="gps_info_one.jsp"></jsp:include></td>
		</tr>
	
		<tr>
			<td colspan=4 class="td-even-line-separator">&nbsp;</td>
		</tr>
    
	<tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
		<!-- 标签栏 -->
		<div id='id_project_info_tabs_content' style="">
		<div title="信息管理">
		<div id="id_table_leasing_proj_equip_container"></div>
		</div>
	</div>
		</td>
	</tr>
	
</table>
</div>
<!--避免在tabs中的js重复执行-->
<jsp:include page="gps_info_manage1.jsp"></jsp:include>
<script>


    
    
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');
		jQuery('#id_json_proj_gps_str').val(
				JsonUtil.encode(currentTable1.getRowsJsonData()));
	}
	//页面初始化
	var isSubTable=true;
	//全局变量说是这一个只读业页
	isViewHistoryTask = false;
	//法人附件上传权限
	
	
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
	
	});
</script>
