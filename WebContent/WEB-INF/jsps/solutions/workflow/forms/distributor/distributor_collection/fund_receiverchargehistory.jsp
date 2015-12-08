<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
    <script>
          var util = {   
    		    clone : function(obj) {   
    		        if (typeof (obj) != 'object')   
    		            return obj;   
    		  
    		        var re = {};   
    		        if (obj.constructor==Array)   
    		            re = [];   
    		  
    		        for ( var i in obj) {   
    		            re[i] = util.clone(obj[i]);   
    		        }   
    		  
    		        return re;   
    		  
    		    }   
    		}; 
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
    function setFundFundChargePlanReback(table){
    	loadMask_oper.show();
    	var plandata = table.getCheckedRowDatas();
        var allItems = document.getElementsByName(table.checkName);
        var currentTabled =getTracywindyObject('table_id_table_receivercharge_container');
        var talbedata=currentTabled.getRowsData();
        var iddata=getTableColumnData(talbedata,"id");
        var isAddPlanData="";
        var reBackData=[];
        for(var i=0;i<plandata.length;i++){
            if(plandata[i].factmoney!=plandata[i].overmoney){
            	 loadMask_oper.hide();
            	 var tempmessage="";
            	 if(parseFloat(plandata[i].overmoney)==0){tempmessage="余额为0"}
            	 else{tempmessage="有抵扣和退款操作";} 
            	 jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>金额为"+plandata[i].factmoney+"的保证金"+tempmessage+"不能红冲</div>",'error'); 
                  return false;
             }else{
        	if(checkIdIsAdd(plandata[i].id,iddata)){
                if(isAddPlanData==""){isAddPlanData=plandata[i].feetype+":"+plandata[i].factmoney;}else{isAddPlanData=isAddPlanData+","+plandata[i].feetype+":"+plandata[i].factmoney;}
            }else{
                 var tdate={};
                 tdate=util.clone(plandata[i]);
                 tdate.factmoney=parseFloat(tdate.factmoney)*(-1);
                 var temp=parseFloat(tdate.factmoney)+parseFloat(tdate.feeadjust);
                 tdate.settlemethod="PayFund9";
                 tdate.rawValue_settlemethod="红冲";
                 tdate.oper="old";
                 tdate.pid=tdate.id;
                 reBackData.push(tdate);
            }}
        }
        currentTabled.AddRows(reBackData);
        for(var i= 0;i<allItems.length;i++)
        {
           if(allItems[i].checked)
            {
        	   allItems[i].checked=false;
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
	 var fund= new tracywindyMultiTable({
	    renderTo:'id_table_receiverchargehistory_container',
	    width:formWidth,
	    tools:"新增|修改",
	    isNeedTools:currentIsNeedTools,
	    otherTools : [ {
			html : '<font color="red">生成资金红冲</font>',
			handler : function(table) {
				var fundPlan = table.getCheckedRowDatas();
				if (0 == fundPlan.length) {
				      //alert("请选择需要红冲的保证金计划!");
					 jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>请选择需要红冲的保证金计划</div>",'error'); 
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
			       {name:'ebanknumber',  header:'网银编号'},
			       {name:'feetype',  header:'费用类型',hidden:true,nullable:false},
			       {name:'rawValue_feetype',  header:'费用类型',nullable:false},
			       {name:'factmoney',  header:'实收金额',nullable:false,type:'double'},
			       {name:'deductionmoney',  header:'抵扣金额',nullable:false,type:'double'},
			       {name:'drawbackmoney',  header:'退款金额',nullable:false,type:'double'},
			       {name:'crwmoney',  header:'红冲金额',nullable:false,type:'double'},
			       {name:'overmoney',  header:'保证金余额',nullable:false,type:'double'},
			       {name:'settlemethod',  header:'结算方式id',hidden:"true",nullable:false},
			       {name:'rawValue_settlemethod',  header:'结算方式',nullable:false},
			       {name:'factdate',  header:'到账时间',nullable:false},
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