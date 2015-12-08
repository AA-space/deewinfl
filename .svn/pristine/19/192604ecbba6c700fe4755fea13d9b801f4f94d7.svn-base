<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保证金抵扣</title>
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
//var proj_id="<%= request.getParameter("id")%>";
var param={};
//if(proj_id!="null" || proj_id==""){param.proj_id=proj_id;}
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	
	var attachmentParams;
	jQuery(function(){
	 var table = new tracywindyOperationTable({
		 tableComment:'[期末保证金抵扣]',
		 constantFlagTable:'ProjInfo',
		 windowTop:20,
	     border:true,
      renderTo:'id_tableContainer',
      title:'期末保证金抵扣',
      width:parseInt("${param.tableWidth}")||pageWidth,
      height:parseInt("${param.tableHeight}")||pageHeight,
      id:'id_table',
      xmlFileName:'\\eleasing\\workflow\\contract\\deduction_list.xml',
      loadMode:'ajax',
      params:{
			//CONTRACT_STATUS_LessThan : 100, CONTRACT_STATUS_GreaterThan : 30,
			//userId:'${sessionScope.loginUser.id}'
			//cust_id : cust_id
			//parentid:'ProductType'
    	  total:'1'
			},
      isPage:true,
      operButtons:' ',
      isFit:false,
      tools:[{
     	 html : '<font color="red">发起</font>',
		 handler : function(table) {
				var projIDValue = table.getCheckedRowDatas();
				if (0 == projIDValue.length) {
					alert("请选择需要启动的流程！");
					return false;
				}
				attachmentParams = "cust_id="+projIDValue[0].custid+"&contract_id=" + projIDValue[0].id ;
				var custdealerid = projIDValue[0].custdealerid;
				var param_ = {};
				if(custdealerid){
					param_.custdealerid = custdealerid;
				}
 				startProcess("期末保证金抵扣-1", attachmentParams);
				 
				 
				 jQuery("#ebank").window("open");
				
				
				//startProcess("收款流程-4",attachmentParams);
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
		            {header:'custid',name:'custid',hidden:true},
		            {header:'客户名称',name:'custname',queryConfig:{}},
		            {header:'经销商名称',name:'custdealer',width:200},
		            {header:'合同号',name:'contractnumber',queryConfig:{}},
		            {header:'项目名称',name:'projname',width:300,queryConfig:{}},
		            {header:'剩余租金',name:'syrent'},
		            {header:'剩余的保证金',name:'sycaution'},//保证金  - 抵扣保证金
		            {header:'保证金',name:'caution'},
		            {header:'还租日期',name:'incomeday',type:'date'}
					/*
		            {header:'项目类型',name:'projtype'},
		            {header:'项目来源',name:'projsource'},
		            //{header:'项目规模',name:'projscale'},
		            {header:'资产分类',name:'industrytype'},
		            {header:'租赁形式',name:'leasform'},
		            {header:'业务模式',name:'businessmode'},
		            {header:'客户经理',name:'projmanage'},
		            {header:'应收租金',name:'receivablerent'}
		            */
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
				name : '可抵扣合同',value : '1'
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
	jQuery(function(){

	   });
 </script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
	    <div id="xproject" style="display: none;overflow:hidden;" title="选择项目">
	    	<div id="xproject"></div>
    </div>
	<script type='text/javascript'>
	    var ebankDom =document.getElementById("xproject");
	    ebankDom.style.height= ((parseInt("${param.tableHeight}")||pageHeight) - 100)+"px";
	</script>
</body>
</html>