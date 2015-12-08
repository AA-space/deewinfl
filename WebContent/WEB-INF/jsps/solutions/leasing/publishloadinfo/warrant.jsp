<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>   
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>担保信息</title>
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
    var constantFlagTable = "ContractDocInfo";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
		
		 
		var table = new tracywindyOperationTable({
			 
			 tableComment:'担保信息 ',
	   		 constantFlagTable:'ContractDocInfo',
	         renderTo:'id_tableContainer',
	         title:'担保信息 ',
	         width:pageWidth,
	         height:pageHeight,
	         id:'id_table',
	         xmlFileName:'/eleasing/jsp/other/lawsuit/list.xml',
	         loadMode:'ajax',
	         isPage:true,
	         border:true,
	         isRank:true,
	         //isFit:true,
	         columns:[
						
				{name:'id',  header:'id',hidden:true},
				{name:'tablename1',  header:'投保人全称',width:140},
				{name:'tablename2',  header:'投保人证件类型',width:140},
				{name:'tablename3',  header:'投保人证件号',width:140},
				{name:'tablename4',  header:'被保险人全称',width:140},
				{name:'tablename1',  header:'被保险人证件类型',width:140},
				{name:'tablename2',  header:'被保险人证件号',width:140},
				{name:'tablename3',  header:'行驶证车主',width:140},
				{name:'tablename4',  header:'品牌型号',width:140},
				{name:'tablename1',  header:'性质',width:140},
				{name:'tablename2',  header:'车牌号（旧车）',width:140},
				{name:'tablename3',  header:'初次登记日期',width:140},
				{name:'tablename4',  header:'核定载客/整备质量',width:140},
				{name:'tablename1',  header:'车辆类型',width:140},
				{name:'tablename2',  header:'车辆/挂车购置价格',width:140},
				{name:'tablename3',  header:'整车合计价格',width:140},
				{name:'tablename4',  header:'发动机号',width:140},
				{name:'tablename1',  header:'车架号',width:140},
				{name:'tablename2',  header:'保险期间',width:140},
				{name:'tablename3',  header:'第一受益人',width:140},
				{name:'tablename4',  header:'第二受益人',width:140},
				{name:'tablename1',  header:'机动车损失保险及不计免赔特约',width:140},
				{name:'tablename2',  header:'第三者责任保险及不计免赔特约',width:140},
				{name:'tablename3',  header:'全车盗抢损失险及不计免赔特约',width:140},
				{name:'tablename4',  header:'车上人员责任险',width:140},
				{name:'tablename1',  header:'车上人员责任不计免赔特约',width:140},
				{name:'tablename2',  header:'车船税',width:140},
				{name:'tablename3',  header:'自燃险',width:140},
				{name:'tablename4',  header:'交强险',width:140},
				{name:'tablename1',  header:'玻璃单独破碎险',width:140},
				{name:'tablename2',  header:'玻璃单独破碎险',width:140},
				{name:'tablename3',  header:'附加险不计免赔特约险',width:140},
				{name:'tablename4',  header:'保险公司名称',width:140},
				{name:'tablename4',  header:'联系方式',width:140},
				{name:'tablename4',  header:'折扣',width:140},
				{name:'tablename4',  header:'备注',width:140},
				{name:'tablename4',  header:'经销商',width:140},
				{name:'tablename4',  header:'联系方式',width:140},
				{name:'tablename4',  header:'联系人', width:140}
				
		        ]
   	 });
   	 
   });

	/*jQuery(function(){
    	dict('num','proj_info.projtype','root_null_ini','${requestScope["proj_info.projtype"]}',null,'');
    	dict('contractidnum','proj_info.projtype','root_null_ini','${requestScope["proj_info.projtype"]}',null,'');
    });
*/
	
</script>
</head>
<body>
<div id="id_tableContainer"></div>
<div id="id_detailInfoWindowContainer" title="添加" style="display: none; width: 800px; height: 400px">
<center>
<form id="id_detailInfoForm">
<table style="width: 90%">
	 	<tr>
	 	<td colspan="4">&nbsp;</td>
	 	</tr>
		<tr>
			<td class="input_label_desc" align="left">投保人全称：</td>
				<td class="td-content">
           		<input  type="text"  name="column3"   class="td-content-input" require="true" label="客户名称"  maxB="8" /><span class="content-required">*</span>
           	</td>
			<td class="input_label_desc" align="left">投保人证件类型:</td>
				<td class="td-content">
           		<input  type="text"  name="column3"   class="td-content-input" require="true" label="客户名称"  maxB="8" /><span class="content-required">*</span>
           	</td>
		</tr>
		<tr>
		<td class="input_label_desc" align="left">投保人证件号:  </td>  
           	<td class="td-content">
           		<input  type="text"  name="column3"   class="td-content-input" require="true" label="客户名称"  maxB="8" /><span class="content-required">*</span>
           	</td>
           	
	      	</tr>
		<tr>
			<td class="input_label_desc" align="left">被保险人全称:</td>
			<td class="td-content">
           		<input   type="text"  name="column4"  class="td-content-input" require="true"  ><span class="content-required">*</span>
           	</td>		
			<td class="input_label_desc" align="left">被保险人证件类型:</td>
			<td class="td-content">
           		<input   type="text"  name="column4"  class="td-content-input" require="true"  ><span class="content-required">*</span>
           	</td>
		</tr>
		<tr>
			<td class="input_label_desc" align="left">被保险人证件号:</td>
			<td class="td-content">
           		<input   type="text"  name="column4"  class="td-content-input" require="true"  ><span class="content-required">*</span>
           	</td>

		</tr>
		<tr>
			<td class="input_label_desc" align="left">行驶证车主:</td>
			<td class="td-content">
           		<input   type="text"  name="column4"  class="td-content-input" require="true"  ><span class="content-required">*</span>
           	</td>		
			<td class="input_label_desc" align="left">品牌型号:</td>
			<td class="td-content">
           		<input   type="text"  name="column4"  class="td-content-input" require="true"  ><span class="content-required">*</span>
           	</td>
		</tr>
		<tr>
			<td class="input_label_desc" align="left">性质:</td>
			<td class="td-content">
           		<input   type="text"  name="column4"  class="td-content-input" require="true"  ><span class="content-required">*</span>
           	</td>		
			<td class="input_label_desc" align="left">车牌号（旧车）:</td>
			<td class="td-content">
           		<input   type="text"  name="column4"  class="td-content-input" require="true"  ><span class="content-required">*</span>
           	</td>
		</tr>
		<tr>
			<td class="input_label_desc" align="left">初次登记日期:</td>
			<td class="td-content">
           		<input   type="text"  name="column4"  class="td-content-input" require="true"  ><span class="content-required">*</span>
           	</td>		
			<td class="input_label_desc" align="left">核定载客/整备质量:</td>
			<td class="td-content">
           		<input   type="text"  name="column4"  class="td-content-input" require="true"  ><span class="content-required">*</span>
           	</td>
		</tr>
		<tr>
			<td class="input_label_desc" align="left">车辆类型:</td>
			<td class="td-content">
           		<input   type="text"  name="column4"  class="td-content-input" require="true"  ><span class="content-required">*</span>
           	</td>		
			<td class="input_label_desc" align="left">车辆/挂车购置价格:</td>
			<td class="td-content">
           		<input   type="text"  name="column4"  class="td-content-input" require="true"  ><span class="content-required">*</span>
           	</td>
		</tr>

		
</table>
</form>
</center>
</div>

</body>
</html>