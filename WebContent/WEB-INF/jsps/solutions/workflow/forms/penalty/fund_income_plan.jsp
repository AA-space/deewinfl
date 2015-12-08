<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
    <script language="javascript">
    function getCurrentDate(){
        var cdate=new Date();
        var month=(parseFloat(cdate.getMonth())+1);
        var day=cdate.getDate();
        if(parseFloat(day)<10){day="0"+day;}
        if(parseFloat(month)<10){month="0"+month;}
        return cdate.getFullYear()+"-"+month+"-"+day;
    }
    function checkIdIsAdd(id,ids){
        if(ids.length>0){
        for(var i=0;i<ids.length;i++){
         if(id==ids[i]){return true;}
        }
        return false;
        }else{return false;}
    }
    function getTableColumnData(tabledatas,column){
        var cdata=[];
        if(tabledatas.length>0){
            for(var i=0;i<tabledatas.length;i++){
                var ctable=tabledatas[i];
                cdata[i]=ctable[column];
            }
        }
        return cdata;
    }
    var loadMask_oper = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');
    function setFundFundChargePlan(table){
    	loadMask_oper.show();
    	var plandata = table.getCheckedRowDatas();
        var ebankdatas=jQuery("#fund_ebank_data input[type='text'],#fund_ebank_data textarea");
        var ebank=[];
        var i=0;
        for(i=0;i<ebankdatas.length;i++){
           ebank[ebankdatas[i].name]=ebankdatas[i].value;
        }
        var allItems = document.getElementsByName(table.checkName);
        for(var i= 0;i<allItems.length;i++)
        {
           if(allItems[i].checked)
            {
        	   allItems[i].checked=false;
           }
        } 
        var currentTable1 = getTracywindyObject('table_id_current_fund_income_detial_container');
        var talbedata=currentTable1.getRowsData();
        var iddata=getTableColumnData(talbedata,"id");
        var isAddPlanData="";
        var curdate=getCurrentDate();
        for(i=0;i<plandata.length;i++){
          if(parseFloat(plandata[i].currentoverage)>0 || parseFloat(plandata[i].penaltyoverage)>0 ){
               var fund={};
               if(checkIdIsAdd(plandata[i].id,iddata)){
                   if(isAddPlanData=="")
                   {
                	   isAddPlanData= plandata[i].contractnumber+"第"+plandata[i].rentlist;
                   }
                   else{isAddPlanData = plandata[i].contractnumber+",第"+isAddPlanData+","+plandata[i].rentlist+"期";}
               }else{   
               fund.id=plandata[i].id;
               fund.planid=plandata[i].id;
               fund.planlist=plandata[i].rentlist;
               fund.contractnumber=plandata[i].contractnumber;
               fund.contractid=plandata[i].id;
               fund.ebanknumber=ebank["fund_ebank_data.ebdataid"];
               fund.balancemode="";
               fund.rawValue_balancemode="";
               fund.hirelist=plandata[i].rentlist;
               //fund.hiredate=curdate;//当前时间
               fund.hiredate=plandata[i].plandate;//取计划时间
               fund.rent=0.00;//plandata[i].currentoverage;
               fund.corpus=0.00;//plandata[i].curcorpusoverage;
               fund.interest=0.00;//plandata[i].curinterestoverage;
               fund.penalty=0.00;
               fund.interestadjust=0.00;
               fund.penaltyadjust=plandata[i].penaltyoverage;
               temp=0.00;//parseFloat(plandata[i].currentoverage)+parseFloat(plandata[i].penaltyoverage);
               fund.receivermoney=temp.toFixed(2);
               fund.accountingdate=curdate;
               fund.oper="add";     
               fund.ownbank=ebank["fund_ebank_data.ownbank"];
               fund.ownaccount=ebank["fund_ebank_data.ownaccount"];
               fund.accnumber=ebank["fund_ebank_data.ownaccnumber"];
               fund.hireobject=ebank["fund_ebank_data.clientname"];
               fund.hirebank=ebank["fund_ebank_data.clientbank"];
               fund.clientaccount=ebank["fund_ebank_data.clientaccount"];
               fund.hirenumber=ebank["fund_ebank_data.clientaccnumber"];
               fund.invoiceno="";
               currentTable1.AddRow(fund);
               }
          }else{
        	  loadMask_oper.hide();
        	  jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>"+plandata[i].contractnumber+">第"+plandata[i].rentlist+"期已经回笼</div>",'error'); 
        	  return false;
           }
          
        }
      //确认时判断是否有隔期核销
	//	doCheckRentListContinue('table_id_fund_income_plans_container','table_id_current_fund_income_detial_container'); 

        loadMask_oper.hide();
        if(isAddPlanData==""){
            jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>操作成功,请到罚息减免明细中确认</div>",'success'); 
        }else{
        	jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>操作成功其中"+isAddPlanData+"已经加到实收计划中不能重复添加</div>",'success'); 
            }
        
        }
	jQuery(function(){
		var currentIsNeedTools = false;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    var table_proj_fund_rent_plan= new tracywindyMultiTable({
		    renderTo:'id_fund_income_plans_container',
		    width:formWidth,
		    height:350,
		    isNeedTools:currentIsNeedTools,
		    isFit:false,
		    otherTools : [ {
				html : '<font color="red">罚息减免</font>',
				handler : function() {
					var fundPlan = table_proj_fund_rent_plan.getCheckedRowDatas();
					if (0 == fundPlan.length) {
						alert("请选择需要核销的租金计划!");
						return false;
					}        
					setFundFundChargePlan(table_proj_fund_rent_plan);
				},    
				iconCls : 'icon-update'
			} ],
		  datas:JsonUtil.decode('${empty fund_rent_plans ? "[]" : fund_rent_plans }'),
		    columns:[
		           {name:'id',  header:'id',hidden:true},
		  	       {name:'contractnumber',header:'合同号',width:'200'},
		  	       {name:'rentlist',  header:'计划期次'},
		  	       {name:'plandate', header:'计划日期'},
		  	       {name:'hirelist', header:'回笼期次',hidden:true},
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