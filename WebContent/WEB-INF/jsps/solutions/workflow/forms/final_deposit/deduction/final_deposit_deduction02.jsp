
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack() {
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		//alert(Validator);
		return true;
	}
	
	
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		//var submitProcessedForm = document
			//.getElementById("id_submitProcessedForm");
		//var isPassed = Validator.Validate(submitProcessedForm,1,false);
		//return isPassed;
		return true;
	}



	function getTableColumnData(tabledatas,column){
        var cdata=[];
        if(tabledatas.length>0){
            for(var i=0;i<tabledatas.length;i++){
                var ctable=tabledatas[i];
                cdata[i]=ctable[column];
            }
        }
        return cdata;
    }
	function autoHX(){
		
		 var currentTable1 = getTracywindyObject('table_id_table_leasing_rent_up_plan_container'); 
		 var currentTable2 = getTracywindyObject('table_id_table_leasing_rent_up_detail_container');
		 var tabledata=currentTable1.getRowsData();
		 var deduction_caution = document.getElementById("projcondition_info.deductible").value;
		 deduction_caution="50000000";//测试数据
		var dc = parseFloat(deduction_caution);
		 if(false){
			 jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>可抵扣保证金为零，无法抵扣</div>",'error'); 
		}else{
			var loadMask_oper = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');
			
			for(var i=tabledata.length-1;i>0;i--){
				loadMask_oper.show();
				//alert(tabledata[i].penalty);
				//alert(tabledata[i].interest);
				var caution_money ={};
				var penalty = parseFloat(tabledata[i].penalty);
				var interest = parseFloat(tabledata[i].interest);
				var corpus = parseFloat(tabledata[i].corpus);
				caution_money.id=tabledata[i].id
				caution_money.planlist=tabledata[i].rentlist
					dc = dc - penalty;
					//alert(dc);
				caution_money.penalty=penalty;
					if(dc<=0){
						currentTable2.AddRow(caution_money);
						break
					};
				 	dc = dc - interest
				 	//alert(2);
				 	//alert(dc);
				caution_money.interest=	interest;
				 	if(dc<=0){
				 		currentTable2.AddRow(caution_money);
					 	break
					};
					dc = dc- corpus
					//alert(dc);
					//alert(3);
					caution_money.corpus = corpus;
					if(dc<=0){
						currentTable2.AddRow(caution_money);
						break
					};
					currentTable2.AddRow(caution_money);
			}
			 //var iddata=getTableColumnData(tabledata,"id");
			 loadMask_oper.hide();
			 jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>核销完成</div>",'info'); 
				

					//alert(tabledata.length);
				//alert(tabledata);	
				//alert(iddata);
		};
		 
	};
</script>


<!--多行控件  -->
<input type="hidden" id="id_json_deposit_in_str" name="json_deposit_in_str" value='${empty json_deposit_in_str ? "[]" : json_deposit_in_str }'/> <!--保证金计划收付清单-->
<input type="hidden" id="id_json_deposit_out_str" name="json_deposit_out_str"  value='${empty json_deposit_out_str ? "[]" : json_deposit_out_str }'/> <!-- 保证金实际收付明细  -->
<input type="hidden" id="id_json_deposit_rent_up_plan_str" name="json_rent_up_plan_str"  value='${empty json_rent_up_plan_str ? "[]" : json_rent_up_plan_str }'/> <!-- 租金回笼计划 -->
<input type="hidden" id="id_json_deposit_rent_up_actually_str" name="json_rent_up_actually_str"  value='${empty json_rent_up_actually_str ? "[]" : json_rent_up_actually_str }'/> <!-- 租金回笼实际 -->
<input type="hidden" id="id_json_deposit_rent_up_detail_str" name="json_rent_up_detail_str"  value='${empty json_rent_up_detail_str ? "[]" : json_rent_up_detail_str }'/> <!-- 本次租金回笼明细 -->

<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr  id="contract_base_info">
		<td colspan=4><!-- 插入合同基本信息 --> <script type='text/javascript'>jQuery(function(){
			     isViewHistoryTask = true;
			});</script><jsp:include
			page="../../contract/contract_approval/contract_base_info.jsp"></jsp:include>
			<script type='text/javascript'>jQuery(function(){
			     isViewHistoryTask = false;
			});</script>
			</td>
	</tr>
	
	<tr>
	<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>

		<tr class="tr-contract-business-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
			<div id='id_contract_condition_tabs_content' style="">
		<div title="保证金信息">
		<span class="print-tabs-title-content">保证金信息</span>
		<div id="" style="overflow: hidden;"><jsp:include page="deposit_info2.jsp"></jsp:include></div>
		
		</div>
		<div title="保证金计划收付清单">
		<span class="print-tabs-title-content">保证金计划收付清单</span>
		<div id="id_table_leasing_deposit_in_container" style="overflow: hidden;"></div>
		</div>
			
		<div title="保证金实际收付明细">
		<span class="print-tabs-title-content">保证金实际收付明细</span>
		<div id="id_table_leasing_deposit_out_container"
							style="overflow: hidden;">
		</div>
		</div>
		
		
		<div title="租金回笼计划">
		<span class="print-tabs-title-content">租金回笼计划</span>
		<div id="id_table_leasing_rent_up_plan_container"
			style="overflow: hidden;">
		</div>
		</div>	
		
		<div title="租金回笼实际">
		<span class="print-tabs-title-content">租金回笼实际</span>
		<div id="id_table_leasing_rent_up_actually_container"
			style="overflow: hidden;">
		</div>
		</div>
			
		<div title="本次租金回笼明细">
		<span class="print-tabs-title-content">本次租金回笼明细</span>
		<div id="id_table_leasing_rent_up_detail_container"
			style="overflow: hidden;">
		</div>
		</div>
		
		
		</div>
		</td>
	</tr>
</table>
</div>

<!--避免在tabs中的js重复执行-->
<jsp:include page="deposit_in.jsp"></jsp:include> <!-- 保证金计划收付清单 -->
<jsp:include page="deposit_out.jsp"></jsp:include> <!-- 保证金实际收付明细 -->
<jsp:include page="rent_up_plan.jsp"></jsp:include> <!-- 租金回笼计划 -->
<jsp:include page="rent_up_actually.jsp"></jsp:include> <!-- 租金回笼实际 -->
<jsp:include page="rent_up_detail.jsp"></jsp:include> <!-- 本次租金回笼明细 -->
<script>
//隐藏域在提交或保存前的赋值
function fillHiddenVal() {
	var currentTable1 = getTracywindyObject('table_id_table_leasing_deposit_in_container');
	jQuery('#id_json_deposit_in_str').val(
			JsonUtil.encode(currentTable1.getRowsJsonData()));

	var currentTable2 = getTracywindyObject('table_id_table_leasing_deposit_out_container');
	jQuery('#id_json_deposit_out_str').val(
			JsonUtil.encode(currentTable2.getRowsJsonData()));

	//var currentTable3 = getTracywindyObject('table_id_table_leasing_deposit_refund_container');
	//jQuery('#id_json_deposit_refund_str').val(
			//JsonUtil.encode(currentTable3.getRowsJsonData()));

	//var currentTable4 = getTracywindyObject('table_id_table_leasing_deposit_refund_detail_container');
	//jQuery('#id_json_deposit_refund_detail_str').val(
	//JsonUtil.encode(currentTable4.getRowsJsonData()));
	
	var currentTable5 = getTracywindyObject('table_id_table_leasing_rent_up_plan_container');
	jQuery('#id_json_deposit_rent_up_plan_str').val(
			JsonUtil.encode(currentTable5.getRowsJsonData()));
	
	var currentTable6 = getTracywindyObject('table_id_table_leasing_rent_up_actually_container');
	jQuery('#id_json_deposit_rent_up_actually_str').val(
			JsonUtil.encode(currentTable6.getRowsJsonData()));

	var currentTable7 = getTracywindyObject('table_id_table_leasing_rent_up_detail_container');
	jQuery('#id_json_deposit_rent_up_detail_str').val(
			JsonUtil.encode(currentTable7.getRowsJsonData()));
}

var isSubTable = true;

jQuery(function() {
	//########公共JS事件##########
	jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
	$("#id_contract_condition_tabs_content").css("width", (formWidth) + "px");
	$("#id_contract_condition_tabs_content").tabs();
	isSubTable = false;
	var d = $("#id_contract_condition_tabs_content");
	//第二个页签集合
	//$("#id_project_info_tabs_content").css("width",(formWidth) + "px");
	//$("#id_project_info_tabs_content").tabs();
	//jQuery(".fillTableContainer").css("width",formWidth+"px");
});
</script>
