<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_deposit_out_container',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    isNeedTools:false,
		   // isNeedTools:currentIsNeedTools,
		    //tools:'新增|修改|删除',
	    datas:JsonUtil.decode('${empty json_deposit_out_str ? "[]" : json_deposit_out_str }'),
	    columns:[
	             {name:'id',header:'id',hidden:true},
	  	       {name:'fundfundchargeplan',header:'计划编号',nullable:false},
	  	       {name:'paytype',header:'收付类型',nullable:false},
	  	       {name:'factdate',header:'实际收付日期',nullable:false},
	  	       {name:'factmoney',header:'实际收付金额',nullable:false},
	  	       {name:'settlemethod',header:'结算方式',nullable:false}
   	     ]
	 });
	 
});

</script>