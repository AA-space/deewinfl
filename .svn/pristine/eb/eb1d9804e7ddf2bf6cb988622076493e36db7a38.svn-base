<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<c:set var="business_type" value="${requestScope['business_type']}"/>
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
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return isPassed;}
		return true;
	}else{
		alert("您没有进行过任何变更调整!");
		return false;
	}
}
</script>
<!--多行控件  -->
<input type="hidden" id="fundrentadjustcontract" name="fund_rent_adjust.contract"  value='${requestScope["fund_rent_adjust.contract"]}'/>
<input type="hidden" id="fundrentadjustcontractid" name="fund_rent_adjust.contractid"  value='${requestScope["fund_rent_adjust.contractid"]}'/>
<input type="hidden" id="fundrentadjustdocid" name="fund_rent_adjust.docid"  value='${requestScope["fund_rent_adjust.docid"]}'/>
<input type="hidden" id="fundrentadjustadjusttype" name="fund_rent_adjust.adjusttype"  value='${requestScope["fund_rent_adjust.adjusttype"]}'/>
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
					<div title="租金计划修改">
					    <span class="print-tabs-title-content">租金计划修改</span>
					    <div id="id_table_leasing_rent_plan_mod_content"	style="overflow: hidden;">
							<jsp:include page="../../rent_reckon/rent_update/main_now.jsp"></jsp:include>	
						</div>
					</div>
					<div title="租金计划[原]">
					    <span class="print-tabs-title-content">租金计划[原]</span>
					    <div id="id_table_leasing_rent_plan_mod_content"	style="overflow: hidden;">
							<jsp:include page="../../rent_reckon/rentOld/main.jsp"></jsp:include>	
						</div>
					</div>
					<div title="租金计划变更原因及内容">
						<span class="print-tabs-title-content">租金计划变更原因及内容</span>
						<div id="id_table_leasing_rent_plan_reason_content"
							style="overflow: hidden;">
							<jsp:include page="../plan_change/plan_reason_content.jsp"></jsp:include>
							</div>
					</div>	
					
			</div>
		</td>
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
		if('${isFirstTask}'){//第一步
			formJSPInputHideOrShow("id_table_leasing_rent_plan_reason_content",'',1);//第一步能用
		}
	}
}
function submitByPlanUpdate(){
	adjustCalculateSubmit("${pageContext.request.contextPath}/leasing/updateCalculateOld.action");
}
function adjustCalculateSubmit(todoAction)
{
    //条件通过提交表单
    jQuery("#id_workflowAdviseContainer").css("overflow","hidden");
    jQuery("#id_workflowFormContainer").css("overflow","hidden");
    if(!loadMask)
    {
    	loadMask = new tracywindyLoadMask(document.body,"数据处理中，请稍等...");
    }
    loadMask.show();
    window.top.document.body.style.overflow="hidden";
    var url = todoAction;
    ajaxRequest({
    	 method:'POST',
         url:url,
         params:{
        	fundrentplan:JsonUtil.encode(getTracywindyObject('table_id_table_leasing_rent_plan_container').getRowsJsonData()),
        	contractid:jQuery("#fundrentadjustcontractid").val(),
        	contract:jQuery("#fundrent_adjustcontract").val(),
        	docid:jQuery("#fundrentadjustdocid").val()
    	 },
         failure:function(res){
    		jQuery("#id_workflowAdviseContainer").css("overflow","auto");
       		jQuery("#id_workflowFormContainer").css("overflow","auto");
   	 		loadMask.hide();
        	alert("访问服务器进行测算失败[服务器正忙,或者无法连通,或者服务器出现异常]!");
         },
         success:function(res){
        	chenckCondiotn=true;
 	   		res=res.responseText;
 	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
     	    if(res!=''){
     	    	ajaxAdjustRentCalculateCallBack(res);
     	    }else{
     	    	jQuery("#id_workflowAdviseContainer").css("overflow","auto");
           		jQuery("#id_workflowFormContainer").css("overflow","auto");
       	 		loadMask.hide();
     	    	alert("请求测算成功,但无结果返回,请重新尝试!");
     	    }
         }
    });
	return false;
}
function ajaxAdjustRentCalculateCallBack(returnResult){
	 jQuery("#id_workflowAdviseContainer").css("overflow","auto");
	 jQuery("#id_workflowFormContainer").css("overflow","auto");
	 loadMask.hide();
	 var rs=JsonUtil.decode(returnResult);
	 if(rs['rentcalculaters']=="yes"){
	  	 var fundRentPlan = getTracywindyObject('table_id_table_leasing_rent_plan_container');
	  	 fundRentPlan.tableData = rs['fundrentplan'];
	  	 var fundCashDetail = getTracywindyObject('table_id_table_leasing_fund_cash_flow_container');
	  	 fundCashDetail.tableData = rs['fundcashdetail'];   	 
	  	 jQuery('#irr').val(decimal((rs['irr']),6)) ;
	  	 jQuery('#planIrr').val(decimal((rs['planirr']),6));
	  	 jQuery('#enddate').val(rs['enddate']);
  		 jQuery('#yearRate').val(rs['yearrate']);
  		 jQuery('#incomeNumber').val(rs['incomenumber']);
  		 jQuery('#leaseTerm').val(rs['leaseterm']);
		//保存多行控件的值
	  	 jQuery('#id_json_fund_cash_flow_str').val(JsonUtil.encode(fundCashDetail.getRowsJsonData())) ;
		 jQuery('#id_json_fund_rent_plan_str').val(JsonUtil.encode(fundRentPlan.getRowsJsonData())) ;
		 fundRentPlan.reload();
	  	 fundCashDetail.reload();
	  	 getTracywindyObject("id_combo_id_settle_method").setValue("irregular_rent");
	 }
     alert(rs['rentcalculatemsg']);
}
</script>
