<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
<script type="text/javascript">
jQuery(function(){
 	 new tracywindyOperationTable({
 		 windowTop:20,
 	     border:true,
       renderTo:'id_tableContainer_cardinfo',
       id:'id_tableContainer_cardinfo_table',
       title:'卡扣到账数据',
       width:formWidth,
       xmlFileName:'/eleasing/workflow/cardHire/contract_card_rent_income.xml',
       loadMode:'ajax',
       isPage:true,
       isFit:false,
       checkType:"checkbox",
       operButtons:'',
       tools:[{
      	    iconCls:'icon-ok',
      	    html:'<font color="red">全部核销</font>',
      	    handler:function(table){ 
      	    	todoCardHireContract("全部核销","");
      	   }
      	 },
      	{
       	    iconCls:'icon-check',
       	    html:'<font color="red">选择核销</font>',
       	    handler:function(table){ 
       	    	var row = table.getCheckedRowDatas();
    	    	if(row.length==0){
        	    	alert("请选择需要核销的数据!");
    	    	}else{
        	    	var ids="";
        	    	for(var i=0;i<row.length;i++){
        	    		ids+=row[i].id+",";
        	    	}
    	    		todoCardHireContract("选择性核销",ids);
    	    	}
       	   }
       	 }
  	   ],
  	   params:{
 			fileid:"${requestScope['cardhire.uploadid'] }",
 			status :  0,
 			canHire : 'true'
	   },
       columns:[
			{header:'id',name:'id',hidden:true},
			{header:'客户名称',name:'custname',width:100},
			{header:'经销商名称',name:'dealername',width:300},
			{header:'合同号',name:'contractid'},
			{header:'业务合同号',name:'contractnumber',width:150},
			{header:'项目名称',name:'projectname',width:300},
			{header:'核销日期',name:'incomedate'},
			{header:'到账金额',name:'incomemoney'},
			{header:'剩余金额',name:'lastmoney'},
			{header:'扣款类型',name:'moneytype'},
			{header:'扣款期项',name:'rentlist'}
        ]
 	 });
});
function todoCardHireContract(domainName,id){
	var params={fileid:"${requestScope['cardhire.uploadid'] }",ids:id,docid:"${requestScope['cardhire.docid'] }"};
	
	var uploadDate = "${requestScope['cardhire.uploaddate'] }" ;
	var hire_date = $('#id_hire_date').val();
	
	//如果自定义了时间，则按自定义核销时间
	if(hire_date && hire_date != uploadDate.substr(0, 10)){
		params.hire_date = hire_date;
	}
	requestAjax(domainName,"${pageContext.request.contextPath}/acl/addCardHireToIncome.acl",params);
}
</script>