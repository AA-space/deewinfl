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
	    tools:'新增|修改|删除',
	    checkType:'radio',
	    otherTools:[
	        //{html:'<font style="color:red;font-weight:BOLD;">租金测算</font>',iconCls:'icon-adjust',handler:submitByPlanUpdate}
	        {html:'<font style="color:red;font-weight:BOLD;">租金测算</font>',iconCls:'icon-adjust',handler:rentPlanReckon}
	    ],
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    datas:JsonUtil.decode('${empty json_fund_rent_plan_str ? "[]" : json_fund_rent_plan_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'rentlist',  header:'期项',nullable:false,type:'number'},
	       {name:'plandate',  header:'计划日期',nullable:false,type:'date'},
	       {name:'rent',  header:'租金',nullable:false,type:'double'},
	       {name:'corpus',  header:'财务本金',nullable:false,type:'double'},
	       {name:'interest',  header:'财务利息',nullable:false,type:'double'},
	       {name:'corpusoverage',  header:'本金余额',nullable:false,type:'double'},
	       {name:'corpusbusiness',  header:'业务本金',nullable:false,type:'double'},
	       {name:'interestbusiness',  header:'业务利息',nullable:false,type:'double'},
	       {name:'yearrate',  header:'年利率',nullable:false,type:'double'}
	     ]
	 });
	}
});
</script>