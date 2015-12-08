<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
jQuery(function(){
		seajs.use("js/apcomponent/aptable/aptable.js",function(ApTable){
			new ApTable({
				id:"table_leasing_invoice_this_apply_container",
				    renderTo:'id_table_leasing_invoice_this_apply_container',
				    height:formHeight,
				    width:formWidth,
				     pageSize:20,
				   showPager:false,
				   hiddenQueryArea : true,
				    showFooter:true,
				    showToolbar:true,
					multiSelect : false,//是否可以多选，true多选，false为单选,
				  tools : ['edit', '-',{
				    	html:"取消开票",
				    	plain:true,
				    	iconCls:"icon-redo",
				    	handler : function(miniTable, buttonText) {//按钮响应函数
							var selectedRowDatas = miniTable.getSelecteds ();//多选的数据，推荐使用，无选择时返回空数组对象[]
							//alert("您选取的数据是:" + mini.encode(selectedRowDatas));//被选择的列的数据，数组对象
							miniTable.removeRows(selectedRowDatas,false);
							mini.get("table_leasing_dealer_invoice_container").addRows(selectedRowDatas,0) ;
						}
				    }],
				   // tools:'新增|复制|修改|删除',
				   data:mini.decode('${empty id_json_dealer_invoice_this_apply_str ? "[]" : id_json_dealer_invoice_this_apply_str }'),
				   columns:[
		                       { type : 'indexcolumn'},/*数字列*/
		                       {type:'checkcolumn'},
		                       {field:'custname', header:'承租人',formEditorConfig:{
				  	    		required : true,
				  	    		readOnly:true
				  	    	   }
				  	    	   },
				  	    	 {field:'contractnumber', header:'融资租赁合同号',formEditorConfig:{
				  	    		required : true,
				  	    		readOnly:true
				  	    	   }
				  	    	   },
				  	    	 {header:'购货单位(人)',field:'purchaseunit',nullable:false,formEditorConfig:{
						  			newLine:true,
						  			required : true
						  		 }},
					  	    		{header:'身份证号码/组织机构代码',field:'idcard',nullable:false,width:100,formEditorConfig : {
							  			labelWidth:160,
							  			required : true
						  	    		//readOnly:true,
							  		 }},
							  		{header:'机动车辆生产企业名称',field:'carname',nullable:false,formEditorConfig:{
							  			newLine:true,
							  			required:true
							  		 }},
							  
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


</script>
