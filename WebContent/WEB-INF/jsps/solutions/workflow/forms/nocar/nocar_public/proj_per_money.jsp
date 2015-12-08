<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <script language="javascript">
    jQuery(function(){
    	dictYesOrNoByCode('id_is_proj_per_money','proj_other_info.ispermoney','${empty requestScope["proj_other_info.ispermoney"] ? "1" : requestScope["proj_other_info.ispermoney"] }','',true,' require="true" label="是否提前准备资金"');
    });
</script>
<table cellspacing="0" cellpadding="0">
	<tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-project-per_money"></div>
		是否提前准备资金</td>
	</tr>
	<tr class="tr-project-per_money tr-odd">
		<td class="td-content-title" >是否提前准备资金：</td>
		<td class="td-content" colspan=3>
		<div class="leftComboContainer" id="id_is_proj_per_money"></div>
		</td>
	</tr>
</table>