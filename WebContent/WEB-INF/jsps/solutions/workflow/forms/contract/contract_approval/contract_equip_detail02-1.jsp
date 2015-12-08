<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	var temp_equip=${requestScope['json_proj_equip_str']};
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
			totalPrice = totalPrice.toFixed(2);
			equipAmt = equipAmt.toFixed(2);
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
	//var copydata=jQuery('#id_json_proj_equip_str_copy').val();
    var copydatas=eval(temp_equip);
    /*for(var i=0;i<copydatas.length;i++)
	{
	    if (copydatas[i].id==$("#id_equip").val())
	    {
		    if (parseFloat($("#id_saleprice").val())>parseFloat(copydatas[i].saleprice))
		    {
		    	$("#id_saleprice").val(copydatas[i].saleprice);
			    alert("租赁物单价不能超过之前的单价,请重新输入！");
	             return false;
		    }
	    }
	}*/
	var differential_swap=$("#id_nowtotal");
	var equipnum=$("#id_equipnum").val();
	var saleprice=$("#id_saleprice").val();
	var purchasetax=$("#id_purchasetax").val();
	var insuremoney=$("#id_insuremoney").val();
	var leasingmoney=$("#id_leasingmoney").val();
	equipnum=equipnum||0;
	saleprice=saleprice||0;
	purchasetax=purchasetax||0;
	insuremoney=insuremoney||0;
	leasingmoney=leasingmoney||0;
	//Edit by Jason 2013-11-23 为temp添加var 变成局部变量
	var temp=parseFloat(saleprice)*parseFloat(equipnum)+parseFloat(purchasetax)+parseFloat(insuremoney)+parseFloat(leasingmoney);
	$("#id_nowtotal").val(temp.toFixed(2));
}
/**
* 车架号唯一验证，注:同步ajax。Edit by jason 2012-12-24 22:25:00
*/
function validateChassisnum(chassisnum){//验证车架号信息
	var returnStatus = true;
	var chassisnumArray = [];
	var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');
	var data = currentTable1.tableData;
	for ( var int = 0; int < data.length; int++) {
		if(data[int]['chassisnum']){
			for(var i = 0; i < chassisnumArray.length; i++){//验证当前表单中是否重复
				if(data[int]['chassisnum'] === chassisnumArray[i]){
					alert("本次租赁物列表中车架号["+data[int]['chassisnum']+"]重复,请查证");
					return false;
				};
			}
			
			chassisnumArray.push(String(data[int]['chassisnum']));
		};
	}

	var chassisnum = chassisnumArray.join(",");
	//与数据库中对比
	if(chassisnum){
		var param = {};
		param.chassisnum  = chassisnum;
		$.ajax({
			type : "post",
			url : "leasing/validateChassisnum.action",
			cache : false,
			async : false,
			data : param,
			success : function(data) {
				if( data === 0 || data === '0'){
					
				} else{
					alert("当前车架号与系统中车架号["+data+"]有重复，请查证");
					returnStatus = false;
				};
			}
		});
	}
	return returnStatus;	
}	
jQuery(function(){
	//dictYesOrNoByCode('id_isAffiliated','isAffiliated',1,'','','require="true" label="是否挂靠"');
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	//currentIsNeedTools = false;
	    }
	    var equipclassname="";
	    var equiptypename ="";
	    var modelname     = "";
		var isaffiliated  ="";
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_proj_equip_container',
	    width:formWidth,
	    isAutoHeight:true,
	    isShowCopyCount:true,
	    isNeedTools:currentIsNeedTools,
	    isFit:false,
	    tools:'修改|删除',
	    updateFromOperCallBack:function(operType,thisForm,me,rowData){
	    	 if(operType=="update"){
				  for(var i=0;i<me.comboboxs.length;i++){
			    	   var combo =me.comboboxs[i];
			    	   if(combo.otherConfig.name=="equipclassname"){
			    		   equipclassname=rowData["equipclass"];//combo.getValue();
			    		   //当车辆类型为挂车时 ’车架号‘和’合同小号‘ 不验证  equip_class_2（挂车）
			    		   if(equipclassname=="equip_class_2"){
								 $("#id_equipcontractnum").attr("require","false");
								 $("#id_chassisnum").attr("require","false");
							}else{
							     $("#id_equipcontractnum").attr("require","true").attr("label","车辆合同小号");
								 $("#id_chassisnum").attr("require","true").attr("label","车架号");
							}
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
					   if(combo.otherConfig.name=="isaffiliated"){
					   		isaffiliated = rowData["isaffiliatedname"];
							var affiliatedinfo = $("#id_affiliatedinfo");
							if(isaffiliated == "是"){
								affiliatedinfo.attr("require","true").attr("label","挂靠信息");
								affiliatedinfo.show();
						        affiliatedinfo.parent().parent().show();
							}else{
								affiliatedinfo.hide();
								affiliatedinfo.parent().parent().hide();
							}
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
		   {name:'modelname', header:'规格型号',type:'combobox',readOnly:true,nullable:false,hiddenName:'model',
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
		   {name:'equipcontractnum',  header:'车辆合同小号',otherAttributes:'maxB="20"',otherAttributes:'id="id_equipcontractnum"', nullable:false},
		   {name:'chassisnum',  header:'车架号',readOnly:true,otherAttributes:'maxB="100"',otherAttributes:'id="id_chassisnum"',nullable:false},
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
	       {name:'manufacturername',  header:'制造商',type:'combobox',nullable:false,hiddenName:'manufacturer',
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
  		   {name:'affiliatedinfo', header:"挂靠单位及法人信息",type:'textarea',otherAttributes:'maxB="2000" id="id_affiliatedinfo"'},
  		   {name:'manufacturer', header:'制造商id',readOnly:true,hidden:true},    
	       {name:'equipdeliveryplace',  header:'交付地点',nullable:true,otherAttributes:'maxB="2000"'},
	       {name:'equipdeliverydate',  header:'预计交付时间',type:'date',nullable:true},
	       {name:'cenote', header:'备注',type:'textarea',otherAttributes:'maxB="2000"'}
	     ]
	 });
});
		

</script>
