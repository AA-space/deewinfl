<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../contract_comm/base.jsp" flush="true" />
<style type="text/css">
body{
	overflow: auto;
}
</style>
<script type="text/javascript">
	isViewHistoryTask = false;
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		//fillHiddenVal();
		return true;
	}

	//保存成功提交后，后台返回
	function saveCallBack(rs) {
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		var form = new mini.Form("#form1");
		form.validate();
		if (form.isValid() == false) return;
		//if(fillHiddenVal("submit")==false) return;
		return true;
	}
	//isSubTable = true;
	var currentClientWidth = document.documentElement.clientWidth;
	var currentClientHeight = document.documentElement.clientHeight;
</script>
<!--多行控件  -->
<input type="hidden" id="id_json_contract_equip_str" name="json_contract_equip_str"  value='${empty json_contract_equip_str ? "[]" : json_contract_equip_str }'></input>
<input type="hidden" id="id_json_contract_guarantee_method_str" name="json_contract_guarantee_method_str" value='${empty json_contract_guarantee_method_str ? "[]" : json_contract_guarantee_method_str }'></input>
<input type="hidden" id="id_json_contract_guarantee_equip_str" name="json_contract_guarantee_equip_str" value='${empty json_contract_guarantee_equip_str ? "[]" : json_contract_guarantee_equip_str }'></input>
<%--
<input type="hidden" id="id_json_contract_supplier_str" name="json_contract_supplier_str" value='${empty json_contract_supplier_str ? "[]" : json_contract_supplier_str }'></input>
<input type="hidden" id="id_json_contract_list_str" name="json_contract_list_str" value='${empty json_contract_list_str ? "[]" : json_contract_list_str }'></input>
 --%>
<input type="hidden" id="id_json_contract_premise_str" name="json_contract_premise_str" value='${empty json_contract_premise_str ? "[]" : json_contract_premise_str }'></input>
<div id="contract_approval_form">
	<div class="fillTableContainer">
		<table class="fillTable" cellspacing="0" cellpadding="0">
			<tr>
				<td ><!-- 插入项目基本信息 --> <jsp:include page="contract_base_info.jsp"></jsp:include></td>
			</tr>
		</table>
	</div>
	<div id="tabDetails" class="mini-tabs" activeIndex="0" style="width:100%;">
		<div title="租赁物件" name="equipList">
			<jsp:include page="contract_equip_detail.jsp"></jsp:include>
		</div>
		<div title="担保单位信息" name="guaranteeDetail">
			<jsp:include page="contract_guarantee_detail.jsp"></jsp:include>
		</div>
		<div title="抵押物列表" name="guarantyDeatil">
			<jsp:include page="contract_guaranty_detail.jsp"></jsp:include>
		</div>
		<div title="合同各方" name="contractAllParties">
			<jsp:include page="contract_signatory.jsp"></jsp:include>
		</div>
		<div title="投放前提条件" name="contractCondition">
			<jsp:include page="contract_premise_info.jsp"></jsp:include>
		</div>
	</div>
</div>
<script>
jQuery(function(){
	$("#tabDetails").css({height:currentClientHeight-423});
});
mini.parse(document.getElementById("contract_approval_form"));

function fillHiddenVal(type){
	var grid_equip = mini.get("equip_detail");
	var grid_guarantee = mini.get("guarantee_detail");
	var grid_guaranty = mini.get("guaranty_detail");
	//var grid_equip = mini.get("");
	var grid_premise = mini.get("contract_premise");
	
	jQuery('#id_json_contract_equip_str').val(JsonUtil.encode(grid_equip.getData()));
	jQuery('#id_json_contract_guarantee_method_str').val(JsonUtil.encode(grid_guarantee.getData()));
	jQuery('#id_json_contract_guarantee_equip_str').val(JsonUtil.encode(grid_guaranty.getData()));
	//jQuery('#id_json_proj_equip_str').val(JsonUtil.encode(grid1.getData()));
	jQuery('#id_json_contract_premise_str').val(JsonUtil.encode(grid_premise.getData()));
}
</script>