package com.business.action.leasing.contract.brrow;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.doc.ContractDocBorrowInfo;
import com.business.entity.contract.doc.ContractDocSendInfo;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.google.inject.internal.Lists;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;

@WorkflowAction(name = "contractBrrowlEndAction", description = "流程结束动作", workflowName = "合同借阅")
@Component(value = "contractBrrowlEndAction")
public class ContractBrrowlEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Resource(name = "tableService")
	private TableService tableService;

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		/** 流程冲突第三步-结束*/
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {WorkFlowFlag w = this.baseService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
		this.tableService.removeEntity(w);}
		/** 流程冲突第三步-结束*/
		
		
		User user = null;
		try {
			user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
		}
		String json_borrow_info_str = variablesMap.get("json_borrow_info_str");
		List<ContractDocBorrowInfo> borrowInfoList = Lists.newArrayList();
		if(StringUtils.isNotEmpty(json_borrow_info_str)){
			JSONArray jsonArray = new JSONArray(json_borrow_info_str);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject =(JSONObject) jsonArray.get(i);
				ContractDocBorrowInfo contractDocBorrowInfo = new ContractDocBorrowInfo();
				ContractDocSendInfo contractDocSendInfo =this.baseService.findEntityByID(ContractDocSendInfo.class, jsonObject.optString("id"));
				contractDocBorrowInfo.setContractDoc(contractDocSendInfo);
				
				//借阅类型
				DictionaryData typeDict = this.baseService.findEntityByID(DictionaryData.class, "document_borrow_1");
				
				contractDocBorrowInfo.setType(typeDict);
				
				//借阅人
				User u = this.baseService.findEntityByID(User.class, jsonObject.optString("borrowuser"));
				
				contractDocBorrowInfo.setBorrowUser(jsonObject.optString("borrowuser"));
				
				contractDocBorrowInfo.setBorrowPart(jsonObject.optInt("docpart"));
				contractDocBorrowInfo.setDatelimit(jsonObject.optString("datelimit"));
				contractDocBorrowInfo.setMemo(jsonObject.optString("memo"));
				
				
				contractDocBorrowInfo.setBorrowDate(jsonObject.optString("borrowdate"));//二次寄送时间
				contractDocBorrowInfo.setBorrowSendNo(jsonObject.optString("borrowsendno"));
				contractDocBorrowInfo.setSeupart(jsonObject.optInt("seupart"));
				
				contractDocBorrowInfo.setCreateDate(DateUtil.getSystemDateTime());
				contractDocBorrowInfo.setCreator(user);
				contractDocBorrowInfo.setOutborrow(variablesMap.get("idname"));
				contractDocBorrowInfo.setPhone(variablesMap.get("telphone"));
				contractDocBorrowInfo.setAddress(variablesMap.get("address"));
				contractDocBorrowInfo.setCompanyname(variablesMap.get("companyname"));
				contractDocBorrowInfo.setReturnDate(variablesMap.get("regdate"));
				borrowInfoList.add(contractDocBorrowInfo);
			}
			if(!borrowInfoList.isEmpty()){
				this.baseService.saveAllEntities(borrowInfoList);
			}
			
			
		}
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//this.end(request, variablesMap, jbpmWorkflowHistoryInfo);
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
	}

}
