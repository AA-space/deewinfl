<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金实收开票确认（收据）</title>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>

<style type="text/css">
	html,body{
		overflow:hidden;
	}
</style>

<script type="text/javascript">
var currentLoginUserId = "${sessionScope['login_userid']}";
var isAdmin = false;

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
    	if("已确认" == plandata[i].status){
    	var contractnumber=plandata[i].contractnumber;
    	//var custname=plandata[i].custname;
    	var contractid=plandata[i].contractid;
    	//收据数据
    	var payobj=plandata[i].custname;//付款对象
    	var factdate=plandata[i].plandate;
    	var incomedate=factdate.substr(0,4)+"年"+factdate.substr(5,2)+"月"+factdate.substr(8,2)+"日";//收款时间
    	var receipttitle="收到"+payobj+"第"+plandata[i].rentlist+"期租金本金";
    	var moneymin="￥"+parseFloat(plandata[i].corpus).toFixed(2);
    	var moneymax=money2DX(parseFloat(plandata[i].corpus).toFixed(2));
    	MS_receipt.push({id:id,memo:contractnumber,modelname:'overduenotice',sheetname:plandata[i].contractid+"第"+plandata[i].rentlist+"租金本金收据"+Math.round(Math.random()*10000),'contractid':contractid,'incomedate':incomedate,'payobj':payobj,'receipttitle':receipttitle,'moneymin':moneymin,'moneymax':moneymax});
    	
	    }else{
    		alert("发票记录必须是已确认和已导出状态!");
    		table.reload();
    	}
    }
	/*后台改收据状态为2  已导出*/
	params["cffcid"] = tempIdArr.join(",");
	$.ajax({
	  	type: "POST",
	  	cache : false,
		async : false,
	    url:  getRootPath()+"/leasing/checkRentstatusInfo.action",
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
	/*后台改收据状态s  已导出  end*/
	debugger;
	var url="/leasing/template/createFileByTemplateClass.action";
	attachmentDown({url:url,title:"下载通知函",twoClassify:'wordtempletypetwo1234',returnType:'list',MS_receipt:MS_receipt});
	
}

var buttons = {
	/* exportData : {
		html : '<font color="red">导出收据</font>',
		handler : function(table) {
			var operType = "导出";
			var operTitle = "租金实收收据";
 	 		var checkedRowDatas = table.getCheckedRowDatas();
 	 		var selectRowsCount = checkedRowDatas.length;
	 		if(0 == selectRowsCount){
				alert("请选择要"+operType+"的记录！！");
				return;
			}

 	 		var tempIdArr = [];
	 		for(var i = 0;i < selectRowsCount; i++){
				var checkedRowdata = checkedRowDatas[i];
				var id = checkedRowdata.id;
				var checkedRawData=checkedRowDatas[i];
				if("已确认" != checkedRawData.status){
					alert("只能导出已确认的数据");
					return;
				}
				tempIdArr.push(id);
			}
	 		
			if(window.confirm("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？")) {
				var loadMaskMsg="正在"+operType+operTitle+"	请稍后... ";
				var currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
				currentLoadMask.show();
				var ids = "'" + tempIdArr.join("','") + "'";
				var attachmentParams = {
					ids:ids,//可以传递到sql——xml的数据参数
					userid:'${sessionScope["login_userid"]}',//可以传递到sql——xml的数据参数
					url:'/leasing/template/createFileByTemplateClass.action',//默认值
					title:"租金计划开票确认收据",
					modelname:'wordtempletypefirst.5',//一级分类
					twoClassify:'rentchargeconfirmreceipt',//二级分类
					returnType:'file',
					functionField:"moneychinese",//查询出来的数据需要做进一步处理的字段，多个逗号隔开
					'function':"convertMoneyToChinese",//查询出来的字段需要哪个函数处理，多个逗号隔开
					dateInitMethod:''//回调函数，在导出文件生成后执行 TODO
				};
				attachmentDown(attachmentParams);
			}
		},
		iconCls : 'icon-print'
	}, */
	confirm : {
		html : '<font color="red">确认</font>',
		iconCls : 'icon-ok',
		handler : function(table) {
			var operType = "确认";
			var operTitle = "租金计划应开票清单(收据)";
			var operAction = "confirmRentIncomeReceipt";// TODO
			var checkedRowDatas = table.getCheckedRowDatas();
			var currentLoadMask = null;
			var params = {};
			var tempIdArr = [];
			var tempPIdArr = [];
			for(var i = 0;i<checkedRowDatas.length;i++){
				var checkedRowdata = checkedRowDatas[i];
				var id = checkedRowdata.id;
				var paymentid=checkedRowdata.rentlist;
				tempIdArr.push(id);
				tempPIdArr.push(paymentid);
			}
			params["ids"] = tempIdArr.join(",");
			params["typnames"] = tempPIdArr.join(",");
			if(0 == checkedRowDatas.length){
				alert("请选择要"+operType+"的记录！！");
				return;
			}
			for(var i =0;i<checkedRowDatas.length;i++){
				var checkedRawData=checkedRowDatas[i];
				if("确认中" !=checkedRawData.status){
					alert("该条"+operTitle+checkedRawData.status+"，不允许重复提交！！！");
					return;
				} 
			}
			if(window.confirm("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？")) {
				var loadMaskMsg="正在"+operType+operTitle+"	请稍后... ";
				var url=getRootPath()+"/acl/"+operAction+".acl";
				currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
				currentLoadMask.show();
				ajaxRequest({
					url:url,
					params:params,
					timeout:30*1000,
					failure:function(){
						alert("操作失败！！");
					},
					success:function(res){//孙传良 修改 显示出action返回值
						res = res.responseText;
						res = res.replace(/(^\s+)|(\s+$)/g, ""); 
						if(res != '') {
							alert(res);
						} else {
							alert(operType+operTitle+"成功！！");
						}
						currentLoadMask.hide();
						table.reload();
					}
				});
			}
		}
	},
	cancel : {
		html : '<font color="red">退回开票清单</font>',
		handler : function(table){
			var operType = "退回";
			var operTitle = "租金实收开票清单（收据）";
			var operAction = "backRentIncomeReceipt";
			var checkedRowDatas = table.getCheckedRowDatas();
			var currentLoadMask = null;
			var params = {};
			var tempIdArr = [];
			var tempPIdArr = [];
			for(var i = 0;i<checkedRowDatas.length;i++){
				var checkedRowdata = checkedRowDatas[i];
				var id = checkedRowdata.id;
				var paymentid=checkedRowdata.typename;
				tempIdArr.push(id);
				tempPIdArr.push(paymentid);
			}
			params["ids"] = tempIdArr.join(",");
			params["typnames"] = tempPIdArr.join(",");
			if(0 == checkedRowDatas.length){
				alert("请选择要"+operType+"的记录！！");
				return;
			}
			for(var i =0;i<checkedRowDatas.length;i++){
				var checkedRawData=checkedRowDatas[i];
				if("确认中" !=checkedRawData.status){
					alert("该条"+operTitle+checkedRawData.status+"，不允许重复提交！！！");
					return;
				}  
			}
			if(!window.confirm(("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？"))) return;
			var loadMaskMsg="正在"+operType+operTitle+"	请稍后... ";
			var url=getRootPath()+"/acl/"+operAction+".acl";
			currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
			currentLoadMask.show();
			ajaxRequest({
				url:url,
				params:params,
				timeout:30*1000,
				failure:function(){
					alert("操作失败！！");
				},
				success:function(res){//孙传良 修改 显示出action返回值
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
		},
		iconCls : 'icon-cancel'
	},
	createword:{
 	    iconCls:'icon-import',
 	    html:'生成收据(自动设已导出)',
 	    handler:function(table){
 	    	createNote(table);
 	   }
	}
};

var userButtons = [];
var hasConfirmButton = false;//是否有确认按钮
var hasExportButton = false;//是否有导出按钮
var hasCancelButton = false;//是否有退回按钮
var hascreateword = false;//是否有生成收据
</script >


<permission:action code="admin_action">
	<script type="text/javascript">
		isAdmin = true;
	</script>
</permission:action>

<permission:action code="interest_master">
	<script type="text/javascript">
		if(false == hasConfirmButton){
			userButtons.push(buttons.confirm);
			hasConfirmButton = true;
		}
		if(false == hasExportButton){
			userButtons.push(buttons.exportData);
			hasExportButton = true;
		}
		if(false == hasCancelButton){
			userButtons.push(buttons.cancel);
			hasCancelButton = true;
		}
	</script >
</permission:action>

<permission:action code="rent_account">
	<script type="text/javascript">
		if(false == hasConfirmButton){
			userButtons.push(buttons.confirm);
			hasConfirmButton = true;
		}
		if(false == hasExportButton){
			userButtons.push(buttons.exportData);
			hasExportButton = true;
		}
		if(false == hasCancelButton){
			userButtons.push(buttons.cancel);
			hasCancelButton = true;
		}
		if(false == hascreateword){
			userButtons.push(buttons.createword);
			hascreateword = true;
		}
	</script >
</permission:action>

<permission:action code="fund_account">
	<script type="text/javascript">
		if(false == hasConfirmButton){
			userButtons.push(buttons.confirm);
			hasConfirmButton = true;
		}
		if(false == hasExportButton){
			userButtons.push(buttons.exportData);
			hasExportButton = true;
		}
		if(false == hasCancelButton){
			userButtons.push(buttons.cancel);
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
		new tracywindyTable({
			renderTo:'id_tableContainer',
			width:all_width,
			height:all_height,
			windowTop:20,
			border:true,
			title:'租金实收开票确认（收据）',
			tools : userButtons,
			id:'id_table',
			xmlFileName:'/eleasing/jsp/invoice_manage/rent_invoice/rent_invoice_income_receipt_confirm.xml',
			loadMode:'ajax',
			isPage:true,
			pageSize : 20,
			isCheck:true,
			isExcel:true,
			params:{
	        	 status:"确认中','已确认"
	         },
			isRank:false,
			columns:[
				{name:'id', header:'id',hidden: true},
				{header:'合同号',name:'contractid', queryConfig:{}},
				{header:'业务合同号',name:'contractnumber',queryConfig:{}},
				{header:'经销商',name:'dealername'},
				{header:'客户名称',name:'custname', queryConfig:{}},
				{header:'期项',name:'rentlist' ,width:50	},
				{header:'计划收款日',name:'plandate',type:"date",isRange:true,queryConfig:{isNewLine:true} },
				{header:'开票金额',name:'corpus', type:'double' },
				{header:'金额类型',name:'moneytype' },
				{header:'开票类型',name:'taxtype' },
				{header:'纳税人识别号',name:'taxregcode'},
				{header:'开户行',name:'taxbank'},
				{header:'账号',name:'taxacc'},
				{header:'电话',name:'taxphone'},
				{header:'地址',name:'taxregadd'},
				{name:'status',  header:'状态',type:'combobox',
	            	queryConfig:{
	            	isNewLine:false,
	            	colSpan:3, 
	            	loadMode:'local',
	            	datas:[
                    {title:'未生成',name:'未生成'},       
                    {title:'确认中',name:'确认中'},
	            	{title:'已导出',name:'已导出'},
	            	{title:'已退回',name:'已退回'},
	            	{title:'已确认',name:'已确认'}
	            	],
	            	displayField:'title',
	            	valueField:'name',
	            	value:''
	            	}
		       }
			]
		});
	});
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>