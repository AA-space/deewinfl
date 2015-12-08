<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
        <table cellspacing="0" cellpadding="0" width="100%" id="contract_summary">
         <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-contractect-info"></div>产权转移单</td>
          </tr>
          <tr class="tr-contractect-info tr-even"> 
             <td class="td-content-title" width="10%">安全性总结 ：</td>
             <td ><textarea rows="10" style="width: 80%;float: left;"  require="true" label="安全性总结 " name="contract_end_info.safetymemo" >${requestScope['contract_end_info.safetymemo']}</textarea><font class="required-content">*</font></td>
          </tr>
           <tr class="tr-contractect-info tr-even"> 
             <td class="td-content-title">收益性总结 ：</td>
             <td ><textarea rows="10" style="width: 80%;float: left;"   require="true" label="收益性总结" name="contract_end_info.incomememo" >${requestScope['contract_end_info.incomememo']}</textarea><font class="required-content">*</font></td>
          </tr> 
           <tr class="tr-contractect-info tr-even"> 
             <td class="td-content-title">流动性总结 ：</td>
             <td ><textarea  rows="10" style="width: 80%;float: left;"   require="true" label="流动性总结" name="contract_end_info.flowmemo" >${requestScope['contract_end_info.flowmemo']}</textarea><font class="required-content">*</font></td>
          </tr>      
        </table>