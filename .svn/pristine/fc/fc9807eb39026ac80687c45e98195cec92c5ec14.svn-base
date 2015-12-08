<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTree2Table.js"></script>	
<script type="text/javascript">
  jQuery(function() {
	 new tracywindyTree2Table({
	 	   renderTo:'div_id_dealer_doc_report',
	 	   id:'doc_report',
	 	   rootDictId:'doc_code_1100',
	 	   //allCheckedTitleCodes:"column_code_307",
	 	   //savedDataKey:"${requestScope['dealername'] }",
	 	   //savedDataKey1:"${requestScope['contractid'] }",
	 	   savedDataKey:"${currentProcessInstanceDBID}",  //当前流程的ID
	 	   savedDataKey1:"${requestScope['currentWorkFlowName']}",//流程名称
	 	   treeTableJson:'${empty json_dealer_doc_report_str ? "[]" : json_dealer_doc_report_str }',
		   width:formWidth-10
	 }); 
 });
function saveDocReport(){
	try{
		//var jsonValue=getTracywindyObject("doc_report").getTableAllSavedConfigJson();

		var fieldMapping=['materialName','original','copy','memo'];
		var index=0;
		var jsonValue=getTracywindyObject("doc_report").getTableAllSavedConfigJson();
		
		var jsonTitleTrs=jsonValue.treeTableJson.trs;
		var confiedData={};
		for(var i=1;i<jsonTitleTrs.length;i++){
             var titletr=jsonTitleTrs[i];
             var titletds=titletr.tds;
             var o={};
             o["docCode"]=titletds[0].code;
             o[fieldMapping[0]]=titletds[0].name;
             confiedData[titletds[0].code]=o;
        }
        index=1;
	    var jsonBody=jsonValue.valuesMapping;
	    for(var headCode in jsonBody){
            var onevalue=jsonBody[headCode];
            if(confiedData[headCode]){
            for( var j=0;j<onevalue.length;j++){
               confiedData[headCode][fieldMapping[index+j]]=onevalue[j].savedData;
            }}
	    }
	    var result=[];
	    for(var p in confiedData){
	    	result.push(confiedData[p]);
	    }
	    jQuery("#id_json_dealer_doc_report").val(JsonUtil.doEncode(result));
		jsonValue=JsonUtil.doEncode(jsonValue);
		//alert(jsonValue);
		jQuery("#id_json_dealer_doc_report_str").val(jsonValue);
	}catch(e){
		alert(e);
		return false;
	}
	return true;
}
</script>
<input  id="id_json_dealer_doc_report_str" name="json_dealer_doc_report_str" style="display:none"
 value='${empty json_dealer_doc_report_str ? "[]" : json_dealer_doc_report_str }'>
 <input size="=100" id="id_json_dealer_doc_report" name="json_dealer_doc_report" style="display:none"
 value='${empty json_dealer_doc_report ? "[]" : json_dealer_doc_report }'>
<div id="div_id_dealer_doc_report" >
</div>	
