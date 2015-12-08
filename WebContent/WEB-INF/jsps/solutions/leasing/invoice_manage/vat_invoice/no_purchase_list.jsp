<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发票管理-新建合同未采购清单</title>
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
var currentLoginUserId = "${sessionScope['login_userid']}";
var isAdmin=false;
var tools=[{
	 html : '<font color="blue">进项发票登记 </font>',
		handler : function(table) {
		// importExcelData(table.id,"/acl/addGpsInterfacesInfoUpload.action",importcolumn);
				//showEwlpCustInfo("id");
				var checkedRowDatas = table.getCheckedRowDatas();
				if(0==checkedRowDatas.length){
					alert("请选择要登记的合同！");
					return;
					}
				table.addEntity();
				//operPromitTable="新增";
				jQuery("#creatorname").val('${sessionScope.loginUser.realname}');
				$("#id").val(checkedRowDatas[0].id);
				$("#contractid").val(checkedRowDatas[0].contractid);
				$("#custname").val(checkedRowDatas[0].custname);
				$("#equipamt").val(checkedRowDatas[0].equipamt);
				//JQuery("#id_detailInfoWindowContainer").show();
				//return false;
		},
		iconCls : 'icon-edit_add'
}];
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
tools='';
</script >
</permission:action>

<permission:action  code="tax_account">
<script type="text/javascript">
isAdmin=true;
tools='';
</script >
</permission:action>

<script type="text/javascript">
	var constantFlagTable = "User";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	     var table = new tracywindyOperationTable({
   		 tableComment:'[进项发票信息]',
   		 constantFlagTable:'TaxVatInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'新建合同未采购清单',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/invoice_manage/vat_invoice/no_purchase_list.xml',
         loadMode:'ajax',
         isPage:true,
         tools:tools,
         isFit:true,
         operButtons:'',
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'合同号',name:'contractid',queryConfig:{}},
		            {header:'业务合同号',name:'contractnumber',queryConfig:{}},
		            {header:'客户名称',name:'custname',queryConfig:{}},
		            {header:'设备款',name:'equipamt',type:'double',queryConfig:{isNewLine:true}},
		            {header:'已登记金额',name:'invoicemoney',type:'double',queryConfig:{}},
		            {header:'未登记金额',name:'unrecordmoney',type:'double'},
		            {header:'状态',name:'status',type:'combobox',
		            	queryConfig:{
						//isNewLine:true,
						width:165,
						//colSpan:3, 
						loadMode:'local',
						datas:[
								{title:'已登记',name:'已登记'},
								{title:'部分登记',name:'部分登记'},
								{title:'未登记',name:'未登记'},
								{title:'全部',name:''}
								],
			            displayField:'title',
			            valueField:'name',
			            defaultValue:1
			            }}
	        ]
         
   	 });
   	 
   });
</script>
</head>
<body>
<div id="id_tableContainer"></div>
<center>
<div id="id_detailInfoWindowContainer"  title="进项发票登记信息" style="display:none;width:800px;height:400px">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:90%">
			            <tr style="display:none"><td><input name="id" id="id" type="hidden" value=""/></td></tr>
			            <tr>
			           <td class="input_label_desc" align="left">合同编号:  </td>  
			            	<td class="td-content">
			            	<input type="text" id="contractid" name="contractid" class="td-content-input td-content-readonly"readonly="readonly">
	            			</td>
			            	<td class="input_label_desc" align="left">设备款:  </td>
			            	<td class="td-content">
			            		<input  type="text"  name="equipamt" id="equipamt"  class="td-content-input td-content-readonly"readonly="readonly"/> 
			            	</td>  
			            </tr>
			            	<td class="input_label_desc" align="left">客户名称:  </td>
			            	<td class="td-content" colspan="3">
			            		<input  type="text"  name="custname" id="custname" style="width: 300px" class="td-content-input td-content-readonly"readonly="readonly"/> 
			            	</td>  
			            </tr>
			            <tr>
			            	<td class="input_label_desc" align="left">发票号码:  </td>  
			            	<td class="td-content">
			            		<input  type="text"  name="invoiceNo"   class="td-content-input" require="true" label="发票号码" /><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc" align="left">发票金额:  </td>  
			            	<td class="td-content">
			            		<input  type="text"  name="invoiceMoney"  class="td-content-input" require="true" label="发票金额" datatype="PMoney"><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc" align="left">登记时间:  </td>  
			            	<td class="td-content">
						      <input class="Wdate td-content-input" readonly name="recordDate" class="td-content-input"  type="text" 
							 onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})"  >
							 </td>
				           	<td class="input_label_desc" align="left">登记人:  </td>  
				           	<td class="td-content">
				           		<input name="creatorname" id="creatorname" label="登记人 " class="td-content-input td-content-readonly" readonly="readonly" type="text" /><span class="content-required">*</span>
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
</center>
</div>

</body>
</html>