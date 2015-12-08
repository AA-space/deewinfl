<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金计划应开票提醒清单（每期租金）</title>
<!--css sheet-->
<link href="${pageContext.request.contextPath}/css/dtree/dtree.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/tracywindy.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/tracywindy/button.css" rel="stylesheet" type="text/css">
<!--javascript libray-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyUtils.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyJsonUtil.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyAjax.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree/dtree.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyLoadMask.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyTable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyComboBox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/workFlowUtil.js"></script>
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
   		 renderTo:'id_tableContainer',
   		 width:all_width,
		 height:all_height,
		 //toolsLeftMargin:200,
		 windowTop:20,
   	     border:true,
         title:'租金计划应开票提醒清单（每期租金）',
         tools : [ {
  			html : '<font color="red">生成开票清单</font>',
  			handler : function(table) {
  				var projIDValue = table.getCheckedRowDatas();
  				if (0 == projIDValue.length) {
  					alert("请选择需要的开票清单！");
  					return false;
  				}
  				var attachmentParams = "proj_id=" + projIDValue[0].proj_id;
  				
  			},
  			iconCls : 'icon-update'
  		} ],
         
         id:'id_table',
         xmlFileName:'/eleasing/jsp/cust_account/cust_account_info.xml',
         loadMode:'ajax',
         isPage:true,
         pageSize : 20,
         isFit:true,
         isCheck:true,
 		 isRank:false,
         columns:[
			       {name:'id',  header:'id',hidden:true},
			       {name:'tablename305',  header:'合同号',nullable:false },
			       {name:'tablename306',  header:'客户名称',nullable:false },
			       {name:'tablename307',  header:'设备名称',nullable:false },
			       {name:'tablename309',  header:'期项',nullable:false },
			       {name:'tablename310',  header:'租金',nullable:false },
			       {name:'tablename311',  header:'本金',nullable:false },
			       {name:'tablename312',  header:'利息',nullable:false },
			       {name:'tablename312',  header:'金额类型',nullable:false },
			       {name:'tablename308',  header:'应收日期',nullable:false },
			       {name:'tablename312',  header:'发票类型',nullable:false },
			       {name:'tablename312',  header:'开票方式',nullable:false },
			       {name:'status',  header:'状态',nullable:false }
			       
	       	     ]
   	 });
   });
    
 
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
	
</body>
</html>

