package com.business.action.leasing.assets.fiveCategory;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractFiveCategory;
import com.business.entity.contract.ContractInfo;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;


@WorkflowAction(name = "fiveCategoryEndAction", description = "五级分类(合同)流程结束", workflowName = "五级分类(合同)流程")
@Component(value = "fiveCategoryEndAction")
public class FiveCategoryEndAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */
		
		
		ContractInfo contractInfo = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, variablesMap.get("contract_id"));
		User user = (User)SecurityUtil.getPrincipal();
		String systemDate = DateUtil.getSystemDateTime();
		Long proceid = jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid();
		DictionaryData contractFiveName = (DictionaryData) this.tableService.findEntityByID(DictionaryData.class, variablesMap.get("five_category.contractfive_business"));
		DictionaryData saleFiveName = (DictionaryData) this.tableService.findEntityByID(DictionaryData.class, variablesMap.get("five_category.contractfive_sale"));
		//设置五级分类
		ContractFiveCategory contractFiveCategory= new ContractFiveCategory();

		contractFiveCategory.setContractId(contractInfo);
		contractFiveCategory.setDocId(proceid.toString());
		
		contractFiveCategory.setContractFiveName(contractFiveName);
		contractFiveCategory.setContractFiveDate(variablesMap.get("five_category.contractfivedate_business"));
		contractFiveCategory.setContractFiveExplain(variablesMap.get("five_category.explain_business"));
		
		contractFiveCategory.setSaleFiveName(saleFiveName);
		contractFiveCategory.setSaleFiveDate(variablesMap.get("five_category.contractfivedate_sale"));
		contractFiveCategory.setSaleFiveExplain(variablesMap.get("five_category.explain_sale"));
		
		contractFiveCategory.setCreator(user);
		contractFiveCategory.setCreateDate(systemDate);
		this.tableService.saveEntity(contractFiveCategory);
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
