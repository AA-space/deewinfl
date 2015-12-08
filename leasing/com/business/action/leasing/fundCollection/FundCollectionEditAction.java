package com.business.action.leasing.fundCollection;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.daoImpl.AbstractBaseDaoImpl;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.asset.FundEbankData;
import com.business.entity.asset.FundEbankProcess;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;

/**
 * @author Toybaby
 * 
 *         2012-12-26下午01:17:43 email toybaby@mail2.tenwa.com.cn function:
 * 
 */
@WorkflowAction(name = "fundCollectionEditAction", description = "流程编辑动作", workflowName = "收款流程")
@Component(value = "fundCollectionEditAction")
public class FundCollectionEditAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	
	 private static Log log = LogFactory.getLog(AbstractBaseDaoImpl.class);
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String  contractid=variablesMap.get("contract_id");
		ContractInfo contractinfo=(ContractInfo)this.tableService.findEntityByID(ContractInfo.class, contractid);
		
		//设置资金计划为非流程中
		Set<ContractFundFundPlan> fundFundChargePlans = contractinfo.getFundFundChargePlans();
		Iterator<ContractFundFundPlan> it = fundFundChargePlans.iterator();
		while (it.hasNext()) {
			ContractFundFundPlan fundFundChargePlan = (ContractFundFundPlan) it.next();
			fundFundChargePlan.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		}
		
		
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//增加对资金计划的判断
		String fundnow=variablesMap.get("json_receivercharge_str");
		JSONArray jsonArr = new JSONArray(fundnow);
		for(int i=0;i<jsonArr.length();i++){
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			ContractFundFundPlan fplan=this.tableService.findEntityByID(ContractFundFundPlan.class, jsonObj.get("fundfundchargeplan").toString());
			if(fplan==null)
			{
				throw new BusinessException("合同已经回退,请重新发起合同审批!");
			}
		}
		//throw new BusinessException("test");
		//获取网银实收
		BigDecimal sum = BigDecimal.ZERO;
		JSONArray jsonArr1 = new JSONArray(variablesMap.get("json_receivercharge_str"));
		for(int i=0;i<jsonArr1.length();i++){
			JSONObject jsonObj = jsonArr1.getJSONObject(i);
			sum=sum.add(new BigDecimal(jsonObj.getDouble("factmoney")));
		}
		
		if("red".equals(variablesMap.get("feetype"))){
			System.out.println("红冲不需要网银信息");
		}else{
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
