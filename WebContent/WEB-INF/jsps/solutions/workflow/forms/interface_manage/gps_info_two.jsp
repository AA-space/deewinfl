
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
   
<div>
	<style type="text/css">
.tabs-panels {
	border: 0px solid #ddd;
}
</style>
 <table cellspacing="0" cellpadding="0" style="width: 98%; margin-top: 20px;" id="fund_ebank_data" >
       <tr>
             <td class="x-panel-table-div-title" colspan=4><div class="toggle-icon-expanded" title="折叠" toggleClass="tr-project-condition"></div>GPS信息明细</td>
          </tr>
          <tr class="tr-project-info tr-even">
             <td class="td-content-title">经销商：</td><td class="td-content"><input name="contract_info.dealername" id ="id_dealer"  class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['contract_info.dealername']}"></td>
             <td class="td-content-title">是否安装GPS</td><td class="td-content"><div class="leftComboContainer" id="is_gps"></div><font class="required-content">*</font></td>
         </tr>
         <tr class="tr-project-info tr-even">
             <td class="td-content-title">客户名称：</td><td class="td-content"><input name="contract_info.custname" id ="id_custname"  class="td-content-input td-content-readonly" readOnly type="text" value="${requestScope['contract_info.custname']}"></td>
             <td class="td-content-title">合同号：</td><td class="td-content"><input id="id_contract_id_container" name="contract_info.projdate" class="td-content-input td-content-readonly"  type="text" value="${requestScope['contract_info.contractnumber']}" /></td>
         </tr>
       
 </table>
</div>

<script language="javascript">
jQuery(function(){
    //dictYesOrNoByCode('id_is_gps','proj_info.is_gps','','',true,' require="true" label="是否第三方代付"');
	 new tracywindyComboBox({
		 id:'id_combo_is_gps',
			width:167,
			renderTo:'is_gps',
			loadMode:'local',
			//xmlFileName:'/eleasing/jsp/other/insurance_manage/list1.xml',
		    datas:[{title:'是',name:'0'},{title:'否',name:'1'}],
		    readOnly:true,
		    //dropListHeight:70,
		    topAdd:0,
	        leftAdd:0,
	        otherAttributes:'require="true" label="是否安装GPS"',
			value:'',
			name:'',
			displayField:'title',
			valueField:'name',
			onSelect:function(r,v){
				//alert(this.getValue());
				//alert(r);
			    var currentTable1 = getTracywindyObject('table_id_table_leasing_proj_equip_container');
				var tabledata11=currentTable1.getRowsData();
				for(var i=0;i<tabledata11.length;i++){
					tabledata11[i].isgps=this.getValue();
					/* //alert(tabledata11[i].chassis_num);
					//alert(tabledata11[i].isgpsname);
					//alert(tabledata11[i].isgps);
					if(this.getValue()==0){
						if(tabledata11[i].isgps==''){
							tabledata11[i].isgps=this.getValue();
						}
					}else{
						//  this.reload();
						//  alert("没有安装GPG，请退回或者选择“是”");
						//  return false;
					} */
				}
				//alert("已安装gps信息");
			},
			leftAdd:0
			
		});

	
});
    

</script>
