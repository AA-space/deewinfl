<%---经销商抵押合同事宜办理 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		if(!saveDocReport()){alert("保存抵押备案材料明细出错");return false;}
		return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack() {
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var s=getTracywindyObject("id_combo_cityname");
		$("#cityname").val(s);
		
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		//必填
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return isPassed;}
		if(!saveDocReport()){alert("保存抵押备案材料明细出错");return false;}
		return true;
	}
	
</script>
 
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<tr class="tr-projectdistribut_info">
		<td  >
			<jsp:include page="dealer_info.jsp"></jsp:include>
		</td>
	</tr>
	<tr>
	<td class="td-even-line-separator">&nbsp;</td>
	</tr>
	<!-- tr class="tr-projectdistribut_info">
		<td  >
			<jsp:include page="mortgagor_detail_info.jsp"></jsp:include>
		</td>
	</tr>
	<tr>
	<td class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr class="tr-projectdistribut_info">
		<td >
			<jsp:include page="contract_info.jsp"></jsp:include>
		</td>
	</tr-->
	<tr>
	<td  class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr class="tr-projectdistribut_info">
		<td >
			<jsp:include page="matter_info.jsp"></jsp:include>
		</td>
	</tr>
	<tr>
	<td  class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr class="tr-projectdistribut_info">
		<td  >
			<jsp:include page="material_detail.jsp"></jsp:include>
		</td>
	</tr>
	<tr>
	<td class="td-even-line-separator"><div align="right"><font color="red">备注：以上信息由租赁事业部或经销商填写确认</font></div></td>
	</tr>
</table>
</div>
<script>
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
