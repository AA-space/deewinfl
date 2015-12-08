<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
<script type="text/javascript">
jQuery(function(){
 	new tracywindyOperationTable({
		 windowTop:20,
	     border:true,
      renderTo:'id_tableContainer_rentincome',
      id:'id_tableContainer_rentincome_table',
      title:'核销数据',
      width:formWidth,
      xmlFileName:'/eleasing/workflow/cardHire/fund_rent_income_temp.xml',
      loadMode:'ajax',
      isPage:true,
      isFit:false,
      checkType:"checkbox",
      operButtons:'',
      tools:[{
    	    iconCls:'icon-cancel',
    	    html:'<font color="red">全部删除</font>',
    	    handler:function(table){ 
    	    	reomveCardHireContract("全部删除核销记录","");
    	   }
    	 },
    	{
     	    iconCls:'icon-delete',
     	    html:'<font color="red">选择删除</font>',
     	    handler:function(table){ 
     	    	var row = table.getCheckedRowDatas();
  	    	if(row.length==0){
      	    	alert("请选择需要删除的数据!");
  	    	}else{
  	    		var ids="";
    	    	for(var i=0;i<row.length;i++){
    	    		ids+=row[i].id+",";
    	    	}
    	    	reomveCardHireContract("选择性删除核销记录",ids);
  	    	}
     	   }
     	 }
	   ],
 	  params:{
 			fileid:"${requestScope['cardhire.uploadid'] }",
   			docid:"${requestScope['cardhire.docid'] }"
	  },
	  columns:[
		       {name:'id',  header:'id',hidden:true},
		       {name:'contractid',  header:'contractid',hidden:true},
		       {name:'contract',  header:'合同号'},
		       {name:'contractnumber',  header:'业务合同号'},
		       {name:'planid',header:'租金计划',hidden:true},
		       {name:'planlist',  header:'计划期项'},
		       {name:'balancemodename',  header:'结算方式' },
		       {name:'balancemode',  header:'balancemode',hidden:true},
		       {name:'hiredate',  header:'回笼日期'},
		       {name:'rent',  header:'回笼租金' },
		       {name:'corpus',  header:'回笼本金'},
		       {name:'interest',  header:'回笼租息'},
		       {name:'penalty',  header:'回笼罚息'},
		       {name:'accountingdate',  header:'会计处理日'},
		       {name:'ownbank',  header:'本方银行'},
		       {name:'ownaccount',  header:'本方银行账户'},
		       {name:'hireobject',  header:'付款人'},
		       {name:'hirebank',  header:'付款人银行'},
		       {name:'hirenumber',  header:'付款人帐号'}
		       ]
	 });
 });
function reomveCardHireContract(domainName,id){
	var params={fileid:"${requestScope['cardhire.uploadid'] }",ids:id,docid:"${requestScope['cardhire.docid'] }"};
	requestAjax(domainName,"${pageContext.request.contextPath}/acl/deleteCardHireToIncome.acl",params);
}
</script>