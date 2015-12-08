<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
/*
 * 根据网银余额校验当前收的保证金是不是大于网银余额
 */
function doCheckFundCharge(sfund,tabledata){
	var tmoney=parseFloat(sfund);
	var stmoney=tmoney;
	var ebankid=jQuery("#ebdataid").val();
	var all_cur_money=0.00;
	for(var i=0;i<tabledata.length;i++){
       if(tabledata[i].ebanknumber==ebankid){
           if(tabledata[i].settlemethod!="红冲"){
             tmoney=parseFloat(tmoney)-parseFloat(tabledata[i].factmoney);
             tmoney=tmoney.toFixed(2);
             all_cur_money=all_cur_money+parseFloat(tabledata[i].factmoney);
             all_cur_money=all_cur_money.toFixed(2);
           }
       }
    }
    if(tmoney<0){
    	 jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>本次收的保证金("+all_cur_money+")大于网银余额("+stmoney+")</div>",'error');
        return false;
    }else{
        return true;
        }
}
/*
 * 获得网银余额并调用doCheckFundCharge来检查当前的数据
 */
function checkFundCharge(){
     //获得这个合同的收款计划情况和相对网银
     if(!loadMask_oper){
    	 loadMask_oper= new tracywindyLoadMask(document.body,"操作进行中 请稍等...");
         }
	 loadMask_oper.show();
	 var isSubmit = false;
	 var ebankid=jQuery("#ebdataid").val();
	 var param={};
	 var currentTable1 = getTracywindyObject('table_id_table_receivercharge_container');
	 var tabledata=currentTable1.getRowsData();
	 if(tabledata.length==0){
		 loadMask_oper.hide();
		 jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>请选择核销的计划！</div>",'error');
     return false;}
	 var method="getCanHireMoeny";
	 param.ebankid=ebankid;
	 ajaxRequest({
		     url:'${pageContext.request.contextPath}/leasing/fund/'+method+'.action',
		     method:'POST',
		     success:function(res){
	   		    var strEbankMay=res.responseText;
	   		    strEbankMay=strEbankMay.replace(/(^\s+)|(\s+$)/g, ""); 
	   		    loadMask_oper.hide();
	   		    isSubmit = doCheckFundCharge(strEbankMay,tabledata);
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
	    tools:"新增|修改|删除",
	    operValidate:function(opertype,rowDatas){
		    if(opertype=="update"){
			     if(rowDatas[0].settlemethod=="红冲")
				     {
			    	 jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>红冲不能修改数据</div>",'error');
		  	   		  return false;   
				     }
			     }
		    
	         return true;
	        },
	    datas:JsonUtil.decode('${empty json_receivercharge_str ? "[]" : json_receivercharge_str }'),
	    columns:[
	               {name:'id',  header:'id',hidden:true},
			       {name:'ebanknumber',  header:'网银编号',readOnly:true,defaultValue:"${requestScope['fund_ebank_data.ebdataid']}"},
			       {name:'feetype',  header:'费用类型',hidden:"true",nullable:false,readOnly:true,defaultValue:"feetype20"},
			       {name:'rawValue_feetype',  header:'费用类型',nullable:false,readOnly:true,defaultValue:"经销商保证金"},
			       {name:'settlemethod',  header:'结算方式id',readOnly:true,hidden:"true",defaultValue:"PayFund6"},
			       {name:'rawValue_settlemethod',  header:'结算方式',readOnly:true,nullable:false,defaultValue:"电汇"},
			       {name:'factmoney',  header:'金额',nullable:false,type:'double',otherAttributes:'id="re_factmoney" onkeyup="comptuerPartAdjustMoney()"'},
			       {name:'factdate',  header:'到账时间',type:'date',readOnly:true,defaultValue:"${requestScope['fund_ebank_data.factdate']}"},
			       {name:'accountbank',  header:'银行(自动生成)',readOnly:true,defaultValue:"${requestScope['fund_ebank_data.ownbank']}"},
			       {name:'account',  header:'银行账户(自动生成)',readOnly:true,defaultValue:"${requestScope['fund_ebank_data.ownaccount']}"},
			       {name:'accnumber',  header:'银行帐号',nullable:false,readOnly:true,defaultValue:"${requestScope['fund_ebank_data.ownaccnumber']}"},
			       {name:'factobject',  header:'付款客户',nullable:false,readOnly:true,defaultValue:"${requestScope['cust_info.custname']}"},
			       {name:'clientbank',  header:'客户银行(自动生成)',readOnly:true,defaultValue:"${requestScope['fund_ebank_data.clientbank']}"},
			       {name:'clientaccount',  header:'客户帐户(自动生成)',readOnly:true,defaultValue:"${requestScope['fund_ebank_data.clientaccount']}"},
			       {name:'clientaccnumber',  header:'客户帐号(自动生成)',nullable:false,readOnly:true,defaultValue:"${requestScope['fund_ebank_data.clientaccnumber']}"},
			       {name:'invoiceno',  header:'单据号',nullable:true},
			       {name:'accountingdate', header:'会计处理日',type:'date',nullable:true},
			       {name:'paytype',header:'收付类型id',hidden:true,defaultValue:"pay_type_in"},
			       {name:'rawValue_paytype',header:'收付类型',hidden:true,defaultValue:"收款"},
			       {name:'ffcmemo',  header:'备注',type:'textarea'}
	     ]
	 });
});

</script>