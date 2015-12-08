 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table cellspacing="0" cellpadding="0" id="proj_credit_other_info">
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-other-indus"></div>申请人存款余额</td>
	</tr>
	<tr class="tr-other-indus tr-even">
		<td class="td-content" colspan=4><textarea rows="5"  ' require="true" label="申请人存款余额"' style="width: 98%;float:left;" id="special_industries" name="proj_other_info.assetsmemo">${requestScope['proj_other_info.assetsmemo'] }</textarea>
		</td>
	</tr>
    	
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-other-equiplist"></div>申请人自有车辆</td>
	</tr>
	<tr class="tr-other-equiplist tr-even">
		<td class="td-content" colspan=4><textarea rows="5"  'label="申请人自有车辆"'
			style="width: 98%;float:left;" id="special_ownervehicle"
			name="proj_other_info.ownervehicle">${requestScope['proj_other_info.ownervehicle'] }</textarea>
		</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-other-ownerestatelist"></div>申请人房产</td>
	</tr>
	<tr class="tr-other-ownerestatelist tr-odd">
		<td class="td-content" colspan=4><textarea rows="5"  'label="申请人房产"'
			style="width: 98%;float:left;" id="special_ownerestate"
			name="proj_other_info.ownerestate">${requestScope['proj_other_info.ownerestate'] }</textarea>
		</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-other-ownerlandlist"></div>申请人土地</td>
	</tr>
	<tr class="tr-other-ownerlandlist tr-ven">
		<td class="td-content" colspan=4><textarea rows="5"  'label="申请人土地"'
			style="width: 98%;float:left;" id="special_ownerland"
			name="proj_other_info.ownerland">${requestScope['proj_other_info.ownerland'] }</textarea>
		</td>
	</tr>
	
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-other-ownerotherlist"></div>申请人其他信息</td>
	</tr>
	<tr class="tr-other-ownerotherlist tr-odd">
		<td class="td-content" colspan=4><textarea rows="5"   'label="申请人其他信息"'
			style="width: 98%;float:left;" id="special_ownerother"
			name="proj_other_info.ownerother">${requestScope['proj_other_info.ownerother'] }</textarea>
		</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-other-assetslist"></div>担保人资产信息</td>
	</tr>
	<tr class="tr-other-assetslist tr-odd">
		<td class="td-content" colspan=4><textarea rows="5"  ' require="true" label="担保人资产信息"'
			style="width: 98%;float:left;" id="special_assetslist"
			name="proj_other_info.assetslist">${requestScope['proj_other_info.assetslist'] }</textarea>
		</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-other-credit_list"></div>经销商剩余额度</td>
	</tr>
	<tr class="tr-other-credit_list tr-odd">
		<td class="td-content-title">剩余额度：</td>
		<td class="td-content"><input name="lastcredit" id="lastcredit" class="td-content-input " type="text"  value="${requestScope['lastcredit'] }" 
			label="剩余额度" 
		></td>
	</tr>
</table>
<script>
/*
jQuery(function() {
	var deptid="${empty requestScope['proj_info.projdept'] ? sessionScope['loginUserDeptObj'].id : requestScope['proj_info.projdept'] }";
	getCreditMoney(deptid);
})

function getCreditMoney(deptid){ 
		//loadMask_oper.show();
		var isSubmit = false;
		 var param={};
		 param.deptid=deptid;
		 ajaxRequest({
  		     url:'${pageContext.request.contextPath}/leasing/checkMoney/getCreditMoney.action',
  		     method:'POST',
  		     success:function(res){
  	   		 var scustinfo=res.responseText;
	   		 scustinfo=scustinfo.replace(/(^\s+)|(\s+$)/g, ""); 
	   		 var cust=eval("("+scustinfo+")");
	   		 $("#lastcredit").val(cust);
  		     },
  		     async:false,
  		     failure:function(res){},
  		     params:param
		 });
		
		}
		*/
</script>