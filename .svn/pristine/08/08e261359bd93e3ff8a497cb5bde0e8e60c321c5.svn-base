<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_fund_rent_plan_container',
	    width:formWidth,
	    isFit:true,
	    isNeedTools:currentIsNeedTools,
	    tools:' ',
	    datas:JsonUtil.decode('${empty json_fund_rent_plan_str ? "[]" : json_fund_rent_plan_str }'),
	    columns:[
               {name:'id',  header:'id',hidden:true},
               {name:'contractid',headler:'合同号ID',hidden:true},
               {name:'contract_number',header:'合同号',nullable:false},
               {name:'cust_name',header:'承租人'},
               {name:'rent_list',header:'期次'},
               {name:'plan_date',header:'计划日期'},
               {name:'rent',header:'计划租金',type:'double'},
               {name:'corpus',header:'计划本金',type:'double'},
               {name:'interest',header:'计划租息',type:'double'},
               {name:'penalty',header:'计划罚息',type:'double'},
               {name:'ov_rent',header:'未回收租金',type:'double'},
               {name:'ov_corpus',header:'未回收本金',type:'double'},
               {name:'ov_interest',header:'未回收租息',type:'double'},
               {name:'vo_penalty',header:'未回收罚息',type:'double'}
	       	   ]
	 });
	 
});

</script>