<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table width="100%">
	<tr>
		<td width="10%">变更时间:</td>
		<td width="90%"><input name="fund_rent_adjust.adjustdate" dataType="Date" class="Wdate td-content-input td-content-readonly" 
             type="text" value="${requestScope['fund_rent_adjust.adjustdate'] }"  onclick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="变更时间" /><font class="required-content">*</font></td>
	</tr>
	<tr>
		<td width="10%">变更原因:</td>
		<td width="90%">
		<textarea rows="5" cols="100" name="fund_rent_adjust.changereason">${requestScope['fund_rent_adjust.changereason'] }</textarea>
		</td>
	</tr>
	<tr>
		<td width="10%">变更内容:</td>
		<td width="90%"><textarea rows="5" cols="100" name="fund_rent_adjust.changecontent">${requestScope['fund_rent_adjust.changecontent'] }</textarea></td>
	</tr>
</table>
</body>
</html>