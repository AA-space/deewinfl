<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script language="javascript">
    function showLawCustInfo(cust_id){
    	var URL = "${pageContext.request.contextPath}/leasing/cust_info/cust_info.bi";
    	var params = {cust_id:cust_id};
	    openFullScreenWindow(URL,params);
        //window.open(getRootPath()+"/leasing/law_cust/show_template.bi?cust_id="+cust_id+"&jsp=law_cust_all_info",'','height=500px,width=1000px,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
    }
</script>
<table cellspacing="0" cellpadding="0">
	<tr>
       <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-other-info"></div>经销商信息</td>
     </tr>
      <tr class="tr-other-info tr-even">   
             <td class="td-content-title">经销商名称：</td><td class="td-content">
                  <input name="cust_info.id" type="hidden" value="${requestScope['cust_info.id'] }">
                  <input  name="cust_info.custname" class="td-content-input td-content-readonly" readOnly require="true" label="经销商名称"  type="text" value="${requestScope['cust_info.custname'] }" >
                  <a href="javascript:void(0);"><img alt="经销商信息" src="${pageContext.request.contextPath}/menuIcons/department.png" onclick="showLawCustInfo('${sessionScope.loginUser.id}')"/></a>
                  <font class="required-content">*</font></td>
             <td class="td-content-title">联系人：</td><td class="td-content"><input name="dealer_document_info.commperson" class="td-content-input " type="text"   value="${requestScope['dealer_document_info.commperson'] }" require="true" label="联系人"><font class="required-content">*</font></td>
     </tr>
      <tr class="tr-other-info tr-even">   
             <td class="td-content-title">邮寄地址：</td><td class="td-content"><input  name="dealer_document_info.mailaddr" class="td-content-input " type="text" style="width:80%" value="${requestScope['dealer_document_info.mailaddr'] }" require="true" label="邮寄地址"><font class="required-content">*</font></td>
             <td class="td-content-title">电话：</td><td class="td-content"><input name="dealer_document_info.phone" class="td-content-input " type="text"    value="${requestScope['dealer_document_info.phone'] }" require="true" label="电话"><font class="required-content">*</font></td>
     </tr>
     <tr class="tr-other-info tr-odd">
             <td class="td-content-title">申请日期：</td><td class="td-content" colspan=3>
            <input name="dealer_document_info.appdate" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['dealer_document_info.appdate'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="申请日期" /><font class="required-content">*</font>
             </td>
     </tr>
</table>