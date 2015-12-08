<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<tr class="tr-contract-plan-chang-old-before-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;" colspan="8">
			<jsp:include page="main_old.jsp" flush="true"/>
		</td>
	</tr>
	<tr>
           <td class="x-panel-table-div-title" colspan="8"><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contract-plan-old-where-info"></div>变更条件</td>
    </tr>
	<tr class="tr-contract-plan-old-where-info">
		<td class="tr-contract-plan-old-where"  colspan=7 align="right">
    	</td>
      	<td class="tr-contract-plan-old-where"  align="left">
			<input style="margin-top:2px;margin-bottom:2px;" id="btn_rent_cal_adjust" class="btn btn-primary" type="button" value="调整租金计划" onclick="submitAdjust()"/>
			<input style="margin-top:2px;margin-bottom:2px;" id="btn_rent_cal_reset" class="btn btn-primary" type="button" value="撤销调整" onclick="resetAdjust()"/>
    	</td>
     </tr>
     <tr class="tr-contract-plan-old-where-info" id="plan_rent_change_form">
        <td class="tr-contract-plan-old-where" >调整开始期数：</td>
        <td class="tr-contract-plan-old-where" >
        <input name="fund_rent_adjust.adjustsavetype" id="adjustsavetype"  type="hidden" value="${requestScope['fund_rent_adjust.adjustsavetype']}">
        <input name="fund_rent_adjust.adjusttype" id="adjuststype"  type="hidden" value="${requestScope['fund_rent_adjust.adjusttype']}">
        <input name="fund_rent_adjust.contract"  type="hidden" value="${requestScope['fund_rent_adjust.contract']}"  ><!-- 合同表中的合同号 -->
        <input name="fund_rent_adjust.contractid"  type="hidden" value="${requestScope['fund_rent_adjust.contractid']}"  ><!-- 合同表中的主键Id -->
        <input name="fund_rent_adjust.docid"  type="hidden" value="${requestScope['fund_rent_adjust.docid']}"  >
        <input name="fund_rent_adjust.jsonfundrentplanstr" id="jsonfundrentplanstr" type="hidden"  >
        <input name="fund_rent_adjust.startlist" id="startList" class="td-content-input td-content-readonly"  readonly  type="text" dataType="PInteger" value="${requestScope['fund_rent_adjust.startlist']}"  require="true" label="调整开始期数" ><font class="required-content">*</font>
        </td>
        <td class="tr-contract-plan-old-where"  >调整后总期数：</td>
        <td class="tr-contract-plan-old-where" >
        <input name="fund_rent_adjust.adjustlist" id="adjustList" class="td-content-input"  type="text" dataType="PInteger" value="${requestScope['fund_rent_adjust.adjustlist']}"  require="true" label="调整后总期数"><font class="required-content">*</font></td>
        <td class="tr-contract-plan-old-where"  >支付日期：</td>
        <td class="tr-contract-plan-old-where" id="rent_paydayAdjust"><input  name="fund_rent_adjust.paydayadjust" id="paydayAdjust" class="Wdate td-content-input td-content-readonly"  type="text" value="${requestScope['fund_rent_adjust.paydayadjust'] }"  onclick="WdatePicker(this,{readOnly:true})" require="true" label="支付日期" readonly dataType="Date" /><font class="required-content">*</font></td>
        <td class="tr-contract-plan-old-where" >年利率：</td>
        <td class="tr-contract-plan-old-where" ><input name="fund_rent_adjust.yearrate" id="adjustYearRate" class="td-content-input"  type="text" dataType="Rate" value="${requestScope['fund_rent_adjust.yearrate']}"  require="true" label="年利率"><font class="required-content">*</font></td>
     </tr>
     <tr  class="tr-contract-plan-old-where-info">
           <td class="tr-contract-plan-old-where" colspan="8"><br></td>
    </tr>
	<tr>
           <td class="x-panel-table-div-title" colspan="8">变更后</td>
    </tr>
	<tr class="tr-contract-plan-chang-old-last-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;" colspan="8">
			<jsp:include page="main_now.jsp" flush="true"/>
		</td>
	</tr>
	</table>
</div>
<script>
//初始化调用
jQuery(function() {
	$("#id_contract_condition_plan_tabs_content_old").css("width", (formWidth) + "px");
	$("#id_contract_condition_plan_tabs_content_old").tabs();
});
function submitAdjust(){//提交变更
	if(checkAdjustData()){
		jQuery("#adjustsavetype").val("reckon");
		adjustCalculateSubmit("${pageContext.request.contextPath}/leasing/adjustCalculateOld.action");
	}
}
function resetAdjust(){//撤销变更
	if(confirm("你确定要清除调整吗?")){
		jQuery("#adjustsavetype").val("reset");
		adjustCalculateSubmit("${pageContext.request.contextPath}/leasing/resetAdjust.action");
	}
}
function submitByPlanAdjust(){//租金调整提交
	var fundRentPlan = getTracywindyObject('table_id_table_leasing_rent_plan_container');
	jQuery('#jsonfundrentplanstr').val(JsonUtil.encode(fundRentPlan.getRowsJsonData())) ;
	jQuery("#adjustsavetype").val("adjust");
	adjustCalculateSubmit("${pageContext.request.contextPath}/leasing/adjustCalculateOld.action");
}
function adjustUpdatePlanCheck(flag,rowDatas){//控制修改期数
	if(flag=='update'){
		if(rowDatas.length>0){
			var startList=jQuery("#startList").val();
			if(startList==''){
				alert("请先输入调整开始期数!");
				return false;
			}else{
				if(rowDatas[0].rowIndex<startList-1){
					alert("只能修改调整开始期数之后的数据!");
					return false;
				}
			}
		}
	}
	return true;
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
    var $submitConditionForm = $("#plan_rent_change_form");
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
  		 //alert(decimal((rs['irr']),6)+"|"+decimal((rs['planirr']),6)+"|"+rs['enddate']+"|"+rs['yearrate']+"|"+rs['incomenumber']+"|"+rs['leaseterm']);
		//保存多行控件的值
	  	 jQuery('#id_json_fund_cash_flow_str').val(JsonUtil.encode(fundCashDetail.getRowsJsonData())) ;
		 jQuery('#id_json_fund_rent_plan_str').val(JsonUtil.encode(fundRentPlan.getRowsJsonData())) ;
		 fundRentPlan.reload();
	  	 fundCashDetail.reload();
	 }
     alert(rs['rentcalculatemsg']);
}
function checkAdjustData(){
	var submitConditionForm =document.getElementById("plan_rent_change_form");
	var isPassed = Validator.Validate(submitConditionForm,1,false);
	if(isPassed){
		var startList=jQuery("#startList").val();
		var adjustList=jQuery("#adjustList").val();
		var paydayAdjust=jQuery("#paydayAdjust").val();
		var adjustYearRate=jQuery("#adjustYearRate").val();
		if(startList!=''){
			if(adjustList!=''){
				if(startList<=0||adjustList<=0){
					alert("调整期数必须为大于零的整数!");
					return false;
				}
				if((adjustList-startList)<0){
					alert("调整开始期数不能比调整后期数大！");
					return false;
				}
			}
			if(!checkStartList(startList,false)){
				return false;
			}
			var planData=getTracywindyObject('multiTable_id_table_leasing_rent_plan_container_old').datas;
			if(paydayAdjust!=''){
				var nowDate='${requestScope["fund_rent_adjust.nowdate"]}';
				var nowDiff=datediff('day',nowDate,paydayAdjust);
				//if(nowDiff*1>0){
				if(nowDiff*0>0){//临时不需判断是否小于今天 2014/5/6 coffin
					alert("调整日期不能小于今天!");
					return false;
				}else{
					var beforeDate="";
					if(startList==1){
						beforeDate=jQuery("#startDateOld").val();
					}else{
						beforeDate=planData[(startList-2)]["plandate"];
					}
					nowDiff=datediff('day',beforeDate,paydayAdjust);
					if(nowDiff*1>0){
						alert("调整日期要大于上一期还款日!");
						return false;
					}
				}
			}
		}
		return true;
	}else{
		return false; 
	}
}
function checkStartList(startList,select){//未回笼 强制校验
	if(startList!=''){
		var planData=getTracywindyObject('multiTable_id_table_leasing_rent_plan_container_old').datas;
		var planStatus=planData[startList-1]["planstatusid"];
		if(planStatus.toLowerCase()!='planmanystatusno'){
			alert("只能从[未收款]期项开始调整!");
			if(select){
				jQuery("#startList").select();
			}
			return false;
		}
	}
	return true;
}
</script>