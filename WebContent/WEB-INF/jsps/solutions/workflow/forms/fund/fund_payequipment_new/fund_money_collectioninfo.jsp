<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <script language="javascript">
    var dealer_id='${empty dealerid ? "" : dealerid }';
    var dealer_name='${empty dealername ? "" : dealername }';
    
    jQuery(function(){
        if(isSubTable){
        var dealer=  new tracywindyComboBox({
        	    id:'id_combo_dealer_cust',
        	    width:300,
        	    renderTo:'id_dealer_cust_name_container',
        	    xmlFileName:'\\eleasing\\workflow\\public\\comboDistributorCustSelect.xml',
        	    loadMode:'ajax',
        	    readOnly:false,
        	    isAjaxLenovo:true,
        	    isContainEmpty:true,
        	    dropListHeight:300,
        	    topAdd:0,
        	    leftAdd:0,
        	    positionDropIconLeftAdd:-1,
        	    name:'dealer_name',
        	    displayField:'name',
        	    valueField:'value',
        	    value:dealer_id,
        	    rawValue:dealer_name,
        	    readOnlyData:(dealer_id.length>0?true:false),
        	    params:{
        			
        	    },
        	    onSelect:function(r, v) {
        	    	cust.setParam("dealer_number",this.getValue());
        	    	cust.reload();
        	    }
        	 });
        var cust=  new tracywindyComboBox({
      	    id:'id_combo_cust',
      	    width:300,
      	    renderTo:'id_cust_name_container',
      	    xmlFileName:'\\eleasing\\workflow\\public\\fundfundSelectCust.xml',
      	    loadMode:'ajax',
      	    readOnly:false,
      	    isAjaxLenovo:true,
      	    isContainEmpty:true,
      	    dropListHeight:300,
      	    topAdd:0,
      	    leftAdd:0,
      	    positionDropIconLeftAdd:-1,
      	    name:'cust_name',
      	    displayField:'cust_name',
  	        valueField:'cust_number',
      	    params:{
        	  dealer_number:dealer_id
      	    },
      	    onSelect:function(r, v) {
      	    	contract.setParam("cust_number",this.getValue());
      	    	contract.reload();
      	        }
      	 });
       var contract=   new tracywindyComboBox({
        	    id:'id_combo_contract',
        	    width:300,
        	    renderTo:'id_contract_id_container',
        	    xmlFileName:'\\eleasing\\workflow\\public\\fundfundSelectContract.xml',
        	    loadMode:'ajax',
        	    readOnly:false,
        	    isAjaxLenovo:true,
        	    isContainEmpty:true,
        	    dropListHeight:300,
        	    topAdd:0,
        	    leftAdd:0,
        	    positionDropIconLeftAdd:-1,
        	    name:'contract_number',
        	    displayField:'contract_number',
        	    valueField:'id',
        	    params:{
        	       cust_number:'null'
        	    },
        	    onSelect:function(combo){
            	   
        	        }
        	 });
          }
        });
    function autoVerification(){
       var cust_id=getTracywindyObject('id_combo_cust').getValue();
       var dealer_id=getTracywindyObject('id_combo_dealer_cust').getValue();
       var contract_id=getTracywindyObject('id_combo_contract').getValue();
       var planstart_date=$("#id_plan_date_start").val();
       var planend_date=$("#id_plan_date_end").val();
       //alert(cust_id+":"+dealer_id+":"+contract_id+":"+planstart_date+":"+planend_date);
       var currentTabled =getTracywindyObject('table_id_table_fund_fund_plan_container');
       var parames={};
       parames["fee_type"]="feetype10";
       parames["cust_number"]=cust_id;
       parames["dealer_number"]=dealer_id;
       parames["contract_id"]=contract_id;
       parames["plan_date_start"]=planstart_date;
       parames["plan_date_end"]=planend_date;
       parames["hasmoney"]="0.00";
	   
     /*
      * 13.房款条件增加为起租流程完成之后，为1、起租流程完成之后；2、全部资金收款完成；3、保险确认完成；4、GPS已安装
      * status=1:起租流程完成之后,status=2:全部资金收款完成,status=3:保险确认完成,status=4:GPS已安装
	  * status=-1:起租未完成，status=-2：全部资金收款未完成，status=-3：保险确认未完成，status=-4：GPS没有安装
	  *	status=-5：系统获取合同id错误
      */
	   ajaxRequest({
		     url:"${pageContext.request.contextPath}/leasing/projectPutStartFlowCheck.acl",
		     params:{contract_id:contract_id},
		     timeout:30*1000,
		     async:true,//改为同步请求
		     success:function(res){
		 		res=res.responseText;
		 		res=res.replace(/(^\s+)|(\s+$)/g, ""); 
		 		if(res=="-1"){
		 			alert("起租未完成不能发起【项目投放流程】");
		 		}else if(res=="-2"){
					alert("全部资金收款未完成不能发起【项目投放流程】");
				}else if(res=="-3"){
					alert("保险确认未完成不能发起【项目投放流程】");
				}else if(res=="-4"){
					alert("设备投放之前必须安装GPS");
				}else if(res=="-5")
					alert("请选择合同！");
				else{
		 			 currentTabled.setParams(parames);
			 	       currentTabled.reload();
			 	       jQuery("#fund_fund_plan_select").show();
			 		   jQuery("#fund_fund_plan_select").window({
			 				   top:10
			 		   	  });
			 		   jQuery("#fund_fund_plan_select").window("open");
		 		}
		     },
		     failure:function(res){
		    	res=res.responseText;
		 		res=res.replace(/(^\s+)|(\s+$)/g, "");
		 		alert(res);
		  	 }
		});
       
	   
    }
    </script>
<div>
	<style type="text/css">
.tabs-panels {
	border: 0px solid #ddd;
}
</style>
 <table cellspacing="0" cellpadding="0" style="width: 100%" >
       <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-condition"></div>设备款明细查询</td>
          </tr>
       <tr class="tr-project-condition tr-odd">
			<td class="td-content-title">经销商：</td>
			<td class="td-content"><div class="leftComboContainer" id="id_dealer_cust_name_container"></div><font class="required-content">*</font></td>
			<td class="td-content-title"></td>
			<td class="td-content"></td>			
		</tr>
        <tr class="tr-project-condition tr-odd">
			<td class="td-content-title">客户名称：</td>
			<td class="td-content"><div class="leftComboContainer" id="id_cust_name_container"></div><font class="required-content">*</font></td>
			<td class="td-content-title">合同号：</td>
			<td class="td-content"><div class="leftComboContainer" id="id_contract_id_container"></div><font class="required-content">*</font></td>			
		</tr>
        <tr class="tr-project-condition tr-even">
		   	<td class="td-content-title">开始日期：</td>
			<td class="td-content"><input id="id_plan_date_start" name="plan_date_start" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['plan_date_start'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly label="开始日期" /><font class="required-content">*</font></td>
		 	<td class="td-content-title">结束日期：</td>
			<td class="td-content"><input id="id_plan_date_end" name="plan_date_end" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['plan_date_end'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly label="结束日期" /><font class="required-content">*</font></td>
		 </tr>  
		 <tr class="tr-project-condition tr-odd">
			<td class="td-content-title" colspan=3></td>
			<td><input style="margin-top: 2px; margin-bottom: 2px;" id="btn_rent_cal" class="btn btn-primary" type="button" value="查询" onclick="autoVerification();" /></td>
		</tr>     	
 </table>
</div>