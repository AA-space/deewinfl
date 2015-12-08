<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	if(isSubTable){
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_premise_container',
	    width:formWidth,
	    height:350,
	    tools:'新增|修改|删除',
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    datas:JsonUtil.decode('${empty json_contract_premise_str ? "[]" : json_contract_premise_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'orderid',  header:'序号',nullable:false,type:'number'},
	       {name:'premise',  header:'条件名称',nullable:false,type:'text'},
	       {name:'premisenote', header:'备注',nullable:false,type:'textarea'}
	     ]
	 });
	}
});

</script>