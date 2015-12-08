<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>   
<script>
jQuery(function(){
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_guarantee_method_container',
	    width:formWidth,
	    height:250,
	    isFit:true,
	    tools:'新增|修改|删除',
	    isNeedTools:false,
	    datas:JsonUtil.decode('${empty json_contract_guarantee_method_str ? "[]" : json_contract_guarantee_method_str }'),
	    columns:[
	       {name:'idold',header:'id',hidden:true},
	       {name:'assurornameold', header:'担保单位',nullable:false,type:'combobox',hiddenName:'assurorold',
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
		   {name:'assurorold', header:'担保单位id',hidden:true},
	       {name:'assuremethodnameold', header:'担保类型',nullable:false,type:'combobox',mapping:'assuremethodnameold',hiddenName:'assuremethodold',
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
		   {name:'assuremethodold', header:'担保类型id',hidden:true},
	       {name:'assurerelationnameold',  header:'关系',nullable:false,type:'combobox',mapping:'assurerelationnameold',hiddenName:'assurerelationold',
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
   			{name:'assurerelationold', header:'关系id',hidden:true},
	       {name:'cgmnoteold',  header:'备注',type:'textarea'}
	     ]
	 });
});

</script>