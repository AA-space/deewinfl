<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金/罚息实收应开票数据提醒清单</title>
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
var currentLoginUserId = "${sessionScope['login_userid']}";
var isAdmin=false;
var tools=[ {
		html : '<font color="red">生成开票清单</font>',
			handler : function(table) {
    	var operType = "生成";
			var operTitle = "租金/罚息实收应开票数据";
			var operAction = "submitRentIncome";
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
				if("确认中"==checkedRawData.status||"已导出"==checkedRawData.status){
					alert("该条"+operTitle+checkedRawData.status+"，不允许重复提交！！！");
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
			iconCls : 'icon-save'
		},{
			html : '<font color="red">不生成开票清单</font>',
			handler : function(table) {
			var operType = "不生成";
			var operTitle = "租金/罚息实收应开票";
			var operAction = "removeRentIncome";
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
				if("已确认"==checkedRawData.status){
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
			iconCls : 'icon-cancel'
		} ];
</script >
<permission:action  code="interest_master">
<script type="text/javascript">
isAdmin=true;
tools='';
</script >
</permission:action>

<permission:action  code="rent_account">
<script type="text/javascript">
isAdmin=true;
tools='';
</script >
</permission:action>

<permission:action  code="tax_account">
<script type="text/javascript">
isAdmin=true;
tools='';
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
         title:'租金/罚息实收应开票数据提醒清单',
         tools : tools,
 		
         
         id:'id_table',
         xmlFileName:'/eleasing/jsp/invoice_manage/rent_invoice/rent_invoice_income.xml',
         loadMode:'ajax',
         isPage:true,
         pageSize : 20,
         isExcel:true,
         isCheck:true,
         checkType:'checkbox',
         params:{
        	 status:"未生成','已退回"
         },
 		 isRank:false,
         columns:[
			        {name:'id',  header:'id',hidden:true},
			       {name:'typename',  header:'typename',hidden:true},
			       {name:'contractid',  header:'合同号',nullable:false ,width:80,queryConfig:{}},
			       {name:'contractnumber',  header:'业务合同编号',nullable:false ,queryConfig:{},width:150},
			       {name:'custname',  header:'客户名称',nullable:false ,queryConfig:{}},
			       {name:'dealername',  header:'经销商名称',nullable:false},
			       {name:'rentlist',  header:'期项',nullable:false,width:40 },
			       {name:'rent',  header:'租金',nullable:false,type:'double' },
			       {name:'corpus',  header:'本金',nullable:false,type:'double' },
			       {name:'interest',  header:'利息',nullable:false,type:'double' },
			       {name:'penalty',  header:'罚息',nullable:false,type:'double' },
			       {name:'moneytype',  header:'金额类型',nullable:false },
			       {name:'plandate',  header:'实收日期',type:'date',isRange:true,queryConfig:{isNewLine:true}},
			       {name:'plan_date',  header:'计划日期',nullable:false,type:"date",isRange:true,queryConfig:{}},
			       {name:'taxtype',  header:'发票类型',nullable:false ,type:'combobox',queryConfig:{
		            	loadMode:'local',
		            	datas:[
		            	{title:'增值税专用发票',name:'增值税专用发票'},
		            	{title:'增值税普通发票',name:'增值税普通发票'},
		            	{title:'全部',name:''}
		            	],
		            	displayField:'title',
		            	valueField:'name',
		            	value:''
		            	
		            }},
			       {name:'rentinvoicetype',  header:'开票方式',nullable:false },
			       {name:'status',  header:'状态',type:'combobox',
		            	queryConfig:{
		            	isNewLine:true,
		            	colSpan:3, 
		            	loadMode:'local',
		            	datas:[
                        {title:'未生成',name:'未生成'},       
                        {title:'确认中',name:'确认中'},
		            	{title:'已导出',name:'已导出'},
		            	{title:'已退回',name:'已退回'}
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

