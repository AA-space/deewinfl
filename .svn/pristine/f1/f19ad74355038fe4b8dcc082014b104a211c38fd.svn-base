<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table cellspacing="0" cellpadding="0">
	 <tr>
       <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-other-dealer"></div>经销商</td>
     </tr>
     <tr class="tr-other-dealer tr-even">   
            <td class="td-content-title" style="width:17%">经销商名称：</td>
            <td class="td-content" style="width:33%">
            <input name="dealerguaranteeinfo.dealername1" type="hidden" value="${requestScope['dealerguaranteeinfo.dealername1'] }">
            <input style="width:72%"  name="cust_info.custname" class="td-content-input td-content-readonly" readOnly require="true" label="经销商名称"  type="text" value="${requestScope['cust_info.custname'] }" >
            <a href="javascript:void(0);"><img alt="经销商信息" src="${pageContext.request.contextPath}/menuIcons/department.png" onclick="showLawCustInfo('${sessionScope.loginUser.id}')"/></a>
            <!-- div class="leftComboContainer" id="dealername" value="${requestScope['dealerguaranteeinfo.dealername1'] }" require="true" label="名称"></div><font class="required-content">*</font-->
            </td>
            <td class="td-content-title" style="width:17%">联系人：</td>
            <td class="td-content" style="width:33%">
            <input id="id_dealerperson" name="dealerguaranteeinfo.dealerperson" class="td-content-input " type="text"   value="${requestScope['dealerguaranteeinfo.dealerperson'] }" require="true" label="联系人"><font class="required-content">*</font>
            </td>
     </tr>
     <tr class="tr-other-dealer tr-odd">   
             <td class="td-content-title">地址：</td><td class="td-content"><input id="id_dealeraddress" name="dealerguaranteeinfo.dealeraddress" class="td-content-input " style="width:300px" type="text" value="${requestScope['dealerguaranteeinfo.dealeraddress'] }" require="true" label="地址"><font class="required-content">*</font></td>
             <td class="td-content-title">电话：</td><td class="td-content"><input id="id_dealerphone" name="dealerguaranteeinfo.dealerphone" class="td-content-input " type="text"    value="${requestScope['dealerguaranteeinfo.dealerphone'] }" require="true" label="电话"><font class="required-content">*</font></td>
     </tr>
</table>
<script>
function showLawCustInfo(cust_id){
	var URL = "${pageContext.request.contextPath}/leasing/cust_info/cust_info.bi";
	var params = {cust_id:cust_id};
    openFullScreenWindow(URL,params);
}
/*
 jQuery(function(){
	 new tracywindyComboBox({
			id : 'id_combo_id_dealername',
			width:300,
			renderTo : 'dealername',
			xmlFileName : '/eleasing/jsp/dealer_manage/new_dealer_info.xml',
			loadMode : 'ajax',
			readOnly : true,
			isAjaxLenovo : true,
			topAdd : 0,
			leftAdd : 0,
			positionDropIconLeftAdd : -1,
			name : 'dealerguaranteeinfo.dealername1',
			displayField : 'custname',
			valueField : 'cid',
			value:"${requestScope['dealerguaranteeinfo.dealername1']}",
			rawValue:"${requestScope['dealerguaranteeinfo.dealername1']}",
	        otherAttributes :'require="true"  label="经销商名称"', 
	        onSelect:function(combo,cdata){
		      $("#id_dealerperson").val(cdata.legalrepresentative);
		      $("#id_dealeraddress").val(cdata.mailadd);
		      $("#id_dealerphone").val(cdata.phone);
	   		}
		});
		
     });*/
     
 </script>