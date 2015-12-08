package com.business.action.leasing.penalty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.service.TableService;
import com.business.service.asset.AssetServer;
import com.business.util.WorkflowUtil;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;
import com.kernal.utils.StringUtil;
import com.kernal.utils.WebUtil;
/**
 * 
 *
 */
@WorkflowAction(name = "penaltyAdjustStartAction", description = "流程开始动作", workflowName = "批量罚息减免流程")
@Component(value = "penaltyAdjustStartAction")
public class PenaltyAdjustStartAction implements JbpmBaseAction {
	@Resource(name = "assetServer")
	private AssetServer assetServer;
	
	@Resource(name = "tableService")
	private TableService tableService;

        
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//租金计划
		
		String contract_id = variablesMap.get("contract_id");
		if ( null != contract_id )
		{
			String sql ="update contract_info set penaltyjmstatus='1' where id in (" +contract_id+ ")";
			this.tableService.updateBySql(sql);
			Map<String, String> mapProp = new HashMap<String, String>();
			mapProp.put("contractid",contract_id);
			variablesMap.put("fund_rent_plans",this.tableService.getJsonArrayData("eleasing/jsp/query/contract_rentplan_query.xml",mapProp).toString());
		}
	}

	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
	}
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String contract_id = variablesMap.get("contract_id");
		if ( null != contract_id )
		{
			String sql ="update contract_info set penaltyjmstatus='0' where id in (" +contract_id+ ")";
			this.tableService.updateBySql(sql);
		}
		return null;
	}
	
	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {}
	
	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}
}
