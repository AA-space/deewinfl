<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script language="javascript">

jQuery(function(){
	//注templateDiv：模板存放的id,oneClassify分类，他可以是五级分类,changeRowNum:模板换行数
	config={templateDiv:'contract_word_check_list',oneClassify:'wordtempletypefirst2',changeRowNum:4};
    loadTemplate(config);
});
function createWord(){
	//var start=jQuery("input[name='dealer_credit_info.adjustcreditstardate']").val();
	var start=jQuery("input[name='dealer_credit_info.adjustdate']").val();
	if(start==''||start==undefined||start==null)
	{
		alert("调整日期不能为空!");
	    return false;
	}
	var end=jQuery("input[name='dealer_credit_info.adjustcreditenddate']").val();
	var aftermoney=jQuery("input[name='dealer_credit_info.adjustcreditmoney']").val();
	if(aftermoney==''||aftermoney==undefined||aftermoney==null)
	{
		alert("授信金额额度调整不能为空!");
	    return false;
	}
	var curmoney=jQuery("input[name='dealer_credit_info.creditmoney']").val();
	var money;
	//注分fileListTable:合同列表多行控件的ID(取这个table)
	//modename:'模板分类',第一级分类
	if(parseFloat(curmoney)>parseFloat(aftermoney)){
		money=parseFloat(curmoney)-parseFloat(aftermoney);
	}else{
		money=parseFloat(aftermoney)-parseFloat(curmoney);
	}
	createWordByIds({fileListTable:'table_id_table_word_list_container',modename:'wordtempletypefirst2','dealer_credit_info.creditstardate':start,'dealer_credit_info.creditenddate':end,'dealer_credit_info.creditmoney':money,'dealer_credit_info.adjustcreditmoney':aftermoney});
}
</script>
<div class="fillTableContainer">
<table class="fillTable" cellspacing="0" cellpadding="0">
	<tr class="tr-contractect-word-info tr-even">
		<td colspan=8 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=8>
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-survey"></div>通知函</td>
	</tr>
	
	<tr class="tr-contractect-word-info tr-odd">
		<td class="td-content-title" style="width:10%">通知函：</td>
		<td class="td-content" colspan=7><div id="contract_word_check_list"><span>请先选择!</span></div></td>
	</tr>
	<tr class="tr-contractect-word-info tr-even">
		<td class="td-content" colspan=8 align="right">
		<input style="margin-top:2px;margin-bottom:2px;" id="btn_rent_cal" class="btn btn-primary" type="button" value="生成通知函" onclick="createWord()"/>
		</td>
	</tr>
	
</table>
</div>