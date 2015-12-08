<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <table cellspacing="0" cellpadding="0"  id="proj_base_info">
         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-maintain-base-info"></div>保养状况</td>
          </tr>
          <tr class="tr-maintain-base-info tr-even">
             <td class="td-content-title" style="width:15%">有无保养手册：</td>
             <td class="td-content" style="width:35%">
                <input type="radio" name="contract_equip_revoke.ismaintain"  checked="true"  value="有"/>有
			    <input type="radio" name="contract_equip_revoke.ismaintain" id="displaynocar"  value="无"/>无<font color="red">*</font></td>
              <td class="td-content-title">车辆所在地：</td><td class="td-content" >
              <input  name="contract_equip_revoke.caraddr" class="td-content-input " type="text" value="${requestScope['contract_equip_revoke.caraddr'] }" require="true" label="车辆所在地"><font class="required-content">*</font>
             </td>
           
           </tr>  
          <tr class="tr-maintain-base-info tr-odd">
             <td class="td-content-title" >其它保养说明：</td>
             <td class="td-content" colspan="3"  >
             <textarea rows="5"  require="true" label="其它保养说明"' style="width:90%;float:left" name="contract_equip_revoke.maintainInfo">${requestScope['contract_equip_revoke.maintainInfo'] }</textarea>
               <font class="required-content">*</font></td>
         </tr>
    </table>
        
	    