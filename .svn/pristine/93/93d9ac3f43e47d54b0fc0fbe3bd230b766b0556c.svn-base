<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
var constantFlagTable = "User";
var pageWidth  = document.documentElement.clientWidth-2;
var pageHeight = document.documentElement.clientHeight-2;
var editor;
jQuery(function(){
	 var table = new tracywindyOperationTable({
		 tableComment:'待会滚调息列表',
		 limit:20,
		 constantFlagTable:'Notice',
	     isNeedEnabled:false,
	     isNeedEnabledQuery:false,
	     operButtons:'',
	     border:true,
	     renderTo:'id_table_pranayama_to_roll_back_the_record_container',
	     width:formWidth,
	     id:'id_table2',
	     xmlFileName:'/eleasing/workflow/money_rate/to_be_a_rollback_list.xml',
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
	     adjustid:"${requestScope['fund_standard_interest.id'] }",
	     docid:"${requestScope['docid'] }"
	     },
     columns:[
			{header:'id',name:'id',hidden:true},
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
			{header:'操作',align:'center',renderer:function(value,tableObj,columnName,columnIndex,rowData){
			      value = value.replace(/(\r|\n)/gim,"");
			      value = value.replace(/\"/gim,'&quot;');
			      value = value.replace(/\'/gim,"&acute");
			      return "<a href='javascript:void(0);' onclick=\"preview('"+value+ "')\">对比</a>";  
			  }}
			    ],
			    //点击调息调用撤销Ajax
		        tools:[
			          {html:'<font style="color:red;font-weight:BOLD;">撤销回滚</font>',iconCls:'icon-reckon',
				          handler:function(table){
				        	  //var currentTable = getTracywindyObject('table_id_table_leasing_todo_regulating_of_breathing_container');
				     			
				        	 var rowDatas  = table.getCheckedRowDatas();
			        		 if(rowDatas.length == 0){
			        			 jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>请选择需要撤销回滚的客户</div>",'error');
			        		 }else {
			        			 removeRollBackTX(rowDatas);
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
		function removeRollBackTX(rowDatas){
			 rowDatas = JsonUtil.encode(rowDatas);
			if(confirm("是否撤销回滚此客户?")){
				var loadMaskMsg = ("正在对此客户进行撤销回滚,请稍后... ");
		        if(null == currentLoadMask){
		        	currentLoadMask = new tracywindyLoadMask(document.body,loadMaskMsg);
		        }
		        currentLoadMask.show();
		        ajaxRequest({
		            url:"${pageContext.request.contextPath}/leasing/acl/removeRollBackAdjustinterest.acl",
		            params:{
		                "already_json_val":rowDatas,
		                adjustid:"${requestScope['fund_standard_interest.id']}",
		       	        docid:"${requestScope['docid'] }"
		            },
		            timeout:30*1000,
		            success:function(res){
		    	   		res=res.responseText;
		    	   		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
			     	    if(res!=''){
			     	    	//currentTable.reload();
				    	 	//getTracywindyObject("table_id_table_leasing_current_regulating_of_breathing_container").reload();
				   
			     	    	jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>撤销回滚成功!</div>",'error');
			     	    	currentLoadMask.hide();
			       			 getTracywindyObject("id_table1").reload();
			    			 getTracywindyObject("id_table2").reload();
			     	    }else{
			     	    	jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>撤销回滚失败!</div>",'error');
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