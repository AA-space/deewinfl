<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_proj_guarantee_equip_container',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    isNeedTools:currentIsNeedTools,
	    tools:'新增|修改|删除',
	    datas:JsonUtil.decode('${empty json_proj_guarantee_equip_str ? "[]" : json_proj_guarantee_equip_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'equip_name',  header:'抵质押物名称',nullable:false},
	       {name:'guarantor', header:'抵质押人',nullable:false,type:'combobox',
			    config:{
				       width:165,
				       xmlFileName:'\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
				       loadMode:'ajax',
				       readOnly:false,
				       isAjaxLenovo:true,
				       displayField:'name',
				       valueField:'code',
				       /*init:function(combo,currentTable,multiTable){
		               },
				       onSelected:function(multiTable,columnConfig){
		               },*/
				       params:{
				          //pid:'assure_method'
				       } 
		   }},
	       {name:'equip_invoice',  header:'发票号',nullable:true},
	       {name:'total_price',  header:'发票金额',nullable:false,type:'double'},
	       {name:'present_value',  header:'现值',nullable:false,type:'double'},
	       {name:'equip_guarantee_type',  header:'抵押方式',nullable:true,type:'combobox',
			    config:{
			       width:165,
			       xmlFileName:'\\combos\\comboDict.xml',
			       loadMode:'ajax',
			       readOnly:true,
			       displayField:'name',
			       valueField:'code',
			       params:{
			          pid:'guarantee_type'
			       } 
   			}},
   			
	       {name:'notary_flag',  header:'是否抵押公证',nullable:true,type:'combobox',config:{
			       width:165,
			       xmlFileName:'\\combos\\comboDict.xml',
			       loadMode:'local',
			       readOnly:true,
			       displayField:'name',
			       valueField:'code',
			       datas:[{name:'是',code:'是'},{name:'否',code:'否'}]
    		       }},
	       {name:'record_mech',  header:'登记机关',nullable:true},
	       {name:'purchase_life',  header:'购买年限',nullable:false,type:'number'},
	       {name:'pgenote',  header:'备注',type:'textarea'}
	     ]
	 });
	 
});

</script>