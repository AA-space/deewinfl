<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <script language="javascript">
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
        var currentTable1 = getTracywindyObject('table_id_table_receivercharge_container');
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
               fund.paymentid=plandata[i].paymentid;
               fund.ebanknumber=ebank["fund_ebank_data.ebdataid"];
               fund.feetype=plandata[i].feetype;
               fund.rawValue_feetype=plandata[i].rawValue_feetype;
               fund.settlemethod="PayFund6";
               fund.rawValue_settlemethod="电汇";
               fund.factdate=ebank["fund_ebank_data.factdate"];
               var temp=parseFloat(plandata[i].planbalance);
               fund.factmoney=temp.toFixed(2);
               fund.receivermoney=temp.toFixed(2);
               fund.feeadjust=0.00;
               fund.oper="add";
               fund.accountbank=ebank["fund_ebank_data.ownbank"];
               fund.account=ebank["fund_ebank_data.ownaccount"];
               fund.accnumber=ebank["fund_ebank_data.ownaccnumber"];
               fund.factobject=ebank["fund_ebank_data.clientname"];
               fund.clientbank=ebank["fund_ebank_data.clientbank"];
               fund.clientaccount=ebank["fund_ebank_data.clientaccount"];
               fund.clientaccnumber=ebank["fund_ebank_data.clientaccnumber"];
               fund.accountingdate=curdate;
               fund.fundfundchargeplan=plandata[i].id;;
               fund.invoiceno="";
               fund.ffcmemo=plandata[i].fpnote;
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
    	var currentIsNeedTools = false;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    var talbe= new tracywindyMultiTable({
	    renderTo:'id_table_receiverchargeplan_container',
	    width:formWidth,
	    height:350,
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    otherTools : [ {
			html : '<font color="red">生成资金收款</font>',
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
	    datas:JsonUtil.decode('${empty json_receiverchargeplan_str ? "[]" : json_receiverchargeplan_str }'),
	    columns:[
	           {name:'id',  header:'id',hidden:true},
	  	       {name:'paymentid',  header:'收款编号',nullable:false,readOnly:false},
	  	       {name:'payobj',  header:'付款对象'},
	  	       {name:'feetype',  header:'feetypeId',hidden:true,defaultvalue:1},
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
	  	       {name:'planmoney',  header:'计划金额',nullable:false,type:'double'},
	  	       {name:'plandate',  header:'计划日期',nullable:false},
	  	       {name:'receivermoney',  header:'已收金额',nullable:false,type:'double'},
	  	       {name:'adjustmoney',  header:'调整金额',nullable:false,type:'double'}, 
	  	       {name:'planbalance',  header:'未收金额',nullable:false,type:'double'}, 
	  	       {name:'planmoneystatus',  header:'planmoneystatusid', hidden:true},
	  	       {name:'rawValue_planmoneystatus',  header:'投放状态'},
	  	       {name:'fpnote', header:'备注',type:'textarea'}
	     ]
	 });
   });

   </script>