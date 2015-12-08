<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<c:set var="business_type" value="${requestScope['business_type']}"/>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<!-- 特殊附件显示公用方法 -->
<jsp:include page="../../util/proj_view_file.jsp"></jsp:include>
<!-- 项目立项附件带到租前业务相关流程 -->
<jsp:include page="../contract_approval/initFileListParams.jsp"></jsp:include>

<script type="text/javascript">

	var checkContractId=false;
	var jsonStrCheck=true;//校验多行必须填写
	var jsonStrCheckMSG="";
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		return true;
	}

	//保存成功提交后，后台返回
	function saveCallBack(rs) {
		if(rs!=""){
			alert(rs);//保存时初步校验合同号是否重复
			return false;
		}
		return true;
	}
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		if(!saveInvoiceType()){return false;};
		if(workflowSaveCallBack()&&validataTotalMoney()){
			//变更暂时去掉
			//if(!validateChassisnum()){return false;};//检查车架号是否重复
			
			//if(!checkContractFlowNext()){return false;}
			//检查租赁物明细
			if(!checkTracywindyTableData("table_id_table_leasing_proj_equip_container","租赁物明细")){return false;}
			//检查合同制作
			if(!checkTracywindyTableData("table_id_table_leasing_contract_list_container","合同制作")){return false;}
			//担保信息
			//德银不需要验证担保人必填 2013-11-8修改
			//if(!checkTracywindyTableData("table_id_table_leasing_contract_guarantee_method_container","担保单位信息")){return false;}
			//租金计划
			if(!checkTracywindyTableData("table_id_table_leasing_rent_plan_container","租金计划")){return false;}
			//前提条件
			//if(!checkTracywindyTableData("table_id_table_leasing_contract_premise_container","前提条件")){return false;}
			//卖方/供应商
			//if(!checkTracywindyTableData("table_id_table_leasing_contract_supplier_container","卖方/供应商")){return false;}
			//担保单位信息必填
			//if(!checkTracywindyTableData("table_id_table_leasing_contract_guarantee_method_container","担保单位信息")){return false;}
			var submitProcessedForm = document.getElementById("id_submitProcessedForm");
			if(!Validator.Validate(submitProcessedForm,1,false)){return false;}
			
			if(!validataTotalMoney()){return false;};
			//if(!checkContractStatus()){return false;};
			//if(!checkContractStart()){return false;};
			
			/* var isPassed = Validator.Validate(submitProcessedForm,1,false);
			isPassed = validataTotalMoney();
			isPassed = checkContractStatus(); */
			
			//首付，保证金，手续费，等向上改
			if(parseFloat($("#firstPaymentRatio").val())<parseFloat("${requestScope['framework_condition.firstpaymentratio']}"))
			 {
				 alert("首付比例不能小于当前首付比例！");
				 return false;
			 }
			if(parseFloat($("#cautionMoneyRatio").val())<parseFloat("${requestScope['framework_condition.cautionmoneyratio']}"))
			 {
				 alert("保证金比例不能小于当前保证金比例！");
				 return false;
			 }
			if(parseFloat($("#handlingChargeMoneyRatio").val())<parseFloat("${requestScope['framework_condition.handlingchargemoneyratio']}"))
			 {
				 alert("手续费比例不能小于当前手续费比例！");
				 return false;
			 }
			return true;
		}
	}
	//流程提交是设置条件路由
	function workflowNextRouteCallBack(buttonText,requestNextRoute){
		//车架号更改之后提交给信审审核。
		//合同变更都需要提交给信审审核
		/*var havChassisnum = true; 
		var  old_eqiup = JsonUtil.decode('${empty json_proj_equip_str_for_credit ? "[]" : json_proj_equip_str_for_credit }');
		 var  new_eqiup = JsonUtil.decode($('#id_json_proj_equip_str').val());
		 
		 var old_eqiup_array = [], new_eqiup_array = [];
		 
		 for ( var i = 0; i < old_eqiup.length; i++) {
			 var  equipcontractnum = old_eqiup[i]['equipcontractnum'];
			 var chassisnum = old_eqiup[i]['chassisnum'];
			 old_eqiup_array.push(equipcontractnum);
			 old_eqiup_array.push(chassisnum);
		}
		 
		 for ( var j = 0; j < new_eqiup.length; j++) {
			 var  equipcontractnum = new_eqiup[j]['equipcontractnum'];
			 var chassisnum = new_eqiup[j]['chassisnum'];
			 new_eqiup_array.push(equipcontractnum);
			 new_eqiup_array.push(chassisnum);
		}
		var oldStr = old_eqiup_array.sort().join("");
		var newStr =  new_eqiup_array.sort().join("");
		 
		if(oldStr != newStr){
			havChassisnum =false;
		}*/
        if(buttonText=="Submit"){
        	var law="02-2法人信用分析师审核";
    		var ewlp="02-1个人信用分析师审核";
    		//var projects = "02业务企划初审";
	        if("${requestScope['proj_info.cust_type']}"=="法人"){
	       	   requestNextRoute.value=law;
	    	}else{
	    	   requestNextRoute.value=ewlp;
	    	}
    		
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
	<tr>
		<td colspan=4><!-- 插入项目其它基本信息 --> <jsp:include page="../contract_approval/contract_base_other_info.jsp"></jsp:include></td>
	</tr>
	</table>
</div>
<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">
	<tr class="tr-contract-business-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
		<div id='id_contract_info_tabs_content' style="">
		    <div title="变更说明">
		    <div id="id_table_leasing_proj_change_info_container"
			   style="overflow: hidden;"><jsp:include page="contract_change_info.jsp"></jsp:include></div>
		    </div>
			<div title="租赁物明细">
				<span class="print-tabs-title-content">租赁物明细</span>
				<c:if test="${'bussiness_type_car' eq business_type}">
				<jsp:include page="contract_equip_detail01.jsp"></jsp:include>
				<div id="id_table_leasing_proj_equip_container"	style="overflow: hidden;"></div>
				</c:if>
				<c:if test="${'bussiness_type_equip' eq business_type}">
				<jsp:include page="../../nocar/nocar_public/thing_detail.jsp"></jsp:include>
				<div id="id_table_leasing_proj_equip_container"	style="overflow: hidden;"></div>
				</c:if>
			</div>
			<div title="商务报价">
				<span class="print-tabs-title-content">商务报价</span>
				<c:if test="${'bussiness_type_car' eq business_type}">
				<div id="id_table_leasing_contract_condition_container"	style="overflow: hidden;">
					<jsp:include page="../../rent_reckon/rent_reckon/main.jsp" flush="true"/>
				</div>
				</c:if>
				<c:if test="${'bussiness_type_equip' eq business_type}">
				<div id="id_table_leasing_contract_condition_container"	style="overflow: hidden;">
					<jsp:include page="../../rent_reckon/rent_reckon/main_4_5.jsp" flush="true"/>
				</div>
				</c:if>
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
						    <td class="td-content-title">签约时间：</td><td class="td-content"><input class="Wdate td-content-input" readonly name="contract_other_info.signdate" class="td-content-input"  type="text" value="${requestScope['contract_other_info.signdate']}" onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})"></td>
						    <td class="td-content-title">签约地点：</td><td class="td-content"><input name="contract_other_info.signplace" class="td-content-input" type="text" value="西安市幸福北路39号" ></input></td>
						</tr>
						<tr  class="tr-contractect-other-info tr-odd">
						    <td class="td-content-title">签约人：</td><td class="td-content" colspan="3"><div class="leftComboContainer" style="width: 99%;"><textarea rows="3"  style="width: 95%;float:left;" name="contract_other_info.signperson">${requestScope['contract_other_info.signperson']}</textarea></div></td>
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
		<script type="text/javascript">jQuery("#id_contract_info_tabs_content").css("width",formWidth+"px");</script>
		</td>
	</tr>
</table>
</div>
<%--避免在tabs中的js重复执行--%>
<%--<jsp:include page="contract_equip_detail.jsp"></jsp:include>租赁物件 --%>
<jsp:include page="../contract_approval/contract_guarantee_method.jsp"></jsp:include><%--担保 --%>
<jsp:include page="../contract_approval/contract_premise_info.jsp"></jsp:include><%--前提条件 --%>
<%--引入流程二选一页面 --%>
<jsp:include page="../../util/flow_condition_select.jsp"></jsp:include>
<script>
//模板上传
function createTemFile(){
       /* 
        var currentTable1 = getTracywindyObject('id_table_leasing_contract_signatory_container');
		//jQuery('#id_json_proj_equip_str').val(
				alert(JsonUtil.encode(currentTable1.getRowsJsonData()));
				var ee=JsonUtil.encode(currentTable1.getRowsJsonData());
				alert(ee[1]);*/
        
    var url="/leasing/template/createFileByTemplateClass.action";
    attachmentDown({url:url,title:"",flowunid:flowUnid,twoClassify:'wordtempletypetwo.22',returnType:'list',modelname:'overduenotice'});
}

	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		var contractEquip = getTracywindyObject('table_id_table_leasing_proj_equip_container');//租赁物件
		jQuery('#id_json_proj_equip_str').val(JsonUtil.encode(contractEquip.getRowsJsonData()));
		var contractGuaranteeMethod = getTracywindyObject('table_id_table_leasing_contract_guarantee_method_container');//担保
		jQuery('#id_json_contract_guarantee_method_str').val(JsonUtil.encode(contractGuaranteeMethod.getRowsJsonData()));
		if(contractGuaranteeMethod.getRowsJsonData()==''||contractGuaranteeMethod.getRowsJsonData()=='[]'){
			jsonStrCheck=false;
			jsonStrCheckMSG+="担保单位信息,";
		}
		var contractPremise = getTracywindyObject('table_id_table_leasing_contract_premise_container');//前提条件
		jQuery('#id_json_contract_premise_str').val(JsonUtil.encode(contractPremise.getRowsJsonData()));
		var contractSupplier = getTracywindyObject('table_id_table_leasing_contract_supplier_container');//合同各方中的供应商
		jQuery('#id_json_contract_supplier_str').val(JsonUtil.encode(contractSupplier.getRowsJsonData()));
		if(!saveReckonJsonValue()){
			jsonStrCheck=false;
			jsonStrCheckMSG+="租金测算信息";//保存租金测算结果
		}
		//合同清单
		var currentTable = getTracywindyObject('table_id_table_leasing_contract_list_container');
		jQuery('#id_json_contract_list_str').val(
				JsonUtil.encode(currentTable.getRowsJsonData()));
	}
	//初始化调用
	jQuery(function() {
		//合同制作前保存数据
		$("#id_contract_info_tabs_content").tabs({onSelect:function(title){
				if(title=='合同制作')
				{
					btn_callBack(saveButtonDisplayText,true);
				}
			}
		});
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		//第一个页签集合
		$("#id_contract_info_tabs_content").css("width", (formWidth) + "px");
		//$("#id_contract_info_tabs_content").tabs();
		isSubTable = false;//标志主页面加载完成
	});
	
	
	function checkContractStart(){
		var returnStatus = false;
		param = {};
    	param.projID = '${proj_id}';
    	param.currentAmt = $('#equipAmt').val();
    	//2013-11-25，增加当前过程表数据
		$.ajax({
			type : "post",
			url : "leasing/checkContractStart.action",
			cache : false,
			async : false,
			data : param,
			success : function(data) {
				if (data['result'] == 'error') {
					alert("您所选择的项目设备金额为【"+data['projEquipAmt']+"】,已经发起【"+ data['number']+"】条合同,总共金额为【" + data['contractEquipAmt'] + "】。\n此条项目不能发起流程,请检查。");
				} else {
					returnStatus = true;
				}
			}
		});
		
		return returnStatus;
	}
	
	function checkContractFlowNext(){
		//检查租赁物件中的车辆合同小号，车架号，购置税，保费，其他融资额必填
		//发票信息必填
		var returnStatus = false;
		param = {};
    	param.projID = $("#projid").val();
		$.ajax({
			type : "post",
			url : getRootPath()+"/leasing/contractStartFlowCheck.acl",
			cache : false,
			async : false,
			data : param,
			success : function(rs) {
			   var svote=rs;
			   svote=svote.replace(/(^\s+)|(\s+$)/g, ""); 
				if (svote!="") {
					alert("请走项目资料补充增加"+svote+"");
					returnStatus=false;
					} else {
					returnStatus = true;
				}
			}
		});
		
		return returnStatus;
	}
	/* 
	   function checkContractStatus(){
			var contractStatus = $("#contract_info.projstatus").val();
			if('11' == contractStatus){
				return true;
			}else{
				alert("项目状态不正确,不可提交！");
				return false;
			}
		} */
</script>