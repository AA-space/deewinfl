<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
     <style type="text/css">
        .tabs-panels{
          border:0px solid #ddd;
        }
     </style>
	<table class="fillTable" cellspacing="0" cellpadding="0">
		  <tr>
             <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-condition"></div>拟商务条件&gt;租金测算</td>
          </tr>
          <tr class="tr-project-condition tr-even">
             <td class="td-content-title">客户名称：</td><td class="td-content" ><input name="cust_info.read_cust_name" class="td-content-input td-content-readonly"  readOnly type="text" value="${requestScope['proj_info.cust_name']}"></td>
             <td class="td-content-title">报价编号：</td><td class="td-content"><input name="contract_condition.quot_id" class="td-content-input td-content-readonly"  
             type="text" value="${requestScope['contract_condition.quot_id']}"   /></td>
             <td class="td-content-title">租金计算方法：</td><td class="td-content"><div id="id_settle_method" class="leftComboContainer"></div><font class="required-content">*</font></td>
          </tr>          
          <tr class="tr-project-condition tr-odd">
             <td class="td-content-title">设备款：</td><td class="td-content"><input name="contract_condition.equip_amt" id="equip_amt" class="td-content-input" type="text"  oninput="OnInput (event)" onpropertychange="OnPropChanged (event)" dataType="Double" require="true" label="设备款" value="${requestScope['contract_condition.equip_amt']}"><font class="required-content">*</font></td>
             <td class="td-content-title">设备款支付日期：</td><td class="td-content"><input name="contract_condition.lease_amt_date" id="lease_amt_date" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['contract_condition.lease_amt_date'] }"  onClick="WdatePicker(this,{readOnly:true})" require="true" label="设备款支付日期" readOnly /><font class="required-content">*</font></td>
             <td class="td-content-title">公差/公比：</td><td class="td-content"><input name="contract_condition.ratio_param" id="ratio_param" class="td-content-input" type="text" value="${requestScope['contract_condition.ratio_param']}"></td>
          </tr>  
          <tr class="tr-project-condition tr-even">
             <td class="td-content-title">首付比例：</td><td class="td-content"><input name="contract_condition.first_payment_ratio" id="first_payment_ratio" class="td-content-input"  type="text" dataType="Double" label="首付款比例" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"  value="${requestScope['contract_condition.first_payment_ratio']}"><font class="required-content">%</font></td>
             <td class="td-content-title">首付款：</td><td class="td-content"><input name="contract_condition.first_payment" id="first_payment" class="td-content-input td-content-readonly"  readonly type="text" value="${empty requestScope['contract_condition.first_payment'] ? 0 : requestScope['contract_condition.first_payment']}"></td>
             <td class="td-content-title">融资额：</td><td class="td-content"><input name="contract_condition.lease_money" id="lease_money" class="td-content-input td-content-readonly" readonly type="text" value="${empty requestScope['contract_condition.lease_money'] ? 0 : requestScope['contract_condition.lease_money']}"   /></td>
          </tr>         
          <tr class="tr-project-condition tr-odd">
             <td class="td-content-title">付租类型 ：</td><td class="td-content"><div id=id_income_number_year class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">还租次数：</td><td class="td-content"><input name="contract_condition.income_number" id="income_number" class="td-content-input" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"  require="true"  dataType="Number" label="还租次数" type="text" value="${requestScope['contract_condition.income_number']}"><font class="required-content">*</font></td>
             <td class="td-content-title">租赁期限(月)：</td><td class="td-content"><input name="contract_condition.lease_term" id="lease_term" class="td-content-input td-content-readonly" require="true" label="租赁期限" readonly type="text" value="${ requestScope['contract_condition.lease_term'] }"   /><font class="required-content">*</font></td>
          </tr>         
          <tr class="tr-project-condition tr-even">
             <td class="td-content-title">付租方式：</td><td class="td-content"><div id="id_period_type" class="leftComboContainer"></div><font class="required-content">*</font></td>
             <td class="td-content-title">租赁年利率：</td><td class="td-content"><input name="contract_condition.year_rate" id="year_rate" class="td-content-input" require="true" dataType="Double" label="租赁年利率" type="text" value="${requestScope['contract_condition.year_rate']}"><font class="required-content">%&nbsp;*</font></td>
             <td class="td-content-title">罚息利率：</td><td class="td-content"><input name="contract_condition.pena_rate" id="pena_rate" class="td-content-input "  type="text" value="${requestScope['contract_condition.pena_rate'] }"   /></td>
          </tr>         
          <tr class="tr-project-condition tr-odd">
             <td class="td-content-title">留购价款：</td><td class="td-content"><input name="contract_condition.nominal_price" id="nominal_price" class="td-content-input"   type="text" value="${empty requestScope['contract_condition.nominal_price'] ? 0 : requestScope['contract_condition.nominal_price']}"></td>
             <td class="td-content-title">保证金比例：</td><td class="td-content"><input name="contract_condition.caution_money_ratio" accept="caution_money_ratio" id="caution_money_ratio" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['contract_condition.caution_money_ratio']}"><font class="required-content">%</font></td>
             <td class="td-content-title">保证金：</td><td class="td-content"><input name="contract_condition.caution_money" id="caution_money" class="td-content-input td-content-readonly" readonly type="text" value="${empty requestScope['contract_condition.caution_money'] ? 0 : requestScope['contract_condition.caution_money'] }"   /></td>
          </tr>         
          <tr class="tr-project-condition tr-even">
             <td class="td-content-title">期末余值：</td><td class="td-content"><input name="contract_condition.assets_value" id="assets_value" class="td-content-input"   type="text" value="${empty requestScope['contract_condition.assets_value']?0:requestScope['contract_condition.assets_value']}"></td>
             <td class="td-content-title">承租人保证金比例：</td><td class="td-content"><input name="contract_condition.cust_caution_money_ratio" id="cust_caution_money_ratio" class="td-content-input td-content-readonly"  readonly type="text" value="${requestScope['contract_condition.cust_caution_money_ratio']}"><font class="required-content">%</font></td>
             <td class="td-content-title">承租人保证金：</td><td class="td-content"><input name="contract_condition.cust_caution_money" id="cust_caution_money" class="td-content-input " oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"   dataType="Double" label="承租人保证金"  type="text" value="${empty requestScope['contract_condition.cust_caution_money'] ? 0 : requestScope['contract_condition.cust_caution_money']}"   /></td>
          </tr>         
          <tr class="tr-project-condition tr-odd">
             <td class="td-content-title">投保方式：</td><td class="td-content"><div id="id_insure_type"></div></td>
             <td class="td-content-title">供应商保证金比例：</td><td class="td-content"><input name="contract_condition.supplier_caution_money_ratio" id="supplier_caution_money_ratio" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['contract_condition.supplier_caution_money_ratio']}"><font class="required-content">%</font></td>
             <td class="td-content-title">供应商保证金：</td><td class="td-content"><input name="contract_condition.supplier_caution_money" id="supplier_caution_money" class="td-content-input" oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"   dataType="Double" label="供应商保证金"  type="text" value="${empty requestScope['contract_condition.supplier_caution_money']?0:requestScope['contract_condition.supplier_caution_money'] }"   /></td>
          </tr>         
          <tr class="tr-project-condition tr-even">
             <td class="td-content-title">保险公司：</td><td class="td-content"><input name="contract_condition.insure" id="insure" class="td-content-input"   type="text" value="${requestScope['contract_condition.insure']}"></td>
             <td class="td-content-title">保证金抵扣比例：</td><td class="td-content"><input name="contract_condition.caution_deduction_ratio" id="caution_deduction_ratio" class="td-content-input td-content-readonly"  readonly type="text" value="${requestScope['contract_condition.caution_deduction_ratio']}"><font class="required-content">%</font></td>
             <td class="td-content-title">保证金抵扣金额：</td><td class="td-content"><input name="contract_condition.caution_deduction_money" id="caution_deduction_money" class="td-content-input " oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"   dataType="Double" label="保证金抵扣金额"  type="text" value="${empty requestScope['contract_condition.caution_deduction_money'] ? 0 : requestScope['contract_condition.caution_deduction_money']}"   />
             </td>
           </tr>
          <%--        
          <tr class="tr-project-condition tr-odd">
             <td class="td-content-title">保险费：</td><td class="td-content"><input name="contract_condition.insurance" class="td-content-input"   type="text" value="${requestScope['contract_condition.insurance']}"></td>
             <td class="td-content-title">预收租金比例：</td><td class="td-content"><input name="contract_condition.caution_money_ratio" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['contract_condition.caution_money_ratio']}"></td>
             <td class="td-content-title">预收租金金额 ：</td><td class="td-content"><input name="contract_condition.caution_money" class="td-content-input td-content-readonly" readonly type="text" value="${requestScope['contract_condition.caution_money'] }"   /></td>
          </tr>         
          <tr class="tr-project-condition tr-even">
             <td class="td-content-title"></td><td class="td-content"></td>
             <td class="td-content-title">预收租金抵扣比例 ：</td><td class="td-content"><input name="contract_condition.caution_money_ratio" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['contract_condition.caution_money_ratio']}"></td>
             <td class="td-content-title">预收租金抵扣金额 ：</td><td class="td-content"><input name="contract_condition.caution_money" class="td-content-input "  type="text" value="${requestScope['proj_conditon.caution_money'] }"   /></td>
          </tr> 
             --%>     
          <tr class="tr-project-condition tr-odd">
             <td class="td-content-title">保险费：</td><td class="td-content"><input name="contract_condition.insure_money" id="insure_money" class="td-content-input"   type="text" value="${empty requestScope['contract_condition.insure_money']?0:requestScope['contract_condition.insure_money']}"></td>
             <td class="td-content-title">手续费比例  ：</td><td class="td-content"><input name="contract_condition.handling_charge_ratio" id="handling_charge_ratio" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['contract_condition.handling_charge_ratio']}"><font class="required-content">%</font></td>
             <td class="td-content-title">手续费 ：</td><td class="td-content"><input name="contract_condition.handling_charge" id="handling_charge" class="td-content-input " oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"   dataType="Double" label="手续费"  type="text" value="${empty requestScope['contract_condition.handling_charge']?0:requestScope['contract_condition.handling_charge'] }"   /></td>
          </tr>         
          <tr class="tr-project-condition tr-even">
             <td class="td-content-title">厂商返利：</td><td class="td-content"><input name="contract_condition.amt_return" id="amt_return" class="td-content-input "  type="text" value="${empty requestScope['contract_condition.amt_return']?0:requestScope['contract_condition.amt_return'] }" /></td>
             <td class="td-content-title">管理费比例  ：</td><td class="td-content"><input name="contract_condition.management_fee_ratio" id="management_fee_ratio" class="td-content-input td-content-readonly" readonly  type="text" value="${requestScope['contract_condition.management_fee_ratio']}"><font class="required-content">%</font></td>
             <td class="td-content-title">管理费 ：</td><td class="td-content"><input name="contract_condition.management_fee" id="management_fee" class="td-content-input "  oninput="OnInput (event)" onpropertychange="OnPropChanged (event)"   dataType="Double" label="管理费" type="text" value="${empty requestScope['contract_condition.management_fee']?0:requestScope['contract_condition.management_fee'] }" /></td>
          </tr>         
          <tr class="tr-project-condition tr-odd">
             <td class="td-content-title">调息方式：</td><td class="td-content"><div id="id_adjust_style"></div></td>
             <td class="td-content-title">其他收入  ：</td><td class="td-content"><input name="contract_condition.other_income" id="other_income" class="td-content-input td-content-readonly" readonly  type="text" value="${empty requestScope['contract_condition.other_income'] ? 0 : requestScope['contract_condition.other_income']}"></td>
             <td class="td-content-title">其他支出 ：</td><td class="td-content"><input name="contract_condition.other_expenditure" id="other_expenditure" class="td-content-input "  type="text" value="${empty requestScope['contract_condition.other_expenditure'] ? 0 : requestScope['contract_condition.other_expenditure'] }" /></td>
          </tr>         
          <tr class="tr-project-condition tr-even">
             <td class="td-content-title">起租日期：</td><td class="td-content"><input name="contract_condition.start_date" id="start_date" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['contract_condition.start_date'] }"  onClick="WdatePicker(this,{readOnly:true})" require="true" label="起租日期" readOnly /><font class="required-content">*</font></td>
             <td class="td-content-title">利率浮动类型  ：</td><td class="td-content"><div id="id_rate_float_type"></div></td>
             <td class="td-content-title">利率调整值 ：</td><td class="td-content"><input name="contract_condition.rate_float_amt" id="rate_float_amt" class="td-content-input "  type="text" value="${empty requestScope['contract_condition.rate_float_amt'] ? 0 : requestScope['contract_condition.rate_float_amt'] }" /></td>
          </tr>         
          <tr class="tr-project-condition tr-odd">
             <td class="td-content-title">第一期租金支付日：</td><td class="td-content"><input name="contract_condition.rent_start_date" id="rent_start_date" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['contract_condition.rent_start_date']}"  onClick="WdatePicker(this,{readOnly:true})" require="true" label="第一期租金支付日" readOnly /><font class="required-content">*</font></td>
             <td class="td-content-title">是否收租前息  ：</td><td class="td-content"><div id="id_is_before_interest"></div></td>
             <td class="td-content-title">租前息金额 ：</td><td class="td-content"><input name="contract_condition.before_interest" id="before_interest" class="td-content-input "  type="text" value="${empty requestScope['contract_condition.before_interes'] ? 0 : requestScope['contract_condition.before_interest'] }" /></td>
          </tr>
          <tr class="tr-project-condition tr-even">
             <td class="td-content-title">宽限期数：</td><td class="td-content"><input name="contract_condition.grace" id="grace" class="td-content-input "  type="text" value="${empty requestScope['contract_condition.grace'] ? 0 : requestScope['contract_condition.grace'] }" /></td>
             <td class="td-content-title">净融资额  ：</td><td class="td-content"><input name="contract_condition.actual_fund" id="actual_fund" class="td-content-input td-content-readonly" readonly  type="text" value="${empty requestScope['contract_condition.actual_fund']?0:requestScope['contract_condition.actual_fund']}"></td>
             <td class="td-content-title">期初付款总计 ：</td><td class="td-content"><input name="contract_condition.first_payment_total" id="first_payment_total" class="td-content-input td-content-readonly" readonly type="text" value="${requestScope['contract_condition.first_payment_total'] }" /></td>
          </tr>                   
          <tr class="tr-project-condition tr-odd">
             <td class="td-content-title">内部收益率：</td><td class="td-content"><input name="contract_condition.irr" id="irr" class="td-content-input td-content-readonly" readonly type="text" value="${requestScope['contract_condition.irr'] }" /><font class="required-content">%</font></td>
             <td class="td-content-title">财务收益率  ：</td><td class="td-content"><input name="contract_condition.plan_irr" id="plan_irr" class="td-content-input"  type="text" value="${requestScope['contract_condition.plan_irr']}"><font class="required-content">%</font></td>
             <td class="td-content-title">免罚息天数 ：</td><td class="td-content"><input name="contract_condition.free_defa_inter_day" id="free_defa_inter_day" class="td-content-input td-content-readonly" readonly type="text" value="${empty requestScope['contract_condition.free_defa_inter_day']?0:requestScope['contract_condition.free_defa_inter_day'] }" /></td>
          </tr> 
          <tr class="tr-project-condition tr-even">
          	 <td class="td-content-title" colspan=5 ></td><td>
          		 <input style="margin-top:2px;margin-bottom:2px;" id="btn_rent_cal" class="btn btn-primary" type="button" value="租金测算" onclick="rentCalculate();"/>
          	 </td>
          </tr>
          <tr>
             <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-fund-rent_plan"></div>拟商务条件&gt;租金测算&gt;租金计划</td>
          </tr>
          <tr class="td-tabs-container tr-fund-rent_plan">
          		<td colspan=6 class="td-tabs-container" style="text-indent:0px;">
          			<div id='id_project_fund_rent_plan_tabs_content' style="">
		          			<div title="租金尝还计划"><div id="id_leasing_table_fund_rent_plan" style="overflow: hidden;">
		          			</div></div>
		          			<div title="现金流量表"><div id="id_leasing_table_fund_rent_cash" style="overflow: hidden;">
		          			</div></div>
          			</div>
          		</td>
          </tr>                  
	</table>
<script type="text/javascript">
//页面各种赋值自动计算
 // Firefox, Google Chrome, Opera, Safari, Internet Explorer from version 9
        function OnInput (event) {
            var name = getTarget(event).id;
            var value =parseFloat(event.target.value);
            equipAmt();
            if (name == 'income_number'){//期限计算
            	incomeNumber();
                }
        }
    // Internet Explorer
        function OnPropChanged (event) {
            if (event.propertyName.toLowerCase () == "value") {
               // alert ("The new content: " + event.srcElement.value);
               var name = getTarget(event).id;
                equipAmt();
                if (name == 'income_number'){//期限计算
                	incomeNumber();
                    }
            }
        } 
      //净融资额=设备款-保证金-手续费-厂商返佣-其他收入+其他支出 -租前息-管理费-首付款
      
        function  equipAmt(){//设备款改变 影响 首付款,融资额,保证金(比例) 保证金抵扣 预收租金 手续费 管理费 首付款
        	var lease_money = parseFloat(jQuery('#first_payment').attr("value"));//融资额
            var equip_amt = parseFloat(jQuery('#equip_amt').attr("value")==''?0:jQuery('#equip_amt').attr("value"));//设备款
            var first_payment_ratio=document.getElementById("first_payment_ratio").value;
            var handling_charge=document.getElementById("handling_charge").value;
            var management_fee=document.getElementById("management_fee").value;
            var cust_caution_money = parseFloat(jQuery('#cust_caution_money').attr("value")==''?0:jQuery('#cust_caution_money').attr("value"));
            var supplier_caution_money = parseFloat(jQuery('#supplier_caution_money').attr("value")==''?0:jQuery('#supplier_caution_money').attr("value"));
            var caution_deduction = parseFloat(jQuery('#caution_deduction_money').attr("value")==''?0:jQuery('#caution_deduction_money').attr("value"));
			//防止设备款为空时就进行计算，导致页面值出现NAN值
            if (equip_amt==0){
					alert("设备款不能为空");
					return false;
                }
            if(equip_amt>0){
    			if(first_payment_ratio*1>=0){				
    				document.getElementById("first_payment").value=decimal(equip_amt*first_payment_ratio/100,2);					
    			}
    			var first_payment=document.getElementById("first_payment").value;
    			if(first_payment*1>=0&&equip_amt*1>=0){
    				document.getElementById("lease_money").value=decimal(equip_amt*1-first_payment*1,2);
    			}

    			//分为承租人和供应商保证金
    			setRatio("handling_charge",handling_charge);
    			setRatio("management_fee",management_fee);			
    			setRatio("cust_caution_money",cust_caution_money);
    			setRatio("supplier_caution_money",supplier_caution_money);	
    			setRatio("caution_deduction",caution_deduction);	
			
    			document.getElementById("caution_money").value=cust_caution_money*1+supplier_caution_money*1;
    			setRatio("caution_money",cust_caution_money*1+supplier_caution_money*1);
    			beforeInterest();
    			firstPaymentTotal();
    			var first_payment_total=document.getElementById("first_payment_total").value;
    			document.getElementById("actual_fund").value=decimal(equip_amt*1-first_payment_total*1,2);
    			if(caution_deduction*1>(cust_caution_money*1+supplier_caution_money*1)*1){
    				alert("保证金比例不能小于保证金抵扣比例");
    			}
             }
      }
        	/*
        	根据金额算比例
        	*/
        function setRatio(obj,num){
        	var equip_amt=document.getElementById("equip_amt").value;
        	if(num*1>=0){
        		document.getElementById(obj+"_ratio").value=decimal(num/equip_amt*100,6);
        	}
        }
            
		//计算  期初付款总计 和 净融资额 ：
     	function firstPaymentTotal(){
        		var first_payment=document.getElementById("first_payment").value;
        		var caution_money=document.getElementById("caution_money").value;
        		var handling_charge_money=document.getElementById("handling_charge").value;
        		var amt_return=document.getElementById("amt_return").value;
        		var other_income=document.getElementById("other_income").value;
        		var other_expenditure=document.getElementById("other_expenditure").value;
        		var before_interest=document.getElementById("before_interest").value;
        		var management_fee=document.getElementById("management_fee").value;
        		first_payment=first_payment==""?"0":first_payment;
        		caution_money=caution_money==""?"0":caution_money;
        		handling_charge_money=handling_charge_money==""?"0":handling_charge_money;
        		amt_return=amt_return==""?"0":amt_return;
        		other_income=other_income==""?"0":other_income;
        		other_expenditure=other_expenditure==""?"0":other_expenditure;
        		before_interest=before_interest==""?"0":before_interest;
        		management_fee=management_fee==""?"0":management_fee;
        		document.getElementById("first_payment_total").value=decimal(first_payment*1+caution_money*1+handling_charge_money*1+amt_return*1+other_income*1-other_expenditure*1+before_interest*1+management_fee*1,2);
        		var equip_amt=document.getElementById("equip_amt").value;
        		var first_payment_total=document.getElementById("first_payment_total").value;
        		document.getElementById("actual_fund").value=decimal(equip_amt*1-first_payment_total*1,2);
        }
     	//租前息计算
     	function beforeInterest(){
     			var equip_amt=document.getElementById("equip_amt").value;
     			var year_rate=document.getElementById("year_rate").value;
     			var start_date=document.getElementById("start_date").value;
     			var lease_amt_date=document.getElementById("lease_amt_date").value;
     			var is_before_interest=getTracywindyObject("id_combo_is_before_interest").getRawValue();
     			if(!(start_date==""||lease_amt_date==""||year_rate==""||equip_amt=="")&&is_before_interest!="否"){
     				var diff=datediff('day',start_date,lease_amt_date);
     				diff=diff<0?0:diff;
     				document.getElementById("before_interest").value=decimal(equip_amt*diff*year_rate/100/year_rate/365,2);
     				//设备款 *(起租日-设备支付日)*年利率/365
     			}
     	}
     	function chargeBefInte(){

     		if (getTracywindyObject("id_combo_is_before_interest").getRawValue()=="否") {
     			document.getElementById("before_interest").value="0";
     		} else {//计算租前息
     			beforeInterest();
     		}


     		}
     	function incomeNumber(){//计算期数
     			var income_number=document.getElementById("income_number").value;
     			var income_number_year=getTracywindyObject("id_combo_income_number_year").getValue();
     			var grace=document.getElementById("grace").value;
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
     				document.getElementById("lease_term").value=(income_number*1+grace*1)*income_number_year;
     			}
     	}

     	function checkSubmit(){
     		var checktime = document.getElementById("start_date").value; 
     		var rent_start_date = document.getElementById("rent_start_date").value; 
     		
     		var times = getCurDateTime().substring(0,10);
     		if(checktime<times){
     			alert("起租日期不能小于今天!");
     			return false;
     		}else if(rent_start_date<times){
     			alert("第一期租金支付日不能小于今天!");
     			return false;
     		}
     		var settle_method=getTracywindyObject("id_combo_settle_method").getRawValue();
     		var ratio_param= document.getElementById("ratio_param").value; 
     		if(('等额租金' != settle_method)&&('等额本金' != settle_method)&&('均息法' != settle_method)&&('不规则' != settle_method)&&(ratio_param=='')){
     			alert("公差/比不能为空！");
     			return false;
         		}
     		return true;	
     	}
	//租金测算
	function rentCalculate(){
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(isPassed){
		if(!checkSubmit()){return false;};
		rentCalculateSubmit();
		}
	}
    function rentCalculateSubmit()
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
        var submitProcessedForm = document.getElementById("id_submitProcessedForm");
        with(submitProcessedForm)
        {
            action="{pageContext.request.contextPath}/submitProcessedForm/leasing/projRentCalculate.action";
        	submit();
            action="{pageContext.request.contextPath}/submitProcessedForm/jbpm/submitProcessedForm.action";
        }
    	return false;
	}
    function ajaxProjRentCalculateCallBack(returnResult){
         jQuery("#id_workflowAdviseContainer").css("overflow","auto");
         jQuery("#id_workflowFormContainer").css("overflow","auto");
    	 loadMask.hide();
    	 //alert(JsonUtil.decode(returnResult)['json_fund_rent_cash_str']);
    	 var planTable = getTracywindyObject('table_leasing_table_fund_rent_plan');
    	 planTable.tableData = JsonUtil.decode(returnResult)['rentPlanDetails'];
    	 var cashTable = getTracywindyObject('table_leasing_table_fund_rent_cash');
    	 cashTable.tableData = JsonUtil.decode(returnResult)['rentCashDetails'];
    	 planTable.reload();
    	 cashTable.reload();
    	 jQuery('#id_json_fund_rent_plan_str').val(JsonUtil.encode(planTable.getRowsJsonData())) ;
    	 jQuery('#id_json_fund_rent_cash_str').val(JsonUtil.encode(cashTable.getRowsJsonData())) ;
    	 jQuery('#irr').val(decimal((JsonUtil.decode(returnResult)['irr'])*100,6)) ;
         alert("租金测算成功");
    }
    
    
</script>
</div>