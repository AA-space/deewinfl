<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
<table cellspacing="0" cellpadding="0">
	<tr>
		<td class="x-panel-table-div-title"><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-cardetail-info"></div>本次卡扣基本信息</td>
	</tr>
	<tr class="tr-cardetail-info tr-odd">
		<td class="td-content-title">
			<table width="100%" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						文件上传人
					</td>
					<td><input name="cardhire.docid" id="cardhire.docid" type="hidden" value="${requestScope['cardhire.docid'] }" /> 
						<input name="cardhire.docname" id="cardhire.docname" type="hidden" value="${requestScope['cardhire.docname'] }" class="td-content-input td-content-readonly" readOnly /> 
						<input name="cardhire.uploadid" id="cardhire.uploaduser" type="hidden" value="${requestScope['cardhire.uploadid'] }" class="td-content-input td-content-readonly" readOnly /> 
						<input name="cardhire.uploaduser" id="cardhire.uploaduser" type="text" value="${requestScope['cardhire.uploaduser'] }" class="td-content-input td-content-readonly" readOnly />
					</td>
					<td>
						文件上传时间
					</td>
					<td>
						<input name="cardhire.uploaddate" id="cardhire.uploaddate" type="text" value="${requestScope['cardhire.uploaddate'] }" class="td-content-input td-content-readonly" readOnly /></td>
					<td>
						总到账金额
					</td>
					<td>
						<input name="cardhire.incomemoneysum" id="cardhire.incomemoneysum" type="text" value="${requestScope['cardhire.incomemoneysum'] }" class="td-content-input td-content-readonly" readOnly />
					</td>
					<td>
						总可用金额
					</td>
					<td>
						<input name="cardhire.lastmoneysum" id="cardhire.lastmoneysum" type="text" value="${requestScope['cardhire.lastmoneysum'] }" class="td-content-input td-content-readonly" readOnly />
					</td>
				</tr>
				
				<tr>
					<td>
						核销日期
					</td>
					<td>
					<input id="id_hire_date" name="hire_date" class="Wdate td-content-input"   type="text" value="${requestScope['hire_date']}" onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="项目日期" /><font class="required-content">*</font>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr class="tr-cardetail-info tr-even">
		<td class="td-content-title">
			<div id="id_tableContainer_cardinfo"></div>
		</td>
	</tr>
	<tr class="tr-cardetail-info tr-even">
		<td class="td-content-title">
			<div id="id_tableContainer_rentincome"></div>
		</td>
	</tr>
	<tr class="tr-cardetail-info tr-even">
		<td class="td-content-title">
			<div id="id_tableContainer_card_fail"></div>
		</td>
	</tr>
	<tr>
		<td class="x-panel-table-div-title"><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-carhire-info">
		</div>卡扣核销操作信息</td>
	</tr>
	<tr class="tr-carhire-info tr-even">
		<td class="td-content-title"><textarea style="width: 98.9%; height: 100px; float: left;" id="carhire_text_memo" class="td-content-input td-content-readonly" readOnly name="carhire_text_memo">${requestScope['carhire_text_memo'] }</textarea>
		</td>
	</tr>
</table>
<div id="id_station_message" closed="true" modal="true" title="操作反馈" style="display: none; width: 600px; height: 400px;">
	<center>
		<div id="msg_memo"></div>
	</center>
</div>
<jsp:include page="contract_card_income_list.jsp"></jsp:include>
<jsp:include page="contract_card_income_temp_list.jsp"></jsp:include>
<jsp:include page="contract_card_fail_list.jsp"></jsp:include>
<script type="text/javascript">

function requestAjax(domainName,todoAction,params)
{
	showMsg("请求处理中,请稍等.........");
    var url = todoAction;
    ajaxRequest({
    	 method:'POST',
         url:todoAction,
         timeout:60*25*1000,
         params:params,
         failure:function(res){
    	 	showMsg("访问服务器进行["+domainName+"]失败[服务器正忙,或者无法连通,或者服务器出现异常]!");
         },
         success:function(res){
 	   		res=res.responseText;
 	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
     	    if(res!=''){
         	    getTracywindyObject("id_tableContainer_cardinfo_table").reload();
         	    getTracywindyObject("id_tableContainer_rentincome_table").reload();
         	   showMsg(res);
     	    }else{
           		showMsg("请求["+domainName+"]成功,但无结果返回,请重新尝试!");
     	    }
         }
    });
}
function showMsg(msg){
	jQuery("#msg_memo").html(msg);
	shwoMessageWindwos();
	msg="-------------------------------------------------------------------------\n"+msg+"\n";
	jQuery("#carhire_text_memo").val(jQuery("#carhire_text_memo").val()+msg);
}
function shwoMessageWindwos(){
	var isClosable = true;
	jQuery("#id_station_message").show();
	jQuery("#id_station_message").window({
    	zIndex:9000,
    	draggable:true,
    	top:150,
    	resizable:true,
    	shadow:true,
    	modal:true,
    	inline:false,
    	collapsible:false,
    	minimizable:false,
    	maximizable:false,
    	closable:isClosable,
    	closed:false
    });
}
</script>