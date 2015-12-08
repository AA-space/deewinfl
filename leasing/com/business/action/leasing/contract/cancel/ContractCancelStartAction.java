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
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.cust.CustInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.SecurityUtil;

/**
 * @author Jason
 * @date 2013-4-24
 * @info
 */
@WorkflowAction(name = "contractCancelStartAction", description = "流程开始动作", workflowName = "合同撤销流程")
@Component(value = "contractCancelStartAction")
public class ContractCancelStartAction implements JbpmBaseAction {
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
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
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
		// 获得一个流水号
		String doc_id = jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid() + "";

		// 基本字段
		ContractInfo contractInfo = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, contract_id);
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractInfo, null, "contract_info"));
		CustInfo customerInfo = contractInfo.getCustId();
		variablesMap.put("contract_info.custname", customerInfo.getCustName());
		variablesMap.put("contract_info.custnumber", customerInfo.getCustNumber());
		variablesMap.put("contract_info.custid", customerInfo.getId());
		variablesMap.put("contract_info.projid", contractInfo.getProjId().getProjId());
		variablesMap.put("business_type", contractInfo.getBusinessType().getCode());
		queryMainObjectMap.put("doc_id", doc_id);

		// 步骤四(为了租金测算的通用性此处的名字不用contract_codition 而用framework_condition)
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractInfo.getContractCondition(), null, "framework_condition"));

		// 步骤五 (设备清单)
		if (!contractInfo.getContractEquips().isEmpty()) {// 租赁物明细
			variablesMap.put("json_contract_equip_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_equip.xml", queryMainObjectMap).toString());
		}

		Map<String, String> fieldClassMapping = new HashMap<String, String>();
		fieldClassMapping.put("ContractInfo", "contractId");
		fieldClassMapping.put("DictionaryData", "code");
		fieldClassMapping.put("FundFundChargePlan", "paymentId");
		fieldClassMapping.put("FundEbankData", "ebdataId");
		fieldClassMapping.put("User", "realname");
		//资金付款历史
		String HQL = " from ContractFundFundCharge as fc where fc.contractId.contractId=? and fc.payType.code=?";
		List<ContractFundFundCharge> outChargeList=this.tableService.findResultsByHSQL(HQL, contractInfo.getContractId(), "pay_type_out");
		if (outChargeList.size() > 0) {
			variablesMap.put("json_contract_fund_payment_history_str", this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(outChargeList, queryMainObjectMap, ""));
		}
		//资金收款历史
		List<ContractFundFundCharge> inChargeList = new ArrayList<ContractFundFundCharge>();
		HQL = " from ContractFundFundCharge as fc where fc.contractId.contractId=? and fc.payType.code=?";
		inChargeList = this.tableService.findResultsByHSQL(HQL, contractInfo.getContractId(), "pay_type_in");
		
		if (inChargeList.size() > 0) {
			variablesMap.put("json_contract_fund_receive_history_str", this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(inChargeList, fieldClassMapping, ""));
		}
		//附件上传用到 put 客户类型
	    variablesMap.put("cust_info.custclass", customerInfo.getCustClass().getName());//动态显示
		//带出项目立项流程上传的附件
		String processDefinitionId = "项目立项流程-1";
		this.tableService.getAttachment(variablesMap, contractInfo.getProjId().getProjId(),processDefinitionId);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.business.action.JbpmBaseAction#back(javax.servlet.http.HttpServletRequest, java.util.Map)
	 **/

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}
}
