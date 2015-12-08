<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商务条款内容</title>
	<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/tracywindy/workFlowUtil.css" rel="stylesheet" type="text/css">
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
//流程历史信息

	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
	jQuery(function(){
   	 var table = new tracywindyOperationTable({   		 
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'修改商务条款内容-[不含合同完成、撤销]',
         width:parseInt("${param.tableWidth}")||pageWidth,
         height:parseInt("${param.tableHeight}")||pageHeight,
         xmlFileName:'/eleasing/jsp/query/updatecontract_conditioninfo.xml',
         loadMode:'ajax',
         operButtons:'修改',
         constantFlagTable:'ManagerCondition',
         isExcel:true,
         id:'id_table',
         isAutoBreakContent:true,
         isPage:true,
         isFit:true,
         columns:[
		            {header:'id',name:'id',hidden:true},//true
		            {header:'业务合同号',name:'contracnumber',queryConfig:{}},
		            {header:'关键字(可查项目、客户、经销商名称)',name:'projectname',queryConfig:{}},
		            {header:'免罚息天数',name:'freedefainterday'},
		            {header:'起租日期',name:'startdate',type:"date",isRange:true,queryConfig:{isNewLine:true}},
		            {header:'合同状态',name:'statusname'}
	        ]
   	 });
   });

</script>

</head>
<body>
	<div id="id_tableContainer"></div>
	<div id="id_detailInfoWindowContainer" buttons="#id-dlg-buttons" closed="true" modal="true" title="修改商务条款内容" style="display:none;">
	        <center>
		        <form id="id_detailInfoForm">
			        <table style="width:100%" class="fillTable">
			             <tr style="display:none">
			             	<td><input name="id" id="id"  type="hidden" value=""/></td>
			             </tr>
			            <tr class="tr-even">
			            <td class="td-content">合同号:  </td>  
			            	<td class="td-content" colspan="3">
			            		<input name="contracnumber" id="contracnumber" label="合同号"  class="td-content-input td-content-readonly"  readonly  type="text" />
			            	</td>
			            </tr>
			            <tr class="tr-even">
			            <td class="td-content">免罚息天数:  </td>  
			            	<td class="td-content" colspan="3">
			            		<input name="freedefainterday" id="freedefainterday" label="免罚息天数" class="td-content-input"  type="text" />
			            	</td>
			            </tr>
			            <tr class="tr-odd">
			            <td class="td-content">起租日期:  </td>  
			            	<td class="td-content" colspan="3">
			            		<input name="startdate" id="startdate"  label="免罚息天数" onClick="WdatePicker(this,{readOnly:true})"  class="Wdate td-content-input td-content-readonly"  readonly type="text" />
			            	</td>
			            </tr>
			          </table>
	            </form>
            </center>
            <div style="text-align:center;width:800px;display:none;height:40px;line-height:40px;" id="id-dlg-buttons">
				  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='submitCust();'><span>确定</span></a>
				  <a  style="margin-left:20px;" href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'><span>取消</span></a>
			</div>
     </div>
			            
	<script type="text/javascript">
		function submitCust(){
			
			var url = "${pageContext.request.contextPath}/leasing/updateManagerCondition.action";
			var id=$("#id").val();
			var freedefainterday=$("#freedefainterday").val();
			var startdate =$("#startdate").val();
			var params = {id:id,freedefainterday:freedefainterday,startdate:startdate};
			var loadMask_oper = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');
			loadMask_oper.show();
				 ajaxRequest({
			    	 method:'POST',
			         url:url,
			         params:params,
			         failure:function(res){},
			         success:function(res)
			         {
	 			 	   		res=res.responseText;
	 			 	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
	 			     	    if(res != '')
	 			     	    {
	 			     	    	if(res=="yes")
	 			     	    	{
	 			     	    		alert("修改成功!");
	 			     	    		jQuery("#id_detailInfoWindowContainer").window("close");
	 			     	    		getTracywindyObject("id_table").reload();
	 			     	    		loadMask_oper.hide();
	 			     	    	}else{
	 			     	    		alert("修改失败!");
	 			     	    		getTracywindyObject("id_table").reload();
	 			     	    		loadMask_oper.hide();
	 			     	    	}
	 			     	    }
	 			  }
			    });
		}
	
	</script>
	
</body>
</html>