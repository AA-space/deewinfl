<%@page import="java.net.URLEncoder"%>
<%@page import="com.business.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>项目信审 - 董事会记录</title>
<jsp:include page="../proj_approval_nocar/boot.jsp"></jsp:include>
</head>
<body>
<div class="mini-panel" title="董事会纪录"  showCollapseButton="true" style="width: 100%;">
	<div id="directorform">
	    <table class="fillTable" cellspacing="0" cellpadding="0">
	          <tr class="tr-project-info tr-even">
	             <td class="td-content-title">上会时间：</td><td class="td-content">
	             	<input name="directorform.update" id =""  class="mini-datepicker" />
	             </td>
	             <td class="td-content-title">上会地点：</td><td class="td-content">
	             	<input name="directorform.upaddress" id =""  class="mini-textbox" />
	             </td>
	         </tr>
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">主持人：</td>
	             <td class="td-content">
	             	<input id="" name="directorform.compere" class="mini-textbox" />
	             </td>
	             <td class="td-content-title">会议方式：</td>
	             <td class="td-content">
		             <input name="directorform.meetingway" class="mini-textbox"/>
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-even">
	             <td class="td-content-title">审批内容：</td>
	             <td class="td-content" colspan=3>
	             	<input name="directorform.examinecontent" id=""  require="true" class="mini-textarea" style="width: 50%;" />
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">参加审批人员：</td>
	             <td class="td-content" colspan=3>
	             	<input name="directorform.examineperson" id=""  require="true" class="mini-textbox" style="width: 50%;" />
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-even">
	             <td class="td-content-title">列席会议人员：</td>
	             <td class="td-content" colspan=3>
	             	<input name="directorform.hasmeetingperson" id=""  require="true" class="mini-textbox" style="width: 50%;" />
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">缺席会议人员：</td>
	             <td class="td-content" colspan=3>
	             	<input name="directorform.absentmeetingperson" id=""  require="true" class="mini-textbox" style="width: 50%;" />
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-even">
	             <td class="td-content-title">会议记录：</td>
	             <td class="td-content" colspan=3>
	             	<input name="directorform.meetingrecord" id=""  require="true" class="mini-textarea" style="width: 50%;" />
	             </td>
	          </tr>
	          <tr class="tr-project-info tr-odd">
	             <td class="td-content-title">会议结论：</td>
	             <td class="td-content" colspan=3>
	             	<input name="directorform.meetingconclusion" id=""  require="true" class="mini-textarea" style="width: 50%;" />
	             </td>
	          </tr>
		</table>
	</div>
</div>
<script language="javascript">
	mini.parse();
	var form = new mini.Form("directorform");
	//var temp='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }';
	var temp = parent.document.getElementById("id_json_proj_director_detail_str").value;  
	var isViewHistoryTask="<%= request.getParameter("isViewHistoryTask")%>";
	
	form.setData(mini.decode(temp));
	//调用返回到主页面
	function returnTab(){
		return form;
	}
    function onbeforeshowpopup(e) {
	    miniui_ext.onbeforeshowpopup(e);
    }
</script>
</body>

</html>
