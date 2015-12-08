<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kernal.utils.FileUtil,com.kernal.utils.WebUtil" %>
<%@ taglib prefix='permission' uri='/WEB-INF/tlds/permission.tld' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租金计划应开票提醒清单（本金）</title>
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
var currentLoginUserId = "${sessionScope['login_userid']}";
var isAdmin=false;
var tools=[ {
		html : '<font color="red">生成开票清单</font>',
			handler : function(table) {
    	 var operType = "生成";
			var operTitle = "租金计划应开票提醒清单（本金）";
			var operAction = "submitRentCorpusOnce";
	 		var checkedRowDatas = table.getCheckedRowDatas();
			var currentLoadMask = null;
	        var params = {};
	        var tempIdArr = [];
	        //var tempPIdArr = [];
	        for(var i = 0;i<checkedRowDatas.length;i++){
				var checkedRowdata = checkedRowDatas[i];
				var id = checkedRowdata.id;
				//var paymentid=checkedRowdata.paymentid;
				tempIdArr.push(id);
				//tempPIdArr.push(paymentid);
			}
			params["ids"] = tempIdArr.join(",");
			//params["paymentids"] = tempPIdArr.join(",");
	 		if(0 == checkedRowDatas.length){
 			alert("请选择要"+operType+"的记录！！");
 			return;
 			}
	 		for(var i =0;i<checkedRowDatas.length;i++){
				var checkedRawData=checkedRowDatas[i];
				if("已确认"==checkedRawData.invoicestatus){
					alert("该条"+operTitle+"已确认，不允许退回！！！");
					return;
					} 
			}
			if(!window.confirm(("确定"+operType+"当前"+checkedRowDatas.length+"条记录么？"))) return;
			var loadMaskMsg="正在"+operType+operTitle+"    请稍后... ";
			var url=getRootPath()+"/acl/"+operAction+".acl";
			currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
			currentLoadMask.show();
			ajaxRequest({
             url:url,
             params:params,
             timeout:30*1000,
             success:function(res){//孙传良 修改  显示出action返回值
     	   		res=res.responseText;
     	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
		     	    if(res!=''){
			    	 	alert(res);
		     	    }else{
		     	    	alert(operType+operTitle+"成功！！");
		     	    }
                 currentLoadMask.hide();
                 table.reload();
                 //successCallBack(table);
             }
        });
			},
			iconCls : 'icon-update'
		} ];
</script >
<permission:action  code="interest_master">
<script type="text/javascript">
isAdmin=true;
tools='';
</script >
</permission:action>

<permission:action  code="rent_account">
<script type="text/javascript">
isAdmin=true;
tools='';
</script >
</permission:action>

<permission:action  code="tax_account">
<script type="text/javascript">
isAdmin=true;
tools='';
</script >
</permission:action>
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
         title:'租金计划应开票提醒清单（本金）',
         tools : tools,
         
         id:'id_table',
         xmlFileName:'/eleasing/jsp/invoice_manage/rent_invoice/rent_invoice_corpus_once.xml',
         loadMode:'ajax',
         isPage:true,
         pageSize : 20,
         isFit:true,
         isCheck:true,
 		 isRank:false,
         columns:[
			       {name:'id',  header:'id',hidden:true},
			       {name:'contractid',  header:'合同号',nullable:false,queryConfig:{} },
			       {name:'contractnumber',  header:'业务合同号',nullable:false,queryConfig:{} },
			       {name:'custname',  header:'客户名称' },
			       {name:'invoicetype',  header:'开票类型',nullable:false },
			       {name:'allcorpus',  header:'本金总额',type:'double',nullable:false },
			       {name:'invoicestatus',  header:'状态',nullable:false,type:'combobox',
			    	   queryConfig:{
			    	   isNewLine:false,
			    	   colSpan:3, 
			    	   loadMode:'local',
			    	   datas:[
			    	   {title:'已导出',name:'已导出'},
			    	   {title:'已确认',name:'已确认'},
			    	   {title:'已退回',name:'已退回'},
			    	   {title:'确认中',name:'确认中'},
			    	   {title:'未提交',name:'未提交'},
			    	   {title:'全部',name:''}
			    	   ],
			    	   displayField:'title',
			    	   valueField:'name',
			    	   defaultValue:1
			    	   }
			    	   			        }
			       
	       	     ]
   	 });
   });
    
 
</script>
</head>
<body>
    <div id="id_tableContainer"></div>
	
</body>
</html>

