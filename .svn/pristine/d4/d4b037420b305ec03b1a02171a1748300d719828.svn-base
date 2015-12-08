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
			        <td ><input class="td-content-input" id="id_fund_rent_adjust_assetownership"  name="fund_rent_adjust.assetownership" id="assetOwnerShip" type="text" value="${requestScope['fund_rent_adjust.assetownership']}" maxlength="100" maxB="100" Require="true" label='资产所有权'><font class="required-content">*</font></td>
					<td >提前结清比例(百分比)%</td>
			        <td ><input class="td-content-input"  name="fund_rent_adjust.advancerate" id="id_advancerate" type="text" value="${empty requestScope['fund_rent_adjust.advancerate']?100:requestScope['fund_rent_adjust.advancerate']}" datatype="Double" Require="true" label='提前结清比例'  onchange="arrangeEndDate()"><font class="required-content">*</font></td>
					<td >约定终止日</td>
					<td ><input class="Wdate td-content-input td-content-readonly"   name="fund_rent_adjust.paydayadjust" id="paydayAdjust" type="text" value="${empty requestScope['fund_rent_adjust.paydayadjust']?'':requestScope['fund_rent_adjust.paydayadjust']}"  dataType="Date"  onclick="WdatePicker(this,{readOnly:true})"  Require="true"  label='约定终止日' onchange="arrangeEndDate()"><font class="required-content">*</font></td>
				</tr>
			    <tr class="tr-odd" >
			       	<td >其他应收</td>
			           <td ><input class="td-content-input td-content-readonly"  name="fund_rent_adjust.otherin" id="otherIn" type="text" value="${requestScope['fund_rent_adjust.otherin']}"  datatype="Double" Require="true" label='其它应收' readonly>
			           </td>
					<td >其他应退</td>
			           <td ><input class="td-content-input td-content-readonly"  name="fund_rent_adjust.otherout" id="otherOut" type="text" value="${requestScope['fund_rent_adjust.otherout']}" datatype="Double" Require="true" label='其它应退' readonly></td>
			       	<td >已到期未支付租金</td>
		            <td ><input class="td-content-input td-content-readonly"  name="fund_rent_adjust.dunrent" id="dunRent" type="text" value="${empty requestScope['fund_rent_adjust.dunrent']?0:requestScope['fund_rent_adjust.dunrent']}" readonly></td>
				</tr>
			    <tr class="tr-even" >
					<td >逾期罚息</td>
					<td ><input class="td-content-input td-content-readonly"  name="fund_rent_adjust.dunpenalty" id="dunPenalty" type="text" value="${empty requestScope['fund_rent_adjust.dunpenalty']?0:requestScope['fund_rent_adjust.dunpenalty']}"  readonly></td>
			       	<td >未到期本金</td>
			        <td ><input class="td-content-input td-content-readonly"  name="fund_rent_adjust.corpusoverage" id="corpusOverage" type="text" value="${empty requestScope['fund_rent_adjust.corpusoverage']?0:requestScope['fund_rent_adjust.corpusoverage']}" readonly></td>
			       	<td >买断本金</td>
			        <td ><input class="td-content-input td-content-readonly"  name="fund_rent_adjust.monopolizecorpusfund" id="monopolizecorpusfund" type="text" value="${empty requestScope['fund_rent_adjust.monopolizecorpusfund']?0:requestScope['fund_rent_adjust.monopolizecorpusfund']}" readonly></td>
				</tr>
			    <tr class="tr-odd" >
					<td >违约手续费</td>
					<td ><input class="td-content-input"  name="fund_rent_adjust.handlingcharge" id="handlingCharge" type="text" value="${requestScope['fund_rent_adjust.handlingcharge']}" datatype="Double" Require="true" label='违约手续费' onblur="contractClaimTotal()"><font class="required-content">*</font></td>
			       	<td > 商定罚息</td>
			        <td ><input class="td-content-input"  name="fund_rent_adjust.agreedpenalty" id="agreedPenalty" type="text" value="${empty requestScope['fund_rent_adjust.agreedpenalty']?0:requestScope['fund_rent_adjust.agreedpenalty']}" datatype="Double" Require="true" label='商定罚息' onblur="contractClaimTotal()"><font class="required-content">*</font></td>
					<td > 商定利息</td>
					<td ><input class="td-content-input"  name="fund_rent_adjust.agreedinterest" id="agreedInterest" type="text" value="${empty requestScope['fund_rent_adjust.agreedinterest']?0:requestScope['fund_rent_adjust.agreedinterest']}" datatype="Double"  Require="true" label='商定利息'><font class="required-content">*</font></td>
				</tr>
			    <tr class="tr-even">
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
				 	<td>本次抵扣保证金</td>
				 	<td><input class="td-content-input"  type="text" name="fund_rent_adjust.currentcautionmoney" id="currentcautionmoney" value="${empty requestScope['fund_rent_adjust.currentcautionmoney']?0:requestScope['fund_rent_adjust.currentcautionmoney']}" onchange="contractClaimTotal()" ></input></td>
				</tr>
				
				<tr class="tr-odd">
				<td > 合同债权总计</td>
				<td ><input class="td-content-input td-content-readonly"  name="fund_rent_adjust.contracttotal" id="contractTotal" type="text" value="${requestScope['fund_rent_adjust.contracttotal']}" readonly></td>
			    <td class="td-content">
		        <input style="margin-top:2px;margin-bottom:2px;" id="btn_rent_cal_adjust" class="btn btn-primary" type="button" value="结算" onclick="submitTerminate()"/>
				<input style="margin-top:2px;margin-bottom:2px;" id="btn_rent_cal_reset" class="btn btn-primary" type="button" value="撤销" onclick="resetTerminate()"/>
		        </td>
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

	//4、	约定终止日默认值为当天，可以手动选择
	//alert(new Date().Format("yyyy-MM-dd"));
	//var endDate = $("input[name='fund_rent_adjust.paydayadjust']").val( new Date().Format('yyyy-MM-dd') );
	//加载页面时，就先根据结算日重新计算下
	arrangeEndDate();
});

//对Date的扩展，将 Date 转化为指定格式的String   
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
//例子：   
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
Date.prototype.Format = function(fmt)   
{ //author: meizz   
var o = {   
 "M+" : this.getMonth()+1,                 //月份   
 "d+" : this.getDate(),                    //日   
 "h+" : this.getHours(),                   //小时   
 "m+" : this.getMinutes(),                 //分   
 "s+" : this.getSeconds(),                 //秒   
 "q+" : Math.floor((this.getMonth()+3)/3), //季度   
 "S"  : this.getMilliseconds()             //毫秒   
};   
if(/(y+)/.test(fmt))   
 fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
for(var k in o)   
 	if(new RegExp("("+ k +")").test(fmt))   
	fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	return fmt;   
}  


//结算
function submitTerminate(){
	if(checkTerminateData()){
		//重新计算合同债权总计
		contractClaimTotal();
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
	var advancerate = $("input[name='fund_rent_adjust.advancerate']").val();
    var url = "${pageContext.request.contextPath}/leasing/contractMidwayEnd.action";
    var params = {contract_id:contractId,end_date:endDate,advancerate:advancerate};
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
     	    	$("input[name='fund_rent_adjust.dunrent']").val(decimal(rs['arrangerentfund'],2));//已到期未支付租金
     	    	$("input[name='fund_rent_adjust.corpusoverage']").val(decimal(rs['noarrangecorpusfund'],2));//未到期本金
     	    	$("input[name='fund_rent_adjust.monopolizecorpusfund']").val(decimal(rs['monopolizecorpusfund'],2));//买断本金
     	    	$("input[name='fund_rent_adjust.dunpenalty']").val(decimal(rs['penaltyoverage'],2));//逾期罚息
     	    	$("input[name='fund_rent_adjust.handlingcharge']").val(decimal(rs['handlingcharge'],2));//违约手续费
     	    	$("input[name='fund_rent_adjust.currentcautionmoney']").val(decimal(rs['incomecharge'],2));//本次抵扣保证金
     	    	
     	    	$("input[name='fund_rent_adjust.otherin']").val(decimal(rs['otherin'],2));//其它应收
     	    	$("input[name='fund_rent_adjust.otherout']").val(decimal(rs['otherout'],2));//其它应退
     	    	//商定罚息默认 = 逾期罚息
     	    	$("input[name='fund_rent_adjust.agreedpenalty']").val(decimal(rs['penaltyoverage'],2));
     	    	
				//合同债权统计计算
     	    	contractClaimTotal();
     	    }else{
     	    	$("input[name='fund_rent_adjust.dunrent']").val('0');
     	    	$("input[name='fund_rent_adjust.corpusoverage']").val('0');
     	    	$("input[name='fund_rent_adjust.monopolizecorpusfund']").val('0');
     	    	$("input[name='fund_rent_adjust.dunpenalty']").val('0');
     	    	$("input[name='fund_rent_adjust.handlingcharge']").val('0');//违约手续费
     	    	$("input[name='fund_rent_adjust.currentcautionmoney']").val('0');//本次抵扣保证金
     	    	$("input[name='fund_rent_adjust.otherin']").val('0');//其它应收
     	    	$("input[name='fund_rent_adjust.otherout']").val('0');//其它应退
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
		 jQuery('#id_json_fund_rent_plan_str').val(JsonUtil.encode(rs['fundrentplan']));
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
			//if(nowDiff*1>0){
			//	alert("约定终止日不能小于今天!");
			//	return false;
			//}else{
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
				//	if(planData[startList]["planstatusid"].toLowerCase()!='planmanystatusno'){
				//		alert("只能从[未收款]期项开始!");
				//		return false;
				//	}else{
						jQuery("#startList").val(startList+1);
						jQuery("#adjustList").val(startList+1);
						jQuery("#adjustYearRate").val(decimal(planData[startList]["yearrate"],6));
				//	}
				}else{
					if(confirm("约定终止日可能不在租赁期限之内，您确定要继续吗？")){
						jQuery("#startList").val(planData.length);
						jQuery("#adjustList").val(planData.length);
					}else{
						return false;
					}
				}
			//}
		}
		return true;
	}
	return false;
}

//合同债权总计 = 其他应收 — 其他应退 + 已到期未支付租金+ 买断本金 + 违约手续费 + 商定罚息 + 商定利息 — 本次抵扣保证金
function contractClaimTotal(){// + 逾期罚息 + parseFloat(dunpenalty)这个去掉
	var otherin = $("input[name='fund_rent_adjust.otherin']").val();//其它应收
	var otherout = $("input[name='fund_rent_adjust.otherout']").val();//其它应退
	var dunrent = $("input[name='fund_rent_adjust.dunrent']").val();//已到期未支付租金
	var dunpenalty = $("input[name='fund_rent_adjust.dunpenalty']").val()=="" ? "0":$("input[name='fund_rent_adjust.dunpenalty']").val();//逾期罚息
	var corpusoverage = $("input[name='fund_rent_adjust.monopolizecorpusfund']").val()=="" ? "0":$("input[name='fund_rent_adjust.monopolizecorpusfund']").val();//买断本金
	var handlingcharge = $("input[name='fund_rent_adjust.handlingcharge']").val()=="" ? "0":$("input[name='fund_rent_adjust.handlingcharge']").val();//违约手续费
	var agreedpenalty = $("input[name='fund_rent_adjust.agreedpenalty']").val()=="" ? "0":$("input[name='fund_rent_adjust.agreedpenalty']").val();//商定罚息
	var agreedinterest = $("input[name='fund_rent_adjust.agreedinterest']").val()=="" ? "0":$("input[name='fund_rent_adjust.agreedinterest']").val();//商定利息
	var currentcautionmoney = $("input[name='fund_rent_adjust.currentcautionmoney']").val()=="" ? "0":$("input[name='fund_rent_adjust.currentcautionmoney']").val();//本次抵扣保证金
	   
	var agreedpenalty = $("input[name='fund_rent_adjust.agreedpenalty']").val()=="" ? "0":$("input[name='fund_rent_adjust.agreedpenalty']").val();//提前结清比例
	if(!isNaN(handlingcharge) && !isNaN(agreedpenalty)){
		//其他应收 — 其他应退 + 已到期未支付租金  + 未到期本金 + 违约手续费 + 商定罚息 + 商定利息 — 本次抵扣保证金
		var contracttotal = parseFloat(otherin) - parseFloat(otherout) + parseFloat(dunrent)  + parseFloat(corpusoverage) + parseFloat(handlingcharge)+ parseFloat(agreedpenalty)+ parseFloat(agreedinterest) - parseFloat(currentcautionmoney);
		$("input[name='fund_rent_adjust.contracttotal']").val(decimal(contracttotal,2));
	}else{
		alert("违约手续费或商定罚息必须为数字");
	}
}
</script>