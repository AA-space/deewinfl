<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同归还</title>
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
	      var all_width = (document.documentElement||document.body).clientWidth-2;
	      var all_height = (document.documentElement||document.body).clientHeight-2;
	    </script>
<script type="text/javascript">
	jQuery(function(){
   	 var table = new tracywindyTable({

   		width:all_width,
		height:all_height,
		isCheck:false,
		isRank:false,
		toolsLeftMargin:938,
   		 tableComment:'[合同归还]',
   		 constantFlagTable:'OwnInfo',
   		 windowTop:20,
   	     border:true,
         renderTo:'id_tableContainer',
         title:'合同归还',
         id:'id_table',
         //xmlFileName:'/eleasing/jsp/own_manage/owninfo.xml',
         xmlFileName:'\\eleasing\\workflow\\contract\\doc_borrow.xml',
         loadMode:'ajax',
         isPage:false,
         isFit:true,
         isCheck:true,
         isRank:true,
         //isNeedGlobalQuery:false,//全局搜索隐藏
         tools:[{
        	 html : '<font color="red">归还按钮</font>',
 			handler : function(table) {
 				var datas = table.getCheckedRowDatas();
 				if (0 == datas.length) {
 					alert("请选择需要归还的合同！");
 					return;
 				}
 			 	var ids = [];
 			 	for ( var int = 0; int < datas.length; int++) {
 			 		ids.push(datas[int]['id']);
				}
 			 	$('#id_detailInfoWindowContainer').dialog({   
 			 	    title: '合同归还',   
 			 	    closed: false,   
 			 	    cache: false,   
 			 	    modal: true  
 			 	});   

 			 	$('#id_detailInfoWindowContainer').dialog('open');  
 			 	$('#returnids').val(ids.join(','));
 		
 				
 			},
 			iconCls :'icon-update'

             }],
         columns:[
		            {header:'id',name:'id',hidden:true},
		            {header:'合同编号',name:'contractid',queryConfig:{}},
		            {header:'业务合同号',name:'contractnumber',queryConfig:{}},
		            {header:'客户名称',name:'custname',queryConfig:{}},
		            {header:'合同档案名称',name:'docname'},
		            {header:'借阅人',name:'brrowuser'},
		            {header:'借阅时间',name:'datelimit',isRange:true,type:'date',queryConfig:{isNewLine:true}},
		            {header:'二次寄送快递单号',name:'borrowsendno'}
		            //{header:'寄送/借阅',name:'column5'},
	        ]
   	 });
   	 
   	 
     new tracywindyComboBox({
			lazyLoad:true,
			id : 'id_returnuser',
			width : 167,
			renderTo : 'returnuser',
			xmlFileName : '\\eleasing\\workflow\\public\\creator_combox.xml',
			loadMode : 'ajax',
			readOnly : false,
			isAjaxLenovo : true,
			otherAttributes:'require="true"  label="归还人"',
			topAdd : 0,
			leftAdd : 0,
			positionDropIconLeftAdd : -1,
			name : 'retrunuser',
			displayField : 'name',
			valueField : 'id'
			
		});
   });
 
	function submitData(){
		var param = {};
		param.ids = $('#returnids').val();
		param.returndate = $('#returndate').val();
		param.returnuser =  getTracywindyObject('id_returnuser').getValue();
		var s = Validator.Validate($('#id_detailInfoForm')[0], 1, false);
		if(Validator.Validate($('#id_detailInfoForm')[0], 1, false)){
			$.post('leasing/docReturn.action', param, function(i,v){
				if(i == 'success'){
					alert('归还成功');
					getTracywindyObject('id_table').reload();
					jQuery("#id_detailInfoWindowContainer").window("close");
				}
			});
		}
	}
	
 
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
   	<div id="id_detailInfoWindowContainer" buttons="#id-dialog-buttons" title="添加合同登记信息" style="padding-top:18px;;display: none; width: 400px; height: 200px; overflow: hidden;">
		<center>
			<form id="id_detailInfoForm">
				<table style="width: 90%;margin:auto;padding:auto;">
					<tr style="display: none">
						<td><input id="returnids" type="hidden" value="" /></td>
					</tr>

					<tr>
						<td class="input_label_desc" align="left">归还日期:</td>
						<td class="td-content"><input class="td-content-input td-content-readonly Wdate" style="float: left"  label="归还日期" require="true" onClick="WdatePicker(this,{readOnly:true,dateFmt:'yyyy-MM-dd'})" id='returndate' name="signdate" readonly name="column4" type="text"><span style="float: left" class="content-required">*</span></td>
					</tr>
					<tr>
						<td class="input_label_desc" align="left">归还人:</td>
						<td class="td-content"><div id='returnuser' style="float: left" ></div><span class="content-required">*</span></td>
					</tr>
				</table>
			</form>
		</center>
	</div>
	<div id="id-dialog-buttons" style="height: 40px; display: none; line-height: 40px; width: 400px; text-align: center;">
		<table width="100%">
			<tr style="text-align: center">
				<td colspan='4'><a style="margin-left: 20px;" href="javascript:void(0);" class="btn btn-primary" onclick='submitData();'><span>确定</span></a> <a style="margin-left: 20px;"
					href="javascript:void(0);" class="btn btn-primary" onclick='jQuery("#id_detailInfoWindowContainer").window("close");'
				><span>取消</span></a></td>
			</tr>
		</table>
	</div>
	
</body>
</html>