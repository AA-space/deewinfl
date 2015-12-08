
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--css sheet-->
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
	<!--javascript libray-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyMultiTable.js"></script>
<script type="text/javascript">
jQuery(function(){
	$("#btn_rent_cal").hide();//只读页面，隐藏 租金测算 按钮
	isViewHistoryTask = true;
    //########公共JS事件##########
    jQuery(".toggle-icon-expanded").click(toggleLeasingOperation); 
    $("#id_project_info_tabs_content").css("width",(formWidth)+"px");
    $("#id_project_info_tabs_content").tabs();
    $("#id_project_fund_rent_plan_tabs_content").css("width",(formWidth)+"px");
    $("#id_project_fund_rent_plan_tabs_content").tabs();
	//jQuery(".fillTableContainer").css("width",formWidth+"px");
	//######项目上基本信息#########
    dict('id_proj_type','contract_info.proj_type','proj_type','${requestScope["contract_info.proj_type"]}','${requestScope["rawValue_contract_info.proj_type"]}','require="true" label="项目类型"');
    dict('id_proj_scale','contract_info.proj_scale','proj_scale','${requestScope["contract_info.proj_scale"]}','${requestScope["rawValue_contract_info.proj_scale"]}','require="true" label="项目规模"');
    dict('id_proj_source','contract_info.proj_source','proj_source','${requestScope["contract_info.proj_source"]}','${requestScope["rawValue_contract_info.proj_source"]}','require="true" label="项目来源"');
    dict('id_cust_kind','contract_info.cust_kind','cust_kind','${requestScope["contract_info.cust_kind"]}','${requestScope["rawValue_contract_info.cust_kind"]}','require="true" label="内部行业"');
    dict('id_leas_type','contract_info.leas_type','leas_type','${requestScope["contract_info.leas_type"]}','${requestScope["rawValue_contract_info.leas_type"]}','require="true" label="项目类型"');
    dict('id_leas_form','contract_info.leas_form','leas_form','${requestScope["contract_info.leas_form"]}','${requestScope["rawValue_contract_info.leas_form"]}','require="true" label="租赁形式"');
    dict('id_insure_type','contract_condition.insure_type','insure_type','${requestScope["contract_condition.insure_type"]}','${requestScope["rawValue_contract_condition.insure_type"]}');
    dict('id_rent_invoice_type','contract_invoice_type.rent_invoice_type','rent_invoice_type','${requestScope["contract_invoice_type.rent_invoice_type"]}','${requestScope["rawValue_contract_invoice_type.rent_invoice_type"]}','',300);
    
    //#######商务条件##############
    dict('id_settle_method','contract_condition.settle_method','settle_method','${requestScope["contract_condition.settle_method"]}','${requestScope["rawValue_contract_condition.settle_method"]}','require="true" label="租金计算方法"');
    dict('id_period_type','contract_condition.period_type','period_type','${requestScope["contract_condition.period_type"]}','${requestScope["rawValue_contract_condition.period_type"]}','require="true" label="付租方式"');
    dict('id_income_number_year','contract_condition.income_number_year','income_number_year','${requestScope["contract_condition.income_number_year"]}','${requestScope["rawValue_contract_condition.income_number_year"]}', 'require="true" label="付租类型"');
    dict('id_adjust_style','contract_condition.adjust_style','adjust_style','${requestScope["contract_condition.adjust_style"]}','${requestScope["rawValue_contract_condition.adjust_style"]}');
    dict('id_rate_float_type','contract_condition.rate_float_type','rate_float_type','${requestScope["contract_condition.rate_float_type"]}','${requestScope["rawValue_contract_condition.rate_float_type"]}');
  //########公共下拉############
    commonSelect('id_proj_dept','t_depts','id_','name_','proj_info.projdept','${empty requestScope["proj_info.projdept"] ? sessionScope["loginUserDeptObj"].id : requestScope["proj_info.projdept"] }','${empty requestScope["rawValue_proj_info.projdept"] ? sessionScope["loginUserDeptObj"].id : requestScope["rawValue_proj_info.projdept.name"] }', null,'require="true" label="出单部门"');
     commonSelect('id_proj_registrar','t_users','id_','realname_','contract_info.proj_registrar','${empty requestScope["contract_info.proj_registrar"] ? sessionScope.loginUser.id : requestScope["contract_info.proj_registrar"]}','${empty requestScope["rawValue_contract_info.proj_registrar"] ? sessionScope.loginUser.id : requestScope["rawValue_contract_info.proj_registrar.realname"]}','require="true" label="录入人员"');
    commonSelect('id_proj_manage','t_users','id_','realname_','contract_info.proj_manage','${empty requestScope["contract_info.proj_manage"] ? sessionScope.loginUser.id : requestScope["contract_info.proj_manage"]}','${empty requestScope["rawValue_contract_info.proj_manage"] ? sessionScope.loginUser.realname : requestScope["rawValue_contract_info.proj_manage.realname"]}','require="true" label="客户经理"');
    commonSelect('id_proj_assist','t_users','id_','realname_','contract_info.proj_assist','${empty requestScope["contract_info.proj_assist"] ? sessionScope.loginUser.id : requestScope["contract_info.proj_assist"]}','${empty requestScope["rawValue_contract_info.proj_assist"] ? sessionScope.loginUser.realname : requestScope["contract_info.proj_assist.realname"]}','require="true" label="客户助理"');
    //特殊下拉
    //dictYesOrNo('id_is_before_interest','is_before_interest','${empty is_before_interest? "否":is_before_interest}');
    dictYesOrNo('id_IsInvoiceRentSplit','contract_invoice_type.isInvoiceRentSplit','isInvoiceRentSplit','${empty requestScope["contract_invoice_type.isinvoicerentsplit"] ? "否" : requestScope["contract_invoice_type.isinvoicerentsplit"] }');
    dictYesOrNo('id_BoolInvoice','contract_invoice_type.boolInvoice','boolInvoice','${empty requestScope["contract_invoice_type.boolinvoice"] ? "否" : requestScope["contract_invoice_type.boolinvoice"] }');
    
	var combo1 = new tracywindyComboBox({
		lazyLoad:true,
		id:'id_combo_is_before_interest',
				renderTo:'id_is_before_interest',
				loadMode:'local',
				width:165,
			    datas:[{title:'否',name:'否'},{title:'是',name:'是'}],
			    readOnly:true,
			    dropListHeight:70,
			    topAdd:0,
		        leftAdd:0,
		        isContainEmpty:false,
				rawValue:'${empty requestScope["rawValue_contract_condition.is_before_interest"] ? "否" : requestScope["rawValue_contract_condition.is_before_interest"] }',
				name:'contract_condition.is_before_interest',
				displayField:'title',
				valueField:'name',
				leftAdd:0,
				onSelect:function(combo){
					chargeBefInte();
					}
	});
});
    //是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		createProjectName();
		return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack()
	{
		//var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		//alert(Validator);
		return true;
    }
	//是否提交    
    function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
    {
    	fillHiddenVal();
    	createProjectName();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		return isPassed;
		//return true;
    }
</script>
<input type="hidden" id="id_json_proj_equip_str" name="json_proj_equip_str" value='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }'></input>
<input type="hidden" id="id_json_fund_rent_plan_str" name="json_fund_rent_plan_str" value='${empty json_fund_rent_plan_str ? "[]" : json_fund_rent_plan_str }'></input>
<input type="hidden" id="id_json_fund_rent_cash_str" name="json_fund_rent_cash_str" value='${empty json_fund_rent_cash_str ? "[]" : json_fund_rent_cash_str }'></input>
<input type="hidden" id="id_json_proj_guarantee_method_str" name="json_proj_guarantee_method_str" value='${empty json_proj_guarantee_method_str ? "[]" :  json_proj_guarantee_method_str}'></input>
<input type="hidden" id="id_json_proj_guarantee_equip_str" name="json_proj_guarantee_equip_str" value='${empty  json_proj_guarantee_equip_str ? "[]" : json_proj_guarantee_equip_str}'></input>
<div class="fillTableContainer">
  <table class="fillTable" cellspacing="0" cellpadding="0">
          <tr>
             <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-info"></div>项目基本信息</td>
          </tr>
          <tr class="tr-project-info tr-even">
             <td class="td-content-title">合同编号：</td><td class="td-content"><input name="contract_info.contract_id" class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['contract_info.contract_id']}"></td>
             <td class="td-content-title">项目日期：</td><td class="td-content"><input name="contract_info.proj_date" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['contract_info.proj_date'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="项目日期" /><font class="required-content">*</font></td>
             <td class="td-content-title">承租单位：</td><td class="td-content"><input name="cust_name" class="td-content-input td-content-readonly" readOnly require="true" label="承租单位"  type="text" value="${requestScope['contract_info.cust_name'] }" ><font class="required-content">*</font></td>
          </tr>
          <tr class="tr-project-info tr-odd">   
             <td class="td-content-title">客户编号：</td><td class="td-content"><input name="rawValue_contract_info.cust_id" class="td-content-input td-content-readonly" readOnly  type="text"  value="${requestScope['contract_info.cust_number'] }"><font class="required-content">*</font></td>
             <td class="td-content-title">活动类型：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_type"></div><font class="required-content">*</font></td>
             <td class="td-content-title">项目规模：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_scale"></div><font class="required-content">*</font></td>
          </tr>
          <tr class="tr-project-info tr-even">  
             <td class="td-content-title">项目来源：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_source"></div><font class="required-content">*</font></td>
             <td class="td-content-title">内部行业：</td><td class="td-content"><div class="leftComboContainer" id="id_cust_kind"></div><font class="required-content">*</font></td>
             <td class="td-content-title">固定资产分类：</td><td class="td-content"><div class="leftComboContainer" id="id_leas_type"></div><font class="required-content">*</font></td>
          </tr>
          <tr class="tr-project-info tr-odd">
             <td class="td-content-title">租赁形式：</td><td class="td-content"><div class="leftComboContainer" id="id_leas_form"></div><font class="required-content">*</font></td>
             <td class="td-content-title">项目出单部门：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_dept"></div><font class="required-content">*</font></td>
             <td class="td-content-title">录入人员：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_registrar"></div><font class="required-content">*</font></td>
          </tr>
          <tr class="tr-project-info tr-even">   
             <td class="td-content-title">客户经理：</td><td class="td-content"  colspan="3"><div class="leftComboContainer" class="leftComboContainer" id="id_proj_manage"></div><font class="required-content">*</font></td>
            <%--
             <td class="td-content-title">客户助理：</td><td class="td-content"><div class="leftComboContainer" id="id_proj_assist"></div><font class="required-content">*</font></td>
             <td class="td-content-title">&nbsp;</td><td class="td-content">&nbsp;</td>
             --%>
          </tr>
          <tr class="tr-project-info tr-odd">
             <td class="td-content-title">项目名称：</td><td class="td-content" colspan=5><input style="width:60%" name="contract_info.project_name" id="project_name" class="td-content-input"  type="text" value="${requestScope['contract_info.project_name']}" onclick="createProjectName();" ><font class="required-content" style="width:150px;">（系统自动生成）* </font></td>
          </tr>
          <tr><td colspan=6 class="td-even-line-separator">&nbsp;</td></tr>
           <tr class="x-panel-table-div-title">
             <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-survey"></div>项目概况</td>
          </tr>
          <tr class="tr-project-survey tr-odd"><td class="td-content"  colspan=6><textarea rows="5" cols="150" style="width: 98%" name="contract_info.proj_survey">${requestScope['contract_info.proj_survey'] }</textarea> </td></tr>    
          <tr><td colspan=6 class="td-even-line-separator">&nbsp;</td></tr>
          <tr class="x-panel-table-div-title">
             <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-special-industries"></div>特殊行业说明</td>
          </tr>
          <tr class="tr-project-special-industries tr-odd">
          	 <td class="td-content"  colspan=6><textarea rows="5"  style="width: 98%" id="special_industries" name="contract_info.special_industries">${requestScope['contract_info.special_industries'] }</textarea> </td>
          </tr>  
          <tr><td colspan=6 class="td-even-line-separator">&nbsp;</td></tr>
          <tr class="x-panel-table-div-title">
             <td class="x-panel-table-div-title" colspan=6><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-business-condition"></div>项目商务条件 </td>
          </tr> 
          <tr><td colspan=6></td></tr>
          <tr class="tr-project-business-condition">
          <td colspan=6 class="td-tabs-container" style="text-indent:0px;">
          	<!-- 标签栏 -->
          	<div id='id_project_info_tabs_content' style="">
				    	<div title="租赁物明细"><span class="print-tabs-title-content">租赁物明细</span><div id="id_table_leasing_proj_equip_container" style="overflow: hidden;"></div></div>
				    	<div title="拟商务条件"><span class="print-tabs-title-content">拟商务条件</span><div id="id_table_leasing_proj_condition_container" style="overflow: hidden;">
				    	<jsp:include page="contract_condition.jsp"></jsp:include>
				    	</div></div>
				    	<div title="担保单位信息"><span class="print-tabs-title-content">担保单位信息</span><div id="id_table_leasing_proj_guarantee_method_container" style="overflow: hidden;"></div></div>
				    	<div title="抵/质押物列表"><span class="print-tabs-title-content">抵/质押物列表</span><div id="id_table_leasing_proj_guarantee_equip_container" style="overflow: hidden;"></div></div>
				    	<div title="风险 防范措施"><span class="print-tabs-title-content">风险 防范措施</span><div id="id_table_leasing_proj_protect_container" style="height:350px;">
				    	  <textarea rows="15"  style="width: 98%;margin-top:20px;" id="risk_prevention_measures" name="contract_info.risk_prevention_measures">${requestScope['contract_info.risk_prevention_measures'] }</textarea>
				    	</div></div>
				    	<div title="其他商务条件"><span class="print-tabs-title-content">其他商务条件</span><div id="id_table_leasing_proj_other_container"  style="height:350px;">
				    	<textarea rows="15"  style="width: 98%;margin-top:20px;" id="other_condition" name="contract_info.other_condition">${requestScope['contract_info.other_condition'] }</textarea>
				    	</div></div>
				    	<div title="租金发票类型"><span class="print-tabs-title-content">租金发票类型</span><div id="id_table_leasing_proj_rent_type_container"  style="height:350px;">
				    	<table class="fillTable" cellspacing="0" cellpadding="0" width="50%">
					          <tr class="tr-odd">   
					             <td class="td-content-title">租金发票类型：</td><td class="td-content" colspan=3>
					             <div id="id_rent_invoice_type"></div>
					             </td>
					          </tr>
					          <tr class="tr-odd">  
					             <td class="td-content-title">租金发票本利金是否拆分：</td><td class="td-content"><div class="leftComboContainer" id="id_IsInvoiceRentSplit"></div></td> 
					             <td class="td-content-title">发票为放款先决条件：</td><td class="td-content"><div class="leftComboContainer" id="id_BoolInvoice"></div></td>
					          </tr>
				    	</table>
				    	</div></div>
          	</div>
          </td>
          </tr> 
    </table>	
 </div>
<!--避免在tabs中的js重复执行-->
<jsp:include page="contract_equip_detail.jsp"></jsp:include>
<jsp:include page="contract_fund_rent_plan.jsp"></jsp:include>
<jsp:include page="contract_fund_rent_cash.jsp"></jsp:include>
<jsp:include page="contract_guarantee_method.jsp"></jsp:include>
<jsp:include page="contract_guarantee_equip.jsp"></jsp:include>

<script>
//隐藏域在提交或保存前的赋值
	function fillHiddenVal(){
		//租赁物件
		var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');
		jQuery('#id_json_proj_equip_str').val(JsonUtil.encode(currentTable1.getRowsJsonData())) ;
		//租金计划
		var currentTable2 = getTracywindyObject('table_leasing_table_fund_rent_plan');
		jQuery('#id_json_fund_rent_plan_str').val(JsonUtil.encode(currentTable2.getRowsJsonData())) ;
		//现金流
		var currentTable3 = getTracywindyObject('table_leasing_table_fund_rent_cash');
		jQuery('#id_json_fund_rent_cash_str').val(JsonUtil.encode(currentTable3.getRowsJsonData())) ;
		//担保单位信息
		var currentTable4 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');
		jQuery('#id_json_proj_guarantee_method_str').val(JsonUtil.encode(currentTable4.getRowsJsonData())) ;
		//抵押物列表
		var currentTable5 = getTracywindyObject('table_id_table_leasing_proj_guarantee_equip_container');
		jQuery('#id_json_proj_guarantee_equip_str').val(JsonUtil.encode(currentTable5.getRowsJsonData())) ;
		
		}
	//生成项目名称
	function createProjectName(){
		var project_name=document.getElementById("project_name").value;
		var dept_name=getTracywindyObject('id_combo_contract_info.proj_dept').getRawValue();
		var cust_kind=getTracywindyObject('id_combo_cust_kind').getRawValue();
		var leas_form=getTracywindyObject('id_combo_leas_form').getRawValue();
		if(project_name==''){
			project_name=dept_name+cust_kind+leas_form+'项目';
			}
		jQuery('#project_name').val(project_name);
		}
</script>