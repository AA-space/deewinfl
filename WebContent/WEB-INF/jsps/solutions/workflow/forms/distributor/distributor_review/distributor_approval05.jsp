
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
	//是否保存   
	isViewHistoryTask = true;
	checkContractId=false;
	
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return isPassed;}
		
		return true;
	}
	function formPageReadOnlyCallBack(){
		if(!isCompletedTask){
		  //formJSPInputHideOrShow("dealer_credit_info_table","",1);
		  formJSPInputHideOrShow("p_id_contractnum","",1);
		}
     }
	//保存成功提交后，后台返回
	function saveCallBack(rs) {
		if(String(rs)!=""){
			alert(rs);
			checkContractId=false;
		}else{
			checkContractId=true;
		}
		return true;
	}

	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		   var contractnum=$("#id_contractnum").val();
		   contractnum=contractnum.replace(/[ ]/g, "");
		   $("#id_contractnum").val(contractnum);
		   if(contractnum==""){alert("请填写合作经销商编号");return false;}
		   var submitProcessedForm = document.getElementById("id_submitProcessedForm");
			var isPassed = Validator.Validate(submitProcessedForm,1,false);
			if(!isPassed){return isPassed;}
			if(checkContractId){
				return workflowSaveCallBack();
			}else{
				alert("请先点击保存以便校验合作经销商编号,或者您的合作经销商编号唯一校验未通过!");
				return false;
			}

	}
</script>
<div class="fillTableContainer">
<table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan=4><!-- 插入项目基本信息 --> 
		<jsp:include page="proj_base_info3.jsp"></jsp:include>
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
	 <tr>
	    <td colspan=4>
	     <jsp:include page="proj_limit_manager.jsp"></jsp:include>
	    </td>
	</tr>
</table>
</div>
<script language="javascript">
isViewHistoryTask = true;
</script>