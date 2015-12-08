<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租赁业务  - 租后检查表</title>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyMultiTable.js"></script>
	
	<style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	</style>
<script type="text/javascript">
jQuery(function(){
	commonSelectOverall('contractidname','CONTRACT_INFO','ID','CONTRACT_ID','contractid','','','require="true" label="合同号"',function(combo,data){choseNext(combo,'id_combo_contractidname','CONTRACT_INFO');},true); 
	var combo_cust = new tracywindyComboBox({
		lazyLoad:true,
		id : 'id_combo_cust',
		width : 300,
		renderTo : 'id_cust_name',
		xmlFileName : '\\eleasing\\workflow\\public\\comboSimpleCustSelect.xml',
		loadMode : 'ajax',
		readOnly : false,
		isAjaxLenovo : true,
		dropListHeight : 300,
		topAdd : 0,
		leftAdd : 0,
		positionDropIconLeftAdd : -1,
		name : 'cust_info',
		displayField : 'name',
		valueField : 'value',
		//rawValue:empty2Other('${empty ProductType ? PROD_ID : ProductType }','推土机'),
		params : {
			custType:'cust_type.cust'
		//currentRawValue:''
		//parentid:'ProductType'
		},
		onSelect : function(r, v) {
			combo_contract.setParam("cust_ID",v.value);
			combo_contract.reload();
		}
	});
});
    function importEbankCallBack(message){
        alert(message);
    	window.currentImportExcelLoadMask.hide();
    	var table = getTracywindyObject("id_table");
    	table.reload();
    }
    var constantFlagTable = "User";
    var ebankUploadUrl="";
    var ebankAttachUrl="";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var tableebank = new tracywindyOperationTable({

   		resetFormCallback:function(table,$form,operFlag){
   		 if("add" == operFlag){
   			var rowData = table.getRowDataAt(0);
   	   		 //document.getElementById("custname").value=rowData["custname"];
   			//$("#custname").val(rowData["custname"]);
   	     }
     	 },
   		 loadFormDataCallBack:function(table,$form,rowIndex){
 
        },
   		 tableComment:'[租后检查表]',
   		 constantFlagTable:'fundebank',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'租后检查表',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/fund_ebank/fund_ebank_info.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         params:{
        	 enabled:0
		 },
         columns:[
                  {header:'id',name:'id',hidden:true},
		            {header:'客户名称',name:'column1'},
		            {header:'合同编号',name:'column2'},
		            {header:'地址',name:'column3'},
		            {header:'经销商',name:'column4'},
		            {header:'邮编',name:'column5'},
		            {header:'电话',name:'column6'}
	        ]
   	 });
   // 	commonSelectOverall('id_select_contract_id',"(select ci.contract_id,ci.id||'/'||cust.cust_name value from contract_info ci left join cust_info cust on (ci.cust_id=cust.id)) rs",'value',"contract_id",'contractid','','','',selectContract,false);
  //   	dictYesOrNoByCode('id_select_is_insured','isinsured',1,'','','require="true" label="是否投保"');
   });

</script>
</head>
<body>
    <div id="id_tableContainer"></div>
    <div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="租后检查表" style="display:none1;width:1000px;padding-top:20px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:95%">
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
			            <tr>
			            	<td class="input_label_desc">客户名称:  </td>  
			            	<td class="td-content" colspan="2">
			            	<div id="id_cust_name" style="float: left;"></div>
			            	<!-- <input name="column7" require="true" label="客户名称"  type="text"  class="td-content-input"  /> -->	<span class="content-required">*</span>
			            	</td>
			                <td class="input_label_desc">合同编号:  </td>  
			            	<td class="td-content"  colspan="2">
			            	<div style="float: left" class="leftComboContainer"  id="contractidname"></div>
			            		<!--<input name="column8" require="true" label="合同编号"  type="text"  class="td-content-input"  />  --><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">地址:  </td>  
			            	<td class="td-content" colspan="2">
			            		<input name="column8" require="true" label="地址"  type="text"  class="td-content-input  td-content-readonly"  readOnly /><span class="content-required">*</span>
			            	</td>
			                <td class="input_label_desc">经销商:  </td>  
			            	<td class="td-content"  colspan="2">
			            		<input name="column9" require="true" label="经销商"  type="text"  class="td-content-input  td-content-readonly"  readOnly /><span class="content-required">*</span>
			            	</td>
			            </tr>
			             <tr>
			            	<td class="input_label_desc">邮编:  </td>  
			            	<td class="td-content" colspan="2">
			            		<input name="column10" require="true" label="邮编"  type="text"  class="td-content-input  td-content-readonly"   readOnly/><span class="content-required">*</span>
			            	</td>
			                <td class="input_label_desc">电话:  </td>  
			            	<td class="td-content"  colspan="2">
			            		<input name="column11" require="true" label="电话"  type="text"  class="td-content-input  td-content-readonly"   readOnly/><span class="content-required">*</span>
			            	</td>
			            </tr>
			           <tr>
			            	<td class="input_label_desc" style="width:12.5%">法定代表人:  </td>  
			            	<td class="td-content"  style="width:20%">
			            		<input name="column12" require="true" label="法定代表人"  type="text"  class="td-content-input  td-content-readonly"   readOnly/><span class="content-required">*</span>
			            	</td>
			                <td class="input_label_desc"  style="width:12.5%">电话:  </td>  
			            	<td class="td-content"  style="width:20%" >
			            		<input name="column13" require="true" label="电话"  type="text"  class="td-content-input  td-content-readonly"  readOnly /><span class="content-required">*</span>
			            	</td>
			            	 <td class="input_label_desc" style="width:12.5%">手机:  </td>  
			            	<td class="td-content" style="width:20%">
			            		<input name="column14" require="true" label="手机"  type="text"  class="td-content-input  td-content-readonly"  readOnly /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">授权代理人:  </td>  
			            	<td class="td-content" >
			            		<input name="column15" require="true" label="授权代理人"  type="text"  class="td-content-input  td-content-readonly"  readOnly /><span class="content-required">*</span>
			            	</td>
			                <td class="input_label_desc">电话:  </td>  
			            	<td class="td-content"  >
			            		<input name="column16" require="true" label="电话"  type="text"  class="td-content-input  td-content-readonly"  readOnly /><span class="content-required">*</span>
			            	</td>
			            	 <td class="input_label_desc">手机:  </td>  
			            	<td class="td-content">
			            		<input name="column17" require="true" label="手机"  type="text"  class="td-content-input  td-content-readonly"   readOnly/><span class="content-required">*</span>
			            	</td>
			            </tr>
			             <tr>
			            	<td class="input_label_desc">财务主管:  </td>  
			            	<td class="td-content" >
			            		<input name="column18" require="true" label="财务主管"  type="text"  class="td-content-input  td-content-readonly"   readOnly/><span class="content-required">*</span>
			            	</td>
			                <td class="input_label_desc">电话:  </td>  
			            	<td class="td-content"  >
			            		<input name="column19" require="true" label="电话"  type="text"  class="td-content-input  td-content-readonly"  readOnly/><span class="content-required">*</span>
			            	</td>
			            	 <td class="input_label_desc">手机:  </td>  
			            	<td class="td-content">
			            		<input name="column20" require="true" label="手机"  type="text"  class="td-content-input  td-content-readonly" readOnly  /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">总资产(元):  </td>  
			            	<td class="td-content" colspan="2">
			            		<input name="column21" require="true" label="总资产(元)"  type="text"  class="td-content-input  td-content-readonly"   readOnly/><span class="content-required">*</span>
			            	</td>
			                <td class="input_label_desc">净资产(元):  </td>  
			            	<td class="td-content"  colspan="2">
			            		<input name="column22" require="true" label="净资产(元)"  type="text"  class="td-content-input  td-content-readonly"  readOnly /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr><td colspan="6">
			            <div id="id_equipment_container" style="overflow: hidden;">
							</div>
			            </td></tr>
			          <tr>
			            	<td class="input_label_desc">期数(月):  </td>  
			            	<td class="td-content" >
			            		<input name="column23" require="true" label="期数(月)"  type="text"  class="td-content-input  td-content-readonly"  readOnly/><span class="content-required">*</span>
			            	</td>
			                <td class="input_label_desc">年利率(%):  </td>  
			            	<td class="td-content"  >
			            		<input name="column24" require="true" label="年利率(%)"  type="text"  class="td-content-input  td-content-readonly" readOnly /><span class="content-required">*</span>
			            	</td>
			            	 <td class="input_label_desc">月付款(元):  </td>  
			            	<td class="td-content">
			            		<input name="column25" require="true" label="月付款(元)"  type="text"  class="td-content-input  td-content-readonly"  readOnly /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">起租日:  </td>  
			            	<td class="td-content" >
			            		<input name="column26" require="true" label="起租日"  type="text"  class="td-content-input  td-content-readonly"  readOnly/><span class="content-required">*</span>
			            	</td>
			                <td class="input_label_desc">首次逾期日期:  </td>  
			            	<td class="td-content"  >
			            		<input name="column27" require="true" label="首次逾期日期"  type="text"  class="td-content-input  td-content-readonly" readOnly  /><span class="content-required">*</span>
			            	</td>
			            	 <td class="input_label_desc">逾期期数:  </td>  
			            	<td class="td-content">
			            		<input name="column28" require="true" label="逾期期数"  type="text"  class="td-content-input td-content-readonly" readOnly /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">逾期罚息:  </td>  
			            	<td class="td-content" >
			            		<input name="column29" require="true" label="逾期罚息"  type="text"  class="td-content-input  td-content-readonly" readOnly /><span class="content-required">*</span>
			            	</td>
			                <td class="input_label_desc">应付日期:  </td>  
			            	<td class="td-content"  >
			            		<input name="column30" require="true" label="应付日期"  type="text"  class="td-content-input  td-content-readonly" readOnly /><span class="content-required">*</span>
			            	</td>
			            	 <td class="input_label_desc">实付日期:  </td>  
			            	<td class="td-content">
			            		<input name="column31" require="true" label="实付日期"  type="text"  class="td-content-input  td-content-readonly" readOnly /><span class="content-required">*</span>
			            	</td>
			            </tr>
			           <tr>
			            	<td class="input_label_desc">保证人:  </td>  
			            	<td class="td-content" colspan="3" >
			            		<input name="column32" require="true" label="保证人"  type="text"  class="td-content-input  td-content-readonly"  readOnly/><span class="content-required">*</span>
			            	</td>
			            	 <td class="input_label_desc">联系电话:  </td>  
			            	<td class="td-content">
			            		<input name="column33" require="true" label="联系电话"  type="text"  class="td-content-input  td-content-readonly" readOnly /><span class="content-required">*</span>
			            	</td>
			            </tr>
			             <tr>
			            	<td class="input_label_desc">客户目前经营状况及变化，融资款的使用情况，租金的支付情况 :  </td>  
			            	<td class="td-content" colspan="5">
			            		<textarea name="column34" require="true"  class="td-content-input"  style="width:90%" label="客户目前经营状况及变化，融资款的使用情况，租金的支付情况"   type="text" ></textarea><span class="content-required">*</span>
			            	</td>
			            </tr>
			             <tr>
			            	<td class="input_label_desc">影响租金偿还或客户履约的主要不利和有利因素，估计客户违约可能性 :  </td>  
			            	<td class="td-content" colspan="5">
			            		<textarea name="column35" require="true"   class="td-content-input"  style="width:90%" label="影响租金偿还或客户履约的主要不利和有利因素，估计客户违约可能性"   type="text" ></textarea><span class="content-required">*</span>
			            	</td>
			            </tr>
			             <tr>
			            	<td class="input_label_desc">担保状况及不利变化 :  </td>  
			            	<td class="td-content" colspan="5">
			            		<textarea name="column36" require="true"    class="td-content-input" style="width:90%" label="担保状况及不利变化"   type="text" ></textarea><span class="content-required">*</span>
			            	</td>
			            </tr>
			             <tr>
			            	<td class="input_label_desc">对经销商或德银公司租后检查的态度 :  </td>  
			            	<td class="td-content" colspan="5">
			            		<textarea name="column37" require="true"   class="td-content-input"  style="width:90%" label="对经销商或德银公司租后检查的态度"   type="text" ></textarea><span class="content-required">*</span>
			            	</td>
			            </tr>
			             <tr>
			            	<td class="input_label_desc">拟采取的主要处理措施 :  </td>  
			            	<td class="td-content" colspan="5">
			            		<textarea name="column38" require="true"   class="td-content-input"  style="width:90%" label="拟采取的主要处理措施"   type="text" ></textarea><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">检查人员:  </td>  
			            	<td class="td-content" colspan="2">
			            	   <input name="column39" require="true" label="检查人员"  type="text"  class="td-content-input  td-content-readonly"  readOnly value="${sessionScope.loginUser.id}" /><span class="content-required">*</span>
			               </td>
			            		<td class="input_label_desc">最后修改时间:  </td>  
			            	<td class="td-content" colspan="2">
			            	<input name="column40" class="td-content-input td-content-readonly"  
             type="text" value="${empty requestScope['column40'] ?'2013-7-1': requestScope['column40']}" readOnly require="true" label="最后修改时间" /><span class="content-required">*</span></td>
			              </tr>
			            <tr class="content-separator">
				            <td colspan='6'>
				                <center>
				                 <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a>
						         <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
				                </center>
				            </td>
			            </tr>
			        </table>
		        </form>
	        </center>
	</div>
    
</body>
<jsp:include page="equipment_detial.jsp"></jsp:include>
</html>