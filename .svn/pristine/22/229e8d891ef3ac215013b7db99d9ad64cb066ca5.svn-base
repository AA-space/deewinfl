<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>   
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_guarantee_equip_container',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    isNeedTools:currentIsNeedTools,
	    tools:'新增|修改|删除',
	    datas:JsonUtil.decode('${empty json_contract_guarantee_equip_str ? "[]" : json_contract_guarantee_equip_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'eqipname',  header:'抵质押物名称',nullable:false,mapping:'eqipname'},
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
	       {name:'equipinvoice',  header:'发票号',nullable:true,mapping:'equipinvoice'},
	       {name:'totalprice',  header:'发票金额',nullable:false,type:'double',mapping:'totalprice'},
	       {name:'presentvalue',  header:'现值',nullable:false,type:'double',mapping:'presentvalue'},
	       {name:'equipguaranteetype',  header:'抵押方式',nullable:true,type:'combobox',mapping:'equipguaranteetype',
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
   			
	       {name:'notaryflag',  header:'是否抵押公证',mapping:'notaryflag',nullable:true,type:'combobox',config:{
			       width:165,
			       xmlFileName:'\\combos\\comboDict.xml',
			       loadMode:'local',
			       readOnly:true,
			       displayField:'name',
			       valueField:'code',
			       datas:[{name:'是',code:'是'},{name:'否',code:'否'}]
    		       }},
	       {name:'recordmech',  header:'登记机关',nullable:true,mapping:'recordmech'},
	       {name:'purchaselife',  header:'购买年限',nullable:false,type:'number',mapping:'purchaselife'},
	       {name:'cgenote',  header:'备注',type:'textarea'}
	     ]
	 });
	 
});

</script>