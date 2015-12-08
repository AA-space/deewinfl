<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租前业务  - 网银信息 - 经销商垫付</title>
    <!--css sheet-->
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
	<!--javascript libray-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAttachmentFileUpload.js"></script>
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
	   html,body{ overflow:hidden;}
	</style>
<script type="text/javascript">
/**
 * 
 @Author chennes
  操作权限判断
  修改权限：租后管理、业务企划、财务部
  网银上传：财务部
  模板下载：财务部
  废弃：          财务部
 */
//#########操作权限#############
var ebank_update = false;
var ebank_upload = false ;
var ebank_download = false;
var ebank_remove = false;
<permission:action  code="ebank_update">
	ebank_update=true;
</permission:action>
/* <permission:action  code="ebank_upload">
	ebank_upload=true;
</permission:action>
<permission:action  code="ebank_download">
	ebank_download=true;
</permission:action>
*/
/* <permission:action  code="ebank_remove">
	ebank_remove=true;
</permission:action>  */
//########操作权限##############
jQuery(function(){
var combo_cust = new tracywindyComboBox({
	lazyLoad:true,
    id:'id_combo_cust',
    width:300,
    renderTo:'id_cust_name',
    xmlFileName:'\\eleasing\\workflow\\public\\comboSimpleCustSelect.xml',
    loadMode:'ajax',
    readOnly:false,
    readOnlyData:true,
    isAjaxLenovo:true,
    isContainEmpty:false,
    dropListHeight:300,
    topAdd:0,
    leftAdd:0,
    positionDropIconLeftAdd:-1,
    name:'custid',
    displayField:'nameandcode',
    valueField:'value',
    
    onSelect:function(combo){
   }
 });
var combo_ebank = new tracywindyComboBox({
	lazyLoad:true,
    id:'id_combo_ownbank',
    width:300,
    renderTo:'id_ownbank',
    readOnlyData:true,
    xmlFileName:'\\eleasing\\jsp\\own_manage\\ownaccountinfo.xml',
    loadMode:'ajax',
    readOnly:false,
    //isAjaxLenovo:true,
    isContainEmpty:false,
    dropListHeight:300,
    topAdd:0,
    leftAdd:0,
    positionDropIconLeftAdd:-1,
    name:'ownbank',
    displayField:'accbank',
    valueField:'accbank',
    otherAttributes :'label="本方银行"', 
    onSelect:function(combo,cdata){
      $("#id_ownaccount").val(cdata.accname);
      $("#id_ownaccnumber").val(cdata.accnumber);
   }
 });
 dictYesOrNoByCode('id_fund_ebank_status','enabled',null,null,null,'" label="是否有效"', null, true);//是否草稿

});
var importcolumn= [
                   {header:'id',mapping:'id'},
                   {header:'流水号',mapping:'sn'},
                   {header:'到账金额',mapping:'factmoney'},
	  		         {header:'与系统无关金额',mapping:'nowithmoney'},
	  		         {header:'到账时间',mapping:'factdate'},
	  		         {header:'到账金额类型',mapping:'moneytype'},
		             {header:'付款人',mapping:'clientname'},
		             //{header:'本方银行',mapping:'ownbank'},
		             //{header:'本方账户',mapping:'ownaccount'},
		             {header:'本方账号',mapping:'ownaccnumber'},
		             //{header:'对方银行',mapping:'clientbank'},
		             //{header:'对方账户',mapping:'clientaccount'},
		             {header:'对方账号',mapping:'clientaccnumber'},
		             {header:'用途',mapping:'usefor'},
		             {header:'备注1',mapping:'summary',hidden:true},
		             {header:'备注2',mapping:'summary1',hidden:true}
		             //{header:'是否启用',mapping:'enabled'}
	        ];
  function checkCancel(){
    var select_enabled = getTracywindyObject("id_combo_id_fund_ebank_status");
	if(select_enabled.getValue()=="1"){
      var owmoney=$("#id_hiremoney").val();
      if(parseFloat(owmoney)>0){
        alert("本网银已经核销过不能撤销");
        select_enabled.setValue(0);
		select_enabled.setRawValue("是");
      }
	}
  }

  
    function importEbankCallBack(message){
    	window.currentImportExcelLoadMask.hide();
    	var table = getTracywindyObject("id_table");
    	table.reload();
    }

    function cancelFundEbank(table){
    	var plandata = table.getCheckedRowDatas();
    	var ids="";
    	for(var i=0;i<plandata.length;i++){
           var factmoney=plandata[i].factmoney;
           var nowithmoney=plandata[i].nowithmoney;
           var owmoney=plandata[i].owmoney;
           var allmoney=parseFloat(factmoney)-parseFloat(nowithmoney);
           allmoney=allmoney.toFixed(2);
           /*if(parseFloat(allmoney)!=parseFloat(owmoney)){
                alert("网银编号为"+plandata[i].ebdataid+"已经核销过，请联系管理员");
                return false;
          }else{*/
              if(ids!=""){ids=ids+",";}
              ids=ids+plandata[i].id;
          //} 
       }
    	var params = {ebank_id:ids};
		params['enable_flag'] = '92';
    	ajaxRequest({
		     url:getRootPath()+"/leasing/acl/custEbankEnabled.action",
		     method:'POST',
		     success:function(res){
		        alert("操作成功");
		        var table = getTracywindyObject("id_table");
		    	table.reload();
    	     },
		     async:false,
		     failure:function(res){},
		     params:params
	   }); 
    }
    var tools = [];
/*    
	if(ebank_upload){
		tools.push({
    	    iconCls:'icon-import',
    	    html:'<font color="red">网银上传</font>',
    	    handler:function(table){
    	    	attachmentUp({url:"/leasing/template/uploadExcelToDatabase.action",targetClass:'com.business.entity.asset.FundEbankData',custoperatorMethod:'checkEbankInfoDataImport',modelname:'ebankinfo',title:'网银上传',parames:importcolumn});
    	   }
    	 });
    } 
    if(ebank_download){
    	tools.push({
    	    iconCls:'icon-import',
    	    html:'<font color="red">模板下载</font>',
    	    handler:function(table){
    	       attachmentDown({url:'/leasing/template/downloadFileTemplateByClasses.action',returnType:'file','twoClassify':'wordtempletypetwo10'});
    	   }});
    }
    */
		tools.push({
    	    iconCls:'icon-import',
    	    html:'<font color="red">启用</font>',
    	    handler:function(table){
    	    	cancelFundEbank(table);
    	   }
    	 });
     
    
    var constantFlagTable = "User";
    var ebankUploadUrl="";
    var ebankAttachUrl="";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var tableebank = new tracywindyOperationTable({
   		resetFormCallback:function(table, $form, operFlag){
   		 if("add" == operFlag){
   			var rowData = table.getRowDataAt(rowIndex);
   	      }
     	},
   	    beforeShowWindowCallBack:function(table, $form, operFlag){
       	      if("update" == operFlag) {
       	    	var rowData = table.getCheckedRowDatas();
       	    	//可核销金额
       	    	var hiremoney = rowData[0].hiremoney;
       			//流程中占用金额
       			var fundpmoney = rowData[0].fundpmoney;
       			
       	    	if(hiremoney!=""||fundpmoney!="")
     	  	    	if(parseInt(hiremoney)>0||parseInt(fundpmoney)>0){
     					//alert("该网银正在使用不能修改！");
     					return true;
     	  	    	}else{
						return true;
     	  	    	}
     	  	    }
          	}
    	,
   	  loadFormDataCallBack:function(table,$form,rowIndex){
     		 var rowData = table.getRowDataAt(rowIndex);
     		 var select_contract = getTracywindyObject("id_combo_cust");
     		 var befor_fund_ebank_status = jQuery("#id_befor_fund_ebank_status");
     		 var befor_cust_id = jQuery("#id_befor_cust_id");
     		 var befor_nowithmoney = $("#id_befor_nowithmoney");
     		 if(rowData["custid"]){
    	        select_contract.setValue(rowData["custid"]);
    	        //1.设置修改前的客户编号
    	        befor_cust_id.val(rowData["custid"]);
     		 }
    		 if(rowData["nowithmoney"]){
     	        //2.设置修改前与系统无关金额
     	        befor_nowithmoney.val(rowData["nowithmoney"]);
      		 }
     		 var select_ebank = getTracywindyObject("id_combo_ownbank");
     		 
     		 if(rowData["ownbank"]){
     			select_ebank.setValue(rowData["ownbank"]);
     			select_ebank.setRawValue(rowData["ownbank"]);
     		 }
     		var select_enabled = getTracywindyObject("id_combo_id_fund_ebank_status");
    		 if(rowData["enabled"]){
    			 //select_enabled.setValue(rowData["enabled"]);
    			//var str="";
    			//if(rowData["enabled"]=="0"){str="是";}else{str="否";}
    			//select_enabled.setRawValue(str);
    			//3.设置修改前的是否有效
    			befor_fund_ebank_status.val(rowData["enabled"]);
    	    }   
         },
   		 tableComment:'[网银其他信息]',
   		 constantFlagTable:'fundebank',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'网银信息',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/fund_ebank/fund_ebank_info.xml',
         operButtons:"修改", 
         loadMode:'ajax',
         checkType:'checkbox',
         isExcel:true,
         isPage:true,
         validateFrom:function(table,sfrom){
              var nowithmoney=$("#id_nowithmoney").val();
              var factmoney=$("#id_factmoney").val();
              var hirmoney=$("#id_hiremoney").val();
              var owmoney=parseFloat(factmoney)-parseFloat(hirmoney);
              owmoney=owmoney.toFixed(2);
              if(parseFloat(nowithmoney)>parseFloat(owmoney)){
                  alert("与系统无关金额大于网银余额");
                return false;
              }
             return true;
         },
         emptyChar:"",
         tools:tools,
         isFit:true,
         params:{
        	 enabled:111,owmoneythanzero:0
		 },
         columns:[
                    {header:'id',name:'id',hidden:true},
		            {header:'网银编号',name:'ebdataid',queryConfig:{}},
		            //{header:'是否有效',name:'enabledname'},
		            /*{header:'经销商/客户',name:'custname',type:'combobox',queryConfig:{
		            	  xmlFileName:'\\eleasing\\workflow\\public\\comboSimpleCustSelect.xml',
			 		       loadMode:'ajax',
			 		       isAjaxLenovo:false,    
			 		       readOnly:false,
			 		       width:200,
			 		       name:'name',
			 		       displayField:'name',
			 		       valueField:'name'
			            }},*/
			        {header:'经销商/客户',name:'custname',queryConfig:{}},
		            {header:'付款人',name:'clientname',queryConfig:{}},
		            {header:'本方银行',name:'ownbank',hidden:true},
		            {header:'本方账户',name:'ownaccount',hidden:true},
		            {header:'本方账号',name:'ownaccnumber',hidden:true},
		            {header:'对方银行',name:'clientbank',hidden:true},
		            {header:'对方账户',name:'clientaccount',hidden:true},
		            {header:'对方账号',name:'clientaccnumber',hidden:true},
		            {header:'到账金额类型',name:'moneytype',hidden:true},
		            {header:'到账金额',name:'factmoney',type:"double",queryConfig:{isNewLine:true}},
		            {header:'与系统无关金额',name:'nowithmoney',type:"double"},
		            {header:'核销过程中金额',name:'fundpmoney',type:"double"},
		            {header:'已核销金额',name:'hiremoney',type:"double"},
		            {header:'剩余金额',name:'owmoney',type:"double"},
		            {header:'到账时间',name:'factdate',type:"date",isRange:true,queryConfig:{}},
		            {header:'流水号',name:'sn',queryConfig:{}},
		            {header:'用途',name:'usefor'},
		            {header:'备注1',name:'summary'},
		            {header:'区域',name:'qyu'},
		            {header:'登记人',name:'creator_name'},
		            {header:'登记时间',name:'create_date'}
	        ]
   	 });
   });
	
	function tableSubmitCallback(){
		
		var cust = getTracywindyObject('id_combo_cust').getValue();
		if(cust){
			getTracywindyObject("id_table").operationTable();
		} else {
			alert ("请选择用户");
		}
	}
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer"  closed="true" modal="true" title="网银信息" style="display:none;width:800px;height:900px;padding-top:10px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:90%" class="fillTable">
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
			            
			            <tr  class="tr-other-info tr-odd">
			            <td class="td-content-title" >流水号:  </td>  
			            	<td class="td-content">
			            	     <input name="ebdataid"  class="td-content-input" type="hidden" />
			            		 <input name="sn" require="true" label="流水号"   class="td-content-input td-content-readonly" readOnly=true type="text" /><font class="required-content">*</font>
			            	</td>
			            	<td class="td-content-title">是否有效</td>
			            	<td  class="td-content">
			            	  <div id="id_fund_ebank_status" style="float:left;"></div>
			            	  <input type="hidden" id="id_befor_fund_ebank_status" name="befor_fund_ebank_status" />
			            	</td>
			            </tr>
			            <tr  class="tr-other-info tr-even">
			                <td class="td-content-title">经销商/客户:  </td>  
			            	<td class="td-content">
			            	    <div id="id_cust_name" style="float:left;"></div>
			            	    <input type="hidden" id="id_befor_cust_id" name="befor_cust_id" />
			            	</td>
			            	<td class="td-content-title">付款人:  </td>  
			            	<td class="td-content">
			            		<input name="clientname" class="td-content-input td-content-readonly"  readOnly label="付款人"  type="text" />
			            	</td>
			            </tr>
			            <tr  class="tr-other-info tr-odd">
			            	<td class="td-content-title">本方银行:  </td>  
			            	<td class="td-content">
			            	   <div id="id_ownbank" style="float:left;"></div>
			            		<!--  <input name="ownbank" class="td-content-input"    type="text" />-->
			            	</td>
			            	<td class="td-content-title">对方银行:  </td>  
			            	<td class="td-content">
			            	<input name="clientbank" class="td-content-input td-content-readonly" readOnly  label="对方银行"  type="text" />
			            	</td>
      				   	    
			            </tr>
			            <tr  class="tr-other-info tr-even">
			            	<td class="td-content-title">本方账户:  </td>  
			            	<td class="td-content">
			            		<input name="ownaccount" id="id_ownaccount"  require="true"  class="td-content-input td-content-readonly" label="本方账户"  readOnly type="text" />
			            	</td>
			            	<td class="td-content-title">对方账户:  </td>  
			            	<td class="td-content">
			            	   <input name="clientaccount"  class="td-content-input td-content-readonly" readOnly  label="对方账户" readOnly type="text" />
			            	</td>
			            </tr>
			             <tr  class="tr-other-info tr-odd">
			            	<td class="td-content-title">本方账号:  </td>  
			            	<td class="td-content">
			            		<input name="ownaccnumber"  id="id_ownaccnumber" require="true" class="td-content-input td-content-readonly" readOnly label="本方账号"  type="text" /><font class="required-content">*</font>
			            	</td>
			            	<td class="td-content-title">对方账号:  </td>  
			            	<td class="td-content">
			                 	<input name="clientaccnumber" class="td-content-input td-content-readonly"  readOnly label="对方账号"  type="text" />
			            	</td>
			            </tr>
			            <tr  class="tr-other-info tr-even">
			            	<td class="td-content-title">到账金额类型:  </td>  
			            	<td class="td-content">
			            		<input name="moneytype" require="true"  class="td-content-input td-content-readonly" readOnly label="到账金额类型"   type="text" /><font class="required-content">*</font>
			            	</td>
			            	<td class="td-content-title">到账金额:  </td>  
			            	<td class="td-content">
			            		<input name="factmoney" id="id_factmoney" require="true" class="td-content-input td-content-readonly"  readOnly label="到账金额" dataType="Money"  type="text" /><font class="required-content">*</font>
			            		</td>
			            </tr>
			            <tr  class="tr-other-info tr-odd">
			            	<td class="td-content-title">网银余额</td>  
			            	<td class="td-content">
			            	    <input id="id_owmoney"  name="owmoney" class="td-content-input td-content-readonly" readOnly label="网银余额" dataType="Money"  type="text" />
			            	</td>
			            	<td class="td-content-title">已核销金额:  </td>  
			            	<td class="td-content">
			            		<input  id="id_hiremoney" name="hiremoney" require="true" class="td-content-input td-content-readonly"  readOnly label="已核销金额" dataType="Money"  type="text" /><font class="required-content">*</font>
			            	</td>
			            </tr>
			            <tr  class="tr-other-info tr-even">
			               <td class="td-content-title">到账时间:  </td>  
			            	<td class="td-content">
			                 <input name="factdate" class="td-content-input td-content-readonly"  type="text" value="${requestScope['factdate'] }" readOnly require="true" label="到账时间" /><font class="required-content">*</font>
          	            	</td>
			            	<td class="td-content-title">与系统无关金额:  </td>  
			            	<td class="td-content">
			            		<input name="nowithmoney" id="id_nowithmoney" class="td-content-input" require="true" label="与系统无关金额" dataType="Money"  value="0.00" type="text" /><font class="required-content">*</font>
			            		<input type="hidden" id="id_befor_nowithmoney" name="befor_nowithmoney"></input>
			            	</td>
			            </tr>
			               <tr  class="tr-other-info tr-odd">
			            	
			            	<td></td><td></td>
			            </tr>
			            </tr>
			               <tr  class="tr-other-info tr-even">
			            	<td class="td-content-title">用途:  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="usefor"   class="td-content-input td-content-readonly" readOnly style="width:80%" label="用途"   type="text" ></textarea><font class="required-content">*</font>
			            	</td>
			            </tr>   
			            </tr>
			               <tr  class="tr-other-info tr-even">
			            	<td class="td-content-title">备注1:  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="summary"   class="td-content-input td-content-readonly" readOnly style="width:80%" label="备注1"   type="text" ></textarea><font class="required-content">*</font>
			            	</td>
			            </tr>   
			            </tr>
			               <tr  class="tr-other-info tr-even">
			            	<td class="td-content-title">备注2:  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="summarybak"   class="td-content-input td-content-readonly" readOnly style="width:80%" label="备注2"   type="text" ></textarea><font class="required-content">*</font>
			            	</td>
			            </tr>   
			            <tr class="content-separator">
				            <td colspan='4'>
				                 <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='tableSubmitCallback();'><span>确定</span></a>
						         <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
				            </td>
			            </tr>
			        </table>
		        </form>
	        </center>
	</div>
</body>
</html>