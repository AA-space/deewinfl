<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	if(isSubTable){
	    var currentIsNeedTools = false;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_fund_cash_flow_container',
	    width:formWidth,
	    isAutoHeight:true,
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    isAutoBreakContent:true,
	    datas:JsonUtil.decode('${empty json_fund_cash_flow_str ? "[]" : json_fund_cash_flow_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'plandate',  header:'计划日期',readOnly:true},
	       {name:'fundin',  header:'流入量',readOnly:true},
	       {name:'fundindetails',  header:'流入量清单',readOnly:true,width:200},
	       {name:'fundout',  header:'流出量',readOnly:true},
	       {name:'fundoutdetails',  header:'流出量清单',readOnly:true,width:200},
	       {name:'netflow',  header:'净流量',readOnly:true}
	     ]
	 });
	}
});
</script>