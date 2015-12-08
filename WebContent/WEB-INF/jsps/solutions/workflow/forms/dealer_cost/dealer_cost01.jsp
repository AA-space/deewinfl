<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="base.jsp"></jsp:include>

<script type="text/javascript">

	 
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		return true;
	}

	//保存成功提交后，后台返回
	function saveCallBack(rs) {
		fillHiddenVal();
		return true;
	}
 
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		var currentTablelist = getTracywindyObject('table_projcreditreport');
		var tabledata11=currentTablelist.getRowsData();
		if(tabledata11.length==0){
			alert("经销商注意,请生成天行健费用核对模版!");
		}
		if(!checkTracywindyTableData("table_id_table_leasing_proj_equip_container_info","GPS信息")){return false;}
		return true;
	}
	isViewHistoryTask = true;
	
	var isSubTable = true;//标志主页面是否加载完成 只有在主页面加载完成再加载其他多行空间和下拉框之类的数据
</script>
<input type="hidden" id="id_json_proj_gps_str" name="json_proj_gps_str" value='${empty json_proj_gps_str ? "[]" : json_proj_gps_str }'></input>

<input type="hidden" id="id_json_word_list_str" name="json_word_list_str" value='${empty json_word_list_str ? "[]" : json_word_list_str }'></input>
<input type="hidden" id="id_json_contract_equip_str" name="json_contract_equip_str"  value='${empty json_contract_equip_str ? "[]" : json_contract_equip_str }'></input>
<input name="contract_info.gpsmoney" id="gpsmoney" type="hidden" value="${requestScope['contract_info.gpsmoney'] }"/>
<input name="contract_info.conservicemoney" id="conservicemoney" type="hidden" value="${requestScope['contract_info.conservicemoney'] }"/>
<input name="contract_info.num" id="num" type="hidden" value="${requestScope['contract_info.num'] }"/>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<tr>
		<td><jsp:include	page="contract_base_info.jsp"></jsp:include></td>
	</tr>
	</table>
</div>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<tr class="tr-contract-business-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
		<div id='id_contract_info_tabs_content' style="">
			<div title="天行健费用核对模版">
				<div id="id_table_leasing_contract_sign_container"	style="overflow: hidden;">
					 <script type="text/javascript">
					    jQuery(function() {  isViewHistoryTask = false;});
		            </script>
                      <jsp:include page="contract_onhire_notice.jsp"></jsp:include>
       				<script type="text/javascript">
					    jQuery(function() {isViewHistoryTask = true; });
		            </script>
				</div>
			</div>
			 <div title="租赁物信息">
				<div id="id_table_leasing_proj_equip_container"	style="overflow: hidden;heigth:450px;">
					 <jsp:include	page="contract_equip_detail.jsp"/>
				</div>
			</div>
			<div title="信息管理">
				<div id="id_table_leasing_proj_equip_container_info">
				    <script type="text/javascript">
					    jQuery(function() {  isViewHistoryTask = false;});
		            </script>
		            <jsp:include page="gps_info_manage1.jsp"></jsp:include>
		            <script type="text/javascript">
					    jQuery(function() {isViewHistoryTask = true; });
		            </script>
				</div>
			</div>
		</div>
		</td>
	</tr>
</table>
</div>
<%--避免在tabs中的js重复执行--%>
 <script>
	 function fillHiddenVal() {
			var currentTable3 = getTracywindyObject('table_projcreditreport');
			jQuery('#id_json_word_list_str').val(JsonUtil.encode(currentTable3.getRowsJsonData()));
			
			var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container_info');
			jQuery('#id_json_proj_gps_str').val(JsonUtil.encode(currentTable1.getRowsJsonData()));
		}
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		$("#id_contract_info_tabs_content").tabs();
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		//第一个页签集合
		$("#id_contract_info_tabs_content").css("width", (formWidth) + "px");
		isSubTable = false;//标志主页面加载完成
	});
 </script>