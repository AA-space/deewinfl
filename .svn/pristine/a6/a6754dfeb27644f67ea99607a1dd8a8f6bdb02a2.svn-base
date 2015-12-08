<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	
	function validataTotalMoney(){//验证金额，add by Jason ###蔡雅超8-15改
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
				alert("【租赁物明细】标签的合计总价["+ totalPrice + "]和【拟商务条件】标签中的设备款["+ equipAmt +"]不相等,请检查.");
				return false;
			} else{
				return true;
			}    
		}else{
			alert("您修改过商务条件中的值且未进行过测算!");
			return false;
		}
	}
</script>    
<script>
function AdjustMoney(){//算出差额
	var differential_swap=$("#id_differential_swap");
	var purchaseprice=$("#id_purchaseprice").val();
	var saleprice=$("#id_saleprice").val();
	purchaseprice=purchaseprice||0;
	saleprice=saleprice||0;
	var temp=parseFloat(saleprice)-parseFloat(purchaseprice);
	$("#id_differential_swap").val(temp.toFixed(2));
}
function AdjustTotal(){//算出总价
	var differential_swap=$("#id_nowtotal");
	var equipnum=$("#id_equipnum").val();
	var saleprice=$("#id_saleprice").val();
	equipnum=equipnum||0;
	saleprice=saleprice||0;
	var temp=parseFloat(saleprice)*parseFloat(equipnum);
	$("#id_nowtotal").val(temp.toFixed(2));
}
jQuery(function(){
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	//currentIsNeedTools = false;
	    }
	    var equipclassname="";
	    var equiptypename ="";
	    var modelname     = "";
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_proj_equip_container',
	    width:formWidth,
	    isAutoHeight:true,          
	    isAutoHeight:true,     
	    isNeedTools:currentIsNeedTools,
	    isFit:false,
	    tools:'修改',  
	    updateFromOperCallBack:function(operType,thisForm,me,rowData){
	    	 if(operType=="update"){
				  for(var i=0;i<me.comboboxs.length;i++){
			    	   var combo =me.comboboxs[i];
			    	   if(combo.otherConfig.name=="equipclassname"){
			    		   equipclassname=rowData["equipclass"];//combo.getValue();
				       }
			    	   if(combo.otherConfig.name=="equiptypename"){
			    		   equiptypename = rowData["equiptype"];
			    		   combo.setParams({equipclass:equipclassname});
			    		   combo.value=equiptypename;
				    	   combo.reload();
				       }
			    	   if(combo.otherConfig.name=="modelname"){
			    		   modelname = rowData["model"];
			    		   combo.setParams({equipclass:equipclassname,equiptype:equiptypename});
			    		   combo.value=modelname;
				    	   combo.reload();
				       }
				   }
			  }
	    },
	    operValidate:function(operType,rowDatas,thisForm,me){
		  if(operType=="add"){
			  for(var i=0;i<me.comboboxs.length;i++){
		    	   var combo =me.comboboxs[i];
		    	   if(combo.otherConfig.name=="equiptypename"){
			    	   combo.setParams({equipclass:'1'});
			    	   combo.reload();
			       }
		    	   if(combo.otherConfig.name=="modelname"){
		    		   combo.setParams({equipclass:'1',equiptype:'1'});
			    	   combo.reload();
			       }
			   }
		  }
          return true;  
	    },
	    datas:JsonUtil.decode('${empty json_proj_equip_str ? "[]" : json_proj_equip_str }'),
	    columns:[
	       {name:'id', header:'id',hidden:true},
	       {name:'projid', header:'projid',hidden:true},
	       {name:'equipclassname', header:'车辆分类',type:'combobox',nullable:false,hiddenName:'equipclass',readOnly:true,
			    config:{
			    	   //id:'id_combobox_equipclassname',
				       width:165,
				       xmlFileName:'\\eleasing\\workflow\\proj_approval\\equipClassSelect.xml',
				       loadMode:'ajax',
				       readOnly:false,
				       isAjaxLenovo:true,
				       displayField:'name',
				       valueField:'code',
				       isForceModify:true,
				       otherConfig:{
							  name:'equipclassname',
							  hiddenName:'equipclass'
		   			   },
				       onSelected:function(combo,rowData,me,columnConfig){
	    	   			   var equipclassValue  = combo.getValue();
				    	   for(var i=0;i<me.comboboxs.length;i++){
					    	   var combo =me.comboboxs[i];
					    	   if(combo.otherConfig.name=="equiptypename"){
						    	   combo.setParams({equipclass:equipclassValue});
						    	   combo.reload();
						       }
					    	   if(combo.otherConfig.name=="modelname"){
					    		   combo.setParams({equipclass:'1',equiptype:'1'});
						    	   combo.reload();
						       }
							   //2013-11-29 14:44 当车辆类型为挂车时 ’车架号‘和’合同小号‘ 不验证  equip_class_2（挂车）
								if(equipclassValue=="equip_class_2"){
									 $("#id_equipcontractnum").attr("require","false");
									 $("#id_chassisnum").attr("require","false");
								}else{
								     $("#id_equipcontractnum").attr("require","true").attr("label","车辆合同小号");
									 $("#id_chassisnum").attr("require","true").attr("label","车架号");
								}
						   }
	       			   }
		   }},
		   {name:'equipclass', header:'车辆分类id',hidden:true},
		   /*{name:'equiptypename', header:'车辆类别',type:'combobox',nullable:false,hiddenName:'equiptype',readOnly:true,
			    config:{
			    	   //id:'id_combobox_equiptypename',
				       width:165,
				       xmlFileName:'\\eleasing\\workflow\\proj_approval\\equipTypeSelect.xml',
				       loadMode:'ajax',
				       readOnly:false,
				       isAjaxLenovo:true,
				       displayField:'name',
				       valueField:'code',
				       isForceModify:true,
				       params:{
			   				//equipclass:'1'
		   			   },
		   			   otherConfig:{
							  name:'equiptypename',
							  hiddenName:'equiptype'
		   			   },
		   			   onSelected:function(combo,rowData,me,columnConfig){
	    	   			   var equipclassValue;
	    	   			   var equiptypeValue  = combo.getValue();
				    	   for(var i=0;i<me.comboboxs.length;i++){
					    	   var combo =me.comboboxs[i];
					    	   if(combo.otherConfig.name=="equipclassname"){
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
					    	   if(combo.otherConfig.name=="modelname"){
					    		   combo.setParams({equipclass:equipclassValue,equiptype:equiptypeValue});
						    	   combo.reload();
						    	   break;
						    	}
						   }
	       			   }
		   }},*/
		   {name:'equiptype', header:'车辆型号id',hidden:true},
		   {name:'modelname', header:'规格型号',type:'combobox',nullable:false,hiddenName:'model',readOnly:true,
			    config:{
				       width:165,
				       xmlFileName:'\\eleasing\\workflow\\proj_approval\\equipModelSelect.xml',
				       loadMode:'ajax',
				       readOnly:false,
				       isAjaxLenovo:true,
				       displayField:'name',
				       valueField:'code',
				       isForceModify:true,
				       otherConfig:{
							  name:'modelname',
							  hiddenName:'model'
		   			   },
				       params:{
			   				//equipclass:'1',
			   				//equiptype:'1'
		   			   }
		   }},
		   {name:'model',  header:'规格型号',hidden:true},
		   {name:'equipcontractnum',  header:'车辆合同小号',nullable:false,otherAttributes:'maxB="100" id="id_equipcontractnum"'},
		   {name:'chassisnum',  header:'车架号',nullable:false,otherAttributes:'maxB="100" id="id_chassisnum"'},
		   {name:'garagedate',  header:'入库时间',type:'date',readOnly:true},
		   {name:'saledate',  header:'已售时间',type:'date',readOnly:true},
		   {name:'equipnum',  header:'数量',type:'number',hidden:true,defaultValue:1,otherAttributes:'id="id_equipnum" onkeyup="AdjustTotal()"',readOnly:true},
		   {name:'saleprice',  header:'销售价',type:'double',nullable:false,otherAttributes:'id="id_saleprice" onkeyup="AdjustTotal()" onkeyup="AdjustMoney()"',readOnly:true},
		   {name:'purchaseprice',  header:'采购价',type:'double',nullable:false,otherAttributes:'id="id_purchaseprice" onkeyup="AdjustMoney()"',readOnly:true}, 
		   {name:'differential_swap',  header:'差额[销售价-采购价]',type:'double',nullable:false,otherAttributes:'id="id_differential_swap"',readOnly:true,width:160},
		   {name:'purchasetax',  header:'购置税',hidden:true,type:'double'},
		   {name:'insuremoney',  header:'保费',hidden:true,type:'double'},
		   {name:'leasingmoney',  header:'其他融资额',hidden:true,type:'double'},
	       {name:'devicetypename',  header:'设备类型',type:'combobox',defaultRawValue:'',nullable:false,hiddenName:'devicetype',readOnly:true,
			    config:{
			       width:165,
			       xmlFileName:'\\combos\\comboDict.xml',
			       loadMode:'ajax',
			       readOnly:true,
			       displayField:'name',
			       valueField:'code',
			       isForceModify:true,
			       params:{
			          pid:'device_type'
			       } 
			}},
			{name:'devicetype', header:'设备类型id',hidden:true},
	       {name:'nowtotal',  header:'总价[数量*销售价]',nullable:false,otherAttributes:'id="id_nowtotal"',readOnly:true,width:130,type:'double'},
	       {name:'manufacturername',  header:'制造商',type:'combobox',nullable:false,hiddenName:'manufacturer',readOnly:true,
			    config:{
			       width:165,
			       xmlFileName : '\\eleasing\\workflow\\public\\SimpleCustSelectForManufacturer.xml',
			       loadMode:'ajax',
			       readOnly:false,
			       isAjaxLenovo:true,
			       displayField:'name',
			       valueField:'id',
			       isForceModify:true,
			       params:{
			    	    cust_class_m:"1",
			   			cust_class1:'CUST_INFO_COMPANY',
			   			cust_class2:'CUST_INFO_PERSON',
			  			cust_type:'cust_type.manufacturer',
			  			cust_dealer_id:"${sessionScope['currentDealerCustInfoId']}"
			       } 
  			}},
  		   {name:'manufacturer', header:'制造商id',hidden:true}, 
	       {name:'equipdeliveryplace',  header:'交付地点',nullable:true,otherAttributes:'maxB="2000"',readOnly:true},
	       {name:'equipdeliverydate',  header:'交付时间',type:'date',nullable:true,readOnly:true},
	       {name:'cenote', header:'备注',type:'textarea',otherAttributes:'maxB="2000"',readOnly:true}
	     ]
	 });
});
		

</script>