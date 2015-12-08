<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <script language="javascript">
    jQuery(function() {
		//########公共JS事件##########
		$("#id_due_info_tabs_content").css("width", (1000) + "px");
		$("#id_due_info_tabs_content").tabs();
		
	});
    function funddue(){
        var fundtable=getTracywindyObject('table_id_rceiverdeductionplan');
    	var fundPlan = fundtable.getCheckedRowDatas();
    	var renttable=getTracywindyObject('table_id_rentdeductionplan');
     	var rentPlan = renttable.getCheckedRowDatas();
		if (fundPlan.length>=1 || rentPlan.length>=1 ){
			//实际付设备款
			 //var  paytable= getTracywindyObject('table_id_table_leasing_json_paychargeplan_container');
			 var  paytable= getTracywindyObject('table_id_table_leasing_delivery_plan');
             var tempchargepayplan=paytable.getCheckedRowDatas();
			 var cmessage="";
			 cmessage=setFundFundChargePlan(paytable,fundtable,renttable); 
			//实际收款 
			 if(cmessage!=""){
                alert(cmessage);
                return ;
		     }
			 else{
				 if(cmessage==""){alert("操作成功!");}else{alert(cmessage);}
			 }
			 jQuery("#fund_rceiverdeductionplan").hide();
			 jQuery("#fund_rceiverdeductionplan").window("close");
		}else{
			alert("选择货扣的计划!");
	   }
    }
    jQuery(function(){
    	var currentIsNeedTools = false;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    var talbe=new tracywindyMultiTable({
	    renderTo:'id_rceiverdeductionplan',
	    isNeedTools:currentIsNeedTools,
	    loadMode:'ajax',
        operButtons:'',
        lazyLoad:true,
        xmlFileName:'eleasing/workflow/fund/fundPlanSelect.xml',
	    columns:[
	           {name:'id',  header:'id',hidden:true},
	  	       {name:'paymentid',  header:'收款编号',nullable:false,readOnly:false},
	  	       {name:'payobj',  header:'付款对象'},
	  	       {name:'feetype',  header:'feetypeId',hidden:true,defaultvalue:1},
	  	       {name:'rawValue_feetype',  header:'费用类型'},
	  	       {name:'planmoney',  header:'计划金额',nullable:false,type:'double'},
	  	       {name:'plandate',  header:'计划日期',nullable:false},
	  	       {name:'receivermoney',  header:'已收金额',nullable:false,type:'double'},
	  	       {name:'adjustmoney',  header:'调整金额',nullable:false,type:'double'}, 
	  	       {name:'planbalance',  header:'未收金额',nullable:false,type:'double'}, 
	  	       {name:'fpnote', header:'备注',type:'textarea'}
	     ],
	     params:{noload:true}
	 });
	    var table_proj_fund_rent_plan= new tracywindyMultiTable({
		    renderTo:'id_rentdeductionplan',
		    isNeedTools:currentIsNeedTools,
		    loadMode:'ajax',
	        operButtons:' ',
	        isFit:true,
	        width:1000,
	        lazyLoad:true,
		    xmlFileName:'eleasing/workflow/rentandfund/RentPlan.xml',
		    columns:[
		           {name:'id',  header:'id',hidden:true},
		  	       {name:'rentlist',  header:'期次'},
		  	       {name:'plandate', header:'计划日期'},
		  	       {name:'rent', header:'计划租金' ,nullable:false,type:'double'},
		  	       {name:'corpus', header:'计划本金', nullable:false,type:'double'},
		  	       {name:'interest',  header:'计划租息', nullable:false,type:'double'},
		  	       {name:'penalty',  header:'应收罚息' , nullable:false,type:'double'},
		  	       {name:'currentoverage',  header:'租金余额' , nullable:false,type:'double'},
		  	       {name:'curcorpusoverage',  header:'本金余额' , nullable:false,type:'double'},
		  	       {name:'curinterestoverage',  header:'利息余额' , nullable:false,type:'double'},
		  	       {name:'penaltyoverage',  header:'罚息余额', nullable:false,type:'double'}
		     ] 
		 });	 
   });
   </script>
   <div id="fund_rceiverdeductionplan"  style="width:1000px;display: none;overflow:hidden;" title="抵扣计划">
	   <div id="id_table_leasing_proj_report_info_container" style="overflow: hidden;height:300">
      		         <br/>&nbsp;&nbsp;<button class="btn btn-primary" onclick="funddue()"  ><span>抵扣</span></button>
        </div>
	   <table class="fillTable" cellspacing="0" cellpadding="0">
	    	<tr class="tr-project-business-condition">
	          	<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
			<!-- 标签栏 -->
			    <div id='id_due_info_tabs_content' style="">
					<div title="收款计划">
					    <span class="print-tabs-title-content">租金发票类型</span>
						<div id="id_rceiverdeductionplan" style="overflow: hidden;"></div>
					</div>	
					<div title="租金计划">
					    <span class="print-tabs-title-content">租金发票类型</span>
						<div id="id_rentdeductionplan" style="overflow: hidden;"></div>
					</div>	
				</div>
		      </td>
	         </tr>
           </table>
    </div>
    <script language="javascript">
    function setFundDeductionInfo(funddate,dueDate){
        var fundTable= getTracywindyObject('table_id_table_receivercharge_container');
        var talbedata=fundTable.getRowsData();
        var iddata=getTableColumnData(talbedata,"id");
        var isAddPlanData="";
        var curdate=getCurrentDate();
        var fund={};
        if(checkIdIsAdd(funddate.id,iddata)){
        	return "编号为"+funddate.paymentid+"已经加到实收计划中不能重复添加"; 
        }else{
        fund.id=funddate.id;
        fund.pid=funddate.id;
        fund.paymentid=funddate.paymentid;
        fund.ebanknumber="";
        fund.feetype=funddate.feetype;
        fund.rawValue_feetype=funddate.rawValue_feetype;
        fund.settlemethod="PayFund11";
        fund.rawValue_settlemethod="货扣";
        fund.factdate=curdate;
        fund.paytype="pay_type_in";
        fund.rawValue_paytype="收款";
        var temp=parseFloat(dueDate.factmoney);
        fund.factmoney=temp.toFixed(2);
        fund.receivermoney=temp.toFixed(2);
        fund.feeadjust=0.00;
        fund.oper="add";
        fund.accountbank="";
        fund.account="";
        fund.accnumber="";
        fund.factobject="";
        fund.clientbank="";
        fund.clientaccount="";
        fund.clientaccnumber="";
        fund.accountingdate=curdate;
        fund.fundfundchargeplan=funddate.id;
        fund.ffcmemo="抵扣编号为"+dueDate.paymentid+"的"+dueDate.rawValue_feetype+"付款计划";
        fundTable.AddRow(fund);
      }
    }
    function setRentDeductionInfo(rentdate,dueDate){
        var fundTable= getTracywindyObject('table_id_current_fund_income_detial_container');
        var talbedata=fundTable.getRowsData();
        var iddata=getTableColumnData(talbedata,"id");
        var isAddPlanData="";
        var curdate=getCurrentDate();
        var fund={};
        if(checkIdIsAdd(rentdate.id,iddata)){
        	alert( "编号为第"+rentdate.rentlist+"期租金已经加到实收计划中不能重复添加"); 
        }else{
             var rent=calculatePlanRent(dueDate.factmoney,rentdate.curcorpusoverage,rentdate.curinterestoverage,rentdate.penaltyoverage);
        	 fund.id=rentdate.id;
        	 fund.pid=dueDate.id;
             fund.planlist=rentdate.rentlist;
             fund.planid=rentdate.id;
             fund.ebanknumber="";
             fund.balancemode="PayFund11";
             fund.rawValue_balancemode="货扣";
             fund.hirelist=rentdate.rentlist;
             fund.hiredate=curdate;
             fund.rent=rent.rent;
             fund.corpus=rent.corpus;
             fund.interest=rent.interest;
             fund.penalty=rent.penalty;
             fund.interestadjust=0.00;
             fund.penaltyadjust=0.00;
             temp=parseFloat(fund.rent)+parseFloat(fund.penalty);
             fund.receivermoney=temp.toFixed(2);
             fund.accountingdate=curdate;
             fund.ownbank="";
             fund.ownaccount="";
             fund.accnumber="";
             fund.hireobject="";
             fund.hirebank="";
             fund.clientaccount="";
             fund.invoiceno="";
             fund.memo="抵扣编号为"+dueDate.paymentid+"的"+dueDate.rawValue_feetype+"付款计划";
             fundTable.AddRow(fund);
      }
    }
    </script>