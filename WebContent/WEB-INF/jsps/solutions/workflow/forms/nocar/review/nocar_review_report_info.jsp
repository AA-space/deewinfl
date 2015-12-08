<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<table cellspacing="0" cellpadding="0" id="review_report">
	<!--<tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	--><%--- 项目概况--%>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan="4">
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-project-survey"></div>
		项目概况</td>
	</tr>
	<tr class="tr-project-survey tr-odd">
		<td class="td-content" >资金用途:</td>
		<td class="td-content" colspan="1">
		<textarea rows="5" cols="30"   style="width: 93%;float: left;" name="proj_other_info.funduseing" maxB="300">${requestScope['proj_other_info.funduseing'] }</textarea>
		</td>
		<td class="td-content" >还款资金来源:</td>
		<td class="td-content">
		<textarea rows="5" cols="30"   style="width: 96%;float:left;" name="proj_other_info.incomerentfrom" maxB="300">${requestScope['proj_other_info.incomerentfrom'] }</textarea>
		</td>
	</tr>
	<%--- 结束项目概况--%>  
	</table>
	
 