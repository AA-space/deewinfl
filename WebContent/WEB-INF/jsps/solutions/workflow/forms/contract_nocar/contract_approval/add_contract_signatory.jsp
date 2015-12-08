<%@page import="java.net.URLEncoder"%>
<%@page import="com.business.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>合同管理 - 合同审批</title>
<jsp:include page="boot.jsp"></jsp:include>
</head>
<body>
<div class="mini-fit">
	<div id="signatoryform">
	    <table class="fillTable" cellspacing="0" cellpadding="0">
	        <tr class="tr-client-info tr-odd">
			    <td class="td-content-title">供应商：</td>
			    <td class="td-content"><input required="true"  name="seller" class="mini-textbox"  ></td>
			    <td class="td-content-title">法定代表人：</td>
			    <td class="td-content"><input required="true"  name="sellerlegalperson" class="mini-textbox" value=""></td>
			</tr>
			<tr class="tr-client-info tr-even">
			    <td class="td-content-title">联系人：</td>
			    <td class="td-content"><input required="true"  name="sellerlinkman" class="mini-textbox" value=""></td>
			    <td class="td-content-title">注册地址：</td>
			    <td class="td-content"><input required="true"  name="sellerregisteraddr" class="mini-textbox" value=""></td>
			</tr>
			<tr class="tr-client-info tr-odd">
			    <td class="td-content-title">通讯地址：</td>
			    <td class="td-content"><input required="true"  name="selleraddr" class="mini-textbox"  ></td>
			    <td class="td-content-title">邮政编码：</td>
			    <td class="td-content"><input required="true"  name="sellerpostcode" class="mini-textbox" value=""></td>
			</tr>
			<tr class="tr-client-info tr-even">
			    <td class="td-content-title">电话：</td>
			    <td class="td-content"><input required="true"  name="sellertel" class="mini-textbox" value=""></td>
			    <td class="td-content-title">传真：</td>
			    <td class="td-content"><input required="true"  name="sellerfax" class="mini-textbox" value=""></td>
			</tr>
			<tr class="tr-client-info tr-odd">
			    <td class="td-content-title">开户账号：</td>
			    <td class="td-content"><input required="true"  name="selleraccnumber" class="mini-textbox"  ></td>
			    <td class="td-content-title">开户银行：</td>
			    <td class="td-content"><input required="true"  name="selleraccbank" class="mini-textbox" value=""></td>
			</tr>
			<tr class="tr-client-info tr-even">
			    <td class="td-content-title">开户户名：</td>
			    <td class="td-content"><input required="true"  name="selleraccname" class="mini-textbox" value=""></td>
			</tr>
		</table>
	</div>
</div>
<div class="mini-toolbar miniext-toolbar-bottom">
    <table class="miniext-form-fit">
        <tr>
            <td>
                <a class="mini-button" iconCls="icon-add" onclick="save">保存</a>
                <a class="mini-button" iconCls="icon-close" onclick="onCancel">关闭</a>
            </td>
        </tr>
    </table>           
</div>
</body>
</html>
<script>                 
 	mini.parse();
 	var isViewHistoryTask="<%= request.getParameter("isViewHistoryTask")%>";
 	var form = new mini.Form("signatoryform");
	//控制只读页面
	if(isViewHistoryTask=="true"){
		$("#signatoryform").hide();
	}
	function SetData(data) {
		form = new mini.Form("signatoryform");
	    //跨页面传递的数据对象，克隆后才可以安全使用
	    data = mini.clone(data);
	    
        form.setData(data);
	}
	function getData(){
		return form.getData();
	}
	function save(e){
		form = new mini.Form("signatoryform");
		var o = form.getData(true,true); 
	    if (miniui_ext.fromvalidation('signatoryform') == false) return;
		CloseWindow("savesuccess");
	}
	function CloseWindow(action) {            
	    if (action == "close" && grid.isChanged()) {
	        if (confirm("数据被修改了，是否先保存？")) {
	            return false;
	        }
	    }
	    if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
	    else window.close();            
	}
	function onCancel(e) {
	    CloseWindow("cancel");
	}
</script>