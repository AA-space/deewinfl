<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <table cellspacing="0" cellpadding="0"  id="proj_base_info">
         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-info"></div>基本信息</td>
          </tr>
          <tr class="tr-project-info tr-even" >
             <td class="td-content-title" style="width:15%">合同编号：</td>
             <td class="td-content" style="width:35%">
                 <input name="contract_equip_revoke.contractid"   class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['contract_equip_revoke.contractid']}"></td>
             <td class="td-content-title" style="width:15%">车架号：</td>
             <td class="td-content" style="width:35%">
              <input  name="contract_equip_revoke.chassisnum" class="td-content-input " type="text" value="${requestScope['contract_equip_revoke.chassisnum'] }" require="true" label="车架号"><font class="required-content">*</font>
             </td>  </tr>
          <tr class="tr-project-info tr-odd">
             <td class="td-content-title">登记日期：</td>
             <td class="td-content" >
                <input name="contract_equip_revoke.regdate" class="Wdate td-content-input td-content-readonly"  
                  type="text" value="${requestScope['contract_equip_revoke.regdate'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="登记日期" /><font class="required-content">*</font></td>
            <td class="td-content-title">生成厂商：</td><td class="td-content"><input  name="contract_equip_revoke.manufacturer" class="td-content-input" require="true" label="生成厂商"  type="text" value="${requestScope['contract_equip_revoke.manufacturer'] }" >
              <font class="required-content">*</font></td>
         </tr>
           <tr class="tr-project-info tr-even">
             <td class="td-content-title">额定载量：</td>
             <td class="td-content">
               <input  name="contract_equip_revoke.limitedamount" class="td-content-input " type="text" value="${requestScope['contract_equip_revoke.limitedamount'] }" require="true" label="额定载量"><font class="required-content">*</font>
             </td>
             <td class="td-content-title">购买时间：</td>
             <td class="td-content">
               <input name="contract_equip_revoke.buydate" class="Wdate td-content-input td-content-readonly"  
                type="text" value="${requestScope['contract_equip_revoke.buydate'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="购买时间" /><font class="required-content">*</font></td>
          </tr>
          <tr class="tr-project-info tr-odd">  
             <td class="td-content-title">购买价格：</td><td class="td-content">
             <input  name="contract_equip_revoke.buyprice" class="td-content-input " type="text" value="${requestScope['contract_equip_revoke.buyprice'] }" require="true" label="购买价格"><font class="required-content">*</font>
             </td>
             <td class="td-content-title">已行驶公里数：</td><td class="td-content"><input  name="contract_equip_revoke.runmileage" class="td-content-input " type="text" value="${requestScope['contract_equip_revoke.runmileage'] }" require="true" label="已行驶公里数"><font class="required-content">*</font>
             </td>
         </tr>
        </table>
        
	    