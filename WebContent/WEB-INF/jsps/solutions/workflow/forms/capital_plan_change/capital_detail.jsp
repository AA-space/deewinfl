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
	       {name:'paymentid',  header:'付款编号',nullable:false,readOnly:false,mapping:'eqipname'},
	       {name:'contractid',  header:'合同编号',type:'double'},
	       {name:'feetype',  header:'款项名称',nullable:false,type:'double' ,mapping:'equipnum',defaultValue:1},
	       {name:'plandate',  header:'计划收付日期',nullable:false,type:'date'/*,otherAttributes:" onpropertychange='document.all.price.value=document.all.equip_num.value*this.value' "*/},
	       {name:'planmoney',  header:'计划金额',nullable:false,type:'double'},
	       {name:'payobj',  header:'付款对象',nullable:false,type:'double'},
	       {name:'paytype',  header:'付款类型'},
	       {name:'factmoney', header:'已收金额',type:'double',defaultRawValue:''},
	       {name:'fund_astatus',  header:'收款状态',type:'double'},
	       {name:'fpnote',  header:'备注'}
	      
	     ]
	 });
});

</script>