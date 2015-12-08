package com.business.action.leasing.contract.dealer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.CustInfoDealer;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;
 

 
@WorkflowAction(name = "dealerInfoEndAction", description = "流程结束动作", workflowName = "经销商合作协议号跨年度修改流程")
@Component(value = "dealerInfoEndAction")
public class DealerInfoEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception { 
		
		String cust_id = variablesMap.get("cust_id");
		String memo = request.getParameter("memo");
		String contract_num = request.getParameter("contract_num");
		String zant = request.getParameter("zant");
		HashMap<String, Object> propertiesMap = new HashMap<String,Object>();
		propertiesMap.put("custId.id",cust_id);
		List<CustInfoDealer> listDealer = this.baseService.findEntityByProperties(CustInfoDealer.class, propertiesMap);
		if(listDealer.size()> 0){
			CustInfoDealer infoDealer = listDealer.get(0);
			infoDealer.setContractNum(contract_num);
			infoDealer.setMemo(memo);
			infoDealer.setDealerzantstatus(zant);
			this.baseService.updateEntity(infoDealer);
		}
	}
		
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	
	 /**
	 * (non-Javadoc)
	 * @see com.business.action.JbpmBaseAction#back(javax.servlet.http.HttpServletRequest, java.util.Map)
	 **/
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
