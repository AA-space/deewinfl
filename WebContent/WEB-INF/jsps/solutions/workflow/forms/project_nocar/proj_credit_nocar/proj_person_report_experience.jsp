<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="mini-panel" title="从业经验" showCollapseButton="true" style="width: 100%;">
	<div id="experienceForm">
	    <table class="fillTable" cellspacing="0" cellpadding="0">
	          <tr class="tr-project-info tr-even">
	             <td class="td-content-title">序号：</td><td class="td-content">
	             	<input name="experience.a1" id =""  class="mini-textbox" value="${requestScope['experience.a1'] }">
	             </td>
	             <td class="td-content-title">时间段：</td><td class="td-content">
	             		<input name="experience.a2" class="mini-datepicker" value="${requestScope['experience.a2'] }"/>
	             </td>
	         </tr>
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">从事职业：</td>
	             <td class="td-content">
	             	<input name="experience.a3" id =""  class="mini-textbox" value="${requestScope['experience.a3'] }">
	             </td>
	             <td class="td-content-title">证明人：</td>
	             <td class="td-content">
		             <input name="experience.a4" id =""  class="mini-textbox" value="${requestScope['experience.a4'] }">
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-even">  
	             <td class="td-content-title">联系电话：</td>
	             <td class="td-content">
		             <input name="experience.a5" id =""  class="mini-textbox" value="${requestScope['experience.a5'] }">
	             </td>
	             <td class="td-content-title">备注：</td>
	             <td class="td-content">
		             <input name="experience.a6" id =""  class="mini-textbox" value="${requestScope['experience.a6'] }">
	             </td>
	          </tr>
		</table>
	</div>
</div>
