<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<script>
function  deletePlanData(currentTable){
    var rowDatas  = currentTable.getCheckedRowDatas();
    var plantable=getTracywindyObject('table_id_table_fund_rent_plan_container');
    var plantableOjbect=plantable.getRowsJsonData();
    for(var i=0;i<rowDatas.length;i++){
        for(var j=0;j<plantableOjbect.length;j++){
            if(rowDatas[i].id==plantableOjbect[j].id){
               var rowData = plantableOjbect[j];
         	   var removeIndex = rowData.rowIndex ;
         	  plantable.removeRowAt(removeIndex);
            }
        }
    }    
}
function checkPenalty(){
	 var plantable=getTracywindyObject('table_id_table_fund_rent_income_container');
	 var rowDatas=plantable.getRowsJsonData();
	 var fundtable=getTracywindyObject('table_id_table_fund_fund_plan_history_container');
	 var fundrowDatas=fundtable.getRowsJsonData();
	 
	 var fund=fundrowDatas[0].overmoney;
	 //alert(fund);
	 var penalty=0.00;
	 for(var i=0;i<rowDatas.length;i++){
		 var rowData=rowDatas[i];
		 penalty=penalty+parseFloat(rowData.penalty)+parseFloat(rowData.penaltyadjust);
	 }		    
	 if(parseFloat(penalty)>parseFloat(fund)){
		 alert("抵扣的罚息大于保证金");
		 return false;
     }else{
         return true;             
         }
	 return false;
}
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_fund_rent_income_container',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    isNeedTools:currentIsNeedTools,
	    confirmRemoveCallBack:function($me,currentTable){
    	deletePlanData(currentTable);
         return true;
       },
	    tools:'修改|删除',
	    datas:JsonUtil.decode('${empty json_fund_rent_income_str ? "[]" : json_fund_rent_income_str }'),
	    columns:[
	             {name:'id',  header:'id',hidden:true},
	               {name:'contractid',headler:'合同号ID',hidden:true},
	               {name:'planid',headler:'计划',hidden:true},
	               {name:'contract_number',header:'合同号',nullable:false,readOnly:true},
	               {name:'cust_name',header:'承租人',readOnly:true},
	               {name:'planlist',header:'期次',readOnly:true},
	               {name:'hiredate',header:'回笼日期',type:'date'},
	               {name:'rent',header:'回笼租金',hidden:true,type:'double'},
	               {name:'corpus',header:'回笼本金',hidden:true,type:'double'},
	               {name:'interest',header:'回笼租息',hidden:true,type:'double'},
	               {name:'penalty',header:'回笼罚息',type:'double',readOnly:true},
	               {name:'rentadjust',header:'租金减免',hidden:true,type:'double'},
	               {name:'corpusadjust',header:'本金减免',hidden:true,type:'double'},
	               {name:'interestadjust',header:'租息减免',hidden:true,type:'double'},
	               {name:'penaltyadjust',header:'罚息减免',hidden:true,type:'double'},
	               {name:'balancemode',header:'结算方式',defaultValue:'PayFund10',hidden:true},
	               {name:'PID',header:'保证金的ID',hidden:true}
			   ]
	 });
	
	 
});

</script>