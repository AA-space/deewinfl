<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<table cellspacing="0" cellpadding="0" style="width: 98%; margin-top: 20px;" >
	<tr  class="tr-contractect-other-info tr-odd">
	    <td class="td-content-title">是否暂停经销商立项：</td>
	    <td class="td-content"><div class="leftComboContainer" id="id_zant"></div><font class="required-content">*</font></td>
	</tr>
	<tr  class="tr-contractect-other-info tr-even">
	   <td class="td-content-title" >备注：</td>
	   <td class="td-content" colspan="3"><div class="leftComboContainer" style="width: 99%;"><textarea rows="3"  style="width: 95%;float:left;" name="contract_other_info.signperson">${requestScope['contract_other_info.signperson']}</textarea></div></td>
	</tr>
</table>