<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
var isSubTable = false;
isViewHistoryTask=true;//直接设置整个表单只读
//是否保存   
function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
{
	fillHiddenVal();
	return true;
}
//保存成功提交后，后台返回
function saveCallBack() {
	return true;
}
//是否提交    
function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
{
	if(jQuery("#adjustsavetype").val()!=""){
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		//关闭验证
		//var isPassed = Validator.Validate(submitProcessedForm,1,false);
		//if(!isPassed){return isPassed;}
		return true;
	}else{
		alert("您没有进行过任何变更调整!");
		return false;
	}
}
</script>

<!--多行控件  -->
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan=4><!-- 插入合同基本信息 --> <jsp:include
			page="../../contract/contract_approval/contract_base_info.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td colspan=4></td>
	</tr>
	<tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
			<!-- 标签栏 -->
			<div id='id_project_info_tabs_content' style="">
					<div title="租金计划变更">
					    <span class="print-tabs-title-content">租金计划变更</span>
					    <div id="id_table_leasing_rent_plan_chang_content"	style="overflow: hidden;">
							<jsp:include page="../../rent_reckon/rent_adjust/main.jsp"></jsp:include>	
						</div>
					</div>
					<div title="租金计划变更原因及内容">
						<span class="print-tabs-title-content">租金计划变更原因及内容</span>
						<div id="id_table_leasing_rent_plan_reason_content"	style="overflow: hidden;">
							<jsp:include page="plan_reason_content.jsp"></jsp:include>	
						</div>
					</div>	
					<div title="上传附件">
						<span class="print-tabs-title-content">上传附件</span>
						<div id="id_table_leasing_rent_plan_attachment"	style="overflow: hidden;">
						  <jsp:include page="upload_word.jsp"></jsp:include>	
						</div>
					</div>	
			</div>
		</td>
	</tr>
</table>
</div>
<!--避免在tabs中的js重复执行-->
<script>
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_project_info_tabs_content").tabs();
		isSubTable = true;
	});
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		saveReckonJsonValue();
	}
  	//只读回调
    function formPageReadOnlyCallBack(obj){
    	if(!isCompletedTask){
    		formJSPInputHideOrShow("id_submitFrameworkConditionForm",'',0);//禁用原表
    		formJSPInputHideOrShow("id_submitFrameworkConditionFormOld",'',0);//禁用现表单
    		formJSPInputHideOrShow("contract_base_info",'',0);//禁用合同基本信息
    		jQuery('#btn_rent_cal').hide();//禁用现表单中的租金测算按钮
    		jQuery('#btn_rent_cal_adjust').hide();//禁用现表单中的租金测算按钮
    		jQuery('#btn_rent_cal_reset').hide();//禁用现表单中的租金测算按钮
    		if('${isFirstTask}'){//第一步
    			jQuery('#btn_rent_cal_adjust').show();//禁用现表单中的租金测算按钮
    			jQuery('#btn_rent_cal_reset').show();//禁用现表单中的租金测算按钮
    			formJSPInputHideOrShow("plan_rent_change_form",'fund_rent_adjust.startlist',1);//第一步能用
    			formJSPInputHideOrShow("id_table_leasing_rent_plan_reason_content",'',1);//第一步能用
    		}
    	}
    }
</script>
