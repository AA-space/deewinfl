<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金实收开票确认</title>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
	
<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	</style>
<script type="text/javascript">
var currentLoginUserId = "${sessionScope['login_userid']}";
var isAdmin=false;
var tools=[ {
		html : '<font color="red">导出租金实收开票数据</font>',
			handler : function(table) {
		var params = getQueryAreaParams(table,false);
 			var checkedRowDatas = table.getCheckedRowDatas();
 			if(0 == checkedRowDatas.length){
    			alert("请选择要导出的记录！！");
    			return;
    			}
 			var tempIdArr = [];
	        for(var i = 0;i<checkedRowDatas.length;i++){
				var checkedRowdata = checkedRowDatas[i];
				var id = checkedRowdata.id;
				tempIdArr.push("'"+id+"'");
			}
	    	var url="/acl/expTaxRentIncomeInvoice.acl";
	    	var fileparames={ids:tempIdArr.join(","),url:url,title:"租金实收开票",twoClassify:'rentchargeinvoiceconfirm',returnType:'file',modelname:'rentinvoiceconfirm'};
	        for(var p in params){
	        	fileparames[p]=params[p];
    	    }
	        attachmentDown(fileparames);
		},
			iconCls : 'icon-update'
		},
		{
			html : '<font color="red">退回开票清单</font>',
		handler : function(table){
			var operType = "退回";
			var operTitle = "租金实收开票清单";
			var operAction = "backRentIncome";
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
				if("已确认"==checkedRawData.invoicestatus){
					alert("该条"+operTitle+"已确认，不允许退回！！！");
					return;
					} 
			}
			if(!window.confirm(("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？"))) return;
			var loadMaskMsg="正在"+operType+operTitle+"    请稍后... ";
			var url=getRootPath()+"/acl/"+operAction+".acl";
			currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
			currentLoadMask.show();
			ajaxRequest({
               url:url,
               params:params,
               timeout:30*1000,
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
                   //successCallBack(table);
               }
          });
				},
			iconCls : 'icon-cancel'} ];
</script >
<permission:action  code="interest_master">
<script type="text/javascript">
isAdmin=true;
tools='';
</script >
</permission:action>

<permission:action  code="rent_account">
<script type="text/javascript">
isAdmin=false;
tools=[ {
	html : '<font color="red">导出租金实收开票数据</font>',
	handler : function(table) {
 var params = getQueryAreaParams(table,false);
		var checkedRowDatas = table.getCheckedRowDatas();
		if(0 == checkedRowDatas.length){
		alert("请选择要导出的记录！！");
		return;
		}
		var tempIdArr = [];
    for(var i = 0;i<checkedRowDatas.length;i++){
		var checkedRowdata = checkedRowDatas[i];
		var id = checkedRowdata.id;
		tempIdArr.push("'"+id+"'");
	}
	var url="/acl/expTaxRentIncomeInvoice.acl";
	var fileparames={ids:tempIdArr.join(","),url:url,title:"租金实收开票",twoClassify:'rentchargeinvoiceconfirm',returnType:'file',modelname:'rentinvoiceconfirm'};
    for(var p in params){
    	fileparames[p]=params[p];
    }
    attachmentDown(fileparames);
},
	iconCls : 'icon-update'
},
{
	html : '<font color="red">退回开票清单</font>',
handler : function(table){
	var operType = "退回";
	var operTitle = "租金实收开票清单";
	var operAction = "backRentIncome";
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
		if("已确认"==checkedRawData.invoicestatus){
			alert("该条"+operTitle+"已确认，不允许退回！！！");
			return;
			} 
	}
	if(!window.confirm(("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？"))) return;
	var loadMaskMsg="正在"+operType+operTitle+"    请稍后... ";
	var url=getRootPath()+"/acl/"+operAction+".acl";
	currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
	currentLoadMask.show();
	ajaxRequest({
       url:url,
       params:params,
       timeout:30*1000,
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
           //successCallBack(table);
       }
  });
		},
	iconCls : 'icon-cancel'} ];
</script >
</permission:action>

<permission:action  code="tax_account">
<script type="text/javascript">
isAdmin=false;
tools=[ {
	html : '<font color="red">导出租金实收开票数据</font>',
	handler : function(table) {
 var params = getQueryAreaParams(table,false);
        var checkedRowDatas = table.getCheckedRowDatas();
		if(0 == checkedRowDatas.length){
		alert("请选择要导出的记录！！");
		return;
		}
		var tempIdArr = [];
    for(var i = 0;i<checkedRowDatas.length;i++){
		var checkedRowdata = checkedRowDatas[i];
		var id = checkedRowdata.id;
		tempIdArr.push("'"+id+"'");
	}
	var url="/acl/expTaxRentIncomeInvoice.acl";
	var fileparames={ids:tempIdArr.join(","),url:url,title:"租金实收开票",twoClassify:'rentchargeinvoiceconfirm',returnType:'file',modelname:'rentinvoiceconfirm'};
    for(var p in params){
    	fileparames[p]=params[p];
    }
    attachmentDown(fileparames);
},
	iconCls : 'icon-update'
},
{
	html : '<font color="red">退回开票清单</font>',
handler : function(table){
	var operType = "退回";
	var operTitle = "租金实收开票清单";
	var operAction = "backRentIncome";
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
		if("已导出"==checkedRawData.status){
			alert("该条"+operTitle+"已导出，不允许退回！！！");
			return;
			} 
	}
	if(!window.confirm(("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？"))) return;
	var loadMaskMsg="正在"+operType+operTitle+"    请稍后... ";
	var url=getRootPath()+"/acl/"+operAction+".acl";
	currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
	currentLoadMask.show();
	ajaxRequest({
       url:url,
       params:params,
       timeout:30*1000,
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
           //successCallBack(table);
       }
  });
		},
	iconCls : 'icon-cancel'} ];
</script >
</permission:action>
	<script type="text/javascript">
	      var all_width = (document.documentElement||document.body).clientWidth-2;
	      var all_height = (document.documentElement||document.body).clientHeight-2;
	    </script>
<script type="text/javascript">
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		 renderTo:'id_tableContainer',
   		 width:all_width,
		 height:all_height,
		 //toolsLeftMargin:200,
		 windowTop:20,
   	     border:true,
         title:'租金实收开票确认',
         tools : tools,
         
         id:'id_table',
         xmlFileName:'/eleasing/jsp/invoice_manage/rent_invoice/rent_invoice_income_confirm.xml',
         loadMode:'ajax',
         isPage:true,
         isExcel:true,
         pageSize : 20,
         //isFit:true,
         isCheck:true,
         checkType:'checkbox',
         params:{
        	 status:'1'
         },
 		 isRank:false,
         columns:[
			       {name:'id',  header:'id',hidden:true},
			       {header:'合同号',name:'contractid',  queryConfig:{}},
			       {header:'业务合同号',name:'contractnumber',queryConfig:{}},
		           {header:'经销商',name:'dealername'},
			       {header:'客户名称',name:'custname',  queryConfig:{}},
			       {header:'期项',name:'rentlist' ,width:50   },
			       {header:'计划日期',name:'plandate',type:'date',isRange:true,queryConfig:{isNewLine:true}},
			       {header:'实收日期',name:'hiredate',type:'date',isRange:true,queryConfig:{isNewLine:true}},
			       {header:'开票金额',name:'taxmoney',type:'double' },
			       {header:'金额类型',name:'renttype' },
			       {name:'taxtype',  header:'发票类型',nullable:false ,type:'combobox',queryConfig:{
		            	loadMode:'local',
		            	datas:[
		            	{title:'增值税专用发票',name:'invoicetype1'},
		            	{title:'增值税普通发票',name:'invoicetype2'},
		            	{title:'全部',name:''}
		            	],
		            	displayField:'title',
		            	valueField:'name',
		            	value:''
		            	
		            }},
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
                        {title:'确认中',name:'1'},
		            	{title:'已导出',name:'2'}
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

