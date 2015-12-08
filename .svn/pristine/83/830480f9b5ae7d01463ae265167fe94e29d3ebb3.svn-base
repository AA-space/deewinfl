<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!--承租人变更 -->
  <script language="javascript">
  jQuery(function(){
	  if(isSubTable){
			isSubTable_business = false;
	  		combo_cust = new tracywindyComboBox({
		    lazyLoad:true,
		    id:'id_combo_cust_new',
		    width:300,
		    renderTo:'id_cust_name_new',
		    xmlFileName:'\\eleasing\\workflow\\public\\comboCustSelect.xml',
		    loadMode:'ajax',
		    readOnly:false,
		    isAjaxLenovo:true,
		    dropListHeight:300,
		    topAdd:0,
		    leftAdd:0,
		    value:'${requestScope["new_cust_info"]}',
		    positionDropIconLeftAdd:-1,
		    name:'new_cust_info',
		    displayField:'name',
		    valueField:'value',
		    params:{
		    }
		 });
	  }	
  });
</script>
<table class="fillTable" cellspacing="0" cellpadding="0" width="50%" height="50px">
	<tr class="tr-contractect-info tr-even">
             <td class="td-content-title"  style="width:200px;">原承租人：</td><td class="td-content"  style="width:400px;"><input class="td-content-input td-content-readonly" readonly="readonly" type="text" value="${requestScope['contract_info.custname']}"></td>
             <td class="td-content-title" style="width:100px;">现承租人:</td><td class="td-content" style="width:200px;"><div id="id_cust_name_new" style="float:left;"></div></td><td><span class="content-required">*</span></td>
         </tr>
</table>
