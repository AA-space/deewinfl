<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTree2Table.js"></script>
<script type="text/javascript">
jQuery(function(){
	/* */new tracywindyTree2Table({
	   width:formWidth-1,
	   isAutoHeight:true,
	   refreshStatisticCallBack:window.setCreditLevel,
 	   renderTo:'div_id_dealer_local_report',
 	   id:'dealer_local_report_data',
 	   rootDictId:'doc_code_1',
 	   savedDataKey:'dealer_local_report_data'+flowUnid,
 	   savedDataKey1:"${requestScope['cust_info.id'] }",
	   savedDataKey2:"${requestScope['dealer_approval_info.approvalnum'] }",
	   savedDataKey3:"${currentProcessInstanceDBID}",  //当前流程的ID
	   savedDataKey4:"${requestScope['currentWorkFlowName']}",//流程名称
 	   height:document.documentElement.clientHeight-50,
 	   totalScoreGrantValueTo:"id_local_report_result",
 	   treeTableJson:'${empty json_dealer_local_report_str ? "[]" : json_dealer_local_report_str }'
    });
	 new tracywindyTree2Table({
		   scoreAllLabel :"可偿债净资产总额",
		   scoreDictLabel:"可偿债价值",
		   grantValueCallback:function(rowIndex,treeTableId,scoreFlag,treeDictId,dataValue,treeTableTdObj_id,refreshSum){
				var treeTableObj = getTracywindyObject(treeTableId);
				var tableConfig  = treeTableObj.tableConfig;
				var treeTableJsonRowData = tableConfig.treeDataMapping;
				var isFound = true;
				var treeTableJsonColumnsData = treeTableJsonRowData[treeTableTdObj_id];
				{
					var $dataDom1 = jQuery(treeTableObj.dom).find("[columnId='"+treeTableJsonColumnsData[0].id+"']");
					var $dataDom2 = jQuery(treeTableObj.dom).find("[columnId='"+treeTableJsonColumnsData[1].id+"']");
					var treeTableJsonColumnData1 = parseFloat($dataDom1.val()||$dataDom1.html());
					var treeTableJsonColumnData2 = parseFloat($dataDom2.val()||$dataDom2.html());
					isFound = (!isNaN(treeTableJsonColumnData1)&&!isNaN(treeTableJsonColumnData2));
					treeTableJsonColumnData1     = isNaN(treeTableJsonColumnData1) ?  0.0 : treeTableJsonColumnData1;
					treeTableJsonColumnData2     = isNaN(treeTableJsonColumnData2) ?  0.0 : treeTableJsonColumnData2;
					if(isFound){
						$(treeTableObj.dom).find("td[scoreFlag='"+scoreFlag+"']").html(decimal(treeTableJsonColumnData1*treeTableJsonColumnData2,2));
					}
					else{
						$(treeTableObj.dom).find("td[scoreFlag='"+scoreFlag+"']").html("-");
					}
					if(refreshSum){
					   treeTableObj.refreshStatistic(false);
					}
				}
				return isFound;
		   },
		   width:formWidth-1,
		   isAutoHeight:true,
	 	   renderTo:'div_id_dealer_credit_report',
	 	   id:'dealer_credit_report_data',
	 	   rootDictId:'doc_code_1200',
	 	   savedDataKey:'dealer_credit_report_data'+flowUnid,
	 	   savedDataKey1:"${requestScope['cust_info.id'] }",
		   savedDataKey2:"${requestScope['dealer_approval_info.approvalnum'] }",
		   savedDataKey3:"${currentProcessInstanceDBID}",  //当前流程的ID
		   savedDataKey4:"${requestScope['currentWorkFlowName']}",//流程名称
	 	   height:document.documentElement.clientHeight-50,
	 	   totalScoreGrantValueTo:"id_credit_report_result",
	 	   treeTableJson:'${empty json_dealer_credit_report_str ? "[]" : json_dealer_credit_report_str }'
	    });  
	 new tracywindyTree2Table({
	   width:formWidth-1,
	   isAutoHeight:true,
 	   renderTo:'div_id_dealer_notlocal_report',
 	   id:'dealer_notlocal_report_data',
 	   rootDictId:'doc_code_100',
 	   savedDataKey:'dealer_notlocal_report_data'+flowUnid,
 	   savedDataKey1:"${requestScope['cust_info.id'] }",
	   savedDataKey2:"${requestScope['dealer_approval_info.approvalnum'] }",
	   savedDataKey3:"${currentProcessInstanceDBID}",  //当前流程的ID
	   savedDataKey4:"${requestScope['currentWorkFlowName']}",//流程名称
 	   height:document.documentElement.clientHeight-50,
 	   treeTableJson:'${empty json_dealer_notlocal_report_str ? "[]" : json_dealer_notlocal_report_str }'
	}); 
});
function checkboxReport(obj){
	if(obj=="1"){
		$("#id_div_id_dealer_report").css("display","block");
		$("#div_id_dealer_notlocal_report").css("display","none"); 
		//iniTreeTable("dealer_local_report_data","doc_code_1");
    }else{
    	$("#id_div_id_dealer_report").css("display","none");
    	$("#div_id_dealer_notlocal_report").css("display","block"); 
    	//iniTreeTable("dealer_notlocal_report_data","doc_code_100");
	}
}

//保存报告
function saveDocReport(){
	//reportResult();
	try{
		var jsonValue=getTracywindyObject("dealer_local_report_data").getTableAllSavedConfigJson();
		jsonValue=JsonUtil.doEncode(jsonValue);
		jQuery("#id_json_dealer_local_report_str").val(jsonValue);

		jsonValue=getTracywindyObject("dealer_credit_report_data").getTableAllSavedConfigJson();
		jsonValue=JsonUtil.doEncode(jsonValue);
		jQuery("#id_json_dealer_credit_report_str").val(jsonValue);
		
		jsonValue=getTracywindyObject("dealer_notlocal_report_data").getTableAllSavedConfigJson();
		jsonValue=JsonUtil.doEncode(jsonValue);
		jQuery("#id_json_dealer_notlocal_report_str").val(jsonValue);
	}catch(e){
		alert(e);
		return false;
	}
	return true;
}
function changetMoney(){
	var f= parseFloat(parseFloat(jQuery("#id_credit_report_result").val())-parseFloat(jQuery("#id_credit_report_result2").val())).toFixed(2);
	jQuery("#id_credit_report_result3").val(f);
}
</script>
<table cellspacing="0" cellpadding="0" >
	<tr>
		<td class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" >
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-dealer-report"></div>
		考察报告</td>
	</tr>
	<tr class="dealer-report">
		<td class="td-even-line-separator">
		<input name="reporttype" type="radio" checked onclick="checkboxReport(this.value)" value="1" />现场考察经销商评审报告 
		<input name="reporttype" type="radio" onclick="checkboxReport(this.value)"  value="2"/>非现场考察经销商评审报告
		</td>
	</tr>
	<tr class="tr-dealer-report">
		<td class="td-even-line-separator">
			<!-- 现场考察报告页签 -->
			<div id='id_div_id_dealer_report'  class="fillTableContainer">
			   <table class="fillTable" cellspacing="0" cellpadding="0">
				<tr class="tr-div-id-dealer-report">
					<td  class="td-tabs-container" style="text-indent: 0px;">
					<div id="div-id-dealer-report" style="">
						<div title="现场考察经销商评审报告">
							<div id="div_id_dealer_local_report" 	style="overflow: hidden;">
								<input id="id_json_dealer_local_report_str"  style="display:none" name="json_dealer_local_report_str" value='${empty json_dealer_local_report_str ? "[]" : json_dealer_local_report_str }'>
							</div>
						</div>
						<div title="经销商综合能力评估及合作建议报告" style="overflow:hidden;">
							<table cellspacing="0" cellpadding="0" >
								<tr>
									<td>
										<div id="div_id_dealer_credit_report"  	style="overflow: hidden;">
											<input id="id_json_dealer_credit_report_str"  type="hidden"  name="json_dealer_credit_report_str" value='${empty json_dealer_credit_report_str ? "[]" : json_dealer_credit_report_str }'>
										</div>
									</td>
								</tr>
								<tr class="x-panel-table-div-title">
									<td>
									可偿债净资产的测算
									</td>
								</tr>
								<tr >
									<td>
									可偿债净资产是指可偿债资产偿还总负债后的余额, 即:
									<br>
									可偿债净资产=可偿债资产-负债总额
									</td>
								</tr>
								<tr >
									<td>
										<table cellspacing="0" cellpadding="0" >
											<tr>
												<td>
												可偿债净资产
												</td>
												<td>
												<input id="id_credit_report_result" name="dealer_approval_info.creditmoney1" class="td-content-input td-content-readonly" readonly="readonly" type="text" value='${empty requestScope["dealer_approval_info.creditmoney1"] ? "0.00" : requestScope["dealer_approval_info.creditmoney1"] }'/>
												</td>
											</tr>
											<tr>
												<td>
												负债总额
												</td>
												<td>
												<input id="id_credit_report_result2" name="dealer_approval_info.creditmoney2" type=""text"" value='${empty requestScope["dealer_approval_info.creditmoney2"] ? "0.00" : requestScope["dealer_approval_info.creditmoney2"] }' onblur="changetMoney()"/>
												</td>
											</tr>
											<tr>
												<td>
												可偿债净资产
												</td>
												<td>
												<input id="id_credit_report_result3" name="dealer_approval_info.creditmoney3"  class="td-content-input td-content-readonly" readonly="readonly"  type=""text"" value='${empty requestScope["dealer_approval_info.creditmoney3"] ? "0.00" : requestScope["dealer_approval_info.creditmoney3"] }'/>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</div>
					</div>
					</td>
				</tr>
				
				</table>
			</div>
			<!-- 非现场考察报告页签 -->
			<div id="div_id_dealer_notlocal_report" style="display:none">
			<input id="id_json_dealer_notlocal_report_str"   style="display:none" name="json_dealer_notlocal_report_str" value='${empty json_dealer_notlocal_report_str ? "[]" : json_dealer_notlocal_report_str }'>
			</div>

		</td>
	</tr>
  </table>
<script type="text/javascript">
//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		//第一个页签集合
		$("#div-id-dealer-report").css("width", (formWidth) + "px");
		$("#div-id-dealer-report").tabs();
		isSubTable = false;//标志主页面加载完成
	});
</script>