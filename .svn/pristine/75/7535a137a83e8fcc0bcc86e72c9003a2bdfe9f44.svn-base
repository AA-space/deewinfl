package com.business.action.leasing.contract.equipAcceptance;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.cust.CustInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.SecurityUtil;


@WorkflowAction(name = "equipAcceptanceStartAction", description = "设备验收流程开始", workflowName = "设备验收流程")
@Component(value = "equipAcceptanceStartAction")
public class EquipAcceptanceStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		/** 流程冲突第二步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第二步-结束 */
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//获取参数
		String contract_id = variablesMap.get("contract_id");
		/**
		 * 流程冲突共三步
		 * 1、起始位置添加第一步，如**startAction
		 * 2、删除流程实例时添加第二部 ,**startAction中delete方法
		 * 3、结束流程里添加第三步, 例**endAction中添加
		 * 注意：例如经销资金收款中，第一步插入冲突表时，需要插入多个，不需要第二步，第三步也需要删除多个
		 * 		workFlowFlag插入时已逗号分隔。
		 * 
		 * 流程冲突第一步-开始*/
		String workFlowName = jbpmWorkflowHistoryInfo.getWorkflowName(); 
		
		//查询冲突 
		String hql = "SELECT new Map(WF.workNumber as workNumber, WF.workFlowName as workFlowName,WF.workFlowInstance AS workFlowInstance, WF.beginUser AS beginUser) FROM  WorkFlowFlag AS WF , ExclusionInfo AS EI  WHERE WF.workFlowName = EI.workFlowNameB AND EI.workFlowNameA = '"+workFlowName+"' AND WF.workNumber = '"+ contract_id +"'";
		List<Map<String,String>> workFlowFlagList =  this.tableService.findResultsByHSQL(hql);
		if (workFlowFlagList.size() > 0){
			Map<String, String> workFlowInfoMap = workFlowFlagList.get(0);
			User beginUser = this.tableService.findEntityByID(User.class, workFlowInfoMap.get("beginUser"));
			String workFlowNameB = workFlowInfoMap.get("workFlowName");
			throw new BusinessException("该条流程与【"+workFlowNameB+"】流程不能同时发起,请与流程发起人:【"+beginUser.getRealname()+"】联系查看详情");
		}
		
		//将本条流程记录插入到冲突表
		WorkFlowFlag workFlowFlag = new WorkFlowFlag();
		workFlowFlag.setBeginUser(SecurityUtil.getPrincipal().getId());
		workFlowFlag.setStatus(1);
		workFlowFlag.setWorkFlowInstance(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"");
		workFlowFlag.setWorkFlowName(workFlowName);
		workFlowFlag.setWorkNumber(contract_id);
		this.tableService.saveEntity(workFlowFlag);

		variablesMap.put("workFlowFlag", workFlowFlag.getId());
		/** 流程冲突第一步-结束*/
		
		Map<String, String> queryMainObjectMap = new HashMap<String, String>();
		queryMainObjectMap.put("contract_id", contract_id);
		//基本字段
		ContractInfo contractInfo= (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, contract_id);
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractInfo,null, "contract_info"));
		CustInfo customerInfo=contractInfo.getCustId();
		variablesMap.put("contract_info.custname", customerInfo.getCustName());
		variablesMap.put("contract_info.custnumber", customerInfo.getCustNumber());
		variablesMap.put("contract_info.custid", customerInfo.getId());
		variablesMap.put("contract_info.projid", contractInfo.getContractId());
		variablesMap.put("business_type", contractInfo.getBusinessType().getCode());
		//商务条件
		if(contractInfo.getContractCondition() != null){
			 variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractInfo.getContractCondition(),null, "framework_condition"));
		 }
		//设置租金测算参数为设备验收等同于之前的起租
		 variablesMap.put("framework_condition.projid","");
		 variablesMap.put("framework_condition.contractid",contractInfo.getContractId());
		 variablesMap.put("framework_condition.process", "equip_acceptance_process");
		 variablesMap.put("framework_condition.custname",customerInfo.getCustName());
		 variablesMap.put("framework_condition.custid",customerInfo.getId());
		 variablesMap.put("framework_condition.docid",jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"");
		 variablesMap.put("framework_condition.onhireid","");
		 
		if (!contractInfo.getContractEquips().isEmpty()) {// 租赁物明细
			variablesMap.put("json_proj_equip_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_equip.xml", queryMainObjectMap).toString());
			//将设备清单的流程状态设置为流程中
			Iterator<ContractEquip> it = contractInfo.getContractEquips().iterator();
			while (it.hasNext()) {
				ContractEquip contractEquip = (ContractEquip) it.next();
				contractEquip.setWorkFlag(AppStaticUtil.WORKFLOW_ON);
			}
		}
		if (!contractInfo.getContractFundRentPlanBefores().isEmpty()) {//租金计划
			variablesMap.put("json_fund_rent_plan_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(contractInfo.getContractFundRentPlanBefores(), null, ""));
		}
		if (!contractInfo.getContractCashDetails().isEmpty()) {//合同现金流
			variablesMap.put("json_fund_cash_flow_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(contractInfo.getContractCashDetails(), null, ""));
		}
        if (!contractInfo.getFundFundChargePlans().isEmpty()) {// 资金计划
			  variablesMap.put("json_fund_fund_charge_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/fund_fund_charge_plan.xml", queryMainObjectMap).toString());
        }
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
