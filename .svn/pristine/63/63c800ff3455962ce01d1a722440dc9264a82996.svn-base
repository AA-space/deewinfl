<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--变更说明 -->
<table class="fillTable" cellspacing="0" cellpadding="0" width="100%">
	<tr class="tr-odd">
		<td class="td-content-title" style="width:100px">变更时间：</td>
		<td class="td-content" colspan=1>
	    <input name="contract_other_info.contractchangedate" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['contract_other_info.contractchangedate'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="变更时间" /><font class="required-content">*</font>
		</td>
	</tr>
	<tr class="tr-even">
		<td class="td-content-title">变更说明：</td>
		<td class="td-content" colspan=1>
		<textarea rows="5" cols="150" style="width:98%;float:left;"  require="true" label="变更说明"  name="contract_other_info.contractChangeMemo">${requestScope['contract_other_info.contractChangeMemo'] }</textarea>	</td>
	</tr>
	<tr class="tr-odd">
		<td class="td-content-title">变更前内容：</td>
		<td class="td-content" colspan=1>
		<textarea rows="5" cols="150" require="true" label="变更前内容" 
			style="width:98%;float:left;" name="contract_other_info.contractChangeBeforMemo">${requestScope['contract_other_info.contractChangeBeforMemo'] }</textarea>
				</td>
	</tr>
		<tr class="tr-even">
		<td class="td-content-title">变更后内容：</td>
		<td class="td-content" colspan=1>
		<textarea rows="5" cols="150" require="true" label="变更后内容" 
			style="width:98%;float:left;" name="contract_other_info.contractChangeAfterMemo">${requestScope['contract_other_info.contractChangeAfterMemo'] }</textarea>	</td>
	</tr>
	
</table>