<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_deposit_refund_detail_container',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    isNeedTools:true,
	    isNeedTools:currentIsNeedTools,
	    tools:'新增|修改|删除',
	    datas:JsonUtil.decode('${empty json_deposit_refund_detail_str ? "[]" : json_deposit_refund_detail_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'eqipname',  header:'编号',nullable:false},
	       {name:'feetype',  header:'费用类型',nullable:false},
	       {name:'settlemethod',  header:'结算方式',nullable:false},
	       {name:'eqipname',  header:'支付时间',type:'date',nullable:false},
	       {name:'eqipname',  header:'金额',type:'double',nullable:false},
	       {name:'eqipname',  header:'调整金额',type:'double',nullable:false},
	       {name:'accountbank',  header:'银行',nullable:false},
	       {name:'account',  header:'银行账户',nullable:false},
	       {name:'accnumber',  header:'银行账号',nullable:false},
	       {name:'eqipname',  header:'收款客户',nullable:false},
	       {name:'clientbank',  header:'客户银行',nullable:false},
	       {name:'clientaccount',  header:'客户账户',nullable:false},
	       {name:'clientaccnumber',  header:'客户账号',nullable:false},
	       {name:'accountingdate',  header:'会计处理日',type:'date',nullable:false},
	       {name:'invoiceno',  header:'单据号',nullable:false},
	       {name:'ffcmemo',  header:'备注',nullable:false}	      
   	     ]
	 });
	 
});

</script>