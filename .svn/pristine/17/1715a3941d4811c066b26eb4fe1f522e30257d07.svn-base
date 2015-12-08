<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统管理 - 上报</title>
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
	   html,body{overflow:hidden; }
	</style>
</head>
<body>
<%---Table展示 --%>
<div id="id_tableContainer"></div>
<%---上报的增加内容 --%>
<div id="id_detailInfoWindowContainer" title="上报" style="display: none; width: 800px; height: 280px;">
<center>
<form id="id_detailInfoForm">
<table style="width: 90%;border: 1px #DDD solid;" class="fillTable">
		<tr>
			<td>
				<input name="id" type="hidden" value=""/>
				<input type="hidden" name="readstatus" id="readstatus" value=""/>
				<input type="hidden" name="fromuser" id="fromuser" value=""/>
				<input type="hidden" name="msgtype" id="msgtype" value=""/>
           	</td>
           	<td></td><td></td><td></td>
		</tr>
		<tr class="tr-even">
			<td class="td-content-title">主题:</td>
				<td class="td-content" colspan="3">
           		<input type="text" name="msgtitle" class="td-content-input" require="true" label="主题"  maxB="80" style="width:400px;"/><font class="required-content">*</font>
           	</td>
		</tr>
		<tr class="tr-odd">
			<td class="td-content-title" align="left">正文内容:</td>
			<td class="td-content" colspan="3">
           		<textarea name="msgtext" style="width:93%;" label="正文内容" maxB="1200" class="td-content-input" require="true"  type="text" ></textarea><font class="required-content">*</font>
           	</td>
		</tr>
		<tr class="tr-even">
			<td class="td-content-title" align="left">接收人:</td>
			<td class="td-content">
           		<div id="id_message_touser" class="leftComboContainer" style="float:left;"></div><font class="required-content">*</font>
           	</td>		
           	<td class="td-content-title"></td>  
	        <td class="td-content"></td>
		</tr>
		<tr class="tr-odd">
			<td class="td-content-title" align="left">上报人:  </td>  
           	<td class="td-content">
           		<input name="fromusername" id="fromusername" label="登记人 " class="td-content-readonly" readonly="readonly" type="text" style="float:left;width:198px; height: 18px;"/><font class="required-content">*</font>
           	</td>
           	<td class="td-content-title" align="left">上报时间:  </td>  
           	<td class="td-content">
           		<input name="senddate" id="senddate"  label="上报时间"  class="Wdate td-content-input td-content-readonly"  onClick="WdatePicker(this,{readOnly:true})" require="true"   type="text" /><font class="required-content">*</font>
           	</td>
	    </tr>
		<tr class="content-separator">
			<td colspan='4'>
				<a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a>
				<a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
			</td>
		</tr>
		
</table>
</form>
</center>
</div>
<script type="text/javascript">
	var constantFlagTable = "User";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
	    var table = new tracywindyOperationTable({
	   		resetFormCallback:function(table,$form,operFlag){
				if("add" == operFlag){
					jQuery("#readstatus").val('1');
				    jQuery("#msgtype").val('msgtype.1');
				    jQuery("#fromuser").val('${sessionScope.loginUser.id}');
				    jQuery("#fromusername").val('${sessionScope.loginUser.realname}');
				}   	  		
	     	},
	    	loadFormDataCallBack:function(table,$form,rowIndex){
	     		jQuery("#readstatus").val('1');
	     		jQuery("#msgtype").val('msgtype.1');
			    jQuery("#fromuser").val('${sessionScope.loginUser.id}');
			    jQuery("#fromusername").val('${sessionScope.loginUser.realname}');
	 			var rowData = table.getRowDataAt(rowIndex);
	 			var rowDataValue = rowData['userid'];
	 			var currentCombo = getTracywindyObject("id_combo_message_touser");
	 			currentCombo.setValue(rowDataValue);
			    currentCombo.reload();
	 		},
	   		 tableComment:'[上报]',
	   		 constantFlagTable:'MessageAppear',
	   		 windowTop:20,
	   	     border:true,
	         renderTo:'id_tableContainer',
	         title:'上报',
	         width:parseInt("${param.tableWidth}")||pageWidth,
	         height:parseInt("${param.tableHeight}")||pageHeight,
	         id:'id_table',
	         xmlFileName:'/eleasing/jsp/base/messageInfo.xml',
	         loadMode:'ajax',
	         isPage:true,
	         isFit:true,
	         operButtons:'新增|修改',
	         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'userid',name:'userid',hidden:true},
		            {header:'主题',name:'msgtitle',queryConfig:{}},
		            {header:'上报时间',name:'senddate',type:'date',queryConfig:{}},
		            {header:'接收人',name:'realname',queryConfig:{}}
	        ],
	        params:{
 			     MSG_TYPE:'msgtype.1',FROM_USER:'${sessionScope["login_userid"]}'  
			}
	   	 });
	    var combo_toUser = new tracywindyComboBox({//接收人
	    	lazyLoad:true,
	   		id:'id_combo_message_touser',
	   	    width:200,
	   	    renderTo:'id_message_touser',
	   	 	xmlFileName:'/eleasing/jsp/base/t_user_info_no_dealer.xml',
	   	 	loadMode:'ajax',
	   	 	readOnly:false,
	   	 	isAjaxLenovo:true,
	   	 	otherAttributes:'require="true" label="接收人"',
		   	dropListHeight:200,
		   	topAdd:0,
		   	leftAdd:0,
		   	positionDropIconLeftAdd:-1,
		   	name:'readuser',
		   	displayField:'value',
		   	valueField:'name',
		   	leftAdd:0,
		    isCheck:false,
		   	params:{},
		   	onSelect:function(combo){}
		 });
	    /*var combo_user_ = new tracywindyComboBox({//上报人
	   		lazyLoad:true,
	   		id:'id_combo_from_user',
	   	    width:200,
	   	    renderTo:'id_from_user',
	   	 	xmlFileName:'/eleasing/jsp/base/t_user_info.xml',
	   	 	loadMode:'ajax',
	   	 	readOnly:false,
	   	 	isAjaxLenovo:true,
	   	 	otherAttributes:'require="true" label="上报人"',
		   	dropListHeight:200,
		   	topAdd:0,
		   	leftAdd:0,
		   	positionDropIconLeftAdd:-1,
		   	name:'fromUser',
		   	displayField:'realname',
		   	valueField:'id',
		   	params:{
		   		USER_ID:'1'
		   	},
		   	onSelect:function(combo){
		   	}
		 });*/
	});
	/*function checkToUserClick(){
		var objName= document.getElementsByName("checkbox_toUser"); 
		var comboUser = getTracywindyObject("id_combo_toUser");
		comboUser.params={};
		for(i=0; i<objName.length; i++){
			if(objName[i].checked&&objName[i].value=="1"){
				comboUser.setParams({USER_ID:'1'});
			}else if(objName[i].checked&&objName[i].value=="2"){
				comboUser.setParams({GROUPS_ID:'1'});
			}else if(objName[i].checked&&objName[i].value=="3"){
				comboUser.setParams({DEPTS_ID:'1'});
			}else if(objName[i].checked&&objName[i].value=="4"){
				comboUser.setParams({DEPTROLES_ID:'1'});
			}
		} 
		comboUser.reload();
	}*/
</script>
</body>
</html>