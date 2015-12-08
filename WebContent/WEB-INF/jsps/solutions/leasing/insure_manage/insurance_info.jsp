<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保险管理 - 保险清单</title>
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
	   .tr_td_dashed{
	   	 border:#DDD 1px dotted;
	   }
	   input[type="text"]{
	   	 border:silver 1px solid;
	   }
	   input[type="checkbox"]{
	   	 vertical-align:middle;
	   	 display:inline-block;
	   }
	</style>
<script type="text/javascript">
    var constantFlagTable = "User";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({
   		 resetFormCallback:function(table,$form,operFlag){
   	   		 if("add" == operFlag){
   	   			getTracywindyObject("id_combo_id_select_chassis_num").readOnlyData = false;
   	   			getTracywindyObject("id_combo_id_select_chassis_num").reload();
   	   	     }
   	   	     if("update" == operFlag){
   	   	  		getTracywindyObject("id_combo_id_select_chassis_num").readOnlyData = true;
   	   	  		getTracywindyObject("id_combo_id_select_chassis_num").reload();
   	   	   		//jQuery("#selectOf_id_combo_id_select_contract_id").attr("readonly","readonly"); 
   	   	   		jQuery("#selectOf_id_combo_id_select_chassis_num").attr("readonly","readonly"); 
   	   	     }
   	     },
   		 loadFormDataCallBack:function(table,$form,rowIndex){
   	   		 var rowData = table.getRowDataAt(rowIndex);
   	   		 jQuery("#selectOf_id_combo_id_select_chassis_num").val(rowData["chassisno"]);
   	   		 jQuery('#contractid').val(rowData["contractidshow"]);
   	   		 jQuery('#custname').val(rowData["custname"]);
   	   		 //jQuery('#contractidhidden').val(rowData["contractid"]);
   	   		 //jQuery('#projidhidden').val(rowData["projid"]);
   	   		 //jQuery(":checkbox [value=rowData['insuranceMoney10']]");
   	   		//if( $("#isDeewinfl").val()==rowData["isdeewinfl"]){
   	   		//			$("#isDeewinfl").attr("checked",true);
   	   	   	//	} ;
   	   		//if( $("#isDealer").val()==rowData["isdealer"]){
   	   		//			$("#isDealer").attr("checked",true);
   	   	   	//	} ;
   	   	  	/*$('[name="isinsurance1"]:radio').attr("checked",rowData["isinsurance1"]);
   	   	  	$('[name="isinsurance2"]:radio').attr("checked",rowData["isinsurance2"]);
   	   	  	$('[name="isinsurance5"]:radio').attr("checked",rowData["isinsurance5"]);
   	   	  	$('[name="isinsurance7"]:radio').attr("checked",rowData["isinsurance7"]);
   	   	  	$('[name="isinsurance11"]:radio').attr("checked",rowData["isinsurance11"]);*/
   	   	  	$('[name="Money10"]:checkbox').each(function(i){
		   	   	  var $this = jQuery(this);
		          var value = this.value;
		          var t=rowData["insurance10"];
		          if (value==t&&(t==50000||t==100000||t==200000||t==300000||t==500000)){
							$this.attr("checked",true);
							$("#insurance10").hide();
			          }else if(value==0&&t!=50000&&t!=100000&&t!=200000&&t!=300000&&t!=500000){
			        	  jQuery('#moneyx').attr("checked",true);
			        	  $("#insurance10").show();
				      }
   	   	   	  	});
   	   			var objMappingArr = [
									{comboId:'document_type',rowDataMapping:'insuredacardtype'},
									{comboId:'document_typeinsuredBCardType',rowDataMapping:'insuredbcardtype'},
									{comboId:'insur_tb_type',rowDataMapping:'insurtypeinfo'},
									//{comboId:'dealerorcompany',rowDataMapping:'dealerid'},
									{comboId:'ThirdInsurTpye',rowDataMapping:'insurance2'}
   	   			               ];
   	   		for(var j=0;j<objMappingArr.length;j++){
			     var objMapping = objMappingArr[j];
			     var rowDataValue  = rowData[objMapping['rowDataMapping']];
			     var comboId   =  ("id_combo_"+objMapping['comboId']);
			     var currentCombo = getTracywindyObject(comboId);
			    	currentCombo.setValue(rowDataValue);
			    	currentCombo.reload();
			 }
    	 },
   		 tableComment:'[保险清单]',
   		 constantFlagTable:'InsuranceInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'保险清单',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/insure_manage/insurance_info.xml',
         loadMode:'ajax',
         rowColorCallback:function(index,rowData){
    		// if (rowData.chassisno=='dafdasf') return 'red';
         },
         isPage:true,
         isFit:true,
         isExcel:true,
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'车架号',name:'chassisno',renderer:showInsuranceInfo,queryConfig:{}},
		            {header:'合同编号',name:'contractidshow',queryConfig:{}},
		            {header:'业务合同号',name:'contractnumber'},
		            {header:'客户',name:'custname',queryConfig:{}},
		            {header:'合同ID',name:'contractid',hidden:true},
		            {header:'投保人全称',name:'insureda',queryConfig:{}},
		            {header:'投保人证件类型',name:'insuredacardtype',hidden:true},
		            {header:'投保人证件类型',name:'insuredacardtypename'},
		            {header:'投保人证件号',name:'insuredacardno'},
		            {header:'被投保人全称',name:'insuredb'},
		            {header:'被保险人证件类型',name:'insuredbcardtype',hidden:true},
		            {header:'被保险人证件类型',name:'insuredbcardtypename'},
		            {header:'被投保人证件号',name:'insuredbcardno'},
		            {header:'行驶证车主',name:'diverhost'},
		            {header:'投保开始日期',name:'begindate'},
		            {header:'投保结束日期',name:'enddate'},
		            {header:'保单类型',name:'initinsurtype'},
		            {header:'合计不计免赔项',name:'comenoabatement'}
		          
	        ]
   	 });
   	//commonSelectOverall('id_select_contract_id',"(select ci.contract_id,ci.id||'/'||ci.proj_id||'/'||cust.cust_name value from contract_info ci left join cust_info cust on (ci.cust_id=cust.id)) rs",'value',"contract_id",'contractid','','','',selectContract,false);
   	commonSelectOverall('id_select_chassis_num',"(select ce.chassis_num chassis_num,ce.chassis_num||'/'||ci.contract_id||'/'||ci.id||'/'||ci.proj_id||'/'||cust.cust_name||'/'||nvl(cii.cust_name,dept.name_)||'/'||nvl(cd.cust_id,ci.cust_dealer)||'/'||ci.contract_number value from contract_equip ce left join  contract_info ci on ce.contract_id=ci.id left join cust_info cust on (ci.cust_id=cust.id)  left join cust_info_dealer cd on cd.id=ci.cust_dealer left join cust_info cii on  cii.id=cd.cust_id left join t_depts dept on ci.proj_dept=dept.id_) rs",'value',"chassis_num",'chassisnum','','','',selectChassisNum,false);
   	dict('id_insurance2','insurance2','ThirdInsurTpye','${requestScope["insurance2"]}',null,' label="第三者责任保险及不计免赔特约"');
   	dict('id_insur_tb_type','insurtypeinfo','insur_tb_type','${requestScope["insurtypeinfo"]}',null,' label="保险模式"');
   	dict('id_insured_a_card_type','insuredACardType','document_type','${requestScope["insured_a_card_type"]}',null,' require="false"  label="投保人证件类型"');
   	dictSameCode('id_insured_b_card_type','insuredBCardType','document_type','${requestScope["insured_b_card_type"]}',null,' require="false"  label="被保险人证件类型"');
   	//dictYesOrNoByCode('id_select_is_insured','isinsured',1,'','','require="true" label="是否投保"');
	/*new tracywindyComboBox({
		id : 'id_combo_dealerorcompany',
		width : 167,
		renderTo : 'dealerorcompany',
		xmlFileName : '\\eleasing\\workflow\\public\\SimpleCustSelect.xml',
		loadMode : 'ajax',
		readOnly : false,
		isAjaxLenovo : true,
		otherAttributes:'require="true"  label="经销商"',
		topAdd : 0,
		leftAdd : 0,
		positionDropIconLeftAdd : -1,
		name : 'dealerorcompany',
		displayField : 'name',
		valueField : 'id',
		value:"${sessionScope['currentDealerCustInfoId']}",
		rawValue:"${sessionScope['currentDealerCustInfoName']}",
		params : {
			cust_class:'CUST_INFO_DEALER',
			cooperate_status:'dealer_symbiosis1',
			dealer_id:"${sessionScope['currentDealerCustInfoId']}"
		}
		
	});*/
	
   });

	function showInsuranceInfo(value,tableObj,columnName,columnIndex,rowData){
        var base = "<a href='javascript:void(0);' onclick='showInsurInfo(\""+rowData.id+"\")'>{1}</a>{2}";
        var separator = "&nbsp;&nbsp;";
        var updateFlag=value;
        var updateClickFunc="other";
        var field=base.replace("{1}",updateFlag).replace("{2}",separator);
        return field;
      }
	 function showInsurInfo(insurid){
	    	var URL = "${pageContext.request.contextPath}/leasing/insure_manage/insurance_info_detail.bi";
	    	var params = {insurid:insurid,read_only:false};
		    openFullScreenWindow(URL,params);
	    }

	   
//提交表单
function submitInsur(){
	var beginDate = $("#beginDate").val();
	var endDate = $("#endDate").val();
	if(endDate<=beginDate){
		alert("投保结束日期必须大于开始日期！！！");
		return false;
	}else{
		getTracywindyObject("id_table").operationTable();
		return true;
	}
}	   
function selectContract(){
	var contractID=getTracywindyObject("id_combo_id_select_contract_id").getValue();
	if(contractID!=""){
		var va=contractID.split("/");
		jQuery('#custname').val(va[2]);
	}
}
function selectChassisNum(){
	var contractID=getTracywindyObject("id_combo_id_select_chassis_num").getValue();
	if(contractID!=""){
		var va=contractID.split("/");
		jQuery('#contractid').val(va[1]);
		jQuery('#custname').val(va[4]);
		jQuery('#dealerorcompanyname').val(va[5]);
		jQuery('#dealerorcompany').val(va[6]);
		jQuery('#contractnumber').val(va[7]);
	}
}
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
    <script type='text/javascript'>
       var currentClientWidth = document.documentElement.clientWidth;
       jQuery(function(){
           jQuery("#id_detailInfoWindowContainer").css({
               width:currentClientWidth*0.95
           });
       });
    </script>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" buttons="#id-dlg-buttons" title="保险清单" style="display:none;height:600px">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:100%" class="fillTable">
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">车架号</td>
			            	<td class="td-content">
			            		<div id="id_select_chassis_num"></div>
			            	</td>
			            	<td class="td-content-title">业务合同号</td>
			            	<td class="td-content">
			            	<input name="contractnumber" id="contractnumber" require="true" label="业务合同号" readonly class="td-content-input td-content-readonly"   type="text" /><span class="required-content">*</span>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">合同编号:  </td>  
			            	<td class="td-content" nowrap="nowrap">
			            		<input name="contractid" id="contractid" require="true" label="合同编号" readonly class="td-content-input td-content-readonly"   type="text" /><span class="required-content">*</span>
			            		<input id="contractidhidden" name="contractidhidden" type="hidden">
			            		<input id="projidhidden" name="projidhidden" type="hidden">
			            	</td>
			            	<td class="td-content-title">客户名:  </td>  
			            	<td class="td-content">
			            		<input name="custname" id="custname" require="true" label="客户名" readonly class="td-content-input td-content-readonly"   type="text" /><span class="required-content">*</span>
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">投保人全称：</td>
			            	<td class="td-content">
			            		<input name="insuredA" id="insureda" require="true" label="投保人全称"  class="td-content-input"   type="text" /><span class="required-content">*</span>
			            	</td>
			            	<td class="td-content-title">投保人证件类型：</td>
			            	<td class="td-content">
			            		<div style="float:left" id="id_insured_a_card_type" class="leftComboContainer"></div>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">投保人证件号</td>
			            	<td class="td-content">
			            		<input name="insuredACardNo" id="insuredACardNo"  label="投保人证件号"  class="td-content-input"   type="text" />
			            	</td>
			            	<td class="td-content-title"></td>
			            	<td class="td-content"></td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">被保险人全称：</td>
			            	<td class="td-content">
			            		<input name="insuredb" id="insuredb" label="被投保人全称" require="true" class="td-content-input"   type="text" /><span class="required-content">*</span>
			            	</td>
			            	<td class="td-content-title">被保险人证件类型：</td>
			            	<td class="td-content">
			            		<div style="float:left" id="id_insured_b_card_type" class="leftComboContainer"></div>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">被保险人证件号</td>
			            	<td class="td-content">
			            		<input name="insuredbCardNo" id="insuredbCardNo"  label="被投保人证件号"  class="td-content-input"   type="text" />
			            	</td>
			            	<td class="td-content-title"></td>
			            	<td class="td-content"></td>
			            </tr>
			            
			            <tr class="tr-odd">
			            	<td class="td-content-title">行驶证车主：</td>
			            	<td class="td-content">
			            		<input name="diverhost" id=diverhost label="行驶证车主" class="td-content-input"   type="text" /><span class="required-content">*</span>
			            	</td>
			            	<td class="td-content-title">品牌型号：</td>
			            	<td class="td-content">
			            		<input name="brands" id="brands" label="品牌型号" class="td-content-input"   type="text" />
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">性质</td>
			            	<td class="td-content">
			            		<input name="property" id="property" label="性质" class="td-content-input"   type="text" />
			            	</td>
			            	<td class="td-content-title">车牌号（旧车）</td>
			            	<td class="td-content">
			            		<input name="oldCarNo" id="oldCarNo" label="车牌号（旧车）"  class="td-content-input"   type="text" />
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">初次登记日期</td>
			            	<td class="td-content">
			            		<input name="firstRegDate" id="firstRegDate" label="初次登记日期"  class="Wdate td-content-input td-content-readonly"  onClick="WdatePicker(this,{readOnly:true})"   type="text" />
			            	</td>
			            	<td class="td-content-title">核定载客/整备质量</td>
			            	<td class="td-content">
			            		<input name="capacityAndQuality" id="capacityAndQuality" label="核定载客/整备质量"  class="td-content-input"   type="text" />
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">车辆类型</td>
			            	<td class="td-content">
			            		<input name="carType" id="carType" label="车辆类型"  class="td-content-input"   type="text" />
			            	</td>
			            	<td class="td-content-title">车辆/挂车购置价格</td>
			            	<td class="td-content">
			            		<input name="carPrice" id="carPrice" label="车辆/挂车购置价格" datatype="PMoney"  class="td-content-input"   type="text" />
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">整车合计价格</td>
			            	<td class="td-content">
			            		<input name="carPriceTotal" id="carPriceTotal" label="整车合计价格" datatype="PMoney"   class="td-content-input"   type="text" />
			            	</td>
			            	<td class="td-content-title">发动机号</td>
			            	<td class="td-content">
			            		<input name="EngineNo" id="EngineNo" label="发动机号"  class="td-content-input"   type="text" />
			            	</td>
			            </tr>
			            
			            <tr class="tr-even">
			            	<td class="td-content-title">投保开始日期</td>
			            	<td class="td-content">
			            		<input name="beginDate" id="beginDate" label="投保开始日期" readonly require="true"  class="Wdate td-content-input td-content-readonly"  onClick="WdatePicker(this,{readOnly:true})"   type="text" /><font class="required-content">*</font>
			            	</td>
			            	<td class="td-content-title">投保结束日期</td>
			            	<td class="td-content">
			            		<input name="endDate" id="endDate" label="投保开始日期"  readonly require="true"  class="Wdate td-content-input td-content-readonly"  onClick="WdatePicker(this,{readOnly:true})"  type="text" /><font class="required-content">*</font>
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">第一受益人</td>
			            	<td class="td-content">
			            		<input name="firstBeneficiary" id="firstBeneficiary" label="第一受益人"  class="td-content-input"   type="text" />
			            	</td>
			            	<td class="td-content-title">第二受益人</td>
			            	<td class="td-content">
			            		<input name="secondBeneficiary" id="secondBeneficiary" label="第二受益人  "  class="td-content-input"   type="text" />
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">保险方式</td>
			            	<td class="td-content"><div id="id_insur_tb_type"></div>
			            	</td>
			            	<td class="td-content-title"></td>
			            	<td class="td-content">
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">保险公司</td>
			            	<td colspan="3">
			            		<div>
			            		<span>
      							保险公司名称:
			            		<input name="insuranceName" id="insuranceName" label="保险公司名称"   require="false" type="text" />
			            		</span>
			            		
			            		</div>
			            		<div>
			            		<span>
      							联系方式:
			            		<input name="insuranceCommunication" id="insuranceCommunication" label="联系方式"   type="text" />
			            		</span>
			            		</div>
			            		<div>
			            		<span>
      							折扣:
			            		<input name="insuranceRebate" id="insuranceRebate" label="折扣"   type="text" />
			            		</span>
			            		</div>
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">备注</td>
			            	<td class="td-content" colspan="3">
			            	<textarea rows="5" cols="30" style="width:98.9%;float:left;" name="iimemo" maxB="300"  label="备注"></textarea>
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            	<td class="td-content-title">经销商</td>
			            	<td class="td-content">
			            		<!-- div style="float: left" class="leftComboContainer" id="dealerorcompany" ></div><font class="required-content">*</font-->	
			            		<input name="dealerorcompanyname" id="dealerorcompanyname" require="true" label="经销商"    type="text" /><span class="required-content">*</span>
			            		<input id="dealerorcompany" name="dealerorcompany" type="hidden">
			            	</td>
			            	<td class="td-content-title">联系方式</td>
			            	<td class="td-content">
			            		<input name="communicationType" id="communicationType" label="联系方式"  class="td-content-input"   type="text" />
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            	<td class="td-content-title">联系人</td>
			            	<td class="td-content">
			            		<input name="communicationPerson" id="communicationPerson" label="联系人"  class="td-content-input"   type="text" />
			            	</td>
			            	<td class="td-content-title"></td>
			            	<td class="td-content">
			            	</td>
			            </tr>
			        </table>
			        <table style="width:100% ;" border="1" cellpadding="0" bordercolorlight="#999999"
						bordercolordark="#FFFFFF" cellspacing="0" line-height="0px"; class="fillTable">
					    <tr class="tr-project-info tr-odd tr_td_dashed">
					    	<td  align="center" colspan="4" class="tr_td_dashed"><b>必投保险种</b></td>
					    </tr>
					    <tr class="tr-project-info tr-odd tr_td_dashed">
					    	<td  align="center" style="width:25%" class="tr_td_dashed"><b>险种</b></td>
					    	<td  align="center" style="width:50%" class="tr_td_dashed" colspan="2"><b>保险金额或责任限额（元）</b></td>
					    	<td  align="center" style="width:25%" class="tr_td_dashed"><b>保险费（元）</b></td>
					    </tr>
						<tr class="tr-project-info tr-even tr_td_dashed" >
							<td class="tr_td_dashed" rowspan="2">机动车损失保险及不计免赔特约：</td>  
							<td class="tr_td_dashed" style="width: 25%">是否不计免赔特约</td>
					        <td class="tr_td_dashed">
					        	<input name="isinsurance1" type="radio" label="是否不计免赔特约" class="nocalculate" value="是" >是
					           			  <input name="isinsurance1" type="radio" label="是否不计免赔特约" class="nocalculate" value="否" >否   
					        </td>
					        <td align="center" class="tr_td_dashed">
					        	<input  name="insurance1Money2"  label="是否不计免赔特约(保险费)"  type="text" class="calculate" datatype="PMoney" >
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-even tr_td_dashed" >
					     	<td class="tr_td_dashed">保险金额按车辆购置发票金额</td>
					     	<td class="tr_td_dashed">&nbsp;&nbsp;&nbsp;&nbsp;<input  name="insurance1"   label="机动车损失保险及不计免赔特约"  type="text" datatype="Double"  >万&nbsp;元</td>
					     	<td align="center" class="tr_td_dashed">
					        	<input  name="insuranceMoney1"  label="机动车损失保险及不计免赔特约(保险费)"  type="text" class="calculate" datatype="PMoney" >
					        </td>
					     </tr>   
					    <tr class="tr-project-info tr-odd tr_td_dashed" >
					        <td class="tr_td_dashed" rowspan="2">第三者责任保险及不计免赔特约：</td>  
							<td class="tr_td_dashed">是否不计免赔特约</td>
							<td class="tr_td_dashed"><input name="isinsurance2" type="radio" label="是否不计免赔特约" class="nocalculate" value="是"  >是
					           			     <input name="isinsurance2" type="radio" label="是否不计免赔特约" class="nocalculate" value="否"  >否
					        </td>
							
							<td align="center" class="tr_td_dashed">
					        	<input  name="insurance2money2" label="第三者责任保险及不计免赔特约(保险费)"  type="text" datatype="PMoney" class="calculate"   >
					        </td>
						 </tr>
						 <tr class="tr-project-info tr-odd tr_td_dashed">
						 <td class="tr_td_dashed"></td>
						 <td class="tr_td_dashed">&nbsp;&nbsp;<div id="id_insurance2"></div></td>
						 <td align="center" class="tr_td_dashed">
					        	<input  name="insuranceMoney2" label="第三者责任保险及不计免赔特约(保险费)"  type="text" datatype="PMoney" class="calculate"   >
					     </td>
						 </tr>
						 
						 
						 <tr class="tr-project-info tr-even tr_td_dashed">
					        <td class="tr_td_dashed" rowspan="2">全车盗抢损失险及不计免赔特约：</td>
					        <td class="tr_td_dashed">是否不计免赔特约</td>
					        <td class="tr_td_dashed"><input name="isinsurance3" type="radio" label="是否不计免赔特约" class="nocalculate" value="是" >是
					           			  <input name="isinsurance3" type="radio" label="是否不计免赔特约" class="nocalculate" value="否" >否</td>
					        </td class="tr_td_dashed">
					        <td align="center" class="tr_td_dashed">
					        	<input  name="insurance3Money2" label="第三者责任保险及不计免赔特约(保险费)"  type="text" datatype="PMoney" class="calculate"   >
					     </td>
					     </tr> 
					     <tr  class="tr-project-info tr-even tr_td_dashed">
					     <td class="tr_td_dashed">首次投保保险金额按车辆购置发票金额</td>
					     <td class="tr_td_dashed">&nbsp;&nbsp;&nbsp;&nbsp;<input name="insurance3" label="全车盗抢损失险及不计免赔特约"   type="text" datatype="Double"  >万&nbsp;元</td>
					     <td align="center" class="tr_td_dashed">
					        	<input  name="insuranceMoney3" label="第三者责任保险及不计免赔特约(保险费)"  type="text" datatype="PMoney" class="calculate"   >
					     </td>
					     </tr>
					         
					     <tr class="tr-project-info tr-odd tr_td_dashed">      
					        <td class="tr_td_dashed" rowspan="3">车上人员责任险及不计免赔特约：</td>
					        <td class="tr_td_dashed" >是否不计免赔特约</td>
					        <td class="tr_td_dashed" ><input name="isinsurance5" type="radio" label="是否不计免赔特约" class="nocalculate" value="是" >是
					           			  <input name="isinsurance5" type="radio" label="是否不计免赔特约" class="nocalculate" value="否">否</td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insurance5Money2" label="驾驶员(保险费)"  type="text" datatype="PMoney" class="calculate"   >
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-odd tr_td_dashed">
					     <td class="tr_td_dashed">驾&nbsp;驶&nbsp;员<input name="insurance4"  class="nocalculate"   label="驾驶员"  type="text" datatype="PMoney"  >人</td>
					      <td class="tr_td_dashed" >保额<input name="insurance41"    label="保额"  type="text" datatype="PMoney"  >元/人</td>
					       <td class="tr_td_dashed" rowspan="2"  align="center">
					        	<input  name="insuranceMoney4" label="驾驶员(保险费)"  type="text" datatype="PMoney" class="calculate"  >
					        </td> 	
					      </tr>  
					     <tr class="tr-project-info tr-odd tr_td_dashed">
					     	<td class="tr_td_dashed">
					        	核定乘客<input name="insurance42" label="核定乘客"  type="text" datatype="Number"  >人</td>
					        <td class="tr_td_dashed">
					        	保额<input name="insurance43" label="核定乘客"  type="text" datatype="PMoney"  >元/人
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-even  tr_td_dashed">
					     	<td class="tr_td_dashed" rowspan="2" >自燃险及不计免赔特约</td>
					     	<td class="tr_td_dashed">是否不计免赔特约</td>
					     	<td class="tr_td_dashed">
					     	<input name="isinsurance7" type="radio" label="是否不计免赔特约" class="nocalculate" value="是" >是
					           			  <input name="isinsurance7" type="radio" label="是否不计免赔特约" class="nocalculate" value="否" >否<br>
					      	 
					        </td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insurance7Money2" label="自燃险(保险费)"  type="text" datatype="PMoney" class="calculate"  >
					        </td>
					     </tr>    
					     <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed"  >自燃险：</td>
					     	<td class="tr_td_dashed"   >
					      	 &nbsp;&nbsp;&nbsp;&nbsp;<input name="insurance7" label="自燃险"  type="text" datatype="PMoney"  >
					        </td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insuranceMoney7" label="自燃险(保险费)"  type="text" datatype="PMoney" class="calculate"   >
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-odd tr_td_dashed">
					     	<td class="tr_td_dashed"  >交强险：</td>
					     	<td class="tr_td_dashed"  ></td>
					     	<td class="tr_td_dashed">
					      	 &nbsp;&nbsp;&nbsp;&nbsp;<input name="insurance8" label="交强险"  type="text" datatype="PMoney"  >
					        </td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insuranceMoney8" label="交强险(保险费)"  type="text" datatype="PMoney" class="calculate"   >
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed"  >车船税：</td>
					     	<td class="tr_td_dashed"  ></td>
					     	<td class="tr_td_dashed" >
					      	 &nbsp;&nbsp;&nbsp;&nbsp;<input name="insurance6" label="车船税"  type="text" datatype="PMoney"  >
					        </td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insuranceMoney6" label="车船税(保险费)"  type="text" datatype="PMoney" class="calculate"   >
					        </td>
					     </tr> 
					     
					     <tr class="tr-even">
			            	<td class="td-content-title">合计不计免赔项</td>
			            	<td class="td-content">
			            		<input name="comeNoAbatement" id="comeNoAbatement"  label="合计不计免赔项"  datatype="PMoney"   type="text" class="calculate"  />
			            	</td>
			            	<td class="td-content-title"></td>
			            	<td class="td-content"></td>
			            </tr>
					     
					      
					      
					        <tr class="tr-project-info tr-odd tr_td_dashed">
					    	<td class="tr_td_dashed"  align="center" colspan="4"><b>工程机械险</b></td>
					    </tr>
					    <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed"  >工程机械设备综合保险：</td>
					     	<td class="tr_td_dashed"  ></td>
					     	<td class="tr_td_dashed"  ></td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insuranceMoney20" label="工程机械设备综合保险"  type="text" datatype="PMoney" class="calculate"   >
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed"  >附加第三者责任保险：</td>
					     	<td class="tr_td_dashed"  ></td>
					     	<td class="tr_td_dashed"  ></td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insuranceMoney21" label="附加第三者责任保险"  type="text" datatype="PMoney" class="calculate"  require="false"/>
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed"  >附加整机盗抢保险：</td>
					     	<td class="tr_td_dashed"  ></td>
					     	<td class="tr_td_dashed"  ></td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insuranceMoney22" label="附加整机盗抢保险"  type="text" datatype="PMoney" class="calculate"   >
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed"  >附加自然损失保险：</td>
					     	<td class="tr_td_dashed"  ></td>
					     	<td class="tr_td_dashed"  ></td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insuranceMoney23" label="附加自然损失保险"  type="text" datatype="PMoney" class="calculate"   >
					        </td>
					     </tr>
					      
					      
					        <tr class="tr-project-info tr-odd tr_td_dashed">
					    	<td class="tr_td_dashed"  align="center" colspan="4"><b>选投保险种</b></td>
					    </tr>
					    <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed"  >玻璃单独破碎险：</td>
					     	<td class="tr_td_dashed"  ></td>
					     	<td class="tr_td_dashed"  >
					      	 &nbsp;&nbsp;&nbsp;&nbsp;<input name="insurance9" label="玻璃单独破碎险"  type="text" datatype="PMoney" >
					        </td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="insuranceMoney9" label="玻璃单独破碎险(保险费)"  type="text" datatype="PMoney" class="calculate"   >
					        </td>
					     </tr>    
					     <tr class="tr-project-info tr-odd tr_td_dashed">
					     	<td class="tr_td_dashed" rowspan="2">车上货物责任险及不计免赔特约：</td>
					     	<td class="tr_td_dashed" >是否不计免赔特约：</td>
					     	<td class="tr_td_dashed" ><input name="isinsurance11" type="radio" label="是否不计免赔特约" class="nocalculate" value="是" >是
					           			  <input name="isinsurance11" type="radio" label="是否不计免赔特约" class="nocalculate" value="否" >否</td>
					        <td class="tr_td_dashed" align="center">
					        	<input  name="insurance11Money2" label="车上货物责任险(保险费)"  type="text" datatype="PMoney" class="calculate">
					        </td>
					     </tr>    
					     <tr class="tr-project-info tr-odd tr_td_dashed">
					     <td class="tr_td_dashed" >
					     车上货物责任险
					     </td>
					     <td class="tr_td_dashed" >
					     <span>
					      	 <input name="Money10" id="money50000" label="车上货物责任险"  type="checkbox"  value="50000"  ${("5000"==insuranceMoney10) ? "checked" : "" }>50000
					      	 <input name="Money10" id="money100000" label="车上货物责任险"  type="checkbox" value="100000" ${("5000"==insuranceMoney10) ? "checked" : "" }>100000
					      	 <input name="Money10" id="money200000" label="车上货物责任险"  type="checkbox" value="200000" ${("200000"==insuranceMoney10) ? "checked" : "" }>200000
					      	 <input name="Money10" id="money300000" label="车上货物责任险"  type="checkbox" value="300000" ${("300000"==insuranceMoney10) ? "checked" : "" }>300000
					      	 <input name="Money10" id="money500000" label="车上货物责任险"  type="checkbox" value="500000" ${("500000"==insuranceMoney10) ? "checked" : "" }>500000
					      	 <input name="Money10" id="moneyx" label="车上货物责任险"  type="checkbox" value="0" ${("0"==insuranceMoney10) ? "checked" : "" }>自选投保金额
					      	 <input name="insurance10" id="insurance10" label="车上货物责任险"  type="text" datatype="PMoney" style='display: ${("0"==insuranceMoney10) ? "" : "none"}'  >
					     	
					     	</span>
					     	</td>
					     	<td class="tr_td_dashed"  align="center">
					        	<input  name="insuranceMoney10" label="车上货物责任险(保险费)"  type="text" datatype="PMoney" class="calculate">
					        </td>
					     </tr>
					     <tr class="tr-project-info tr-even tr_td_dashed">
					     	<td class="tr_td_dashed" align="center"><b>合计</b></td>
					     	<td class="tr_td_dashed" colspan="2" ></td>
					        <td class="tr_td_dashed"   align="center">
					        	<input  name="feetotal" id="feetotal" label="合计(保险费)" readonly="readonly" type="text" >
					        </td>
					     </tr>       
	</table>
	 <script language="javascript">
	 $(':input[name="Money10"]').click(function(){
	        $(':input[name="Money10"]').prop('checked',false);
	        $(this).prop('checked',true);
	        if($(this).attr("checked")){
					$("#insurance10").val($(this).val());
		        }
	      //自选投保金额被选中时   
	   	if($("#moneyx").attr("checked")){
			$("#insurance10").show();
		}else{
			$("#insurance10").hide();
		}
	   });	  
	 function getSumFunc(){
			var sum = 0.0;
			jQuery('input[class="calculate"]').each(function(i){
	            var $this = jQuery(this);
	            var value = this.value;
	            var tempValue = parseFloat(value);
	            if(tempValue && !isNaN(tempValue)){
	            	sum+=tempValue;
	            }
		    });
		    //return sum;
		    $("#feetotal").val(sum);
     }  
	$(':input[class="calculate"]').each(function(i){
		this.oninput = function(){
			//alert(getSumFunc());
			getSumFunc();
		};
		this.onpropertychange=function(event){
			var ev = getEvent(event);
			if (ev.propertyName.toLowerCase () == "value")
			{
				//alert(getSumFunc());
				getSumFunc();
			}
		};

	});	   
	

					
	</script>

		        </form>
	        </center>
	</div>
		<div style="text-align:center;width:800px;display:none;height:40px;line-height:40px;" id="id-dlg-buttons">
		 <!--  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='getTracywindyObject("id_table").operationTable();'><span>确定</span></a> -->
		  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='submitInsur()'><span>确定</span></a>
		  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
	</div>
</body>
</html>