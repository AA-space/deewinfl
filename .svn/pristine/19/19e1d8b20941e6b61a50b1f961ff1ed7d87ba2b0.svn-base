<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_rent_netflow',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    isNeedTools:currentIsNeedTools,
	    tools:'新增|修改|删除',
	    datas:JsonUtil.decode('${empty json_rent_netflow_str ? "[]" : json_rent_netflow_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'eqipName',  header:'编号',nullable:false,mapping:'eqipname'},
	       {name:'eqipName',  header:'期项',nullable:false,mapping:'eqipname'},
	       {name:'eqipName',  header:'状态',nullable:false,mapping:'eqipname'},
	       {name:'eqipName',  header:'承付日期',nullable:false,mapping:'eqipname'},
	       {name:'eqipName',  header:'租金',nullable:false,mapping:'eqipname'},
	       {name:'eqipName',  header:'财务本金',nullable:false,mapping:'eqipname'},
	       {name:'eqipName',  header:'财务利息',nullable:false,mapping:'eqipname'},
	       {name:'equipInvoice',  header:'业务本金',nullable:true,mapping:'equipinvoice'},
	       {name:'totalPrice',  header:'业务利息',nullable:false,type:'double',mapping:'totalprice'},
	       {name:'presentValue',  header:'年利率',nullable:false,type:'double',mapping:'presentvalue'}
	      
   			
	     
	     ]
	 });
	 
});

</script>