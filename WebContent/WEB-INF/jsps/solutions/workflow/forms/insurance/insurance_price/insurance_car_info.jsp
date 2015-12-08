
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <table cellspacing="0" cellpadding="0">
	  <tr>
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-info"></div>投保车辆信息</td>
	  </tr>
	  <tr class="tr-project-info tr-even">
		<td class="td-content-title" style="width:17%">项目编号：</td>  
		<td class="td-content" style="width:33%">
              <input  name="insurance_price.projID" class="td-content-input td-content-readonly" readOnly require="true" label="项目编号"  type="text" value="${requestScope['insurance_price.projID'] }" >
              </td>
         <td class="td-content-title" style="width:17%"></td>  
		<td class="td-content" style="width:33%">
		</td>
	  </tr>
	  <tr class="tr-project-info tr-odd">
             <td class="td-content-title">被保险人全称：</td><td class="td-content" colspan=5><input style="width:50%" name="insurance_price.personName" id="insurance_price.personName"  require="true" label="被保险人全称" class="td-content-input"  type="text" value="${requestScope['insurance_price.personName']}" ><font class="required-content">*</font></td>
      </tr>
      	  <tr class="tr-project-info tr-even">
		 <td class="td-content-title" align="left">车辆型号:</td>
	     <td class="td-content" colspan="3">
			<textarea rows="5" cols="30" style="width:98.9%;float:left;" name="insurance_price.equipType" maxB="300" require="true"  label="车辆型号">${requestScope['insurance_price.equipType'] }</textarea><font class="required-content">*</font>
		 </td>
	  </tr>
	</table>
	