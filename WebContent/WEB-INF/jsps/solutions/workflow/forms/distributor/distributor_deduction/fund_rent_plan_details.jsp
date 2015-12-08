<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
var pid='${empty fundid ? "" : fundid }';
function showPenaltyRed(value,tableObj,columnName,columnIndex,rowData){
	return "<font color='red'>"+value+"</fond>";
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
function setFundFundChargePlan(table){
	loadMask_oper.show();
	 var plantable=getTracywindyObject('table_id_table_fund_rent_income_container');
	 var rowDatas=plantable.getRowsJsonData();
	 var fundtable=getTracywindyObject('table_id_table_fund_fund_plan_history_container');
	 var fundrowDatas=fundtable.getRowsJsonData();
	 
	 var fund=fundrowDatas[0].overmoney;
	 var penalty=0.00;
	 for(var i=0;i<rowDatas.length;i++){
		 var rowData=rowDatas[i];
		 penalty=penalty+parseFloat(rowData.penalty)+parseFloat(rowData.penaltyadjust);
	 }		    
    var fundlast=parseFloat(fund)-parseFloat(penalty);
    fundlast=fundlast.toFixed(2);
    if(parseFloat(fundlast)<=0){loadMask_oper.hide();alert("本次保证金不足，不能再抵扣");return false;}
	var plandata = table.getCheckedRowDatas();
    var allItems = document.getElementsByName(table.checkName);
    var currentTabled =getTracywindyObject('table_id_table_fund_rent_income_container');
    var planTable=getTracywindyObject('table_id_table_fund_rent_plan_container');
    var talbedata=currentTabled.getRowsData();
    var iddata=getTableColumnData(talbedata,"id");
    var isAddPlanData="";
    var reBackData=[];
    var fundplandate=[];
    for(var i=0;i<plandata.length;i++){
    	if(checkIdIsAdd(plandata[i].id,iddata)){
            if(isAddPlanData==""){isAddPlanData=plandata[i].rent_list;}else{isAddPlanData=isAddPlanData+","+plandata[i].rent_list;}
        }else{
             if(parseFloat(fundlast)>0){
             var temppenalty=plandata[i].vo_penalty;
             temppenalty=300;
             
             if(parseFloat(temppenalty)>parseFloat(fundlast)){
            	 temppenalty= fundlast;
            	 fundlast=0.00;
             }else{
            	 fundlast=parseFloat(fundlast)-parseFloat(temppenalty);
            	 fundlast=fundlast.toFixed(2);
             }
             var _temPlandata ={};
        	 _temPlandata.id=plandata[i].id;
        	 _temPlandata.contractid=plandata[i].contractid;
        	 _temPlandata.planid=plandata[i].id;
        	 _temPlandata.cust_name=plandata[i].cust_name;
        	 _temPlandata.contract_number=plandata[i].contract_number;
        	 _temPlandata.planlist=plandata[i].rent_list;
        	 _temPlandata.hiredate=getCurDate();
        	 _temPlandata.rent="0.00";
        	 _temPlandata.corpus="0.00";
        	 _temPlandata.interest="0.00";
        	 _temPlandata.penalty=temppenalty;
        	 _temPlandata.rentadjust="0.00";
        	 _temPlandata.corpusadjust="0.00";
        	 _temPlandata.interestadjust="0.00";
        	 _temPlandata.penaltyadjust="0.00";
        	 _temPlandata.balancemode="PayFund10";
        	 _temPlandata.PID=pid;
        	 fundplandate.push(plandata[i]);
             reBackData.push(_temPlandata);}
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
    	alert("操作成功其中"+isAddPlanData+"期次已经加到计划中不能重复添加"); 
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
	    xmlFileName : '\\eleasing\\workflow\\public\\fundRentPlanSelect.xml',
		loadMode : 'ajax',
		params : {},
		lazyLoad:true,
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
				{name:'contractid',headler:'合同号ID',hidden:true},
				{name:'contract_number',header:'合同号',nullable:false},
				{name:'cust_name',header:'承租人'},
				{name:'rent_list',header:'期次'},
				{name:'plan_date',header:'计划日期'},
				{name:'rent',header:'计划租金'},
				{name:'corpus',header:'计划本金'},
				{name:'interest',header:'计划租息'},
				{name:'penalty',header:'计划罚息'},
				{name:'ov_rent',header:'未回收租金'},
				{name:'ov_corpus',header:'未回收本金'},
				{name:'ov_interest',header:'未回收租息'},
				{name:'vo_penalty',header:'未回收罚息',renderer:showPenaltyRed}
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