package com.business.action.leasing.contract.cancel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.service.BaseService;
import com.business.util.WorkflowUtil;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;

/**
 * @author Jason
 * @date 2013-4-24
 * @info 
 */
@WorkflowAction(name = "contractCancelEndAction", description = "流程结束动作", workflowName = "合同撤销流程")
@Component(value = "contractCancelEndAction")
public class ContractCancelEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String contract_id = variablesMap.get("contract_info.contractid");
		// 1.将合同状态改成合同撤销
		Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("contractId", contract_id);
		

		
		ContractInfo contractInfo = (ContractInfo)this.baseService.updateMainEntity(ContractInfo.class, queryMainObjectMap, variablesMap,null, "contract_info");
		contractInfo.setContractStatus(AppStaticUtil.CONTRACT_APPROVAL);
		contractInfo.setContractStatus( AppStaticUtil.CONTRACT_CANCEL);
		/**
		 * 将合同号放入废弃池 开始
		 */
		//String contractNumber = contractInfo.getContractNumber();
		contractInfo.setContractNumber("");
		//德银业务合同号在项目信审生成，不需要号码废弃池
		//WorkflowUtil.addDiscardContractInfoSerialNumberForBussiness(contractNumber,contract_id, baseService.getBussinessDao().getHibernateTemplate(), this.baseService.getBussinessDao().getJdbcTemplate());
		/**
		 * 将合同号放入废弃池 结束
		 */
		
		
		//保存红冲
	    DictionaryData dicdpayType;
	    String paytype="pay_type_out";
		String HQL=" from ContractInfo as c where c.contractId=?";
		HQL=" from DictionaryData AS DD where DD.code=? ";
		dicdpayType=(DictionaryData)this.baseService.findResultsByHSQL(HQL,paytype).get(0);
		Map<String,Object> propertiesMap = new HashMap<String,Object>();
		propertiesMap.put("DictionaryData", "code");
		//propertiesMap.put("FundEbankData", "ebdataId");
		propertiesMap.put("FundFundChargePlan", "paymentId");
		// 实付
		List<ContractFundFundCharge>chargeList=new ArrayList<ContractFundFundCharge>();
		String jsonFundString = variablesMap.get("json_contract_fund_payment_now_str");//proj_info.projEquips
		if(jsonFundString!= null && !jsonFundString.equals("")){
			//chargeList = this.baseService.getManyToOneListToInsertByJsonString(FundFundCharge.class, jsonFundString, propertiesMap);
			if (chargeList != null && chargeList.size() > 0) {
				for (ContractFundFundCharge charge : chargeList) {
					charge.setContractId(contractInfo);
					charge.setPayType(dicdpayType);
					this.baseService.saveOrUpdateEntity(charge);
				}
			}
		}
		
		
		
		/** 流程冲突第三步-结束*/
		
		if(StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))){WorkFlowFlag w = this.baseService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.baseService.removeEntity(w);}
		/** 流程冲突第三步-结束*/
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
//        this.end(request, variablesMap, jbpmWorkflowHistoryInfo);
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
	}

}
