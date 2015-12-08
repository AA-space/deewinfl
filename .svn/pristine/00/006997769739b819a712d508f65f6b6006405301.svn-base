<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	//alert(jQuery("#contractid").val());
		new tracywindyMultiTable({
		    renderTo:'id_table_leasing_contract_limit_list',
		    //id:'id_table_leasing_contract_limit_list',
		    loadMode:'ajax',
		    width:formWidth,
		    tools:'',
		    height:350,
		    xmlFileName:'\\eleasing\\workflow\\contract\\contract_put_limit_list.xml',
		    isFit:true,
		    params:{
			contractnumber:jQuery("#contractid").val()
		    },
		    columns:[
	               {name:'id',  header:'id',hidden:true},
			       {name:'custname',  header:'客户名'},
			       {name:'dealername',  header:'经销商名称'},
			       {name:'contractid',  header:'合同编号'},
			       {name:'limitmoney',  header:'合同限额'},
			       {name:'createdate',  header:'申请日期'}
		     ]
		 });
		
});
</script>