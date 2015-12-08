<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息管理  - 走访调研信息</title>
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
<%-- <permission:action  code="cust_add_update">
<script type="text/javascript">
operButtons='新增|修改|删除';
</script > 
</permission:action>--%>
<permission:action  code="cust_info_contact_add_up_del">
<script type="text/javascript">
operButtons='新增|修改|删除';
</script >
</permission:action>
<permission:action  code="dealer_contract_add_up_del">
<script type="text/javascript">
operButtons='新增|修改|删除';
</script >
</permission:action>
<permission:action  code="admin_action">
<script type="text/javascript">
operButtons='新增|修改|删除|状态';
</script >
</permission:action>
<script type="text/javascript">
var cust_id="<%= request.getParameter("cust_id")%>";
    var param={};
    if("false"=='${param.readOnly}')
    {
	   operButtons="";
    }
    if(cust_id!="null" || cust_id==""){param.CUST_ID=cust_id;}
    var constantFlagTable = "User";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		resetFormCallback:function(table,$form,operFlag){
   		 if("add" == operFlag){
   			var rowData = table.getRowDataAt(1);
   			jQuery("#creatorname").val('${sessionScope.loginUser.realname}');
   			initCustInfoName(cust_id);
   			var select_contract = getTracywindyObject("id_combo_id_is_contactType");
	   	     select_contract.setValue('');
   	     }
     	 },
		 
   		 loadFormDataCallBack:function(table,$form,rowIndex){
	   		 var rowData = table.getRowDataAt(rowIndex);
	   	     var select_contract = getTracywindyObject("id_combo_id_is_contactType");
	   	     select_contract.setValue(rowData["contacttype"]);
	   
	   	    
	 },
   		 tableComment:'[走访调研]',
   		 constantFlagTable:'CustInfoContact',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'走访调研',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/cust_info_contact/cust_info_contact.xml',
         params:param,
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         operButtons:operButtons,
         columns:[
		           
                    {header:'客户名称',name:'custname'},
		            {header:'记录类型',name:'contacttype' ,hidden:true},		      
		            {header:'记录类型',name:'contacttypename'},
		            {header:'访谈时间',name:'contactdate',datatype:'date'},
		            {header:'联系人',name:'contactperson'},
		            {header:'联系电话',name:'contactphone'},
		            {header:'联系地点',name:'contactadd'},
		            {header:'访谈内容',name:'ccmemo'}
		            //,{header:'登记人',name:'creatorname'}
		           
		          
	        ]
   	 });
   // 	commonSelectOverall('id_select_contract_id',"(select ci.contract_id,ci.id||'/'||cust.cust_name value from contract_info ci left join cust_info cust on (ci.cust_id=cust.id)) rs",'value',"contract_id",'contractid','','','',selectContract,false);
  //   	dictYesOrNoByCode('id_select_is_insured','isinsured',1,'','','require="true" label="是否投保"');
   });

</script>

  <script type="text/javascript">
     jQuery(function(){
        
        dictOnSelect('id_is_contactType','contacttype','contact_type',null,null,false,true,165); //记录类型
      });
     </script>
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="走访调研" style="display:none;width:700px;height:330px">
	        <center>
		         <form id="id_detailInfoForm">
			        <table style="width:95%" class="fillTable">
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
			            <tr  class="tr-even">
			            	
			            	<td class="td-content-title">客户名称:  </td>  
			            	<td class="td-content" >
			            	  <input name="custId" id="id_custid" type="hidden" />
			            		<input name="custname" id="id_custname"   maxlength="255"  require="true" readonly="readonly" label="客户名称" class="td-content-input td-content-readonly" type="text" /><font class="required-content">*</font></td>
			           
			            	<td class="td-content-title">记录类型</td>  
			            	<td class="td-content">
			            		 <div id="id_is_contactType" class="leftComboContainer" style="float:left"></div><font class="required-content">*</font></td>
      				  	
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">走访时间:  </td>  
			            	<td class="td-content">
			            		<input class="Wdate td-content-input" readonly name="contactDate" class="td-content-input"  type="text"  onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="走访时间"><font class="required-content">*</font>
			         	  	</td>
			            	<td class="td-content-title">联系人:  </td>  
			            	<td class="td-content">
			            	 <input name="contactPerson" id="contactPerson" class="td-content-input" require="true" label="联系人"  maxB="50"   maxlength="50"   type="text" /><font class="required-content">*</font>
			            	 </td>
			            </tr>
			            
			            <tr  class="tr-even">
			            	<td class="td-content-title">联系人电话:  </td>  
			            	<td class="td-content" >
			            		<input name="contactPhone" require="true"  label="联系人电话" class="td-content-input"   maxB="100"    type="text" /><font class="required-content">*</font>
			            	</td>
			            	<td class="td-content-title">联系地点:  </td>  
			            	<td class="td-content" >
			            		<input name="contactAdd" require="true" label="联系地点"  class="td-content-input"  maxlength="255"  maxB="255"  type="text" /><font class="required-content">*</font>
			            	</td>
			            	
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">调研内容:  </td>  
			            	<td class="td-content" colspan="3">
			            	<textarea name="CCMEMO" require="true" maxB="255"  maxlength="255"  class="td-content-input"  style="width:86%;height:200" label="调研内容"   type="text" ></textarea><font class="required-content">*</font>
			            	</td>
			            </tr>
			        
			            	<tr  class="tr-even">
			            	<td class="td-content-title">登记人 :  </td>  
			            	<td class="td-content">
			            		<input name="creatorname" id="creatorname" label="登记人 " class=" td-content-input td-content-readonly" readonly="readonly" type="text" />
			            	</td>
			            	<td class="td-content-title">登记时间</td>  
			            	<td class="td-content">
			            		<input name="createdate" id="createdate" isDefaultDate="true" label="登记时间 "   class=" td-content-input td-content-readonly"  readonly="readonly" type="text" />
			            	</td>
			            </tr>
			            	<tr  class="tr-odd">
			            	<td class="td-content-title">修改人 :  </td>  
			            	<td class="td-content">
			            		<input name="modificatorname" id="modificator" label="修改人 " class=" td-content-input td-content-readonly" readonly="readonly" type="text" />
			            	</td>
			            	<td class="td-content-title">修改时间</td>  
			            	<td class="td-content">
			            		<input name="modifydate" id="modifydate" label="修改时间" class=" td-content-input td-content-readonly"  readonly="readonly" type="text" />
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