<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tracywindy/tracywindyOperationTable.js"></script>
<script type="text/javascript">
jQuery(function(){
 	 new tracywindyOperationTable({
 		 windowTop:20,
 	     border:true,
       renderTo:'id_tableContainer_card_fail',
       id:'id_tableContainer_card_fail_table',
       title:'卡扣失败数据',
       width:formWidth,
       xmlFileName:'/eleasing/workflow/cardHire/contract_card_rent_income.xml',
       loadMode:'ajax',
       isPage:true,
       isFit:false,
       checkType:"checkbox",
       operButtons:'',
  	   params:{
 			fileid:"${requestScope['cardhire.uploadid'] }",
 			status :  1,
 			canHire : 'true'
	   },
       columns:[
			{header:'id',name:'id',hidden:true},
			{header:'contract_id',name:'contract_id',hidden:true},
			{header:'客户名称',name:'custname',width:100},
			{header:'经销商名称',name:'dealername',width:300},
			{header:'合同号',name:'contractid'},
			{header:'业务合同号',name:'contractnumber',width:150},
			{header:'项目名称',name:'projectname',width:300},
			{header:'到账日期',name:'incomedate'},
			{header:'到账金额',name:'incomemoney'},
			{header:'剩余金额',name:'lastmoney'},
			{header:'扣款类型',name:'moneytype'},
			{header:'扣款期项',name:'rentlist'}
        ]
 	 });
});
</script>