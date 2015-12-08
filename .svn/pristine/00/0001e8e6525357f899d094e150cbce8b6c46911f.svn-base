<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资金开票红冲</title>
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
var currentLoginUserId = "${sessionScope['login_userid']}";
var isAdmin=false;
var operButtons='新增';
</script >
<permission:action  code="interest_master">
<script type="text/javascript">
isAdmin=true;
operButtons='';
</script >
</permission:action>

<permission:action  code="rent_account">
<script type="text/javascript">
isAdmin=false;
operButtons='新增';
</script >
</permission:action>

<permission:action  code="tax_account">
<script type="text/javascript">
isAdmin=false;
operButtons='新增';
</script >
</permission:action>
<script type="text/javascript">
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		
   		 tableComment:'[资金开票红冲]',
   		 constantFlagTable:'TaxFundHcInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'资金开票红冲',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/invoice_manage/fund_invoice/fund_invoice_hc.xml',
         loadMode:'ajax',
         isPage:true,
         isCheck:false,
         operButtons:operButtons,
         isFit:true,
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'上传编号',name:'taxfundupid',hidden:true},
		            {header:'合同号',name:'contractid',queryConfig:{}},
		            {header:'发票号',name:'invoiceno',queryConfig:{}},
		            {header:'客户名称',name:'custname',queryConfig:{}},
		            {header:'专用发票红冲通知单号',name:'invoicehcno'},
		            {header:'红冲时间',name:'invoicehcdate',type:"date",isRange:true,queryConfig:{isNewLine:true}},
		            {header:'金额',name:'corpustaxmoney'},
		            {header:'费用类型',name:'taxtype'},
		            {header:'创建人',name:'creator'},
		            {header:'创建日期',name:'createdate'},
		            {header:'状态',name:'hcstatus',type:'combobox',
		            	queryConfig:{
		            	isNewLine:false,
		            	colSpan:2, 
		            	loadMode:'local',
		            	datas:[
		            	{title:'已红冲',name:'已红冲'},
		            	{title:'红冲发票',name:'红冲发票'},
		            	{title:'全部',name:''}
		            	],
		            	displayField:'title',
		            	valueField:'name',
		            	defaultValue:1
		            	}
		            			            }
	        ]
   	 });
   });
    jQuery(function(){
	var sql = "(SELECT INVOICE_NO,ID||'/'||TAX_TYPE||'/'||CORPUS_TAX_MONEY as value from TAX_FUND_UPLOAD_INFO WHERE NVL(HC_STATUS,0)=0)";
	commonSelectOverall('id_invoice_num',sql,'value',"INVOICE_NO",'invoice_no','${requestScope["proj_info.projtype"]}',null,null,queryTaxFundHcInfo,true);
        });
    function queryTaxFundHcInfo(){
    	var id_invoice_num = getTracywindyObject("id_combo_id_invoice_num").getValue();
    	if(id_invoice_num!=""){
    		var va=id_invoice_num.split("/");
    		//资金发票导入数据存储表ID 反插入到主表资金发票红冲发票信息表
    		jQuery('#id').val(va[0]);
    		jQuery('#id_taxtype').val(va[1]);
    		jQuery('#id_corpustaxmoney').val(va[2]);
    	}
    }

	   
  //提交表单
  function submitInsur(){
	var id_invoice_num = getTracywindyObject("id_combo_id_invoice_num").getValue();
  	var id_taxtype        = $("#id_taxtype").val();
  	var id_corpustaxmoney = $("#id_corpustaxmoney").val(); 
  	if(id_invoice_num==""||id_invoice_num==null){
  		alert("发票号不能为空！！！");
  		return false;
  	}else if(id_taxtype == ""||id_taxtype==null){
  		alert("费用类型不能为空！！！");
  		return false;
  	}else if(id_corpustaxmoney == "" || null==id_corpustaxmoney){
  		alert("金额不能为空！！！");
  		return false;
  	}else{
  		getTracywindyObject("id_table").operationTable();
  		return true;
  	}
  }
    
 
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  title="新增资金红冲" style="display:none;width:400px;height:300px">
       <center>
        <form id="id_detailInfoForm">
	        <table style="width:90%">
	            <tr style="display:none"><td><input id="id" name="id" type="hidden"/></td></tr>
	            <tr>
	            	<td class="input_label_desc" align="left">发票号:  </td>
	            	<td class="td-content">
	            	<div id="id_invoice_num"></div>	  
	            	</td>
	            </tr>
	            <tr>
	                <td class="input_label_desc" align="left">费用类型:  </td>  
	            	<td class="td-content">
	            		<input  type="text" id="id_taxtype" name="taxtype"   class="td-content-input"  />
	            	</td>
	            </tr>
	            
	             <tr>
	            	<td class="input_label_desc" align="left">金额:  </td>  
	            	<td class="td-content">
	            		<input  type="text"  id="id_corpustaxmoney" name="corpustaxmoney"   class="td-content-input"  />
	            	</td>
	            	
	            </tr>
	            
	            <tr>
	            	<td class="input_label_desc" align="left">红冲通知单号/作废单号:  </td>  
	            	<td class="td-content">
	            		<input   type="text"  name="id_invoicehcno"  class="td-content-input" require="true" label="发票红冲通知单号" maxB="20"><span class="content-required">*</span>
	            	</td>
	            </tr>
	            <tr>
	            	<td class="input_label_desc" align="left">红冲日期:  </td>  
	            	<td class="td-content">
			      <input class="Wdate td-content-input" readonly name="id_invoicehcdate" class="td-content-input"  type="text" 
 onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="红冲日期" ><span class="content-required">*</span>
               </td>
	            	 
	            </tr>
	            
	            <tr class="content-separator">
		            <td colspan='4'>
		                 <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='submitInsur();'><span>确定</span></a>
				         <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
		            </td>
	            </tr>
	        </table>
        </form>
       </center>
	</div>
	
</body>
</html>