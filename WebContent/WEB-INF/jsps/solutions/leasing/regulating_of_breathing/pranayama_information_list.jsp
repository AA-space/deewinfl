<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.kernal.utils.DateUtil"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>央行调息管理</title>
    <!--css sheet-->
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/js/my97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/my97DatePicker/WdatePicker.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
    <style type="text/css">
	   html,body{
	     overflow:hidden;
	   }
	</style>
<script type="text/javascript">
    var constantFlagTable = "FundStandardInterest";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		 loadFormDataCallBack:function(table,$form,rowIndex){
   		    getTracywindyObject("id_combo_id_isclose").setRawValue(table.tableData[rowIndex].isclose);
   		 },
   		 tableComment:'央行调息',
   		 constantFlagTable:'FundStandardInterest',
   	    // isNeedEnabled:true,
   	     operButtons:'新增|全局搜索',
   	     border:true,
         renderTo:'id_tableContainer',
         title:'央行基准利率调整表',
         width:pageWidth,
         height:pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/regulating_of_breathing/queryAllAdjustTheBreath.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:false,
         border:true,
         rowColorCallback:
             function(index, rowData) {
	             if("否" == rowData.isclose){
	                 return "#F9A28C";
	             }else{
	            	 return "";
	             }
             },
          tools:[{
         
         	 html : '<font color="red">修改</font>',
  			 handler : function(table) {
  				var adjustValue = table.getCheckedRowDatas();
  				if (0 == adjustValue.length) {
  					alert("请选择需要修改的记录！");
  					return false;
  				}
  				var datas = {};
  		    	datas.id = adjustValue[0]["id"];//项目id,必填
  		    	datas.startdate = adjustValue[0]["startdate"];
  		    	datas.ratehalf = adjustValue[0]["ratehalf"];
  		    	datas.rateone = adjustValue[0]["rateone"];
  		    	datas.ratethree = adjustValue[0]["ratethree"];
  		    	datas.ratefive = adjustValue[0]["ratefive"];
  		    	datas.rateabovefive = adjustValue[0]["rateabovefive"];
  		    	datas.baseratehalf = adjustValue[0]["baseratehalf"];
  		    	datas.baserateone = adjustValue[0]["baserateone"];
  		    	datas.baseratethree = adjustValue[0]["baseratethree"];
  		  	    datas.baseratefive = adjustValue[0]["baseratefive"];
  		  	    datas.baserateabovefive = adjustValue[0]["baserateabovefive"];
  		  	    datas.isclose = adjustValue[0]["isclose"]=="是"?"0":"1";
  		  	    datas.creator = adjustValue[0]["creator"];
  		  	    datas.creatordate = adjustValue[0]["creatordate"];
  		    	//ajax成功提交window
 	 		   	var sheight = window.screen.availHeight-30;
 	 		    var swidth = window.screen.availWidth-10;
  		       ajaxRequest({
 				     url:'${pageContext.request.contextPath}/leasing/acl/updateFundStandardInterest.acl',
 				     method:'POST',
 				     success:function(res){
 					     var data = res.responseText;
 					     if (data == 'error') {
 	 					    alert('该央行基准利率正在调息，不能修改数据！');
							return false;
 	 					 } else{
 					   		 table.updateEntity();
 	 					 }
 				     },
 					 params:datas,
 				     failure:function(res){
 				    	var data = res.responseText;
						alert("acl路径有误");
 	 				     },
 				     async:false
 			    });
 				},
 				iconCls : 'icon-update'
 			} ],
         columns:[
					{header:'序号',name:'id',hidden:true},
		            {header:'利率开始执行日期',name:'startdate',width:100},
		            {header:'利息调整幅度_六月',name:'ratehalf',width:120},
		            {header:'利息调整幅度_1年',name:'rateone',width:120},
		            {header:'利息调整幅度_3年',name:'ratethree',width:120},
		            {header:'利息调整幅度_5年',name:'ratefive',width:120},
		            {header:'利息调整幅度_5年以上',name:'rateabovefive',width:150},
		            {header:'利息央行基准_六月',name:'baseratehalf',width:120},
		            {header:'利息央行基准_1年',name:'baserateone',width:120},
		            {header:'利息央行基准_3年',name:'baseratethree',width:120},
		            {header:'利息央行基准_5年',name:'baseratefive',width:120},
		            {header:'利息央行基准_5年以上',name:'baserateabovefive',width:150},
		            {header:'是否调息结束',name:'isclose'},
		            {header:'创建人',name:'creator'},
		            {header:'创建时间',name:'creatordate'}
	        ]
   	 });
 	/**
 	 * 孙传良[注]
 	 * divContainerDivId:加载的下拉框需要显示到的层ID
 	 * fieldName:下拉框显示出来的输入域的域名
 	 * defaultValue:默认显示值的
 	 * selectFunc:下拉框发生select事件后需要触发的函数
 	 * isContainEmpty:加载的下拉框是否有空选择项
 	 * otherAttributes:其他的附加在输入域上的属性
 	 * width:输入框的宽度
 	 * 如果需要取值 getTracywindyObject 传入'id_combo_'+divContainerDivId
 	 */
 	dictYesOrNoByCode('id_isclose','isclose','',onSelectIsClose,true,'require="true" label="是否调息结束"',191);
   });

	function onSelectIsClose(combo,data){
		var isclose = data.name;
		if("1" == isclose){
			getTracywindyObject("id_combo_id_isclose").setRawValue("否");
			getTracywindyObject("id_combo_id_isclose").setValue("1");
		}else{
			getTracywindyObject("id_combo_id_isclose").setRawValue("是");
			getTracywindyObject("id_combo_id_isclose").setValue("0");
		}
		
	}
	
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="央行利率管理" style="display:none;width:500px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table>
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
			            <tr><td class="input_label_desc" style="width:150px">利率开始执行日期:  </td>  <td class="input_value"><input name="startDate" id="startDate" isDefaultDate="true" label="利率开始执行日期"  class="Wdate td-content-input td-content-readonly"  onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" readOnly   type="text" /><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">利息调整幅度_六月:</td>  <td class="input_value"><input name="ratehalf" require="true" label="利息调整幅度_六月" dataType="text" type="Rate" /><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">利息调整幅度_1年:</td>  <td class="input_value"><input name="rateone" require="true" label="利息调整幅度_1年" dataType="text" type="Rate" /><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">利息调整幅度_3年:</td>  <td class="input_value"><input name="ratethree" type="text" require="true" label="利息调整幅度_3年" dataType="Rate"/><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">利息调整幅度_5年:</td>  <td class="input_value"><input name="ratefive" type="text" require="true" label="利息调整幅度_5年" dataType="Rate"/><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">利息调整幅度_5年以上:</td>  <td class="input_value"><input name="rateabovefive" type="text" require="true"  label="利息调整幅度_5年以上" dataType="Rate"/><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">利息央行基准_六月:</td>  <td class="input_value"><input name="baseratehalf" type="text" require="true"  label="利息央行基准_六月" dataType="Rate"/><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">利息央行基准_1年:</td>  <td class="input_value"><input name="baserateone" type="text" require="true"  label="利息央行基准_1年" dataType="Rate"/><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">利息央行基准_3年:</td>  <td class="input_value"><input name="baseratethree" type="text" require="true"  label="利息央行基准_3年" dataType="Rate"/><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">利息央行基准_5年:</td>  <td class="input_value"><input name="baseratefive" type="text" require="true"  label="利息央行基准_5年" dataType="Rate"/><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">利息央行基准_5年以上:</td>  <td class="input_value"><input name="baserateabovefive" type="text" require="true"  label="利息央行基准_5年以上" dataType="Rate"/><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">是否调息结束:</td>  <td class="input_value"><div class="leftComboContainer" id="id_isclose"></div><span class="content-required">*</span></td></tr>
			            <tr><td class="input_label_desc">创建人:</td>  <td class="input_value"><input name="creator" type="text" require="true" label="创建人" /><span class="content-required">*</span></td></tr>
			            <tr style="display:none"><td>
			            <input name="enabled" type="hidden" value="true"/>
			            <input name="creatordate" type="hidden" isDefaultDate="true"/>
			            <input name="modificator" type="hidden"/>
			            <input name="modifydate" type="hidden"/>
			            </td></tr>
			            <tr class="content-separator">
				            <td colspan='2'>
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