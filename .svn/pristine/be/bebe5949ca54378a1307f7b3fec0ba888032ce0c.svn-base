package com.business.action.leasing.dealerinvoiceapply;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.contract.equip.gps.GPSInfo;
import com.business.entity.contract.invoice.InvoicInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjChangeInfo;
import com.business.entity.proj.ProjGuaranteeMethod;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.entity.proj.reckon.ProjCashDetail;
import com.business.entity.proj.reckon.ProjFundFundPlan;
import com.business.entity.proj.reckon.ProjFundRentPlan;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;

/**
 * 
 * @author 周丽梅
 * @date 2014-2-14
 * @info开票申请Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "dealerInvoiceApplyEndAction", description = "流程结束动作", workflowName = "开票申请流程")
@Component(value = "dealerInvoiceApplyEndAction")
public class DealerInvoiceApplyEndAction implements JbpmBaseAction{
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
		System.out.println("$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		//String contrac_id = variablesMap.get("contract_info.contractnumber");
		//Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		//queryMainObjectMap.put("contractid", contrac_id);
		String id_json_dealer_invoice_this_apply_str = variablesMap.get("id_json_dealer_invoice_this_apply_str");
		ObjectMapper jsonMapper = new ObjectMapper(); 
		JSONArray jsonArray = new JSONArray(id_json_dealer_invoice_this_apply_str);
		System.out.println(id_json_dealer_invoice_this_apply_str);
		InvoicInfo invoiceApply=new InvoicInfo();
		for(int i=0;i<jsonArray.length();i++){
			  JSONObject jsonObj = jsonArray.getJSONObject(i); 
			  //ishaveinvoice
			if(null!=jsonObj.optString("ishaveinvoice")&&"0".equals(jsonObj.optString("ishaveinvoice"))){  
			  //if(null!=jsonObj.optString("idcardno")&&!"".equalsIgnoreCase(jsonObj.optString("idcardno"))){
			 ContractEquip contractequip=this.tableService.findEntityByID(ContractEquip.class,jsonObj.optString("equipid"));
				  System.out.println(jsonObj.optString("equipid"));
				 invoiceApply.setContractequip(contractequip);
				  invoiceApply.setCarName(jsonObj.optString("carname"));
				  invoiceApply.setCertificate(jsonObj.optString("certificate"));
				  invoiceApply.setConfinedNum(jsonObj.optString("confinednum"));
				  invoiceApply.setInletCertificate(jsonObj.optString("inletcertificate"));
				  invoiceApply.setPurchaseUnit(jsonObj.optString("purchaseunit"));
				  invoiceApply.setBrandModel(jsonObj.optString("modelname"));
				  invoiceApply.setMotorNumber(jsonObj.optString("motornumber"));
				  invoiceApply.setLocality(jsonObj.optString("locality"));
				  invoiceApply.setInspection(jsonObj.optString("inspection"));
				  invoiceApply.setPriceTotal(new BigDecimal(jsonObj.optString("pricetotal")));
				  invoiceApply.setPriceTotalUpper(jsonObj.optString("pricetotalupper"));
				  invoiceApply.setTonnage(Integer.parseInt(jsonObj.optString("tonnage")));
				  invoiceApply.setIdCard(jsonObj.optString("idcard"));
				  this.tableService.saveEntity(invoiceApply);
			  }
			  
			  
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
