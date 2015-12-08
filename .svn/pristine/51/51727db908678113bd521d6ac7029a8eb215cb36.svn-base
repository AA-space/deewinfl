<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTree2Table.js"></script>
<script type="text/javascript">
jQuery(function() {
	new tracywindyTree2Table({
	 	   renderTo:'div_id_dealer_doc_report',
	 	   id:'doc_report',
	 	   rootDictId:'doc_code_1000',
	 	   savedDataKey:"${requestScope['cust_info.id'] }"+flowUnid,
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
		reportResult();
		jQuery("#id_json_dealer_doc_report_str").val(jsonValue);
	}catch(e){
		alert(e);
		return false;
	}
	return true;
}
//生成评分
function reportResult(){
	var result=0.00;
	$("#div_id_dealer_doc_report input[type='radio']").each(function(i,val){
	    if(val.checked){
	       result=parseFloat(result)+parseFloat(val.value);
	       result=result.toFixed(2);
	    }}); 
    $("#id_credit_result").val(result);
}
</script>

<input  id="id_json_dealer_doc_report_str" name="json_dealer_doc_report_str" style="display:none"
 value='${empty json_dealer_doc_report_str ? "[]" : json_dealer_doc_report_str }'>
 <input id="id_credit_result" name="dealer_credit_info.reportscore"  style="display:none" value='${empty requestScope["dealer_credit_info.reportscore"] ? "0.00" : requestScope["dealer_credit_info.reportscore"] }'/>
<div id="div_id_dealer_doc_report" >
</div>
