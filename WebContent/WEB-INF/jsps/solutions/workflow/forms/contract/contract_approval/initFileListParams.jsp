<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
function initFileListParams(){
	 //担保单位信息
	  var currentTable = getTracywindyObject('table_id_table_leasing_contract_guarantee_method_container');
	  var onSelectDatas = JsonUtil.encode(currentTable.getRowsJsonData());
	  ///console.info(onSelectDatas);
	  var custname = "${requestScope['contract_info.custname']}";
	  ///console.info(custname);
	  var custnumber = "${requestScope['contract_info.custnumber']}";
	  ///console.info(custnumber);
	  var custclass = "${requestScope['cust_info.custclass']}";
	  ///console.info(custclass);
	  customWorkflowAttachment(onSelectDatas,custname,custnumber,custclass);
}
</script>