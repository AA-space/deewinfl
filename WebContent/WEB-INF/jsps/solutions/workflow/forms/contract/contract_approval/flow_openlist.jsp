<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同管理-合同审批</title>
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
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		 tableComment:'[项目信息]',
   		 constantFlagTable:'ProjInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'项目信息',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'\\eleasing\\workflow\\contract\\contract_flowlist.xml',
         loadMode:'ajax',
         params:{
		  user_id:'${sessionScope.loginUser.id}',
		  //增加显示 已合同审批的过滤掉（判断项目和合同金额）
		  cApproval:"1"
	     },
         isPage:true,
         operButtons:' ',
         isFit:false,
         isAutoBreakContent:true,
         tools:[{
        	 html : '<font color="red">合同审批</font>',
 			 handler : function(table) {
 				var projIDValue = table.getCheckedRowDatas();
 				if (0 == projIDValue.length) {
 					alert("请选择需要启动的流程！");
 					return false;
 				}
 				var conditions = {};
 		    	conditions.projID = projIDValue[0]["pid"];//项目id,必填
 		    	//ajax成功提交window
	 		   	var sheight = window.screen.availHeight-30;
	 		    var swidth = window.screen.availWidth-10;
 		    	var winoption ="left=0px,top=0px,height="+sheight+"px,width="+swidth+"px,toolbar=yes,menubar=yes,location=yes,status=yes,scrollbars=yes,resizable=yes";
 		    	//var winRef = window.open("", "_blank",winoption);//打开一个新的页面
				/*$.post('${pageContext.request.contextPath}/leasing/checkContractStart.action', conditions, function(data) {
						if (data['result'] == 'error') {
							try{
								winRef.opener = null;
								winRef.close();
							}catch(e){}
							alert("您所选择的项目设备金额为【"+data['projEquipAmt']+"】,已经发起【"+ data['number']+"】条合同,总共金额为【" + data['contractEquipAmt'] + "】。\n此条项目不能发起流程,请检查。");
						} else {
							var attachmentParams = "proj_id=" + projIDValue[0]["pid"]+"&cust_id="+projIDValue[0]["custid"];
							startProcess("合同审批流程-1",attachmentParams,winRef);
						}
					});*/
			var loadMask_oper = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');
			loadMask_oper.show();
 		       ajaxRequest({
				     url:'${pageContext.request.contextPath}/leasing/checkContractStart.action',
				     method:'POST',
				     success:function(res){
					     var data = res.responseText;
					     data = eval("("+data+")");
					     if (data['result'] == 'error') {
								alert("您所选择的项目设备金额为【"+data['projEquipAmt']+"】,已经发起【"+ data['number']+"】条合同,总共金额为【" + data['contractEquipAmt'] + "】。\n此条项目不能发起流程,请检查。");
							} else {
								var attachmentParams = "proj_id=" + projIDValue[0]["pid"]+"&cust_id="+projIDValue[0]["custid"];
								startProcess("合同审批流程-1",attachmentParams);
							}
				     },
					 params:conditions,
				     failure:function(res){},
				     async:false,
				     timeout:30*1000
			    });
 		      loadMask_oper.hide();
 		     table.reload();
				},
				iconCls : 'icon-update'
			} ],
			columns : [ {
				header : 'id',
				name : 'id',
				hidden : true
			}, {
				header : 'pid',
				name : 'pid',
				hidden : true
			}, {
				header : 'projstatus',
				name : 'projstatusnum',
				hidden : true
			}, {
				header : 'custid',
				name : 'custid',
				hidden : true
			},{
				header : '项目编号',
				name : 'projid',
				queryConfig : {}
			}, {
				header : '项目名称',
				name : 'projname',
				width : 350,
				queryConfig : {
				}
			}, {
				header : '租赁形式',
				name : 'leasform',
				queryConfig : {
					isNewLine : true
				}
			},{
				header : '项目状态',
				name : 'projstatus'
			},{
				header : '客户名称',
				name : 'custname',
				width : 150,
				queryConfig : {}
			}, {
				header : '经销商名称',
				name : 'custdealer',
				queryConfig : {}
			},{
				header : '业务类型',
				name : 'businesstype'
			},{
				header : '业务模式',
				name : 'businessmode'
			},{
				header : '客户性质',
				name : 'custproperty'
			}, {
				header : '身份证/组织机构代码',
				width : 120,
				name : 'orgcodecardno'
			}, {
				header : '纳税人类别',
				name : 'taxpayertype'
			},{
				header : '项目经理',
				width : 120,
				name : 'projmanage'
			}, {
				header : '项目助理',
				width : 120,
				name : 'projassistant'
			}, {
				header : '项目出单部门',
				name : 'projdept'
			}, {
				header : '项目金额',
				name : 'projmoney'
			}, {
				header : '已有合同金额',
				name : 'contractmoney'
			}  ]
		});
	});
</script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
</body>
</html>