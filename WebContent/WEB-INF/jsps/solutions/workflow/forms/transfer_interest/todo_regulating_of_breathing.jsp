
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
	if(isSubTable){
	 var table_ = new tracywindyOperationTable({
		 title:'待调息列表',
		 constantFlagTable:'TransferInterest',
	     isNeedEnabled:false,
	     isNeedEnabledQuery:false,
	     operButtons:'',
	     checkType:'combox',
	     border:true,
	     renderTo:'id_table_leasing_todo_regulating_of_breathing_container',
	     id:'id_table_leasing_todo_regulating_of_breathing_container_table',
	     width:formWidth,
	     xmlFileName:'/eleasing/workflow/money_rate/todo_money_rate_list.xml',
	     loadMode:'ajax',
	     isPage:true,
	     isFit:false,
	     border:true,
	     windowTop:10,
	     isNewLineQueryButton:true,
	     queryButtonColSpan:4,
	     params:{
		     adjustid:"${requestScope['fund_standard_interest.id'] }",
		     docid:"${requestScope['docid'] }"
		 },
	     columns:[
				{header:'id',name:'id',hidden:true},
				{header:'proj_id',name:'projid',hidden:true},
				{header:'custid',name:'custid',hidden:true},
				{header:'docid',name:'docid',hidden:true},
				{header:'合同号',name:'contractid',width:100,queryConfig:{}},
				{header:'业务合同号',name:'contractnumber',width:150,queryConfig:{}},
				{header:'客户名',name:'custname',width:200,queryConfig:{isNewLine:true}},
				{header:'经销商',name:'custdealer',width:200,queryConfig:{}},
				{header:'设备款',name:'equipamt'},
				{header:'首付款',name:'firstpayment'},
				{header:'还租次数',name:'incomenumber'},
				{header:'付租类型',name:'incomenumberyear'},
				{header:'付租方式',name:'periodtype'},
				{header:'起租日期',name:'startdate'},
				{header:'利率',name:'yearrate'},
				{header:'内部收益率',name:'irr'},
	            {header:'操作',align:'center',width:120,
					renderer:function(value,tableObj,columnName,columnIndex,rowData){
	                return "<a href='javascript:void(0);' onclick='viewShowCondition(\""+rowData["id"]+"\")'>当前商务条件查看</a>";
					}
	    	     }

        ],
        //点击调息调用撤销Ajax
        tools:[
	          {html:'<font style="color:red;font-weight:BOLD;">调息</font>',iconCls:'icon-reckon',
		          handler:function(table){
		        	  //var currentTable = getTracywindyObject('table_id_table_leasing_todo_regulating_of_breathing_container');
		        	 var rowDatas  = table.getCheckedRowDatas();
	        		 if(rowDatas.length == 0){
	        			 jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>请选择需要调息的合同</div>",'error');
	        		 }else {
	        			 todoTX(rowDatas);
	        		 }
			  }}
		]
	 });
	}
});
//查看商务条件
function viewShowCondition(contractId){
	var URL = "${pageContext.request.contextPath}/leasing/selectContractCondition.action?contractid="+contractId;
    openFullScreenWindow(URL);
}
var isContinue=true;//控制循环是否继续
var c;
//总循环控制调息
function todoTX(rowDatas){
	if(confirm("确认对选中合同进行调息?")){
		isContinue=true;
		c=rowDatas.length;
		jQuery("#msgButtonText").html("停止请求");//设置控制按钮
		shwoMessageWindwos();//显示操作信息层
		for(var i=0;i<rowDatas.length&&isContinue;i++){
			showMsg(rowDatas[i]["contractnumber"]+"开始请求调息!");
			doSendTX(rowDatas[i]["id"],rowDatas[i]["contractnumber"]);//调用调息ajax
		}
	}
}

//显示操作信息层
function shwoMessageWindwos(){
	jQuery("#id_station_message").show();
	jQuery("#id_station_message").dialog({
    	zIndex:9000,
    	draggable:true,
    	top:150,
    	resizable:true,
    	shadow:true,
    	modal:true,
    	inline:false,
    	collapsible:false,
    	minimizable:false,
    	maximizable:false,
    	closable:false,
    	closed:false
    });
}
function msgButton(){
	if(isContinue){
		if(confirm("确认中断调息吗?")){
			isContinue=false;
			showMsg("调息被人为中断!");
			jQuery("#msgButtonText").html("关闭");//设置控制按钮
			return;
		}
	}else{
		//把信息写入富文本域
		var msg=jQuery("#msg_memo").html();
		while(msg.indexOf("<br>")>=0){
			msg=msg.replace("<br>","\n");
		}
		jQuery("#tx_text_memo").val(jQuery("#tx_text_memo").val()+msg);
		jQuery("#msg_memo").html("");
		//重新加载列表
		getTracywindyObject("id_table_leasing_todo_regulating_of_breathing_container_table").reload();
		getTracywindyObject("id_table_leasing_current_regulating_of_breathing_container").reload();
		jQuery("#id_station_message").window("close");
	}
}
//往控制台显示消息
function showMsg(msg){
	msg="-------------------------------------------------------------------------<br>"+msg+"<br>";
	jQuery("#msg_memo").html(jQuery("#msg_memo").html()+msg);
}
//发contract——id 到后台调用调息函数
function doSendTX(cid,contractNumber){
	ajaxRequest({
	     url:"${pageContext.request.contextPath}/leasing/acl/addAdjustinterest.acl",
	     params:{adjustid:"${requestScope['fund_standard_interest.id'] }",docid:"${requestScope['docid']}",contractid:cid},
	     timeout:30*1000,
	     async:true,//改为同步请求
	     success:function(res){
	 		res=res.responseText;
	 		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
	 		showMsg(contractNumber+"调息请求成功!反馈如下["+res+"]");
	 		txBackFun(cid);
	     },
	     failure:function(res){
	    	res=res.responseText;
	 		res=res.replace(/(^\s+)|(\s+$)/g, "");
	 		showMsg("<strong id='red'>"+contractNumber+"调息请求失败!反馈如下["+res+"]</strong>");
	 		txBackFun();
	     }
	});
}
function txBackFun(id){
	c--;
	if(c<=0){
		isContinue=false;
		jQuery("#msgButtonText").html("关闭");//设置控制按钮
	}
	if(id){
		jQuery("#id_adjust_contractids").val(jQuery("#id_adjust_contractids").val()+(jQuery("#id_adjust_contractids").val()==""?"":",")+id);
	}
}
</script>