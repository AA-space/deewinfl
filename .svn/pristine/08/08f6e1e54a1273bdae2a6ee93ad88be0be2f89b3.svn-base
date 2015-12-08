<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_proj_equip_container',
	    width:formWidth,
	    height:350,
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    datas:JsonUtil.decode('${empty json_proj_equip_str ? "[]" : json_proj_equip_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'equip_name',  header:'设备名称',nullable:false},
	       {name:'model',  header:'规格型号'},
	       {name:'equip_num',  header:'数量',nullable:false,type:'number',defaultValue:1},
	       {name:'original_value',  header:'设备原值',nullable:false,type:'double'},
	       {name:'present_value',  header:'设备现值',nullable:false,type:'double'},
	       {name:'price',  header:'交易价格',nullable:false,type:'double'},
	       {name:'brand',  header:'品牌'},
	       {name:'supplier', header:'供应商',nullable:false,type:'combobox',defaultRawValue:'',
			    config:{
				       width:165,
				       xmlFileName:'\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
				       loadMode:'ajax',
				       readOnly:false,
				       isAjaxLenovo:true,
				       displayField:'name',
				       valueField:'code'
		   }},
	       {name:'manufacturer',  header:'制造商',nullable:false,type:'combobox',
			    config:{
			       width:165,
			       xmlFileName:'\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
			       loadMode:'ajax',
			       readOnly:false,
			       isAjaxLenovo:true,
			       displayField:'name',
			       valueField:'code'
   			}},
	       {name:'device_type',  header:'设备类型',nullable:false,type:'combobox',
			    config:{
			       width:165,
			       xmlFileName:'\\combos\\comboDict.xml',
			       loadMode:'ajax',
			       readOnly:true,
			       displayField:'name',
			       valueField:'code',
			       params:{
			          pid:'device_type'
			       } 
			}},
	       {name:'equip_id',  header:'设备序号'},
	       {name:'equip_delivery_place',nullable:true,  header:'交付地点'},
	       {name:'equip_delivery_date',  header:'交付时间',nullable:true,type:'date'},
	       {name:'equip_place',  header:'设备设置地址'},
	       {name:'memo', header:'备注',type:'textarea'}
	     ]
	 });
});


</script>