
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<jsp:include page="../../util/flow_condition_select.jsp"></jsp:include>
<script type="text/javascript">
	//是否保存   
	//是否提交  
	isViewHistoryTask = true;
	var isSelectRote=false; 
	
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		if(!saveDocReport()){
			alert("保存考察报告出现异常!");
			return false;
		}
		
		return true;
	}
	
	function formPageReadOnlyCallBack(){
		if(!isCompletedTask){
		  //formJSPInputHideOrShow("dealer_credit_info_table","",1);
		  formJSPInputHideOrShow("div_id_dealer_local_report","",1);//现场考察经销商评审报告
		  formJSPInputHideOrShow("div_id_dealer_notlocal_report","",1);//非现场考察经销商评审报告 
		  formJSPInputHideOrShow("id_proj_cedit_result_info","dealer_approval_info.reportscore,dealer_approval_info.reportscorelevel",1);//经销商额度授信建议
		  formJSPInputHideOrShow("div_id_dealer_credit_report","",1);//经销商综合能力评估及合作建议报告
		  formJSPInputHideOrShow("id_credit_report_resultdiv","",1);//负债总额 
		  formJSPInputHideOrShow("dealer_credit_info_table","",1);//额度调整
	  }
     }
	function btn_callBack(buttonText){
		workflowSubmitCallBack(buttonText);
	}
	//是否提交    
	function workflowSubmitCallBack(buttonText)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{   var submitProcessedForm = document.getElementById("id_submitProcessedForm");
        var isPassed = Validator.Validate(submitProcessedForm,1,false);
       if(!isPassed){return isPassed;}
		var agree=getTracywindyObject('id_combo_dealer_creditStatus').getValue();
		if(agree=="conform"){
			 $("#id_approvaldata").val(getCurDate());
		}else{
           $("#id_approvaldata").val("");
		} 
		
		return workflowSaveCallBack();
	}

	
	function workflowNextRouteCallBack(buttonText,requestNextRoute){
	
		var selectRote="";    
         if(buttonText=="Submit"){
        	 var agree=getTracywindyObject('id_combo_dealer_creditStatus').getValue();
     		if(agree=="conform"){
     			selectRote="通过";
     		}else{
     			selectRote="不通过";
     		} 
        	//if(selectRote=="通过"){$("#id_creditresult").val("dealerApprovalstatus4");}else{$("#id_creditresult").val("dealerApprovalstatus5");}
        	 requestNextRoute.value=selectRote;
         }
    }
</script>
<div class="fillTableContainer">
<table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan=4><!-- 插入项目基本信息 -->
		<jsp:include page="proj_base_info2.jsp"></jsp:include>
		</td>
	</tr>

	<tr>
		<td colspan=4><!-- 插入是否提前准备钱 -->
		 <jsp:include page="proj_per_money.jsp"></jsp:include>
		</td> 
	</tr>

	<tr>
		<td colspan=4><!-- 插入项目其它基本信息 -->
		<script language="javascript">
	     jQuery(function(){isViewHistoryTask = false;});
	    </script>
		<jsp:include page="proj_base_other_info.jsp"></jsp:include>
		<script language="javascript">
	     jQuery(function(){isViewHistoryTask = true;});
	    </script>
	    </td>
	</tr>
	<tr>
	    <td colspan=4>
	    <script language="javascript">
	     jQuery(function(){isViewHistoryTask = false;});
	    </script>
	    <jsp:include page="proj_credit_result_info.jsp"></jsp:include>
	    <script language="javascript">
	     jQuery(function(){isViewHistoryTask = true;});
	    </script>
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