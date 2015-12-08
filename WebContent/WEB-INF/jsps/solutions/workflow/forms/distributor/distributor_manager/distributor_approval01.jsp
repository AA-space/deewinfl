
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>

<script type="text/javascript">
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{ 
		if(!saveDocReport()){
			alert("保存资料清单信息出现异常!");
			return false;
		}
		return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack(rs) {
	
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		//var isPassed = Validator.Validate(submitProcessedForm,1,false);
		//if(!isPassed){return isPassed;}
	   return workflowSaveCallBack();			
	}	
	//isViewHistoryTask = true;
</script>

<div class="fillTableContainer">
<table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan=4><!-- 插入经销商基本信息 --> <jsp:include
			page="proj_base_info.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td colspan=4><!-- 插入经销商材料基本信息 --> 
		
		<jsp:include page="proj_base_other_info.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td colspan=4><!-- 插入申请 人，申请部门，申请时间 --> <jsp:include
			page="proj_per_money.jsp"></jsp:include></td>
	</tr>
</table>
</div>

