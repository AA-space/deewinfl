<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <script language="javascript">
    jQuery(function(){
    	var currentIsNeedTools = true;
	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
	    	currentIsNeedTools = false;
	    }
	    var talbe= new tracywindyMultiTable({
	    renderTo:'id_table_leasing_fundfundchargeplan_container',
	    width:formWidth,
	    height:350,
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    operValidate:function(opertype,rowDatas){
	    	if(opertype=="add"){
					var custname = $("input[name='contract_info.custname']").val();    	
					$("input[name='contract_info.custname']").val(custname);
	    	}
            return changeoperarot(opertype,rowDatas);
	    },
		validateForm:function($me,currentTable){
			var rowData = currentTable.getCheckedRowDatas()[0];
		    var data = currentTable.tableData;
			var paymentId = $("#id_paymentidR").val();
	    	/* if(paymentId.length != 17){
				alert("收款编号不完整,请确认!");
				return false;
	        } */ 
			if(rowData != null){
				if (paymentId == rowData.paymentid) {
				
				} else {
					for(var i=0;i<data.length;i++){
						if(data[i]['paymentid'] == paymentId){
							alert("收款编号已存在,请重新输入!");
							return false;
						}
					}
				}
			}else{
				for(var i=0;i<data.length;i++){
					if(data[i]['paymentid'] == paymentId){
						alert("收款编号已存在,请重新输入!");
						return false;
					}
				}
			}
	 		if(!Validator.Validate(jQuery("#"+$me.windowId+" form")[0],1,false)){return false;};
	 		//if(!checkMoney()){return false;} 
	 		return true;
	 	},
	    tools:'新增|修改|删除',
	    datas:JsonUtil.decode('${empty json_fundchargeplanreceiver_str ? "[]" : json_fundchargeplanreceiver_str }'),
	    columns:[
	           {name:'id',  header:'id',hidden:true},
	  	       {name:'paymentid',  header:'收款编号',nullable:false,readOnly:false,defaultValue:"i-${requestScope['fundPlanPaymentId']}-",otherAttributes:'id="id_paymentidR"'},
	  	       /* {name:'rawValue_payobj',  header:'收款对象',type:'combobox',defaultRawValue:'',hiddenName:'payobj',
				    config:{
			       width:165,
			       xmlFileName:'\\eleasing\\workflow\\proj_approval\\simpleCustSelect.xml',
			       loadMode:'ajax',
			       isAjaxLenovo:true,
			       displayField:'name',
			       isForceModify:true,
			       valueField:'code',
			       params:{
	  	    	 	  custType:'cust_type.cust'
				   } 
	          }}, */
	          {name:'payobj',header:'收款对象',defaultValue:"${requestScope['contract_info.custname']}"},
	  	      {name:'rawValue_feetype',  header:'费用类型',nullable:false,type:'combobox',hiddenName:'feetype', config:{
			       width:165,
			       xmlFileName:'\\combos\\comboDict.xml',
			       loadMode:'ajax',
			       displayField:'name',
			       isForceModify:true,
			       valueField:'code',
			       params:{
			          pid:'FeeType'
			       } 
				}},
			   {name:'feetype',  header:'款项名称id',hidden:true},
	  	       {name:'planmoney',  header:'计划金额',nullable:false,type:'double'},
	  	       {name:'plandate',  header:'计划日期',nullable:false,type:'date'},
	  	       {name:'receivermoney',  header:'已收金额',type:'double',readOnly:true,defaultValue:'0.00'},
	  	       {name:'rawValue_planmoneystatus',header:'收款状态',defaultValue:'未收款',readOnly:true},
	  	       {name:'planmoneystatus',header:'收款状态',hidden:true},
	  	       {name:'paytype',header:'收付方向',defaultValue:'pay_type_in',hidden:true},
	  	       {name:'fpnote', header:'备注',type:'textarea'}
	     ]
	 });
   });

   </script>