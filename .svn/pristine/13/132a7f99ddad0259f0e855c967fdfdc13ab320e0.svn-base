<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	//isViewHistoryTask = false;
    var currentIsNeedTools = true;
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_fund_limit_add_id',
	    width:formWidth,
	    height:450,
	    isFit:true,
	    tools:'新增|修改|删除',
	    isNeedTools:currentIsNeedTools,
	    datas:JsonUtil.decode('${empty json_fund_limit_str ? "[]" : json_fund_limit_str }'),
		updateFromOperCallBack:function(operType,thisForm,multiTable,rowData){
			for(var i=0;i<multiTable.comboboxs.length;i++){
				var combo = multiTable.comboboxs[i];
				if(combo.otherConfig.name=="custname"){
				  	   var cust_dealer_id  = rowData.dealerid;
					   var custid          = rowData["custid"];
					   var loadCompleteFunc = (function(combo,cust_dealer_id,custid){
					   	   return function($combo,rowData){
							   combo.setParams({cust_dealer_id:cust_dealer_id});
							   combo.value = custid;
							   combo.reload();
							   $combo.loadComplete = null;
						   };
					   })(combo,cust_dealer_id,custid);
					   combo.loadComplete = loadCompleteFunc;
			    	   
			      }
				  if(combo.otherConfig.name=="contractnumber"){
				   	   var custid  = rowData.custid;
					   var contractid = rowData["contractid"];
					   var loadCompleteFunc = (function(combo,custid,contractid){
					   	   return function($combo,rowData){
							   combo.setParams({custid:custid});
					    	   combo.value = contractid;
					    	   combo.reload();
							   $combo.loadComplete = null;
						   };
					   })(combo,custid,contractid);
					   combo.loadComplete = loadCompleteFunc;
				   }
			}
		},
	    columns:[
	       {name:'id',  header:'uuid',hidden:true},
	       {name:'dealername', header:'经销商名称',type:'combobox',hiddenName:'dealerid',
			    config:{
				       width:165,
				       xmlFileName:'\\eleasing\\workflow\\public\\SimpleCustSelect.xml',
				       loadMode:'ajax',
				       readOnly:false,
				       isAjaxLenovo:true,
				       displayField:'name',
				       valueField:'id',
				       isForceModify:true,
				       params : {
							cust_class:'CUST_INFO_DEALER',
							cooperate_status:'dealer_symbiosis1'
							
						},
				       otherConfig:{
							  name:'dealername',
							  hiddenName:'dealerid'
		   			   },
		   			onSelected:function(combo,rowData,me,columnConfig){
	    	   			   var cust_dealer_id  = combo.getValue();
				    	   for(var i=0;i< me.comboboxs.length;i++){
					    	   var combo = me.comboboxs[i];
					    	   if(combo.otherConfig.name=="custname"){
						    	   combo.setParams({cust_dealer_id:cust_dealer_id});
						    	   combo.reload();
						       }
						   }
	       			   }
		   }},
		   {name:'dealerid', header:'经销商id',hidden:true},
	       {name:'custname', header:'客户名称',type:'combobox',nullable:false,hiddenName:'custid',
			    config:{
				       width:165,
				       xmlFileName:'\\eleasing\\workflow\\public\\limitCustSelect.xml',
				       loadMode:'ajax',
				       readOnly:false,
				       isAjaxLenovo:true,
				       displayField:'name',
				       valueField:'id',
				       isForceModify:true,
				       otherConfig:{
							  name:'custname',
							  hiddenName:'custid'
		   			   },
					   params:{
					   		cust_dealer_id:""
					   },
				       onSelected:function(combo,rowData,me,columnConfig){
	    	   			   var custid  = combo.getValue();
				    	   for(var i=0;i<me.comboboxs.length;i++){
					    	   var combo =me.comboboxs[i];
					    	   if(combo.otherConfig.name=="contractnumber"){
						    	   combo.setParams({custid:custid});
						    	   combo.reload();
						       }
						   }
	       			   }
		   }},
		   {name:'custid', header:'客户id',hidden:true},
		   {name:'contractname', header:'合同号',type:'combobox',nullable:false,hiddenName:'contractid',
			    config:{
				       width:165,
				       xmlFileName:'\\eleasing\\workflow\\public\\ContractNumSelect.xml',
				       loadMode:'ajax',
				       readOnly:false,
				       isAjaxLenovo:true,
				       displayField:'contractnumber',
				       valueField:'contractid',
				       isForceModify:true,
		   			   otherConfig:{
							  name:'contractnumber',
							  hiddenName:'contractid'
		   			   }
		   }},
		   {name:'contractid', header:'合同id',hidden:true},
		   {name:'limitmoney', header:'额度金额',nullable:false}
	     ]
	 });
});

</script>