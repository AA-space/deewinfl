<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
    <script>
    function setFundFundChargePlanReback(table){
    	//loadMask_oper.show();
    	var plandata = table.getCheckedRowDatas();
        var allItems = document.getElementsByName(table.checkName);
        var currentTabled =getTracywindyObject('table_id_table_receivercharge_container');
        var talbedata=currentTabled.getRowsData();
        var iddata=getTableColumnData(talbedata,"id");
        var isAddPlanData="";
        var reBackData=[];
        for(var i=0;i<plandata.length;i++){
        	if(plandata[i]['rollback'] == '1'){
        		jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>红冲数据不能再次红冲</div>",'error'); 
        		//loadMask_oper.hide();
        		if(allItems[i].checked)
                {
            	   allItems[i].checked=false;
               }
        		return;
        	}
        	
        	if(checkIdIsAdd(plandata[i].id,iddata)){
                if(isAddPlanData==""){isAddPlanData=plandata[i].fundfundchargeplan;}else{isAddPlanData=isAddPlanData+","+plandata[i].fundfundchargeplan;}
            }else{
            	 var _temPlandata =  jQuery.extend({},plandata[i]);
            	 _temPlandata.factmoney=parseFloat(plandata[i].factmoney)*(-1);
            	 _temPlandata.feeadjust=parseFloat(plandata[i].feeadjust)*(-1);
            	 _temPlandata.paymentid=plandata[i]['fundfundchargeplan.paymentId'];
            	 _temPlandata.rollback=1;
            	 _temPlandata.pid=plandata[i]['id'];
            	 _temPlandata.settlemethod="PayFund9";
            	 _temPlandata.rawValue_settlemethod="红冲";
                 var temp=parseFloat(plandata[i].factmoney)+parseFloat(plandata[i].feeadjust);
                 _temPlandata.receivermoney=temp.toFixed(2);
                 _temPlandata.oper="old";
                 reBackData.push(_temPlandata);
            }
        }
        currentTabled.AddRows(reBackData);
        for(var i= 0;i<allItems.length;i++)
        {
           if(allItems[i].checked)
            {
        	   allItems[i].checked=false;
           }
        } 
        //loadMask_oper.hide();
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
	 var fund= new tracywindyMultiTable({
	    renderTo:'id_table_receiverchargehistory_container',
	    width:formWidth,
	    height:350,
	    tools:"新增|修改",
	    isNeedTools:currentIsNeedTools,
	    otherTools : [ {
			html : '<font color="red">生成资金红冲</font>',
			handler : function(table) {
				var fundPlan = table.getCheckedRowDatas();
				if (0 == fundPlan.length) {
					alert("请选择需要资金计划!");
					return false;
				}
				setFundFundChargePlanReback(fund);
			},
			iconCls : 'icon-update'
		} ],
	    isFit:false,
	    datas:JsonUtil.decode('${empty json_receiverchargehistory_str ? "[]" : json_receiverchargehistory_str }'),
	    columns:[
	             {name:'id',  header:'id',hidden:true},
			       {name:'fundfundchargeplan',  header:'fundfundchargeplan',hidden:true},
			       {name:'fundfundchargeplan.paymentId',  header:'收款编号',nullable:false,readOnly:false},
			       {name:'ebanknumber',  header:'网银编号'},
			       {name:'feetype',  header:'费用类型',hidden:true},
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
			       {name:'settlemethod',  header:'settlemethodId',hidden :true},
			 	     {name:'rawValue_settlemethod',  header:'费用类型',nullable:false,type:'combobox',hiddenName:'settlemethod',
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
			       
			       {name:'factdate',  header:'到账时间',nullable:false},
			       {name:'factmoney',  header:'金额',nullable:false,type:'double'},
			       {name:'feeadjust',  header:'调整金额',nullable:false,type:'double'},
			       {name:'accountbank',  header:'银行'},
			       {name:'account',  header:'银行账户'},
			       {name:'accnumber',  header:'银行账号'},
			       {name:'factobject',  header:'付款客户'},
			       {name:'clientbank',  header:'客户银行'},
			       {name:'clientaccount',  header:'客户账户'},
			       {name:'clientaccnumber',  header:'客户帐号'},
			       {name:'accountingdate',  header:'会计处理日'},
			       {name:'invoiceno',  header:'单据号'},
			       {name:'ffcmemo', header:'备注',type:'textarea'},
			       {name:'creator',  header:'输入人'},
			       {name:'createdate',  header:'输入日期'}
	     ]
	 });
   });

   </script>