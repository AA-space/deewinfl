<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_put_detail',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    isNeedTools:currentIsNeedTools,
	    tools:'新增|修改|删除',
	    datas:JsonUtil.decode('${empty json_proj_guarantee_equip_str ? "[]" : json_proj_guarantee_equip_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'planId',  header:'投放编号',nullable:false },
	       {name:'planId2',  header:'计划投放编号',nullable:false },
	       {name:'payType',  header:'结算方式',nullable:false },
	       {name:'putObject',  header:'投放对象',nullable:false },
	       {name:'putMoney',  header:'投放金额',nullable:false },
	       {name:'changeMoney',  header:'调整金额',nullable:false },
	       {name:'actuallyDate',  header:'实际投放日期',nullable:false },
	       {name:'DNum',  header:'单据号',nullable:false},
	       {name:'equipInvoice',  header:'客户开户银行',nullable:true},
	       {name:'totalPrice',  header:'客户开户账号',nullable:false,type:'double'},
	       {name:'presentValue',  header:'客户开户账户',nullable:false,type:'double'},
	       {name:'presentValue2',  header:'本方账号',nullable:false,type:'double'},
	       {name:'presentValue3',  header:'本方账户',nullable:false,type:'double'},
		   {name:'recordMech',  header:'本方银行',nullable:true,mapping:'recordmech'},
	       {name:'purchaseLife',  header:'会计处理日',nullable:false,type:'number'},
	       {name:'cgenote',  header:'备注',type:'textarea'}
	     ]
	 });
	 
});

</script>