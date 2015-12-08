<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金开票红冲</title>
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
var tools=[ {
		html : '<font color="red">新增租金红冲</font>',
			handler:function(table){
      	  table.addEntity();
        },
			iconCls : 'icon-add'
		} ];
</script >
<permission:action  code="interest_master">
<script type="text/javascript">
isAdmin=true;
tools='';
</script >
</permission:action>

<permission:action  code="rent_account">
<script type="text/javascript">
isAdmin=true;
tools=[ {
		html : '<font color="red">新增租金红冲</font>',
			handler:function(table){
      	  table.addEntity();
        },
			iconCls : 'icon-add'
		} ];
</script >
</permission:action>

<permission:action  code="tax_account">
<script type="text/javascript">
isAdmin=true;
tools='';
</script >
</permission:action>
	<script type="text/javascript">
	      var all_width = (document.documentElement||document.body).clientWidth-2;
	      var all_height = (document.documentElement||document.body).clientHeight-2;

	jQuery(function(){
		var table = new tracywindyOperationTable({
		 tableComment:'[红冲发票]',
	     constantFlagTable:'TaxRentHcInfo',
   		 renderTo:'id_tableContainer',
   		 width:all_width,
		 height:all_height,
		 //toolsLeftMargin:200,
		 windowTop:20,
   	     border:true,
         title:'租金开票红冲',
         operButtons:' ',
         tools : tools,
         
         id:'id_table',
         xmlFileName:'eleasing/jsp/invoice_manage/rent_invoice/rent_invoice_hc.xml',
         loadMode:'ajax',
         isPage:true,
         pageSize : 20,
         isFit:true,
         isCheck:false,
 		 isRank:false,
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'上传编号',name:'taxfundupid',hidden:true},
		            {header:'合同号',name:'contractid'},
		            {header:'业务合同号',name:'contractnumber',width:180},
		            {header:'发票号',name:'invoiceno'},
		            {header:'客户名称',name:'custname'},
		            {header:'专用发票红冲通知单号',name:'invoicehcno'},
		            {header:'红冲时间',name:'invoicehcdate'},
		            {header:'开票金额',name:'invoicemoney'},
		            {header:'金额类型',name:'renttype'},
		            {header:'创建人',name:'creator'},
		            {header:'创建日期',name:'createdate'}
	       	     ]
   	 });
		var sql = "(SELECT INVOICE_NO,ID||'/'||RENT_TYPE||'/'||TAX_MONEY as value from TAX_RENT_UPLOAD_INFO WHERE NVL(HC_STATUS,0)=0)";
		commonSelectOverall('id_invoiceno',sql,'value',"INVOICE_NO",'invoice_no','${requestScope["proj_info.projtype"]}',null,null,queryTaxFundHcInfo,false);
	        });
   
	    function queryTaxFundHcInfo(){
	    	var id_invoiceno = getTracywindyObject("id_combo_id_invoiceno").getValue();
	    	if(id_invoiceno!=""){
	    		var va=id_invoiceno.split("/");
	    		jQuery('#id').val(va[0]);
	    		jQuery('#id_taxtype').val(va[1]);
	    		jQuery('#id_taxtmoney').val(va[2]);
	    	}
	    }
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="租金开票红冲" style="display:none;height:350px;width:800px;padding-top:20px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:95%" class="fillTable">
			            <tr style="display:none"><td><input id="id" name="id" type="hidden"/></td></tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">发票号:  </td>  
			            	<td class="td-content">
			            	 <div id="id_invoiceno" class="leftComboContainer" style="float:left"></div></td>

			            	<td class="td-content-title">费用类型:  </td>  
			            	<td class="td-content" >
			            		<input id="id_taxtype" name=taxtype class="td-content-input" require="true" readonly="readonly" maxlength="50"  label="费用类型"  maxB="50"   type="text" />
			            	</td>
			            </tr>
			            <tr  class="tr-even">
			            <td class="td-content-title">金额:  </td>  
			            	<td class="td-content" >
			            		<input id="id_taxtmoney" name="taxtmoney"  class="td-content-input" readonly="readonly" require="true"  maxlength="30"  label="金额"   maxB="30"  type="text" />
			            	</td>

			            	<td class="td-content-title">红冲通知单号/作废单号 :  </td>  
			            	<td class="td-content">
			            	<input id="id_invoicehcno" name=id_invoicehcno class="td-content-input" require="true"  maxlength="50"  label="专用发票红冲通知单号"  maxB="50"   type="text" /><font class="required-content">*</font>
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">红冲日期:  </td>  
			            	<td class="td-content" colspan="3">
			            		<input id="id_invoicehcdate" class="Wdate td-content-input" readonly name="id_invoicehcdate" class="td-content-input"  type="text"  onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" require="true" label="红冲日期"><font class="required-content">*</font>
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

