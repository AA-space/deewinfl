<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>   
<div id="id_contract_doc_ems_window" closed="true" modal="true" title="EMS单号"
	style="display:none;width:600px;padding-top:10px;padding:0px;">
<center>
<div style="width:96%;text-align:left;">
<table width="100%">
   <tr><tr style='height:20px;'><td >EMS单号:</td>
	<td class="input_value"><input id="contractems_id"  type='text' name="contractems" style="border:1px solid #DDD;width:200px;" value=""/>
	   </span></td>
	</tr>
	<tr class="content-separator">
		<td colspan="2"><a style="margin-left: 20px;"
			href="javascript:void(0);" class="btn btn-primary"
			onclick='setContractEms();'><span>确定</span></a> <a
			style="margin-left: 20px;" href="javascript:void(0);"
			class="btn btn-primary"
			onclick="jQuery('#id_contract_doc_ems_window').window('close');"
            ><span>取消</span></a>
		</td>
	</tr>
</table>
</div>
</center>
</div>
<script language="javascript">
function setContractEms(){
	var contractdoc = getTracywindyObject('table_id_table_leasing_contract_doc_send_info');//合同
    var plandata = contractdoc.getCheckedRowDatas();
    var ems=$('#contractems_id').val();
    for(var i=0;i<plandata.length;i++){
    	contractdoc.getRowDataAt(plandata[i].rowIndex).sendno=ems;
     }
    jQuery('#id_contract_doc_send_info_str').val(JsonUtil.encode(contractdoc.getRowsJsonData()));
    contractdoc.reload();
    jQuery('#id_contract_doc_ems_window').window('close');
}
</script>