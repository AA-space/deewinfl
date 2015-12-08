<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<jsp:include page="../project/proj_approval/base.jsp"></jsp:include> 

<!-- start  显示合同基本信息-->
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<tr>
		<td ><jsp:include page="../contract/contract_approval/contract_base_info.jsp"></jsp:include></td>
	</tr>
	 
	</table>
</div>
<!-- end  显示合同基本信息-->

<!-- start 显示发票信息 -->
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<tr class="tr-contract-business-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
		<div id='id_contract_info_tabs_content' style="">
			<div title="租金发票类型">
				<span class="print-tabs-title-content">租金发票类型</span>
				<div id="id_table_leasing_contract_rent_type_container"	style="overflow: hidden;">
					<jsp:include page="../contract/contract_approval/contract_invoice_info.jsp"></jsp:include>
				</div>
			</div>
			 
		</div>
		</td>
	</tr>
	</table>
</div>
<!-- end 显示发票信息 -->

<script>
	var checkContractId = false;
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
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return isPassed;}
		return true;
	}
	var isSubTable = true;//标志主页面是否加载完成 只有在主页面加载完成再加载其他多行空间和下拉框之类的数据
	isViewHistoryTask = true;//全局变量说是这一个只读页面
	/*初始化调用*/
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		//第一个页签集合
		$("#id_contract_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_contract_info_tabs_content").tabs();
		isSubTable = false;//标志主页面加载完成
	});
</script>