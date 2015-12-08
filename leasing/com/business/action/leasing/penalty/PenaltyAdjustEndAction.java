package com.business.action.leasing.penalty;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

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
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.service.TableService;
import com.business.service.vouchersFactory.FundIncomeService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;

/**
 * @author Toybaby
 * 
 *         2012-12-26下午01:17:43 email toybaby@mail2.tenwa.com.cn function:
 * 
 */
@WorkflowAction(name = "penaltyAdjustEndAction", description = "流程结束动作", workflowName = "批量罚息减免流程")
@Component(value = "penaltyAdjustEndAction")
public class PenaltyAdjustEndAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;

	@Resource(name = "fundIncomeService")
	private FundIncomeService fundIncomeService;
//	@Resource(name = "executor")
//	ExecutorService es;

	@Override
	public String delete(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request,
			 Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		String jsonFundString = variablesMap.get("current_fund_income_detial");// 本次减免清单
		JSONArray jsonArray = new JSONArray(jsonFundString);//json --> Object
		JSONObject jsonObj = null;  
		Integer planlist = null;
		BigDecimal  penalty,hispenalty,penaltyad = null;
		String hiredate ,hql,contractid,hsqlx = null;
		List<ContractFundRentInCome> income = null;
		List<ContractFundRentPlan> rentplan = null;
		ContractFundRentInCome incomeUP,incomenw = null;
		DictionaryData balanceMode = null;
		ContractInfo contractinfo = null;
		for ( int i = 0; i < jsonArray.length(); i++ )
		{
			jsonObj = jsonArray.getJSONObject(i);
			planlist = jsonObj.getInt("planlist"); //计划期次
			contractid = jsonObj.getString("contractid");//合同主键id
			hiredate = jsonObj.getString("hiredate");//回笼日期
			hql = " from ContractFundRentInCome  where contractId.id=? and planList=? ";//and income.hireList=?
		    income = this.tableService.findResultsByHSQL( hql,contractid,planlist );//,hirelist
			if( income !=null && income.size() > 0 )
			{
				incomeUP = income.get(0);
				penalty = new BigDecimal( jsonObj.optString("penaltyadjust") );
				hispenalty = incomeUP.getPenaltyAdjust()==null?BigDecimal.ZERO:incomeUP.getPenaltyAdjust();
				incomeUP.setPenaltyAdjust( penalty.add(hispenalty) );
				incomeUP.setModifyDate( DateUtil.getSystemDateTime() );
				this.tableService.updateEntity(incomeUP);
			}
			else
			{
				incomenw = new ContractFundRentInCome();
				penaltyad = new BigDecimal( jsonObj.optString("penaltyadjust") );
				contractinfo = new  ContractInfo();
				contractinfo = this.tableService.findEntityByID( ContractInfo.class,contractid );
				incomenw.setContractId(contractinfo);
				//取计划id
				hsqlx = "from ContractFundRentPlan where contractId.id =? and rentList=? ";
				rentplan = this.tableService.findResultsByHSQL( hsqlx,contractinfo.getId(),planlist );
				if ( rentplan.size() > 0 )  incomenw.setPlanId( rentplan.get(0) );
				incomenw.setPenaltyAdjust(penaltyad);
				incomenw.setPlanList(planlist);
				incomenw.setCreateDate( DateUtil.getSystemDateTime() );
				incomenw.setCreator( SecurityUtil.getPrincipal() );
				incomenw.setHireList(1);
				balanceMode = this.tableService.findEntityByID( DictionaryData.class,"PayFund12" );
				incomenw.setBalanceMode(balanceMode);
				incomenw.setHireDate(hiredate);
				incomenw.setPenalty(BigDecimal.ZERO);
				this.tableService.saveEntity(incomenw);
			}
		}
		 //--------------------------------改为  未减免状态-----------------------------------------
		String contract_id = variablesMap.get("contract_id");
		if ( null != contract_id )
		{
			String sql ="update contract_info set penaltyjmstatus='0' where id in (" +contract_id+ ")";
			this.tableService.updateBySql(sql);
		}
		
	}

	@Override
	public String save(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.business.action.JbpmBaseAction#back(javax.servlet.http.HttpServletRequest,
	 *      java.util.Map)
	 **/

	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub

	}
}
