<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_fund_payment_now_container',
	    width:(parseInt("${param.tableWidth}")||pageWidth) - 300,
        height:(parseInt("${param.tableHeight}")||pageHeight)-140,
	    xmlFileName:'/eleasing/workflow/public/fundfundPlanSelect.xml',
	    loadMode:'ajax',
	    params:{
	    	pay_type : 'pay_type_in',
	    	contract_id : ' ',
	    	hasmoney : "1"
	    },
	    isFit:true,
	    isNeedTools:currentIsNeedTools,
	    tools:' ',
	    otherTools : [ {
			html : '<font color="red">生成本次实收资金明细</font>',
			handler : function(table) {
				var fundPlan = table.getCheckedRowDatas();
				if (0 == fundPlan.length) {
					alert("请选择需要资金!");
					return false;
				}
				setFundFundChargePlan(table);
				setFundLimit();
			},
			iconCls : 'icon-update'
		} ],
	   // datas:JsonUtil.decode('${empty json_proj_guarantee_equip_str ? "[]" : json_proj_guarantee_equip_str }'),
	    columns:[
			       {name:'id',  header:'id',hidden:true},
			       {name:'contract_id',  header:'contract_id',hidden:true },
			       {name:'contract_number',  header:'合同号',nullable:false },
			       {name:'payment_id',  header:'付款编号',nullable:false },
			       {name:'fee_type',  header:'fee_type',hidden:true },
			       {name:'rawvaluefee_type',  header:'费用类型',nullable:false },
			       {name:'pay_type',  header:'pay_type',hidden:true },
			       {name:'status',  header:'回收状态',nullable:false },
			       {name:'plan_date',  header:'回收日期',nullable:false },
			       {name:'plan_money',  header:'应收金额',nullable:false },
			       {name:'fact_money',  header:'已收金额',nullable:false },
			       {name:'ow_fact_money',  header:'未收金额',nullable:false }
	       	     ]
	 });
	 
});

function getCurrentDate(){
    var cdate=new Date();
    return cdate.getFullYear()+"-"+(parseFloat(cdate.getMonth())+1)+"-"+cdate.getDate();
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
function setFundLimit(){
	 //添加到额度管理
   	var currentTable1 = getTracywindyObject('table_id_table_limit_container');
   	//currentTable1.tableData=[];
   	var limit={};
   	limit.dealername=getTracywindyObject('id_combo_dealer').getRawValue();
   	limit.custname=getTracywindyObject('id_custname').getRawValue();
   	limit.contractname=getTracywindyObject('id_combo_contract').getRawValue();
   	limit.contractid=getTracywindyObject('id_combo_contract').getValue();
   	if(JsonUtil.encode(currentTable1.getRowsJsonData()).indexOf(limit.contractid)==-1){
   		currentTable1.AddRow(limit);
   	}
}
function setFundFundChargePlan(table){
	loadMask_oper.show();
	var plandata = table.getCheckedRowDatas();
    var ebankdatas=jQuery("#fund_ebank_data input[type='text'],#fund_ebank_data textarea");
    var ebank=[];
    var i=0;
    for(i=0;i<ebankdatas.length;i++){
       ebank[ebankdatas[i].name]=ebankdatas[i].value;
    }
    var allItems = document.getElementsByName(table.checkName);
    for(var i= 0;i<allItems.length;i++)
    {
       if(allItems[i].checked)
        {
    	   allItems[i].checked=false;
       }
    } 
    var currentTable1 = getTracywindyObject('table_id_table_leasing_delivery_plan');
    var talbedata=currentTable1.getRowsData();
    var iddata=getTableColumnData(talbedata,"id");
    var isAddPlanData="";
    var curdate=getCurrentDate();
    for(i=0;i<plandata.length;i++){
      if(parseFloat(plandata[i].plan_money)>parseFloat(plandata[i].fact_money)){
           var fund={};
           if(checkIdIsAdd(plandata[i].id,iddata)){
               if(isAddPlanData==""){isAddPlanData=plandata[i].payment_id;}else{isAddPlanData=isAddPlanData+","+plandata[i].payment_id;}
           }else{
           fund.id=plandata[i].id;
           fund.paymentid=plandata[i].payment_id;
           fund.status = plandata[i].status;
           fund.fact_money = plandata[i].fact_money;
           fund.ow_fact_money = plandata[i].ow_fact_money;
           fund.contract_number = plandata[i].contract_number;
           fund.plan_money = plandata[i].plan_money;
           fund.contract_id = plandata[i].contract_id;
           
           
           fund.ebanknumber=ebank["fund_ebank_data.ebdataid"];
           fund.feetype=plandata[i].fee_type;
           fund.rawvaluefee_type=plandata[i].rawvaluefee_type;
           fund.settlemethod="PayFund6";
           fund.rawValue_settlemethod="电汇";
           fund.factdate=ebank["fund_ebank_data.factdate"];
           var temp=parseFloat(plandata[i].ow_fact_money);
           fund.factmoney=temp.toFixed(2);
           fund.receivermoney=temp.toFixed(2);
           fund.feeadjust=0.00;
           fund.oper="add";
           fund.accountbank=ebank["fund_ebank_data.ownbank"];
           fund.account=ebank["fund_ebank_data.ownaccount"];
           fund.accnumber=ebank["fund_ebank_data.ownaccnumber"];
           fund.factobject=ebank["fund_ebank_data.clientname"];
           fund.clientbank=ebank["fund_ebank_data.clientbank"];
           fund.clientaccount=ebank["fund_ebank_data.clientaccount"];
           fund.clientaccnumber=ebank["fund_ebank_data.clientaccnumber"];
           fund.accountingdate=curdate;
           fund.fundfundchargeplan=plandata[i].id;;
           fund.invoiceno="";
         
           currentTable1.AddRow(fund);
           }
      }else{
    	  loadMask_oper.hide();
    	  alert("编辑号"+plandata[i].payment_id+"已经回笼"); 
    	  return false;
       }
      
    }
    loadMask_oper.hide();
    if(isAddPlanData==""){
        alert('操作成功'); 
        jQuery("#id_table_leasing_contract_fund_payment_now_container").window("close");
    }else{
    	alert("操作成功其中"+isAddPlanData+"已经加到实收计划中不能重复添加"); 
        }
    }
</script>