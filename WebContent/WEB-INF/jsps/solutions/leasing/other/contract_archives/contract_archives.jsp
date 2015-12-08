<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同归档</title>
<!--css sheet-->
<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
<style type="text/css">
html,body {
	overflow: hidden;
}

.x-panel-table-div input[type="text"] {
	border: 1px solid #DDD;
	width: 90%;
}
</style>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyMultiTable.js"></script>


<script type="text/javascript">
    var constantFlagTable = "ContractDocInfo";
	var pageWidth  = document.documentElement.clientWidth-2;
	var formWidth  = pageWidth ;
	var pageHeight = document.documentElement.clientHeight-2;
	
	var contract_id  = '';
	var equipAmt = 0;
	
	jQuery(function(){
		var table = new tracywindyOperationTable({
			 tableComment:'合同归档',
	   		 constantFlagTable:'ContractDocInfo',
	         renderTo:'id_tableContainer',
	         title:'合同归档',
	         width:pageWidth,
	         id:'id_tables',
	         height:pageHeight,
	         windowTop:2,
	         id:'id_table',
	         xmlFileName:'/eleasing/jsp/other/contract_file/list.xml',
	         loadMode:'ajax',
	         isPage:true,
	         isFit:true,
	         border:true,
	         isRank:true,
	         operButtons:'修改',
	         loadFormDataCallBack : function(table,form,flag){
	        	 contractinfo = table.getCheckedRowDatas();
	        	 
	 	    	var custinfo = getTracywindyObject('id_combo_cust');//合同
		    	custinfo.setValue(contractinfo[0].custid);
	 	    	
		    	//设置档案
    			var contract = getTracywindyObject('id_combo_proj');
		    	//contract.value="";
		    	contract.setValue(contractinfo[0].id);
    			contract.setRawValue(contractinfo[0].contractid);
	         },
	         resetFormCallback : function(table,form,flag){
	        	if(flag == 'add'){
	        		contract_id = '';
	        		var contract = getTracywindyObject('contract_doc_send_info');//租赁物件
			    	contract.setParam("contract_id",contract_id);
			    	contract.reload();
	        	}
	        	if(flag == 'update'){
	        		contractinfo = table.getCheckedRowDatas();
	        		if (0 == contractinfo.length) {
	        			alert("请选择需要的合同");	
	        		} else {
				    	//设置用户
				    	//custinfo.reload();
				    	//设置合同
				    	//var cust_id=combo.getValue();
				    	
				    	
				    	//设置档案
	        			var contract = getTracywindyObject('contract_doc_send_info');
				    	contract.setParam("contract_id",contractinfo[0].id);
				    	contract.value="";
				    	contract.reload();
				    	
				    	$('#contract_id').html(contractinfo[0].contractid);
			    		$('#cust_name').html(contractinfo[0].custname);
			    		$('#dealer').html(contractinfo[0].dealername);
			    		$('#date').html(contractinfo[0].signdate);
				    	
			    		
				    	/* getTracywindyObject('id_combo_cust').readOnlyData =true;
				    	getTracywindyObject('id_combo_cust').reload();
				    	getTracywindyObject('id_combo_proj').readOnlyData =true;
				    	getTracywindyObject('id_combo_proj').reload(); */
				    	
				    	
	        		}
	        	}
	         },
	         
	         columns:[
						{header:'合同编号',name:'contractid',queryConfig:{}},
						{header:'合同id',name:'id',hidden:true},
						{header:'合同号',name:'contractnumber',queryConfig:{}},
						{header:'业务模式',name:'businessmode'},
						{header:'客户名称',name:'custname',queryConfig:{}},
						//{header:'合同档案名称',name:'id'},
						//{header:'合同对方',name:'id'},
						{header:'合同金额（元）',name:'eqiupamt'},
						{header:'文档具体柜号',name:'docnumber'}
						
		        ]
   	 });
   });
	 jQuery(function(){
		 /* dictOnSelect('id_contractnum','root_null_ini_1','root_null_ini');
		 dictOnSelect('id_condition_state','root_null_ini_2','root_null_ini'); */
		 
		 //选用户
		 combo_cust = new tracywindyComboBox({
			    id:'id_combo_cust',
			    width:165,
			    renderTo:'id_cust_name',
			    xmlFileName:'\\eleasing\\workflow\\public\\comboCustSelect.xml',
			    loadMode:'ajax',
			    readOnly:false,
			    isAjaxLenovo:true,
			    dropListHeight:300,
			    readOnlyData :true,
			    topAdd:0,
			    leftAdd:0,
			    positionDropIconLeftAdd:-1,
			    name:'cust_info',
			    displayField:'name',
			    valueField:'value',
			    params:{
			    	custType:'cust_type.cust'
			    },
			    onSelect:function(combo){
			    	var cust_id=combo.getValue();
			    	var combo_proj = getTracywindyObject('id_combo_proj');//合同
			       	//combo_proj.setParams({"custID":cust_id});
			    	combo_proj.setValue('');
			       	combo_proj.setParam("custID", cust_id);
			       	combo_proj.reload();
			    }
			 });
		 
		 //选合同
			combo_proj = new tracywindyComboBox({
			    id:'id_combo_proj',
			    width:165,
			    renderTo:'id_proj_name',
			    xmlFileName:'\\eleasing\\workflow\\contract\\contractSelect.xml',
			    loadMode:'ajax',
			    readOnly:false,
			    isAjaxLenovo:true,
			    dropListHeight:300,
			    readOnlyData :true,
			    topAdd:0,
			    leftAdd:0,
			    positionDropIconLeftAdd:-1,
			    name:'proj_info',
			    displayField:'name',
			    valueField:'value',
			    params:{
			    },
			    onSelect:function(combo){
			    	var contract_id = combo.getValue();
			    	var contract = getTracywindyObject('contract_doc_send_info');//租赁物件
			    	contract.setParam("contract_id",contract_id);
			    	contract.reload();
			    }
			 });
	    });
	 
	 
	 
jQuery(function(){
	new tracywindyTable({
	    renderTo:'id_table_leasing_contract_doc_send_info',
	    width:782,
	    id:'contract_doc_send_info',
	    height:250,
	    emptyChar : '',
	    //displayToggleContainer:'id_detailInfoWindowContainer',
	    //isFit:true,displayToggleContainer
	    isNeedTools:false,
	    xmlFileName:'\\eleasing\\workflow\\contract\\doc_send_info.xml',
	    loadMode:'ajax',
	     params : {
	    	 contract_id : contract_id,
	    	 equipAmt : equipAmt
	     },
	     isChecked :false,
	     completeCallBack:function(){
		    	var data, datas = this.tableData;
		    	if(datas && datas.length > 0){
		    		data = datas[1];
		    	}
		    	if(data){
		    		$('#businessmode').val(data.businessmode);
		    		$('#signdate').val(data.signdate);
		    		$('#equipinfo').val(data.equipinfo);
		    		$('#docnumber').val(data.docnumber);
		    	}
		    	
		 },
	    //tools:'修改',
	    //windowContainerIdTable : 
	    columns:[
	       {name:'id',  header:'id', hidden:true},
	       {name:'contractid',  header:'contractid',hidden:true},
	       {name:'docname',  header:'docname',hidden:true},
	       {name:'rowvalue_docname', header:'合同档案名称',readOnly:true},
	       {name:'contractperson', width:70,  header:'合同对方'},
	       {name:'totalprice', width:102,  header:'合同金额',readOnly:true},
	       {name:'docnumber',  header:'归档号', readOnly:true},
	       {name:'docpart', width:70, header:'合同份数'},
	       {name:'contracta', width:120, header:'我方签约人'},
	       {name:'contractb', header:'对方签约人'},
	       {name:'sendpart',  header:'寄送份数',width:50},
	       {name:'sendno',  header:'快递单号'}
	     ]
	 });
	 
});


	function submitData() {
	   var docNumber = $('#docnumber').val();
	   if (!docNumber) {
			alert('请输入归档号');
			return;
		}
		var cid= $("#cid").val();
		var param = {};
		param.docNumber=docNumber;
		param.contract_id=cid;
		
	 	$.post('leasing/docSendSave2.action', param, function(data) {
			if (data == 'yes') {
				alert("保存成功");
				jQuery("#id_detailInfoWindowContainer").window("close");
			}else
			{
				alert("保存失败!");
			}
	    	getTracywindyObject('id_table').reload();
		}); 
	}
</script>
</head>
<body>
	<div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer" buttons="#id-dialog-buttons" title="添加合同登记信息" style="display: none; width: 800px; height: 450px; overflow: hidden;">
		<center>
			<form id="id_detailInfoForm">
				<table style="width: 100%">
					<tr style="display: none">
						<td><input name="id" id="cid" type="hidden" value="" /></td>
					</tr>
					<tr>
						<td class="input_label_desc" align="left">客户名称:</td>
						<td class="td-content"><div id="id_cust_name"  style="float: left;"></div>
							<span class="content-required">*</span></td>
						<td class="input_label_desc" align="left">业务模式:</td>
						<td class="td-content"><input id="businessmode" type="text" name="businessmode" class="td-content-input td-content-readonly" readonly /></td>
					</tr>
					<tr>
						<td class="input_label_desc" align="left">合同编号:</td>
						<td class="td-content">
							<div id="id_proj_name"  style="float: left;"></div>
						</td>
						<td class="input_label_desc" align="left">标的物详情:</td>
						<td class="td-content"><input type="text" id="equipinfo" name="equipinfo" class="td-content-input td-content-readonly" " readOnly="true" label="标的物详情"></td>
					</tr>

					<tr>
						<td class="input_label_desc" align="left">合同签订日期:</td>
						<td class="td-content"><input class="td-content-input td-content-readonly" id='signdate' name="signdate" readonly name="column4" type="text"></td>
						<td class="input_label_desc" align="left">备注:</td>
						<td class="td-content"><input type="text" class="td-content-input td-content-readonly" require="true" label="备注"></td>
					</tr>
					<tr>
						<td><a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='documentShow();'><span>归档</span></a></td>
						<td><input type="text" id="docnumber"><span class="content-required">柜号*</span></td>
					</tr>	
					<tr>
						<td colspan="4" style="height: 1px; border: 0px; padding: 0px; margin: 0px;"><hr style="height: 1px; padding: 0px; margin: 0px;" /></td>
					</tr>
					<tr>
						<td class="td-content" colspan="4" align="left">
							<div id="id_table_leasing_contract_doc_send_info" style="overflow: hidden;"></div>
						</td>
					</tr>
				</table>
			</form>
		</center>
	</div>
	<div id="id-dialog-buttons" style="height: 30px; display: none; line-height: 30px; width: 800px; text-align: center;">
		<table width="100%">
			<tr style="text-align: center">
				<td colspan='4'><a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='submitData();'><span>确定</span></a> <a style="margin-left: 20px;"
					href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'
				><span>取消</span></a></td>
			</tr>
		</table>
	</div>
	<script type="text/javascript">

	 function	 documentShow(){
		var table = getTracywindyObject("contract_doc_send_info");
			var data = table.getRowsJsonData();
			var docStrArray = [];
			if(data && data.length > 0){
				for(var j=0; j< data.length; j++){
					docStrArray.push('<input type="checkbox" value="'+data[j]['rowvalue_docname']+'"/> '+ data[j]['rowvalue_docname']+'<br>');
				}
				
				
			}
			
			$('#doclist').html(docStrArray.join(''));
			
			

 			var $window = $("#id_thisDocumentArchives");
			$window.show();
			$window.dialog({
				top : 20,
				autoScroll : true
			});
			$window.dialog('open'); 
		}

		function print() {
			alert("还没有添加打印功能呢,亲.");
		}
		function printDocumentArchives(){
			window.open ('${pageContext.request.contextPath}/leasing/other/contract_archives/printPreview.bi', '_blank', 'height=550, width=800, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no') 
			//window.open("${pageContext.request.contextPath}/leasing/other/contract_archives/printPreview.bi");
	    }
	</script>

	<div id="id_thisDocumentArchives" title="归档" style="display: none; width: 800px; height: 550px">
		<center>
			<table style="width: 100%" align="left">
				<tr>
					<td>合同号</td>
					<td style="text-align:left;"><span id="contract_id"></span></td>
					<td colspan='4'><a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='printDocumentArchives();'><span id='id_btn_printPreview'>打印预览</span></a></td>
				</tr>
				<tr>
					<td>客户名</td>
					<td style="text-align:left;"><span id="cust_name" ></span></td>
				</tr>
				<tr>
					<td>经销商</td>
					<td style="text-align:left;"><span  id="dealer" ></span></td>
				</tr>
				<tr>
					<td>登记日期</td>
					<td style="text-align:left;"><span id="date"></span></td>
				</tr>
				<tr>
					 <td colspan="2" style="height: 1px; border: 0px; padding: 0px; margin: 0px;"><hr style="height: 1px; padding: 0px; margin: 0px;" /></td>
				</tr>
				<tr >
					<td>合同档案</td>
					<td id="doclist" style="text-align:left;">
					<!-- 	<input type="checkbox" /> 租赁物买卖合同<br>
						<input type="checkbox" /> 担保函   <br> 
						<input type="checkbox" /> 车辆所有权确认协议<br> 
						<input type="checkbox" /> 车辆所有权确认协议<br>
						<input type="checkbox" /> 物流运输费用结算合同<br> 
						<input type="checkbox" /> 保单原件<br> 
						<input type="checkbox" /> 复印件<br> 
						<input type="checkbox" /> 车辆证书<br> 
						<input type="checkbox" />承租人基本资料<br> 
						<input type="checkbox" /> 担保人基本资料<br>
						<input type="checkbox" /> 车辆发票</td> -->
					</td>
				</tr>
			</table>
		</center>
	</div>
</body>
</html>