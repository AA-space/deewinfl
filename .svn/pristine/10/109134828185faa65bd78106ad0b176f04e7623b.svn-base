package com.business.action.leasing.fundPayment;

import java.math.BigDecimal;
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
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.invoice.ContractInvoiceType;
import com.business.entity.contract.reckon.fund.ContractFundRentInCome;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoAccount;
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
@WorkflowAction(name = "fundPaymentStartAction", description = "流程开始动作", workflowName = "付款流程")
@Component(value = "fundPaymentStartAction")
public class FundPaymentStartAction implements JbpmBaseAction {
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
		
		String  contractid=variablesMap.get("contract_id");
		
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
		
		//获取经销商的主账号信息
		ContractInfo cc=this.tableService.findEntityByID(ContractInfo.class, contractid);
		Map<String,Object> listmap=new HashMap<String,Object>();
		listmap.put("custId", cc.getCustDealer());
		listmap.put("isMain","0");
		List<CustInfoAccount> listacc=this.tableService.findEntityByProperties(CustInfoAccount.class, listmap);
		if(listacc.size()>0){
			variablesMap.put("dealer_bankName", listacc.get(0).getBankName());
			variablesMap.put("dealer_account", listacc.get(0).getAccount());
			variablesMap.put("dealer_accNumber", listacc.get(0).getAccNumber());
		}
		
		String  cust_id=variablesMap.get("cust_id");
		CustInfo  cust;
		ContractInfo contractinfo;
		contractinfo=(ContractInfo)this.tableService.findEntityByID(ContractInfo.class, contractid);
		cust=(CustInfo)this.tableService.findEntityByID(CustInfo.class, cust_id);
		DictionaryData dicdpayType;
		String paytype="pay_type_out";
		String HQL="";
		HQL=" from DictionaryData AS DD where DD.belongDictionary.code=? ";
		List<DictionaryData> listpayType=new ArrayList<DictionaryData>();
		//查出资金状态
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
			 //加入合同基本信息
		     variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractinfo, fieldClassMap, "contract_info"));
			//计划
		   /* HQL=" from ContractFundFundPlan as fc where fc.contractId.contractId=? and fc.payType.code=? and fc.invalid=?";
		    List<ContractFundFundPlan> fundPlan=new ArrayList<ContractFundFundPlan>();
		    fundPlan=this.tableService.findResultsByHSQL(HQL,contractinfo.getContractId() ,paytype,"0");
		    List<ContractFundFundPlan> fundPlanR=new ArrayList<ContractFundFundPlan>();
		    
		    String sqls =" from ContractFundRentInCome as f where f.contractId.contractId=? and f.balanceMode.code=?";
		    List<ContractFundRentInCome> contractFundRentInCome= this.tableService.findResultsByHSQL(sqls,contractinfo.getContractId(),"PayFund7");
		    BigDecimal yCautionMoney=BigDecimal.ZERO;
		    if (contractFundRentInCome.size() > 0)
		    {
		    	for (int i=0 ;i<contractFundRentInCome.size(); i++)
		    	{
		    		yCautionMoney = yCautionMoney.add(contractFundRentInCome.get(i).getRent());
		    	}
		    }
		    int i=0;
		    for(ContractFundFundPlan fplan:fundPlan){
		    	fplan.receiverAllMoney(mapPayType);
		    	System.out.println("getCode()"+fundPlan.get(i).getFeeType().getCode());
		    	if ( fundPlan.get(i).getFeeType().getCode().equals("feetype2") )
		    	{
		    		//计划
		    		fplan.setPlanMoney(fundPlan.get(i).getPlanMoney());
//		    		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@"+fundPlan.get(i).getPlanMoney());
		    		//已收
		    		fplan.setReceiverMoney(yCautionMoney);
//		    		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@"+yCautionMoney);
		    		//未收
		    		BigDecimal wei= fundPlan.get(i).getPlanMoney().subtract(yCautionMoney).setScale(2);
//		    		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@"+wei);
		    		fplan.setPlanbalance(wei);
		    	}
		        fundPlanR.add(fplan);
		        i++;
		    }*/
		    HashMap<String,String>fieldClassMapping=new HashMap<String,String>();
		    fieldClassMapping.put("ContractInfo", "id");
		    fieldClassMapping.put("DictionaryData", "code");
		    
		   /*if(fundPlanR.size()>0){  
			   String json_paychargeplan_str= this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(fundPlanR, fieldClassMapping, "");
			   json_paychargeplan_str = json_paychargeplan_str.trim();
			   variablesMap.put("json_paychargeplan_str",json_paychargeplan_str);
			   System.out.println("要看的json:"+variablesMap.get("json_paychargeplan_str"));
		   }*/
		   
		   Map<String,String>  queryMainObjectMap =new HashMap<String,String>();
			queryMainObjectMap.put("contract_id",contractid);
			String json_paychargeplan_str = this.tableService.getJsonArrayData("eleasing/workflow/fund/fund_payment_plan_info.xml", queryMainObjectMap).toString();
			System.out.println("json_paychargeplan_str:"+json_paychargeplan_str);
			if ( json_paychargeplan_str.length() > 0 && null != json_paychargeplan_str)
			{
				variablesMap.put("json_paychargeplan_str",json_paychargeplan_str);
			}
		   //实付表
		   List<ContractFundFundCharge>chargeList=new ArrayList<ContractFundFundCharge>();
		   HQL=" from DictionaryData AS DD where DD.code=? ";
		   dicdpayType=(DictionaryData)this.tableService.findResultsByHSQL(HQL,paytype).get(0);
		   HQL=" from ContractFundFundCharge as fc where fc.contractId.contractId=? and fc.payType.code=?";
		   chargeList=this.tableService.findResultsByHSQL(HQL, contractinfo.getContractId(),paytype);
		    fieldClassMapping.clear(); 
		    fieldClassMapping.put("ContractInfo", "contractId");
		    fieldClassMapping.put("DictionaryData", "code");
		    fieldClassMapping.put("ContractFundFundPlan", "paymentId");
		    fieldClassMapping.put("FundEbankData", "ebdataId");
		    fieldClassMapping.put("User", "realname");
		    if(chargeList.size()>0){
		    	variablesMap.put("json_contract_fund_payment_history_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(chargeList, fieldClassMapping, ""));
		       System.out.println(variablesMap.get("json_contract_fund_payment_history_str"));
		    }
		    //发票类型
			HQL="from ContractInvoiceType as ct where ct.contractId.contractId=?";
			List<ContractInvoiceType> cinvoicetype=new ArrayList<ContractInvoiceType>();
			cinvoicetype=this.tableService.findResultsByHSQL(HQL, contractinfo.getContractId());
			if(cinvoicetype.size()>0){
				 variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(cinvoicetype.get(0), fieldClassMap, "contract_invoice_type"));
			}
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
