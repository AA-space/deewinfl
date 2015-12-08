<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <table cellspacing="0" cellpadding="0"  id="proj_base_info">
         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-config-base-info"></div>配置</td>
          </tr>
          <tr class="tr-config-base-info tr-even">
             <td class="td-content-title" style="width:15%">发动机厂家：</td>
             <td class="td-content" style="width:35%">
                 <input name="contract_equip_revoke.enginefactory"   class="td-content-input "  type="text" value="${requestScope['contract_equip_revoke.enginefactory']}" require="true" label="发动机厂家"></td>
             <td class="td-content-title" style="width:15%">发动机型号：</td>
             <td class="td-content" style="width:35%">
              <input  name="contract_equip_revoke.enginemodel" class="td-content-input " type="text" value="${requestScope['contract_equip_revoke.enginemodel'] }" require="true" label="发动机型号"><font class="required-content">*</font>
             </td>  
          </tr>
          <tr class="tr-config-base-info tr-odd">  
             <td class="td-content-title">变速箱厂家/型号：</td><td class="td-content">
             <input  name="contract_equip_revoke.gearbox" class="td-content-input " type="text" value="${requestScope['contract_equip_revoke.gearbox'] }" require="true" label="变速箱厂家/型号"><font class="required-content">*</font>
             </td>
             <td class="td-content-title">车辆外观(几成新)：</td><td class="td-content"><input  name="contract_equip_revoke.carstyle" class="td-content-input " type="text" value="${requestScope['contract_equip_revoke.carstyle'] }" require="true" label="车辆外观(几成新)"><font class="required-content">*</font>
             </td>
         </tr>
          <tr class="tr-config-base-info tr-even">
             <td class="td-content-title">有无空调：</td>
             <td class="td-content" colspan="3">
             <input type="radio" name="contract_equip_revoke.airconditioning"  checked="true"  value="有"/>有
			 <input type="radio" name="contract_equip_revoke.airconditioning"  value="无"/>无<span class="content-required">*</span>
             </td>
          </tr>
          <tr class="tr-config-base-info tr-odd">
             <td class="td-content-title">车辆改装情况：</td>
             <td class="td-content" colspan="3" >
             <textarea rows="5"  require="true" label="车辆改装情况" 
			style="width:90%;float:left" name="contract_equip_revoke.carmemo">${requestScope['contract_equip_revoke.carmemo'] }</textarea>
               <font class="required-content">*</font></td>
         </tr>
         
        </table>
        
	    