package com.business.action.leasing.fundPlanChange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.daoImpl.AbstractBaseDaoImpl;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.cust.CustInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.SecurityUtil;

/**
 * @author Toybaby
 * 
 *         2012-12-26下午01:17:43 email toybaby@mail2.tenwa.com.cn function:
 * 
 */
@WorkflowAction(name = "fundPlanChangeStartAction", description = "流程开始动作", workflowName = "资金计划变更流程")
@Component(value = "fundPlanChangeStartAction")
public class FundPlanChangeStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	
	 private static Log log = LogFactory.getLog(AbstractBaseDaoImpl.class);
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
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
		String contractid = variablesMap.get("contract_id");
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
		String hql = "SELECT new Map(WF.workNumber as workNumber, WF.workFlowName as workFlowName,WF.workFlowInstance AS workFlowInstance, WF.beginUser AS beginUser) FROM  WorkFlowFlag AS WF , ExclusionInfo AS EI  WHERE WF.workFlowName = EI.workFlowNameB AND EI.workFlowNameA = '"+workFlowName+"' AND WF.workNumber = '"+ contractid +"'";
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
		workFlowFlag.setWorkNumber(contractid);
		this.tableService.saveEntity(workFlowFlag);

		variablesMap.put("workFlowFlag", workFlowFlag.getId());
		/** 流程冲突第一步-结束*/
		
		
		String cust_id = variablesMap.get("cust_id");
		System.out.println(contractid+"=-=-=-="+cust_id);
		ContractInfo contractinfo = (ContractInfo)this.tableService.findEntityByID(ContractInfo.class, contractid);
		CustInfo cust = (CustInfo)this.tableService.findEntityByID(CustInfo.class, cust_id);
		String HQL="";
		//查出资金状态
		HQL=" from DictionaryData AS DD where DD.belongDictionary.code=? ";
		List<DictionaryData> listpayType=new ArrayList<DictionaryData>();
		listpayType=this.tableService.findResultsByHSQL(HQL, "PLANMANYSTATUS");
		HashMap<String,DictionaryData> mapPayType=new HashMap<String,DictionaryData>();
		for(DictionaryData dd:listpayType){
			mapPayType.put(dd.getCode(), dd);
		}
		HashMap fieldClassMap=new HashMap<String,String>();
		fieldClassMap.put("DictionaryData", "code");
		fieldClassMap.put("User", "id");
		fieldClassMap.put("ProjInfo", "projId");
		if(contractinfo!=null){
			//加入客户信息
			 variablesMap.put("contract_info.custname",cust.getCustName());
			 variablesMap.put("contract_info.custnumber",cust.getCustNumber());
			 variablesMap.put("fundPlanPaymentId", contractinfo.getContractId().toLowerCase());
			 //加入合同基本信息
		     variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractinfo, fieldClassMap, "contract_info"));
		     String rawValue_payobj = "";
		     String payobj_id = "";
		     String payobj = "";
			//付款计划
		    HQL=" from ContractFundFundPlan as cf where cf.contractId.contractId=? and cf.payType.code=? and cf.invalid=? order by cf.paymentId ";
		    List<ContractFundFundPlan> fundPlan=new ArrayList<ContractFundFundPlan>();
		    fundPlan=this.tableService.findResultsByHSQL(HQL,contractinfo.getContractId() ,"pay_type_out","0");
		    List<ContractFundFundPlan> fundPlanR=new ArrayList<ContractFundFundPlan>();
		    for(ContractFundFundPlan fplan:fundPlan){
		    	fplan.receiverAllMoney(mapPayType);
		        fundPlanR.add(fplan);
		    }
		    HashMap<String,String>fieldClassMapping=new HashMap<String,String>();
		    fieldClassMapping.put("ContractInfo", "contractId");
		    fieldClassMapping.put("DictionaryData", "code");
		    String jsonFundPlanPay = this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(fundPlanR, fieldClassMapping, "");
		    if(fundPlanR.size()>0){  
			   variablesMap.put("json_fundchargeplanpay_str",jsonFundPlanPay);
		    }
		    //收款计划
		    HQL=" from ContractFundFundPlan as cf where cf.contractId.contractId=? and cf.payType.code=? and cf.invalid=? order by cf.paymentId ";
		    fundPlan=new ArrayList<ContractFundFundPlan>();
		    fundPlan=this.tableService.findResultsByHSQL(HQL,contractinfo.getContractId() ,"pay_type_in","0");
		    fundPlanR=new ArrayList<ContractFundFundPlan>();
		    for(ContractFundFundPlan fplan:fundPlan){
		    	fplan.receiverAllMoney(mapPayType);
		        fundPlanR.add(fplan);
		    }
		    jsonFundPlanPay = this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(fundPlanR, fieldClassMapping, "");
		    JSONArray jsonArray = new JSONArray(jsonFundPlanPay);
		    List<String> jsonFundList=new ArrayList<String>();
		    for (int i = 0; i < jsonArray.length(); i++) {
		    	JSONObject jsonObject =  (JSONObject) jsonArray.get(i);
//		    		throw new BusinessException("合同号"+jsonObject.getString("contractid")+"付款对象 为空!");
		    	if ( !jsonObject.has("payobj") )
		    		  payobj= cust.getCustName();
		    	else
		    	{  
		    		payobj = jsonObject.getString("payobj");
		    	}
	    		jsonObject.put("payobj", payobj);
		    	jsonFundList.add(jsonObject.toString());
			}
		    if(fundPlanR.size()>0){  
				variablesMap.put("json_fundchargeplanreceiver_str",jsonFundList.toString());
			}
		    System.out.println("json@@@@@@@@@@@:"+jsonFundList.toString());
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
