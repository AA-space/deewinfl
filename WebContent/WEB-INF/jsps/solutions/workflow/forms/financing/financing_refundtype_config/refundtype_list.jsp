
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基础信息维护 - 还款方式</title>
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

  		
   		 loadFormDataCallBack:function(table,$form,rowIndex){
   		 var rowData = table.getRowDataAt(rowIndex);
   	     //var select_contract = getTracywindyObject("id_combo_id_unit_property");
  	    // select_contract.setValue(rowData["unitproperty"]);
   	    
        },
   		 tableComment:'[还款方式]',
   		 constantFlagTable:'FinacingRefundType',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'还款方式',
         width:pageWidth,
         height:pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/financing_config/finacing_config_refund_type.xml',
         loadMode:'ajax',
         isPage:true,
         isFit:true,
         columns:[
		            
		            {header:'id',name:'id',hidden:true},
		            {header:'还款方式编号',name:'code'},
		            {header:'还款方式名称',name:'refundname'},
		            {header:'贷款方式',name:'loanname'},
		            {header:'最后更新日期',name:'modifydate'},
		            {header:'操作员',name:'creator'}
	        ]
   	 });
   // 	commonSelectOverall('id_select_contract_id',"(select ci.contract_id,ci.id||'/'||cust.cust_name value from contract_info ci left join cust_info cust on (ci.cust_id=cust.id)) rs",'value',"contract_id",'contractid','','','',selectContract,false);
  //   	dictYesOrNoByCode('id_select_is_insured','isinsured',1,'','','require="true" label="是否投保"');
   });




	jQuery(function(){

	    var all_width = document.body.clientWidth;
		var all_height = document.body.clientHeight;
		//commonSelect('id_crediter','FINANCING_CONFIG_UNIT','UNIT_NAME','ID','crediter',null,null,'lable="授信机构"',190);
			//构建页面中的combox
			//客户类别
			
			var custtype = new tracywindyComboBox({
			       id:'id_combo_custtypename',
			       renderTo:'id_loan_type_name',
			       xmlFileName:'\\eleasing\\jsp\\financing_config\\finacing_config_loan_type_name.xml',
			       loadMode:'ajax',
			       readOnly:false,
				   isContainEmpty:false,
				   otherAttributes:'requerid=true label="贷款类型名称"',
			       name:'loanName',
			       width:160,
			       displayField:'name',//sql里面的显示值
			       valueField:'code',//sql里面的隐藏值
			       leftAdd:0,
			       isCheck:false,
			       params:{
			          pid:'cust_type'
			       }
				   //onSelect:changeCustType
			    });





		
	jQuery("#id_menuDetailInfoForm").show();
	jQuery("#id_menuDetailInfoForm").window({
		   closable:false,
		   top:20
	});
	jQuery("#id_menuDetailInfoForm").window("open");
	});



	   

</script>

 
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="贷款类型" style="display:none;width:350px;padding-top:20px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:90%">
			            <tr>
			            	<input type="hidden" name="id"/>
			            	<td class="input_label_desc"  align="left" width="30%">贷款类型名称:  </td>  
			            	<td class="td-content" colspan="3" >
			            	<div id="id_loan_type_name"></div> <span class="content-required">*</span>
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc"  align="left" width="30%">还款方式编号: </td>  
			            	<td class="td-content" colspan="3">
			            		<input name="code" require="true" label="还款方式编号:"  type="text" /><span class="content-required">*</span>
			            	</td>
			            </tr>
			             <tr>
			            	<td class="input_label_desc"  align="left" width="30%">还款方式名称: </td>  
			            	<td class="td-content" colspan="3">
			            		<input name="refundName" require="true" label="还款方式名称"  type="text" /><span class="content-required">*</span>
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