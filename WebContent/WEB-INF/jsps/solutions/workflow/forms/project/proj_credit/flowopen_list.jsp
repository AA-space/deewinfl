<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<%@ taglib prefix='c'   uri='/WEB-INF/tlds/c.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目信审清单</title>
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
<permission:action  code="law_cust_for_credit">
<c:set var="custClass" value="CUST_INFO_COMPANY"/>
</permission:action>
<permission:action  code="person_cust_for_credit">
<c:set var="custClass" value="CUST_INFO_PERSON"/>
</permission:action>
<script type="text/javascript"> 
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		 tableComment:'[项目信审清单]',
   		 constantFlagTable:'ProjInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'项目信审清单',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'\\eleasing\\workflow\\proj_change\\proj_change_info_list.xml',
         loadMode:'ajax',
         params:{
   			 custClass:'${custClass}',
         	 PROJ_STATUS_LessThan : 10,
 			 PROJ_STATUS_GreaterThan : 0,
 		     WORK_FLAG : 0,
 			 cust_dealer_id:"${sessionScope['currentDealerCustInfoId']}"
          },
         isPage:true,
         isAutoBreakContent:true,
         operButtons:' ',
         isFit:false,
         tools:[{
        	 html : '<font color="red">项目信审</font>',
 			handler : function(table) {
 				var projIDValue = table.getCheckedRowDatas();
 				if (0 == projIDValue.length) {
 					alert("请选择需要启动的流程！");
 					return false;
 				}
			    if(projIDValue[0]["typecode"]=="bussiness_type_equip"){
					var attachmentParams = "proj_id=" + projIDValue[0]["id"];
					 startProcess("项目信审流程(设备)-1", attachmentParams);   
				}else if(projIDValue[0]["typecode"]=="bussiness_type_car"){
					var attachmentParams = "proj_id=" + projIDValue[0]["id"];
 				    startProcess("项目信审流程-1",attachmentParams);
				}else{
					var attachmentParams = "proj_id=" + projIDValue[0]["id"];
 				    startProcess("项目信审流程-1",attachmentParams);
				}
			    table.reload();
 			},
 			iconCls :'icon-update'
             }],
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'code1',name:'typecode',hidden:true},
		            {header:'code2',name:'modecode',hidden:true},
		            {header:'custid',name:'custid',hidden:true},
		            {header:'项目号',name:'proj_id',queryConfig:{}},
		            {header:'项目名称',name:'projname',width:300,queryConfig:{}},
		            {header:'项目状态',name:'statusname'},
		            {header:'客户名',name:'custname'},
		            {header:'经销商',name:'custdealer',queryConfig:{}},
		            {header:'租赁形式',name:'leasform'},
		            {header:'立项结束时间',name:'enddate'},
		            {header:'客户性质',name:'custclass'},
		            {header:'身份证/组织机构代码',name:'orgcodecardno',width:250}, 
		            {header:'纳税人类别',name:'taxlevel'},
		            {header:'项目经理',name:'projmanage'}, 
		            {header:'项目助理',name:'projassist'},
		            {header:'项目出单部门',name:'projdept',width:250},
		            {header:'设备款',name:'equipamt'}
         ]
   	 });
   });
function showCustName(value,tableObj,columnName,columnIndex,rowData){
    var base = "<a href='javascript:void(0);' onclick='showLawCustInfo(\""+rowData.custid+"\")'>{1}</a>{2}";
    var separator = "&nbsp;&nbsp;";
    var updateFlag=value;
    var updateClickFunc="other";
    var field=base.replace("{1}",updateFlag).replace("{2}",separator);
    return field;
}
function showLawCustInfo(cust_id){
   	var URL = "${pageContext.request.contextPath}/leasing/cust_info/cust_info.bi";
   	var params = {cust_id:cust_id};
    openFullScreenWindow(URL,params);
}	
</script>
 
</head>
<body>
    <div id="id_tableContainer"></div>
	
</body>
</html>