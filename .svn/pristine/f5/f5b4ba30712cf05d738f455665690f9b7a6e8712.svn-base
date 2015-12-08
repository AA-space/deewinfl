<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>其它功能 - 合同扣款卡号维护</title>
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
		dictYesOrNoByCode('iscardname','iscard',null,function(combox, data){
			//下拉不是卡扣,”银行卡号”、“银行”、“户名”都应该颜色样式变暗
			if(data['name'] == '0'){
				$('#id_bank_blank').hide().removeAttr('name');
				$('#id_bankname').show();
				$('#cardnum').removeClass('td-content-input td-content-readonly');
				$('#cardname').removeClass('td-content-input td-content-readonly');
				$('#cardnum').removeAttr('readonly');
				$('#id_bank_blank').removeAttr('readonly');
				$('#cardname').removeAttr('readonly');
				$('#cardnum').attr({require:"true"});
			}else
			{
				$('#cardnum').addClass('td-content-input td-content-readonly');
			   	$('#cardname').addClass('td-content-input td-content-readonly');
				$('#cardnum').attr({readonly:'readonly'});
				$('#cardnum').removeAttr('require');
				$('#cardname').attr({readonly:'readonly'});
			}
		},null,'require="true" label="是否卡扣"');//是否卡扣
		dictOnSelect('id_bankname','bankname','card_hire_bank',null,null,'label="银行"',true,null, true); // require="true" 记录类型
		
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
			   	 $('#cardnum').addClass('td-content-input td-content-readonly');
			   	 $('#id_bank_blank').addClass('td-content-input td-content-readonly');
			   	 $('#cardname').addClass('td-content-input td-content-readonly');
			   	 $('#cardnum').attr({readonly:'readonly'});
			   	 $('#id_bank_blank').attr({readonly:'readonly'});
			   	 $('#cardname').attr({readonly:'readonly'});
		   	     if(rowData["iscard"] == '1'){
			   	  	$('#id_bank_blank').show().attr('name','bankname');
					$('#id_bankname').hide();
		   	     }
		   	     
		   	     var blankData = rowData["bankname"] || '';
		   		if(rowData["iscard"] == '0' || blankData.indexOf('card_hire_bank') != -1){
					$('#id_bank_blank').hide().removeAttr('name');
					$('#id_bankname').show();
					var select_blankname = getTracywindyObject("id_combo_id_bankname");
					select_blankname.setRawValue(rowData["bankname"]);
				}
		 },
			 tableComment:'合同扣款卡号维护',
	   		 constantFlagTable:'ContractDebit',
	         renderTo:'id_tableContainer',
	         title:'合同扣款卡号维护',
	         width:pageWidth,
	         height:pageHeight,
	         id:'id_table',
	         xmlFileName:'/eleasing/jsp/other/contract_debit/list.xml',
	         loadMode:'ajax',
	         isPage:true,
	         isFit:false,
	         isExcel:true,
	         border:true,
	         isRank:true,
	         operButtons:'修改|全局搜索',
	         
	         params:{
	 			 queryText:unescape(decodeURIComponent("${param.queryText}"))
	          },
	         columns:[
						{header:'id',name:'id',hidden:true},
						{header:'cid',name:'contractid',hidden:true},
						{header:'客户名称',name:'custname',width:150,queryConfig:{}},
						{header:'身份证号码',name:'idcard',width:150,queryConfig:{}},
						{header:'经销商名称',name:'dealername',width:200,queryConfig:{}},
						{header:'合同号',name:'cid'},
						{header:'业务合同号',name:'contractnumber',width:150,queryConfig:{isNewLine:true}},
						{header:'项目名称',name:'projectname',width:300,queryConfig:{}},
						{header:'是否卡扣',name:'iscardname',type:'combobox',hiddenName:'iscard',queryConfig:{
							   loadMode:'local',
							   isNewLine:true,
						       datas:[{title:'是',name:'0'},{title:'否',name:'1'}],
				 		       isAjaxLenovo:true,    
				 		       readOnly:false,
				 		       width:165,
				 		       displayField:'title',
				 		       valueField:'name'
					 		   }},
						{header:'是否卡扣id',name:'iscard',hidden:true},
						{header:'银行名称',name:'bankname',queryConfig:{}},
						{header:'卡扣录入日期',name:'shdate',type:'date',isRange:true,queryConfig:{}},
						{header:'户名',name:'cardname'},
						{header:'卡号',name:'cardnum'},
						{header:'备注',name:'memo'}
		        ]
   	 });
   });
</script>
</head>
<body>
<div id="id_tableContainer"></div>
<div id="id_detailInfoWindowContainer" buttons="#id-dlg-buttons" closed="true" modal="true" title="合同扣款卡号维护信息" style="display:none;width:800px;height:400px">
  <center>
    <form id="id_detailInfoForm">
      <table style="width: 90%">
        <tr style="display:none">
          <td colspan="4"><input name="id" type="hidden" value=""/><input name="contractid" type="hidden" value=""/></td>
        </tr>
        <tr class="tr-even">
          <td class="input_label_desc" align="left">客户名:</td>
          <td class="td-content" colspan="3"><input name="custname" id="custname" style="width:520px"  label="客户名" class="td-content-input td-content-readonly"  readonly type="text" /></td>
        </tr>
        <tr class="tr-even">
          <td class="input_label_desc" align="left">身份证号码:</td>
          <td class="td-content" colspan="3"><input name="idcard" id="idcard" style="width:520px"  label="身份证号码" class="td-content-input td-content-readonly"  readonly type="text" /></td>
        </tr>
        <tr class="tr-even">
          <td class="input_label_desc" align="left">经销商:</td>
          <td class="td-content" colspan="3"><input name="dealername" id="dealername" style="width:520px" label="经销商" class="td-content-input td-content-readonly"  readonly type="text" /></td>
        </tr>
        <tr class="tr-even">
          <td class="input_label_desc" align="left">项目名:</td>
          <td class="td-content" colspan="3"><input name="projectname" id="projectname" style="width:520px"  label="项目名" class="td-content-input td-content-readonly"  readonly type="text" /></td>
        </tr>        
        <tr class="tr-even">
          <td class="input_label_desc" align="left">合同号:</td>
          <td class="td-content"><input name="cid" id="cid"   label="合同号" class="td-content-input td-content-readonly"  readonly type="text" /></td>
          <td class="input_label_desc" align="left">业务合同号:</td>
          <td class="td-content"><input name="contractnumber" id="contractnumber"   label="业务合同号" class="td-content-input td-content-readonly"  readonly type="text" /></td>
          </tr>   
        <tr class="tr-odd">
        <td class="input_label_desc" align="left">是否卡扣:</td>
          <td class="td-content"><div style="float: left" class="leftComboContainer" id="iscardname"></div>
            <span class="content-required">*</span></td>
          <td class="input_label_desc" align="left">银行卡号:</td>
          <td class="td-content"><input name="cardnum" id="cardnum"  class="td-content-input"
				label="银行卡号" type="text" />
            <span class="content-required">*</span></td>
        </tr>
        
        <tr class="tr-even">
        <td class="input_label_desc" align="left">银行:</td>
          <td class="td-content">
          	<input name="bankname" id="id_bank_blank" class="td-content-input" label="银行" type="text" />
          	<div id="id_bankname" style="display:none;"></div>
          	<span class="content-required">*</span>
		  </td>
          <td class="input_label_desc" align="left">户名:</td>
          <td class="td-content">
          <input name="cardname" id="cardname" class="td-content-input" label="户名" type="text" />
          </td>
        </tr>
        
        <tr class="tr-even">
          <td class="input_label_desc" align="left">备注:</td>
          <td class="td-content">
          <input name="memo" class="td-content-input" label="备注" type="text" />
          </td>
        </tr>
        
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