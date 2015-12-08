<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--css sheet-->
<link href="${pageContext.request.contextPath}/css/dtree/dtree.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css"
	rel="stylesheet" type="text/css">
<!--javascript libray-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/validator.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyMultiTable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/ajaxfileupload.js"></script>
<script type="text/javascript">
 
     var isCompletedTask=("true"=="${isCompletedTask}");   //当前结点是否结束
     var flowName="${requestScope['currentWorkFlowName']}";//流程名称
     var stepName="${currentTaskActivityName}";   //当前节点的名称
     var flowUnid="${currentProcessInstanceDBID}";   //当前流程的ID
     var stepUnid="${requestScope['currentTaskId']}";   //当前节点的id
     
    </script>
<script type="text/javascript">
    jQuery(function(){
        var creditType = "${requestScope['financing_credit.credit_type']}";
    	dictYesOrNoByCode('id_credit_assurer','financing_credit.isAssurer',null,null,null,'label="担保"');
    	dictYesOrNoByCode('id_bloc_credit','financing_credit.bloc_credit',null,null,null,'label="集团内部融资"');
    	dictOnSelect('id_currency','financing_credit.currency','currency_type',null,null,'label="币种"',false);
    	dictOnSelect('id_assurer','financing_credit.assurer','FinancingAssurer',null,null,'label="担保机构"',true);
    	dictOnSelect('id_credit_type','financing_credit.credit_type','credit_type',creditType,null,'label="授信种类"',false);
    	var combo_rate = new tracywindyComboBox({
    	    id:'id_credit_use_type',
    	    width:165,
    	    renderTo:'id_credit_use_type',
    	    loadMode:'local',
    	    datas:[{title:'一次性',name:'1'},{title:'循环',name:'2'}],
    	    readOnly:true,
    	    isContainEmpty:true,
    	    dropListHeight:200,
    	    topAdd:0,
    	    leftAdd:0,
    	    positionDropIconLeftAdd:-1,
    	    name:'financing_credit.credit_use_type',
    		displayField:'title',
    		valueField:'name',
    	    otherAttributes:'require="true" label="额度使用方式"'
    	 });
        });
    </script>
    
	<tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-credit-info"></div>
		融资授信基本信息</td>
	</tr>
	<tr class="tr-credit-info tr-even">
		<td class="td-content-title">授信标号：</td>
		<td class="td-content"><input name="financing_credit.credit_id"
			label="授信标号" class="td-content-input td-content-readonly" readOnly
			type="text" value="${requestScope['financing_credit.credit_id']}"><font
			class="required-content">*</font></td>
		<td class="td-content-title">合同号：</td>
		<td class="td-content"><input
			name="financing_credit.credit_contract_id" type="text"
			class="td-content-input td-content-readonly"
			value="${requestScope['financing_credit.credit_contract_id']}"
			 require="true" /></td>
	</tr>
	<tr class="tr-credit-info tr-odd">
		<td class="td-content-title">授信单位：</td>
		<td class="td-content"><input name="financing_credit.crediter"
			label="授信单位" class="td-content-input td-content-readonly" readOnly
			type="text" value="${requestScope['financing_credit.crediter']}"
			require="true"><font class="required-content">*</font></td>
		<td class="td-content-title">授信机构属性：</td>
		<td class="td-content"><input
			name="financing_credit.crediter_type" type="text"
			class="td-content-input td-content-readonly"
			value="${requestScope['financing_credit.crediter_type']}" readOnly /></td>
	</tr>
	<tr class="tr-credit-info tr-even">
		<td class="td-content-title">授信种类：</td>
		<td class="td-content"><div id="id_credit_type" style="float: left;"></div><font
			class="required-content">*</font></td>
		<td class="td-content-title">公司在该行资信评级：</td>
		<td class="td-content"><input
			name="financing_credit.company_credit_info"
			class="td-content-input td-content-readonly" type="text"
			value="${requestScope['financing_credit.company_credit_info'] }"></td>
	</tr>
	<tr class="tr-credit-info tr-odd">
		<td class="td-content-title">币种：</td>
		<td class="td-content"><div id="id_currency" style="float: left;"></div><font
			class="required-content">*</font></td>
		<td class="td-content-title">授信金额：</td>
		<td class="td-content"><input label="授信金额"
			name="financing_credit.credit_money"
			class="td-content-input td-content-readonly" require="true"
			type="text" value="${requestScope['financing_credit.credit_money'] }"><font
			class="required-content">*</font></td>
	</tr>
	<tr class="tr-credit-info tr-even">
		<td class="td-content-title">担保：</td>
		<td class="td-content">
		<div id="id_credit_assurer"></div>
		</td>
		<td class="td-content-title">担保机构：</td>
		<td class="td-content"><div id="id_assurer"></div></td>
	</tr>
	<tr class="tr-credit-info tr-odd">
		<td class="td-content-title">担保方式：</td>
		<td class="td-content"><input label="担保方式"
			name="financing_credit.assure_way"
			class="td-content-input td-content-readonly" require="true"
			type="text" value="${requestScope['financing_credit.assure_way'] }"><font
			class="required-content">*</font></td>
		<td class="td-content-title">抵质押物：</td>
		<td class="td-content"><input id="pawn"
			name="financing_credit.pawn"
			class="td-content-input td-content-readonly" type="text"
			value="${requestScope['financing_credit.pawn'] }"></td>
	</tr>
	<tr class="tr-credit-info tr-even">
		<td class="td-content-title">授信起始日期：</td>
		<td class="td-content"><input label="授信起始日期"
			name="financing_credit.credit_start_date"
			class="Wdate td-content-input td-content-readonly"
			onclick="WdatePicker(this,{readOnly:true})" readOnly require="true"
			type="text"
			value="${requestScope['financing_credit.credit_start_date'] }"><font
			class="required-content">*</font></td>
		<td class="td-content-title">授信截止日期：</td>
		<td class="td-content"><input label="授信截止日期"
			name="financing_credit.credit_end_date"
			class="Wdate td-content-input td-content-readonly"
			onclick="WdatePicker(this,{readOnly:true})" readOnly require="true"
			type="text"
			value="${requestScope['financing_credit.credit_end_date'] }"><font
			class="required-content">*</font></td>
	</tr>
	<tr class="tr-credit-info tr-odd">
		<td class="td-content-title">额度使用方式：</td>
		<td class="td-content"><div id="id_credit_use_type" style="float: left;"></div><font
			class="required-content">*</font></td>
		<td class="td-content-title">集团内部融资：</td>
		<td class="td-content">
		<div id="id_bloc_credit"></div>
		</td>
	</tr>
	<tr class="tr-credit-info tr-even">
		<td class="td-content-title">备注：</td>
		<td colspan="3" class="td-content-title"><textarea name="financing_credit.remark"
			class="h60" rows="6" cols="80"></textarea></td>
	<tr/>

<script>
var isSubTable = true;
//初始化调用
jQuery(function() {
	//########公共JS事件##########
	jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
	$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
	$("#id_project_info_tabs_content").tabs();
	isSubTable = false;
	var d = $("#id_project_info_tabs_content");
	$("#id_project_fund_rent_plan_tabs_content").css("width",
			(formWidth) + "px");
	$("#id_project_fund_rent_plan_tabs_content").tabs();
	//jQuery(".fillTableContainer").css("width",formWidth+"px");
});
</script>