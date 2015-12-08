package com.business.action.leasing.assets;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.asset.FundEbankData;
import com.business.entity.asset.FundEbankProcess;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;

/**
 * @author Toybaby
 * 
 *         2012-12-26下午01:17:43 email toybaby@mail2.tenwa.com.cn function:
 * 
 */
@WorkflowAction(name = "fundIncomeEditAction", description = "流程编辑动作", workflowName = "租金回笼流程")
@Component(value = "fundIncomeEditAction")
public class FundIncomeEditAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//获取网银实收
		BigDecimal sum = BigDecimal.ZERO;
		JSONArray jsonArr = new JSONArray(variablesMap.get("current_fund_income_detial"));
		for(int i=0;i<jsonArr.length();i++){
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			sum=sum.add(new BigDecimal(jsonObj.getDouble("rent")));
		}
		
		FundEbankProcess fundEbankProcess = (FundEbankProcess) this.tableService.findEntityByID(FundEbankProcess.class, variablesMap.get("fund_ebank_process"));
		FundEbankData fundEbankData = (FundEbankData) this.tableService.findEntityByID(FundEbankData.class, variablesMap.get("ebank_id"));
		
		fundEbankData.initFundEbank();
		
		
		if(fundEbankData.getMayOpeMoney().subtract(sum.setScale(2,BigDecimal.ROUND_HALF_UP)).compareTo(BigDecimal.ZERO) == -1){
			throw new BusinessException("当前核销金额有误,请检查");
		} 
		//设置网银过程表数据，防止其他流程占用
		fundEbankProcess.setProcessAmount(sum);
		this.tableService.updateEntity(fundEbankProcess);
		
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
