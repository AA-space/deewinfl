package com.business.action.leasing.contract.dealer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.kernal.annotation.WorkflowAction;

 
@WorkflowAction(name = "dealerInfoStartAction", description = "流程开始动作", workflowName = "经销商合作协议号跨年度修改流程")
@Component(value = "dealerInfoStartAction")
public class DealerInfoStartAction implements JbpmBaseAction {

	@Override
	public void start(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String cust_id = variablesMap.get("cust_id");//经销商的主键
		String dealername = variablesMap.get("dealername");//经销商的名称
		String contract_num = variablesMap.get("contract_num");//经销商的合作字编号
		
		variablesMap.put("cust_id", cust_id);
		variablesMap.put("dealername", dealername);
		variablesMap.put("contract_num", contract_num);
		
	}

	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
	}

	@Override
	public void end(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
	}

	@Override
	public String save(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public String delete(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}
 
}
