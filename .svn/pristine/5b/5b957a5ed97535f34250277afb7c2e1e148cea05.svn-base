<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
	var checkContractId=false;
	var jsonStrCheck=true;//校验多行必须填写
	var jsonStrCheckMSG="";
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		if(jsonStrCheckMSG!=""){
			if(confirm("如下重要数据为空白,请确认是否继续?\n"+jsonStrCheckMSG)){
				jsonStrCheck=true;
			}else{
				jsonStrCheck=false;
			}
			jsonStrCheckMSG="";
		}
		if(jsonStrCheck){
			var submitProcessedForm = document.getElementById("id_submitProcessedForm");
			var isPassed = Validator.Validate(submitProcessedForm,1,false);
			if(!isPassed){return isPassed;}
			//检查租赁物明细
			if(!checkTracywindyTableData("table_id_table_leasing_contract_equip_container","租赁物明细")){return false;}
			//担保信息
			if(!checkTracywindyTableData("table_id_table_leasing_contract_guarantee_method_container","担保单位信息")){return false;}
			//租金计划
			if(!checkTracywindyTableData("table_id_table_leasing_rent_plan_container","租金计划")){return false;}
			//前提条件
			if(!checkTracywindyTableData("table_id_table_leasing_contract_premise_container","前提条件")){return false;}
			//卖方/供应商
			if(!checkTracywindyTableData("table_id_table_leasing_contract_supplier_container","卖方/供应商")){return false;}
			
			return true;
		}else{
			return jsonStrCheck;
		}
	}
	//保存成功提交后，后台返回
	function saveCallBack(rs) {
		if(String(rs)!=""){
			alert(rs);
			checkContractId=false;
		}else{
			checkContractId=true;
		}
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		if(checkContractId){
			return workflowSaveCallBack();
		}else{
			alert("请先点击保存以便校验合同号,或者您的合同号唯一校验未通过!");
			document.getElementById("contract_info.contractid").select();
			return false;
		}
	}
	//是否提交  
	var isSelectRote=false; 
	var selectRote=""; 
	function workflowSubmitCallBack(buttonText)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		if(checkContractId){
			var condtion="[{condtion:'正常审批',rote:'TO 2业务部门经理审核'},{condtion:'直接审批',rote:'TO 10总经理审批'}]";
			if(buttonText=="提交"){
		       if(!isSelectRote){
		          selectRoteByCondtion(condtion);
		          return false;
	         }}
	        isSelectRote=false;
			return true;
		}else{
			alert("请先点击保存以便校验合同号,或者您的合同号唯一校验未通过!");
			document.getElementById("contract_info.contractid").select();
			return false;
		}
		
	}
	function workflowNextRouteCallBack(buttonText,requestNextRoute){
         if(buttonText=="提交"){
             alert(selectRote);
        	 requestNextRoute.value=selectRote;
         }
    }
	var isSubTable = true;//标志主页面是否加载完成 只有在主页面加载完成再加载其他多行空间和下拉框之类的数据
</script>
<!--多行控件  -->
<input type="hidden" id="id_json_proj_equip_str" name="json_proj_equip_str"  value='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }'></input>
<input type="hidden" id="id_json_contract_guarantee_method_str" name="json_contract_guarantee_method_str" value='${empty json_contract_guarantee_method_str ? "[]" : json_contract_guarantee_method_str }'></input>
<input type="hidden" id="id_json_contract_guarantee_equip_str" name="json_contract_guarantee_equip_str" value='${empty json_contract_guarantee_equip_str ? "[]" : json_contract_guarantee_equip_str }'></input>
<input type="hidden" id="id_json_contract_supplier_str" name="json_contract_supplier_str" value='${empty json_contract_supplier_str ? "[]" : json_contract_supplier_str }'></input>
<input type="hidden" id="id_json_contract_premise_str" name="json_contract_premise_str" value='${empty json_contract_premise_str ? "[]" : json_contract_premise_str }'></input>
<input type="hidden" id="id_json_contract_list_str" name="json_contract_list_str" value='${empty json_contract_list_str ? "[]" : json_contract_list_str }'></input>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td ><!-- 插入项目基本信息 --> <jsp:include	page="../contract_approval/contract_base_info.jsp"></jsp:include></td>
	</tr>
	</table>
</div>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<tr class="tr-contract-business-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
		<div id='id_contract_info_tabs_content' style="">
			<div title="租赁物明细">
				<span class="print-tabs-title-content">租赁物明细</span>
				<div id="id_table_leasing_proj_equip_container"	style="overflow: hidden;"></div>
			</div>
			<div title="商务报价">
				<span class="print-tabs-title-content">商务报价</span>
				<div id="id_table_leasing_contract_condition_container"	style="overflow: hidden;">
					<jsp:include page="../../rent_reckon/rent_reckon/main.jsp" flush="true"/>
				</div>
			</div>
			<div title="担保单位信息">
				<span class="print-tabs-title-content">担保单位信息</span>
				<div id="id_table_leasing_contract_guarantee_method_container"	style="overflow: hidden;"></div>
			</div>
			<div title="合同各方">
				<span class="print-tabs-title-content">合同各方</span>
				<div id="id_table_leasing_contract_signatory_container"	style="overflow: hidden;">
					<jsp:include page="../contract_approval/contract_signatory.jsp"></jsp:include>
				</div>
			</div>
			<div title="前提条件">
				<span class="print-tabs-title-content">前提条件</span>
				<div id="id_table_leasing_contract_premise_container"	style="overflow: hidden;"></div>
			</div>
			<div title="合同制作">
				<span class="print-tabs-title-content">合同制作</span>
				<div id="id_table_leasing_contract_make_container"	style="overflow: hidden;">
					<jsp:include page="../contract_approval/contract_new_word.jsp"></jsp:include>
				</div>
			</div>
			<div title="签约信息">
				<span class="print-tabs-title-content">签约信息</span>
				<div id="id_table_leasing_contract_sign_container"	style="overflow: hidden;">
					<table cellspacing="0" cellpadding="0" style="width: 98%; margin-top: 20px;" >
						 <tr  class="tr-contractect-other-info tr-even">
						    <td class="td-content-title">签约时间：</td><td class="td-content"><input class="Wdate td-content-input" readonly name="contract_other_info.signdate" class="td-content-input"  type="text" value="${requestScope['contract_other_info.signdate']}" onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="签约时间"><font class="required-content">*</font></td>
						    <td class="td-content-title">签约地点：</td><td class="td-content"><input name="contract_other_info.signplace" class="td-content-input" type="text" value="${requestScope['contract_other_info.signplace']}" require="true" label="签约地点"><font class="required-content">*</font></td>
						</tr>
						<tr  class="tr-contractect-other-info tr-odd">
						    <td class="td-content-title">签约人：</td><td class="td-content" colspan="3"><div class="leftComboContainer" style="width: 99%;"><textarea rows="3"  style="width: 95%;float:left;" name="contract_other_info.signperson" require="true" label="签约人">${requestScope['contract_other_info.signperson']}</textarea></div><font class="required-content">*</font></td>
						</tr>
					</table>
				</div>
			</div>
			<div title="租金发票类型">
				<span class="print-tabs-title-content">租金发票类型</span>
				<div id="id_table_leasing_contract_rent_type_container"	style="overflow: hidden;">
					<jsp:include page="../contract_approval/contract_invoice_type.jsp"></jsp:include>
				</div>
			</div>
			<div title="税号">
				<span class="print-tabs-title-content">税号</span>
				<div id="id_table_leasing_contract_invoice_info_container"	style="overflow: hidden;">
					<jsp:include page="../contract_approval/contract_invoice_info.jsp"></jsp:include>
				</div>
			</div>
		</div>
		</td>
	</tr>
</table>
</div>
<%--避免在tabs中的js重复执行--%>
<%--<jsp:include page="contract_equip_detail.jsp"></jsp:include>租赁物件 --%>
<jsp:include page="../../project/proj_approval/proj_equip_detail.jsp"></jsp:include>
<jsp:include page="../contract_approval/contract_guarantee_method.jsp"></jsp:include><%--担保 --%>
<jsp:include page="../contract_approval/contract_premise_info.jsp"></jsp:include><%--前提条件 --%>
<%--引入流程二选一页面 --%>
<jsp:include page="../../util/flow_condition_select.jsp"></jsp:include>
<script>
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		var contractEquip = getTracywindyObject('table_id_table_leasing_proj_equip_container');//租赁物件
		jQuery('#id_json_contract_equip_str').val(JsonUtil.encode(contractEquip.getRowsJsonData()));
		var contractGuaranteeMethod = getTracywindyObject('table_id_table_leasing_contract_guarantee_method_container');//担保
		jQuery('#id_json_contract_guarantee_method_str').val(JsonUtil.encode(contractGuaranteeMethod.getRowsJsonData()));
		if(contractGuaranteeMethod.getRowsJsonData()==''||contractGuaranteeMethod.getRowsJsonData()=='[]'){
			jsonStrCheck=false;
			jsonStrCheckMSG+="担保单位信息,";
		}
		var contractGuaranteeEqui = getTracywindyObject('table_id_table_leasing_contract_guarantee_equip_container');//抵押
		jQuery('#id_json_contract_guarantee_equip_str').val(JsonUtil.encode(contractGuaranteeEqui.getRowsJsonData()));
		var contractPremise = getTracywindyObject('table_id_table_leasing_contract_premise_container');//前提条件
		jQuery('#id_json_contract_premise_str').val(JsonUtil.encode(contractPremise.getRowsJsonData()));
		var contractList = getTracywindyObject('table_id_table_leasing_contract_list_container');//合同清单
		jQuery('#id_json_contract_list_str').val(JsonUtil.encode(contractList.getRowsJsonData()));
		var contractSupplier = getTracywindyObject('table_id_table_leasing_contract_supplier_container');//合同各方中的供应商
		jQuery('#id_json_contract_supplier_str').val(JsonUtil.encode(contractSupplier.getRowsJsonData()));
		if(!saveReckonJsonValue()){
			jsonStrCheck=false;
			jsonStrCheckMSG+="租金测算信息";//保存租金测算结果
		}
	}
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		//第一个页签集合
		$("#id_contract_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_contract_info_tabs_content").tabs();
		isSubTable = false;//标志主页面加载完成
	});
</script>