<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <script language="javascript">
    function changeoperarot(opertype,rowDatas){
        var cmess=new Array();
         if(opertype=="update" || opertype=="remove"){
             if(rowDatas.length==0){ alert("请选择要操作的数据");return false;}
             else{
                      for(var i=0;i<rowDatas.length;i++){
                          if(rowDatas[i].rawValue_planmoneystatus!="未收款"){
                        	  cmess.push(rowDatas[i].paymentid);
                           }
                      }
                      if(cmess.length>0){
            	         jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>编号为"+cmess+"的计划不为未收款不能操作</div>",'error'); 
                         return false;
                       }else{
                          return true;  
                  }
               }
          }else{return true;}
       }
    jQuery(function(){
    	 var currentIsNeedTools = true;
 	    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
 	    	currentIsNeedTools = false;
 	    }
	    var talbe= new tracywindyMultiTable({
	    renderTo:'id_table_leasing_contract_fund_charge_container',
	    width:formWidth,
	    height:350,
	    tools:'新增|修改|删除',
	    isNeedTools:currentIsNeedTools,
	    isFit:true,
	    isForceModify:false,
	    operValidate:function(opertype,rowDatas){
                return changeoperarot(opertype,rowDatas);
		},
		validateForm:function($me,currentTable){
		    var rowData = currentTable.getCheckedRowDatas()[0];
		    var data = currentTable.tableData;
			var paymentId = $("#id_paymentidP").val();
	    	/* if(paymentId.length != 17){
				alert("付款编号不完整,请确认!");
				return false;
	        } */
			if(rowData != null){
				if (paymentId == rowData.paymentid) {
				
				} else {
					for(var i=0;i<data.length;i++){
						if(data[i]['paymentid'] == paymentId){
							alert("付款编号已存在,请重新输入!");
							return false;
						}
					}
				}
			}else{
				for(var i=0;i<data.length;i++){
					if(data[i]['paymentid'] == paymentId){
						alert("付款编号已存在,请重新输入!");
						return false;
					}
				}
			}
	 		if(!Validator.Validate(jQuery("#"+$me.windowId+" form")[0],1,false)){return false;};
	 		//if(!checkMoney()){return false;} 
	 		return true;
	 	},
	    datas:JsonUtil.decode('${empty json_fundchargeplanpay_str ? "[]" : json_fundchargeplanpay_str }'),
	    columns:[
	           {name:'id',  header:'id',hidden:true},
	  	       {name:'paymentid',  header:'付款编号',nullable:false,readOnly:false,defaultValue:"o-${requestScope['fundPlanPaymentId']}-",otherAttributes:'id="id_paymentidP"'},
	  	       {name:'payobj',  header:'付款对象',defaultValue:'德银融资租赁有限公司',readOnly:true},
	  	       {name:'rawValue_feetype',  header:'费用类型',nullable:false,type:'combobox',hiddenName:'feetype', config:{
			       width:165,
			       xmlFileName:'\\combos\\comboDict.xml',
			       loadMode:'ajax',
			       readOnly:true,
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
	  	       {name:'receivermoney',  header:'已付金额',type:'double',readOnly:true,defaultValue:'0.00'},
	  	       {name:'rawValue_planmoneystatus', header:'付款状态',defaultValue:'未付款',readOnly:true},
	  	       {name:'planmoneystatus', header:'付款状态ID',hidden:true},
	  	       {name:'paytype',header:'收付方向',defaultValue:'pay_type_out',hidden:true},
	  	       {name:'fpnote', header:'备注',type:'textarea'}
	     ]
	 });
   });

   </script>