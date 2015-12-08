<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经销商管理  - 经销商账号信息</title>
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
    var constantFlagTable = "User";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	var cust_id="<%= request.getParameter("cust_id")%>";
    var param={};
	jQuery(function(){
   	 var table = new tracywindyOperationTable({

   		resetFormCallback:function(table,$form,operFlag){
   		 if("add" == operFlag){
   			var rowData = table.getRowDataAt(0);
   			var select_contract = getTracywindyObject("id_combo_id_is_enable");
 	        select_contract.setValue("");
 	        var select_contract = getTracywindyObject("id_combo_id_is_dealerDept");
	        select_contract.setValue("");
	        var select_contract = getTracywindyObject("id_combo_id_is_custid");
	        select_contract.setValue("");
	        jQuery("#creatorname").val('${sessionScope.loginUser.realname}');
 	        //getTracywindyObject("id_combo_id_is_custid").readOnlyData = false;
  	  		//getTracywindyObject("id_combo_id_is_custid").reload();
  	  	
   	       }
 	       
 	      if("update" == operFlag){
 	    	  //getTracywindyObject("id_combo_id_is_custid").readOnlyData = true;
	   	  	  //getTracywindyObject("id_combo_id_is_custid").reload();
	   	  	  
 	 	       }
     	 },
   		 loadFormDataCallBack:function(table,$form,rowIndex){
   		    var rowData = table.getRowDataAt(rowIndex);
   			var select_contract = getTracywindyObject("id_combo_id_is_enable");
	        select_contract.setValue(rowData["enable"]);
	        var select_contract = getTracywindyObject("id_combo_id_is_dealerDept");
	        select_contract.setValue(rowData["dealerdept"]);
	        var select_contract = getTracywindyObject("id_combo_id_is_custid");
	        select_contract.setValue(rowData["custid"]);

        },
   		 tableComment:'[经销商账号]',
   		 constantFlagTable:'DealerAccountManager',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'经销商账号',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/dealer_manage/dealer_account_manager.xml',
         params:param,
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         isExcel : true,
         columns:[
					{header:'id',name:'id',hidden:true},
					{header:'custid',name:'custid',hidden:true},
					{header:'账号状态',name:'enablename',hidden:false
						,type:'combobox',
		            	queryConfig:{
						width:165,
						loadMode:'local',
						datas:[
								{title:'启用',name:'0'},
								{title:'禁用',name:'1'}
								],
			            displayField:'title',
			            valueField:'name',
			            defaultValue:0
					}},
					{header:'经销商',name:'custname',queryConfig:{}},
		            {header:'经销商对应部门',name:'dealerdeptname'}
		            
		           
	        ]
   	 });
   // 	commonSelectOverall('id_select_contract_id',"(select ci.contract_id,ci.id||'/'||cust.cust_name value from contract_info ci left join cust_info cust on (ci.cust_id=cust.id)) rs",'value',"contract_id",'contractid','','','',selectContract,false);
  //   	dictYesOrNoByCode('id_select_is_insured','isinsured',1,'','','require="true" label="是否投保"');
   });

</script>

 <script type="text/javascript">
     jQuery(function(){
 		 //dictOnSelect('id_is_enable','enable','dealer_symbiosis',null,null,'require="true" label="状态"');
    	 commonSelectOverall('id_is_custid',"(select cust.id,cust.cust_name from cust_info_dealer dealer left join cust_info cust on dealer.cust_id=cust.id) rs",'id',"cust_name",'custid','','','require="true" label="经销商"',null,false);
    	 commonSelectOverall('id_is_dealerDept',"(select id_,name_ from T_DEPTS) rs",'id_',"name_",'dealerDept','','','require="true" label="经销商对应部门"',null,false);

    	 var combo = new tracywindyComboBox({
    		 lazyLoad:true,
    	      id:'id_combo_id_is_enable',
    	      renderTo:'id_is_enable',
    	      loadMode:'local',
    	      datas:[{title:'禁用',name:'1'},{title:'启用',name:'0'}],
    	      readOnly:false,
    	      topAdd:0,
    	      otherAttributes:'require="true"  label="状态"',
    	      leftAdd:0,
    	      name:'enable',
    	      displayField:'title',
    	      valueField:'name'
    			});

         });

     </script>
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="经销商账号管理" style="display:none1;width:800px;padding-top:20px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:95%" class="fillTable">
			              <tr style="display:none"><td><input name="id" type="hidden" value=""/><!--<input name="custid" type="hidden" value=""/>--></td></tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">经销商:  </td>  
			            	<td class="td-content" colspan="3" >
			            	<div style="float: left" class="leftComboContainer" id="id_is_custid" ></div><font class="required-content">*</font></td>
			               </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">经销商对应部门:  </td>  
			            	<td class="td-content">
			            		<div style="float: left" class="leftComboContainer" id="id_is_dealerDept"></div><font class="required-content">*</font>
			            	</td>
			            	<td class="td-content-title">状态:  </td>  
			            	<td class="td-content">
			            	 <div id="id_is_enable" class="leftComboContainer" style="float:left"></div><font class="required-content">*</font></td>
			            </tr>
		         
			            <tr class="tr-odd">
			            	<td class="td-content-title">登记人 :  </td>  
			            	<td class="td-content">
			            		<input name="creatorname" id="creatorname" label="登记人 " class="td-content-input td-content-readonly"  readonly="readonly" type="text" />
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
				                 <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a>
						         <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
				            </td>
			            </tr>
			        </table>
		        </form>
	        </center>
	</div>
</body>

</html>
