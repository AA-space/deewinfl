<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>项目复议流程</title>
</head>
<body>
    
<jsp:include page="../proj_approval_nocar/boot.jsp"></jsp:include>
   <div id="proj_change_form1" class="mini-fit">
	    <table class="fillTable" cellspacing="0" cellpadding="0">
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title" style="width:10%">复议日期：</td><td class="td-content">
	             <input id="id_colunm1" name="colunm1" class="mini-datepicker" required="true"  allowInput="false"/>
	             </td>
	          </tr>
	          
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">复议说明：</td>
	             <td class="td-content" colspan=5 >
	             <input id="id_colunm2" style="width:72%" name="colunm2"  required="true" label="复议说明" class="mini-textarea"  type="text" > 
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">复议前内容：</td>
	             <td class="td-content" colspan=5 >
	             <input id="id_colunm3" style="width:72%" name="colunm3"  required="true" label="复议前内容" class="mini-textarea"  type="text" > 
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">复议后内容：</td>
	             <td class="td-content" colspan=5 >
	             <input id="id_colunm4" style="width:72%" name="colunm4"  required="true" label="复议后内容" class="mini-textarea"  type="text" > 
	             </td>
	          </tr>
	            
	</table>
</div>
</body>
</html>
<script language="javascript">
    //控制只读页面
	mini.parse("proj_change_form1");
	debugger;
	var id_colunm1 = parent.document.getElementById("id_proj_info_colunm1").value;
	mini.get("id_colunm1").setValue(id_colunm1);
	
	var id_colunm2 = parent.document.getElementById("id_proj_info_colunm2").value;
	mini.get("id_colunm2").setValue(id_colunm2);
	
	var id_colunm3 = parent.document.getElementById("id_proj_info_colunm3").value;
	mini.get("id_colunm3").setValue(id_colunm3);
	
	var id_colunm4 = parent.document.getElementById("id_proj_info_colunm4").value;
	mini.get("id_colunm4").setValue(id_colunm4);
	
	var isViewHistoryTask="<%=request.getParameter("isViewHistoryTask")%>";
	var form = new mini.Form("proj_change_form1");
	debugger;
    //var grid=mini.get("proj_change_form1");
	if (isViewHistoryTask == "true") {
		var o = form.getData();
		var fields = form.getFields();
		for (var index = 0; index < fields.length; index++) {
			//判断是否是下拉框控件，是则同时把text属性传入后台
			if (fields[index].uiCls == "mini-combobox"
					|| fields[index].uiCls == "mini-datepicker") {
				fields[index].disable();
			} else {
				fields[index].allowInput = false;
			}
		}
	}
	//调用返回到主页面
	function returnTab() {
		return form;
	}
</script>

