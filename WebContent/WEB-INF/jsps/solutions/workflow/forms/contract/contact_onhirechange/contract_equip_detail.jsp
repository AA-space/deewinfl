<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>    
<script>
jQuery(function(){   

    var currentIsNeedTools = false;
    new tracywindyMultiTable({   
    renderTo:'id_table_leasing_contract_equip_container',
    width:formWidth,   
    height:200,     
    isAutoHeight:true,
    isNeedTools:currentIsNeedTools,
    isFit:false,
    datas:JsonUtil.decode('${empty json_contract_equip_str ? "[]" : json_contract_equip_str }'),
    columns:[
       {name:'idold', header:'id',hidden:true},
       {name:'equipclassnameold', header:'车辆分类',type:'combobox',nullable:false,hiddenName:'equipclassold',
		    config:{
		    	   //id:'id_combobox_equipclassname',
			       width:165,
			       xmlFileName:'\\eleasing\\workflow\\proj_approval\\equipClassSelect.xml',
			       loadMode:'ajax',
			       readOnly:false,
			       isAjaxLenovo:true,
			       displayField:'name',
			       valueField:'code',
			       otherConfig:{
						  name:'equipclassnameold',
						  hiddenName:'equipclassold'
	   			   },
			       onSelected:function(combo,rowData,me,columnConfig){
   	   			   var equipclassValue  = combo.getValue();
			    	   for(var i=0;i<me.comboboxs.length;i++){
				    	   var combo =me.comboboxs[i];
				    	   if(combo.otherConfig.name=="equiptypenameold"){
					    	   combo.setParams({equipclass:equipclassValue});
					    	   combo.reload();
					       }
				    	   if(combo.otherConfig.name=="modelnameold"){
				    		   combo.setParams({equipclass:'1',equiptype:'1'});
					    	   combo.reload();
					       }
					   }
      			   }
	   }},
	   {name:'equipclassold', header:'车辆分类id',hidden:true},
	   {name:'equiptypenameold', header:'车辆类别',type:'combobox',nullable:false,hiddenName:'equiptypeold',
		    config:{
		    	   //id:'id_combobox_equiptypename',
			       width:165,
			       xmlFileName:'\\eleasing\\workflow\\proj_approval\\equipTypeSelect.xml',
			       loadMode:'ajax',
			       readOnly:false,
			       isAjaxLenovo:true,
			       displayField:'name',
			       valueField:'code',
			       params:{
		   				equipclass:'1'
	   			   },
	   			   otherConfig:{
						  name:'equiptypenameold',
						  hiddenName:'equiptypeold'
	   			   },
	   			   onSelected:function(combo,rowData,me,columnConfig){
   	   			   var equipclassValue;
   	   			   var equiptypeValue  = combo.getValue();
			    	   for(var i=0;i<me.comboboxs.length;i++){
				    	   var combo =me.comboboxs[i];
				    	   if(combo.otherConfig.name=="equipclassnameold"){
				    		   equipclassValue=combo.getValue();
					    	   break;
					    	}
					   }
					   if(equipclassValue==""){
						   alert("请先选择车辆分类");
					   }
					   if(equiptypeValue==""){
						   alert("请先选择车辆类别");
					   }
					   for(var i=0;i<me.comboboxs.length;i++){
				    	   var combo =me.comboboxs[i];
				    	   if(combo.otherConfig.name=="modelnameold"){
				    		   combo.setParams({equipclass:equipclassValue,equiptype:equiptypeValue});
					    	   combo.reload();
					    	   break;
					    	}
					   }
      			   }
	   }},
	   {name:'equiptypeold', header:'车辆型号id',hidden:true},
	   {name:'modelnameold', header:'规格型号',type:'combobox',nullable:false,hiddenName:'modelold',
		    config:{
			       width:165,
			       xmlFileName:'\\eleasing\\workflow\\proj_approval\\equipModelSelect.xml',
			       loadMode:'ajax',
			       readOnly:false,
			       isAjaxLenovo:true,
			       displayField:'name',
			       valueField:'code',
			       otherConfig:{
						  name:'modelnameold',
						  hiddenName:'modelold'
	   			   },
			       params:{
		   				equipclass:'1',
		   				equiptype:'1'
	   			   }
	   }},
	   {name:'modelold',  header:'规格型号',hidden:true},
	   {name:'equipcontractnumold',  header:'车辆合同小号',nullable:false,otherAttributes:'maxB="20"'},
	   {name:'chassisnumold',  header:'车架号',nullable:false,otherAttributes:'maxB="10"'},
	   {name:'garagedateold',  header:'入库时间',type:'date'},
	   {name:'saledateold',  header:'已售时间',type:'date'},
	   {name:'equipnumold',  header:'数量',type:'number'},
	   {name:'salepriceold',  header:'销售价',type:'double',nullable:false},
	   {name:'purchasepriceold',  header:'采购价',type:'double',nullable:false}, 
	   {name:'differential_swapold',  header:'差额[销售价-采购价]',type:'double',nullable:false,readOnly:true,width:160},
	   {name:'purchasetaxold',  header:'购置税',hidden:true,type:'double',nullable:false},
	   {name:'insuremoneyold',  header:'保费',hidden:true,type:'double',nullable:false},
	   {name:'leasingmoneyold',  header:'其他融资额',hidden:true,type:'double',nullable:false},
       {name:'devicetypeidold',  header:'设备类型',type:'combobox',defaultRawValue:'',nullable:false,hiddenName:'devicetypeold',
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
	   {name:'devicetypeold', header:'设备类型id',hidden:true},
       {name:'nowtotalold',  header:'总价[数量*销售价]',nullable:false,type:'double',readOnly:true,width:130},
       {name:'manufactureridold',  header:'制造商',type:'combobox',nullable:false,hiddenName:'manufacturerold',
		    config:{
		       width:165,
		       xmlFileName:'\\eleasing\\workflow\\public\\SimpleCustSelectForManufacturer.xml',
		       loadMode:'ajax',
		       readOnly:false,
		       isAjaxLenovo:true,
		       displayField:'name',
		       valueField:'code',
		       params:{
		  			custType:'cust_type.manufacturer'
		       } 
			}},
	   {name:'manufacturerold', header:'制造商id',hidden:true},
       {name:'equipdeliveryplaceold',  header:'交付地点',nullable:true,otherAttributes:'maxB="2000"'},
       {name:'equipdeliverydateold',  header:'交付时间',type:'date',nullable:true},
       {name:'cenoteold', header:'备注',type:'textarea',nullable:false,otherAttributes:'maxB="2000"'}
     ]
 });
});

</script>