<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <table cellspacing="0" cellpadding="0">
         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-insure-base-info"></div>保险状况</td>
          </tr>
          <tr class="tr-insure-base-info tr-even">
             <td class="td-content-title" style="width:15%">是否在保险有限期：</td>
             <td class="td-content" style="width:35%">
                <input type="radio" name="contract_equip_revoke.isinsurterm"  checked="true"  value="有"/>有
			    <input type="radio" name="contract_equip_revoke.isinsurterm" id="displaynocar"  value="无"/>无<font color="red">*</font></td>
             <td class="td-content-title" style="width:15%">现保单生效日：</td>
             <td class="td-content" style="width:35%">
                     <input name="contract_equip_revoke.insurdate" class="Wdate td-content-input td-content-readonly"  
                  type="text" value="${requestScope['contract_equip_revoke.insurdate'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="现保单生效日" /><font class="required-content">*</font></td>
          </tr>
          <tr class="tr-insure-base-info tr-odd">  
             <td class="td-content-title">现保单已交保费：</td><td class="td-content" colspan="3"  >
             <input  name="contract_equip_revoke.insurmoney" class="td-content-input " type="text" value="${requestScope['contract_equip_revoke.insurmoney'] }" require="true" label="现保单已交保费"><font class="required-content">*</font>
             </td>
         </tr>
          <tr class="tr-insure-base-info tr-even">  
             <td class="td-content-title" rowspan="2">已投保险种：</td><td class="td-content" colspan="3" >
                         车损<input name="contract_equip_revoke.isinsurtype1" type="checkbox">
                         金额<input  name="contract_equip_revoke.insurtypemoney1"  style="width:80" type="text" value="${requestScope['contract_equip_revoke.insurtypemoney1'] }" >
                         三者<input name="contract_equip_revoke.isinsurtype2" type="checkbox">
                         金额<input  name="contract_equip_revoke.insurtypemoney2" style="width:80" type="text" value="${requestScope['contract_equip_revoke.insurtypemoney2'] }">
                         盗抢<input name="contract_equip_revoke.isinsurtype3" type="checkbox">
                         金额<input  name="contract_equip_revoke.insurtypemoney3" style="width:80" type="text" value="${requestScope['contract_equip_revoke.insurtypemoney3'] }">
                         自然<input name="contract_equip_revoke.isinsurtype4" type="checkbox">
                         金额<input  name="contract_equip_revoke.insurtypemoney4"  style="width:80" type="text" value="${requestScope['contract_equip_revoke.insurtypemoney4'] }">
            </td>
           </tr>
           <tr class="tr-insure-base-info tr-even">
            <td class="td-content" colspan="3" >        
                         不计<input name="contract_equip_revoke.isinsurtype5" type="checkbox">
                         金额<input  name="contract_equip_revoke.insurtypemoney5" style="width:80" type="text" value="${requestScope['contract_equip_revoke.insurtypemoney5'] }">
                         司乘<input name="contract_equip_revoke.isinsurtype6" type="checkbox">
                         金额<input  name="contract_equip_revoke.insurtypemoney6" style="width:80" type="text" value="${requestScope['contract_equip_revoke.insurtypemoney6'] }">
                         货险<input name="contract_equip_revoke.isinsurtype7" type="checkbox">
                         金额<input  name="contract_equip_revoke.insurtypemoney7" style="width:80" type="text" value="${requestScope['contract_equip_revoke.insurtypemoney7'] }">
             </td>
           </tr>
          <tr class="tr-insure-base-info tr-odd">
             <td class="td-content-title">有无理赔记录：</td>
             <td class="td-content">
             <input type="radio" name="contract_equip_revoke.isreparation"  checked="true"  value="有"/>有
			 <input type="radio" name="contract_equip_revoke.isreparation"  value="无"/>无<span class="content-required">*</span>
             </td>
              <td class="td-content-title" nowrap="nowrap">若有理赔记录,本车车损金额</td><td class="td-content"  >
                 <input  name="contract_equip_revoke.reparationmoney" class="td-content-input " type="text" value="${requestScope['contract_equip_revoke.reparationmoney'] }" require="true" label="本车车损金额"><font class="required-content">*</font>
             </td>
          </tr>
           <tr class="tr-insure-base-info tr-even">  
             <td class="td-content-title">车辆出险日期：</td><td class="td-content" colspan="3" >
                   <input name="contract_equip_revoke.reparationdate" class="Wdate td-content-input td-content-readonly"  
                  type="text" value="${requestScope['contract_equip_revoke.reparationdate'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="车辆出险日期" /><font class="required-content">*</font></td>
         
           </tr>
          <tr class="tr-insure-base-info tr-odd">
             <td class="td-content-title">车辆出险情况：</td>
             <td class="td-content" colspan="3" >
             <textarea rows="5"  require="true" label="车辆出险情况"'
			style="width:90%;float:left" name="contract_equip_revoke.reparationInfo">${requestScope['contract_equip_revoke.reparationInfo'] }</textarea>
               <font class="required-content">*</font></td>
         </tr>
    </table>
        
	    