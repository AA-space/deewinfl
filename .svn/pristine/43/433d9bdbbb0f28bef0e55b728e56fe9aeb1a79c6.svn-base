<!--发票类型 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

  <script language="javascript">
    jQuery(function(){
        var isInit=isSubTable||false;
        if(isInit==true){
   	    dict('id_rent_invoice_type','proj_invoice_type.rentinvoicetype','rent_invoice_type','${requestScope["proj_invoice_type.rentinvoicetype"]}','${requestScope["rawValue_proj_invoice_type.rentinvoicetype"]}','require="true" label="租金发票类型"',300);
        //特殊下拉
        dictYesOrNoByCode('id_IsInvoiceRentSplit','proj_invoice_type.isinvoicerentsplit','${empty requestScope["proj_invoice_type.isinvoicerentsplit"] ? "0" : requestScope["proj_invoice_type.isinvoicerentsplit"] }','',true,' require="true" label="租金发票本利金是否拆分"');
        dictYesOrNoByCode('id_BoolInvoice','proj_invoice_type.boolinvoice','${empty requestScope["proj_invoice_type.boolinvoice"] ? "0" : requestScope["proj_invoice_type.boolinvoice"] }','',true,' require="true" label="发票为放款先决条件"');
         }
    });
    </script>
<table class="fillTable" cellspacing="0" cellpadding="0" width="50%">
	<tr class="tr-odd">
		<td class="td-content-title">租金发票类型：</td>
		<td class="td-content" colspan=3>
		<div id="id_rent_invoice_type"></div>
		</td>
	</tr>
	<tr class="tr-odd">
		<td class="td-content-title">租金发票本利金是否拆分：</td>
		<td class="td-content">
		<div class="leftComboContainer" id="id_IsInvoiceRentSplit"></div>
		</td>
		<td class="td-content-title">发票为放款先决条件：</td>
		<td class="td-content">
		<div class="leftComboContainer" id="id_BoolInvoice"></div>
		</td>
	</tr>
</table>