package com.business.action.leasing.contract.onhire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.daoImpl.AbstractBaseDaoImpl;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.invoice.ContractInvoiceType;
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
@WorkflowAction(name = "contractOnHireStartAction", description = "流程开始动作", workflowName = "合同起租流程")
@Component(value = "contractOnHireStartAction")
public class ContractOnHireStartAction implements JbpmBaseAction {
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
		//合同基本信息
		//商务条件
		//资金收付计划
		//已投放明细
		//设备验收信息
		//租金发票信息
		String  contractid=variablesMap.get("contract_id");
		String contract_id = contractid;
		
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
		
		String  cust_id=variablesMap.get("cust_id");
		ContractInfo contractinfo = (ContractInfo)this.tableService.findEntityByID(ContractInfo.class, contractid);
		CustInfo cust = (CustInfo)this.tableService.findEntityByID(CustInfo.class, cust_id);
		DictionaryData dicdpayType;
		String paytype = "pay_type_out";
		String HQL = " from DictionaryData AS DD where DD.belongDictionary.code=? ";
		List<DictionaryData> listpayType=new ArrayList<DictionaryData>();
		//查出资金状态
		listpayType=this.tableService.findResultsByHSQL(HQL, "PLANMANYSTATUS");
		HashMap<String,DictionaryData> mapPayType=new HashMap<String,DictionaryData>();
		for(DictionaryData dd:listpayType){
			mapPayType.put(dd.getCode(), dd);
		}
		Map<String, String> queryMainObjectMap = new HashMap<String, String>();
		queryMainObjectMap.put("contract_id", contractid);
		HashMap<String,String> fieldClassMap=new HashMap<String,String>();
		fieldClassMap.put("DictionaryData", "code");
		fieldClassMap.put("User", "id");
		fieldClassMap.put("ProjInfo", "projId");
		fieldClassMap.put("CustInfo", "id");
		if(contractinfo!=null){
			 // 加入客户信息
			 variablesMap.put("contract_info.custname",cust.getCustName());
			 variablesMap.put("contract_info.custnumber",cust.getCustNumber());
			 variablesMap.put("business_type", contractinfo.getBusinessType().getCode());
			 // 加入合同基本信息
		     variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractinfo, fieldClassMap, "contract_info"));
		     variablesMap.put("contract_info.projid",contractinfo.getProjId().getProjId());		     
		     // 租赁物明细
		     if (!contractinfo.getContractEquips().isEmpty()) {
					variablesMap.put("json_proj_equip_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_equip.xml", queryMainObjectMap).toString());
		     }       		   
		     HashMap<String,String>fieldClassMapping=new HashMap<String,String>();
		     fieldClassMapping.put("ContractInfo", "contractId");
		     fieldClassMapping.put("DictionaryData", "code");
		     // 资金计划
	         if (!contractinfo.getFundFundChargePlans().isEmpty()) {//
				  variablesMap.put("json_fund_fund_charge_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/fund_fund_charge_plan.xml", queryMainObjectMap).toString());
	         }
		     // 实收表
		     List<ContractFundFundCharge>chargeList=new ArrayList<ContractFundFundCharge>();
		     HQL=" from DictionaryData AS DD where DD.code=? ";
		     dicdpayType=(DictionaryData)this.tableService.findResultsByHSQL(HQL,paytype).get(0);
		     HQL=" from ContractFundFundCharge as fc where fc.contractId.contractId=? and fc.payType.code=? and fc.feeType.code=?";
		     chargeList=this.tableService.findResultsByHSQL(HQL, contractinfo.getContractId(),paytype,"feetype10");
		     fieldClassMapping.clear(); 
		     fieldClassMapping.put("ContractInfo", "contractId");
		     fieldClassMapping.put("DictionaryData", "code");
		     fieldClassMapping.put("FundFundChargePlan", "paymentId");
		     fieldClassMapping.put("FundEbankData", "ebdataId");
		     fieldClassMapping.put("User", "realname");
		     if(chargeList.size()>0){
		    	 variablesMap.put("json_already_throw_in_list_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(chargeList, fieldClassMapping, ""));
		     }
		    //设备验收
		    //variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractinfo.getContractEquipAcceptance(), fieldClassMap, "equip_acceptance"));
		    //发票类型
			 HQL="from ContractInvoiceType as ct where ct.contractId.contractId=?";
			 List<ContractInvoiceType> cinvoicetype=new ArrayList<ContractInvoiceType>();
			 cinvoicetype=this.tableService.findResultsByHSQL(HQL, contractinfo.getContractId());
			 System.out.println(cinvoicetype.size());
			 if(cinvoicetype.size()>0){
			 	  variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(cinvoicetype.get(0), fieldClassMap, "contract_invoice_type"));
			 }
			 //为了租金测算的通用性此处的名字不用contract_codition 而用framework_condition
			 if(contractinfo.getContractCondition() != null){
				 variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractinfo.getContractCondition(),null, "framework_condition"));
			 }
			 //设置租金测算参数为合同审批
			 variablesMap.put("framework_condition.projid","");
			 variablesMap.put("framework_condition.contractid",contractinfo.getContractId());
			 variablesMap.put("framework_condition.process", "onhire_process");
			 variablesMap.put("framework_condition.custname",cust.getCustName());
			 variablesMap.put("framework_condition.custid",cust.getId());
			 variablesMap.put("framework_condition.docid",jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"");
			 variablesMap.put("framework_condition.onhireid","");
			 //因为这里是按照XML配置查询 所以在合同审批发起的时候数据是从项目表来的 所以这里的xml配置的是项目的XML
			 if (!contractinfo.getContractFundRentPlanBefores().isEmpty()) {//租金计划
				 variablesMap.put("json_fund_rent_plan_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(contractinfo.getContractFundRentPlanBefores(), fieldClassMapping, ""));
			 }
			 if (!contractinfo.getContractCashDetails().isEmpty()) {//合同现金流
				 variablesMap.put("json_fund_cash_flow_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(contractinfo.getContractCashDetails(), fieldClassMapping, ""));
			 }
			//附件上传用到 put 客户类型
		    variablesMap.put("cust_info.custclass", cust.getCustClass().getName());//动态显示
		    //带出项目立项流程上传的附件
			String processDefinitionId = "项目立项流程-1";
			this.tableService.getAttachment(variablesMap, contractinfo.getProjId().getProjId(),processDefinitionId);
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
