<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<script type="text/javascript">
	function checkOnePlanList(rentplan){
      //corpusov,interestov,penaltyov,corpus,interest,penalty,interestadjust,penaltyadjust
	  var cmessage=new Array();
	  var cmessagt=new Array();
	  if(parseFloat(rentplan.corpusov)<0){cmessage.push("本金");}
	  if(parseFloat(rentplan.interestov)<0){cmessage.push("租息");}
	  //if(parseFloat(rentplan.penaltyov)<0){cmessage.push("罚息");}
	  if(cmessage.length>0){cmessage.push("大于计划");}
	  if(parseFloat(rentplan.corpus)<0){cmessagt.push("本金");}
	  if(parseFloat(rentplan.interest)<0){cmessagt.push("租息");}
	 // if(parseFloat(rentplan.penalty)<0){cmessagt.push("罚息");}
	  if(parseFloat(rentplan.interestadjust)<0){cmessagt.push("租息调整");}
	 // if(parseFloat(rentplan.penaltyadjust)<0){cmessagt.push("罚息调整");}
	  if(cmessagt.length>0){cmessagt.push("红冲大于实收");}
	  return  cmessage+cmessagt+"";   
    }
	function doCheckRentCharge(fundData,tabledata){
		var fund=eval("("+fundData+")");
		var ebankMoney=0.00;
		var ebankId="";
		var fundList=new Array();
		ebankMoney=fund.ebank[0].mayopemoney;
		ebankId=fund.ebank[0].ebankid;
		fundList=fund.fund;
		var messageovpaln=new Array();
		var messageovebank=new Array();
		var messageovreback=new Array();
		//检查核销的收款计划大于网银/计划可核销的金额
		for(var i=0;i<tabledata.length;i++){
	       for(var j=0;j<fundList.length;j++){
	          if(fundList[j].rentlist==tabledata[i].planlist){//查找相同的付款编号
                  if(tabledata[i].rent<0||tabledata[i].penalty<0){
                      if(ebankId==tabledata[i].ebanknumber){
                    	  ebankMoney=parseFloat(ebankMoney)+parseFloat(tabledata[i].rent)+parseFloat(tabledata[i].penalty);
                    	  fundList[j].corpusov=parseFloat(fundList[j].corpusov)-parseFloat(tabledata[i].corpus);
                    	  fundList[j].interestov=parseFloat(fundList[j].interestov)-parseFloat(tabledata[i].interest)-parseFloat(tabledata[i].interestadjust);
                    	  fundList[j].penaltyov=parseFloat(fundList[j].penaltyov)-parseFloat(tabledata[i].penalty)-parseFloat(tabledata[i].penaltyadjust);
                      }
                      fundList[j].corpus=parseFloat(fundList[j].corpus)+parseFloat(tabledata[i].corpus);
                	  fundList[j].interest=parseFloat(fundList[j].interest)+parseFloat(tabledata[i].interest)+parseFloat(tabledata[i].interestadjust);
                	  fundList[j].penalty=parseFloat(fundList[j].penalty)+parseFloat(tabledata[i].penalty)+parseFloat(tabledata[i].penaltyadjust);
                	  fundList[j].interestadjust=parseFloat(fundList[j].interestadjust)+parseFloat(tabledata[i].penaltyadjust);
                	  fundList[j].penaltyadjust=parseFloat(fundList[j].penaltyadjust)+parseFloat(tabledata[i].penaltyadjust);
                    }
                  else{
                	  ebankMoney=parseFloat(ebankMoney)-parseFloat(tabledata[i].corpus)-parseFloat(tabledata[i].interest)-parseFloat(tabledata[i].penalty)
                	  fundList[j].corpusov=parseFloat(fundList[j].corpusov)-parseFloat(tabledata[i].corpus);
                	  fundList[j].interestov=parseFloat(fundList[j].interestov)-parseFloat(tabledata[i].interest)-parseFloat(tabledata[i].interestadjust);
                	  fundList[j].penaltyov=parseFloat(fundList[j].penaltyov)-parseFloat(tabledata[i].penalty)-parseFloat(tabledata[i].penaltyadjust);
                      if(parseFloat(ebankMoney)<0){
                    	  jQuery.messager.alert('错误提示',"<div style='font-size:15px;line-height:30px;width:200px;'>第"+fundList[j].rentlist+"期的金额大于网银可核销的金额！</div>",'error');
                          return false;
                      }
                   }
                  var cmessage="";
                  cmessage= checkOnePlanList(fundList[j]);
                  if(cmessage!=""){
                      jQuery.messager.alert('错误提示',"<div style='font-size:15px;line-height:30px;width:200px;'>第"+fundList[j].rentlist+"期的"+cmessage+"！</div>",'error');
                      return false;
                     }
                 
	             }

		      }
		}
		return true;
		
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
		 var currentTable1 = getTracywindyObject('table_id_current_fund_income_detial_container');
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
		 var method="getRentCheckData";
		 param.contractid=contractid;
		 param.ebankid=ebankid;
		 param.rentlist=rentlist;
		 //网银中间表
		 param.ebankProcess = $('#id_fund_ebank_process').val();
		 ajaxRequest({
			     url:'${pageContext.request.contextPath}/leasing/rent/'+method+'.action',
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
	    //var interestadjust=$("#re_interestadjust").val()||0;
	    //var penaltyadjust=$("#re_penaltyadjust").val()||0;
	    var temp=parseFloat(corpus)+parseFloat(interest)+parseFloat(penalty)+parseFloat(interestad)+parseFloat(penaltyad)
            //temp=temp+parseFloat(interestadjust)+parseFloat(penaltyadjust);
        $("#re_receivermoney").val(temp.toFixed(2));
        temp=parseFloat(corpus)+parseFloat(interest)+parseFloat(interestad);
        $("#re_rent").val(temp.toFixed(2));
		}
	jQuery(function(){
     var currentIsNeedTools = true;
	 if(('true'!='${isFirstTask}')||('true' == '${isViewHistoryTask}')){
		currentIsNeedTools = false;
	 }
	var table_fund_rent_inComes = new tracywindyMultiTable({
	    renderTo:'id_current_fund_income_detial_container',
	    width:formWidth,
	    height:350,
	    isNeedTools:currentIsNeedTools,
	    isFit:false,
	    tools:'修改|删除',
	    addOperCallBack:function(opertype,rowDatas){
		showdisplayplandate(opertype,rowDatas);
         return true;
        },
        updateOperCallBack:function($me,currentTable){
         return false;
        },
	    datas:JsonUtil.decode('${empty current_fund_income_detial ? "[]" : current_fund_income_detial }'),
	    isRank:true,
	    rankSize:10,
	    columns:[
	       {name:'id',  header:'id',hidden:true},
	       {name:'pid',  header:'pid',hidden:true},
           {name:'rollback',  header:'rollback',hidden:true},
	       {name:'planid',header:'租金计划',hidden:true},
	       {name:'planlist',  header:'计划期项',readOnly:true},
	       {name:'ebanknumber',  header:'网银编号',readOnly:true},
	       {name:'hirelist',  header:'回笼期项',readOnly:true},
	       {name:'balancemode',  header:'balancemode',hidden:true},
	       {name:'rawValue_balancemode',  header:'结算方式',nullable:true,type:'combobox',hiddenName:'balancemode',
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
	       {name:'hiredate',  header:'回笼日期',type:'date'},
	       {name:'rent',  header:'回笼租金' , nullable:false,type:'double',readOnly:true, otherAttributes:'id="re_rent"'},
	       {name:'corpus',  header:'回笼本金' , nullable:false,type:'double',readOnly:true, otherAttributes:'id="re_corpus" onkeyup="comptuerCurMoney()"'},
	       {name:'interest',  header:'回笼租息', nullable:false,type:'double',readOnly:true, otherAttributes:'id="re_interest" onkeyup="comptuerCurMoney()"'},
	       {name:'penalty',  header:'回笼罚息' , nullable:false,type:'double',readOnly:true, otherAttributes:'id="re_penalty" onkeyup="comptuerCurMoney()"'},
	       {name:'interestadjust',  header:'租息调整', nullable:false,type:'double',readOnly:true, otherAttributes:'id="re_interestadjust" onkeyup="comptuerCurMoney()"'},
	       {name:'penaltyadjust',  header:'罚息调整', nullable:false,type:'double', readOnly:false,otherAttributes:'id="re_penaltyadjust" onkeyup="comptuerCurMoney()"'},
	       {name:'receivermoney',  header:'回笼合计', nullable:false,type:'double',readOnly:true, otherAttributes:'id="re_receivermoney"'},
	       {name:'invoiceno',  header:'单据号'},
	       {name:'oper',  header:'操作类型',hidden:true, nullable:false,defaultValue:'add'},
	       {name:'accountingdate',  header:'会计处理日', nullable:false,type:'date'},
	       {name:'ownbank',  header:'本方银行', nullable:true,readOnly:false},
	       {name:'ownaccount',  header:'本方银行账户', nullable:true,readOnly:false},
	       {name:'hireobject',  header:'付款人', nullable:true,readOnly:false},
	       {name:'hirebank',  header:'付款人银行', nullable:true,readOnly:false},
	       {name:'hirenumber',  header:'付款人帐号', nullable:true,readOnly:false}
	       ]
	      
	 });
});

	 //验证核销不能跳期核，只能按期次向下
    function doCheckRentListContinue(tableid1,tableid2)
    {
		var plantable = getTracywindyObject(tableid1); //租金计划数据
		var plandate=util.clone(plantable.getRowsData());
		var incomeTable= getTracywindyObject(tableid2); //本次租金回笼明细数据
		var incometable=util.clone(incomeTable.getRowsData());
		var temp=0;
        for(var i=0;i<plandate.length;i++){
             for( var j=0;j<incometable.length;j++){
                 if(plandate[i].rentlist==incometable[j].planlist){
                     temp=0;
                     temp=parseFloat(plandate[i].currentoverage)-parseFloat(incometable[j].rent);
                     temp=temp.toFixed(2);
                     plandate[i].currentoverage=temp;
                 }   
             } 
        }
        for(var i=0;i<plandate.length-1;i++){
            var j=i+1;
            if(plandate[i].currentoverage>0&&plandate[j].currentoverage!=plandate[j].rent){
            	 jQuery.messager.alert('错误提示',"<div style='font-size:15px;line-height:30px;width:200px;'>不能跳过第"+(i+1)+"期进行隔期核销，请确认！</div>",'error');
                 return false;
            }  
        }
		return true;
    }
	</script>