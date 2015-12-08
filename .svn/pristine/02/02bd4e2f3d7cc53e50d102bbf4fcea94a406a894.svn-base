<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!--合同文件清单 -->
<script>
jQuery(function(){
		    var currentIsNeedTools = true;
		    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
		    	currentIsNeedTools = false;
		    }
		    new tracywindyMultiTable({
		    renderTo:'id_table_word_list_container',
		    width:formWidth,
		    height:350,
		    tools:'删除',
		    isNeedTools:currentIsNeedTools,
		    isFit:true,
		    datas:JsonUtil.decode('${empty json_word_list_str ? "[]" : json_word_list_str }'),
		    columns:[
		       {name:'id',  header:'id',hidden:true},
		       {name:'templatename',  header:'协议类型',type:'text'},
		       {name:'templateshowname',  header:'协议文本',type:'text'},
		       {name:'filename',  header:'操作',type:'text', renderer:showContractFile}
		     ]
		 	});
});

</script>