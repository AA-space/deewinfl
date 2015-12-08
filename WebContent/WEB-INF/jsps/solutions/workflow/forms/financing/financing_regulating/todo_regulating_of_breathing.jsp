<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_deposit_in_container',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    isNeedTools:false,
		   // isNeedTools:currentIsNeedTools,
		    //tools:'新增|修改|删除',
	    datas:JsonUtil.decode('${empty json_todo_regulating_of_breathing_str ? "[]" : json_todo_regulating_of_breathing_str }'),
	    columns:[
	       {name:'id',  header:'id', hidden:true},
	       {name:'custid',  header:'收付类型',hidden:true},
	       {name:'pid',  header:'项目编号',hidden:true},
	       {name:'contractid',  header:'合同编号',nullable:false},
	       {name:'custname',  header:'客户名称',nullable:false},
	       {name:'projname',  header:'项目名称',nullable:false},
	       {name:'projtype',  header:'活动类型', hidden:true},
   	     ]
	 });
	 
});
</script>