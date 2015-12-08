<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
//isViewHistoryTask = false;
jQuery(function(){
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_invoice_apply_container',
	    width:formWidth,
	    height:formHeight,
	    isAutoHeight:true,
	    isRemoteSortable:false,
	    //isShowCopyCount:true,
	    // isNeedTools:currentIsNeedTools,
	    isFit:true,
	    tools:'',
	    datas:JsonUtil.decode('${empty json_dealer_invoice_apply_str ? "[]" : json_dealer_invoice_apply_str }'),
	    columns:[
                {header:'equipid',name:'equipid',hidden:true},
                {name:'equipclassname', header:'车辆分类',type:'combobox',nullable:false,hiddenName:'equipclass',
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
    					    	   if(combo.otherConfig.name=="modelname"){
    					    		   combo.setParams({equipclass:equipclassValue});
    						    	   combo.reload();
    						    	   break;
    						    	}
    						    	
    						   }
    	       			   }
    		   }},
    		   {name:'equipclass', header:'车辆分类id',hidden:true},
    		   {name:'modelname', header:'规格型号',type:'combobox',nullable:false,hiddenName:'model',
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
    			   				
    		   			   }
    		   }},
    		   {name:'model',  header:'规格型号',hidden:true},

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
	  			{name:'manufacturer', header:'制造商id',hidden:true},
				{header:'购货单位(人)',name:'purchaseunit',nullable:false},
				{header:'身份证号码/组织机构代码',name:'idcard',nullable:false,width:100},
				{header:'机动车辆生产企业名称',name:'carname',nullable:false},
				{header:'厂牌型号',name:'brandmodel',nullable:false},
				{header:'合格证号',name:'certificate',nullable:false},
				{header:'进口证明书号',name:'inletcertificate'},
				{header:'发动机号码',name:'motornumber'},
				{header:'产地',name:'locality',nullable:false},
				{header:'商检单号',name:'inspection'},
				{header:'价税合计',name:'pricetotal',nullable:false},
				//{header:'小写',name:'lower'},
				{header:'吨位',name:'tonnage',nullable:false},
				{header:'限乘人数',name:'confinednum'}
				  
	    ]
	 });
	    
});

</script>
