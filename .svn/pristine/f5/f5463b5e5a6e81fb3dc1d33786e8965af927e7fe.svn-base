<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(function() {
		if(isSubTable_assets){
			dictSameCode('id_contract_five_category_assets', 'five_category.contractfive_assets', 'five_class','${requestScope["five_category.contractfive_assets"]}', null, 'require="true" label="资产五级分类"');
			isSubTable_assets = false;
		}
		//######资产五级分类#########
	});
</script>
<table id="five_category_content_assets" cellspacing="0" cellpadding="0" style="width: 99.8%;">
	<tr><td colspan="4">&nbsp;</td></tr>
    <tr class="tr-business-five tr-even">
    	<td class="td-content-title">资产五级分类：</td>
    	<td class="td-content"><div class="leftComboContainer" id="id_contract_five_category_assets"></div><font class="required-content">*</font></td>
        <td class="td-content-title">五级分类日期：</td>
        <td class="td-content"><input class="Wdate td-content-input" readonly name="five_category.contractfive_dateassets" dataType="Date" type="text" value="${requestScope['five_category.contractfive_dateassets']}" onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="五级分类日期"><font class="required-content">*</font></td>
    </tr>
    <tr class="tr-business-five tr-even">
		<td class="td-content-title">五级分类说明：</td><td class="td-content" colspan="3"><div class="leftComboContainer" style="width: 90%;height: auto;"><textarea rows="6" style="width:95%;float:left;" name="five_category.explain_assets"  label="五级分类说明">${requestScope['five_category.explain_assets']}</textarea></div><font class="required-content">*</font></td>
	</tr>
</table>