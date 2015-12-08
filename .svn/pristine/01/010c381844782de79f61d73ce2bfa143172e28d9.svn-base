<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(function(){
		if(isSubTable_risk){
			dictSameCode('id_contract_five_category_risk', 'five_category.contractfive_risk', 'five_class','${requestScope["five_category.contractfive_risk"]}', null, 'require="true" label="合同五级分类"');
			isSubTable_risk = false;
		}	
		//######合同五级分类#########
	});
</script>
<table id="five_category_content_risk" cellspacing="0" cellpadding="0" style="width: 99.8%;">
	<tr><td colspan="4">&nbsp;</td></tr>
    <tr class="tr-business-five tr-even">
    	<td class="td-content-title">合同五级分类：</td>
    	<td class="td-content"><div class="leftComboContainer" id="id_contract_five_category_risk"></div><font class="required-content">*</font></td>
        <td class="td-content-title">五级分类日期：</td>
        <td class="td-content"><input class="Wdate td-content-input" readonly name="five_category.contractfivedate_risk" dataType="Date" type="text" value="${requestScope['five_category.contractfivedate_risk']}" onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="五级分类日期"><font class="required-content">*</font></td>
    </tr>
    <tr class="tr-business-five tr-even">
		<td class="td-content-title">五级分类说明：</td><td class="td-content" colspan="3"><div class="leftComboContainer" style="width: 90%;height: auto;"><textarea rows="6" style="width:95%;float:left;" name="five_category.explain_risk" require="true" label="五级分类说明">${requestScope['five_category.explain_risk']}</textarea></div><font class="required-content">*</font></td>
	</tr>
</table>