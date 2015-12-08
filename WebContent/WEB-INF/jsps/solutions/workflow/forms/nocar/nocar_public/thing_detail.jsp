<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>    
<script>
function validataTotalMoney(){//验证金额，add by Jason
	if(chenckCondiotn){
		//计算租赁物的总交易价格
		var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');
		var data = currentTable1.tableData;
		var totalPrice = 0;
		for(var i=0;i<data.length;i++){
			totalPrice += parseFloat(data[i]['nowtotal']);
		}
		//计算商务条件的设备款
		var equipAmt = parseFloat($("#equipAmt").val());
		if(totalPrice !=  equipAmt){//如果不相等，则跳出执行
			alert("【租赁物明细】标签的合计交易价["+ totalPrice + "]和【拟商务条件】标签中的设备款["+ equipAmt +"]不相等,请检查.");
			return false;
		} else{
			return true;
		}
	}else{
		alert("您修改过商务条件中的值且未进行过测算!");
		return false;
	}
}

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
	    isFit:false,
	    datas:JsonUtil.decode('${empty json_proj_equip_str ? "[]" : json_proj_equip_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'eqipid',  header:'设备序号',nullable:false},
	       {name:'eqipname',  header:'设备名称',nullable:false,readOnly:false},
	       {name:'model',  header:'规格型号',nullable:false},
	       {name:'equipnum',  header:'数量',nullable:false,type:'number',defaultValue:1},
	       {name:'total',  header:'设备原值',nullable:false,type:'double'/*,otherAttributes:" onpropertychange='document.all.price.value=document.all.equip_num.value*this.value' "*/},
	       {name:'saleprice',  header:'设备现值',nullable:false,type:'double'},
	       {name:'nowtotal',  header:'交易价',nullable:false,type:'double',width:220},
	       {name:'brand',  header:'品牌',nullable:false},
	       {name:'vndrname', header:'供应商',nullable:false,type:'combobox',defaultRawValue:'',hiddenName:'vndr',
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
				    	   custType:'cust_type.vndr'
				       } 
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
			       valueField:'code',
			       params:{
			    	   custType:'cust_type.manufacturer'
			       }
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
	       {name:'cenote', header:'备注',type:'textarea',width:150}
	     ]
	 });
});

</script>
