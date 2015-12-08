
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金测算 - 调息</title>
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
			
		//dictOnSelect('id_unit_property','unitProperty','crediter_type',null,null,'label="授信机构属性" require="true"',true);//授信机构属性

		
   	 var table = new tracywindyOperationTable({

   		resetFormCallback:function(table,$form,operFlag){
   		 if("add" == operFlag){
   			var rowData = table.getRowDataAt(0);
   	   		 //document.getElementById("custname").value=rowData["custname"];
   			//$("#custname").val(rowData["custname"]);
   	     }
     	 },

  			//新增的时候为空，修改的时候把值给附上去
   		 	loadFormDataCallBack:function(table,$form,rowIndex){
   			var rowData = table.getRowDataAt(rowIndex);
   	   		 var rowData = table.getRowDataAt(rowIndex);
   	   		 alert(rowData["adjustFlag"]);
   	   	     var wordindustry = getTracywindyObject("id_combo_id_combo_cust_kind");
   	         wordindustry.setRawValue("是");
        },
   		 tableComment:'[调息]',
   		 constantFlagTable:'FinacingAdjustInterest',
   		 windowTop:30,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'调息',
         width:pageWidth,
         height:pageHeight,
         id:'id_table',
        xmlFileName:'/eleasing/jsp/financing_config/finacing_zjcs_list.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         columns:[
		            
		            {header:'id',name:'id',hidden:true},
		            {header:'开始日期',name:'startdate'},
		            {header:'利息调整幅度1年',name:'rateone'},
		            {header:'利息调整幅度1至3年',name:'ratethree'},
		            {header:'利息调整幅度3至5年',name:'ratefive'},
		            {header:'利息调整幅度5年以上',name:'rateabovefive'}
	        ]
   	 });
   // 	commonSelectOverall('id_select_contract_id',"(select ci.contract_id,ci.id||'/'||cust.cust_name value from contract_info ci left join cust_info cust on (ci.cust_id=cust.id)) rs",'value',"contract_id",'contractid','','','',selectContract,false);
  //   	dictYesOrNoByCode('id_select_is_insured','isinsured',1,'','','require="true" label="是否投保"');
   });
	jQuery(function(){
		//设置是否下拉列表的
	 dictYesOrNoByCode ('id_combo_cust_kind','adjustFlag',
			  '${empty requestScope["adjustFlag"] ? "0" : requestScope["adjustFlag"] }',
			  '',false,' require="true" label="是否调息完成"');
	});


</script>

 
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="调息" style="display:none;width:900px;padding-top:16px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:90%">
			            <tr>
			            	<input type="hidden" name="id"/>
			            	<td class="input_label_desc" >利率开始执行日期</td>  
			            	
			            	<td class="td-content">
			                       <input name="startDate" class="Wdate td-content-input td-content-readonly"  
                      type="text" value="${requestScope['factdate'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="到账时间" /> 
          	            	%<span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc" >是否调息完成</td>  
			            	<td  >
			            	<div class="leftComboContainer"    id="id_combo_cust_kind" style="display:inline-block"  ></div>
			            	 %<span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">本次调整后央行基础利率6个月</td>  
			            	<td  >
			            		<input name="baseRateHalf" require="true" label="本次调整后央行基础利率6个月"  type="text" />%<span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc">本次利息调整幅度6个月</td>  
			            	<td  >
			            		<input name="rateHalf" require="true" label="本次利息调整幅度6个月"  type="text" />%<span class="content-required">*</span>
			            	</td>
			            </tr>
			            
			           
			           <tr>
			            	<td class="input_label_desc">本次调整后央行基础利率1年</td>  
			            	<td class="td-content">
			            		<input name="baseRateOne" require="true" label="本次调整后央行基础利率1年"  type="text" />%<span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc">本次利息调整幅度1年</td>  
			            	<td class="td-content">
			            		<input name="rateOne" require="true" label="本次利息调整幅度1年"  type="text" />%<span class="content-required">*</span>
			            	</td>
			            </tr>
			            
			            <tr>
			            	<td class="input_label_desc">本次调整后央行基础利率1至3年</td>  
			            	<td class="td-content">
			            		<input name="baseRateThree" require="true" label="本次调整后央行基础利率1至3年"  type="text" />%<span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc">本次利息调整幅度1至3年</td>  
			            	<td class="td-content">
			            		<input name="rateThree" require="true" label="本次利息调整幅度1至3年"  type="text" />%<span class="content-required">*</span>
			            	</td>
			            </tr>
			            
			            <tr>
			            	<td class="input_label_desc" >本次调整后央行基础利率3至5年</td>  
			            	<td class="td-content" >
			            		<input name="baseRateFive" require="true" label="本次调整后央行基础利率3至5年"  type="text" />%<span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc" >本次利息调整幅度3至5年</td>  
			            	<td class="td-content" >
			            		<input name="rateFive" require="true" label="本次利息调整幅度3至5年"  type="text" />%<span class="content-required">*</span>
			            	</td>
			            </tr>
			            
			            <tr>
			            	<td class="input_label_desc"  >本次调整后央行基础利率5年以上 </td>  
			            	<td class="td-content" >
			            		<input name="baseRateAbovefive" require="true" label="本次调整后央行基础利率5年以上"  type="text" />%<span class="content-required">*</span>
			            	</td>
			            	<td class="input_label_desc"  >本次利息调整幅度5年以上 </td>  
			            	<td class="td-content" >
			            		<input name="rateAbovefive" require="true" label="本次利息调整幅度5年以上"  type="text" />%<span class="content-required">*</span>
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