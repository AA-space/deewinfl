<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<script type="text/javascript">
jQuery(function(){
    if(isSubTable==true){
		dictOnSelect('id_settle_method_old','framework_condition_old.settlemethod','settle_method','${requestScope["framework_condition_old.settlemethod"]}',null,'require="true" label="租金计算方法"');
		dictOnSelect('id_period_type_old','framework_condition_old.periodtype','period_type','${requestScope["framework_condition_old.periodtype"]}',null,'require="true" label="付租方式"');
		dictOnSelect('id_adjust_style_old','framework_condition_old.adjuststyle','adjust_style','${requestScope["framework_condition_old.adjuststyle"]}',null,'require="true" label="调息方式"');
		dictOnSelect('id_rate_float_type_old','framework_condition_old.ratefloattype','rate_float_type','${requestScope["framework_condition_old.ratefloattype"]}',null,'require="true" label="利率浮动类型"');
		dictOnSelect('id_income_number_year_old','framework_condition_old.incomenumberyear','income_number_year','${requestScope["framework_condition_old.incomenumberyear"]}',null,'require="true" label="付租类型"');
		dictYesOrNoByCode('id_is_before_interest_old','framework_condition_old.isbeforeinterest','${empty requestScope["framework_condition_old.isbeforeinterest"] ? "1" : requestScope["framework_condition_old.isbeforeinterest"] }',null,false,'require="true" label="是否收租前息"',165);
		dictYesOrNoByCode('id_is_merger_old','framework_condition_old.ismerger','${empty requestScope["framework_condition_old.ismerger"] ? "1" : requestScope["framework_condition_old.ismerger"] }',null,false,'require="true" label="是否合并起租"',165);
    }
});
</script>
<div id="id_submitFrameworkConditionFormOld">
	<table class="fillTable" cellspacing="0" cellpadding="0" >
		  <tr>
             <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-condition-info"></div>商务条件</td>
          </tr>
          <tr class="tr-condition-info tr-even" id="onhireid-tr_old">
             <td class="td-content-title" >起租编号：</td>
             <td class="td-content" ><input name="framework_condition_old.onhireid" id="onhireidOld" class="td-content-input td-content-readonly"  type="text" value="${requestScope['framework_condition_old.onhireid']}" readonly></td>
             <td class="td-content-title" >是否合并起租：</td>
             <td class="td-content" ><div id="id_is_merger_old" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title" >剩余本金：</td>
             <td class="td-content" ><input name="framework_condition_old.lastcorpus" id="lastCorpusOld" class="td-content-input td-content-readonly" type="text" dataType="PMoney"  value="${empty requestScope['framework_condition_old.lastcorpus'] ? 0 :requestScope['framework_condition_old.lastcorpus']}" readonly></td>
          </tr> 
          <tr class="tr-condition-info tr-odd" id="rentCalUtil_old">
             <td class="td-content-title">客户名称：</td>
             <td colspan="3" class="td-content" >
             	<input style="width:85%"  name="framework_condition_old.custname" id="conditionCustNameOld" class="td-content-input td-content-readonly"  type="text" value="${requestScope['framework_condition_old.custname']}" readonly>
             </td>
             <td class="td-content-title">报价编号：</td><td class="td-content"><input name="framework_condition_old.quotid" class="td-content-input td-content-readonly"  readonly type="text" value="${requestScope['framework_condition_old.quotid']}"   /></td>
          </tr>
          <tr class="tr-condition-info tr-even">
            <td class="td-content-title">设备款：</td>
            <td class="td-content"><input name="framework_condition_old.equipamt" id="equipAmtOld" class="td-content-input" type="text"  oninput="OnInput (event)" onpropertychange="OnPropChanged (event)" dataType="PMoney" require="true" label="设备款" value="${requestScope['framework_condition_old.equipamt']}" />
            <font class="required-content">*</font></td>
            <td class="td-content-title">首付比例：</td>
            <td class="td-content"><span class="td-content-title">
              <input name="framework_condition_old.firstpaymentratio" class="td-content-input td-content-readonly"  type="text"  value="${requestScope['framework_condition_old.firstpaymentratio']}"  id="firstPaymentRatioOld" readonly />
            <font class="required-content">%</font></span></td>
            <td class="td-content-title">首付款：</td>
            <td class="td-content"><input name="framework_condition_old.firstpayment" id="firstPaymentOld" class="td-content-input"   type="text" value="${empty requestScope['framework_condition_old.firstpayment'] ? 0 : requestScope['framework_condition_old.firstpayment']}" dataType="PMoney" label="首付款" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)" />
            <font class="required-content">*</font></td>
          </tr>
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">设备款支付日期：</td><td class="td-content"><input  name="framework_condition_old.leaseamtdate" id="leaseAmtDateOld" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['framework_condition_old.leaseamtdate'] }"  onclick="WdatePicker(this,{readOnly:true})" require="true" label="设备款支付日期" readonly />
               <font class="required-content">*</font></td>
             <td class="td-content-title">起租日期：</td>
               <td class="td-content"><input name="framework_condition_old.startdate" id="startDateOld" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['framework_condition_old.startdate'] }"  onclick="WdatePicker(this,{readOnly:true})" require="true" label="起租日期" readonly />
               <font class="required-content">*</font></td>
             <td class="td-content-title">第一期租金支付日：</td><td class="td-content"><input name="framework_condition_old.firstplandate" id="firstPlanDateOld" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['framework_condition_old.firstplandate']}"  onclick="WdatePicker(this,{readOnly:true})" require="true" label="第一期租金支付日" readonly />
               <font class="required-content">*</font></td>
          </tr>  
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">租金计算方法：</td><td class="td-content"><div id="id_settle_method_old" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">付租类型 ：</td><td class="td-content"><div id="id_income_number_year_old" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">付租方式：</td><td class="td-content"><div id="id_period_type_old" class="leftComboContainer"></div><font class="required-content">*</font></td>
          </tr>         
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">租赁年利率：</td><td class="td-content"><input name="framework_condition_old.yearrate" id="yearRateOld" class="td-content-input" require="true" datatype="Rate" label="租赁年利率" type="text" value="${requestScope['framework_condition_old.yearrate']}" />
               <font class="required-content">%&nbsp;*</font></td>
             <td class="td-content-title">还租次数：</td><td class="td-content"><input name="framework_condition_old.incomenumber" id="incomeNumberOld" class="td-content-input" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"  require="true"  dataType="Number" label="还租次数" type="text" value="${requestScope['framework_condition_old.incomenumber']}"><font class="required-content">*</font></td>
             <td class="td-content-title">租赁期限(月)：</td><td class="td-content"><input name="framework_condition_old.leaseterm" id="leaseTermOld" class="td-content-input td-content-readonly" label="租赁期限" readonly type="text" value="${ requestScope['framework_condition_old.leaseterm'] }"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">融资额：</td><td class="td-content"><input name="framework_condition_old.leasemoney" id="leaseMoneyOld" class="td-content-input td-content-readonly" readonly type="text" value="${empty requestScope['framework_condition_old.leasemoney'] ? 0 : requestScope['framework_condition_old.leasemoney']}"  /></td>
             <td class="td-content-title">保证金比例：</td><td class="td-content"><input name="framework_condition_old.cautionmoneyratio" id="cautionMoneyRatioOld" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['framework_condition_old.cautionmoneyratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">保证金：</td><td class="td-content"><input name="framework_condition_old.cautionmoney" id="cautionMoneyOld" class="td-content-input td-content-readonly" readonly dataType="PMoney" type="text" value="${empty requestScope['framework_condition_old.cautionmoney'] ? 0 : requestScope['framework_condition_old.cautionmoney'] }"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">留购价款：</td><td class="td-content"><input name="framework_condition_old.nominalprice" id="nominalPriceOld" class="td-content-input"   type="text" value="${empty requestScope['framework_condition_old.nominalprice'] ? 0 : requestScope['framework_condition_old.nominalprice']}"></td>
             <td class="td-content-title">承租人保证金比例：</td><td class="td-content"><input name="framework_condition_old.custcautionmoneyratio" id="custCautionMoneyRatioOld" class="td-content-input td-content-readonly"  readonly type="text" value="${requestScope['framework_condition_old.custcautionmoneyratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">承租人保证金：</td><td class="td-content"><input name="framework_condition_old.custcautionmoney" id="custCautionMoneyOld" class="td-content-input " oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"   dataType="PMoney" label="承租人保证金"  type="text" value="${empty requestScope['framework_condition_old.custcautionmoney'] ? 0 : requestScope['framework_condition_old.custcautionmoney']}"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">期末余值：</td><td class="td-content"><input name="framework_condition_old.equipendvalue" id="equipEndValueOld" class="td-content-input"   type="text" value="${empty requestScope['framework_condition_old.equipendvalue']?0:requestScope['framework_condition_old.equipendvalue']}"></td>
             <td class="td-content-title">供应商保证金比例：</td><td class="td-content"><input name="framework_condition_old.suppliercautionmoneyratio" id="supplierCautionMoneyRatioOld" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['framework_condition_old.suppliercautionmoneyratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">供应商保证金：</td><td class="td-content"><input name="framework_condition_old.suppliercautionmoney" id="supplierCautionMoneyOld" class="td-content-input" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"   dataType="PMoney" label="供应商保证金"  type="text" value="${empty requestScope['framework_condition_old.suppliercautionmoney']?0:requestScope['framework_condition_old.suppliercautionmoney'] }"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">保险公司：</td><td class="td-content"><input name="framework_condition_old.insurer" id="insurerOld" class="td-content-input"   type="text" value="${requestScope['framework_condition_old.insurer']}" /></td>
             <td class="td-content-title">保证金抵扣比例：</td><td class="td-content"><input name="framework_condition_old.cautiondeductionratio" id="cautionDeductionRatioOld" class="td-content-input td-content-readonly"  readonly type="text" value="${requestScope['framework_condition_old.cautiondeductionratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">保证金抵扣金额：</td><td class="td-content"><input name="framework_condition_old.cautiondeductionmoney" id="cautionDeductionMoneyOld" class="td-content-input " oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"   dataType="PMoney" label="保证金抵扣金额"  type="text" value="${empty requestScope['framework_condition_old.cautiondeductionmoney'] ? 0 : requestScope['framework_condition_old.cautiondeductionmoney']}"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">保险费：</td><td class="td-content"><input name="framework_condition_old.insuremoney" id="insure_moneyOld" class="td-content-input"   dataType="PMoney" label="保险费"  type="text" value="${empty requestScope['framework_condition_old.insuremoney']?0:requestScope['framework_condition_old.insuremoney']}" /></td>
             <td class="td-content-title">预收租金比例：</td><td class="td-content"><input name="framework_condition_old.expectrentratio" class="td-content-input td-content-readonly" readonly  id="expectRentRatioOld" type="text" value="${requestScope['framework_condition_old.expectrentratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">预收租金金额 ：</td><td class="td-content"><input name="framework_condition_old.expectrent" class="td-content-input" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)" id="expectRentOld"  dataType="PMoney" label="预收租金金额"  type="text" value="${empty requestScope['framework_condition_old.expectrent']?0:requestScope['framework_condition_old.expectrent'] }"   /></td>
           </tr>
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">其他收入  ：</td><td class="td-content"><input name="framework_condition_old.otherincome" id="otherIncomeOld" class="td-content-input" dataType="PMoney" label="其他收入"  type="text" value="${empty requestScope['framework_condition_old.otherincome'] ? 0 : requestScope['framework_condition_old.otherincome']}" /></td>
             <td class="td-content-title">预收租金抵扣比例 ：</td><td class="td-content"><input name="framework_condition_old.expectrentdeductionratio" class="td-content-input td-content-readonly" readonly id="expectRentDeductionRatioOld" type="text" value="${requestScope['framework_condition_old.expectrentdeductionratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">预收租金抵扣金额 ：</td><td class="td-content"><input name="framework_condition_old.expectrentdeduction" class="td-content-input " oninput="OnInput (event)" onpropertychange="OnPropChanged (event)" id="expectRentDeductionOld"  dataType="PMoney" label="预收租金抵扣金额"   type="text" value="${empty requestScope['framework_condition_old.expectrentdeduction']?0:requestScope['framework_condition_old.expectrentdeduction'] }"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">其他支出 ：</td><td class="td-content"><input name="framework_condition_old.otherexpenditure" id="otherExpenditureOld" class="td-content-input " dataType="PMoney" abel="其他支出" type="text" value="${empty requestScope['framework_condition_old.otherexpenditure'] ? 0 : requestScope['framework_condition_old.otherexpenditure'] }" /></td>
             <td class="td-content-title">手续费比例  ：</td><td class="td-content"><input name="framework_condition_old.handlingchargemoneyratio" id="handlingChargeMoneyRatioOld" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['framework_condition_old.handlingchargemoneyratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">手续费 ：</td><td class="td-content"><input name="framework_condition_old.handlingchargemoney" id="handlingChargeMoneyOld" class="td-content-input " oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"   dataType="PMoney" label="手续费"  type="text" value="${empty requestScope['framework_condition_old.handlingchargemoney']?0:requestScope['framework_condition_old.handlingchargemoney'] }"   /></td>
          </tr> 
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">厂商返利：</td><td class="td-content"><input name="framework_condition_old.returnamt" id="returnAmtOld" class="td-content-input "  type="text" value="${empty requestScope['framework_condition_old.returnamt']?0:requestScope['framework_condition_old.returnamt'] }" /></td>
             <td class="td-content-title">管理费比例  ：</td><td class="td-content"><input name="framework_condition_old.managementmoneyratio" id="managementMoneyRatioOld" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['framework_condition_old.managementmoneyratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">管理费 ：</td><td class="td-content"><input name="framework_condition_old.managementmoney" id="managementMoneyOld" class="td-content-input "  oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"   dataType="PMoney" label="管理费" type="text" value="${empty requestScope['framework_condition_old.managementmoney']?0:requestScope['framework_condition_old.managementmoney'] }" /></td>
          </tr>         
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">调息方式：</td><td class="td-content"><div id="id_adjust_style_old" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">利率浮动类型  ：</td><td class="td-content"><div id="id_rate_float_type_old" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">利率调整值 ：</td><td class="td-content"><input name="framework_condition_old.ratefloatamt" id="rateFloatAmtOld" class="td-content-input " datatype="Rate"  label="利率调整值"  type="text" value="${empty requestScope['framework_condition_old.ratefloatamt'] ? 0 : requestScope['framework_condition_old.ratefloatamt'] }" /></td>
          </tr>         
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">宽限期数：</td><td class="td-content"><input name="framework_condition_old.grace" id="graceOld" class="td-content-input " datatype="Number"  label="宽限期数" type="text" value="${empty requestScope['framework_condition_old.grace'] ? 0 : requestScope['framework_condition_old.grace'] }"  oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"  /></td>
             <td class="td-content-title">罚息利率：</td><td class="td-content"><input name="framework_condition_old.penaRate" id="penaRateOld" class="td-content-input " require="true" datatype="Rate" label="罚息利率" type="text" value="${empty requestScope['framework_condition_old.penarate'] ? 6:requestScope['framework_condition_old.penarate'] }"   />
               <font class="required-content">%%&nbsp;</font></td>
             <td class="td-content-title">免罚息天数 ：</td>
             <td class="td-content"><input name="framework_condition_old.freedefainterday" id="freeDefaInterDayOld" class="td-content-input" type="text" datatype="Number"  label="免罚息天数" value="${empty requestScope['framework_condition_old.freedefainterday']?7:requestScope['framework_condition_old.freedefainterday'] }" /></td>
          </tr>         
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title" ><span id="irr_no_purview_irr_title_old">内部收益率：</span></td><td class="td-content"><span id="irr_no_purview_irr_old"><input name="framework_condition_old.irr" id="irrOld" class="td-content-input td-content-readonly" readonly type="text" value="${empty requestScope['framework_condition_old.irr']?0:requestScope['framework_condition_old.irr'] }" />
               <font class="required-content">%</font></span></td>
             <td class="td-content-title">是否收租前息  ：</td><td class="td-content"><div id="id_is_before_interest_old" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">租前息金额 ：</td><td class="td-content"><input name="framework_condition_old.beforeinterest" id="beforeInterestOld" class="td-content-input " dataType="PMoney" label="租前息金额" type="text" value="${empty requestScope['framework_condition_old.beforeinterest'] ? 0 : requestScope['framework_condition_old.beforeinterest'] }" /></td>
          </tr>
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title" ><span id="irr_no_purview_planirr_title_old">财务收益率：</span></td><td class="td-content"><span id="irr_no_purview_planirr_old"><input name="framework_condition_old.planirr" id="planIrrOld" class="td-content-input td-content-readonly" readonly type="text" value="${empty requestScope['framework_condition_old.planirr']?0:requestScope['framework_condition_old.planirr']}" />
               <font class="required-content">%</font></span></td>
             <td class="td-content-title">净融资额  ：</td><td class="td-content"><input name="framework_condition_old.cleanleasemoney" id="cleanLeaseMoneyOld" class="td-content-input td-content-readonly" readonly  type="text" value="${empty requestScope['framework_condition_old.cleanleasemoney']?0:requestScope['framework_condition_old.cleanleasemoney']}"></td>
             <td class="td-content-title">期初付款总计 ：</td><td class="td-content"><input name="framework_condition_old.firstpaymenttotal" id="firstPaymentTotalOld" class="td-content-input td-content-readonly" readonly type="text" value="${requestScope['framework_condition_old.firstpaymenttotal'] }" /></td>
          </tr> 
          <tr class="tr-condition-info tr-even">
          	 <td  colspan=6 align="right">
				<input name="framework_condition_old.id" id="conditionIdOld"  type="hidden" value="${requestScope['framework_condition_old.id']}">
				<input name="framework_condition_old.custid" id="conditionCustIdOld" type="hidden" value="${requestScope['framework_condition_old.custid']}">
				<input name="framework_condition_old.contractid" id="conditionContractIdOld" type="hidden" value="${requestScope['framework_condition_old.contractid']}">
				<input name="framework_condition_old.projid" id="conditionProjIdOld" type="hidden" value="${requestScope['framework_condition_old.projid']}">
				<input name="framework_condition_old.docid" id="conditionDocIdOld" type="hidden" value="${requestScope['framework_condition_old.docid']}">
				<input name="framework_condition_old.process" id="reckonProcessOld" type="hidden" value="${requestScope['framework_condition_old.process']}">
				<input name="framework_condition_old.reckontype" id="reckonTypeOld"  type="hidden" value="${empty requestScope['framework_condition_old.reckontype']?'condition':requestScope['framework_condition_old.reckontype'] }" />
				<input name="framework_condition_old.enddate" id="enddateOld"  type="hidden" value="${requestScope['framework_condition_old.enddate']}" />
				<input type="hidden" id="id_json_fund_rent_plan_old_str" name="json_fund_rent_plan_old_str" value='${empty json_fund_rent_plan_old_str ? "[]" : json_fund_rent_plan_old_str}'/><%--租金计划 --%>
				<input type="hidden" id="id_json_fund_cash_flow_old_str" name="json_fund_cash_flow_old_str" value='${empty json_fund_cash_flow_old_str ? "[]" : json_fund_cash_flow_old_str }'/><%--现金流 --%>
          	 </td>
          </tr>                
	</table>
<script type="text/javascript">
    //判断多次起租
    if(jQuery('#onhireid').val()==""){
        jQuery('#onhireid-tr_old').hide();
        jQuery('#onhireid-tr_old').removeAttr("class");
    }
</script> 
<permission:action  code="irr_no_purview">
<script type="text/javascript">
jQuery('#irr_no_purview_irr_title_old').hide();//经销商不可见
jQuery('#irr_no_purview_irr_old').hide();//经销商不可见
jQuery('#irr_no_purview_planirr_title_old').hide();//经销商不可见
jQuery('#irr_no_purview_planirr_old').hide();//经销商不可见
</script >
</permission:action>
</div>