package com.business.action.leasing.assets;

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
import com.business.entity.User;
import com.business.entity.asset.FundEbankData;
import com.business.entity.asset.FundEbankProcess;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.cust.CustInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.business.service.asset.AssetServer;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;
/**
 * 
 * @author 陈兴<br>
 * 修改时间：2013年8月13日 星期二<br>
 * 向网银在进行流程信息表 增加记录  并且 流程增加状态
 *
 */
@WorkflowAction(name = "fundIncomeStartAction", description = "流程开始动作", workflowName = "租金回笼流程")
@Component(value = "fundIncomeStartAction")
public class FundIncomeStartAction implements JbpmBaseAction {
	@Resource(name = "assetServer")
	private AssetServer assetServer;
	
	@Resource(name = "tableService")
	private TableService tableService;
	
	

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		this.assetServer.removeEntityById(FundEbankProcess.class, variablesMap.get("fund_ebank_process"));
		/** 流程冲突第二步-结束*/
		WorkFlowFlag w = this.assetServer.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
		this.assetServer.removeEntity(w);
		/** 流程冲突第二步-结束*/
		String  ebankID = variablesMap.get("ebank_id");
		if ( ebankID != null) //红冲不选网银情况
		{
			FundEbankData ebankData = this.assetServer.findEntityByID(FundEbankData.class,ebankID);
			ebankData.setInuseflag("0");
		}
		
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
		String fq ="select * from contract_fund_rent_plan where 1=1 and card_export_status not in ('2','0') and contract_id= '"+contract_id+"'";
		 List<Map<String, Object>> listmap = this.tableService.queryListBySql(fq);
		 if(listmap.size() > 0 ){
			 throw new BusinessException("该合同有期次正在卡扣,请等卡扣结束后在回笼!");
		 }
		
		//查询冲突 
		String hql = "SELECT new Map(WF.workNumber as workNumber, WF.workFlowName as workFlowName,WF.workFlowInstance AS workFlowInstance, WF.beginUser AS beginUser) FROM  WorkFlowFlag AS WF , ExclusionInfo AS EI  WHERE WF.workFlowName = EI.workFlowNameB AND EI.workFlowNameA = '"+workFlowName+"' AND WF.workNumber = '"+ contract_id +"'";
		List<Map<String,String>> workFlowFlagList =  this.assetServer.findResultsByHSQL(hql);
		if (workFlowFlagList.size() > 0){
			Map<String, String> workFlowInfoMap = workFlowFlagList.get(0);
			User beginUser = this.assetServer.findEntityByID(User.class, workFlowInfoMap.get("beginUser"));
			String workFlowNameB = workFlowInfoMap.get("workFlowName");;
			throw new BusinessException("该条流程与【"+workFlowNameB+"】流程不能同时发起,请与流程发起人:【"+beginUser.getRealname()+"】联系查看详情");
		}
		
		//将本条流程记录插入到冲突表
		WorkFlowFlag workFlowFlag = new WorkFlowFlag();
		workFlowFlag.setBeginUser(SecurityUtil.getPrincipal().getId());
		workFlowFlag.setStatus(1);
		workFlowFlag.setWorkFlowInstance(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"");
		workFlowFlag.setWorkFlowName(workFlowName);
		workFlowFlag.setWorkNumber(contract_id);
		this.assetServer.saveEntity(workFlowFlag);

		variablesMap.put("workFlowFlag", workFlowFlag.getId());
		/** 流程冲突第一步-结束*/
		
		
		String ebank_id = variablesMap.get("ebank_id");
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
		//网银信息
		HashMap<String,Object>propertiesMap=new HashMap<String,Object>();
		propertiesMap.put("id", ebank_id);
		List<FundEbankData> list_ebank=new ArrayList<FundEbankData>();
		ContractInfo contractInfo = (ContractInfo) this.assetServer.findEntityByID(ContractInfo.class, contract_id);
		cust=(CustInfo)this.assetServer.findEntityByID(CustInfo.class, cust_id);
		list_ebank=this.assetServer.findEntityByProperties(FundEbankData.class, propertiesMap);
		FundEbankData fundBank = null;
		if(list_ebank.size()>0){
			fundBank=list_ebank.get(0);
			fundBank.initFundEbank();
			fundBank.setInuseflag("inuserflag");//加入在使用这笔网银的标识
			fundBank.setModifyDate(DateUtil.getSystemDateTime());
			fundBank.setModificator(SecurityUtil.getPrincipal());
			variablesMap.put("fund_ebank_data.id", fundBank.getId());
			variablesMap.putAll(this.assetServer.getEntityPropertiesToStringMap(fundBank, null, "fund_ebank_data"));
		}
		//配置转为json时类的对应关系
		HashMap<String,String> fieldClassMap=new HashMap<String,String>();
		fieldClassMap.put("DictionaryData", "name");
		fieldClassMap.put("User", "id");
		fieldClassMap.put("ProjInfo", "projId");
		fieldClassMap.put("FundEbankData", "ebdataId");
		//插入租金计划表
		Map<String,String>  queryMainObjectMap =new HashMap<String,String>();
		queryMainObjectMap.put("contract_id",contract_id);
		//网银到账日期
		queryMainObjectMap.put("calcdate",fundBank==null?DateUtil.getSystemDate():fundBank.getFactDate());
		String fund_rent_plans = this.tableService.getJsonArrayData("eleasing/workflow/fund/fund_income/fundIncomePlan.xml", queryMainObjectMap).toString();
		System.out.println("fund_rent_plans:"+fund_rent_plans);
		if ( fund_rent_plans.length() > 0 && null != fund_rent_plans)
		{
			variablesMap.put("fund_rent_plans",fund_rent_plans);
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
		
		//插入网银中间表
		FundEbankProcess fundEbankProcess = new FundEbankProcess();
		fundEbankProcess.setContractId(contract_id);
		fundEbankProcess.setDealerID(contractInfo.getCustDealer().getId());
		fundEbankProcess.setEbdataId(fundBank);
		fundEbankProcess.setFlowUnid(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"");
		fundEbankProcess.setProcessName(jbpmWorkflowHistoryInfo.getWorkflowDisplayName());
		fundEbankProcess.setStartDate(DateUtil.getSystemDateTime());
		fundEbankProcess.setWork_flag("0");
		fundEbankProcess.setProcessAmount(BigDecimal.ZERO);
		this.assetServer.saveEntity(fundEbankProcess);
		
		variablesMap.put("fund_ebank_process", fundEbankProcess.getId());


	}

	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
