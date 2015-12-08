<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
function showPenaltyRed(value,tableObj,columnName,columnIndex,rowData){
	return "<font color='red'>"+value+"</fond>";
}
jQuery(function(){
	    new tracywindyMultiTable({
	    renderTo:'id_table_other_fund_plan_container',
	    width:formWidth,
	    height:formHeight,
	    tools:'',
	    //isNeedTools:currentIsNeedTools,
	    isFit:true,
	    isPage:true,
	    pageSize:10,
	    xmlFileName : '\\eleasing\\workflow\\public\\fundRentPlanSelect.xml',
		loadMode : 'ajax',
		params : {dealer_number:'${empty dealerid ? "" : dealerid}',
	    	haspenalty:0
			},
		//lazyLoad:true,
	    datas:JsonUtil.decode('${empty json_other_fund_rent_str ? "[]" : json_other_fund_rent_str }'),
	    columns:[
				{name:'id',  header:'id',hidden:true},
				{name:'contractid',headler:'合同号ID',hidden:true},
				{name:'contract_number',header:'合同号',nullable:false},
				{name:'cust_name',header:'承租人'},
				{name:'rent_list',header:'期次'},
				{name:'plan_date',header:'计划日期'},
				{name:'rent',header:'计划租金'},
				{name:'corpus',header:'计划本金'},
				{name:'interest',header:'计划租息'},
				{name:'penalty',header:'计划罚息'},
				{name:'ov_rent',header:'未回收租金'},
				{name:'ov_corpus',header:'未回收本金'},
				{name:'ov_interest',header:'未回收租息'},
				{name:'vo_penalty',header:'未回收罚息',renderer:showPenaltyRed}
	     ]
	 });
});	
</script>
