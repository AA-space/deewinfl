<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	<%---下面是所购车辆营运信息表 --%>
	<table cellspacing="0" cellpadding="0" id="id_salecar_info">
	<tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan="4">
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-special-indust"></div>
		所购车辆营运信息</td>
	</tr>
	<tr class="tr-contractect-info tr-odd">
		<td class="td-content-title" >车辆上牌照地:</td>
		<td class="td-content" >
		<input name="operation_info.column15" value="${requestScope['operation_info.column15']}" class="td-content-input" require="true" label="车辆上牌照地" type="text" maxB="20"/><font class="required-content">*</font>
		</td>
		<td class="td-content-title" >预计所购车月营动费用:</td>
		<td class="td-content" >
		<input name="operation_info.column16" value="${requestScope['operation_info.column16']}" class="td-content-input"  type="text" require="true" label="预计所购车月营动费用" datatype="Number"/><font class="required-content">*</font>
		</td>
	</tr>
	<tr class="tr-contractect-info tr-even">
		<td class="td-content-title" >预计月行驶公里数:</td>
		<td class="td-content" >
		<input name="operation_info.column17" value="${requestScope['operation_info.column17']}" class="td-content-input"  type="text" require="true" label="预计月行驶公里数" datatype="Number"/><font class="required-content">*</font>
		</td>
		<td class="td-content-title" >预定运输线路:</td>
		<td class="td-content" >
		<input name="operation_info.column18" value="${requestScope['operation_info.column18']}" class="td-content-input"  type="text" require="true" label="预定运输线路" maxB="30"/><font class="required-content">*</font>
		</td>
	</tr>
	<tr class="tr-contractect-info tr-odd">
		<td class="td-content-title" >车辆登记所有权人:</td>
		<td class="td-content" >
		<input name="operation_info.column19" value="${requestScope['operation_info.column19']}" class="td-content-input"   type="text" maxB="60" require="true" label="车辆登记所有权人" /><font class="required-content">*</font>
		</td>
		<td class="td-content-title" >车辆实际所有权人:</td>
		<td class="td-content" >
		<input name="operation_info.column20" value="${requestScope['operation_info.column20']}" class="td-content-input"   type="text" maxB="60" require="true" label="车辆实际所有权人"/><font class="required-content">*</font>
		</td>
	</tr>
</table>