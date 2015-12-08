
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
   var isSubTable = true;
   isViewHistoryTask = true;
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		//createProjectName();
		return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack() {
		//var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		//alert(Validator);
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		//检查租赁物明细
		if(!checkTracywindyTableData("table_id_table_receivercharge_container","本次收款信息")){return false;}  
		 if(!checkFundCharge()){return false;}
		return true;
	}
	
</script>
<!--多行控件  -->
<!-- 历史收款 -->
<input type="hidden"  id="id_json_receiverchargehistory_str" name="json_receiverchargehistory_str" value='${empty json_receiverchargehistory_str ? "[]" : json_receiverchargehistory_str }'/>
<!-- 本次收款 -->
<input  type="hidden" id="id_json_receivercharge_str" name="json_receivercharge_str" value='${empty json_receivercharge_str ? "[]" : json_receivercharge_str }'/>

<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
   <tr>
		<td ><!-- 插入合同基本信息 --> 
		<jsp:include	page="distributor_base_info.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td class="x-panel-table-div-title" >
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-info"></div>网银信息</td>
	</tr>
	<tr>
	<td class="td-tabs-container" style="text-indent: 0px;">
	  <div id="id_table_leasing_fundebankdata_container" style="overflow: hidden;">
		    <jsp:include page="../../fund/fund_collection/fund_ebankdata.jsp"></jsp:include>
		    </div>
	</td>  
	</tr>
	<tr>
		<td class="x-panel-table-div-title" >
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-info"></div>历史收款明细</td>
	</tr>
	<tr>
	<td class="td-tabs-container" style="text-indent: 0px;">
	  <div id="id_table_receiverchargehistory_container" style="overflow: hidden;">
		    </div>
	</td>  
	</tr>
	<tr>
		<td class="x-panel-table-div-title" >
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-info"></div>本次收款信息</td>
	</tr>
	<tr>
	<td class="td-tabs-container" style="text-indent: 0px;">
	   <div id="id_table_receivercharge_container" style="overflow: hidden;">
		    </div>
	</td>  
	</tr>
</table>
</div>
 <script language="javascript">
   jQuery(function() {isViewHistoryTask = isCompletedTask;});
</script>
<jsp:include page="fund_receiverchargehistory.jsp"></jsp:include>
<jsp:include page="fund_receivercharge.jsp"></jsp:include>
 <script language="javascript">
   jQuery(function() {isViewHistoryTask = true;});
</script>
<script>
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
     //历史收款
		var currentTable1 = getTracywindyObject('table_id_table_receiverchargehistory_container');
		jQuery('#id_json_receiverchargehistory_str').val(
				JsonUtil.encode(currentTable1.getRowsJsonData()));
		//本次实收
		var currentTable1 = getTracywindyObject('table_id_table_receivercharge_container');
		jQuery('#id_json_receivercharge_str').val(
				JsonUtil.encode(currentTable1.getRowsJsonData()));
	}
	var isSubTable = true;
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		
		$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_project_info_tabs_content").tabs();
		isSubTable = false;
	
		jQuery(".fillTableContainer").css("width",formWidth+"px");
		
	});
</script>
