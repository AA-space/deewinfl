package com.business.action.leasing.contract.change;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;

/**
 * 
 * @author 孙传良
 * @date 2013-4-18下午04:53:39
 * @info 配置在流程步骤第一步的action 如果合同号设置为只读 则不需要配置该action 在这个步骤中如果点击保存则触发校验合同号唯一, 如果点击下一步则把该合同的合同信息写入合同表中并标记该合同正在合同审批流程中.
 *       如果该步骤发生删除操作,则删除租金测算表中的临时数据,并删除合同表中的记录
 * @Copyright Tenwa
 */
@WorkflowAction(name = "contractChangeEditToBackAction", description = "流程回退动作", workflowName = "合同变更流程")
@Component(value = "contractChangeEditToBackAction")
public class ContractChangeEditToBackAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	//@Resource(name = "contractApprovalStartAction")
	//private ContractApprovalStartAction contractApprovalStartAction;

	@SuppressWarnings("unchecked")
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}
	
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//信审提交之后车架号更新成最新的车架号
		variablesMap.put("json_proj_equip_str_for_credit", variablesMap.get("json_proj_equip_str"));
	}

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

}
