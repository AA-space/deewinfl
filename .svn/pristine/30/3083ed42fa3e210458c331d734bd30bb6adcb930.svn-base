<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>跟换经销商转移客户操作</title>
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
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
//流程历史信息
var dealer_id='${empty dealerid ? "" : dealerid }';
  	//console.info(dealer_id);
  	var dealer_name='${empty dealername ? "" : dealername }';
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
		var mynotice = new tracywindyOperationTable({
	   		 tableComment:'[跟换经销商转移客户操作]',
	   	     border:true,
	   	     title:'跟换经销商转移客户操作',
	         operButtons:'',
	         renderTo:'id_mynotice_list',
	         width:pageWidth,
	         height:pageHeight,
	         id:'id_table_mynotice_list',
	         xmlFileName:'/eleasing/jsp/base/dealer_user_relay.xml',
	         loadMode:'ajax',
	         isPage:true,
	         isFit:true,
	         isExcel:true,
	         isAutoBreakContent:true,
	         tools:[{
	        	    iconCls:'icon-ok',
	        	    html:'<font color="red">跟换经销商转移客户</font>',
	        	    handler:function(table)
	        	    { 
	        	    	jQuery("#id_message_list").show();
	        	    	jQuery("#id_message_list").window({
	        	    		top:10
	        	    	});
	        	    	jQuery("#id_message_list").window("open");
	        	    }
	         }],
	         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'经销商名称',name:'dealername',queryConfig:{}},
		            {header:'经销商编号',name:'custnumber'}
	        ],
	        params:{
			     //USER_ID:'${sessionScope.loginUser.id}'
			}
	   	 });
   });
	
</script>

</head>
<body>
	<div id="id_mynotice_list"></div>
	<div id="id_message_list" style="width: 420px; display: none; overflow: hidden;" title="选择要操作的经销商">
		<table class="fillTable">
			<tr class="tr-even">
			<td class="td-content-title">到：</td>
			<td class="td-content"><div class="leftComboContainer" id="id_dealer"></div><font class="required-content">*</font></td>
			</tr>
			
			<tr class="tr-odd">
				<td colspan="4" style="text-align:center">
					<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='confirmData();'><span>确定</span></a>
					<a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_message_list").window("close");'><span>取消</span></a>
				</td>
			</tr>
	 </table>
	</div>
	<script type="text/javascript">
	
	function confirmData()
	{
		//获取原来的经销商id
		var dealerdata = getTracywindyObject("id_table_mynotice_list").getCheckedRowDatas();
		//alert(dealerdata[0].dealername+dealerdata[0].id);
		//现在的经销商id
		var dealer_id= $("#selectOfValue_id_combo_dealer").val();
		var dealer_name= $("#selectOfRawValue_id_combo_dealer").val();
		//alert(dealer_id);
		var cof =window.confirm("您确定要改【"+dealerdata[0].dealername+"】客户到【"+dealer_name+"】?");
		var param ={};
        param.dealer_id = dealer_id;
        param.olddealer_id = dealerdata[0].id;
        if(cof)
        {
	        $.ajax({
				type : "post",
				url : getRootPath()+"/leasing/checkDealerInfo.action",
				cache : false,
				async : false,
				data : param,
				success : function(rs) 
				{
				   var svote=rs;
				   svote=svote.replace(/(^\s+)|(\s+$)/g, ""); 
					if (svote!="") 
					{
						if ( rs == "yes" )
						{
						   alert("操作成功!");
						   jQuery("#id_message_list").window("close");
			               getTracywindyObject("id_table_mynotice_list").reload();
						}else
						{
							alert("操作失败!");
						}
					}
				}
			});
        }
	}
	 $(function(){
		 var dealer=  new tracywindyComboBox({
		   	    id:'id_combo_dealer',
		   	    width:162,
		   	    renderTo:'id_dealer',
		   	    xmlFileName:'\\eleasing\\workflow\\public\\comboDealerName.xml',
		   	    loadMode:'ajax',
		   	    readOnly:false,
		   	    isAjaxLenovo:true,
		   	    isContainEmpty:true,
		   	    dropListHeight:300,
		   	    topAdd:0,
		   	    leftAdd:0,
		   	    positionDropIconLeftAdd:-1,
		   	    name:'dealer_name',
		   	    displayField:'name',
		   	    valueField:'value',
		   	 	value:dealer_id,
		   		rawValue:dealer_name,
		   	    params:{
		   	    	//user_id :'${sessionScope.loginUser.id}'
		   	    }
		   	 });
		 
	 });
	</script>
</body>
</html>