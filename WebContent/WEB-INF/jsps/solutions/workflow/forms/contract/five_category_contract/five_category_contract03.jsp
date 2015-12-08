<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">

	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		return Validator.Validate(submitProcessedForm,1,false);;
	}
	//保存成功提交后，后台返回
	function saveCallBack() {
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		return Validator.Validate(submitProcessedForm,1,false);;
	}
	var isSubTable_assets = true;//标志主页面是否加载完成 只有在主页面加载完成再加载其他多行空间和下拉框之类的数据
	var isSubTable_business = true;//标志主页面是否加载完成 只有在主页面加载完成再加载其他多行空间和下拉框之类的数据
	var isSubTable_finance = true;//标志主页面是否加载完成 只有在主页面加载完成再加载其他多行空间和下拉框之类的数据
	var isSubTable_risk = true;//标志主页面是否加载完成 只有在主页面加载完成再加载其他多行空间和下拉框之类的数据
	var isSubTable_sale = true;//标志主页面是否加载完成 只有在主页面加载完成再加载其他多行空间和下拉框之类的数据

	var isViewHistoryTask = true;
	//var isform02 = true;
</script>

<!--多行控件  -->
<input type="hidden" id="id_json_generated_reports_str" name="json_generated_reports_str" value='${empty json_generated_reports_str ? "[]" : json_generated_reports_str }'></input>

<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td ><!-- 插入合同基本信息 --> <jsp:include	page="../contract_approval/contract_base_info.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td>
			<div id='id_project_info_tabs_content' style="">
				<div title="业务五级">
					<span class="print-tabs-title-content">业务五级</span>
					<div id="id_table_leasing_proj_condition_container" style="overflow: hidden;">
				    	<!-- 插入业务五级 --> <jsp:include page="business_five.jsp"></jsp:include>
				    </div>
				</div>
				<div title="资产五级">
					<span class="print-tabs-title-content">资产五级</span>
					<div id="id_table_leasing_proj_condition_container" style="overflow: hidden;">
				    	<!-- 插入业务五级 --> <jsp:include page="assets_five.jsp"></jsp:include>
				    </div>
				</div>
				<div title="财务五级">
					<span class="print-tabs-title-content">财务五级</span>
					<div id="id_table_leasing_proj_condition_container" style="overflow: hidden;">
					<script language="javascript">jQuery(function() {isViewHistoryTask = isCompletedTask;});</script>
				    	<!-- 插入业务五级 --> <jsp:include page="finance_five.jsp"></jsp:include>
				    <!-- <script language="javascript">jQuery("#five_category_content_finance input[name='five_category.contractfivedata_finance']").attr("isForceModify","true");</script> -->
					<script language="javascript">jQuery(function() {isViewHistoryTask = true;});</script>
				    </div>
				</div>
	        </div>
		</td>
	</tr>
	<tr>
		<td ><!-- 插入制作报告 --> <jsp:include	page="make_reports.jsp"></jsp:include></td>
	</tr>
	
	<!-- 插入已生成报告 -->
          <tr class="x-panel-table-div-title">
             <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-generated_reports"></div>已生成的报告 </td>
    </tr> 
    <tr><td colspan=6></td></tr>
    <tr class="tr-generated_reports">
    <td colspan=6 class="td-tabs-container" style="text-indent:0px;">
          	<!-- 标签栏 -->
          	<div id='id_project_info_tabs_content' style="">
				    	<div title="已生成的报告"><div id="id_table_leasing_generated_reports_container" style="overflow: hidden;"></div></div>
          	</div>
          </td>
          </tr> 

    
	</table>
</div>

<jsp:include page="generated_reports.jsp"></jsp:include> <!-- 已生成的报告 -->

<script>
	function formPageReadOnlyCallBack(){
	    if(!isCompletedTask){
		   formJSPInputHideOrShow("five_category_content_finance","",1);
	    }
	}
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		//第一个页签集合
		$("#id_contract_condition_tabs_content").css("width", (formWidth) + "px");
		$("#id_contract_condition_tabs_content").tabs();
		//第二个页签集合
		//$("#id_contract_info_tabs_content").css("width", (formWidth) + "px");
		//$("#id_contract_info_tabs_content").tabs();
		isSubTable = false;//标志主页面加载完成
		//var d = $("#id_contract_info_tabs_content");
		 $("#id_project_info_tabs_content").css("width",(formWidth)+"px");
		 $("#id_project_info_tabs_content").tabs();
		  
	});
	
	 
	  
	  
	//######五级分类#########
	//dict('id_contract_five_category_risk', 'five_category.contractfivename', 'five_class','${requestScope["five_category.contractfivename"]}', null, 'require="true" label="合同五级分类"');
		
		//隐藏域在提交或保存前的赋值
	function fillHiddenVal(){
		//已生成的报告
		var currentTable1 = getTracywindyObject('table_id_table_leasing_generated_reports_container');
		jQuery('#id_json_generated_reports_str').val(JsonUtil.encode(currentTable1.getRowsJsonData())) ;
		}
		
</script>