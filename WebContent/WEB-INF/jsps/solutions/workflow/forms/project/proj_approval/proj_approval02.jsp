<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->    
<jsp:include page="base.jsp"></jsp:include>
<!-- 特殊附件显示公用方法 -->
<jsp:include page="../../util/proj_view_file.jsp"></jsp:include>
<!-- 项目立项附件带到租前业务相关流程 -->
<jsp:include page="initFileListParams.jsp"></jsp:include>
<script type="text/javascript">
//页面初始化
var isSubTable=false;
//全局变量说是这一个只读业页
isViewHistoryTask = true;
//是否保存   
function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
{
	fillHiddenVal();
	return true;
}
//保存成功提交后，后台返回
function saveCallBack() {
	 var submitProcessedForm = document.getElementById("id_submitProcessedForm");
	return true;
}
//是否提交    
function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
{
	fillHiddenVal();
	//必填
	//流程第二部不需要做验证。 edit by jason 2013-11-25
/* 	var submitProcessedForm = document.getElementById("id_submitProcessedForm");
	var isPassed = Validator.Validate(submitProcessedForm,1,false);
	if(!isPassed){return isPassed;}
	//判断
    if(!checkTracywindyTableData("table_id_table_leasing_proj_equip_container","租赁物明细")){return false;}//检查租赁物明细
    //德银不需要验证担保人必填
	//if(!checkTracywindyTableData("table_id_table_leasing_proj_guarantee_method_container","担保单位信息")){return false;}//担保信息
    if(!checkTracywindyTableData("table_id_table_leasing_rent_plan_container","租金计划")){return false;}//租金计划
	if(!validataTotalMoney()){return false;} */
	return true;
}

</script>
<!--多行控件  -->
<input type="hidden" id="id_json_proj_equip_str" name="json_proj_equip_str" value='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }'></input>
<input type="hidden" id="id_json_proj_guarantee_method_str" 	name="json_proj_guarantee_method_str" value='${empty json_proj_guarantee_method_str ? "[]" : json_proj_guarantee_method_str }'></input>
<div class="fillTableContainer">
  <table class="fillTable" cellspacing="0" cellpadding="0">
          
          <tr><td colspan=4 >
          <!-- 插入项目基本信息 -->
              <jsp:include page="proj_base_info_forcredit2.jsp"></jsp:include>
          </td>
          </tr>
         <tr>
		    <td colspan=4><!-- 插入项目其它基本信息 --> 
		    <jsp:include page="proj_base_other_info.jsp"></jsp:include> 
			</td>
	     </tr>
          <tr class="x-panel-table-div-title">
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-business-condition"></div>项目商务条件 </td>
          </tr> 
          <tr><td colspan=4></td></tr>
          <tr class="tr-project-business-condition">
          <td colspan=4 class="td-tabs-container" style="text-indent:0px;">
          	<!-- 标签栏 -->
          	<div id='id_project_info_tabs_content' style="">
				    	<div title="租赁物明细"><span class="print-tabs-title-content">租赁物明细</span><div id="id_table_leasing_proj_equip_container" style="overflow: hidden;"></div></div>
				    	<div title="拟商务条件"><span class="print-tabs-title-content">拟商务条件</span><div id="id_table_leasing_proj_condition_container" style="overflow: hidden;">
				    	<jsp:include page="../../rent_reckon/rent_reckon/main.jsp"></jsp:include>
				    	</div></div>
				    	<div title="担保单位信息"><span class="print-tabs-title-content">担保单位信息</span><div id="id_table_leasing_proj_guarantee_method_container" style="overflow: hidden;"></div></div>
				    	<div title="租金发票类型"><span class="print-tabs-title-content">租金发票类型</span><div id="id_table_leasing_proj_rent_type_container"  style="height:350px;">
				    	<script language="javascript">
		                    jQuery(function() {isViewHistoryTask = isCompletedTask;});
		                </script> 
				    	<jsp:include page="proj_invoice.jsp"></jsp:include>
				    	<script language="javascript">
						jQuery(function() {isViewHistoryTask = true;});
						</script>
				    	</div></div>
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
	function fillHiddenVal(){
		//租赁物件
		var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');
		jQuery('#id_json_proj_equip_str').val(JsonUtil.encode(currentTable1.getRowsJsonData())) ;
		//担保单位信息
		var currentTable4 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');
		jQuery('#id_json_proj_guarantee_method_str').val(JsonUtil.encode(currentTable4.getRowsJsonData())) ;
		//商务条件数据
		saveReckonJsonValue();
		}
	isSubTable=true;
	//初始化调用
	jQuery(function(){
	
	    //########公共JS事件##########
	    jQuery(".toggle-icon-expanded").click(toggleLeasingOperation); 
	    $("#id_project_info_tabs_content").css("width",(formWidth)+"px");
	    $("#id_project_info_tabs_content").tabs();
	    isSubTable=false;
	    var d=$("#id_project_info_tabs_content");
	    $("#id_project_fund_rent_plan_tabs_content").css("width",(formWidth)+"px");
	    $("#id_project_fund_rent_plan_tabs_content").tabs();
		//jQuery(".fillTableContainer").css("width",formWidth+"px");
	});
</script>