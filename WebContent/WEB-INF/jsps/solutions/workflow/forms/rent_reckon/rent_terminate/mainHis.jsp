<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div class="fillTableContainer"><!-- 分支版本提交测试-->
   <table class="fillTable" cellspacing="0" cellpadding="0">
    <tr>
        <td class="x-panel-table-div-title">
        <div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contract-plan-terminate"></div>结算条件
        </td>
    </tr>
    <tr class="tr-contract-plan-terminate" >
	    <td>
	    	<table class="fillTable" id="plan_rent_terminate_form">
		    	<tr class="tr-even" >
			       	<td >资产所有权</td>
			        <td ><input class="td-content-input"  name="fund_rent_adjust.assetownership" id="assetOwnerShip" type="text" value="${requestScope['fund_rent_adjust.assetownership']}" maxlength="100" maxB="100" Require="true" label='资产所有权'><font class="required-content">*</font></td>
					<td >约定终止日</td>
					<td ><input class="Wdate td-content-input td-content-readonly"   name="fund_rent_adjust.paydayadjust" id="paydayAdjust" type="text" value="${requestScope['fund_rent_adjust.paydayadjust']}"  dataType="Date"  onclick="WdatePicker(this,{readOnly:true})"  Require="true"  label='资产所有权' onchange="arrangeEndDate()"><font class="required-content">*</font></td>
				</tr>
			    <tr class="tr-odd" >
			       	<td >其他应收</td>
			           <td ><input class="td-content-input td-content-readonly"  name="fund_rent_adjust.otherin" id="otherIn" type="text" value="${requestScope['fund_rent_adjust.otherin']}"  readonly></td>
					<td >其他应退</td>
					<td ><input class="td-content-input td-content-readonly"  name="fund_rent_adjust.otherout" id="otherOut" type="text" value="${requestScope['fund_rent_adjust.otherout']}" readonly></td>
				</tr>
			    <tr class="tr-even" >
			       	<td >已到期租金</td>
			           <td ><input class="td-content-input td-content-readonly"  name="fund_rent_adjust.dunrent" id="dunRent" type="text" value="${requestScope['fund_rent_adjust.dunrent']}" readonly></td>
					<td >逾期罚息</td>
					<td ><input class="td-content-input td-content-readonly"  name="fund_rent_adjust.dunpenalty" id="dunPenalty" type="text" value="${requestScope['fund_rent_adjust.dunpenalty']}"  readonly></td>
				</tr>
			    <tr class="tr-odd">
			       	<td >未到期本金</td>
			           <td ><input class="td-content-input td-content-readonly"  name="fund_rent_adjust.corpusoverage" id="corpusOverage" type="text" value="${requestScope['fund_rent_adjust.corpusoverage']}" readonly></td>
					<td >违约手续费</td>
					<td ><input class="td-content-input"  name="fund_rent_adjust.handlingcharge" id="handlingCharge" type="text" value="${requestScope['fund_rent_adjust.handlingcharge']}" datatype="Double" Require="true" label='违约手续费' onblur="contractClaimTotal()"><font class="required-content">*</font></td>
				</tr>
			    <tr class="tr-even" >
			       	<td > 商定罚息</td>
			           <td ><input class="td-content-input"  name="fund_rent_adjust.agreedpenalty" id="agreedPenalty" type="text" value="${requestScope['fund_rent_adjust.agreedpenalty']}" datatype="Double" Require="true" label='商定罚息' onblur="contractClaimTotal()"><font class="required-content">*</font></td>
					<td > 商定利息</td>
					<td ><input class="td-content-input"  name="fund_rent_adjust.agreedinterest" id="agreedInterest" type="text" value="${requestScope['fund_rent_adjust.agreedinterest']}" datatype="Double"  Require="true" label='商定利息'><font class="required-content">*</font></td>
				</tr>
			    <tr class="tr-odd">
					<td > 合同债权总计</td>
					<td ><input class="td-content-input td-content-readonly"  name="fund_rent_adjust.contracttotal" id="contractTotal" type="text" value="${requestScope['fund_rent_adjust.contracttotal']}" readonly></td>
			       	<td >
				       	<input name="fund_rent_adjust.adjustsavetype" id="adjustsavetype"  type="hidden" value="${requestScope['fund_rent_adjust.adjustsavetype']}">
				        <input name="fund_rent_adjust.adjusttype" id="adjuststype"  type="hidden" value="${requestScope['fund_rent_adjust.adjusttype']}">
				        <input name="fund_rent_adjust.contractid"  type="hidden" value="${requestScope['fund_rent_adjust.contractid']}"  ><!-- 合同表中的主键Id -->
				        <input name="fund_rent_adjust.contract"  type="hidden" value="${requestScope['fund_rent_adjust.contract']}"  ><!-- 合同表中的合同号 -->
				        <input name="fund_rent_adjust.docid"  type="hidden" value="${requestScope['fund_rent_adjust.docid']}"  >
				        <input name="fund_rent_adjust.startlist" id="startList"  type="hidden" dataType="PInteger" value="${requestScope['fund_rent_adjust.startlist']}" >
        				<input name="fund_rent_adjust.adjustlist" id="adjustList"   type="hidden" dataType="PInteger" value="${requestScope['fund_rent_adjust.adjustlist']}" />
        				<input name="fund_rent_adjust.yearrate" id="adjustYearRate"  type="hidden" dataType="Rate" value="${requestScope['fund_rent_adjust.yearrate']}" />
				        <input type="hidden" id="id_json_fund_rent_plan_str" name="json_fund_rent_plan_str" value='${empty json_fund_rent_plan_str ? "[]" : json_fund_rent_plan_str}'/><%--租金计划 --%>
						<input type="hidden" id="id_json_fund_cash_flow_str" name="json_fund_cash_flow_str" value='${empty json_fund_cash_flow_str ? "[]" : json_fund_cash_flow_str }'/><%--现金流 --%>
					剩余保证金
					</td>
					<td><input class="td-content-input td-content-readonly"  name="fund_rent_adjust.deductible" id="deductible" type="text" value="${requestScope['fund_rent_adjust.deductible']}" disabled="disabled"></td>
				</tr>
				<tr class="tr-even">
				 	<td>本次抵扣保证金</td>
				 	<td><input class="td-content-input"  type="text" name="fund_rent_adjust.currentcautionmoney" id="currentcautionmoney" value="${requestScope['fund_rent_adjust.currentcautionmoney']}"></input></td>
				    <!-- 
				     <td class="td-content">
			        <input style="margin-top:2px;margin-bottom:2px;" id="btn_rent_cal_adjust" class="btn btn-primary" type="button" value="结算" onclick="submitTerminate()"/>
					<input style="margin-top:2px;margin-bottom:2px;" id="btn_rent_cal_reset" class="btn btn-primary" type="button" value="撤销" onclick="resetTerminate()"/>
			        </td>
			         -->
				</tr>
			</table>
	    </td>
    </tr>
    <tr class="tr-contract-plan-terminate-data">
		<td  class="td-tabs-container" style="text-indent: 0px;">
			<div id='id_contract_terminate_tabs_content' style="">
				<div title="商务条件[结算后]">
					<div id="id_table_leasing_rent_plan_container"	style="overflow: hidden;">
						<jsp:include page="fund_rent_plan_frame.jsp"/>
					</div>
				</div>

			</div>
		</td>
	</tr> 
    </table>
</div>
<script>
jQuery(function() {
	jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
	$("#id_contract_terminate_tabs_content").css("width", (formWidth) + "px");
	$("#id_contract_terminate_tabs_content").tabs();
});
function submitTerminate(){
	if(checkTerminateData()){
		jQuery("#adjustsavetype").val("terminate");
		terminateCalculateSubmit("${pageContext.request.contextPath}/leasing/adjustCalculateOld.action");
	}
}
function resetTerminate(){
	if(confirm("你确定要清除调整吗?")){
		jQuery("#adjustsavetype").val("reset");
		terminateCalculateSubmit("${pageContext.request.contextPath}/leasing/resetAdjust.action");
	}
}
function terminateCalculateSubmit(todoAction)
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
    var $submitConditionForm = $("#plan_rent_terminate_form");
    var url = todoAction;
    var params = $submitConditionForm.tracywindySerializeFormToJsonObject(true,true);
    ajaxRequest({
    	 method:'POST',
         url:url,
         params:params,
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
     	    	ajaxTerminateRentCalculateCallBack(res);
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
//约定终止日事件
function arrangeEndDate(){
	var contractId = $("input[name='contract_info.id']").val();
	var endDate = $("input[name='fund_rent_adjust.paydayadjust']").val();
    var url = "${pageContext.request.contextPath}/leasing/contractMidwayEnd.action";
    var params = {contract_id:contractId,end_date:endDate};
    ajaxRequest({
    	 method:'POST',
         url:url,
         params:params,
         failure:function(res){
        	alert("访问服务器进行测算已到期租金、未到期本金、逾期罚息失败!");
         },
         success:function(res){
 	   		res=res.responseText;
 	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
     	    if(res!=''){
     	    	var rs=JsonUtil.decode(res);
     	    	$("input[name='fund_rent_adjust.dunrent']").val(rs['arrangerentfund']);
     	    	$("input[name='fund_rent_adjust.corpusoverage']").val(rs['noarrangecorpusfund']);
     	    	$("input[name='fund_rent_adjust.dunpenalty']").val(rs['penaltyoverage']);
     	    }else{
     	    	$("input[name='fund_rent_adjust.dunrent']").val('0');
     	    	$("input[name='fund_rent_adjust.corpusoverage']").val('0');
     	    	$("input[name='fund_rent_adjust.dunpenalty']").val('0');
     	    	alert("请求测算已到期租金、未到期本金、逾期罚息成功,但无结果返回,请重新尝试!");
     	    }
         }
    });
}
function ajaxTerminateRentCalculateCallBack(returnResult){
	 jQuery("#id_workflowAdviseContainer").css("overflow","auto");
	 jQuery("#id_workflowFormContainer").css("overflow","auto");
	 loadMask.hide();
	 var rs=JsonUtil.decode(returnResult);
	 if(rs['rentcalculaters']=="yes"){
	  	 var fundRentPlan = getTracywindyObject('table_id_table_leasing_rent_plan_container');
	  	 fundRentPlan.tableData = rs['fundrentplan'];
		//保存多行控件的值
	  	 jQuery('#id_json_finance_rent_plan_str').val(JsonUtil.encode(rs['finarentplan'])) ;
	  	 jQuery('#id_json_fund_cash_flow_str').val(JsonUtil.encode(rs['fundcashdetail'])) ;
	  	 jQuery('#id_json_finance_cash_flow_str').val(JsonUtil.encode(rs['finacashdetail'])) ;
		 jQuery('#id_json_fund_rent_plan_str').val(JsonUtil.encode(rs['fundrentplan'])) ;
		 fundRentPlan.reload();
	 }
     alert(rs['rentcalculatemsg']);
}
function checkTerminateData(){
	var submitForm =document.getElementById("plan_rent_terminate_form");
	var isPassed = Validator.Validate(submitForm,1,false);
	if(isPassed){
		var paydayAdjust=jQuery("#paydayAdjust").val();
		var planData=getTracywindyObject('multiTable_id_table_leasing_rent_plan_container').datas;
		if(paydayAdjust!=''){
			var nowDate='${requestScope["fund_rent_adjust.nowdate"]}';
			var nowDiff=datediff('day',nowDate,paydayAdjust);
			if(nowDiff*1>0){
				alert("约定终止日不能小于今天!");
				return false;
			}else{
				var startList=-1;
				for(var index=0;planData.length;index++){
					var pd=planData[index];
					var beforeDate=pd["plandate"];
					nowDiff=datediff('day',beforeDate,paydayAdjust);
					if(nowDiff*1>=0){
						startList=(pd["rentlist"]-1);
						break;
					}
				}
				if(startList>0){
					if(planData[startList]["planstatusid"].toLowerCase()!='planmanystatusno'){
						alert("只能从[未收款]期项开始!");
						return false;
					}else{
						jQuery("#startList").val(startList+1);
						jQuery("#adjustList").val(startList+1);
						jQuery("#adjustYearRate").val(decimal(planData[startList]["yearrate"],6));
					}
				}else{
					if(confirm("约定终止日可能不在租赁期限之内，您确定要继续吗？")){
						jQuery("#startList").val(planData.length);
						jQuery("#adjustList").val(planData.length);
					}else{
						return false;
					}
				}
			}
		}
		return true;
	}
	return false;
}
function contractClaimTotal(){
	var otherin = $("input[name='fund_rent_adjust.otherin']").val();
	var otherout = $("input[name='fund_rent_adjust.otherout']").val();
	var dunpenalty = $("input[name='fund_rent_adjust.dunpenalty']").val()=="" ? "0":$("input[name='fund_rent_adjust.dunpenalty']").val();
	var handlingcharge = $("input[name='fund_rent_adjust.handlingcharge']").val()=="" ? "0":$("input[name='fund_rent_adjust.handlingcharge']").val();
	var agreedpenalty = $("input[name='fund_rent_adjust.agreedpenalty']").val()=="" ? "0":$("input[name='fund_rent_adjust.agreedpenalty']").val();
	if(!isNaN(handlingcharge) && !isNaN(agreedpenalty)){
		var contracttotal = parseFloat(otherin) + parseFloat(dunpenalty) + parseFloat(handlingcharge) + parseFloat(agreedpenalty) - parseFloat(otherout);
		$("input[name='fund_rent_adjust.contracttotal']").val(contracttotal);
	}else{
		alert("违约手续费或商定罚息必须为数字");
	}
}
</script>