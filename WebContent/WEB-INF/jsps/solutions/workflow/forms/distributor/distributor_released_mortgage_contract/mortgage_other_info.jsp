
<%---经销商抵押合同事宜办理的一个多行控件 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script> 
jQuery(function(){
	   var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_mortgage_info_container',
	    width:formWidth,
	    isAutoBreakContent:true,
	    height:200,
	    tools:'新增|修改|删除',
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    datas:JsonUtil.decode('${empty json_mortgage_info_str ? "[]" : json_mortgage_info_str }'),
	    columns:[
/* 	       {name:'id',  header:'id',hidden:true},
	       {name:'appaddr', header:'办理地',type:'text'},
	       {name:'guaranteenum',  header:'抵押登记申请表', type:'text'},
	       {name:'regcode', header:'组织机构代码证',type:'text'},
	       {name:'guaranteedocnum',  header:'抵押合同', type:'text'},
	       {name:'entrustnormalnum', header:'授权委托书标准版',type:'text'},
	       {name:'entrustnum', header:'授权委托书通用版',type:'text'},   
	       {name:'otherdoc', header:'其他材料',type:'text'},
	       {name:'status', header:'状态',type:'text',defaultValue:'解除抵押'} */
	       
	       {name:'id',  header:'id', hidden:true},
	       {name:'appaddr', header:'办理地',type:'text'},
	       {name:'guaranteenum',  header:'抵押登记申请表', type:'number',defaultValue:'0', otherAttributes:'label="抵押登记申请表"'},
	       {name:'regcode', header:'组织机构代码证',type:'number',defaultValue:'0', otherAttributes:'label="组织机构代码证"'},
	       {name:'guaranteedocnum',  header:'抵押合同', type:'number',defaultValue:'0', otherAttributes:'label="抵押合同"'},
	       {name:'entrustnormalnum', header:'授权委托书标准版',type:'number',defaultValue:'0', otherAttributes:'label="授权委托书标准版"'},
	       {name:'entrustnum', header:'授权委托书通用版',type:'number',defaultValue:'0', otherAttributes:'label="授权委托书通用版"'},
	       {name:'otherdoc', header:'其他材料',type:'text'},
	       {name:'status', header:'状态',type:'text',defaultValue:'解除抵押',readOnly:true}   
	       
	     ]
	 });
});

</script>