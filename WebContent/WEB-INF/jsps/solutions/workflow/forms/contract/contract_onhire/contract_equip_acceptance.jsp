<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_equip_acceptance_container',
	    width:formWidth,
	    height:350,
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    datas:JsonUtil.decode('${empty json_equip_acceptance_str ? "[]" : json_equip_acceptance_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       //{name:'',  header:'编号',nullable:false,readOnly:false},
	       {name:'accepttype',  header:'验收类型',type:'double'},
	       {name:'acceptdate',  header:'验收日期',nullable:false,type:'date'},
	       {name:'ecmemo',  header:'备注',
			    config:{
				       width:165,
				       xmlFileName:'\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
				       loadMode:'ajax',
				       readOnly:false,
				       isAjaxLenovo:true,
				       displayField:'name',
				       valueField:'code'
		   }}
	      
	     ]
	 });
});

</script>