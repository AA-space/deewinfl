<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	jQuery(function(){
	    var table_proj_fund_rent_cash= new tracywindyTable({
		    renderTo:'id_leasing_table_fund_rent_cash',
		    id:'table_leasing_table_fund_rent_cash',
		    loadMode:'local',
		    width:formWidth,
		    isFit:true,
		    height:350,
		    isRank:true,
		    border:true,
		    datas:JsonUtil.decode('${empty json_fund_rent_cash_str ? "[]" : json_fund_rent_cash_str }'),
		    columns:[
		     //  {name:'id',  header:'id',hidden:true},
		       {name:'plan_date',  header:'计划日期',nullable:false},
		       {name:'follow_in',  header:'流入量'},
		       {name:'follow_in_detail',  header:'流入明细'},
		       {name:'follow_out',  header:'流出量',nullable:false,type:'double'},
		       {name:'follow_out_detail',  header:'流出明细'},
		       {name:'net_follow',  header:'净流量'}
		     ]
		 });
	});

</script>