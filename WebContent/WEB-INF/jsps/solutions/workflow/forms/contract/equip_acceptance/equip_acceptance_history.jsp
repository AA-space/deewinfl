<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	    var currentIsNeedTools = false;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    //renderTo:'id_table_leasing_contract_fund_receive_history_container',
	    renderTo:'id_table_leasing_equip_acceptance_history_container',
	    
	    width:formWidth,
	    height:350,
	    tools:'新增|修改|删除',
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    //datas:JsonUtil.decode('${empty json_contract_fund_receive_history_str ? "[]" : json_contract_fund_receive_history_str }'),
	    datas:JsonUtil.decode('${empty json_equip_acceptance_history_str ? "[]" : json_equip_acceptance_history_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'contractid',  header:'编号',nullable:false},
	       {name:'accepttype',  header:'验收类型',nullable:false},
	       {name:'acceptdate',  header:'验收日期',nullable:false},
	       {name:'ecmemo', header:'备注',type:'textarea'}
	       
	     ]
	 });
});

</script>