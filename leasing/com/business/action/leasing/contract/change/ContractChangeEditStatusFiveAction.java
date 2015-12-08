package com.business.action.leasing.contract.change;

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
 * @author rovine
 * @date 2013-11-13
 * @info 合同变更，第五步保存寄送合同信息
 * @Copyright Tenwa
 */
@WorkflowAction(name = "contractChangeEditStatusFiveAction",description = "流程编辑动作", workflowName = "合同变更流程")
@Component(value = "contractChangeEditStatusFiveAction")
public class ContractChangeEditStatusFiveAction implements JbpmBaseAction {
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
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = (JSONObject) jsonArray.opt(i);
			ContractDocSendInfo si = new ContractDocSendInfo();
			
			si.setContractDate(jsonObject.optString("contractdate"));
			si.setContractA(jsonObject.optString("contracta"));
			si.setContractB(jsonObject.optString("contractb"));
			
			ContractInfo ci = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, jsonObject.optString("contractid"));
			
			si.setContractID(ci);
			si.setContractPerson(jsonObject.optString("contractperson"));
			
			
			DictionaryData dict = (DictionaryData) this.tableService.findEntityByID(DictionaryData.class, jsonObject.optString("docname"));
			//si.setDocName(dict);
			si.setDocName(jsonObject.optString("docname"));
			si.setEquipInfo(jsonObject.optString("equipinfo"));
			si.setSendNo(jsonObject.optString("sendno"));
			si.setSendPart(jsonObject.optInt("sendpart"));
			
			if(jsonObject.optString("id") != null){
				si.setModificator(user);
				si.setModifyDate(DateUtil.getSystemDate());
			}
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
