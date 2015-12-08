<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_rent_up_plan_container',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    isNeedTools:false,
		   // isNeedTools:currentIsNeedTools,
		    //tools:'新增|修改|删除',
		 otherTools:[{
			 html:'<font style="color:red;font-weight:BOLD;">'+"选择抵扣"+'</font>',
				iconCls:'icon-'+"import",
				handler:function(table){
					setDataDetail(table);
					jQuery.messager.alert('提示',"<div style='font-size:12px;line-height:30px;'>请查看本次租金回笼明细</div>",'info');
					table.reload();
				}
			 
		 }],
	    datas:JsonUtil.decode('${empty json_rent_up_plan_str ? "[]" : json_rent_up_plan_str }'),
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'planid',  header:'planId',hidden:true},
	       {name:'rentlist',  header:'期次',nullable:false},
	       {name:'rawValue_planstatus',  header:'回笼状态',nullable:false},
	       {name:'plandate',  header:'计划日期',nullable:false},
	       {name:'rent',  header:'计划租金',nullable:false},
	       {name:'corpus',  header:'计划本金',nullable:false},
	       {name:'interest',  header:'计划租息',nullable:false},
	       {name:'penalty',  header:'应收罚款',nullable:false},
	       {name:'currentoverage',  header:'租金余额',nullable:false},
	       {name:'curcorpusoverage',  header:'本金余额',nullable:false},
	       {name:'curinterestoverage',  header:'利息余额',nullable:false},
	       {name:'penaltyoverage',  header:'罚息余额',nullable:false}	      
   	     ]
	 });
	 
});

function setDataDetail(table) {
	var tabledata = table.getCheckedRowDatas();
	var currentTable2 = getTracywindyObject('table_id_table_leasing_rent_up_detail_container');
	var deduction_caution = document.getElementById("projcondition_info.deductible").value;
	var surpluscaution = document.getElementById("projcondition_info.surpluscaution").value; //4.2剩余保证金
	var dc = parseFloat(deduction_caution);
	var ss = parseFloat(surpluscaution);
	var caution_money ={};
	caution_money.corpus = "0.00"; //回笼本金
	caution_money.interestadjust = "0.00"; //租息调整
	caution_money.penaltyadjust = "0.00"; //罚息调整
	caution_money.penalty="0.00"; //回笼租罚息
	caution_money.interest="0.00";//回笼租息
	caution_money.invoiceno = "-"; //单据号
	caution_money.balancemode = "PayFund7";//结算方式
	caution_money.rawValue_balancemode="保证金抵扣";
	for ( var i = 0; i < tabledata.length; i++ )
	{
		//caution_money.planid=tabledata[i].id;
		caution_money.planid=tabledata[i].planid;
		caution_money.contractid="${requestScope['contract_info.id'] }";
		caution_money.hiredate = tabledata[i].plandate;//取当期计划日期
		caution_money.planlist = tabledata[i].rentlist; //复制期次
		caution_money.hirelist = tabledata[i].rentlist;//回笼期项
		var interest = parseFloat(tabledata[i].curinterestoverage); //利息余额 
		var corpus = parseFloat(tabledata[i].curcorpusoverage); //本金余额
		if ( interest == 0 && corpus == 0 )
		{
			alert("已结清不允许再抵扣!");
			return false;
		}
	if( dc-corpus >= 0 )  //dc  > corpus  核銷 所有corpus
	{
	 	   caution_money.corpus = decimal(corpus,2);
	 	   dc = dc-corpus;
	}
	else
	{
		   caution_money.corpus = decimal(dc,2);
		   dc = 0;
		   if( dc-interest  <= 0 )
		   {	//不足以抵扣利息的情况	   
		   		caution_money.rent  = parseFloat(parseFloat(caution_money.corpus)
		   				+ parseFloat(caution_money.interest)).toFixed(2);
		   }
		   currentTable2.AddRow(caution_money);
		   break; 
	}
	if( dc-interest >= 0)
	{
	 	   caution_money.interest=decimal(interest,2);
	 	   dc=dc-interest;
	}
	else
	{
	   caution_money.interest=decimal(dc,2);
	   if (parseFloat(interest - caution_money.interest).toFixed(2) ==0) //利息都抵扣完的情况
	   {
		   caution_money.rent  = parseFloat(parseFloat(caution_money.corpus)
				   +parseFloat(caution_money.interest)).toFixed(2);
	   }
	       currentTable2.AddRow(caution_money);
	   break; 
	}
	
	caution_money.rent = parseFloat(caution_money.interest) + parseFloat(caution_money.corpus);
	currentTable2.AddRow(caution_money);
  }
		
}
 

</script>