<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <script type="text/javascript">
 jQuery(function() {
		 if(isSubTable){
			tracywindyAttachmentFileUpload({
		                  renderTo:'id_table_leasing_rent_plan_attachment',
		                  module:'rentUpdateAgreement',
		                  attachmentType:'rent_Update_agreement',
		                  identifierOne:window.assignAttachmentKeyOne||jQuery("#id_currentHistoryTaskInfo_keyOne").val(),
		                  identifierTwo:window.assignAttachmentKeyTwo||jQuery("#id_currentHistoryTaskInfo_keyTwo").val(),
		                  identifierThree:window.assignAttachmentKeyThree||jQuery("#id_currentHistoryTaskInfo_keyThree").val(),
		                  identifierFour:window.assignAttachmentKeyFour||jQuery("#id_currentHistoryTaskInfo_keyFour").val(),
		                  identifierFive:window.assignAttachmentKeyFive||jQuery("#id_currentHistoryTaskInfo_keyFive").val(),
		                  identifierSix:window.assignAttachmentKeySix||jQuery("#id_currentHistoryTaskInfo_keySix").val(),
		                  identifierSeven:window.assignAttachmentKeySeven||jQuery("#id_currentHistoryTaskInfo_keySeven").val(),
		                  identifierEight:window.assignAttachmentKeyEight||jQuery("#id_currentHistoryTaskInfo_keyEight").val(),
		                  identifierNine:window.assignAttachmentKeyNine||jQuery("#id_currentHistoryTaskInfo_keyNine").val(),
		                  identifierTen:window.assignAttachmentKeyTen||jQuery("#id_currentHistoryTaskInfo_keyTen").val(),
		                  width:all_width-13,
		                  height:200,
		                  isRank:false,
		                  isCheck:false,
		                  isReadOnly:window.isCompletedTask||window.assignAttachmentIsReadOnly||false,
		                  border:false,
		                  displayToggleContainer:"id_table_leasing_rent_plan_attachment"
			 });
		 }
   });
 </script>