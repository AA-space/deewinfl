<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
//isViewHistoryTask = false;
jQuery(function(){
		seajs.use("js/apcomponent/aptable/aptable.js",function(ApTable){
			new ApTable({
				id:"table_leasing_dealer_invoice_container",
				    renderTo:'id_table_leasing_dealer_invoice_container',
				    width:formWidth,
				    height:formHeight,
				  //  pageSize:20,
				    showPager:false, 
				    showFooter:true,
				    showToolbar:true,
				    hiddenQueryArea : true,
				    editFormPopupWindowWidth:580,
					multiSelect : true,//是否可以多选，true多选，false为单选,
				    tools : [ 'edit', '-',{
				    	html:"生成开票",
				    	plain:true,
				    	iconCls:"icon-redo",
				    	handler : function(miniTable, buttonText) {//按钮响应函数
							var selectedRowDatas = miniTable.getSelecteds ();//多选的数据，推荐使用，无选择时返回空数组对象[]
							if(selectedRowDatas.length<=0){
								alert("请选择生成的发票项");
								return;
							}
							/* alert("====");
							for(var i=0;i<selectedRowDatas.length;i++){
								alert("***");
								miniTable.validateRow(mini.encode(selectedRowDatas[i]));
								alert(mini.encode(selectedRowDatas[i]));
								alert(miniTable.isValid());
								if(!miniTable.isValid ()){
									alert("生成发票信息完整!");
									return;
								}
							}
							miniTable.validate();
							if(!miniTable.isValid ()){
								alert("生成发票信息完整!");
								return;
							}
							 for(var i=0;i<selectedRowDatas.length;i++){
								alert("***");
								miniTable.validateRow(mini.encode(selectedRowDatas[i]));
								alert(mini.encode(selectedRowDatas[i]));
								alert(miniTable.isValid());
								if(!miniTable.isValid ()){
									alert("生成发票信息完整!");
									return;
								}
							} */
							
							//alert("您选取的数据是:" + mini.encode(selectedRowDatas));//被选择的列的数据，数组对象
							miniTable.removeRows(selectedRowDatas,false);
							mini.get("table_leasing_invoice_this_apply_container").addRows(selectedRowDatas,0) ;
						}
				    }],
				   // tools:'新增|复制|修改|删除',
				    data:mini.decode('${empty json_dealer_invoice_str ? "[]" : json_dealer_invoice_str }'),
				     columns:[
                       {type:'indexcolumn'},
                       {type:'checkcolumn'},
                       {field:'custname', header:'承租人',formEditorConfig:{
		  	    		required : true
		  	    	   }
		  	    	   },
		  	    	 {field:'contractnumber', header:'融资租赁合同号',formEditorConfig:{
		  	    		required : true
		  	    	   }
		  	    	   },
		  	    	 {header:'购货单位(人)',field:'purchaseunit',nullable:false,formEditorConfig:{
				  			newLine:true,
				  			required : true
				  		 }},
			  	    		{header:'身份证号码/组织机构代码',field:'idcard',nullable:false,width:100,formEditorConfig : {
					  			labelWidth:160,
					  			required : true
					  		 }},
					  		{header:'机动车辆生产企业名称',field:'carname',nullable:false,formEditorConfig:{
					  			newLine:true,
					  			//width:200,
					  			required:true
					  		 }},
					  		/* {field:'manufacturername', header:'制造商',formEditorConfig : {
								type : 'combobox',
								//required : true,
								multiSelect : false,
								readOnly:false,
								//fillFromFieldName : 'model',// 有哪一个combox决定该表单域的值
								valueField : 'id',// table显示值
								textField : 'name',// combox显示值
								//width : 165,
								//labelWidth : 100,
								params : {
									xmlFileName : '\\eleasing\\workflow\\public\\SimpleCustSelectForManufacturer.xml',
									  cust_class_m:"1",
		  					   			cust_class1:'CUST_INFO_COMPANY',
		  					   			cust_class2:'CUST_INFO_PERSON',
		  					  			cust_type:'cust_type.manufacturer',
		  					  			cust_dealer_id:"${sessionScope['currentDealerCustInfoId']}"
								}
			  		   			}
			  		   			}, */
		  				
			  	        {field:'equipid', header:'equipid',visible:false,formEditorConfig:{
			  	    	fieldVisible:false
			  	    	   }},
			  	       {field:'projid', header:'projid',visible:false,formEditorConfig:{
			  	    		fieldVisible:false
		  	    	   }}, 
		  	    	 {field:'ishaveinvoice', header:'是否已开过票',visible:false,formEditorConfig:{
			  	    		fieldVisible:false
		  	    	   }},
			  	       {field:'equipclassname', header:'车辆分类',formEditorConfig : {
							type : 'combobox',
							required : true,
							newLine:true,
							multiSelect : false,
							readOnly:false,
							fillFromFieldName : 'equipclass',// 有哪一个combox决定该表单域的值
							valueField : 'code',// table显示值
							textField : 'name',// combox显示值
							//width : 165,
							//labelWidth : 100,
							params : {
								xmlFileName : '\\eleasing\\workflow\\proj_approval\\equipClassSelect.xml'
							}
			  		   }
		  		   			}, 
			  		 {field:'equipclass', header:'车辆分类id',visible:false,formEditorConfig:{
			  			fieldVisible:false
			  		 }},
			  		{field:'modelname', header:'规格型号',formEditorConfig : {
						type : 'combobox',
						required : true,
						multiSelect : false,
						readOnly:false,
						fillFromFieldName : 'model',// 有哪一个combox决定该表单域的值
						valueField : 'code',// table显示值
						textField : 'name',// combox显示值
						//width : 165,
						//labelWidth : 100,
						params : {
							xmlFileName : '\\eleasing\\workflow\\proj_approval\\equipModelSelect.xml'
						}}
	  		   			},
	  		   			{field:'model',  header:'规格型号',visible:false,formEditorConfig:{
				  			fieldVisible:false
				  		 }},	
				  		{field:'locality',  header:'产地',formEditorConfig:{
				  			newLine:true,
				  			required:true
				  		 }},
	  		   		    
				  		{header:'合格证号',field:'certificate',nullable:false,formEditorConfig:{
				  			required:true
				  		 }},
				  		{header:'进口证明书号',field:'inletcertificate',formEditorConfig:{
				  			newLine:true
				  		 }},
				  		{header:'商检单号',field:'inspection',formEditorConfig:{
				  			required:true
				  		 }},

		  					{header:'发动机号码',field:'motornumber',formEditorConfig:{
		  						newLine:true,
		  						required:true
					  		 }},
	  					
		  		   		{header:'车辆识别代号/车架号码',field:'chassisnum',nullable:false,formEditorConfig:{
		  		   		required:true
				  		 }},
	  					{header:'价税合计',field:'pricetotalupper',nullable:false,formEditorConfig:{
				  			newLine:true,
				  			required:true
				  		 }},
	  					{header:'小写',field:'pricetotal',nullable:false,formEditorConfig:{
	  						type:"float",
	  						required:true
				  		 }},
	  					//{header:'小写',name:'lower'},
	  					{header:'吨位',field:'tonnage',nullable:false,formEditorConfig:{
	  						newLine:true,
	  						type:"float",
	  						required:true
				  		 }},
	  					{header:'限乘人数',field:'confinednum',formEditorConfig:{
				  			type:"number",
				  			required : true
				  		 }}
		  		   			]
			});
			
		});
});
/** jQuery(function(){
	
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_dealer_invoice_container',
	    width:formWidth,
	    height:formHeight,
	    isAutoHeight:true,
	    isRemoteSortable:false,
	    //isShowCopyCount:true,
	    // isNeedTools:currentIsNeedTools,
	    isFit:true,
	    tools:'修改',
	    datas:JsonUtil.decode('${empty json_dealer_invoice_str ? "[]" : json_dealer_invoice_str }'),
	    columns:[
                {header:'equipid',name:'equipid',hidden:true},
                {name:'equipclassname', header:'车辆分类',nullable:false,hiddenName:'equipclass',
    			    config:{
    			    	   //id:'id_combobox_equipclassname',
    				       width:165,
    				       xmlFileName:'\\eleasing\\workflow\\proj_approval\\equipClassSelect.xml',
    				       loadMode:'ajax',
    				       readOnly:true,
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

    		   {name:'devicetypename',  header:'设备类型',defaultRawValue:'',nullable:false,hiddenName:'devicetype',
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

				{name:'manufacturername',  header:'制造商',nullable:false,hiddenName:'manufacturer',
				    config:{
				       width:165,
				       xmlFileName : '\\eleasing\\workflow\\public\\SimpleCustSelectForManufacturer.xml',
				       loadMode:'ajax',
				       readOnly:true,
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
	    
}); */

</script>
