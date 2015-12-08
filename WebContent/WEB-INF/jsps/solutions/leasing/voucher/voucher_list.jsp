<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>凭证信息</title>
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
html, body {
	overflow: hidden;
}
</style>
<script type="text/javascript">
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
		
		var table = new tracywindyOperationTable({
	   		resetFormCallback:function(table,$form,operFlag){
	   		 if("add" == operFlag){
	   			var rowData = table.getRowDataAt(0);
		   	  var select_contract = getTracywindyObject("id_combo_iscardname");
		   	     select_contract.setValue("1");
		   	  
	   	     }
	     	 },
			 
	   		 loadFormDataCallBack:function(table,$form,rowIndex){
		   		 var rowData = table.getRowDataAt(rowIndex);
		   	  	 var select_contract = getTracywindyObject("id_combo_iscardname");
		   	     select_contract.setValue(rowData["iscard"]);
		   
		   	    
		 },
			 tableComment:'凭证信息',
	   		 constantFlagTable:'ContractDebit',
	         renderTo:'id_tableContainer',
	         title:'凭证信息',
	         width:pageWidth,
	         height:pageHeight,
	         id:'id_table',
	         xmlFileName:'eleasing/jsp/voucher/voucher_list.xml',
	         loadMode:'ajax',
	         isPage:true,
	         isFit:false,
	         border:true,
	         isRank:true,
	         lazyLoad:true,
	         isCheck:true,
	         checkType:'checkbox',
	         operButtons:'',
	         tools : [ {
		  			html : '<font color="red">修改</font>',
		  			handler : function(table) {
		 				var voucherIDValue = table.getCheckedRowDatas();
		 				if (0 == voucherIDValue.length) {
		 					alert("请选择需要修改的数据！");
		 					return false;
		 				}
		 				var id = voucherIDValue[0].id;
		 				var URL = "${pageContext.request.contextPath}/leasing/updateInsuranceInfo.action";
			        	var params = {id:id,read_only:false};
			    	    openFullScreenWindow(URL,params);
		 				//window.open("${pageContext.request.contextPath}/leasing/voucher/voucher_mod.bi","_blank");
		  			},
		  			iconCls : 'icon-update'
		  		},
		  		{
		  			html : '<font color="red">导出</font>',
		  			handler : function(table) {
		  				var voucherIDValue = table.getCheckedRowDatas();
		  				var voucherid=new Array();
		  				for (var i=0;i<voucherIDValue.length;i++){
		  					if(voucherIDValue[i].easflag=='已导出'){
		  						alert(voucherIDValue[i].modlename+"的"+voucherIDValue[i].vouchernumber+"凭证状态为已导出，不能再导出");
		  						return false;
		  					}else{
		  						voucherid[i]=voucherIDValue[i].id;
		  					}
		  				}
		  				//alert(voucherid.length);
		  				var params=getQueryAreaParams(table,false);
		  				params.voucherid = JsonUtil.encode(voucherid);
		  				//params.url = 'eleasing/jsp/voucher/voucher_list.xml';
		  				$.post("leasing/toEas.action", params);
		  				//console.info(params);
		  			},
	  				 iconCls : 'icon-add'
	  			 
	  		} ],
	         columns:[
						{header:'id',name:'id',hidden:true},
						{header:'客户名称',name:'custname',queryConfig:{}},
						{header:'业务合同号',name:'contract_number',width:200,queryConfig:{}},
						{header:'经销商名称',name:'dealname',width:200,queryConfig:{}},
						{header:'系统模块',name:'modlename',width:150,type:'combobox',
						queryConfig:{
							   width:165,
						       xmlFileName:'eleasing/jsp/voucher/voucher_status.xml',
						       loadMode:'ajax',
						       readOnly:false,
						       isAjaxLenovo:true,
						       displayField:'name',
						       valueField:'id',
						       isForceModify:true
							
						}},
						{header:'导出备注',name:'easmemo'},
						{header:'摘要',name:'voucherabstract',queryConfig:{isNewLine:true,}},
						{header:'凭证号',name:'vouchernumber',width:150,queryConfig:{}},
						{header:'到账日期',name:'bookeddate',width:150,type:"date",isRange:true,queryConfig:{}},
						{header:'记账日期',name:'bizdate',width:150},
						{header:'凭证字',name:'vouchertype'},
						{header:'财务客户',name:'', renderer:function(value,tableObj,columnName,columnIndex,rowData){
					       	 return "<a href='javascript:void(0);' onclick='showName(\""+rowData.id+"\")'>详情</a>";
				         }},
						{header:'凭证状态',name:'status',type:'combobox',
								 queryConfig:{
									colSpan:1,
									loadMode:'local',
									datas:[{title:'已完整',name:'已完整'},{title:'未完整',name:'未完整'}],
						            displayField:'title',
						            valueField:'name'
									}
							},
						{header:'导出状态',name:'easflag',type:'combobox',
							queryConfig:{
							colSpan:2,
							loadMode:'local',
							datas:[{title:'未导出',name:'0'},{title:'已导出',name:'1'}],
				            displayField:'title',
				            valueField:'name',
				            isNewLine:true,
				            defaultValue:1
							}},
						{header:'操作时间',name:'generatedate',type:"date",isRange:true,queryConfig:{colSpan:2}},
						{header:'导出时间',name:'expdate'},
						{header:'金额',name:'originalamount',queryConfig:{}}
		        ]
   	 });
   });

     	function showName(vouchernumber){
     		var URL = "${pageContext.request.contextPath}/leasing/addInsuranceInfo.action";
        	var params = {vouchernumber:vouchernumber,read_only:false};
    	    openFullScreenWindow(URL,params);
     	   //window.open("${pageContext.request.contextPath}/leasing/addInsuranceInfo.action","_blank");
     	}

     	/*var currentLoadMask;
     	function showName(vouchernumber){
     		
     		
     		    var params = {vouchernumber:vouchernumber};
     	        ajaxRequest({
     	            url:"${pageContext.request.contextPath}/leasing/addInsuranceInfo.action",
     	           params:params,
     	            timeout:30*1000,
     	            method:'POST',
     	            success:function(res){
     	    	   		res=res.responseText;
     	    	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
     		     	    if(res!=''){
         		     	    alert(res);
     		     	    }else{
         		     	    
     		  	    	}
     	            },
     	            
     	            failure:function(res){
     	                jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>服务器通信失败!</div>",'error');
     	                //currentLoadMask.hide();
     	            }
     	       });
     	    
     	}*/
	   
</script>
</head>
<body>
<div id="id_tableContainer"></div>
<div id="id_detailInfoWindowContainer" buttons="#id-dlg-buttons" closed="true" modal="true" title="凭证信息" style="display:none;width:800px;height:400px">
  <center>
    <form id="id_detailInfoForm">
      <table style="width: 90%">
        <tr style="display:none">
          <td colspan="4"><input name="id" type="hidden" value=""/><input name="contractid" type="hidden" value=""/></td>
        </tr>
        <!--  <tr class="tr-even">
          <td class="input_label_desc" align="left">客户名:</td>
          <td class="td-content" colspan="3"><input name="custname" id="custname" style="width:520px"  label="客户名" class="td-content-input td-content-readonly"  readonly type="text" /></td>
        </tr>
        <tr class="tr-even">
          <td class="input_label_desc" align="left">经销商:</td>
          <td class="td-content" colspan="3"><input name="dealername" id="dealername" style="width:520px" label="经销商" class="td-content-input td-content-readonly"  readonly type="text" /></td>
        </tr>
        <tr class="tr-even">
          <td class="input_label_desc" align="left">项目名:</td>
          <td class="td-content" colspan="3"><input name="projectname" id="projectname" style="width:520px" label="项目名" class="td-content-input td-content-readonly"  readonly type="text" /></td>
        </tr>        
        <tr class="tr-even">
          <td class="input_label_desc" align="left">合同号:</td>
          <td class="td-content"><input name="cid" id="cid"   label="合同号" class="td-content-input td-content-readonly"  readonly type="text" /></td>
          <td class="input_label_desc" align="left">业务合同号:</td>
          <td class="td-content"><input name="contractnumber" id="contractnumber"   label="业务合同号" class="td-content-input td-content-readonly"  readonly type="text" /></td>
          </tr>   
        <tr class="tr-odd">
        <td class="input_label_desc" align="left">是否卡扣:</td>
          <td class="td-content"><div style="float: left" class="leftComboContainer"
				id="iscardname"></div>
            <span class="content-required">*</span></td>
          <td class="input_label_desc" align="left">银行卡号:</td>
          <td class="td-content"><input name="cardnum" require="true"  class="td-content-input"
				label="银行卡号" type="text" />
            <span class="content-required">*</span></td>
        </tr>-->
      </table>
    </form>
  </center>
</div>
<div style="text-align:center;width:800px;display:none;height:40px;line-height:40px;" id="id-dlg-buttons">
		  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a> 
		  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
</div>
</body>
</html>