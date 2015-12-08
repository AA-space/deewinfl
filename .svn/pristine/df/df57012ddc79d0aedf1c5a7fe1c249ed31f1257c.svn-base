<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息管理  - 银行账号信息</title>
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
var operButtons='';
</script >
<permission:action  code="cust_add_update">
<script type="text/javascript">
operButtons='新增|修改|删除';
</script >
</permission:action>
<permission:action  code="admin_action">
<script type="text/javascript">
operButtons='新增|修改|删除';
</script >
</permission:action>
<script type="text/javascript">
    if("false"=='${param.readOnly}')
    {
	   operButtons="";
    }
    var constantFlagTable = "User";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	var cust_id="<%= request.getParameter("cust_id")%>";
    var param={};
    if(cust_id!="null" || cust_id==""){param.CUST_ID=cust_id;}
	jQuery(function(){
   	 var table = new tracywindyOperationTable({

   		resetFormCallback:function(table,$form,operFlag){
   		 if("add" == operFlag){
   			var rowData = table.getRowDataAt(0);
   			jQuery("#creator").val('${sessionScope.loginUser.realname}');
   			jQuery("#creator").val('${sessionScope.loginUser.realname}');
   			initCustInfoName(cust_id);
   		    var select_contract = getTracywindyObject("id_combo_id_is_mainPersonFlags");
 	        select_contract.setValue("");
   	       }
     	 },
   		 loadFormDataCallBack:function(table,$form,rowIndex){
   		    var rowData = table.getRowDataAt(rowIndex);
   	        var select_contract = getTracywindyObject("id_combo_id_is_mainPersonFlags");
   	        select_contract.setValue(rowData["ismain"]);
  	   	    jQuery("#creatorname").val('${sessionScope.loginUser.realname}');
        },
   		 tableComment:'[银行账号]',
   		 constantFlagTable:'CustAccount',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'银行账号',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/cust_account/cust_account_info.xml',
         params:param,
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         operButtons:operButtons,
         columns:[
					{header:'客户名称',name:'custname'},
		            {header:'是否主账号',name:'ismainname'},
		            {header:'是否主账号',name:'ismain',hidden:true},
		            {header:'账户名称',name:'account'},
		            {header:'开户银行',name:'bankname'},
		            {header:'银行账号',name:'accnumber'}
		            //,{header:'登记人',name:'creatorname'}
		           
	        ]
   	 });
   // 	commonSelectOverall('id_select_contract_id',"(select ci.contract_id,ci.id||'/'||cust.cust_name value from contract_info ci left join cust_info cust on (ci.cust_id=cust.id)) rs",'value',"contract_id",'contractid','','','',selectContract,false);
  //   	dictYesOrNoByCode('id_select_is_insured','isinsured',1,'','','require="true" label="是否投保"');
   });

</script>

 <script type="text/javascript">
     jQuery(function(){
     	dictYesOrNoByCode('id_is_mainPersonFlags','ismain',1,'','','require="true" label="是否主账户"'); //是否是主账户
      });
     </script>
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="银行账户" style="display:none;height:350px;width:800px;padding-top:20px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:95%" class="fillTable">
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">客户名称:  </td>  
			            	<td class="td-content" colspan="3" >
			                    <input name="custid" id="id_custid" type="hidden" />
			            		<input name="custname" id="id_custname" style="width:84%"  maxlength="255"  require="true" label="客户名称" class="td-content-input td-content-readonly"  readonly="readonly" type="text" /><font class="required-content">*</font></td>
			               </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">帐户名称:  </td>  
			            	<td class="td-content">
			            		<input name="account" class="td-content-input" require="true" label="帐户名称"  maxlength="1508"  maxB="150" type="text" /><font class="required-content">*</font>
			            	</td>
			            	<td class="td-content-title">是否主账户:  </td>  
			            	<td class="td-content">
			            	 <div id="id_is_mainPersonFlags" class="leftComboContainer" style="float:left"></div><font class="required-content">*</font></td>
			            </tr>
			            
			            <tr  class="tr-odd">
			            	<td class="td-content-title">开户银行:  </td>  
			            	<td class="td-content" >
			            		<input name=bankname class="td-content-input" require="true"  maxlength="50"  label="开户银行"  maxB="50"   type="text" /><font class="required-content">*</font>
			            	</td>
			            	<td class="td-content-title">银行帐号:  </td>  
			            	<td class="td-content" >
			            		<input name="accnumber"  class="td-content-input" require="true"  maxlength="30"  label="银行帐号"   maxB="30"  type="text" /><font class="required-content">*</font>
			            	</td>
			            	
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">帐户使用情况:  </td>  
			            	<td class="td-content" colspan="3">
			            		 <textarea name="accInfo"  require="true"  class="td-content-input" style="width:84%"  label="帐户使用情况" maxB="255"   type="text" ></textarea><font class="required-content">*</font>
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">登记人 :  </td>  
			            	<td class="td-content">
			            		<input name="creatorname" id="creator" label="登记人 " class="td-content-input td-content-readonly"  readonly="readonly" type="text" />
			            	</td>
			            	<td class="td-content-title">登记时间</td>  
			            	<td class="td-content">
			            		<input name="createdate" id="createdate" isDefaultDate="true" label="登记时间 "   class="td-content-input td-content-readonly"  readonly="readonly" type="text" />
			            	</td>
			            </tr>
			            	<tr class="tr-even">
			            	<td class="td-content-title">修改人 :  </td>  
			            	<td class="td-content">
			            		<input name="modificatorname" id="modificator" label="修改人 " class="td-content-input td-content-readonly" readonly="readonly" type="text" />
			            	</td> 
			            	<td class="td-content-title">修改时间</td>  
			            	<td class="td-content">
			            		<input name="modifydate" id="modifydate" label="修改时间" class="td-content-input td-content-readonly"  readonly="readonly" type="text" />
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
</body>
<script language="javascript">
function initCustInfoName(cust_id){
 
window.currentLoadMask = new tracywindyLoadMask(document.body,"正在初始化 请稍等..."); 
currentLoadMask.show();
        var param={};
        param.custID=cust_id;
        param.xmlFileName='\\eleasing\\workflow\\public\\SimpleCustInfoSelect.xml';
    	ajaxRequest({
		     url:'${pageContext.request.contextPath}/table/getTableData.action',
		     method:'POST',
		     success:function(res){
	   		    var scustinfo=res.responseText;
	   		    scustinfo=scustinfo.replace(/(^\s+)|(\s+$)/g, ""); 
	   		    var cust=eval("("+scustinfo+")");
	   		    var currentRowData=cust.datas[0];
	   		    $("#id_custname").val(currentRowData.name);
	   		    $("#id_custid").val(cust_id);
	   		   currentLoadMask.hide();
		     },
		     async:false,
		     failure:function(res){
		    	 currentLoadMask.hide();
			     },
		     params:param
	 });
    }
</script>
</html>
