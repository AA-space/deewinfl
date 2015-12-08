<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_fund_charge_container_pay',
	    width:formWidth,
	    height:350,
	    tools:'新增|修改|删除',
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    datas:JsonUtil.decode('${empty json_contract_fund_charge_str ? "[]" : json_contract_fund_charge_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'planid',  header:'编号',nullable:false},
	       {name:'feetype',  header:'款项名称',nullable:false,readOnly:false,
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
	       {name:'plandate',  header:'计划收款日期',nullable:false,readOnly:false,type:'date'},
	       {name:'planmoney',  header:'金额',nullable:false,type:'double'},
	       {name:'payobj',  header:'付款对象',nullable:false,readOnly:false,type:'combobox',
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

</script>