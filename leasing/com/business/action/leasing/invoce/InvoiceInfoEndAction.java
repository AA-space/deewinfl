package com.business.action.leasing.invoce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.invoice.ContractInvoiceInfo;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;

@WorkflowAction(name = "invoiceInfoEndAction", description = "流程结束动作", workflowName = "维护发票信息流程")
@Component(value = "invoiceInfoEndAction")
public class InvoiceInfoEndAction implements JbpmBaseAction{
	@Resource(name = "tableService")
	private TableService tableService;
	
	

	@Override
	public void back(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String delete(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String contract_id = variablesMap.get("contract_id");
		Map<String, Object> propertiesMap = new HashMap<String,Object>();
		propertiesMap.put("contractId.id",contract_id);
		
		List<ContractInvoiceInfo> invoiceInfoList = this.tableService.findEntityByProperties(ContractInvoiceInfo.class, propertiesMap);
		if(invoiceInfoList.size()>0){
			/*修改发票信息*/
			ContractInvoiceInfo invoiceInfo = invoiceInfoList.get(0);
			invoiceInfo.setIskfp(variablesMap.get("contract_invoice_info.iskfp"));
			invoiceInfo.setInvoiceType(this.tableService.findEntityByID(DictionaryData.class, variablesMap.get("contract_invoice_info.invoicetype")));
			invoiceInfo.setInvoiceOpenBank(variablesMap.get("contract_invoice_info.invoiceopenbank"));
			invoiceInfo.setInvoiceNumber(variablesMap.get("contract_invoice_info.invoicenumber"));
			invoiceInfo.setInvoiceAddress(variablesMap.get("contract_invoice_info.invoiceaddress"));
			invoiceInfo.setInvoiceTel(variablesMap.get("contract_invoice_info.invoicetel"));
			
			invoiceInfo.setTaxNumber(variablesMap.get("contract_invoice_info.taxnumber"));
			invoiceInfo.setTaxRegType(this.tableService.findEntityByID(DictionaryData.class,variablesMap.get("contract_invoice_info.taxregtype")));
			invoiceInfo.setInvoicememo(variablesMap.get("contract_invoice_info.invoicememo"));
			invoiceInfo.setInvoiceRemarks(variablesMap.get("contract_invoice_info.invoiceremarks"));
			invoiceInfo.setModifyDate(DateUtil.getSystemDateTime());
			this.tableService.updateEntity(invoiceInfo);
		}else{
			/*插入新的发票信息*/
			ContractInvoiceInfo contractInvoiceInfo = new ContractInvoiceInfo();
			this.tableService.copyAndOverrideExistedValueFromStringMap(variablesMap, contractInvoiceInfo, null, "contract_invoice_info");
			contractInvoiceInfo.setContractId(this.tableService.findEntityByID(ContractInfo.class,contract_id));
			this.tableService.saveEntity(contractInvoiceInfo);
		}
		
		
	}

	@Override
	public String save(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
