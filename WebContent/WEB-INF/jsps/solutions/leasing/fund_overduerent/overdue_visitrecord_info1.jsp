<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
var cust_id="${param.cust_id}";

var param={};
if(cust_id!="null" || cust_id==""){param.CUST_ID=cust_id;}
	var constantFlagTable = "User";
	var ebankUploadUrl="";
	var ebankAttachUrl="";
	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 new tracywindyOperationTable({
   		resetFormCallback:function(table,$form,operFlag){
   		 if("add" == operFlag){
   	   	jQuery("#id_visitcustid").val(cust_id);
   	   	var custInfoParam = {};
   		custInfoParam.contractid = contract_id;
   		custInfoParam.custid = cust_id;
   		    $.post('${pageContext.request.contextPath}/leasing/acl/getCustVisitInfo.acl?radom=' + Math.random(), custInfoParam, function(value){
   			var src = null;
   			if(value.indexOf("查询失败") != -1){
   				alert(value);
   				return;
   			}
   			value = eval('(' + value + ')'); 
   			var $title = $('#title');
   			jQuery("#id_vicustname").val(value.custname);
   			jQuery("#id_is_equipamt").val(value.equipamt);
   			jQuery("#corpus").val(value.equipamt-value.incomedata);
   			if(src != null){
   				$("#iframe").attr("src", src);
   			}
   		    });
   	       }
     	 },
   		 loadFormDataCallBack:function(table,$form,rowIndex){
     		var rowData = table.getRowDataAt(rowIndex);	   
     		var select_contract = getTracywindyObject("id_combo_id_is_contactType");
	   	     select_contract.setValue(rowData["contacttype"]);  
        },
   		 tableComment:'[走访记录]',
   		 constantFlagTable:'FundOverduerent',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableVistContainer',
         formContainerId:'id_vdetailInfoWindowContainer',
         title:'走访记录',
         width:window.formWidth||parseInt("${param.tableWidth}")||pageWidth,
         id:'id_from_table',
         xmlFileName:'/eleasing/jsp/fund_overduerent/overdue_visitrecord_info.xml',
         loadMode:'ajax',
         params:{CUST_ID:cust_id,CONTRACT_ID:contract_id},
         isPage:true,
         isFit:true,
         columns:[
                    {header:'id',name:'id',hidden:true},
                    {header:'客户id',name:'custid',hidden:true},
		            {header:'客户名称',name:'custname'},
		            {header:'走访日期',name:'contactdate'},
		            {header:'合同金额(元)',name:'rent'},
		            {header:'合同余额(万元)',name:'corpus'},
		            {header:'走访方式',name:'contacttypename'},
		            {header:'走访对象',name:'contactperson'},
		            {header:'客户异常',name:'custexp'},
		            {header:'客户需求',name:'custrequire'},
		            {header:'登记时间',name:'createdate'},
		            {header:'最后修改时间',name:'modifydate'}
	        ]
   	 });
   	dictOnSelect('id_is_contactType','contacttype','contact_type',null,null,false,true,165); //走访方式
    });
</script>
    <div id="id_tableVistContainer"></div>
    <div id="id_vdetailInfoWindowContainer"  closed="true" modal="true" title="走访记录" style="display:none;width:900px;padding-top:20px;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:90%">
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
			            <tr>
			            	<td class="input_label_desc">客户名称:  </td>  
			            	<td class="td-content" >
			            	    <input name="custid" id="id_visitcustid" type="hidden" />
			            		<input name="custname" id="id_vicustname" readonly="readonly"  label="客户名称" class="td-content-input"  type="text" /></td>
			                <td class="input_label_desc">走访日期:  </td>  
			            	<td class="td-content">
			            		<input name="contactdate" id="contactdate"  label="走访日期"  class="Wdate td-content-input td-content-readonly"  onClick="WdatePicker(this,{readOnly:true})" readOnly   type="text" />
			            </tr>
			            <tr>
			            	<td class="input_label_desc">合同金额(元）:  </td>  
			            	<td class="td-content">
			            		<input id="id_is_equipamt" name="rent" label="合同金额(元）" readonly="readonly" class="td-content-input td-content-readonly"  type="text" />
			            	</td>
			            	<td class="input_label_desc">合同余额(万元):  </td>  
			            	<td class="td-content">
			            	<input name="corpus" id="corpus" label="合同余额(万元)" readonly="readonly" class="td-content-input td-content-readonly"   type="text" />
			            	</td> 
			            </tr>
			            <tr>
			            	<td class="input_label_desc">走访方式:  </td>  
			            	<td class="td-content">
			            	 <div id="id_is_contactType" class="leftComboContainer" style="float:left"></div><font color="red">*</font>
			            	</td>
			            	<td class="input_label_desc">走访对象:  </td>  
			            	<td class="td-content">
			            	   <input name="contactperson" require="true" label="走访对象"  type="text"  class="td-content-input" /><span class="content-required">*</span>
			            	</td>
			            </tr>
			             <tr>
			            	<td class="input_label_desc">客户异常:  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="custexp" require="true"   class="td-content-input"   style="width:84%" label="客户异常"   type="text" ></textarea><span class="content-required">*</span>
			            	
			            	</td>
			            </tr>
			             <tr>
			            	<td class="input_label_desc">客户需求:  </td>  
			            	<td class="td-content" colspan="3">
			            		<textarea name="custrequire" require="true"   class="td-content-input"  style="width:84%" label="客户需求"   type="text" ></textarea><span class="content-required">*</span>
			            	
			            	</td>
			            </tr>
			            <tr>
			            	<td class="input_label_desc">登记时间:  </td>  
			            	<td  style="float:left">
			            	<input name="createdate" id="createdate"  label="登记时间" isDefaultDate="true"  readOnly   type="text" />
			            	</td>
			         		<td class="input_label_desc">最后修改时间:  </td>  
			            	<td  style="float:left" >
			            	<input name="modifydate" id="modifydate" label="登记时间" isDefaultDate="true"  readOnly   type="text" /></td>
			            </tr>
			            <tr class="content-separator">
				            <td colspan='4'>
				                 <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary"onclick='getTracywindyObject("id_from_table").operationTable();'><span>确定</span></a>
						         <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_vdetailInfoWindowContainer").window("close");'><span>取消</span></a>
				            </td>
			            </tr>
			        </table>
		        </form>
	        </center>
	</div>
	<script language="javascript">
function initVisitrCustInfoName(cust_id){
window.currentLoadMask = new tracywindyLoadMask(document.body,"正在初始化 请稍等..."); 
currentLoadMask.show();
        var param={};
        param.custID=cust_id;
        param.xmlFileName='\\eleasing\\workflow\\public\\SimpleCustSelect.xml';
    	ajaxRequest({
		     url:'${pageContext.request.contextPath}/table/getTableData.action',
		     method:'POST',
		     success:function(res){
	   		    var scustinfo=res.responseText;
	   		    scustinfo=scustinfo.replace(/(^\s+)|(\s+$)/g, ""); 
	   		    var cust=eval("("+scustinfo+")");
	   		    var currentRowData=cust.datas[0];
	   		    $("#id_vcustname").val(currentRowData.name);
	   		    $("#id_vcustid").val(cust_id);
	   		   currentLoadMask.hide();
		     },
		     async:false,
		     failure:function(res){
		    	 currentLoadMask.hide();
			     },
		     params:param
	 });
    }
</script>