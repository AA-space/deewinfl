<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_equipment_container',
	    width:1000,
	    height:350,
	    isFit:true,
	    tools:'新增|修改|删除',
	    isNeedTools:currentIsNeedTools,
	    datas:JsonUtil.decode('${empty json_proj_guarantee_method_str ? "[]" : json_proj_guarantee_method_str }'),
	    columns:[
		   {name:'colunm1',  header:'资产类型',nullable:false},
	       {name:'colunm2',  header:'评估价格(元)',nullable:false},
	       {name:'colunm3',  header:'数量',nullable:false},
	       {name:'colunm4',  header:'备注',nullable:false}
	     ]
	 });
});

</script>