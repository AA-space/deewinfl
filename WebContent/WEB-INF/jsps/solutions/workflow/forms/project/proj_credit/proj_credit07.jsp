<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 插入样式和JS -->
<jsp:include page="../proj_approval/base.jsp"></jsp:include>
<!-- 特殊附件显示公用方法 -->
<jsp:include page="../../util/proj_view_file.jsp"></jsp:include>
<!-- 项目立项附件带到租前业务相关流程 -->
<jsp:include page="initFileListParams.jsp"></jsp:include>
<!-- 项目信审申请 -->
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
		return true;
	}
</script>
<!--多行控件  -->
<input type="hidden" id="id_json_proj_equip_str" name="json_proj_equip_str" value='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }'></input>
<input type="hidden" id="id_json_proj_guarantee_method_str" 	name="json_proj_guarantee_method_str" value='${empty json_proj_guarantee_method_str ? "[]" : json_proj_guarantee_method_str }'></input>
<input type="hidden" id="id_json_proj_guarantee_equip_str" name="json_proj_guarantee_equip_str" value='${empty json_proj_guarantee_equip_str ? "[]" : json_proj_guarantee_equip_str }'></input>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan=4><!-- 插入项目基本信息 --> <jsp:include
			page="../proj_approval/proj_base_info.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td colspan=4><!-- 插入项目其它基本信息 --> <jsp:include
			page="proj_base_other_info.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td colspan=4><!-- 插入项目信审其它基本信息 --> <jsp:include
			page="proj_credit_other_info.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td colspan=4><!-- 插入项目评审结果 -->
		 <jsp:include  page="proj_credit_result_info.jsp"></jsp:include>
        </td>
	</tr>
	<tr>
       <td colspan=4><jsp:include page="proj_credit_reportxls.jsp"></jsp:include></td>
    </tr>
	<tr>
		<td colspan=4><!-- 插入项目信审结论 -->
		 <jsp:include  page="proj_credit_result.jsp"></jsp:include>
        </td>
	</tr>
	<tr>
	<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-project-business-condition"></div>
		项目商务条件</td>
	</tr>
	<tr>
		<td colspan=4></td>
	</tr>
	<tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
		<!-- 标签栏 -->
		<div id='id_project_info_tabs_content' style="">
		<div title="租赁物明细">
		<div id="id_table_leasing_proj_equip_container"
			style="overflow: hidden;"></div>
		</div>
		<div title="拟商务条件">
		<div id="id_table_leasing_proj_condition_container"
			style="overflow: hidden;">
			<jsp:include page="../../rent_reckon/rent_reckon/main.jsp"></jsp:include></div>
		</div>
		<div title="担保单位信息">
		<div id="id_table_leasing_proj_guarantee_method_container"
			style="overflow: hidden;"></div>
		</div>
		<div title="租金发票类型">
		<div id="id_table_leasing_proj_rent_type_container"
			style="height: 350px;"><jsp:include page="../proj_approval/proj_invoice.jsp"></jsp:include>
		</div>
		</div>
	</div>
		</td>
	</tr>
</table>
</div>
<!--避免在tabs中的js重复执行-->
<jsp:include page="../proj_approval/proj_equip_detail.jsp"></jsp:include>
<jsp:include page="../proj_approval/proj_guarantee_method.jsp"></jsp:include>
<script>
	//页面初始化
	var isSubTable=true;
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
