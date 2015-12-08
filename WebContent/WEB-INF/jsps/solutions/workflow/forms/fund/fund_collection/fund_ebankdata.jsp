<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!-- 网银信息 -->
 <input name="fund_ebank_process" id="id_fund_ebank_process" type="hidden" value="${requestScope['fund_ebank_process'] }"/>
<input name="dealer" id="dealer" type="hidden" value="${requestScope['dealer'] }"/>
 <table cellspacing="0" cellpadding="0" style="width: 98%; margin-top: 20px;" id="fund_ebank_data" >
        <tr class="tr-project-condition tr-even">
			<td class="td-content-title">网银编号：</td>
			<td class="td-content"><input name="fund_ebank_data.ebdataid" id="ebdataid" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.ebdataid']}"></td>
			<td class="td-content-title">付款人：</td>
			<td class="td-content"><input name="fund_ebank_data.clientname" class="td-content-input td-content-readonly" type="text" value="${requestScope['fund_ebank_data.clientname']}" /></td>
		    <td class="td-content-title">流水号：</td>
			<td class="td-content"><input name="fund_ebank_data.sn" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.sn']}"></td>
		</tr>
		<tr class="tr-project-condition tr-odd">
			<td class="td-content-title">本方银行：</td>
			<td class="td-content"><input name="fund_ebank_data.ownbank" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.ownbank']}"></td>
			<td class="td-content-title">本方账户：</td>
			<td class="td-content"><input name="fund_ebank_data.ownaccount" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.ownaccount']}"></td>
			<td class="td-content-title">本方账号：</td>
			<td class="td-content"><input name="fund_ebank_data.ownaccnumber" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.ownaccnumber']}"></td>
		</tr>

		<tr class="tr-project-condition tr-even">
			<td class="td-content-title">对方银行：</td>
			<td class="td-content"><input name="fund_ebank_data.clientbank" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.clientbank']}"></td>
			<td class="td-content-title">对方账户：</td>
			<td class="td-content"><input name="fund_ebank_data.clientaccount" class="td-content-input td-content-readonly" type="text" value="${requestScope['fund_ebank_data.clientaccount']}" /></td>
			<td class="td-content-title">对方账号：</td>
			<td class="td-content"><input name="fund_ebank_data.clientaccnumber" class="td-content-input td-content-readonly" type="text" value="${requestScope['fund_ebank_data.clientaccnumber']}" /></td>
		</tr>

		<tr class="tr-project-condition tr-odd">
			<td class="td-content-title">到账金额：</td>
			<td class="td-content"><input name="fund_ebank_data.factmoney" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.factmoney']}"></td>
			<td class="td-content-title">已核销金额：</td>
			<td class="td-content" ><input name="fund_ebank_data.hadmoney" class="td-content-input td-content-readonly" type="text" value="${requestScope['fund_ebank_data.hadmoney']}" /></td>
			<td class="td-content-title">可核销金额：</td>
			<td class="td-content" ><input name="fund_ebank_data.mayopemoney" class="td-content-input td-content-readonly" type="text" value="${requestScope['fund_ebank_data.mayopemoney']}" /></td>	
		</tr>
		<tr class="tr-project-condition tr-even">
		    <td class="td-content-title">无关金额：</td>
			<td class="td-content"><input name="fund_ebank_data.nowithmoney" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.nowithmoney']}"></td>
		    <td class="td-content-title">到账金额类型：</td>
			<td class="td-content"><input name="fund_ebank_data.moneytype" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.moneytype']}"></td>
			<td class="td-content-title">到账时间：</td>
			<td class="td-content"><input name="fund_ebank_data.factdate" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['fund_ebank_data.factdate']}"></td>
		 </tr>
		<tr class="tr-project-condition tr-odd">
		    <td class="td-content-title">备注：</td>
			<td class="td-content" colspan="5">
			<textarea rows="5"    label="备注" class="td-content-input"
			style="width: 70%;float:left" name="fund_ebank_data.summary">${requestScope['fund_ebank_data.summary'] }</textarea>
		</tr>
 </table>