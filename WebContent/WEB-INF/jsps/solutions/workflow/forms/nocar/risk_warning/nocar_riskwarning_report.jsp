<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script language="javascript">
    jQuery(function(){
    	function showLawCustInfo(cust_id){
        	var URL = "${pageContext.request.contextPath}/leasing/law_cust/show_template.bi";
        	var params = {cust_id:cust_id,jsp:"law_cust_all_info"};
    	    openFullScreenWindow(URL,params);
        }
        /*
    	commonSelect('id_warning_report_projregistrar','t_users','id_','realname_','ContractRiskInfo.riskPerson',
    	    	'${empty requestScope["proj_info.projregistrar"] ? sessionScope.loginUser.id : requestScope["proj_info.projregistrar"]}',
    	    	'${empty requestScope["RawValue_proj_info.projregistrar"] ? sessionScope.loginUser.id : requestScope["RawValue_proj_info.projregistrar.realname"]}',' require="true" label="预警报告人"');
    	*/
    });
</script>
<table cellspacing="0" cellpadding="0">
	<tr>
		<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<%--- 风险报告--%>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan="4">
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-project-survey"></div>
		风险报告</td>
	</tr>
	<tr class="tr-project-survey tr-even">
		<td class="td-content" style="width:20%">风险因由:</td>
		<td class="td-content" >
		<textarea rows="5" cols="30"  require="true"  
			style="width: 98%;float: left;"  name="ContractRiskInfo.riskreason" maxB="300" >${requestScope['ContractRiskInfo.riskreason']}</textarea>
		</td>
		<td class="td-content" >发现时间:</td>
		<td class="td-content" >
		<input class="Wdate td-content-input" readonly name="ContractRiskInfo.finddate" class="td-content-input"  type="text" value="${requestScope['ContractRiskInfo.finddate'] }"
		 onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="形成时间"/>
		</td>
	</tr>
	<tr class="tr-project-survey tr-odd">
		<td class="td-content" >形成时间:</td>
		<td class="td-content" >
		<input class="Wdate td-content-input" readonly name="ContractRiskInfo.becomingdate" class="td-content-input"  type="text" 
		 onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="形成时间" value="${requestScope['ContractRiskInfo.becomingdate'] }"/>
		</td>
		<td class="td-content" >监控方式:</td>
		<td class="td-content" >
		<input name="ContractRiskInfo.inspecttype" class="td-content-input" require="true" label="监控方式"  type="text" maxB="50" value="${requestScope['ContractRiskInfo.inspecttype'] }"/>
		</td>
	</tr>
	
	 <tr class="tr-project-survey tr-even">
		<td class="td-content" >风险因由简述:</td>
		<td class="td-content" colspan="4">
		<textarea rows="5" cols="30"  require="true"  
			style="width: 98%;float: left;" name="ContractRiskInfo.reasoninfo" maxB="300" >${requestScope['ContractRiskInfo.reasoninfo'] }</textarea>
		</td>
	</tr>
	 <tr class="tr-project-survey tr-odd">
		<td class="td-content" >风险破坏与损失程度:</td>
		<td class="td-content" colspan="4">
		<textarea rows="5" cols="30"  require="true"  
			style="width: 98%;float: left;" name="ContractRiskInfo.risklevel" maxB="300" >${requestScope['ContractRiskInfo.risklevel'] }</textarea>
		</td>
	</tr>
	 <tr class="tr-project-survey tr-even">
		<td class="td-content" >风险恶性发展可能性:</td>
		<td class="td-content" colspan="4">
		<textarea rows="5" cols="30"  require="true"  
			style="width: 98%;float: left;" name="ContractRiskInfo.riskprospect" maxB="300" >${requestScope['ContractRiskInfo.riskprospect'] }</textarea>
		</td>
	</tr>
	<tr class="tr-project-survey tr-odd">
		<td class="td-content" >采取的措施和紧急处置意见:</td>
		<td class="td-content" colspan="4">
		<textarea rows="5" cols="30"  require="true"  
			style="width: 98%;float: left;" name="ContractRiskInfo.riskmeasure" maxB="300" >${requestScope['ContractRiskInfo.riskmeasure'] }</textarea>
		</td>
	</tr>
	<tr class="tr-project-survey tr-even">
		<td class="td-content" >风险等级定型结论:</td>
		<td class="td-content" colspan="4">
		<textarea rows="5" cols="30"  require="true"  
			style="width: 98%;float: left;" name="ContractRiskInfo.levelreason" maxB="300" >${requestScope['ContractRiskInfo.levelreason'] }</textarea>
		</td>
	</tr>
	<%--
	 <tr class="tr-project-survey tr-odd">
		<td class="td-content" >预警报告人:</td>
		<td class="td-content" colspan="4">
		<div class="leftComboContainer" id="id_warning_report_projregistrar"></div>
		</td>
	</tr>
	 --%>
</table>


