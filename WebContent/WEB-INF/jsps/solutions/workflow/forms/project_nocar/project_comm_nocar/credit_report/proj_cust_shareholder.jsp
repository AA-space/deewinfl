<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="mini-panel" title="承租企业股本结构" showCollapseButton="true" style="width: 100%;"> 
    <table class="fillTable" cellspacing="0" cellpadding="0">
			<tr class="tr-even" >
		        <td class="td-content-title">主要股东名称
		        </td>
		        <td class="td-content">
		            <input name="companyShareholder.a1" class="mini-textbox" required="true" value="${requestScope['companyShareholder.a1'] }"/>
		        </td>
		        <td class="td-content-title">法人/个人
		        </td>
		        <td class="td-content">
		            <input name="companyShareholder.a2" class="mini-textbox" value="${requestScope['companyShareholder.a2'] }"/>
		        </td>
		    </tr>
			<tr class="tr-odd" >
		        <td class="td-content-title">组织机构代码/身份证号
		        </td>
		        <td class="td-content">
		            <input name="companyShareholder.a3" class="mini-textbox" required="true" value="${requestScope['companyShareholder.a3'] }"/>
		        </td>
		        <td class="td-content-title" nowrap="nowrap">主营业务
		        </td>
		        <td class="td-content">
		            <input name="companyShareholder.a4" class="mini-textbox" value="${requestScope['companyShareholder.a4'] }"/>
		        </td>
		    </tr>
			<tr class="tr-even" >
		        <td class="td-content-title">地  址
		        </td>
		        <td class="td-content">
		            <input name="companyShareholder.a5" class="mini-textbox" required="true" value="${requestScope['companyShareholder.a5'] }"/>
		        </td>
		        <td class="td-content-title">注册资本
		        </td>
		        <td class="td-content">
		            <input name="companyShareholder.a6" class="mini-textbox" value="${requestScope['companyShareholder.a6'] }"/>
		        </td>
		    </tr>
			<tr class="tr-odd" >
		        <td class="td-content-title">持股比例
		        </td>
		        <td class="td-content">
		            <input name="companyShareholder.a7" class="mini-textbox" required="true" value="${requestScope['companyShareholder.a7'] }"/>
		        </td>
		        <td class="td-content-title">法定代表人
		        </td>
		        <td class="td-content">
		            <input name="companyShareholder.a8" class="mini-textbox" value="${requestScope['companyShareholder.a8'] }"/>
		        </td>
		    </tr>
		
		</table>
	</div>
    
</body>

</html>

