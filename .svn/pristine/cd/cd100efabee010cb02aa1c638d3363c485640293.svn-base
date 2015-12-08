<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<script type="text/javascript">
function doCheckFundCharge(fundData,tabledata){
	var fund=eval("("+fundData+")");
	var ebankMoney=0.00;
	var ebankId="";
	var fundList=new Array();
	ebankMoney=fund.ebank[0].mayopemoney;
	ebankId=fund.ebank[0].ebankid;
	fundList=fund.fund;
	var messageovpaln=new Array();
	var messageovebank=new Array();
	var messageovreback=new Array();

	//检查核销的收款计划大于网银/计划可核销的金额
	for(var i=0;i<tabledata.length;i++){
		 for(var j=0;j<fundList.length;j++){
	          if(fundList[j].paymentid==tabledata[i].fundfundchargeplan){//查找相同的付款编号
	        	  var temp=parseFloat(tabledata[i].factmoney)+parseFloat(tabledata[i].feeadjust);
	         	 temp=temp.toFixed(2);
	              if(parseFloat(tabledata[i].factmoney)<0){
	        	  var templast=parseFloat(fundList[j].lastmoney)-parseFloat(tabledata[i].curmoney);
	                 fundList[j].lastmoney=templast.toFixed(2);
	              }
	          }
   }}
	for(var i=0;i<tabledata.length;i++){
       for(var j=0;j<fundList.length;j++){
          if(fundList[j].paymentid==tabledata[i].fundfundchargeplan){//查找相同的付款编号
        	 var temp=parseFloat(tabledata[i].factmoney)+parseFloat(tabledata[i].feeadjust);
        	 temp=temp.toFixed(2);
             if(parseFloat(tabledata[i].factmoney)>0){
                 //检查是否大于计划
                  if(parseFloat(fundList[j].lastmoney)<parseFloat(temp)){
                	 messageovpaln.push(fundList[j].paymentid);
                	 fundList[j].lastmoney=0;
                  }else{
                       var temp=parseFloat(fundList[j].lastmoney)-parseFloat(temp);
                       fundList[j].lastmoney=temp.toFixed(2);
                  }
                  
             }else{
            	 var temp=parseFloat(fundList[j].receivermoney)+parseFloat(tabledata[i].factmoney);
                 if(temp<0){
                	 messageovreback.push( fundList[j].paymentid+"的投放金额"); 
                 }
                 var tempadjust=parseFloat(fundList[j].adjustmoney)+parseFloat(tabledata[i].feeadjust);
                 if(tempadjust<0){
                	 messageovreback.push( fundList[j].paymentid+"调整金额"); 
                 }
                 fundList[j].receivermoney=temp.toFixed(2);
                 fundList[j].adjustmoney=tempadjust.toFixed(2);
              }
          }
       }
	}
	if(messageovpaln.length>0||messageovebank.length>0||messageovreback.length>0){
		var message="";
		if(messageovpaln.length>0){message=message+"编号为"+messageovpaln+"投放计划的金额大于计划";}
		if(message!=""){message=message+"<br>";}
		if(messageovebank.length>0){message=message+"编号为"+messageovebank+"投放计划的金额大于网银金额";}
		if(message!=""){message=message+"<br>";}
		if(messageovreback.length>0){message=message+"编号为"+messageovreback+"大于投放可红冲金额";}
		jQuery.messager.alert('错误提示',"<div style='font-size:15px;line-height:30px;line-width:100px;'>"+message+"！</div>",'error');
		return false;
    }else{
        return true;
    }
}
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
		 jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>请选择把投放的计划！</div>",'error');
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
    for(var i=0;i<rowDatas.length;i++){
    if(rowDatas[i].oper=="old"){
    	rentPlan.setReadOnly(true,"factdate");
    }else{
    	rentPlan.setReadOnly(false,"factdate");
        }
      }
	}
jQuery(function(){
	    var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_fund_payment_now_container',
	    width:formWidth,
	    height:350,
	    tools:'新增|修改|删除',
	    isNeedTools:currentIsNeedTools,
	    isFit:false,
	    operValidate:function(opertype,rowDatas){
			showdisplayplandate(opertype,rowDatas);
	         return true;
	        },
	    //datas:JsonUtil.decode('${empty json_contract_fund_charge_str ? "[]" : json_contract_fund_charge_str }'),
	    datas:JsonUtil.decode('${empty json_contract_fund_payment_now_str ? "[]" : json_contract_fund_payment_now_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'fundfundchargeplan',  header:'投放编号',nullable:false,readOnly:false},
	       {name:'factobject',  header:'投入对象',nullable:false},
	       {name:'settlemethod',  header:'结算方式',nullable:false},
	       {name:'factmoney',  header:'投放金额',nullable:false,type:'double',otherAttributes:'id="re_factmoney" onkeyup="comptuerPartAdjustMoney()"'},
	       {name:'feeadjust',  header:'调整金额',nullable:false,type:'double',otherAttributes:'id="re_feeadjust" onkeyup="comptuerPartFeeMoney()"'},
	       {name:'receivermoney',  header:'收款合计',nullable:false,type:'double',readOnly:true,otherAttributes:'id="re_receivermoney"'},
	       {name:'factdate',  header:'实际投放日期',nullable:false},
	       {name:'accountbank',  header:'本方银行',nullable:false},
	       {name:'account',  header:'本方银行账户',nullable:false},
	       {name:'accnumber',  header:'本方银行账号',nullable:false},
	       {name:'clientbank',  header:'客户银行',nullable:false},
	       {name:'clientaccount',  header:'客户账户',nullable:false},
	       {name:'clientaccnumber',  header:'客户账号',nullable:false},
	       {name:'accountingdate',  header:'会计处理日',nullable:false},
	       {name:'oper',  header:'操作类型',hidden:true, nullable:false,defaultValue:'add'},
	       {name:'invoiceno',  header:'单据号',nullable:false},
	       {name:'paytype',header:'收付类型',hidden:true,defaultValue:"付款"},
	       {name:'ffcmemo', header:'备注',type:'textarea'}
	     ]
	 });
});
</script>