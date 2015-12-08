
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!-- 插入样式和JS -->
<jsp:include page="../proj_approval/base.jsp"/>
<jsp:include page="../../util/flow_condition_select.jsp"/>
<!-- 特殊附件显示公用方法 -->
<jsp:include page="../../util/proj_view_file.jsp"></jsp:include>
<!-- 项目立项附件带到租前业务相关流程 -->
<jsp:include page="initFileListParams.jsp"></jsp:include>
<!-- 项目信审申请 -->
<script type="text/javascript">
	//是否保存   
	//只读回调
	function workflowSaveCallBack()//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		fillHiddenVal();
		return true;
	}
	//只读反转
	function formPageReadOnlyCallBack(){
	       if(!isCompletedTask){
	          formJSPInputHideOrShow("proj_credit_result_info","proj_other_info.assetslevel,proj_other_info.cashlevel",1);
	          formJSPInputHideOrShow("proj_credit_other_info","proj_other_info.specialindustries",1);
	          var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');
	   		  var tabledata=currentTable1.getRowsData();
	   		  var test='';
	   		  for(i=1;i<=tabledata.length;i++)
	   		    formJSPInputHideOrShow("proj_credit_result_info"+i,"",1);
		      }
	}

	//是否提交    
	function workflowSubmitCallBack(buttonText)//返回true提交，返回false不提交 ，该回调函数可与用表单字段验证
	{
		if(!saveInvoiceType()){return false;};
		fillHiddenVal();
		if(!checkRadio()){alert("客户信用评分表每行必填");return false;}
		var submitProcessedForm = document.getElementById("id_submitProcessedForm");
		var isPassed = Validator.Validate(submitProcessedForm,1,false);
		if(!isPassed){return isPassed;}
		if(buttonText=="Submit"){
	    	var equipNum1=0;//拖车数量
	    	var equipNum2=0;//挂车数量
	    	var equipJson=getTracywindyObject('table_id_table_leasing_proj_equip_container').getRowsJsonData();
	    	for(var i=0;i<equipJson.length;i++){
	        	var equip=equipJson[i];
	        	if(equip["equipclass"]=="equip_class_2"){
	        		equipNum2++;
	        	}else{
	        		equipNum1++;
	        	}
	    	}   
	    	//var condtion="[{condtion:'正常审批',rote:'10台以下资料审核'},{condtion:'直接审批',rote:'10台以下资料齐全'}]";
	    	var condtion="[{condtion:'直接审批',rote:'10台以下资料齐全'}]";
			if(parseInt(equipNum1) <= 10){
				/*if(!isSelectRote){
		        	selectRoteByCondtion(condtion);
		        	return false;
		         }else{
		        	 return isPassed;
		         }*/
				selectRote="04信审部经理审核";
				return  isPassed;
			}else{
				selectRote="02信用分析师2";
				return  isPassed;
			}
	    }
		isSelectRote=false;
	}
	
	var isSelectRote=false; 
	var selectRote=""; 

	function workflowNextRouteCallBack(buttonText,requestNextRoute){
        if(buttonText=="Submit"){
       		requestNextRoute.value=selectRote;
       		isSelectRote=false;
        }
   }


</script>
<!--多行控件  -->
<input type="hidden" id="id_json_proj_equip_str" name="json_proj_equip_str" value='${empty json_proj_equip_str ? "[]" : json_proj_equip_str }'></input>
<input type="hidden" id="id_json_proj_guarantee_method_str" 	name="json_proj_guarantee_method_str" value='${empty json_proj_guarantee_method_str ? "[]" : json_proj_guarantee_method_str }'></input>
<input type="hidden" id="id_json_proj_guarantee_equip_str" name="json_proj_guarantee_equip_str" value='${empty json_proj_guarantee_equip_str ? "[]" : json_proj_guarantee_equip_str }'></input>
<input type="hidden" id="id_json_word_list_str" name="json_word_list_str" value='${empty json_word_list_str ? "[]" : json_word_list_str }'></input>

<div class="fillTableContainer">
   <table class="fillTable" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan=4><!-- 插入项目基本信息 --> <jsp:include
			page="../proj_approval/proj_base_info_forcredit.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td colspan=4><!-- 插入项目其它基本信息 --> <jsp:include
			page="proj_base_other_info.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td colspan=4><!-- 插入项目信审其它基本信息 --> <jsp:include
			page="proj_credit_other_info.jsp"></jsp:include></td>
	</tr>
	
    <tr>
       <td colspan=4>
       <script type="text/javascript">
					    jQuery(function() {
						    isViewHistoryTask = false;
						    });
		            </script>
		            <c:if test="${requestScope['proj_info.cust_type']=='法人'}">
                      <jsp:include page="proj_credit_reportxls.jsp"></jsp:include>
                    </c:if>
       
           <script type="text/javascript">
					    jQuery(function() {
						    isViewHistoryTask = true;
						    });
		            </script>
       </td>
    </tr>	
	<tr>
		<td colspan=4><!-- 插入项目评审结果 -->
		<script language="javascript">
               jQuery(function() {isViewHistoryTask = isCompletedTask;});
             </script> 
		 <jsp:include  page="proj_credit_result_info.jsp"></jsp:include>
		     <script language="javascript">
			    jQuery(function() {
				    isViewHistoryTask = true;
				    });
            </script>
        </td>
	</tr>
	
	<tr>
	<td colspan=4 class="td-even-line-separator">&nbsp;</td>
	</tr>
	<tr class="x-panel-table-div-title">
		<td class="x-panel-table-div-title" colspan=4>
		<div class="toggle-icon-expanded" title="折叠"
			toggleClass="tr-project-business-condition"></div>
		项目商务条件</td>
	</tr>
	<tr>
		<td colspan=4></td>
	</tr>
	<tr class="tr-project-business-condition">
		<td colspan=4 class="td-tabs-container" style="text-indent: 0px;">
		<!-- 标签栏 -->
		<div id='id_project_info_tabs_content' style="">
		<div title="租赁物明细">
		<div id="id_table_leasing_proj_equip_container"
			style="overflow: hidden;"></div>
		</div>
		<div title="拟商务条件">
		<div id="id_table_leasing_proj_condition_container"
			style="overflow: hidden;">
			<jsp:include page="../../rent_reckon/rent_reckon/main.jsp"></jsp:include></div>
		</div>
		<div title="担保单位信息">
		<div id="id_table_leasing_proj_guarantee_method_container"
			style="overflow: hidden;"></div>
		</div>
		<div title="租金发票类型">
		<!-- <script type="text/javascript">jQuery(function() {isViewHistoryTask = true;}); </script> -->
		<div id="id_table_leasing_proj_rent_type_container" style="height: 350px;"><jsp:include page="../proj_approval/proj_invoice.jsp"></jsp:include></div>
		<!-- <script type="text/javascript">jQuery(function() {isViewHistoryTask = true;}); </script> -->
		</div>
		<div title="客户信用评分表">
			<div id="id_table_leasing_proj_cust_creidt_container" style="overflow: hidden;">
			<script type="text/javascript">
					    jQuery(function() {
						    isViewHistoryTask = false;
						    });
		            </script>
			<jsp:include page="proj_cust_credit_list.jsp"></jsp:include>
			</div>
		</div>
	</div>
		</td>
	</tr>
</table>
</div>
<!--避免在tabs中的js重复执行-->
<jsp:include page="../proj_approval/proj_equip_detail.jsp"></jsp:include>
<jsp:include page="../proj_approval/proj_guarantee_method.jsp"></jsp:include>
<jsp:include page="proj_cust_credit.jsp"></jsp:include>
<script> 
function createTemFile(){
	var currentTablelist = getTracywindyObject('table_projcreditreport');
	var tabledata11=currentTablelist.getRowsData();
	for(var i=0;i<tabledata11.length;i++){
			if(tabledata11[i].filename=='法人客户现场考察报告（德银).doc')
				{
				  alert(tabledata11[i].filename+"已经生成");
				  return false;
				}
	}
    var d=new Date();
    //alert(d.getFullYear());
	var currentTable2 = getTracywindyObject('table_id_table_leasing_proj_equip_container');
   // alert(currentTable2.getRowsData().length);
	
    var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');
   
	//alert(JsonUtil.encode(currentTable1.getRowsJsonData()));
			var tabledata=currentTable1.getRowsData();
			var assurorname="('";
			for(var i=0;i<tabledata.length;i++){
				assurorname+=tabledata[i].assurorname;
				 if(i<tabledata.length-1)
		 		  {
		 			assurorname+="','";
		 		   }
		 		}
		 		assurorname+="')";
			//alert(assurorname);
    
   var url="/leasing/template/createFileByTemplateClass.action";
   var filename='table_projcreditreport';
   attachmentDown({uploadid:filename,url:url,title:"",flowunid:flowUnid,twoClassify:'wordtempletypetwo.',returnType:'listtocurpaget',modelname:'creditreport',assurorname:assurorname,projectid:jQuery("#project_id").val(),"framework_condition.equipnum":currentTable2.getRowsData().length,"framework_condition.date":d.getFullYear()});
 }

    function createTemFileCredit()
    {
    	var currentTablelist = getTracywindyObject('table_projcreditreport');
    	var tabledata11=currentTablelist.getRowsData();
    	for(var i=0;i<tabledata11.length;i++){
    			if(tabledata11[i].filename=='法人客户信审报告（10台以上）.xls')
    				{
    				  alert(tabledata11[i].filename+"已经生成");
    				  return false;
    				}
    	}
        //平均租金
        var currentTable2 = getTracywindyObject('table_id_table_leasing_rent_plan_container');
 		var tabledata2=currentTable2.getRowsData();
 		var sumMoney=null;
 		for(var j=0;j<tabledata2.length;j++)
 		{
           sumMoney=sumMoney+parseFloat(tabledata2[j].rent);
 	 	}
 	 	sumMoney=sumMoney/parseInt(tabledata2.length);
 	 	//alert(sumMoney);
 	 	
        //担保人
    	var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');
 		var tabledata=currentTable1.getRowsData();
 		var assurorname="('";
 		for(var i=0;i<tabledata.length;i++){
 		assurorname+=tabledata[i].assurorname;
 		 if(i<tabledata.length-1)
		  {
			assurorname+="','";
		   }
		}
		assurorname+="')";
 		var test=getTracywindyObject("id_combo_creatordept").getRawValue();
 		//alert(test+"2222");
 		
 		//alert("按"+jQuery("#firstPaymentRatio").val()+"%首付"+jQuery("#cautionMoney").val()+"%保证金，"+jQuery("#yearRate").val()+"%年利率，"+jQuery("#leaseTerm").val()+"个月租赁期，融资额为"+jQuery("#leaseMoney").val()+"元，每月还款租金  "+sumMoney);
 	 	var data="按"+jQuery("#firstPaymentRatio").val()+"%首付，"+jQuery("#cautionMoneyRatio").val()+"%保证金，"+jQuery("#yearRate").val()+"%年利率，"+jQuery("#leaseTerm").val()+"个月租赁期，融资额为"+jQuery("#leaseMoney").val()+"元，每月还款租金  "+sumMoney+"元";
    	var url="/leasing/template/createFileByTemplateClass.action";
    	var filename='table_projcreditreport';
        attachmentDown({uploadid:filename,url:url,title:"",flowunid:flowUnid,twoClassify:'wordtempletypetwo.34',returnType:'listtocurpaget',modelname:'creditreport',assurorname:assurorname,lesseesname:jQuery("#cust_name").val(),projectid:jQuery("#project_id").val(),"framework_condition.money":sumMoney,"condition.array":data,dealername:test});
    }

    function createTemFileCredit6()
    {
    	var currentTablelist = getTracywindyObject('table_projcreditreport');
    	var tabledata11=currentTablelist.getRowsData();
    	for(var i=0;i<tabledata11.length;i++){
    			if(tabledata11[i].filename=='法人客户信审报告（6-10台).xls')
    				{
    				  alert(tabledata11[i].filename+"已经生成");
    				  return false;
    				}
    	}
        //alert(jQuery("#cust_name").val());
        //平均租金
        var currentTable2 = getTracywindyObject('table_id_table_leasing_rent_plan_container');
 		var tabledata2=currentTable2.getRowsData();
 		var sumMoney=null;
 		for(var j=0;j<tabledata2.length;j++)
 		{
           sumMoney=sumMoney+parseFloat(tabledata2[j].rent);
 	 	}
 	 	sumMoney=sumMoney/parseInt(tabledata2.length);
 	 	//alert(sumMoney);
 	 	//alert("按"+jQuery("#firstPaymentRatio").val()+"%首付"+jQuery("#cautionMoney").val()+"%保证金，"+jQuery("#yearRate").val()+"%年利率，"+jQuery("#leaseTerm").val()+"个月租赁期，融资额为"+jQuery("#leaseMoney").val()+"元，每月还款租金  "+sumMoney);
 	 	        
 	 	var data="按"+jQuery("#firstPaymentRatio").val()+"%首付，"+jQuery("#cautionMoneyRatio").val()+"%保证金，"+jQuery("#yearRate").val()+"%年利率，"+jQuery("#leaseTerm").val()+"个月租赁期，融资额为"+jQuery("#leaseMoney").val()+"元，每月还款租金  "+sumMoney+"元";
        //担保人
    	var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');
 		var tabledata=currentTable1.getRowsData();
 		var assurorname="('";
 		for(var i=0;i<tabledata.length;i++){
 		assurorname+=tabledata[i].assurorname;
 		  if(i<tabledata.length-1)
 		  {
 			assurorname+="','";
 		   }
 		}
 		assurorname+="')";
 		//alert(assurorname);
 		var test=getTracywindyObject("id_combo_creatordept").getRawValue();
 		var filename='table_projcreditreport';
    	var url="/leasing/template/createFileByTemplateClass.action";
        attachmentDown({uploadid:filename,url:url,title:"",flowunid:flowUnid,twoClassify:'wordtempletypetwo.33',returnType:'listtocurpaget',modelname:'creditreport',assurorname:assurorname,lesseesname:jQuery("#cust_name").val(),projectid:jQuery("#project_id").val(),"framework_condition.money":sumMoney,"condition.array":data,dealername:test});
    }
    
	//隐藏域在提交或保存前的赋值
	function fillHiddenVal() {
		if("${requestScope['proj_info.cust_type']}"=='法人')
		{
			var currentTable3 = getTracywindyObject('table_projcreditreport');
			jQuery('#id_json_word_list_str').val(
				JsonUtil.encode(currentTable3.getRowsJsonData()));
		}
		//租赁物件
		var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');
		jQuery('#id_json_proj_equip_str').val(
				JsonUtil.encode(currentTable1.getRowsJsonData()));
		//担保单位信息
		var currentTable4 = getTracywindyObject('table_id_table_leasing_proj_guarantee_method_container');
		jQuery('#id_json_proj_guarantee_method_str').val(
				JsonUtil.encode(currentTable4.getRowsJsonData()));
		saveReckonJsonValue();//保存租金测算结果
		saveDocReport();//保存客户信用评分表
	}
	//页面初始化
	var isSubTable=true;
	//全局变量说是这一个只读业页
	isViewHistoryTask = true;
	//法人附件上传权限
	var isAttachment=false;
	//信审报告
	var tooldata=[{
	  	 html : '<font color="blue">生成法人客户现场考察报告 </font>',
			handler : function(table) {
					createTemFile();
					//return false;
			},
			iconCls : 'icon-update'
	}];
	//初始化调用
	jQuery(function() {
		//########公共JS事件##########
		jQuery(".toggle-icon-expanded").click(toggleLeasingOperation);
		$("#id_project_info_tabs_content").css("width", (formWidth) + "px");
		$("#id_project_info_tabs_content").tabs();
		isSubTable = false;
		var d = $("#id_project_info_tabs_content");
		$("#id_project_fund_rent_plan_tabs_content").css("width",
				(formWidth) + "px");
		$("#id_project_fund_rent_plan_tabs_content").tabs();
		//jQuery(".fillTableContainer").css("width",formWidth+"px");
		
		////承租人评审结果，带出融资额
		jQuery('#id_leasingmoney').val("${requestScope['framework_condition.leasemoney']}");
		//承租人评审结果，将第一个月的月租金赋值给月租金
	    var currentTableRent = getTracywindyObject('table_id_table_leasing_rent_plan_container');
	 	var tabledataRent=currentTableRent.getRowsData();
	 	var sumMoney=parseFloat(tabledataRent[0].rent);
	 	jQuery('#id_monthrent').val(sumMoney);
	    
	});
</script>
