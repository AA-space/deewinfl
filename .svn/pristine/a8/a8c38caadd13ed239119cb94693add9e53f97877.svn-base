<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邮件发送 - 任务列表</title>
    <!--css sheet-->
     <link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
	 <!--javascript libray-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
	<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	</style>
<script type="text/javascript">
var constantFlagTable = "EmailTask";
var pageWidth  = document.documentElement.clientWidth-2;
var pageHeight = document.documentElement.clientHeight-2;


//发送失败的消息再次发送
function sendEmailAgain(){
	var currentTable = getTracywindyObject('id_tableEmailTask');
	var checkRowDatas = currentTable.getCheckedRowDatas();
	var checkedSize = checkRowDatas.length;
	var ids = [];
	if(checkedSize > 0){
		for (var i = 0; i < checkedSize; i++) {
			var currentRow = checkRowDatas[i];
			ids.push(currentRow["id"]);
		}
		
		if(confirm('选中的记录将一律被重新发送，继续请点击确定！')){
			var idsStr = ids.join(',');
			if (!window.loadMask) {
		    	window.loadMask = new tracywindyLoadMask(document.body, "正在发送，请稍等...");
		    }
	        window.loadMask.show();
			ajaxRequest({
		    	method: 'POST',
		    	type: 'JSON',
		    	url: '${pageContext.request.contextPath}/leasing/acl/sendEmailAgain.acl',
		    	params: {ids : idsStr},
		    	failure: function(data){
		    		window.loadMask.hide();
		    		alert("发送失败！");
		    		currentTable.reload();
		    	},
		    	success: function(data){
		    		var responseObj = JsonUtil.decode(data.responseText);
					var result = responseObj["result"];
					window.loadMask.hide();
					if(result == 'success'){
						alert("发送完成。");
					} else {
						alert("发送失败！");
					}
					currentTable.reload();
		    	}
		    });
		}
	} else {
		alert("请选择要发送的邮件。");
	}
}


//将未发送的消息立即发送出去
function sendEmailNow(){
	var currentTable = getTracywindyObject('id_tableEmailTask');
	var checkRowDatas = currentTable.getCheckedRowDatas();
	var checkedSize = checkRowDatas.length;
	var ids = [];
	if(checkedSize > 0){
		var flag = true;
		for (var i = 0; i < checkedSize; i++) {
			var currentRow = checkRowDatas[i];
			var sendFlag = currentRow["sendflag"];
			if(sendFlag == 0){
				ids.push(currentRow["id"]);
			} else {
				flag = false;
			}
		}
		var noSendSize = ids.length;
		if(flag == false && noSendSize == 0){//全部不是未发送状态的
			alert("请选择未发送状态的邮件进行发送。");
		} else {
			if (flag == false && noSendSize > 0){
				if(false == confirm('您的选择中有已发送状态的记录，这些记录将被忽略，继续发送请点确定！')){
					return;
				}
			}
			if (!window.loadMask) {
		    	window.loadMask = new tracywindyLoadMask(document.body, "正在发送，请稍等...");
		    }
			window.loadMask.show();
			var idsStr = ids.join(',');
			ajaxRequest({
		    	method: 'POST',
		    	type: 'JSON',
		    	url: '${pageContext.request.contextPath}/leasing/acl/sendEmailNow.acl',
		    	params: {ids : idsStr},
		    	failure: function(data){
		    		window.loadMask.hide();
		    		alert("发送失败！");
		    		currentTable.reload();
		    	},
		    	success: function(data){
		    		var responseObj = JsonUtil.decode(data.responseText);
					var result = responseObj["result"];
					window.loadMask.hide();
					if(result == 'success'){
						alert("发送完成。");
					} else {
						alert("发送失败！");
					}
					currentTable.reload();
		    	}
		    });
			
		}
	} else {
		alert("请选择要发送的邮件。");
	}
}

function downloadEmailAttachmentFile(fileName,filePath){
	var form = jQuery('#downloadEmailAttachmentFileForm');
	if(form.length == 0){
		form = jQuery('<form/>');
		form.attr('id','downloadEmailAttachmentFileForm');
		form.attr('method','get');
		form.attr('action','leasing/acl/downloadEmailAttachmentFile.acl');
		form.appendTo(jQuery('body:first'));
		
		form.append(jQuery('<input type="hidden" name="browserType" value="' + SysBrowser.getBrowser().toLowerCase() + '"/>'));
		form.append(jQuery('<input type="hidden" name="fileName" value="' + fileName + '"/>'));
		form.append(jQuery('<input type="hidden" name="filePath" value="' + filePath + '"/>'));
	} else {
		form.find('input[name="fileName"]').val(fileName);
		form.find('input[name="filePath"]').val(filePath);
	}
	form.submit();
}

function showDownloadFileName(value,tableObj,columnName,columnIndex,rowData){
	var filePaths = rowData['fileaddress'].split(',');
	var fileNames = rowData['filenames'].split(',');
	var field = '';
	for ( var i = 0; i < filePaths.length && i < fileNames.length; i++) {
	    field += "<a href='javascript:void(0);' onclick='downloadEmailAttachmentFile(\""+fileNames[i]+"\",\""+filePaths[i]+"\");'>" + fileNames[i] + "</a><br/>";
	}
    return field;
}

jQuery(function(){
	tracywindyOperationTable({
		beforeShowWindowCallBack:function(table, $form, operFlag){
			if(operFlag == 'add'){
				var nowDate = new Date().format('yyyy-MM-dd hh:mm:ss');
				$form.find("input[name='noticetime']").val(nowDate);
				$form.find("input[name='emailtype']").val('DELAYED');
			}
			if(operFlag == 'update'){
				var checkRowDatas = table.getCheckedRowDatas();
				if(checkRowDatas && checkRowDatas.length > 0){
					var rowData = checkRowDatas[0];
					if(rowData["sendflag"] != '0'){
						alert("只能修改未发送的邮件。");
						return false;
					}
				}
			}
			return true;
		},
		tableComment:'邮件任务 ',
		constantFlagTable:constantFlagTable,
		renderTo:'id_tableEmailTaskContainer',
		title:'邮件任务列表',
		width:window.formWidth||pageWidth,
		id:'id_tableEmailTask',
		formContainerId:'id_taskTaskInfoWindowContainer',
		xmlFileName:'/eleasing/jsp/email/email_task_list.xml',
		loadMode:'ajax',
		isPage:true,
		border:true,
		isRank:true,
		isFit:false,
		checkType:"checkbox",
		isCheck:true,
		isAutoHeight:false,
		width:pageWidth,
		height:pageHeight,
		validateForm:true,
		operButtons:'新增|修改|删除',
		tools:[
	        {html:'立即发送',iconCls:'icon-reckon',handler:sendEmailNow},
	        {html:'重新发送',iconCls:'icon-reckon',handler:sendEmailAgain}
	    ],
		columns:[
			{header:'id',name:'id',hidden:true},
			{header:'收件人地址',name:'emailaddress',queryConfig:{}},
			{header:'邮件标题',name:'emailtitle'},
			{header:'邮件内容',name:'emailcontent'},
			{header:'附件地址',name:'fileaddress',hidden:true},
			{header:'附件名称',name:'filenames',renderer:showDownloadFileName},
			{header:'预计发送时间',name:'noticetime'},
			{header:'发送时机',name:'emailtype',hidden:true},
			{header:'发送时机',name:'emailtypename',type:'combobox',
				queryConfig:{
					loadMode:'local',
					datas:[
						{name:'立即',val:'IMMEDIATELY'},
						{name:'延时',val:'DELAYED'}
					],
		            displayField:'name',
		            valueField:'val'
				}
			},
			{header:'实际发送时间',name:'sendtime'},
			{header:'发送状态',name:'sendflag',hidden:true},
			{header:'发送状态',name:'sendflagname',type:'combobox',
				queryConfig:{
					loadMode:'local',
					datas:[
						{name:'待发送',val:'0'},
						{name:'已发送',val:'1'}
					],
		            displayField:'name',
		            valueField:'val'
				}
			},
			{header:'反馈消息',name:'sendresult'},
			{header:'创建人',name:'creator'},
			{header:'创建时间',name:'createdate'}
		]
	});
});
</script>
</head>

<body>
	<div id="id_tableEmailTaskContainer"></div>
	<div id="id_taskTaskInfoWindowContainer" closed="true" modal="true" title="邮件任务" style="display:none;width:700px;padding-top:20px;">
		<center>
			<form id="id_detailInfoForm">
				<table style="width:90%;position: relative;">
				 	<tr>
				 		<td colspan="4">&nbsp;</td>
				 	</tr>
				 	<tr class="tr-even">
						<td class="input_label_desc" align="left">邮箱地址:</td>
						<td class="td-content" colspan="4">
							<input name="id" type="hidden" value=""/>
							<input name="emailtype" type="hidden" value="DELAYED"/>
							<input name="emailaddress" id="emailAddress" require="true" label="邮箱地址" dataType="Email" class="td-content-input" require="true" type="text" /><font color="red">&nbsp;*&nbsp;</font>
						</td>
					</tr>
					<tr class="tr-even">
						<td class="input_label_desc" align="left">邮件标题:</td>
						<td class="td-content" colspan="4">
							<input name="emailtitle" id="emailTitle" require="true" label="邮件标题" class="td-content-input" require="true" type="text" style="width: 95%;"/><font color="red">&nbsp;*&nbsp;</font>
						</td>
					</tr>
					<tr class="tr-even">
						<td class="input_label_desc" align="left">预计发送时间:</td>
						<td class="td-content" style="width: 200px;">
							<input name="noticetime" id="noticeTime" label="预计发送时间" class="Wdate td-content-input td-content-readonly" onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd hh:mm:ss'})" readonly="readonly" type="text"/>
						</td>
						<td class="input_label_desc" style="width: 60px;">立即发送:</td>
						<td class="td-content" colspan="2">
							<input name="sendnow" id="sendNow" type="checkbox"/>
						</td>
					</tr>
					<tr class="tr-odd">
						<td class="input_label_desc" align="left">邮件内容:</td>
						<td class="td-content" colspan="4">
							<textarea rows="3" name="emailcontent" require="true" label="邮件内容" style="width:95%;" require="true"></textarea><font color="red">&nbsp;*&nbsp;</font>
						</td>
					</tr>
					<tr class="content-separator">
						<td colspan='4'>
							<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='getTracywindyObject("id_tableEmailTask").operationTable();'><span>确定</span></a>
							<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_taskTaskInfoWindowContainer").window("close");'><span>取消</span></a>
						</td>                                                                                             
					</tr>
				</table>
			</form>
		</center>
	</div>
</body>
</html>
