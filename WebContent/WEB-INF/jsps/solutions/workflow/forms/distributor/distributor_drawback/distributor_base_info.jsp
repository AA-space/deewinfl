<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <table cellspacing="0" cellpadding="0">
	  <tr>
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-info"></div>经销商信息</td>
	  </tr>
	  <tr class="tr-project-info tr-even">
		<td class="td-content-title" style="width:17%">经销商名称：</td>  
		<td class="td-content" style="width:33%">
		 <input name="cust_info.id" type="hidden" value="${requestScope['cust_info.id'] }">
              <input  name="cust_info.custname" class="td-content-input td-content-readonly" readOnly require="true" label="经销商名称"  type="text" value="${requestScope['cust_info.custname'] }" >
              <a href="javascript:void(0);"><img alt="经销商信息" src="${pageContext.request.contextPath}/menuIcons/department.png" onclick="showLawCustInfo('${requestScope['cust_info.id'] }')"/></a>
             <font class="required-content">*</font></td>
         <td class="td-content-title" style="width:17%"></td>  
		 <td class="td-content" style="width:33%">
		</td>
	</table>
	