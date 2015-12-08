<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	if(isSubTable){
		//初次加载控制
		var settle_method="${empty requestScope['framework_condition.settlemethod']?'even_rent':requestScope['framework_condition.settlemethod'] }";
		var read=false;
		if(settle_method=='irregular_rent'){
			read=false;
		}
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    	read=true;
	    }
	    var fundRentPlan=new tracywindyMultiTable({
	    renderTo:'id_table_leasing_rent_plan_container',
	    width:formWidth,
	    tools:'新增|修改|删除',
	    isAutoHeight:true,
	    otherTools:[
	        {html:'<font style="color:red;font-weight:BOLD;">租金测算</font>',iconCls:'icon-reckon',handler:rentPlanReckon},
	        {html:'<font style="color:red;font-weight:BOLD;">租金调整</font>',iconCls:'icon-adjust',handler:rentPlanAdjust}
	    ],
	    isNeedTools:true,
	    isFit:true,
	    completeCallBack:function(){
	    	rentPlanMultiTable();
		},
	    datas:JsonUtil.decode('${empty json_fund_rent_plan_str ? "[]" : json_fund_rent_plan_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'rentlist',  header:'期项',readOnly:read,nullable:false,type:'text'},
	       {name:'plandate',  header:'计划日期',readOnly:true,nullable:false,type:'date'},
	       {name:'rent',  header:'租金',readOnly:true,nullable:false,type:'double'},
	       {name:'corpus',  header:'财务本金',readOnly:read,nullable:false,type:'double'},
	       {name:'interest',  header:'财务利息',readOnly:read,nullable:false,type:'double'},
	       {name:'corpusoverage',  header:'本金余额',readOnly:true,nullable:false,type:'double',hidden:true},
	       {name:'corpusbusiness',  header:'业务本金',readOnly:read,nullable:false,type:'double'},
	       {name:'interestbusiness',  header:'业务利息',readOnly:read,nullable:false,type:'double'},
	       {name:'yearrate',  header:'年利率',readOnly:true,nullable:false,type:'rate',hidden:true},
	       {name:'rentadjust',  header:'租金调整',readOnly:!currentIsNeedTools,type:'double',defaultValue:0}
	     ]
	 });
	}
});
</script>