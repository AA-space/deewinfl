<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<script type="text/javascript">
//合同审批判断死否做过租金测算
var contract_approval=false;
//#############5.留购价款=100元*车头数，车头数即非挂车数量
var leaveTheToy = 0;
jQuery(function(){
    if(isSubTable==true){
		dictOnSelect('id_period_type','framework_condition.periodtype','period_type','${empty requestScope["framework_condition.periodtype"] ? "period_type_1" : requestScope["framework_condition.periodtype"] }',null,'require="true" label="付租方式"',null,null,true,'期末');
		dictOnSelect('id_income_number_year','framework_condition.incomenumberyear','income_number_year','${empty requestScope["framework_condition.incomenumberyear"] ? "income_1" : requestScope["framework_condition.incomenumberyear"] }',incomeNumber,'require="true" label="付租类型"',null,null,true,'月 付' );
		dictOnSelect('id_insurer_type','framework_condition.insurertype','insurer_type','${empty requestScope["framework_condition.insurertype"] ? "insurer_type.assign" : requestScope["framework_condition.insurertype"] }',null,'require="true" label="付租类型"',null,null,true,'月 付' );
		dictYesOrNoByCode('id_is_registration','framework_condition.isregistration','${empty requestScope["framework_condition.isregistration"] ? "0" : requestScope["framework_condition.isregistration"] }',null,false,'require="true" label="是否上牌"',165,null,true,'否');
		dictYesOrNoByCode('id_is_guaranty','framework_condition.isguaranty','${empty requestScope["framework_condition.isguaranty"] ? "0" : requestScope["framework_condition.isguaranty"] }',null,false,'require="true" label="是否抵押"',165,null,true,'否');
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
				 tableName:"(select code_ as code, prop_two_ as val from t_dicts_datas where code_='default_year_rate_one') rs",
				 displayColumnName:"code",
				 valueColumnName:"val"
			}
		});
		
		
		//#################5.留购价款=100元*车头数，车头数即非挂车数量
	    if('${business_type}'=='bussiness_type_car'){
			var contractEquip = getTracywindyObject('table_id_table_leasing_proj_equip_container');//租赁物件
			if (contractEquip != null) {
				var datas = contractEquip.getRowsJsonData();
				var carType;
				var totle = 0;
				for (var i = 0; i < datas.length; i++) {
					carType = datas[i].equipclass;
					//2013-11-22 9:54,修改原因：应该是非挂车，判断成挂车了
					if (carType != "equip_class_2") {
						totle++;
					}
				}
				leaveTheToy = 100 * totle;
				//修改了商务条件就需要重新测算租金
			     if($("#nominalPrice").val()!=leaveTheToy){
			    	$("#nominalPrice").val(leaveTheToy);
				    //chenckCondiotn=false;
				    //ie以外的浏览器需要不支持js改变值的事件，需重新计算商务条件
					equipAmt();
			     }
			}
		}
		//##################5.留购价款=100元*车头数，车头数即非挂车数量
    }
	var rentPlanList = JsonUtil.decode('${empty json_fund_rent_plan_str ? "[]" : json_fund_rent_plan_str }');
	var rentPlanListLength = rentPlanList.length;
	var rentTotal = 0;
	for ( var i = 0; i < rentPlanListLength; i++) {
		var renPlan = rentPlanList[i];
		var rent = renPlan['rent'];
		rentTotal += rent*1;
	}
	jQuery('#rentTotalMoney').val(rentTotal);
});
</script>
<div id="id_submitFrameworkConditionForm">
  <table class="fillTable" cellspacing="0" cellpadding="0" id="contract_condition">
  <!-- 
  		<input  name="framework_condition.freedefainterday" id="freedefainterday"  type="hidden" value="${requestScope['framework_condition.freedefainterday']}" >
		  -->
		  <tr>
             <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-condition-info"></div>商务条件</td>
          </tr> 
          <tr class="tr-condition-info tr-odd" id="rentCalUtil">
             <td class="td-content-title">客户名称：</td>
             <td colspan="3" class="td-content" >
             	<input style="width:85%"  name="framework_condition.custname" id="conditionCustName" class="td-content-input td-content-readonly"  type="text" value="${requestScope['framework_condition.custname']}" readonly>
             </td>
             <td class="td-content-title">报价编号：</td><td class="td-content"><input name="framework_condition.quotid" class="td-content-input td-content-readonly"  readonly type="text" value="${requestScope['framework_condition.quotid']}"   /></td>
          </tr>
          <tr class="tr-condition-info tr-even" >
			 <td class="td-content-title">设备款：</td><td class="td-content"><input name="framework_condition.equipamt" id="equipAmt" class="td-content-input" type="text" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)" datatype="PMoney" require="true" label="设备款" value="${requestScope['framework_condition.equipamt']}" />
               <font class="required-content">*</font></td>
             <td class="td-content-title">融资额：</td>
               <td class="td-content"><input name="framework_condition.leasemoney" id="leaseMoney" class="td-content-input td-content-readonly" readonly type="text" value="${empty requestScope['framework_condition.leasemoney'] ? 0 : requestScope['framework_condition.leasemoney']}"  /></td>
             <td class="td-content-title">净融资额  ：</td><td class="td-content"><input name="framework_condition.cleanleasemoney" id="cleanLeaseMoney" class="td-content-input td-content-readonly" readonly="readonly"  type="text" value="${empty requestScope['framework_condition.cleanleasemoney']?0:requestScope['framework_condition.cleanleasemoney']}" /></td>
          </tr>
          <tr class="tr-condition-info tr-odd" id="onHireProcessDataTR">
            <td class="td-content-title" id="onhiredatatext">计划起租日期：</td>
            <td class="td-content"><input name="framework_condition.startdate" id="startDate" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['framework_condition.startdate'] }" dataType="Date"  onclick="WdatePicker(this,{readOnly:true})" require="true" label="起租日期" readonly="readonly" onchange="OnchangeDate()"/>
              <font class="required-content">*</font></td>
              <td class="td-content-title">第一期租金支付日：</td>
            <td class="td-content"><input name="framework_condition.firstplandate" dataType="Date" id="firstPlanDate" class="Wdate td-content-input td-content-readonly" type="text" onclick="WdatePicker(this,{readOnly:true})" require="true"  label="第一期租金支付日" readonly="readonly" value="${requestScope['framework_condition.firstplandate'] }"/><font class="required-content">*</font></td>
            <td class="td-content-title">租赁年利率：</td>
            <td class="td-content"><input name="framework_condition.yearrate" id="yearRate" class="td-content-input" require="true" datatype="Rate" label="租赁年利率" type="text" value="${requestScope['framework_condition.yearrate']}" />
            <font class="required-content">%&nbsp;*</font></td>
            
          </tr>
          <tr class="tr-condition-info tr-even">
          <td class="td-content-title">起租比例：</td>
            <td class="td-content"><span class="td-content-title">
              <input name="framework_condition.firstpaymentratio" class="td-content-input"  type="text"  value="${requestScope['framework_condition.firstpaymentratio']}"  id="firstPaymentRatio" require="true" datatype="Double" label="起租比例" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"/>
              <font class="required-content">%&nbsp;*</font></span></td>
            <td class="td-content-title">起租租金：</td>
            <td class="td-content"><input name="framework_condition.firstpayment" id="firstPayment" readonly require="true" class="td-content-input td-content-readonly"   type="text" value="${empty requestScope['framework_condition.firstpayment'] ? 0 : requestScope['framework_condition.firstpayment']}" datatype="PMoney" label="起租租金"  />
              <font class="required-content">*</font></td>
            
            <td class="td-content-title">还租次数：</td>
            <td class="td-content"><input name="framework_condition.incomenumber" id="incomeNumber" class="td-content-input" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"  require="true"  datatype="Number" label="还租次数" type="text" value="${requestScope['framework_condition.incomenumber']}" />
            <font class="required-content">*</font></td>
          </tr>
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">付租类型 ：</td><td class="td-content"><div id="id_income_number_year" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">付租方式：</td><td class="td-content"><div id="id_period_type" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">租赁期限(月)：</td><td class="td-content"><input name="framework_condition.leaseterm" id="leaseTerm" class="td-content-input td-content-readonly" label="租赁期限" readonly type="text" value="${ requestScope['framework_condition.leaseterm'] }"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-odd">
             <td class="td-content-title">保险费：</td><td class="td-content"><input name="framework_condition.insuremoney" id="insureMoney" class="td-content-input"   datatype="PMoney" label="保险费"  type="text" value="${empty requestScope['framework_condition.insuremoney']?0:requestScope['framework_condition.insuremoney']}" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"/></td>
             <td class="td-content-title">天行健服务费：</td><td class="td-content"><input name="framework_condition.gpsmoney" id="gpsMoney" class="td-content-input"   datatype="PMoney"  type="text" value="${empty requestScope['framework_condition.gpsmoney']?0:requestScope['framework_condition.gpsmoney']}" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"/></td>
             <td class="td-content-title">留购价款：</td><td class="td-content"><input name="framework_condition.nominalprice" id="nominalPrice" class="td-content-input"  datatype="PMoney"  oninput="OnInput (event)" onpropertychange="OnPropChanged (event)" require="true" label="留购价款"  type="text" value="${empty requestScope['framework_condition.nominalprice'] ? 0 : requestScope['framework_condition.nominalprice']}" />
             <font class="required-content">*</font></td>
          </tr>         
          <tr class="tr-condition-info tr-even">
             <td class="td-content-title">是否上牌：</td><td class="td-content"><div id="id_is_registration" class="leftComboContainer"></div>
               <font class="required-content">*</font></td>
             <td class="td-content-title">保证金比例：</td><td class="td-content"><input name="framework_condition.cautionmoneyratio" id="cautionMoneyRatio" class="td-content-input" require="true" label="保证金比例" datatype="Rate" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"  type="text" value="${empty  requestScope['framework_condition.cautionmoneyratio']?5:requestScope['framework_condition.cautionmoneyratio']}" />
               <font class="required-content">%&nbsp;*</font></td>
             <td class="td-content-title">保证金：</td><td class="td-content"><input name="framework_condition.cautionmoney" id="cautionMoney" class="td-content-input td-content-readonly" dataType="PMoney" readonly type="text" value="${empty requestScope['framework_condition.cautionmoney'] ? 0 : requestScope['framework_condition.cautionmoney'] }"   /></td>
          </tr>         
          <tr class="tr-condition-info tr-odd">
            <td class="td-content-title">是否抵押：</td>
            <td class="td-content"><div id="id_is_guaranty" class="leftComboContainer"></div>
               <font class="required-content">*</font></td>
            <td class="td-content-title">手续费比例  ：</td>
            <td class="td-content"><input name="framework_condition.handlingchargemoneyratio" id="handlingChargeMoneyRatio" class="td-content-input" require="true" label="手续费比例" datatype="Rate" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)" type="text" value="${empty requestScope['framework_condition.handlingchargemoneyratio']?1:requestScope['framework_condition.handlingchargemoneyratio']}" />
            <font class="required-content">%&nbsp;*</font></td>
            <td class="td-content-title">手续费 ：</td>
            <td class="td-content"><input name="framework_condition.handlingchargemoney" id="handlingChargeMoney" class="td-content-input  td-content-readonly"  readonly datatype="PMoney" label="手续费"  type="text" value="${empty requestScope['framework_condition.handlingchargemoney']?0:requestScope['framework_condition.handlingchargemoney'] }"   /></td>
          </tr>
          <tr class="tr-condition-info tr-even">
            <td class="td-content-title">租金总额：</td><td class="td-content"><input name="framework_condition.renttotalmoney" id="rentTotalMoney" class="td-content-input td-content-readonly" readonly  datatype="PMoney"  type="text" value="${empty requestScope['framework_condition.renttotalmoney']?0:requestScope['framework_condition.renttotalmoney']}" /></td>
             <td class="td-content-title">期初付款总计：</td><td class="td-content"><input title="期初付款总计=起租租金+保证金+手续费+留购价款+保险费+天行健服务费+其他费用" name="framework_condition.firstpaymenttotal" id="firstPaymentTotal" class="td-content-input td-content-readonly" readonly="readonly" type="text" value="${requestScope['framework_condition.firstpaymenttotal'] }" /></td>
             <td class="td-content-title">其他费用  ：</td>
            <td class="td-content"><input name="framework_condition.otherincome" id="otherIncome" class="td-content-input" datatype="PMoney" label="其他收入"  type="text" value="${empty requestScope['framework_condition.otherincome'] ? 0 : requestScope['framework_condition.otherincome']}" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"/></td>
             
          </tr>    
          
          <tr class="tr-condition-info tr-odd">
            <td class="td-content-title" >保险方式:</td>
            <td class="td-content"><div id="id_insurer_type" class="leftComboContainer"></div><font class="required-content">*</font></td>
            <td  id="irr_no_purview_irr" class="td-content-title">内部收益率：</td>
            <td  id="irr_no_purview_irr_content" class="td-content"><input name="framework_condition.irr" id="irr" class="td-content-input td-content-readonly" readonly type="text" value="${empty requestScope['framework_condition.irr']?0:requestScope['framework_condition.irr'] }" />
            <font class="required-content">%</font></td>
            <td class="td-content-title">&nbsp;</td>
            <td class="td-content">&nbsp;</td>
          </tr>
          <tr class="tr-condition-info tr-even">
          	 <td  colspan=6 align="right">
          	 	<div id="id_default_year_rate" class="leftComboContainer" style="display: none;"></div>
          	 	<input name="framework_condition.leaseamtdate" id="leaseAmtDate" type="hidden" value="${requestScope['framework_condition.leaseamtdate'] }"/>          	 	
          	 	<input name="framework_condition.settlemethod" id="settleMethod" type="hidden" value="${empty requestScope['framework_condition.settlemethod']?'even_rent':requestScope['framework_condition.settlemethod'] }"/>
          	 	<input name="framework_condition.ismerger" id="ismerger" type="hidden" value="1"/>
				<input name="framework_condition.id"  id="conditionId" type="hidden" value="${requestScope['framework_condition.id']}">
				<input name="framework_condition.custid" id="conditionCustId" type="hidden" value="${requestScope['framework_condition.custid']}">
				<input name="framework_condition.contractid" id="conditionContractId"  type="hidden" value="${requestScope['framework_condition.contractid']}">
				<input name="framework_condition.projid" id="conditionProjId"  type="hidden" value="${requestScope['framework_condition.projid']}">
				<input name="framework_condition.docid" id="conditionDocId" type="hidden" value="${requestScope['framework_condition.docid']}">
				<input name="framework_condition.process" id="reckonProcess" type="hidden" value="${requestScope['framework_condition.process']}">
				<input name="framework_condition.reckontype" id="reckonType"  type="hidden" value="${empty requestScope['framework_condition.reckontype']?'condition':requestScope['framework_condition.reckontype'] }" />
				<input name="framework_condition.enddate" id="enddate"  type="hidden" value="${requestScope['framework_condition.enddate']}" />
				<input type="hidden" id="id_json_fund_rent_plan_str" name="json_fund_rent_plan_str" value='${empty json_fund_rent_plan_str ? "[]" : json_fund_rent_plan_str}'/><%--租金计划 --%>
				<input type="hidden" id="id_json_fund_cash_flow_str" name="json_fund_cash_flow_str" value='${empty json_fund_cash_flow_str ? "[]" : json_fund_cash_flow_str }'/><%--现金流 --%>
				<input type="hidden" id="id_json_fund_fund_charge_str" name="json_fund_fund_charge_str"  value='${empty json_fund_fund_charge_str ? "[]" : json_fund_fund_charge_str }'/>
				<input style="margin-top:2px;margin-bottom:2px;" id="btn_rent_cal" class="btn btn-primary" type="button" value="租金测算" onclick="conditionReckon();"/>
          	 </td>
          </tr>                
	</table>
    <script type="text/javascript">
//租金测算默认为false,如果修改商务条件，然后保存，再从草稿中打开，是可以提交任务的
var chenckCondiotn=false;//是否改变过租金测算的代码为点租金测算  (false不能提交,true允许提交)
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
    // Internet Explorer
        function OnPropChanged (event) {
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
        	var equipAmt = getNumber("equipAmt");//设备款
            var firstPaymentRatio = getNumber("firstPaymentRatio");//起租比例
            var firstPayment = decimal((equipAmt * firstPaymentRatio)/100,0);//起租租金
            var leaseMoney = decimal(equipAmt*1-firstPayment*1,0);//融资额
            
            var handlingChargeMoneyRatio = getNumber("handlingChargeMoneyRatio");
            var handlingChargeMoney = decimal((leaseMoney * handlingChargeMoneyRatio)/100,0);//手续费
            var cautionMoneyRatio = getNumber("cautionMoneyRatio");
            var cautionMoney = decimal((leaseMoney * cautionMoneyRatio)/100,0);//保证金
            
            if(equipAmt*1 >= 0 && leaseMoney*1 >= 0){
   				jQuery('#leaseMoney').val(leaseMoney);
   				jQuery('#firstPayment').val(firstPayment);
   				jQuery('#handlingChargeMoney').val(handlingChargeMoney);
   				jQuery('#cautionMoney').val(cautionMoney);
    			firstPaymentTotal();
            }
     	}
       	/*
       	根据金额算比例
       	*/
        function setRatio(obj,num){
        	var equip_amt=getNumber("equipAmt");
        	if(equip_amt==""){equip_amt=0;}
        	if(num*1>=0){
        		jQuery('#'+obj+"Ratio").val(decimal(num/equip_amt*100,6));
        	}
        }
		/*
       	根据比例算金额
       	*/
        function setMoneyByRatio(obj,num){
        	var equip_amt=getNumber("equipAmt");
        	if(num*1>=0){
        		jQuery('#'+obj).val(decimal(num*equip_amt/100,0));
        	}
        }
        /*
       	根据比例算金额
       	*/
        function setMoneyByRatioNew(obj,num){
        	var leaseMoney=getNumber("leaseMoney");
        	if(num*1>=0){
        		jQuery('#'+obj).val(decimal(num*leaseMoney/100,0));
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
        function OnchangeDate(){
			var starDate=jQuery('#startDate').val();
			//按照付款间隔推算起租日
			var income_number_year=getTracywindyObject("id_combo_id_income_number_year").getValue();
			var period_type=getTracywindyObject("id_combo_id_period_type").getValue();
			if(income_number_year=="income_1") {income_number_year="1";}
			if(income_number_year=="income_2") {income_number_year="2";}
			if(income_number_year=="income_3") {income_number_year="3";}
			if(income_number_year=="income_6") {income_number_year="6";}
			if(income_number_year=="income_12"){income_number_year="12";}
			if(period_type=="period_type_0") {period_type="0";}
			if(period_type=="period_type_1") {period_type="1";}
			if(income_number_year==""||period_type==""||starDate==""){
				return;
			}
			var firstPlanDate="";
			if(income_number_year!=""&&period_type!=""){
				firstPlanDate=calculateDate(5,income_number_year*period_type,starDate);
			}
			//当月6日至当月15日起租的项目，次月15日还第一期租金；
			//当月16日至当月25日起租的项目，次月25日还第一期租金；
			//当月26日至次月5日起租的项目，次次月5日还第一期租金。
			var day=starDate.split("-")[2];
			if(day<6){
				firstPlanDate=firstPlanDate.substring(0,7)+"-05";
			}else	if(day>=6&&day<=15){
				firstPlanDate=firstPlanDate.substring(0,7)+"-15";
			}else if(day>=16&&day<=25){
				firstPlanDate=firstPlanDate.substring(0,7)+"-25";
			}else{
				firstPlanDate=firstPlanDate.substring(0,7)+"-05";
				firstPlanDate=calculateDate(5,1,firstPlanDate);
			}
			jQuery("#firstPlanDate").val(firstPlanDate);
			jQuery("#leaseAmtDate").val(starDate);
		}
		
		//计算  期初付款总计 和 净融资额 ：
     	function firstPaymentTotal(){
        		var clean_lease_money = decimal(getNumber("equipAmt"), 0);
        		var first_payment_total = 0;
        		first_payment_total += decimal(getNumber("firstPayment"), 0);
        		first_payment_total += decimal(getNumber("cautionMoney"), 0);
        		first_payment_total += decimal(getNumber("handlingChargeMoney"), 0);
        		first_payment_total += decimal(getNumber("otherIncome"), 0);
        		first_payment_total += decimal(getNumber("insureMoney"), 0);
        		first_payment_total += decimal(getNumber("gpsMoney"), 0);
        		first_payment_total += decimal(getNumber("nominalPrice"), 0);
        		clean_lease_money -= first_payment_total;
        		jQuery('#firstPaymentTotal').val(decimal(first_payment_total, 0));
        		jQuery('#cleanLeaseMoney').val(decimal(clean_lease_money, 0));
        		chenckCondiotn = false;
        }
     	function incomeNumber(){//计算期数
   			var income_number=getNumber("incomeNumber");
   			var income_number_year=getTracywindyObject("id_combo_id_income_number_year").getValue();
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
   				jQuery('#leaseTerm').val((income_number*1)*income_number_year);
   			}
   			OnchangeDate();
   			chenckCondiotn=false;
     	}
     	function checkSubmit(){
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
	    	 var fundCashDetail = getTracywindyObject('table_id_table_leasing_fund_cash_flow_container');
	    	 fundCashDetail.tableData = rs['fundcashdetail'];
	    	 jQuery('#irr').val(decimal((rs['irr']),6)) ;
	    	 jQuery('#enddate').val(rs['enddate']);
	    	 jQuery('#rentTotalMoney').val(rs['renttotalmoney']);
     		//保存多行控件的值
	    	 jQuery('#id_json_fund_cash_flow_str').val(JsonUtil.encode(fundCashDetail.getRowsJsonData())) ;
     		 jQuery('#id_json_fund_rent_plan_str').val(JsonUtil.encode(fundRentPlan.getRowsJsonData())) ;
     		 fundRentPlan.reload();
	    	 fundCashDetail.reload();
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
    	 }
         //根据测算方式控制是否显示多行控件操作条
         var settle_method=jQuery("#settleMethod").val();
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
	        	//fundPlan.disabledToolsByText("修改");
			}else{
				//fundPlan.enabledToolsByText("修改");
			}
    	}
    }
    //设置租金计划表中的控制
    function rentPlanMultiTable(settleMethod){
    	if(!settleMethod){
    		var settle_method=jQuery("#settleMethod").val();
        	settleMethod=settle_method?settle_method:"${empty requestScope['framework_condition.settlemethod']?'even_rent':requestScope['framework_condition.settlemethod'] }";
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
        }else if('irregular_rent'!= settleMethod){
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
		//合同审批判断死否做过租金测算
		contract_approval=true;
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
			var fundChargePlan = getTracywindyObject('table_id_table_leasing_fund_fund_charge_container');//合同资金计划
	    	if(typeof(fundChargePlan)=='object'){
				jQuery('#id_json_fund_fund_charge_str').val(JsonUtil.encode(fundChargePlan.getRowsJsonData()));
	    	}
			return true;
        }catch (e){
            alert('保存租金测算结果出错['+e+']!');
            return false;
        }
    }
    //德银不需要的内容隐藏
    jQuery('#deewinflspecial').hide();
    //只读页面不显示测算按钮
    if(isViewHistoryTask){
    	jQuery('#btn_rent_cal').hide();
    }
  //起租是反转只读
    function conditionOnHire(){
    	formJSPInputHideOrShow("onHireProcessDataTR","framework_condition.yearrate",1);
    	jQuery('#btn_rent_cal').show();
    }
    function checkEquipMoney(){
    	//计算租赁物的总交易价格
		var currentTable = getTracywindyObject('table_id_table_leasing_proj_equip_container');
		var data = currentTable.tableData;
		var totalPrice = 0;
		for(var i=0;i<data.length;i++){
			totalPrice += parseFloat(data[i]['nowtotal']);
		}
		var equipAmt = parseFloat($("#equipAmt").val());
		if(totalPrice !=  equipAmt){//如果不相等，则跳出执行
			alert("【租赁物明细】标签的合计总价["+ totalPrice + "]和【拟商务条件】标签中的设备款["+ equipAmt +"]不相等,请检查.");
			return false;
		} else{
			return true;
		}
    }
    </script>
<permission:action  code="irr_no_purview">
<script type="text/javascript">
//jQuery('#irr_no_purview_irr').hide();//经销商不可见
jQuery('#irr_no_purview_irr').html('');//经销商不可见
jQuery('#irr_no_purview_irr_content').html('');//经销商不可见
</script >
</permission:action>
</div>