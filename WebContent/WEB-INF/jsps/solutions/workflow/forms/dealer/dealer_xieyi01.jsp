<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="base.jsp"></jsp:include>

<script type="text/javascript">

	 
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		return true;
	}

	//保存成功提交后，后台返回
	function saveCallBack(rs) {
		 
		return true;
	}
 
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		if(!Validator.Validate(submitProcessedForm,1,false)){return false;}
		return true;
	}
	 
	
	var isSubTable = true;//标志主页面是否加载完成 只有在主页面加载完成再加载其他多行空间和下拉框之类的数据
</script>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<tr>
		<td><jsp:include	page="dealer_base_info.jsp"></jsp:include></td>
	</tr>
	</table>
</div>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<tr class="tr-contract-business-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
		<div id='id_contract_info_tabs_content' style="">
			<div title="暂停经销商立项">
				<div id="id_table_leasing_contract_sign_container"	style="overflow: hidden;">
					<table  cellspacing="0" cellpadding="0">
					<tr>
		             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contractect-other-info"></div>暂停经销商立项</td>
		          </tr>
						 <tr  class="tr-contractect-other-info tr-even">
						    <td class="td-content-title">是否暂停经销商立项：</td>
						    <td class="td-content">
						    <div class="leftComboContainer" id="id_zant"></div><font class="required-content">*</font></td>
						</tr>
						<tr  class="tr-contractect-other-info tr-odd">
						    <td class="td-content-title">备注：</td>
						    <td class="td-content" colspan="3">
						    <div class="leftComboContainer" style="width: 1000px;"><textarea rows="5"  style="width: 95%;float:left;" name="memo">${requestScope['memo']}</textarea></div>
						    </td>
						</tr>
					</table>
				</div>
			</div>
			 
		</div>
		</td>
	</tr>
</table>
</div>
<%--避免在tabs中的js重复执行--%>
 <script>
 
//初始化调用
	jQuery(function() {
		dictYesOrNoByCode('id_zant','zant','${empty requestScope["zant"] ? "1" : requestScope["zant"] }','',true,' require="true" label="是否暂停经销商立项"');
		//########公共JS事件##########
		$("#id_contract_info_tabs_content").tabs();
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		//第一个页签集合
		$("#id_contract_info_tabs_content").css("width", (formWidth) + "px");
		//$("#id_contract_info_tabs_content").tabs();
		isSubTable = false;//标志主页面加载完成
	});
 </script>