<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租赁物管理  - 设备管理</title>
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
	   td.td-content{
	     text-align:left;
	   }
	   td.td-content input{
	      width:165px;
	      float:left;
	      border:1px solid #DDD;
	   }
	   td.td-content textarea{
	      width:90%;
	      overflow:auto;
	      float:left;
	      border:1px solid #DDD;
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
   	       }
     	 },
   		 loadFormDataCallBack:function(table,$form,rowIndex){
   		    var rowData = table.getRowDataAt(rowIndex);
   		 	var select_contract = getTracywindyObject("id_combo_equipclassname");
	        select_contract.setValue(rowData["equipclass"]);
	        //var select_contract = getTracywindyObject("id_combo_equiptypename");
	        //select_contract.setValue(rowData["equiptype"]);
	        var select_contract = getTracywindyObject("id_combo_id_is_enable");
	        select_contract.setValue(rowData["enable"]);
   	        
        },
   		 tableComment:'[设备管理]',
   		 constantFlagTable:'EquipManagement',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'设备管理',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         id:'id_table',
         xmlFileName:'/eleasing/jsp/lease_management/equip_management.xml',
         //params:param,
         loadMode:'ajax',
         isPage:true,
         operButtons:'新增|修改|删除|状态',
         enabledPromit:'无效',
         disabledPromit:'有效',
         enabledDefaultValue:'0',
         isFit:true,
         columns:[
					{header:'id',name:'id',hidden:true},
					{header:'设备分类',name:'equipclassname',type:'combobox',queryConfig:{
						loadMode:'ajax',
						isAjaxLenovo:true,    
			 		    readOnly:false,
			 		    width:200,
						xmlFileName:'\\combos\\comboDict.xml',
			            displayField:'name',
			            name:'name',
			            valueField:'code',
			            params:{
			                pid:'equip_class'
			             }
			        }},
		           // {header:'设备类别',name:'equiptypename'},
		            {header:'型号',name:'model',queryConfig:{}},
		            {header:'计量单位',name:'unit'},
		            {header:'厂商',name:'manufacturer'},
		            {header:'启用停用',name:'enablename'}
	        ]
   	 });
   });

</script>

 <script type="text/javascript">
     jQuery(function(){
    	 dictOnSelect('equipclassname','equipclass','equip_class',null,null,'require="true" label="设备分类"');
    	 //dictOnSelect('equiptypename','equiptype','equip_type',null,null,'label="设备类型"');
    	 var combo = new tracywindyComboBox({
    		 lazyLoad:true,
    	      id:'id_combo_id_is_enable',
    	      renderTo:'id_is_enable',
    	      loadMode:'local',
    	      datas:[{title:'禁用',name:'1'},{title:'启用',name:'0'}],
    	      readOnly:true,
    	      topAdd:0,
    	      leftAdd:0,
    	      name:'enable',
    	      displayField:'title',
    	      valueField:'name'
    			});

    	      });
     
     
     function submitEquiment(){
    	 
    	 
    	 var equipclassname = getTracywindyObject("id_combo_equipclassname").getValue();
    	 //var equiptypename = getTracywindyObject("id_combo_equiptypename").getValue();
    	 param = {};
    	 param.equipclassname = equipclassname;
    	 //param.equiptypename = equiptypename;
		$.ajax({
				url : "leasing/equipmentManagerCheck.action",
				async : false,
				type : "post",
				dataType : "json",
				data : param,
				success : function(data) {
				}
			});

			getTracywindyObject("id_table").operationTable();
		}
	</script>
</head>
<body>
    <div id="id_tableContainer"></div>
    <div id="id_detailInfoWindowContainer" buttons="#id-dlg-buttons" closed="true" modal="true" title="设备管理" style="display:none;width:800px;height:200px">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:95%" class="fillTable">
			            <tr style="display:none"><td><input name="id" type="hidden" value=""/></td></tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">设备分类:  </td>  
			            	<td class="td-content" >
			            	 <div id="equipclassname" class="leftComboContainer" style="float:left"></div><font class="required-content">*</font></td>
			               <!-- 
			               <td class="td-content-title">设备类别:  </td>  
			            	<td class="td-content">
			            	 <div id="equiptypename" class="leftComboContainer" style="float:left"></div></td>
			                -->
			            </tr>
			            <tr  class="tr-even">
			            	<td class="td-content-title">型号:  </td>  
			            	<td class="td-content">
			            	 <input name="model"  id="model" class="td-content-input" require="true" type="text"  maxlength="20" label="型号"  maxB="20" /><font class="required-content">*</font></td>
			           <td class="td-content-title">计量单位:  </td>  
			            	<td class="td-content" > 
			            		<input name=unit class="td-content-input"   maxlength="20"  label="计量单位"  maxB="20"   type="text" />
			            	</td>
			            </tr>
			            <tr  class="tr-odd">
			            	<td class="td-content-title">厂商:  </td>  
			            	<td class="td-content" >
			            		<input name="manufacturer"  class="td-content-input"   maxlength="200"  label="厂商"   maxB="200"  type="text" />
			            	</td>
			            	<td class="td-content-title">启用停用:  </td>  
			            	<td class="td-content" colspan="3">
			            		<div id="id_is_enable" class="leftComboContainer" style="float:left"></div><font class="required-content">*</font></td>
			            </tr>
			        </table>
		        </form>
	        </center>
	        <div style="text-align:center;width:800px;display:none;height:40px;line-height:40px;" id="id-dlg-buttons">
		  		<a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='submitEquiment()'><span>确定</span></a>
		  		<a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
			</div>
	</div>
</body>
</html>
