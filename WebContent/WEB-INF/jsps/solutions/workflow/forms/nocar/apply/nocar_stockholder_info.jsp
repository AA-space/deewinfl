<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script> 
jQuery(function(){
	   var currentIsNeedTools = false;

	   //isViewHistoryTask =false;
 
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_stockholder_info_container',
	    width:formWidth,
	    height:200,
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    //isCheck:false,
	    //isRank:false,
	     datas:JsonUtil.decode('${empty json_stockholder_info_str ? "[]" : json_stockholder_info_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'stockholdername', header:'股东'},
	       {name:'shareholding',  header:'股权比例 '}
	     ]
	 });
});

</script>