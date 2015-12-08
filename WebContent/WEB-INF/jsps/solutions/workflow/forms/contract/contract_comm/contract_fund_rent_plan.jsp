<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<script>
	jQuery(function(){
	var table_proj_fund_rent_plan= new tracywindyTable({
	    renderTo:'id_leasing_table_fund_rent_plan',
	    id:'table_leasing_table_fund_rent_plan',
	    loadMode:'local',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    datas:JsonUtil.decode('${empty json_fund_rent_plan_str ? "[]" : json_fund_rent_plan_str }'),
	    isStatistic:true,
	    statisticColumnNames:['rent','corpus','interest'],
	    isRank:true,
	    rankSize:60,
	    columns:[
	       {name:'uuid',  header:'uuid',hidden:true},
	       {name:'plan_date',  header:'计划日期'},
	       {name:'rent_list',  header:'期次'},
	       {name:'rent',  header:'租金'},
	       {name:'corpus',  header:'本金'},
	       {name:'interest',  header:'利息'},
	       {name:'corpus_overage',  header:'剩余本金'}
	     ],
	     callBack:function(){ 
    			this.setColumnAlign('center','plan_date');
    			this.setColumnAlign('center','rent_list');
		     }
	     
	 });
});
	</script>