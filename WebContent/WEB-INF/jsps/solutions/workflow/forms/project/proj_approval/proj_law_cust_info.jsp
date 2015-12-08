<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table cellspacing="0" cellpadding="0">
         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-law-cust-info"></div>${requestScope['cust_info.custclass']}客户信息</td>
          </tr>
         <tr class="tr-project-y tr-odd">
		<td class="td-content" >法定代表人:</td>
		<td class="td-content" >
		<input name="cust_info_company.legalrepresentative" class="td-content-input td-content-readonly" readOnly type="text"  value="${requestScope['cust_info_company.legalrepresentative'] }"/>
		</td>
		<td class="td-content" >注册地址:</td>
		<td class="td-content" >
		<input name="cust_info_company.taxregadd" class="td-content-input td-content-readonly" readOnly type="text" readonly="readonly"  value="${requestScope['cust_info_company.taxregadd'] }"/>
		</td>
	</tr>
	<tr class="tr-project-y tr-even">
		<td class="td-content" >客户规模:</td>
		<td class="td-content" >
		<input name="cust_info_company.custscale" class="td-content-input td-content-readonly" readOnly  type="text" readonly="readonly"  value="${requestScope['cust_info_company.custscale'] }"/>
		</td>
		<td class="td-content" >企业性质:</td>
		<td class="td-content" >
		<input name="cust_info_company.ownership" class="td-content-input td-content-readonly" readOnly  type="text" readonly="readonly"   value="${requestScope['cust_info_company.ownership'] }"/>
		</td>
	</tr>
	<tr class="tr-project-y tr-odd">
		<td class="td-content" >高管姓名:</td>
		<td class="td-content" >
		<input name="cust_info_company.seniorname" class="td-content-input"   type="text"  value="${requestScope['cust_info_company.seniorname'] }"/>
		</td>
		<td class="td-content" >职位:</td>
		<td class="td-content" >
		<input name="cust_info_company.position" class="td-content-input"   type="text"    value="${requestScope['cust_info_company.position'] }"/>
		</td>
	</tr>
	<tr class="tr-project-y tr-even">
		<td class="td-content" >学历:</td>
		<td class="td-content" >
		<input name="cust_info_company.degree" class="td-content-input"   type="text"   value="${requestScope['cust_info_company.degree'] }"/>
		</td>
		<td class="td-content" >从业年限:</td>
		<td class="td-content" >
		<input name="cust_info_company.worklife" class="td-content-input"   type="text"  value="${requestScope['cust_info_company.worklife'] }"/>
		</td>
	</tr>
	<tr class="tr-project-y tr-odd">
		<td class="td-content" >年龄:</td>
		<td class="td-content" colspan="3">
		<input name="cust_info_company.cage" class="td-content-input"   type="text"  value="${requestScope['cust_info_company.cage'] }"/>
		</td>
	</tr>
   </table>