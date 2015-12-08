<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script type="text/javascript">
function doCheckFundCharge(fundData,tabledata){
	var fund=fundData;
	var ebankMoney=0.00;
	var ebankId="";
	var fundList=new Array();
	fundList=fund;
	var messageovpaln=new Array();
	var messageovebank=new Array();
	var messageovreback=new Array();

	//检查核销的收款计划大于网银/计划可核销的金额
	for(var i=0;i<tabledata.length;i++){
	       for(var j=0;j<fundList.length;j++){
	          if(fundList[j].id==tabledata[i].id){//查找相同的付款编号
		         var curmoney=parseFloat(tabledata[i].factmoney)+parseFloat(tabledata[i].feeadjust);
		         curmoney=curmoney.toFixed(2);
	             if(parseFloat(curmoney)>0 ){
	                 //检查是否大于计划
	                  if(parseFloat(fundList[j].planbalance)<parseFloat(curmoney)){
	                	 messageovpaln.push(fundList[j].paymentid);
	                	 fundList[j].planbalance=0;
	                  }else{
	                       var temp=parseFloat(fundList[j].planbalance)-parseFloat(tabledata[i].curmoney)
	                       fundList[j].planbalance=temp.toFixed(2);
	                  }
	                  
	             }else{
	                
	              }
	          }
	       }
		}
	if(messageovpaln.length>0||messageovebank.length>0||messageovreback.length>0){
		var message="";
		if(messageovpaln.length>0){message=message+"编号为"+messageovpaln+"付款计划的金额大于计划";}
		if(message!=""){message=message+"<br>";}
		if(messageovebank.length>0){message=message+"编号为"+messageovebank+"付款计划的金额大于网银金额";}
		if(message!=""){message=message+"<br>";}
		if(messageovreback.length>0){message=message+"编号为"+messageovreback+"红冲计划的金额大于实收";}
		jQuery.messager.alert('错误提示',"<div style='font-size:15px;line-height:30px;line-width:200px;'>"+message+"！</div>",'error');
		return false;
    }else{
        return true;
    }
}
function checkFundCharge(){
	 var currentTable1 = getTracywindyObject('table_id_table_leasing_contract_fund_payment_now_container');
	 var tabledata=currentTable1.getRowsData();
     var sourceTable=getTracywindyObject('table_id_table_leasing_json_paychargeplan_container');
     var sourceTableData=sourceTable.getRowsData();
     var isSubmit = doCheckFundCharge(sourceTableData,tabledata);
	 return isSubmit;
}
/*
function checkFundCharge(){
     //获得这个合同的收款计划情况和相对网银
	 loadMask_oper.show();
	 var isSubmit = false;
	 var contractid=jQuery("#contractid").val();
	 var ebankid="";
	 var paytype="pay_type_out";
	 var param={};
	 var currentTable1 = getTracywindyObject('table_id_table_leasing_contract_fund_payment_now_container');
	 var tabledata=currentTable1.getRowsData();
	 if(tabledata.length==0){
		 loadMask_oper.hide();
		 jQuery.messager.alert('错误提示',"<div style='font-size:20px;line-height:30px;'>请选择核销的计划！</div>",'error');
     return false;}
	 var method="getFundCheckData";
	 param.contractid=contractid;
	 param.ebankid=ebankid;
	 param.paytype=paytype;
	 ajaxRequest({
		     url:'${pageContext.request.contextPath}/leasing/fund/'+method+'.action',
		     method:'POST',
		     success:function(res){
	   		    var sfund=res.responseText;
	   		    sfund=sfund.replace(/(^\s+)|(\s+$)/g, ""); 
	   		    loadMask_oper.hide();
	   		    if(sfund==""){
  	   		    jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>没有付款计划！</div>",'error');
  	   		        isSubmit = false;
	   		    }else{
	   		        isSubmit = doCheckFundCharge(sfund,tabledata);
	   	   		}
		     },
		     async:false,
		     failure:function(res){},
		     params:param
	 });
	 loadMask_oper.hide();
	 return isSubmit;
	}
	*/
</script>    
<script> 
function comptuerPartFeeMoney(){
	var allMoney=$("#re_receivermoney").val();
	var feemoney=$("#re_factmoney").val();
	var feeadjust=$("#re_feeadjust").val();
	feeadjust=feeadjust||0;
	allMoney=allMoney||0;
	temp=parseFloat(allMoney)-parseFloat(feeadjust);
	$("#re_factmoney").val(temp.toFixed(2));
}
function comptuerPartAdjustMoney(){
	var allMoney=$("#re_receivermoney");
	var feemoney=$("#re_factmoney").val();
	var feeadjust=$("#re_feeadjust").val();
	feemoney=feemoney||0;
	feeadjust=feeadjust||0;
	temp=parseFloat(feemoney)+parseFloat(feeadjust);
	$("#re_receivermoney").val(temp.toFixed(2));
}
function   showdisplayplandate(opertype,rowDatas){
	var rentPlan=getTracywindyObject('multiTable_id_table_leasing_contract_fund_payment_now_container');
	if(rowDatas){
	    for(var i=0;i<rowDatas.length;i++){
	    if(rowDatas[i].oper=="old"){
	    	rentPlan.setReadOnly(true,"factdate");
	    }else{
	    	rentPlan.setReadOnly(false,"factdate");
	        }
	      }
		}
	}
jQuery(function(){
	    var currentIsNeedTools = true;
	    //if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    //	currentIsNeedTools = false;
	    //}
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_fund_payment_now_container',
	    width:formWidth,
	    height:350,
	    tools:'修改|删除',
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    operValidate:function(operType,rowDatas,thisForm,multiTable){
		    if("update"==operType){
		    	//showdisplayplandate(opertype,rowDatas);
		    	if(parseFloat(rowDatas[0].factmoney)<0){
		        jQuery.messager.show({
                   title:'提示',
                   width:500,
                   msg:"<div style='font-size:18px;line-height:30px;'>红冲数据不能修改</div>"
			    });
			    //'提示',"<div style='font-size:18px;line-height:30px;'>红冲数据不能修改</div>",'success'); 
			    return false;
		    	}
			}
	         return true;
	     },
	    displayToggleContainer:document.getElementById('id_table_leasing_contract_fund_payment_now_container').parentNode.parentNode,
	    datas:JsonUtil.decode('${empty json_contract_fund_payment_now_str ? "[]" : json_contract_fund_payment_now_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'fundfundchargeplan',  header:'fundfundchargeplanid',nullable:false,hidden:true},
	       {name:'fundfundchargeplanname',  header:'付款编号',nullable:false,readOnly:true},
	       {name:'feetype',  header:'feetypeId',hidden:true},
  	       {name:'rawValue_feetype',  header:'费用类型',nullable:false ,readOnly:true},
	       {name:'settlemethod',  header:'结算方式id',hidden:true},
	       {name:'rawValue_settlemethod',  header:'结算方式',nullable:false,readOnly:true},
	       //{name:'factdate',  header:'支付时间',nullable:false,type:'date'},
	       {name:'payobj',  header:'支付对象',nullable:false},
	       {name:'custname',  header:'客户名称',nullable:false},
	       {name:'factmoney',  header:'金额',nullable:false ,type:'double',otherAttributes:'id="re_factmoney" onkeyup="comptuerPartAdjustMoney()"'},
	       {name:'feeadjust',  header:'调整金额',nullable:false,type:'double',otherAttributes:'id="re_feeadjust" onkeyup="comptuerPartFeeMoney()"'},
	       {name:'receivermoney',header:'付款合计',nullable:false,type:'double',readOnly:true,otherAttributes:'id="re_receivermoney"'},
	       /*{name:'accountbank',  header:'银行'},
	       {name:'account',  header:'银行账户'},
	       {name:'accnumber',  header:'银行账号'},
	       {name:'factobject',  header:'收款客户'},*/
	       {name:'clientbank',  header:'客户银行'},
	       {name:'clientaccount',  header:'客户账户'},
	       {name:'clientaccnumber',  header:'客户账号'},
	       /*{name:'accountingdate',  header:'会计处理日',type:'date'},
	       {name:'invoiceno',  header:'单据号'},*/
	       {name:'oper',  header:'操作类型',hidden:true, nullable:false,defaultValue:'add'},
	       {name:'paytype',header:'收付类型',hidden:true,defaultValue:"pay_type_out"},
	       {name:'ffcmemo', header:'备注',type:'textarea'}
	     ]
	 });
});

</script>