<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息</title>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/MustFillIn.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custType.js"></script>
<style>
body,html {
	overflow: hidden;
}
</style>

<script language="javascript">
	$(function() {
		var availWidth = parseInt(document.documentElement.clientWidth);
		var availHeight = parseInt(document.documentElement.clientHeight);
		$("#mianbody").css("height", availHeight - 30 + "px");
		$("#mianbody").css("width", availWidth - 20 + "px");
		
		var cust_id = '${param.cust_id}';
		var read_only =  '${empty param.read_only ? false : param.read_only}' ;
		if(!cust_id){
			alert("请输入用户ID");
			return;
		}
		
		var custInfoParam = {};
		custInfoParam.cust_id = cust_id;
		$.post('${pageContext.request.contextPath}/leasing/acl/getCustInfo.acl?radom=' + Math.random(), custInfoParam, function(value){
			var src = null;
			if(value.indexOf("查询失败") != -1){
				alert(value);
				return;
			}
			value = eval('(' + value + ')'); 
			var $title = $('#title');
			switch (value.custType) {
			case 'CUST_INFO_PERSON':
				//个人
				src = "${pageContext.request.contextPath}/leasing/cust_info/cust_person/cust_person_detial.bi?cust_id="+ cust_id + '&read_only=' + read_only + '&radom=' + Math.random();
				$title.html('个人客户');
				break;
			case 'CUST_INFO_DEALER':
				//经销商
				src = "${pageContext.request.contextPath}/leasing/cust_info/cust_dealer/cust_dealer_detial.bi?cust_id="+ cust_id + '&read_only=' + read_only + '&radom=' + Math.random();
				$title.html('经销商');
				break;
			case 'CUST_INFO_COMPANY':
				//法人
				src = "${pageContext.request.contextPath}/leasing/cust_info/cust_company/cust_company_detial.bi?cust_id="+ cust_id + '&read_only=' + read_only + '&radom=' + Math.random();
				$title.html('法人客户');
				break;

			default:
				alert("未知客户类型，请查阅");
				return;	
				break;
			}
			
			if(src != null){
				$("#iframe").attr("src", src);
			}
		});
	})
</script>

</head>
<body>

	<div style="margin-left: 10px; margin-top: 10px; height: 30px; width: 80%">
		<div id="title" class="x-panel-table-div-title" style="width: 80px; text-align: center">客户信息</div>
	</div>
	<div id="mianbody" style="border-style: solid; margin: 0 10px 10px 10px; border-color: #DDDDDD; border-width: 2px; width: 800px; height: 500px; text-align: center">
		<div id="id_custForm" style="overflow: hidden; margin: 10px 10px 10px 10px; border-style: solid; border-color: #DDDDDD; border-width: 2px; width: 98.2%; height: 90%">
			<iframe id="iframe" frameborder=0 style="border-width: 0px; width: 100%; height: 100%; display: block;" ></iframe>
		</div>
		<div style="text-align: right; height: 30px; margin: 0px">
			<a style="margin-left: 20px; margin-right: 20px" href="javascript:void(0);" class="btn btn-primary" onclick='window.close()'><span>关闭</span></a>
		</div>
	</div>
</body>
</html>