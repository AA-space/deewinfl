<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经销商管理 - 经销商登记</title>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/MustFillIn.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/custType.js"></script>
	<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	   td.td-content{
	     text-align:left;
	   }
	   td.td-content input{
	      width:165px;
	      float:left;
	      border:1px solid #DDD;
	   }
	   td.td-content textarea{
	      width:90%;
	      overflow:auto;
	      float:left;
	      border:1px solid #DDD;
	   }
	</style>
	<script>
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
	
	}
	var isSubTable = true;
	//初始化调用
	jQuery(function() {
		var all_width  =document.documentElement.clientWidth;
		var all_height =  document.documentElement.clientHeight;
		var oldCurrentPageClientWidth = all_width;
		var oldCurrentPageClientHeight = all_height;
		
		var formHeight = 0;
		var formWidth = 0;
			   var containerWidthAdd = 12;
			   var containerHeightAdd = 115;
			   formHeight = all_height-containerHeightAdd-10;
			   formWidth = all_width-containerWidthAdd-15;
		//########公共JS事件##########
		//jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		//$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
		//$("#id_project_info_tabs_content").tabs();
		//jQuery(".fillTableContainer").css("width",formWidth+"px");
		jQuery("#cust_all_info").css("height",all_height+"px");
/* 		$("#id_project_info_tabs_content").tabs();
		//cust_id
		$("iframe[fileLocation]").each(function(){
			var $me = $(this); 
			$me.attr("src","${pageContext.request.contextPath}/"+$me.attr("fileLocation")+"?cust_id=${param.cust_id}&tableWidth="+(formWidth-2)+"&tableHeight=500");
	    }); */
		
	    
	    var read_only = '${param.read_only}';
		//if(read_only == 'false' || read_only == false){
			$('#table_').show();
			$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
			$("#id_project_info_tabs_content").tabs();
			$("iframe[fileLocation]").each(function(){
				var $me = $(this); 
				$me.attr("src","${pageContext.request.contextPath}/"+$me.attr("fileLocation")+"?cust_id=${param.cust_id}&tableWidth="+(formWidth-2)+"&tableHeight=500&readOnly="+read_only);
		    });
		//}
	});
</script>
</head>
<body >
    <div style="background:#F6F6F6;" >
    <div id="cust_all_info" style="height:100%;width:100%;overflow-y:auto;background:#FFFFFF">
			      <table  style="width:100%"  >
			            <tr>
                         <td>
                              <iframe  frameborder=0  style="overflow:auto;border-width:0px;width:100%;height:1200px;display:block;" src="${pageContext.request.contextPath}/leasing/cust_info/cust_dealer/cust_dealer_base.bi?cust_id=<%= request.getParameter("cust_id")%>" ></iframe>
                         </td>
                       </tr>
			            <tr id ='table_' style='display: none;'>
		                <td>
		                <!-- 标签栏 -->
		                 <div id='id_project_info_tabs_content'>
		                   <div title="重要个人">
			                 <div id="id_table_receiverchargeplan_container1" style="overflow: hidden;">
			                    <iframe   frameborder=0 
			                     fileLocation="/leasing/cust_info/comm_page/cust_related_person.bi" 
			                     style="overflow:auto;border-width:0px;width:100%;height:500px;display:block;" >
			                     </iframe>
			                 </div>
		                   </div>
	                       <div title="银行账号">
		                      <div id="id_table_receiverchargehistory_container2" style="overflow: hidden;">
		                        <iframe   frameborder=0 
		                         fileLocation="/leasing/cust_info/comm_page/cust_account.bi" 
		                         style="overflow:auto;border-width:0px;width:100%;height:500px;display:block;" >
		                         </iframe>
		                      </div>
		                   </div>
		                   <div title="走访调研">
		                       <div id="id_table_receivercharge_container4" style="overflow: hidden;">
		                         <iframe   frameborder=0 
		                         id="id_iframe_cust_info_contact" 
		                         style="overflow:auto;border-width:0px;width:100%;height:500px;display:block;" 
		                         fileLocation="/leasing/cust_info/comm_page/cust_contact.bi" >
		                         src="${pageContext.request.contextPath}/leasing/cust_info_contact/cust_info_contact.bi?cust_id=<%= request.getParameter("cust_id")%>" >
		                         </iframe>
		                        </div>
		                   </div>
		                   <!-- <div title="信用等级">
		                      <div id="id_table_leasing_fundebankdata_container3" style="overflow: hidden;">
		                        <iframe 
		                        fileLocation="/leasing/cust_credit_rank/cust_credit_rank.bi" 
		                        style="overflow:auto;border-width:0px;width:100%;height:500px;display:block;" >
		                        </iframe>
		                      </div>
		                   </div>
		                   <div title="关联企业">
		                       <div id="id_table_receivercharge_container5" style="overflow: hidden;">
		                           <iframe 
		                           style="overflow:auto;border-width:0px;width:100%;height:500px;display:block;" 
		                           fileLocation="/leasing/cust_share_company/cust_share_company.bi" >
		                           </iframe>
		                       </div>
		                   </div>
		                   <div title="股本结构">
		                       <div id="id_table_receivercharge_container6" style="overflow: hidden;">
		                            <iframe  
		                            fileLocation="/leasing/cust_stockholder/cust_stockholder.bi"  
		                            style="overflow:auto;border-width:0px;width:100%;height:500px;display:block;"> 
		                            </iframe>
		                        </div>
		                   </div> -->
		                 </div>
		                 </td>
	                    </tr> 
			        </table>
		        </div>
		   <div>  
		   </div>   
		   </div>
</body>


</html>