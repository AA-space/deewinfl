<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
   
         <table cellspacing="0" cellpadding="0" width="100%">
          <tr class="tr-contractect-info tr-even"> 
             <td class="td-content-title" width="10%">终止原因 ：</td>
             <td ><textarea rows="10" style="width: 80%" name="contract_end_info.endreason" >${requestScope['contract_end_info.endreason']}</textarea></td>
          </tr>
           <tr class="tr-contractect-info tr-even"> 
             <td class="td-content-title">备注 ：</td>
             <td ><textarea rows="10" style="width: 80%" name="contract_end_info.endcenote" >${requestScope['contract_end_info.endcenote']}</textarea></td>
          </tr> 
        </table>