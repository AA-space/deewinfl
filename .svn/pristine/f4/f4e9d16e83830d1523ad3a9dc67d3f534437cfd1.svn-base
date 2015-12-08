<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	if(isSubTable){
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_fund_cash_flow_container_old',
	    width:formWidth,
	    isNeedTools:false,
	    isFit:true,
	    isAutoHeight:true,
	    checkType:'radio',
	    datas:JsonUtil.decode('${empty json_fund_cash_flow_old_str ? "[]" : json_fund_cash_flow_old_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'plandate',  header:'计划日期',readOnly:true},
	       {name:'fundin',  header:'流入量',readOnly:true},
	       {name:'fundindetails',  header:'流入量清单',readOnly:true},
	       {name:'fundout',  header:'流出量',readOnly:true},
	       {name:'fundoutdetails',  header:'流出量清单',readOnly:true},
	       {name:'netflow',  header:'净流量',readOnly:true}
	     ]
	 });
	}
});
</script>