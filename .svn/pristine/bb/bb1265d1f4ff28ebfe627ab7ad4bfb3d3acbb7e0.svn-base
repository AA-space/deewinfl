<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
function getCurrentDate(){
    var cdate=new Date();
    var month=(parseFloat(cdate.getMonth())+1);
    var day=cdate.getDate();
    if(parseFloat(day)<10){day="0"+day;}
    if(parseFloat(month)<10){month="0"+month;}
    return cdate.getFullYear()+"-"+month+"-"+day;
}
function checkIdIsAdd(id,ids){
    if(ids.length>0){
    for(var i=0;i<ids.length;i++){
     if(id==ids[i]){return true;}
    }
    return false;
    }else{return false;}
}
function getTableColumnData(tabledatas,column){
    var cdata=[];
    if(tabledatas.length>0){
        for(var i=0;i<tabledatas.length;i++){
            var ctable=tabledatas[i];
            cdata[i]=ctable[column];
        }
    }
    return cdata;
}
var loadMask_oper = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');

	function setFundFundChargePlan(table) {
		loadMask_oper.show();
		var plandata = table.getCheckedRowDatas();
		var rowDatas = table.getRowsData();

		var plandata_rent_list = {};
		for ( var int = 0; int < rowDatas.length; int++) {
			if (!plandata_rent_list[rowDatas[int]['contract_id']]) {
				plandata_rent_list[rowDatas[int]['contract_id']] = [];
			}
			plandata_rent_list[rowDatas[int]['contract_id']].push(rowDatas[int]['rent_list']);
		}

		var ebankdatas = jQuery("#fund_ebank_data input[type='text'],#fund_ebank_data textarea");
		var ebank = [];
		var i = 0;
		for (i = 0; i < ebankdatas.length; i++) {
			ebank[ebankdatas[i].name] = ebankdatas[i].value;
		}
		var allItems = document.getElementsByName(table.checkName);
		for ( var i = 0; i < allItems.length; i++) {
			if (allItems[i].checked) {
				allItems[i].checked = false;
			}
		}
		var currentTable1 = getTracywindyObject('table_id_table_leasing_delivery_plan');
		var talbedata = currentTable1.getRowsData();
		var iddata = getTableColumnData(talbedata, "id");
		var isAddPlanData = "";
		var curdate = getCurrentDate();
		for (i = 0; i < plandata.length; i++) {
			// plandata_rent_list[plandata[i]['contract_id']][0];
			// console.info( plandata_rent_list[plandata[i]['contract_id']]);

			if (plandata[i].rent_list != plandata_rent_list[plandata[i]['contract_id']][0]) {
				loadMask_oper.hide();
				//jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>因租金必须按顺序回笼, 第"+plandata[i].rentlist+"期以下租金未被选择</div>",'error'); 
				alert("因租金必须按顺序回笼,合同【" + plandata[i].contract_number + "】中, 第【" + plandata[i].rent_list + "】期及以下租金未被选择");
				return false;
			}
			if (plandata[i].incomecard == "3") {
				loadMask_oper.hide();
				alert("所勾选的租金计划记录正在卡扣,不允许操作!");
				return false;
			}
			plandata_rent_list[plandata[i]['contract_id']].shift();
			
		

			if (parseFloat(plandata[i].ov_rent) > 0 || parseFloat(plandata[i].vo_penalty) > 0) {
				var fund = {};

				if (checkIdIsAdd(plandata[i].id, iddata)) {
					if (isAddPlanData == "") {
						isAddPlanData = '【' + plandata[i].contract_number + '】号合同第【' + plandata[i].rent_list + '】期';
					} else {
						isAddPlanData = isAddPlanData + "," + '【' + plandata[i].contract_number + '】号合同第【' + plandata[i].rent_list + '】期';
					}
				} else {
					fund.id = plandata[i].id;
					fund.planid = plandata[i].id;
					fund.planlist = plandata[i].rent_list;
					fund.dealer_id = plandata[i].dealer_id;
					fund.dealer_cust_name = plandata[i].dealer_cust_name;
					fund.cust_id = plandata[i].cust_id;
					fund.cust_name = plandata[i].cust_name;
					fund.plan_date = plandata[i].plan_date;
					fund.contract_id = plandata[i].contract_id;
					fund.contract_number = plandata[i].contract_number;
					fund.ebanknumber = ebank["fund_ebank_data.ebdataid"];
					fund.balancemode = "PayFund6";
					fund.rawValue_balancemode = "电汇";
					fund.hirelist = parseFloat(plandata[i].hirelist || 0) + 1;
					fund.hiredate = ebank["fund_ebank_data.factdate"];
					fund.ov_rent = plandata[i].ov_rent;
					fund.ov_corpus = plandata[i].ov_corpus;
					fund.ov_interest = plandata[i].ov_interest;
					fund.rent = plandata[i].ov_rent;
					fund.corpus = plandata[i].ov_corpus;
					fund.interest = plandata[i].ov_interest;
					fund.penalty = plandata[i].vo_penalty;
					fund.interestadjust = 0.00;
					fund.penaltyadjust = 0.00;
					temp = parseFloat(plandata[i].ov_rent) + parseFloat(plandata[i].vo_penalty);
					fund.receivermoney = temp.toFixed(2);
					fund.accountingdate = curdate;
					fund.oper = "add";
					fund.ownbank = ebank["fund_ebank_data.ownbank"];
					fund.ownaccount = ebank["fund_ebank_data.ownaccount"];
					fund.accnumber = ebank["fund_ebank_data.ownaccnumber"];
					fund.hireobject = ebank["fund_ebank_data.clientname"];
					fund.hirebank = ebank["fund_ebank_data.clientbank"];
					fund.clientaccount = ebank["fund_ebank_data.clientaccount"];
					fund.hirenumber = ebank["fund_ebank_data.clientaccnumber"];
					fund.invoiceno = "";
					currentTable1.AddRow(fund);
				}
			} else {
				loadMask_oper.hide();
				alert("合同【" + plandata[i].contract_number + "】, 第【" + plandata[i].rent_list + "】期已经回笼");
				return false;
			}

		}
		loadMask_oper.hide();
		if (isAddPlanData == "") {
			alert("操作成功");
			jQuery("#id_fund_plan_detial").window("close");
		} else {
			alert("操作成功其中" + isAddPlanData + "已经加到实收计划中不能重复添加");
		}
	}

	jQuery(function() {
		var currentIsNeedTools = true;
		if (('true' != '${isFirstTask}') || ('true' == '${isViewHistoryTask}')) {
			currentIsNeedTools = false;
		}
		new tracywindyMultiTable({
			renderTo : 'id_fund_plan_detial',
			width : formWidth,
			height : 350,
			isNeedTools : currentIsNeedTools,
			xmlFileName : '/eleasing/workflow/public/fundRentPlanSelect.xml',
			loadMode : 'ajax',
			//此处不能用分页，如果分页按顺序核销有可能失效 add by jason 2013-12-5
			//isPage:true,
			isAutoBreakContent : true,
			isColumnResizable : false,
			isRemoteSortable : false,
			tools : ' ',
			params : {
				//pay_type : 'pay_type_in',
				contract_id : ' ',
				hasmoney : "1",
				calcdate:"${requestScope['fund_ebank_data.factdate']}"
			},
			otherTools : [ {
				html : '<font color="red">生成本次租金回笼明细</font>',
				handler : function(table) {
					var fundPlan = table.getCheckedRowDatas();
					if (0 == fundPlan.length) {
						alert("请选择需要租金!");
						return false;
					}
					setFundFundChargePlan(table);
				},
				iconCls : 'icon-update'
			} ],
			//datas:JsonUtil.decode('${empty json_proj_guarantee_equip_str ? "[]" : json_proj_guarantee_equip_str }'),
			columns : [ {
				name : 'id',
				header : 'id',
				hidden : true
			}, {
				name : 'contract_id',
				header : 'contract_id',
				hidden : true
			}, {
				name : 'dealer_id',
				header : 'dealer_id',
				hidden : true
			}, {
				name : 'dealer_cust_name',
				header : '经销商名称'
			}, {
				name : 'cust_id',
				header : 'cust_id',
				hidden : true
			}, {
				name : 'cust_name',
				header : '客户名称',
				width : 130
			}, {
				name : 'contract_number',
				header : '合同号',
				nullable : false,
				width : 180
			}, {
				name : 'rent_list',
				header : '期次',
				nullable : false
			},
			//{name:'hire_list',  header:'期次',nullable:false },
			{
				name : 'rent_status',
				header : '回笼状态',
				nullable : false
			}, {
				name : 'plan_date',
				header : '计划日期',
				nullable : false
			}, {
				name : 'rent',
				header : '计划租金',
				nullable : false
			}, {
				name : 'corpus',
				header : '计划本金',
				nullable : false
			}, {
				name : 'interest',
				header : '计划租息',
				nullable : false
			}, {
				name : 'penalty',
				header : '应收罚息',
				nullable : false
			}, {
				name : 'ov_rent',
				header : '租金余额',
				nullable : false
			}, {
				name : 'ov_corpus',
				header : '本金余额',
				nullable : true
			}, {
				name : 'ov_interest',
				header : '利息余额',
				nullable : false,
				type : 'double'
			}, {
				name : 'vo_penalty',
				header : '罚息余额',
				nullable : false,
				type : 'double'
			} 
			, {
				name : 'is_card',
				header : '是否卡扣'
			} , {
				name : 'incomecard',
				header : '是否正在卡扣',
				hidden : true
			}]
		});

	});
</script>