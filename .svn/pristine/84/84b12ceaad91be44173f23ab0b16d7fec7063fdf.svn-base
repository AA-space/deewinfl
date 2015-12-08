package com.business.action.leasing.rentPenaltyAdjust;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.fund.ContractFundRentInCome;
import com.business.service.TableService;
import com.business.service.vouchersFactory.FundIncomeService;
import com.business.util.WorkflowUtil;
import com.kernal.annotation.WorkflowAction;

/**
 * @author Toybaby
 * 
 *         2012-12-26下午01:17:43 email toybaby@mail2.tenwa.com.cn function:
 * 
 */
@WorkflowAction(name = "rentPenaltyAdjustEndAction", description = "流程结束动作", workflowName = "罚息减免流程")
@Component(value = "rentPenaltyAdjustEndAction")
public class RentPenaltyAdjustEndAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	
	@Resource(name = "fundIncomeService")
	private FundIncomeService fundIncomeService;
	
	

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		//删除流程冲突 
		  WorkflowUtil.deleteWorkFlowConflict(this.tableService, variablesMap); 
		String contract_id = variablesMap.get("contract_id");
	
		BigDecimal sum = BigDecimal.ZERO;
		
		ContractInfo contractInfo = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, contract_id);
		
		Map<String,String> propertiesMap = new HashMap<String,String>();
		propertiesMap.put("DictionaryData", "code");
		propertiesMap.put("FundEbankData", "ebdataId");
		propertiesMap.put("ContractFundRentPlan", "id");
		// 租金实收
		String jsonFundString = variablesMap.get("current_fund_income_detial");
		JSONArray jsonArray = new JSONArray(jsonFundString);
		for(int i=0;i<jsonArray.length();i++){
			List<String> jsonFundList=new ArrayList<String>();
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			Integer planlist=jsonObj.getInt("planlist");
			Integer hirelist=jsonObj.getInt("hirelist");
			String hql= " from ContractFundRentInCome AS income where income.contractId.id=? and income.planList=? and income.hireList=? ";
			List<ContractFundRentInCome> income=this.tableService.findResultsByHSQL(hql, contractInfo.getId(),planlist,hirelist);
			if(income.size()>0)
			{
				ContractFundRentInCome incomeUP=income.get(0);
				BigDecimal  penalty=new BigDecimal(jsonObj.optString("penaltyadjust"));
				BigDecimal  hispenalty=incomeUP.getPenaltyAdjust();
				incomeUP.setPenaltyAdjust(penalty.add(hispenalty));
				this.tableService.updateEntity(incomeUP);
			}else{
				jsonFundList.add(jsonObj.toString());
				this.tableService.updateOneToManyCollectionsNoRemoved(contractInfo, "contractFundRentIncomes", ContractFundRentInCome.class, "contractId", jsonFundList.toString(), propertiesMap);
			}
			
		}
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
