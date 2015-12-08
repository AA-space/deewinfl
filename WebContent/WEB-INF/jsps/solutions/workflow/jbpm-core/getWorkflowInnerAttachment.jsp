<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<div id="id_toggle_tabs_attachment"><!--页签2开始-->
	<div class="x-panel-table-div-title" >附件上传</div>
	<div id="id_workflowAttachmentContainer"></div>
 </div>
 <script type="text/javascript">
    function loadWorkflowAttachment()
    {
        var infoFlag = "attachment";
		if(lazyLoadedObj[infoFlag]){
			return true;
		}
		var workflowAttachmentContainer = "id_workflowAttachmentContainer";
		var module = "WorkflowAttchmentFiles";
		if(!window.initFileListParams){
			tracywindyAttachmentFileUpload({
	                  renderTo:'id_workflowAttachmentContainer',
	                  module:'WorkflowAttchmentFiles',
	                  id:'id_customworkflowattachment',
	                  batchDownloadAttachmentFileTitle:window.assignBatchDownloadAttachmentFileTitle||"${requestScope['proj_info.custname']}",
	                  //attachmentFileDictListImplBeanName:'commonAttachmentFileDictList',
	                  attachmentType:window.assignAttachmentTypeIds||'${currentTaskActivityDetailInfo.attachmentTypeIds}',
	                  identifierOne:window.assignAttachmentKeyOne||"${currentProcessInstanceDBID}",
	                  identifierTwo:window.assignAttachmentKeyTwo||jQuery("#id_currentHistoryTaskInfo_keyOne").val(),
	                  identifierThree:window.assignAttachmentKeyThree||jQuery("#id_currentHistoryTaskInfo_keyTwo").val(),
	                  identifierFour:window.assignAttachmentKeyFour||jQuery("#id_currentHistoryTaskInfo_keyThree").val(),
	                  identifierFive:window.assignAttachmentKeyFive||jQuery("#id_currentHistoryTaskInfo_keyFour").val(),
	                  identifierSix:window.assignAttachmentKeySix||jQuery("#id_currentHistoryTaskInfo_keyFive").val(),
	                  identifierSeven:window.assignAttachmentKeySeven||jQuery("#id_currentHistoryTaskInfo_keySix").val(),
	                  identifierEight:window.assignAttachmentKeyEight||jQuery("#id_currentHistoryTaskInfo_keySeven").val(),
	                  identifierNine:window.assignAttachmentKeyNine||jQuery("#id_currentHistoryTaskInfo_keyEight").val(),
	                  identifierTen:window.assignAttachmentKeyTen||jQuery("#id_currentHistoryTaskInfo_keyNine").val(),
	                  width:all_width-13,
	                  height:all_height-containerWidthAdd-142,
	                  isReadOnly:window.isCompletedTask||window.assignAttachmentIsReadOnly||false,
	                  border:true,
	                  displayToggleContainer:"id_toggle_tabs_attachment",
	                  checkedKey:'isAttachmentChecked'
	      });
		}else{
			window.initFileListParams();
		}

    }
    var checkAttachmentInfoFunc = function(){return true;};
 </script>
 <c:if test="${'true' eq currentTaskIsAttachmentChecked}">
     <script type='text/javascript'>
	    checkAttachmentInfoFunc = function(){
	        if(!lazyLoadedObj["attachment"]){
	            alert("由于此流程步骤需要检查附件完整性，请点击附件一览确认附件完整性，确认无误后再进行提交！");
	            return false;
	        }
		    var attachmentTable    = getTracywindyObject("id_customworkflowattachment");
		    var attachmentRowsJsonArrayData = attachmentTable.getRowsData();
		    {//检查附件
				  var checkedKey = attachmentTable.checkedKey;
				  for(var i=0;i< attachmentRowsJsonArrayData.length;i++){
					  var attachmentRowData = attachmentRowsJsonArrayData[i];
					  var attachmentFileDictFileName = attachmentRowData["attachmentFileDictFileName"] ;
					  var fileListUUIDStr = attachmentRowData["attachmentFileUploadInfoDetailIds"] ;
					  var currentIsAttachmentChecked = attachmentRowData[checkedKey] ;
					  if("true" == (currentIsAttachmentChecked+"")){
						  if(attachmentTable.checkAttachmentInfoFuncCallback){
					    	  isPassed = attachmentTable.checkAttachmentInfoFuncCallback(attachmentFileDictFileName,fileListUUIDStr,attachmentRowData,attachmentTable); 
                              if(false == isPassed){
                                  return isPassed;
                              }
						   }else{
						        if(!fileListUUIDStr)
						        {
							        alert(attachmentFileDictFileName+"必需上传附件");
						            return false;
						        }
						  }
					  }
			      }
		   }
		   return true;
	    };
     </script>
 </c:if>