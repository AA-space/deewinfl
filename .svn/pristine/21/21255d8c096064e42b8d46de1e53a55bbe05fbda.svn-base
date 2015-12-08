<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script type="text/javascript">
function reckonStarDate(date){
	if(date!=""){
		jQuery("#startDate").val(date);
		if(window.OnchangeDate){
			OnchangeDate();
		}
		conditionReckon();//调用测算
	}
}
</script>
<table cellspacing="0" cellpadding="0" id="equip_accpance_other_info">
	<tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan="4">
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-project-y"></div>
		设备验收</td>
	</tr>
	<tr class="tr-project-y tr-even" id="accept_date">
		<td class="td-content-title" >验收时间:</td>
		<td class="td-content" >
		<input class="Wdate td-content-input td-content-readonly" onchange="reckonStarDate(this.value)"  dataType="Date"  readonly="readonly" dataType="Date" name="equip_acceptance.acceptdate" type="text" 
		 onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" value="${requestScope['equip_acceptance.acceptdate'] }" require="true" label="验收时间">
		<font class="required-content">*</font></td>
		<td class="td-content-title" >验收人:</td>
		<td class="td-content" >
		<input name="equip_acceptance.acceptuser" class="td-content-input" value="${requestScope['equip_acceptance.acceptuser'] }" label="验收人"  type="text" maxB="20"/>
		</td>
	</tr>
	<tr class="tr-project-y tr-odd">
	 	<td class="td-content-title" >验收地点:</td>
		<td class="td-content" colspan=4><textarea rows="5" 
			style="width: 98%;float:left;" id="special_industries"
			name="equip_acceptance.acceptadder" maxB="300">${requestScope['equip_acceptance.acceptadder'] }</textarea>
		</td>
	</tr>
	 <tr class="tr-project-y tr-even">
		<td class="td-content-title" >验收备注:</td>
		<td class="td-content" colspan=4><textarea rows="5" 
			style="width: 98%;float:left;" id="special_industries"
			name="equip_acceptance.ecmemo" maxB="300">${requestScope['equip_acceptance.ecmemo'] }</textarea>
		</td>
	</tr>
	<tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	</table>