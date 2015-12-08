package com.business.action.leasing.rentPenaltyAdjust;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.cust.CustInfo;
import com.business.service.TableService;
import com.business.service.asset.AssetServer;
import com.business.util.WorkflowUtil;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;
import com.kernal.utils.StringUtil;
/**
 * 
 * @author 陈兴<br>
 * 修改时间：2013年8月13日 星期二<br>
 * 向网银在进行流程信息表 增加记录  并且 流程增加状态
 *
 */
@WorkflowAction(name = "rentPenaltyAdjustStartAction", description = "流程开始动作", workflowName = "罚息减免流程")
@Component(value = "rentPenaltyAdjustStartAction")
public class RentPenaltyAdjustStartAction implements JbpmBaseAction {
	@Resource(name = "assetServer")
	private AssetServer assetServer;
	
	@Resource(name = "tableService")
	private TableService tableService;

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//删除流程冲突 
		 WorkflowUtil.deleteWorkFlowConflict(this.tableService, variablesMap); 
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}
        
	@Override
	@SuppressWarnings("unchecked")
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		
		
		//合同基本信息
		//网银信息
		//租金计划
		//历史回笼信息
		
		String HQL="";     
		String contract_id = variablesMap.get("contract_id");
		
		//流程冲突检查 
		  String checkWorkFlag=""; 
		  String workFlowName = jbpmWorkflowHistoryInfo.getWorkflowName(); 
		  String flowunid=jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+""; 
		  checkWorkFlag=WorkflowUtil.checkWorkFlowConflict(this.tableService, workFlowName, flowunid, contract_id); 
		  variablesMap.put("workFlowFlag", checkWorkFlag); 

		String  cust_id=variablesMap.get("cust_id");
		BigDecimal rate=new BigDecimal("0.00");
		CustInfo cust;
		
		//查出资金状态
		HQL=" from DictionaryData AS DD where DD.belongDictionary.code=? ";
		List<DictionaryData> listpayType=new ArrayList<DictionaryData>();
		listpayType=this.assetServer.findResultsByHSQL(HQL, "PLANMANYSTATUS");
		HashMap<String,DictionaryData> mapPayType=new HashMap<String,DictionaryData>();
		for(DictionaryData dd:listpayType){
			mapPayType.put(dd.getCode(), dd);
		}     
		
		ContractInfo contractInfo = (ContractInfo) this.assetServer.findEntityByID(ContractInfo.class, contract_id);
		cust=(CustInfo)this.assetServer.findEntityByID(CustInfo.class, cust_id);
		
		//配置转为json时类的对应关系
		HashMap<String,String> fieldClassMap=new HashMap<String,String>();
		fieldClassMap.put("DictionaryData", "name");
		fieldClassMap.put("User", "id");
		fieldClassMap.put("ProjInfo", "projId");
		fieldClassMap.put("FundEbankData", "ebdataId");
		//插入租金计划表
		HQL="from ContractFundRentPlan as cp where cp.contractId.contractId=? order by  cp.rentList";
		List<ContractFundRentPlan> crentlist=new ArrayList<ContractFundRentPlan>();
		List<ContractFundRentPlan> lastrentlist=new ArrayList<ContractFundRentPlan>();
		crentlist=this.assetServer.findResultsByHSQL(HQL, contractInfo.getContractId());
		//罚息利率
		
		//System.out.println(contractInfo.getContractCondition().getPenaRate());
		try{
			rate = new BigDecimal(StringUtil.nullToString(contractInfo.getContractCondition().getPenaRate(), "0.00"));
		}catch( Exception e){
			
		}
		//免罚息天数 
		int freeDefaInterDay=0;
		try{
		freeDefaInterDay=Integer.parseInt(StringUtil.empty2Other(contractInfo.getContractCondition().getFreeDefaInterDay(), "0"));
		}catch( Exception e){
		}
		//当前时间
		String cur_date=DateUtil.getSystemDate();
		if(crentlist.size()>0){
			for(ContractFundRentPlan oneRentPlan:crentlist){
				oneRentPlan.initContractFundRentPlan(mapPayType,cur_date,rate,freeDefaInterDay);
				String calcDate=cur_date;
				HashMap<String,String> penalty=assetServer.calculatePenalty(oneRentPlan,calcDate);
				oneRentPlan.setPenalty(new BigDecimal(penalty.get("planpenalty")));
				oneRentPlan.setPenaltyOverage(new BigDecimal(penalty.get("penalty")));
				lastrentlist.add(oneRentPlan);
			}
			variablesMap.put("fund_rent_plans", this.assetServer.getCollectionEntitiesPropertiesToJsonArrayString(lastrentlist, fieldClassMap, ""));
	    }
		
		//插入租金实收表
		HQL="from ContractFundRentInCome as cp where cp.contractId.contractId=? order by  cp.planList";
		List<ContractFundRentPlan> crentincomelist=new ArrayList<ContractFundRentPlan>();
		crentincomelist=this.assetServer.findResultsByHSQL(HQL,contractInfo.getContractId());
		if(crentincomelist.size()>0){
		   variablesMap.put("fund_income_history", this.assetServer.getCollectionEntitiesPropertiesToJsonArrayString(crentincomelist,fieldClassMap, ""));
		}
		//加入合同信息
		variablesMap.putAll(this.assetServer.getEntityPropertiesToStringMap(contractInfo, null, "contract_info"));
		//加入客户信息
		variablesMap.put("contract_info.custname",cust.getCustName());
		variablesMap.put("contract_info.custnumber",cust.getCustNumber()); 
		variablesMap.put("contract_info.projid", contractInfo.getProjId().getProjId());
		
	}

	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
