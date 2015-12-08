<%@page import="com.tenwa.business.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
String opertype=request.getParameter("opertype");
%>
<title>项目信审 - 自然人（考察报告） - 申请人自然情况</title>

<%@include file="/base/mini.jsp"%>
<!-- miniui扩展样式 -->
<link rel=stylesheet href="${pageContext.request.contextPath}/css/comm/miniui_ext.css"/>
<!-- miniui扩展JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/comm/miniui_ext.js"></script>

</head>
<body>

<div class="mini-fit">
	<div id="form1">
		<table class="miniext-form-table">
		    <tr>
		        <td style="width:120px;">申请人姓名：</td>
		        <td>
 		        	<input name="" class="mini-textbox" style="display: none;"/>
 		        	<input name="" class="mini-textbox" style="display: none;"/>
		            <input id="" name="" class="mini-textbox miniext-form-fit" required="true" requiredErrorText="客户名称不能为空"/>
		        </td>
		        <td style="width:120px;">性别：</td>
		        <td>
					<div name="" class="mini-radiobuttonlist"
						data="[{id:'0',text:'男'},{id:'1',text:'女'}]"
						textField="text" valueField="id" >
					</div>
		        </td>
		    </tr>
		    <tr>
		    	<td style="width:100px;">证件类型：</td>
		        <td>
					<input id="" name="" class="mini-textbox miniext-form-fit" />
		        </td>
		        <td class="miniext-form-td">证件号码：</td>
		        <td>
					<input name="" class="mini-textbox miniext-form-fit" allowInput="false"/>
		        </td>
		     </tr>
		    <tr>
		        <td >出生日期：</td>
		        <td>
					<input name="" class="mini-datepicker miniext-form-fit"/>
		        </td>
		        <td class="miniext-form-td">婚烟状态：</td>
		        <td>
					<input name="" class="mini-combobox miniext-form-fit" textField="name" 
	                  	   valueField="value"  
						   dataField="datas"
						   allowInput="false" 
						   data-options="{_params:{pid:'marital_status'}}" 
						   onbeforeshowpopup="onbeforeshowpopup"
					/>
		        </td>
		    </tr>
		    <tr>
		        <td class="miniext-form-td">学历：</td>
		        <td >
					<input name="" class="mini-combobox miniext-form-fit" textField="name" 
	                  	   valueField="value"  
						   dataField="datas"
						   allowInput="false" 
						   data-options="{_params:{pid:'school'}}" 
						   onbeforeshowpopup="onbeforeshowpopup"
					/>
		        </td>
		        <td class="miniext-form-td">户口所在地：</td>
		        <td >
					<input id="" name="" class="mini-textbox miniext-form-fit" />
		        </td>
		    </tr>
		    </tr>
		    <tr>
		        <td class="miniext-form-td">邮寄地址：</td>
		        <td colspan="3">
					<input name="" class="mini-textbox miniext-form-fit2"/>
		        </td>
		    </tr>
		    <tr>
		    	<td class="miniext-form-td">手机号码：</td>
		        <td >
					<input name="" class="mini-textbox miniext-form-fit"/>
		        </td>
		        <td class="miniext-form-td">电话：</td>
		        <td >
					<input name="" class="mini-textbox miniext-form-fit"/>
		        </td>
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
<script>
mini.parse();
var form = new mini.Form("form1");
var opertype="<%=opertype%>";
function onbeforeshowpopup(e) {
	miniui_ext.onbeforeshowpopup(e);
}
function $mini(id){
	return mini.get(id);
}
function oncountrychanged(e){
	$mini("province").setValue("");
}
function onprovincechanged(e){
	$mini("city").setValue("");
}
function changecountrybefore(e){
	var cb=e.sender;
	var country = $mini("country").getValue();
	if("" == country){
		mini.alert("请先选择国家!");
		return;
	}
	var url = cb._url ||getRootPath()+'/table/getTableData.action?tracywindyRandom=1&decorate=none';//url 
    var xmlFileName = cb._xmlFileName;
	cb.setUrl(url+"&xmlFileName="+xmlFileName+"&pid="+country);
	
}
function changeprovincebefore(e){
	var cb=e.sender;
	var province = $mini("province").getValue();
	if("" == province){
		mini.alert("请先选择省份!");
		return;
	}
	var url = cb._url ||getRootPath()+'/table/getTableData.action?tracywindyRandom=1&decorate=none';//url 
    var xmlFileName = cb._xmlFileName;
	cb.setUrl(url+"&xmlFileName="+xmlFileName+"&pid="+province);
}
function SetData(data) {
	var form = new mini.Form("form1");
    //跨页面传递的数据对象，克隆后才可以安全使用
    data = mini.clone(data);
    $.ajax({
        url: "<%=request.getContextPath() %>/table/getTableData.action?tracywindyRandom=1&decorate=none&xmlFileName=/eleasing/jsp/cust_info/cust_person/get_custinfoperson_byid.xml&id=" + data.id,
        cache: false,
        success: function (text) {
        	var result = mini.decode(text);
            form.setData(result.datas[0]);
            miniui_ext.initcomboboxloaddata("form1",result.datas[0]);
            form.setChanged(false);
        }
    });
}
function save(e){
	var o = form.getData(true,true); 
    if (miniui_ext.fromvalidation('form1') == false) return;
    var url="";
    if(opertype=="add"){
		url="<%=request.getContextPath() %>/acl/addCustEwlp.acl";
	}else{
		url="<%=request.getContextPath() %>/acl/updateCustEwlp.acl";
	}
    var json = mini.encode(o);
	$.ajax({
        url: url,
        type: "post",
        data:  o ,
        success: function (text) {
        	CloseWindow("savesuccess");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
        }
    });
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
function onCloseClick(e) {
    var obj = e.sender;
    obj.setText("");
    obj.setValue("");
}
</script>
</body>
</html>