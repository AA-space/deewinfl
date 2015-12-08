package com.business.action.leasing.assets.onhirechange;

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
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjInfo;
import com.business.entity.project_nocar.credit_nocar.ProjFileInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.SecurityUtil;

/**
 * @author Jason
 * @date 2013-4-24
 * @info
 */
@WorkflowAction(name = "contractOnhireChangeStartAction", description = "流程开始动作", workflowName = "起租后合同变更")
@Component(value = "contractOnhireChangeStartAction")
public class ContractOnhireChangeStartAction implements JbpmBaseAction {
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
			String workFlowNameB = workFlowInfoMap.get("workFlowName");;
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
		CustInfo custInfo = contractInfo.getCustId();
		String cust_class = custInfo.getCustClass().getCode();
		variablesMap.put("contract_info.custname", custInfo.getCustName());
		variablesMap.put("contract_info.custnumber", custInfo.getCustNumber());
		variablesMap.put("contract_info.custid", custInfo.getId());
		variablesMap.put("contract_info.projid", contractInfo.getProjId().getProjId());
		variablesMap.put("business_type", contractInfo.getBusinessType().getCode());
		variablesMap.put("contract_condition.equipAmt", contractInfo.getContractCondition().getEquipAmt().toString());
		variablesMap.put("contract_condition.firstPaymentRatio", contractInfo.getContractCondition().getFirstPaymentRatio().toString());
		variablesMap.put("contract_condition.leaseAmt", contractInfo.getContractCondition().getLeaseAmt() == null ? "" :contractInfo.getContractCondition().getLeaseAmt().toString());
		variablesMap.put("contract_condition.leaseTerm", contractInfo.getContractCondition().getLeaseTerm().toString());
		//设置附件上传类型
		variablesMap.put("cust_info.custclass", custInfo.getCustClass().getName());
		if("CUST_INFO_COMPANY".equals(cust_class)){
			variablesMap.put("cust_info.taxRegAdd", custInfo.getCustInfoCompany().getTaxRegAdd());
			variablesMap.put("cust_info.legalRepresentative", custInfo.getCustInfoCompany().getLegalRepresentative());
			//variablesMap.put("cust_info.taxRegAdd", custInfo.getCustInfoCompany().getTaxRegAdd());企业实际控制人是谁？
			variablesMap.put("cust_info.regCapital", custInfo.getCustInfoCompany().getRegCapital());
			variablesMap.put("cust_info.ownership", custInfo.getCustInfoCompany().getOwnership()==null?"":custInfo.getCustInfoCompany().getOwnership().getName());
			variablesMap.put("cust_info.custScale", custInfo.getCustInfoCompany().getCustScale()==null?"":custInfo.getCustInfoCompany().getCustScale().getName());
		}else if("CUST_INFO_PERSON".equals(cust_class)){
			variablesMap.put("cust_info.taxRegAdd", custInfo.getCustInfoPerson().getTaxRegAdd());
			variablesMap.put("cust_info.legalRepresentative", custInfo.getCustInfoPerson().getCustId().getCustName());
			//variablesMap.put("cust_info.taxRegAdd", custInfo.getCustInfoCompany().getTaxRegAdd());企业实际控制人是谁？
			variablesMap.put("cust_info.regCapital", custInfo.getCustInfoPerson().getOwnershipTotal());
			//variablesMap.put("cust_info.ownership", custInfo.getCustInfoPerson());
			if(custInfo.getCustInfoPerson().getCustScale() != null){
				variablesMap.put("cust_info.custScale", custInfo.getCustInfoPerson().getCustScale().getName());
			}
		}
		queryMainObjectMap.put("doc_id", doc_id);
		
		if (!contractInfo.getContractEquips().isEmpty()) {// 租赁物明细
			variablesMap.put("json_contract_equip_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_equip_old.xml", queryMainObjectMap).toString());
		}
		if (!contractInfo.getContractEquips().isEmpty()) {// 租赁物明细
			variablesMap.put("json_contract_equip_container_new_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_equip.xml", queryMainObjectMap).toString());
		}
		if (!contractInfo.getContractGuaranteeMethods().isEmpty()) {// 担保单位
			variablesMap.put("json_contract_guarantee_method_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_guarantee_method_old.xml", queryMainObjectMap).toString());
		}
		
		//带出项目立项流程上传的附件
//		String processDefinitionId = "项目立项流程-1";
//		ProjInfo projInfo= contractInfo.getProjId();
//		this.tableService.getAttachment(variablesMap, projInfo.getProjId(),processDefinitionId);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.business.action.JbpmBaseAction#back(javax.servlet.http.HttpServletRequest, java.util.Map)
	 **/

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub

	}
}
