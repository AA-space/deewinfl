
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
	<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!-- 插入样式和JS -->
<jsp:include page="../proj_approval/base.jsp"></jsp:include>
<!-- 特殊附件显示公用方法 -->
<jsp:include page="../../util/proj_view_file.jsp"></jsp:include>
<!-- 项目立项附件带到租前业务相关流程 -->
<jsp:include page="initFileListParams.jsp"></jsp:include>
<script type="text/javascript">
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		 
		//fillHiddenVal();
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
		//fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return isPassed;}
		//if(!checkTracywindyTableData("table_id_table_leasing_proj_equip_container","租赁物明细")){return false;}//检查租赁物明细
		//if(!validataTotalMoney()){return false;}
		return true;
	}
	
</script>
<input type="hidden" id="id_json_proj_equip_str" name="json_proj_equip_str" value='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }'></input>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr  id="proj_base_info">
		<td colspan=4><!-- 插入项目基本信息 --> 
		   <script language="javascript">jQuery(function() {isViewHistoryTask = true;});</script> 
		       <jsp:include page="../proj_approval/proj_base_info.jsp"></jsp:include>
		   <script language="javascript">jQuery(function() {isViewHistoryTask = false;});</script>	
		</td>
	</tr>
	<permission:action  code="admin_action">
	<tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
			<!-- 标签栏 -->
			<div id='id_project_info_tabs_content' style="">
					<div title="租赁物明细">
						<span class="print-tabs-title-content">租赁物明细</span>
						<div id="id_table_leasing_proj_equip_container"	style="overflow: hidden;">
						<jsp:include page="../../project/proj_approval/proj_equip_detail.jsp"></jsp:include>
						</div>
			       </div>
				   <div title="商务报价">
						<span class="print-tabs-title-content">商务报价</span>
						<div id="id_table_leasing_contract_condition_container"	style="overflow: hidden;">
							<jsp:include page="../../rent_reckon/rent_reckon/main.jsp" flush="true"/>
						</div>
					</div>
				<div title="租金发票类型">
				    <span class="print-tabs-title-content">租金发票类型</span>
					<div id="id_table_leasing_proj_rent_type_container"  style="height:350px;">
				    	<jsp:include page="proj_invoice.jsp"></jsp:include>
				    </div>
			    </div>
			</div>
		</td>
	</tr>
	</permission:action>
</table>
</div>
<script type="text/javascript">
function fillHiddenVal() {
	//租赁物件
	var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');
	jQuery('#id_json_proj_equip_str').val(
			JsonUtil.encode(currentTable1.getRowsJsonData()));
}
  
   //isViewHistoryTask = false;
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
