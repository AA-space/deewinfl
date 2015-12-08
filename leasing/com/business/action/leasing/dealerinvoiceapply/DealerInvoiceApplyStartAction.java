package com.business.action.leasing.dealerinvoiceapply;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.action.leasing.project.change.ProjChangeStartAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractOtherInfo;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.invoice.ContractInvoiceInfo;
import com.business.entity.contract.invoice.InvoicInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoCompany;
import com.business.entity.cust.CustInfoPerson;
import com.business.entity.proj.ProjInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.SecurityUtil;

/**
 * 
 * @author 周丽梅
 * @date 2014-2-14
 * @info开票申请Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "dealerInvoiceApplyStartAction", description = "流程开始动作", workflowName = "开票申请流程")
@Component(value = "dealerInvoiceApplyStartAction")
public class DealerInvoiceApplyStartAction implements JbpmBaseAction{
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public String save(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		Logger logger = Logger.getLogger(ProjChangeStartAction.class.getName());
		//String proj_id = variablesMap.get("proj_id");// 先获得proj_id
		String contract_id=variablesMap.get("contract_id");
		ContractInfo contractinfo=(ContractInfo)this.tableService.findEntityByID(ContractInfo.class, contract_id);
		//ProjInfo projInfo = (ProjInfo) this.tableService.findEntityByID(ProjInfo.class, proj_id);
		//variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo, null, "proj_info"));// 把项目的所有元素映射进来
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractinfo, null, "contract_info"));
		CustInfo custInfo=contractinfo.getCustId();
		//CustInfo custInfo = projInfo.getCustId();
		if (custInfo != null) {
			//CustInfo CustInfo=this.tableService.findEntityByID(CustInfo.class, custInfo.getId());
			/*if(custInfo.getCustInfoCompany()!=null){
				variablesMap.put("contract_info.idcardno",custInfo.getCustInfoCompany().getIdcardNo());	
			}else{
				variablesMap.put("contract_info.idcardno","");	
			}*/
			variablesMap.put("contract_info.custname", custInfo.getCustName());
			variablesMap.put("contract_info.custnumber", custInfo.getCustNumber());
			variablesMap.put("contract_info.custid", custInfo.getId());
			variablesMap.put("contract_info.cust_type", custInfo.getCustClass().getCode().equals("CUST_INFO_COMPANY") ? "法人" : "自然人");
			variablesMap.put("contract_info.custclass", custInfo.getCustClass().getName());// 动态显示
		} 
			
		/** 项目商务条件选项卡内容 */
		Map<String, String> queryMainObjectMap = new HashMap<String, String>();
		//queryMainObjectMap.put("proj_id", proj_id);// 注明：项目其它信息(这里projInfo_id在后面的JsonArrayData中很多用到这种格式)
		queryMainObjectMap.put("contract_id", contract_id);
		
		variablesMap.put("json_dealer_invoice_str", this.tableService.getJsonArrayData("eleasing/jsp/dealer_invoice_apply/invoice_list1.xml", queryMainObjectMap).toString());
		System.out.println(variablesMap.get("json_dealer_invoice_str"));
		
		variablesMap.put("json_dealer_invoice_apply_str", this.tableService.getJsonArrayData("eleasing/jsp/dealer_invoice_apply/invoice_apply_list1.xml", queryMainObjectMap).toString());
		System.out.println(variablesMap.get("json_dealer_invoice_apply_str"));
	}

}
