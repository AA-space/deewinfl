<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息管理  - 客户信用等级信息</title>
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
</permission:action> --%>
<permission:action  code="cust_credit_rank_add_up_del">
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
    var cust_id="<%= request.getParameter("cust_id")%>";
    var param={};
    if(cust_id!="null" || cust_id==""){param.CUST_ID=cust_id;}
    var constantFlagTable = "User";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		
   		resetFormCallback:function(table,$form,operFlag){
   		 if("add" == operFlag){
   			var rowData = table.getRowDataAt(0);
   			jQuery("#creatorname").val('${sessionScope.loginUser.realname}');
   			jQuery("#creator").val('${sessionScope.loginUser.realname}');
   			initCustInfoName(cust_id);
   			var select_contract = getTracywindyObject("id_combo_id_is_creditrank");
	   	     select_contract.setValue('');
   			
   	   	     }
     	 },
    	 loadFormDataCallBack:function(table,$form,rowIndex){
	   		 var rowData = table.getRowDataAt(rowIndex);
	   	     var select_contract = getTracywindyObject("id_combo_id_is_creditrank");
	   	     select_contract.setValue(rowData["creditrank"]);
	   	
	   	    
	 },
  
   		 tableComment:'[信用等级]',
   		 constantFlagTable:'CustInfoCreditRank',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'信用等级',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/cust_credit_rank/cust_credit_rank.xml',
         params:param,
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         operButtons:operButtons,
         columns:[
		            {header:'id',name:'id',hidden:true},
		            
		            {header:'客户名称',name:'custname'},
		            {header:'级别',name:'creditrankname'},
		            //{header:'信用等级名',name:'creditrankname'},
		            {header:'变动日期',name:'changedate'}
		            //{header:'登记人',name:'creatorname'},
		            //{header:'登记时间',name:'createdate'},
		            //{header:'更新人',name:'modificatorname'},
		            //{header:'更新日期',name:'modifydate'}
		           
		          
	        ]
   	 });
   // 	commonSelectOverall('id_select_contract_id',"(select ci.contract_id,ci.id||'/'||cust.cust_name value from contract_info ci left join cust_info cust on (ci.cust_id=cust.id)) rs",'value',"contract_id",'contractid','','','',selectContract,false);
  //   	dictYesOrNoByCode('id_select_is_insured','isinsured',1,'','','require="true" label="是否投保"');
   });

</script>
<script type="text/javascript">
jQuery(function(){
    
    dictOnSelect('id_is_creditrank','creditrank','credit_rating',null,null,'require="true" label="信用等级"',true,165); //信用等级
  });
</script>

</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="信用等级" style="display:none;width:700px;height:290px">
	        <center>
		         <form id="id_detailInfoForm">
			        <table style="width:95%" class="fillTable">
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
			            <tr  class="tr-even">
			            	
			            	<td class="td-content-title">客户名称:  </td>  
			            	<td class="td-content" >
			            	   <input name="custid" id="id_custid" type="hidden" />
			            		<input name="custname" id="id_custname" require="true" label="客户名称"  maxlength="255"  readonly="readonly" class="td-content-input td-content-readonly"  type="text" /><font class="required-content">*</font></td>
			            	<td class="td-content-title">信用等级</td>  
			            	<td class="td-content">
			            		 <div id="id_is_creditrank" class="leftComboContainer" style="display:inline-block"></div><font class="required-content">*</font></td>
      				  	
			            </tr>
			            <tr  class="tr-odd"> 
			            	<td class="td-content-title">变动日期:  </td>  
			            	<td class="td-content">
			            		<input class="Wdate td-content-input" readonly name="changedate" class="td-content-input"  type="text"  onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="变动日期"><font class="required-content">*</font>
			    	</td>
			            	<td class="td-content-title">  </td>  
			            	<td class="td-content">
			            	</td>
			            </tr>
			            
			            <tr  class="tr-even">
			            	<td class="td-content-title">备注:  </td>  
			            	<td class="td-content" colspan="3">
			            	<textarea name="ccrmemo" maxB="255"  maxlength="255"  class="td-content-input"  style="width:84%;height:200" label="备注"   type="text" ></textarea>
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">登记人 :  </td>  
			            	<td class="td-content">
			            		<input name="creatorname" id="creatorname" label="登记人 " class=" td-content-input td-content-readonly" readonly="readonly" type="text" />
			            	</td>
			            	<td class="td-content-title">登记时间</td>  
			            	<td class="td-content">
			            		<input name="createdate" id="createdate" isDefaultDate="true" label="登记时间 "   class=" td-content-input td-content-readonly"  readonly="readonly" type="text" />
			            	</td>
			            </tr>
			            	<tr  class="tr-even">
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