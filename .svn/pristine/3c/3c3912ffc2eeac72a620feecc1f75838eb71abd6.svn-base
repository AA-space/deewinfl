<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<script type="text/javascript">
jQuery(function(){
   if(isSubTable==true){
		dictOnSelect('id_period_type_old','framework_condition_old.periodtype','period_type','${empty requestScope["framework_condition_old.periodtype"] ? "period_type_1" : requestScope["framework_condition_old.periodtype"] }',null,'require="true" label="付租方式"');
		dictOnSelect('id_income_number_year_old','framework_condition_old.incomenumberyear','income_number_year','${empty requestScope["framework_condition_old.incomenumberyear"] ? "income_1" : requestScope["framework_condition_old.incomenumberyear"] }',null,'require="true" label="付租类型"');
		dictYesOrNoByCode('id_is_registration_old','framework_condition_old.isregistration','${empty requestScope["framework_condition_old.isregistration"] ? "1" : requestScope["framework_condition_old.isregistration"] }',null,false,'require="true" label="是否上牌"',165);
		dictYesOrNoByCode('id_is_guaranty_old','framework_condition_old.isguaranty','${empty requestScope["framework_condition_old.isguaranty"] ? "1" : requestScope["framework_condition_old.isguaranty"] }',null,false,'require="true" label="是否抵押"',165);
   }
	
	var rentPlanListOld = JsonUtil.decode('${empty json_fund_rent_plan_old_str ? "[]" : json_fund_rent_plan_old_str }');
	var rentPlanListLengthOld = rentPlanListOld.length;
	var rentTotalOld = 0;
	for ( var i = 0; i < rentPlanListLengthOld; i++) {
		var renPlan = rentPlanListOld[i];
		var rent = renPlan['rent'];
		rentTotalOld += rent*1;
	}
	jQuery('#rentTotalMoneyOld').val(rentTotalOld);
});
</script>
<div id="id_submitFrameworkConditionFormOld">
  <table class="fillTable" cellspacing="0" cellpadding="0" >
		  <tr>
             <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-condition-info"></div>商务条件</td>
          </tr> 
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">客户名称：</td>
             <td colspan="3" class="td-content" >
             	<input style="width:85%"  name="framework_condition_old.custname" id="conditionCustNameOld" class="td-content-input td-content-readonly"  type="text" value="${requestScope['framework_condition_old.custname']}" readonly>
             </td>
             <td class="td-content-title">报价编号：</td><td class="td-content"><input name="framework_condition_old.quotid" class="td-content-input td-content-readonly"  readonly type="text" value="${requestScope['framework_condition_old.quotid']}"   /></td>
          </tr>
          <tr class="tr-condition-info tr-even" >
             <td class="td-content-title">设备款：</td><td class="td-content"><input name="framework_condition_old.equipamt" id="equipAmtOld" class="td-content-input" type="text"  datatype="PMoney" require="true" label="设备款" value="${requestScope['framework_condition_old.equipamt']}" />
               <font class="required-content">*</font></td>
             <td class="td-content-title">融资额：</td>
               <td class="td-content"><input name="framework_condition_old.leasemoney" id="leaseMoneyOld" class="td-content-input td-content-readonly" readonly type="text" value="${empty requestScope['framework_condition_old.leasemoney'] ? 0 : requestScope['framework_condition_old.leasemoney']}"  /></td>
             <td class="td-content-title">净融资额  ：</td><td class="td-content"><input name="framework_condition_old.cleanleasemoney" id="cleanLeaseMoneyOld" class="td-content-input td-content-readonly" readonly="readonly"  type="text" value="${empty requestScope['framework_condition_old.cleanleasemoney']?0:requestScope['framework_condition_old.cleanleasemoney']}" /></td>
          </tr>
          <tr class="tr-condition-info tr-odd">
            <td class="td-content-title">起租日期：</td>
            <td class="td-content"><input name="framework_condition_old.startdate" id="startDateOld" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['framework_condition_old.startdate'] }"  onclick="WdatePicker(this,{readOnly:true})" require="true" label="起租日期" readonly="readonly" onchange="OnchangeDate()"/>
              <font class="required-content">*</font></td>
            <td class="td-content-title">起租比例：</td>
            <td class="td-content"><span class="td-content-title">
              <input name="framework_condition_old.firstpaymentratio" class="td-content-input td-content-readonly"  type="text"  value="${requestScope['framework_condition_old.firstpaymentratio']}"  id="firstPaymentRatioOld" readonly="readonly" />
              <font class="required-content">%</font></span></td>
            <td class="td-content-title">起租租金：</td>
            <td class="td-content"><input name="framework_condition_old.firstpayment" id="firstPaymentOld" class="td-content-input"   type="text" value="${empty requestScope['framework_condition_old.firstpayment'] ? 0 : requestScope['framework_condition_old.firstpayment']}" datatype="PMoney" label="首付款" />
              <font class="required-content">*</font></td>
          </tr>
          <tr class="tr-condition-info tr-even">
            <td class="td-content-title">第一期租金支付日：</td>
            <td class="td-content"><input name="framework_condition_old.firstplandate" id="firstPlanDateOld" class="Wdate td-content-input td-content-readonly" type="text" onclick="WdatePicker(this,{readOnly:true})" require="true"  label="第一期租金支付日" readonly="readonly" value="${requestScope['framework_condition_old.firstplandate'] }"/><font class="required-content">*</font></td>
            <td class="td-content-title">租赁年利率：</td>
            <td class="td-content"><input name="framework_condition_old.yearrate" id="yearRateOld" class="td-content-input" require="true" datatype="Rate" label="租赁年利率" type="text" value="${requestScope['framework_condition_old.yearrate']}" />
            <font class="required-content">%&nbsp;*</font></td>
            <td class="td-content-title">还租次数：</td>
            <td class="td-content"><input name="framework_condition_old.incomenumber" id="incomeNumberOld" class="td-content-input"   require="true"  datatype="Number" label="还租次数" type="text" value="${requestScope['framework_condition_old.incomenumber']}" />
            <font class="required-content">*</font></td>
          </tr>
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">付租类型 ：</td><td class="td-content"><div id="id_income_number_year_old" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">付租方式：</td><td class="td-content"><div id="id_period_type_old" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">租赁期限(月)：</td><td class="td-content"><input name="framework_condition_old.leaseterm" id="leaseTermOld" class="td-content-input td-content-readonly" label="租赁期限" readonly type="text" value="${ requestScope['framework_condition_old.leaseterm'] }"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">保险费：</td><td class="td-content"><input name="framework_condition_old.insuremoney" id="insureMoneyOld" class="td-content-input"   datatype="PMoney" label="保险费"  type="text" value="${empty requestScope['framework_condition_old.insuremoney']?0:requestScope['framework_condition_old.insuremoney']}" /></td>
             <td class="td-content-title">天行健服务费：</td><td class="td-content"><input name="framework_condition_old.gpsmoney" id="gpsMoneyOld" class="td-content-input"   datatype="PMoney"  type="text" value="${empty requestScope['framework_condition_old.gpsmoney']?0:requestScope['framework_condition_old.gpsmoney']}"/></td>
             <td class="td-content-title">留购价款：</td><td class="td-content"><input name="framework_condition_old.nominalprice" id="nominalPriceOld" class="td-content-input"   type="text" value="${empty requestScope['framework_condition_old.nominalprice'] ? 0 : requestScope['framework_condition_old.nominalprice']}" /></td>
          </tr>         
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">是否上牌：</td><td class="td-content"><div id="id_is_registration_old" class="leftComboContainer"></div>
               <font class="required-content">*</font></td>
             <td class="td-content-title">保证金比例：</td><td class="td-content"><input name="framework_condition_old.cautionmoneyratio" id="cautionMoneyRatioOld" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['framework_condition_old.cautionmoneyratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">保证金：</td><td class="td-content"><input name="framework_condition_old.cautionmoney" id="cautionMoneyOld" class="td-content-input td-content" dataType="PMoney" type="text" value="${empty requestScope['framework_condition_old.cautionmoney'] ? 0 : requestScope['framework_condition_old.cautionmoney'] }"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-odd">
            <td class="td-content-title">是否抵押：</td>
            <td class="td-content"><div id="id_is_guaranty_old" class="leftComboContainer"></div>
               <font class="required-content">*</font></td>
            <td class="td-content-title">手续费比例  ：</td>
            <td class="td-content"><input name="framework_condition_old.handlingchargemoneyratio" id="handlingChargeMoneyRatioOld" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['framework_condition_old.handlingchargemoneyratio']}" />
            <font class="required-content">%</font></td>
            <td class="td-content-title">手续费 ：</td>
            <td class="td-content"><input name="framework_condition_old.handlingchargemoney" id="handlingChargeMoneyOld" class="td-content-input "  datatype="PMoney" label="手续费"  type="text" value="${empty requestScope['framework_condition_old.handlingchargemoney']?0:requestScope['framework_condition_old.handlingchargemoney'] }"   /></td>
          </tr>
          <tr class="tr-condition-info tr-even">
            <td class="td-content-title">租金总额：</td><td class="td-content"><input name="framework_condition_old.renttotalmoney" id="rentTotalMoneyOld" class="td-content-input td-content-readonly" readonly  datatype="PMoney"  type="text" value="${empty requestScope['framework_condition_old.renttotalmoney']?0:requestScope['framework_condition_old.renttotalmoney']}" /></td>
             <td class="td-content-title">期初付款总计：</td><td class="td-content"><input title="期初付款总计=起租租金+保证金+手续费+留购价款+保险费+天行健服务费+其他费用" name="framework_condition_old.firstpaymenttotal" id="firstPaymentTotalOld" class="td-content-input td-content-readonly" readonly="readonly" type="text" value="${requestScope['framework_condition_old.firstpaymenttotal'] }" /></td>
             <td class="td-content-title">其他费用  ：</td>
            <td class="td-content"><input name="framework_condition_old.otherincome" id="otherIncomeOld" class="td-content-input" datatype="PMoney" label="其他收入"  type="text" value="${empty requestScope['framework_condition_old.otherincome'] ? 0 : requestScope['framework_condition_old.otherincome']}"/></td>
             
          </tr>         
          <tr class="tr-condition-info tr-odd" id="irr_no_purview_irr_old">
            <td class="td-content-title">内部收益率：</td>
            <td class="td-content"><input name="framework_condition_old.irr" id="irrOld" class="td-content-input td-content-readonly" readonly type="text" value="${empty requestScope['framework_condition_old.irr']?0:requestScope['framework_condition_old.irr'] }" />
            <font class="required-content">%</font></td>
            <td class="td-content-title" >&nbsp;</td>
            <td class="td-content">&nbsp;</td>
            <td class="td-content-title">&nbsp;</td>
            <td class="td-content">&nbsp;</td>
          </tr>
          <tr class="tr-condition-info tr-even">
          	 <td  colspan=6 align="right">
          	 	<input name="framework_condition_old.leaseamtdate" id="leaseAmtDateOld" type="hidden" value="${requestScope['framework_condition_old.leaseamtdate'] }"/>          	 	
          	 	<input name="framework_condition_old.settlemethod" id="settleMethodOld" type="hidden" value="${empty requestScope['framework_condition_old.settlemethod']?'even_rent':requestScope['framework_condition_old.settlemethod'] }"/>
          	 	<input name="framework_condition_old.ismerger" id="ismergerOld" type="hidden" value="1"/>
				<input name="framework_condition_old.id"  id="conditionIdOld" type="hidden" value="${requestScope['framework_condition_old.id']}">
				<input name="framework_condition_old.custid" id="conditionCustIdOld" type="hidden" value="${requestScope['framework_condition_old.custid']}">
				<input name="framework_condition_old.contractid" id="conditionContractIdOld"  type="hidden" value="${requestScope['framework_condition_old.contractid']}">
				<input name="framework_condition_old.projid" id="conditionProjIdOld"  type="hidden" value="${requestScope['framework_condition_old.projid']}">
				<input name="framework_condition_old.docid" id="conditionDocIdOld" type="hidden" value="${requestScope['framework_condition_old.docid']}">
				<input name="framework_condition_old.process" id="reckonProcessOld" type="hidden" value="${requestScope['framework_condition_old.process']}">
				<input name="framework_condition_old.reckontype" id="reckonTypeOld"  type="hidden" value="${empty requestScope['framework_condition_old.reckontype']?'condition':requestScope['framework_condition_old.reckontype'] }" />
				<input name="framework_condition_old.enddate" id="enddateOld"  type="hidden" value="${requestScope['framework_condition_old.enddate']}" />
				<input type="hidden" id="id_json_fund_rent_plan_old_str" name="json_fund_rent_plan_old_str" value='${empty json_fund_rent_plan_old_str ? "[]" : json_fund_rent_plan_old_str}'/><%--租金计划 --%>
				<input type="hidden" id="id_json_fund_cash_flow_old_str" name="json_fund_cash_flow_old_str" value='${empty json_fund_cash_flow_old_str ? "[]" : json_fund_cash_flow_old_str }'/><%--现金流 --%>
          	 </td>
          </tr>                
	</table>
<permission:action  code="irr_no_purview">
<script type="text/javascript">
jQuery('#irr_no_purview_irr_old').hide();//经销商不可见
</script >
</permission:action>
</div>