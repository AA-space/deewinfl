<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!--合同租金发票类型 -->
  <script language="javascript">
    jQuery(function(){
        if(isSubTable){
   	    dict('id_rent_invoice_type','contract_invoice_type.rentinvoicetype','rent_invoice_type',
		'${requestScope["contract_invoice_type.rentinvoicetype"]}','${requestScope["rawValue_contract_invoice_type.name"]}','require="false" label="租金发票类型"',300);
        //特殊下拉 
        dictYesOrNoByCode('id_IsInvoiceRentSplit','contract_invoice_type.isinvoicerentsplit','${empty requestScope["contract_invoice_type.isinvoicerentsplit"] ?"0": requestScope["contract_invoice_type.isinvoicerentsplit"]}',null,null,'require="true" label="租金发票本利金是否拆分"');
        dictYesOrNoByCode('id_BoolInvoice','contract_invoice_type.boolinvoice','${empty requestScope["contract_invoice_type.boolinvoice"] ? "0":requestScope["contract_invoice_type.boolinvoice"]}',null,null,'require="true" label="发票为放款先决条件"');
        
        }
        
     
    });
    
    function saveInvoiceType(){
    	 //自动判断租金发票类型
		//租金发票类型
		var invoice_type_obj = getTracywindyObject('id_combo_rent_invoice_type');
		var havaInvoiceType = invoice_type_obj.getValue()||invoice_type_obj.value;
		if(!havaInvoiceType){
			//租赁形式 直租 回租
			var leas_form = getTracywindyObject('id_combo_leas_form').getValue();
			//客户模式 "法人" "自然人
			var cust_type = document.getElementById('proj_info.cust_type').value;
			//是否上牌
			var is_registration = getTracywindyObject('id_combo_id_is_registration').getValue();
			if (leas_form == 'lease_form1') {//直租
				if (is_registration === 0 || is_registration === '0') {//上牌
					invoice_type_obj.setValue('invoice_type02');
					invoice_type_obj.reload();
				} else if (is_registration === 1 || is_registration === '1') {//不上牌
					invoice_type_obj.setValue('invoice_type04');
					invoice_type_obj.reload();
				} else{
					alert("上牌模式不对，不能自动选择租金发票类型，请手动选择");
					return false;
				}
			} else if (leas_form == 'lease_form2') {//回租
				if (cust_type == '法人') {
					invoice_type_obj.setValue('invoice_type06');
					invoice_type_obj.reload();
				} else if (cust_type == '自然人') {
					invoice_type_obj.setValue('rent_invoice_type07');
					invoice_type_obj.reload();
				} else {
					alert("客户类别不对，不能自动选择租金发票类型，请手动选择");
					return false;
				}
			} else {
				alert("租赁形式不对，不能自动选择租金发票类型，请手动选择");
				return false;
			}
		}
		return true;
    }
    
    
    </script>
<table class="fillTable" cellspacing="0" cellpadding="0" width="50%">
	<tr class="tr-odd">
		<td class="td-content-title">租金发票类型：</td>
		<td class="td-content" colspan=3>
		<div id="id_rent_invoice_type" class="leftComboContainer"></div></font>
		</td>
	</tr>
	<tr class="tr-even">
		<td class="td-content-title">租金发票本利金是否拆分：</td>
		<td class="td-content">
		<div class="leftComboContainer" id="id_IsInvoiceRentSplit"></div><font class="required-content">*</font>
		</td>
		<td class="td-content-title">发票为放款先决条件：</td>
		<td class="td-content">
		<div class="leftComboContainer" id="id_BoolInvoice"></div><font class="required-content">*</font>
		</td>
	</tr>
</table>