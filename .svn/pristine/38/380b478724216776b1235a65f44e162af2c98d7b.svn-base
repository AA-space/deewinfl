<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金回笼</title>
<!--css sheet-->
<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
<!--javascript libray-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
<style type="text/css">
html,body {
	overflow: hidden;
}

.picItem {
	float: left;
	padding: 5px 5px 5px 5px;
	border: 1px solid silver;
}
</style>

<script type="text/javascript">
	jQuery(function() {

		var all_width = document.body.clientWidth;
		var all_height = document.body.clientHeight;
		jQuery("#id_menuDetailInfoForm").show();
		jQuery("#id_menuDetailInfoForm").window({
			   closable:false,
			   top:20
		 });
		jQuery("#id_menuDetailInfoForm").window("open");
		
		/* var cust_id = '';
		var contract_id = '';
		var ebank_id = '';
		 */
		var combo_cust = new tracywindyComboBox({
			lazyLoad:true,
			id : 'id_combo_cust',
			width : 300,
			renderTo : 'id_cust_name',
			xmlFileName : '\\eleasing\\workflow\\public\\comboCustSelect.xml',
			loadMode : 'ajax',
			readOnly : false,
			isAjaxLenovo : true,
			dropListHeight : 300,
			topAdd : 0,
			leftAdd : 0,
			positionDropIconLeftAdd : -1,
			name : 'cust_info',
			displayField : 'name',
			valueField : 'value',
			//rawValue:empty2Other('${empty ProductType ? PROD_ID : ProductType }','推土机'),
			params : {
			//currentRawValue:''
			//parentid:'ProductType'
			},
			onSelect : function(r, v) {
				//cust_id  = v.value;
				combo_contract.setParam("cust_id",v.value);
				combo_contract.reload();
			}
		});
		
		
		var combo_contract = new tracywindyComboBox({
			lazyLoad:true,
			id : 'id_contract_name',
			width : 300,
			renderTo : 'id_contract_name',
			xmlFileName : '/eleasing/workflow/assets/combofundIncomeContractSelect.xml',
			loadMode : 'ajax',
			readOnly : false,
			isAjaxLenovo : true,
			dropListHeight : 300,
			topAdd : 0,
			leftAdd : 0,
			positionDropIconLeftAdd : -1,
			name : 'contract_info',
			displayField : 'name',
			valueField : 'value',
			//rawValue:empty2Other('${empty ProductType ? PROD_ID : ProductType }','推土机'),
			params : {
			//cust_id : cust_id
			//parentid:'ProductType'
			},
			onSelect : function(r,v) {
				//contract_id = v.value;
				combo_ebank.setParam('contract_id', v.value);
				//alert(combo.datas),
				//combo.rawValue='aaaaa',
				//	combo.reload();
			}
		});
		
		var combo_ebank = new tracywindyComboBox({
			lazyLoad:true,
			id : 'id_combo_ebank',
			width : 300,
			renderTo : 'id_ebank_name',
			xmlFileName : '\\eleasing\\workflow\\ebank\\comboEbankSelect.xml',
			loadMode : 'ajax',
			readOnly : false,
			isAjaxLenovo : true,
			dropListHeight : 300,
			topAdd : 0,
			leftAdd : 0,
			positionDropIconLeftAdd : -1,
			name : 'ebank_info',
			displayField : 'ebankid',
			valueField : 'ebankid',
			//rawValue:empty2Other('${empty ProductType ? PROD_ID : ProductType }','推土机'),
			params : {
			//currentRawValue:''
			//parentid:'ProductType'
			}
		});
	});
	function openWindow() {
		var contract_id = getTracywindyObject('id_contract_name').getValue();
		alert(contract_id);
		var ebank_id = getTracywindyObject('id_combo_ebank').getValue();
		var cust_id=getTracywindyObject('id_combo_cust').getValue();
		if (!contract_id) {
			alert("请选择合同!");   
			return false;
		} else if(!ebank_id){
			alert("请选择网银编号!");
			return false;
		} else {
			var attachmentParams = "contract_id=" + contract_id + "&ebank_id=" + ebank_id+"&cust_id="+cust_id;
			//alert(attachmentParams);
			startProcess("租金回笼流程-1", attachmentParams);
			//jQuery.post('leasing/canStartFlow.action', {contract_id : contract_id, ebank_id : ebank_id}, function(r){
			//	if(r === 'true'){
			//		startProcess("租金回笼流程-1", attachmentParams);
			//	} else {
			//		alert("此合同对该条网银已发起流程，请检查后再试");
			//	}
			//});
		}
	}
</script>
</head>
<body>
	<div id="id_menuDetailInfoForm" class="easyui-window" closed="true" modal="true" title="租金回笼" style="display: none; width: 600px; height: 250px; text-align: center;">
		<center>
			<div style="width: 90%; padding-top: 30px;">
				<table align="center">
					<tr>
						<td class="input_label_desc">承租人:</td>
						<td class="input_value"><div id="id_cust_name" style="float: left;"></div></td>
						<td><span class="content-required">*</span></td>
					</tr>
					<tr>
						<td class="input_label_desc">合同编号:</td>
						<td class="input_value"><div id="id_contract_name" style="float: left;"></div></td>
						<td><span class="content-required">*</span></td>
					</tr>
					<tr>
						<td class="input_label_desc">网银编号:</td>
						<td class="input_value"><div id="id_ebank_name" style="float: left;"></div></td>
						<td><span class="content-required">*</span></td>
					</tr>
					<tr class="content-separator">
						<td colspan=3><a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='openWindow();'><span>确定</span></a> 
						<a style="margin-left: 20px;"
							href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_menuDetailInfoForm").window("close");'
						><span>取消</span></a></td>
					</tr>

				</table>
			</div>
		</center>
	</div>
</body>
</html>