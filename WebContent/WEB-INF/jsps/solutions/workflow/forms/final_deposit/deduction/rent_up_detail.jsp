<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_rent_up_detail_container',
	    width:formWidth,
	    /*validateForm:function($me,currentTable){
	 		if(!Validator.Validate(jQuery("#"+$me.windowId+" form")[0],1,false)){return false;};
	 		//1.本次租金回笼明细对象
			 var currentTable = getTracywindyObject('table_id_table_leasing_rent_up_detail_container');
				//2.得到租金回笼计划表数据
			 var tabledata = currentTable.getRowsData();
				 //3.剩余保证金
			 var deductible = document.getElementById("projcondition_info.deductible").value;
			 var totleRentMoney =0.00;
			 var local_interest = document.getElementById("interest").value;
			 var local_corpus = document.getElementById("corpus").value;
			 var local_penalty = document.getElementById("interest").value;
			 var sumRenMoney = parseFloat(local_interest)+parseFloat(local_corpus)+parseFloat(local_penalty);
			 for(var i=0;i<tabledata.length;i++){
				 alert(tabledata[i].interest+"|"+tabledata[i].corpus+"|"+tabledata[i].penalty);
				 totleRentMoney = parseFloat(totleRentMoney) + (parseFloat(tabledata[i].interest)+parseFloat(tabledata[i].corpus)+parseFloat(tabledata[i].penalty))+sumRenMoney;
					
				 }
			 alert(totleRentMoney);
			 if(totleRentMoney>deductible){
				 jQuery.messager.alert('错误提示',"<div style='font-size:12px;line-height:30px;'>本次回笼租金不能大于保证金</div>",'error');
				 return false;
			 }
	 		return true;
	 	},*/
	    height:350,
	    isFit:true,
	    isNeedTools:true,
		isNeedTools:currentIsNeedTools,
		tools:'新增|修改|删除',
	    datas:JsonUtil.decode('${empty json_rent_up_detail_str ? "[]" : json_rent_up_detail_str }'),
	    updateFromOperCallBack:function(operType,thisForm,multiTable,rowData){
	 	   /*var rentValue = parseFloat(rowData.corpus)+parseFloat(rowData.interest)+parseFloat(rowData.penalty);
		   jQuery(thisForm).find("input[name='rent']").val(rentValue); 
			   */
		},
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'planlist',  header:'计划期项',nullable:false,type:'number'},
	       {name:'ebanknumber',  header:'网银编号'},//,nullable:false
	       {name:'hirelist',  header:'回笼期项',nullable:false,type:'number'},
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
	       {name:'hiredate',  header:'回笼日期',nullable:false,type:'date'},
	       {name:'rent',  header:'回笼租金',nullable:false,type:'double'},
	       {name:'corpus',  header:'回笼本金',nullable:false,type:'double',otherAttributes:" onpropertychange='javascript:onRentChangeValue();' oninput='javascript:onRentChangeValue(); '"},
	       {name:'interest',  header:'回笼租息',nullable:false,type:'double',otherAttributes:" onpropertychange='javascript:onRentChangeValue();' oninput='javascript:onRentChangeValue(); '"},
	       {name:'penalty',  header:'回笼罚息',nullable:false,type:'double'},//,otherAttributes:" onpropertychange='javascript:onRentChangeValue();' oninput='javascript:onRentChangeValue(); '"
	       {name:'interestadjust',  header:'租息调整',nullable:false,type:'double'},
	       {name:'penaltyadjust',  header:'罚息调整',nullable:false,type:'double'},
	       {name:'invoiceno',  header:'单据号',nullable:false},
	     
	       //{name:'accountingdate',  header:'会计处理日',type:'date',nullable:false},
	       //{name:'ownbank',  header:'本方银行',nullable:false},
	       //{name:'ownaccount',  header:'本方银行账户',nullable:false},
	      // {name:'ownnumber',  header:'本方银行账号',nullable:false},
	       //{name:'eqipname',  header:'付款人',nullable:false},
	       //{name:'eqipname',  header:'付款人银行',nullable:false,mapping:'eqipname'},
	     //  {name:'eqipname',  header:'付款人银行账户',nullable:false,mapping:'eqipname'},
	      // {name:'eqipname',  header:'付款人银行账号',nullable:false,mapping:'eqipname'}		      
	       {name:'planid',header:'计划编码',hidden: false}, 
	       {name:'contractid',header:'合同编码',hidden: false}
   	     ]
	 });
	 
});
function onRentChangeValue(){
	var $form = jQuery("#table_id_table_leasing_rent_up_detail_containerWindow form");
	var corpusVal = parseFloat($form.find("input[name='corpus']").val()); 
	corpusVal = isNaN(corpusVal)? 0.0 : corpusVal;
	var interestVal = parseFloat($form.find("input[name='interest']").val()); 
	interestVal = isNaN(interestVal)? 0.0 : interestVal;
	var penaltyVal = parseFloat($form.find("input[name='penalty']").val()); 
	penaltyVal = isNaN(penaltyVal)? 0.0 : penaltyVal;
	$form.find("input[name='rent']").val(parseFloat(corpusVal+interestVal).toFixed(2));//+penaltyVal  
}
</script>