<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	jQuery(function(){
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_funds_collection_details',
	    width:formWidth,
	    tools:'',
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
		loadMode : 'local',
	    datas:JsonUtil.decode('${empty json_fundfundcharge_str ? "[]" : json_fundfundcharge_str }'),
	    columns:[
				{name:'id',  header:'id',hidden:true},
				{name:'payment_id',  header:'付款编号',nullable:false},
				{name:'cust_name',  header:'客户名称'},
				{name:'contract_id',  header:'融资租赁合同号',nullable:false,hidden:true},
				{name:'contract_number',  header:'融资租赁合同号',nullable:false},
				{name:'rawvaluefee_type',  header:'付款名目',nullable:false},
				{name:'plan_date',  header:'付款日期',nullable:false},
				{name:'plan_money',  header:'应收设备款',nullable:false,type:'double'},
				{name:'ow_fact_money',  header:'未收设备款',nullable:false,type:'double'},
				{name:'fact_money',  header:'已收设备款',type:'double'}
	     ]
	 });
});

</script>