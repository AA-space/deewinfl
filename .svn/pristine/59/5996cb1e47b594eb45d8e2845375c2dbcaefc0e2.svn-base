<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script> 

function setFundFundChargePlanReback(table){
	//loadMask_oper.show();
	var plandata = table.getCheckedRowDatas();
    var allItems = document.getElementsByName(table.checkName);
    var currentTabled = getTracywindyObject('table_id_table_leasing_contract_fund_payment_now_container');
    var talbedata=currentTabled.getRowsData();
    var iddata=getTableColumnData(talbedata,"id");
    var plantable=getTracywindyObject('table_id_table_leasing_contract_fund_payment_now_container');
    var plantabledate=plantable.getRowsData();
    var isAddPlanData="";
    var reBackData=[];
    for(var i=0;i<plandata.length;i++){
        
        if(plandata[i].rollback=="1"){
        	//loadMask_oper.hide();
        	jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>已经红冲的付款计划不能红冲</div>",'success'); 
          return false;
        }
    	if(checkIdIsAdd(plandata[i].id,iddata)){
            if(isAddPlanData==""){isAddPlanData=plandata[i].fundfundchargeplan;}else{isAddPlanData=isAddPlanData+","+plandata[i].fundfundchargeplan;}
        }else{
        	 tdate=util.clone(plandata[i]);
             var paymentid=tdate.fundfundchargeplan;
             var id="";
             for(var j=0;j<plantabledate.length;j++){
                if(plantabledate[j].paymentid==paymentid){
                    id=plantabledate[j].id;
                 }
              }
             
             tdate.pid=plandata[i]['id'];
             tdate.paymentid = plandata[i]['fundfundchargeplan.paymentId'];
             tdate.rollback = 1;
             tdate.custname= $('input[name="contract_info.custname"]').val();
             tdate.PID=plandata[i].id;
             tdate.fundfundchargeplan= plandata[i].fundfundchargeplan;
             tdate.paymentid=plandata[i]['fundfundchargeplan.paymentId'];
             tdate.factmoney=parseFloat(tdate.factmoney)*(-1);
             tdate.feeadjust=parseFloat(tdate.feeadjust)*(-1);
             var temp=parseFloat(tdate.factmoney)+parseFloat(tdate.feeadjust);
             tdate.settlemethod="PayFund9";
             tdate.rawValue_settlemethod="红冲";
             tdate.receivermoney=temp.toFixed(2);
             tdate.oper="old";
             reBackData.push(tdate);
        }
    }
    currentTabled.AddRows(reBackData);
    for(var i= 0;i<allItems.length;i++)
    {
       if(allItems[i].checked)
        {
    	   allItems[i].checked=false;
       }
    } 
    //loadMask_oper.hide();
    if(isAddPlanData==""){
       jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>操作成功</div>",'success'); 
    }else{
    	jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>操作成功其中"+isAddPlanData+"已经加到实付计划中不能重复添加</div>",'success'); 
     }
   }
jQuery(function(){
	if(isSubTable){
	    var currentIsNeedTools = false;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    	$('#table_id_table_leasing_contract_fund_payment_history_container_toolsDiv').hide();
	    }
	   var fundp=   new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_fund_payment_history_container',
	    width:formWidth,
	    height:350,
	    tools:'新增|修改|删除',
	    isNeedTools:currentIsNeedTools,
	    otherTools : [ {
			html : '<font color="red">生成资金红冲</font>',
			handler : function(table) {
				var fundPlan = table.getCheckedRowDatas();
				if (0 == fundPlan.length) {
					alert("请选择需要资金计划!");
					return false;
				}
				setFundFundChargePlanReback(fundp);
			},
			iconCls : 'icon-update'
		} ],
	    isFit:false,
	    datas:JsonUtil.decode('${empty json_contract_fund_payment_history_str ? "[]" : json_contract_fund_payment_history_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'fundfundchargeplan',  header:'fundfundchargeplan',hidden:true},
	       {name:'fundfundchargeplan.paymentId',  header:'付款编号',nullable:false},
	       {name:'feetype',  header:'feetypeId',hidden:true},
	       {name:'rollback',header:'红冲',hidden:true,type:"text",renderer:function(val){if(val=="1"){return "是"}else{return "否"}}},
  	       {name:'rawValue_feetype',  header:'费用类型',nullable:false},
  	       {name:'factmoney',  header:'金额',nullable:false,type:'double'},
	       {name:'feeadjust',  header:'调整金额',nullable:false,type:'double'},
	       {name:'settlemethod',  header:'结算方式id',hidden:true},
	       {name:'rawValue_settlemethod',  header:'结算方式',nullable:false,readOnly:true},
	       {name:'factdate',  header:'支付时间',nullable:false},
	       {name:'accountbank',  header:'银行',nullable:false},
	       {name:'account',  header:'银行账户',nullable:false},
	       {name:'accnumber',  header:'银行账号',nullable:false},
	       {name:'factobject',  header:'收款客户',nullable:false},
	       {name:'clientbank',  header:'客户银行',nullable:false},
	       {name:'clientaccount',  header:'客户账户',nullable:false},
	       {name:'clientaccnumber',  header:'客户账号',nullable:false},
	       {name:'accountingdate',  header:'会计处理日',nullable:false},
	       {name:'invoiceno',  header:'单据号',nullable:false},
	       {name:'ffcmemo', header:'备注',type:'textarea'},
	       {name:'creator',  header:'输入人',nullable:false},
	       {name:'createdate',  header:'输入日期',nullable:false,readOnly:false,type:'date'}
	     ]
	   });
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	$('#table_id_table_leasing_contract_fund_payment_history_container_toolsDiv').parent().hide();
	    }
	}
});

</script>