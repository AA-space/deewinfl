﻿
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 插入样式和JS -->
<jsp:include page="../../project/proj_approval/base.jsp"></jsp:include>
<script type="text/javascript">
	//是否保存   
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		return true;
	}
	//保存成功提交后，后台返回
	function saveCallBack() {
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		//alert(Validator);
		return true;
	}
	
	
	//是否提交    
	function workflowSubmitCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		//必填
		//var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		//var isPassed = Validator.Validate(submitProcessedForm,1,false);
		//if(!isPassed){return isPassed;}
		//判断
	    if(!checkTracywindyTableData("table_id_table_leasing_deposit_in_container","保证金信息")){return false;}//检查租赁物明细
		if(!checkTracywindyTableData("table_id_table_leasing_rent_up_detail_container","本次租金回笼明细")){return false;}//担保信息
		//if(!validataTotalMoney()){return false;}
		
		//########################提交时验证可用保证金<本次填写回笼租金########################
		//1.本次租金回笼明细对象
		 var currentTable = getTracywindyObject('table_id_table_leasing_rent_up_detail_container');
		//2.得到租金回笼计划表数据
		 var tabledata = currentTable.getRowsData();
		//3.剩余保证金
		 var deductible = document.getElementById("projcondition_info.deductible").value;
		 //计算多行里面的 所有还款金额
		 var totleRentMoney = 0.00;
		 for(var i=0;i<tabledata.length;i++){
			 totleRentMoney = parseFloat(totleRentMoney) + (parseFloat(tabledata[i].interest)+parseFloat(tabledata[i].corpus)+parseFloat(tabledata[i].penalty));
		 }
		 //如果本次还款金额 大于 可用保证金的金额 提示操作者
		 if(totleRentMoney>deductible){
			 jQuery.messager.alert('错误提示',"<div style='font-size:12px;line-height:30px;'>本次回笼租金不能大于保证金</div>",'error');
			 return false;
		 }
		//############提交时验证可用保证金<本次填写回笼租金########################
		return true;
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
  /* *
  * 自动核销 保证金抵扣租金
  *	
  */
	function autoHX(){
         var ebanktemp="${requestScope['ebankid']}";
		//1.租金回笼计划对象
		 var currentTable1 = getTracywindyObject('table_id_table_leasing_rent_up_plan_container'); 
		 //2.本次租金回笼明细对象
		 var currentTable2 = getTracywindyObject('table_id_table_leasing_rent_up_detail_container');
		 //3.得到租金回笼计划表数据
		 var tabledata = currentTable1.getRowsData();
		//3.1得到租金回笼明细数据
		 var tabledata2 = currentTable2.getRowsData();
		 if(tabledata2.length>0)
		 {
			 alert("期末保证金抵扣租金已经生成回笼租金明细！");
			 return false;
		 }
		 
		 //4.1得到可抵扣保证金的值
		 var deduction_caution = document.getElementById("projcondition_info.deductible").value;
		 //4.2剩余保证金
		 var surpluscaution = document.getElementById("projcondition_info.surpluscaution").value;
		 //5.1可抵扣保证金解析为小数类型
		var dc = parseFloat(deduction_caution);
		//5.2 转化float
		var ss = parseFloat(surpluscaution);
		//ss = 10000;
		//6.如果金额小于0就提示
		 if(dc<=ss){
			 if(dc<=0){
				 jQuery.messager.alert('错误提示',"<div style='font-size:12px;line-height:30px;'>可抵扣保证金为零，无法抵扣</div>",'error'); 
			//7.大于0核销
			}else{
				//8.页面加载IE遮罩等待
				var loadMask_oper = new tracywindyLoadMask(document.body,'操作进行中，请稍等...');
				//9.如果有数据
				//for(var i=tabledata.length-1;i>=0;i--){ //倒序
				for (var i = 0; i < tabledata.length; i++){ //顺序
					//debugger;
					//10.显示页面
					loadMask_oper.show();
					//debugger;
					//alert(tabledata[i].penalty);
					//alert(tabledata[i].interest);
					//定义数组
					var caution_money ={};
					//罚息余额
					var penalty = parseFloat(tabledata[i].penaltyoverage);
					//利息余额
					var interest = parseFloat(tabledata[i].curinterestoverage);
					//本金余额
					var corpus = parseFloat(tabledata[i].curcorpusoverage);

					var rent = parseFloat(tabledata[i].currentoverage);
					//本次租金回笼选项卡里面 增加行
					//复制ID
					caution_money.planid=tabledata[i].planid;
					caution_money.contractid="${requestScope['contract_info.id'] }";
					//复制期次
					caution_money.planlist = tabledata[i].rentlist;

					//回笼期项
					caution_money.hirelist = tabledata[i].rentlist;
					//结算方式
					caution_money.balancemode = "PayFund7";
					caution_money.rawValue_balancemode="保证金抵扣";
					//回笼日期
					//caution_money.hiredate = getCurDate();//取当天操作日期
					caution_money.hiredate = tabledata[i].plandate;//取当期计划日期
					
					//租金余额
					//caution_money.rent = decimal(tabledata[i].currentoverage,2);
					//if(parseFloat(tabledata[i].currentoverage)==0||tabledata[i].currentoverage==null){
						caution_money.rent = "0.00";
					//}
					//
					
					//网银编号
					caution_money.ebanknumber =ebanktemp;
					//回笼本金
					//if(parseFloat(tabledata[i].corpusoverage)==0||tabledata[i].corpusoverage==null){
					//	caution_money.corpus = "0.00";
					//}
					//回笼本金
					caution_money.corpus = "0.00";
					//租息调整
					caution_money.interestadjust = "0.00";
					//罚息调整
					caution_money.penaltyadjust = "0.00";
					//回笼租罚息
					caution_money.penalty="0.00";
					//回笼租息
					caution_money.interest="0.00";
					//单据号
					caution_money.invoiceno = "-";
		
					
					//保证金-罚息
						
						//var _a = dc;
						//dc = dc - penalty;
						//var _a = decimal(dc + penalty , 2);
						
						//alert(dc);
					//复制应收罚款=应收罚款
					//caution_money.penalty = dc>=0?penalty:decimal(_a , 2); 
					//caution_money.penalty=penalty;
					//保证金-罚息>=0就往 本次租金回笼里面加列
						/*if(dc<0){
							caution_money.rent = caution_money.penalty;
							currentTable2.AddRow(caution_money);
							break;
						}
						
						//保证金
						var _b = dc;
					 	dc = dc - interest;
					 	//alert(2);
					 	//alert(dc);
						//复制计划租息
						caution_money.interest=	dc>=0?interest:decimal(_b , 2);
					 	if(dc<0){
					 		caution_money.rent = caution_money.interest+caution_money.penalty;
					 		currentTable2.AddRow(caution_money);
						 	break;
						}*/
						//var _c = dc;
						//dc = dc - corpus;
						//alert(dc);
						//复制计划本金
						//caution_money.corpus = dc>0?corpus:decimal(_c , 2);
						//if(dc<0){
						//	caution_money.rent = caution_money.interest+caution_money.penalty+caution_money.corpus;
						//	currentTable2.AddRow(caution_money);
						//	break;
						//}
						/*
						
						caution_money.rent=parseFloat(parseFloat(caution_money.interest)+parseFloat(caution_money.corpus)).toFixed(2);
						var test=parseFloat(parseFloat(caution_money.penalty)+parseFloat(caution_money.rent)).toFixed(2);
                        if(parseFloat(test)>0)
                        {
 						   currentTable2.AddRow(caution_money);
                        }   
                    */

                    //抵扣倒序：罚息、利息、本金
                    if(decimal(corpus,2)!=0) //剩余本金大于0
					{
						if(dc-corpus>=0){
						 	   caution_money.corpus=decimal(corpus,2);
						 	   dc=dc-corpus;
							}else{
							   caution_money.corpus=decimal(dc,2);
							   dc = 0;
							   if(dc-interest  <=0){	//不足以抵扣利息的情况	   
							   		caution_money.rent  = parseFloat(parseFloat(caution_money.corpus)+parseFloat(caution_money.interest)).toFixed(2);
							   }
							   currentTable2.AddRow(caution_money);
							   break; 
							}
					}
				 	if(decimal(interest,2)!=0)
					{
						if(dc-interest>=0){
						 	   caution_money.interest=decimal(interest,2);
						 	   dc=dc-interest;
							}else{
							   caution_money.interest=decimal(dc,2);
							   if (parseFloat(interest - caution_money.interest).toFixed(2) ==0) //利息都抵扣完的情况
								{
								   caution_money.rent  = parseFloat(parseFloat(caution_money.corpus)+parseFloat(caution_money.interest)).toFixed(2);
								 }
							        currentTable2.AddRow(caution_money);
							   break; 
							}
					}
				 	/*
					if(decimal(rent,2)!=0)
					{
						if(dc - rent >= 0) 
						{
							caution_money.rent = decimal(rent,2);
						 	//dc = dc - rent;//抵扣的保证金不需减租金是由于后面会减利息和本金
						}else
						{
							caution_money.rent = decimal(dc,2); //可抵扣的保证金小于租金
							//currentTable2.AddRow(caution_money);
							//break; 
						}
					}
				 	
                    if(decimal(penalty,2)>0)
					{
						if(dc-penalty>=0){
					 	   caution_money.penalty=decimal(penalty,2);
					 	   dc=dc-penalty;
						}else{
						   caution_money.penalty=decimal(dc,2);
						   dc = 0;
						   currentTable2.AddRow(caution_money);
						   break; 
						}
					}
                    */
					if(caution_money.rent !=0  ||  caution_money.interest !=0 ){
				 	     caution_money.rent  = parseFloat(parseFloat(caution_money.corpus)+parseFloat(caution_money.interest)).toFixed(2);
						currentTable2.AddRow(caution_money);
					}
				}
			}
		}else {
			jQuery.messager.alert('错误提示',"<div style='font-size:12px;line-height:30px;'>【可抵扣保证金】必须小于或等于【剩余保证金】</div>",'error');
		}
		 //var iddata=getTableColumnData(tabledata,"id");
		 
					
		 loadMask_oper.hide();
		 jQuery.messager.alert('提示',"<div style='font-size:12px;line-height:30px;'>核销完成</div>",'info'); 
//清空资源
		 dc = 0;
	}

</script>


<!--多行控件  -->
<input type="hidden" id="id_json_deposit_in_str" name="json_deposit_in_str" value='${empty json_deposit_in_str ? "[]" : json_deposit_in_str }'/> <!--保证金计划收付清单-->
<input type="hidden" id="id_json_deposit_out_str" name="json_deposit_out_str"  value='${empty json_deposit_out_str ? "[]" : json_deposit_out_str }'/> <!-- 保证金实际收付明细  -->
<input type="hidden" id="id_json_deposit_rent_up_plan_str" name="json_rent_up_plan_str"  value='${empty json_rent_up_plan_str ? "[]" : json_rent_up_plan_str }'/> <!-- 租金回笼计划 -->
<input type="hidden" id="id_json_deposit_rent_up_actually_str" name="json_rent_up_actually_str"  value='${empty json_rent_up_actually_str ? "[]" : json_rent_up_actually_str }'/> <!-- 租金回笼实际 -->
<input type="hidden" id="id_json_deposit_rent_up_detail_str" name="json_rent_up_detail_str"  value='${empty json_rent_up_detail_str ? "[]" : json_rent_up_detail_str }'/> <!-- 本次租金回笼明细 -->

<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr  id="contract_base_info">
		<td colspan=4>
		<!-- 插入合同基本信息 --> 
		<script type='text/javascript'>
		jQuery(function(){
			     isViewHistoryTask = true;
			});
		
		</script>
			<jsp:include page="../../contract/contract_approval/contract_base_info.jsp"></jsp:include>
		<script type='text/javascript'>
			jQuery(function(){
			     isViewHistoryTask = false;
			     //document.getElementById("projcondition_info.deductible").setAttribute("readonly", "");
			});
			/*只读反转
			function formPageReadOnlyCallBack(){
				alert();
			       if(!isCompletedTask){
			          formJSPInputHideOrShow("id_contract_condition_cash_deposit_content","projcondition_info.deductible",1);
			         //formJSPInputHideOrShow("proj_credit_other_info","proj_other_info.specialindustries",1);
				         
			       }
			}*/
			
		</script>
			</td>
	</tr>
	
	<tr>
	<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>

		<tr class="tr-contract-business-condition">
		<td  class="td-tabs-container" style="text-indent: 0px;">
			<div id='id_contract_condition_tabs_content' style="">
		<div title="保证金信息">
		<span class="print-tabs-title-content">保证金信息</span>
		<div id="" style="overflow: hidden;"><jsp:include page="deposit_info.jsp"></jsp:include></div>
		
		</div>
		<div title="保证金计划收付清单">
		<span class="print-tabs-title-content">保证金计划收付清单</span>
		<div id="id_table_leasing_deposit_in_container" style="overflow: hidden;"></div>
		</div>
			
		<div title="保证金实际收付明细">
		<span class="print-tabs-title-content">保证金实际收付明细</span>
		<div id="id_table_leasing_deposit_out_container"
							style="overflow: hidden;">
		</div>
		</div>
		
		
		<div title="租金回笼计划">
		<span class="print-tabs-title-content">租金回笼计划</span>
		<div id="id_table_leasing_rent_up_plan_container"
			style="overflow: hidden;">
		</div>
		</div>	
		
		<div title="租金回笼实际">
		<span class="print-tabs-title-content">租金回笼实际</span>
		<div id="id_table_leasing_rent_up_actually_container"
			style="overflow: hidden;">
		</div>
		</div>
			
		<div title="本次租金回笼明细">
		<span class="print-tabs-title-content">本次租金回笼明细</span>
		<div id="id_table_leasing_rent_up_detail_container"
			style="overflow: hidden;">
		</div>
		</div>
		
		
		</div>
		</td>
	</tr>
</table>
</div>

<!--避免在tabs中的js重复执行-->
<jsp:include page="deposit_in.jsp"></jsp:include> <!-- 保证金计划收付清单 -->
<jsp:include page="deposit_out.jsp"></jsp:include> <!-- 保证金实际收付明细 -->
<jsp:include page="rent_up_plan.jsp"></jsp:include> <!-- 租金回笼计划 -->
<jsp:include page="rent_up_actually.jsp"></jsp:include> <!-- 租金回笼实际 -->
<jsp:include page="rent_up_detail.jsp"></jsp:include> <!-- 本次租金回笼明细 -->
<script>

//隐藏域在提交或保存前的赋值
function fillHiddenVal() {
	var currentTable1 = getTracywindyObject('table_id_table_leasing_deposit_in_container');
	jQuery('#id_json_deposit_in_str').val(
			JsonUtil.encode(currentTable1.getRowsJsonData()));

	var currentTable2 = getTracywindyObject('table_id_table_leasing_deposit_out_container');
	jQuery('#id_json_deposit_out_str').val(
			JsonUtil.encode(currentTable2.getRowsJsonData()));

	//var currentTable3 = getTracywindyObject('table_id_table_leasing_deposit_refund_container');
	//jQuery('#id_json_deposit_refund_str').val(
			//JsonUtil.encode(currentTable3.getRowsJsonData()));

	//var currentTable4 = getTracywindyObject('table_id_table_leasing_deposit_refund_detail_container');
	//jQuery('#id_json_deposit_refund_detail_str').val(
	//JsonUtil.encode(currentTable4.getRowsJsonData()));
	
	var currentTable5 = getTracywindyObject('table_id_table_leasing_rent_up_plan_container');
	jQuery('#id_json_deposit_rent_up_plan_str').val(
			JsonUtil.encode(currentTable5.getRowsJsonData()));
	
	var currentTable6 = getTracywindyObject('table_id_table_leasing_rent_up_actually_container');
	jQuery('#id_json_deposit_rent_up_actually_str').val(
			JsonUtil.encode(currentTable6.getRowsJsonData()));

	var currentTable7 = getTracywindyObject('table_id_table_leasing_rent_up_detail_container');
	jQuery('#id_json_deposit_rent_up_detail_str').val(
			JsonUtil.encode(currentTable7.getRowsJsonData()));
}

var isSubTable = true;

jQuery(function() {
	//########公共JS事件##########
	jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
	$("#id_contract_condition_tabs_content").css("width", (formWidth) + "px");
	$("#id_contract_condition_tabs_content").tabs();
	isSubTable = false;
	var d = $("#id_contract_condition_tabs_content");
	//第二个页签集合
	//$("#id_project_info_tabs_content").css("width",(formWidth) + "px");
	//$("#id_project_info_tabs_content").tabs();
	//jQuery(".fillTableContainer").css("width",formWidth+"px");
	
});


</script>
