<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_proj_guarantee_equip_container',
	    width:formWidth,
	    isAutoHeight:true,
	    isFit:true,
	    isNeedTools:currentIsNeedTools,
	    tools:'新增|修改|删除',
	    datas:JsonUtil.decode('${empty json_proj_guarantee_equip_str ? "[]" : json_proj_guarantee_equip_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'eqipname',  header:'抵质押物名称',nullable:false},
	       {name:'guarantor', header:'抵质押人',nullable:false,type:'combobox',
			    config:{
				       width:165,
				       xmlFileName:'\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
				       loadMode:'ajax',
				       readOnly:false,
				       isAjaxLenovo:true,
				       displayField:'name',
				       valueField:'code',
				       params:{
	    	  				custType:'cust_type.guarantor'
				       } 
		   }},
	       {name:'equipinvoice',  header:'发票号',nullable:true},
	       {name:'totalprice',  header:'发票金额',nullable:false,type:'double'},
	       {name:'presentvalue',  header:'现值',nullable:false,type:'double'},
	       {name:'equipguaranteetype',  header:'抵押方式',nullable:true,type:'combobox',
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
   			
	       {name:'notaryflag',  header:'是否抵押公证',nullable:true,type:'combobox',config:{
			       width:165,
			       loadMode:'local',
			       readOnly:true,
			       displayField:'name',
			       valueField:'code',
			       datas:[{name:'是',code:'0'},{name:'否',code:'1'}]
    		       }},
	       {name:'recordmech',  header:'登记机关',nullable:true},
	       {name:'purchaselife',  header:'购买年限',nullable:false,type:'number'},
	       {name:'cgenote',  header:'备注',type:'textarea'}
	     ]
	 });
	 
});

</script>