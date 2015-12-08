<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script type="text/javascript">
jQuery(function(){
 	dict('id_dealerapprovalstatus','dealer_approval_info.dealerStatus','dealer_creditStatus','${requestScope["dealer_approval_info.dealerStatus"]}',null,'require="true" label="选 择是否符合准入的标准"');    
	});
function setCreditLevel(grade){
	if(grade==""){grade=0;}
	var lastGrade=parseFloat(grade);
	var leave="";
	if(lastGrade<60){leave="D";}
	else if(lastGrade<70){leave="C";}
	else if(lastGrade<85){leave="B";}
	else{leave="A";}
	$("#id_local_report_result_level").val(leave);
}
</script>
<table cellspacing="0" cellpadding="0" id="id_proj_cedit_result_info" >
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" >
			<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-dealer-report-2"></div>经销商额度授信建议</td>
	</tr>
	<tr class="">
		<td><div style="float:left">经过对该经销商综合能力的评测,该经销商的综合得分为:</div>
		
			<input style="float:left" id="id_local_report_result" name="dealer_approval_info.reportscore" onpropertychange="setCreditLevel(this.value)" oninput="setCreditLevel(this.value)" type="text" size=3 value='${empty requestScope["dealer_approval_info.reportscore"] ? "0.00" : requestScope["dealer_approval_info.reportscore"] }' readOnly="true" class="td-content-readonly" />
			<div style="float:left">分  建议评级</div><input  style="float:left"id="id_local_report_result_level" name="dealer_approval_info.reportscorelevel" type="text" size=1 value='${empty requestScope["dealer_approval_info.reportscorelevel"] ? "0.00" : requestScope["dealer_approval_info.reportscorelevel"] }' readonly="readonly" class="td-content-readonly" /><div style="float:left">级</div>
		<div style="float:left" id="id_dealerapprovalstatus"></div>准入的标准
		</td>
	</tr>
	 <tr>
		<td>综合考虑以下可能对经销商未来履约能力或履约意愿方面的影响因素</td>
	</tr>
	<tr>
		<td><textarea rows="5" style="width: 98%" id="id_coloum1" name="coloum1">${requestScope['coloum2'] }</textarea></td>
	</tr>
	<tr>
		<td>综上所述，根据《陕重汽经销商信用等级和授信额度管理 办法(试行)》中的额度制定标准，建议该经销商授信额度为</td>
	</tr>
	<tr>
		<td>
		<table>
		  <tr>
			  <td>授信阶段</td><td>建议放大倍数</td><td>建议标准额度</td>
		  </tr>
		  <tr>
			   <td>辅导期</td>
			   <td><input id="id_1" name="table1" type="text" size=2 value='${empty requestScope["table1"] ? "" : requestScope["table1"] }' class="td-content-input" /></td>
				<td><input id="id_2" name="table2" type="text" size=20 value='${empty requestScope["table2"] ? "" : requestScope["table2"] }' class="td-content-input" /></td>
		  </tr>
		  <tr>
				<td>辅导期通过后</td>
				<td><input id="id_3" name="table3" type="text" size=2 value='${empty requestScope["table3"] ? "" : requestScope["table3"] }' class="td-content-input" /></td>
				<td><input id="id_4" name="table4" type="text" size=20 value='${empty requestScope["table4"] ? "" : requestScope["table4"] }' class="td-content-input" /></td>
		  </tr>
		</table>
		</td>
				
	</tr>
	<tr>
		 <td><textarea rows="5" style="width: 98%" id="id_coloum2" name="coloum2">${requestScope['coloum2'] }</textarea></td>
	 </tr>
</table>
