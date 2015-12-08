<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="/WEB-INF/tlds/c.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@include file="/base/mini.jsp" %>
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
<html>
<body style="overflow: auto;">
<h1 align="center">文件管理</h1>
	<div>
		<table class="fillTable" cellspacing="0" cellpadding="0" style="width:100%;" id="contract_base_info">
			<tr>
				<td style="padding:5px">
					<a class="mini-button" iconCls="icon-save" onclick="saveData(0)">正常提交</a>
					<span class="separator"></span>
					<c:choose>
		   				<c:when test="${param.isbuhezuo ne '2'}">
							<a class="mini-button" iconCls="icon-save" onclick="saveData(1)">提交到不合作经销商</a>
							<span class="separator"></span>
		   				</c:when>
		   			</c:choose>
					<a class="mini-button" iconCls="icon-close" onclick="onCancel">关闭</a>
				</td>
				<td>
					年份:&nbsp;&nbsp;&nbsp;<input name="year" id="year" onClick="WdatePicker(this,{maxDate:'%y',dateFmt:'yyyy'})" dataType="date" readOnly class="Wdate"
					onchange="changeView()" type="text" require="true" label="年份" />
				</td>
			</tr>
		</table>
	</div>
	<div id="treegrid1" class="mini-treegrid" style="width: 100%;"
		url="${pageContext.request.contextPath}/table/getTableData.action?xmlFileName=\\eleasing\\workflow\\dealer_file_management\\dealer_file_detail.xml&cust_id=<%= request.getParameter("cust_id")%>"
		idField="id" allowResize="true" pageSize="20" dataField="datas"
		allowCellEdit="true" allowCellSelect="true" multiSelect="true"
		editNextOnEnterKey="true" editNextRowCell="true">
		<div property="columns">
			<div type="indexcolumn"></div>
			<div name="id" field="id" width="160" visible="false"></div>
			<div name="fileid" field="fileid" width="160" visible="false"></div>
			<div name="fileindex" field="fileindex" width="10">序号</div>
			<div name="filename" field="filename" width="160">合同/文件名称</div>
			<div name="filenum" field="filenum" width="60">份数
				<input property="editor" class="mini-textbox" vtype="int"/>
			</div>
			<div type="checkboxcolumn" name="filestatus" field="filestatus"
				trueValue="1" falseValue="0" width="60">是否齐全</div>
			<div field="memo" name="memo" width="160" align="right">备注 
				<input property="editor" class="mini-textbox" style="width: 100%;" />
			</div>
		</div>
	</div>
<script type="text/javascript">
jQuery(function(){
	var defaultyear = new Date().getFullYear();
	 $("#year").val(defaultyear);
	grid.load({year:defaultyear});
});
mini.parse();
var grid = mini.get("treegrid1");
	
function saveData(flag) {
	grid.validate();
	var changedata = grid.getData();
	var json = mini.encode(changedata);
	var datas = {};
	datas.jsondata = mini.encode(changedata);
	datas.flag = flag;
	datas.custid = '${param.cust_id}';
	grid.loading("保存中，请稍后......");
	$.ajax({
	    url: getRootPath()+"/acl/saveDealerFileData.acl",
	    data: { data: datas },
	    type: "post",
	    success: function (text) {
	    	if('0'==flag){
		        mini.alert("正常提交成功!");
	    	}else{
	    		mini.alert("提交到不合作经销商成功!");
	    	}
	        grid.reload();
	    },
	    error: function (jqXHR, textStatus, errorThrown) {
	        alert(jqXHR.responseText);
	    }
	});
};
function onCancel(e) {
	window.close();
};
function getRootPath() {
	var strFullPath = window.document.location.href;
	var strPath = window.document.location.pathname;
	var pos = strFullPath.indexOf(strPath);
	var prePath = strFullPath.substring(0, pos);
	var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
	return (prePath + postPath);
};
function changeView(){
	var selectYear =  $("#year").val();
	grid.load({year:selectYear});
};

</script>
</body>
</html>
 