<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同结束管理-合同结束</title>
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
<script type="text/javascript"><!-- 
 //var proj_id="<%= request.getParameter("id")%>";
   var param={};
   //if(proj_id!="null" || proj_id==""){param.proj_id=proj_id;}
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
		
   	 var table = new tracywindyOperationTable({
   		 tableComment:'[合同结束]',
   		 constantFlagTable:'ProjInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'合同结束',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'\\eleasing\\workflow\\contract\\contractFinish_flowopen_list.xml',
         loadMode:'ajax',
         params:{
   			//custdealer:''
        	 total:'1'
    			
	     },
         isPage:true,
         operButtons:' ',
         isFit:false,
         tools:[{
        	 html : '<font color="red">合同结束</font>',
 			handler : function(table) {
 				var projIDValue = table.getCheckedRowDatas();
 				if (0 == projIDValue.length) {
 					alert("请选择需要启动的流程！");
 					return false;
 				}
 				var loadMask_oper = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');
 				var params ={};
 				params.contract_id=projIDValue[0]["id"];
 				loadMask_oper.show();
 	 		       ajaxRequest({
 					     url:'${pageContext.request.contextPath}/leasing/checkFinish.action',
 					     method:'POST',
 					     success:function(res){
 						     var data = res.responseText;
 						     if ( data == "no")
					    	 {
								 var attachmentParams = "contract_id=" + projIDValue[0]["id"]+"&cust_id="+projIDValue[0]["custid"];
				 				startProcess("合同结束流程-1",attachmentParams); 
					    	 }
 						     else
					    	 {
 						    	alert("合同已经结束!");
					    	 	return false;
					    	 }
 					     },
 						 params:params,
 					     failure:function(res){},
 					     async:false,
 					     timeout:30*1000
 				    });
 	 		      loadMask_oper.hide();
 	 		      table.reload();
 			},
 			iconCls :'icon-update'
             },
             {
 				isHtml : true,
 				html : '选择显示合同信息：'
 		     }
 		     ,{
 				isHtml : true,
 				html : '<div id="id_flow_name" style="float:left;"></div>'
 			 } 
             ],
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'proj_id',name:'proj_id',hidden:true},
		            {header:'pid',name:'pid',hidden:true},
		            {header:'custid',name:'custid',hidden:true},
		            {header:'业务类别',name:'businesstype',hidden:true},
		            {header:'客户名称',name:'custname',queryConfig:{}},
		            {header:'经销商名称',name:'custdealer',width:200,queryConfig:{}},
		           // {header:'合同编号',name:'contractid',queryConfig:{}},
		            {header:'业务合同号',name:'contractnumber',queryConfig:{isNewLine:true}},
		            {header:'项目名称',name:'projname',width:300,queryConfig:{}},
					/*
		            {header:'项目类型',name:'projtype',type:'combobox',
			            queryConfig:{
						colSpan:3,
						loadMode:'local',
						datas:[{title:'关联',name:'关联'},{title:'非关联',name:'非关联'}],
			            displayField:'title',
			            valueField:'name',
			            defaultValue:1
			        }},
			        */
		            //{header:'项目来源',name:'projsource'},
		            //{header:'项目规模',name:'projscale'},
		            //{header:'资产分类',name:'industrytype'},
		            {header:'租赁形式',name:'leasform'},
		            {header:'业务模式',name:'businessmode'},
		            {header:'客户经理',name:'projmanage'}
         ]
   	 });
   
	 var combo_type = new tracywindyComboBox({
			id : 'id_combo_flow_name',
			width : 200,
			renderTo : 'id_flow_name',
			loadMode : 'local',
			readOnly : false,
			isAjaxLenovo : true,
			isContainEmpty : false,
			dropListHeight : 300,
			topAdd : 0,
			leftAdd : 0,
			positionDropIconLeftAdd : -1,
			value:'1',
			name : 'flow_name',
			displayField : 'name',
			valueField : 'value',
			datas : [{
				name : '结束合同',value : '1'
			    }
		       ,{
				name : '全部合同',value : ''
			}],
			onSelect : function(combo) 
			{
				var table = getTracywindyObject('id_table');
				if(combo.getValue()=='1'){
					table.setParams({total: combo.getValue()});
		            table.reload();
				}else{
					table.setParams({total:''});
		            table.reload();
				}
				
			}
		});
	 
	});
</script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>