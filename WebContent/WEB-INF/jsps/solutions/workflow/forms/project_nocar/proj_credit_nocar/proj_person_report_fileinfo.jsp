<%@page import="java.net.URLEncoder"%>
<%@page import="com.business.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>项目信审 - 文件清单</title>
<jsp:include page="../proj_approval_nocar/boot.jsp"></jsp:include>
</head>
<body>
<div id="grid1">
	<div class="mini-panel" title="文件清单" showCollapseButton="true" style="width: 100%;">
	    <!-- 按钮操作 -->
	    <div id="projGuaranteeForm1"  class="mini-toolbar miniext-toolbar-top">
	        <table class="miniext-form-fit">
	            <tr>
		            <td>
		                <a class="mini-button" iconCls="icon-addfolder" plain="true" onclick="addFileinfoRow">增加</a>
		                <span class="separator"></span>
		                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="removeFileinfoRow">删除</a>
		            </td>
	            </tr>
	        </table>
	    </div>
	    <!--grid展示--撑满页面-->
	    <div id="fileinfogrid" class="mini-datagrid" style="width:100%;height:300px;" datafield=""
	        url=""  
	        sizeList="[5,10,20,50]" pageSize="10"  idfield=""
		     allowResize="true" showColumnsMenu="true"
		     allowCellEdit="true" allowCellSelect="true" multiSelect="true"
		     allowCellValid="true"
	    >
	        <div property="columns">
	        	<div type="checkcolumn"></div>
	            <div type="indexcolumn" headerAlign="center">序号</div>
	            <div field="fileinfoname" align="center" headerAlign="center">
	            	资料名称
	            	<input property="editor" class="mini-textbox" style="width:100%;"/>
	            </div>
	            <div field="purpose"  headerAlign="center">
	            	说明及目的
	            	<input property="editor" class="mini-textbox" style="width:100%;"/>
	            </div>                                    
	            <div field="collect"  headerAlign="center">收集情况
	            	<input property="editor" class="mini-textbox" style="width:100%;"/>
	            </div>
	            <div field="remark"  headerAlign="center">备注
	            	<input property="editor" class="mini-textbox" style="width:100%;"/>
	            </div>
	        </div>
	    </div> 
	</div>
</div>
</body>
</html>
<script>                 
 	mini.parse();
 	var grid = mini.get("fileinfogrid");
 	//var temp='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }';
 	var temp = parent.document.getElementById("id_json_proj_file_detail_str").value;  
 	var isViewHistoryTask="<%= request.getParameter("isViewHistoryTask")%>";
 	grid.setData(mini.decode(temp));
 	//调用返回到主页面
 	function returnTab(){
 		return grid;
 	}
 	
 	function returnHeight(){
 		return document.getElementById("grid1").offsetHeight;
 	}
 	function addFileinfoRow() {
		var fileinfogrid = $mini("fileinfogrid");
	    var newRow = {};
	    fileinfogrid.addRow(newRow, 0);
	    fileinfogrid.beginEditCell(newRow);
	}
	function removeFileinfoRow() {
		var fileinfogrid = $mini("fileinfogrid");
	    var rows = fileinfogrid.getSelecteds();
	    if (rows.length > 0) {
	    	fileinfogrid.removeRows(rows, true);
	    }
	}
	function $mini(id){
    	return mini.get(id);
    } 
	
	//控制只读页面
	if(isViewHistoryTask=="true"){
		grid.disable();
		$("#projGuaranteeForm1").hide();
	}
</script>