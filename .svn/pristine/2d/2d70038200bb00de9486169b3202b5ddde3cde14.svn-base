<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		if(parseFloat(tabledata[i].factmoney)<0){
			 if(ebankId==tabledata[i].ebanknumber)
             {
          	  ebankMoney=parseFloat(ebankMoney)-parseFloat(tabledata[i].factmoney);
          	  ebankMoney=ebankMoney.toFixed(2);
             }
		}	
	}	
	for(var i=0;i<tabledata.length;i++){
       for(var j=0;j<fundList.length;j++){
          if(fundList[j].paymentid==tabledata[i].paymentid){//查找相同的付款编号
             var temp=parseFloat(tabledata[i].factmoney)+parseFloat(tabledata[i].feeadjust);
             temp=temp.toFixed(2);
             if(parseFloat(temp)>0){
                 //检查是否大于计划
                  if(parseFloat(fundList[j].lastmoney)<parseFloat(temp)){
                	 messageovpaln.push(fundList[j].paymentid);
                  }
                  if(ebankId==tabledata[i].ebanknumber)
                   {
                	  ebankMoney=parseFloat(ebankMoney)-parseFloat(tabledata[i].factmoney);
                	  ebankMoney=ebankMoney.toFixed(2);
                     }
                  if(ebankMoney<0){
                	  messageovebank.push(fundList[j].paymentid);
                   }
             }else{
                 //如果红冲是相同的网银则将相应的金额加到相应的网银
                 var temp=parseFloat(fundList[j].receivermoney)+parseFloat(tabledata[i].factmoney);
                 if(temp<0){
                	 messageovreback.push( fundList[j].paymentid+"的收款"); 
                 }
                 fundList[j].receivermoney=temp;
                 temp=parseFloat(fundList[j].adjustmoney)+parseFloat(tabledata[i].feeadjust);
                 if(temp<0){
                	 messageovreback.push( fundList[j].paymentid+"的调整"); 
                 }
                 fundList[j].adjustmoney=temp;
              }
          }
       }
	}
	if(messageovpaln.length>0||messageovebank.length>0||messageovreback.length>0){
		var message="";
		if(messageovpaln.length>0){message=message+"编号为"+messageovpaln+"收款计划的金额大于计划";}
		
		if(messageovebank.length>0){if(message!=""){message=message+"<br>";} message=message+"编号为"+messageovebank+"收款计划的金额大于网银金额";}
		
		if(messageovreback.length>0){
			if(message!=""){message=message+"<br>";}
	      	message=message+"编号为"+messageovreback+"大于可红冲金额";}
		jQuery.messager.alert('错误提示',"<div style='font-size:15px;line-height:30px;width:200px;'>"+message+"！</div>",'error');
		return false;
    }else{
        return true;
    }
}
function checkFundCharge(){
     //获得这个合同的收款计划情况和相对网银
	 loadMask_oper.show();
	 var isSubmit = false;
	 //var contractid=jQuery("#contractid").val();
	 var contractid=jQuery('input[name="contract_info.id"]').val();
	 var ebankid=jQuery("#ebdataid").val();
	 var paytype="pay_type_in";
	 var param={};
	 var currentTable1 = getTracywindyObject('table_id_table_receivercharge_container');
	 var tabledata=currentTable1.getRowsData();
	 if(tabledata.length==0){
		 loadMask_oper.hide();
		 jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>请选择核销的计划！</div>",'error');
     return false;}
	 var method="getFundCheckData";
	 param.contractid=contractid;
	 param.ebankid=ebankid;
	 param.paytype=paytype;
	 param.ebankProcess=$('#id_fund_ebank_process').val();
	 ajaxRequest({
		     url:'${pageContext.request.contextPath}/leasing/fund/'+method+'.action',
		     method:'POST',
		     success:function(res){
	   		    var sfund=res.responseText;
	   		    sfund=sfund.replace(/(^\s+)|(\s+$)/g, ""); 
	   		    loadMask_oper.hide();
	   		    if(sfund==""){
  	   		    jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>没有收款计划！</div>",'error');
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
	var rentPlan=getTracywindyObject('multiTable_id_table_receivercharge_container');
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
	    renderTo:'id_table_receivercharge_container',
	    width:formWidth,
	    height:350,
	    isNeedTools:currentIsNeedTools,
	    isFit:false,
	    tools:"修改|删除",
	    operValidate:function(opertype,rowDatas){
			showdisplayplandate(opertype,rowDatas);
	         return true;
	        },
	    datas:JsonUtil.decode('${empty json_receivercharge_str ? "[]" : json_receivercharge_str }'),
	    columns:[
	             {name:'id',  header:'id',hidden:true},
	             {name:'pid',  header:'pid',hidden:true},
	             {name:'rollback',  header:'rollback',hidden:true},
	             {name:'fundfundchargeplan',  header:'fundfundchargeplan',hidden:true},
			     {name:'paymentid',  header:'收款编号',nullable:false,readOnly:true},
			     {name:'ebanknumber',  header:'网银编号',readOnly:true},
				 {name:'feetype',  header:'feetypeId', hidden :true},
				 {name:'rawValue_feetype',  header:'费用类型',nullable:false,type:'combobox',hiddenName:'feetype',
			    	   config:{
					       width:165,
					       xmlFileName:'\\combos\\comboDict.xml',
					       loadMode:'ajax',
					       readOnly:true,
					       displayField:'name',
					       valueField:'code',
					       params:{
					          pid:'FeeType'
					       } 
					   }
			       },
			       {name:'settlemethod',  header:'settlemethodId', hidden:true},
			       {name:'rawValue_settlemethod',  header:'结算方式',nullable:false,type:'combobox',hiddenName:'settlemethod',
			    	   config:{
					       width:165,
					       xmlFileName:'\\combos\\comboDict.xml',
					       loadMode:'ajax',
					       readOnly:true,
					       displayField:'name',
					       valueField:'code',
					       params:{
					          pid:'PayFund'
					       } 
					   }
			       },
			       {name:'factdate',  header:'到账时间',type:'date',readOnly:true},
			       {name:'factmoney',  header:'金额',nullable:false,type:'double',otherAttributes:'id="re_factmoney" onkeyup="comptuerPartAdjustMoney()"'},
			       {name:'feeadjust',  header:'调整金额',nullable:false,type:'double',otherAttributes:'id="re_feeadjust" onkeyup="comptuerPartFeeMoney()"'},
			       {name:'receivermoney',  header:'收款合计',nullable:false,type:'double',readOnly:true,otherAttributes:'id="re_receivermoney"'},
			       {name:'accountbank',  header:'银行(由银行账号自动生成)',readOnly:true},
			       {name:'account',  header:'银行账户(由银行账号自动生成)',readOnly:true},
			       {name:'accnumber',  header:'银行帐号',nullable:false,type:'combobox',
					    config:{
						       width:165,
						       xmlFileName:'\\eleasing\\workflow\\ebank\\comboEbankSelect.xml',
						       loadMode:'ajax',
						       readOnly:false,
						       isAjaxLenovo:true,
						       displayField:'accnumber',
						       valueField:'accnumber'
			   			}
			       },
			       {name:'factobject',  header:'付款客户',type:'combobox',readOnly:true,
					    config:{
						       width:165,
						       xmlFileName:'\\eleasing\\workflow\\ebank\\comboEbankSelect.xml',
						       loadMode:'ajax',
						       readOnly:false,
						       isAjaxLenovo:true,
						       displayField:'clientname',
						       valueField:'clientname'
			   			}
			       },
			       {name:'clientbank',  header:'客户银行(由银行账号自动生成)',readOnly:true},
			       {name:'clientaccount',  header:'客户帐号(由银行账号自动生成)',readOnly:true},
			       {name:'clientaccnumber',  header:'客户帐号',type:'combobox',
					    config:{
						       width:165,
						       xmlFileName:'\\eleasing\\workflow\\ebank\\comboEbankSelect.xml',
						       loadMode:'ajax',
						       readOnly:false,
						       isAjaxLenovo:true,
						       displayField:'clientaccnumber',
						       valueField:'clientaccnumber'
			   			}},
			       {name:'accountingdate', header:'会计处理日',type:'date',nullable:false},
			       {name:'oper',  header:'操作类型',hidden:true, nullable:false,defaultValue:'add'},
			       {name:'invoiceno',  header:'单据号'},
			       {name:'paytype',header:'收付类型',hidden:true,defaultValue:"pay_type_in"},
			       {name:'ffcmemo',  header:'备注',type:'textarea'}
	     ]
	 });
});

</script>