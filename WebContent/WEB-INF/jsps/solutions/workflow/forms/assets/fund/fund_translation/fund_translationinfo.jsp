<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function checkOnePlanList(rentplan){
	      //corpusov,interestov,penaltyov,corpus,interest,penalty,interestadjust,penaltyadjust
		  var cmessage=new Array();
		  var cmessagt=new Array();
		  if(parseFloat(rentplan.corpusov)<0){cmessage.push("本金");}
		  if(parseFloat(rentplan.interestov)<0){cmessage.push("租息");}
		  if(parseFloat(rentplan.penaltyov)<0){cmessage.push("罚息");}
		  if(cmessage.length>0){cmessage.push("大于计划");}
		  if(parseFloat(rentplan.corpus)<0){cmessagt.push("本金");}
		  if(parseFloat(rentplan.interest)<0){cmessagt.push("租息");}
		 // if(parseFloat(rentplan.penalty)<0){cmessagt.push("罚息");}
		  if(parseFloat(rentplan.interestadjust)<0){cmessagt.push("租息调整");}
		  if(parseFloat(rentplan.penaltyadjust)<0){cmessagt.push("罚息调整");}
		  if(cmessagt.length>0){cmessagt.push("红冲大于实收");}
		  return  cmessage+cmessagt+"";   
	    }
		
		/*
		 * 根据网银余额校验当前收的保证金是不是大于网银余额
		 */
		function doCheckRentCharge(sfund,tabledata){
			var tmoney=parseFloat(sfund);
			var stmoney=tmoney;
			var ebankid=jQuery("#ebdataid").val();
			var all_cur_money=0.00;
			///console.info(123);
			for(var i=0;i<tabledata.length;i++){
		       if(tabledata[i].ebanknumber==ebankid){
		           //if(tabledata[i].settlemethod!="红冲"){
		             tmoney=parseFloat(tmoney)-parseFloat(tabledata[i].receivermoney);
		             tmoney=parseFloat(tmoney.toFixed(2));
		             all_cur_money=all_cur_money+parseFloat(tabledata[i].receivermoney);
		             all_cur_money=parseFloat(all_cur_money.toFixed(2));
		           //}
		       }
		    }
		    if(tmoney<0){
		    	 //jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>本次收取的金额【"+all_cur_money+"】大于网银余额【"+stmoney+"】\n不能执行下一步.请调整.</div>",'error');
		        //return false;
		        return true;
		    }else{
		        return true;
		    }
		}
		
		function checkRentCharge(){
		     //获得这个合同的收款计划情况和相对网银
		      var loadMask_oper = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');
			 loadMask_oper.show();
			 var isSubmit = false;
			 //var contractid=jQuery("#contractid").val();
			  var contractid=jQuery('input[name="contract_info.contractid"]').val();
			 var ebankid=jQuery("#ebdataid").val();
			 var param={};
			 var currentTable1 = getTracywindyObject('table_id_table_leasing_delivery_plan');
			 var tabledata=currentTable1.getRowsData();
			 if(tabledata.length==0){
				 loadMask_oper.hide();
				 jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>请选择核销的计划！</div>",'error');
		     return false;}
		     var rentlist="";
		     for(var i=0;i<tabledata.length;i++){
			     if(rentlist!=""){
	               rentlist=rentlist+",";
			     }
			     rentlist=rentlist+tabledata[i].planlist;
		     }   
			 //var method="getRentCheckData";
			 var method="getCanHireMoeny";
			 param.contractid=contractid;
			 param.ebankid=ebankid;
			 param.rentlist=rentlist;
			 //网银中间表
			 param.ebankProcess = $('#id_fund_ebank_process').val();
			 ajaxRequest({
				     //url:'${pageContext.request.contextPath}/leasing/rent/'+method+'.action',
				     url:'${pageContext.request.contextPath}/leasing/fund/'+method+'.action',
				     method:'POST',
				     success:function(res){
			   		    var sfund=res.responseText;
			   		    sfund=sfund.replace(/(^\s+)|(\s+$)/g, ""); 
			   		    loadMask_oper.hide();
			   		    if(sfund==""){
		  	   		    jQuery.messager.alert('错误提示',"<div style='font-size:18px;line-height:30px;'>没有租金计划！</div>",'error');
		  	   		        isSubmit = false;
			   		    }else{
			   		        isSubmit = doCheckRentCharge(sfund,tabledata);
			   	   		}
				     },
				     async:false,
				     failure:function(res){},
				     params:param
			 });
			 loadMask_oper.hide();
			 return isSubmit;
			}
		</script>   
		<script> 
		function   showdisplayplandate(opertype,rowDatas){
			var rentPlan=getTracywindyObject('multiTable_id_current_fund_income_detial_container');
		    for(var i=0;i<rowDatas.length;i++){
	        if(rowDatas[i].oper=="old"){
	        	rentPlan.setReadOnly(true,"hiredate");
	        }else{
	        	rentPlan.setReadOnly(false,"hiredate");
	            }
	          }
			}
		function comptuerCurMoney(){
			var corpus=$("#re_corpus").val()||0;
			var interest=$("#re_interest").val()||0;
			var penalty=$("#re_penalty").val()||0;
			var interestad=$("#re_interestadjust").val()||0;
		    var penaltyad=$("#re_penaltyadjust").val()||0;
		    var interestadjust=$("#re_interestadjust").val()||0;
		    var penaltyadjust=$("#re_penaltyadjust").val()||0;
		    if ( penalty < 0)
	    	{
		    	alert("回笼罚息不能小于0");
	    		$("#re_penalty").val(-(penalty));
	    	}
		    var temp=parseFloat(corpus)+parseFloat(interest)+parseFloat(penalty)+parseFloat(interestad)+parseFloat(penaltyad)
	            temp=temp+parseFloat(interestadjust)+parseFloat(penaltyadjust);
	        $("#re_receivermoney").val(temp.toFixed(2));
	        temp=parseFloat(corpus)+parseFloat(interest)+parseFloat(interestad);
	        $("#re_rent").val(temp.toFixed(2));
			}
		function splitRent(){
			var ovcorpus=parseFloat($("#ov_corpus").val())||0;
			var ovinterest=parseFloat($("#ov_interest").val())||0;
			var ovrent=parseFloat($("#ov_rent").val())||0;
			var rerent=parseFloat($("#re_rent").val())||0;
			var penalty=parseFloat($("#re_penalty").val())||0;
		    if(rerent>ovrent){
		    	alert("回笼租金不能大于剩余租金！！");
		    	$("#re_rent").val(ovrent);
		    	$("#re_corpus").val(ovcorpus);
	    		$("#re_interest").val(ovinterest);
	    		$("#re_receivermoney").val((ovrent+penalty).toFixed(2));//合计
		    	return false;
		    }else{
		    	//如果本次租金小于剩余本金，怎么全部回笼本金
		    	if(rerent<=ovcorpus){
		    		$("#re_corpus").val(rerent.toFixed(2));
		    		$("#re_interest").val(0);
		    	}else{
		    		$("#re_corpus").val(ovcorpus.toFixed(2));
		    		$("#re_interest").val((rerent-ovcorpus).toFixed(2));
		    	}
		    	$("#re_receivermoney").val((rerent+penalty).toFixed(2));//合计
		    }
		}
		function onCheckPenalty(){
			var penalty = $("#re_penalty").val(); 
			if ( penalty < 0)
			{
				alert("回笼罚息小于0");
				return false;	
			} 
		}
</script>  
</script>    
<script>
jQuery(function(){
    var currentIsNeedTools = true;
    
    if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
    	currentIsNeedTools = false;
    }
	new tracywindyMultiTable({
	    renderTo:'id_table_leasing_delivery_plan',
	    width:formWidth,
	    height:350,
	    isFit:true,
	    isNeedTools:currentIsNeedTools,
	    tools:'修改|删除',
	  /*   otherTools : [ {
			html : '<font color="red">生成本次回笼租金明细</font>',
			handler : function(table) {
				var fundPlan = table.getCheckedRowDatas();
				if (0 == fundPlan.length) {
					alert("请选择需要回笼租金!");
					return false;
				}
				setFundFundChargePlan(talbe)
			},
			iconCls : 'icon-update'
		} ], */
	    datas:JsonUtil.decode('${empty json_id_fund_rent_income ? "[]" : json_id_fund_rent_income }'),
	    columns:[
			       {name:'id',  header:'id',hidden:true},
			       {name:'pid',  header:'pid',hidden:true},
			       {name:'contract_id',  header:'contract_id',hidden:true},
		           {name:'rollback',  header:'rollback',hidden:true},
			       {name:'ebanknumber',  header:'ebanknumber', hidden:true},
			       {name:'planid',header:'租金计划',hidden:true},
				   {name:'dealer_id',  header:'dealer_id',hidden:true},
			       {name:'dealer_cust_name',header:'经销商名称',hidden:false},
				   {name:'cust_id',  header:'cust_id',hidden:true},
			       {name:'cust_name',header:'客户名称',hidden:false},
			       {name:'contract_number',header:'合同号',hidden:false},
				   {name:'plan_date',header:'计划日期',hidden:false},
			       {name:'planlist',  header:'计划期项',readOnly:false},
			       {name:'hirelist',  header:'回笼期项',readOnly:false},
			       {name:'balancemode',  header:'balancemode',hidden:true},
			       {name:'hiredate',  header:'回笼日期',type:'date',readOnly :false},
			       {name:'ov_rent',  header:'剩余租金',readOnly:true,otherAttributes:'id="ov_rent"'},
			       {name:'ov_corpus',  header:'剩余本金',readOnly:true,otherAttributes:'id="ov_corpus"'},
			       {name:'ov_interest',  header:'剩余利息',readOnly:true,otherAttributes:'id="ov_interest"'},
			       {name:'rent',  header:'回笼租金' , nullable:false,type:'double',readOnly:false, otherAttributes:'id="re_rent" onkeyup="splitRent()"'},
			       {name:'corpus',  header:'回笼本金' , nullable:false,type:'double', readOnly:true,otherAttributes:'id="re_corpus" onkeyup="comptuerCurMoney()"'},
			       {name:'interest',  header:'回笼租息', nullable:false,type:'double',readOnly:true, otherAttributes:'id="re_interest" onkeyup="comptuerCurMoney()"'},
			       {name:'penalty',  header:'回笼罚息' , nullable:false,type:'double', otherAttributes:'id="re_penalty" onkeyup="comptuerCurMoney()" '},
			       {name:'interestadjust',  header:'租息调整',readOnly :true, nullable:false,type:'double', otherAttributes:'id="re_interestadjust" onkeyup="comptuerCurMoney()"'},
			       {name:'penaltyadjust',  header:'罚息调整', readOnly :true,nullable:false,type:'double', otherAttributes:'id="re_penaltyadjust" onkeyup="comptuerCurMoney()"'},
			       {name:'receivermoney',  header:'回笼合计', nullable:false,type:'double',readOnly:true, otherAttributes:'id="re_receivermoney"'},
			       {name:'invoiceno',  header:'单据号'},
			       {name:'oper',  header:'操作类型',hidden:true, nullable:false,defaultValue:'add'},
			       //{name:'accountingdate',  header:'会计处理日', nullable:false,type:'date'},
			       {name:'ownbank',  header:'本方银行', readOnly:false},
			       {name:'accnumber',  header:'本方账号', readOnly:false},
			       {name:'ownaccount',  header:'本方银行账户',readOnly:false},
			       {name:'hireobject',  header:'付款人', readOnly:false},
			       {name:'hirebank',  header:'付款人银行', readOnly:false},
			       {name:'hirenumber',  header:'付款人帐号', readOnly:false}
	       	     ]
	 });
	 
});

</script>
