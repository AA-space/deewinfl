<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
function initFileListParams(){
	 //担保单位信息
	  var currentTable = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');
	  var onSelectDatas = JsonUtil.encode(currentTable.getRowsJsonData());
	  var custname = "${requestScope['proj_info.custname']}";
	  var custnumber = "${requestScope['proj_info.custnumber']}";
	  var custclass = "${requestScope['cust_info.custclass']}";
	  customWorkflowAttachment(onSelectDatas,custname,custnumber,custclass);
}
</script>