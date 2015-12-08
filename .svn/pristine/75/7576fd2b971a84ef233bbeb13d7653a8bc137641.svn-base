<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div id="businessconditionForm">
	    <div class="mini-panel" title="授信条件" showCollapseButton="true" style="width: 100%;">
		    <table class="fillTable" cellspacing="0" cellpadding="0" id="proj_base_info" >
		          <tr class="tr-project-info tr-even">
		              <td class="td-content-title"  >设备款：</td>
		              <td class="td-content">
		             		<!-- 下边的值是一些关建行信息值，包跨项目阶段的项目编号，合同阶段的合同编号，客户报价时客户编号  //实际授信月数(申请书需用到)//保证金抵扣期数-->
						  <input name="framework_condition.id" 			id="conditionId"  		style="display:none;"	class="mini-textbox" value="${requestScope['framework_condition.id']}"/>
						  <input name="framework_condition.custid" 		id="conditionCustId" 	style="display:none;"	class="mini-textbox" value="${requestScope['framework_condition.custid']}"/>
						  <input name="framework_condition.contractid" 	id="conditionContractId" 	style="display:none;"	class="mini-textbox" value="${requestScope['framework_condition.contractid']}"/>
						  <input name="framework_condition.projid" 		id="conditionProjId" 		style="display:none;"	class="mini-textbox" value="${requestScope['framework_condition.projid']}"/>
						  <input name="framework_condition.docid" 		id="conditionDocId" 		style="display:none;"	class="mini-textbox" value="${requestScope['framework_condition.docid']}"/> 
						  <input name="framework_condition.creditmonths"id="creditmonths" 	        style="display:none;"	class="mini-textbox" value="${requestScope['framework_condition.creditmonths']}"/> 
						  <input name="framework_condition.dcnum" 		id="dcnum" 	        		style="display:none;"	class="mini-textbox" value="${requestScope['framework_condition.dcnum']}"/>
						  
						  <!-- 下面是关于测算的关键值 -->
						    <input name="framework_condition.process" 		id="reckonProcess" 			style="display:none;"	class="mini-textbox" value="${requestScope['framework_condition.process']}"/>
							<input name="framework_condition.reckontype" 	id="reckonType"  			style="display:none;"	class="mini-textbox" value="${empty requestScope['framework_condition.reckontype']?'condition':requestScope['framework_condition.reckontype'] }"/>
							
							<!-- 下边的是租金计划的值，就是测算结果 -->
							<input name="json_fund_rent_plan_str" 			id="id_json_fund_rent_plan_str" 		style="display:none;"	class="mini-textbox" value='${empty json_fund_rent_plan_str ? "[]" : json_fund_rent_plan_str}'/><%-- 租金计划 --%>
							<input name="json_fund_cash_flow_str" 			id="id_json_fund_cash_flow_str" 		style="display:none;"	class="mini-textbox" value='${empty json_fund_cash_flow_str ? "[]" : json_fund_cash_flow_str }'/><%-- 现金流 --%>
							<input name="json_finance_rent_plan_str" 		id="id_json_finance_rent_plan_str" 		style="display:none;"	class="mini-textbox" value='${empty json_finance_rent_plan_str ? "[]" : json_finance_rent_plan_str }'/><%-- 会计租金计划 --%>
							<input name="json_finance_cash_flow_str" 		id="id_json_finance_cash_flow_str" 		style="display:none;"	class="mini-textbox" value='${empty json_finance_cash_flow_str ? "[]" : json_finance_cash_flow_str }'/><%-- 会计现金流 --%>
							<input name="json_fund_fund_charge_str" 		id="id_json_fund_fund_charge_str" 		style="display:none;"	class="mini-textbox" value='${empty json_fund_fund_charge_str ? "[]" : json_fund_fund_charge_str }'/><%-- 资金首付计划 --%>
							<input name="json_knowing_rent_plan_str" 		id="id_json_knowing_rent_plan_str"  	style="display:none;"	class="mini-textbox" value='${empty json_knowing_rent_plan_str ? "[]" : json_knowing_rent_plan_str }'/><!-- 已知租金法的租金列表 -->
							  
		             	  <input name="equipamt" id ="equipamt"  class="mini-textbox" value="" onvaluechanged="changefirstpaymentratio"></td>
		              <td class="td-content-title">首付款：</td>
		              <td class="td-content"><input name="firstpayment" id ="firstpayment"  class="mini-textbox" value="" onvaluechanged="changefirstpaymentratio"></td>
		              <td class="td-content-title">首付比例：</td>
		              <td class="td-content"><input name="firstpaymentratio" id ="firstpaymentratio"  class="mini-textbox" value="" readonly><font class="required-tag">%*</font></td>
		              <td class="td-content-title">期末余值：</td>
		              <td class="td-content"><input name="equipendvalue" id ="equipendvalue"  class="mini-textbox" value=""></td>
		          </tr>
		               
		          <tr class="tr-project-info tr-odd">
		              <td class="td-content-title">净融资额：</td>
		              <td class="td-content"><input name="cleanleasemoney" id ="cleanleasemoney"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">期初付款总计：</td>  
		              <td class="td-content"><input name="firstpaymenttotal" id ="firstpaymenttotal"  class="mini-textbox" value="" readonly></td>
		              <td class="td-content-title">净授信额：</td>
		              <td class="td-content"><input name="cleancreditmoney" id ="cleancreditmoney"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">净授信比例：</td>
		              <td class="td-content"><input name="cleancreditratio" id ="cleancreditratio"  class="mini-textbox" value=""></td>
		          </tr>
			</table>
		</div>
		
		<div class="mini-panel" title="租金推算方式" showCollapseButton="true" style="width: 100%;">
		    <table class="fillTable" cellspacing="0" cellpadding="0" id="proj_base_info" >
		          <tr class="tr-project-info tr-even">
		              <td class="td-content-title">租金计算方式：</td>
		              <td class="td-content">
		              	   <input id="settlemethod" name="settlemethod" class="mini-combobox" textField="name" 
		                  	   valueField="value"  
							   dataField="datas"
							   allowInput="false" 
							   data-options="{_params:{pid:'settle_method'}}" 
							   onbeforeshowpopup="onbeforeshowpopup"
						   />
		              </td>
		              <td class="td-content-title">租金推算方法：</td>
		              <td class="td-content">
						   <input id="rentorrate" name="rentorrate" class="mini-combobox" textField="name" 
		                  	   valueField="value"  
							   dataField="datas"    
							   allowInput="false" 
							   text="按租金计算年利率"
							   value="rate"
							   data-options="{_params:{pid:'rent_or_rate'}}" 
							   onbeforeshowpopup="onbeforeshowpopup"
						   />
					  </td>
		              <td class="td-content-title">测算租金/利率：</td>
		              <td class="td-content"><input name="rentorratevalue" id =""  class="mini-textbox" value=""></td>
		              <td class="td-content-title">期初/期末：</td>
		              <td class="td-content">
			              <input id="periodtype" name="periodtype" class="mini-combobox" textField="name" 
			                  	   valueField="value"  
								   allowInput="false" 
								   dataField="datas"
								   data-options="{_params:{pid:'period_type'}}" 
								   onbeforeshowpopup="onbeforeshowpopup"
						  />
					  </td>
		          </tr>
		          <tr class="tr-project-info tr-odd">
		              <td class="td-content-title">租金支付类型：</td>
		              <td class="td-content">
			              <input id="incomenumberyear" name="incomenumberyear" class="mini-combobox" textField="name" 
				                  	   valueField="value"  
									   dataField="datas"
									   allowInput="false" 
									   data-options="{_params:{pid:'income_number_year'}}" 
									   onbeforeshowpopup="onbeforeshowpopup"
									   onvaluechanged="incomenumberyearvaluechange"
						   />
					  </td>
		              <td class="td-content-title">还租次数(年)：</td>  
		              <td class="td-content"><input name="incomenumber" id ="incomenumber"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">宽限期：</td>
		              <td class="td-content"><input name="grace" id ="grace"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">租赁期限(月)：</td>
		              <td class="td-content"><input name="leaseterm" id ="leaseterm"  class="mini-textbox" value=""></td>
		          </tr>
		          <tr class="tr-project-info tr-even">
		              <td class="td-content-title">利率计算方式：</td>
		              <td class="td-content">
			              <input id="ratefloattype" name="ratefloattype" class="mini-combobox" textField="name" 
				                  	   valueField="value"  
									   dataField="datas"
									   allowInput="false" 
									   data-options="{_params:{pid:'rate_float_type'}}" 
									   onbeforeshowpopup="onbeforeshowpopup"
									   onvaluechanged="ratefloattypevaluechange"
						  />
					  </td>   
		              <td class="td-content-title">利率调整值：</td>
		              <td class="td-content"><input name="ratefloatamt" id ="ratefloatamt"  class="mini-textbox" value="" required="true"></td>
		              <td class="td-content-title">基准利率：</td>
		              <td class="td-content"><input name="baserate" id ="baserate"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">年利率：</td>
		              <td class="td-content"><input name="yearrate" id ="yearrate"  class="mini-textbox" value=""></td>
		          </tr>
			</table>
		</div>
		
		<div class="mini-panel" title="测算条件" showCollapseButton="true" style="width: 100%;">
		    <table class="fillTable" cellspacing="0" cellpadding="0" id="proj_base_info" >
		          <tr class="tr-project-info tr-even">
		          <td class="td-content-title">付款日：</td>
		              <td class="td-content"><input name="leaseamtdate" id ="leaseamtdate"  class="mini-datepicker" value="" allowInput="false" onvaluechanged="leaseamtdatevaluechange"></td>
		              <td class="td-content-title" >起租日：</td>   
		              <td class="td-content"><input name="startdate" id ="startdate"  class="mini-datepicker" value="" allowInput="false"></td>
		              <td class="td-content-title">第一期租金支付日：</td>
		              <td class="td-content"><input name="firstplandate" id ="firstplandate"  class="mini-datepicker" value="" allowInput="false"></td>
		              <td class="td-content-title">第二期租金支付日：</td>
		              <td class="td-content"><input name="secondplandate" id ="secondplandate"  class="mini-datepicker" value="" allowInput="false"></td>
		          </tr>
			</table>
		</div>
		<div class="mini-panel" title="资金信息" showCollapseButton="true" style="width: 100%;">
		    <table class="fillTable" cellspacing="0" cellpadding="0" id="proj_base_info" >
		          <tr class="tr-project-info tr-even">
		              <td class="td-content-title">手续费：</td>
		              <td class="td-content"><input name="handlingchargemoney" id ="handlingchargemoney"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">手续费比例：</td>
		              <td class="td-content"><input name="handlingchargemoneyratio" id ="handlingchargemoneyratio"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">管理费：</td>
		              <td class="td-content"><input name="managementmoney" id ="managementmoney"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">管理费比例：</td>
		              <td class="td-content"><input name="managementmoneyratio" id ="managementmoneyratio"  class="mini-textbox" value=""></td>
		          </tr>    
		          <tr class="tr-project-info tr-odd">
		          	  
		              <td class="td-content-title">保证金：</td>   
		              <td class="td-content"><input name="cautionmoney" id ="cautionmoney"  class="mini-textbox" value="" onvaluechanged="cautionmoneyremainvaluechange"></td>
		              <td class="td-content-title">保证金比例：</td>
		              <td class="td-content"><input name="cautiondeductionratio" id ="cautiondeductionratio"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">保证金抵扣金额：</td> 
		              <td class="td-content"><input name="cautiondeductionmoney" id ="cautiondeductionmoney"  class="mini-textbox" value="" onvaluechanged="cautionmoneyremainvaluechange"></td>
		              <td class="td-content-title">保证金退还金额：</td>
		              <td class="td-content"><input name="cautionmoneyremain" id ="cautionmoneyremain"  class="mini-textbox" value="" readonly></td>
		          </tr>
		          <tr class="tr-project-info tr-even">
		              
		              <td class="td-content-title">保险计算方式：</td>
		              <td class="td-content">
		              	  <input id="insuremoneytype" name="insuremoneytype" class="mini-combobox" textField="name" 
			                  	   valueField="value"     
								   dataField="datas"
								   allowInput="false" 
								   data-options="{_params:{pid:'insure_type'}}" 
								   onbeforeshowpopup="onbeforeshowpopup"
								   onvaluechanged="insuremoneytypevaluechange"
						  />
		              </td>
		              <td class="td-content-title">保险费：</td>
		              <td class="td-content"><input name="insuremoney" id ="insuremoney"  class="mini-textbox" value=""></td>
		              <td class="td-content-title"> 保险费(承租人)：</td>
		              <td class="td-content"><input name="insurancelessee" id ="insurancelessee"  class="mini-textbox" value="" onvaluechanged="insuremoneyvaluechange"></td>
		              <td class="td-content-title"> 保险费(我司)：</td>
		              <td class="td-content"><input name="insurancelessor" id ="insurancelessor"  class="mini-textbox" value="" onvaluechanged="insuremoneyvaluechange"></td>
		              
		          </tr>
		          <tr class="tr-project-info tr-odd">
		          	  <td class="td-content-title">名义货价：</td>   
		              <td class="td-content"><input name="nominalprice" id ="nominalprice"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">租前息金额：</td>
		              <td class="td-content"><input name="beforeinterest" id ="beforeinterest"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">其他收入：</td>
		              <td class="td-content"><input name="otherincome" id ="otherincome"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">其他支出：</td>
		              <td class="td-content"><input name="otherexpenditure" id ="otherexpenditure"  class="mini-textbox" value=""></td>
		          </tr>
		          <tr class="tr-project-info tr-even">
		          	  <td class="td-content-title">厂商返利：</td>   
		              <td class="td-content"><input name="returnamt" id ="returnamt"  class="mini-textbox" value=""></td>
		          </tr>
			</table>
		</div>
		<div class="mini-panel" title="调息/罚息" showCollapseButton="true" style="width: 100%;">
		    <table class="fillTable" cellspacing="0" cellpadding="0" id="proj_base_info" >
		          <tr class="tr-project-info tr-even">
		              <td class="td-content-title" >调息生效节点：</td>
		              <td class="td-content">
		              	  <input id="adjuststyle" name="adjuststyle" class="mini-combobox" textField="name" 
			                  	   valueField="value"  
								   dataField="datas"  
								   allowInput="false" 
								   data-options="{_params:{pid:'adjust_style'}}" 
								   onbeforeshowpopup="onbeforeshowpopup"
						  />	
		              </td>
		              <td class="td-content-title">罚息利率：</td>
		              <td class="td-content"><input name="penarate" id ="penarate"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">免罚息天数：</td>
		              <td class="td-content"><input name="freedefainterday" id ="freedefainterday"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">&nbsp;</td>
		              <td class="td-content" style="width:160px;"></td>
		          </tr>
			</table>
		</div>
		<div class="mini-panel" title="收益" showCollapseButton="true" style="width: 100%;">
		    <table class="fillTable" cellspacing="0" cellpadding="0" id="proj_base_info" >
		          <tr class="tr-project-info tr-even">
		          	  <td class="td-content-title" >内部收益率：</td>  
		              <td class="td-content"><input name="irr" id ="irr"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">财务收益率：</td>
		              <td class="td-content"><input name="planirr" id ="planirr"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">项目粗利：</td>
		              <td class="td-content"><input name="grossprofit" id ="grossprofit"  class="mini-textbox" value=""></td>
		              <td class="td-content-title">&nbsp;</td>
		              <td class="td-content" style="width:160px;"><a class="mini-button" iconCls="icon-user" plain="true" onclick="save" style="color: red;">租金测算</a></td>
		          </tr>
			</table>
		</div>
	</div>
<script type="text/javascript">
mini.parse();
var form = new mini.Form("businessconditionForm");
/*
	利率计算方式：
		1 选择：固定利率 则利率调整值只读，去掉必填校验
		2 选择非‘固定利率’则利率调整值可输入，并且有必填校验
*/
function ratefloattypevaluechange(e){
	var sender = e.sender;
	if("fixed" == sender.value){
		$mini("ratefloatamt").setAllowInput(false);
		$mini("ratefloatamt").setRequired(false);
	}else{
		$mini("ratefloatamt").setAllowInput(true);
		$mini("ratefloatamt").setRequired(true);
	}
}
/*
  保险计算方式 改为：本司付款、客户自保，不投保
             选择‘本司付款’则‘保险费(我司)’必填
             选择‘客户自保’则‘保险费(承租人)’必填
             选择‘不投保’ 三个值默认0只读
 */
function insuremoneytypevaluechange(e){
	var sender = e.sender;
	if("insure_type1" == sender.value){
		$mini("insurancelessor").setRequired(true);
		$mini("insurancelessee").setRequired(false);
		$mini("insurancelessee").setValue("");
		$mini("insurancelessor").setValue("");
		$mini("insuremoney").setValue("");
	}else if("insure_type3" == sender.value){
		$mini("insurancelessee").setRequired(true);
		$mini("insurancelessor").setRequired(false);
		$mini("insurancelessee").setValue("");
		$mini("insurancelessor").setValue("");
		$mini("insuremoney").setValue("");
	}else if("insure_type5" == sender.value){
		$mini("insurancelessor").setRequired(false);
		$mini("insurancelessee").setRequired(false);
		$mini("insurancelessee").setValue("0");
		$mini("insurancelessor").setValue("0");
		$mini("insuremoney").setValue("0");
	}
}
/*
 	租金支付类型 
	 	1 月付情况下‘租赁期限(月)’ = 1 * ‘还租次数(年)’
	  	2 季付情况下‘租赁期限(月)’ = 3 * ‘还租次数(年)’
	  	3 半年付情况下‘租赁期限(月)’ = 6 * ‘还租次数(年)’
	  	4 年付情况下‘租赁期限(月)’ = 12 * ‘还租次数(年)’
	  	5 双月付情况下‘租赁期限(月)’ = 2 * ‘还租次数(年)’
 */
function incomenumberyearvaluechange(e){
	var sender = e.sender;
	//  income_1	income_1	income_number_year	月  付
	// 	income_3	income_3	income_number_year	季  付
	// 	income_6	income_6	income_number_year	半年付
	// 	income_12	income_12	income_number_year	年  付
	// 	income_2	income_2	income_number_year	双月付
	if("income_1" == sender.value){
		$mini("leaseterm").setValue(1 * $minigetvalue(incomenumber));
	}else if("income_3" == sender.value){
		$mini("leaseterm").setValue(3 * $minigetvalue(incomenumber));
	}else if("income_6" == sender.value){
		$mini("leaseterm").setValue(6 * $minigetvalue(incomenumber));
	}else if("income_12" == sender.value){
		$mini("leaseterm").setValue(12 * $minigetvalue(incomenumber));
	}else if("income_2" == sender.value){
		$mini("leaseterm").setValue(2 * $minigetvalue(incomenumber));
	}
}
/*
 *	付款日：
 	付款日放在起租日前面
 	付款日选择后触发事件计算：起租日，第一期租金支付日，第二期租金支付日 三个值
 	计算逻辑：第一期租金支付日不能小于起租日期，第二期租金支付日不能小于第一期租金支付日!
	1.起租日，第一期租金支付日，第二期租金支付日 三个值都不存在值则被重新计算
	2.三个值都为空情况下：
		起租日 = 付款日
		第一期租金支付日：if '期初/期末' = q期初，则=起租日，else = 起租日 + 租金支付类型（同上方3的数字:1/3/6/12/2）月份
		第二期租金支付日：= 第一期租金支付日 +  + 租金支付类型（同上方3的数字:1/3/6/12/2）的数字:1/3/6/12)月份 
 */
function leaseamtdatevaluechange(e){
	var sender = e.sender;
	//  income_1	income_1	income_number_year	月  付
	// 	income_3	income_3	income_number_year	季  付
	// 	income_6	income_6	income_number_year	半年付
	// 	income_12	income_12	income_number_year	年  付
	// 	income_2	income_2	income_number_year	双月付
	var startdate = $minigetvalue("startdate");//起租日
	var firstplandate = $minigetvalue("firstplandate");//第一期租金支付日
	var secondplandate = $minigetvalue("secondplandate");//第二期租金支付日
	var periodtype = $minigetvalue("periodtype");//期初/期末
	var incomenumberyear = $minigetvalue("incomenumberyear");//租金支付类型
	if("" == secondplandate && "" == firstplandate && "" == secondplandate){
		$mini("startdate").setValue(sender.value);
	}
	if("period_type_1" == periodtype){
		$mini("firstplandate").setValue(sender.value);
	}else{
		
		if("income_1" == incomenumberyear){
			
		}else if("income_3" == incomenumberyear){
			
		}else if("income_6" == incomenumberyear){
			
		}else if("income_12" == incomenumberyear){
			
		}else if("income_2" == incomenumberyear){
			
		}
	}
}
function save(e){
	var o = form.getData(true,true); 
    if (miniui_ext.fromvalidation('businessconditionForm') == false) return;
    var url="<%=request.getContextPath() %>/leasing/rentCalculate.action";
    var json = mini.encode(o);
	$.ajax({
        url: url,
        type: "post",
        data:  o ,
        success: function (text) {
        	CloseWindow("savesuccess");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
        }
    });
}

function onbeforeshowpopup(e) {	
	miniui_ext.onbeforeshowpopup(e);
}
//计算手续费比例
function changehandlingchargemoneyratio(e){
	var equipamt = getNumber("equipamt");//设备款
	var handlingchargemoney = getNumber("handlingchargemoney");//手续费
	var handlingchargemoneyratio = mini.get("handlingchargemoneyratio");//手续费比例
	if("" == equipamt || "" == handlingchargemoney) return;
	var handlingchargemoneyratiovalue = decimal(handlingchargemoney/equipamt*100, 6);
	handlingchargemoneyratio.setValue(handlingchargemoneyratiovalue);
}
//计算管理费比例
function changemanagementmoneyratio(e){
	var equipamt = getNumber("equipamt");//设备款
	var managementmoney = getNumber("managementmoney");//管理费
	var managementmoneyratio = mini.get("managementmoneyratio");//管理费比例
	if("" == equipamt || "" == managementmoney) return;
	var managementmoneyratiovalue = decimal(managementmoney/equipamt*100, 6);
	managementmoneyratio.setValue(managementmoneyratiovalue);
}
//计算保证金比例
function changecautiondeductionratio(e){
	var equipamt = getNumber("equipamt");//设备款
	var cautionmoney = getNumber("cautionmoney");//保证金
	var cautiondeductionratio = mini.get("cautiondeductionratio");//保证金比例
	if("" == equipamt || "" == cautionmoney) return;
	var cautiondeductionratiovalue = decimal(cautionmoney/equipamt*100, 6);
	cautiondeductionratio.setValue(cautiondeductionratiovalue);
}
//计算首付比例
function changefirstpaymentratio(e){
	var equipamt = getNumber("equipamt");//设备款
	var firstpayment = getNumber("firstpayment");//首付款
	var firstpaymentratio = mini.get("firstpaymentratio");//首付比例
	if("" == equipamt || "" == firstpayment) return;
	var firstpaymentratiovalue = decimal(firstpayment/equipamt*100, 6);
	firstpaymentratio.setValue(firstpaymentratiovalue);
}
//计算保证金退还金额
function cautionmoneyremainvaluechange(e){
	var cautionmoney = getNumber("cautionmoney");//保证金
	var cautiondeductionmoney = getNumber("cautiondeductionmoney");//保证金抵扣金额
	var cautionmoneyremain = mini.get("cautionmoneyremain");//保证金退还金额
	if("" == cautionmoney || "" == cautiondeductionmoney) return;
	var cautionmoneyremainvalue = cautionmoney - cautiondeductionmoney;
	cautionmoneyremain.setValue(cautionmoneyremainvalue);
}
//计算保险费
function insuremoneyvaluechange(e){
	var insurancelessee = getNumber("insurancelessee");//保证金
	var insurancelessor = getNumber("insurancelessor");//保证金抵扣金额
	var insuremoney = mini.get("insuremoney");//保证金退还金额
	if("" == insurancelessee || "" == insurancelessor) return;
	var insuremoneyvalue = insurancelessee + insurancelessor;
	insuremoney.setValue(insuremoneyvalue);
}
//获取对象的数值
function getNumber(id){
    var value = mini.get(id).getValue();
    try {
    	value = (value+'').replace(/,/g,'');
    	value = value == '' ? '0' : value;
    	value = parseFloat(value);
    } catch(e) {
    	value = 0;
    }
    return value;
}
function decimalReal(num,v)
{
   var dight  =(num*Math.pow(10,v)/Math.pow(10,v)).toFixed(v);  
   return parseFloat(dight);
} 
//四舍五入
function decimal(num,v)
{	//num表示要四舍五入的数,v表示要保留的小数位数。
	if(0 == v)
	{
		return decimalReal(decimalReal(num,2),0);
	}
    return decimalReal(num,v);		
}
function $minigetvalue(id){
	return mini.get(id).getValue();
}
function $mini(id){
	return mini.get(id);
}
//var temp='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }';
// var temp = parent.document.getElementById("id_json_business_condition_str").value;  
<%-- var isViewHistoryTask="<%= request.getParameter("isViewHistoryTask")%>"; --%>
//form.setData(mini.decode(temp));
//调用返回到主页面
function returnTab(){
	abc(form.el.id);
	return form;
}
function abc(formid){
	var form = new mini.Form(formid);
	var o = form.getData(); 
	var fields = form.getFields();
	for(var index =0;index<fields.length;index++){
		 //判断是否是下拉框控件，是则同时把text属性传入后台
		if(fields[index].uiCls == "mini-combobox"){
			 o["raw_"+fields[index].id]=fields[index].text;
		}
	}
}
//控制只读页面
// if (isViewHistoryTask == "true") {
// 	miniui_ext.initformenabled("businessconditionForm");
// }
</script>

