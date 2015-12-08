<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保险管理 - 保险清单</title>
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
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		 resetFormCallback:function(table,$form,operFlag){
   	   		 if("add" == operFlag){
   	   	   		 
   	   	     }
   	   	     if("update" == operFlag){
   	   	  		getTracywindyObject("id_combo_id_select_contract_id").readOnlyData = true;
   	   	  		getTracywindyObject("id_combo_id_select_contract_id").reload();
   	   	   		jQuery("#selectOf_id_combo_id_select_contract_id").attr("readonly","readonly"); 
   	   	     }
   	     },
   		 loadFormDataCallBack:function(table,$form,rowIndex){
   	   		 var rowData = table.getRowDataAt(rowIndex);
   	   	     var select_contract = getTracywindyObject("id_combo_id_select_contract_id");
   	   	     select_contract.setRawValue(rowData["contractidshow"]);
   	   	     var select_isinsured = getTracywindyObject("id_combo_id_select_is_insured");
   	   		 select_isinsured.setRawValue(rowData["isinsuredshow"]);
    	 },
   		 tableComment:'[保险清单]',
   		 constantFlagTable:'InsuranceInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'保险清单',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/insure_manage/insurance_info.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:false,
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'合同编号',name:'contractidshow'},
		            {header:'合同ID',name:'contractid',hidden:true},
		            {header:'客户名',name:'custname'},
		            {header:'是否已投保',name:'isinsuredshow'},
		            {header:'是否已投保id',name:'isinsured',hidden:true},
		            {header:'保险公司',name:'insurer'},
		            {header:'投保日期',name:'begindate'},
		            {header:'保险终止日期',name:'enddate'},
		            {header:'保险单号',name:'insuranceno'},
		            {header:'险种',name:'insurancetype'},
		            {header:'投保人',name:'insured',hidden:true},
		            {header:'第一受益人',name:'beneficiary',hidden:true},
		            {header:'融资公司支付保费',name:'leaseinsurance',hidden:true},
		            {header:'客户支付保费',name:'custinsurance',hidden:true},
		            {header:'保险费',name:'insurance',hidden:true},
		            {header:'保险费率(%%)',name:'insurancerates'},
		            {header:'保险金额(万元)',name:'insuranceamount'},
		            {header:'保险代理费率(%)',name:'proxyrates'},
		            {header:'保险代理费',name:'proxyamount'},
		            {header:'付保费日期',name:'paydate',hidden:true},
		            {header:'收保单日期',name:'getdate',hidden:true},
		            {header:'退保对象',name:'surrenderobject',hidden:true},
		            {header:'退保金额',name:'surrendermoney',hidden:true},
		            {header:'租赁物件',name:'rentalitems',hidden:true},
		            {header:'退保日志',name:'surrendernote',hidden:true},
		            {header:'备注',name:'iimemo',hidden:true}
	        ]
   	 });
   	commonSelectOverall('id_select_contract_id',"(select ci.contract_id,ci.id||'/'||cust.cust_name value from contract_info ci left join cust_info cust on (ci.cust_id=cust.id)) rs",'value',"contract_id",'contractid','','','',selectContract,false);
   	dictYesOrNoByCode('id_select_is_insured','isinsured',1,'','','require="true" label="是否投保"');
   });
function selectContract(){
	var contractID=getTracywindyObject("id_combo_id_select_contract_id").getValue();
	if(contractID!=""){
		var va=contractID.split("/");
		jQuery('#custname').val(va[1]);
	}
}
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="保险清单" style="display:none;width:800px;height:400px">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:90%">
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
			            <tr>
			            	<td class="input_label_desc">合同编号:  </td>  
			            	<td class="td-content" nowrap="nowrap">
			            		<div style="float:left" id="id_select_contract_id" class="leftComboContainer"></div><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc">客户名:  </td>  
			            	<td class="td-content">
			            		<input name="custname" id="custname" require="true" label="客户名" readonly class="td-content-input td-content-readonly"   type="text" /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">是否投保:  </td>
			            	<td class="td-content">
			            		<div style="float:left" id="id_select_is_insured" class="leftComboContainer"></div> <span class="content-required">*</span> 
			            	</td>
			            	<td class="input_label_desc">保险公司:  </td>  
			            	<td class="td-content">
			            		<input name="insurer" require="true" label="保险公司"  class="td-content-input"  type="text" /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">投保日期:  </td>  
			            	<td class="td-content">
			            		<input class="Wdate td-content-input" readonly name="begindate" class="td-content-input"  type="text"  onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="投保日期"><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc">保险终止日期:  </td>  
			            	<td class="td-content">
			            		<input class="Wdate td-content-input" readonly name="enddate" class="td-content-input"  type="text"  onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="保险终止日期"><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">保险单号:  </td>  
			            	<td class="td-content">
			            		<input name="insuranceno" require="true" label="保险单号"    class="td-content-input"  type="text" /><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc">险种:  </td>  
			            	<td class="td-content">
			            		<input name="insurancetype" require="true" label="险种"  class="td-content-input"   type="text" /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">投保人:  </td>  
			            	<td class="td-content">
			            		<input name="insured" require="true" label="投保人"    class="td-content-input"  type="text" /><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc">第一受益人:  </td>  
			            	<td class="td-content">
			            		<input name="beneficiary" require="true" label="第一受益人"   class="td-content-input"    type="text" /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">融资公司支付保费:  </td>  
			            	<td class="td-content">
			            		<input name="leaseinsurance" require="true" label="融资公司支付保费"   class="td-content-input"    type="text" datatype="PMoney"/><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc">客户支付保费:  </td>  
			            	<td class="td-content">
			            		<input name="custinsurance" require="true" label="客户支付保费"   class="td-content-input"    type="text" datatype="PMoney" /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">保险费:  </td>  
			            	<td class="td-content">
			            		<input name="insurance" require="true" label="保险费"   class="td-content-input"    type="text" datatype="PMoney"/><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc"></td>  
			            	<td class="td-content">
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">保险费率:  </td>  
			            	<td class="td-content">
			            		<input name="insurancerates" require="true" label="保险费率"   class="td-content-input"    type="text" datatype="Rate"/><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc">保险金额(万元):  </td>  
			            	<td class="td-content">
			            		<input name="insuranceamount" require="true" label="保险金额(万元)"   class="td-content-input"  datatype="PMoney"  type="text" /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">保险代理费率:  </td>  
			            	<td class="td-content">
			            		<input name="proxyrates" require="true" label="保险代理费率"  datatype="Rate"   class="td-content-input" type="text" /><span class="content-required">*</span>
			            	</td> 
			            	<td class="input_label_desc">保险代理费:  </td>  
			            	<td class="td-content">
			            		<input name="proxyamount" require="true" label="保险代理费"  datatype="PMoney"  class="td-content-input"   type="text" /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">付保费日期:  </td>  
			            	<td class="td-content">
			            		<input class="Wdate td-content-input" readonly name="paydate" class="td-content-input"  type="text"  onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="付保费日期"><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc">收保单日期:  </td>  
			            	<td class="td-content">
			            		<input class="Wdate td-content-input" readonly name="getdate" class="td-content-input"  type="text"  onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="收保单日期"><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">退保对象:  </td>  
			            	<td class="td-content">
			            		<input name="surrenderobject" require="true" label="退保对象"  class="td-content-input"   type="text" /><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc">退保金额:  </td>  
			            	<td class="td-content">
			            		<input name="surrendermoney" require="true" label="退保金额"  datatype="Money"  class="td-content-input"   type="text" /><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">租赁物件:  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="rentalitems" require="true" label="租赁物件"  style="width:90%"  class="td-content-input"   type="text" ></textarea><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">退保日志:  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="surrendernote" require="true" label="退保日志"   class="td-content-input"  style="width:90%"  type="text" ></textarea><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">备注:  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="iimemo" require="true" label="备注"   class="td-content-input" style="width:90%" type="text" ></textarea><span class="content-required">*</span>
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
</html>