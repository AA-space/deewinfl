<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
var constantFlagTable = "User";
var pageWidth  = document.documentElement.clientWidth-2;
var pageHeight = document.documentElement.clientHeight-2;
var editor;
jQuery(function(){
	 var table = new tracywindyOperationTable({
		 tableComment:'已调息可回滚记录列表',
		 limit:20,
		 constantFlagTable:'Notice',
	     isNeedEnabled:false,
	     isNeedEnabledQuery:false,
	     operButtons:'',
	     border:true,
	     renderTo:'id_table_already_regulating_of_breathing_container',
	     width:formWidth,
	     id:'id_table1',
	     xmlFileName:'/eleasing/workflow/money_rate/already_money_rollback_list.xml',
	     loadMode:'ajax',
	     isPage:true,
	     isFit:true,
	     border:true,
	     windowTop:10,
	     checkType:'combox',

	     beforeSubmitData:function($form,params){
	    	 var content = editor.html().replace(/(\r|\n)/gim,"");
	    	 params["content"]= content;
	     },
     isNewLineQueryButton:true,
     queryButtonColSpan:4,
     params:{
	     adjustid:"${requestScope['fund_standard_interest.id']}",
	     docid:"${requestScope['docid']}"
	     },
     columns:[
			{header:'id',name:'id',hidden:true},
			{header:'projid',name:'projid',hidden:true},
			{header:'custid',name:'custid',hidden:true},
			{header:'adjustid',name:'adjustid',hidden:true},
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
			{header:'状态',name:'status'},
			{header:'操作',align:'center',renderer:function(value,tableObj,columnName,columnIndex,rowData){
			      value = value.replace(/(\r|\n)/gim,"");
			      value = value.replace(/\"/gim,'&quot;');
			      value = value.replace(/\'/gim,"&acute");
			      return "<a href='javascript:void(0);' onclick=\"preview('"+value+ "')\">对比</a>";  
			  }}
			    ],
	    //点击调息调用撤销Ajax
        tools:[
	          {html:'<font style="color:red;font-weight:BOLD;">回滚</font>',iconCls:'icon-reckon',
		          handler:function(table){
		        	  //var currentTable = getTracywindyObject('table_id_table_leasing_todo_regulating_of_breathing_container');
		        	  	
		        	 var rowDatas  = table.getCheckedRowDatas();
	        		 if(rowDatas.length == 0){
	        			 jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>请选择需要调息的客户</div>",'error');
	        		 }else {
	        			 rollBackTX(rowDatas);
	        		 }
			  }}
		]
	 });
});
function preview(content){
   var $previewDetailInfoWindowContainer = jQuery("#id_previewDetailInfoWindowContainer");
   $previewDetailInfoWindowContainer.show();
   var $previewDetailInfo = jQuery("#id_previewDetailInfo");
   $previewDetailInfo.html(content);
   $previewDetailInfoWindowContainer.window({top:20});
   $previewDetailInfoWindowContainer.window('open');
}
//发contract——id 到后台调用调息函数
var currentLoadMask;
function rollBackTX(rowDatas){
	 rowDatas = JsonUtil.encode(rowDatas);
	if(confirm("是否回滚此客户?")){
		var loadMaskMsg = ("正在对此客户进行回滚,请稍后... ");
        if(null == currentLoadMask){
        	currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
        }
        currentLoadMask.show();
        ajaxRequest({
            url:"${pageContext.request.contextPath}/leasing/acl/rollBackAdjustinterest.acl",
            params:{
            	adjustid:"${requestScope['fund_standard_interest.id']}",
            	docid:"${requestScope['docid']}",
                "already_json_val":rowDatas
            },
            timeout:30*1000,
            success:function(res){
    	   		res=res.responseText;
    	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
	     	    if(res!=''){
	     	    	//currentTable.reload();
		    	 	//getTracywindyObject("table_id_table_leasing_current_regulating_of_breathing_container").reload();
	     	    	jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>回滚成功!</div>",'error');
	     	    	currentLoadMask.hide();
	       			 getTracywindyObject("id_table1").reload();
	    			 getTracywindyObject("id_table2").reload();
	    			 
	     	    }else{
	     	    	jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>回滚失败!</div>",'error');
	     	    	currentLoadMask.hide();
	       			 getTracywindyObject("id_table1").reload();
	    			 getTracywindyObject("id_table2").reload();
	     	    }
            },
            
            failure:function(res){
                jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>服务器通信失败!</div>",'error');
                currentLoadMask.hide();
            }
       });
    }
}





</script>