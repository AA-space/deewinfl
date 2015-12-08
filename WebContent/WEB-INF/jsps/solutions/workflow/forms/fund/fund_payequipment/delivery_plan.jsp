<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <script type="text/javascript">
    function getCurrentDate(){
        var cdate=new Date();
        return cdate.getFullYear()+"-"+(parseFloat(cdate.getMonth())+1)+"-"+cdate.getDate();
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
    var loadMask_oper ;//= new tracywindyLoadMask(document.body,'操作进行中，请稍等...');
    function setFundFundChargePlan(table){

    	//获取合同额度
    	var currentTablelimit = getTracywindyObject('table_id_table_leasing_contract_limit_list');
		var tabledatalimit=currentTablelimit.getRowsData();
			var sumMoney=0;
			for(var j=0;j<tabledatalimit.length;j++)
			{
	       sumMoney=sumMoney+parseFloat(tabledatalimit[j].limitmoney);
		 	}
		 	//alert(sumMoney);
        
    	var firstpayment = JsonUtil.decode('${firstpayment}');
    	//console.info(firstpayment);
    	if(loadMask_oper==null){
    		loadMask_oper = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');
    	}
    	loadMask_oper.show();
    	var plandata = table.getCheckedRowDatas();
        var allItems = document.getElementsByName(table.checkName);
        for(var i= 0;i<allItems.length;i++)
        {
           if(allItems[i].checked)
            {
        	   allItems[i].checked=false;
           }
        } 
        var currentTable1 = getTracywindyObject('table_id_table_leasing_contract_fund_payment_now_container');
       var planTable = getTracywindyObject('table_id_table_leasing_delivery_plan');
        //计算合计计划投放金额
        var datas = planTable.tableData;
        var totalPlanMoney = 0;
        for ( var int = 0; int < datas.length; int++) {
        	totalPlanMoney += parseFloat(datas[int].planmoney);
		}
        var talbedata=currentTable1.getRowsData();
        var iddata=getTableColumnData(talbedata,"id");
        var isAddPlanData="";
        var curdate=getCurrentDate();
        for(i=0;i<plandata.length;i++){
          if(parseFloat(plandata[i].planmoney)>parseFloat(plandata[i].receivermoney)){
               var fund={};
               if(checkIdIsAdd(plandata[i].id,iddata)){
                   if(isAddPlanData==""){isAddPlanData=plandata[i].paymentid;}else{isAddPlanData=isAddPlanData+","+plandata[i].paymentid;}
               }else{
               fund.id=plandata[i].id;
               fund.fundfundchargeplan=plandata[i].paymentid;
               //fund.ebanknumber=ebank["fund_ebank_data.ebdataid"];
               fund.feetype='feetype10';
               fund.rawValue_feetype = '设备款';
               //付款时间由最后一步出纳填写
               //fund.factdate=plandata[i].plandate;
              var temp=parseFloat(plandata[i].planbalance);
               //fund.factmoney=temp.toFixed(2);
               fund.feeadjust=0.00;
               fund.receivermoney=temp.toFixed(2);
               fund.factobject=plandata[i].payobj;
               fund.oper="add";
               fund.settlemethod="PayFund6";
               fund.rawValue_settlemethod="电汇";
               //fund.accountbank=ebank["fund_ebank_data.ownbank"];
               //fund.account=ebank["fund_ebank_data.ownaccount"];
               //fund.accnumber=ebank["fund_ebank_data.ownaccnumber"];
               //fund.factobject=ebank["fund_ebank_data.clientname"];
               //fund.clientbank=ebank["fund_ebank_data.clientbank"];
               //fund.clientaccount=ebank["fund_ebank_data.clientaccount"];
               //fund.clientaccnumber=ebank["fund_ebank_data.clientaccnumber"];
               fund.fundfundchargeplan=plandata[i].id;;
               fund.accountingdate=curdate;
               fund.paytype='pay_type_out';
               fund.accountingdate=curdate;
               fund.invoiceno="";
               fund.ffcmemo=plandata[i].fpnote;
               fund.contractid=plandata[i].contractid;
               fund.contractnumber=plandata[i].contractnumber;
               fund.equipmoney=plandata[i].planmoney;
               fund.equipcount='${equipcount}';
               fund.paymentid=plandata[i].paymentid;
               fund.factmoney=parseFloat(plandata[i].planmoney)-parseFloat(sumMoney);
               //fund.factmoney= totalPlanMoney;
               fund.clientbank='${dealer_bankName}';
               fund.clientaccount='${dealer_account}';
               fund.clientaccnumber='${dealer_accNumber}';
               fund.planfirstpayment = firstpayment['datas'][0]['plan_money'];
               fund.factfirstmoney = firstpayment['datas'][0]['plan_first_fact_money'];
               fund.custname= $('input[name="contract_info.custname"]').val();
               if(talbedata.length==0)
               {
                     fund.creditmoney=sumMoney;
                }else{
                	fund.creditmoney=0;
                }
                       
               currentTable1.AddRow(fund);
               }
          }else{
        	  loadMask_oper.hide();
        	  jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>编辑号"+plandata[i].paymentid+"已经回笼</div>",'error'); 
        	  return false;
           }
          
        }
        loadMask_oper.hide();
        if(isAddPlanData==""){
            jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>操作成功</div>",'success'); 
        }else{
        	jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>操作成功其中"+isAddPlanData+"已经加到实收计划中不能重复添加</div>",'success'); 
            }
        }
    
    jQuery(function(){
        if(isSubTable){
    	var currentIsNeedTools = false;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    var talbe= new tracywindyMultiTable({
	    renderTo:'id_table_leasing_delivery_plan',
	    width:formWidth,
	    height:350,
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    otherTools : [ {
			html : '<font color="red">生成资金投放</font>',
			handler : function(table) {
				var fundPlan = table.getCheckedRowDatas();
				if (0 == fundPlan.length) {
	         		alert("请选择需要资金计划!");
					return false;
				}
				setFundFundChargePlan(talbe)
			},
			iconCls : 'icon-update'
		} ],
	    datas:JsonUtil.decode('${empty json_leasing_delivery_plan_str ? "[]" : json_leasing_delivery_plan_str }'),
	    columns:[
	           {name:'id',  header:'id',hidden:true},
	  	       {name:'paymentid',  header:'投放编号',nullable:false,readOnly:false},
	  	       {name:'contractid',  header:'contractid',hidden:true},
	  	       {name:'contractnumber',  header:'contractnumber',hidden:true},
	  	       {name:'planmoney',  header:'计划金额',nullable:false,type:'double'},
	  	       {name:'plandate',  header:'计划投放日期',nullable:false},
	  	       {name:'receivermoney',  header:'已投放金额',nullable:false,type:'double'},
	  	       {name:'adjustmoney',  header:'调整金额',nullable:false,type:'double'},
	  	       {name:'planbalance',  header:'可投放金额',nullable:false,type:'double'},
	  	       {name:'payobj',  header:'付款对象'},
	  	       {name:'planmoneystatus',  header:'planmoneystatusid', hidden:true},
	  	       {name:'rawValue_planmoneystatus',  header:'投放状态'},
	  	       {name:'fpnote', header:'备注',type:'textarea'}
	     ]
		 });
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	$('#table_id_table_leasing_delivery_plan_toolsDiv').parent().hide();
	    }
      }
   });

   </script>