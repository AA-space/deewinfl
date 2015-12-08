package com.business.action.leasing.invoce;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.ContractInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.CustInfoDealer;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;

@WorkflowAction(name = "invoiceInfoStartAction", description = "流程开始动作", workflowName = "维护发票信息流程")
@Component(value = "invoiceInfoStartAction")
public class InvoiceInfoStartAction implements JbpmBaseAction{
	@Resource(name = "tableService")
	private TableService tableService;

	@Override
	public void back(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String delete(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		 
		return null;
	}

	@Override
	public void end(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String save(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String contract_id = variablesMap.get("contract_id").trim();
		ContractInfo contractInfo = this.tableService.findEntityByID(ContractInfo.class,contract_id);
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractInfo, null, "contract_info"));
		
		CustInfo customerInfo = contractInfo.getCustId();
		variablesMap.put("contract_info.custname", customerInfo.getCustName());
		variablesMap.put("contract_info.custnumber", customerInfo.getCustNumber());
		variablesMap.put("contract_info.custid", customerInfo.getId());
		
		variablesMap.put("contract_info.projid", contractInfo.getProjId().getProjId());
		variablesMap.put("business_type", contractInfo.getBusinessType().getCode()); 
		variablesMap.put("proj_info.cust_type", contractInfo.getProjId().getCustId().getCustClass().getCode()); 
		
		Map<String, Object> propertiesMap = new HashMap<String,Object>();
		propertiesMap.put("custId",contractInfo.getCustDealer());
		List<CustInfoDealer> list = this.tableService.findEntityByProperties(CustInfoDealer.class, propertiesMap);
		if(list.size()> 0 ){
			variablesMap.put("dealear_xiey", list.get(0).getContractNum());
		}
		
		Map<String,String> queryMainObjectMap = new HashMap<String,String>();
		queryMainObjectMap.put("contract_id",variablesMap.get("contract_id"));
		JSONObject jsonObject;
		Iterator<?> it;
		JSONArray jsonArray2=this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/contract_invoice_info.xml", queryMainObjectMap);
		if(jsonArray2!=null&&jsonArray2.length()>0){
			jsonObject= jsonArray2.getJSONObject(0);
			it= jsonObject.keys();
			while(it.hasNext()){//租金发票类型
				String key = (String)it.next();
				variablesMap.put("contract_invoice_info." + key,jsonObject.get(key).toString());
			};
		}
	}
	
	 
}
