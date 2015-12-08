<%---借阅 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
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
	//显示外部借阅信息

	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		//createProjectName();
		//必填
		/* if(document.getElementById("outborrowinfo").style.display =="")
		{
		  var submitProcessedForm = document.getElementById("outborrowinfo");
		  var isPassed = Validator.Validate(submitProcessedForm,1,false);
		  if(!isPassed){return isPassed;}
		}  */
		//检查租合同寄送
		if(!checkTracywindyTableData("table_leasing_borrow_other_container","合同寄送")){return false;}
		//if(!validataTotalMoney()){return false;}
		return true;
	}
	
	/* function workflowNextRouteCallBack(buttonText,requestNextRoute) {
		
		//alert(11)
	}*/
	
	//流程提交是设置条件路由
	function workflowNextRouteCallBack(buttonText,requestNextRoute){
        if(buttonText=="Submit"){
        	var dealer = '${currentDealerCustInfoId}';
        	if(dealer){
        		requestNextRoute.value="TO 02信审确认";
			} else{
				requestNextRoute.value="TO 04法务寄送";
			}
        }
   } 
	
</script>
<!--多行控件  -->
<input type="hidden" id="id_json_borrow_info_str" name="json_borrow_info_str" value='${empty json_borrow_info_str ? "[]" : json_borrow_info_str }'></input>
<input type="hidden"  id="borrowtype" name="borrowtype" />
<!--结束多行控件  -->
<div class="fillTableContainer">
	<table class="fillTable" cellspacing="0" cellpadding="0">
		<tr>
			<script type="text/javascript">jQuery(function(){isViewHistoryTask = true;});</script>
			<td colspan=4>
				<!-- 插入项目基本信息 --> <jsp:include page="../../contract/contract_approval/contract_base_info.jsp"></jsp:include></td>
			<script type="text/javascript">jQuery(function(){isViewHistoryTask = false;});</script>
		</tr>
		<tr>
			<td colspan=4 class="td-even-line-separator">&nbsp;</td>
		</tr>
		
		<%---选项卡 --%>
	<%-- 	<tr class="x-panel-table-div-title">
			<td class="x-panel-table-div-title" colspan=4>
				<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-business-condition1"></div>借阅类型
			</td>
		</tr>
		<tr class="tr-project-business-condition1" id="outborrowinfo" style="display:none">
			<td colspan=4>
				<!-- 插入项目基本信息 --> <jsp:include page="out_borrow_info.jsp"></jsp:include></td>
		</tr>
		<tr>
			<td colspan=4 class="td-even-line-separator">&nbsp;</td>
		</tr>
		 --%>
		
		<%---选项卡 --%>
		<tr class="x-panel-table-div-title">
			<td class="x-panel-table-div-title" colspan=4>
				<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-business-condition"></div> 借阅
			</td>
		</tr>
		<tr>
			<td colspan=4></td>
		</tr>
		<tr class="tr-project-business-condition">
			<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
				<div id='id_project_info_tabs_content'>
					<div title="合同寄送">
						<span class="print-tabs-title-content">合同寄送</span>
						<div id="id_table_leasing_borrow_other_container" style="height: 350px;"></div>
					</div>


				</div>
			</td>
		</tr>
		<%---结束选项卡 --%>
	</table>
</div>

<jsp:include page="borrow_other_info.jsp"></jsp:include>
<script>

	function fillHiddenVal(){
		var currentTable1 = getTracywindyObject('table_leasing_borrow_other_container');
		jQuery('#id_json_borrow_info_str').val(
				JsonUtil.encode(currentTable1.getRowsJsonData()));
	}
	 
	var isSubTable = true;
	//初始化调用
	jQuery(function() {
		/* var dealer = '${currentDealerCustInfoId}';
			if(dealer){
			 	document.getElementById("outborrowinfo").style.display = "";
			 	document.getElementById("borrowtype").value = 'outborrow';
			} else{
			 	document.getElementById("outborrowinfo").style.display = "none";
			 	document.getElementById("borrowtype").value = 'inborrow';
			} */
		
		//########公共JS事件##########
		//jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		//$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
		//$("#id_project_info_tabs_content").tabs();
		//isSubTable = false;
		//var d = $("#id_project_info_tabs_content");
		//$("#id_project_fund_rent_plan_tabs_content").css("width",
		//		(formWidth) + "px");
		//$("#id_project_fund_rent_plan_tabs_content").tabs();
		//jQuery(".fillTableContainer").css("width",formWidth+"px");
	});
</script>
