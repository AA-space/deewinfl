<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    //renderTo:'id_table_leasing_contract_fund_receive_history_container',
	    renderTo:'id_table_leasing_generated_reports_container',
	    width:formWidth,
	    height:350,
	    tools:'新增|修改|删除',
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    //datas:JsonUtil.decode('${empty json_contract_fund_receive_history_str ? "[]" : json_contract_fund_receive_history_str }'),
	    datas:JsonUtil.decode('${empty json_generated_reports_str ? "[]" : json_generated_reports_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'contractid',  header:'合同编号',nullable:false},
	       {name:'contracttype',  header:'合同类型',nullable:false},
	       {name:'contracttext',  header:'合同文本',nullable:false}
	     ]
	 });
});
</script>