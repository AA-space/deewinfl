<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTree2Table.js"></script>

<script type="text/javascript">
//保存报告
function saveDocReport(){
	try{
		var jsonValue=getTracywindyObject("cust_credit").getTableAllSavedConfigJson();
		jsonValue=JsonUtil.doEncode(jsonValue);
		jQuery("#id_json_cust_credit_str").val(jsonValue);
	}catch(e){
		alert(e);
		return false;
	}
	return true;
}
function setCustCreditLevel(grade){
	if(grade==""){grade=0;}
	var lastGrade=parseFloat(grade);
	var leave="";
	if(lastGrade<=50){leave="E";}
	else if(lastGrade<=60){leave="D";}
	else if(lastGrade<=70){leave="C";}
	else if(lastGrade<=80){leave="B";}
	else{leave="A";}
	$("#id_cust_credit_level").val(leave);
}
//树转表每行必选校验
function checkRadio(){
	var radioAmaount = $('#id_table_leasing_proj_cust_creidt_container :radio:checked').length;
	return radioAmaount == 15 ;
}

</script>

<table cellspacing="0" cellpadding="0" id="id_cust_cedit_result_info" >
	<tr>
		<td>
			<div id="div-id-custcredit-report" style="">
				<div id="div_id_cust_credit" 	style="overflow: hidden;">
				<input id="id_json_cust_credit_str"  style="display:none" name="json_cust_credit_str" value='${empty json_cust_credit_str ? "[]" : json_cust_credit_str }'>
			</div>
		</td>
	</tr>
	<tr class="">
		<td><div style="float:left">经过对该客户信用评分的评测,该客户的综合得分为:</div>
			<input style="float:left" id="id_cust_credit_score" name="proj_other_info.custcredit" onpropertychange="setCustCreditLevel(this.value)" oninput="setCustCreditLevel(this.value)" type="text" size=3 value='${empty requestScope["proj_other_info.custcredit"] ? "0.00" : requestScope["proj_other_info.custcredit"] }' readOnly="true" class="td-content-readonly" />
			<div style="float:left">分  建议评级</div><input  style="float:left"id="id_cust_credit_level" name="proj_other_info.custcreditlevel" type="text" size=1 value='${empty requestScope["proj_other_info.custcreditlevel"] ? "0.00" : requestScope["proj_other_info.custcreditlevel"] }' readonly="readonly" class="td-content-readonly" /><div style="float:left">级</div>
		</td>
	</tr>
</table>
<script type="text/javascript">
//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		//第一个页签集合
// 		$("#div-id-custcredit-report").css("width", (formWidth) + "px");
// 		$("#div-id-custcredit-report").tabs();
		isSubTable = false;//标志主页面加载完成
	})
</script>