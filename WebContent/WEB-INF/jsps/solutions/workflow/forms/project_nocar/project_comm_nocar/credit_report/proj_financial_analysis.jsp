<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="mini-panel" title="财务分析" showCollapseButton="true" style="width: 100%;"> 
    <table class="fillTable" cellspacing="0" cellpadding="0">
			<tr class="tr-even" >
		        <td class="td-content-title">总资产
		        </td>
		        <td class="td-content">
		            <input name="companyFinance.a1" class="mini-textbox" required="true" value="${requestScope['companyFinance.a1'] }"/>
		        </td>
		        <td class="td-content-title">流动资产
		        </td>
		        <td class="td-content">
		            <input name="companyFinance.a2" class="mini-textbox" value="${requestScope['companyFinance.a2'] }"/>
		        </td>
		    </tr>
			<tr class="tr-odd" >
		        <td class="td-content-title">资产负债单
		        </td>
		        <td class="td-content">
		            <input name="companyFinance.a3" class="mini-textbox" value="${requestScope['companyFinance.a3'] }" required="true"/>
		        </td>
		        <td class="td-content-title" nowrap="nowrap">总负债
		        </td>
		        <td class="td-content">
		            <input name="companyFinance.a4" class="mini-textbox" value="${requestScope['companyFinance.a4'] }"/>
		        </td>
		    </tr>
			<tr class="tr-even" >
		        <td class="td-content-title">流动负债
		        </td>
		        <td class="td-content">
		            <input name="companyFinance.a5" class="mini-textbox" required="true" value="${requestScope['companyFinance.a5'] }" />
		        </td>
		        <td class="td-content-title">速动比率
		        </td>
		        <td class="td-content">
		            <input name="companyFinance.a6" class="mini-textbox" value="${requestScope['companyFinance.a6'] }"/>
		        </td>
		    </tr>
			<tr class="tr-odd" >
		        <td class="td-content-title">年销售额
		        </td>
		        <td class="td-content">
		            <input name="companyFinance.a7" class="mini-textbox" required="true" value="${requestScope['companyFinance.a7'] }"/>
		        </td>
		        <td class="td-content-title">年净利润
		        </td>
		        <td class="td-content">
		            <input name="companyFinance.a8" class="mini-textbox" value="${requestScope['companyFinance.a8'] }"/>
		        </td>
		    </tr>
			<tr class="tr-even" >
		        <td class="td-content-title">投资回报率
		        </td>
		        <td colspan="3" class="td-content">
		            <input name="companyFinance.a9" class="mini-textbox" required="true" value="${requestScope['companyFinance.a9'] }"/>
		        </td>
		         
		    </tr>
		
		</table>
	</div>
    
</body>

</html>

