<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>    
<script>
jQuery(function(){
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_equip_container',
	    width:formWidth,
	    height:350,
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    datas:JsonUtil.decode('${empty json_contract_equip_str ? "[]" : json_contract_equip_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'eqipid',  header:'设备序号',nullable:false},
	       {name:'eqipname',  header:'设备名称',nullable:false,readOnly:false},
	       {name:'model',  header:'规格型号',nullable:false},
	       {name:'equipnum',  header:'数量',nullable:false,type:'number',defaultValue:1},
	       {name:'total',  header:'设备原值',nullable:false,type:'double'/*,otherAttributes:" onpropertychange='document.all.price.value=document.all.equip_num.value*this.value' "*/},
	       {name:'nowtotal',  header:'设备现值',nullable:false,type:'double'},
	       {name:'saleprice',  header:'交易价格',nullable:false,type:'double'},
	       {name:'brand',  header:'品牌',nullable:false},
	       {name:'vndrname', header:'供应商',nullable:false,type:'combobox',defaultRawValue:'',hiddenName:'vndr',
			    config:{
				       width:165,
				       xmlFileName:'\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
				       loadMode:'ajax',
				       readOnly:false,
				       isAjaxLenovo:true,
				       displayField:'name',
				       valueField:'code'
		   }},
		   {name:'vndr', header:'供应商id',hidden:true},
	       {name:'manufacturername',  header:'制造商',nullable:false,type:'combobox',hiddenName:'manufacturer',
			    config:{
			       width:165,
			       xmlFileName:'\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
			       loadMode:'ajax',
			       readOnly:false,
			       isAjaxLenovo:true,
			       displayField:'name',
			       valueField:'code'
   			}},
   			{name:'manufacturer', header:'制造商id',hidden:true},
   			{name:'devicetypename',  header:'设备类型',type:'combobox',defaultRawValue:'',nullable:false,hiddenName:'devicetype',
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
		   {name:'devicetype', header:'设备类型id',hidden:true},
	       {name:'equipdeliveryplace',  header:'交付地点',nullable:false},
	       {name:'equipdeliverydate',  header:'交付时间',nullable:false,type:'date'},
	       {name:'equipplace',  header:'设备设置地址',nullable:false},
	       {name:'cenote', header:'备注',type:'textarea'}
	     ]
	 });
});

</script>
