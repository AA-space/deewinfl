<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	if(isSubTable){
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_rent_plan_container_old',
	    width:formWidth,
	    isNeedTools:false,
	    isFit:true,
	    isAutoHeight:true,
	    checkType:'radio',
	    datas:JsonUtil.decode('${empty json_fund_rent_plan_old_str ? "[]" : json_fund_rent_plan_old_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'rentlist',  header:'期项',type:'number'},
	       {name:'plandate',  header:'计划日期',type:'date'},
	       {name:'planstatusid',  header:'状态ID',hidden:true},
	       {name:'planstatusname',  header:'状态'},
	       {name:'rent',  header:'租金',type:'double'},
	       {name:'corpus',  header:'财务本金',type:'double'},
	       {name:'interest',  header:'财务利息',type:'double'},
	       {name:'corpusoverage',  header:'本金余额',type:'double'},
	       {name:'corpusbusiness',  header:'业务本金',type:'double'},
	       {name:'interestbusiness',  header:'业务利息',type:'double'},
	       {name:'yearrate',  header:'年利率',type:'double'},
	       {name:'rentadjust',  header:'租金调整',type:'double'}
	     ]
	 });
	}
});
</script>