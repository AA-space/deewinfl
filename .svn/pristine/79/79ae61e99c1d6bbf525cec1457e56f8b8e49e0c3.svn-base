<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资金发票计划开票</title>
<!--css sheet-->
<link href="${pageContext.request.contextPath}/css/dtree/dtree.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/button.css"
	rel="stylesheet" type="text/css">
<!--javascript libray-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
<style type="text/css">
html,body {
	overflow: hidden;
}
</style>

<script type="text/javascript">
	var modifyParams = new Object();
	var tools=[{
		html : '确认',
		iconCls : 'icon-ok',
		handler : function(table) {
 			var operType = "确认";
 	 		var checkedRowDatas = table.getCheckedRowDatas();
			//var currentLoadMask = null;
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
				if("未确认" != checkedRawData.status){
					alert("只能确认未确认的数据");
					return;
				}
				tempIdArr.push(id);
				tempPIdArr.push(paymentid);
			}
			params["ids"] = tempIdArr.join(",");
			paramsnew=params;
			params["paymentids"] = tempPIdArr.join(",");
			if(!window.confirm((operType+"当前"+checkedRowDatas.length+"条记录的保险方式么？"))) {
				return;
			}
				
				var dialog = jQuery("#ebank_confirm");
		       dialog.show();
		      
				dialog.window({
					   top:10
				});
				dialog.window('open');
				
		}},
		{
			html : '修改',
			iconCls : 'icon-update',
			handler : function(table) {
			  var operType1="修改";
			 var checkedRowDatas1 = table.getCheckedRowDatas();
				//var currentLoadMask = null;
		        var params1 = {};
		        var tempIdArr1 = [];
		        var tempPIdArr1 = [];
		        if(0 == checkedRowDatas1.length){
	    			alert("请选择要"+operType1+"的记录！！");
	    			return;
	    		}
		        for(var i = 0;i<checkedRowDatas1.length;i++){
					var checkedRowdata = checkedRowDatas1[i];
					var id = checkedRowdata.id;
					var paymentid=checkedRowdata.paymentid;
					var checkedRawData=checkedRowDatas1[i];
					/*if("未确认" != checkedRawData.status){
						alert("只能确认未确认的数据");
						return;
					}*/
					tempIdArr1.push(id);
					tempPIdArr1.push(paymentid);
				}
		        params1["ids"] = tempIdArr1.join(",");
		        modifyParams=params1;
		        //console.debug(modifyParams);
				
				if(!window.confirm((operType1+"当前"+checkedRowDatas1.length+"条记录的保险方式么？"))) {
					return;
				}
				var dialog = $('#ebank_modify');
				dialog.show();
				dialog.window({top:10});
				dialog.window('open');
			},
			iconCls : 'icon-update'
			
	}
	  ];
	var all_width = (document.documentElement||document.body).clientWidth-2;
	var all_height = (document.documentElement||document.body).clientHeight-2;
	
	jQuery(function(){
	   	var table = new tracywindyOperationTable({
	   		
	   		 width:all_width,
			 height:all_height,
	   		 tableComment:'保险方式确认',
	   		 constantFlagTable:'FundInvoice',
	   		 windowTop:20,
	   	     border:true,
	         renderTo:'id_tableContainer',
	         title:'保险方式确认',
	         id:'id_table',
	         xmlFileName:'/eleasing/jsp/insure_manage/insurance_way_confirm.xml',
	         loadMode:'ajax',
	         isPage:true,
	         isFit:true,
	         operButtons:'',
	         checkType:'checkbox',
	         isCheck:true,
	 		 isRank:false,
	 		 params:{
	     		enabled:"1",
	     		userid:"${sessionScope['login_userid']}"    
		     },
	 		 tools : tools,
	         columns:[
	            {header:'id',name:'id',hidden:true},
	            {header:'合同号',name:'contractid'},
	            {header:'业务合同号',name:'contractnumber',queryConfig:{}},
	            {header:'客户名称',name:'custname',queryConfig:{}},
	            {header:'经销商',name:'dealername'},
	            {header:'保险方式',name:'insurertype'},
	            {header:'确认人',name:'sureuser'},
	            {header:'确认时间',name:'suredate'},
	            {header:'是否起租',name:'isstart',type:'combobox',
	            	queryConfig:{
		            	isNewLine:false,
		            	colSpan:3, 
		            	loadMode:'local',
		            	datas:[
			            	{title:'未起租',name:'未起租'},
			            	{title:'已起租',name:'已起租'}
		            	],
		            	displayField:'title',
		            	valueField:'name',
		            	defaultValue:1
	            	}
	           	},
	            {header:'状态',name:'status',type:'combobox',
	            	queryConfig:{
		            	isNewLine:false,
		            	colSpan:3, 
		            	loadMode:'local',
		            	datas:[
			            	{title:'未确认',name:'未确认'},
			            	{title:'已确认',name:'已确认'}
		            	],
		            	displayField:'title',
		            	valueField:'name',
		            	defaultValue:1
	            	}
	           	},
	           	{header:'车架号',name:'',renderer:function(value,tableObj,columnName,columnIndex,rowData){
			       	 return "<a href='javascript:void(0);' onclick='showName(\""+rowData.id+"\")'>车架号详情</a>";
		         }}
	           	]
		   });
	   	//选择保险方式
	   	dictOnSelect('id_insurer_type_confirm','framework_condition.insurertype','insurer_type','${empty requestScope["framework_condition.insurertype"] ? "insurer_type.assign" : requestScope["framework_condition.insurertype"] }',null,'require="true" label="付租类型"',null,null,true,'月 付' );
	   	dictOnSelect('id_insurer_type_modify','framework_condition.insurertype','insurer_type','${empty requestScope["framework_condition.insurertype"] ? "insurer_type.assign" : requestScope["framework_condition.insurertype"] }',null,'require="true" label="付租类型"',null,null,true,'月 付' );
	  });
	function showName(vouchernumber){
 		var URL = "${pageContext.request.contextPath}/acl/addInsuranceConfirm.acl";
    	var params = {vouchernumber:vouchernumber,read_only:false};
	    openFullScreenWindow(URL,params);
 	   //window.open("${pageContext.request.contextPath}/leasing/addInsuranceInfo.action","_blank");
 	}

 	
	
	function confirmData() {
		paramsnew["insurerType"]=getTracywindyObject("id_combo_id_insurer_type_confirm").getValue();
		var operAction = "updateInsuranceConfirm";
		var currentLoadMask = null;
		var loadMaskMsg="正在确认保险方式"+"    请稍后... ";
		var url=getRootPath()+"/acl/"+operAction+".acl";
		currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
		currentLoadMask.show();
		
		ajaxRequest({
            url:url,
            params:paramsnew,
            timeout:30*1000,
            success:function(res){
            	
    	   		res=res.responseText;
    	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
	     	    if(res == ''){
	     	    	alert("确认保险方式成功！！");
	     	    }
                currentLoadMask.hide();
                jQuery("#ebank_confirm").window("close");
                getTracywindyObject("id_table").reload();
            }
        });

        
	}

	function modifyData() {
		modifyParams["insurerType"]=getTracywindyObject("id_combo_id_insurer_type_modify").getValue();
		var operAction = "updateModifyInsurance";
		var currentLoadMask = null;
		var loadMaskMsg="正在修改保险方式"+"    请稍后... ";
		var url=getRootPath()+"/acl/"+operAction+".acl";
		currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);

		currentLoadMask.show();
		
		ajaxRequest({
            url:url,
            params:modifyParams,
            timeout:30*1000,
            success:function(res){
            	console.debug(res);
    	   		res=res.responseText;
    	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
	     	    if(res == ''){
	     	    	alert("修改保险方式成功！！");
	     	    }
                currentLoadMask.hide();
                jQuery("#ebank_modify").window("close");
                getTracywindyObject("id_table").reload();
            }
        });

        
	}

	
	
	</script>
</head>
<body>
<div id="id_tableContainer"></div>
<!-- 确认表单 -->
<div id="ebank_confirm"	style="width: 400px; display: none; overflow: hidden;" title="选择保险方式">
	
	<table>
		<tr>
			<td class="input_label_desc" align="left">保险方式:</td>
			<td class="td-content">
				<div id="id_insurer_type_confirm"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:right">
				<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='confirmData();'><span>确定</span></a>
				<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#ebank_confirm").window("close");'><span>取消</span></a>
			</td>
		</tr>
	</table>
</div>
<!--修改表单-->
<div id="ebank_modify"	style="width: 400px; display: none; overflow: hidden;" title="选择保险方式">
	
	<table>
		<tr>
			<td class="input_label_desc" align="left">保险方式:</td>
			<td class="td-content">
				<div id="id_insurer_type_modify"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:right">
				<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='modifyData();'><span>确定</span></a>
				<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#ebank_modify").window("close");'><span>取消</span></a>
			</td>
		</tr>
	</table>
</div>

</body>
</html>