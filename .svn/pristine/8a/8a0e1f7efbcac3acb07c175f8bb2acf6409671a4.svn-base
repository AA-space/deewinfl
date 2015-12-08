<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script> 
jQuery(function(){
	    var currentIsNeedTools = false;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_fund_receive_history_container',
	    width:formWidth,
	    height:350,
	    tools:'新增|修改|删除',
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    //datas:JsonUtil.decode('${empty json_contract_fund_charge_str ? "[]" : json_contract_fund_charge_str }'),
	    datas:JsonUtil.decode('${empty json_contract_fund_receive_history_str ? "[]" : json_contract_fund_receive_history_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'contractid',  header:'编号',nullable:false},
	       {name:'ebankNumber',  header:'网银编号',nullable:false},
	       {name:'feetype',  header:'费用类型',nullable:false},
	       {name:'settlemethod',  header:'结算方式',nullable:false},
	       {name:'factdate',  header:'到账时间',nullable:false},
	       {name:'factmoney',  header:'金额',nullable:false},
	       {name:'feeadjust',  header:'调整金额',nullable:false},
	       {name:'accountbank',  header:'银行',nullable:false},
	       {name:'account',  header:'银行账户',nullable:false},
	       {name:'accnumber',  header:'银行账号',nullable:false},
	       {name:'factobject',  header:'付款客户',nullable:false},
	       {name:'clientbank',  header:'客户银行',nullable:false},
	       {name:'clientaccount',  header:'客户账户',nullable:false},
	       {name:'clientaccnumber',  header:'客户账号',nullable:false},
	       {name:'accountingdate',  header:'会计处理日',nullable:false},
	       {name:'invoiceno',  header:'单据号',nullable:false},
	       {name:'ffcmemo', header:'备注',type:'textarea'},
	       //{name:'feeType',  header:'款项名称',nullable:false,readOnly:false,
		   //   config:{
		   //       width:165,
		   //       xmlFileName:'\\combos\\comboDict.xml',
		   //	    loadMode:'ajax',
		   //       readOnly:true,
		   //       displayField:'name',
		   //       valueField:'code',
		   //       params:{
		   //       pid:'FeeType'
		   //     } 
		   //  }
	       //},
	       {name:'creator',  header:'输入人',nullable:false},
	       {name:'createdate',  header:'输入日期',nullable:false,readOnly:false,type:'date'}
	       //{name:'payObj',  header:'付款对象',nullable:false,readOnly:false,type:'combobox',
		   // 	config:{
		   //	       width:165,
		   //	       xmlFileName:'\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
		   //	       loadMode:'ajax',
		   //	       readOnly:false,
		   //	       isAjaxLenovo:true,
		   //	       displayField:'name',
		   //	       valueField:'code',
		   //	       params:{
		   //	       } 
	       //  		}
		   //  },
	       
	     ]
	 });
});
</script>