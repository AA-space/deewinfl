<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
 
<script>
jQuery(function(){
	if(isSubTable){
	    var columns = [
	        	       {name:'id',  header:'id',hidden:true},
	        	       {name:'pid',  header:'pid',hidden:true},
	        	       {name:'fundfundchargeplan',  header:'fundfundchargeplan',hidden:true},
	        	       {name:'feeadjust',  header:'feeadjust',hidden:true, defaultValue : 0.00},
	                   {name:'rollback',  header:'rollback',hidden:true},
	        	       //{name:'orderid',  header:'序号',nullable:false,type:'number'},
	        	       {name:'paymentid',  header:'投放编号',nullable:false,readOnly:true},
	        	       {name:'factobject',  header:'付款人名称',nullable:false,readOnly:false},
	        	       {name:'custname',  header:'客户名称',nullable:false},
	        	       {name:'contractid',  header:'合同号',hidden:true,nullable:false,readOnly:true},
	        	       //{name:'contractnumber',  header:'融资租赁合同号',nullable:false,readOnly:true},
	        	       //{name:'tablename12',  header:'台数',nullable:false,type:'double'},
	        	        {name:'settlemethod',  header:'settlemethodid', hidden :true},
	        	        {name:'feetype',  header:'feetypeId', hidden :true},
	        		 	{name:'rawValue_feetype',  header:'付款名目',nullable:false,type:'combobox',hiddenName:'feetype',
	        			    	   config:{
	        					       width:165,
	        					       xmlFileName:'\\combos\\comboDict.xml',
	        					       loadMode:'ajax',
	        					       readOnly:true,
	        					       displayField:'name',
	        					       valueField:'code',
	        					       params:{
	        					          pid:'FeeType'
	        					       } 
	        					   }
	        			       }, 
	        	      // {name:'tablename13',  header:'付款名目',nullable:false,type:'double'},
	        	       //{name:'tablename14',  header:'应收首付款',nullable:false,type:'double'},
	        	       {name:'planfirstpayment',  header:'应收首付款',readOnly:true},
	        	       {name:'factfirstmoney',  header:'实收首付款',readOnly:true},
	        	       {name:'equipcount',  header:'台数',nullable:false},
	        	       {name:'equipmoney',  header:'设备款',nullable:false},
	        	       {name:'factmoney',  header:'电汇金额',nullable:false},
	        	       {name:'creditmoney',  header:'放车额度',readOnly:true,nullable:false,otherAttributes:'id="id_creditmoney" onkeyup="comptuerCurMoney()"'},
	        	       //{name:'factdate',  header:'付款时间', type:'date'},
	        	       {name:'clientbank',  header:'客户银行'},
	        	       {name:'clientaccount',  header:'客户账户'},
	        	       {name:'clientaccnumber',  header:'客户账号'},
	        	       {name:'servicefees',  header:' 综合服务费',otherAttributes:'id="id_servicefees"'}
	        	     ];
	    
	    var _tools = '修改|删除';
	    //是否填写开户行和账号
	    var currentIsNeedTools = true;
	    if(isNeedBank){
	    	if(isNeedBankEdit){
		    	for ( var int = 0; int < columns.length; int++) {
					if(!columns[int]['readOnly']){
						columns[int]['readOnly'] = true;
					}
				}
	    		currentIsNeedTools = true;
	    		_tools = '修改';
	    	}
	    	columns.push({name:'accountbank',  header:'开户行户名称',nullable:false}, {name:'accnumber',  header:'账号',nullable:false});
	    }
	    
	    
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_fund_payment_now_container',
	    width:document.documentElement.clientWidth-2,
	    height:350,
	    tools:_tools,
	    isFit:true,
	    isNeedTools:currentIsNeedTools,
	    updateFromOperCallBack:function(operType,thisForm,me,rowData){
	    	 if(operType=="update"){
		    	 //默认付款日期为周三，超过为下周三
	    		 /*var day=new Date();
	    		 var num1=(3-day.getDay()+7)%7;
	    		 var wed = new Date(day.getTime() + 1000 * 60 * 60 * 24 * num1);
	    		 var factday=wed.getFullYear()+"-"+(wed.getMonth()+1)+"-"+wed.getDate();
		    	 thisForm["factdate"].value=factday;*/
	    	 }
	 	},
	    datas:JsonUtil.decode('${empty json_contract_fund_payment_now_str ? "[]" : json_contract_fund_payment_now_str }'),
	    columns:columns
	 });
	}
});



function comptuerCurMoney(){
    var creditmoney=$('#id_creditmoney');
    var servicefees=$('#id_servicefees');
    var tempservice=parseFloat(creditmoney.val()||0)*0.026;
    servicefees.val(tempservice.toFixed(2));
}


</script>