
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="base.jsp"></jsp:include>
<!-- 特殊附件显示公用方法 -->
<jsp:include page="../../util/proj_view_file.jsp"></jsp:include>
<!-- 项目立项附件带到租前业务相关流程 -->
<jsp:include page="initFileListParams.jsp"></jsp:include>
<script type="text/javascript">
//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		createProjectName();
		return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack() {
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack(buttonText)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		//added by tracywindy 2013-11-22 解决永远提示没有测算的问题开始
		var beforeCheckedCondition = chenckCondiotn;
		//added by tracywindy 2013-11-22 解决永远提示没有测算的问题结束
		
		createProjectName();
		//必填
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return isPassed;}
		//判断
	    if(!checkTracywindyTableData("table_id_table_leasing_proj_equip_container","租赁物明细")){return false;}//检查租赁物明细
	  //德银不需要验证担保人必填
		//if(!checkTracywindyTableData("table_id_table_leasing_proj_guarantee_method_container","担保单位信息")){return false;}//担保信息
	    if(!checkTracywindyTableData("table_id_table_leasing_rent_plan_container","租金计划")){return false;}//租金计划
	    //added by tracywindy 2013-11-22 解决永远提示没有测算的问题开始
	    chenckCondiotn = beforeCheckedCondition;
	    //added by tracywindy 2013-11-22 解决永远提示没有测算的问题结束
		if(!validataTotalMoney()){return false;}
	    //检查附件
		if(!checkInvoiceFile()){return false};
		return true;
	}
	//流程提交是设置条件路由
	function workflowNextRouteCallBack(buttonText,requestNextRoute){
        if(buttonText=="Submit"){
        	var law="TO 02法人客户信用分析师检查资料";
    		var ewlp="TO 03个人客户信用分析师检查资料";
    		var oneLevel ="TO 012一级经销商处理";
    		var twolevelstatus="${requestScope['proj_info.twolevelstatus'] }";
    		if(twolevelstatus=="0"){
    			requestNextRoute.value=oneLevel;//走   是二级经销商判断
    		}
    		else
    		{
	    		if("${requestScope['proj_info.cust_type']}"=="法人"){
	       			requestNextRoute.value=law;
	    		}else{
	    			requestNextRoute.value=ewlp;
	    		}
    		}
        }
   } 
//留购价款=100元*车头数，车头数即非挂车数量
function countLeaveTheToy(){
    var liugoujiasum = 0;
	var currentTable = getTracywindyObject('table_id_table_leasing_proj_equip_container');
	datas = currentTable.getRowsJsonData();
	 for (var i = 0; i < datas.length; i++) {
			if (datas[i].equipclass != "equip_class_2") {
					liugoujiasum++;
			}
	 }
	 //修改了商务条件就需要重新测算租金
     if($("#nominalPrice").val()!=100*liugoujiasum){
	    $("#nominalPrice").val(100*liugoujiasum);
	    //chenckCondiotn=false;
	    //ie以外的浏览器需要不支持js改变值的事件，需重新计算商务条件
		equipAmt();
     }
	return true;
}
	
</script>
<!--多行控件  -->
<input type="hidden" id="id_json_proj_equip_str" name="json_proj_equip_str" value='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }'></input>
<input type="hidden" id="id_json_proj_guarantee_method_str" 	name="json_proj_guarantee_method_str" value='${empty json_proj_guarantee_method_str ? "[]" : json_proj_guarantee_method_str }'></input>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan=4><!-- 插入项目基本信息 --> <jsp:include
			page="proj_base_info_forcredit.jsp"></jsp:include></td>
	</tr>	
	<tr>
		<td colspan=4><!-- 插入项目其它基本信息 --> <jsp:include
			page="proj_base_other_info.jsp"></jsp:include></td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-project-business-condition"></div>
		项目商务条件</td>
	</tr>
	<tr>
		<td colspan=4></td>
	</tr>
	<tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
			<!-- 标签栏 -->
			<div id='id_project_info_tabs_content' style="">
					<div title="租赁物明细">
					    <span class="print-tabs-title-content">租赁物明细</span>
						<div id="id_table_leasing_proj_equip_container" style="overflow: hidden;"></div>
					</div>
					<div title="拟商务条件">
					 	<span class="print-tabs-title-content">拟商务条件</span>
						<div id="id_table_leasing_proj_condition_container" style="overflow: hidden;">
							<jsp:include page="../../rent_reckon/rent_reckon/main.jsp"></jsp:include></div>
						</div>
					<div title="担保单位信息">
						<span class="print-tabs-title-content">保单位信息</span>
						<div id="id_table_leasing_proj_guarantee_method_container"
							style="overflow: hidden;"></div>
					 </div>
					 <div title="税号">
						<span class="print-tabs-title-content">税号</span>
						<div id="id_table_leasing_contract_invoice_info_container"	style="overflow: hidden;">
							<jsp:include page="proj_invoice_info.jsp"></jsp:include>
						</div>
					</div>
			</div>
		</td>
	</tr>
</table>
</div>
<!--避免在tabs中的js重复执行-->
<jsp:include page="proj_equip_detail.jsp"></jsp:include>
<jsp:include page="proj_guarantee_method.jsp"></jsp:include>

<script>
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		//租赁物件
		var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');
		jQuery('#id_json_proj_equip_str').val(
				JsonUtil.encode(currentTable1.getRowsJsonData()));
		//担保单位信息
		var currentTable4 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');
		jQuery('#id_json_proj_guarantee_method_str').val(
				JsonUtil.encode(currentTable4.getRowsJsonData()));

		/*担保单位信息
		var currentTable5 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_attachment_container');
		jQuery('#id_json_proj_guarantee_method_attachment_str').val(
				JsonUtil.encode(currentTable5.getRowsJsonData()));*/
		//留购价计算
		countLeaveTheToy();
		//商务条件数据
		saveReckonJsonValue();
	}
	//生成项目名称
	function createProjectName() {
		var project_name =jQuery('#project_name').val();
		var dept_name = getTracywindyObject('id_combo_creatordept').getRawValue();
		var proj_id=$("#project_id").val();
		var cust_name=$("#cust_name").val();
		if (project_name == '') {
			project_name = proj_id+"-"+dept_name+"-"+cust_name + '项目'+$("#id_business_type").val();
		}else{
            var srefix=project_name.substring(project_name.length-2);
            var stype=$("#id_business_type").val();
            if(srefix!=stype){
            	project_name=project_name+stype;
            }
		}
		jQuery('#project_name').val(project_name);
		jQuery('#project_name').removeAttr('readOnly');
	}
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
	function checkInvoiceFile(){
			//法人 开票文件校验
		if("${requestScope['proj_info.cust_type']}"=="法人"
				&& ($("#selectOfValue_id_combo_id_kfp").val() =="0")
				&&"invoicetype1"==getTracywindyObject('id_combo_invoicetype').getValue()){
			var isPassed = true;
			var arr = ['税务登记证','增值税一般纳税人认定表','开票信息申请表'];
	        loadWorkflowAttachment();
			var attachmentTable    = getTracywindyObject("id_customworkflowattachment");
		    var attachmentRowsJsonArrayData = attachmentTable.getRowsData();
			for(var i=0;i< attachmentRowsJsonArrayData.length;i++){
				var attachmentRowData = attachmentRowsJsonArrayData[i];
				var dictname = attachmentRowData["attachmentFileDictFileName"] ;
				var cname = attachmentRowData["attachmentFileUploadInfoDetailChineseFileNames"] ;
				var uploadtype = attachmentRowData["uploadtype"]; 
				if(arr.indexOf(dictname)>-1 && ""==cname && "承租人资料"== uploadtype){
					alert("请上传"+dictname+"资料!");
					isPassed = false;
					return isPassed;
				}
			}
			return isPassed;
		}else{
			return true;
		}
	}
</script>
