<%---项目担保页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_proj_guarantee_method_container',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    tools:'新增|修改|删除',
	    isNeedTools:currentIsNeedTools,
	    datas:JsonUtil.decode('${empty json_proj_guarantee_method_str ? "[]" : json_proj_guarantee_method_str }'),
	    columns:[
	       {name:'id',  header:'uuid',hidden:true},
	       {name:'assuror', header:'担保单位',nullable:false,type:'combobox',
			    config:{
				       width:165,
				       xmlFileName:'\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
				       loadMode:'ajax',
				       readOnly:true,
				       displayField:'name',
				       valueField:'code',
				       params:{
	    	   				custType:'cust_type.assuror'
				       } 
		   }},
	       {name:'assuremethod', header:'担保类型',nullable:false,type:'combobox',
			    config:{
				       width:165,
				       xmlFileName:'\\combos\\comboDict.xml',
				       loadMode:'ajax',
				       readOnly:true,
				       displayField:'name',
				       valueField:'code',
				       params:{
				          pid:'assure_method'
				       } 
		   }},
	       {name:'assurerelation',  header:'关系',nullable:false,type:'combobox',
			    config:{
			       width:165,
			       xmlFileName:'\\combos\\comboDict.xml',
			       loadMode:'ajax',
			       readOnly:true,
			       displayField:'name',
			       valueField:'code',
			       params:{
			          pid:'relation'
			       } 
   			}},
	       {name:'cgmnote',  header:'备注',type:'textarea'}
	     ]
	 });
});

</script>