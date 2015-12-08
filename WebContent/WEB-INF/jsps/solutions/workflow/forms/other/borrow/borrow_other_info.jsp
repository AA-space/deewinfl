
<%---借阅的一个多行控件 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script> 
jQuery(function(){
	   var currentIsNeedTools = true;
	   isViewHistoryTask = false;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_borrow_other_container',
	    id:'table_leasing_borrow_other_container',
	    width:formWidth,
	    height:350,
	    tools:'新增|修改|删除',
	    isNeedTools:currentIsNeedTools,
	    isFit:false,
	    datas:JsonUtil.decode('${empty json_borrow_info_str ? "[]" : json_borrow_info_str }'),
	    resetFromOperCallBack:function(operType,thisForm,me){
			/* if(operType=="add"){
				 var borrowuser="${sessionScope.loginUser.realname}";
				 $("#id_borrowuser").val(borrowuser);
			} */
	    },
	    columns:[
	      // {name:'id',  header:'id',hidden:true},
  	     /*   {name:'contractid',  header:'合同编号',nullable:false,type:'combobox',mapping:'accepttype',
			    config:{
			       width:165,
			       xmlFileName:'\\eleasing\\workflow\\public\\comboContractSelect.xml',
			       loadMode:'ajax',
			       readOnly:true,
			       displayField:'name',
			       valueField:'code',
			       params:{
			          pid:'EQUIP_ACCEPTANCE'
			       } 
			}}, */
		/* 	{name:'tablename.column2', header:'业务模式',type:'text',readOnly:true},
	       {name:'tablename.column3', header:'客户名称',type:'text',readOnly:true},
	       {name:'tablename.column4', header:'合同档案名称',type:'text',nullable:false},
	       {name:'tablename.column5', header:'合同对方',type:'text',readOnly:true},
	       {name:'tablename.column6', header:'合同金额（元）',type:'text',readOnly:true},
	       {name:'tablename.column7', header:'标的物详情',type:'text',readOnly:true}, 
	       {name:'tablename.column8',  header:'合同生效日期', type:'date',nullable:false},
	       {name:'tablename.column9', header:'合同份数',type:'text',readOnly:true},
	       {name:'tablename.column10', header:'我方签约人',type:'text',readOnly:true},
	       {name:'tablename.column11', header:'对方签约人',type:'text',readOnly:true},   
	       {name:'tablename.column12', header:'寄送份数',type:'text',readOnly:true},
	       {name:'tablename.column13', header:'快递单号',type:'text',readOnly:true}, */
	       
	       {name:'rowvalue_docname',  header:'合同档案名称',type:'combobox',nullable:false,
		    config:{
		       width:165,
		       xmlFileName:'\\eleasing\\workflow\\contract\\doc_send_info.xml',
		       loadMode:'ajax',
		       readOnly:true,
		       displayField:'rowvalue_docname',
		       valueField:'id',
		       params:{
		          //pid:'EQUIP_ACCEPTANCE'
		          equipAmt:0,
		    	   contract_id: '${empty contract_id ? "": contract_id}'
		       },
		       onSelected:function(combo,rowData,$$me,columnConfig){
		    	   var selectedValue = combo.getValue();
		    	   var $form = jQuery("#"+$$me.windowId+" form");
		    	   for(var p in rowData){
		    		   $form.find("input[name='"+p+"']").val(rowData[p]);
		    		  /// console.info(rowData[p]);
		    	   }
		       }
		    }},
	       {name:'id',  header:'id',hidden:true},
	       {name:'contractid',  header:'contractid',hidden:true},
	       {name:'docname',  header:'docname',hidden:true},
	       //{name:'rowvalue_docname', header:'合同档案名称',readOnly:true},
	       {name:'contractperson', width:70,  header:'合同对方',readOnly:true},
	       {name:'totalprice', width:102,  header:'合同金额',readOnly:true},
	       {name:'docpart', width:70, header:'合同份数',readOnly:true},
	       {name:'contracta', width:120, header:'我方签约人',readOnly:true},
	       {name:'contractb', header:'对方签约人',readOnly:true},
	       {name:'sendpart',  header:'寄送份数',width:50,readOnly:true},
	       {name:'sendno',  header:'快递单号',readOnly:true},
	       {name:'docnumber',  header:'归档号',readOnly:true},
	       {name:'borrowuser',  header:'借阅人',defaultValue:'${sessionScope.loginUser.realname}',otherAttributes:'id="id_borrowuser"'},
	       {name:'datelimit', header:'借阅时间期限(截止日)',type:'date' ,nullable:false},
	       {name:'memo', header:'备注(车驾号及借阅原因)',width:300,type:'textarea',nullable:false,otherAttributes:'maxB="2000"' }
	       /* {name:'borrowuser',  header:'borrowuserid', hidden:true},
	       {name:'rowData_borrowuser', header:'借阅人',nullable:false,type:'combobox',hiddenName:'borrowuser',
			    config:{
				       width:165,
				       xmlFileName:'\\eleasing\\workflow\\public\\creator_combox.xml',
				       loadMode:'ajax',
				       readOnly:true,
				       displayField:'name',
				       valueField:'id',
				       params:{
		            	   custType:'cust_type.assuror'
				       }
		   }}, */
	       /* ,{name:'borrowpart',  header:'二次寄送份数', type :'number'},//,nullable:false
	       {name:'borrowsendno', header:'二次寄送快递单号',type:'text' },
	       {name:'borrowdate', header:'二次寄送时间',type:'date' } */
	       
	     ]
	 });
});

</script>