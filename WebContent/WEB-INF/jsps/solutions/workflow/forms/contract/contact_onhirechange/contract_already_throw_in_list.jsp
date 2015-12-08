<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_already_throw_in_list_container',
	    width:formWidth,
	    height:350,
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    datas:JsonUtil.decode('${empty json_already_throw_in_list_str ? "[]" : json_already_throw_in_list_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'eqipName',  header:'投放编号',nullable:false,readOnly:false},
	       {name:'planid',  header:'计划投放编号',type:'double'},
	       {name:'settlemethod',  header:'结算方式'},
	       {name:'factobject',  header:'投放对象'/*,otherAttributes:" onpropertychange='document.all.price.value=document.all.equip_num.value*this.value' "*/},
	       {name:'factmoney',  header:'投放金额',nullable:false,type:'double'},
	       {name:'feeadjust',  header:'调整金额',nullable:false,type:'double'},
	       {name:'factdate',  header:'实际投放日期',nullable:false,type:'date'},
	       {name:'invoiceno', header:'单据号'},
	       {name:'clientbank',  header:'客户开户银行'},
	       {name:'clientaccnumber',  header:'客户开户账号'},
	       {name:'clientaccount',  header:'客户开户账户'},
	       {name:'accnumber',  header:'本方账号'},
	       {name:'account',  header:'本方账户'},
	       {name:'accountbank',  header:'本方银行'},
	       {name:'accountingdate',  header:'会计处理日',nullable:false,type:'date'},
	       {name:'ffcmemo',  header:'备注'}
	      
	     ]
	 });
});

</script>