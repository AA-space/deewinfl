<%@page import="java.net.URLEncoder"%>
<%@page import="com.business.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>项目信审 - 信审会记录</title>
<jsp:include page="../proj_approval_nocar/boot.jsp"></jsp:include>
</head>
<body>
<div class="mini-panel" title="信审会记录"  showCollapseButton="true" style="width: 100%;">
	<div id="recordform">
	    <table class="fillTable" cellspacing="0" cellpadding="0">
	          <tr class="tr-project-info tr-even">
	             <td class="td-content-title">上会时间：</td><td class="td-content">
	             	<input name="recordform.update" id =""  class="mini-datepicker" />
	             </td>
	             <td class="td-content-title">上会地点：</td><td class="td-content">
	             	<input name="recordform.upaddress" id =""  class="mini-textbox" />
	             </td>
	         </tr>
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">主持人：</td>
	             <td class="td-content">
	             	<input id="" name="recordform.compere" class="mini-textbox" />
	             </td>
	             <td class="td-content-title">会议方式：</td>
	             <td class="td-content">
		             <input name="recordform.meetingway" class="mini-textbox" />
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-even">
	             <td class="td-content-title">审批内容：</td>
	             <td class="td-content" colspan=3>
	             	<input name="recordform.examinecontent" id=""  require="true" class="mini-textarea" style="width: 50%;" />
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">参加审批人员：</td>
	             <td class="td-content" colspan=3>
	             	<input name="recordform.examineperson" id=""  require="true" class="mini-textbox" style="width: 50%;" />
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-even">
	             <td class="td-content-title">列席会议人员：</td>
	             <td class="td-content" colspan=3>
	             	<input name="recordform.hasmeetingperson" id=""  require="true" class="mini-textbox" style="width: 50%;" />
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">缺席会议人员：</td>
	             <td class="td-content" colspan=3>
	             	<input name="recordform.absentmeetingperson" id=""  require="true" class="mini-textbox" style="width: 50%;" />
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-even">
	             <td class="td-content-title">会议记录：</td>
	             <td class="td-content" colspan=3>
	             	<input name="recordform.meetingrecord" id=""  require="true" class="mini-textarea" style="width: 50%;" />
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">会议结论：</td>
	             <td class="td-content" colspan=3>
	             	<input name="recordform.meetingconclusion" id=""  require="true" class="mini-textarea" style="width: 50%;" />
	             </td>
	          </tr>
		</table>
	</div>
</div>
<script language="javascript">
	mini.parse();
	var form = new mini.Form("recordform");
	//var temp='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }';
	var temp = parent.document.getElementById("id_json_proj_letter_detail_str").value;  
	var isViewHistoryTask="<%= request.getParameter("isViewHistoryTask")%>";

	form.setData(mini.decode(temp));
	//调用返回到主页面
	function returnTab(){
		return form;
	}
    function onbeforeshowpopup(e) {
	    miniui_ext.onbeforeshowpopup(e);
    }
  //控制只读页面
	if(isViewHistoryTask=="true"){
		miniui_ext.initformenabled("recordform");
	}
</script>
</body>

</html>
