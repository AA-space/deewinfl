<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_fund_charge_container',
	    width:formWidth,
	    height:350,
	    tools:'修改',
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    datas:JsonUtil.decode('${empty json_contract_fund_charge_str ? "[]" : json_contract_fund_charge_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'docid',  header:'docid',hidden:true},
	       {name:'contractid',  header:'合同号',nullable:false,readOnly:true},
	       {name:'paymentid',  header:'编号',nullable:false,readOnly:true},
	       {name:'plandate',  header:'计划收款日期',nullable:false,readOnly:true,type:'date'},
	       {name:'planmoney',  header:'金额',nullable:false,type:'double'},
	       {name:'feetype',  header:'款项名称',nullable:false,readOnly:false,type:'combobox',
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
	       {name:'paytype',  header:'收付方向',nullable:false,readOnly:false,type:'combobox',
			   config:{
			       width:165,
			       xmlFileName:'\\combos\\comboDict.xml',
			       loadMode:'ajax',
			       readOnly:true,
			       displayField:'name',
			       valueField:'code',
			       params:{
			          pid:'pay_type'
			       } 
		       }
	       },
	       {name:'payobj',  header:'收付对象',nullable:false,readOnly:false,type:'combobox',
		    	config:{
			       width:165,
			       xmlFileName:'\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
			       loadMode:'ajax',
			       readOnly:false,
			       isAjaxLenovo:true,
			       displayField:'name',
			       valueField:'code',
			       params:{
			       } 
	       		}
		    },
	       {name:'fpnote', header:'备注',type:'textarea'}
	     ]
	 });
});
function  createFundChargePlan(returnResult){
	//alert("资金计划重组");
	var fundChargePlan = getTracywindyObject('table_id_table_leasing_contract_fund_charge_container');
	fundChargePlan.tableData = JsonUtil.decode(returnResult)['fundchargeplan'];
	fundChargePlan.reload();
}
</script>