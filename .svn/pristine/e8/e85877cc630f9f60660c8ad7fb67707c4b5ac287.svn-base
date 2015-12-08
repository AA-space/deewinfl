<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>其它功能 - 权证文件登记</title>
<!--css sheet-->
<link href="${pageContext.request.contextPath}/css/dtree/dtree.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/button.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css"
	rel="stylesheet" type="text/css">
<!--javascript libray-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindySerializeFormToJsonObject.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/validator.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
<style type="text/css">
html,body {
	overflow: hidden;
}
</style>
<script type="text/javascript">
    var constantFlagTable = "ContractEquipDelivery";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
		 
		var table = new tracywindyOperationTable({
			resetFormCallback:function(table,$form,operFlag){
				 var contractCombo = getTracywindyObject("id_combo_contractid");
				 var custCombo = getTracywindyObject("id_combo_custid");
				 if("add" == operFlag){
					 contractCombo.readOnlyData = false;
					 contractCombo.reload();
					 custCombo.readOnlyData = false;
					 custCombo.reload();
	   	   	     }
	   	    },
	   	    loadFormDataCallBack:function(table,$form,rowIndex){
	   	    	var rowData = table.getRowDataAt(rowIndex);
	   	    	var contractCombo = getTracywindyObject("id_combo_contractid");
	   	    	contractCombo.readOnlyData = true;
	   	    	contractCombo.rawValue=rowData["contractid"];
	   	    	contractCombo.reload();
	   	    	var custCombo = getTracywindyObject("id_combo_custid");
	   	    	custCombo.readOnlyData = true;
	   	    	custCombo.rawValue=rowData["custname"];
	   	    	custCombo.reload();
			},
			tableComment:'权证文件',
	   		constantFlagTable:constantFlagTable,
	        renderTo:'id_tableContainer',
	        title:'权证文件登记',
	        width:pageWidth,
	        height:pageHeight,
	        id:'id_table',
	        xmlFileName:'/eleasing/jsp/other/document_reg/list.xml',
	        loadMode:'ajax',
	        isPage:true,
	        isFit:false,
	        border:true,
	        columns:[
				{header:'流水号',name:'id',hidden:true},
				{header:'合同编号',name:'contractid',queryConfig:{}},
				{header:'业务合同号',name:'contractnumber',queryConfig:{}},
				{header:'承租人',name:'custname',queryConfig:{}},
				{header:'首付款',name:'planmoney'},
				{header:'GPS安装',name:'gpsinfo'},
				{header:'车辆投保',name:'carinsure'},
				{header:'车辆上牌',name:'carlicense'},

				{header:'车辆抵押',name:'carguarantee'},
				{header:'向客户交付租赁物',name:'custdelivery'},
				{header:'客户签收租赁物',name:'custsign'},
				{header:'车辆合格证原件',name:'carcredentials'},
				{header:'发票原件',name:'carinvoice'},
				{header:'机动车辆登记证原件',name:'motorcredentials'},

				{header:'保单复印件',name:'invoicecopy'},
				{header:'行驶证复印件',name:'drivecopy'}
		    ],
		    params : {
				dealer_id:"${requestScope['contractid']}"
			}
   	    });
    });
	jQuery(function(){
	     commonSelectOverall('contractid',"(SELECT ID,CONTRACT_ID||'&'||0||'&'||ID NAME FROM CONTRACT_INFO WHERE 1=1) RS",'name','id','contractid',null,null,null,function(combo){
		     var contractId = combo.getValue().split('&')[0];
		     var planMoney = combo.getValue().split('&')[1];
			 $('#planmoney').val(planMoney);
		 },false);
		 commonSelectOverall('custid',"(SELECT ID,CUST_NAME NAME FROM CUST_INFO) RS",'id','name','custid',null,null,null,function(combo){
			 var custId = combo.getValue();
			 var contractCombo = getTracywindyObject("id_combo_contractid");
			 contractCombo.params["tableName"] = "(SELECT CI.CONTRACT_NUMBER ID,CI.CONTRACT_ID||'&'||DECODE(CFFP.PLAN_MONEY,NULL,0,CFFP.PLAN_MONEY)||'&'||CI.ID NAME FROM CONTRACT_INFO CI JOIN CUST_INFO CII ON CII.ID=CI.CUST_ID LEFT JOIN (SELECT CONTRACT_ID,SUM(PLAN_MONEY) PLAN_MONEY FROM CONTRACT_FUND_FUND_PLAN WHERE FEE_TYPE='feetype5' and invalid='0' GROUP BY CONTRACT_ID) CFFP ON CFFP.CONTRACT_ID=CI.ID WHERE CI.CUST_ID='" + custId + "') RS";
			 contractCombo.reload();
		 },false);
	});
	
	//提交表单
	function submitInsure(){
		var contractId = getTracywindyObject("id_combo_contractid").getValue();
		if(!!contractId){
			var result = getTracywindyObject("id_table").operationTable();
			return true;
		} else {
			alert("请选择合同编号！！！");
			return false;
		}
	}
</script>
</head>
<body>
<div id="id_tableContainer"></div>
<div id="id_detailInfoWindowContainer"  title="权证文件操作" style="display:none;width:750px;height:360px">
    <center>
       <form id="id_detailInfoForm">
	        <table style="width:90%">
	            <tr>
	            	<td class="input_label_desc" align="left">承租人：</td>
	            	<td class="td-content">
	            		<div class="leftComboContainer" id="custid"></div>	
	            	</td>
	           		<td class="input_label_desc" align="left">业务合同编号：</td>  
	            	<td class="td-content">
		            	<input type="hidden" name="id"/>
            			<div class="leftComboContainer" id="contractid"></div>	
            		</td>
	            </tr>
	            <tr>
		            <td class="input_label_desc" align="left" nowrap="nowrap">承租人支付融资合同首付款：</td>  
		            <td class="td-content" style="float:left;" colspan="2">
		            	<input type="text" name="planmoney" id="planmoney"  class="td-content-input td-content-readonly" readonly="readonly"/>
		            </td>
	            </tr>
	            <tr>
	               <td class="input_label_desc" align="left" colspan="4">车务手续办理情况&gt;&gt;</td>  
	            </tr>
	            <tr>
	            	<td class="input_label_desc" align="left">GPS安装：</td>
	            	<td class="td-content">
	            		<input type="text" name="gpsinfo"   class="td-content-input"/>
	            	</td>
	              	<td class="input_label_desc" align="left">车辆投保：</td>  
	            	<td class="td-content">
	            		<input type="text" name="carinsure"   class="td-content-input" />
	            	</td>
	            </tr>
	            <tr>
	            	<td class="input_label_desc" align="left">车辆上牌：</td>
	            	<td class="td-content">
	            		<input   type="text" name="carlicense"   class="td-content-input" /> 
	            	</td>
	            	<td class="input_label_desc" align="left">车辆抵押：</td>  
	            	<td class="td-content">
	            		<input type="text" name="carguarantee"   class="td-content-input" />
	            	</td>
	            </tr>
	            <tr>
	            	<td class="input_label_desc" align="left">向客户交付租赁物：</td>
	            	<td class="td-content">
	            		<input   type="text" name="custdelivery"   class="td-content-input" /> 
	            	</td>
	              	<td class="input_label_desc" align="left">客户签收租赁物：</td>  
	            	<td class="td-content">
	            		<input type="text" name="custsign"   class="td-content-input" />
	            	</td>
	            </tr>
	            <tr>
	               <td class="input_label_desc" align="left" colspan="4">回收车辆资料及证件&gt;&gt;</td>  
	            </tr>
	            <tr>
	             	<td class="input_label_desc" align="left">车辆合格证原件：</td>  
	            	<td class="td-content">
	            		<input type="text" name="carcredentials"   class="td-content-input" />
	            	</td>
	            	<td class="input_label_desc" align="left">发票原件：</td>
	            	<td class="td-content">
	            		<input   type="text" name="carinvoice"   class="td-content-input" /> 
	            	</td>
	            </tr>
	            <tr>
	              	<td class="input_label_desc" align="left">机动车辆登记证原件：</td>  
	            	<td class="td-content">
	            		<input type="text" name="motorcredentials"   class="td-content-input" />
	            	</td>
	            	<td class="input_label_desc" align="left">保单复印件：</td>
	            	<td class="td-content">
	            		<input   type="text" name="invoicecopy"   class="td-content-input" /> 
	            	</td>
	            </tr>
	            <tr>
	              	<td class="input_label_desc" align="left">行驶证复印件：</td>  
	            	<td class="td-content">
	            		<input type="text" name="drivecopy"   class="td-content-input" />
	            	</td>
	            </tr>
	            <tr class="content-separator">
		            <td colspan='4'>
		                 <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='submitInsure();'><span>确定</span></a>
				         <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
		            </td>
	            </tr>
	        </table>
        </form>
     </center>
</div>
</body>
</html>