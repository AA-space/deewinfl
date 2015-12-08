
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		//检查租赁物明细
		//if(!checkTracywindyTableData("table_id_table_receivercharge_container","本次收款信息")){return false;}  
		 //if(!checkFundCharge()){return false;};
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		return isPassed;
		
		return true;
	}
	
</script>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
   <tr>
		<td ><!-- 基本信息 -->
		 <jsp:include	page="base_info.jsp"></jsp:include></td>
	</tr>
	  <tr>
		<td ><!-- 配置信息 -->
		 <jsp:include	page="config_base_info.jsp"></jsp:include></td>
	</tr>
	  <tr>
		<td ><!-- 保险信息 -->
		 <jsp:include	page="insure_base_info.jsp"></jsp:include></td>
	</tr>
	  <tr>
		<td ><!-- 保养信息 -->
		 <jsp:include	page="maintain_base_info.jsp"></jsp:include></td>
	</tr>
	 <tr>
		<td ><!-- 评估信息 -->
		 <jsp:include	page="evluate_info.jsp"></jsp:include></td>
	</tr>
</table>
</div>

<script>
	
	var isSubTable = true;
</script>
