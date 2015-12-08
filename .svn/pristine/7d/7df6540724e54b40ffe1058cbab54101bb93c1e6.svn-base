<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_deposit_in_container',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    isNeedTools:false,
		   // isNeedTools:currentIsNeedTools,
		    //tools:'新增|修改|删除',
	    datas:JsonUtil.decode('${empty json_current_regulating_of_breathing_str ? "[]" : json_current_regulating_of_breathing_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'paymentid',  header:'合同编号',nullable:false},
	       {name:'paytype',  header:'客户编号',nullable:false},
	       {name:'plandate',  header:'客户名称',nullable:false},
	       {name:'planmoney',  header:'项目编号',nullable:false},
	       {name:'receivermoney',  header:'项目名称',nullable:false},
	       {name:'planmoneystatus',  header:'利率浮动类型', hidden:true},
  	       {name:'rawValue_planmoneystatus',  header:'利率调整值'},
  	       {name:'rawValue_planmoneystatus',  header:'调息方式'},
  	   	   {name:'rawValue_planmoneystatus',  header:'测算时间'},
  	       {name:'rawValue_planmoneystatus',  header:'调息前后'}
  	 
   	     ]
	 });
	 
});

</script>