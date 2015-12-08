<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息管理  - 关联企业及分支机构情况</title>
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
    var cust_id="<%= request.getParameter("cust_id")%>";
    if("false"=='${param.readOnly}')
    {
	   operButtons="";
    }
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
   			initCustInfoName(cust_id);
   		    var select_contract = getTracywindyObject("id_combo_id_is_stockholdertype");
	   	    select_contract.setValue("CUST_INFO_COMPANY");
	   	 var select_contract = getTracywindyObject("id_combo_id_is_relationship");
	   	    select_contract.setValue('');
   	     }
     	 },
		 
   		 loadFormDataCallBack:function(table,$form,rowIndex){
	   		 var rowData = table.getRowDataAt(rowIndex);
	   	     var select_contract = getTracywindyObject("id_combo_id_is_stockholdertype");
	   	    select_contract.setValue(rowData["stockholdertype"]);
	   		  var select_contract = getTracywindyObject("id_combo_id_is_relationship");
	   		select_contract.setValue(rowData["relationship"]);
	   	  
	 },
   		 tableComment:'[关联企业及分支机构情况]',
   		 constantFlagTable:'CustShareCompany',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'关联企业及分支机构情况',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/cust_share_company/cust_share_company.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         params:param,
         operButtons:operButtons,
         columns:[
		            {header:'客户名称',name:'custname'},
		            {header:'关联企业名称',name:'stockholdername'},
		            {header:'法人/个人',name:'stockholdertype',hidden:true},
		            {header:'法人/个人',name:'stockholdertypename'},
		            {header:'身份证/组织机构代码',name:'orgcode'},
		            {header:'注册资本',name:'regcapital'},
		            {header:'持股比例',name:'shareholding'},
		            {header:'法人代表',name:'legalrepresentative'}
	        ]
   	 });
   // 	commonSelectOverall('id_select_contract_id',"(select ci.contract_id,ci.id||'/'||cust.cust_name value from contract_info ci left join cust_info cust on (ci.cust_id=cust.id)) rs",'value',"contract_id",'contractid','','','',selectContract,false);
  //   	dictYesOrNoByCode('id_select_is_insured','isinsured',1,'','','require="true" label="是否投保"');
   });

</script>

  <script type="text/javascript">
     jQuery(function(){
    	 dictOnSelect('id_is_relationship','relationship','relation_ship',null,null,' require="true"  label="关联关系"');//关联关系
       // dictOnSelect('id_is_stockholdertype','stockholdertype','cust_info_type',null,null,false,true,165); //记录类型
    	 new tracywindyComboBox({
    		   lazyLoad:true,
    	       id:'id_combo_id_is_stockholdertype',
    	       width:defaultInputWidth,
    	       renderTo:'id_is_stockholdertype',
    	       loadMode:'local',
    	       readOnly:true,
    	       name:'stockholdertype',
    	       displayField:'name',
    	       valueField:'code',
    	       leftAdd:0,
    	       datas:[{name:'个人',code:'CUST_INFO_PERSON'},{name:'法人',code:'CUST_INFO_COMPANY'}]
    	    });
      });
     </script>
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  buttons="#id-dlg-buttons"  closed="true" modal="true" title="关联企业及分支机构情况" style="display:none;width:800px;height:1030px;">
	        <center>
		         <form id="id_detailInfoForm">
			        <table style="width:95%" class="fillTable">
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
			            <tr  class="tr-even">
			            	
			            	<td class="td-content-title" >客户名称:  </td>  
			            	<td class="td-content">
			            	  <input name="custid" id="id_custid" type="hidden" />
			            		<input name="custname" id="id_custname" require="true"  style="width:82%"  maxlength="255"  readonly="readonly" label="客户名称" class="td-content-input td-content-readonly" type="text" /><font class="required-content">*</font></td>
			           
			            	 <td class="td-content-title"></td><td class="td-content"></td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">主要股东名称:  </td>  
			            	<td class="td-content" colspan="3">
			            	   <textarea name="stockholdername" require="true"   maxlength="255"  maxB="255" class="td-content-input"  style="width:86%" label="主要股东名称"   type="text" ></textarea><font class="required-content">*</font>
			         	  	</td>
			         	</tr>
			         	<tr  class="tr-even">
			            	<td class="td-content-title">法人/个人:  </td>  
			            	<td class="td-content" colspan="3">
			            	 <div id="id_is_stockholdertype" class="leftComboContainer"  class="td-content-input"  maxlength="30"  maxB="30"  style="float:left"></div><font class="required-content">*</font></td>
			                 
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">身份证/组织机构代码:  </td>  
			            	<td class="td-content" >
			            		<input name="orgcode" require="true" label="身份证/组织机构代码" class="td-content-input"  maxlength="18"  maxB="30"   type="text" /><font class="required-content">*</font>
			            	</td>
			            	<td class="td-content-title">注册资本:  </td>  
			            	<td class="td-content" >
			            		<input name="regcapital" require="true" label="注册资本"  dataType="Double"  maxlength="50"  class="td-content-input"  type="text" /><font class="required-content">*</font>
			            	</td>
			            	
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">持股比例:  </td>  
			            	<td class="td-content" >
			            		<input name="shareholding" require="true" label="持股比例" class="td-content-input"  maxlength="30"   dataType="Double"   type="text" /><font class="required-content" style="color:#000000">%</font><font class="required-content">*</font>
			            	</td>
			            	<td class="td-content-title">法人代表:  </td>  
			            	<td class="td-content" >
			            		<input name="legalrepresentative" require="true" label="法人代表" class="td-content-input"   maxlength="150"  maxB="150"   type="text" /><font class="required-content">*</font>
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">关联关系:  </td>  
			            	<td class="td-content" colspan="3">
			            		<div style="float:left" class="leftComboContainer"  label="关联关系" id="id_is_relationship"></div><font class="required-content">*</font>
			            	</td>
			            </tr>
			     	   <tr  class="tr-even">
			            	<td class="td-content-title">地址:  </td>  
			            	<td class="td-content" colspan="3">
			            		<input name="addr" id="addr" style="width:86%" maxB="255"  maxlength="255"   class="td-content-input"  require="true" label="地址"      type="text" /><font class="required-content">*</font>
			            	</td>
			            	
			            </tr>
			              <tr  class="tr-odd">
			            	<td class="td-content-title">主营业务:  </td>  
			            	<td class="td-content" colspan="3">
			            	<textarea name="bizscopeprimary" require="true" maxB="255"  maxlength="255"  class="td-content-input"  style="width:86%" label="主营业务"   type="text" ></textarea><font class="required-content">*</font>
			            		</td>
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">登记人 :  </td>  
			            	<td class="td-content">
			            		<input name="creatorname" id="creatorname" label="登记人 " class=" td-content-input td-content-readonly" readonly="readonly" type="text" />
			            	</td>
			            	<td class="td-content-title">登记时间:</td>  
			            	<td class="td-content">
			            		<input name="createdate" isDefaultDate="true" id="createdate" label="登记时间 " class="td-content-input td-content-readonly"  readonly="readonly" type="text" />
			            	</td>
			            </tr>  
			            	<tr  class="tr-odd">
			            	<td class="td-content-title">修改人 :  </td>  
			            	<td class="td-content">
			            		<input name="modificatorname" id=modificator label="修改人 " class="td-content-input td-content-readonly" readonly="readonly" type="text" />
			            	</td> 
			            	<td class="td-content-title">修改时间:</td>  
			            	<td class="td-content">
			            		<input name="modifydate" id="modifydate" label="修改时间" class="td-content-input td-content-readonly"  readonly="readonly" type="text" />
			            	</td>
			            </tr>
			        </table>
		        </form>
	        </center>
	</div>
	<div style="text-align:center;width:800px;display:none;height:40px;line-height:40px;" id="id-dlg-buttons">
		  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a>
		  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
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