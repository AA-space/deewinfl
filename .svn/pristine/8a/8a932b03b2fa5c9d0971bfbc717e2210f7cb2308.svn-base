<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进项发票确认</title>
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
var tools=[{
	 html : '<font color="blue">确认发票清单 </font>',
		handler : function(table) {
		var operType = "确认";
		var operTitle = "进项发票";
		var operAction = "confirmTaxVatInfo";
	 	var checkedRowDatas = table.getCheckedRowDatas();
		var currentLoadMask = null;
     var params = {};
     var tempIdArr = [];
     for(var i = 0;i<checkedRowDatas.length;i++){
			var checkedRowdata = checkedRowDatas[i];
			var id = checkedRowdata.id;
			tempIdArr.push(id);
		}
		params["ids"] = tempIdArr.join(",");
		if(0 == checkedRowDatas.length){
			alert("请选择要"+operType+"的记录！！");
			return;
			}
		for(var i =0;i<checkedRowDatas.length;i++){
				var checkedRawData=checkedRowDatas[i];
				if("已退回"==checkedRawData.invoicestatus){
					alert("该条"+operTitle+"已退回，不允许再次确认！！！");
					return;
					}
				if("已确认"==checkedRawData.invoicestatus){
					alert("该条"+operTitle+"已确认，不允许再次确认！！！");
					return;
					}  
			}
		
		if(!window.confirm(("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？"))) return;
		var loadMaskMsg="正在"+operType+operTitle+"    请稍后... ";
		var url=getRootPath()+"/acl/"+operAction+".acl";
		currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
		currentLoadMask.show();
		ajaxRequest({
         url:url,
         params:params,
         timeout:30*1000,
         success:function(res){//孙传良 修改  显示出action返回值
 	   		res=res.responseText;
 	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
	     	    if(res!=''){
		    	 	alert(res);
	     	    }else{
	     	    	alert(operType+operTitle+"成功！！");
	     	    }
             try{jQuery("#id_detailInfoWindowContainer").window('close');}catch(e){}
             currentLoadMask.hide();
             table.reload();
             //successCallBack(table);
         }
    });
		},
		iconCls : 'icon-ok'
},
{
	 html : '<font color="blue">退回发票清单 </font>',
		handler : function(table) {
	 var operType = "退回";
		var operTitle = "进项发票";
		var operAction = "backTaxVatInfo";
	var checkedRowDatas = table.getCheckedRowDatas();
		var currentLoadMask = null;
     var params = {};
     var tempIdArr = [];
     for(var i = 0;i<checkedRowDatas.length;i++){
			var checkedRowdata = checkedRowDatas[i];
			var id = checkedRowdata.id;
			tempIdArr.push(id);
		}
		params["ids"] = tempIdArr.join(",");
		if(0 == checkedRowDatas.length){
			alert("请选择要"+operType+"的记录！！");
			return;
			}
		for(var i =0;i<checkedRowDatas.length;i++){
			var checkedRawData=checkedRowDatas[i];
			if("已确认"==checkedRawData.invoicestatus){
				alert("该条"+operTitle+"已确认，不允许退回！！！");
				return;
				} 
		}
		if(!window.confirm(("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？"))) return;
		var loadMaskMsg="正在"+operType+operTitle+"    请稍后... ";
		var url=getRootPath()+"/acl/"+operAction+".acl";
		currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
		currentLoadMask.show();
		ajaxRequest({
         url:url,
         params:params,
         timeout:30*1000,
         success:function(res){//孙传良 修改  显示出action返回值
 	   		res=res.responseText;
 	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
	     	    if(res!=''){
		    	 	alert(res);
	     	    }else{
	     	    	alert(operType+operTitle+"成功！！");
	     	    }
             try{jQuery("#id_detailInfoWindowContainer").window('close');}catch(e){}
             currentLoadMask.hide();
             table.reload();
             //successCallBack(table);
         }
    });
		},
		iconCls : 'icon-cancel'
}
  ];
</script >
<permission:action  code="interest_master">
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

<permission:action  code="rent_account">
<script type="text/javascript">
isAdmin=false;
tools=[{
	 html : '<font color="blue">确认发票清单 </font>',
		handler : function(table) {
		var operType = "确认";
		var operTitle = "进项发票";
		var operAction = "confirmTaxVatInfo";
	 	var checkedRowDatas = table.getCheckedRowDatas();
		var currentLoadMask = null;
  var params = {};
  var tempIdArr = [];
  for(var i = 0;i<checkedRowDatas.length;i++){
			var checkedRowdata = checkedRowDatas[i];
			var id = checkedRowdata.id;
			tempIdArr.push(id);
		}
		params["ids"] = tempIdArr.join(",");
		if(0 == checkedRowDatas.length){
			alert("请选择要"+operType+"的记录！！");
			return;
			}
		for(var i =0;i<checkedRowDatas.length;i++){
				var checkedRawData=checkedRowDatas[i];
				if("已退回"==checkedRawData.invoicestatus){
					alert("该条"+operTitle+"已退回，不允许再次确认！！！");
					return;
					}
				if("已确认"==checkedRawData.invoicestatus){
					alert("该条"+operTitle+"已确认，不允许再次确认！！！");
					return;
					}  
			}
		
		if(!window.confirm(("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？"))) return;
		var loadMaskMsg="正在"+operType+operTitle+"    请稍后... ";
		var url=getRootPath()+"/acl/"+operAction+".acl";
		currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
		currentLoadMask.show();
		ajaxRequest({
      url:url,
      params:params,
      timeout:30*1000,
      success:function(res){//孙传良 修改  显示出action返回值
	   		res=res.responseText;
	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
	     	    if(res!=''){
		    	 	alert(res);
	     	    }else{
	     	    	alert(operType+operTitle+"成功！！");
	     	    }
          try{jQuery("#id_detailInfoWindowContainer").window('close');}catch(e){}
          currentLoadMask.hide();
          table.reload();
          //successCallBack(table);
      }
 });
		},
		iconCls : 'icon-ok'
},
{
	 html : '<font color="blue">退回发票清单 </font>',
		handler : function(table) {
	 var operType = "退回";
		var operTitle = "进项发票";
		var operAction = "backTaxVatInfo";
	var checkedRowDatas = table.getCheckedRowDatas();
		var currentLoadMask = null;
  var params = {};
  var tempIdArr = [];
  for(var i = 0;i<checkedRowDatas.length;i++){
			var checkedRowdata = checkedRowDatas[i];
			var id = checkedRowdata.id;
			tempIdArr.push(id);
		}
		params["ids"] = tempIdArr.join(",");
		if(0 == checkedRowDatas.length){
			alert("请选择要"+operType+"的记录！！");
			return;
			}
		for(var i =0;i<checkedRowDatas.length;i++){
			var checkedRawData=checkedRowDatas[i];
			if("已确认"==checkedRawData.invoicestatus){
				alert("该条"+operTitle+"已确认，不允许退回！！！");
				return;
				} 
		}
		if(!window.confirm(("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？"))) return;
		var loadMaskMsg="正在"+operType+operTitle+"    请稍后... ";
		var url=getRootPath()+"/acl/"+operAction+".acl";
		currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
		currentLoadMask.show();
		ajaxRequest({
      url:url,
      params:params,
      timeout:30*1000,
      success:function(res){//孙传良 修改  显示出action返回值
	   		res=res.responseText;
	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
	     	    if(res!=''){
		    	 	alert(res);
	     	    }else{
	     	    	alert(operType+operTitle+"成功！！");
	     	    }
          try{jQuery("#id_detailInfoWindowContainer").window('close');}catch(e){}
          currentLoadMask.hide();
          table.reload();
          //successCallBack(table);
      }
 });
		},
		iconCls : 'icon-cancel'
}
];
</script >
</permission:action>


<script type="text/javascript">
    var constantFlagTable = "User";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		
   		 tableComment:'进项发票',
   		 constantFlagTable:'TaxVatInfo',
   		 windowTop:20,
   		 isfit:false,
   	     border:true,
   	     isCheck:true,
   	     checkType:'checkbox',
         renderTo:'id_tableContainer',
         title:'进项发票确认',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/invoice_manage/vat_invoice/vat_invoice_confirm.xml',
         loadMode:'ajax',
         isPage:true,
         operButtons:'',
         tools:tools,
         isFit:true,
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'发票号码',name:'invoiceno',queryConfig:{}},
		            {header:'合同号',name:'contractid',queryConfig:{}},
		            {header:'合同总金额',name:'equipamt',type:'double',precise:'2'},
		            {header:'发票总金额',name:'invoicemoney',type:'double',precise:'2',queryConfig:{}},
		            {header:'税额',name:'taxmoney',type:'double',precise:'2'},
		            {header:'状态',name:'invoicestatus',type:'combobox',
		            	queryConfig:{
						isNewLine:true,
						colSpan:3, 
						loadMode:'local',
						datas:[
								{title:'已导出',name:'已导出'},
								{title:'已确认',name:'已确认'},
								{title:'已退回',name:'已退回'},
								{title:'不生成',name:'生成'},
								{title:'确认中',name:'确认中'},
								{title:'未提交',name:'未提交'},
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
	    	dict('id_contractnum','proj_info.projtype','root_null_ini','${requestScope["proj_info.projtype"]}','${requestScope["rawValue_proj_info.projtype"]}','');
	    });
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  title="添加项发票登记信息" style="display:none;width:800px;height:400px">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:90%">
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
			            <tr>
			           <td class="input_label_desc" align="left">合同编号:  </td>  
			            	<td class="td-content">
	            			<div class="leftComboContainer" id="id_contractnum"></div>	  
	            			</td>
			            	<td class="input_label_desc" align="left">客户名称:  </td>
			            	<td class="td-content">
			            		<input  type="text"  name="column2"   class="td-content-input"readonly="readonly"/> 
			            	</td>  
			            </tr>
			            <tr>
			            	<td class="input_label_desc" align="left">张数:  </td>  
			            	<td class="td-content">
			            		<input  type="text"  name="column3"   class="td-content-input" require="true" label="张数" datatype="Number"/><span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc" align="left">金额:  </td>  
			            	<td class="td-content">
			            		<input  type="text"  name="column4"  class="td-content-input" require="true" label="金额" datatype="Number"><span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc" align="left">登记时间:  </td>  
			            	<td class="td-content">
						      <input class="Wdate td-content-input" readonly name="column5" class="td-content-input"  type="text" 
			 onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})"  >
			 </td>
           	<td class="input_label_desc" align="left">登记人:  </td>  
           	<td class="td-content">
           		<input type="text" name="column6"  class="td-content-input" require="true" label="邮编" datatype="Zip" /><span class="content-required">*</span>
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