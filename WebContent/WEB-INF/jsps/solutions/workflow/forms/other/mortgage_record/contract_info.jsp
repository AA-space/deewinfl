<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table cellspacing="0" cellpadding="0">
	<tr>
       <td class="x-panel-table-div-title" colspan=5><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-other-contract"></div>合同</td>
     </tr>
      <tr class="tr-other-contract tr-even">   
             <td class="td-content-title" style="width:17%">合同编号：</td>
             <td class="td-content" style="width:33%">
                  <input name="contractnumber"  class="td-content-input td-content-readonly " type="text"  value="${requestScope['contractnumber'] }"/>
                  <input name="contractid"  class="td-content-input td-content-readonly " style="display:none" type="text"  value="${requestScope['contractid'] }"/></td>
             <td class="td-content-title" style="width:17%">车辆类型：</td>
             <td class="td-content" style="width:33%"><input name="contractequiptype" class="td-content-input " type="text"   value="${requestScope['contractequiptype'] }" require="true" label="车辆类型"><font class="required-content">*</font></td>
     </tr>
      <tr class="tr-other-contract tr-odd">   
             <td class="td-content-title" >车辆数量：</td>
             <td class="td-content" ><input  name="contractequipnumber" class="td-content-input " type="text" value="${requestScope['contractequipnumber'] }" require="true" label="车辆数量"><font class="required-content">*</font></td>
             <td class="td-content-title">其他：</td>
             <td class="td-content"><input name="contractequipother" class="td-content-input " type="text"    value="${requestScope['contractequipother'] }" require="true" label="其他"><font class="required-content">*</font></td>
     </tr>
</table>