package com.business.action.leasing.assets.custview;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractPatrolCust;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;


@WorkflowAction(name = "custViewEndAction", description = "客户巡访流程结束", workflowName = "客户巡访流程")
@Component(value = "custViewEndAction")
public class CustViewEndAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		ContractInfo contractInfo = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, variablesMap.get("contract_id"));
		User user = (User)SecurityUtil.getPrincipal();
		String viewTime = variablesMap.get("cust_view.viewTime");
		String marketValue = variablesMap.get("cust_view.marketValue");
		String systemDate = DateUtil.getSystemDateTime();
		Long proceid = jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid();

		
		//保存计划表单
		ContractPatrolCust contractPatrolCust = new ContractPatrolCust();
		contractPatrolCust.setContractId(contractInfo);
		contractPatrolCust.setDocId(proceid.toString());
		contractPatrolCust.setPatrolDate(viewTime);
		contractPatrolCust.setPatrolPrice(marketValue);
		contractPatrolCust.setCreateDate(systemDate);
		contractPatrolCust.setCreator(user);
		
		this.tableService.saveEntity(contractPatrolCust);
		

		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */
		
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
