<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
           //if(tabledata[i].settlemethod!="红冲"){
             tmoney=parseFloat(tmoney)-parseFloat(tabledata[i].factmoney);
             tmoney=parseFloat(tmoney.toFixed(2));
             all_cur_money=all_cur_money+parseFloat(tabledata[i].factmoney);
             all_cur_money=parseFloat(all_cur_money.toFixed(2));
           //}
       }
    }
    if(tmoney<0){
    	 jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>本次收取的金额【"+all_cur_money+"】大于网银余额【"+stmoney+"】\n不能执行下一步.请调整.</div>",'error');
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
	 var currentTable1 = getTracywindyObject('table_id_table_leasing_delivery_plan');
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
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_delivery_plan',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    isNeedTools:currentIsNeedTools,
	    tools:'修改|删除',
	    datas:JsonUtil.decode('${empty json_receivercharge_str ? "[]" : json_receivercharge_str }'),
	    validateForm : function(){
	    	var patrn = /^[+]?\d+(\.[0-9]{1,2})?$/;
	    	var factmoney = $('#id_factmoney').val();
	    	var fact_money = $('#id_fact_money').val();
	    	var plan_money = $('#id_plan_money').val();
	    	
	    	if (patrn.exec(factmoney)) {
	    		if (parseFloat(fact_money) +parseFloat(factmoney) >  parseFloat(plan_money)) {
	    			alert("当前实收金额加已收金额不能大于计划金额");
	    			return false;
	    		}
	    	} else {
	    		alert('请输入正确的金额');
	    		return false;
	    	}
	    	return true;
	    },
	    columns:[
			       {name:'id',  header:'id',hidden:true},
			       {name:'contract_id',  header:'contract_id',hidden:true},
			       {name:'fundfundchargeplan',  header:'fundfundchargeplan',hidden:true},
			       {name:'ebanknumber',  header:'网银编号',readOnly:true,hidden:true},
			       {name:'settlemethod',  header:'settlemethodId', hidden:true},
			       {name:'feetype',  header:'feetypeId', hidden :true},
			       {name:'contract_number',  header:'合同号',readOnly:true},
			       {name:'paymentid',  header:'付款编号',readOnly:true},
			       {name:'rawvaluefee_type',  header:'费用类型',type:'combobox',readOnly:true,hiddenName:'feetype',
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
			       {name:'status',  header:'回收状态',readOnly:true},
			       {name:'factdate',  header:'到账时间',type:'date',readOnly:true},
			       {name:'plan_money',  header:'应收金额',type:'double',readOnly:true,otherAttributes:'id="id_plan_money"'},
			       {name:'feeadjust',  header:'调整金额',hidden:true, defaultValue:0.00,readOnly:true},
			       {name:'fact_money',  header:'已收金额',readOnly:true,otherAttributes:'id="id_fact_money"'},
			       {name:'factmoney',  header:'本次金额',nullable:false,type:'double',otherAttributes:'id="id_factmoney"'}
			   ]
	 });
	 
});
</script>