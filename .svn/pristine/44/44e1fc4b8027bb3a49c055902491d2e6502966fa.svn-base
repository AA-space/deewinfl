<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	if(isSubTable){
		var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_rent_plan_container',
	    width:formWidth,
	    isAutoHeight:true,
	    tools:'修改',
	    checkType:'radio',
	    otherTools:[
	        {html:'<font style="color:red;font-weight:BOLD;">租金调整</font>',iconCls:'icon-adjust',handler:submitByPlanAdjust}
	    ],
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    operValidate:adjustUpdatePlanCheck,
	    updateOperCallBack:enabledUpdate,
	    completeCallBack:disabledUpdate,
	    datas:JsonUtil.decode('${empty json_fund_rent_plan_str ? "[]" : json_fund_rent_plan_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'rentlist',  header:'期项',readOnly:true,nullable:false,type:'number'},
	       {name:'plandate',  header:'计划日期',type:'text'},//,nullable:false ,readOnly:true
	       {name:'rent',  header:'租金',readOnly:true,nullable:false,type:'double'},
	       {name:'corpus',  header:'财务本金',readOnly:true,nullable:false,type:'double'},
	       {name:'interest',  header:'财务利息',readOnly:true,nullable:false,type:'double'},
	       {name:'corpusoverage',  header:'本金余额',readOnly:true,nullable:false,type:'double'},
	       {name:'corpusbusiness',  header:'业务本金',readOnly:true,nullable:false,type:'double'},
	       {name:'interestbusiness',  header:'业务利息',readOnly:true,nullable:false,type:'double'},
	       {name:'yearrate',  header:'年利率',readOnly:true,nullable:false,type:'double'},
	       {name:'rentadjust',  header:'租金调整',nullable:false,type:'double'}
	     ]
	 });
	}
});
function  enabledUpdate(){
	getTracywindyObject('table_id_table_leasing_rent_plan_container').enabledToolsByText("租金调整");
}
function  disabledUpdate(){
	getTracywindyObject('table_id_table_leasing_rent_plan_container').disabledToolsByText("租金调整");
}
</script>