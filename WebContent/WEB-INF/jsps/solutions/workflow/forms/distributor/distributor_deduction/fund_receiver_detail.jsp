<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
    <script>
    jQuery(function(){
    	 var currentIsNeedTools = true;
    	    
    	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	    	currentIsNeedTools = false;
    	    }
    		new tracywindyMultiTable({
    		    renderTo:'id_table_fund_fund_plan_history_container',
    		    width:formWidth,
    		    isFit:true,
    		    isNeedTools:currentIsNeedTools,
    		    tools:' ',
    		    lazyLoad:true,
	    datas:JsonUtil.decode('${empty json_fund_receiver_detail_str ? "[]" : json_fund_receiver_detail_str }'),
	    columns:[
	               {name:'id',  header:'id',hidden:true},
			       {name:'rawValue_feetype',  header:'费用类型',nullable:false},
			       {name:'factmoney',  header:'实收金额',nullable:false,type:'double'},
			       {name:'deductionmoney',  header:'抵扣金额',nullable:false,type:'double'},
			       {name:'drawbackmoney',  header:'退款金额',nullable:false,type:'double'},
			       {name:'crwmoney',  header:'红冲金额',nullable:false,type:'double'},
			       {name:'overmoney',  header:'保证金余额',nullable:false,type:'double'},
			       {name:'factdate',  header:'到账时间',nullable:false},
			       {name:'ffcmemo', header:'备注',type:'textarea'},
			       {name:'creator',  header:'输入人'},
			       {name:'createdate',  header:'输入日期'}
	     ]
	 });
   });

   </script>