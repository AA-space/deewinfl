<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='/WEB-INF/tlds/c.tld' %>
<!-- 插入样式和JS -->
<jsp:include page="../proj_approval/base.jsp"></jsp:include>
<!-- 特殊附件显示公用方法 -->
<jsp:include page="../../util/proj_view_file.jsp"></jsp:include>
<!-- 项目立项附件带到租前业务相关流程 -->
<jsp:include page="initFileListParams.jsp"></jsp:include>
<!-- 项目信审申请 -->
<script type="text/javascript">
//全局变量说是这一个只读业页
isViewHistoryTask = true;
//是否保存   
function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
{  fillHiddenVal();
	return true;
}
//是否提交    
function workflowSubmitCallBack(buttonText)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
{  
	/*
	if(buttonText=="Submit"){
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(isPassed){
			if(equipNum1<10){//10台一下必须填写信审结论
				if(getTracywindyObject('id_combo_id_credit_result_type').getValue()==""){
					isPassed=false;
				}
				if(jQuery("#id_proj_projcreditpasstime").val()==""){
					isPassed=false;
				}
				if(!isPassed){
					alert("10台一下必须填写信审结论和时间!");
				}
			}
		}
		return isPassed;
	}
	*/
	return true;
}
var equipNum1=0;//拖车数量

//流程提交是设置条件路由
/*
function workflowNextRouteCallBack(buttonText,requestNextRoute){
    if(buttonText=="Submit"){
        //判断是否决
        var creditResult=getTracywindyObject('id_combo_id_credit_result_type');//.getValue();
        var creditResultNum=jQuery("#id_credit_result_value").val();
        if(creditResultNum>100){
            if(confirm("您的信审结论为["+creditResult.getRawValue()+"],点击确认流程将直接结束!")){
            	requestNextRoute.value="结束";
            	return;
            }
        }
    	var nextroute05="03业务评审委员会(1)评委";
    	var nextroute06="03业务评审委员会(2)评审";
    	var nextroute07="结束";

		if(countEquipNum()<10){
			alert(countEquipNum());
   			requestNextRoute.value=nextroute05;
			alert(requestNextRoute.value);
		}else if(countEquipNum()>=10&&countEquipNum()<20){
			requestNextRoute.value=nextroute06;
		}else{
			requestNextRoute.value=nextroute07;
		}
    }
}
*/
function formPageReadOnlyCallBack(){
	formJSPInputHideOrShow("proj_credit_result","",1);
 }
</script>
<!--多行控件  -->
<input type="hidden" id="id_json_proj_equip_str" name="json_proj_equip_str" value='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }'></input>
<input type="hidden" id="id_json_proj_guarantee_method_str" 	name="json_proj_guarantee_method_str" value='${empty json_proj_guarantee_method_str ? "[]" : json_proj_guarantee_method_str }'></input>
<input type="hidden" id="id_json_proj_guarantee_equip_str" name="json_proj_guarantee_equip_str" value='${empty json_proj_guarantee_equip_str ? "[]" : json_proj_guarantee_equip_str }'></input>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan=4><!-- 插入项目基本信息 --> <jsp:include
			page="../proj_approval/proj_base_info.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td colspan=4><!-- 插入项目其它基本信息 --> <jsp:include
			page="../proj_approval/proj_base_other_info.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td colspan=4><!-- 插入项目信审其它基本信息 --> <jsp:include
			page="../proj_credit/proj_credit_other_info.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td colspan=4><!-- 插入项目评审结果 -->
		 <jsp:include  page="../proj_credit/proj_credit_result_info.jsp"></jsp:include>
        </td>
	</tr>
	<tr>
		<td colspan=4><!-- 插入项目信审结论 -->
		<script language="javascript">
            jQuery(function() {isViewHistoryTask = isCompletedTask;});
        </script> 
		 <jsp:include  page="../proj_credit/proj_credit_result.jsp"></jsp:include>
		 <script language="javascript">
		    jQuery(function() {
			    isViewHistoryTask = true;
			    });
         </script>
        </td>
	</tr>
	<tr>
	<td colspan=4 class="td-even-line-separator">&nbsp;</td>
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
		<div title="复议内容">
		<div id="id_table_leasing_proj_change_info_container"
			style="overflow: hidden;"><jsp:include page="proj_review_info.jsp"></jsp:include></div>
		</div>
		<div title="租赁物明细">
		<div id="id_table_leasing_proj_equip_container"
			style="overflow: hidden;"></div>
		</div>
		<div title="拟商务条件">
		<div id="id_table_leasing_proj_condition_container"
			style="overflow: hidden;">
			<jsp:include page="../../rent_reckon/rent_reckon/main.jsp"></jsp:include></div>
		</div>
		<div title="担保单位信息">
		<div id="id_table_leasing_proj_guarantee_method_container"
			style="overflow: hidden;"></div>
		</div>
		<div title="租金发票类型">
		<div id="id_table_leasing_proj_rent_type_container"
			style="height: 350px;"><jsp:include page="../proj_approval/proj_invoice.jsp"></jsp:include>
		</div>
		</div>
	</div>
		</td>
	</tr>
</table>
</div>
<jsp:include page="proj_equip_detail01.jsp"></jsp:include>
<jsp:include page="../proj_approval/proj_guarantee_method.jsp"></jsp:include>
<script>
	//页面初始化
	var isSubTable=true;
	function fillHiddenVal() {
		//租赁物件
		var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');
		jQuery('#id_json_proj_equip_str').val(
				JsonUtil.encode(currentTable1.getRowsJsonData()));
		//担保单位信息
		var currentTable4 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');
		jQuery('#id_json_proj_guarantee_method_str').val(
				JsonUtil.encode(currentTable4.getRowsJsonData()));
		saveReckonJsonValue();//保存租金测算结果
	}
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
	function countEquipNum(){//计算租赁物件的数据
		var equipJson=jQuery("#id_json_proj_equip_str").val();
		equipJson=JsonUtil.encode(equipJson);
		var equipNum2=0;//挂车数量
		console.debug(equipJson);
    	for(var i=0;i<equipJson.length;i++){
        	var equip=equipJson[i];
			/*
        	if(equip["equipclass"]=="equip_class_1"){
        		equipNum1++;
        	}
        	*/
        	if(equip["equipclass"]=="equip_class_2"){
        		equipNum2++;
        	}
    	}
    	return equipNum2;
	}
	/*
	countEquipNum();
	if(equipNum1>=10){//台以上不需要填写信审结论
		jQuery("#proj_credit_result").hide();
	}
	*/
</script>
