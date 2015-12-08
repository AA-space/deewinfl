<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
     var isSubTable = true;
     isViewHistoryTask = true;
    //是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
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
		fillHiddenVal();
		if(checkPaymentIdisSame()){return false;}
		var submitProcessedForm = document
				.getElementById("id_submitProcessedForm");
		//var isPassed = Validator.Validate(submitProcessedForm,1,false);
		//return isPassed;
		return true;
	}
	function checkPaymentIdisSame(){
		var idsp=new Array();
		var idsr=new Array();
		var cmessage=new Array();
		var currentTable1 = getTracywindyObject('table_id_table_leasing_fundfundchargeplan_container');
        var tablesdata=currentTable1.getRowsData();
        var jsond=tablesdata;
        if(jsond.length>0){
          for(var i=0;i<jsond.length;i++){
        	  idsr.push(jsond[i].paymentid);
          } 
        }
		var currentTable2 = getTracywindyObject('table_id_table_leasing_contract_fund_charge_container');		
		tablesdata=currentTable2.getRowsData();
		jsond=tablesdata;
        if(	jsond.length>0){
          for(var i=0;i<	jsond.length;i++){
        	  idsr.push(jsond[i].paymentid);
          }
        }
        idsr.sort();
        for(var i=0;i<idsr.length-1;i++){
            for(var j=i+1;j<idsr.length;j++){
           if(idsr[i]==idsr[j]){cmessage.push(idsr[i]);}
            }
        }
		if(cmessage.length>0){
      	  jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>编号为"+cmessage+"的计划重复</div>",'error'); 
            return true;
        }else{return false;}
 }
</script>
	<!--多行控件  xuyunlong-->
<input type="hidden"  id="id_json_fundchargeplanreceiver_str" name="json_fundchargeplanreceiver_str" value='${empty json_fundchargeplanreceiver_str ? "[]" : json_fundchargeplanreceiver_str }'/><!-- 收款 1-->
<input type="hidden"  id="id_json_fundchargeplanpay_str" name="json_fundchargeplanpay_str" value='${empty json_fundchargeplanpay_str ? "[]" : json_fundchargeplanpay_str }'/><!-- 付款2 -->
	  
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	 <tr>
		<td colspan=4>
		<jsp:include page="../../contract/contract_approval/contract_base_info.jsp"></jsp:include></td>
	</tr>   
	    <tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-project-business-condition"></div>
		资金计划修改</td>
	</tr> 
	<tr>
		<td colspan=4></td>
	</tr>

	 <tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
		<div id='id_project_info_tabs_content' style="">
	    <div title="资金收款计划修改">
			<div id="id_table_leasing_fundfundchargeplan_container" style="overflow: hidden;"></div>
		</div>
		<div title="资金付款计划修改">
			<div id="id_table_leasing_contract_fund_charge_container" style="overflow: hidden;"></div>
		</div>
		</div>
		</td>
	</tr>   
</table>
</div>
<!--避免在tabs中的js重复执行-->
 <script language="javascript">
jQuery(function() {isViewHistoryTask = isCompletedTask;});
</script>
<jsp:include page="fundchargeplanforReceiver.jsp"></jsp:include>
<jsp:include page="fundchargeplanforpay.jsp"></jsp:include>
 <script language="javascript">
jQuery(function() {isViewHistoryTask = true;});
</script>
<script>
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		  // 收款计划
		  var currentTable1 = getTracywindyObject('table_id_table_leasing_fundfundchargeplan_container');
		jQuery('#id_json_fundchargeplanreceiver_str').val(
			
			JsonUtil.encode(currentTable1.getRowsJsonData()));
		 //付款计划
		var currentTable2 = getTracywindyObject('table_id_table_leasing_contract_fund_charge_container');
		jQuery('#id_json_fundchargeplanpay_str').val(JsonUtil.encode(currentTable2.getRowsJsonData()));
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
	});
</script>
