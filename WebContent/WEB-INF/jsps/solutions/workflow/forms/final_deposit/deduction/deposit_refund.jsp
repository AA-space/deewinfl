<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    //renderTo:'id_table_leasing_deposit_refund_container',
	    width:formWidth,
	    height:350,
	    isFit:true,
	   // xmlFileName:'\\eleasing\\workflow\\caution_money\\caution_money_dk.xml',
	   // loadMode:'ajax',
	    isNeedTools:false,
		   // isNeedTools:currentIsNeedTools,
		    //tools:'新增|修改|删除',
	    //datas:JsonUtil.decode('${empty json_deposit_refund_str ? "[]" : json_deposit_refund_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'eqipName',  header:'计划编号',nullable:false,mapping:'eqipname'},
	       {name:'eqipName',  header:'收款对象',nullable:false,mapping:'eqipname'},
	       {name:'feeType',  header:'费用类型',nullable:false,mapping:'eqipname'},
	       {name:'eqipName',  header:'计划支付日期',nullable:false,mapping:'eqipname'},
	       {name:'eqipName',  header:'计划退款本金',nullable:false,mapping:'eqipname'},
	       {name:'eqipName',  header:'剩余金额',nullable:false,mapping:'eqipname'},
	       {name:'ffcmemo',  header:'备注',nullable:false,mapping:'eqipname'}	      
   	     ],
   	  params:{
 			feetype:'feetype2',settlemethod:'PayFund8'
  	     }
	 });
	 
});

</script>