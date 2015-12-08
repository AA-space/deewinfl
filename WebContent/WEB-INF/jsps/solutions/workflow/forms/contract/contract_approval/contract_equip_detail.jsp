<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	function validataTotalMoney() {//验证金额，add by Jason
		if (chenckCondiotn) {
			//计算租赁物的总交易价格
			var currentTable1 = getTracywindyObject('table_id_table_leasing_contract_equip_container');
			var data = currentTable1.tableData;
			var totalPrice = 0;
			for ( var i = 0; i < data.length; i++) {
				totalPrice += parseFloat(data[i]['nowtotal']);
			}
			//计算商务条件的设备款
			var equipAmt = parseFloat($("#equipAmt").val());
			totalPrice = totalPrice.toFixed(2);
			equipAmt = equipAmt.toFixed(2);
			if (totalPrice != equipAmt) {//如果不相等，则跳出执行
				alert("__tag_16$11_标签的合计交易价格和__tag_16$28_标签中的设备款不相等,请检查.");
				return false;
			} else {
				return true;
			}
		} else {
			alert("您修改过商务条件中的值且未进行过测算!");
			return false;
		}
	}	
</script>
<script>
	function AdjustMoney() {//算出差额
		var differential_swap = $("#id_differential_swap");
		var purchaseprice = $("#id_purchaseprice").val();
		var saleprice = $("#id_saleprice").val();
		purchaseprice = purchaseprice || 0;
		saleprice = saleprice || 0;
		temp = parseFloat(saleprice) - parseFloat(purchaseprice);
		$("#id_differential_swap").val(temp.toFixed(2));
	}
	function AdjustTotal() {//算出总价
		var differential_swap = $("#id_nowtotal");
		var equipnum = $("#id_equipnum").val();
		var saleprice = $("#id_saleprice").val();
		equipnum = equipnum || 0;
		saleprice = saleprice || 0;
		temp = parseFloat(saleprice) * parseFloat(equipnum);
		$("#id_nowtotal").val(temp.toFixed(2));
	}
	jQuery(function() {
		var currentIsNeedTools = false;
		new tracywindyMultiTable(
				{
					renderTo : 'id_table_leasing_contract_equip_container',
					width : formWidth,
					isAutoHeight:true,
					isAutoHeight : true,
					isNeedTools : currentIsNeedTools,
					isFit : false,
					datas : JsonUtil
							.decode('${empty json_contract_equip_str ? "[]" : json_contract_equip_str }'),
							 columns:[
								       {name:'id', header:'id',otherAttributes:'id="id_equip"',hidden:true},
								       {name:'projid', header:'projid',hidden:true},
								       {name:'equipclassname', header:'车辆分类',type:'combobox',readOnly:true,nullable:false,hiddenName:'equipclass',
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
												    	  /*  if(combo.otherConfig.name=="equiptypename"){
													    	   combo.setParams({equipclass:equipclassValue});
													    	   combo.reload();
													       }
												    	   if(combo.otherConfig.name=="modelname"){
												    		   combo.setParams({equipclass:'1',equiptype:'1'});
													    	   combo.reload();
													       } */
													       
												    	   if(combo.otherConfig.name=="modelname"){
												    		   combo.setParams({equipclass:equipclassValue});
													    	   combo.reload();
													    	   break;
													    	}
													   }
								       			   }
									   }},
									   {name:'equipclass', header:'车辆分类id',hidden:true},
									/*    {name:'equiptypename', header:'车辆类别',type:'combobox',readOnly:true,nullable:false,hiddenName:'equiptype',
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
									   }},
									   {name:'equiptype', header:'车辆型号id',hidden:true}, */
									   {name:'modelname', header:'规格型号',type:'combobox',readOnly:false,nullable:false,hiddenName:'model',
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
									   {name:'equipcontractnum',  header:'车辆合同小号',otherAttributes:'maxB="20"'},
									   {name:'chassisnum',  header:'车架号',otherAttributes:'maxB="10"'},
									   {name:'garagedate',  header:'入库时间',type:'date',readOnly:true},
									   {name:'saledate',  header:'已售时间',type:'date',readOnly:true},
									   {name:'equipnum',  header:'数量',type:'number',readOnly:true,hidden:true,defaultValue:1,otherAttributes:'id="id_equipnum" onkeyup="AdjustTotal()"'},
									   {name:'saleprice',  header:'销售价',type:'double',nullable:false,otherAttributes:'id="id_saleprice" onkeyup="AdjustTotal()" onkeyup="AdjustMoney()"'},
									   {name:'purchaseprice',  header:'采购价',type:'double',readOnly:true,nullable:false,otherAttributes:'id="id_purchaseprice" onkeyup="AdjustMoney()"'}, 
									   {name:'differential_swap',  header:'差额[销售价-采购价]',type:'double',nullable:false,otherAttributes:'id="id_differential_swap"',readOnly:true,width:160},
									   {name:'purchasetax',  header:'购置税',hidden:true,type:'double',defaultValue:'0',otherAttributes:'id="id_purchasetax" onkeyup="AdjustTotal()"'},
									   {name:'insuremoney',  header:'保费',hidden:true,type:'double',defaultValue:'0',otherAttributes:'id="id_insuremoney" onkeyup="AdjustTotal()"'},
									   {name:'leasingmoney',  header:'其他融资额',hidden:true,type:'double',defaultValue:'0',otherAttributes:'id="id_leasingmoney" onkeyup="AdjustTotal()"'},
								       {name:'devicetypename',  header:'设备类型',type:'combobox',readOnly:true,defaultRawValue:'',nullable:false,hiddenName:'devicetype',
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
								       {name:'nowtotal',  header:'总计',nullable:false,otherAttributes:'id="id_nowtotal"',readOnly:true,width:130,type:'double'},
								       {name:'manufacturername',  header:'制造商',readOnly:true,type:'combobox',nullable:false,hiddenName:'manufacturer',
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
							  			{header:'是否挂靠',name:'isaffiliatedname',type:'combobox',hiddenName:'isaffiliated',otherAttributes:'id="id_isaffiliated"',
								            config:{
							  				width:165,
											isNewLine:true,
											colSpan:3, 
											loadMode:'local',
											datas:[{title:'是',name:'0'},{title:'否',name:'1'}],
								            displayField:'title',
								            valueField:'name',
								            defaultValue:1,
								            value:'1',
								            
								            onSelected:function(combo,rowData,me,columnConfig){
							 	   			   var isAffiliated;
							 	   			   var isAffiliated  = combo.getValue();
											   if(isAffiliated=='1'){
													$("#id_affiliatedinfo").hide();
													$("#id_affiliatedinfo").parent().parent().hide();
													$("#id_affiliatedinfo").attr("require","false").attr("sytle","display:none");
													
											   }else{
												    $("#id_affiliatedinfo").show();
													$("#id_affiliatedinfo").parent().parent().show();
													$("#id_affiliatedinfo").attr("require","true").attr("label","挂靠信息").attr("style","display:inline");
											   }
							  				},
								  			otherConfig:{name:'isaffiliated'}
								            }
								           
							            },
							           {name:'isaffiliated', header:'是否挂靠id',hidden:true},
							  		   {name:'affiliatedinfo', header:"挂靠信息",type:'textarea',otherAttributes:'maxB="2000" id="id_affiliatedinfo"'},
							  		   {name:'manufacturer', header:'制造商id',readOnly:true,hidden:true},    
								       {name:'equipdeliveryplace',  header:'交付地点',nullable:true,otherAttributes:'maxB="2000"'},
								       {name:'equipdeliverydate',  header:'预计交付时间',type:'date',nullable:true},
								       {name:'cenote', header:'备注',type:'textarea',otherAttributes:'maxB="2000"'}
								     ]
				});
	});
</script>