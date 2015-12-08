
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!-- 插入样式和JS -->
<jsp:include page="../project/proj_approval/base.jsp"></jsp:include>
<!-- 特殊附件显示公用方法 -->
<!-- 项目立项附件带到租前业务相关流程 -->
<!-- 项目信审申请 -->
<script type="text/javascript">
	//是否保存   
	//只读回调
	isViewHistoryTask = true;
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		 
			
		return true;
	}
	//只读反转
	function formPageReadOnlyCallBack(){
	       
	}
	//保存成功提交后，后台返回
	function saveCallBack() {
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		return true;
	}

	//是否提交    
	function workflowSubmitCallBack(buttonText)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{ //alert(mini.encode( mini.get('table_leasing_dealer_invoice_container').getData()));
		var tableRowsData = mini.get('table_leasing_dealer_invoice_container').getData();
		/* var tableLen = tableRowsData.length;
		var dataLen = 0;
		for(var i = 0;i < tableLen;i ++){
			if(tableRowsData[i].idcard.length != 0){
				dataLen++;
			}
		}
		if(dataLen == 0){
			alert("没有修改任何数据！");
			return;
		} */
		//alert("提交");
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		//var isPassed = Validator.Validate(submitProcessedForm,1,false);
		return true;
	}
	

</script>
<!--多行控件  -->
<input type="hidden" id="id_json_dealer_invoice_str" name="json_dealer_invoice_str" value='${empty json_dealer_invoice_str ? "[]" : json_dealer_invoice_str }'></input>
<input type="hidden" id="id_json_dealer_invoice_apply_str" name="json_dealer_invoice_apply_str" value='${empty json_dealer_invoice_apply_str ? "[]" : json_dealer_invoice_apply_str }'></input>
<input type="hidden" id="id_json_dealer_invoice_this_apply_str" name="id_json_dealer_invoice_this_apply_str" value='${empty id_json_dealer_invoice_this_apply_str ? "[]" : id_json_dealer_invoice_this_apply_str }'></input>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
		<tr>
		<td colspan=4><!-- 插入项目基本信息 -->
			<jsp:include	page="../contract/contract_approval/contract_base_info.jsp"></jsp:include></td>
	    </tr>
	
		<tr>
			<td colspan=4 class="td-even-line-separator">&nbsp;</td>
		</tr>
    
	<tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
		<!-- 标签栏 -->
		<div id='id_project_info_tabs_content' style="">
		      <div title="已开票明细">
		          <div id="id_table_leasing_invoice_apply_container" class="mini-datagrid"></div>
		     </div>
		    <div title="本次开票明细">
		      <div id="id_table_leasing_invoice_this_apply_container" class="mini-datagrid"></div> 
		    </div>
		    <div title="未开票明细">
		      <div id="id_table_leasing_dealer_invoice_container" class="mini-datagrid"></div>
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

 <jsp:include page="dealer_invoice_detail1.jsp"></jsp:include>
<script language="javascript">
   jQuery(function() {isViewHistoryTask = true;});
</script>

  <jsp:include page="dealer_invoice_detail102.jsp"></jsp:include>   
  
  <jsp:include page="dealer_invoice_detail103.jsp"></jsp:include>   
<script>


    
    
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		//var currentTable1 = getTracywindyObject('table_id_table_leasing_dealer_invoice_container');
		var currentTable1 = mini.get('table_leasing_dealer_invoice_container');
		//alert(currentTable1.getData()+"=====");
		jQuery('#id_json_dealer_invoice_str').val(
				mini.encode(currentTable1.getData()));

		//var currentTable2 = getTracywindyObject('table_id_table_leasing_dealer_invoice_container');
		var currentTable2 = mini.get('table_leasing_invoice_apply_container');
		//alert(currentTable2.getData()+"&&&&&&&&&&&&&&&");
		jQuery('#id_json_dealer_invoice_apply_str').val(
				mini.encode(currentTable2.getData()));
		var currentTable3 = mini.get('table_leasing_invoice_this_apply_container');
		//alert(currentTable2.getData()+"&&&&&&&&&&&&&&&");
		jQuery('#id_json_dealer_invoice_this_apply_str').val(
				mini.encode(currentTable3.getData()));
	}
	

	//页面初始化
	var isSubTable=true;
	//全局变量说是这一个只读业页

	//法人附件上传权限
	
	
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
