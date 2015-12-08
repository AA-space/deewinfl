<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<c:set var="business_type" value="${requestScope['business_type']}"/>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<!-- 附件显示 -->
<jsp:include page="../../util/proj_view_file.jsp"></jsp:include>
<script type="text/javascript">
     var isSubTable = true;
     isViewHistoryTask = true;
     function formPageReadOnlyCallBack(){
		//conditionOnHire();
    	 if(!isCompletedTask){
	         formJSPInputHideOrShow("equip_accpance_other_info","",1);
    	 }
	  
     } 
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return isPassed;}
		return true;
	}
</script>
<!--多行控件  -->
<!-- 已投放明细 -->
<input type="hidden" id="id_json_already_throw_in_list_str" name="json_already_throw_in_list_str"  value='${empty json_already_throw_in_list_str ? "[]" : json_already_throw_in_list_str }'/>
<!-- 租赁物件明细 -->
<input type="hidden" id="id_json_contract_equip_str" name="json_contract_equip_str"  value='${empty json_contract_equip_str ? "[]" : json_contract_equip_str }'/>
<!-- 设备验收信息 -->
<input type="hidden" id="id_json_equip_acceptance_str" name="json_equip_acceptance_str"  value='${empty json_equip_acceptance_str ? "[]" : json_equip_acceptance_str }'/>
<input type="hidden" id="id_json_word_list_str" name="json_word_list_str" value='${empty json_word_list_str ? "[]" : json_word_list_str }'></input>

<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	 <tr>
		<td colspan=4><jsp:include page="../contract_approval/contract_base_info.jsp"></jsp:include></td>
	</tr>
	
	<tr>
       <td colspan=4>
       <script type="text/javascript">
					    jQuery(function() {
						    isViewHistoryTask = false;
						    });
		            </script>
                      <jsp:include page="contract_onhire_notice.jsp"></jsp:include>
       <script type="text/javascript">
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
		合同起租</td>
	</tr> 
	 <tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
		<div id='id_contract_onhire_info_tabs_content' style="">
			<div title="设备验收信息">
				<jsp:include page="../equip_acceptance/equip_acceptance_other_info.jsp"/>
			</div>
			
			<div title="租赁物件">
						<%-- 					<div id="id_table_leasing_contract_equip_container"	style="overflow: hidden;">
					<jsp:include page="../contract_approval/contract_equip_detail.jsp"></jsp:include>租赁物件
					</div> --%>
						<div id="id_table_leasing_proj_equip_container" style="overflow: hidden;"></div>
						<jsp:include page="../../project/proj_approval/proj_equip_detail.jsp"></jsp:include>



					</div>
					<div title="商务报价">
						<c:if test="${'bussiness_type_car' eq business_type}">
							<div id="id_table_leasing_contract_condition_container" style="overflow: hidden;">
								<jsp:include page="../../rent_reckon/rent_reckon/main.jsp" flush="true" />
							</div>
						</c:if>
						<c:if test="${'bussiness_type_equip' eq business_type}">
							<div id="id_table_leasing_contract_condition_container" style="overflow: hidden;">
								<jsp:include page="../../rent_reckon/rent_reckon/main_4_5.jsp" flush="true" />
							</div>
						</c:if>
					</div>
			
			<div title="已投放明细">
					<div id="id_table_leasing_already_throw_in_list_container"	style="overflow: hidden;">
						<jsp:include page="contract_already_throw_in_list.jsp"/>
					</div>
			</div>
		
			<div title="租金发票类型">
				<div id="id_table_leasing_contract_rent_type_container" style="overflow: hidden;">
				   <jsp:include page="../contract_approval/contract_invoice_type.jsp"/>
				</div>
			</div>
		</div>
		</td>
	</tr>   
</table>
</div>

<script>
function createTemFile(){
	var currentTablelist = getTracywindyObject('table_projcreditreport');
	var tabledata11=currentTablelist.getRowsData();
	for(var i=0;i<tabledata11.length;i++){
			if(tabledata11[i].filename=='起租通知函.doc')
				{
				  alert(tabledata11[i].filename+"已经生成");
				  return false;
				}
	}
	//承租人评审结果，将第一个月的月租金赋值给月租金
    var currentTableRent = getTracywindyObject('table_id_table_leasing_rent_plan_container');
 	var tabledataRent=currentTableRent.getRowsData();
 	var sumMoney=parseFloat(tabledataRent[0].rent);

    //当前日期
    var d=new Date();
    var url="/leasing/template/createFileByTemplateClass.action";
    var filename='table_projcreditreport';
    attachmentDown({uploadid:filename,url:url,title:"",flowunid:flowUnid,twoClassify:'wordtempletypetwo.102',returnType:'listtocurpaget',modelname:'contractNotice',"framework_condition.rentmoney":sumMoney.toFixed(2),"contract_info.projdeptraw":getTracywindyObject('id_combo_creatordept').getRawValue(),"curdate.curyear":d.getFullYear(),"curdate.curmonth":(d.getMonth()+1),"curdate.curday":d.getDate(),"framework_condition.firstplandatepage":$("#firstPlanDate").val()});
 }
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		var currentTable3 = getTracywindyObject('table_projcreditreport');
		jQuery('#id_json_word_list_str').val(
			JsonUtil.encode(currentTable3.getRowsJsonData()));
		saveReckonJsonValue();
	}
	var isSubTable = true;
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		$("#id_contract_onhire_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_contract_onhire_info_tabs_content").tabs();
		isSubTable = false;
	});
	
</script>
