package com.business.action.leasing.contract.change;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.reckon.cash.ContractCashDetail;
import com.business.entity.contract.reckon.fund.ContractFundRentPlanBefore;
import com.business.entity.proj.ProjInfo;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;

/**
 * @author Jason
 * @date 2013-4-24
 * @info
 */
@WorkflowAction(name = "contractChangeEditAction", description = "流程编辑动作", workflowName = "合同变更流程")
@Component(value = "contractChangeEditAction")
public class ContractChangeEditAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	@Resource(name="baseService")
	private BaseService baseService;

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String contract_id = variablesMap.get("contract_id");
		ContractInfo contractInfo = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, contract_id);
		contractInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		Map<String,Object> propertiesMap = new HashMap<String,Object>();
		String contractNumber = variablesMap.get("contract_info.contractnumber").trim();
		variablesMap.put("contract_info.contractnumber",contractNumber);
		String id = variablesMap.get("contract_info.id");
		
		if(!"".equals(id)){
			ContractInfo contractInfo=new ContractInfo();
			//propertiesMap.put("contractNumber", contractNumber);
			//List<ContractInfo> cInfos=this.baseService.findEntityByProperties(ContractInfo.class, propertiesMap);
			contractInfo=this.baseService.findEntityByID(ContractInfo.class, id);
			//更新数据
			ProjInfo pinfo=contractInfo.getProjId();
			//contractInfo=(ContractInfo)this.baseService.copyAndOverrideExistedValueFromStringMap(variablesMap, contractInfo,null,"contract_info");
				//保存合同信息
			if(pinfo!=null){
				contractInfo.setProjId(pinfo);
			}
			contractInfo.setContractStatus(AppStaticUtil.CONTRACT_APPROVAL_01);
			contractInfo.setWorkFlag(AppStaticUtil.WORKFLOW_ON);
			this.baseService.saveOrUpdateEntity(contractInfo);
			
			//数据字典通过name属性匹配
			Map<String,String> dictDataClassMapping = new HashMap<String,String>();
			dictDataClassMapping.put("DictionaryData", "code");
			// 更新资金计划
			// 获取实收资金信息
			Map<String, Object> propertiesMapc = new HashMap<String, Object>();
			propertiesMapc.put("contractId", contractInfo);
			List<ContractFundFundCharge> ccharge = this.tableService.findEntityByProperties(ContractFundFundCharge.class, propertiesMapc);
			
			//合同变更，前需判断是否有资金收款
			for (int i = 0; i < ccharge.size(); i++) {
				ContractFundFundCharge cc = ccharge.get(i);
				// 如果是红冲金额,则处理资金计划信息,有其他收款则走红冲 PayFund9--资金类型为红冲
				if ("PayFund9".equalsIgnoreCase(cc.getSettleMethod().getCode())) {

					// 3.将资金计划作废
					ContractFundFundPlan cplan = cc.getFundFundChargePlan();
					cplan.setInvalid("1");
					cplan.setPaymentId(null);
					this.tableService.updateEntity(cplan);

				} else {
					throw new BusinessException("已经资金收款,不能做合同变更,如需合同变更,请走资金收款做红冲!");
				}
			}
			
			//没有实收的资金计划删除
			List<ContractFundFundPlan> fundplan = this.tableService.findEntityByProperties(ContractFundFundPlan.class,propertiesMapc);
			for (int j = fundplan.size() - 1; j >= 0; j--) {
				ContractFundFundPlan fplan = fundplan.get(j);
				for (int i = 0; i < ccharge.size(); i++) {
					if (fplan.getId().equalsIgnoreCase(ccharge.get(i).getFundFundChargePlan().getId())) {
						fundplan.remove(fplan);
					}
				}
			}
			this.tableService.removeAllEntites(fundplan);
			//flush删除的资金计划
			this.baseService.updateFlush();
			
			//保存新的资金计划
			String json_contract_fund_charge_str = variablesMap.get("json_fund_fund_charge_str");
			this.baseService.updateOneToManyCollections(contractInfo, "fundFundChargePlans", ContractFundFundPlan.class, "contractId", json_contract_fund_charge_str,dictDataClassMapping);
			
		}else{
			throw new BusinessException("请输入合同号!");
		}
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//校验合同号唯一
		System.out.println(variablesMap.toString());
		String msg="";
		Map<String,Object> propertiesMap = new HashMap<String,Object>();
		String contractId = variablesMap.get("contract_info.contractid");
		if(!"".equals(contractId)){
			propertiesMap.put("contractId", contractId);
			List<ContractInfo> cInfos=tableService.findEntityByProperties(ContractInfo.class, propertiesMap);
			if(cInfos!=null&&cInfos.size()>0){
				if(!cInfos.get(0).getId().equals(variablesMap.get("contract_info.id"))){
					msg="您填写的合同号["+contractId+"]已经存在!";
				}
			}
		}
		return msg;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.business.action.JbpmBaseAction#back(javax.servlet.http.HttpServletRequest, java.util.Map)
	 **/
	
	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		System.out.println("################开始EditAction的退回动作");
		
		
		// System.out.println(variablesMap);
		// 1获取合同信息
		String contractid = variablesMap.get("contract_info.contractid");
		Map<String, Object> cMap = new HashMap<String, Object>();
		cMap.put("contractId", contractid);
		ContractInfo contractInfo = this.baseService.findEntityByProperties(ContractInfo.class, cMap).get(0);
        //恢复到合同状态21
		contractInfo.setContractStatus(AppStaticUtil.CONTRACT_APPROVAL);
		contractInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		this.baseService.saveOrUpdateEntity(contractInfo);
		
		//数据字典通过name属性匹配
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		// 更新资金计划
		// 获取实收资金信息
		Map<String, Object> propertiesMapc = new HashMap<String, Object>();
		propertiesMapc.put("contractId", contractInfo);
		List<ContractFundFundCharge> ccharge = this.tableService.findEntityByProperties(ContractFundFundCharge.class, propertiesMapc);
		// 流程互斥表:判断是否在客户资金收款或资金收款流程中,在则不能删除
		Map<String, Object> MapWork = new HashMap<String, Object>();
		MapWork.put("workNumber", contractInfo.getId());
		List<WorkFlowFlag> wflags = this.baseService.findEntityByProperties(WorkFlowFlag.class, MapWork);
		for (WorkFlowFlag wflag : wflags) {
			if ("收款流程".equals(wflag.getWorkFlowName()) || "经销商资金收款".equals(wflag.getWorkFlowName())) {
				throw new BusinessException("与" + wflag.getWorkFlowName() + "冲突,不能回退!");
			}
		}
		
		//合同变更，前需判断是否有资金收款
		for (int i = 0; i < ccharge.size(); i++) {
			ContractFundFundCharge cc = ccharge.get(i);
			// 如果是红冲金额,则处理资金计划信息,有其他收款则走红冲 PayFund9--资金类型为红冲
			if ("PayFund9".equalsIgnoreCase(cc.getSettleMethod().getCode())) {

				// 3.将资金计划作废
				ContractFundFundPlan cplan = cc.getFundFundChargePlan();
				cplan.setInvalid("1");
				cplan.setPaymentId(null);
				this.tableService.updateEntity(cplan);

			} else {
				throw new BusinessException("已经资金收款,不能做合同变更回退,如需合同变更,请走资金收款做红冲!");
			}
		}
		
		//没有实收的资金计划删除
		List<ContractFundFundPlan> fundplan = this.tableService.findEntityByProperties(ContractFundFundPlan.class,propertiesMapc);
		for (int j = fundplan.size() - 1; j >= 0; j--) {
			ContractFundFundPlan fplan = fundplan.get(j);
			for (int i = 0; i < ccharge.size(); i++) {
				if (fplan.getId().equalsIgnoreCase(ccharge.get(i).getFundFundChargePlan().getId())) {
					fundplan.remove(fplan);
				}
			}
		}
		this.tableService.removeAllEntites(fundplan);
		//flush删除的资金计划
		this.baseService.updateFlush();
		
		//还原以前的资金计划
		String json_contract_fund_charge_str = variablesMap.get("json_fund_fund_charge_str_old");
		this.baseService.updateOneToManyCollections(contractInfo, "fundFundChargePlans", ContractFundFundPlan.class, "contractId", json_contract_fund_charge_str,dictDataClassMapping);

		System.out.println("################结束EditAction的退回动作");
		//throw new BusinessException("与冲突,不能回退!");
	}
}
