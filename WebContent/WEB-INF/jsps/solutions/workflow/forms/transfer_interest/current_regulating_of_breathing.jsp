<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
var constantFlagTable = "User";
var pageWidth  = document.documentElement.clientWidth-2;
var pageHeight = document.documentElement.clientHeight-2;
var editor;
jQuery(function(){
	 var table = new tracywindyOperationTable({
		 tableComment:'待回滚',
		 limit:20,
	     isNeedEnabled:false,
	     isNeedEnabledQuery:false,
	     operButtons:'',
	     border:true,
     	renderTo:'id_table_leasing_current_regulating_of_breathing_container',
     	width:formWidth,
     	id:'id_table_leasing_current_regulating_of_breathing_container',
     	xmlFileName:'/eleasing/workflow/money_rate/current_money_rate_list.xml',
     	loadMode:'ajax',
     	isPage:true,
     	isFit:true,
     	border:true,
     	windowTop:10,
     	checkType:'combox',
        isNewLineQueryButton:true,
        queryButtonColSpan:4,
        params:{
	     adjustid:"${requestScope['fund_standard_interest.id'] }",
	     docid:"${requestScope['docid'] }",
	     Central_Bank_id:'${empty Central_Bank_id ? "[]" : Central_Bank_id }'
	     },
     columns:[

		{header:'id',name:'id',hidden:true},
		{header:'faictid',name:'faictid',hidden:true},
		{header:'proj_id',name:'proj_id',hidden:true},
		{header:'custid',name:'custid',hidden:true},
		{header:'docid',name:'docid',hidden:true},
		{header:'合同号',name:'contractid'},
		{header:'业务合同号',name:'contractnumber'},
		{header:'客户名',name:'custname'},
		{header:'经销商',name:'custdealer'},
		{header:'设备款',name:'equipamt'},
		{header:'首付款',name:'firstpayment'},
		{header:'还租次数',name:'incomenumber'},
		{header:'付租类型',name:'incomenumberyear'},
		{header:'付租方式',name:'periodtype'},
		{header:'起租日期',name:'startdate'},
		{header:'利率',name:'yearrate'},
		{header:'内部收益率',name:'irr'},
		{header:'调息前利率',name:'rateoriginal'},
		{header:'调息后利率',name:'rateadjust'},
		{header:'调息前内部收益率',name:'oldirr'},
		{header:'调息后内部收益率',name:'newirr'},
		{header:'操作',align:'center',renderer:compare}
		],
        tools:[
		          {html:'<font style="color:red;font-weight:BOLD;">撤销</font>',iconCls:'icon-reckon',
			          handler:function(table){
			        	 // var currentTable = getTracywindyObject('table_id_table_leasing_todo_regulating_of_breathing_container');
			        	 var rowDatas  = table.getCheckedRowDatas();
		        		 if(rowDatas.length == 0){
		        			 jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>请选择需要撤销的合同</div>",'error');
		        		 }else {
		        			 revocationTX(rowDatas);
		        		 }
				  }}
		]
		 });
});


function compare(value,tableObj,columnName,columnIndex,rowData){
    // var base = "<a href='#' onclick='showRecorder(\""+rowData.id+"\")'>记录</a>";
    // var base2 = "<a href='#' onclick='downloadFile(\""+rowData.id+"\")'>下载</a>";
     //var base3 = "<a href='#' onclick='preview(\""+rowData.contractid+"\",\""+rowData.docid+"\")'>对比</a>";
     var base3 = "<a href='#' onclick='previewhis("+JsonUtil.encode(rowData)+")'>对比</a>";
     return base3; 
  }
function previewhis(data){
   /*var $previewDetailInfoWindowContainer = jQuery("#id_previewDetailInfoWindowContainer");
   $previewDetailInfoWindowContainer.show();
   var $previewDetailInfo = jQuery("#id_previewDetailInfo");
   $previewDetailInfo.html(content);
   $previewDetailInfoWindowContainer.window({top:20});
   $previewDetailInfoWindowContainer.window('open');*/
   var URL = "${pageContext.request.contextPath}/leasing/query/condition_temp/interestTempCompare.bi";
   var params = {contractid:data.contractid,docid:data.docid,read_only :false};
   openFullScreenWindow(URL,params);
}

//发Ajax到后台调用调息撤销acl
function revocationTX(rowDatas){
	if(confirm("确认对选中合同进行撤销?")){
		isContinue=true;
		c=rowDatas.length;
		jQuery("#msgButtonText").html("停止请求");//设置控制按钮
		shwoMessageWindwos();//显示操作信息层
		for(var i=0;i<rowDatas.length&&isContinue;i++){
			showMsg(rowDatas[i]["contractnumber"]+"开始请求撤销调息!");
			doSendTXCX(rowDatas[i]["id"],rowDatas[i]["contractnumber"]);//调用调息ajax
		}
	}
}
function doSendTXCX(cid,contractNumber){
	ajaxRequest({
	     url:"${pageContext.request.contextPath}/leasing/acl/removeAdjustinterest.acl",
	     params:{adjustid:"${requestScope['fund_standard_interest.id'] }",docid:"${requestScope['docid'] }",contractid:cid},
	     timeout:30*1000,
	     async:true,//改为同步请求
	     success:function(res){
	 		res=res.responseText;
	 		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
	 		showMsg(contractNumber+"撤销调息请求成功!反馈如下["+res+"]");
	 		txcxBackFun(cid);
	     },
	     failure:function(res){
	    	res=res.responseText;
	 		res=res.replace(/(^\s+)|(\s+$)/g, "");
	 		showMsg("<strong id='red'>"+contractNumber+"撤销调息请求失败!反馈如下["+res+"]</strong>");
	 		txcxBackFun(cid);
	  	 }
	});
}
function txcxBackFun(id){
	c--;
	if(c<=0){
		isContinue=false;
		jQuery("#msgButtonText").html("关闭");//设置控制按钮
	}
	if(id){
		var ids=jQuery("#id_adjust_contractids").val();
		ids=ids.replace(id,"").replace(",,",",");
		if(ids.indexOf(",")==0){
			ids=ids.substring(1);
		}
		if(ids.indexOf(",")==ids.length-1){
			ids=ids.substring(0,ids.length-1);
		}
		jQuery("#id_adjust_contractids").val(ids);
	}
}
</script>
