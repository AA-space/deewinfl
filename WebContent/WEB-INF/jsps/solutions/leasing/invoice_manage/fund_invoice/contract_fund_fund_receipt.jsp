<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资金实收开票确认（收据）</title>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
<style type="text/css">
    html,body{
        overflow:hidden;
    }
</style>

<script type="text/javascript">
/**
 * 金额大写转换函数
 */
function money2DX(money) {
	if (!/^(0|[1-9]\d*)(\.\d+)?$/.test(money)){
		return "数据非法";
	}
	var unit = "千百拾亿千百拾万千百拾元角分", str = "";
	money += "00";
	var p = money.indexOf('.');
	if (p >= 0){
		money = money.substring(0, p) + money.substr(p + 1, 2);
	}
	unit = unit.substr(unit.length - money.length);
	for (var i = 0; i < money.length; i++){
		str += '零壹贰叁肆伍陆柒捌玖'.charAt(money.charAt(i)) + unit.charAt(i);
	}
	return str.replace(/零(千|百|拾|角)/g, "零").replace(/(零)+/g, "零").replace(/零(万|亿|元)/g, "$1").replace(/(亿)万|壹(拾)/g, "$1$2").replace(/^元零?|零分/g, "").replace(/元$/g, "元整");
};
function createNote(table){
	var plandata = table.getCheckedRowDatas();
	ids="";
	contracts="";
	filename="";
	var MS_receipt=[];
	var params ={};
	var tempIdArr=[];
	for(var i=0;i<plandata.length;i++){
    	var id=plandata[i].id;
    	tempIdArr.push(id);
    	if("等待导出" == plandata[i].status || "已导出" == plandata[i].status ){
	    	var contractnumber=plandata[i].contractnumber;
	    	//var custname=plandata[i].custname;
	    	var contractid=plandata[i].contractid;
	    	//收据数据
	    	var payobj=plandata[i].payobj;//付款对象
	    	var factdate=plandata[i].factdate;
	    	var incomedate=factdate.substr(0,4)+"年"+factdate.substr(5,2)+"月"+factdate.substr(8,2)+"日";//收款时间
	    	var receipttitle="收到"+plandata[i].custname+plandata[i].feetype;
	    	var moneymin="￥"+parseFloat(plandata[i].dactmoney).toFixed(2);
	    	var moneymax=money2DX(parseFloat(plandata[i].dactmoney).toFixed(2));
	    	MS_receipt.push({id:id,memo:contractnumber,modelname:'overduenotice',sheetname:plandata[i].contractid+plandata[i].feetype+'收据'+Math.round(Math.random()*10000),'contractid':contractid,'incomedate':incomedate,'payobj':payobj,'receipttitle':receipttitle,'moneymin':moneymin,'moneymax':moneymax});
	    	
		}else{
	    	alert("只能生成等待导出和已导出的数据");
			return;
	    }
    }
	/*后台改收据状态为4  已导出*/
	params["cffcid"] = tempIdArr.join(",");
	$.ajax({
	  	type: "POST",
	  	cache : false,
		async : false,
	    url:  getRootPath()+"/leasing/checkVtatusInfo.action",
	    data: params,
	    success: function(msg){
	    	if (msg == "no"){
	    		alert("变更已导出状态请求失败!");
	    	}
	    	else{
	    		//alert( msg );//return yes
	    	}
	    	table.reload();
	   }
	});
	/*后台改收据状态为4  已导出  end*/
	var url="/leasing/template/createFileByTemplateClass.action";
	attachmentDown({url:url,title:"下载通知函",twoClassify:'wordtempletypetwo1234',returnType:'list',MS_receipt:MS_receipt});
	
}

	var buttons = {
		
		submitButton: {
			html : '提交',
			iconCls : 'icon-save',
			handler : function(table) {
	 			var operType = "提交";
				var operTitle = "资金实收收据";
				var operAction = "submitFundReceipt2";
	 	 		var checkedRowDatas = table.getCheckedRowDatas();
				var currentLoadMask = null;
		        var params = {};
		        var tempIdArr = [];
		        var tempPIdArr = [];
		 		if(0 == checkedRowDatas.length){
	    			alert("请选择要"+operType+"的记录！！");
	    			return;
	    		}
		        for(var i = 0;i<checkedRowDatas.length;i++){
					var checkedRowdata = checkedRowDatas[i];
					var id = checkedRowdata.id;
					var paymentid=checkedRowdata.paymentid;
					var checkedRawData=checkedRowDatas[i];
					if("等待提交" != checkedRawData.status){
						alert("只能提交等待提交的数据");
						return;
					}
					tempIdArr.push(id);
					tempPIdArr.push(paymentid);
				}
				params["ids"] = tempIdArr.join(",");
				params["paymentids"] = tempPIdArr.join(",");
				if(!window.confirm(("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？"))) {
					return;
				}
				var loadMaskMsg="正在"+operType+operTitle+"    请稍后... ";
				var url=getRootPath()+"/acl/"+operAction+".acl";
				currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
				currentLoadMask.show();
				ajaxRequest({
	                url:url,
	                params:params,
	                timeout:30*1000,
	                failure:function(){
	                	alert("请求提交失败");
	                	currentLoadMask.hide();
	                },
	                success:function(res){//孙传良 修改  显示出action返回值
	        	   		res=res.responseText;
	        	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
			     	    if(res!=''){
				    	 	alert(res);
			     	    }else{
			     	    	alert(operType+operTitle+"成功！！");
			     	    }
	                    currentLoadMask.hide();
	                    table.reload();
	                }
	            });
			}
	 	},
	 	
		confirmButton: {
			html : '确认',
			iconCls : 'icon-ok',
			handler : function(table) {
	 			var operType = "确认";
				var operTitle = "资金实收收据";
				var operAction = "submitFundReceipt1";
	 	 		var checkedRowDatas = table.getCheckedRowDatas();
				var currentLoadMask = null;
		        var params = {};
		        var tempIdArr = [];
		        var tempPIdArr = [];
		 		if(0 == checkedRowDatas.length){
	    			alert("请选择要"+operType+"的记录！！");
	    			return;
	    		}
		        for(var i = 0;i<checkedRowDatas.length;i++){
					var checkedRowdata = checkedRowDatas[i];
					var id = checkedRowdata.id;
					var paymentid=checkedRowdata.paymentid;
					var checkedRawData=checkedRowDatas[i];
					if("等待确认" != checkedRawData.status){
						alert("只能确认等待确认的数据");
						return;
					}
					tempIdArr.push(id);
					tempPIdArr.push(paymentid);
				}
				params["ids"] = tempIdArr.join(",");
				params["paymentids"] = tempPIdArr.join(",");
				if(!window.confirm(("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？"))) {
					return;
				}
				var loadMaskMsg="正在"+operType+operTitle+"    请稍后... ";
				var url=getRootPath()+"/acl/"+operAction+".acl";
				currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
				currentLoadMask.show();
				ajaxRequest({
	                url:url,
	                params:params,
	                timeout:30*1000,
	                failure:function(){
	                	alert("请求提交失败");
	                	currentLoadMask.hide();
	                },
	                success:function(res){//孙传良 修改  显示出action返回值
	        	   		res=res.responseText;
	        	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
			     	    if(res!=''){
				    	 	alert(res);
			     	    }else{
			     	    	alert(operType+operTitle+"成功！！");
			     	    }
	                    currentLoadMask.hide();
	                    table.reload();
	                }
	            });
			}
	 	},
	 	/*
	 	exportButton : {
			html : '导出',
			iconCls : 'icon-print',
			handler : function(table) {
	 			var operType = "导出";
				var operTitle = "资金实收收据";
				var operAction = "exportFundReceipt";
	 	 		var checkedRowDatas = table.getCheckedRowDatas();
		        var tempIdArr = [];
		 		if(0 == checkedRowDatas.length){
	    			alert("请选择要"+operType+"的记录！！");
	    			return;
	    		}
		 		
		        for(var i = 0;i<checkedRowDatas.length;i++){
					var checkedRowdata = checkedRowDatas[i];
					var id = checkedRowdata.id;
					var checkedRawData=checkedRowDatas[i];
					if("等待导出" != checkedRawData.status){
						alert("只能导出等待导出的数据");
						return;
					}
					tempIdArr.push(id);
				}
				
				if(window.confirm(("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？"))) {
					var loadMaskMsg="正在"+operType+operTitle+"    请稍后... ";
					var currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
					currentLoadMask.show();
					
					var ids = "'" + tempIdArr.join("','") + "'";
					
			    	var fileparames={
	    				ids:ids,
	    				userid:'${sessionScope["login_userid"]}',
		    			url:'/leasing/template/createFileByTemplateClass.action',
		    			title:"资金发票计划开票",
		    			modelname:'wordtempletypefirst.5',
		    			twoClassify:'fundchargeconfirmreceipt',
		    			returnType:'file',
		    			functionField:"moneychinese",
		    			'function':"convertMoneyToChinese",
		    			custoperatorMethod:'forReceiptInfoExportServiceCallback'
			    	};
			        attachmentDown(fileparames);
				}
			}
	 	},
	 	*/
	 	cancelButton : {
			html : '退回',
			iconCls : 'icon-cancel',
			handler : function(table) {
	 			var operType = "退回";
				var operTitle = "资金实收收据";
				var operAction = "updateFundReceiptForReturn";
	 	 		var checkedRowDatas = table.getCheckedRowDatas();
				var currentLoadMask = null;
		        var params = {};
		        var tempIdArr = [];
		        var tempPIdArr = [];
		 		if(0 == checkedRowDatas.length){
	    			alert("请选择要"+operType+"的记录！！");
	    			return;
	    		}
		        for(var i = 0;i<checkedRowDatas.length;i++){
					var checkedRowdata = checkedRowDatas[i];
					var id = checkedRowdata.id;
					var paymentid=checkedRowdata.paymentid;
					var checkedRawData=checkedRowDatas[i];
					if("等待确认" == checkedRawData.status || "已导出" == checkedRawData.status ){
						alert("等待确认和已导出的数据不允许退回");
						return;
					}
					tempIdArr.push(id);
					tempPIdArr.push(paymentid);
				}
				params["ids"] = tempIdArr.join(",");
				params["paymentids"] = tempPIdArr.join(",");
				if(!window.confirm(("确定"+operType+"当前"+checkedRowDatas.length+"条记录到上一流程么？"))) {
					return;
				}
				var loadMaskMsg="正在"+operType+operTitle+"    请稍后... ";
				var url=getRootPath()+"/acl/"+operAction+".acl";
				currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
				currentLoadMask.show();
				ajaxRequest({
	                url:url,
	                params:params,
	                timeout:30*1000,
	                failure:function(){
	                	alert("请求提交失败");
	                	currentLoadMask.hide();
	                },
	                success:function(res){//孙传良 修改  显示出action返回值
	        	   		res=res.responseText;
	        	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
			     	    if(res!=''){
				    	 	alert(res);
			     	    }else{
			     	    	alert(operType+operTitle+"成功！！");
			     	    }
	                    currentLoadMask.hide();
	                    table.reload();
	                }
	            });
			}
		},
		createword:{
     	    iconCls:'icon-import',
     	    html:'生成收据(自动设已导出)',
     	    handler:function(table){
     	    	createNote(table);
     	   }},
	};
</script>
<!--
<permission:action code="submitButton">
	<script type="text/javascript">
	    userButtons.push(buttons.submitButton);//出纳提交
	</script >
</permission:action>
<permission:action code="confirmButton">
	<script type="text/javascript">
		userButtons.push(buttons.confirmButton);//企划确认
	</script >
</permission:action>
<permission:action code="exportButton">
	<script type="text/javascript">
		userButtons.push(buttons.exportButton);//审核导出
	</script >
</permission:action>
-->

<script type="text/javascript">
var hasSubmitButton = false;//是否有提交按钮
var hasConfirmButton = false;//是否有确认按钮
var hasExportButton = false;//是否有导出按钮
var hasCancelButton = false;//是否有退回按钮
var hascreateword = false;//是否有生成收据
var userButtons = [];
</script >

<permission:action code="admin_action">
<script type="text/javascript">//超级系统管理员 提交 确认 导出 退回按钮
if(false == hasSubmitButton){
	userButtons.push(buttons.submitButton);
	hasSubmitButton = true;
}
if(false == hasConfirmButton){
	userButtons.push(buttons.confirmButton);
	hasConfirmButton = true;
}
if(false == hasExportButton){
	userButtons.push(buttons.exportButton);
	hasExportButton = true;
}
if(false == hasCancelButton){
	userButtons.push(buttons.cancelButton);
	hasCancelButton = true;
}
if(false == hascreateword){
	userButtons.push(buttons.createword);
	hascreateword = true;
}
</script>
</permission:action>

<permission:action code="interest_master">
<script type="text/javascript">
//财务部长：查看权限
</script >
</permission:action>

<permission:action code="rent_account">
<script type="text/javascript">// 提交 确认 导出 退回按钮
//租赁核算会计
if(false == hasSubmitButton){
	userButtons.push(buttons.submitButton);
	hasSubmitButton = true;
}
if(false == hasConfirmButton){
	userButtons.push(buttons.confirmButton);
	hasConfirmButton = true;
}
if(false == hasExportButton){
	userButtons.push(buttons.exportButton);
	hasExportButton = true;
}
if(false == hasCancelButton){
	userButtons.push(buttons.cancelButton);
	hasCancelButton = true;
}
if(false == hascreateword){
	userButtons.push(buttons.createword);
	hascreateword = true;
}
</script >
</permission:action>

<permission:action code="fund_account">
<script type="text/javascript">// 提交 确认 导出 退回按钮
//资金会计
if(false == hasSubmitButton){
	userButtons.push(buttons.submitButton);
	hasSubmitButton = true;
}
if(false == hasConfirmButton){
	userButtons.push(buttons.confirmButton);
	hasConfirmButton = true;
}
if(false == hasExportButton){
	userButtons.push(buttons.exportButton);
	hasExportButton = true;
}
if(false == hasCancelButton){
	userButtons.push(buttons.cancelButton);
	hasCancelButton = true;
}
if(false == hascreateword){
	userButtons.push(buttons.createword);
	hascreateword = true;
}
</script >
</permission:action>
    
<script type="text/javascript">
	var all_width = (document.documentElement||document.body).clientWidth-2;
	var all_height = (document.documentElement||document.body).clientHeight-2;
	
	jQuery(function(){
	   	var table = new tracywindyOperationTable({
	   		 width:all_width,
			 height:all_height,
	   		 tableComment:'[资金发票实收开票]',
	   		 constantFlagTable:'FundInvoice',
	   		 windowTop:20,
	   	     border:true,
	         renderTo:'id_tableContainer',
	         title:'资金发票实收开票',
	         id:'id_table',
	         xmlFileName:'/eleasing/jsp/invoice_manage/fund_invoice/contract_fund_fund_receipt.xml',
	         loadMode:'ajax',
	         isPage:true,
	         isFit:true,
	         isExcel:true,
	         operButtons : '',
	 		 tools : userButtons,
	         checkType:'checkbox',
	         isCheck:true,
	         isExcel:true,
	 		 isRank:false,
	 		 params:{
	     		enabled:"1",
	     		userid:"${sessionScope['login_userid']}"
		     },
	         columns:[
	            {header:'id',name:'id',hidden: true},
	            {header:'合同号',name:'contractid',queryConfig:{}},
	            {header:'业务合同号',name:'contractnumber'},
	            {header:'经销商',name:'dealername'},
	            {header:'客户名称',name:'custname',queryConfig:{}},
	            {header:'付款对象',name:'payobj'},
	            {header:'费用',name:'dactmoney'},
	            {header:'费用类型',name:'feetype'},
	            {header:'实收日期',name:'factdate',type:'date',isRange:true,queryConfig:{isNewLine:true}},
	            {header:'收据类型',name:'taxlevel'},
	            {header:'状态',name:'status',type:'combobox',
	            	queryConfig:{
		            	//isNewLine:false,
		            	colSpan:3, 
		            	loadMode:'local',
		            	datas:[
			            	{title:'等待确认',name:'等待确认'},
			            	{title:'等待提交',name:'等待提交'},
			            	{title:'等待导出',name:'等待导出'},
			            	{title:'已导出',name:'已导出'},
			            	{title:'其他',name:'其他'}
		            	],
		            	displayField:'title',
		            	valueField:'name',
		            	defaultValue:1
	            	}
	           	}]
		   });
	  });
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>