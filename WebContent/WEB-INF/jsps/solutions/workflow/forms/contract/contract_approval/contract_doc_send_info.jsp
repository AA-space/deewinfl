<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>   
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    /* if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    } */
    
   
    //合同号
    var contract_id = document.getElementById("contract_info.id").value;
    //金额
    var equipAmt = document.getElementById("equipAmt").value;
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_doc_send_info',
	    width:formWidth,
	    height:450,
	    isFit:true,
	    isNeedTools:currentIsNeedTools,
	    tools:'修改',
	    otherTools :[
	         	    
	         	    {
       	 	html : '<font color="red">同步合同登记信息</font>',
			handler : function(table) {
				var conditions = {};
		    	conditions.contract_id = contract_id;//项目id,必填
		    	conditions.equipAmt = equipAmt;
		        
 				$.post('leasing/docSendCheckNew.action', conditions, function(data) {
 					if(data){
 						table.tableData = JsonUtil.decode(data);
 						createDataTable(table);
 						alert("更新成功");
 					}
				}); 
			},
			iconCls : 'icon-update'
	    }
        ,
 
        {
       	 	html : '<font color="red">批量修改快递单号</font>',
			handler : function(table) {
    		   var plandata = table.getCheckedRowDatas();
    		   if(plandata.length<=0){alert("请选择合同")}
    		   else{
    			   jQuery("#id_contract_doc_ems_window").show();
        		   jQuery("#id_contract_doc_ems_window").window({top:10});
        		   jQuery("#id_contract_doc_ems_window").window("open");
        		  }
    	
			},
			iconCls : 'icon-update'
	    }
	    ],
	    datas:JsonUtil.decode('${empty json_contract_doc_send_info_str ? "[]" : json_contract_doc_send_info_str }'),
	     //xmlFileName:'\\eleasing\\workflow\\contract\\doc_send_info.xml',
	     //loadMode:'ajax',
	     params : {
	    	 contract_id : contract_id,
	    	 equipAmt : equipAmt
	     },
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'contractid',  header:'contractid',hidden:true},
	       {name:'contractnumber',  header:'合同编号',readOnly:true},
	       {name:'businessmode',header:'业务模式',readOnly:true},
	       {name:'custname',header:'客户名称',readOnly:true},
	       {name:'docname',  header:'docname',hidden:true},
	       {name:'rowvalue_docname', header:'合同档案名称',readOnly:true},
	       {name:'contractperson',  header:'合同对方'},
	       {name:'totalprice',  header:'合同金额',readOnly:true},
	       {name:'docpart',  header:'合同份数'},
	       {name:'contracta',  header:'我方签约人'},
	       {name:'contractb',  header:'对方签约人'},
	       {name:'contractdate',  header:'合同生效日期',type:'date'},
	       {name:'sendpart',  header:'寄送/不寄送'},
	       {name:'sendno',  header:'快递单号'},
	       {name:'maincount',  header:'主车台数'},
	       {name:'gcount',  header:'挂车台数'},
	       {name:'sdy',  header:'是否抵押'}
	     ]
	 });
	 
});
</script>


