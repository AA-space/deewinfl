<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_rent_up_actually_container',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    isNeedTools:false,
		   // isNeedTools:currentIsNeedTools,
		    //tools:'新增|修改|删除',
	    datas:JsonUtil.decode('${empty json_rent_up_actually_str ? "[]" : json_rent_up_actually_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'planlist',  header:'计划期项',nullable:false},
	       {name:'ebanknumber',  header:'网银编号',nullable:false},
	       {name:'hirelist',  header:'回笼期项',nullable:false},
	       {name:'balancemode',  header:'结算方式',nullable:false},
	       {name:'hiredate',  header:'回笼日期',nullable:false},
	       {name:'rent',  header:'回笼租金',nullable:false},
	       {name:'corpus',  header:'回笼本金',nullable:false},
	       {name:'interest',  header:'回笼租息',nullable:false},
	       {name:'penalty',  header:'回笼罚息',nullable:false},
	       {name:'interestadjust',  header:'租息调整',nullable:false},
	       {name:'penaltyadjust',  header:'罚息调整',nullable:false},
	       {name:'invoiceno',  header:'单据号',nullable:false}
	       //{name:'accountingdate',  header:'会计处理日',nullable:false},
	      // {name:'ownbank',  header:'本方银行',nullable:false},
	       //{name:'ownaccount',  header:'本方银行账户',nullable:false},
	       //{name:'ownnumber',  header:'本方银行账号',nullable:false},
	      // {name:'hireobject',  header:'付款人',nullable:false},
	      // {name:'hirebank',  header:'付款人银行',nullable:false},
	       //{name:'hirebank',  header:'付款人银行账户',nullable:false},
	      // {name:'hirenumber',  header:'付款人银行账号',nullable:false}		      
   	     ]
	 });
	 
});

</script>