
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
	//是否保存   
	isViewHistoryTask = true;
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return isPassed;}
		return true;
	}
</script>
<div class="fillTableContainer">
<table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan=4><!-- 插入项目基本信息 --> 
		 <jsp:include page="proj_base_info.jsp"></jsp:include>
		</td>
	</tr>

	<tr>
		<td colspan=4><!-- 插入是否提前准备钱 -->
		<jsp:include page="proj_per_money.jsp"></jsp:include>
			</td> 
	</tr>

	<tr>
		<td colspan=4><!-- 插入项目其它基本信息 -->
		 <jsp:include page="proj_base_other_info.jsp"></jsp:include>
	  </td>
	</tr>
	<tr>
	    <td colspan=4>
	    <jsp:include page="proj_credit_result_info.jsp"></jsp:include>
	    </td>
	 </tr>
</table>
</div>
<script language="javascript">

</script>