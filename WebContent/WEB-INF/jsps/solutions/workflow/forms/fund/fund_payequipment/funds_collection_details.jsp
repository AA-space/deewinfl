<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	if(isSubTable){
		var table_proj_fund_rent_plan= new tracywindyTable({
		    renderTo:'id_table_leasing_funds_collection_details',
		    id:'table_leasing_funds_collection_details',
		    loadMode:'local',
		    width:formWidth,
		    height:350,
		    isFit:false,
		    datas:JsonUtil.decode('${empty json_fundfundcharge_str ? "[]" : json_fundfundcharge_str }'),
		    columns:[
	              {name:'id',  header:'id',hidden:true},
			       {name:'paytype',  header:'paytype',hidden:true},
			       {name:'fundfundchargeplan',  header:'fundfundchargeplan',hidden:true},
			       {name:'fundfundchargeplan.paymentId',  header:'收款编号',nullable:false,readOnly:false},
			       {name:'ebanknumber',  header:'网银编号'},
			       {name:'feetype',  header:'费用类型',hidden:true},
			 	     {name:'rawValue_feetype',  header:'费用类型',nullable:false,type:'combobox',hiddenName:'feetype',
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
			       {name:'settlemethod',  header:'settlemethodId',hidden :true},
			 	     {name:'rawValue_settlemethod',  header:'费用类型',nullable:false,type:'combobox',hiddenName:'settlemethod',
			    	   config:{
					       width:165,
					       xmlFileName:'\\combos\\comboDict.xml',
					       loadMode:'ajax',
					       readOnly:true,
					       displayField:'name',
					       valueField:'code',
					       params:{
					          pid:'PayFund'
					       } 
					   }
			       },
			       
			       {name:'factdate',  header:'到账时间',nullable:false},
			       {name:'factmoney',  header:'金额',nullable:false,type:'double'},
			       {name:'feeadjust',  header:'调整金额',nullable:false,type:'double'},
			       {name:'accountbank',  header:'银行'},
			       {name:'account',  header:'银行账户'},
			       {name:'accnumber',  header:'银行账号'},
			       {name:'factobject',  header:'付款客户'},
			       {name:'clientbank',  header:'客户银行'},
			       {name:'clientaccount',  header:'客户账户'},
			       {name:'clientaccnumber',  header:'客户帐号'},
			       {name:'accountingdate',  header:'会计处理日'},
			       {name:'invoiceno',  header:'单据号'},
			       {name:'ffcmemo', header:'备注',type:'textarea'},
			       {name:'creator',  header:'输入人'},
			       {name:'createdate',  header:'输入日期'}
		     ]
		 });
	}
});
</script>