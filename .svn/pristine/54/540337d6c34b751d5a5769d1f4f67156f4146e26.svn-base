package com.business.action.leasing.fundPayEquipment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.daoImpl.AbstractBaseDaoImpl;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractPremiseCondition;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.invoice.ContractInvoiceType;
import com.business.entity.cust.CustInfo;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;

/**
 * @author Toybaby
 * 
 *         2012-12-26下午01:17:43 email toybaby@mail2.tenwa.com.cn function:
 * 
 */
@WorkflowAction(name = "fundPayEquipmentEditAction", description = "流程编辑动作", workflowName = "实际投放流程")
@Component(value = "fundPayEquipmentEditAction")
public class FundPayEquipmentEditAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;

	private static Log log = LogFactory.getLog(AbstractBaseDaoImpl.class);

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String  contractid=variablesMap.get("contract_id");
		ContractInfo contractinfo=(ContractInfo)this.tableService.findEntityByID(ContractInfo.class, contractid);
		
		//设置资金计划为流程中
		Set<ContractFundFundPlan> fundFundChargePlans = contractinfo.getFundFundChargePlans();
		Iterator<ContractFundFundPlan> it = fundFundChargePlans.iterator();
		while (it.hasNext()) {
			ContractFundFundPlan fundFundChargePlan = (ContractFundFundPlan) it.next();
			fundFundChargePlan.setWorkFlag(AppStaticUtil.WORKFLOW_ON);
		}
		
		return null;
	}

	@Override
	public void end(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		System.out.println(variablesMap);
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
	    //加载合同基本信息
		//加载付款条件
		//加载投放计划
		//资金收款名细
		//已投入名细
		//本次投入计划
		//租金发票类型
		String  contractid=variablesMap.get("contract_id");
		String  cust_id=variablesMap.get("cust_id");
		CustInfo  cust;
		ContractInfo contractinfo;
		DictionaryData dicdpayType;
	    String paytype="pay_type_out";
	    String HQL="";
		contractinfo=(ContractInfo)this.tableService.findEntityByID(ContractInfo.class, contractid);
		
		//设置资金计划为流程中
		Set<ContractFundFundPlan> fundFundChargePlans = contractinfo.getFundFundChargePlans();
		Iterator<ContractFundFundPlan> it = fundFundChargePlans.iterator();
		while (it.hasNext()) {
			ContractFundFundPlan fundFundChargePlan = (ContractFundFundPlan) it.next();
			fundFundChargePlan.setWorkFlag(AppStaticUtil.WORKFLOW_ON);
		}
		
		cust=(CustInfo)this.tableService.findEntityByID(CustInfo.class, cust_id);
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
			 //查出资金状态
			 HQL=" from DictionaryData AS DD where DD.belongDictionary.code=? ";
			 List<DictionaryData> listpayType=new ArrayList<DictionaryData>();
			 listpayType=this.tableService.findResultsByHSQL(HQL, "PLANMANYSTATUS");
			 HashMap<String,DictionaryData> mapPayType=new HashMap<String,DictionaryData>();
			 for(DictionaryData dd:listpayType){
				  mapPayType.put(dd.getCode(), dd);
			  }
			  //投放前提条件
			  HQL="from ContractPremiseCondition as cc where cc.contractId=?";
			  List<ContractPremiseCondition> contractPCondtion=new ArrayList<ContractPremiseCondition>();
			  contractPCondtion=this.tableService.findResultsByHSQL(HQL, contractinfo);
			  if( contractPCondtion.size()>0){
			       variablesMap.put("json_contract_premise_str", this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(contractPCondtion, null, ""));
		       }
		     //投入设备款计划
			 HQL=" from ContractFundFundPlan as fc where fc.contractId.contractId=? and fc.payType.code=? and fc.feeType.code=? and fc.invalid=?";
			 List<ContractFundFundPlan> fundPlan=new ArrayList<ContractFundFundPlan>();
			 fundPlan=this.tableService.findResultsByHSQL(HQL, contractinfo.getContractId() ,paytype,"feetype10","0");
			 List<ContractFundFundPlan> fundPlanR=new ArrayList<ContractFundFundPlan>();
			 for(ContractFundFundPlan fplan:fundPlan){
			    fplan.receiverAllMoney(mapPayType);
			    fundPlanR.add(fplan);
			 }
			 HashMap<String,String>fieldClassMapping=new HashMap<String,String>();
			 fieldClassMapping.put("ContractInfo", "contractId");
			 fieldClassMapping.put("DictionaryData", "code");
		     if(fundPlanR.size()>0){  
			    variablesMap.put("json_leasing_delivery_plan_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(fundPlanR, fieldClassMapping, ""));
		     }
		    //资金收款明细
		    List<ContractFundFundCharge>chargeList=new ArrayList<ContractFundFundCharge>();
		    HQL=" from ContractFundFundCharge as fc where fc.contractId.contractId=? and fc.payType.code=?";
		    chargeList=this.tableService.findResultsByHSQL(HQL,  contractinfo.getContractId(),"pay_type_in");
		    fieldClassMapping.clear(); 
		    fieldClassMapping.put("ContractInfo", "contractId");
		    fieldClassMapping.put("DictionaryData", "code");
		    fieldClassMapping.put("ContractFundFundPlan", "paymentId");
		    fieldClassMapping.put("FundEbankData", "ebdataId");
		    fieldClassMapping.put("User", "realname");
		    if(chargeList.size()>0){
			   variablesMap.put("json_fundfundcharge_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(chargeList, fieldClassMapping, ""));
		    }
		    //设备款已投放
		    List<ContractFundFundCharge>chargeListEquip=new ArrayList<ContractFundFundCharge>();
		   HQL=" from ContractFundFundCharge as fc where fc.contractId.contractId=? and fc.payType.code=? and fc.feeType.code=?";
		    chargeListEquip=this.tableService.findResultsByHSQL(HQL,contractinfo.getContractId(),paytype,"feetype10");
		    if(chargeListEquip.size()>0){
				 variablesMap.put("json_contract_fund_payment_history_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(chargeListEquip, fieldClassMapping, ""));
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
	 * 
	 * @see com.business.action.JbpmBaseAction#back(javax.servlet.http.HttpServletRequest,
	 *      java.util.Map)
	 **/

	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub

	}
}
