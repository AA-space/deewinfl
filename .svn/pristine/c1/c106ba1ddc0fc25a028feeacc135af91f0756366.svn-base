<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<script type="text/javascript">
jQuery(function(){
    if(isSubTable==true){
		dictOnSelect('id_settle_method','framework_condition.settlemethod','settle_method','${requestScope["framework_condition.settlemethod"]}',null,'require="true" label="租金计算方法"');
		dictOnSelect('id_period_type','framework_condition.periodtype','period_type','${requestScope["framework_condition.periodtype"]}',null,'require="true" label="付租方式"');
		dictOnSelect('id_adjust_style','framework_condition.adjuststyle','adjust_style','${requestScope["framework_condition.adjuststyle"]}',null,'require="true" label="调息方式"');
		dictOnSelect('id_rate_float_type','framework_condition.ratefloattype','rate_float_type','${requestScope["framework_condition.ratefloattype"]}',null,'require="true" label="利率浮动类型"');
		dictOnSelect('id_income_number_year','framework_condition.incomenumberyear','income_number_year','${requestScope["framework_condition.incomenumberyear"]}',incomeNumber,'require="true" label="付租类型"');
		dictOnSelect('id_insurer_type','framework_condition.insurertype','insurer_type','${empty requestScope["framework_condition.insurertype"] ? "insurer_type.assign" : requestScope["framework_condition.insurertype"] }',null,'require="true" label="付租类型"',null,null,true,'月 付' );
		dictYesOrNoByCode('id_is_before_interest','framework_condition.isbeforeinterest','${empty requestScope["framework_condition.isbeforeinterest"] ? "1" : requestScope["framework_condition.isbeforeinterest"] }',beforeInterest,false,'require="true" label="是否收租前息"',165);
		dictYesOrNoByCode('id_is_merger','framework_condition.ismerger','${empty requestScope["framework_condition.ismerger"] ? "1" : requestScope["framework_condition.ismerger"] }',isMergerChange,false,'require="true" label="是否合并起租"',165);
		
		new tracywindyComboBox({
			id:'id_combo_id_default_year_rate',
			width:defaultInputWidth,
			renderTo:'id_default_year_rate',
			xmlFileName:'/combos/comboCommonSelect.xml',
			loadMode:'ajax',
			readOnly:false,
			otherAttributes:'',
			name:'framework_condition.defaultyearrate',
			rawValue:'default_year_rate_one',
			displayField:'name',
			valueField:'value',
			isContainEmpty: false,
			loadComplete : function(combo){
				var yearRateVal = getNumber('yearRate');
				var defaultVal = combo.getValue();
				if(!yearRateVal && defaultVal){
					$('#yearRate').val(defaultVal);
				}
			},
			params : {
				 tableName:"(select code_ as code, prop_one_ as val from t_dicts_datas where code_='default_year_rate_one') rs",
				 displayColumnName:"code",
				 valueColumnName:"val"
			}
		});
	}
});
</script>
<div id="id_submitFrameworkConditionForm">
	<table class="fillTable" cellspacing="0" cellpadding="0" id="contract_condition">
		  <tr>
             <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-condition-info"></div>商务条件</td>
          </tr>
          <tr class="tr-condition-info tr-even" id="onhireid-tr">
             <td class="td-content-title" >起租编号：</td>
             <td class="td-content" ><input name="framework_condition.onhireid" id="onhireid" class="td-content-input td-content-readonly"  type="text" value="${requestScope['framework_condition.onhireid']}" readonly></td>
             <td class="td-content-title" >是否合并起租：</td>
             <td class="td-content" ><div id="id_is_merger" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title" >剩余本金：</td>
             <td class="td-content" ><input name="framework_condition.lastcorpus" id="lastCorpus" class="td-content-input td-content-readonly" type="text" dataType="PMoney"  value="${empty requestScope['framework_condition.lastcorpus'] ? 0 :requestScope['framework_condition.lastcorpus']}" readonly></td>
          </tr> 
          <tr class="tr-condition-info tr-odd" id="rentCalUtil">
             <td class="td-content-title">客户名称：</td>
             <td colspan="3" class="td-content" >
             	<input style="width:85%"  name="framework_condition.custname" id="conditionCustName" class="td-content-input td-content-readonly"  type="text" value="${requestScope['framework_condition.custname']}" readonly>
             </td>
             <td class="td-content-title">报价编号：</td><td class="td-content"><input name="framework_condition.quotid" class="td-content-input td-content-readonly"  readonly type="text" value="${requestScope['framework_condition.quotid']}"   /></td>
          </tr>
          <tr class="tr-condition-info tr-even">
            <td class="td-content-title">设备款：</td>
            <td class="td-content"><input name="framework_condition.equipamt" id="equipAmt" class="td-content-input" type="text"  oninput="OnInput (event)" onpropertychange="OnPropChanged(event)" dataType="PMoney" require="true" label="设备款" value="${requestScope['framework_condition.equipamt']}" />
            <font class="required-content">*</font></td>
            <td class="td-content-title">首付比例：</td>
            <td class="td-content"><span class="td-content-title">
              <input name="framework_condition.firstpaymentratio" class="td-content-input td-content-readonly"  type="text"  value="${requestScope['framework_condition.firstpaymentratio']}"  id="firstPaymentRatio" readonly />
            <font class="required-content">%</font></span></td>
            <td class="td-content-title">首付款：</td>
            <td class="td-content"><input name="framework_condition.firstpayment" id="firstPayment" class="td-content-input"   type="text" value="${empty requestScope['framework_condition.firstpayment'] ? 0 : requestScope['framework_condition.firstpayment']}" dataType="PMoney" label="首付款" oninput="OnInput (event)" onpropertychange="OnPropChanged(event)" />
            <font class="required-content">*</font></td>
          </tr>
          <tr class="tr-condition-info tr-odd" id="onHireProcessDataTR">
             <td class="td-content-title">设备款支付日期：</td><td class="td-content"><input  name="framework_condition.leaseamtdate" id="leaseAmtDate" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['framework_condition.leaseamtdate'] }"  onclick="WdatePicker(this,{readOnly:true})" require="true" label="设备款支付日期" readonly />
               <font class="required-content">*</font></td>
             <td class="td-content-title">起租日期：</td>
               <td class="td-content"><input name="framework_condition.startdate" id="startDate" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['framework_condition.startdate'] }"  onclick="WdatePicker(this,{readOnly:true})" require="true" label="起租日期" readonly />
               <font class="required-content">*</font></td>
             <td class="td-content-title">第一期租金支付日：</td><td class="td-content"><input name="framework_condition.firstplandate" id="firstPlanDate" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['framework_condition.firstplandate']}"  onclick="WdatePicker(this,{readOnly:true})" require="true" label="第一期租金支付日" readonly />
               <font class="required-content">*</font></td>
          </tr>  
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">租金计算方法：</td><td class="td-content"><div id="id_settle_method" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">付租类型 ：</td><td class="td-content"><div id=id_income_number_year class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">付租方式：</td><td class="td-content"><div id="id_period_type" class="leftComboContainer"></div><font class="required-content">*</font></td>
          </tr>         
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">租赁年利率：</td><td class="td-content"><input name="framework_condition.yearrate" id="yearRate" class="td-content-input" require="true" datatype="Rate" label="租赁年利率" type="text" value="${requestScope['framework_condition.yearrate']}" />
               <font class="required-content">%&nbsp;*</font></td>
             <td class="td-content-title">还租次数：</td><td class="td-content"><input name="framework_condition.incomenumber" id="incomeNumber" class="td-content-input" oninput="OnInput (event)" onpropertychange="OnPropChanged(event)"  require="true"  dataType="Number" label="还租次数" type="text" value="${requestScope['framework_condition.incomenumber']}"><font class="required-content">*</font></td>
             <td class="td-content-title">租赁期限(月)：</td><td class="td-content"><input name="framework_condition.leaseterm" id="leaseTerm" class="td-content-input td-content-readonly" label="租赁期限" readonly type="text" value="${ requestScope['framework_condition.leaseterm'] }"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">融资额：</td><td class="td-content"><input name="framework_condition.leasemoney" id="leaseMoney" class="td-content-input td-content-readonly" readonly type="text" value="${empty requestScope['framework_condition.leasemoney'] ? 0 : requestScope['framework_condition.leasemoney']}"  /></td>
             <td class="td-content-title">保证金比例：</td><td class="td-content"><input name="framework_condition.cautionmoneyratio" id="cautionMoneyRatio" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['framework_condition.cautionmoneyratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">保证金：</td><td class="td-content"><input name="framework_condition.cautionmoney" id="cautionMoney" class="td-content-input td-content-readonly" readonly dataType="PMoney" type="text" value="${empty requestScope['framework_condition.cautionmoney'] ? 0 : requestScope['framework_condition.cautionmoney'] }"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">留购价款：</td><td class="td-content"><input name="framework_condition.nominalprice" id="nominalPrice" class="td-content-input" oninput="OnInput (event)" onpropertychange="OnPropChanged(event)" dataType="PMoney" type="text" value="${empty requestScope['framework_condition.nominalprice'] ? 0 : requestScope['framework_condition.nominalprice']}"></td>
             <td class="td-content-title">承租人保证金比例：</td><td class="td-content"><input name="framework_condition.custcautionmoneyratio" id="custCautionMoneyRatio" class="td-content-input td-content-readonly"  readonly type="text" value="${requestScope['framework_condition.custcautionmoneyratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">承租人保证金：</td><td class="td-content"><input name="framework_condition.custcautionmoney" id="custCautionMoney" class="td-content-input " oninput="OnInput (event)" onpropertychange="OnPropChanged(event)"   dataType="PMoney" label="承租人保证金"  type="text" value="${empty requestScope['framework_condition.custcautionmoney'] ? 0 : requestScope['framework_condition.custcautionmoney']}"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">期末余值：</td><td class="td-content"><input name="framework_condition.equipendvalue" id="equipEndValue" class="td-content-input" oninput="resetMoneyScale(event)" onpropertychange="resetMoneyScale(event)" dataType="PMoney" type="text" value="${empty requestScope['framework_condition.equipendvalue']?0:requestScope['framework_condition.equipendvalue']}"></td>
             <td class="td-content-title">供应商保证金比例：</td><td class="td-content"><input name="framework_condition.suppliercautionmoneyratio" id="supplierCautionMoneyRatio" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['framework_condition.suppliercautionmoneyratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">供应商保证金：</td><td class="td-content"><input name="framework_condition.suppliercautionmoney" id="supplierCautionMoney" class="td-content-input" oninput="OnInput (event)" onpropertychange="OnPropChanged(event)"   dataType="PMoney" label="供应商保证金"  type="text" value="${empty requestScope['framework_condition.suppliercautionmoney']?0:requestScope['framework_condition.suppliercautionmoney'] }"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">保险公司：</td><td class="td-content"><input name="framework_condition.insurer" id="insurer" class="td-content-input"   type="text" value="${requestScope['framework_condition.insurer']}" /></td>
             <td class="td-content-title">保证金抵扣比例：</td><td class="td-content"><input name="framework_condition.cautiondeductionratio" id="cautionDeductionRatio" class="td-content-input td-content-readonly"  readonly type="text" value="${requestScope['framework_condition.cautiondeductionratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">保证金抵扣金额：</td><td class="td-content"><input name="framework_condition.cautiondeductionmoney" id="cautionDeductionMoney" class="td-content-input " oninput="OnInput (event)" onpropertychange="OnPropChanged(event)"   dataType="PMoney" label="保证金抵扣金额"  type="text" value="${empty requestScope['framework_condition.cautiondeductionmoney'] ? 0 : requestScope['framework_condition.cautiondeductionmoney']}"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">保险费：</td><td class="td-content"><input name="framework_condition.insuremoney" id="insure_money" class="td-content-input" oninput="resetMoneyScale(event)" onpropertychange="resetMoneyScale(event)"  dataType="PMoney" label="保险费"  type="text" value="${empty requestScope['framework_condition.insuremoney']?0:requestScope['framework_condition.insuremoney']}" /></td>
             <td class="td-content-title">预收租金比例：</td><td class="td-content"><input name="framework_condition.expectrentratio" class="td-content-input td-content-readonly" readonly  id="expectRentRatio" type="text" value="${requestScope['framework_condition.expectrentratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">预收租金金额 ：</td><td class="td-content"><input name="framework_condition.expectrent" class="td-content-input" oninput="OnInput (event)" onpropertychange="OnPropChanged(event)" id="expectRent"  dataType="PMoney" label="预收租金金额"  type="text" value="${empty requestScope['framework_condition.expectrent']?0:requestScope['framework_condition.expectrent'] }"   /></td>
           </tr>
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">其他收入  ：</td><td class="td-content"><input name="framework_condition.otherincome" id="otherIncome" class="td-content-input" dataType="PMoney" label="其他收入" oninput="resetMoneyScale(event)" onpropertychange="resetMoneyScale(event)" type="text" value="${empty requestScope['framework_condition.otherincome'] ? 0 : requestScope['framework_condition.otherincome']}" /></td>
             <td class="td-content-title">预收租金抵扣比例 ：</td><td class="td-content"><input name="framework_condition.expectrentdeductionratio" class="td-content-input td-content-readonly" readonly id="expectRentDeductionRatio" type="text" value="${requestScope['framework_condition.expectrentdeductionratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">预收租金抵扣金额 ：</td><td class="td-content"><input name="framework_condition.expectrentdeduction" class="td-content-input " oninput="OnInput (event)" onpropertychange="OnPropChanged(event)" id="expectRentDeduction"  dataType="PMoney" label="预收租金抵扣金额"   type="text" value="${empty requestScope['framework_condition.expectrentdeduction']?0:requestScope['framework_condition.expectrentdeduction'] }"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">其他支出 ：</td><td class="td-content"><input name="framework_condition.otherexpenditure" id="otherExpenditure" class="td-content-input " oninput="resetMoneyScale(event)" onpropertychange="resetMoneyScale(event)" dataType="PMoney" abel="其他支出" type="text" value="${empty requestScope['framework_condition.otherexpenditure'] ? 0 : requestScope['framework_condition.otherexpenditure'] }" /></td>
             <td class="td-content-title">手续费比例  ：</td><td class="td-content"><input name="framework_condition.handlingchargemoneyratio" id="handlingChargeMoneyRatio" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['framework_condition.handlingchargemoneyratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">手续费 ：</td><td class="td-content"><input name="framework_condition.handlingchargemoney" id="handlingChargeMoney" class="td-content-input " oninput="OnInput (event)" onpropertychange="OnPropChanged(event)"   dataType="PMoney" label="手续费"  type="text" value="${empty requestScope['framework_condition.handlingchargemoney']?0:requestScope['framework_condition.handlingchargemoney'] }"   /></td>
          </tr> 
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">厂商返利：</td><td class="td-content"><input name="framework_condition.returnamt" id="returnAmt" class="td-content-input " oninput="resetMoneyScale(event)" onpropertychange="resetMoneyScale(event)" type="text" datatype="PMoney" value="${empty requestScope['framework_condition.returnamt']?0:requestScope['framework_condition.returnamt'] }" /></td>
             <td class="td-content-title">管理费比例  ：</td><td class="td-content"><input name="framework_condition.managementmoneyratio" id="managementMoneyRatio" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['framework_condition.managementmoneyratio']}" />
               <font class="required-content">%</font></td>
             <td class="td-content-title">管理费 ：</td><td class="td-content"><input name="framework_condition.managementmoney" id="managementMoney" class="td-content-input "  oninput="OnInput (event)" onpropertychange="OnPropChanged(event)"   dataType="PMoney" label="管理费" type="text" value="${empty requestScope['framework_condition.managementmoney']?0:requestScope['framework_condition.managementmoney'] }" /></td>
          </tr>         
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">调息方式：</td><td class="td-content"><div id="id_adjust_style" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">利率浮动类型  ：</td><td class="td-content"><div id="id_rate_float_type" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">利率调整值 ：</td><td class="td-content"><input name="framework_condition.ratefloatamt" id="rateFloatAmt" class="td-content-input " datatype="Rate"  label="利率调整值"  type="text" value="${empty requestScope['framework_condition.ratefloatamt'] ? 0 : requestScope['framework_condition.ratefloatamt'] }" /></td>
          </tr>         
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">宽限期数：</td><td class="td-content"><input name="framework_condition.grace" id="grace" class="td-content-input " datatype="Number"  label="宽限期数" type="text" value="${empty requestScope['framework_condition.grace'] ? 0 : requestScope['framework_condition.grace'] }"  oninput="OnInput (event)" onpropertychange="OnPropChanged(event)"  /></td>
             <td class="td-content-title">罚息利率：</td><td class="td-content"><input name="framework_condition.penaRate" id="penaRate" class="td-content-input " require="true" datatype="Rate" label="罚息利率" type="text" value="${empty requestScope['framework_condition.penarate'] ? 6:requestScope['framework_condition.penarate'] }"   />
               <font class="required-content">%%&nbsp;</font></td>
             <td class="td-content-title">免罚息天数 ：</td>
             <td class="td-content"><input name="framework_condition.freedefainterday" id="freeDefaInterDay" class="td-content-input" type="text" datatype="Number"  label="免罚息天数" value="${empty requestScope['framework_condition.freedefainterday']?7:requestScope['framework_condition.freedefainterday'] }" /></td>
          </tr>         
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title" ><span id="irr_no_purview_irr_title">内部收益率：</span></td><td class="td-content"><span id="irr_no_purview_irr"><input name="framework_condition.irr" id="irr" class="td-content-input td-content-readonly" readonly type="text" value="${empty requestScope['framework_condition.irr']?0:requestScope['framework_condition.irr'] }" />
               <font class="required-content">%</font></span></td>
             <td class="td-content-title">是否收租前息  ：</td><td class="td-content"><div id="id_is_before_interest" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">租前息金额 ：</td><td class="td-content"><input name="framework_condition.beforeinterest" id="beforeInterest" class="td-content-input " dataType="PMoney" label="租前息金额" type="text" value="${empty requestScope['framework_condition.beforeinterest'] ? 0 : requestScope['framework_condition.beforeinterest'] }" /></td>
          </tr>
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title" ><span id="irr_no_purview_planirr_title">财务收益率：</span></td><td class="td-content"><span id="irr_no_purview_planirr"><input name="framework_condition.planirr" id="planIrr" class="td-content-input td-content-readonly" readonly type="text" value="${empty requestScope['framework_condition.planirr']?0:requestScope['framework_condition.planirr']}" />
               <font class="required-content">%</font></span></td>
             <td class="td-content-title">净融资额  ：</td><td class="td-content"><input name="framework_condition.cleanleasemoney" id="cleanLeaseMoney" class="td-content-input td-content-readonly" readonly  type="text" value="${empty requestScope['framework_condition.cleanleasemoney']?0:requestScope['framework_condition.cleanleasemoney']}"></td>
             <td class="td-content-title">期初付款总计 ：</td><td class="td-content"><input name="framework_condition.firstpaymenttotal" id="firstPaymentTotal" class="td-content-input td-content-readonly" readonly type="text" value="${requestScope['framework_condition.firstpaymenttotal'] }" /></td>
          </tr> 
          <tr class="tr-condition-info tr-odd">
            <td class="td-content-title" >保险方式:</td>
            <td class="td-content"><div id="id_insurer_type" class="leftComboContainer"></div><font class="required-content">*</font></td>
            <td class="td-content-title">&nbsp;</td>
            <td class="td-content">&nbsp;</td>
          </tr>
          <tr class="tr-condition-info tr-even">
          	 <td  colspan=6 align="right">
          	 	<div id="id_default_year_rate" class="leftComboContainer" style="display: none;"></div>
				<input name="framework_condition.id" id="conditionId"  type="hidden" value="${requestScope['framework_condition.id']}">
				<input name="framework_condition.custid" id="conditionCustId" type="hidden" value="${requestScope['framework_condition.custid']}">
				<input name="framework_condition.contractid" id="conditionContractId" type="hidden" value="${requestScope['framework_condition.contractid']}">
				<input name="framework_condition.projid" id="conditionProjId" type="hidden" value="${requestScope['framework_condition.projid']}">
				<input name="framework_condition.docid" id="conditionDocId" type="hidden" value="${requestScope['framework_condition.docid']}">
				<input name="framework_condition.process" id="reckonProcess" type="hidden" value="${requestScope['framework_condition.process']}">
				<input name="framework_condition.reckontype" id="reckonType"  type="hidden" value="${empty requestScope['framework_condition.reckontype']?'condition':requestScope['framework_condition.reckontype'] }" />
				<input name="framework_condition.enddate" id="enddate"  type="hidden" value="${requestScope['framework_condition.enddate']}" />
				<input type="hidden" id="id_json_fund_rent_plan_str" name="json_fund_rent_plan_str" value='${empty json_fund_rent_plan_str ? "[]" : json_fund_rent_plan_str}'/><%--租金计划 --%>
				<input type="hidden" id="id_json_fund_cash_flow_str" name="json_fund_cash_flow_str" value='${empty json_fund_cash_flow_str ? "[]" : json_fund_cash_flow_str }'/><%--现金流 --%>
				<input type="hidden" id="id_json_finance_rent_plan_str" name="json_finance_rent_plan_str" value='${empty json_finance_rent_plan_str ? "[]" : json_finance_rent_plan_str }'/><%--会计租金计划 --%>
				<input type="hidden" id="id_json_finance_cash_flow_str" name="json_finance_cash_flow_str" value='${empty json_finance_cash_flow_str ? "[]" : json_finance_cash_flow_str }'/><%--会计现金流 --%>
				<input type="hidden" id="id_json_fund_fund_charge_str" name="json_fund_fund_charge_str"  value='${empty json_fund_fund_charge_str ? "[]" : json_fund_fund_charge_str }'/>
				<input style="margin-top:2px;margin-bottom:2px;margin-right: 100px" id="btn_rent_cal" class="btn btn-primary" type="button" value="租金测算" onclick="conditionReckon();"/>
          	 </td>
          </tr>                
	</table>
<script type="text/javascript">
var chenckCondiotn=true;//是否改变过租金测算的代码为点租金测算  (false不能提交,true允许提交)
//页面各种赋值自动计算
 // Firefox, Google Chrome, Opera, Safari, Internet Explorer from version 9
	 	function resetMoneyScale(event){
	 		var targetId = getTarget(event).id;
	        var value = getTarget(event).value;
	        if(targetId && value && !isNaN(value)){
	        	var $targetDocument = jQuery('#' + targetId);
	            var dataType = $targetDocument.attr('datatype');
	            if(dataType && (dataType == 'PMoney'||dataType == 'Money')){
	            	if(decimal(value, 0) != value){
	            		$targetDocument.val(decimal(value, 0));
	            	}
	            }
	        }
		}
 
        function OnInput (event) {
        	var targetId = getTarget(event).id;
        	resetMoneyScale(event);
            equipAmt();
            if (targetId == 'incomeNumber'||targetId == 'grace'){//期限计算
            	incomeNumber();
            }
        }
        
        function OnPropChanged(event) {
            var targetId = getTarget(event).id;
            resetMoneyScale(event);
            if (event.propertyName.toLowerCase () == "value") {
                equipAmt();
                if (targetId == 'incomeNumber'||targetId == 'grace'){//期限计算
                	incomeNumber();
                }
            }
        }
        //净融资额=设备款-保证金-手续费-厂商返佣-其他收入+其他支出 -租前息-管理费-首付款
        function  equipAmt(){//设备款改变 影响 首付款,融资额,保证金(比例) 保证金抵扣 预收租金 手续费 管理费 首付款
        	var firstPayment =decimal(getNumber("firstPayment"),0);//首付款
            var equipAmt =decimal(getNumber("equipAmt"),0);//设备款
            var handlingChargeMoney=decimal(getNumber("handlingChargeMoney"),0);//手续费
            var managementMoney=decimal(getNumber("managementMoney"),0);//管理费
            var custCautionMoney =decimal(getNumber("custCautionMoney"),0);//客户保证金
            var supplierCautionMoney = decimal(getNumber("supplierCautionMoney"),0);//供应商保证金
            var cautionDeductionMoney =decimal(getNumber("cautionDeductionMoney"),0); //保证金抵扣金额
			var expectRent =decimal(getNumber("expectRent"),0); //预收租金
			var expectRentDeduction =decimal(getNumber("expectRentDeduction"),0);//预收租金抵扣金额
			//防止设备款为空时就进行计算，导致页面值出现NAN值
            if (equipAmt==0){
					alert("设备款不能为空");
					return false;
            }
            if(equipAmt>0){
				//计算比例
				setRatio("firstPayment",firstPayment);
    			setRatio("handlingChargeMoney",handlingChargeMoney);
    			setRatio("managementMoney",managementMoney);			
    			setRatio("custCautionMoney",custCautionMoney);	
    			setRatio("supplierCautionMoney",supplierCautionMoney);
				setRatio("cautionDeduction",cautionDeductionMoney);
				setRatio("expectRent",expectRent);
				setRatio("expectRentDeduction",expectRentDeduction);
				jQuery('#cautionMoney').val(decimal(custCautionMoney*1+supplierCautionMoney*1,0));			
    			setRatio("cautionMoney",decimal(custCautionMoney*1+supplierCautionMoney*1,0));
    			if(firstPayment*1>=0&&equipAmt*1>=0){
    				jQuery('#leaseMoney').val(decimal(equipAmt*1-firstPayment*1,0));
    			}    			
    			beforeInterest();
    			firstPaymentTotal();
    			if(decimal(cautionDeductionMoney*1,0)>decimal(custCautionMoney*1+supplierCautionMoney*1,0)){
    				alert("保证金抵扣大于保证金金额");
    			}
             }
     	}
       	/*
       	根据金额算比例
       	*/
        function setRatio(obj,num){
        	var equip_amt=getNumber("equipAmt");
        	if(num*1>=0){
        		jQuery('#'+obj+"Ratio").val(decimal(num/equip_amt*100,6));
        	}
        }
        //获取对象的数值
        function getNumber(id){
            var obj=jQuery('#'+id).attr("value");
            var va=0;
            try{
                if(obj==''){
                	obj=0;
                }
            	va=parseFloat(obj);
            }catch(e){
            	va=0;
            }
            return va;
        }
         //租前息计算
     	function beforeInterest(){
     			var equipAmt=getNumber("equipAmt");
     			var yearRate=getNumber("yearRate");
     			var startDate=jQuery('#startDate').attr("value");
     			var leaseAmtDate=jQuery('#leaseAmtDate').attr("value");
     			var is_before_interest=getTracywindyObject("id_combo_id_is_before_interest").getValue();
     			if(!(startDate==""||leaseAmtDate==""||yearRate==""||equipAmt=="")&&is_before_interest!="1"){
     				var diff=datediff('day',startDate,leaseAmtDate);
     				diff=diff<0?0:diff;
     				jQuery('#beforeInterest').val(decimal(equipAmt*diff*yearRate/100/yearRate/365,0));
     				//设备款 *(起租日-设备支付日)*年利率/365
     			}else{
     				jQuery('#beforeInterest').val("0");
     			}
     			chenckCondiotn=false;
     	}   
		//计算  期初付款总计 和 净融资额 ：
     	function firstPaymentTotal(){
        		var clean_lease_money = decimal(getNumber("equipAmt"), 0);
        		var first_payment_total = 0;
        		first_payment_total += decimal(getNumber("firstPayment"), 0);
        		first_payment_total += decimal(getNumber("cautionMoney"), 0);
        		first_payment_total += decimal(getNumber("expectRent"), 0);				
        		first_payment_total += decimal(getNumber("handlingChargeMoney"), 0);
        		first_payment_total += decimal(getNumber("returnAmt"), 0);
        		first_payment_total += decimal(getNumber("otherIncome"), 0);
        		first_payment_total -= decimal(getNumber("otherExpenditure"), 0);
        		first_payment_total += decimal(getNumber("beforeInterest"), 0);
        		first_payment_total += decimal(getNumber("managementMoney"), 0);
        		first_payment_total += decimal(getNumber("nominalPrice"), 0);
        		clean_lease_money -= first_payment_total;
        		jQuery('#firstPaymentTotal').val(decimal(first_payment_total, 0));
        		jQuery('#cleanLeaseMoney').val(decimal(clean_lease_money, 0));
        		chenckCondiotn = false;
        }
     	
     	function chargeBefInte(){
     		if (getTracywindyObject("id_combo_id_is_before_interest").getRawValue()=="1") {
     			jQuery('#beforeInterest').val("0");
     		} else {//计算租前息
     			beforeInterest();
     		}
     		firstPaymentTotal();
     	}
     	function incomeNumber(){//计算期数
     			var income_number=getNumber("incomeNumber");
     			var income_number_year=getTracywindyObject("id_combo_id_income_number_year").getValue();
     			var grace=getNumber("grace");
     			if(grace==""){
     				grace=0;
     			}
     			/*
     			月  付 income_1 
     			双月付 income_2
     			季  付 income_3 
     			半年付 income_6 
     			年  付 income_12 
     			*/
     			if(income_number_year=="income_1") {income_number_year="1";}
     			if(income_number_year=="income_2") {income_number_year="2";}
     			if(income_number_year=="income_3") {income_number_year="3";}
     			if(income_number_year=="income_6") {income_number_year="6";}
     			if(income_number_year=="income_12"){income_number_year="12";}
     			if(income_number*1>0&&income_number_year*1>0){
     				jQuery('#leaseTerm').val((income_number*1+grace*1)*income_number_year);
     			}
     			chenckCondiotn=false;
     	}
     var isMergerChange= function(){
     		if (getTracywindyObject("id_combo_id_is_merger").getValue()=="1") {
     			jQuery('#lastCorpus').val("0");
     		} 
     		chenckCondiotn=false;
     	}
     	function checkSubmit(){
     		var checktime =jQuery('#startDate').attr("value"); 
     		var rent_start_date =jQuery('#firstPlanDate').attr("value"); 
     		
     		var times = getCurDateTime().substring(0,10);
     		if(checktime<times){
     			alert("起租日期不能小于今天!");
     			return false;
     		}else if(rent_start_date<times){
     			alert("第一期租金支付日不能小于今天!");
     			return false;
     		}
     		var settle_method=getTracywindyObject("id_combo_id_settle_method").getValue();
     		if('irregular_rent' == settle_method){
     			alert("不规则测算请自行修改租金计划(默认使用等额租金测算初始化租金计划数据)！");
         	}
     		return true;	
     	}

    function rentCalculateSubmit(todoAction)
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
        var $submitConditionForm = $("#id_submitFrameworkConditionForm");
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
	     	    	ajaxRentCalculateCallBack(res);
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
    function ajaxRentCalculateCallBack(returnResult){
         jQuery("#id_workflowAdviseContainer").css("overflow","auto");
         jQuery("#id_workflowFormContainer").css("overflow","auto");
    	 loadMask.hide();
    	 var rs=JsonUtil.decode(returnResult);
    	 if(rs['rentcalculaters']=="yes"){
	    	 var fundRentPlan = getTracywindyObject('table_id_table_leasing_rent_plan_container');
	    	 fundRentPlan.tableData = rs['fundrentplan'];
	    	 //var finaRentPlan = getTracywindyObject('table_id_table_leasing_finance_rent_plan_container');
	    	 //finaRentPlan.tableData = rs['finarentplan'];
	    	 var fundCashDetail = getTracywindyObject('table_id_table_leasing_fund_cash_flow_container');
	    	 fundCashDetail.tableData = rs['fundcashdetail'];
	    	 //var finaCashDetail = getTracywindyObject('table_id_table_leasing_finance_cash_flow_container');
	    	 //finaCashDetail.tableData = rs['finacashdetail'];	    	 
	    	 jQuery('#irr').val(decimal((rs['irr']),6)) ;
	    	 jQuery('#planIrr').val(decimal((rs['planirr']),6));
	    	 jQuery('#enddate').val(rs['enddate']);
     		//保存多行控件的值
	    	 //jQuery('#id_json_finance_rent_plan_str').val(JsonUtil.encode(finaRentPlan.getRowsJsonData())) ;
	    	 jQuery('#id_json_fund_cash_flow_str').val(JsonUtil.encode(fundCashDetail.getRowsJsonData())) ;
	    	 //jQuery('#id_json_finance_cash_flow_str').val(JsonUtil.encode(finaCashDetail.getRowsJsonData())) ;
     		 jQuery('#id_json_fund_rent_plan_str').val(JsonUtil.encode(fundRentPlan.getRowsJsonData())) ;
     		 fundRentPlan.reload();
	    	 //finaRentPlan.reload();
	    	 fundCashDetail.reload();
	    	 //finaCashDetail.reload();
	    	 //判断是否有资金计划的表单在
	    	 var fundChargePlan = getTracywindyObject('table_id_table_leasing_fund_fund_charge_container');
	    	 if(typeof(fundChargePlan)=='object'){
		    	 //alert("有资金计划控件");
	    		 if(JsonUtil.decode(returnResult)['fundchargeplanmsg']=="yes"){
	    			 createFundChargePlan(returnResult);
	    		 }
	    	 }
	    	 var contractStarDate=jQuery('#contract_info.startdate');
	    	 if(typeof(contractStarDate)=='object'){
	    		 contractStarDate.val(jQuery('#framework_condition.startdate'));
	    	 }
	    	 var contractEndDate=jQuery('#contract_info.enddate');
	    	 if(typeof(contractEndDate)=='object'){
	    		 contractEndDate.val(jQuery('#framework_condition.enddate'));
	    	 }
	    	 var projStarDate=jQuery('#proj_info.startdate');
	    	 if(typeof(projStarDate)=='object'){
	    		 projStarDate.val(jQuery('#framework_condition.startdate'));
	    	 }
	    	 var projEndDate=jQuery('#proj_info.enddate');
	    	 if(typeof(projEndDate)=='object'){
	    		 projEndDate.val(jQuery('#framework_condition.enddate'));
	    	 }
	    	 alert("租金测算成功");     		 
    	 }else{
        	 var reckonType=jQuery('#reckonType');
        	 var settleMethod=getTracywindyObject("id_combo_id_settle_method").getValue();
        	 if(settleMethod!='irregular_rent'||reckonType!='condition'){
	        	 alert(JsonUtil.decode(returnResult)['rentcalculatemsg']);
        	 }
    	 }
         //根据测算方式控制是否显示多行控件操作条
         var settle_method=getTracywindyObject("id_combo_id_settle_method").getValue();
         reckonMultiTable(settle_method);
    	 saveReckonJsonValue();
    }
    /*
    * 页面加载时根据租金测算方式显示控件是否可用
      1.没有选择租金测算方式时 所有控件禁用
      2.选择为 不规则 时  增删改 和 租金测算 可用 其他不可用
            增删改 功能中 租金调整值不能填写,其他必填,本金+利息=租金 校验
            增删改 动作完成 把JS变量 chenckCondiotn 赋值为false
      3.选择不为 不规则 时 修改 和 租金调整 可用 其他不可用
            修改功能只能输入 租金调整值 其他值不可输入
            修改 动作完成 把JS变量 chenckCondiotn 赋值为false
      4.测算类型为合同层时 资金计划修改能用,项目层时不可用
    */
    function reckonMultiTable(settleMethod){
    	rentPlanMultiTable(settleMethod);
    	fundPlanMultiTable();
    }
	//设置资金计划表的控制    
    function fundPlanMultiTable(settleMethod){
    	if(!settleMethod){
        	settleMethod='${requestScope["framework_condition.process"]}';
        }
    	var fundPlan=getTracywindyObject('table_id_table_leasing_fund_fund_charge_container');
    	if(fundPlan){
	    	if(settleMethod.indexOf("con")<0){
	        	fundPlan.disabledToolsByText("修改");
			}else{
				fundPlan.enabledToolsByText("修改");
			}
    	}
    }
    //设置租金计划表中的控制
    function rentPlanMultiTable(settleMethod){
    	if(!settleMethod){
    		var settle_method=getTracywindyObject("id_combo_id_settle_method").getValue();
        	settleMethod=settle_method?settle_method:'${requestScope["framework_condition.settlemethod"]}';
        }
        var rentPlan=getTracywindyObject('table_id_table_leasing_rent_plan_container');
        if(settleMethod==''){
        	rentPlan.disabledToolsByText("新增,修改,删除,租金测算,租金调整");
        	rentPlan=getTracywindyObject('multiTable_id_table_leasing_rent_plan_container');
        	rentPlan.setReadOnly(true,"rentlist");
        	rentPlan.setReadOnly(true,"plandate");
        	rentPlan.setReadOnly(true,"rent");
        	rentPlan.setReadOnly(true,"corpus");
        	rentPlan.setReadOnly(true,"interest");
        	rentPlan.setReadOnly(true,"corpusbusiness");
        	rentPlan.setReadOnly(true,"interestbusiness");
        	rentPlan.setReadOnly(true,"rentadjust");
        }else if('irregular_rent' != settleMethod){
        	rentPlan.disabledToolsByText("新增,删除,租金测算");
        	rentPlan.enabledToolsByText("修改,租金调整");
        	rentPlan=getTracywindyObject('multiTable_id_table_leasing_rent_plan_container');
        	rentPlan.setReadOnly(true,"rentlist");
        	rentPlan.setReadOnly(true,"plandate");
        	rentPlan.setReadOnly(true,"rent");
        	rentPlan.setReadOnly(true,"corpus");
        	rentPlan.setReadOnly(true,"interest");
        	rentPlan.setReadOnly(true,"corpusbusiness");
        	rentPlan.setReadOnly(true,"interestbusiness");
        	rentPlan.setReadOnly(false,"rentadjust");
 		 }else{//不规则可写
        	rentPlan.disabledToolsByText("租金调整");
        	rentPlan.enabledToolsByText("新增,修改,删除,租金测算");
        	rentPlan=getTracywindyObject('multiTable_id_table_leasing_rent_plan_container');
        	rentPlan.setReadOnly(false,"rentlist");
        	rentPlan.setReadOnly(false,"plandate");
        	rentPlan.setReadOnly(false,"rent");
        	rentPlan.setReadOnly(false,"corpus");
        	rentPlan.setReadOnly(false,"interest");
        	rentPlan.setReadOnly(false,"corpusbusiness");
        	rentPlan.setReadOnly(false,"interestbusiness");
        	rentPlan.setReadOnly(true,"rentadjust");
 		 }
    }
	//租金测算
    function conditionReckon(){
    	jQuery('#reckonType').val("condition");
    	var submitConditionForm =document.getElementById("id_submitFrameworkConditionForm");
		var isPassed = Validator.Validate(submitConditionForm,1,false);
		if(isPassed){
			if(!checkSubmit()){return false;};
		    	rentCalculateSubmit('${pageContext.request.contextPath}/leasing/rentCalculateOld.action');
			}
    }
    //不规则租金计划修改
    function rentPlanReckon(){
    	var fundRentPlan = getTracywindyObject('table_id_table_leasing_rent_plan_container');
    	jQuery('#id_json_fund_rent_plan_str').val(JsonUtil.encode(fundRentPlan.getRowsJsonData())) ;
    	jQuery('#reckonType').val("plan");
    	rentCalculateSubmit("${pageContext.request.contextPath}/leasing/rentCalculateOld.action");
    }
    //租金计划调整
    function rentPlanAdjust(){
        var fundRentPlan = getTracywindyObject('table_id_table_leasing_rent_plan_container');
    	jQuery('#id_json_fund_rent_plan_str').val(JsonUtil.encode(fundRentPlan.getRowsJsonData())) ;
    	jQuery('#reckonType').val("adjust");
    	rentCalculateSubmit("${pageContext.request.contextPath}/leasing/rentCalculateOld.action");
    }
    //租金测算相关多行赋值
    function saveReckonJsonValue(){
        try{
	    	//商务条件数据
			var rentPlan = getTracywindyObject('table_id_table_leasing_rent_plan_container');//合同租金计划
			jQuery('#id_json_fund_rent_plan_str').val(JsonUtil.encode(rentPlan.getRowsJsonData()));
			var fundCashFlow = getTracywindyObject('table_id_table_leasing_fund_cash_flow_container');//合同现金流
			jQuery('#id_json_fund_cash_flow_str').val(JsonUtil.encode(fundCashFlow.getRowsJsonData()));
			//var financeRentPlan = getTracywindyObject('table_id_table_leasing_finance_rent_plan_container');//会计租金计划
			//jQuery('#id_json_finance_rent_plan_str').val(JsonUtil.encode(financeRentPlan.getRowsJsonData()));
			//var financeCashFlow = getTracywindyObject('table_id_table_leasing_finance_cash_flow_container');//会计现金流
			//jQuery('#id_json_finance_cash_flow_str').val(JsonUtil.encode(financeCashFlow.getRowsJsonData()));
			var fundChargePlan = getTracywindyObject('table_id_table_leasing_fund_fund_charge_container');
	    	if(typeof(fundChargePlan)=='object'){
				jQuery('#id_json_fund_fund_charge_str').val(JsonUtil.encode(fundChargePlan.getRowsJsonData()));
	    	 }
			return true;
        }catch (e){
            //alert('保存租金测算结果出错['+e+']!');
            return false;
        }
    }
    //判断多次起租
    if(jQuery('#onhireid').val()==""){
        jQuery('#onhireid-tr').hide();
        jQuery('#onhireid-tr').removeAttr("class");
    }
    //只读页面不显示测算按钮
    if(isViewHistoryTask){
    	jQuery('#btn_rent_cal').hide();
    }
    //起租是反转只读
    function conditionOnHire(){
    	formJSPInputHideOrShow("onHireProcessDataTR","",1);
    	jQuery('#btn_rent_cal').show();
    }
</script> 
<permission:action  code="irr_no_purview">
<script type="text/javascript">
jQuery('#irr_no_purview_irr_title').hide();//经销商不可见
jQuery('#irr_no_purview_irr').hide();//经销商不可见
jQuery('#irr_no_purview_planirr_title').hide();//经销商不可见
jQuery('#irr_no_purview_planirr').hide();//经销商不可见
</script >
</permission:action>
</div>