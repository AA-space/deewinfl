package com.business.action.leasing.contract.approval;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.doc.ContractDocSendInfo;
import com.business.service.TableService;
import com.google.common.collect.Lists;
import com.google.inject.internal.Maps;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;

/**
 * 
 * @author 孙传良
 * @date 2013-4-18下午04:53:39
 * @info 配置在流程步骤第一步的action 如果合同号设置为只读 则不需要配置该action 在这个步骤中如果点击保存则触发校验合同号唯一, 如果点击下一步则把该合同的合同信息写入合同表中并标记该合同正在合同审批流程中.
 *       如果该步骤发生删除操作,则删除租金测算表中的临时数据,并删除合同表中的记录
 * @Copyright Tenwa
 */
@WorkflowAction(name = "contractApprovalEditStatusFiveAction", description = "合同信息登记动作", workflowName = "合同审批流程")
@Component(value = "contractApprovalEditStatusFiveAction")
public class ContractApprovalEditStatusFiveAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		User user = null;
		try {
			user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
		}

		List<ContractDocSendInfo> list = Lists.newArrayList();
		
		String json_contract_doc_send_info_str = variablesMap.get("json_contract_doc_send_info_str");
		JSONArray jsonArray = new JSONArray(json_contract_doc_send_info_str);
		ContractDocSendInfo si = null;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = (JSONObject) jsonArray.opt(i);
			si = new ContractDocSendInfo();
			si.setContractDate(jsonObject.optString("contractdate"));
			si.setContractA(jsonObject.optString("contracta"));
			si.setContractB(jsonObject.optString("contractb"));
			si.setMaincount(jsonObject.optString("maincount"));
			si.setGcount(jsonObject.optString("gcount"));
			si.setSdy(jsonObject.optString("sdy"));
			
//			ContractInfo ci = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, jsonObject.optString("contractid"));
			//插入合同号
			ContractInfo ci = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class,variablesMap.get("contract_info.id"));
			si.setContractID(ci);
			
			si.setContractPerson(jsonObject.optString("contractperson"));
			
			
			//si.setDocName(dict);
			si.setDocName(jsonObject.optString("docname"));
			si.setEquipInfo(jsonObject.optString("equipinfo"));
			si.setSendNo(jsonObject.optString("sendno"));
			si.setSendPart(jsonObject.optInt("sendpart"));
			si.setDocPart(jsonObject.optInt("docpart"));
//			if(jsonObject.optString("id") != null){
//				si.setModificator(user);
//				si.setModifyDate(DateUtil.getSystemDate());
//			}
			si.setCreateDate(DateUtil.getSystemDate());
			si.setCreator(user);
			list.add(si);
		}
		this.tableService.saveAllEntities(list);
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		//如果第一次进行合同登记。则添加，如果已经有信息则不赋值
		if(variablesMap.get("json_contract_doc_send_info_str") == null){
			String contract_id= variablesMap.get("contract_info.id");
			String equipAmt =  variablesMap.get("framework_condition.equipamt");
			
			Map<String,String> properMap = Maps.newHashMap();
			properMap.put("contract_id", contract_id);
			properMap.put("equipAmt", equipAmt);
			String json_ontract_doc_send_info = this.tableService.getJsonArrayData("\\eleasing\\workflow\\contract\\doc_send_info.xml", properMap).toString();
			variablesMap.put("json_contract_doc_send_info_str", json_ontract_doc_send_info);
		}
	}

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

}
