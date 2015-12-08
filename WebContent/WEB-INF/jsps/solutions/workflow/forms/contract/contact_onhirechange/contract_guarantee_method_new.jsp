<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>   
<script>
jQuery(function(){
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_guarantee_method_container_new',
	    width:formWidth,
	    height:250,
	    isFit:true,
	    tools:'新增|修改|删除',
	    isNeedTools:true,
	    datas:JsonUtil.decode('${empty json_contract_guarantee_method_new_str ? "[]" : json_contract_guarantee_method_new_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'assurorname', header:'担保单位',nullable:false,type:'combobox',hiddenName:'assuror',
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
		   {name:'assuror', header:'担保单位id',hidden:true},
	       {name:'assuremethodname', header:'担保类型',nullable:false,type:'combobox',mapping:'assuremethodname',hiddenName:'assuremethod',
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
		   {name:'assuremethod', header:'担保类型id',hidden:true},
	       {name:'assurerelationname',  header:'关系',nullable:false,type:'combobox',mapping:'assurerelationname',hiddenName:'assurerelation',
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
   			{name:'assurerelation', header:'关系id',hidden:true},
	       {name:'cgmnote',  header:'备注',type:'textarea'}
	     ]
	 });
});

</script>