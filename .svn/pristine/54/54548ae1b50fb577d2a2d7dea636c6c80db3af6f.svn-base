<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<script type="text/javascript">
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
function setFundFundChargePlan(table){
	loadMask_oper.show();
	var plandata = table.getCheckedRowDatas();
    var allItems = document.getElementsByName(table.checkName);
    var currentTabled =getTracywindyObject('table_id_table_leasing_contract_fund_payment_now_container');
    var planTable=getTracywindyObject('table_id_table_leasing_funds_collection_details');
    var talbedata=currentTabled.getRowsData();
    var iddata=getTableColumnData(talbedata,"id");
    var isAddPlanData="";
    var reBackData=[];
    var fundplandate=[];
    for(var i=0;i<plandata.length;i++){
    	if(plandata[i]['rollback'] == '1'){
    		jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>红冲数据不能再次红冲</div>",'error'); 
    		loadMask_oper.hide();
    		if(allItems[i].checked)
            {
        	   allItems[i].checked=false;
           }
    		return;
    	}
    	
    	if(checkIdIsAdd(plandata[i].id,iddata)){
            if(isAddPlanData==""){isAddPlanData=plandata[i].payment_id;}else{isAddPlanData=isAddPlanData+","+plandata[i].payment_id;}
        }else{
        	 var _temPlandata ={};
        	 _temPlandata.id=plandata[i].id;
        	 _temPlandata.fundfundchargeplan=plandata[i].payment_id;
        	 _temPlandata.creditmoney=plandata[i].money;
        	 _temPlandata.factObject=plandata[i].pay_obj;
        	 _temPlandata.cust_name=plandata[i].cust_name;
        	 _temPlandata.contractid=plandata[i].contract_id;
        	 _temPlandata.contract_number=plandata[i].contract_number;
        	 _temPlandata.feetype=plandata[i].fee_type;
        	 _temPlandata.rawvaluefee_type=plandata[i].rawvaluefee_type;
        	 //_temPlandata.plan_first_money=plandata[i].plan_first_money;
        	 //_temPlandata.plan_first_fact_money=plandata[i].plan_first_fact_money;
        	 _temPlandata.settlemethod="PayFund6";
        	 _temPlandata.rawValue_settlemethod="电汇";
        	 _temPlandata.feeadjust="0.00";
        	 _temPlandata.plan_money=plandata[i].ow_fact_money;
        	 _temPlandata.factmoney=parseFloat(plandata[i].plan_first_money)-parseFloat(plandata[i].money);
             //付款时间到最后一步由出纳 填写
        	 //_temPlandata.factdate=plandata[i].plan_date;
        	 _temPlandata.paytype="pay_type_out";
        	 _temPlandata.rawValue_paytype="付款";
        	 fundplandate.push(plandata[i]);
             reBackData.push(_temPlandata);
        }
    }
    currentTabled.AddRows(reBackData);
    planTable.AddRows(fundplandate);
    for(var i= 0;i<allItems.length;i++)
    {
       if(allItems[i].checked)
        {
    	   allItems[i].checked=false;
       }
    } 
    loadMask_oper.hide();
    if(isAddPlanData==""){
           alert("操作成功"); 
    }else{
    	alert("操作成功其中"+isAddPlanData+"已经加到实收计划中不能重复添加"); 
     }
    }
	jQuery(function(){
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_fund_fund_plan_container',
	    width:formWidth,
	    height:500,
	    tools:'',
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    lazyLoad:true,
	    xmlFileName : '\\eleasing\\workflow\\public\\fundfundPlanSelect.xml',
		loadMode : 'ajax',
		params : {fee_type:'feetype10'},
		otherTools : [ {
			html : '<font color="red">付款</font>',
			handler : function(table) {
				var fundPlan = table.getCheckedRowDatas();
				if (0 == fundPlan.length) {
					 jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>请选择设备款付款计划</div>",'error'); 
					return false;
				}
				setFundFundChargePlan(table);
			},
			iconCls : 'icon-update'
		} ],  
	    datas:JsonUtil.decode('${empty json_fundfundcharge_str ? "[]" : json_fundfundcharge_str }'),
	    columns:[
				{name:'id',  header:'id',hidden:true},
				{name:'payment_id',  header:'付款编号',nullable:false},
				{name:'cust_name',  header:'客户名称'},
				{name:'pay_obj',  header:'收款人',nullable:false,hidden:true},
				{name:'money',  header:'放车额度',nullable:false,hidden:true},
				{name:'contract_id',  header:'融资租赁合同号',nullable:false,hidden:true},
				{name:'contract_number',  header:'融资租赁合同号',nullable:false},
				{name:'rawvaluefee_type',  header:'付款名目',nullable:false},
				{name:'plan_date',  header:'付款日期',nullable:false},
				{name:'plan_money',  header:'应收设备款',nullable:false,type:'double'},
				{name:'ow_fact_money',  header:'未收设备款',nullable:false,type:'double'},
				{name:'fact_money',  header:'已收设备款',type:'double'}
	     ]
	 });
});	
</script>
<div id="fund_fund_plan_select" closed="true" modal="true" title="设备款名细"
		style="display:none;width:1200px;padding-top:10px;padding:0px;">
	<center>
	<div style="width:100%;text-align:left;" id="id_table_fund_fund_plan_container">
	
	</div>
    </center>
 </div>