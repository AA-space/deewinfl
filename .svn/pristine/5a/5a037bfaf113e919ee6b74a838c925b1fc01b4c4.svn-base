<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>短信任务发送 - 任务列表</title>
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
var constantFlagTable = "SmsTask";
var pageWidth  = document.documentElement.clientWidth-2;
var pageHeight = document.documentElement.clientHeight-2;

jQuery(function(){
	tracywindyOperationTable({		
		beforeShowWindowCallBack:function(table, $form, operFlag){
			if(operFlag == 'add'){
				var nowDate = new Date().format('yyyy-MM-dd hh:mm:ss');
				$form.find("input[name='noticetime']").val(nowDate);
				$form.find("input[name='smstype']").val('DELAYED');
			}
			if(operFlag == 'update'){
				var checkRowDatas = table.getCheckedRowDatas();
				if(checkRowDatas && checkRowDatas.length > 0){
					var rowData = checkRowDatas[0];
					if(rowData["sendflag"] != '0'){
						alert("只能修改未发送的消息。");
						return false;
					}
				}
			}
			return true;
		},
		tableComment:'短信任务 ',
		constantFlagTable:constantFlagTable,
		renderTo:'id_tableTaskContainer',
		title:'短信任务列表',
		width:window.formWidth||pageWidth,
		id:'id_tableTask',
		formContainerId:'id_taskInfoWindowContainer',
		xmlFileName:'/eleasing/jsp/sms/sms_task_list.xml',
		loadMode:'ajax',
		isPage:true,
		border:true,
		isRank:true,
		isFit:false,
		isAutoHeight:false,
		width:pageWidth,
		height:pageHeight,
		checkType:"checkbox",
		isCheck:true,
		validateForm:true,
		tools:[
	        {html:'立即发送',iconCls:'icon-reckon',handler:sendSmsNow},
	        {html:'重新发送',iconCls:'icon-reckon',handler:sendSmsAgain}
	    ],
		columns:[
			{header:'id',name:'id',hidden:true},
			{header:'电话号码',name:'phonenumber',queryConfig:{}},
			{header:'短信内容',name:'smscontent'},
			{header:'预计发送时间',name:'noticetime'},
			{header:'发送时机',name:'smstype',hidden:true},
			{header:'发送时机',name:'smstypename',type:'combobox',
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


function sendSmsAgain(){
	var currentTable = getTracywindyObject('id_tableTask');
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
		    	url: '${pageContext.request.contextPath}/leasing/acl/sendSmsAgain.acl',
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
		alert("请选择要发送的短信。");
	}
}



function sendSmsNow(){
	var currentTable = getTracywindyObject('id_tableTask');
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
			alert("请选择未发送状态的短信进行发送。");
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
		    	url: '${pageContext.request.contextPath}/leasing/acl/sendSmsNow.acl',
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
		alert("请选择要发送的短信。");
	}
}
</script>
</head>
<body>
	<div id="id_tableTaskContainer"></div>
	<div id="id_taskInfoWindowContainer" closed="true" modal="true" title="短信任务" style="display:none;width:700px;padding-top:20px;">
		<center>
			<form id="id_detailInfoForm">
				<table style="width:90%">
				 	<tr>
				 		<td colspan="4">&nbsp;</td>
				 	</tr>
				 	<tr class="tr-even">
						<td class="input_label_desc" align="left">电话号码:</td>
						<td class="td-content" colspan="4">
							<input name="id" type="hidden" value=""/>
							<input name="smstype" type="hidden" value="DELAYED"/><!-- 默认延迟发送 -->
							<input name="phonenumber" id="phoneNumber" require="true" label="电话号码" dataType="Mobile" class="td-content-input" require="true" type="text" /><font color="red">&nbsp;*&nbsp;</font>
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
						<td class="input_label_desc" align="left">短信内容:</td>
						<td class="td-content" colspan="4">
							<textarea rows="3" name="smscontent" require="true" label="短信内容" style="width:95%" require="true"></textarea><font color="red">&nbsp;*&nbsp;</font>
						</td>
					</tr>
					<tr class="content-separator">
						<td colspan='4'>
						<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='getTracywindyObject("id_tableTask").operationTable();'><span>确定</span></a>
						<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_taskInfoWindowContainer").window("close");'><span>取消</span></a>
						</td>                                                                                             
					</tr>
				</table>
			</form>
		</center>
	</div>
</body>
</html>
