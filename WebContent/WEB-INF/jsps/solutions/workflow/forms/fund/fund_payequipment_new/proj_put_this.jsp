<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
 
<script type="text/javascript">
function comptuerCurMoney(fileName){
	var planmoney=$('#id_plan_money');
    var factmoney=$('#id_factmoney');
    var creditmoney=$('#id_creditmoney');
    var servicefees=$('#id_servicefees');
    var planfirstmoney=$('#id_plan_first_money');
    
    if(parseFloat(planmoney.val())<parseFloat(factmoney.val())+parseFloat(creditmoney.val()))
    {
    	 factmoney.val(parseFloat(planfirstmoney.val())-parseFloat(creditmoney.val()));
         alert("总金额不能大于计划金额！");
         return false;
	}
	/* 2013-11-12 修改 rovine
    if(fileName=="factmoney"){
         var temp=parseFloat(planmoney.val())-parseFloat(factmoney.val()||0);
         creditmoney.val(temp.toFixed(2));
        }
    else{
    	var temp=parseFloat(planmoney.val())-parseFloat(creditmoney.val()||0);
    	factmoney.val(temp.toFixed(2));
      }*/
    var tempservice=parseFloat(creditmoney.val()||0)*0.026;
    servicefees.val(tempservice.toFixed(2));
}
function  deletePlanData(currentTable){
    var rowDatas  = currentTable.getCheckedRowDatas();
    var plantable=getTracywindyObject('table_id_table_leasing_funds_collection_details');
    var plantableOjbect=plantable.getRowsJsonData();
    for(var i=0;i<rowDatas.length;i++){
        for(var j=0;j<plantableOjbect.length;j++){
            if(rowDatas[i].id==plantableOjbect[j].id){
               var rowData = plantableOjbect[j];
         	   var removeIndex = rowData.rowIndex ;
         	  plantable.removeRowAt(removeIndex);
            }
        }
    }    
}
function checkMoney(){
	var planmoney=$('#id_plan_money');
    var factmoney=$('#id_factmoney');
    var creditmoney=$('#id_creditmoney');
    /*
    if(parseFloat(factmoney.val())<0){
   jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>电汇金额小于零</div>",'error'); 
			return false;
    }*/
    if(parseFloat(creditmoney.val())<0){
    jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>额度金额小于零</div>",'error'); 
			return false;
    }
	return true;
}


jQuery(function(){
	    var currentIsNeedTools = true;
	    //if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    //	currentIsNeedTools = false;
	    //}
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_fund_payment_now_container',
	    width:formWidth,
	    tools:'修改|删除',
	    isNeedTools:currentIsNeedTools,
	    confirmRemoveCallBack:function($me,currentTable){
	    	deletePlanData(currentTable);
           return true;
	     },
	     validateForm:function($me,currentTable){
		    
	 		if(!Validator.Validate(jQuery("#"+$me.windowId+" form")[0],1,false)){return false;};
	 		if(!checkMoney()){return false;} 
	 		return true;
	 	},
	 	 updateFromOperCallBack:function(operType,thisForm,me,rowData){
	    	 /*if(operType=="update"){
		    	 //默认付款日期为周三，超过为下周三
	    		 var day=new Date();
	    		 var num1=(3-day.getDay()+7)%7;
	    		 var wed = new Date(day.getTime() + 1000 * 60 * 60 * 24 * num1);
	    		 var factday=wed.getFullYear()+"-"+(wed.getMonth()+1)+"-"+wed.getDate();
		    	 thisForm["accountingdate"].value=factday;
	    	 }*/
	 	},
	    isFit:true,
	    datas:JsonUtil.decode('${empty json_contract_fund_payment_now_str ? "[]" : json_contract_fund_payment_now_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'fundfundchargeplan',header:'付款编号',nullable:false,readOnly:true},
	       {name:'factObject',header:'付款人名称',nullable:false,readOnly:false},
	       {name:'cust_name',header:'客户名称',nullable:false,readOnly:true},
	       {name:'contractid',header:'融资租赁合同号',nullable:false,hidden:true},
	       {name:'contract_number',header:'融资租赁合同号',nullable:false,readOnly:true},
	       {name:'feetype',header:'feetypeId', hidden :true},
		   {name:'rawvaluefee_type',header:'付款名目',nullable:false,readOnly:true},
	       //{name:'plan_first_money',header:'应收首付款',nullable:false,type:'double',readOnly:true,otherAttributes:'id="id_plan_first_money"'},
	       //{name:'plan_first_fact_money',header:'实收首付款',nullable:false,type:'double',readOnly:true},
	       {name:'settlemethod',header:'结算方式id',readOnly:true,hidden:"true",defaultValue:"PayFund6"},
	       {name:'rawValue_settlemethod',header:'结算方式',readOnly:true,nullable:false,defaultValue:"电汇"},
	       {name:'plan_money',header:'计划金额',nullable:false,type:'double',readOnly:true,otherAttributes:'id="id_plan_money"'},
	       {name:'factmoney',header:'电汇金额',nullable:false,type:'double',otherAttributes:'id="id_factmoney" onkeyup="comptuerCurMoney(this.name)"'},
	       {name:'creditmoney',header:'放车额度',nullable:false,type:'double',readOnly:true,otherAttributes:'id="id_creditmoney" onkeyup="comptuerCurMoney(this.name)"'},
	       //{name:'accountingdate',header:'会计处理日',type:'date'},
	       //{name:'clientaccount',header:'开户行户名称'},
	       //{name:'clientaccnumber',header:'账号'},
           {name:'servicefees',header:' 综合服务费',otherAttributes:'id="id_servicefees"'},
	       {name:'paytype',header:'收付类型id',hidden:true,defaultValue:"pay_type_out"},
	       {name:'rawValue_paytype',header:'收付类型',hidden:true,defaultValue:"付款"}
	     ]
	 });
});


</script>