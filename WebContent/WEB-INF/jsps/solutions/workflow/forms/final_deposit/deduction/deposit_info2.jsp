<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<table class="fillTable" cellspacing="0" cellpadding="0" width="50%" id="id_contract_condition_cash_deposit_content" >
	<tr class="tr-odd">
	<td class="td-content-title">总保证金:</td>
	<td class="td-content"><input class="td-content-input" type="text" name="projcondition_info.cautionmoney" readonly="readonly" value="${requestScope['projcondition_info.cautionmoney']}"/></td>
	<td class="td-content-title">已还保证金:</td>
	<td class="td-content"><input class="td-content-input" type="text" name="projcondition_info.incomecaution" readonly="readonly" value="${requestScope['projcondition_info.incomecaution']}"/></td>
	<td></td>
	<td class="td-content-title">已抵扣保证金:</td>
	<td class="td-content"><input class="td-content-input" type="text" name="projcondition_info.deduction" readonly="readonly" value="${requestScope['projcondition_info.deduction']}"/></td>
	<td></td>
	</tr>
	<tr class="tr-even">
	<td class="td-content-title">剩余保证金:</td>
	<td class="td-content"><input class="td-content-input" type="text" name="projcondition_info.surpluscaution" id="projcondition_info.surpluscaution" readonly="readonly" value="${empty requestScope['projcondition_info.surpluscaution']?'0':requestScope['projcondition_info.surpluscaution']}"/></td>
	<td class="td-content-title">可抵扣保证金:</td>
	<td class="td-content"><input class="td-content-input" type="text" name="projcondition_info.deductible" id="projcondition_info.deductible" readonly="readonly" value="${empty requestScope['projcondition_info.deductible']?'0':requestScope['projcondition_info.deductible']}"/></td>
	</tr>
	
</table>
