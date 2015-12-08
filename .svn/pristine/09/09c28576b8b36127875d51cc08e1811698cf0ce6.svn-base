<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <script language="javascript">
  	var dealer_id='${empty dealerid ? "" : dealerid }';
  	var dealer_name='${empty dealername ? "" : dealername }';
 	var pageWidth  = document.documentElement.clientWidth-2;
	var pageHeight = document.documentElement.clientHeight-2;
    jQuery(function(){
    		//经销商
    	   var dealer=  new tracywindyComboBox({
       	    id:'id_combo_dealer',
       	    width:162,
       	    renderTo:'id_dealer',
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
       	    	user_id :'${sessionScope.loginUser.id}'
       	    },
       	    onSelect:function(r, v) {
           	    custname.setParam("cust_dealer_id",this.getValue());
           	    custname.reload();
       	    }
       	 });
          //客户名称
    	   var custname=  new tracywindyComboBox({
          	    id:'id_custname',
          	    width:162,
          	    renderTo:'id_custname',
          	    xmlFileName:'\\eleasing\\workflow\\public\\limitCustSelect.xml',
          	    loadMode:'ajax',
          	    readOnly:false,
          	    isAjaxLenovo:true,
          	    isContainEmpty:true,
          	    dropListHeight:300,
          	    topAdd:0,
          	    leftAdd:0,
          	    positionDropIconLeftAdd:-1,
          	    name:'cust_name',
          	    displayField:'name',
          	    valueField:'id',
          	 	//readOnlyData:(dealer_id.length>0?true:false),
          	 	params:{
          	 		dealer_id:dealer_id,
          	 		cust_type: 'cust_type.cust',
           	    	cust_class1:'CUST_INFO_COMPANY',
           	    	cust_class2:'CUST_INFO_COMPANY'
           	    },
          	    onSelect:function(r, v) {
          	    	contract.setParam("cust_number",this.getValue());
          	    	contract.reload();
          	    }
          	 });
    		
    	//合同号
    	   var contract=   new tracywindyComboBox({
       	    id:'id_combo_contract',
       	    width:162,
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
       	 params :{
       	    	cust_number : ' '
       	    },
       	    onSelect:function(combo){
       	    	//currentTable1.tableData=[];
       	    }
       	 });
    	
    	
    /*     if(isSubTable){
		 ///dict('tablename1','tablename64','root_null_ini','${requestScope["proj_info.projsource"]}',null,'require="true" label="经销商"');
		 dictOnSelect('tablename2','tablename65','root_null_ini','${requestScope["proj_info.leasform"]}',null,'require="true" label="合同号"');
        } */
        });
    
    function detialCollection(){
		//var table_fund_plan = getTracywindyObject('table_fund_plan');
		
		var table_fund_plan = getTracywindyObject("table_id_table_leasing_contract_fund_payment_now_container");

		//部门
		 var contract_id =getTracywindyObject('id_combo_contract').getValue();
		 var startData = '';
		 var endData = '';
		
		 if($('#startdate').val()){
			 startData = $('#startdate').val();
			 startData = calculateDate('4',-1, startData,'yyyy-MM-dd');
		 }
		 if($('#enddate').val()){
			 endData =$('#enddate').val();
			 endData = calculateDate('4', 1, endData,'yyyy-MM-dd');
		 }
		 if(!contract_id){
			 jQuery.messager.alert('提示',"<div style='font-size:18px;line-height:30px;'>请选择合同</div>",'success'); 
			 return;
		 }
		 table_fund_plan.params.contract_id = contract_id;
		 table_fund_plan.params.plan_date_start = startData;
		 table_fund_plan.params.plan_date_end = endData;
		 
		 /* table_fund_plan.setParam('contract_id', contract_id);
		 table_fund_plan.setParam('plan_date_start', startData);
	 	 table_fund_plan.setParam('plan_date_end', endData); */
		
		table_fund_plan.reload();
		
		jQuery("#id_table_leasing_contract_fund_payment_now_container").show();
		jQuery("#id_table_leasing_contract_fund_payment_now_container").window({
			   top:15,
			   title:'资金明细'
		});
		jQuery("#id_table_leasing_contract_fund_payment_now_container").window("open");
    }
    
    </script>
<div>
	<style type="text/css">
.tabs-panels {
	border: 0px solid #ddd;
}
</style>
 <table cellspacing="0" cellpadding="0" style="width: 98%; margin-top: 20px;" id="fund_ebank_data" >
       <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-condition"></div>未付设备款明细</td>
          </tr>
       <tr class="tr-project-condition tr-odd">
			<td class="td-content-title">经销商：</td>
			<td class="td-content"><div class="leftComboContainer" id="id_dealer"></div><font class="required-content">*</font></td>
			<td class="td-content-title"></td>
			<td class="td-content"></td>	
			</tr>
		<tr class="tr-project-condition tr-even">
			<td class="td-content-title">客户名称：</td>
			<td class="td-content"><div class="leftComboContainer" id="id_custname"></div><font class="required-content">*</font></td>
			<td class="td-content-title">合同号：</td>
			<td class="td-content"><div class="leftComboContainer" id="id_contract_id_container"></div><font class="required-content">*</font></td>			
		</tr>
      
       <tr class="tr-project-condition tr-odd">
		   	<td class="td-content-title">开始日期：</td>
			<td class="td-content"><input name="tablename66" id ="startdate" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['proj_info.projdate'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="开始日期" /><font class="required-content">*</font></td>
		 	<td class="td-content-title">结束日期：</td>
			<td class="td-content"><input name="tablename67" id="enddate" class="Wdate td-content-input td-content-readonly"  
             type="text" value="${requestScope['proj_info.projdate'] }"  onClick="WdatePicker(this,{readOnly:true})" readOnly require="true" label="结束日期" /><font class="required-content">*</font></td>
		 </tr>  
		 <tr class="tr-project-condition tr-odd">
			<td class="td-content-title" colspan=3></td>
			<td><input style="margin-top: 2px; margin-bottom: 2px;" id="btn_rent_cal" class="btn btn-primary" type="button" value="查询设备款明细" onclick="detialCollection();" /></td>
		</tr>     	
 </table>
</div>

<script>


/* 	if (isSubTable) {
		//var user_id = '${sessionScope["userDeptListSqlStr"]}';
		var user_id = '${sessionScope.loginUser.id}';
		var queryStr = "select ID_,NAME_ from t_depts where id_ = '"+ user_id + "' OR '"+ user_id + "' NOT IN (SELECT UD.USER_ID_  FROM DEALER_DEPT_INFO DD LEFT JOIN T_USERS_DEPTS UD   ON (DD.DEALER_DEPT = UD.DEPT_ID_)  WHERE UD.ID_ IS NOT NULL)";
		console.info(queryStr)*/
/* 		commonSelect(
				'id_dealer',
				"("+ queryStr +")",
				'id_',
				'name_',
				'dealer.dept',
				'${empty requestScope["proj_info.projdept"] ? sessionScope["loginUserDeptObj"].id : requestScope["dealer.dept"] }',
				null, ' require="true" label="出单部门"'); 
	} */
</script>