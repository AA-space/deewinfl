<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTree2Table.js"></script>
<script type="text/javascript">
jQuery(function() {
	new tracywindyTree2Table({
	 	   renderTo:'div_id_dealer_doc_report',
	 	   id:'doc_report',
	 	   rootDictId:'doc_code_300',
	 	   allCheckedTitleCodes:"column_code_307",
	 	   savedDataKey:"${requestScope['cust_info.id'] }",
	 	   savedDataKey1:"${requestScope['dealer_approval_info.approvalnum'] }",
	 	   savedDataKey2:"${currentProcessInstanceDBID}",  //当前流程的ID
	 	   savedDataKey3:"${requestScope['currentWorkFlowName']}",//流程名称
	 	   treeTableJson:'${empty json_dealer_doc_report_str ? "[]" : json_dealer_doc_report_str }',
		  width:formWidth-10
	}); 
});
function saveDocReport(){
	try{
		var jsonValue=getTracywindyObject("doc_report").getTableAllSavedConfigJson();
		jsonValue=JsonUtil.doEncode(jsonValue);
		
		jQuery("#id_json_dealer_doc_report_str").val(jsonValue);
	}catch(e){
		alert(e);
		return false;
	}
	return true;
}
</script>
<input size="=100" id="id_json_dealer_doc_report_str" name="json_dealer_doc_report_str" style="display:none"
 value='${empty json_dealer_doc_report_str ? "[]" : json_dealer_doc_report_str }'>
<div id="div_id_dealer_doc_report" >
</div>
