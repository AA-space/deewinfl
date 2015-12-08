package com.business.action.leasing.distributor.mortgagecontract;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.BaseMessage;
import com.business.entity.base.BaseMessageToUser;
import com.business.entity.dealer.DealerDocumentInfo;
import com.business.entity.dealer.DealerDocumentList;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;
/**
 * 
 * @author 徐云龙
 * @date 2013-8-10上午17:55:13
 * @info 经销商抵押合同事宜办理流程
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "distributorMortgageContractEndAction", description = "流程结束动作", workflowName = "经销商抵押合同事宜办理流程")
@Component(value = "distributorMortgageContractEndAction")
public class DistributorMortgageContractEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;

	/*
	 * public ProjApprovalEndAction(){ this.baseService =
	 * (ProjApprrovalDao)WebUtil.getApplicationContext().getBean("baseService"); }
	 */
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String cust_id=variablesMap.get("cust_info.id");
		variablesMap.put("dealer_document_info.custid", cust_id);
		Map<String,Object> propertiesMap=new HashMap<String,Object>();
		propertiesMap.put("id", null);
		Map<String,String>classFieldMapping=new HashMap<String,String>();
		classFieldMapping.put("CustInfo", "id");
		//插入抵押合同申请信息
		DealerDocumentInfo di=(DealerDocumentInfo)this.baseService.updateMainEntity(DealerDocumentInfo.class, propertiesMap, variablesMap, classFieldMapping, "dealer_document_info");
		//插入合同
		String jsonContractStr = variablesMap.get("json_mortgage_info_str");//proj_info.projEquips
		this.baseService.updateOneToManyCollections(di, "dealerDocumentList", DealerDocumentList.class, "documentInfo", jsonContractStr,null);
		
		//发站内信
		User user = (User) SecurityUtil.getPrincipal();
		Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("code", "msgtype.1");
		BaseMessage baseMessage = new BaseMessage();
		baseMessage.setMsgTitle(variablesMap.get("cust_info.custname")+"经销商申请抵押材料审批");
		baseMessage.setMsgType((DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, queryMainObjectMap).get(0));
		baseMessage.setSendDate(DateUtil.getSystemDate());
		baseMessage.setFromUser(user);
		baseMessage.setCreateDate(DateUtil.getSystemDateTime());
		baseMessage.setCreator(user);
		baseMessage.setMsgText(variablesMap.get("cust_info.custname")+"经销商,你申请的抵押材料审批意见为:"+variablesMap.get("processedAdvise"));
		this.baseService.saveEntity(baseMessage);
		
		Map<String,Object> pMap=new HashMap<String,Object>();
		pMap.put("username", variablesMap.get("requestInitiator"));
		List<User> iniloginlist=this.baseService.findEntityByProperties(User.class, pMap);
		if(iniloginlist.size()>0){
			User inilogin=iniloginlist.get(0);
		    BaseMessageToUser baseMessageToUser = null;
			baseMessageToUser = new BaseMessageToUser();
			baseMessageToUser.setMsgID(baseMessage);
			baseMessageToUser.setReadStatus("1");
			baseMessageToUser.setReadUser(inilogin);
			baseMessageToUser.setCreateDate(DateUtil.getSystemDateTime());
			baseMessageToUser.setCreator(user);
			this.baseService.saveEntity(baseMessageToUser);
		}
	}
	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

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
