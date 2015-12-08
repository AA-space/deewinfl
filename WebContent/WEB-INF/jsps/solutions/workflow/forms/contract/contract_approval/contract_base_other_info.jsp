<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table cellspacing="0" cellpadding="0">
	<tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<%-- <tr>
		<td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-other-info"></div>项目概况</td>
	</tr>
	<tr class="tr-other-info tr-odd">
		<td class="td-content-title">单次所需时间：</td>
		<td class="td-content" colspan=3><input name="proj_other_info.singletime" class="td-content-input " type="text" value="${requestScope['proj_other_info.singletime'] }" require="true"
			label="单次运输时间" maxB="50"
		><font class="required-content">*</font></td>
	</tr>
	<tr class="tr-other-info tr-even">
		<td class="td-content-title">单次运输收入：</td>
		<td class="td-content"><input name="proj_other_info.singleincome" class="td-content-input " type="text" dataType="PMoney" value="${requestScope['proj_other_info.singleincome'] }" require="true"
			label="单次运输收入" maxB="50"
		><font class="required-content">*</font></td>
		<td class="td-content-title">单次运输费用：</td>
		<td class="td-content"><input name="proj_other_info.singlefee" class="td-content-input " type="text" dataType="PMoney" value="${requestScope['proj_other_info.singlefee'] }" require="true"
			label="单次运输费用" maxB="50"
		><font class="required-content">*</font></td>
	</tr>
	<tr>
		<td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-other-info1"></div>费用项目</td>
	</tr>
	<tr class="tr-other-info1 tr-even">
		<td class="td-content-title">油费:</td>
		<td class="td-content"><input name="proj_other_info.oilfee" class="td-content-input" type="text" value="${requestScope['proj_other_info.oilfee']}" dataType="PMoney" require="true" label="油费"
			maxB="50"
		><font class="required-content">*</font></td>
		<td class="td-content-title">过路费：</td>
		<td class="td-content"><input name="proj_other_info.tollfee" class="td-content-input" type="text" value="${requestScope['proj_other_info.tollfee']}" dataType="PMoney" require="true" label="过路费"
			maxB="50"
		/><font class="required-content">*</font></td>
	</tr>
	<tr class="tr-other-info1 tr-odd">
		<td class="td-content-title">人工费：</td>
		<td class="td-content"><input name="proj_other_info.laborfee" class="td-content-input" type="text" value="${requestScope['proj_other_info.laborfee']}" dataType="PMoney" require="true"
			label="人工费" maxB="50"
		><font class="required-content">*</font></td>
		<td class="td-content-title">维修保养费：</td>
		<td class="td-content"><input name="proj_other_info.servicefee" class="td-content-input" type="text" value="${requestScope['proj_other_info.servicefee']}" dataType="PMoney" require="true"
			label="维修保养费" maxB="50"
		><font class="required-content">*</font></td>
	</tr>
	<tr class="tr-other-info1 tr-even">
		<td class="td-content-title">其他：</td>
		<td class="td-content" colspan="3"><input name="proj_other_info.otherfee" class="td-content-input" type="text" value="${requestScope['proj_other_info.otherfee'] }" dataType="PMoney" label="其它"
			maxB="50"
		></td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
			<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-other-inf"></div>特殊说明
		</td>
	</tr>
	<tr class="tr-other-inf">
		<td class="td-content" colspan=4><textarea rows="5" style="width: 98%" id="special_industries" name="proj_other_info.specialindustries">${requestScope['proj_other_info.specialindustries'] }</textarea>
		</td>
	</tr> --%>
	<tr>
		<td class="x-panel-table-div-title" colspan=4>
			<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-other-inf"></div>标的物详情
		</td>
	</tr>
	<tr class="tr-other-inf">
		<td class="td-content" colspan=4><textarea rows="5" style="width: 98%" id="equipinfo" name="contract_other_info.equipinfo">${requestScope['contract_other_info.equipinfo'] }</textarea>
		</td>
	</tr>
</table>