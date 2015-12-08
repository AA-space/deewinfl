<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<style type="text/css">
.tabs-panels {
	border: 0px solid #ddd;
}
</style>
<input name="fund_ebank_process" id="id_fund_ebank_process" type="hidden" value="${requestScope['fund_ebank_process'] }"/>

 <table cellspacing="0" cellpadding="0" style="width: 98%; margin-top: 20px;" id="fund_ebank_data" >
        <tr class="tr-project-condition tr-even">
			<td class="td-content-title">网银编号：</td>
			<td class="td-content"><input name="fund_ebank_data.ebdataid" id="ebdataid" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.ebdataid']}"></td>
			<td class="td-content-title">付款人：</td>
			<td class="td-content"><input name="fund_ebank_data.clientname" class="td-content-input td-content-readonly" type="text" value="${requestScope['fund_ebank_data.clientname']}" /></td>
		    <td class="td-content-title">流水号：</td>
			<td class="td-content"><input name="fund_ebank_data.sn" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.sn']}"></td>
		</tr>
		<tr class="tr-project-condition tr-odd">
			<td class="td-content-title">本方银行：</td>
			<td class="td-content"><input name="fund_ebank_data.ownbank" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.ownbank']}"></td>
			<td class="td-content-title">本方账户：</td>
			<td class="td-content"><input name="fund_ebank_data.ownaccount" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.ownaccount']}"></td>
			<td class="td-content-title">本方账号：</td>
			<td class="td-content"><input name="fund_ebank_data.ownaccnumber" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.ownaccnumber']}"></td>
		</tr>

		<tr class="tr-project-condition tr-even">
			<td class="td-content-title">对方银行：</td>
			<td class="td-content"><input name="fund_ebank_data.clientbank" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.clientbank']}"></td>
			<td class="td-content-title">对方账户：</td>
			<td class="td-content"><input name="fund_ebank_data.clientaccount" class="td-content-input td-content-readonly" type="text" value="${requestScope['fund_ebank_data.clientaccount']}" /></td>
			<td class="td-content-title">对方账号：</td>
			<td class="td-content"><input name="fund_ebank_data.clientaccnumber" class="td-content-input td-content-readonly" type="text" value="${requestScope['fund_ebank_data.clientaccnumber']}" /></td>
		</tr>

		<tr class="tr-project-condition tr-odd">
			<td class="td-content-title">到账金额：</td>
			<td class="td-content"><input name="fund_ebank_data.factmoney" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.factmoney']}"></td>
			<td class="td-content-title">已核销金额：</td>
			<td class="td-content" ><input name="fund_ebank_data.hadmoney" class="td-content-input td-content-readonly" type="text" value="${requestScope['fund_ebank_data.hadmoney']}" /></td>
			<td class="td-content-title">可核销金额：</td>
			<td class="td-content" ><input name="fund_ebank_data.mayopemoney" class="td-content-input td-content-readonly" type="text" value="${requestScope['fund_ebank_data.mayopemoney']}" /></td>	
		</tr>
		<tr class="tr-project-condition tr-even">
		    <td class="td-content-title">无关金额：</td>
			<td class="td-content"><input name="fund_ebank_data.nowithmoney" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.nowithmoney']}"></td>
		    <td class="td-content-title">到账金额类型：</td>
			<td class="td-content"><input name="fund_ebank_data.moneytype" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.moneytype']}"></td>
			<td class="td-content-title">到账时间：</td>
			<td class="td-content"><input name="fund_ebank_data.factdate" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.factdate']}"></td>
		 </tr>
		<tr class="tr-project-condition tr-odd">
		    <td class="td-content-title">备注：</td>
			<td class="td-content" colspan="5">
			<textarea rows="5"    label="备注"'
			style="width:98.9%;float:left;" name="fund_ebank_data.summary" >${requestScope['fund_ebank_data.summary'] }</textarea>
		</tr>
		<tr id="btn_rent_cal_tr" class="tr-project-condition tr-even" style="display: none">
			<td class="td-content-title" colspan=5></td>
			<td><input style="margin-top: 2px; margin-bottom: 2px;" id="btn_rent_cal" class="btn btn-primary" type="button" value="自动核销" onclick="openHireBox(this);" /></td>
		</tr>
 </table>
</div>


<div id="autoVerification_box" closed="true" modal="true" title="自动核销" style="display: none; width: 800px; padding-top: 20px;">
<center>
	<table cellspacing="0" cellpadding="0" style="width: 98%; margin-top: 5px;">
		<tr class="tr-project-condition tr-even">
			<td class="td-content-title">可核销金额：</td>
			<td class="td-content"><span id="can_hire_money"></span></td>
		</tr>
		<tr class="tr-project-condition tr-odd">
			<td class="td-content-title">本次自动核销金额：</td>
			<td class="td-content"><input id="real_hire_money" class="td-content-input" type="text"/></td>
		</tr>

		<tr class="content-separator">
			<td colspan="2"><a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='autoVerification();'>
					<span>确定</span>
				</a>
				<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#autoVerification_box").window("close");'>
					<span>取消</span>
				</a>
		</tr>
	</table>
	</center>
</div>


<script type="text/javascript">

	$(function() {
		var isFirstTask = '${isFirstTask }';
		if(isFirstTask =='true'){
			$('#btn_rent_cal_tr').show();
		}
		
	});

	function calculatePlanRent(allMoney, corpus, interest, penalty,otype) {
		
       //otype:1核销金本，2核销利息 3，核销罚息
        if(otype==1){interest=0;penalty=0;}
        if(otype==2){corpus=0;penalty=0;}
        if(otype==3){corpus=0;interest=0;}
		var rentlist = {};
		//核销罚息
		if (allMoney > 0) {
			if (allMoney - penalty >= 0) {
				allMoney = parseFloat(allMoney) - parseFloat(penalty);
			} else {
				penalty = allMoney;
				allMoney = 0;
			}
		} else {
			penalty = 0;
		}
		//核销租息
		if (allMoney > 0) {
			if (allMoney - interest >= 0) {
				allMoney = parseFloat(allMoney) - parseFloat(interest);
			} else {
				interest = allMoney;
				allMoney = 0;
			}
		} else {
			interest = 0;
		}
		//核销本金
		if (allMoney > 0) {
			if (allMoney - corpus >= 0) {
				allMoney = parseFloat(allMoney) - parseFloat(corpus);
			} else {
				corpus = allMoney;
				allMoney = 0;
			}
		} else {
			corpus = 0;
		}
		allMoney=allMoney.toFixed(2);
		var rent = parseFloat(penalty) + parseFloat(interest) + parseFloat(corpus);
		rentlist.rent = rent;
		rentlist.corpus = corpus
		rentlist.interest = interest;
		rentlist.penalty = penalty;
		rentlist.lastMoney = allMoney;
		//alert(JsonUtil.encode(rentlist));
		return rentlist;
	}

	function openHireBox(obj) {
		$('#can_hire_money').html($('input[name="fund_ebank_data.mayopemoney"]').val());
		$('#real_hire_money').val($('input[name="fund_ebank_data.mayopemoney"]').val());

		var box = $('#autoVerification_box');
		$('#real_hire_money').removeAttr('readonly').removeClass('element-readonly').focus();

		box.show();
		box.window({
			top : 20
		});
		box.window("open");
	}

	function autoVerification() {//自动核销
		var real_hire_money = $('#real_hire_money').val();
		var can_hire_money = $('input[name="fund_ebank_data.mayopemoney"]').val();
		//验证输入数据
		if (!real_hire_money || real_hire_money == 0) {
			alert('请输入核销金额');
			return;
		} else {
			var patrn = /^([1-9][\d]*|0)(\.[\d]{1,2})?$/;
			;

			if (patrn.exec(real_hire_money)) {
				if (parseFloat(real_hire_money) > parseFloat(can_hire_money)) {
					alert("当前核销金额不能大于最大核销金额");
					return;
				}
			} else {
				alert('请输入正确的金额');
				return;
			}
		}

		jQuery("#autoVerification_box").window("close");

		loadMask_oper.show();
		var isPenalty = true;
		var rent = 0.00;
		var corpus = 0.00;
		var interest = 0.00;
		var penalty = 0.00;
		var ebankdatas = jQuery("#fund_ebank_data input[type='text'],#fund_ebank_data textarea");
		var ebank = [];
		var i = 0;
		for (i = 0; i < ebankdatas.length; i++) {
			ebank[ebankdatas[i].name] = ebankdatas[i].value;
		}
		var curIncome = getTracywindyObject('table_id_current_fund_income_detial_container');//回收表
		var curtabledate = curIncome.getRowsData();
		var palntable = getTracywindyObject('table_id_fund_income_plans_container');//计划表
		var curplantable = palntable.getRowsData();

		var iddata = getTableColumnData(curtabledate, "id");//已经加到实收中的计划
		//var allMoney = ebank["fund_ebank_data.mayopemoney"];
		var allMoney = real_hire_money;
		var ebankid = ebank["fund_ebank_data.ebdataid"];
		/*
		if(curtabledate.length>0){
		for(i=0;i<curtabledate.length;i++){
		       rent=parseFloat(curtabledate[i].rent);
		       corpus=parseFloat(curtabledate[i].corpus);
		       interest=parseFloat(curtabledate[i].interest);
		       penalty=parseFloat(curtabledate[i].penalty);
		   var interestadjust=parseFloat(curtabledate[i].interestadjust);
		   var penaltyadjust=parseFloat(curtabledate[i].penaltyadjust);
		   var cebankid=curtabledate[i].ebanknumber;

		   if(rent<0||corpus<0||interest<0||penalty<0){
		       if(ebankid==cebankid){
		     	  allMoney=parseFloat(allMoney)+parseFloat(rent)+parseFloat(penalty);
		     	  allMoney=allMoney.toFixed(2);
		       }
		   }else{
		 	  var calculateresult=calculatePlanRent(allMoney,corpus,interest,penalty);
		 	  allMoney=calculateresult.lastMoney;
		 	  curtabledate[i].rent=calculateresult.rent+parseFloat(penaltyadjust)+parseFloat(interestadjust);
		 	  curtabledate[i].rent=curtabledate[i].rent.toFixed(2);
		       curtabledate[i].corpus=calculateresult.corpus.toFixed(2);
		       curtabledate[i].interest=calculateresult.interest.toFixed(2);
		       curtabledate[i].penalty=calculateresult.penalty.toFixed(2);
		   }        
		 }
		}
		 */
		curIncome.tableData.length = 0;
		// curIncome.AddRows(curtabledate);
		//自动核销
		var funddate=[];
		var curdate = getCurrentDate();
		var index=1;
		var nowdate=getCurDate(new Date());
		nowdate=nowdate.replace(/-/g,"");
		if (curplantable.length > 0) {
			while (allMoney > 0&& index<3) {
			 for (i = 0; i < curplantable.length; i++) {
				    var plandate=curplantable[i].plandate;
				    plandate=plandate.replace(/-/g,"");
				    if(parseFloat(allMoney)>0 &&parseFloat(plandate)<=parseFloat(nowdate)){
					if (parseFloat(curplantable[i].currentoverage) > 0
							|| parseFloat(curplantable[i].penaltyoverage) > 0) {
						var fund = {};
                        if(!checkIdIsAdd(curplantable[i].id,iddata)){
						corpus = parseFloat(curplantable[i].curcorpusoverage);
						interest = parseFloat(curplantable[i].curinterestoverage);
						penalty = parseFloat(curplantable[i].penaltyoverage);
						var calculateresult = calculatePlanRent(allMoney, corpus, interest, penalty,index);
						allMoney = calculateresult.lastMoney;
						if(index==1){
						fund.id = curplantable[i].id;
						fund.planid = curplantable[i].id;
						fund.planlist = curplantable[i].rentlist;
						fund.ebanknumber = ebank["fund_ebank_data.ebdataid"];
						//fund.balancemode = "电汇";
						fund.balancemode="PayFund6";
			            fund.rawValue_balancemode="电汇";
						fund.hirelist = parseFloat(curplantable[i].hirelist) + 1;
						fund.hiredate = ebank["fund_ebank_data.factdate"];
						fund.rent = parseFloat(calculateresult.rent);
						fund.corpus = parseFloat(calculateresult.corpus).toFixed(2);
						fund.interest = parseFloat(calculateresult.interest).toFixed(2);
						fund.penalty = parseFloat(calculateresult.penalty);
						fund.interestadjust = 0.00;
						fund.penaltyadjust = 0.00;
						fund.accountingdate = curdate;
						fund.ownbank = ebank["fund_ebank_data.ownbank"];
						fund.ownaccount = ebank["fund_ebank_data.ownaccount"];
						fund.accnumber = ebank["fund_ebank_data.ownaccnumber"];
						fund.hireobject = ebank["fund_ebank_data.clientname"];
						fund.hirebank = ebank["fund_ebank_data.clientbank"];
						fund.clientaccount = ebank["fund_ebank_data.clientaccount"];
						fund.hirenumber = ebank["fund_ebank_data.clientaccnumber"];
						fund.receivermoney = parseFloat(parseFloat(fund.rent)+parseFloat(fund.penalty)).toFixed(2);
						fund.invoiceno = "";
						funddate.push(fund);
						//   }
					   }else{
						   
                        for(var j=0;j<funddate.length;j++){
                          if(funddate[j].planlist==curplantable[i].rentlist){
                        	  funddate[j].rent = parseFloat(funddate[j].rent)+parseFloat(calculateresult.rent);
                        	  funddate[j].corpus =parseFloat(funddate[j].corpus)+parseFloat( calculateresult.corpus);
                        	  funddate[j].interest =parseFloat( funddate[j].interest)+parseFloat(calculateresult.interest);
                        	  funddate[j].penalty =parseFloat( funddate[j].penalty)+ parseFloat(calculateresult.penalty);
                        	  funddate[j].receivermoney=parseFloat(parseFloat(funddate[j].rent)+parseFloat(funddate[j].penalty)).toFixed(2);
                        	  funddate[j].rent=funddate[j].rent.toFixed(2);
                        	  funddate[j].corpus= funddate[j].corpus.toFixed(2);
                        	  funddate[j].interest=funddate[j].interest.toFixed(2);
                        	  funddate[j].penalty= funddate[j].penalty.toFixed(2);
                          }
                         }
					  
				  }}
				}}
			}
			index=index+1;
			}
			curIncome.AddRows(funddate);
		}
		loadMask_oper.hide();
		jQuery.messager.alert("正确提示", "<div style='font-size:18px;line-height:30px;'>操作成功<div>", "success");
	}
</script>