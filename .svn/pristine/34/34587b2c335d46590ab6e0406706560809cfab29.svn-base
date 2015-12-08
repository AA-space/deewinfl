<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script language="javascript">

jQuery(function(){
	//注templateDiv：模板存放的id,oneClassify分类，他可以是五级分类,changeRowNum:模板换行数
	config={templateDiv:'contract_word_check_list',oneClassify:'wordtempletypefirst1',changeRowNum:6};
    loadTemplate(config);
});
function createWord(){
	//注分fileListTable:合同列表多行控件的ID(取这个table)
	//modename:'模板分类',第一级分类
	createWordByIds({fileListTable:'table_id_table_word_list_container',modename:'wordtempletypefirst2'});
}
</script>
<table cellspacing="0" cellpadding="0">
	<tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-survey"></div> 授信协议</td>
	</tr>
	<tr>
		<td colspan=4 class="td-even-line-separator">
		 <span id="contract_word_check_list"> </span><input type="button" value="生成协议" onclick="createWord()" /></td>
	</tr>

	<tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
</table>