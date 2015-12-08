<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script language="javascript">

	function checkLimit() {
		var currentTable1 = getTracywindyObject('table_id_table_limit_container');
		var tabledata = currentTable1.getRowsData();
		if (tabledata.length > 0) {
			for ( var i = 0; i < tabledata.length; i++) {
				if(typeof tabledata[i]['limitmoney'] == 'undefined'){
					loadMask_oper.hide();
					jQuery.messager.alert('错误提示', "<div style='font-size:18px;line-height:30px;'>请选择投放额度！</div>", 'error');
					return false;
				}
			}
			return true;
		}
	}
    jQuery(function(){	
    	
    	var limitJason = [];
    	if('${json_fund_limit_str}'){//后台带出数据，适用于企划添加
    		
    		limitJason = JsonUtil.decode('${empty json_fund_limit_str ? "[]" : json_fund_limit_str }');
    	
    	} else{//前台导出，适用于经销商
    		
    	}
    	
    	new tracywindyMultiTable({
	    renderTo:'id_table_limit_container',
	    width:formWidth,
	    height:450,
	    isFit:true,
	    tools:'删除|修改',
	    //isNeedTools:currentIsNeedTools,
	    datas:limitJason,
	    columns:[
	       {name:'id',  header:'uuid',hidden:true},
	       {name:'dealername', header:'经销商名称',readOnly:true},
	       {name:'custname', header:'客户名称',readOnly:true},
		   {name:'contractname', header:'合同号',readOnly:true},
		   {name:'contractid', header:'合同id',hidden:true},
		   {name:'limitmoney', header:'额度金额',type:'double',nullable:false}
	     ]
	 });

   });

   </script>