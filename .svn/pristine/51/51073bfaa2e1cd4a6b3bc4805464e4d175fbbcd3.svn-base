<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<script>
	jQuery(function(){
		 function setFundFundChargePlanReback(table){
		    	//loadMask_oper.show();
		    	var plandata =table.getCheckedRowDatas();
		        var allItems = document.getElementsByName(table.checkName);
		        var currentTabled =getTracywindyObject('table_id_current_fund_income_detial_container');
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
		                if(isAddPlanData==""){isAddPlanData=plandata[i].planlist;}else{isAddPlanData=isAddPlanData+","+plandata[i].planlist;}
		            }else{
		            	 var _temPlandata =  jQuery.extend({},plandata[i]);
		            	 _temPlandata.rent=parseFloat(plandata[i].rent)*(-1);
		            	 _temPlandata.corpus=parseFloat(plandata[i].corpus)*(-1);
		            	 _temPlandata.interest=parseFloat(plandata[i].interest)*(-1);
		            	 _temPlandata.penalty=parseFloat(plandata[i].penalty)*(-1);
		            	 _temPlandata.interestadjust=parseFloat(plandata[i].interestadjust)*(-1);
		            	 _temPlandata.penaltyadjust=parseFloat(plandata[i].penaltyadjust)*(-1);
		            	 _temPlandata.rollback=1;
		            	 _temPlandata.pid=plandata[i]['id'];
		            	 _temPlandata.balancemode="PayFund9";
		            	 _temPlandata.rawValue_balancemode="红冲";
		            	 temp=(parseFloat(plandata[i].rent)+parseFloat(plandata[i].penalty)+parseFloat(plandata[i].penaltyadjust));
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
    var currentIsNeedTools = false;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	var table_fund_rent_inComes= new tracywindyMultiTable({
	    renderTo:'id_fund_income_history_container',
	    width:formWidth,
	    height:350,
	    isNeedTools:currentIsNeedTools,
	    isFit:false,
	    otherTools : [ {
			html : '<font color="red">生成租金红冲</font>',
			handler : function() {
				var fundPlan = table_fund_rent_inComes.getCheckedRowDatas();
				if (0 == fundPlan.length) {
					alert("请选择租金计划!");
					return false;
				}
				setFundFundChargePlanReback(table_fund_rent_inComes)
			},
			iconCls : 'icon-update'
		} ],
	    datas:JsonUtil.decode('${empty fund_income_history ? "[]" : fund_income_history }'),
	    isRank:true,
	    rankSize:60,
	    columns:[
	           {name:'id',  header:'id',hidden:true},
	  	       {name:'planid',header:'租金计划',hidden:true},
	  	       {name:'planlist',  header:'计划期项'},
	  	       {name:'ebanknumber',  header:'网银编号'},
	  	       {name:'hirelist',  header:'回笼期项'},
	  	     {name:'balancemode',  header:'balancemode',hidden:true},
		       {name:'rawValue_balancemode',  header:'结算方式',nullable:false,type:'combobox',hiddenName:'balancemode',
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
	  	       {name:'hiredate',  header:'回笼日期'},
	  	       {name:'rent',  header:'回笼租金' , nullable:false,type:'double'},
	  	       {name:'corpus',  header:'回笼本金' , nullable:false,type:'double'},
	  	       {name:'interest',  header:'回笼租息', nullable:false,type:'double'},
	  	       {name:'penalty',  header:'回笼罚息' , nullable:false,type:'double'},
	  	       {name:'interestadjust',  header:'租息调整', nullable:false,type:'double'},
	  	       {name:'penaltyadjust',  header:'罚息调整', nullable:false,type:'double'},
	  	       {name:'invoiceno',  header:'单据号'},
	  	       {name:'accountingdate',  header:'会计处理日'},
	  	       {name:'ownbank',  header:'本方银行'},
	  	       {name:'ownaccount',  header:'本方银行账户'},
	  	       {name:'hireobject',  header:'付款人'},
	  	       {name:'hirebank',  header:'付款人银行'},
	  	       {name:'hirenumber',  header:'付款人帐号'}
	     ]
	 });
});
	</script>