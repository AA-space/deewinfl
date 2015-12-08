<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!--合同文件清单 -->
<script>
function downloadFile(Id)
{
  attachmentDown({returnType:'file',url:"${pageContext.request.contextPath}/leasing/template/downLoadAttachById.action?id="+Id});
} 
function showOperator(value,tableObj,columnName,columnIndex,rowData){
     var base = "<a href='javascript:void(0);' onclick='showRecorder(\""+rowData.id+"\")'>记录</a>";
     var base2 = "<a href='javascript:void(0);' onclick='downloadFile(\""+rowData.id+"\")'>下载</a>";
     var base3 = "<a href='javascript:void(0);' onclick='editoverdue(\""+rowData.id+"\")'>编辑</a>";
     //return base2+"&nbsp;&nbsp;|&nbsp;&nbsp;"+base3; 
     return base3;
  }
 
 function editoverdue(id){
 	var currentPageClientWidth  =  document.documentElement.clientWidth;
 	var currentPageClientHeight =  document.documentElement.clientHeight;
 	//status=0 只能打印 
 	openFullScreenWindow(getRootPath()+'/leasing/common/templateManager/editWordTemplate.bi',{id:id,status:0});
 	//window.open (getRootPath()+'/leasing/common/templateManager/editWordTemplate.bi?id='+id,'newwindow',"resizable=true,top=0,left=0") ;
 }
function showContractFile(value,tableObj,columnName,columnIndex,rowData){
    var base = "<a href='#' onclick='downloadContractWordUploadFile(\""+$("#projid").val()+"/"+rowData.wordaddress+"\",\""+rowData.wordtemplatename+"\")'>{1}</a>{2}";
    var separator = "&nbsp;&nbsp;";
    var updateFlag=value;
    var updateClickFunc="other";
    var field=base.replace("{1}",updateFlag).replace("{2}",separator);
       return field;
    }
function downloadContractWordUploadFile(fileAddress,wordName)
{
   if(null==window.attachmentFileUploadloadMask)
   {
      attachmentFileUploadloadMask = new tracywindyLoadMask(document.body,"操作进行中 请稍等...");
       createAttachmentFileContainers();
    }
   attachmentFileUploadloadMask.show();
   var newAction = getRootPath()+"/leasing/word/downLoadContractAttach.action?browserType="+SysBrowser.getBrowser().toLowerCase();
   newAction+="&fileAddress="+fileAddress+"&wordName="+wordName;
   uploadAttachmentFileFormSubmit(newAction);
   attachmentFileUploadloadMask.hide();
} 
jQuery(function(){
		    var currentIsNeedTools = true;
		    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
		    	currentIsNeedTools = false;
		    }
		    new tracywindyMultiTable({
		    renderTo:'id_table_leasing_contract_list_container',
		    width:formWidth,
		    height:350,
		    tools:'删除',
		    isNeedTools:currentIsNeedTools,
		    isFit:true,
		    datas:JsonUtil.decode('${empty json_contract_list_str ? "[]" : json_contract_list_str }'),
		    columns:[
		       {name:'id',  header:'id',type:'text',hidden:true},
		       {header:'文件名称',name:'filename'},
		       {header:'操作',name:'create',renderer:showOperator}
		     ]
		 	});
			// 全选 
			$('#inputCheck').click(function() { 
				$("input[name='contract_word_list_check_box']").attr("checked", $(this).attr("checked")); 
			}); 
			//反选 
			$("#select_reverse").click(function() { 
				$("input[name='contract_word_list_check_box']").each(function(idx, item) { 
				$(item).attr("checked", !$(item).attr("checked")); 
				}) 
			}); 
});
</script>