<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table>
<tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<%---评审结果 --%>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-project-special-stries"></div>
		评审结果</td>
	</tr>
	<tr class="tr-project-special-stries tr-odd">
		<td class="td-content" >资产评估值:</td>
		<td class="td-content" >
		<input name="tablename.column9" class="td-content-input" require="true" label="资产评估值"  type="text" />
		</td>
		<td class="td-content" >融资额:</td>
		<td class="td-content">
		<input name="tablename.column10" class="td-content-input" require="true" label="融资额"  type="text" datatype="Number"/>
		</td>
	</tr>
	<tr class="tr-project-special-stries tr-even">
		<td class="td-content" >资产级别:</td>
		<td class="td-content" colspan="4">
		<input name="tablename.column11" class="td-content-input" require="true" label="资产级别"  type="text" />
		</td>
	</tr>
	<tr class="tr-project-special-stries tr-odd">
		<td class="td-content" >平均月现金流:</td>
		<td class="td-content" >
		<input name="tablename.column12" class="td-content-input" require="true" label="平均月现金流"  type="text" datatype="Number"/>
		</td>
		<td class="td-content" >月租金:</td>
		<td class="td-content">
		<input name="tablename.column13" class="td-content-input" require="true" label="月租金"  type="text" datatype="Number"/>
		</td>
	</tr>
	<tr class="tr-project-special-stries tr-even">
		<td class="td-content" >现金流级别:</td>
		<td class="td-content" colspan="4">
		<input name="tablename.column14" class="td-content-input" require="true" label="现金流级别"  type="text" />
		</td>
	</tr>
	<tr class="tr-project-special-stries tr-odd">
		<td class="td-content" >备注:</td>
		<td class="td-content" colspan="4">
		<textarea rows="5" cols="30" '    
			style="width: 98%;float: left;" name="tablename.column15" maxB="300"  label="备注">${requestScope['proj_other_info.projsurvey'] }</textarea>
		</td>
	</tr>
	<tr class="tr-project-special-stries tr-even">
		<td class="td-content" >信审结论:</td>
		<td class="td-content" >
		<!--<select name="">
		<option id="1" value="通过">通过</option>
		<option id="2" value="不通过">不通过</option>
		<option id="3" value="特殊通过">特殊通过</option>
		</select>
		-->
		<div id="id_credit_result" class="leftComboContainer"></div>
		</td>
		<td class="td-content" >信审日期:</td>
		<td class="td-content">
		<input class="Wdate td-content-input" readonly name="tablename.column17" class="td-content-input"  type="text" 
		 onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="信审日期">
		</td>
	</tr>
	<%---结束评审结果 --%>
	
	</table>